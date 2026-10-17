# Referencia de la API HTTP :id=http-query-reference

Esta referencia describe los parámetros de LifeUp Cloud y los modelos completos de respuesta HTTP. Para instalación, autorización y conexión, comienza con [LifeUp Cloud](/guide/api_cloud). Los nuevos endpoints de registros requieren LifeUp **1.106.0+** y LifeUp Cloud **3.0.0+**; usa `/info` para identificar las versiones instaladas. Describe los contratos del código actual, no demuestra la disponibilidad en una versión concreta.

## Índice de interfaces :id=interface-index

| Recurso | Métodos y rutas | Parámetros y modelo |
| --- | --- | --- |
| Reglas comunes | Respuestas JSON, autorización, condiciones de caché, paginación | [Convenciones](#representations), [caché y autenticación](#auth-cache), [paginación](#pagination) |
| Tareas | `GET /tasks`, `GET /tasks/{categoryId}`, `GET /tasks_categories` | [Consultas](#get-tasks), [modelo de tarea](#task-fields), [categorías](#get-tasks-categories) |
| Historial de tareas | `GET /history` | [Parámetros](#get-history), [marcas de tiempo](#task-times), [informes diarios](#daily-report) |
| Objetos | `GET /items`, `GET /items/{listId}`, `GET /items_categories` | [ID de objetos, ID de categorías y modelos completos](#get-items) |
| Atributos | `GET /skills`, `GET /skill_groups` | [Atributos y grupos](#get-skills) |
| Logros | `GET /achievements`, `GET /achievements/{id}`, `GET /achievement_categories`, `GET /achievement_conditions/{id}` | [Logros y condiciones](#get-achievements) |
| Síntesis | `GET /synthesis`, `GET /synthesis/{id}`, `GET /synthesis_categories`, `GET /synthesis_categories/{id}` | [Recetas y categorías](#get-synthesis) |
| Sentimientos | `GET /feelings` | [Sentimientos paginados](#get-feelings) |
| EXP / monedas | `GET /exp_records`, `GET /coin_records` | [Parámetros y modelos de registros](#reward-journals) |
| Otros registros | `GET /pomodoro_records`, `GET /inventory_records`, `GET /step_records` | [Pomodoro](#get-pomodoro-records), [inventario](#get-inventory-records), [pasos](#get-step-records) |
| Niveles / estadísticas | `GET /level_defines`, `GET /statistics` | [Niveles](#get-level-defines), [estadísticas](#get-statistics) |
| App / saldo | `GET /info`, `GET /coin` | [Información de versión](#get-info), [resultado de monedas](#get-coin) |
| Invocar acciones | `GET` / `POST /api`, `GET` / `POST /api/contentprovider` | [Puente de invocación](#invoke-api); los métodos funcionales siguen en el [catálogo de esquemas URL](/guide/api) |
| Archivos / copias | `GET /files/{url}`, `POST /files/upload`, `GET /data/export`, `POST /data/import` | [Archivos](#files-download), [transferencia de copias](#files-backup) |
| Eventos | `GET /events`, WebSocket `/events` | [Sondeo y eventos en directo](#get-events) |
| Página inicial | `GET /` | Introducción HTML, no un recurso JSON. |

MCP utiliza una representación separada de cliente/herramienta; consulta [diferencias de MCP](#mcp-differences) y la [guía de MCP](/guide/api_mcp).

## Transporte y representación :id=representations

| Interfaz | Representación | Diferencia importante |
| --- | --- | --- |
| Consultas HTTP de Cloud | JSON envuelto en `{code, message, data}` | Las referencias siguientes describen este JSON público. |
| ContentProvider de Android | Columnas de Cursor, como `_ID` / `_GID`, que a veces contienen texto JSON | El análisis del SDK las convierte en campos HTTP como `id` / `gid` y arrays anidados. No uses las definiciones de columnas de Cursor como esquema HTTP. |
| Acciones URL Scheme | `lifeup://api/{method}` y parámetros/resultados propios del método | Los parámetros de escritura pueden usar snake_case aunque los campos HTTP de lectura usen camelCase. |
| Herramientas de listas MCP | Envoltorio propio de la herramienta y registros compactos o detallados | La paginación y los campos de salida de MCP son comportamiento adicional del cliente, no campos de respuesta HTTP. |

## Respuesta y errores :id=response-errors

El envoltorio JSON HTTP común es `HttpResponse<T>`:

| Campo | Tipo | Significado |
| --- | --- | --- |
| `code` | integer | `200` para una consulta correcta; un valor distinto de `200` indica un error. Es un campo del cuerpo, separado del estado HTTP. |
| `message` | string | Normalmente `success` si tiene éxito; una descripción del error en otro caso. |
| `data` | `T` o `null` | Valor específico del endpoint (array, objeto o cadena) en caso de éxito; `null` en caso de error. |

Ejemplo de lista vacía obtenida correctamente:

```json
{"code":200,"message":"success","data":[]}
```

Ejemplo ilustrativo de error de permisos/acceso al proveedor:

```json
{"code":10001,"message":"Cursor is null, check if LifeUp is installed and running and you have granted the permission","data":null}
```

| Señal | Cómo tratarla |
| --- | --- |
| HTTP `401` | Envía el token de Cloud configurado como valor directo de la cabecera `Authorization`. No añadas `Bearer`. |
| Cuerpo `code = 10001` | Comprueba que LifeUp esté instalado/en ejecución y que Cloud tenga permiso para leer datos de LifeUp. |
| Cuerpo `code = 10002` | La consulta ContentProvider ha fallado; revisa el mensaje de error. |
| Otro estado/código de error | Trata la consulta como fallida, no como un resultado vacío. |

Comprueba **tanto** el estado HTTP como el `code` del cuerpo. Algunos fallos de ruta siguen usando HTTP `200` con un código de error en el cuerpo. Las acciones por `/api/contentprovider` también requieren comprobar cada `data[].result.api_result`; el `code=200` del envoltorio no demuestra que todas las acciones hayan tenido éxito.

## Autorización y lecturas condicionales :id=auth-cache

Si hay un token de Cloud configurado, envía su valor exacto sin modificar en `Authorization`, sin anteponer `Bearer`. El servidor también acepta el parámetro de consulta `token`, incluso para clientes que no pueden establecer una cabecera WebSocket. Un token ausente o incorrecto produce HTTP `401` y `code=401` en el cuerpo. Se comprueban la página inicial, recursos, puente, archivos, transferencia de copias y eventos.

Las lecturas correctas de recursos JSON incluyen un `ETag` fuerte SHA-256 y `Cache-Control: private, no-cache`. Se aplica a tareas/historial, objetos/categorías, atributos/grupos, logros/condiciones, sentimientos, síntesis/categorías, registros, niveles, estadísticas, información y monedas. No se aplica al puente de invocación, transferencia de archivos o copias ni flujos/sondeo de eventos.

| Cabecera de solicitud | Comportamiento actual |
| --- | --- |
| `If-Match` | Una versión distinta falla con HTTP `412`; se evalúa antes de `If-None-Match`. |
| `If-None-Match` | Una versión coincidente devuelve HTTP `304` sin cuerpo JSON. Reutiliza la representación correcta en caché. |

Los contenedores de error no incluyen cabecera de versión del recurso. Las lecturas condicionales se aplican por solicitud, sin instantánea ni transacción entre páginas o rutas.

Las solicitudes de navegador entre orígenes pueden usar `If-None-Match`. La configuración CORS actual no permite `If-Match` en la comprobación previa; no dependas de solicitudes entre orígenes con `If-Match` sin cambiar la implementación. Los clientes nativos no están sujetos al CORS del navegador.

## Convenciones comunes de datos :id=data-conventions

| Convención | Regla |
| --- | --- |
| Tiempo | Los campos de tiempo usan milisegundos Unix. Los límites del día natural dependen de la zona horaria prevista. Cada campo conserva su significado específico para el recurso. |
| Identidad | El `id` de tarea identifica una tarea/ciclo; su `gid` identifica el grupo entre ciclos repetidos. Un ID de categoría/lista identifica otro recurso. |
| Valores vacíos | Ausencia, `null`, `0`, `""` y `[]` son distintos. Cada modelo documenta su comportamiento real de sustitución u omisión. |
| ID numéricos | Los ID pueden ser enteros de 64 bits con signo; Number de JavaScript no representa exactamente todos los valores. Conserva los ID grandes con un analizador JSON adecuado. |
| Arrays y objetos | Los valores HTTP anidados como `items` y `subTasks` son arrays, no cadenas con JSON codificado. |
| Códigos de estado y motivo | Usa la enumeración documentada para cada recurso. El estado de tareas, el estado de logros y los motivos de diarios son dominios diferentes. |

Consulta las [definiciones de tiempos de tareas](/guide/api-reference?id=task-times) para `startTime`, `deadline` y `endTime`.

## Paginación y filtrado :id=pagination

La paginación es una capacidad del endpoint, no una propiedad de todas las listas. Las respuestas HTTP de listas contienen `data: [...]`; **no** añaden `total`, `count` ni `hasMore`.

| Endpoint HTTP | Paginación | Rango de fechas | Otros filtros |
| --- | --- | --- | --- |
| `/tasks`, `/tasks/{categoryId}` | No; array completo | No | Categoría opcional en la ruta |
| `/history` | `offset` / `limit` en el servidor | No | `gid` opcional |
| `/feelings` | `offset` / `limit` en el servidor | No | Consulta la [sentimientos](#get-feelings) |
| `/pomodoro_records`, `/coin_records`, `/inventory_records`, `/exp_records`, `/step_records` | `offset` / `limit` en el servidor | `time_range_start` / `time_range_end` | Consulta el endpoint concreto |
| `/statistics` | No; un objeto | `time_range_start` / `time_range_end` | Consulta agregada |
| `/coin`, `/info` | No; un objeto | No | Consulta de objeto único |

Para endpoints paginados, los valores HTTP predeterminados son `offset=0` y `limit=100`. Usa desplazamientos no negativos y tamaños de página de `1..100` para un bucle común. El puente HTTP no aplica el límite MCP de `1..100`, y los proveedores pueden imponer otros límites; consulta el tamaño efectivo y las notas de validación de cada endpoint.

Salvo la [limitación del pomodoro filtrado por tiempo](#get-pomodoro-records), tras cada página correcta aumenta `offset` por el número de registros recibidos. Detente cuando sea menor que el tamaño efectivo de página (el `limit` solicitado al usar `1..100`, excluido el pomodoro filtrado por tiempo). No confundas una página limitada por el proveedor con la última. Una página vacía después del final es normal. Varias páginas no forman una instantánea: los registros pueden cambiar durante la consulta.

El SDK HTTP actual solo reenvía los límites de fecha si **ambos** se interpretan como enteros y `start < end`. Un límite aislado, ilegible o invertido produce una consulta sin filtro; no confíes en recibir un error para detectarlo. Valida ambos límites antes de enviar. La referencia de diarios indica el comportamiento inclusivo de sus límites.

## Diferencias de MCP :id=mcp-differences

Las herramientas de listas MCP usan `limit=20` por defecto, lo limitan a `1..100` y fijan `offset` como mínimo en `0`. Envían la paginación al servidor para recursos como historial/diarios, pero descargan arrays HTTP completos y los recortan localmente para recursos como tareas. Sus `items`, `count`, `hasMore` y `total` opcional pertenecen al envoltorio MCP. `detail=false` también elimina campos de cada registro; usa `detail=true` cuando necesites el modelo HTTP completo.

## Fuentes y alcance de versiones :id=api-common-sources

Estas referencias describen el SDK público actual y el comportamiento correspondiente del proveedor LifeUp. Los ejemplos usan datos inventados. Los enlaces al código son referencias de implementación, no pruebas de que una versión instalada concreta incluya todos los campos: [rutas HTTP](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt), [envoltorio HTTP](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/vo/HttpResponse.kt), [correspondencia de consultas MCP](https://github.com/Ayagikei/LifeUp-SDK/blob/main/mcp/src/query.ts).

## Modelos de datos de tareas e historial :id=task-history-models

Esta página define el **JSON HTTP** devuelto por las [consultas de tareas/historial](/guide/api-reference?id=task-queries). Las columnas Cursor de Android y los parámetros de acciones URL Scheme pueden tener nombres y representaciones distintos; consulta las [convenciones comunes](/guide/api-reference?id=representations).

El SDK usa una sola clase serializada `Task` para dos vistas. Aquí `Task` designa la vista `/tasks` y `HistoryRecord` la vista `/history`. Estos nombres describen la salida existente; no introducen otra API. La serialización actual de Cloud incluye valores predeterminados y campos `null`.

### Campos de Task / HistoryRecord :id=task-fields

Todos los campos siguientes aparecen en el objeto HTTP actual. Los valores ausentes del proveedor suelen convertirse en los valores de sustitución indicados; estos no demuestran que los datos originales contuvieran dicho valor.

| Campo | Tipo JSON | Significado / sustitución |
| --- | --- | --- |
| `id` | integer o `null` | ID de esta tarea/ciclo. |
| `gid` | integer o `null` | ID de grupo de tareas compartido entre ciclos repetidos. |
| `name` | string | Nombre de tarea. Si falta en el proveedor se convierte en `ERROR: name is null`. |
| `notes` | string | Notas; cadena vacía si no existen. |
| `status` | integer | Estado de tarea; si falta, `0`. Consulta la tabla de estados. |
| `startTime` | integer | Inicio configurado en milisegundos; sustitución del SDK `0`. |
| `deadline` | integer | Vencimiento en milisegundos; sustitución del SDK `0` si falta. |
| `remindTime` | integer | Recordatorio en milisegundos; sustitución del SDK `0` si falta. |
| `frequency` | integer | Código de repetición; `0` una vez, `1` diaria, `-1` ilimitada. Otros modos se describen en [acciones de tareas](/guide/api). Sustitución del SDK `0`. |
| `weekdays` | string | Selección de días, p. ej. `1,3,5` (lunes `1`, domingo `7`); vacío si no se proporciona y marcador vacío fijo en el historial. |
| `exp` | integer | Recompensa EXP configurada, no importe de transacción; predeterminado `0`. |
| `skillIds` | integer array | Atributos asociados a la recompensa; array vacío si no están disponibles. |
| `coin` | integer | Recompensa de monedas configurada; predeterminado `0`. |
| `coinVariable` | integer | Configuración de recompensa de monedas aleatorias; predeterminado `0`. |
| `itemId` | integer | ID heredado del primer objeto de recompensa; predeterminado `0`. Usa `items` para la lista completa. |
| `itemAmount` | integer | Cantidad heredada del primer objeto de recompensa; predeterminado `0`. Este nombre HTTP difiere de la columna `itemCount` del proveedor. |
| `words` | string | Texto de incentivo al completar; vacío si no existe. |
| `categoryId` | integer | ID de categoría/lista de tareas; predeterminado `0` si falta. |
| `order` | integer | Valor de orden de la lista; marcador fijo `0` en el historial porque ese proveedor no devuelve la columna. |
| `nameExtended` | string | Nombre ampliado para mostrar; marcador vacío fijo en el historial porque ese proveedor no devuelve la columna. |
| `endTime` | integer | Hora de finalización registrada en el historial. `/tasks` la rellena con `0`; consulta la [semántica temporal](/guide/api-reference?id=task-times). |
| `items` | `RewardItem[]` | Objetos de recompensa; array vacío si no están disponibles. |
| `subTasks` | `SubTask[]` | Subtareas anidadas; array vacío si no están disponibles. |
| `countProgress` | `TaskCountProgress` o `null` | Instantánea del progreso de conteo si está disponible; puede aparecer en ambas vistas. |
| `repeatEndCondition` | `TaskRepeatEndCondition` o `null` | Regla de fin de repetición en `/tasks`; siempre `null` en `/history`. |

### Estado y marcas de tiempo de tareas :id=task-times

| `status` | Significado | Significado de `endTime` en el historial |
| --- | --- | --- |
| `0` | Sin terminar | No es una hora de finalización; `/history` selecciona registros terminados. |
| `1` | Completada | Hora de finalización registrada. |
| `2` | Vencida | Hora de vencimiento registrada. |
| `3` | Abandonada | Hora de abandono registrada. |

| Campo temporal | Definición |
| --- | --- |
| `startTime` | Inicio configurado/programado de la tarea, no el momento en que el usuario empezó realmente a trabajar. |
| `deadline` | Vencimiento programado, separado de la hora de finalización registrada. |
| `endTime` | Hora registrada en que terminó la tarea del historial; interprétala con `status` como se indica arriba. |

Los tres usan milisegundos Unix. Al completar normalmente, la App registra la hora actual. `history_operation` con `operation=edit_completed_time` recibe `completed_time` y edita esa misma hora guardada; al leer el historial el campo sigue llamándose `endTime`.

Las horas guardadas se pueden editar. Si un registro terminado no tiene fecha de fin guardada, la App usa la hora actual. Por ello, `endTime` es la hora registrada actualmente, no una marca de auditoría inmutable. El `0` de `/tasks` es solo un marcador del SDK, no un evento real en el origen de la época Unix.

### RewardItem :id=reward-item

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `itemId` | integer | ID del objeto de recompensa. |
| `itemCount` | integer | Cantidad de recompensa. |

```json
{"itemId":7,"itemCount":1}
```

### SubTask :id=subtask

| Campo | Tipo JSON | Significado / predeterminado |
| --- | --- | --- |
| `id` | integer | ID de subtarea. |
| `gid` | integer | ID del grupo de subtareas. |
| `todo` | string | Texto de la subtarea. |
| `status` | integer | `0` sin terminar, `1` completada. |
| `remindTime` | integer o `null` | Marca de recordatorio en milisegundos; `null` si no está disponible. |
| `endTime` | integer o `null` | Marca de finalización de la subtarea en milisegundos; `null` si no está disponible. |
| `exp` | integer | Recompensa EXP configurada. |
| `coin` | integer o `null` | Recompensa de monedas configurada. |
| `coinVariable` | integer o `null` | Configuración de recompensa de monedas aleatorias. |
| `items` | `RewardItem[]` | Objetos de recompensa; array vacío por defecto. |
| `order` | integer o `null` | Valor de orden; predeterminado del modelo `0`. |
| `autoUseItem` | boolean o `null` | Si las recompensas se usan automáticamente; predeterminado del modelo `false`. |

```json
{
  "id":201,"gid":20,"todo":"Read ten pages","status":1,
  "remindTime":null,"endTime":1792072800000,"exp":2,
  "coin":0,"coinVariable":0,"items":[{"itemId":7,"itemCount":1}],
  "order":0,"autoUseItem":false
}
```

### TaskCountProgress :id=count-progress

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `currentCount` | integer | Conteo actual de esta tarea/ciclo. |
| `targetCount` | integer | Conteo objetivo de esta tarea/ciclo. |

```json
{"currentCount":2,"targetCount":5}
```

### TaskRepeatEndCondition :id=repeat-end-condition

| Campo | Tipo JSON | Significado / predeterminado |
| --- | --- | --- |
| `mode` | string | `COUNT` o `DATE`. Son cadenas de lectura, no los parámetros numéricos de acciones. |
| `behavior` | string | `TERMINATE` o `FREEZE`. |
| `targetCycleCount` | integer o `null` | Objetivo de ciclos para `COUNT`; predeterminado `null`. |
| `endDateMillis` | integer o `null` | Marca de fecha final en milisegundos para `DATE`; predeterminado `null`. |
| `inclusive` | boolean | Indicador de fecha final inclusiva; predeterminado `false`. |

```json
{"mode":"COUNT","behavior":"TERMINATE","targetCycleCount":10,"endDateMillis":null,"inclusive":false}
```

### Importes de recompensas :id=reward-amounts

Estos campos de tareas y subtareas describen recompensas configuradas. Los multiplicadores, monedas aleatorias y reglas de liquidación pueden cambiar la recompensa real. Usa los [diarios de EXP y monedas](/guide/api-reference?id=reward-journals) para los importes de transacciones y distingue las recompensas positivas de los cambios netos con reversiones o penalizaciones.

### Referencias de implementación :id=api-task-model-sources

[Task](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/Task.kt) · [Analizador](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TasksApi.kt) · [SubTask](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/SubTask.kt) · [RewardItem](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/common/RewardItem.kt) · [Progreso de conteo](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TaskCountProgress.kt) · [Regla de repetición](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TaskRepeatEndCondition.kt).

## Consultas de tareas e historial :id=task-queries

Lee las [convenciones comunes](/guide/api-reference?id=http-query-reference) y el [modelo completo de tareas/historial](/guide/api-reference?id=task-history-models). Estos endpoints requieren el permiso de Cloud para leer datos de LifeUp. Las consultas básicas de listas están documentadas para LifeUp v1.91+ con Cloud actualizado; los ejemplos describen los campos del SDK actual. Comprueba `/info` al integrar instalaciones antiguas.

### GET /tasks y /tasks/{categoryId} :id=get-tasks

Consulta la lista actual de tareas **sin terminar**, opcionalmente limitada a una categoría/lista. El resultado es un array completo, sin paginación del servidor. Los registros completados, vencidos y abandonados pertenecen a `/history`.

| Parámetro | Ubicación | Tipo | Obligatorio | Predeterminado / comportamiento |
| --- | --- | --- | --- | --- |
| `categoryId` | Path | integer | Solo para `/tasks/{categoryId}` | Omite todo el segmento de ruta para obtener la lista sin restricción. |

Estas rutas no admiten parámetros de consulta `offset`, `limit`, `gid` ni rangos de fechas. Un segmento de categoría no entero se interpreta actualmente como categoría ausente; valídalo antes de solicitar para no consultar todas las tareas por accidente.

```text
GET http://{host:port}/tasks
GET http://{host:port}/tasks/1
```

**Respuesta:** `HttpResponse<Task[]>`. Todos los campos y estructuras anidadas se definen en [campos de tareas/historial](/guide/api-reference?id=task-fields). El siguiente registro inventado muestra la estructura HTTP superior completa; `endTime=0` es un marcador de esta ruta, no una marca de finalización.

```json
{
  "code": 200,
  "message": "success",
  "data": [{
    "id": 101, "gid": 10, "name": "Read a chapter", "notes": "",
    "status": 0, "startTime": 1792108800000, "deadline": 1792195199999,
    "remindTime": 0, "frequency": 1, "weekdays": "",
    "exp": 5, "skillIds": [2], "coin": 10, "coinVariable": 0,
    "itemId": 0, "itemAmount": 0, "words": "", "categoryId": 1,
    "order": 0, "nameExtended": "Read a chapter", "endTime": 0,
    "items": [], "subTasks": [], "countProgress": null,
    "repeatEndCondition": null
  }]
}
```

**Comportamiento y errores:** la selección y el orden siguen la lógica de listas de LifeUp; este endpoint no garantiza orden por finalización. Un `data: []` correcto significa que la lista seleccionada no devolvió registros. Los fallos de permisos/proveedor usan el [envoltorio común de errores](/guide/api-reference?id=response-errors); no son arrays vacíos. Para informes de tareas completadas, usa `/history` en lugar del `endTime` de esta ruta.

### GET /history :id=get-history

Consulta registros visibles de tareas terminadas, incluidas completadas, vencidas y abandonadas. Se excluye el historial eliminado.

| Parámetro | Ubicación | Tipo | Obligatorio | Predeterminado / comportamiento |
| --- | --- | --- | --- | --- |
| `offset` | Query | integer | No | `0`; número de registros que omitir, basado en cero. |
| `limit` | Query | integer | No | `100`; solicita un tamaño positivo, preferiblemente `1..100`. |
| `gid` | Query | integer | No | Sin filtro de grupo; si aparece, selecciona ese grupo de tareas entre ciclos. |

El analizador HTTP usa `0` / `100` si no puede interpretar `offset` / `limit`, y descarta un `gid` ilegible. Esta ruta no limita los números interpretados. Valida tú los desplazamientos no negativos y límites positivos. `time_range_start` / `time_range_end` **no se admiten**; enviarlos no filtra el historial.

```text
GET http://{host:port}/history?offset=0&limit=100
GET http://{host:port}/history?offset=0&limit=100&gid=10
```

**Respuesta:** `HttpResponse<HistoryRecord[]>`, con los [campos HTTP de tareas/historial](/guide/api-reference?id=task-fields). `HistoryRecord` es el nombre documental de la vista de historial del modelo `Task` del SDK. `repeatEndCondition` es `null` en esta vista; puede aparecer `countProgress`. La hora `endTime` guardada se interpreta con `status`.

```json
{
  "code": 200,
  "message": "success",
  "data": [{
    "id": 100, "gid": 10, "name": "Read a chapter", "notes": "",
    "status": 1, "startTime": 1792022400000, "deadline": 1792108799999,
    "remindTime": 0, "frequency": 1, "weekdays": "",
    "exp": 5, "skillIds": [2], "coin": 10, "coinVariable": 0,
    "itemId": 0, "itemAmount": 0, "words": "", "categoryId": 1,
    "order": 0, "nameExtended": "", "endTime": 1792072800000,
    "items": [], "subTasks": [], "countProgress": null,
    "repeatEndCondition": null
  }]
}
```

**Orden:** fecha final guardada descendente, lo más reciente primero. No hay un criterio de desempate documentado para fechas iguales. La paginación no es una instantánea; evita editar datos al recopilar un informe y elimina duplicados por `id` al combinar páginas.

**Paginación y resultados vacíos:** usa el [procedimiento común](/guide/api-reference?id=pagination). Un array vacío correcto significa que no hay registros visibles para esta página/grupo, incluso si `offset` supera el final. No certifica que nunca hubiera actividad: se excluyen registros eliminados y no hay indicador de integridad. Si falla alguna petición, informa de datos no disponibles/incompletos, no de cero tareas. Se aplican los [errores comunes](/guide/api-reference?id=response-errors).

### Crear un informe diario :id=daily-report

1. Elige la zona horaria del informe. Calcula el inicio del día natural (`dayStart`) y el del día siguiente (`nextDayStart`). No supongas que todos los días locales duran exactamente 24 horas.
2. Lee `/history` con `offset=0&limit=100`, comprueba cada respuesta y recopila todas las páginas. Mantén constante cualquier filtro `gid` previsto.
3. Selecciona `status == 1` y `dayStart <= endTime < nextDayStart`. Ten en cuenta las [limitaciones de las horas registradas](/guide/api-reference?id=task-times) al describir resultados.
4. Para cambios reales de EXP y monedas, lee los [diarios de recompensas](/guide/api-reference?id=reward-journals) del mismo día. Sus filtros incluyen ambos extremos, así que usa `time_range_start=dayStart` y `time_range_end=nextDayStart-1`.
5. Distingue «sin registros en los datos disponibles» de una lectura fallida/incompleta. Decide si el informe muestra solo recompensas positivas o cambios netos con reversiones y aplica ese criterio de forma coherente.

Los campos `exp` y `coin` de tareas/historial son recompensas configuradas, no sustituyen con fiabilidad los importes del diario. Editar la finalización a otro día no implica que la hora de transacción del diario de recompensas se haya desplazado también.

### Referencias de implementación :id=api-task-queries-sources

[Rutas HTTP](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt) · [Análisis de tareas e historial](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TasksApi.kt).

## Consultas de diarios de EXP y monedas :id=reward-journals

Estos endpoints HTTP de solo lectura requieren permiso para leer datos de LifeUp, LifeUp **1.106.0+** y LifeUp Cloud **3.0.0+**. Devuelven cambios registrados, incluidas disminuciones y reversiones, en lugar de la configuración de recompensas de tareas. Lee primero las [convenciones comunes](/guide/api-reference?id=http-query-reference).

### Parámetros de ambos endpoints :id=journal-parameters

El siguiente contrato se aplica específicamente a **ambos**, `GET /exp_records` y `GET /coin_records`.

| Parámetro | Ubicación | Tipo | Obligatorio | Predeterminado / comportamiento real |
| --- | --- | --- | --- | --- |
| `offset` | Query | integer | No | Predeterminado HTTP `0`; el proveedor limita los negativos a `0`. |
| `limit` | Query | integer | No | Predeterminado HTTP `100`; el proveedor limita a `1..200`. Usa `1..100` para la paginación común. |
| `time_range_start` | Query | integer (milisegundos Unix) | No, o por pares | Límite inferior inclusivo de la hora registrada de la transacción. |
| `time_range_end` | Query | integer (milisegundos Unix) | No, o por pares | Límite superior inclusivo; el filtro válido requiere `start < end`. |

Los valores de paginación ilegibles o fuera de rango usan los predeterminados HTTP. Los de fecha ilegibles se consideran ausentes. El SDK actual solo reenvía el rango si existen ambos límites y `start < end`; en otro caso consulta **sin filtro de fecha**. Las llamadas directas al ContentProvider validan los rangos inválidos de otra manera. Valida los límites en el cliente HTTP.

Ambos endpoints ordenan por hora de transacción registrada descendente, lo más reciente primero, y excluyen entradas eliminadas. No garantizan desempate por ID ni instantánea de varias páginas. Sigue la [paginación](/guide/api-reference?id=pagination), considerando el límite efectivo del proveedor. Un array vacío correcto significa que ninguna entrada coincide con el rango/página elegidos; una lectura fallida no equivale a cero actividad. Ninguno proporciona un indicador de integridad para datos eliminados o no disponibles.

### GET /exp_records :id=get-exp-records

Consulta cambios de EXP. Los parámetros son exactamente los [cuatro parámetros de diarios anteriores](/guide/api-reference?id=journal-parameters); no hay filtro `gid`.

```text
GET http://{host:port}/exp_records?offset=0&limit=100&time_range_start=1792022400000&time_range_end=1792108799999
```

**Respuesta:** `HttpResponse<ExpRecord[]>`. La serialización actual incluye todos los campos indicados, incluidos los que admiten valores nulos.

| Campo | Tipo JSON | Significado / sustitución del analizador |
| --- | --- | --- |
| `id` | integer o `null` | ID de entrada del diario. |
| `time` | integer o `null` | Hora de transacción en milisegundos Unix, distinta de la finalización editable de la tarea. |
| `value` | integer | Cambio de EXP por atributo asociado; sustitución `0`. Usa `isDecrease` para la dirección. |
| `isDecrease` | boolean | `true` para disminución, `false` para aumento; el analizador interpreta el entero `1` del proveedor como verdadero. |
| `totalValue` | integer | Cambio agregado de EXP registrado, **no un saldo de EXP**; sustitución `0`. Los lotes con varios atributos pueden solaparse en este total guardado; consulta [totales de informes](/guide/api-reference?id=journal-totals). |
| `resCode` | integer | Código de motivo específico de EXP; sustitución `0`. |
| `relatedId` | integer o `null` | ID del objeto de origen relacionado. Al completar una tarea normalmente, es su `id`, no su `gid`. Otros motivos pueden referirse a otros recursos. |
| `content` | string o `null` | Descripción del cambio. |
| `skillIds` | integer array | IDs de atributos/habilidades asociados; sustitución array vacío. |
| `relatedAttributes` | string array | Cadenas heredadas de atributos asociados; sustitución array vacío. |

Ejemplo inventado: 10 EXP para cada uno de dos atributos, 20 EXP en total.

```json
{
  "code":200,"message":"success","data":[{
    "id":301,"time":1792072800000,"value":10,"isDecrease":false,
    "totalValue":20,"resCode":1,"relatedId":100,"content":"Task completed",
    "skillIds":[2,3],"relatedAttributes":[]
  }]
}
```

**Errores:** [errores comunes HTTP/del proveedor](/guide/api-reference?id=response-errors). Los límites de fecha HTTP inválidos pueden eliminar silenciosamente el filtro como se explica arriba, en vez de producir un error.

### GET /coin_records :id=get-coin-records

Consulta cambios de monedas. Los parámetros son exactamente los [cuatro parámetros de diarios anteriores](/guide/api-reference?id=journal-parameters); no hay filtro `gid`.

```text
GET http://{host:port}/coin_records?offset=0&limit=100&time_range_start=1792022400000&time_range_end=1792108799999
```

**Respuesta:** `HttpResponse<CoinRecord[]>`. La serialización actual incluye todos los campos indicados, incluidos los que admiten valores nulos.

| Campo | Tipo JSON | Significado / sustitución del analizador |
| --- | --- | --- |
| `id` | integer o `null` | ID de entrada del diario. |
| `time` | integer o `null` | Hora de transacción en milisegundos Unix. |
| `value` | integer | Importe del cambio de monedas; sustitución `0`. Usa `isDecrease` para la dirección. |
| `isDecrease` | boolean | `true` para disminución, `false` para aumento; el analizador interpreta el entero `1` del proveedor como verdadero. |
| `totalValue` | integer | Saldo de monedas tras la operación; sustitución `0`. A diferencia de `totalValue` de EXP, sí es un saldo. |
| `resCode` | integer | Código de motivo específico de monedas; sustitución `0`. |
| `relatedId` | integer o `null` | ID del objeto de origen relacionado; al completar normalmente una tarea usa su `id`. Interpreta otros orígenes mediante el código de motivo. |
| `content` | string o `null` | Descripción del cambio. |
| `savingBalance` | integer o `null` | Saldo de ahorros registrado para la operación. |

Ejemplo inventado: disminución de 5 monedas que deja un saldo de 95.

```json
{
  "code":200,"message":"success","data":[{
    "id":401,"time":1792072800000,"value":5,"isDecrease":true,
    "totalValue":95,"resCode":0,"relatedId":null,"content":"Example purchase",
    "savingBalance":0
  }]
}
```

**Errores:** [errores comunes HTTP/del proveedor](/guide/api-reference?id=response-errors). Los límites de fecha HTTP inválidos pueden eliminar silenciosamente el filtro como se explica arriba, en vez de producir un error.

### Códigos de motivo y totales de informes :id=journal-totals

Los dominios de códigos de motivo difieren. Algunos ejemplos:

| Motivo | EXP `resCode` | Monedas `resCode` |
| --- | --- | --- |
| Completar tarea | `1` | `2` |
| Deshacer tarea completada | `101` | `3` |
| Completar subtarea | `12` | `11` |
| Deshacer subtarea completada | `106` | `12` |
| Cambio por API | `200` | `28` |

Códigos EXP completos: `0` desconocido; `1` tarea completada; `2` logro; `3` intercambio de me gusta; `4` racha de días de uso; `5` intercambio de pasos; `6` marcar como completada; `7` deshacer abandono; `8` deshacer vencimiento; `9` comer tomate; `10` usar objeto; `11` desbloqueo de logro del usuario; `12` subtarea completada; `200` API; `101` deshacer finalización; `102` abandono; `103` vencimiento; `104` uso de objeto que reduce EXP; `105` volver a bloquear logro del usuario; `106` deshacer finalización de subtarea. Los códigos de motivo de monedas usan el mismo dominio que los [registros de inventario](#get-inventory-records). Conserva los códigos futuros desconocidos. Para un cambio neto, aplica la dirección con `isDecrease` (`true` resta el importe registrado). No supongas que una disminución se codifica como un `value` negativo; los tipos numéricos tienen signo y no se garantiza un valor sin signo/absoluto.

El `value` de EXP es por atributo. No sumes ciegamente el `totalValue` de EXP entre registros: la lógica actual por lotes puede guardar totales solapados si hay más de tres atributos. Por ejemplo, un cambio de 10 EXP para cada uno de cuatro atributos puede producir totales guardados de 40 y 10, en lugar de una suma segura de 40. Para informes precisos, concilia el `value` por atributo con los atributos enumerados en cada registro; la ausencia de asociaciones limita las conclusiones posibles. No sumes `value` y `totalValue` ni describas el `totalValue` de EXP como saldo.

Para un día natural, calcula `dayStart` y `nextDayStart` locales y solicita `[dayStart, nextDayStart - 1]`, porque ambos límites son inclusivos. Selecciona códigos de motivo al informar solo recompensas de tareas; no los filtres al informar todos los cambios registrados. [Procedimiento de informe diario](/guide/api-reference?id=daily-report).

### Referencias de implementación :id=api-ledgers-sources

[CoinRecord](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/CoinRecord.kt) · [ExpRecord](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/ExpRecord.kt) · [Reenvío de parámetros de fecha](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/LedgerUri.kt).

## Objetos y categorías :id=get-items

`GET /items` devuelve `ShopItem[]`. El parámetro opcional repetido `id` selecciona ID de objetos: `/items?id=1&id=2`. Se descartan los valores no enteros. Se omiten los ID inexistentes; los válidos conservan el orden solicitado, incluidos duplicados. Si todos son inválidos, el SDK no envía filtro por ID y devuelve la lista normal. Sin paginación.

`GET /items/{listId}` devuelve `ShopItem[]` de una **categoría**, no un objeto individual. `listId` es un ID de categoría entero de 64 bits con signo; `-1` significa todas. Un valor de ruta inválido usa todas. La lista normal excluye objetos retirados/eliminados (`isDel=0`) y sigue el orden configurado de tienda/categoría. La selección por ID puede recuperar objetos independientemente de ese filtro normal.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Coffee","desc":"A small reward","icon":"","categoryId":0,"stockNumber":-1,"ownNumber":2,"price":10,"order":0,"disablePurchase":false,"maxPurchaseNumber":5,"titleColorString":"","actionText":"Use","unlist":false,"disableUse":false,"purchaseLimit":"[]","limitScope":"purchase"}]}
```

### ShopItem :id=model-shop-item

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `id` | integer o null | ID del objeto. |
| `name` | string | Nombre del objeto. |
| `desc` | string | Descripción. |
| `icon` | string | URI de imagen legible o cadena vacía. Descargar mediante `/files/{url}`. |
| `categoryId` | integer | ID de la categoría de la tienda. |
| `stockNumber` | integer | Existencias disponibles; las negativas se consideran ilimitadas al calcular `maxPurchaseNumber`. |
| `ownNumber` | integer | Cantidad poseída en el inventario. |
| `price` | integer | Precio en monedas. |
| `order` | integer | Orden guardado dentro de su categoría. |
| `disablePurchase` | boolean | Indicador de compra desactivada. |
| `maxPurchaseNumber` | integer o null | Se calcula con las monedas disponibles más el crédito y las existencias finitas; las compras desactivadas dan 0 y las existencias gratuitas ilimitadas pueden dar 2147483647. No evalúa todas las reglas de límite de compra. |
| `titleColorString` | string o null | Color personalizado del título. |
| `actionText` | string o null | Texto personalizado del botón de uso. |
| `unlist` | boolean | Indicador de retirado/eliminado; normalmente false en listas. |
| `disableUse` | boolean | Si el objeto tiene un efecto que impide usarlo. |
| `purchaseLimit` | string o null | **Cadena codificada en JSON**, no un array anidado; configuración de límites de compra del objeto. |
| `limitScope` | string o null | `purchase`, `use` o `both`. |

### GET /items_categories :id=get-items-categories

Devuelve `ShopCategory[]`. `include_hidden` es opcional y vale `false` por defecto; solo acepta exactamente `true` y `false` en minúsculas, cualquier otro valor usa false. Incluye la categoría virtual «Todas». El servidor HTTP no expone `/items_categories/{id}`.

```json
{"code":200,"message":"success","data":[{"id":0,"name":"Default","isAsc":true,"sort":"order","order":0,"hidden":false,"inventoryHidden":false}]}
```

### ShopCategory :id=model-shop-category

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `id` | integer o null | ID de la categoría. |
| `name` | string | Nombre de la categoría. |
| `isAsc` | boolean | Indicador configurado de orden ascendente. |
| `sort` | string | Preferencia de orden guardada. |
| `order` | integer | Orden de la categoría. |
| `hidden` | boolean | Oculta en la tienda. |
| `inventoryHidden` | boolean | Oculta en el inventario. |

### GET /tasks_categories :id=get-tasks-categories

Devuelve `TaskCategory[]`, incluidas la categoría «Todas» y las archivadas. Sin parámetros de consulta ni paginación. El servidor HTTP no expone `/tasks_categories/{id}`. Los valores de orden/filtro son preferencias guardadas de la App; este endpoint no los aplica como filtros de solicitud.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Daily","isAsc":true,"sort":"order","filter":"","order":0,"status":0,"type":0}]}
```

### TaskCategory :id=model-task-category

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `id` | integer o null | ID de la categoría. |
| `name` | string | Nombre. |
| `isAsc` | boolean | Indicador guardado de orden ascendente. |
| `sort` | string | Preferencia de orden guardada. |
| `filter` | string | Preferencia guardada de agrupación/filtro. |
| `order` | integer | Orden de la categoría. |
| `status` | integer | 0 normal; 1 archivada. |
| `type` | integer | 0 normal; listas inteligentes: 10 diaria, 11 semanal, 12 mensual, 20 en curso. |

## Atributos y grupos de atributos :id=get-skills

`GET /skills` devuelve `Skill[]`, sin parámetros ni paginación. Excluye atributos ocultos/eliminados y usa el orden guardado. `group_id` y `status` del ContentProvider subyacente **no** son campos del modelo HTTP.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Strength","desc":"","icon":"","order":0,"color":-65536,"exp":150,"level":2,"untilNextLevelExp":50,"currentLevelExp":50,"type":1}]}
```

### Skill :id=model-skill

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `id` | integer o null | ID del atributo. |
| `name` | string | Nombre localizado del atributo. |
| `desc` | string | Descripción. |
| `icon` | string | URI de icono legible o vacía. |
| `order` | integer | Orden guardado. |
| `color` | integer | Entero de color empaquetado de Android. |
| `exp` | integer | EXP total actual. |
| `level` | integer | Nivel actual. |
| `untilNextLevelExp` | integer | EXP restante hasta el siguiente nivel. |
| `currentLevelExp` | integer | EXP ganada desde el inicio del nivel actual. |
| `type` | integer | 0 usuario; 1 fuerza; 2 aprendizaje; 3 encanto; 4 resistencia; 5 vitalidad; 6 creatividad. |

### GET /skill_groups :id=get-skill-groups

Devuelve `SkillGroup[]`. `include_hidden` usa el mismo análisis booleano estricto que `/items_categories`, por defecto false. El repositorio actual de la App ignora este indicador para grupos y siempre excluye los eliminados. Orden guardado ascendente. Sin paginación.

```json
{"code":200,"message":"success","data":[{"id":1,"content":"Personal","order":0,"collapsed":false}]}
```

### SkillGroup :id=model-skill-group

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `id` | integer o null | ID del grupo. |
| `content` | string | Título del grupo. |
| `order` | integer | Orden guardado del grupo. |
| `collapsed` | boolean | Estado contraído. |

## Logros :id=get-achievements

`GET /achievements` devuelve `Achievement[]` cargando cada categoría en orden y concatenando sus logros. `GET /achievements/{id}` devuelve logros **de la categoría `id`**, no el detalle de un logro. Los ID de ruta inválidos equivalen a la ruta sin filtro. El orden dentro de cada categoría sigue su preferencia en la App. Ninguno tiene paginación.

```json
{"code":200,"message":"success","data":[{"id":10,"name":"First step","desc":"Complete a task","iconUri":"","categoryId":1,"status":0,"exp":10,"coin":5,"coinVariable":0,"type":0,"progress":0,"order":0,"itemId":null,"itemAmount":null,"unlockedTime":null,"items":[],"color":""}]}
```

### Achievement :id=model-achievement

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `id` | integer o null | ID del logro. |
| `name` | string | Título. |
| `desc` | string | Descripción. |
| `iconUri` | string | URI del icono o vacía. |
| `categoryId` | integer | ID de la categoría. |
| `status` | integer | 0 incompleto; 1 completado con recompensa sin reclamar; 2 recompensa reclamada/otro estado completado. |
| `exp` | integer | Recompensa de EXP. |
| `coin` | integer | Recompensa en monedas. |
| `coinVariable` | integer | Recompensa variable en monedas. |
| `type` | integer | 0 logro; 1 encabezado de subcategoría. |
| `progress` | integer | Progreso guardado. |
| `order` | integer | Orden dentro de la categoría. |
| `itemId` | integer o null | ID del primer objeto de recompensa (campo auxiliar antiguo). |
| `itemAmount` | integer o null | Cantidad del primer objeto de recompensa. |
| `unlockedTime` | integer o null | Fecha de desbloqueo en milisegundos Unix. |
| `items` | RewardItem[] o null | Lista completa de objetos de recompensa; el analizador actual devuelve un array vacío si el JSON de objetos falta o está mal formado. |
| `color` | string o null | Color personalizado del título. |

Los objetos de recompensa usan el modelo compartido [RewardItem](#reward-item).

### GET /achievement_categories :id=get-achievement-categories

Devuelve `AchievementCategory[]`, sin parámetros ni paginación. El servidor HTTP no expone `/achievement_categories/{id}`.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Milestones","desc":"","iconUri":"","isAsc":true,"sort":"order","filter":"","order":0,"type":0}]}
```

### AchievementCategory :id=model-achievement-category

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `id` | integer o null | ID de la categoría. |
| `name` | string | Nombre. |
| `desc` | string | Descripción. |
| `iconUri` | string | URI/cadena del icono. |
| `isAsc` | boolean | Indicador de orden ascendente. |
| `sort` | string | Preferencia de orden guardada. |
| `filter` | string | Preferencia guardada de agrupación/filtro. |
| `order` | integer | Orden de la categoría. |
| `type` | integer | 0 logros del usuario; 1 logros del sistema. |

### GET /achievement_conditions/{id} :id=get-achievement-conditions

Devuelve `AchievementCondition[]` para el ID de **logro** `id`. Un ID no entero produce un contenedor de error con código 500. Si no hay condiciones coincidentes, devuelve un array vacío. No existe una ruta de colección `/achievement_conditions`.

```json
{"code":200,"message":"success","data":[{"id":1,"type":0,"relatedId":42,"target":10,"current":3,"progress":30}]}
```

### AchievementCondition :id=model-achievement-condition

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `id` | integer o null | ID de la condición. |
| `type` | integer | Código de condición; véase abajo. |
| `relatedId` | integer | Identificador de tarea/objeto/atributo relacionado según la condición. |
| `target` | integer | Valor objetivo. |
| `current` | integer | Valor acumulado actual. |
| `progress` | integer | Progreso guardado. |

Códigos de condición: 0 tareas completadas; 1 racha actual de tarea; 2 nivel de atributo antiguo; 3 tomates; 4 días de uso de la App; 5 me gusta; 6 días consecutivos de finalización; 7 monedas actuales; 8 monedas ganadas en un día; 9 tomates de tarea; 10 compras de objetos; 11 usos de objetos; 12 objetos ganados en cajas; 13 nivel de atributo; 14 nivel de vida; 15 objetos ganados acumulados; 16 objetos ganados por síntesis; 17 cantidad poseída actual; 18 tiempo de concentración de tarea; 19 ahorros ATM; 20 API externa. Condiciones repetidas: 500 tareas completadas; 501 aumentos de nivel de atributo; 502 tomates; 503 monedas; 504 objetos ganados; 505 compras de objetos; 506 ganancias de cajas; 507 ganancias por síntesis; 508 usos de objetos; 509 minutos de concentración de tarea; 510 tomates de tarea; 511 me gusta; 512 aumentos de ahorros ATM; 513 llamadas API externas; 514 días de uso; 515 aumentos de nivel de vida; 516 monedas diarias; 517 tareas completadas consecutivamente; 518 tomates diarios; 519 minutos diarios de concentración; 520 grupos de tareas distintos diarios; 521 usos diarios de objetos; 522 compras diarias de objetos; 523 finalizaciones diarias de una tarea concreta; 524 registros totales diarios de tareas completadas. Son códigos enteros sin procesar, no nombres de enumeración serializados.

## Síntesis :id=get-synthesis

`GET /synthesis` devuelve `Synthesis[]` de categorías visibles. `GET /synthesis/{id}` devuelve recetas **de la categoría `id`**, incluido su contenido oculto. Los ID no negativos seleccionan una categoría; los negativos, todas las visibles. Los inválidos usan la ruta de colección. Los resultados siguen el orden guardado ascendente de recetas; excluyen las eliminadas. Sin paginación.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Tea","desc":"","input":[{"itemId":2,"itemName":"Tea leaf","amount":2,"ownedNumber":5,"icon":""}],"output":[{"itemId":3,"itemName":"Tea","amount":1,"ownedNumber":0,"icon":""}],"categoryId":0,"canSynthesisTimes":2}]}
```

### Synthesis :id=model-synthesis

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `id` | integer o null | ID de la receta. |
| `name` | string | Nombre. |
| `desc` | string | Descripción. |
| `input` | SynthesisItemInfo[] | Objetos necesarios. |
| `output` | SynthesisItemInfo[] | Objetos producidos. |
| `categoryId` | integer o null | ID de la categoría. |
| `canSynthesisTimes` | integer | Número de síntesis disponibles actualmente. |

### SynthesisItemInfo :id=model-synthesis-item-info

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `itemId` | integer | ID del objeto. |
| `itemName` | string | Nombre del objeto. |
| `amount` | integer | Cantidad de entrada/salida por síntesis. |
| `ownedNumber` | integer | Cantidad poseída. |
| `icon` | string | URI de icono legible o vacía. |

### GET /synthesis_categories y /synthesis_categories/{id} :id=get-synthesis-categories

Ambos devuelven `SynthesisCategory[]`. El `id` opcional de ruta filtra el ID de categoría, sin cambiar la forma del array. Los ID inválidos seleccionan todas las categorías. `include_hidden` es opcional, usa análisis booleano estricto en minúsculas y vale false por defecto, incluso si se indica categoría. Sin paginación.

```json
{"code":200,"message":"success","data":[{"id":0,"name":"Default","isAsc":true,"sort":"order","order":0,"hidden":false}]}
```

### SynthesisCategory :id=model-synthesis-category

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `id` | integer o null | ID de la categoría. |
| `name` | string | Nombre. |
| `isAsc` | boolean | Indicador guardado de orden ascendente. |
| `sort` | string | Preferencia de orden guardada. |
| `order` | integer | Orden de la categoría. |
| `hidden` | boolean | Indicador de ocultación. |

## Sentimientos :id=get-feelings

`GET /feelings` devuelve `Feelings[]`. `offset` vale 0 y `limit` 100 por defecto; los valores ausentes o no enteros usan esos valores. Sin límite explícito. Usa desplazamientos no negativos y límites positivos. Excluye sentimientos eliminados. El orden sigue la preferencia de la App (`createTime` ascendente o descendente), no un parámetro. No hay filtro temporal.

```json
{"code":200,"message":"success","data":[{"id":1,"content":"A good day","isFav":false,"title":"Read","time":1700000000000,"attachments":[],"type":0}]}
```

### Feelings :id=model-feelings

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `id` | integer o null | ID del sentimiento. |
| `content` | string | Texto. |
| `isFav` | boolean | Indicador de favorito. |
| `title` | string | Título relacionado. |
| `time` | integer | Fecha de creación en milisegundos Unix. |
| `attachments` | string[] | URI de adjuntos legibles para archivos existentes no vacíos. |
| `type` | integer | 0 tarea; 1 logro; 2 entrada independiente. |

## Registros de pomodoro :id=get-pomodoro-records

`GET /pomodoro_records` devuelve `PomodoroRecord[]`. `offset` vale 0 y `limit` 100 por defecto; sin límite explícito. Los opcionales `time_range_start` y `time_range_end` son milisegundos Unix. El SDK solo reenvía el intervalo si ambos se analizan como enteros de 64 bits e inicio es menor que fin; en otro caso lo omite silenciosamente.

Sin intervalo, devuelve registros completados no eliminados con `startTime != endTime` y `endTime` positivo, ordenados por `endTime DESC, startTime DESC, id DESC`. Un intervalo válido selecciona `start < endTime <= end` y excluye filas eliminadas.

> [!WARNING]
> Las implementaciones anteriores pasaban `limit` y `offset` al DAO en posiciones invertidas al consultar un intervalo y no definían el orden. El código local de LifeUp ya usa argumentos con nombre y ordena los resultados paginados por `endTime DESC, startTime DESC, id DESC`; esta corrección local aún no se ha publicado. Hasta confirmar que tu versión instalada de LifeUp la incluye, omite el intervalo y filtra las filas en el cliente para paginar de forma fiable.

```json
{"code":200,"message":"success","data":[{"id":1,"startTime":1700000000000,"endTime":1700001500000,"duration":1500000,"reward":1.0}]}
```

### PomodoroRecord :id=model-pomodoro-record

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `id` | integer o null | ID del registro. |
| `startTime` | integer o null | Inicio en milisegundos Unix. |
| `endTime` | integer o null | Fin en milisegundos Unix. |
| `duration` | integer | Milisegundos: `lastTime` guardado si es distinto de cero; en otro caso, fin menos inicio. |
| `reward` | number | Tomates ganados: abandonado = 0; mitad = 0,5 × multiplicador; en otro caso, multiplicador. |

## Registros de inventario :id=get-inventory-records

`GET /inventory_records` devuelve `InventoryRecord[]`. `offset` vale 0 por defecto y se limita a un mínimo de 0; `limit` vale 100 y se limita a 1–200. `time_range_start` y `time_range_end` opcionales solo se reenvían si son enteros de 64 bits e inicio < fin; el SDK omite silenciosamente intervalos inválidos/incompletos. Los válidos usan límites inclusivos `time >= start AND time <= end`. Excluye registros eliminados (`isDel` null o 0); orden `time DESC, id DESC`. Sin filtro por ID de objeto.

```json
{"code":200,"message":"success","data":[{"id":1,"time":1700000000000,"itemId":2,"itemName":"Tea","changeNumber":1,"isDecrease":false,"resCode":0,"desc":"Purchase"}]}
```

### InventoryRecord :id=model-inventory-record

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `id` | integer o null | ID del registro. |
| `time` | integer o null | Fecha de creación en milisegundos Unix. |
| `itemId` | integer o null | ID del objeto relacionado. |
| `itemName` | string o null | Nombre del objeto relacionado, si está disponible. |
| `changeNumber` | integer | Cambio de cantidad registrado. |
| `isDecrease` | boolean | Si el cambio reduce el inventario. |
| `resCode` | integer | Código del motivo de origen; véase abajo. |
| `desc` | string o null | Descripción del registro. |

Códigos de motivo: 0 compra; 1 uso; 2 tarea completada; 3 deshacer finalización; 4 borrar datos; 5 abandonar tarea; 6 tarea vencida; 7 desbloqueo de logro integrado; 8 deshacer abandono; 9 deshacer vencimiento; 10 devolver objeto; 11 subtarea completada; 12 deshacer subtarea; 13 desbloqueo de logro del usuario; 14 deshacer logro del usuario; 15 depósito; 16 retirada; 17 venta de tomates; 20 objeto de recompensa; 21 deshacer recompensa; 23 síntesis; 24 caja de botín; 25 intereses ATM; 26 cambio de tomates por objeto; 27 intereses de crédito; 28 API; 29 cambio de existencias por efecto de objeto. Los clientes deben conservar códigos futuros desconocidos.

## Registros de pasos :id=get-step-records

`GET /step_records` devuelve `StepRecord[]`. Los valores y límites de paginación y las reglas de omisión de intervalos del SDK coinciden con `/inventory_records`. El filtro temporal válido es inclusivo sobre `date`; orden `date DESC` sin clave secundaria explícita.

```json
{"code":200,"message":"success","data":[{"id":1,"date":1700000000000,"dailyStepCount":5000,"totalStepCount":120000,"isGotReward":true,"isUserInput":false,"rewardLevel":1}]}
```

### StepRecord :id=model-step-record

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `id` | integer o null | ID del registro. |
| `date` | integer o null | Fecha registrada en milisegundos Unix. |
| `dailyStepCount` | integer | Pasos diarios. |
| `totalStepCount` | integer | Pasos acumulados guardados. |
| `isGotReward` | boolean | Indicador de recompensa reclamada. |
| `isUserInput` | boolean | Indicador de entrada del usuario. |
| `rewardLevel` | integer o null | Nivel de recompensa guardado. |

## Definiciones de niveles :id=get-level-defines

`GET /level_defines` devuelve un único objeto `LevelDefines`. Sin parámetros. Usa definiciones personalizadas si el modo de niveles personalizados está activo; en otro caso, las integradas.

```json
{"code":200,"message":"success","data":{"custom":true,"levels":[{"id":1,"levelStart":1,"levelEnd":10,"perLevelExp":100}]}}
```

### LevelDefines :id=model-level-defines

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `custom` | boolean | Modo de niveles personalizados. |
| `levels` | LevelDefine[] | Intervalos de niveles. |

### LevelDefine :id=model-level-define

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `id` | integer o null | ID de la definición. |
| `levelStart` | integer | Nivel inicial. |
| `levelEnd` | integer | Nivel final. |
| `perLevelExp` | integer | EXP necesaria por nivel en el intervalo. |

El JSON de niveles mal formado se convierte actualmente en un array `levels` vacío, sin hacer fallar toda la solicitud.

## Estadísticas :id=get-statistics

`GET /statistics` devuelve un objeto `Statistics`. Los opcionales `time_range_start` y `time_range_end` usan milisegundos Unix y la misma regla del SDK: ambos válidos e inicio < fin; si no, no se envía intervalo. Sin intervalo, la App usa desde su primera marca registrada hasta ahora; si no existe, los últimos 30 días. `usingDays` y `companionDays` son valores de toda la vida incluso con intervalo. Las demás métricas se calculan con sus respectivos métodos estadísticos; no supongas que todas las consultas subyacentes comparten idénticas reglas de inclusión de extremos.

```json
{"code":200,"message":"success","data":{"start":1700000000000,"end":1700086400000,"tomatoes":4,"pomodoroMinutes":100,"focusCount":4,"tasksCompleted":3,"tasksTotal":4,"taskCompleteRate":0.75,"feelingsCount":1,"usingDays":30,"companionDays":32,"interestChanged":2,"coinPurchaseConsumed":10}}
```

### Statistics :id=model-statistics

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `start` | integer o null | Inicio efectivo del intervalo en milisegundos Unix. |
| `end` | integer o null | Fin efectivo del intervalo en milisegundos Unix. |
| `tomatoes` | integer | Estadística de tomates ganados. |
| `pomodoroMinutes` | integer | Duración de concentración en minutos. |
| `focusCount` | integer | Número de sesiones de concentración. |
| `tasksCompleted` | integer | Tareas completadas usadas en la estadística de finalización. |
| `tasksTotal` | integer | Total de tareas usado en esa estadística. |
| `taskCompleteRate` | number | Proporción de finalización. |
| `feelingsCount` | integer | Número de sentimientos. |
| `usingDays` | integer | Días de uso desde el inicio. |
| `companionDays` | integer | Días de compañía desde el inicio. |
| `interestChanged` | integer | Estadística del cambio de monedas por intereses. |
| `coinPurchaseConsumed` | integer | Estadística del consumo de monedas en compras. |

## Información de la App y saldo de monedas :id=get-info

`GET /info` devuelve `Info`. LifeUp Cloud añade su versión instalada a la información de la App/proveedor. Sin parámetros.

```json
{"code":200,"message":"success","data":{"appVersion":1,"appVersionName":"example","apiVersion":1,"cloudVersion":1,"cloudVersionName":"example"}}
```

### Info :id=model-info

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `appVersion` | integer | Código de la versión instalada de LifeUp. |
| `appVersionName` | string | Nombre de la versión instalada de LifeUp. |
| `apiVersion` | integer | Versión de la API de LifeUp. |
| `cloudVersion` | integer | Código de la versión instalada de LifeUp Cloud. |
| `cloudVersionName` | string | Nombre de la versión instalada de LifeUp Cloud. |

### GET /coin :id=get-coin

Invoca `lifeup://api/query?key=coin` mediante el ContentProvider y devuelve su objeto resultado. Sin parámetros. Un resultado null se convierte en objeto vacío. Los campos los define el proveedor, no una respuesta tipada `CoinData`. Una consulta correcta proporciona `value` (saldo entero de 64 bits con signo) y `api_result: true`; los fallos pueden incluir los campos de estado/error descritos abajo.

```json
{"code":200,"message":"success","data":{"value":50,"api_result":true}}
```

## Invocar una API de esquema URL :id=invoke-api

El [catálogo de API de esquemas URL](/guide/api) define nombres de métodos, parámetros y resultados específicos. El puente HTTP acepta la URL completa `lifeup://api/...`.

| Transporte | Entrada | Ejecución y respuesta |
| --- | --- | --- |
| `GET /api` | Parámetro repetido `url` codificado como URL | Inicia una actividad Android por URL en el orden indicado. Devuelve la cadena `success`. Sin URL también devuelve éxito. |
| `POST /api` | JSON `RawQueryVo` | Inicia primero cada entrada de `urls` y luego `url`, si existe. Devuelve la cadena `success`. Un objeto vacío también tiene éxito. |
| `GET /api/contentprovider` | Parámetro repetido `url` codificado como URL | Llama al proveedor síncronamente y devuelve `CallUrlResult[]` en el orden indicado. Sin URL devuelve un contenedor de error (`No url found`). |
| `POST /api/contentprovider` | JSON `RawQueryVo` | Llama primero a cada entrada de `urls` y luego a `url`; devuelve `CallUrlResult[]`. Un objeto vacío devuelve un array vacío. |

Establece `Content-Type: application/json` en los POST JSON. Codifica la URL completa al incluirla en una consulta GET, conservando `&`, `?`, `+` y codificación porcentual internos. Una respuesta correcta del puente de actividades confirma el envío, no que la acción de LifeUp haya terminado. Los métodos ContentProvider requieren permiso de Cloud en LifeUp y dependen del método del esquema URL. Las llamadas son secuenciales; si una posterior lanza una excepción, no se revierten efectos anteriores.

```json
{"urls":["lifeup://api/query?key=coin"],"url":"lifeup://api/query?key=atm"}
```

Respuesta del puente de actividades:

```json
{"code":200,"message":"success","data":"success"}
```

Respuesta del puente del proveedor (resultado ilustrativo):

```json
{"code":200,"message":"success","data":[{"url":"lifeup://api/query?key=coin","result":{"value":50,"api_result":true}},{"url":"lifeup://api/query?key=atm","result":{"value":100,"api_result":true}}]}
```

### RawQueryVo :id=model-raw-query

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `url` | string o null | URL individual opcional. |
| `urls` | string[] o null | Lista opcional de URL; se procesa antes de `url`. |

### CallUrlResult :id=model-call-url-result

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `url` | string | URL enviada. |
| `result` | object o null | Bundle del proveedor convertido; null por sí solo no hace fallar el contenedor HTTP. |

La conversión de Bundle conserva valores Int/Long/Double/String/Boolean y Bundles anidados. Los arrays se convierten en arrays de cadenas. Los demás tipos se convierten mediante `toString()` (incluido null de Bundle, que se vuelve la cadena `"null"`). Comprueba los campos de fallo dentro de `result` incluso con código externo 200.

El manejador actual de LifeUp añade `api_result` (boolean) a las llamadas completadas. Un fallo capturado devuelve `api_result: false`, `error_code` (string) y `error_message` (string). Los códigos incluyen `missing_required_parameter`, `invalid_parameter`, `entity_not_found`, `invalid_format`, `unsupported_api`, `cancelled` e `internal_error`; cada método puede añadir otros. Durante la restauración, el proveedor puede devolver `error_code: "503"` y `error_message` sin `api_result`. Si falta un manejador API, puede lanzar antes de esta conversión y producir un error externo del puente.

## Leer y subir archivos :id=files-download

### GET /files/{url} :id=files-get

Codifica la URI legible completa como un segmento de ruta. Lee bytes mediante el resolvedor de contenido de Android, normalmente iconos, adjuntos de sentimientos, exportaciones o archivos subidos. Devuelve un flujo de bytes, no un contenedor JSON de éxito. No especifica nombre de archivo ni tipo MIME. Los flujos vacíos/ilegibles no se convierten en un resultado estructurado de no encontrado; las excepciones usan el manejador HTTP 500 global. Un parámetro coincidente vacío produce un contenedor de error (`url is required`).

```bash
curl "$BASE/files/content%3A%2F%2Fexample.provider%2Fimages%2F1" -o image.bin
```

### POST /files/upload :id=files-upload

Envía `multipart/form-data`. Acepta cada parte de archivo independientemente del nombre de campo; ignora las demás partes. Usa el nombre original para el archivo en caché; si falta, Cloud elige `uploaded_image_<time>.jpg`. Devuelve un array de URI de contenido legibles. La subida proporciona una URI para llamadas posteriores; no adjunta automáticamente el archivo a objetos o tareas. Sin archivos devuelve un contenedor de error con `No files received`.

```bash
curl -X POST "$BASE/files/upload" -F 'file=@image.png'
```

```json
{"code":200,"message":"success","data":["content://example.fileprovider/cache/image.png"]}
```

## Exportar e importar copias de seguridad :id=files-backup

### GET /data/export :id=files-export

Inicia la creación de copia mediante el proveedor. `withMedia` es opcional, por defecto `true`; si se indica, `true` sin distinguir mayúsculas significa verdadero y cualquier otro valor falso. Devuelve el Bundle convertido, actualmente con `backup_file_uri`; descarga esa URI mediante `/files/{url}`. Crea una exportación aunque use GET. Puede incluir campos de estado/error del proveedor que deben comprobarse. Un `backup_file_uri` vacío indica que no se produjo un archivo utilizable. Un resultado null se convierte en error.

```json
{"code":200,"message":"success","data":{"backup_file_uri":"content://example.provider/backup/LifeUpExportBackup.zip","api_result":true}}
```

### POST /data/import :id=files-import

Envía `multipart/form-data` con una copia de seguridad. Si hay varias partes de archivo, prevalece la última; no se comprueba su nombre de campo. El nombre predeterminado es `backup.lfbak`. Lee el campo opcional `description`, pero no tiene efecto. Cloud almacena el archivo e inicia la actividad de copia de LifeUp; la respuesta confirma la subida y el inicio, **no la restauración completada**. Sin archivo devuelve `No file received`.

```bash
curl -X POST "$BASE/data/import" -F 'file=@backup.lfbak'
```

```json
{"code":200,"message":"success","data":"File uploaded and BackupActivity launched"}
```

## Eventos :id=get-events

### GET /events :id=get-events-poll

Devuelve `EventsPage`. `after` es un cursor exclusivo de ID de evento (entero de 64 bits, por defecto 0). `limit` es entero, por defecto 50, limitado a 1–200. Los valores no enteros usan los predeterminados. Devuelve primero los más antiguos del búfer conservado, con `id > after`. Conserva como máximo 200 eventos en memoria; descarta los anteriores y reinicia los ID al reiniciar el proceso. `latestId` es el último ID global, no necesariamente el último de una página limitada. Continúa desde el último evento realmente procesado para no saltar pendientes. Sin historial duradero ni confirmación de entrega.

```json
{"code":200,"message":"success","data":{"latestId":2,"eventWs":true,"events":[{"id":1,"time":1700000000000,"action":"app.lifeup.task.complete","extras":{"id":"42"}}],"broadcasts":true}}
```

### EventsPage :id=model-events-page

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `latestId` | integer | ID del evento más reciente actual. |
| `eventWs` | boolean | Configuración de WebSocket de Cloud. |
| `events` | CloudEvent[] | Eventos conservados después del cursor. |
| `broadcasts` | boolean o null | Si las difusiones de LifeUp están activadas; null significa desconocido o no compatible. El estado se almacena en caché cinco segundos. |

### CloudEvent :id=model-cloud-event

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `id` | integer | ID de secuencia del evento en memoria. |
| `time` | integer | Recepción en Cloud en milisegundos Unix. |
| `action` | string | Acción de difusión de Android. |
| `extras` | objeto de valores de cadena | Extras de difusión convertidos con `toString()`; null se convierte en cadena vacía. Las claves dependen de la acción. |

### WebSocket /events :id=get-events-websocket

Si `eventWs` es true, conecta a `ws://HOST:PORT/events?after=ID` y proporciona el token configurado. El servidor reproduce eventos conservados posteriores a `after` y después envía eventos en directo como tramas de texto JSON `CloudEvent` individuales, **sin** contenedor HTTP. La reproducción se limita al búfer de 200 eventos; no hay parámetro WebSocket `limit`. Envía tramas Ping cada 30 segundos. Reconecta con el último ID realmente procesado. Si está desactivado, la ruta WebSocket no se registra; el sondeo HTTP sigue disponible.

```json
{"id":2,"time":1700000001000,"action":"app.lifeup.item.use","extras":{"id":"3"}}
```

Las suscripciones de acciones compatibles son `app.lifeup.task.complete`, `app.lifeup.task.overdue`, `app.lifeup.task.giveup`, `app.lifeup.achievement.unlock`, `app.lifeup.achievement.condition.unlock`, `app.lifeup.item.purchase`, `app.lifeup.item.reward`, `app.lifeup.item.use`, `app.lifeup.synthesis.complete`, `app.lifeup.pomodoro.start`, `app.lifeup.pomodoro.pause`, `app.lifeup.pomodoro.complete`, `app.lifeup.pomodoro.stop`, `app.lifeup.feelings.add`, `app.lifeup.level.up`, `app.lifeup.level.down`, `app.lifeup.item.countdown.start`, `app.lifeup.item.countdown.complete`, `app.lifeup.item.countdown.stop`, `app.lifeup.timing.start`, `app.lifeup.timing.complete`, `app.lifeup.timing.pause`, y `app.lifeup.timing.abandon`. La recopilación requiere difusiones de LifeUp activadas. El sondeo `/events` comprueba el ajuste, sin activarlo automáticamente.
