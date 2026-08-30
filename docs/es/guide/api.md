<h1 align="center" padding="100">Interfaz abierta</h1>

<p align="center">¡Crea posibilidades infinitas!</p>

> [!NOTE]
> Estamos desplegando **LifeUp v1.106.0** y **LifeUp Cloud v3.0.0** de forma gradual. Los plazos de revisión varían según la plataforma, por lo que esta documentación puede actualizarse antes de que las apps estén ampliamente disponibles; la fecha real de lanzamiento puede ser posterior a la que aparece aquí.

?> En la versión v1.90, `LifeUp` ha abierto diversas interfaces funcionales, y se da la bienvenida a cualquier integración con aplicaciones externas. <br/>También ofrece el efecto «URL» para los objetos de la Tienda, y los usuarios pueden usar directamente los objetos para llamar a aplicaciones externas o a la interfaz de `LifeUp`. <br/>Estas funciones pueden dar a tu `LifeUp` posibilidades ilimitadas, pero también requieren un poco de comprensión y capacidad práctica.

**Última actualización: 2026/08/28**

Los parámetros y definiciones de la API en este documento se basan en la versión **v1.106.0**.

Asegúrate de que tu aplicación esté actualizada a **v1.106.0** antes de usar la API más reciente.

La actualización se despliega gradualmente a través de Google Play; si aún no la has recibido, ten paciencia, llegará pronto.

## Ejemplo de escenario

