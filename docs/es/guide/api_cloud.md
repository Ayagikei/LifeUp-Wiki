<h1 align="center" padding="100">LifeUp Cloud ☁️</h1>

<p align="center">
 <img src="guide/_media/api/cloud.png" />
</p>

LifeUp Cloud es uno de los kits de herramientas API principales de LifeUp. Convierte tu teléfono en un **puente API**: controla LifeUp desde tu **ordenador u otros dispositivos**, crea **integraciones personalizadas** (escritorio, web, scripts de automatización) o combínalo con **agentes de IA**.

### Escenarios habituales

| Escenario | Para quién | En una frase | Más información |
| --- | --- | --- | --- |
| **HTTP + construye el tuyo** | Desarrolladores, usuarios de automatización | Llama a las API y consulta datos desde Python, apps web o scripts por LAN — no hace falta experiencia en Android | [API HTTP](#http-api-definition), [Escritorio](guide/api_desktop.md) |
| **Escaneo QR** | Fans del check-in en el mundo real | Imprime códigos QR para completar Tareas, iniciar temporizadores, abrir diálogos o lanzar páginas web / otras apps | [Escaneo de códigos QR](#qr-code-scanning) |
| **Atajos de inicio / parada** | Automatización, NFC, Tasker | `lifeupcloud://start` y `lifeupcloud://stop` abren Cloud e inician o detienen el servidor HTTP | [Inicio y parada](#cloud-scheme) |
| **Agente IA + MCP** | Cursor, Claude, etc. | Un prompt para crear listas de Tareas, Objetos de la Tienda, Logros y más | [MCP & Skills](guide/api_mcp.md) |
> **Ejemplo de prompt para IA:** Borra las Tareas y Objetos de ejemplo de la Tienda, luego crea una configuración completa de desarrollador indie: listas de Tareas, Atributos, Objetos de la Tienda y Logros.

<br/>

## Descarga

- Si usas la versión de membresía de China continental, encontrarás la entrada de descarga de LifeUp Cloud en `Sidebar` → `Settings` → `Experiments`.
- [Google Play Store](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http)

<br/>


## Iniciar y detener el servicio Cloud :id=cloud-scheme

Puedes iniciar o detener el servidor HTTP sin pulsar **Start Service**, usando estos esquemas de URL:

```txt
lifeupcloud://start
lifeupcloud://stop
```

Abrir cualquiera de las URLs lanza LifeUp Cloud y aplica la acción. Úsalas como acceso directo en la pantalla de inicio, etiqueta NFC, acción de Tasker/automatización, o:

```txt
adb shell am start -a android.intent.action.VIEW -d lifeupcloud://start
```

Las mismas URLs aparecen en la tarjeta de estado de Cloud — tócalas para copiar.

> [!NOTE]
> `lifeupcloud://` controla el propio servidor HTTP de Cloud. No es una API de juego `lifeup://api/…`.

<br/>

## Escaneo de códigos QR :id=qr-code-scanning

El botón **Scan** en la parte superior de LifeUp Cloud lee la URL codificada en un código QR y la abre al instante — sin entrada manual.

El escaneo **no se limita a las API de LifeUp**: `lifeup://api/…`, páginas web `https://…` y esquemas de URL de otras apps (p. ej. `weixin://`) también funcionan — Android abre el destino correspondiente.

### Cómo usarlo

1. Elige una URL de LifeUp o de la [lista de API](guide/api.md) del wiki (completar una Tarea, iniciar un pomodoro, abrir diálogos de compra/uso u abrir una página web externa).

2. Genera un código QR con la URL completa (imprímelo y pégalo en un escritorio, pared o dispositivo).

3. Abre LifeUp Cloud, toca **Scan** (toca **?** junto a él para una guía breve en la app) y apunta al código.

### Qué puedes hacer

| Escenario | Ejemplo (ilustrativo) |
| --- | --- |
| Check-in Pomodoro | `lifeup://api/pomodoro?...` iniciar/detener temporizador |
| Check-in de Tarea | `lifeup://api/complete?name=...` completar una Tarea |
| Interacción con la Tienda | `lifeup://api/goto?page=shop` o diálogos de compra/uso |
| Recompensa / penalización | `lifeup://api/reward?...` / `lifeup://api/penalty?...` |
| Minijuego web | `https://wiki.lifeupapp.fun/en/example/wordle/index.html` |
| Otras apps | `weixin://`, `intent://` o el esquema de cualquier app instalada |
| Flujos personalizados | Cualquier combinación de URL escaneable |

### Interacción en el mundo real

Los códigos QR vinculan **lugares o acciones físicas** con la gamificación en la app:

- Pegatina en **equipo de gimnasio** → escanear para completar una Tarea de entrenamiento de fuerza

- Pegatina en **escritorio de estudio** → escanear para iniciar un pomodoro de Enfoque

- Pegatina en **puesto de trabajo** → escanear para registrar stand-up o revisión de código

- Pegatina en **tablón de eventos** → escanear para reclamar una Recompensa o abrir un Logro

En resumen: **convierte los URL Schemes en disparadores físicos escaneables**, con LifeUp Cloud como ejecutor entre la app y el mundo real.

<br/>

> [!NOTE]
> LifeUp Cloud es un puente HTTP solo en LAN. Cómo llegar a tu teléfono — dirección IP, router, firewall, misma subred, VPN o aislamiento AP — depende de tu red doméstica. Si no puedes conectar, no podemos depurar tu LAN personal. Revisa tu propia red, usa herramientas de red estándar o pide ayuda a un agente de IA.

## Definición de la API HTTP :id=http-api-definition

> [!WARNING]
> La documentación de API de esta página puede ir por detrás de las actualizaciones de implementación. Usa el código fuente como referencia final: [KtorService.kt](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt)

### 1. API de invocación por URL Scheme

#### GET

Función:

> Invoca API que empiezan por `lifeup://api`.

URL de petición:

```txt
// Recomendado: modo content provider (mejor compatibilidad)
http://{host:port}/api/contentprovider

// modo startActivity (algunos dispositivos pueden bloquear la UI en segundo plano)
http://{host:port}/api
```

**Método: `GET`**

**Parámetros de consulta:**

| Campo | Descripción | Ubicación | Tipo | Obligatorio | Notas |
| --- | --- | --- | --- | --- | --- |
| url | URL de API que empieza por `lifeup://api` | Query | string | Sí | Codifica la URL al construirla manualmente. Se admiten varios parámetros `url`. |

**Ejemplos de petición:**

```txt
// Llamada única (content provider)
http://{host:port}/api/contentprovider?url=YOUR_ENCODED_API_URL

// Llamada por lotes
http://{host:port}/api/contentprovider?url=YOUR_ENCODED_API_URL_1&url=YOUR_ENCODED_API_URL_2

// Llamada única (startActivity)
http://{host:port}/api?url=YOUR_ENCODED_API_URL
```

<br/>

#### POST

Función:

> Invoca API que empiezan por `lifeup://api`.

URL de petición:

```txt
// Recomendado: modo content provider (mejor compatibilidad)
http://{host:port}/api/contentprovider

// modo startActivity (algunos dispositivos pueden bloquear la UI en segundo plano)
http://{host:port}/api
```

**Método: `POST`**

**Parámetros del cuerpo JSON:**

| Campo | Descripción | Ubicación | Tipo | Obligatorio | Notas |
| --- | --- | --- | --- | --- | --- |
| urls | Array de URLs que empiezan por `lifeup://api` | Body | List<string> | Sí | No hace falta codificación URL extra en el cuerpo JSON. |

**Ejemplo de petición:**

```txt
// POST
http://{host:port}/api/contentprovider

// JSON body
{
  "urls": ["lifeup://api/goto?page=lab"]
}
```

<br/>

### 2. API de consulta de datos

> [!NOTE]
> Requisitos:
> 1. LifeUp v1.91+ y la última versión de LifeUp Cloud.
> 2. Concede el permiso **Read LifeUp Data** en LifeUp Cloud.

Función:

> Consulta conjuntos completos de datos de LifeUp, como Tareas y Objetos.

**Endpoints de Tareas**

```txt
// Todas las Tareas
http://{host:port}/tasks

// Tareas en categoría/lista ${id}
http://{host:port}/tasks/${id}

// Historial (admite paginación)
// gid es opcional y puede filtrar todo el historial de una Tarea repetitiva
http://{host:port}/history?offset=${offset}&limit=${limit}&gid=${gid}

// Categorías de Tareas
http://{host:port}/tasks_categories
```

**Endpoints de Objetos**

```txt
// Todos los Objetos
http://{host:port}/items

// Objetos en categoría/lista ${id}
http://{host:port}/items/${id}

// Categorías de Objetos
http://{host:port}/items_categories

// Incluir listas ocultas
http://{host:port}/items_categories?include_hidden=true
```

**Endpoints de Logros**

```txt
// Todos los Logros
http://{host:port}/achievements

// Logros en categoría/lista ${id}
http://{host:port}/achievements/${id}

// Categorías de Logros
http://{host:port}/achievement_categories
```

**Endpoints de Reflexiones**

```txt
// Todas las Reflexiones (admite paginación)
http://{host:port}/feelings?offset=${offset}&limit=${limit}
```

**Endpoints de categorías de Síntesis**

```txt
// Todas las categorías de Síntesis
http://{host:port}/synthesis_categories

// Categorías de Síntesis en lista ${id}
http://{host:port}/synthesis_categories/${id}
```

**Endpoints de recetas de Síntesis**

```txt
// Todas las recetas de Síntesis
http://{host:port}/synthesis

// Recetas de Síntesis en categoría ${id}
http://{host:port}/synthesis/${id}
```

**Endpoints de Atributos**

```txt
// Todos los Atributos
http://{host:port}/skills
```


**Otros**

```txt
// Saldo de monedas
http://{host:port}/coin

// Versiones de LifeUp / Cloud
http://{host:port}/info

// Registros Pomodoro (paginados; rango de tiempo opcional)
http://{host:port}/pomodoro_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}

// Diarios (paginados; rango de tiempo opcional). Filas eliminadas suavemente omitidas.
http://{host:port}/coin_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/inventory_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/exp_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/step_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/level_defines
http://{host:port}/statistics?time_range_start=${ms}&time_range_end=${ms}
// Todos los Logros (implementado; id de categoría opcional)
http://{host:port}/achievements

// Eventos broadcast. LifeUp Labs → Broadcast events está desactivado por defecto; Cloud Advanced puede mostrar el estado y activarlo. GET data.broadcasts es ese interruptor (omitido si no leído). El ajuste WebSocket de Cloud es solo transporte.
http://{host:port}/events?after=${id}&limit=50

// Push WebSocket (activado por defecto; ajuste Cloud WebSocket event push)
ws://{host:port}/events?after=${id}
```

Sobre: `{ code, message, data }`. `200` solo indica OK de transporte. `10001` LifeUp no en ejecución o Read Data no concedido. `10002` consulta ContentProvider fallida.

### Valores de campos de listas

| Endpoint | Campo | Valores |
| --- | --- | --- |
| `/tasks` `/history` | `status` | `0` sin terminar · `1` hecha · `2` vencida · `3` abandonada |
| `/tasks` | `frequency` | `0` una vez · `1` diaria · `N>1` cada N días · `-1` ilimitada · `-3` Ebbinghaus · `-4` mensual · `-5` anual |
| `/tasks` | `weekdays` | `1,3,5` (Lun=1 … Dom=7). Vacío cuando no es modo por días de la semana. v1.106.0+ |
| `/tasks_categories` | `status` | `0` normal · `1` archivada |
| `/tasks_categories` | `type` | `<10` normal · `10` diaria · `11` semanal · `12` mensual · `20` en curso |
| `/achievements` | `status` | `0` bloqueado · `1` desbloqueado, Recompensa sin reclamar · `2` desbloqueado, reclamada |
| `/achievements` | `type` | `0` normal · `1` subcategoría |
| `/achievement_categories` | `type` | `0` usuario · `1` sistema |
| `/feelings` | `type` | `0` Tarea · `1` Logro · `2` crudo · `3` uso de Objeto |
| `/feelings` | `isFav` | bool (CP 0/1) |
| `/skills` | `type` | `0` usuario · `1` fuerza · `2` aprendizaje · `3` encanto · `4` resistencia · `5` vitalidad · `6` creativo |
| `/items_categories` | `hidden` / `inventoryHidden` | `0` visible · `1` oculto (banderas independientes) |
| `/synthesis_categories` | `hidden` | `0` visible · `1` oculto |
| `/pomodoro_records` | `reward` | `0` abandonado · `0.5×n` mitad · si no, múltiplo completo |
| `/coin_records` `/inventory_records` | `resCode` | Tienda: `0` comprar · `1` usar · `2` terminar Tarea · `3` deshacer terminar · `4` borrar · `5` abandonar · `6` vencida · `7` desbloquear Logro · `8` revocar abandonar · `9` revocar vencida · `10` devolver · `11` terminar subtarea · `12` deshacer subtarea · `13` desbloquear Logro de usuario · `14` deshacer Logro de usuario · `15` depositar · `16` retirar · `17` vender tomates · `20` Recompensa Objeto · `21` deshacer Recompensa Objeto · `23` Síntesis · `24` Caja de botín · `25` interés ATM · `26` cambio tomate · `27` interés crédito · `28` API · `29` acción efecto |
| `/exp_records` | `resCode` | Exp (no Tienda `28`): `0` desconocido · `1` terminar · `2` Logro · `3` cambio like · `4` racha diaria · `5` pasos · `6` marcar terminada · `7` revocar abandonar · `8` revocar vencida · `9` comer tomate · `10` Objeto usado · `11` desbloquear Logro de usuario · `12` terminar subtarea · `200` API · `101` deshacer terminar · `102` abandonar · `103` vencida · `104` débito Objeto usado · `105` bloquear Logro de usuario · `106` deshacer subtarea |

`GET /items_categories`, `GET /synthesis_categories` y `GET /skill_groups` aceptan `include_hidden=true` (listas ocultas omitidas por defecto). Condiciones de desbloqueo de Logros: `GET /achievement_conditions/{id}`. `status` de Habilidad (0 normal / 1 oculto) solo en `query`/`query_skill`, **no** en `GET /skills`.

**Método: `GET`**

**Parámetros:**

| Campo | Descripción | Ubicación | Tipo | Obligatorio | Notas |
| --- | --- | --- | --- | --- | --- |
| id | ID de datos | Path/Query | Number | Sí (para endpoints por ID) | - |
| offset | Desplazamiento de consulta | Query | Number | No | Obligatorio solo en algunos endpoints paginados |
| limit | Tamaño de página | Query | Number | No | Obligatorio solo en algunos endpoints paginados |
| gid | Filtrar historial de Tarea repetitiva | Query | Number | No | Opcional para consulta de historial |
| include_hidden | Incluir listas ocultas | Query | Boolean | No | Predeterminado false. Usado por `/items_categories`, `/synthesis_categories`, `/skill_groups` |
| time_range_start | Inicio de rango (ms) | Query | Number | No* | Debe ir emparejado con `time_range_end`. Rango parcial/inválido devuelve `invalid_parameter` |
| time_range_end | Fin de rango (ms) | Query | Number | No* | Debe ser mayor que `time_range_start` |

**Ejemplos de petición**

**Tareas**

```txt
// Todas las Tareas
http://{host:port}/tasks

// Tareas en lista ID 1
http://{host:port}/tasks/1

// Historial (100 registros desde índice 0)
http://{host:port}/history?offset=0&limit=100

// Categorías de Tareas
http://{host:port}/tasks_categories
```

**Objetos**

```txt
// Todos los Objetos
http://{host:port}/items

// Consultar IDs de Objeto específicos 1 y 4
http://{host:port}/items?id=1&id=4

// Objetos en lista ID 1
http://{host:port}/items/1

// Categorías de Objetos
http://{host:port}/items_categories
```

**Logros**

```txt
// Logros en lista/categoría ${id}
http://{host:port}/achievements/${id}

// Categorías de Logros
http://{host:port}/achievement_categories
```

**Reflexiones**

```txt
// 100 registros desde índice 0
http://{host:port}/feelings?offset=0&limit=100
```

**Atributos**

```txt
http://{host:port}/skills
```

**Categorías de Síntesis**

```txt
http://{host:port}/synthesis_categories
http://{host:port}/synthesis_categories/1
```

**Recetas de Síntesis**

```txt
http://{host:port}/synthesis
http://{host:port}/synthesis/1
```

<br/>

### 3. API de imagen/archivo

> [!NOTE]
> Por restricciones de almacenamiento de Android, LifeUp Cloud puede necesitar crear un archivo copiado al servir contenido de imagen desde LifeUp.

Función:

> Carga recursos de imagen/archivo devueltos por las API de datos (típicamente `content://...`).

URL de petición:

```txt
http://{host:port}/files/${url}
```

**Método: `GET`**

**Parámetros de ruta:**

| Campo | Descripción | Ubicación | Tipo | Obligatorio | Notas |
| --- | --- | --- | --- | --- | --- |
| url | URL de archivo | Path | String | Sí | - |

**Ejemplo de petición:**

```txt
http://{host:port}/files/xxx
```

<br/>

### 4. Consultas ContentProvider de Habilidades

> [!NOTE]
> Requiere v1.103.0+

Para consultas de lista o estructuradas, puedes leer las siguientes URI de ContentProvider mediante el endpoint `http://{host:port}/api/contentprovider`.

#### `content://net.sarasarasa.lifeup.provider.api/skills`

Devuelve solo Habilidades visibles.

| Columna | Significado | Tipo | Notas |
| ------ | ------- | ---- | ----- |
| _ID | ID de Habilidad | number | - |
| name | Nombre de Habilidad | string | - |
| desc | Descripción | string | Puede estar vacío |
| icon | URI de icono | string | Puede estar vacío |
| order | Orden bruto | number | `orderInCategory` |
| group_id | ID de grupo de Habilidades | number / null | Puede estar vacío si la Habilidad no está en un grupo |
| color | Color | number / null | Puede estar vacío |
| exp | Puntos de Experiencia | number | - |
| level | Nivel actual | number | - |
| until_next_level_exp | EXP hasta el siguiente Nivel | number | - |
| current_level_exp | EXP ganada en el Nivel actual | number | - |
| type | Tipo de Habilidad | number | - |
| status | Estado de Habilidad | number | `0` = normal, `1` = oculto |

#### `content://net.sarasarasa.lifeup.provider.api/skill_groups`

Devuelve solo grupos de Habilidades visibles.

| Columna | Significado | Tipo | Notas |
| ------ | ------- | ---- | ----- |
| _ID | ID de grupo de Habilidades | number | - |
| content | Nombre del grupo | string | - |
| order | Orden bruto | number | `orderInCategory` |
| collapsed | Estado de colapso | string | Devuelto como texto `true` / `false` |

<br/>

## Contribución

El SDK, LifeUp Cloud y LifeUp Desktop son proyectos de código abierto.

Puedes obtener el código fuente en:

- [Ayagikei/LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop](https://github.com/Ayagikei/LifeUp-Desktop)