| Llamador | Escenario | Notas |
| ------ | -------- | ----- |
|**LifeUp→Otras aplicaciones**<br/>Implementado mediante el efecto «URL» del objeto de la Tienda| **Tras usar el objeto de la Tienda:**<br/>1. Usar un navegador para visitar una página web<br/>2. Saltar a WeChat y escanear, o abrir un miniprograma concreto<br/>3. Añadir automáticamente registros contables ([por ejemplo, «Qianji» admite una interfaz de contabilidad](http://docs.qianjiapp.com/plugin/auto_tasker.html))<br/>4. Guardar la configuración de la herramienta de automatización Tasker (incluso compartirla en el Market) e importar automáticamente la configuración en Tasker tras usarla<br/>5. Activar Tasker para cambiar el fondo de pantalla<br/>6. ... (siempre que la aplicación externa admita este método de llamada) | [Tasker](https://play.google.com/store/apps/details?id=net.dinglisch.android.taskerm&hl=en_US&gl=US) es una herramienta de automatización y admite exportar la configuración como Uri |
|**LifeUp→LifeUp**<br/>Implementado mediante el efecto «URL» del objeto de la Tienda| **Tras usar el objeto de la Tienda:**<br/>1. Abrir una página concreta<br/>2. Aumentar el tipo de interés del cajero automático<br/>3. Mostrar una ventana emergente para que el usuario seleccione el producto y reduzca su precio (cupón de descuento)<br/>4. Activar la finalización de una Tarea<br/>5. Mostrar un mensaje motivacional personalizado<br/>6. Crear una plantilla de Recompensa de Tarea: basta con introducir el nombre para crear una Tarea automáticamente<br/>7. Mostrar una ventana que pida al usuario elegir una rama, creando una pequeña interacción contextual<br/>8. Más operaciones dentro de la App... |  |
|**Aplicaciones externas/páginas web→LifeUp** | **Configurar herramientas de automatización:**<br/>1. Detectar cuándo el teléfono se enciende por primera vez cada día, completar la Tarea de levantarse temprano o activar directamente la penalización por «levantarse tarde»<br/>2. Tras cada 25 palabras, pasar una tarjeta NFC concreta y completar automáticamente la Tarea<br/>3. El GPS detecta que se ha llegado a un lugar nuevo y desbloquea el Logro «lugar nuevo»<br/>4. Al conectarse cada día al Wi-Fi del trabajo, aumenta el progreso de la condición de desbloqueo; tras acumular 20 días, se desbloquea el Logro «Trabajador»<br/>5. Recompensarte con monedas de oro por «llegar a casa» al conectarte por primera vez cada día al Wi-Fi de casa<br/>6. Capturar notificaciones de otras apps de Pomodoro o Enfoque y registrar automáticamente el tiempo en `LifeUp`<br/>7. Capturar la notificación de finalización de software de deporte o estudio y otorgar automáticamente Puntos de Experiencia de «fuerza» y «conocimiento»<br/>8. En el periodo que configures, cada vez que abras el teléfono se activará una penalización<br/>9. ...<br/>**Enlace con aplicaciones externas/aplicación propia:**<br/>1. Si no te convence el Pomodoro de `LifeUp`: puedes desarrollar tu propio software de temporizador, ya sea web o Android, y enlazarlo con «LifeUp» mediante la interfaz para añadir registros de tiempo o Recompensas<br/>2. Modificar algunos minijuegos de inteligencia (como el ejemplo de Wordle más abajo). Al completar el juego con éxito, activar que `LifeUp` envíe Recompensas<br/>3. ... |  |

<br/>En otras palabras, todos los escenarios anteriores son en realidad «eventos» que desencadenan «acciones».

Esta actualización de `LifeUp` proporciona el punto de activación del evento «uso de objetos» y, a continuación, diversas «acciones» (Recompensas, finalización de Tareas, etc.).

Si necesitas

- Hacer clic en un botón web
- Pasar una tarjeta NFC
- Desbloquear la pantalla por primera vez al despertar cada día

Este tipo de eventos requiere la intervención de aplicaciones externas. Por ejemplo, hacer un desarrollo secundario por tu cuenta o usar herramientas de automatización como `Tasker` y `MacroDroid`.

**La actualización LifeUp 1.90.2 añadirá una serie de «eventos», que pueden ser recibidos por herramientas de automatización o aplicaciones externas.**

Se puede usar para lograr:

Tras usar el objeto, activar herramientas de automatización como Tasker para cambiar el fondo del launcher.

Tras completar la Tarea, activar una herramienta de automatización como Tasker para abrir una app.

**En la versión 1.90.2, es posible realizar el «evento de LifeUp» que desencadena la «operación de Tasker».**

Tasker tiene permisos muy amplios: puede cambiar fondos de pantalla, desinstalar apps, subir el volumen, elegir qué app abrir y mucho más. Incluso puedes escribir lógica de interacción de UI sin base en programación.

---

## Recomendaciones

**Si no estás familiarizado con la programación,** puedes buscar e importar objetos especiales de la Tienda directamente en [Mundo] → [Market] → etiqueta [Link]/[API]/[Automate]. También puedes probar a editar los parámetros para adaptarlos a tus necesidades.

**Si dominas informática,** puedes leer la documentación de interfaces que sigue y editar tú mismo el efecto deseado. Úsala junto con software de automatización como [*Tasker*](https://play.google.com/store/apps/details?id=net.dinglisch.android.taskerm). Aunque no edites la configuración de Tasker, si consigues instalarlo, puedes importar configuraciones de automatización compartidas por otros en Market u otras comunidades.

**Si tienes base en programación,** puedes desarrollar páginas web o aplicaciones Android para integrarlas con LifeUp. Esta página y versiones personalizadas de Wordle son algunos ejemplos. También puedes crear y compartir configuraciones de herramientas de automatización.

---

## Llamar a otra aplicación

Si quieres llamar a una aplicación externa en *LifeUp*, solo tienes que añadir un efecto «Link» al objeto de la Tienda, **introducir un enlace web o específico de la aplicación** y usar el objeto para activar la llamada.

**Algunos ejemplos (también puedes ir a «Mundo»→«Market»→«Link» para ver objetos públicos con efecto de llamada a interfaz):**

- Abrir Google en el navegador: https://www.google.com
- Facebook: [fb://](fb://)
- Abrir una app con su nombre de paquete/ID: [market://launch?id=net.sarasarasa.lifeup](market://launch?id=net.sarasarasa.lifeup)
- ...

En teoría, mientras la app externa proporcione la URL, puedes saltar usándola como objeto de la Tienda.

**Puedes buscar el enlace de aplicación que necesites buscando `URL Schemes` en Google.**

**Estos enlaces no tienen relación con `LifeUp`; `LifeUp` solo ofrece la función de salto por URL.**

**Por eso no mantenemos (ni mantendremos) una lista de URLs. Pero puedes ver los objetos públicos de la Tienda con efecto de enlace en la página [Mundo]→[Market]→[Link].**

Puedes encontrar el nombre de paquete de una app (también llamado ID):

- en su URL de Play Store: https://play.google.com/store/apps/details?id=net.sarasarasa.lifeup
- con una app gestora de aplicaciones
- con la acción App Info en Tasker
- con la acción Launch App en Macrodroid

---

## Llamar a las APIs de LifeUp

Si:

- Necesitas llamar a la interfaz de `LifeUp` dentro de `LifeUp`. Solo añade un efecto «link» al objeto de la Tienda, introduce **una URL concreta** según la documentación de las APIs y usa el objeto para completar la llamada.
- Llamas desde una página web, solo tienes que saltar a las APIs de LifeUp mediante un hipervínculo.
- Llamas desde una app que desarrolles tú, usa Intent para saltar al enlace de interfaz correspondiente.
- Llamas desde una herramienta de automatización (como Tasker), rellena el enlace API correspondiente en Browser URL de Tasker.

**Algunos ejemplos:**

Al hacer clic en el enlace siguiente, «LifeUp» mostrará «You have learned to call APIs!».

<a href="lifeup://api/toast?text=You have learned to call APIs!&type=1&isLong=true">lifeup://api/toast?text=You have learned to call APIs!&type=1&isLong=true</a>

Al hacer clic en el enlace siguiente, obtendrás una moneda en «LifeUp», y el motivo será «Learn API Calls».

<a href="lifeup://api/reward?type=coin&content=Learn API Calls&number=1">lifeup://api/reward?type=coin&content=Learn API Calls&number=1</a>

Si copias el enlace al efecto «link» del objeto, usar el objeto también activará el mismo efecto.

**Ejemplo de enlace con aplicación externa:**

[Wordle Clone (lifeupapp.fun)](https://wiki.lifeupapp.fun/en/example/wordle/index.html)

Wordle es un pequeño juego de adivinar palabras: hay que adivinar palabras de 5 letras. Naranja indica que la letra está en la respuesta; verde, que está en la posición correcta.

**Esta versión de Wordle admite enlace con «LifeUp»:**

1. Si aciertas la palabra, obtienes 10 monedas, con un motivo personalizado.
2. Si no aciertas al final, hay un premio de consolación de 1 moneda.

![](_media/api/wordle.png ':size=30%')

<br/>

**Ejemplo de enlace con Tasker:**

> Tasker se invoca seleccionando `Action Category`→`Program`→`Shortcut`. Introduce en la columna de acceso directo el enlace que empieza por lifeup://.

Desbloquear la pantalla por primera vez después de las 5 en punto cada día puede activar la finalización de la Tarea que indiques (por ejemplo, levantarse).

**Nota: Se requiere un Task Group Id para importar esta configuración. Puedes activar [Developer Mode] en [Settings]→[Labs] y consultar el gid en la página de detalles de la Tarea.**

Si tienes Tasker instalado, [haz clic aquí para importar las Tareas configuradas.](taskerproject://H4sIAAAAAAAAAKVWTW/bOBA9p7+CENCeshZlfcWtzMJts0ABY1EkaS49FKxE20xlSZDG3s2/3xmSku1ELer25OF7Q/LNB0fO7mT3XbUfJEjWtXPPY8Vez73AY7Cfe8mETwLuiRcX2ae2XulSGacG7ejKY3s196bEXmR5IUGJIEl4NONxMAvDMPMtaOiyEdDuFGJoEaKON4RRMA2vMl8NG1alXHcCIWsQpAsRIYA/tNrqgosozXxjEFJtlVgAi9mN6hSwu41iH+Rj5hNO/J3eWvl5XZmY6JqNiPGOjVttBcfV1q7AcOA4MBwYLvPpLMqK79IymqHZORk6yUcc8YDPfiEfsyf5SJ7k42/ddsA+V2Wdf1fFJXtfb5tSgWJU9kNqrveqgkNujmSj7rpAXZxj9MY08ZsNxrwFlNhvDca2JvFh50X2vq4KDbqulrqzV+qVdT/i7HlOSOjoi6zcdOJlpf4tqKy0cHjdiGCa+XXTAy1ymd/2Hpk/nGxF+CcqbEgmkJGaPqgc+po+8B+VNJmm05TPro5LWklM71Kv1OeGyR3ULHfZx8RLl/lGFx229SVV0tgEggGTS2pvsKBRRVLIpuIZSYBGlJyKQRlREiVpMEvO6C9qpmRopqbVVHKUhAYBi3woi8zBZSE9LnNMERzKfAut9W7XhzIOtUPWun10bYdu1DuynHvc859x059w4SmX+VbriOxgRHaY8mPZnRIrWXZYoc4h73ZV4R61icV11D16GRDvHvqzUjApdLUudZdvJrIq2loXEzATdnJzvby+X/xz9/V+cfNx8W55fStelfAGU4E7Fm0rH+0A9l+t4Q12yJln/Z6Ev+CxUeLL8kHu5aSU1Xpi9ZwvwJ7knhtlx700m79nTREMTVHiA9k1r31fNtrvX8jbtS7mL+myr2gNDXNSXPdM72Wr5bd+7u77yZ6XSrb1Dvp6DmvDqv+augWsHY6Jg20ovd3ugA7sdx4Awzf7XLtvmTEdWAhaF8OyEp/wxk4xXTU7YIBfIwqHrVFEwygm4+Tc8d0FVwTp4QQNAgwCPVKJo4zQ0uHO0fl1cBy2W5ncPUmYmSo0Sp6PlHRspHAeh/zHIyXk6TR+OlLSPxsp6W+MlNEmC8Znzhlz5YSLfsLFjgtHuMRxwbNZ1VfC/to/ZOLF/9uCy6GeCQAA)

![](_media/api/tasker_01.png ':size=30%')

![](_media/api/tasker_02.png ':size=30%')

<br/>

**Cómo usar MacroDroid para llamar a las APIs de LifeUp:**

> [MacroDroid](https://play.google.com/store/apps/details?id=com.arlosoft.macrodroid&hl=en_US&gl=US) también es una herramienta de automatización; es gratuita y su interfaz es más sencilla.

1. Añade macros y configura las condiciones que necesites (o hazlo más tarde)
2. Añade `Actions`
3. Selecciona `Applications`
4. Selecciona `Open Website`
5. Introduce una URL que empiece por `lifeup://` en el campo `Enter URL`
6. **[Desmarca]** todas las opciones inferiores, como `URL encode parameters`...
7. Guárdalo; puedes pulsar la acción y elegir `Test action` para comprobarlo

<br/>

**Con esta función puedes ampliar sin límite las posibilidades de LifeUp, ¡tengas o no conocimientos de programación!**

Consulta más abajo las reglas concretas de llamada.

---

## Documentación de interfaces

### Basics - Examples

| Tipo             | Descripción   |
| ---------------- | ------------- |
| Ejemplo          | <a href="lifeup://api/toast?text=You learned to call! &type=1&isLong=true">lifeup://api/toast?text=You learned to call! &type=1&isLong=true</a> |
| Formato de interfaz | fixed prefix/method name?parameter1=value1&parameter2=value2 |
| Prefijo fijo     | lifeup://api/ |
| Nombre del método | toast         |
| Parámetros       | ?text=You learned to call! &type=1&isLong=true |

<br/>

### Basics - Escaping (URL Encode)

Si el valor de tu parámetro contiene símbolos especiales como +, espacio, =, %, &, #, etc., hay que escaparlos:

| Caracteres especiales | Significado                                         | Sustituir por |
| :----------------- | :---------------------------------------------- | :--------- |
| +                  | El signo + en la URL representa un espacio        | +          |
| espacios             | Los espacios en URLs pueden ser + o codificados              | %20        |
| /                  | Separa directorio y subdirectorio            | %2F        |
| ?                  | Separa la URL real y los parámetros         | %3F        |
| %                  | Especifica caracteres especiales                      | %          |
| #                  | Indica marcador                                  | %23        |
| &                  | Separador entre parámetros en la URL   | %26        |
| =                  | Valor del parámetro indicado en la URL | %3D        |

Tomando como ejemplo la interfaz del mensaje emergente anterior: si quieres que el texto final mostrado sea `You have learned to call APIs!`,
hay que sustituir los espacios por +; el resultado final es:

<a href="lifeup://api/toast?text=You learned to call! &type=1&isLong=true">lifeup://api/toast?text=You learned to call! &type=1&isLong=true</a>
<br/>

**Esta es una herramienta sencilla de codificación implementada en Javascript:**

<iframe src="guide/html/url_encoded.html" frameborder="0" scrolling="no" width="90%"> </iframe>

<br/>

### Basics - LifeUp Data ID

Casi todos los datos almacenados en LifeUp tienen un id único.

Algunas de las interfaces siguientes admiten modificar objetos de la Tienda **concretos** y completar Tareas **concretas**.

Para que `LifeUp` encuentre los datos correspondientes, debes proporcionarle un id.

**Puedes activar «Settings» → «Labs» → «Developer Mode» para ver el id original de los datos en cada página de detalles de la App.**

Por ejemplo, si el nombre del Atributo se muestra como «strength (1)», su id de Atributo es 1.

#### Task id

Se puede ver en la página de detalles del evento.

id: Si es una Tarea repetitiva, el id se actualiza en cada repetición.

gid: El id del grupo de elementos. Para la misma Tarea repetitiva, su gid no cambia.

#### List id

Tras activar «Developer Mode», consúltalo en la ventana emergente «Select List».

#### Attribute id

Tras activar «Developer Mode», consúltalo en la página «Custom Attributes».

#### Shop item id

Tras activar «Developer Mode», pulsa el objeto de la Tienda para ver los detalles.

#### Achievement condition id

Tras personalizar la condición de desbloqueo del Logro «requires an external API call to unlock», puedes ver el id de la condición en la página de detalles.

<br/>

### Basics - Name Matching

Cuando una API admite buscar Tareas, objetos de la Tienda o subtareas por nombre, LifeUp intenta primero una coincidencia exacta ignorando mayúsculas y minúsculas. Si no hay coincidencia exacta, pasa a coincidencia difusa por contención.

Por ejemplo, si existen «Coin» y «Coin Box», pasar `name=Coin` coincide primero con «Coin» en lugar del primer resultado difuso que aparezca.

Si nombres duplicados o similares pueden ser ambiguos, es preferible pasar el id correspondiente.

<br/>

### Basics - Return Values

Algunas interfaces pueden devolver valores.

**Si desarrollas una aplicación Android,** puedes usar el método `onActivityResult` para recibir el valor devuelto.

**Si usas una aplicación de automatización como Tasker:**

En general, estas aplicaciones no pueden recibir valores devueltos de tipo Activity. Hay que añadir un parámetro `broadcast` y usar el evento `received intent` para recibir el valor devuelto.

Para más detalles, consulta los parámetros broadcast más abajo.

<br/>

### Basics - JSON Data Structure

?> Requiere v1.98.0+

Esta sección presenta las estructuras JSON de uso frecuente en la API.

#### 1. Estructura de Recompensa de Objetos

Un array JSON que especifica Recompensas de Objetos; cada elemento contiene un ID y una cantidad.

```json
[
    {
        "item_id": 1,    // Item ID
        "amount": 2      // Quantity
    },
    {
        "item_id": 2,
        "amount": 3
    }
]
```

#### 2. Estructura de condición de desbloqueo de Logros

```json
[
    {
        "type": 7,           // Condition type
        "related_id": null,  // Related ID (some types must provide)
        "target": 1000000    // Target value
    }
]
```

#### 3. Estructura de límite de compra

`purchase_limit` es un array JSON. Cada objeto representa una regla de restricción.

| Campo | Significado | Tipo | Obligatorio | Notas |
| ----- | ------- | ---- | -------- | ----- |
| limitType | Tipo de restricción | number | Sí | Ver la tabla de tipos más abajo |
| limitNumber | Valor numérico principal | number | No* | Usado por reglas basadas en cantidad/rango |
| maxNumber | Límite superior de un rango | number | No | Usado por rango de Nivel de Atributo / cantidad de Objetos en posesión |
| limitId | ID del objetivo relacionado | number | No* | Obligatorio para reglas basadas en Atributo / Objeto / Tarea / ciclo de Tarea / Logro |
| extendInfo | Datos adicionales | string | No | Usado por reglas basadas en tiempo; el valor en sí es una cadena JSON |

**Definición de tipos**

| limitType | Significado | Campos obligatorios / notas |
| --------- | ------- | ----------------------- |
| 0 | Límite diario de cantidad | `limitNumber`: máximo de veces al día |
| 1 | Límite semanal de cantidad | `limitNumber`: máximo de veces a la semana |
| 2 | Límite mensual de cantidad | `limitNumber`: máximo de veces al mes |
| 3 | Límite anual de cantidad | `limitNumber`: máximo de veces al año |
| 10 | Regla de Nivel de Atributo | `limitId`: ID de Atributo<br/>`limitNumber`: nivel mínimo<br/>`maxNumber`: nivel máximo opcional |
| 20 | Rango horario diario | `extendInfo`: `{"startMinuteOfDay":540,"endMinuteOfDay":1320}` |
| 21 | Selección de días laborables | `extendInfo`: `{"weekdays":[1,2,3,4,5]}`<br/>Lunes = 1, domingo = 7 |
| 22 | Rango horario absoluto | `extendInfo`: `{"startMillis":1710000000000,"endMillis":1710086400000}` |
| 23 | Selección de meses | `extendInfo`: `{"months":[1,6,12]}` |
| 24 | Selección de día del mes | `extendInfo`: `{"daysOfMonth":[1,15,31]}` |
| 30 | Regla de cantidad de Objetos en posesión | `limitId`: ID del Objeto objetivo<br/>`limitNumber`: cantidad mínima en posesión<br/>`maxNumber`: cantidad máxima en posesión opcional |
| 31 | Regla de Tarea completada | `limitId`: ID de Tarea |
| 32 | Regla de Logro desbloqueado | `limitId`: ID de Logro |
| 33 | Regla de ciclo de Tarea completado | `limitId`: ID del grupo de Tareas repetitivas (`groupId`)<br/>Se valida contra el último ciclo iniciado en ese grupo |

**Notas**

- Cuando `limitType=33`, `limitId` no es un ID de Tarea. Debe ser el `groupId` de la Tarea repetitiva.

- Las cargas compatibles con versiones anteriores pueden omitir `maxNumber` y `extendInfo`.
- `extendInfo` es un campo de tipo string; al llamar a la API mediante URL, la cadena JSON interna suele necesitar otra capa de escape/codificación.

**Ejemplo:**

```json
[
    {
        "limitType": 0,
        "limitNumber": 5
    },
    {
        "limitType": 10,
        "limitId": 1,
        "limitNumber": 5,
        "maxNumber": 10
    }
]
```

#### 4. Estructura de efecto de Objeto

```json
[
    {
        "type": 2,           // Effect type
        "info": {            // Effect parameters, different for different types
            "min": 100,      // Minimum value (used for gold rewards, etc.)
            "max": 200       // Maximum value (used for gold rewards, etc.)
        }
    }
]
```

#### Descripción de tipos de efecto

?> Los tipos 10-16 están disponibles desde v1.102.0+.

| Código de tipo | Significado | Descripción de parámetros |
| ------- | ---- | ------- |
| 0 | Sin efecto especial | Sin parámetros |
| 1 | No utilizable | Sin parámetros |
| 2 | Añadir monedas | min: Monedas mínimas<br/>max: Monedas máximas (opcional, por defecto min)<br/>using_limit: Si aplicar límites del sistema (opcional) |
| 3 | Quitar monedas | min: Monedas mínimas<br/>max: Monedas máximas (opcional, por defecto min)<br/>using_limit: Si aplicar límites del sistema (opcional) |
| 4 | Añadir experiencia | ids: Array de ID de Habilidad<br/>value: Valor de experiencia (legacy, igual que min)<br/>min: Experiencia mínima (opcional, si no se indica value)<br/>max: Experiencia máxima (opcional, por defecto min/value)<br/>using_limit: Si usar límite (opcional, false por defecto) |
| 5 | Quitar experiencia | ids: Array de ID de Habilidad<br/>value: Valor de experiencia (legacy, igual que min)<br/>min: Experiencia mínima (opcional, si no se indica value)<br/>max: Experiencia máxima (opcional, por defecto min/value)<br/>using_limit: Si usar límite (opcional, false por defecto) |
| 6 | Síntesis simple | require_number: Cantidad requerida<br/>item_id: ID de Objeto |
| 7 | Abrir caja | items: Array de Objetos; cada elemento contiene:<br/>- item_id: ID de Objeto<br/>- amount: Cantidad<br/>- probability: Probabilidad<br/>- is_fixed_reward: Si es Recompensa fija |
| 8 | Cuenta atrás | seconds: Segundos de cuenta atrás |
| 9 | Enlace web | url: Dirección del enlace<br/>use_web_view: Si usar el navegador integrado (opcional, false por defecto) |
| 10 | Registrar Reflexión | Sin parámetros |
| 11 | Cambiar monedas (aumentar o disminuir) | min: Monedas mínimas (puede ser negativo)<br/>max: Monedas máximas (opcional, por defecto min)<br/>using_limit: Si aplicar límites del sistema (opcional) |
| 12 | Cambiar experiencia (aumentar o disminuir) | ids: Array de ID de Habilidad<br/>value: Valor de experiencia (legacy, igual que min)<br/>min: Experiencia mínima (puede ser negativa)<br/>max: Experiencia máxima (opcional, por defecto min/value)<br/>using_limit: Si usar límite (opcional, false por defecto) |
| 13 | Añadir stock de Objeto | item_id: ID del Objeto objetivo<br/>min: Cambio mínimo de stock<br/>max: Cambio máximo de stock (opcional, por defecto min)<br/>using_limit: Si aplicar límites de stock (opcional) |
| 14 | Quitar stock de Objeto | item_id: ID del Objeto objetivo<br/>min: Cambio mínimo de stock<br/>max: Cambio máximo de stock (opcional, por defecto min)<br/>using_limit: Si aplicar límites de stock (opcional) |
| 15 | Cambiar stock de Objeto (aumentar o disminuir) | item_id: ID del Objeto objetivo<br/>min: Cambio mínimo de stock (puede ser negativo)<br/>max: Cambio máximo de stock (opcional, por defecto min)<br/>using_limit: Si aplicar límites de stock (opcional) |
| 16 | Reproducir sonido | file_name: Nombre del archivo de sonido local (preferido)<br/>uri: URI del sonido a importar (alternativa a file_name)<br/>display_name: Nombre visible (opcional) |

**Ejemplos de efecto:**

Aumentar oro aleatorio:

```json
{
    "type": 2,
    "info": {
        "min": 100,
        "max": 200
    }
}
```

Aumentar Puntos de Experiencia:

```json
{
    "type": 4,
    "info": {
        "ids": [1, 2],
        "value": 50,
        "using_limit": false
    }
}
```

Cambiar monedas (aleatorio +/-):

```json
{
    "type": 11,
    "info": {
        "min": -10,
        "max": 20
    }
}
```

Cambiar stock de Objeto (aleatorio +/-):

```json
{
    "type": 15,
    "info": {
        "item_id": 1,
        "min": -3,
        "max": 5
    }
}
```

Reproducir sonido:

```json
{
    "type": 16,
    "info": {
        "display_name": "API test sound",
        "uri": "android.resource://net.sarasarasa.lifeup/raw/bellringing"
    }
}
```

Efecto de abrir caja:

```json
{
    "type": 7,
    "info": {
        "items": [
            {
                "item_id": 1,
                "amount": 1,
                "probability": 50,
                "is_fixed_reward": false
            },
            {
                "item_id": 2,
                "amount": 1,
                "probability": 50,
                "is_fixed_reward": true
            }
        ]
    }
}
```

<br/>

### Popup message

**Nombre del método:** toast

**Descripción:** Muestra mensajes emergentes de varios estilos

**Ejemplo:** <a href="lifeup://api/toast?text=Live well, eat well!&type=1&isLong=true">lifeup://api/toast?text=Live well, eat well!&type=1&isLong=true</a>

**Explicación:** El mensaje «Live well, eat well!» aparece con estilo de bonificación y se muestra durante más tiempo.

> Haz clic en el enlace del ejemplo para probar el efecto

| Parámetro | Significado                | Tipo               | Ejemplo              | Obligatorio | Notas |
| --------- | ---------------------- | ------------------ | -------------------- | -------- | ----- |
| text      | Texto del mensaje | Cualquier texto           | You learned to call! | sí      |       |
| type      | Estilo del texto        | Número del 0 al 6 | 1                    | no       | 0 - Estilo normal<br/>1 - Estilo bonificación<br/>2 - Estilo tomate<br/>3 - Estilo éxito<br/>4 - Estilo aviso<br/>5 - Estilo advertencia<br/>6 - Estilo error |
| isLong    | Duración de visualización       | true o false      | true                 | no       | true - largo<br/>false - corto |

<br/>

### Reward

**Nombre del método:** reward

**Descripción:** Otorga la Recompensa directamente. Puedes personalizar el motivo.

**Ejemplo:**

- Obtener 1 moneda; el motivo es «Learn API Calls». El motivo se mostrará en la página de detalles de monedas:

  <a href="lifeup://api/reward?type=coin&content=Learn API Calls&number=1">lifeup://api/reward?type=coin&content=Learn API Calls&number=1</a>

- Obtener 300 Puntos de Experiencia para «Learning, Creativity»; el motivo es «Learn API Calls». El motivo se mostrará en la página de detalles de EXP:

  <a href="lifeup://api/reward?type=exp&content=Learn API Calls&number=300&skills=2&skills=6">lifeup://api/reward?type=exp&content=Learn API Calls&number=300&skills=2&skills=6</a>

- Obtener 1 Objeto con coincidencia difusa «treasure»; el motivo es «Learn API Calls». El motivo se mostrará en el historial del Inventario:

  <a href="lifeup://api/reward?type=item&content=Learn API Calls&number=1&item_name=treasure">lifeup://api/reward?type=item&content=Learn API Calls&number=1&item_name=treasure</a>

| Parámetro | Significado                       | Tipo                            | Ejemplo            | Obligatorio | Notas                            |
| --------- | ----------------------------- | ------------------------------- | ------------------ | -------- | -------------------------------- |
| type      | Tipo de Recompensa                   | actualmente solo admite:<br/>coin<br/>exp<br/>item | coin | sí | coin - monedas<br/>exp - Puntos de Experiencia<br/>item - Objetos de la Tienda |
| content   | Motivo de la Recompensa                 | cualquier texto                        | Learning API Calls | Sí      |                                  |
| skills    | Habilidades (Atributos)           | array de números mayores que 0 | 1                  | No       | Solo cuando type es exp<br/>Admite arrays (p. ej. &skills=1&skills=2&skills=3)<br/>Para saber cómo obtenerlos, consulta el apartado «Basics - LifeUp Data ID» más arriba |
| number    | Cantidad de Recompensas             | número mayor que 0         | 1                  | Sí      | Si son monedas, el máximo es 999999<br/>Si son Puntos de Experiencia, el máximo es 99999<br/>Si es un Objeto, el máximo es 999 |
| item_id   | ID del Objeto                       | número mayor que 0           | 1                  | no*      | solo cuando type es item |
| item_name | Nombre del Objeto                     | cualquier texto                        | treasure           | no*      | solo cuando type es item; coincidencia difusa con nombres de Objetos |
| silent    | Desactivar avisos de la interfaz | true o false                   | false              | no       | false por defecto                 |

<br/>

### Penalty

**Nombre del método:** penalty

**Descripción:** Aplica una penalización directamente. Puedes personalizar el motivo.

**Ejemplo:** *Básicamente igual que la interfaz reward

- Penalizar 1 moneda; el motivo es «sleep in». El motivo se mostrará en la página de detalles de monedas:

  <a href="lifeup://api/penalty?type=coin&content=sleep in&number=1">lifeup://api/penalty?type=coin&content=sleep in&number=1</a>

- Penalizar 300 Puntos de Experiencia de «Strength» por «sleep in». El motivo se mostrará en la página de detalles de EXP:

  <a href="lifeup://api/penalty?type=exp&content=sleep in&number=300&skills=1">lifeup://api/penalty?type=exp&content=sleep in&number=300&skills=1</a>

- Penalizar 1 Objeto con coincidencia difusa «treasure» por «sleep in». El motivo se mostrará en el historial del Inventario:

  <a href="lifeup://api/penalty?type=item&content=sleep in&number=1&item_name=treasure">lifeup://api/penalty?type=item&content=sleep in&number=1&item_name=treasure</a>

| Parámetro | Significado                       | Tipo                                                 | Ejemplo  | Obligatorio | Notas            |
| --------- | ----------------------------- | ---------------------------------------------------- | -------- | -------- | ---------------- |
| type      | Tipo de penalización                  | Actualmente solo admite:<br/>coin<br/>exp<br/>item | coin     | sí      | coin - monedas<br/>exp - Puntos de Experiencia<br/>item - Objetos de la Tienda |
| content   | Motivo de la penalización            | cualquier texto                                             | Sleep In | Sí      |                  |
| skills    | Habilidades (Atributos)           | array de números mayores que 0                      | 1        | No       | Solo cuando type es exp<br/>Admite arrays (p. ej. &skills=1&skills=2&skills=3)<br/>Para saber cómo obtenerlos, consulta el apartado «Basics - LifeUp Data ID» más arriba |
| number    | Cantidad penalizada             | número mayor que 0                              | 1        | Sí      | Si son monedas, el máximo es 999999<br/>Si son Puntos de Experiencia, el máximo es 99999<br/>Si es un Objeto, el máximo es 999 |
| item_id   | ID del Objeto                       | número mayor que 0                                | 1        | no*      | solo cuando type es item |
| item_name | Nombre del Objeto                     | cualquier texto                                             | treasure | no*      | solo cuando type es item; coincidencia difusa con nombres de Objetos |
| silent    | Desactivar avisos de la interfaz | true o false                                        | false    | no       | false por defecto |

<br/>

### Edit Coin

**Nombre del método:** edit_coin

**Descripción:** Edita directamente el saldo de monedas del usuario. El saldo actual se establecerá en el valor indicado. Puedes personalizar el motivo del cambio; se mostrará en el historial de monedas.

**Ejemplo:**

- Establecer monedas en 1000 con motivo «API adjustment»: <a href="lifeup://api/edit_coin?coin=1000&content=API adjustment">lifeup://api/edit_coin?coin=1000&content=API adjustment</a>
- Establecer monedas en 500 en silencio: <a href="lifeup://api/edit_coin?coin=500&silent=true">lifeup://api/edit_coin?coin=500&silent=true</a>

| Parámetro | Significado | Tipo | Ejemplo | Obligatorio | Notas |
| --------- | ------- | ---- | ------- | -------- | ----- |
| coin | Saldo objetivo de monedas | number >= 0 | 1000 | Sí | Saldo final tras la operación; máximo 999999 |
| content | Motivo del cambio | cualquier texto | API adjustment | No | Si no se indica, usa el motivo predeterminado del sistema |
| reason | Motivo del cambio (alias) | cualquier texto | API adjustment | No | Alternativa al parámetro content |
| silent | Desactivar notificación de la interfaz | true o false | false | No | false por defecto; true suprime el mensaje toast |

<br/>

### Tasks

#### Add a Task

?> Algunos campos como `pin` requieren v1.98.0+

**Nombre del método:** add_task

**Descripción:** Crea una Tarea directamente

**Ejemplo:**
[lifeup://api/add_task?todo=This is an auto-added task&notes=notes&coin=10&coin_var=1&exp=2048&skills=1&skills=2&skills=3&category=0&item_name=coin](lifeup://api/add_task?todo=This is an auto-added task&notes=notes&coin=10&coin_var=1&exp=2048&skills=1&skills=2&skills=3&category=0&item_name=coin)

| Parámetro         | Significado             | Valores                | Ejemplo   | Obligatorio | Notas                           |
| ---------------- | ------------------- | -------------------- | --------- | -------- | ------------------------------- |
| todo             | Contenido de la Tarea        | cualquier texto             | Write diary | Sí     |                                |
| notes            | Notas               | cualquier texto             | Notes      | No       | Vacío por defecto               |
| coin             | Recompensa en monedas         | number >= 0         | 10         | No       | 0 por defecto; sujeto a límites del sistema                   |
| coin_var         | Variación de monedas| number >= 0          | 1          | No       | 0 por defecto; si >0, Recompensa aleatoria entre [coin, coin+coin_var] |
| exp              | Recompensa de Puntos de Experiencia   | number >= 0          | 100        | No       | 0 por defecto; sujeto a límites del sistema                   |
| skills           | ID de Habilidad           | array de números > 0 | 1          | No       | Admite arrays (p. ej., &skills=1&skills=2) |
| category         | ID de lista             | number >= 0          | 0          | No       | 0 por defecto (lista predeterminada); no admite listas inteligentes |
| frequency        | Frecuencia de repetición    | integer              | 0          | No       | 0 por defecto (una vez)<br/>0 - Una vez<br/>1 - Diaria<br/>N (N>1) - Cada N días<br/>-1 - Ilimitada<br/>-3 - Ebbinghaus (requiere v1.99.1)<br/>-4 - Mensual<br/>-5 - Anual |
| weekdays         | Días laborables            | `1,3,5` o `none`    | 1,3,5      | No       | v1.106.0+; 1=lunes … 7=domingo, días **en los que se repite**. Si se indica, frequency debe omitirse o ser 1. `none` se rechaza al añadir; al editar, `none` restablece a diaria. Los 7 días se tratan como diaria |
| importance       | Nivel de importancia    | [1, 4]              | 1          | No       | 1 por defecto                   |
| difficulty       | Nivel de dificultad    | [1, 4]              | 1          | No       | 1 por defecto                   |
| deadline         | Fecha límite            | timestamp (milisegundos) | 1640995200000 | No |                               |
| no_deadline      | Sin fecha límite         | true/false         | true      | No       | v1.104.0+; solo válido para Tareas repetitivas. Pasar `&no_deadline=true` borra la fecha límite concreta |
| color            | Color de etiqueta           | cadena de color         | #66CCFF    | No       | # debe escaparse como %23        |
| background_url   | URL de imagen de fondo| URL web             | http://example.com/bg.jpg | No | Debe ser una imagen web accesible |
| background_alpha | Opacidad del fondo  | float entre [0, 1] | 0.5        | No       | 1.0 por defecto                |
| enable_outline   | Contorno de texto | true o false       | false      | No       | Solo válido con background_url; añade contorno al texto para mejor legibilidad |
| use_light_remark_text_color | Texto claro para notas | true o false | false | No | Solo válido con background_url; usa color claro para las notas |
| start_time       | Hora de inicio          | timestamp (milisegundos) | 1640995200000 | No | Hora de inicio de la Tarea              |
| auto_use_item    | Usar Objetos de Recompensa automáticamente| true o false      | false      | No       | Usa las Recompensas automáticamente al completar |
| remind_time      | Hora de recordatorio       | timestamp (milisegundos) | 1640995200000 | No | Hora de recordatorio de la Tarea          |
| pin              | Fijar Tarea            | true o false       | false      | No       | Fija la Tarea arriba                |
| words            | Texto de Recompensa al completar | cualquier texto         | Great job! | No       | Texto motivacional al completar la Tarea |
| frozen           | Estado de congelación       | true o false       | false      | No       | false por defecto              |
| freeze_until     | Congelar hasta        | timestamp (milisegundos) | 1640995200000 | No | Solo efectivo cuando frozen es true |
| coin_penalty_factor | Factor de penalización en monedas| float entre [0, 100) | 0.5    | No       |                               |
| exp_penalty_factor | Factor de penalización de experiencia| float entre [0, 100) | 0.5 | No    |                               |
| write_feelings   | Activar Reflexiones     | true o false       | false      | No       | false por defecto              |
| item_id          | ID del Objeto             | number > 0          | 1          | No*      | Se requiere item_id o item_name |
| item_name        | Nombre del Objeto           | cualquier texto            | Treasure   | No*      | Se requiere item_id o item_name |
| item_amount      | Cantidad del Objeto       | [1, 99]             | 1          | No       | 1 por defecto                  |
| items            | Recompensas de Objetos        | texto JSON           | Ver [Estructura de Recompensa de Objetos](#1-item-rewards-structure) | No | Establece varias Recompensas de Objetos |
| task_type        | Tipo de Tarea           | [0, 4]              | 0          | No       | Requiere v1.99.1<br/>0 - Tarea normal<br/>1 - Tarea de conteo<br/>2 - Tarea negativa<br/>3 - Tarea API<br/>4 - Tarea cronometrada (v1.102.0+) |
| target_times     | Veces objetivo        | number > 0          | 1          | No       | Solo válido cuando task_type es 1 (tarea de conteo) |
| is_affect_shop_reward | Afecta Recompensa de la Tienda | true/false      | false    | No       | Solo válido cuando task_type es 1 (tarea de conteo); si afecta el cálculo de Recompensa de Objetos |
| enable_proportional_settlement | Liquidación proporcional | true/false | false | No | v1.104.0+; solo válido cuando task_type es 1 (tarea de conteo). Al activarse, la liquidación del progreso de conteo otorga Recompensas proporcionalmente y la finalización no vuelve a otorgar lo ya liquidado |
| expected_focus_minutes | Minutos de Enfoque esperados | number > 0 | 25 | No | Solo válido cuando task_type es 4 (tarea cronometrada); 25 por defecto (v1.102.0+) |
| repeat_end_mode | Modo de fin de repetición | 0 o 1 | 0 | No | Solo válido para Tareas repetitivas (frequency no es 0 / -1)<br/>0 - Terminar por cantidad<br/>1 - Terminar por fecha (v1.102.0+) |
| repeat_target_times | Cantidad de fin de repetición | number > 0 | 3 | No | Usado cuando repeat_end_mode=0 (o se infiere por este campo); no confundir con target_times (v1.102.0+) |
| repeat_end_date | Fecha de fin de repetición | timestamp (milisegundos) | 1640995200000 | No | Usado cuando repeat_end_mode=1 (o se infiere por este campo) (v1.102.0+) |
| repeat_end_behavior | Comportamiento al terminar la repetición | 0 o 1 | 0 | No | 0 - Terminar la Tarea al alcanzar la condición<br/>1 - Congelar la Tarea al alcanzar la condición (v1.102.0+) |

**Respuesta:**

| Campo    | Tipo    | Descripción      | Ejemplo | Notas                    |
| -------- | ------- | ---------------- | ------- | ------------------------ |
| task_id  | Number  | ID de Tarea          | 1000    |                          |
| task_gid | Number  | ID de grupo de Tareas    | 1000    |                          |

<br/>

#### Complete a Task

**Nombre del método:** complete

**Descripción:** Activa la finalización de una Tarea. Solo busca Tareas sin completar.

**Ejemplo:**

- Completar la Tarea con id 1: [lifeup://api/complete?id=1](lifeup://api/complete?id=1)
- Completar la Tarea con «task group id» 1: [lifeup://api/complete?gid=1](lifeup://api/complete?gid=1)
- Buscar Tareas por nombre y completarlas: <a href="lifeup://api/complete?name=Start using&ui=true">lifeup://api/complete?name=Start using&ui=true</a>

**Explicación:**

Cada Tarea tiene un id.

En Tareas repetitivas, el id se renueva en cada repetición, pero el «task group id» permanece igual.

Para obtener el id, activa «Developer Mode» en la página «Labs» y consúltalo en la página «Task Details».

| Parámetro | Significado                         | Tipo                  | Ejemplo | Obligatorio | Notas |
| --------- | ------------------------------- | --------------------- | ------- | -------- | ----- |
| id        | ID de Tarea                         | número mayor que 0 | 1       | no*      | ID de Tarea; en Tareas repetitivas, el id se actualiza en cada repetición. |
| gid       | ID de grupo de Tareas                   | número mayor que 0 | 1       | no*      | ID de grupo de Tareas; |
| name      | nombre                            | cualquier texto              | get up  | no*      | búsqueda difusa; solo una de las Tareas encontradas |
| ui        | Mostrar la interfaz emergente | true o false         | true    | no       | false por defecto; solo se muestra un mensaje en segundo plano |
| count                    | Valor de conteo                        | Number                                                 | 1         | No       | Solo aplicable a tareas de conteo; usar junto con el parámetro `count_set_type`     |
| count_set_type           | Cómo establecer el conteo         | Uno de los siguientes:<br/>absolute<br/>relative        | absolute  | No       | relative por defecto<br/>absolute - Establece el objetivo directamente al valor<br/>relative - Suma o resta sobre el valor original |
| count_force_sum_up       | Forzar suma de Recompensas de tarea de conteo  | true o false                                          | true      | No       |                                                                                                    |
| reward_factor            | Factor de Recompensa                      | Número decimal mayor que 0                   | 1.1       | No       | No aplicable a tareas de conteo<br/>El factor afecta la cantidad de experiencia y monedas (no la cantidad de Objetos) |

**Aviso:**

1. Para poder localizar la Tarea, hay que indicar id, gid o name.
2. Las tareas cronometradas no pueden completarse manualmente con esta API (v1.102.0+).

<br/>

#### Give up a Task

**Nombre del método:** give_up

**Descripción:** Activa el abandono de una Tarea.

**Ejemplo:**

- Buscar Tareas por nombre y abandonarlas: [lifeup://api/give_up?name=get up early](lifeup://api/give_up?name=get up early)

**Explicación:**

| Parámetro | Significado       | Tipo                  | Ejemplo | Obligatorio | Notas |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id        | ID de Tarea       | número mayor que 0 | 1       | no*      | ID de Tarea; en Tareas repetitivas, el id se actualiza en cada repetición. |
| gid       | ID de grupo de Tareas | número mayor que 0 | 1       | no*      | ID de grupo de Tareas; |
| name      | nombre          | cualquier texto              | get up  | no*      | búsqueda difusa; opera sobre una sola Tarea coincidente |

**Aviso:**

1. Para poder localizar la Tarea, hay que indicar id, gid o name.

<br/>

#### Freeze a task

**Nombre del método:** freeze

**Descripción:** Congela una Tarea; solo para Tareas repetitivas.

**Ejemplo:**

- Buscar Tareas por nombre y congelarlas: [lifeup://api/freeze?name=get up early](lifeup://api/freeze?name=get up early)

**Explicación:**

| Parámetro | Significado       | Tipo                  | Ejemplo | Obligatorio | Notas |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id        | ID de Tarea       | número mayor que 0 | 1       | no*      | ID de Tarea; en Tareas repetitivas, el id se actualiza en cada repetición. |
| gid       | ID de grupo de Tareas | número mayor que 0 | 1       | no*      | ID de grupo de Tareas; |
| name      | nombre          | cualquier texto              | get up  | no*      | búsqueda difusa; opera sobre una sola Tarea coincidente |
| time      | Congelar hasta  | timestamp             | 1661688800682 | no | - |

**Aviso:**

1. Para poder localizar la Tarea, hay que indicar id, gid o name.

<br/>

#### Unfreeze a task

**Nombre del método:** unfreeze

**Descripción:** Descongela una Tarea.

**Ejemplo:**

- Buscar Tareas por nombre y descongelarlas: [lifeup://api/unfreeze?name=get up early](lifeup://api/unfreeze?name=get up early)

**Explicación:**

| Parámetro | Significado       | Tipo                  | Ejemplo | Obligatorio | Notas |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id        | ID de Tarea       | número mayor que 0 | 1       | no*      | ID de Tarea; en Tareas repetitivas, el id se actualiza en cada repetición. |
| gid       | ID de grupo de Tareas | número mayor que 0 | 1       | no*      | ID de grupo de Tareas; |
| name      | nombre          | cualquier texto              | get up  | no*      | búsqueda difusa; opera sobre una sola Tarea coincidente |

**Aviso:**

1. Para poder localizar la Tarea, hay que indicar id, gid o name.

<br/>

#### Delete a task

**Nombre del método:** delete_task

**Descripción:** Elimina una Tarea.

**Ejemplo:**

- Buscar Tareas por nombre y eliminarlas: [lifeup://api/delete_task?name=get up early](lifeup://api/delete_task?name=get up early)

**Explicación:**

| Parámetro | Significado       | Tipo                  | Ejemplo | Obligatorio | Notas |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id        | ID de Tarea       | número mayor que 0 | 1       | no*      | ID de Tarea; en Tareas repetitivas, el id se actualiza en cada repetición. |
| gid       | ID de grupo de Tareas | número mayor que 0 | 1       | no*      | ID de grupo de Tareas; |
| name      | nombre          | cualquier texto              | get up  | no*      | búsqueda difusa; opera sobre una sola Tarea coincidente |

**Aviso:**

1. Para poder localizar la Tarea, hay que indicar id, gid o name.

<br/>

### Edit Task

?> Requiere v1.98.0+

**Nombre del método:** edit_task

**Descripción:** Edita el contenido y las propiedades de una Tarea existente

**Ejemplo:**
[lifeup://api/edit_task?id=1&todo=Modified task content&notes=notes&coin=10&exp=20&skills=1&skills=2&category=0](lifeup://api/edit_task?id=1&todo=Modified task content&notes=notes&coin=10&exp=20&skills=1&skills=2&category=0)

| Parámetro           | Significado              | Valores                | Ejemplo   | Obligatorio | Notas                           |
| ------------------ | -------------------- | -------------------- | --------- | -------- | ------------------------------- |
| id                 | ID de Tarea              | número mayor que 0 | 1        | No*      | Se requiere id, gid o name |
| gid                | ID de grupo de Tareas        | número mayor que 0 | 1        | No*      | Se requiere id, gid o name |
| name               | Nombre de la Tarea            | cualquier texto             | Write diary| No*      | Se requiere id, gid o name |
| todo               | Contenido de la Tarea         | cualquier texto             | Write weekly| No      |                                |
| notes              | Notas                | cualquier texto             | Note content| No      |                                |
| coin               | Recompensa en monedas          | number >= 0         | 10        | No       | Monedas al completar; sujeto a límites del sistema    |
| coin_var           | Variación de monedas        | número mayor que 0 | 1        | No       | Recompensa aleatoria entre [coin, coin+coin_var] |
| exp                | Recompensa de Puntos de Experiencia    | number >= 0          | 20        | No       | Puntos de Experiencia al completar; sujeto a límites del sistema        |
| skills             | ID de Habilidad            | array de números mayores que 0 | 1 | No    | Admite arrays (p. ej., &skills=1&skills=2) |
| category           | ID de lista              | número mayor o igual que 0 | 0 | No  | 0 para lista predeterminada; no admite listas inteligentes |
| frequency          | Frecuencia de repetición     | integer              | 0         | No       | 0 por defecto (una vez)<br/>0 - Una vez<br/>1 - Diaria<br/>N (N>1) - Cada N días<br/>-1 - Ilimitada<br/>-3 - Ebbinghaus (requiere v1.99.1)<br/>-4 - Mensual<br/>-5 - Anual |
| weekdays           | Días laborables             | `1,3,5` o `none`    | 1,3,5     | No       | v1.106.0+; igual que add_task. Omitir para no cambiar; `none` restablece a diaria; fijar frequency distinta de 1 también borra weekdays |
| importance         | Nivel de importancia     | [1, 4]              | 1         | No       | 1 por defecto                   |
| difficulty         | Nivel de dificultad     | [1, 4]              | 2         | No       | 1 por defecto                   |
| deadline           | Fecha límite             | timestamp (milisegundos) | 1640995200000 | No |                               |
| no_deadline        | Sin fecha límite          | true/false         | true     | No       | v1.104.0+; solo válido para Tareas repetitivas. Pasar `&no_deadline=true` borra la fecha límite concreta |
| remind_time        | Hora de recordatorio        | timestamp (milisegundos) | 1640995200000 | No |                               |
| start_time         | Hora de inicio           | timestamp (milisegundos) | 1640995200000 | No |                               |
| color              | Color de etiqueta            | cadena de color         | #66CCFF   | No       | # debe escaparse como %23        |
| background_url     | URL de imagen de fondo | dirección URL web      | http://example.com/bg.jpg | No |                         |
| background_alpha   | Opacidad del fondo   | decimal entre [0, 1] | 0.5 | No   |                                |
| enable_outline     | Contorno de texto  | true o false       | false      | No       | Solo válido con background_url; añade contorno al texto para mejor legibilidad |
| use_light_remark_text_color | Texto claro para notas | true o false | false | No | Solo válido con background_url; usa color claro para las notas |
| item_id            | ID del Objeto              | número mayor que 0 | 1        | No*      | Se requiere item_id o item_name |
| item_name          | Nombre del Objeto            | cualquier texto             | Treasure  | No*      | Se requiere item_id o item_name |
| item_amount        | Cantidad del Objeto          | [1, 99]             | 1         | No       | 1 por defecto                   |
| items              | JSON de Recompensas de Objetos    | texto JSON           | [{"itemId":1,"amount":1}] | No | Establece varias Recompensas de Objetos |
| auto_use_item      | Usar Objeto automáticamente        | true o false        | false     | No       |                                |
| frozen             | Estado de congelación        | true o false        | false     | No       | false por defecto              |
| freeze_until       | Congelar hasta         | timestamp (milisegundos) | 1640995200000 | No | Solo efectivo cuando frozen es true |
| coin_penalty_factor| Factor de penalización en monedas  | decimal entre [0, 100) | 0.5 | No |                                |
| exp_penalty_factor | Factor de penalización de experiencia | decimal entre [0, 100) | 0.5 | No |                             |
| write_feelings     | Activar Reflexiones      | true o false        | false     | No       |                                |
| pin                | Fijar Tarea             | true o false        | false     | No       |                                |
| words              | Texto de Recompensa al completar | cualquier texto           | Great job!| No       | Texto motivacional al completar la Tarea |
| task_type        | Tipo de Tarea           | [0, 4]              | 0          | No       | Requiere v1.99.1<br/>0 - Tarea normal<br/>1 - Tarea de conteo<br/>2 - Tarea negativa<br/>3 - Tarea API<br/>4 - Tarea cronometrada (v1.102.0+) |
| target_times     | Veces objetivo        | number > 0          | 1          | No       | Solo válido cuando task_type es 1 (tarea de conteo) |
| is_affect_shop_reward | Afecta Recompensa de la Tienda | true/false      | false    | No       | Solo válido cuando task_type es 1 (tarea de conteo); si afecta el cálculo de Recompensa de Objetos |
| enable_proportional_settlement | Liquidación proporcional | true/false | false | No | v1.104.0+; solo válido cuando task_type es 1 (tarea de conteo). En tareas de conteo existentes, este parámetro puede pasarse solo para activar o desactivar la liquidación proporcional; cambiar este ajuste o la configuración de Recompensa puede restablecer o revertir el progreso liquidado según las reglas de la App |
| expected_focus_minutes | Minutos de Enfoque esperados | number > 0 | 25 | No | Solo válido cuando task_type es 4 (tarea cronometrada); 25 por defecto (v1.102.0+) |
| repeat_target_times | Cantidad de fin de repetición | number > 0 | 3 | No | Solo válido para Tareas repetitivas (frequency no es 0 / -1); si se indican repeat_target_times y repeat_end_date, repeat_target_times tiene prioridad (v1.102.0+) |
| repeat_end_date | Fecha de fin de repetición | timestamp (milisegundos) | 1640995200000 | No | Solo válido para Tareas repetitivas (frequency no es 0 / -1) (v1.102.0+) |
| repeat_end_behavior | Comportamiento al terminar la repetición | 0 o 1 | 0 | No | 0 - Terminar la Tarea al alcanzar la condición<br/>1 - Congelar la Tarea al alcanzar la condición (v1.102.0+) |
| coin_set_type     | Cómo fijar el valor de monedas | Uno de:<br/>absolute<br/>relative | absolute | No | absolute - fija coin directamente al valor<br/>relative - suma o resta sobre el valor original de coin |
| exp_set_type      | Cómo fijar el valor de exp | Uno de:<br/>absolute<br/>relative | absolute | No | absolute - fija exp directamente al valor<br/>relative - suma o resta sobre el valor original de exp |

**Respuesta:**

| Campo     | Tipo    | Descripción      | Ejemplo | Notas             |
| --------- | ------- | ---------------- | ------- | ---------------- |
| task_id   | Number  | ID de Tarea          | 1000    |                  |
| task_gid  | Number  | ID de grupo de Tareas    | 1000    |                  |

<br/>

### Task Templates

?> Introducido en v1.102.0+

**Nombre del método:** task_template

**Descripción:** CRUD de plantillas de Tareas.

**Ejemplos:**

- Listar plantillas: `lifeup://api/task_template?method=list`
- Crear desde parámetros: `lifeup://api/task_template?method=create&name=MyTemplate&todo=Write diary&frequency=0`
- Crear desde una Tarea existente: `lifeup://api/task_template?method=create&name=MyTemplate&from_task_id=1`
- Obtener plantilla: `lifeup://api/task_template?method=get&id=1`
- Actualizar nombre de plantilla: `lifeup://api/task_template?method=update&id=1&name=NewName`
- Actualizar contenido de plantilla desde una Tarea: `lifeup://api/task_template?method=update&id=1&from_task_id=1`
- Eliminar plantilla: `lifeup://api/task_template?method=delete&id=1`

| Parámetro | Significado | Valor | Ejemplo | Obligatorio | Notas |
| --------- | ------- | ----- | ------- | -------- | ----- |
| method | Operación | list / get / create / update / delete | list | Sí | - |
| id | ID de plantilla | number > 0 | 1 | No* | Obligatorio para get/update/delete; alias: template_id |
| template_id | ID de plantilla | number > 0 | 1 | No* | Alias de id |
| name | Nombre de plantilla | text | MyTemplate | No* | Obligatorio para create; obligatorio para update si no se usa from_task_id/from_task_gid |
| from_task_id | Crear desde ID de Tarea | number > 0 | 1 | No | Para create/update |
| from_task_gid | Crear desde ID de grupo de Tareas | number > 0 | 1 | No | Para create/update |
| todo | Contenido de la Tarea | text | Write diary | No* | Obligatorio en create si no se usa from_task_id/from_task_gid |
| notes | Notas | text | Notes | No | Vacío por defecto |
| category | ID de lista | number >= 0 | 0 | No | Alias: category_id |
| category_id | ID de lista | number >= 0 | 0 | No | Alias de category |
| frequency | Frecuencia de repetición | integer | 0 | No | Igual que add_task |
| weekdays | Días laborables | `1,3,5` | 1,3,5 | No | v1.106.0+; igual que add_task; create rechaza `none` |
| importance | Nivel de importancia | [1, 4] | 1 | No | - |
| difficulty | Nivel de dificultad | [1, 4] | 1 | No | - |
| coin | Recompensa en monedas | number | 10 | No | - |
| coin_var | Variación de monedas | number | 1 | No | - |
| exp | Recompensa de Puntos de Experiencia | number | 100 | No | - |
| skills | ID de Habilidad | array params | 1 | No | Admite arrays (p. ej., &skills=1&skills=2) |
| skill_ids | ID de Habilidad | JSON array o lista separada por comas | [1,2] | No | Alternativa a skills |
| deadline | Fecha límite | timestamp (milisegundos) | 1640995200000 | No | - |
| start_time | Hora de inicio | timestamp (milisegundos) | 1640995200000 | No | - |
| remind_time | Hora de recordatorio | timestamp (milisegundos) | 1640995200000 | No | - |
| words | Texto de Recompensa al completar | text | Great job! | No | - |
| task_type | Tipo de Tarea | [0, 4] | 0 | No | 0 - Normal<br/>1 - Conteo<br/>2 - Negativa<br/>3 - API<br/>4 - Cronometrada |
| target_times | Veces objetivo | number > 0 | 10 | No | Solo válido cuando task_type es 1 (tarea de conteo) |
| is_affect_shop_reward | Afecta Recompensa de la Tienda | true / false | false | No | Solo válido cuando task_type es 1 (tarea de conteo) |
| enable_proportional_settlement | Liquidación proporcional | true / false | false | No | v1.104.0+; solo válido cuando task_type es 1 (tarea de conteo). Las Tareas creadas desde la plantilla conservan este ajuste de liquidación de conteo |
| expected_focus_minutes | Minutos de Enfoque esperados | number > 0 | 25 | No | Solo válido cuando task_type es 4 (tarea cronometrada) |
| repeat_end_mode | Modo de fin de repetición | 0 o 1 | 0 | No | Solo válido para Tareas repetitivas (frequency no es 0 / -1)<br/>0 - Terminar por cantidad<br/>1 - Terminar por fecha |
| repeat_target_times | Cantidad de fin de repetición | number > 0 | 3 | No | Usado cuando repeat_end_mode=0 (o se infiere por este campo) |
| repeat_end_date | Fecha de fin de repetición | timestamp (milisegundos) | 1640995200000 | No | Usado cuando repeat_end_mode=1 (o se infiere por este campo) |
| repeat_end_behavior | Comportamiento al terminar la repetición | 0 o 1 | 0 | No | 0 - Terminar<br/>1 - Congelar |

**Retorno:**

| Campo | Significado | Tipo | Notas |
| ----- | ------- | ---- | ----- |
| templates | lista de plantillas (cadena JSON) | text | Solo para method=list |
| count | cantidad de plantillas | number | Solo para method=list |
| template | detalle de plantilla (cadena JSON) | text | Solo para method=get |
| id | ID de plantilla | number | Para get/create/update/delete |
| name | nombre de plantilla | text | Para get/create/update |
| success | si tuvo éxito | true / false | Para create/update/delete |

<br/>

### History Task Operation

?> Requiere v1.98.0+

**Nombre del método:** history_operation

**Descripción:** Opera sobre Tareas completadas, abandonadas o vencidas

**Ejemplos:**

- Eliminar Tarea del historial: [lifeup://api/history_operation?id=1&operation=delete](lifeup://api/history_operation?id=1&operation=delete)
- Marcar Tarea como abandonada: [lifeup://api/history_operation?id=1&operation=set_to_give_up](lifeup://api/history_operation?id=1&operation=set_to_give_up)
- Reiniciar Tarea: [lifeup://api/history_operation?id=1&operation=restart](lifeup://api/history_operation?id=1&operation=restart)

!> Esta API solo aplica a Tareas no pendientes (completadas, abandonadas o vencidas)

| Parámetro      | Significado           | Valores               | Ejemplo    | Obligatorio | Notas                           |
| ------------- | ----------------- | -------------------- | ---------- | -------- | ------------------------------- |
| id            | ID de Tarea           | número mayor que 0 | 1         | Sí      | ID de la Tarea del historial          |
| operation     | Tipo de operación    | Uno de:<br/>delete<br/>complete<br/>undo_complete<br/>set_to_give_up<br/>set_to_overdue<br/>edit_completed_time<br/>restart | delete | Sí | delete - Eliminar Tarea<br/>complete - Marcar como completada<br/>undo_complete - Deshacer finalización<br/>set_to_give_up - Marcar como abandonada<br/>set_to_overdue - Marcar como vencida<br/>edit_completed_time - Modificar hora de finalización<br/>restart - Reiniciar Tarea |
| completed_time | Hora de finalización   | timestamp (milisegundos) | 1640995200000 | No* | Obligatorio solo cuando operation es edit_completed_time |

**Respuesta:**

| Campo    | Tipo    | Descripción    | Ejemplo | Notas                    |
| -------- | ------- | -------------- | ------- | ------------------------ |
| task_id  | Number  | ID de Tarea        | 1000    | ID de la Tarea operada  |

<br/>

### Shop Settings

**Nombre del método:** shop_settings

**Instrucciones:** Ajusta varios parámetros de la Tienda

**Ejemplo:**

- Establecer tipo de interés del cajero automático en 0,01 %: [lifeup://api/shop_settings?key=atm_interest&value=0.01](lifeup://api/shop_settings?key=atm_interest&value=0.01)
- Aumentar el tipo de interés un 0,01 % por clic: [lifeup://api/shop_settings?key=atm_interest&value=0.01&set_type=relative](lifeup://api/shop_settings?key=atm_interest&value=0.01&set_type=relative)

| Parámetro | Significado              | Tipo | Ejemplo | Obligatorio | Notas |
| --------- | -------------------- | ---- | ------- | -------- | ----- |
| key       | tipo                 | Actualmente solo admite:<br/>atm_interest<br/>credit_interest<br/>line_of_credit<br/>discount_rate_for_returning<br/>atm_balance | atm_interest | sí | atm_interest - tipo diario del cajero automático<br/>credit_interest - tipo diario del préstamo<br/>line_of_credit - importe prestable<br/>discount_rate_for_returning - escala de descuento por devolución<br/>atm_balance - establecer saldo del cajero automático |
| value     | valor numérico        | número decimal o entero | 0.01 | sí | cada key admite rangos distintos<br/>Por ejemplo, los saldos del cajero automático no admiten decimales |
| set_type  | Cómo fijar el valor | Uno de los siguientes:<br/>absolute<br/>relative | absolute | no | absolute - valor absoluto, es decir, fija el objetivo directamente al valor<br/>relative - valor relativo, suma o resta sobre el valor original |
| silent    | Ejecutar en silencio (sin mostrar interfaz) | Boolean | false | No | Compatible desde v1.93.0-beta01 (502)<br/>false por defecto, lo que muestra avisos de la interfaz |

<br/>

### Jump

**Nombre del método:** goto

**Descripción:** Saltar a una página en `LifeUp`

**Ejemplo:** [lifeup://api/goto?page=lab](lifeup://api/goto?page=lab)

**Explicación:** Saltar a la página de Laboratorios

| Parámetro | Significado | Valor | Ejemplo | Obligatorio | Notas |
| --------- | ------- | ----- | ------- | -------- | ----- |
| page | página | Uno de los siguientes valores:<br/>main<br/>setting<br/>about<br/>pomodoro<br/>feelings<br/>achievement<br/>history<br/>add_task<br/>add_achievement<br/>add_achievement_cate<br/>exp<br/>coin<br/>backup<br/>add_item<br/>lab<br/>custom_attributes<br/>pomodoro_record<br/>synthesis<br/>pic_manage<br/>purchase_dialog<br/>task_detail<br/>dlc<br/>new_default<br/>use_item_dialog<br/>achievement_list<br/>user_achievement | lab | sí | `purchase_dialog` se refiere al popup de compra<br/> `use_item_dialog` se refiere al popup de uso de Objeto<br/>El resto de entradas corresponden a páginas principales concretas |

#### 1. Saltar a la ventana emergente de compra/uso de Objeto

Cuando el parámetro `page` es `purchase_dialog` o `use_item_dialog`, puedes especificar el ID del Objeto:

Por ejemplo: `lifeup://api/goto?page=purchase_dialog&id=1`

| Parámetro | Significado | Valor            | Ejemplo | Obligatorio | Notas   |
| --------- | ------- | ---------------- | ------- | -------- | ------- |
| id        | ID de Objeto | Entero positivo | 1       | Sí      | ID de Objeto |

<br/>

#### 2. Saltar a la subpágina de inicio

Cuando el parámetro `page` es `main`, puedes especificar además la subpágina de destino:

Por ejemplo, saltar a la página de la Tienda: `lifeup://api/goto?page=main&sub_page=shop`

| Parámetro   | Significado       | Valor | Ejemplo | Obligatorio | Notas  |
| ----------- | ------------- | ----- | ------- | -------- | ------ |
| sub_page    | nombre de subpágina | Uno de:<br/>todo<br/>shop<br/>inventory<br/>achievement<br/>status<br/>me<br/>statistic<br/>pomodoro<br/>feelings<br/>world | shop    | no       |      |
| category_id | id de lista       | number | 0      | no       | Si `sub_page` es una página de lista, puedes indicar el id de lista al que saltar. <br/>Por ejemplo, lista de Objetos de la Tienda, lista del Inventario, lista de Tareas. |

<br/>

#### 3. Saltar a los detalles de una Tarea

Cuando el parámetro `page` es `task_detail`, puedes especificar además el id de Tarea al que saltar:

Por ejemplo, saltar a la página de detalles de la Tarea con id 53: `lifeup://api/goto?page=task_detail&task_id=53`

| Parámetro | Significado       | Valor         | Ejemplo      | Obligatorio | Notas |
| --------- | ------------- | ------------- | ------------ | -------- | ----- |
| task_id   | id de Tarea       | id de Tarea       | 53           | No*      | id de Tarea; si es una Tarea repetitiva, el id se actualiza en cada repetición. |
| task_gid  | id de grupo de Tareas | id de grupo de Tareas | 3            | No*      | id de grupo de Tareas |
| task_name | nombre de Tarea     | string        | get up early | No*      | nombre de Tarea; búsqueda difusa de una coincidencia. |

**Aviso:**

1. Solo hace falta proporcionar uno de los tres parámetros.
    - Si se proporcionan varios a la vez, habrá un orden de prioridad interno. Esto es comportamiento indefinido; la App no garantiza el orden.

<br/>

#### 4. Saltar a la página de nuevo Logro

Cuando el parámetro `page` es `add_achievement`, **debes** especificar además el id de categoría:

Por ejemplo, saltar a la página de nuevo Logro con id de categoría 1: `lifeup://api/goto?page=add_achievement&category_id=1`

| Parámetro    | Significado         | Valor         | Ejemplo | Obligatorio | Notas  |
| ------------ | --------------- | ------------- | ------- | -------- | ------ |
| category_id  | id de categoría de Logro | id de categoría de Logro | 1       | Sí      |        |

#### 5. Saltar a la página de categoría de Logro concreta

Cuando el parámetro `page` es `user_achievement`, **debes** especificar además el id de categoría:

Por ejemplo, saltar a la página de categoría de Logro con id 1: `lifeup://api/goto?page=user_achievement&category_id=1`

| Parámetro    | Significado         | Valor         | Ejemplo | Obligatorio | Notas  |
| ------------ | --------------- | ------------- | ------- | -------- | ------ |
| category_id  | id de categoría de Logro | id de categoría de Logro | 1       | Sí      |        |

#### 6. Saltar a la página de categoría de Síntesis concreta

Cuando el parámetro `page` es `synthesis`, puedes especificar opcionalmente el id de categoría:

Por ejemplo, saltar a la página de categoría de Síntesis con id 1: `lifeup://api/goto?page=synthesis&category_id=1`

| Parámetro    | Significado         | Valor         | Ejemplo | Obligatorio | Notas  |
| ------------ | --------------- | ------------- | ------- | -------- | ------ |
| category_id  | id de categoría de Síntesis | id de categoría de Síntesis | 1       | No       |        |

También puedes abrir la página de Síntesis con un filtro (v1.102.0+):

Por ejemplo, filtrar por id de Objeto producto 1: `lifeup://api/goto?page=synthesis&filter_type=product&filter_item_id=1&filter_item_name=Gem`

| Parámetro        | Significado           | Valor | Ejemplo | Obligatorio | Notas |
| --------------- | ----------------- | ----- | ------- | -------- | ----- |
| filter_type     | Tipo de filtro       | product / ingredient / related | product | No* | Requiere filter_item_id |
| filter_item_id  | id de Objeto filtro    | number > 0 | 1 | No* | Requiere filter_type |
| filter_item_name| Nombre de Objeto filtro  | text | Gem | No | Opcional; se usa para mostrar |

### Shop

#### Añadir Objetos

?> Algunos campos como `effects` requieren v1.98.0+

**Nombre del método:** add_item

**Descripción:** Crea un Objeto de la Tienda con propiedades personalizables, incluidos límites de compra y efectos de uso.

**Ejemplo:** [lifeup://api/add_item?name=Take a 10-minute break&desc=Go and take a short break!&price=10&action_text=rest&icon=☕](lifeup://api/add_item?name=Take a 10-minute break&desc=Go and take a short break!&price=10&action_text=rest&icon=☕)

| Parámetro        | Significado                | Valores               | Ejemplo       | Obligatorio | Notas                           |
| --------------- | --------------------- | -------------------- | ------------- | -------- | ------------------------------- |
| name            | Nombre del Objeto             | any text             | 10 minute break | Sí    |                                 |
| desc            | Descripción           | any text             | Take a break  | No       |                                 |
| icon            | Icono                  | emoji, http(s) URL, or built-in sample name | ☕ | No | Se guarda como `emoji_*.webp`, `lifeup_sample_*` o URL. Un emoji en el nombre no establece el icono. |
| price           | Precio                 | [0, 999999]         | 10            | No       | Por defecto es 0                    |
| stock_number    | Cantidad en stock        | [-1, 99999]         | -1            | No       | -1 significa ilimitado              |
| action_text     | Texto del botón de acción    | any text             | rest          | No       |                                 |
| disable_purchase| Deshabilitar compra      | true or false        | false         | No       | Por defecto es false                |
| disable_use     | Deshabilitar uso           | true or false        | false         | No       | Por defecto es false                |
| category        | ID de categoría           | number greater than or equal to 0 | 0 | No    | 0 para la categoría predeterminada          |
| order           | Orden de visualización         | integer              | 1             | No       | Posición en la categoría            |
| purchase_limit  | Reglas de restricción     | JSON text            | Ver [Purchase Limit Structure](#3-purchase-limit-structure) | No | Restricciones configurables de compra/uso |
| limit_scope     | Ámbito de restricción     | purchase / use / both | purchase | No | Solo aplica cuando `purchase_limit` no está vacío; por defecto es `purchase` |
| effects         | Efectos de uso           | JSON text            | Ver [Item Effects Structure](#4-item-effects-structure) | No | Efectos al usar el Objeto |
| own_number      | Cantidad inicial en propiedad | integer             | 0             | No       | Establece la cantidad inicial en el Inventario  |
| unlist          | Ocultar de la Tienda        | true or false        | false         | No       | Por defecto es false                |

**Datos de retorno:**

| Campo    | Tipo    | Descripción    | Ejemplo | Notas                    |
| -------- | ------- | -------------- | ------- | ------------------------ |
| item_id  | Number  | ID de Objeto        | 1000    | ID del Objeto creado   |

!> El parámetro effects anula disable_use. Si estableces effects para indicar un Objeto no usable, se ignorará disable_use.

<br/>

#### Editar Objeto

?> Requiere v1.98.0+

**Nombre del método:** item

**Descripción:** Modifica Objetos existentes, incluidos precio, stock, efectos y otras propiedades

**Ejemplos:**

- Ajustar precio: [lifeup://api/item?id=1&set_price=1&set_price_type=relative](lifeup://api/item?id=1&set_price=1&set_price_type=relative)
- Modificar efectos: [lifeup://api/item?effects=%5B%7B%22type%22%3A2%2C%22info%22%3A%7B%22min%22%3A100%2C%22max%22%3A200%7D%7D%5D&id=1](lifeup://api/item?effects=%5B%7B%22type%22%3A2%2C%22info%22%3A%7B%22min%22%3A100%2C%22max%22%3A200%7D%7D%5D&id=1)
  - El contenido decodificado del parámetro effects es: `[{"type":2,"info":{"min":100,"max":200}}]`

| Parámetro         | Significado             | Valores               | Ejemplo   | Obligatorio | Notas                           |
| ---------------- | ------------------- | -------------------- | --------- | -------- | ------------------------------- |
| id               | ID de Objeto             | number greater than 0| 1         | No*      | Se requiere id o name      |
| name             | Nombre del Objeto           | any text             | Treasure  | No*      | Para búsqueda difusa, no para renombrar  |
| set_name         | Establecer nombre            | any text             | Treasure  | No       | No puede estar vacío                 |
| set_desc         | Establecer descripción     | any text             | Get gift  | No       |                                |
| set_icon         | Establecer icono            | emoji, http(s) URL, or built-in sample name | ☕ | No | Igual que `icon`. Valores no admitidos devuelven `unsupported_parameter`. |
| set_price        | Ajustar precio        | integer              | 1         | No       |                                |
| set_price_type   | Método de ajuste de precio | absolute or relative | relative  | No       | absolute: establecer directamente<br/>relative: sumar/restar |
| own_number       | Ajustar cantidad en propiedad| integer             | 1         | No       | Admite valores negativos con relative |
| own_number_type  | Ajuste de cantidad en propiedad| absolute or relative| relative  | No       | absolute: establecer directamente<br/>relative: sumar/restar |
| stock_number     | Ajustar stock        | [-1, 99999]         | 1         | No       | -1 significa stock ilimitado        |
| stock_number_type| Método de ajuste de stock | absolute or relative | relative  | No       | absolute: establecer directamente<br/>relative: sumar/restar |
| disable_purchase | Deshabilitar compra    | true or false        | false     | No       | Por defecto es false              |
| disable_use      | Deshabilitar uso         | true or false        | false     | No       | Por defecto es false              |
| action_text      | Texto del botón de uso     | any text             | Use       | No       |                                |
| title_color_string| Color del título        | color string         | #66CCFF   | No       | # debe escaparse como %23<br/>Un valor vacío restaura el predeterminado |
| effects          | Efectos de uso         | JSON text            | Ver [Item Effects Structure](#4-item-effects-structure) | No | Establece efectos de uso del Objeto |
| purchase_limit   | Reglas de restricción   | JSON text            | Ver [Purchase Limit Structure](#3-purchase-limit-structure) | No | Pasa `null` para borrar todas las restricciones |
| limit_scope      | Ámbito de restricción   | purchase / use / both | purchase | No | Solo se actualiza cuando se proporciona este campo; se borra automáticamente cuando `purchase_limit` queda vacío |
| category_id      | ID de categoría         | number >= 0          | 1         | No       | 0 para la categoría predeterminada         |
| order            | Orden de visualización       | integer              | 1         | No       | Posición en la categoría           |
| unlist           | Quitar de la Tienda    | true or false        | false     | No       | Por defecto es false              |

!> Debe proporcionarse el parámetro id o name para localizar el Objeto a modificar

<br/>

#### Ajustar el efecto de Caja de botín

**Nombre del método:** loot_box

**Descripción:** Modifica el efecto de Caja de botín del Objeto caja indicado; admite ajustar probabilidad, cantidad de Recompensas y añadir contenido. (Por ahora no admite eliminación)

**Ejemplo:** <a href="lifeup://api/loot_box?name=Coin loot box&sub_name=A big bag of coins&set_type=relative&probability=1&fixed=false">lifeup://api/loot_box?name=Coin loot box&sub_name=A big bag of coins&set_type=relative&probability=1&fixed=false</a>

**Explicación:** Aumenta en 1 punto la proporción de la bolsa [grande] de monedas de oro en la caja de monedas.

| Parámetro   | Significado                               | Tipo                                                    | Ejemplo        | Obligatorio | Notas                                                        |
| ----------- | ------------------------------------- | ------------------------------------------------------- | -------------- | -------- | ------------------------------------------------------------ |
| id          | id de Objeto                               | a number greater than 0                                 | 1              | no*      | Consulta arriba "Basic Knowledge - LifeUp Data ID" para saber cómo obtenerlo |
| name        | nombre de Objeto                             | any text                                                | Treasure chest | no*      | Si el id es desconocido, búsqueda difusa del producto; no modifica el nombre |
| sub_id      | id de Objeto contenido                       | a number greater than 0                                 | 1              | no*      | id del contenido del cofre                                         |
| sub_name    | nombre de Objeto contenido                     | any text                                                | Get a gift     | no*      | Búsqueda difusa cuando se desconoce el id del contenido de la caja |
| set_type    | método de ajuste (absolute/relative) | one of the following values: <br/>absolute<br/>relative | relative       | no       | absolute: valor absoluto, es decir, fija el objetivo directamente<br/>relative: valor relativo, suma o resta sobre el valor original |
| amount      | cantidad del Objeto contenido                | number                                                  | 1              | no       | cantidad de Recompensas de un solo Objeto                          |
| probability | probabilidad del Objeto contenido       | number                                                  | 1              | no       | -                                                            |
| fixed       | si es Recompensa fija          | boolean                                                 | true/false     | no       | -                                                            |

**Aviso:**

1. Para buscar un producto, debe proporcionarse id o name.
1. Para buscar contenido, debe proporcionarse sub_id o sub_name.
1. `name` y `sub_name` intentan coincidencia exacta primero y luego búsqueda difusa.
1. La API heredada `loot_box` mantiene su comportamiento de compatibilidad: si el mismo Objeto contenido aparece varias veces con cantidades distintas, edita la primera entrada coincidente y no usa `sub_amount` para desambiguar. Usa `loot_box/v2` cuando necesites edición, eliminación o fusión específica por cantidad.

<br/>

#### Ajustar el efecto de Caja de botín (v2)

?> Esta API se introdujo en la versión v1.104.2.

**Nombre del método:** loot_box/v2

**Descripción:** Versión mejorada de la API loot_box. Modifica el efecto de Caja de botín del Objeto caja indicado; admite ajustar probabilidad, cantidad de Recompensas, añadir contenido y **eliminar contenido**.

**Mejoras respecto a v1:**
- **`sub_amount` para coincidencia precisa**: Cuando la caja contiene varias entradas del mismo Objeto con cantidades distintas (p. ej., A x1 50 %, A x2 30 %), usa `sub_amount` para apuntar a una entrada concreta. El valor predeterminado es `1`. Si no se encuentra coincidencia, LifeUp busca el Objeto por `sub_id` / `sub_name` y añade una entrada nueva; si la solicitud es una eliminación con `amount=0`, no se añade entrada nueva.
- **`set_type` independiente**: `amount_set_type` y `probability_set_type` pueden controlarse por separado. El `set_type` global sirve como valor predeterminado de respaldo.
- **Soporte de eliminación**: Establecer `amount=0` con `amount_set_type=absolute` (o calcular `<=0` con `relative`) elimina la entrada coincidente.
- **Fusión de duplicados**: Si cambiar `amount` duplicaría una entrada existente con el mismo Objeto y cantidad en la misma caja, LifeUp fusiona en la entrada existente y sigue aplicando los valores `probability` / `fixed` de la solicitud.

**Ejemplo:** <a href="lifeup://api/loot_box/v2?name=Coin loot box&sub_name=A big bag of coins&sub_amount=2&probability_set_type=relative&probability=10">lifeup://api/loot_box/v2?name=Coin loot box&sub_name=A big bag of coins&sub_amount=2&probability_set_type=relative&probability=10</a>

**Explicación:** Aumenta en 10 puntos la probabilidad de la bolsa [grande] de monedas de oro (x2) en la caja de monedas.

| Parámetro              | Significado                               | Tipo                                                    | Ejemplo        | Obligatorio | Notas                                                        |
| ---------------------- | ------------------------------------- | ------------------------------------------------------- | -------------- | -------- | ------------------------------------------------------------ |
| id                     | id de Objeto                               | a number greater than 0                                 | 1              | no*      | Consulta arriba "Basic Knowledge - LifeUp Data ID" para saber cómo obtenerlo |
| name                   | nombre de Objeto                             | any text                                                | Treasure chest | no*      | Si el id es desconocido, búsqueda difusa del producto; no modifica el nombre |
| sub_id                 | id de Objeto contenido                       | a number greater than 0                                 | 1              | no*      | id del contenido del cofre. Si se proporcionan sub_id y sub_name, sub_id tiene prioridad |
| sub_name               | nombre de Objeto contenido                     | any text                                                | Get a gift     | no*      | Búsqueda difusa cuando se desconoce el id del contenido de la caja |
| sub_amount             | cantidad del Objeto contenido para coincidencia      | number                                                  | 2              | no       | Sirve para coincidir con precisión una entrada con esta cantidad. Mínimo `1`, predeterminado `1`. Si no hay coincidencia y no es una solicitud de eliminación, se añade una entrada nueva. |
| set_type               | método de ajuste global              | one of: `absolute` / `relative`                         | relative       | no       | Predeterminado para `amount_set_type` y `probability_set_type` si no se especifica |
| amount_set_type        | método de ajuste para amount          | one of: `absolute` / `relative`                         | relative       | no       | Anula `set_type` para el campo amount                    |
| probability_set_type   | método de ajuste para probability     | one of: `absolute` / `relative`                         | absolute       | no       | Anula `set_type` para el campo probability               |
| amount                 | cantidad del Objeto contenido                | number                                                  | 1              | no       | cantidad de Recompensas de un solo Objeto. `0` (absolute) o calculado `<=0` (relative) elimina la entrada |
| probability            | probabilidad del Objeto contenido       | number                                                  | 1              | no       | -                                                            |
| fixed                  | si es Recompensa fija          | boolean                                                 | true/false     | no       | -                                                            |
| query                  | listar contenido de la caja                     | true or false                                           | true           | no       | v1.105.1+. Devuelve solo JSON del Objeto; no se requieren sub_id / sub_name |

**Aviso:**

1. Para buscar un producto, debe proporcionarse id o name.
1. Para buscar contenido, debe proporcionarse sub_id o sub_name. Usa `query=true` para listar contenido sin sub_id / sub_name.
1. Si se proporcionan `sub_id` y `sub_name`, `sub_id` tiene prioridad. `sub_name` solo se usa cuando no hay un `sub_id` válido.
1. `name` y `sub_name` intentan coincidencia exacta primero y luego búsqueda difusa.
1. `sub_amount` tiene valor predeterminado `1`. Cuando la caja tiene varias entradas del mismo Objeto con cantidades distintas, proporciona `sub_amount` para apuntar a una entrada concreta. Si no hay coincidencia y no es una solicitud de eliminación, se añade una entrada nueva con `amount=sub_amount`.
1. Para eliminar una entrada, establece `amount=0` con `amount_set_type=absolute`, o usa `amount_set_type=relative` con un valor negativo que deje el total en `<=0`. La eliminación solo aplica a entradas coincidentes; si no hay entrada coincidente, `amount=0` no añade una entrada nueva.
1. Si cambiar el `amount` de una entrada duplicaría una entrada existente con el mismo Objeto y cantidad en la misma caja, LifeUp fusiona en la entrada existente y sigue aplicando los valores `probability` / `fixed` de la solicitud.
1. Cuando la eliminación deja la caja vacía, todo el efecto de Caja de botín se elimina de forma suave (el Objeto se conserva y puedes volver a añadir entradas de Caja de botín más tarde).

<br/>

#### Usar Objetos

?> Esta API se introdujo en la versión v1.93.0-beta01 (502).

**Nombre del método:** use_item

**Descripción:** Usa un Objeto especificado.

**Ejemplo:**

- Abrir una caja de monedas: [lifeup://api/use_item?name=coin_box&use_times=1](lifeup://api/use_item?name=coin_box&use_times=1)

| Parámetro | Significado     | Tipo                    | Ejemplo  | Obligatorio | Notas                                                        |
| --------- | ----------- | ----------------------- | -------- | -------- | ------------------------------------------------------------ |
| id        | ID de Objeto     | a number greater than 0 | 1        | No*      | Para obtener el ID de Objeto, consulta la sección "Basic Knowledge - LifeUp Data ID" |
| name      | Nombre de Objeto   | Any text                | coin_box | No*      | Para IDs desconocidos; realiza búsqueda difusa de Objetos      |
| use_times | Veces de uso | a number greater than 0 | 1        | No       | Por defecto es 1 vez<br/>Para Objetos normales o al abrir cajas, corresponde a la cantidad del Objeto<br/>Para Objetos de Síntesis simple, este valor corresponde a la "cantidad de síntesis" y no al número de Objetos consumidos |

**Retorno:**

!> Esta API puede fallar por varios motivos; los valores de retorno pueden incluir el motivo concreto del fallo.

| Parámetro | Significado            | Tipo     | Ejemplo          | Obligatorio | Notas                                                        |
| --------- | ------------------ | -------- | ---------------- | -------- | ------------------------------------------------------------ |
| result    | Código de resultado        | a number | 0                | Sí      | 0 - Uso correcto<br/>1 - Excepción de base de datos<br/>2 - Restricción por Puntos de Experiencia insuficientes<br/>3 - Objeto no encontrado<br/>4 - Conflicto de cuenta atrás en curso<br/>5 - Inventario insuficiente<br/>6 - Objeto no usable<br/>7 - Límite de monedas<br/>8 - Límite de stock del objetivo<br/>9 - Restricción por nivel de Atributo<br/>10 - Restricción horaria<br/>11 - Restricción por cantidad de Objetos en propiedad<br/>12 - Restricción por finalización de Tarea<br/>13 - Restricción por desbloqueo de Logro<br/>14 - Restricción por cantidad del periodo<br/>15 - Restricción por ciclo de Tarea completado |
| desc      | Descripción del resultado | Text     | RunningCountDown | Sí      |                                                              |

<br/>

### ATM

**⚠ Solo disponible en v1.91+**

> Las operaciones de depósito y retiro aquí se verificarán.
>
> Si necesitas ajustar directamente el saldo del cajero automático, consulta la interfaz "Shop Settings" más arriba.

#### Depósito

**Nombre del método:** deposit

**Descripción:** El depósito se comprobará por legalidad (si el saldo de monedas es suficiente).

**Ejemplo:**[lifeup://api/deposit?amount=500](lifeup://api/deposit?amount=500)

**Explicación:** Depositar 500 monedas.

| Parámetro | Significado        | Tipo                    | Ejemplo | Obligatorio | Notas |
| --------- | -------------- | ----------------------- | ------- | -------- | ----- |
| amount    | importe del depósito | a number greater than 0 | 100     | sí      | -     |

**Retorno:**

| Parámetro | Significado                              | Tipo              | Ejemplo | Obligatorio | Notas |
| --------- | ------------------------------------ | ----------------- | ------- | -------- | ----- |
| result    | Si la operación tuvo éxito | `true` or `false` | true    | sí      | -     |

<br/>

#### Retiro

**Nombre del método:** withdraw

**Descripción:** Los retiros se comprobarán por legalidad (si el saldo del cajero automático es suficiente).

**Ejemplo:** [lifeup://api/withdraw?amount=500](lifeup://api/withdraw?amount=500)

**Explicación:** Retirar 500 monedas.

| Parámetro | Significado           | Tipo                    | Ejemplo | Obligatorio | Notas |
| --------- | ----------------- | ----------------------- | ------- | -------- | ----- |
| amount    | importe del retiro | a number greater than 0 | 100     | sí      | -     |

**Retorno:**

| Parámetro | Significado                              | Tipo              | Ejemplo | Obligatorio | Notas |
| --------- | ------------------------------------ | ----------------- | ------- | -------- | ----- |
| result    | Si la operación tuvo éxito | `true` or `false` | true    | sí      | -     |

<br/>

### Pomodoro Timer

**Nombre del método:** pomodoro_timer

**Descripción:** Controla la cuenta atrás o el cronómetro ascendente Pomodoro real en LifeUp. Esta API inicia
la misma sesión de temporizador que la interfaz de la App; no añade directamente registros Pomodoro ni tomates.

**Ejemplos:**

- Iniciar o reanudar la cuenta atrás de trabajo predeterminada:
  [lifeup://api/pomodoro_timer?action=start&mode=countdown](lifeup://api/pomodoro_timer?action=start&mode=countdown)
- Iniciar el cronómetro ascendente y seleccionar la Tarea 101:
  [lifeup://api/pomodoro_timer?action=start&mode=count_up&task_id=101](lifeup://api/pomodoro_timer?action=start&mode=count_up&task_id=101)
- Pausar la cuenta atrás activa:
  [lifeup://api/pomodoro_timer?action=pause&mode=countdown](lifeup://api/pomodoro_timer?action=pause&mode=countdown)
- Abandonar y reiniciar el ciclo de vida Pomodoro:
  [lifeup://api/pomodoro_timer?action=abandon&mode=countdown](lifeup://api/pomodoro_timer?action=abandon&mode=countdown)
- Saltar la etapa Pomodoro actual:
  [lifeup://api/pomodoro_timer?action=skip](lifeup://api/pomodoro_timer?action=skip)
- Liquidar un cronómetro ascendente sin recibir Recompensas de tomates:
  [lifeup://api/pomodoro_timer?action=complete&mode=count_up&receive_reward=false](lifeup://api/pomodoro_timer?action=complete&mode=count_up&receive_reward=false)
- Consultar ambos modos de temporizador:
  [lifeup://api/pomodoro_timer?action=status](lifeup://api/pomodoro_timer?action=status)

**Parámetros:**

| Parámetro | Significado | Tipo / valores | Obligatorio | Notas |
| --------- | ------- | ------------- | -------- | ----- |
| action | Operación | `start`, `pause`, `abandon`, `skip`, `complete`, `select_task`, `status` | sí | - |
| mode | Modo de temporizador | `countdown`, `count_up` | para `start`, `pause`, `abandon` y `complete` | `skip` siempre apunta a la cuenta atrás. |
| stage | Etapa de cuenta atrás | `work`, `short_break`, `long_break` | no | Solo válido con `mode=countdown`. Si se omite, se usa la etapa canónica activa, en pausa o siguiente por etapas; un ciclo de vida nuevo empieza con `work`. |
| receive_reward | Si recibir Recompensas de tomates | `true` or `false` | para `complete` | Booleano estricto. `complete` solo admite `mode=count_up`. |
| task_id | ID de Tarea | positive integer | no | No puede combinarse con `task_gid` o `task_name`. |
| task_gid | ID de grupo de Tareas | positive integer | no | Puede combinarse con `task_name` para acotar la coincidencia. |
| task_name | Nombre de Tarea | text | no | Se prefiere coincidencia exacta, con búsqueda difusa como respaldo. |
| clear_task | Borrar la Tarea del temporizador | `true` or `false` | no | `true` no puede combinarse con un localizador de Tarea. |

`select_task` requiere un localizador de Tarea o `clear_task=true`. `start` puede incluir los mismos
parámetros de selección de Tarea. No se admiten parámetros de duración personalizada: las cuentas atrás usan
la duración predeterminada actual o la duración Pomodoro de la Tarea seleccionada.

`abandon&mode=countdown` equivale a la acción izquierda de la App: abandona la etapa actual,
reinicia el ciclo de vida Pomodoro y vuelve a una etapa de trabajo detenida. `skip` equivale a la
acción derecha: avanza de trabajo a descanso corto/largo, o de descanso a trabajo, sin iniciar automáticamente
la etapa siguiente. Cada llamada a `skip` es una acción real no idempotente; los llamadores no deben reintentarla
automáticamente.

`complete&mode=count_up` liquida la sesión ascendente real. Las sesiones de menos de 30 segundos se
consumen sin crear registro. Con `receive_reward=false`, un registro que cumple el umbral
se guarda igualmente como abandonado pero no otorga tomates.

**Reglas de cambio de Tarea:**

- Una cuenta atrás de trabajo en curso rechaza cambios de Tarea.
- Un cronómetro ascendente en curso permite cambios de Tarea y actualiza su notificación.
- Una cuenta atrás en pausa permite cambios de Tarea y conserva el tiempo transcurrido mientras recalcula su duración total
  según la configuración de la nueva Tarea.

**Valores de retorno en caso de éxito:**

| Parámetro | Significado | Tipo |
| --------- | ------- | ---- |
| api_result | Si la llamada a la API tuvo éxito | boolean |
| applied | Si esta llamada cambió el estado del temporizador | boolean |
| mode | Modo de temporizador objetivo o seleccionado actualmente | `countdown` or `count_up` |
| state | Estado de `mode` | `running`, `paused`, or `stopped` |
| selected_task_id | ID de Tarea del temporizador actual, o `0` | number |
| can_start_in_background | Si Android permite actualmente iniciar el temporizador en segundo plano | boolean |
| countdown_state | Estado canónico de cuenta atrás | `running`, `paused`, or `stopped` |
| countdown_phase | Fase del ciclo de vida de cuenta atrás | `idle`, `running`, `paused`, `completing`, `completed`, or `cancelled` |
| countdown_stage | Etapa canónica de cuenta atrás | `work`, `short_break`, or `long_break` |
| countdown_session_id | ID de sesión canónica de cuenta atrás | text or null |
| countdown_total_millis | Duración total de cuenta atrás | milliseconds |
| countdown_remaining_millis | Duración restante de cuenta atrás | milliseconds |
| count_up_state | Estado canónico del cronómetro ascendente | `running`, `paused`, or `stopped` |
| count_up_elapsed_millis | Duración transcurrida del cronómetro ascendente | milliseconds |
| battery_optimization_ignored | Si LifeUp está exento de optimización de batería | boolean |

Las respuestas `complete` con éxito contienen además `record_created`, `reward_tomatoes` y
`settled_elapsed_millis`.

Las llamadas repetidas a `start`, `pause` o `abandon` que ya coinciden con el estado solicitado tienen éxito con
`applied=false`. Las llamadas mutantes no ofrecen deduplicación de reintento entre procesos.

**Errores:**

Los fallos devuelven `api_result=false`, `error_code` y `error_message`. Los códigos de error estables
específicos del temporizador son:

- `invalid_parameter`
- `missing_required_parameter`
- `unsupported_action_for_mode`
- `task_not_found`
- `task_change_not_allowed`
- `timer_mode_locked`
- `timer_state_conflict`
- `background_start_not_allowed`
- `timer_start_failed`
- `timer_settlement_failed`

En Android 12 y versiones posteriores, una llamada en segundo plano a ContentProvider solo puede iniciar un temporizador cuando LifeUp
tiene permiso para ignorar la optimización de batería. En caso contrario devuelve `background_start_not_allowed`
antes de cambiar el estado del temporizador. Abrir el URL Scheme a través de su Activity lleva LifeUp al
primer plano antes de iniciar. Android puede bloquear que una app de terceros lance esa Activity desde
segundo plano; cuando eso ocurre, LifeUp no recibe ninguna llamada a la API y no puede devolver un error.

<br/>

### Pomodoro Record

#### Añadir registro Pomodoro

**Nombre del método:** add_pomodoro

**Descripción:** Añade un registro de temporización de tomates

**Ejemplo:**

- Añadir un registro de temporización de 25 minutos (1500000 ms) asociado a una Tarea cuyo nombre contiene learning: [lifeup://api/add_pomodoro?task_name=learning&duration=1500000](lifeup://api/add_pomodoro?task_name=learning&duration=1500000)
- Añadir registro de temporización para `2022-08-01 11:00:00` - `2022-08-01 12:00:00`: [lifeup://api/add_pomodoro?start_time=1659322800000&end_time=1659326400000](lifeup://api/add_pomodoro?start_time=1659322800000&end_time=1659326400000)

**Explicación:**

| Parámetro        | Significado                    | Tipo                    | Ejemplo       | Obligatorio | Notas |
| ---------------- | -------------------------- | ----------------------- | ------------- | -------- | ----- |
| start_time       | hora de inicio de temporización          | timestamp               | 1659322800000 | no*      | Si no sabes qué es un timestamp, ¡búscalo! |
| duration         | duración de Enfoque             | number (in milliseconds) <br/>must be greater than 30000 | 1500000 | no* | |
| end_time         | hora de fin de temporización            | timestamp               | 1659326400000 | no*      |       |
| reward_tomatoes  | si otorgar tomates | true or false           | true          | no       | por defecto es false |
| task_id          | id de Tarea                    | a number greater than 0 | 1             | no       |       |
| task_gid         | id de grupo de Tareas              | a number greater than 0 | 1             | no       |       |
| task_name        | nombre                       | any text                | learning      | no       | búsqueda difusa; solo una de las Tareas encontradas |
| ui               | Mostrar interfaz de tomates otorgados | true or false         | true          | no       | Introducido en v1.94.0; por defecto es true |

**Aviso:**

1. Debe proporcionarse uno de start_time, duration o end_time.
2. Si solo se proporciona duration, end_time predeterminado es la hora actual.
3. end_time debe ser mayor que start_time.
4. duration es como mínimo 30000 milisegundos (30 segundos).
5. Si se proporcionan start_time, duration y end_time, duration debe ser menor o igual que (end_time - start_time).

<br/>

#### Editar registro Pomodoro

> Introducido en v1.94.0
> **Nombre del método:** edit_pomodoro

**Descripción:** Edita un registro de temporización Pomodoro existente o añade uno nuevo si se proporciona un `edit_item_id` válido.

**Ejemplo:**

- Editar un registro con un ID especificado, establecer duración a 45 minutos (2700000 ms) y otorgar tomates: [lifeup://api/edit_pomodoro?edit_item_id=123&duration=2700000&reward_tomatoes=true](lifeup://api/edit_pomodoro?edit_item_id=123&duration=2700000&reward_tomatoes=true)
- Editar un registro por hora de inicio y fin: [lifeup://api/edit_pomodoro?start_time=1659322800000&end_time=1659326400000&edit_item_id=456](lifeup://api/edit_pomodoro?start_time=1659322800000&end_time=1659326400000&edit_item_id=456)

**Parámetros:**

| Parámetro       | Significado                    | Tipo                  | Ejemplo       | Obligatorio | Notas                                            |
| --------------- | -------------------------- | --------------------- | ------------- | -------- | ------------------------------------------------ |
| task_id         | ID de Tarea                    | Number greater than 0 | 101           | No       | Identificador único de la Tarea                   |
| task_gid        | ID de grupo de Tareas              | Number greater than 0 | 5             | No       | Si se proporciona, anula task_id                |
| task_name       | Nombre de Tarea                  | Any text              | Study         | No       | Obligatorio si no se proporciona task_id o task_gid   |
| start_time      | Hora de inicio de temporización          | Timestamp             | 1659322800000 | No*      | Puedes buscar en Google qué es un timestamp     |
| end_time        | Hora de fin de temporización            | Timestamp             | 1659326400000 | No*      | -                                                |
| duration        | Duración de Enfoque             | Number (milliseconds) | 2700000       | No*      | Debe ser como mínimo 30000 milisegundos (30 segundos) |
| reward_tomatoes | Si otorgar tomates | true or false         | true          | No       | Por defecto es false                                 |
| edit_item_id    | ID del elemento a editar     | Number greater than 0 | 123           | Sí      | Especifica el ID del registro a editar                  |
| ui              | Mostrar interfaz de tomates otorgados | true or false         | true          | No       |                                                  |
| delete          | Eliminar el registro          | true or false         | true          | No       | v1.105.1+. Elimina suavemente el registro pomodoro (`isDel`), igual que la App |

**Valores de retorno:**

| Parámetro | Significado                          | Tipo   | Ejemplo | Obligatorio | Notas                    |
| --------- | -------------------------------- | ------ | ------- | -------- | ------------------------ |
| tomatoes  | Tomates obtenidos con esta acción | Number | 2       | No       | Se devuelve si `ui` es true |

**Notas:**

1. Debe proporcionarse al menos uno de `start_time`, `duration` o `end_time`.
2. `end_time` debe ser mayor que `start_time`.
3. `duration` debe ser menor o igual que (`end_time` - `start_time`).
4. Si se proporciona `edit_item_id` y se encuentra el registro correspondiente, se editará; en caso contrario, se creará un registro nuevo según los demás parámetros.

<br/>

### Condiciones de desbloqueo de Logros

**Nombre del método:** unlock_condition

**Descripción:** Condición de desbloqueo de Logro: requiere una llamada externa a la API para desbloquear

**Ejemplo:**

- Invocar la condición de desbloqueo con id 2: [lifeup://api/unlock_condition?id=2](lifeup://api/unlock_condition?id=2)

| Parámetro | Significado      | Tipo                  | Ejemplo | Obligatorio | Notas |
| --------- | ---------------- | --------------------- | ------- | -------- |------ |
| id        | id de condición | number greater than 0 | 2       | sí      |       |

<br/>

### Completar / reclamar Logro

?> Esta API se introdujo en v1.105.1.

**Nombre del método:** complete_achievement

**Descripción:** Completa un Logro manual y reclama su Recompensa, o reclama la Recompensa de un Logro automático ya desbloqueado. Mismo comportamiento que pulsar la casilla de completado / el botón de reclamar Recompensa en la App.

**Ejemplo:**

- Completar o reclamar el Logro con id 1: [lifeup://api/complete_achievement?id=1](lifeup://api/complete_achievement?id=1)

| Parámetro | Significado        | Tipo                  | Ejemplo | Obligatorio | Notas |
| --------- | ------------------ | --------------------- | ------- | -------- | ----- |
| id        | id de Logro | number greater than 0 | 1       | sí      |       |

**Valor de retorno:**

| Campo  | Tipo   | Descripción | Ejemplo | Notas |
| ------ | ------ | ----------- | ------- | ----- |
| id     | number | ID de Logro | 1 | |
| status | number | estado tras la llamada | 2 | `0` bloqueado · `1` desbloqueado, Recompensa sin reclamar · `2` desbloqueado, Recompensa reclamada |

**Notas:**

1. Logros manuales (sin condiciones de desbloqueo): si aún están bloqueados, esta llamada completa el Logro y otorga Recompensas.
2. Logros automáticos (con condiciones de desbloqueo): solo reclama Recompensas cuando ya está desbloqueado y queda una Recompensa pendiente. Si no se cumplen las condiciones, la llamada falla con `error_code=achievement_not_unlocked`.
3. Volver a llamar tras reclamar la Recompensa tiene éxito con `status=2` y no otorga Recompensas dos veces.
4. Esto difiere de `achievement?unlocked=true`, que solo escribe el estado de desbloqueo y no otorga Recompensas.

<br/>

### Establecer el número de pasos

**Nombre del método:** step

**Descripción:** Establece el número de pasos en la fecha indicada; por ejemplo, puede usarse para registrar pasos con una pulsera + herramienta de automatización. También sirve para modificar registros históricos.

**Ejemplo:**

- Ajustar el número de pasos del 2022-10-21 en la zona horaria GMT+8 a 9999 pasos: [lifeup://api/step?count=9999&time=1666282995643](lifeup://api/step?count=9999&time=1666282995643)

| Parámetro | Significado                         | Tipo                                | Ejemplo       | Obligatorio | Notas |
| --------- | ----------------------------------- | ----------------------------------- | ------------- | -------- | ----- |
| count     | número de pasos                 | a number greater than or equal to 0 | 9999          | sí      |       |
| time      | marca de tiempo arbitraria de la fecha | timestamp (ms)                      | 1666282995643 | sí      |       |

<br/>

### Editar Puntos de Experiencia

?> Esta API se introdujo en la versión v1.93.0-beta01 (502).

**Nombre del método:** edit_exp

**Descripción:** Esta API puede establecer por lotes los valores actuales de Puntos de Experiencia de los Atributos. Puede fijar directamente un valor concreto de experiencia o un Nivel determinado.

**Ejemplo:**

> Esta API afecta a los datos y, para evitar un uso accidental, aquí no se proporcionan enlaces directos.

- Restablecer los Puntos de Experiencia de los Atributos [Fuerza] y [Conocimiento] a 0: lifeup://api/edit_exp?skills=1&skills=2&exp=0
- Ajustar directamente los Puntos de Experiencia de [Encanto] al Nivel 50: lifeup://api/edit_exp?skills=3&level=50

| Parámetro | Significado              | Tipo                                      | Ejemplo | Obligatorio | Notas |
| --------- | -------------------- | ----------------------------------------- | ------- | -------- | ----- |
| skills    | ID de Atributo (Habilidad) | Array of numbers greater than 0           | 1       | No       | Admite arrays (es decir, &skills=1&skills=2&skills=3)<br/>Para obtener el ID de Atributo, consulta la sección "Basic Knowledge - LifeUp Data ID" |
| exp       | Establecer Puntos de Experiencia | Number greater than or equal to 0 (int32) | 9999    | No, pero debe proporcionarse exp o level |                                                               |
| level     | Establecer Nivel            | Number greater than or equal to 0 (int32) | 50      | No, pero debe proporcionarse exp o level | Representa los Puntos de Experiencia iniciales de un Nivel concreto<br/>y se verá afectado por gradientes de Nivel personalizados. |

<br/>

### Añadir o editar Reflexiones

?> Esta API está disponible desde la versión v1.93.4 (536).

**Nombre del método:** feeling

**Descripción:** Sirve para crear o actualizar registros de Reflexiones.

**Ejemplo:**

- Crear un registro de Reflexión: [lifeup://api/feeling?content=Happy&time=1633036800](lifeup://api/feeling?content=Happy&time=1633036800)
- Actualizar un registro de Reflexión existente y marcarlo como favorito: [lifeup://api/feeling?id=1&is_favorite=true](lifeup://api/feeling?id=1&is_favorite=true)
- Eliminar una Reflexión: [lifeup://api/feeling?id=1&delete=true](lifeup://api/feeling?id=1&delete=true)

| Parámetro            | Significado           | Tipo                               | Ejemplo           | Obligatorio | Notas                                                                                                                                                                                                                                        |
| -------------------- | ----------------- | ---------------------------------- | ----------------- | -------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| id                   | ID de registro de Reflexión | Number greater than 0              | 1                 | No       | Si se proporciona, el método intenta actualizar un registro concreto. Obligatorio al eliminar.                                                                                                                                                           |
| content              | Contenido           | Any text                           | Happy             | No       | Sirve para crear un registro nuevo o actualizar el contenido de uno existente                                                                                                                                                                    |
| time                 | Marca de tiempo         | Unix timestamp                     | 1633036800        | No       | Hora del registro; por defecto, la hora actual                                                                                                                                                                                             |
| is_favorite          | Marca de favorito     | true or false                      | true              | No       | Marca el registro como favorito o no                                                                                                                                                                                                        |
| delete               | Eliminar            | true or false                      | true              | No       | v1.105.1+. Elimina la Reflexión de forma suave igual que en la App (se quitan los adjuntos).                                                                                                                                                       |
| relate_type          | Tipo de relación     | Number between 0 and 3             | 1                 | No       | Especifica el tipo de relación asociado al registro:<br/>0: Tarea<br/>1: Logro personalizado<br/>2: Sin relación<br/>3: Uso de Objeto                                                                                                        |
| relate_id            | ID relacionado        | Number greater than 0              | 2                 | No       | Especifica el ID del elemento relacionado:<br/>Cuando relate_type es 0: representa el ID de Tarea<br/>Cuando relate_type es 1: representa el ID de Logro<br/>Cuando relate_type es 3: representa el ID de Objeto<br/>Cuando relate_type es 2: no hace falta ID                |
| usage_count          | Recuento de uso       | Integer greater than 1             | 1                 | No       | Solo válido cuando relate_type es 3 (uso de Objeto); registra el recuento de uso del Objeto.                                                                                                                                                          |
| image_uris           | URIs de imagen        | List of URI strings                |                   | No       | Admite URIs de archivos locales (file://) o imágenes web remotas (http/https). Admite arrays (p. ej., &image_uris=uri1&image_uris=uri2). |
| image_uris_update_mode | Modo de actualización       | APPEND or REPLACE | REPLACE           | No       | Solo válido al actualizar un registro existente y proporcionar image_uris.<br/>APPEND: Añade a las imágenes existentes.<br/>REPLACE: Sustituye las imágenes existentes (predeterminado).                                                               |
    
**Nota:**

1. Si se proporciona el parámetro `id`, el método intenta actualizar el registro de Reflexión correspondiente. Se lanza una excepción si no se encuentra un registro coincidente.
2. Si no se proporciona `id`, pero sí `content`, el método creará un registro de Reflexión nuevo.

<br/>

### Recuento de tomates

?> Requiere v1.98.0+

**Nombre del método:** tomato

**Descripción:** Ajusta el número de tomates (aumentar, disminuir o fijar una cantidad concreta)

**Ejemplos:**

- Añadir 1 tomate: [lifeup://api/tomato?action=increase&number=1](lifeup://api/tomato?action=increase&number=1)
- Quitar 2 tomates: [lifeup://api/tomato?action=decrease&number=2](lifeup://api/tomato?action=decrease&number=2)
- Fijar el recuento Pomodoro en 10: [lifeup://api/tomato?action=set&number=10](lifeup://api/tomato?action=set&number=10)

| Parámetro | Significado        | Valores                                        | Ejemplo   | Obligatorio | Notas                                                         |
| --------- | -------------- | --------------------------------------------- | --------- | -------- | ------------------------------------------------------------- |
| action    | Tipo de operación | One of:<br/>increase<br/>decrease<br/>set     | increase  | No       | increase - Añadir pomodoros (predeterminado)<br/>decrease - Quitar pomodoros<br/>set - Fijar el recuento Pomodoro al valor indicado |
| number    | Cantidad         | Integer                                       | 1         | Sí      | Significado según action:<br/>increase/decrease - Cantidad a añadir/quitar<br/>set - Cantidad objetivo |

**Respuesta:**

| Campo    | Tipo    | Descripción              | Ejemplo |
| -------- | ------- | ------------------------ | ------- |
| tomatoes | Integer | Recuento Pomodoro actual   | 10      |

<br/>

### Comprar Objeto

?> Requiere v1.98.0+

**Nombre del método:** purchase_item

**Descripción:** Compra un Objeto concreto

**Ejemplos:**

- Comprar Objeto con ID 1: [lifeup://api/purchase_item?id=1](lifeup://api/purchase_item?id=1)
- Comprar Objeto llamado "Health Potion": [lifeup://api/purchase_item?name=Health%20Potion](lifeup://api/purchase_item?name=Health%20Potion)
- Comprar 5 unidades del Objeto con ID 1: [lifeup://api/purchase_item?id=1&purchase_quantity=5](lifeup://api/purchase_item?id=1&purchase_quantity=5)

Si el Objeto tiene configurado `purchase_limit` y `limit_scope` incluye `purchase`, esta API también aplicará esas restricciones.

| Parámetro         | Significado          | Valores                | Ejemplo       | Obligatorio | Notas                      |
| ----------------- | ---------------- | --------------------- | ------------- | -------- | -------------------------- |
| id                | ID de Objeto          | number greater than 0 | 1             | No*      | Se requiere id o name |
| name              | Nombre de Objeto        | any text              | Health Potion | No*      | Se requiere id o name |
| purchase_quantity | Cantidad de compra| number greater than 0 | 5             | No       | Por defecto 1              |

**Respuesta:**

| Campo  | Tipo    | Descripción        | Ejemplo         | Notas                       |
| ------ | ------- | ------------------ | --------------- | --------------------------- |
| itemId | Number  | ID de Objeto            | 1               | Devuelto al comprar con éxito  |
| result | Integer | Código de resultado        | 0               | Ver códigos de resultado abajo      |
| desc   | Text    | Descripción del resultado | PurchaseSuccess | Ver códigos de resultado abajo      |

**Códigos de resultado:**

| Código | Descripción               | Notas                         |
| ---- | ------------------------- | ----------------------------- |
| 0    | PurchaseSuccess           | Compra correcta            |
| 1    | DatabaseError             | Error de base de datos                |
| 2    | NotEnoughCoin             | Monedas insuficientes              |
| 3    | ItemNotFound              | Objeto no encontrado                |
| 4    | PurchaseAndUseSuccess     | Compra y uso correctos    |
| 5    | PurchaseSuccessAndUseFailure | Compra correcta pero uso fallido |
| 6    | NotPurchaseable           | Compra bloqueada por ajustes o restricciones del Objeto |
| 7    | OutOfStock                | Stock de la Tienda insuficiente      |

<br/>

### Síntesis

?> Requiere v1.98.0+

**Nombre del método:** synthesize

**Descripción:** Sintetiza Objetos usando una fórmula existente

**Ejemplos:**

- Sintetizar una vez con la fórmula con ID 1: [lifeup://api/synthesize?id=1](lifeup://api/synthesize?id=1)
- Sintetizar 5 veces con la fórmula con ID 1: [lifeup://api/synthesize?id=1&times=5](lifeup://api/synthesize?id=1&times=5)

**Comportamiento de difusión:**

- Esta API es para **Síntesis por receta**.
- Cuando `Broadcast events` está activado y la Síntesis tiene éxito, LifeUp también envía el evento de difusión `app.lifeup.synthesis.complete`.
- Este evento **no** se envía para la Síntesis simple dentro de `use_item`; esa ruta sigue perteneciendo a `app.lifeup.item.use`.

| Parámetro | Significado            | Valores                | Ejemplo | Obligatorio | Notas                    |
| --------- | ----------------- | -------------------- | ------- | -------- | ------------------------ |
| id        | ID de fórmula        | number greater than 0 | 1       | Sí      | ID de la fórmula de Síntesis  |
| times     | Número de veces   | number greater than 0 | 5       | No       | Por defecto 1           |

**Respuesta:**

| Campo           | Tipo    | Descripción     | Ejemplo          | Notas                    |
| -------------- | ------- | --------------- | ---------------- | ------------------------ |
| formulaId      | Number  | ID de fórmula      | 1                |                          |
| result         | Integer | Código de resultado     | 0                | Ver códigos de resultado abajo   |
| desc           | Text    | Descripción del resultado | SynthesisSuccess | Ver códigos de resultado abajo |
| synthesisResults| Text   | Resultados de Síntesis | {...}           | Solo se devuelve si tiene éxito |

**Códigos de resultado:**

| Código | Descripción          | Notas                 |
| ---- | ------------------- | --------------------- |
| 0    | SynthesisSuccess    | Síntesis correcta  |
| 1    | FormulaNotFound     | Fórmula no encontrada     |
| 2    | InsufficientMaterials| Materiales insuficientes |
| 3    | DatabaseError       | Error de base de datos        |
| 4    | UnknownError        | Otros errores         |

<br/>

### Gestión de fórmulas de Síntesis

?> Requiere v1.98.0+

**Nombre del método:** synthesis_formula

**Descripción:** Crear, modificar o eliminar fórmulas de Síntesis

**Ejemplos:**

- Crear una fórmula nueva: [lifeup://api/synthesis_formula?inputItems=%5B%7B%22item_id%22%3A%20296%2C%20%22amount%22%3A%2088%7D%5D&outputItems=%5B%7B%22item_id%22%3A%20295%2C%20%22amount%22%3A%201%7D%5D](lifeup://api/synthesis_formula?inputItems=%5B%7B%22item_id%22%3A%20296%2C%20%22amount%22%3A%2088%7D%5D&outputItems=%5B%7B%22item_id%22%3A%20295%2C%20%22amount%22%3A%201%7D%5D)
  - Aquí, inputItems es `[{"item_id": 296, "amount": 88}]`
  - Aquí, outputItems es `[{"item_id": 295, "amount": 1}]`
- Eliminar fórmula: [lifeup://api/synthesis_formula?id=1&delete=true](lifeup://api/synthesis_formula?id=1&delete=true)

| Parámetro   | Significado        | Valores                | Ejemplo                        | Obligatorio | Notas                          |
| ----------- | -------------- | -------------------- | ------------------------------ | -------- | ------------------------------ |
| id          | ID de fórmula     | number greater than 0 | 1                             | No       | Obligatorio para modificar o eliminar  |
| delete      | Marca de eliminación    | true or false        | true                          | No       | Solo para eliminación         |
| inputItems  | Objetos de entrada    | Item array, see below | [{"item_id":1,"amount":2}]     | Sí      | Obligatorio para crear o modificar  |
| outputItems | Objetos de salida   | Item array, see below | [{"item_id":3,"amount":1}]     | Sí      | Obligatorio para crear o modificar  |
| category    | ID de categoría    | number greater than 0 | 1                             | No       | Por defecto, categoría común    |

!> inputItems y outputItems son arrays JSON en los que cada elemento contiene los campos item_id y amount. Todos los ID de Objeto deben existir y las cantidades deben ser mayores que 0

**Respuesta:**

| Campo     | Tipo    | Descripción      | Ejemplo     | Notas                    |
| --------- | ------- | ---------------- | ----------- | ------------------------ |
| formulaId | Number  | ID de fórmula       | 1           | Devuelto si tiene éxito      |
| result    | Integer | Código de resultado      | 0           | Ver códigos de resultado abajo   |
| desc      | Text    | Descripción del resultado | AddSuccess | Ver códigos de resultado abajo   |

**Códigos de resultado:**

| Código | Descripción     | Notas             |
| ---- | -------------- | ----------------- |
| 0    | Success        | Operación correcta |
| 1    | Failed         | Operación fallida  |

<br/>

### Gestión de subtareas

?> Requiere v1.98.0+

**Nombre del método:** subtask

**Descripción:** Crear o editar subtareas

**Ejemplos:**

- Añadir una subtarea a la Tarea principal con ID 1: [lifeup://api/subtask?main_id=1&todo=Complete%20homework](lifeup://api/subtask?main_id=1&todo=Complete%20homework)
- Editar subtarea y establecer Recompensas: [lifeup://api/subtask?main_id=1&edit_id=2&coin=10&exp=5](lifeup://api/subtask?main_id=1&edit_id=2&coin=10&exp=5)

| Parámetro     | Significado            | Valores                | Ejemplo    | Obligatorio | Notas                           |
| ------------ | ------------------ | -------------------- | ---------- | -------- | ------------------------------- |
| main_id      | ID de Tarea principal       | number greater than 0 | 1         | No*      | Se requiere uno de main_id, main_gid o main_name |
| main_gid     | ID de grupo de Tarea principal | number greater than 0 | 1         | No*      | Se requiere uno de main_id, main_gid o main_name |
| main_name    | Nombre de Tarea principal     | any text             | Study task | No*      | Se requiere uno de main_id, main_gid o main_name |
| edit_id      | ID de subtarea a editar | number greater than 0 | 2         | No*      | Se requiere uno de edit_id, edit_gid o edit_name al editar; no hace falta al crear |
| edit_gid     | ID de grupo de subtarea   | number greater than 0 | 2         | No*      | Se requiere uno de edit_id, edit_gid o edit_name al editar; no hace falta al crear |
| edit_name    | Nombre de subtarea       | any text             | Do homework| No*      | Se requiere uno de edit_id, edit_gid o edit_name al editar; no hace falta al crear |
| todo         | Contenido de Tarea       | any text             | Do homework| No       | Obligatorio al crear una subtarea nueva |
| remind_time  | Hora de recordatorio      | timestamp (milliseconds)| 1640995200000 | No | Pasa null para borrar el recordatorio    |
| order        | Orden              | integer              | 1          | No       | Posición en la lista de Tareas           |
| coin         | Recompensa en monedas        | [0, 999999]         | 10         | No       | Monedas obtenidas al completar    |
| coin_var     | Variación de monedas      | integer              | 5          | No       | Variación aleatoria de la Recompensa en monedas  |
| exp          | Recompensa de Puntos de Experiencia  | [0, 99999]          | 5          | No       | Puntos de Experiencia obtenidos        |
| auto_use_item| Usar Objeto automáticamente      | true or false        | true       | No       | Si se usa el Objeto automáticamente al completar |
| item_id      | ID de Objeto            | number greater than 0 | 1         | No*      | Se requiere item_id o item_name |
| item_name    | Nombre de Objeto          | any text             | Health Potion| No*    | Se requiere item_id o item_name |
| item_amount  | Cantidad de Objeto        | number greater than 0 | 1         | No       | Solo válido al establecer Recompensa de Objeto |
| items        | JSON de Objetos         | JSON text            | [{"item_id":1,"amount":1}] | No | Establece varias Recompensas de Objeto a la vez |
| coin_set_type     | Cómo fijar el valor de monedas | One of:<br/>absolute<br/>relative | absolute | No | absolute - fija las monedas directamente al valor<br/>relative - suma o resta sobre el valor original de monedas |
| exp_set_type      | Cómo fijar el valor de exp | One of:<br/>absolute<br/>relative | absolute | No | absolute - fija exp directamente al valor<br/>relative - suma o resta sobre el valor original de exp |

**Respuesta:**

| Campo        | Tipo    | Descripción      | Ejemplo | Notas            |
| ------------ | ------- | ---------------- | ------- | ---------------- |
| main_task_id | Number  | ID de Tarea principal     | 1       |                  |
| subtask_id   | Number  | ID de subtarea       | 2       |                  |
| subtask_gid  | Number  | ID de grupo de subtarea | 3       | Puede estar vacío     |

<br/>

### Gestión de categorías

?> Requiere v1.98.0+

**Nombre del método:** category

**Descripción:** Añadir o editar categorías (listas de Tareas, listas de Logros, listas de Tienda, listas de Síntesis)

**Ejemplos:**

- Crear una lista de Tareas: [lifeup://api/category?type=tasks&name=Study List](lifeup://api/category?type=tasks&name=Study List)
- Editar una lista de Tienda: [lifeup://api/category?type=shop&edit_id=1&name=Equipment Shop&order=1](lifeup://api/category?type=shop&edit_id=1&name=Equipment Shop&order=1)

| Parámetro        | Significado           | Valores               | Ejemplo    | Obligatorio | Notas                           |
| --------------- | ----------------- | -------------------- | ---------- | -------- | ------------------------------- |
| type            | Tipo de categoría     | One of:<br/>tasks<br/>achievements<br/>shop<br/>synthesis | tasks | Sí | tasks - Listas de Tareas<br/>achievements - Listas de Logros<br/>shop - Listas de Tienda<br/>synthesis - Listas de Síntesis |
| edit_id         | ID de categoría a editar| number greater than 0| 1         | No       | Obligatorio al editar           |
| name            | Nombre de categoría     | any text             | Study List | No       | Obligatorio para categorías nuevas; opcional al editar |
| order           | Orden de clasificación        | integer              | 1         | No       | Posición en la lista            |
| hidden          | Ocultar categoría     | true or false        | false     | No       | tasks=archivo; shop=ocultar en Tienda; synthesis=ocultar. Las listas de Logros y la lista ALL de Síntesis rechazan con `unsupported_parameter`. `false` desoculta |
| inventory_hidden| Ocultar en Inventario | true or false        | false     | No       | Solo compatible con listas de Tienda   |
| icon_uri        | URI de icono          | emoji, http(s) URL, content URI, or empty | 🏆 | No | Solo compatible con listas de Logros. El emoji se guarda como `emoji_*.webp`. Vacío lo borra. |
| desc            | Descripción       | any text             | This is a description | No | Solo compatible con listas de Logros |
| color           | Color de etiqueta         | color string         | #66CCFF   | No       | Solo compatible con listas de Tareas; # debe escaparse como %23 |

**Respuesta:**

| Campo | Tipo    | Descripción    | Ejemplo | Notas                    |
| ----- | ------- | -------------- | ------- | ------------------------ |
| id    | Number  | ID de categoría    | 1000    | ID de la categoría nueva o editada |

<br/>

### Exportar copia de seguridad

?> Requiere v1.98.0+

**Nombre del método:** export_backup

**Descripción:** Crea un archivo de copia de seguridad y devuelve su URI (solo llamadas de Content Provider)

!> Esta API solo puede invocarse mediante Content Provider; no se admiten llamadas directas por URL Scheme

| Parámetro      | Significado        | Valores          | Ejemplo | Obligatorio | Notas                                         |
| ------------- | -------------- | --------------- | ------- | -------- | --------------------------------------------- |
| withMedia     | Incluir archivos multimedia | true or false | true    | No       | Si se incluyen archivos multimedia (imágenes, efectos de sonido, etc.) en la copia de seguridad<br/>Por defecto true |
| callingPackage| Nombre del paquete llamante | any text      | com.example.app | No | Identificador de paquete para llamadas de Content Provider |

**Respuesta:**

| Campo          | Tipo   | Descripción          | Ejemplo                                       |
| -------------- | ------ | -------------------- | --------------------------------------------- |
| backup_file_uri | Text   | URI del archivo de copia de seguridad      | content://net.sarasarasa.lifeup.api/backup/file.zip |

<br/>

### Operación de subtareas

?> Requiere v1.98.0+

**Nombre del método:** subtask_operation

**Descripción:** Completar, deshacer la finalización o eliminar subtareas

**Ejemplos:**

- Completar una subtarea: [lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=complete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=complete)
- Eliminar una subtarea: [lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=delete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=delete)
- Deshacer la finalización de una subtarea: [lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=undo_complete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=undo_complete)

| Parámetro     | Significado          | Valores               | Ejemplo    | Obligatorio | Notas                          |
| ------------ | ---------------- | ------------------- | ---------- | -------- | ------------------------------ |
| main_id      | ID de Tarea principal     | number greater than 0| 1         | No*      | Se requiere uno de main_id, main_gid o main_name |
| main_gid     | ID de grupo de Tarea principal| number greater than 0| 1        | No*      | Se requiere uno de main_id, main_gid o main_name |
| main_name    | Nombre de Tarea principal   | any text            | Study task | No*      | Se requiere uno de main_id, main_gid o main_name |
| edit_id      | ID de subtarea       | number greater than 0| 2         | No*      | Se requiere uno de edit_id, edit_gid o edit_name |
| edit_gid     | ID de grupo de subtarea | number greater than 0| 2         | No*      | Se requiere uno de edit_id, edit_gid o edit_name |
| edit_name    | Nombre de subtarea     | any text            | Do homework| No*      | Se requiere uno de edit_id, edit_gid o edit_name |
| operation    | Tipo de operación   | One of the following:<br/>complete<br/>undo_complete<br/>delete | complete | Sí | complete - Completar Tarea<br/>undo_complete - Deshacer finalización<br/>delete - Eliminar Tarea |

**Respuesta:**

| Campo        | Tipo    | Descripción      | Ejemplo | Notas            |
| ------------ | ------- | ---------------- | ------- | ---------------- |
| main_task_id | Number  | ID de Tarea principal     | 1       |                  |
| subtask_id   | Number  | ID de subtarea       | 2       |                  |
| subtask_gid  | Number  | ID de grupo de subtarea | 3       | Puede estar vacío     |

<br/>

### Gestión de Logros

?> Requiere v1.98.0+

**Nombre del método:** achievement

**Descripción:** Añadir o editar Logros personalizados y subcategorías de Logros

**Ejemplos:**

- Crear un Logro: [lifeup://api/achievement?name=Collector&desc=Collect 100 items&category_id=1](lifeup://api/achievement?name=Collector&desc=Collect 100 items&category_id=1)
  - Puede que tengas que sustituir `category_id` por el id real de tu lista de Logros disponible para probar este ejemplo
- Crear un Logro con condiciones de desbloqueo: [lifeup://api/achievement?name=Millionaire&conditions_json=%5B%7B%22type%22%3A7%2C%22target%22%3A1000000%7D%5D&category_id=1](lifeup://api/achievement?name=Millionaire&conditions_json=%5B%7B%22type%22%3A7%2C%22target%22%3A1000000%7D%5D&category_id=1)
  - Puede que tengas que sustituir `category_id` por el id real de tu lista de Logros disponible para probar este ejemplo
  - El contenido decodificado de `conditions_json` es `[{"type":7,"target":1000000}]`
- Editar Logro existente: [lifeup://api/achievement?edit_id=1&name=New Achievement Name&exp=100](lifeup://api/achievement?edit_id=1&name=New Achievement Name&exp=100)

#### 1. Parámetros de Logro

| Parámetro      | Significado           | Valores               | Ejemplo   | Obligatorio | Notas                           |
| ------------- | ----------------- | -------------------- | --------- | -------- | ------------------------------- |
| edit_id       | ID de Logro a editar | number greater than 0 | 1      | No       | Obligatorio al editar          |
| is_subcategory| Es subcategoría    | true or false        | false     | No       | Por defecto false               |
| name          | Nombre de Logro   | any text             | Collector | No*      | Obligatorio para Logros nuevos   |
| desc          | Descripción       | any text             | Collect 100 items | No |                               |
| icon_uri      | Icono              | emoji, http(s) URL, content URI, or empty | 🏆 | No | No es `icon`. El emoji se guarda como archivo `emoji_`. Vacío lo borra. |
| order         | Orden de clasificación        | integer              | 1         | No       | Posición en la lista                |
| category_id   | ID de categoría       | number greater than 0 | 1        | No*      | Obligatorio al crear subcategoría |
| unlocked      | Estado de desbloqueo     | true or false        | true      | No       | true - desbloquear de inmediato<br/>false - restablecer a bloqueado |
| unlock_time   | Hora de desbloqueo       | timestamp (milliseconds) | 1640995200000 | No | Solo tiene efecto cuando ya está desbloqueado |
| delete        | Marca de eliminación       | true or false        | false     | No       |                                |
| secret        | Logro oculto| true or false        | false     | No       |                                |
| write_feeling | Registrar Reflexiones   | true or false        | false     | No       |                                |
| color         | Color del título       | color string         | #66CCFF   | No       | # debe escaparse como %23        |
| auto_use_item | Usar Objeto automáticamente     | true or false        | false     | No       |                                |
| skills        | IDs de Habilidad         | array of numbers greater than 0 | 1 | No    | Admite arrays (p. ej., &skills=1&skills=2) |
| exp           | Recompensa de Puntos de Experiencia | integer              | 100       | No       |                                |
| item_id       | ID de Objeto           | number greater than 0 | 1        | No*      | Se requiere item_id o item_name |
| item_name     | Nombre de Objeto         | any text             | Treasure  | No*      | Se requiere item_id o item_name |
| item_amount   | Cantidad de Objeto     | [1, 99]             | 1         | No       | Por defecto 1                   |
| items         | JSON de Recompensas de Objeto | JSON text            | [{"item_id":1,"amount":2}] | No | Establece varias Recompensas de Objeto; ver formato abajo |
| conditions_json| JSON de condiciones de desbloqueo | JSON text      | [{"type":7,"target":1000000}] | No | Establece condiciones de desbloqueo; ver formato abajo |
| coin         | Recompensa en monedas       | [0, 999999]      | 10         | No       | Cantidad de monedas obtenidas al desbloquear el Logro |
| coin_var     | Variación de Recompensa en monedas | integer              | 5          | No       | Rango de variación de las Recompensas en monedas |
| coin_set_type| Cómo fijar el valor de monedas | One of:<br/>absolute<br/>relative | absolute | No | absolute - fija las monedas directamente al valor<br/>relative - suma o resta sobre el valor original de monedas |
| exp_set_type | Cómo fijar el valor de exp | One of:<br/>absolute<br/>relative | absolute | No | absolute - fija exp directamente al valor<br/>relative - suma o resta sobre el valor original de exp |

**Respuesta:**

| Campo  | Tipo    | Descripción      | Ejemplo | Notas                    |
| ------ | ------- | ---------------- | ------- | ------------------------ |
| id     | Number  | ID de Logro   | 1000    | ID del Logro nuevo o editado |

#### 2. Parámetros de subcategoría

| Parámetro     | Significado           | Valores               | Ejemplo   | Obligatorio | Notas                           |
| ------------ | ----------------- | -------------------- | --------- | -------- | ------------------------------- |
| is_collapsed | Estado de colapso   | true or false        | false     | No       | Solo aplica a subcategorías   |

Las subcategorías rechazan `icon_uri` (incluido emoji) con `unsupported_parameter`. Editar una subcategoría sin `is_subcategory=true` devuelve `is_subcategory_required`.
**Respuesta:**

| Campo  | Tipo    | Descripción      | Ejemplo | Notas                    |
| ------ | ------- | ---------------- | ------- | ------------------------ |
| id     | Number  | ID de Logro   | 1000    | ID del Logro nuevo o editado (subcategoría) |

#### 3. Tipos de condición de desbloqueo

| Código de tipo | Descripción             | Requiere related_id | Tipo de related_id | Descripción de target  |
| --------- | ----------------------- | ------------------ | --------------- | ------------------ |
| 0         | Recuento de finalizaciones de Tarea   | Sí                | ID de Tarea         | Número de finalizaciones |
| 1         | Racha de finalizaciones de Tarea  | Sí                | ID de Tarea         | Recuento de racha       |
| 3         | Recuento Pomodoro         | No                 | -               | Número de pomodoros |
| 4         | Días usando LifeUp      | No                 | -               | Número de días     |
| 5         | Recuento de me gusta             | No                 | -               | Número de me gusta    |
| 6         | Racha diaria de finalizaciones | No                 | -               | Días de racha        |
| 7         | Monedas actuales          | No                 | -               | Cantidad de monedas    |
| 8         | Monedas obtenidas en un día| No                 | -               | Cantidad de monedas    |
| 9         | Recuento Pomodoro de Tarea    | Sí                | ID de Tarea         | Número de pomodoros |
| 10        | Recuento de compras de Objeto    | Sí                | ID de Objeto         | Recuento de compras     |
| 11        | Recuento de usos de Objeto       | Sí                | ID de Objeto         | Recuento de usos        |
| 12        | Recuento de Objetos de Caja de botín    | Sí                | ID de Objeto         | Recuento obtenido     |
| 13        | Nivel de Habilidad alcanzado    | Sí                | ID de Habilidad        | Valor de Nivel        |
| 14        | Nivel de vida            | No                 | -               | Valor de Nivel        |
| 15        | Total de Objetos obtenidos   | Sí                | ID de Objeto         | Recuento total de obtención |
| 16        | Objetos por Síntesis   | Sí                | ID de Objeto         | Recuento de Síntesis    |
| 17        | Cantidad actual de Objeto  | Sí                | ID de Objeto         | Recuento en propiedad          |
| 18        | Duración de Enfoque de Tarea    | Sí                | ID de Tarea         | Duración (minutos) |
| 19        | Ahorros en cajero automático           | No                 | -               | Importe de ahorros     |
| 20        | API externa          | No                 | -               | Definido por la API        |
| 520       | Completar N Tareas distintas al día | No         | -               | Recuento de Tareas distintas (deduplicado por ID de grupo; tipo existente) |
| 524       | Completar N finalizaciones de Tarea al día | No       | -               | Recuento total de finalizaciones válidas en un día (v1.104.4+) |

> A partir de v1.104.4, los tipos `520` y `524` usan la siguiente semántica:
>
> - Ambos comparten la misma definición de finalización y el límite de día del calendario local (`TimeRange.today()`).
> - Las Tareas normales cuentan `COMPLETED`; las Tareas negativas cuentan `GIVE_UP`.
> - El tipo `520` deduplica por `groupId` efectivo (recurre al id del registro de Tarea si falta el id de grupo). Completar la misma Tarea ilimitada varias veces en un día sigue contando como 1 Tarea distinta.
> - El tipo `524` cuenta cada fila de finalización válida. Completar la misma Tarea ilimitada 5 veces produce `completionCount = 5`.
> - Los Logros existentes con `type=520` conservan la semántica de Tareas distintas; no hace falta migración.

#### 4. Especificaciones de formato JSON

##### Condiciones de desbloqueo (conditions_json)

```json
[
    {
        "type": 7,           // Condition type (refer to table above)
        "related_id": null,  // Related ID (required for some types)
        "target": 1000000    // Target value
    },
    {
        "type": 10,          // Example: Purchase specific item
        "related_id": 1,     // Item ID
        "target": 5          // Purchase 5 times
    },
    {
        "type": 520,         // Complete N distinct tasks daily
        "related_id": null,
        "target": 5
    },
    {
        "type": 524,         // Complete N task completions daily
        "related_id": null,
        "target": 10
    }
]
```

##### Recompensas de Objeto (items)

```json
[
    {
        "item_id": 1,    // Item ID
        "amount": 2      // Quantity
    },
    {
        "item_id": 2,
        "amount": 3
    }
]
```

<br/>

### Gestión de Habilidades

?> Requiere v1.98.0+

**Nombre del método:** skill

**Descripción:** Crear o editar Habilidades personalizadas (Atributos)

**Ejemplos:**

- Crear una Habilidad: [lifeup://api/skill?content=Programming&desc=Coding ability&color=%23FF6B6B](lifeup://api/skill?content=Programming&desc=Coding ability&color=%23FF6B6B)
- Editar Puntos de Experiencia de Habilidad: [lifeup://api/skill?id=1&exp=100](lifeup://api/skill?id=1&exp=100)
- Eliminar Habilidad: [lifeup://api/skill?id=1&delete=true](lifeup://api/skill?id=1&delete=true)

| Parámetro    | Significado           | Valores               | Ejemplo    | Obligatorio | Notas                           |
| ----------- | ----------------- | -------------------- | ---------- | -------- | ------------------------------- |
| id          | ID de Habilidad          | number greater than 0 | 1         | No       | Obligatorio al editar           |
| content     | Nombre de Habilidad        | any text             | Programming| No*      | Obligatorio para Habilidades nuevas         |
| desc        | Descripción       | any text             | Coding ability | No    |                                |
| icon        | Icono              | any text             | 💻         | No       | Puede usarse emoji                   |
| color       | Color             | color string         | #FF6B6B    | No       | # debe escaparse como %23        |
| type        | Tipo              | integer              | 0          | No       |                                |
| order       | Orden de clasificación        | integer              | 1          | No       | Posición bruta en la lista mixta. Usado solo, la Habilidad se coloca en esa posición y el grupo final se infiere del diseño; usado con `group_id`, se ajusta a la posición legal más cercana dentro del grupo objetivo |
| group_id    | ID de grupo de Habilidad    | integer              | 10         | No       | Requiere v1.103.0+; no puede ser menor que `0`, y solo `0` mueve la Habilidad al área sin agrupar. Usado solo, las Habilidades nuevas se añaden al final del grupo objetivo, mientras que las editadas conservan su posición actual si ya están en ese grupo; en caso contrario, se mueven al final del grupo; usado con `order`, `group_id` tiene prioridad |
| status      | Estado            | integer              | 0          | No       |                                |
| exp         | Puntos de Experiencia | number greater than or equal to 0 | 100 | No | Puntos de Experiencia actuales de la Habilidad        |
| delete      | Marca de eliminación       | true or false        | false      | No       | Solo válido al editar         |

**Respuesta:**

| Campo  | Tipo    | Descripción    | Ejemplo | Notas                    |
| ------ | ------- | -------------- | ------- | ------------------------ |
| id     | Number  | ID de Habilidad       | 1000    | ID de la Habilidad nueva o editada |

<br/>

### Skill Group Management :id=skill_group_management

Requiere v1.103.0+

**Nombre del método:** skill_group

**Descripción:** Crear, editar, eliminar u reordenar grupos de Habilidades. La API de ordenación también admite orden mixto de grupos y Habilidades.

**Ejemplos:**

- Crear un grupo: [lifeup://api/skill_group?content=Combat](lifeup://api/skill_group?content=Combat)
- Editar un grupo: [lifeup://api/skill_group?id=10&content=Combat&order=20&collapsed=true](lifeup://api/skill_group?id=10&content=Combat&order=20&collapsed=true)
- Eliminar un grupo: [lifeup://api/skill_group?id=10&delete=true](lifeup://api/skill_group?id=10&delete=true)
- Ordenar grupos y Habilidades juntos:

```text
lifeup://api/skill_group?sort_json=[{"type":"skill","id":2},{"type":"group","id":10},{"type":"skill","id":3}]
```

| Parámetro | Significado | Valores | Ejemplo | Obligatorio | Notas |
| --------- | ------- | ------ | ------- | -------- | ----- |
| id | ID de grupo de Habilidad | number greater than 0 | 10 | No* | Obligatorio al editar o eliminar |
| content | Nombre del grupo | any text | Combat | No* | Obligatorio al crear |
| order | Orden de clasificación | integer | 20 | No | Valor bruto de `orderInCategory`; debe ser único en la lista mixta de Habilidad/grupo |
| collapsed | Estado de colapso | true or false | true | No | Si el grupo está colapsado |
| delete | Marca de eliminación | true or false | false | No | Solo válido al editar |
| sort_json | Nodos de orden mixto | JSON array | `[{"type":"skill","id":2},{"type":"group","id":10}]` | No* | Cuando se proporciona, se ignoran los parámetros CRUD y se aplica el plan de orden mixto. Se admite orden parcial: los nodos no especificados conservan su orden relativo |

Formato de nodo de `sort_json`:

| Campo | Significado | Valores |
| ----- | ------- | ------ |
| type | Tipo de nodo | `skill` / `group` |
| id | ID de entidad | number greater than 0 |

**Respuesta:**

| Campo | Tipo | Descripción | Ejemplo | Notas |
| ----- | ---- | ----------- | ------- | ----- |
| id | Number | ID de grupo de Habilidad | 10 | Devuelto para crear / editar / eliminar |
| count | Number | Número de nodos ordenados | 3 | Devuelto para solicitudes `sort_json` |

<br/>

### Ajustes de la App

?> Requiere v1.98.0+

**Nombre del método:** app_settings

**Descripción:** Ajusta la configuración de la interfaz de la App

**Ejemplos:**

- Activar modo compacto: [lifeup://api/app_settings?is_enable_compact_mode=true](lifeup://api/app_settings?is_enable_compact_mode=true)
- Activar tema Material You: [lifeup://api/app_settings?is_enable_material_you=true](lifeup://api/app_settings?is_enable_material_you=true)
- Cambiar ajustes y reiniciar la interfaz al instante: [lifeup://api/app_settings?is_enable_compact_mode=true&restart_activities=true](lifeup://api/app_settings?is_enable_compact_mode=true&restart_activities=true)

| Parámetro              | Significado           | Valores          | Ejemplo | Obligatorio | Notas                           |
| --------------------- | ----------------- | --------------- | ------- | -------- | ------------------------------- |
| is_enable_compact_mode| Activar modo compacto| true or false  | true    | No       | Simplifica los elementos de la interfaz     |
| is_enable_material_you| Activar Material You| true or false  | true    | No       | Activa el tema Material You       |
| restart_activities    | Reiniciar interfaz | true or false   | true    | No       | Aplica los cambios de interfaz al instante |
| broadcast_event | Eventos broadcast de LifeUp Labs | true or false | true | No | Desactivado por defecto. Mismo interruptor que Ajustes → Labs |

**Respuesta:**

| Campo  | Tipo    | Descripción  | Ejemplo | Notas                    |
| ------ | ------- | ------------ | ------- | ------------------------ |
| result | Integer | Código de resultado  | 0       | 0 indica éxito      |

<br/>

### Consulta simple

!> Las funciones de este apartado se usan con herramientas de automatización o desarrollo secundario. Si necesitas consultar una lista completa de datos, consulta [`LifeUp SDK`, `LifeUp Cloud`](https://github.com/Ayagikei/LifeUp-SDK) y [`LifeUp Desktop`.](https://github.com/Ayagikei/LifeUp-Desktop)

**Nombre del método:** query

**Descripción:** parámetros de consulta

**Ejemplo:** - Consultar el número actual de monedas: [lifeup://api/query?key=coin](lifeup://api/query?key=coin)
- Consultar el interruptor de eventos broadcast: [lifeup://api/query?key=broadcast](lifeup://api/query?key=broadcast) → `{enabled}`

| Parámetro   | Significado              | Tipo                                                         | Ejemplo | Obligatorio                                    | Notas                                                        |
| ----------- | -------------------- | ------------------------------------------------------------ | ------- | ------------------------------------------- | ------------------------------------------------------------ |
| key         | tipo de consulta        | Solo uno de los siguientes valores:<br/>coin<br/>atm<br/>item<br/>item_id_list<br/>tomato<br/>task<br/>broadcast | coin    | sí                                         | coin - cantidad actual de monedas<br/>atm - saldo actual del cajero automático<br/>item - información del Objeto del `itemId` indicado<br/>item_id_list - lista de IDs de Objeto del `categoryId` indicado<br/>tomato - datos de tomate<br/>task - información de Tarea (v1.101.0+)<br/>broadcast - interruptor de eventos broadcast de Labs (`{enabled}`) |
| item_id     | id del Objeto   | número mayor que 0                                      | 1       | Cuando key es `item`, es obligatorio |                                                              |
| category_id | id de categoría de la Tienda | número mayor o igual que 0                            | 0       | no*                                         | Obligatorio solo cuando key es `item_id_list`; representa el ID de la lista a consultar. |
| task_id / taskId | ID de Tarea          | número mayor que 0                                        | 1       | Cuando key es `task`, uno de tres* es obligatorio | ID de Tarea consultada |
| task_gid / taskGid / task_group_id / taskGroupId | ID de grupo de Tareas | número mayor que 0 | 1 | Cuando key es `task`, uno de tres* es obligatorio | ID de grupo de Tareas consultado |
| task_name / taskName | Nombre de Tarea      | cualquier texto                                                     | Study   | Cuando key es `task`, uno de tres* es obligatorio | Nombre de Tarea con coincidencia difusa |
| withSubTasks | Incluir subtareas   | true or false                                                | true    | No                                          | Solo disponible cuando key es `task`; true por defecto |

**Valor de retorno:**

Disponible desde la versión 1.90.2

Al consultar coin/atm:

| Parámetro | Significado                             | Tipo               | Ejemplo | Obligatorio | Notas |
| --------- | ----------------------------------- | ------------------ | ------- | -------- | ----- |
| value     | Valor numérico devuelto por la consulta | number             | 1000    | sí      |       |

Al consultar un Objeto:

| Parámetro        | Significado                         | Tipo     | Ejemplo   | Obligatorio | Notas |
| ---------------- | ------------------------------- | -------- | --------- | -------- | ----- |
| item_id          | id del Objeto              | number   | 1         | sí      |       |
| name             | nombre del Objeto            | any text | Coffee    | sí      |       |
| desc             | descripción                     | any text |           | no       |       |
| icon             | URL del icono                        | any text | icon.webp | no       | Si es un archivo local, solo se devuelve el nombre del archivo |
| category_id      | id de categoría                | number   | 1         | sí      |       |
| stock_number     | stock de la Tienda             | number   | -1        | sí      | `-1` representa stock infinito en la Tienda |
| own_number       | cantidad en el Inventario | number   | 10        | sí      |       |
| price            | precio                       | number   | 100       | sí      |       |
| order            | orden                         | number   | 100       | sí      | Valor de peso al ordenar personalizado |
| disable_purchase | Si desactivar la compra     | true or false | true | sí |       |
| purchase_limit   | Reglas de restricción               | JSON text | [{"limitType":0,"limitNumber":5}] | sí | Lista de restricciones actual |
| limit_scope      | Ámbito de restricción               | purchase / use / both | use | sí | Devuelto como valor de texto de la API |

Al consultar item_id_list:

| Parámetro | Significado                           | Tipo   | Ejemplo | Obligatorio | Notas |
| --------- | --------------------------------- | ------ | ------- | -------- | ----- |
| item_ids  | Array de IDs de Objeto separados por comas     | string | 1,2,3,4 | sí      |       |

Al consultar tomato:

| Parámetro | Significado                  | Tipo   | Ejemplo | Obligatorio | Notas |
| --------- | ------------------------ | ------ | ------- | -------- | ----- |
| total     | Total de tomates       | number | 100     | sí      |       |
| available | Tomates disponibles   | number | 50      | sí      |       |
| exchanged | Tomates canjeados   | number | 50      | sí      |       |

Al consultar task (v1.101.0+):

| Parámetro   | Significado                      | Tipo        | Ejemplo | Obligatorio | Notas                           |
| ----------- | ---------------------------- | ----------- | ------- | -------- | ------------------------------- |
| _ID         | ID de Tarea                      | number      | 1       | sí      | -                               |
| _GID        | ID de grupo de Tareas                | number      | 1       | sí      | -                               |
| name        | Nombre de Tarea                    | text        | Study   | sí      | -                               |
| notes       | Notas                        | text        | -       | no       | Puede estar vacío                    |
| status      | Estado de la Tarea                  | number      | 0       | sí      | 0=incompleta, 1=completada       |
| startTime   | Hora de inicio                   | number      | -       | sí      | Marca de tiempo Unix (milisegundos)   |
| deadline    | Fecha límite                | number      | -       | no       | Marca de tiempo Unix (milisegundos), puede estar vacía |
| remindTime  | Hora de recordatorio                  | number      | -       | no       | Marca de tiempo Unix (milisegundos), puede estar vacía |
| frequency   | Frecuencia de repetición         | number      | -       | sí      | -                               |
| weekdays    | Días laborables                     | text        | 1,3,5   | no       | v1.106.0+; vacío cuando no es modo por días. 1=lunes … 7=domingo |
| exp         | Recompensa de Puntos de Experiencia                   | number      | -       | sí      | -                               |
| skillIds    | Lista de IDs de Habilidad                | JSON text   | -       | sí      | Formato de array JSON               |
| coin        | Recompensa en monedas                  | number      | -       | no       | Puede estar vacía                    |
| coinVariable| Recompensa aleatoria en monedas           | number      | -       | no       | Puede estar vacía                    |
| itemId      | ID del primer Objeto de Recompensa         | number      | -       | no       | Puede estar vacío                    |
| itemCount   | Cantidad del primer Objeto de Recompensa      | number      | -       | no       | Se devuelve cuando existe itemId     |
| items       | Lista de Recompensas de Objetos             | JSON text   | -       | sí      | Formato de array JSON               |
| words       | Palabras motivacionales al completar   | text        | -       | no       | Puede estar vacío                    |
| categoryId  | ID de categoría                  | number      | -       | no       | Puede estar vacío                    |
| order       | Orden                        | number      | -       | sí      | -                               |
| name_extended | Nombre extendido              | text        | -       | sí      | Igual que name                    |
| subTasks    | Lista de subtareas                | JSON text   | -       | sí      | Formato de array JSON, ver abajo    |

**Descripción del campo subtareas (subTasks):**

El campo `subTasks` es un array JSON; cada elemento contiene los siguientes campos:

- `id`: ID de subtarea
- `gid`: ID de grupo de subtarea
- `todo`: Contenido de la subtarea
- `status`: Estado de la subtarea (0=incompleta, 1=completada)
- `remindTime`: Hora de recordatorio (marca de tiempo Unix, milisegundos)
- `exp`: Recompensa de Puntos de Experiencia
- `coin`: Recompensa en monedas
- `coinVariable`: Recompensa aleatoria en monedas
- `items`: Lista de Recompensas de Objetos
- `order`: Orden
- `autoUseItem`: Si usar el Objeto automáticamente

<br/>

### Consultar Atributos :id=query_skill

!> Las funciones de este apartado se usan con herramientas de automatización o desarrollo secundario.

**Nombre del método:** query_skill

**Descripción:** Consulta la información básica, los campos de ordenación en bruto y los datos de Nivel/experiencia de una Habilidad concreta.

Puedes usar esta API para personalizar widgets de Atributos.

**Ejemplo:**

- Consultar el Atributo de fuerza: [lifeup://api/query_skill?id=1](lifeup://api/query_skill?id=1)

| Parámetro | Significado              | Tipo                    | Ejemplo | Obligatorio | Notas |
| --------- | -------------------- | ----------------------- | ------- | -------- | ----- |
| id        | id de Atributo (Habilidad) | número mayor que 0 | 1       | sí      | Para saber cómo obtenerlo, consulta el apartado «Basics - LifeUp Data ID» más arriba |

**Valor de retorno:**

Disponible desde la versión 1.90.6

| Parámetro            | Significado                              | Tipo   | Ejemplo  | Obligatorio | Notas |
| -------------------  | ------------------------------------ | ------ | -------- | -------- | ----- |
| id                   | id de Habilidad                             | number | 1        | sí      | Añadido a `query_skill` en v1.103.0+ |
| name                 | nombre del Atributo                       | string | strength | sí      |       |
| order                | orden de clasificación en bruto                       | number | 20       | sí      | Añadido en v1.103.0+; `orderInCategory` |
| group_id             | ID de grupo de Habilidades                       | number | 10       | sí      | Añadido en v1.103.0+; devuelve `0` cuando la Habilidad no está en un grupo |
| status               | estado                               | number | 0        | sí      | Añadido en v1.103.0+; `0` = normal, `1` = oculta |
| level                | Nivel                                | number | 10       | sí      |       |
| total_exp            | Puntos de Experiencia totales              | number | 10000    | sí      |       |
| until_next_level_exp | Puntos de Experiencia necesarios para el siguiente Nivel | number | 99       | sí      |       |
| current_level_exp    | Puntos de Experiencia ganados por encima del Nivel actual       | Number | 1000     | Sí      |       |

<br/>

### Consultar grupo de Habilidades :id=query_skill_group

Requiere v1.103.0+

**Nombre del método:** query_skill_group

**Descripción:** Consulta un grupo de Habilidades concreto y devuelve su orden en bruto y estado de colapso.

**Ejemplo:**

- Consultar un grupo de Habilidades: [lifeup://api/query_skill_group?id=10](lifeup://api/query_skill_group?id=10)

| Parámetro | Significado | Tipo | Ejemplo | Obligatorio | Notas |
| --------- | ------- | ---- | ------- | -------- | ----- |
| id | ID de grupo de Habilidades | number greater than 0 | 10 | sí | - |

**Valor de retorno:**

| Parámetro | Significado | Tipo | Ejemplo | Obligatorio | Notas |
| --------- | ------- | ---- | ------- | -------- | ----- |
| id | ID de grupo de Habilidades | number | 10 | sí | - |
| content | Nombre del grupo | string | Combat | sí | - |
| order | Orden de clasificación en bruto | number | 20 | sí | `orderInCategory` |
| collapsed | Estado de colapso | string | true | sí | Devuelto como texto `true` / `false` |

<br/>

<br/>

### Interfaz especial

#### Aleatorio

?> Esta API se publicó en v1.93.0.

**Nombre del método:** random

**Descripción:** Interfaz aleatoria sencilla que puede activar una de varias APIs al azar.

**Ejemplo:**

- Probabilidad igual de mostrar al azar `scissors`, `rock` o `paper`: [lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper](lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper)

- 90 % de probabilidad de mostrar `rock`, 5 % para `scissors` y 5 % para `paper`: [lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper&weight=90&weight=5&weight=5](lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper&weight=90&weight=5&weight=5)

| Parámetro | Significado    | Valores                 | Ejemplo                                | Obligatorio | Notas |
| --------- | ---------- | ---------------------- | -------------------------------------- | -------- | ----- |
| api       | API aleatoria | Any text               | lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock | Sí      | Admite llamada en forma de array (es decir, varios parámetros api, como en los ejemplos anteriores) |
| weight    | Peso     | Numbers greater than 0 | 1                                      | No       | Admite llamada en forma de array.<br/><br/>Si no se especifica weight, todos los pesos son iguales (probabilidad uniforme).<br/>Si se especifican pesos, se asignan en secuencia: p. ej., el primer peso corresponde al primer parámetro api.<br/><br/>**Asegúrate de que el número de parámetros weight coincida con el de parámetros api, o puede no surtir efecto.** |

<br/>

#### Diálogo de confirmación

**Nombre del método:** confirm_dialog

**Descripción:** Muestra una ventana de selección emergente. Puedes personalizar el título, el texto, el botón positivo y el negativo. También se pueden llamar otras interfaces al pulsar los botones.

**Ejemplo:**

- [<a href="lifeup://api/confirm_dialog?title=Do you believe in love&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dbelieve&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Ddo not believe">lifeup://api/confirm_dialog?title=Do you believe in love&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dbelieve&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Ddo not believe</a>](lifeup://api/confirm_dialog?title=Do you believe in love&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dbelieve&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Ddo not believe)
- Otros escenarios de uso:
  - Elección de Recompensas
  - Selección de rama de evento

| Parámetro       | Significado              | Tipo     | Ejemplo  | Obligatorio | Notas |
| --------------- | -------------------- | -------- | -------- | -------- | ----- |
| title           | título del popup          | any text | Title    | sí      |       |
| message         | descripción detallada de la ventana emergente | any text | This is the content of the popup window | no |  |
| positive_text   | texto del botón positivo | any text | YES      | no       |       |
| negative_text   | texto del botón negativo | any text | NO       | no       |       |
| neutral_text    | texto del botón neutro  | any text | QUESTION | no       |       |
| positive_action | respuesta de enlace del botón positivo | URL (other interface) | lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D You clicked OK | no | En realidad es el texto escapado de la interfaz de mensaje emergente. Para las reglas de escape, consulta «Basics - Escaping (URL Encode)». |
| negative_action | respuesta de enlace del botón negativo | URL (other interface) | Igual que arriba | no |  |
| neutral_action  | respuesta de enlace del botón neutro  | URL (other interface) | Igual que arriba | no |  |
| cancel_action   | respuesta de enlace de la acción cancelar   | URL (other interface) | Igual que arriba | no |  |

<br/>

#### Sin acción

**Nombre del método:** placeholder

**Nota:** Esta interfaz no ejecuta lógica por sí misma, pero puedes usarla con callback y broadcast.

**Ejemplo:**

- [lifeup://api/placeholder?broadcast=app.lifeup.item.rest](lifeup://api/placeholder?broadcast=app.lifeup.item.rest)

<br/>

#### Marcador de variable

`LifeUp` ofrece métodos de intervención del usuario para los parámetros.

| Marcador                          | Significado                                                      | Ejemplo                                                      |
|--------------------------------------|--------------------------------------------------------------|--------------------------------------------------------------|
| [$text\|title]                       | Marcador de texto                                             | [$text\|Introduce el nombre de la Tarea]                                     |
| [$number\|Title]                     | Marcador numérico (sin decimales)                   | [$number\|Introduce el precio]                                       |
| [$number\|Title\|signed]             | Marcador numérico (sin decimales), mostrar signo        | [$number\|Introduce el precio\|signed]                               |
| [$decimal\|title]                    | Marcador numérico (con decimales)                      | [$decimal\|Introduce la tasa del cajero automático]                                   |
| [$decimal\|title\|signed]            | Marcador numérico (con decimales), mostrar signo           | [$decimal\|Introduce la tasa del cajero automático\|signed]                           |
| [$item]                              | Seleccionar un Objeto; se sustituye por el id del Objeto              | [$item]                                                      |
| [$task_category]                     | Seleccionar lista de Tareas; se sustituye por el id de la lista    | [$task_category]                                             |
| [$time\|Anchor Time\|Offset in Milliseconds(optional)] | Marcador de hora<br/><br/>Valores posibles de Anchor Time:<br/>`current`, `today`, `this_monday`, `last_monday`, `this_month`, `last_month`, `this_year`, `last_year` <br/><br/>El desplazamiento en milisegundos debe ser un entero; 0 ms por defecto | Medianoche de hoy: [$time\|today]<br/>Medianoche de mañana: [$time\|today\|86400000] |
| [$random_number\|Min\|Max]           | Marcador de número aleatorio (sin decimales)             | [$random_number\|0\|3000]                                    |
| [$random_decimal\|Min\|Max]          | Marcador de número aleatorio (con decimales)                | [$random_decimal\|1.0\|2.0]                                  |

**Ejemplo 1: al usar, seleccionar un Objeto para reducir el precio en 1 moneda**

Por ejemplo, tras configurar la API para reducir el precio de un Objeto concreto de la Tienda, puede que quieras dejar que el usuario elija el Objeto al llamar en lugar de fijar el id de antemano.

La siguiente API solo puede reducir en 1 moneda el precio del Objeto de la Tienda con id 1:

````url
lifeup://api/item?id=1&set_price=-1&set_price_type=relative
````

Basta con cambiar el id del Objeto por el marcador [$item]; al hacer la llamada, el usuario puede elegir activamente el Objeto cuyo precio quiere reducir:

<a href="lifeup://api/item?id=[$item]&set_price=-1&set_price_type=relative">lifeup://api/item?id=[$item]&set_price=-1&set_price_type=relative</a>

**Ejemplo 2: plantilla de Tarea: basta con introducir el nombre y la lista para crear una plantilla de Recompensa predefinida**

<a href="lifeup://api/add_task?todo=[$text|Enter a task name]&notes=This is a reward template for a task&coin=10&coin_var=10&exp=2048&skills=1&skills=2&skills=3&category=[$task_category]]">lifeup://api/add_task?todo=[$text|Enter a task name]&notes=This is a reward template for a task&coin=10&coin_var=10&exp=2048&skills=1&skills=2&skills=3&category=[$task_category]]</a>

<br/>

#### Callback al finalizar

Puedes añadir el parámetro callback a todas las interfaces para devolver la URL tras la llamada.

También sirve para encadenar varias interfaces; por ejemplo, si quieres un aviso tras el salto:

lifeup://api/goto?page=lab + lifeup://api/toast?text=callback

Puedes usar el parámetro callback. Consulta también el apartado **Basics - Escaping (URL Encode)** más arriba. Puedes escribir este tipo de procesamiento:

<a href="lifeup://api/goto?page=lab&callback=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dtest callback">lifeup://api/goto?page=lab&callback=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dtest callback</a>

Por supuesto, también puedes añadir varios enlaces a un Objeto de la Tienda para lograr el mismo efecto.

Además, este callback se usa sobre todo para:

aplicación X → LifeUp → aplicación X

o

aplicación X → LifeUp → aplicación Y

<br/>

#### Valor de retorno por broadcast

!> Las funciones de este apartado se usan con herramientas de automatización o desarrollo secundario, y tienen cierta curva de aprendizaje.

Al añadir este parámetro, el valor de retorno original de la API también puede enviarse por broadcast, para que herramientas como Tasker lo reciban.

El valor de broadcast equivale al de la columna de acción de «Intent Received» en Tasker. Puedes escribir cualquier texto, siempre que ambos coincidan.

**Por ejemplo, usar la API de consulta de monedas de oro con Tasker ([si usas MacroDroid, consulta este enlace.](https://github.com/Ayagikei/LifeUp/issues/43)):**

[lifeup://api/query?key=coin](lifeup://api/query?key=coin)

1. Añade el parámetro broadcast para enviar el valor de retorno a Tasker; puede ser cualquier texto, como `app.lifeup.query.coin`.

   [lifeup://api/query?key=coin&broadcast=app.lifeup.query.coin](lifeup://api/query?key=coin&broadcast=app.lifeup.query.coin)

2. Añade un evento en Tasker → «Intent Received» y escribe `app.lifeup.query.coin` en la columna de acción.

3. La tarea de Tasker puede recibir el valor de retorno de `value` como variable `%value`.

4. Luego puedes evaluar en Tasker la cantidad de monedas de oro para lograr distintos efectos. (¿Cambiar el fondo del escritorio según el número de monedas, por ejemplo?)

![](_media/api/broadcast_01.png ':size=30%')

![](_media/api/broadcast_02.png ':size=30%')

![](_media/api/broadcast_03.png ':size=30%')

![](_media/api/broadcast_04.png ':size=30%')

<br/>

---

## Notificación de eventos por broadcast

!> Las funciones de este apartado se usan con herramientas de automatización o desarrollo secundario.

> En la versión 1.90.2 emitiremos diversos eventos hacia el exterior. Puedes usar herramientas de automatización como Tasker para recibirlos y activar acciones de Tasker.
>
### Activar

**Por defecto, los eventos broadcast están desactivados.**

Puedes activarlos en `Ajustes` → `Labs` → `Modo desarrollador` → `Eventos broadcast`.

### Ejemplo: cambiar el fondo con un Objeto

1. Crea un Objeto nuevo llamado «Change Wallpaper».
2. En Tasker, ve a `Configuration file` → `Event` → `System` → `Intent Received`, escribe `app.lifeup.item.use` en la columna de operación y vuelve.
3. Pulsa New Task e introduce cualquier nombre (por ejemplo, change wallpaper).
4. Pulsa el signo + en la esquina inferior derecha para añadir una tarea, selecciona `Task` → `If`
5. Ajusta la columna de condición a `%name eq change wallpaper`.
6. Vuelve atrás; en `Insert Action` selecciona `If`.
7. Pulsa de nuevo el signo + en la esquina inferior derecha, selecciona `Display` → `Set Wallpaper`
8. (Opcional) Cambia `Type` por `All`
9. En la columna de imagen, pulsa el icono 🔍 y elige el archivo de fondo que quieras
10. Sal y comprueba que esta configuración esté activada.
11. Usa el Objeto «Wallpaper Change» en `LifeUp`; deberías ver que el fondo cambia correctamente

![](_media/api/broadcast_sample_01.png ':size=30%')

![](_media/api/broadcast_sample_02.png ':size=30%')

![](_media/api/broadcast_sample_03.png ':size=30%')

![](_media/api/broadcast_sample_04.png ':size=30%')

Usar `Sin acción` + `Valor de retorno por broadcast` puede lograr este efecto de forma más concisa; puedes explorarlo.

<br/>

### Tarea completada

**Nombre:** app.lifeup.task.complete

**Valor de retorno:**

| Parámetros  | Significado          | Ejemplos        |
| ----------- | ---------------- | --------------- |
| task_id     | id de Tarea          | 1               |
| task_gid    | id de grupo de Tareas    | 1               |
| name        | nombre de Tarea        | Getting started |
| category_id | id de categoría de Tarea | 1               |

### Tarea abandonada

**Nombre:** app.lifeup.task.giveup

**Valor de retorno:**

| Parámetros  | Significado          | Ejemplos        |
| ----------- | ---------------- | --------------- |
| task_id     | id de Tarea          | 1               |
| task_gid    | id de grupo de Tareas    | 1               |
| name        | nombre de Tarea        | Getting started |
| category_id | id de categoría de Tarea | 1               |

### Tarea vencida

**Nombre:** app.lifeup.task.overdue

**Valor de retorno:**

| Parámetros | Significado                 | Ejemplos                        |
| ---------- | ----------------------- | ------------------------------- |
| task_ids   | **array** de ids de Tarea       | [1, 2, 3]                       |
| task_gids  | **array** de ids de grupo de Tareas | [1, 2, 3]                       |
| names      | **array** de nombres de Tarea     | [Getting started, Drink Waters] |
| task_ids_json  | **array Json** de ids de Tarea   | [1, 2, 3]                       |
| task_gids_json | **array Json** de ids de grupo de Tareas | [1, 2, 3]                       |
| names_json     | **array Json** de nombres de Tarea | ["Getting started", "Drink Waters"]                      |

### Logro desbloqueado

**Nombre:** app.lifeup.achievement.unlock

**Valor de retorno:**

| Parámetros     | Significado          | Ejemplos                 |
| -------------- | ---------------- | ------------------------ |
| achievement_id | id de Logro   | 1                        |
| name           | nombre de Logro | Using LifeUp for 30 days |

### Objetos comprados

**Nombre:** app.lifeup.item.purchase

**Valor de retorno:**

| Parámetros | Significado           | Ejemplos          |
| ---------- | ----------------- | ----------------- |
| item_id    | id de Objeto           | 1                 |
| name       | nombre de Objeto         | Break 10 branches |
| amount     | cantidad comprada | 1                 |

### Objeto usado

**Nombre:** app.lifeup.item.use

**Descripción:** Se envía cuando un uso normal de Objeto o un flujo de uso de Síntesis simple tiene éxito.

**Valor de retorno:**

| Parámetros | Significado      | Ejemplos          |
| ---------- | ------------ | ----------------- |
| item_id    | id de Objeto      | 1                 |
| name       | nombre de Objeto    | Break 10 branches |
| amount     | cantidad usada | 1                 |

### Síntesis completada

> [!NOTE]
> Este evento broadcast se publicó en v1.102.8.

**Nombre:** app.lifeup.synthesis.complete

**Descripción:** Se envía cuando una Síntesis de receta se completa con éxito.

**Valor de retorno:**

| Parámetros   | Significado                            | Ejemplos                                              |
| ------------ | ---------------------------------- | ----------------------------------------------------- |
| formula_id   | id de fórmula                         | 1                                                     |
| formula_name | nombre de fórmula                       | Toolbox Recipe                                        |
| times        | veces de ejecución                    | 3                                                     |
| input_count  | número de entradas de Objeto de entrada       | 2                                                     |
| output_count | número de entradas de Objeto de salida      | 1                                                     |
| inputs_json  | array JSON de todas las entradas consumidas  | [{"item_id":7,"name":"Wood","amount":6}]              |
| outputs_json | array JSON de todas las salidas producidas | [{"item_id":9,"name":"Toolbox","amount":3}]           |

**Notas:**

- Este evento solo se envía tras una Síntesis exitosa.
- Si faltan materiales, la fórmula no existe, falla el guardado o `Eventos broadcast` está desactivado, no se envía este evento.
- Una sola llamada a la API envía un solo evento aunque `times > 1`.
- En `inputs_json` y `outputs_json`, cada elemento usa la siguiente estructura:

```json
{
  "item_id": 7,
  "name": "Wood",
  "amount": 6
}
```

- `amount` es el **total consumido / total producido** en esta ejecución, no la cantidad por fórmula.

### Reflexiones añadidas / actualizadas

**Nombre:** app.lifeup.feelings.add

**Valor de retorno:**

| Parámetros | Significado | Ejemplos |
| --- | --- | --- |
| feelings_id | id de Reflexión | 1 |
| action_type | `add` o `update` | add |
| content | texto de la Reflexión | Feeling good today! |
| create_time | marca de tiempo de creación (ms) | 1642060800000 |
| relate_type | tipo de objeto relacionado | 0 |
| related_id | id de objeto relacionado | 1 |
| attachments_count | número de adjuntos | 2 |
| attachments | array de rutas de adjuntos | ["/path/1", "/path/2"] |

### Subida de Nivel

**Nombre:** app.lifeup.level.up

**Valor de retorno:**

| Parámetros | Significado       | Ejemplos |
| ---------- | ------------- | -------- |
| skill_id   | id de Habilidad       | 1        |
| name       | nombre          | strength |
| level      | Nivel actual | 2        |

### Bajada de Nivel

**Nombre:** app.lifeup.level.down

**Valor de retorno:**

| Parámetros | Significado       | Ejemplos |
| ---------- | ------------- | -------- |
| skill_id   | id de Habilidad       | 1        |
| name       | nombre          | strength |
| level      | Nivel actual | 2        |

### Cuenta atrás de Objeto de la Tienda

**Nombre:**

- Inicio: app.lifeup.item.countdown.start
- Parada: app.lifeup.item.countdown.stop
- Finalización: app.lifeup.item.countdown.complete

**Valor de retorno:**

| Parámetros | Significado                       | Ejemplos                  |
| ---------- | ----------------------------- | ------------------------- |
| item_id    | id de Objeto                       | 1                         |
| name       | nombre de Objeto                     | play games for 30 minutes |
| time_left  | tiempo restante (milisegundos) | 30000                     |

### Ciclo de vida del Pomodoro

?> Este evento broadcast se publicó en v1.101.0 y ofrece datos de evento más completos.

**Nombre:**

- Inicio: app.lifeup.pomodoro.start
- Pausa: app.lifeup.pomodoro.pause (nuevo en v1.101.0)
- Parada: app.lifeup.pomodoro.stop
- Finalización: app.lifeup.pomodoro.complete

**Descripción:** Cuando el temporizador Pomodoro inicia, pausa, se detiene o finaliza, el sistema envía los eventos broadcast correspondientes con información de Tarea, estado del temporizador y otros datos detallados.

**Valor de retorno:**

| Parámetro          | Significado                       | Ejemplo        | Notas                                                      |
| ------------------ | ----------------------------- | -------------- | ---------------------------------------------------------- |
| task_id            | ID de Tarea                       | 1              | Opcional; solo existe cuando el Pomodoro está asociado a una Tarea |
| task_gid           | ID de grupo de Tareas                 | 1              | Opcional; solo existe cuando el Pomodoro está asociado a una Tarea |
| name               | Nombre de Tarea                     | Study English  | Nombre de Tarea asociado al Pomodoro o nombre personalizado         |
| service_type       | Tipo de servicio                  | 0              | 0=Enfoque, 1=descanso corto, 2=descanso largo                      |
| service_type_label | Etiqueta del tipo de servicio            | Focus          | Texto localizado del tipo de servicio                                |
| duration           | Duración total (milisegundos) | 1500000        | Duración total de Enfoque o descanso                           |
| remaining          | Duración restante (milisegundos) | 900000     | Duración restante actual                                 |
| elapsed            | Duración transcurrida (milisegundos) | 600000       | Tiempo transcurrido                                           |
| start              | Hora de inicio                    | 1639123456789  | Marca de tiempo Unix (milisegundos)                              |
| event_time         | Hora de activación del evento            | 1639123456789  | Marca de tiempo Unix (milisegundos)                              |
| reason             | Motivo de parada                   | user           | Solo en el evento stop; valores posibles: manual, cancel, complete, auto |

**Descripción del motivo de parada:**

El parámetro `reason` solo existe en el evento `app.lifeup.pomodoro.stop` e indica por qué se detuvo el Pomodoro:

- `manual`: el usuario lo detuvo manualmente
- `cancel`: el usuario lo canceló
- `complete`: finalizó con normalidad (nota: al completarse también se activa `app.lifeup.pomodoro.complete`)
- `auto`: se detuvo automáticamente (p. ej., Tarea eliminada)

### Ciclo de vida del cronómetro ascendente :id=broadcast_positive_timing

> [!NOTE]
> Estos eventos corresponden al cronómetro ascendente, no a los eventos de cuenta atrás Pomodoro anteriores. Antes de usarlos, asegúrate de que `Ajustes` → `Labs` → `Modo desarrollador` → `Eventos broadcast` esté activado.

**Nombre:**

- Inicio: app.lifeup.timing.start
- Pausa: app.lifeup.timing.pause
- Finalización: app.lifeup.timing.complete
- Abandono: app.lifeup.timing.abandon

**Descripción:** Cuando un cronómetro ascendente inicia, pausa, finaliza o se abandona manualmente, LifeUp envía el broadcast correspondiente. `complete` significa que la sesión terminó con normalidad y quedó registrada. `abandon` significa que la sesión actual se detuvo o descartó manualmente.

**Valor de retorno:**

| Parámetros | Significado                        | Ejemplos      | Notas                                            |
| ---------- | ------------------------------ | ------------- | ------------------------------------------------ |
| task_id    | ID de Tarea                        | 1             | Opcional; solo presente cuando el temporizador está vinculado a una Tarea |
| name       | Nombre de Tarea                      | Study English | Nombre de Tarea vinculada o nombre personalizado del temporizador          |
| time       | Duración acumulada (ms)      | 600000        | Duración total transcurrida del cronómetro ascendente actual |
| start      | Hora de inicio                     | 1639123456789 | Marca de tiempo Unix (milisegundos)                    |
| end        | Hora de fin                       | 1639127056789 | Solo presente en eventos `complete` / `abandon`    |

---

## Integración

Damos la bienvenida a cualquier forma de integración por parte de otros desarrolladores.

> Pronto añadiremos más detalles...

### ¿Necesitas más APIs?

La funcionalidad de la API está aún en una sola iteración de versión.

En el futuro seguiremos añadiendo más APIs para cubrir más escenarios de uso.

Si necesitas más APIs, puedes abrir Issues en [Github](https://github.com/Ayagikei/LifeUp/issues/new/choose).

<br/>

### Cómo llamar

#### Android

##### Usar el SDK

Consulta el módulo `core` en: https://github.com/Ayagikei/LifeUp-SDK.

##### Sin usar el SDK

```kotlin
    /**
    * Define a method to handle the uri
    */
    private fun call(context: Context, uriString: String){
        try {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(uriString)
            }
            context.startActivity(intent)
        }catch (e: Exception) {
            e.printStackTrace()
        }
    }

fun xxx() {
        ...
        // Then call it where appropriate
        call(context, "lifeup://api/toast?text=You+learned+to+call!&type=1&isLong=true")
        ...
    }
````

<br/>

#### Página web

Si la llamada se hace desde una página web, si se puede activar depende del navegador. Navegadores habituales como Quark, Chrome y Edge funcionan bien. Pero algunos navegadores integrados del sistema pueden preguntar al usuario «si desea abrir Rensheng» cada vez que aparece el aviso.

Si desarrollas tu propia aplicación con WebView embebido, debes asegurarte de que el WebView pueda manejar el esquema lifeup.

Para una experiencia uniforme, puedes usar el efecto de enlace de producto en `LifeUp` y marcar «Usar navegador integrado» para abrirlo. Por la configuración de seguridad, este método solo admite enlaces HTTPS (no HTTP).

**HTML**

Salta directamente al hipervínculo

````htm
<a href="lifeup://api/toast?text=You learned to call!&type=1&isLong=true" target="_blank" rel="noopener">Click here to call</a>
````

**Javascript**

En realidad también es un hipervínculo

````javascript
location.href='lifeup://api/reward?type=coin&content=consolation+prize&number=1'
````

<br/>

### Desarrollador de aplicación/web/automatización

¡Cuéntanos si has desarrollado algo relacionado con LifeUp!

<br/>

### Cualquier lenguaje/plataforma que admita el protocolo HTTP

Para más detalles, consulta https://github.com/Ayagikei/LifeUp-SDK y [LifeUp Cloud - HTTP APIs - Google Play](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http).
