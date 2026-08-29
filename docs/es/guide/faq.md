# Preguntas frecuentes

LifeUp la mantienen dos compañeros indie en nuestro tiempo libre:

- Un desarrollador se encarga principalmente de la app.
- Otro compañero se centra en servicios backend y operaciones.

## Detrás de la app indie

Cuando lanzamos LifeUp en 2020, las apps indie aún eran relativamente poco comunes. En 2026, desarrolladores y apps indie están por todas partes — y eso es genial.

Pero también hemos visto muchas tendencias poco recomendables: sacar una app nueva cada mes o dos y abandonarla tras el lanzamiento; apps construidas enteramente con código generado por IA sin ingeniería real detrás, llenas de errores, con mal rendimiento e imposibles de mantener; precios agresivos impulsados por el hype que saltan de decenas a cientos de dólares antes de que la app esté terminada, con mensajes urgentes en foros presionando a comprar una membresía de por vida «antes de que sea tarde»; o apps que cobran una membresía de por vida en la v1, la mantienen apenas, y de repente «reviven» con una v2.0 para vender de nuevo membresías de por vida — solo para que la app quede sin mantenimiento, se rompa o sea retirada de la tienda, dejando esas membresías de por vida sin valor.

En contraste, LifeUp está construida por desarrolladores que se preocupan por el mantenimiento a largo plazo: ~6 años de iteración continua con más de 400 versiones. Hemos mantenido el modelo de pago único, y nuestros precios se han mantenido muy por debajo de la mayoría de apps comparables, incluso tras ajustes modestos a lo largo de los años. LifeUp también ofrece de forma única una [API](/guide/api.md) y un [cliente de escritorio de código abierto](/guide/api_desktop.md), para que puedas integrar LifeUp en tus propios flujos de trabajo con IA y tus habilidades de desarrollo — o incluso construir encima de ella. LifeUp también admite copias de seguridad con exportación completa de datos, que incluyen tus archivos multimedia originales y una base de datos SQLite — así siempre eres dueño y controlas tus datos. Puedes convertirlos a formatos compatibles con otras apps, hacer que la IA los analice para generar gráficos, y más (todo ello también es posible — y más directo — mediante la API). Incluso puedes importar tu copia de seguridad directamente en [ulives](https://app.ulives.io/), nuestra nueva app para iOS.

Algunas funciones y detalles de la interfaz aún se están puliendo, y los vamos mejorando paso a paso.

Si LifeUp te ayuda, compartirla con otros también nos ayuda mucho.

Si quieres apoyar el desarrollo, también puedes invitarnos un café en la página **About** de la app.

## ⚙️ Configuración de compatibilidad

Si te encuentras con problemas como:

- recordatorios que no se disparan
- recordatorios Pomodoro o cuentas atrás de objetos que no funcionan en segundo plano
- acciones del widget que fallan (por ejemplo, no poder marcar tareas de conteo)
- problemas de actualización del widget

lee la guía de compatibilidad:

> [!WARNING]
> [Configuración de compatibilidad](/guide/compatibility.md)

## 🌍 General

<details>
<summary>Política de reembolso</summary>

LifeUp está actualmente publicada como app de pago en Google Play por razones históricas, lo que dificulta migrar a un modelo de pago tras la descarga.

Google Play puede reembolsar automáticamente tu pedido si desinstalas poco después de la compra.

Si ese reembolso automático no ocurre, contáctanos en un plazo de **7 días** en [lifeup@ulives.io](mailto:lifeup@ulives.io).
Incluye tu número de pedido GPA y envía el correo desde la misma cuenta de Google usada para la compra.

Por razones antiabuso, solo podemos ofrecer soporte de reembolso manual **una vez por usuario**.
No podemos procesar solicitudes de reembolso después de 7 días desde la fecha de compra.

Nota: las reseñas de Google Play no incluyen suficientes detalles del pedido para gestionar reembolsos.

</details>

<details>
<summary>¿Mis datos son privados y seguros?</summary>

Sí. Nos tomamos la privacidad en serio.

La mayor parte de los datos permanecen en tu dispositivo y no pasan por nuestros servidores.

La principal excepción es el módulo Mundo, donde los usuarios pueden compartir públicamente diseños y plantillas.
Todo lo compartido allí es opt-in: nada se publica a menos que elijas compartirlo, y puedes eliminar el contenido compartido en cualquier momento.

Puedes leer más en nuestra [Política de privacidad](https://wiki.lifeupapp.fun/en/#/introduction/privacy-terms).

</details>

<details>
<summary>¿Cómo puedo hacer copia de seguridad de mis datos si los servidores no los almacenan?</summary>

LifeUp admite copias de seguridad de exportación/importación y destinos de copia de seguridad en la nube.

Puedes usar:
- Archivos de copia de seguridad exportados
- WebDAV
- Google Drive
- Dropbox

</details>

<details>
<summary>¿Por qué no hay idioma XX? ¿O por qué la traducción está incompleta y se muestra en inglés?</summary>

La mayoría de idiomas en *LifeUp* los mantiene la comunidad.

A partir de 2026, usaremos traducción con IA para los idiomas principales, para mejorar la calidad base y acelerar las actualizaciones.

Las revisiones y correcciones de la comunidad siguen siendo muy bienvenidas.

Puedes contribuir aquí: [Crowdin - LifeUp](https://crowdin.com/project/lifeup).

</details>

<details>
<summary>¿Puedo ocultar el módulo Mundo si no lo necesito?</summary>

Sí.

Puedes personalizar la barra de navegación inferior en:
`barra lateral` → `Ajustes` → `Aspecto` → `Ajustes de módulos`.

Desde ahí, puedes ocultar el módulo Mundo o reemplazarlo por otro módulo.

</details>

<details>
<summary>El podómetro es impreciso, o no necesito este módulo</summary>

> Puedes tocar el icono de interrogación junto al podómetro en la app para ver cómo funciona.

- Para mayor precisión, abre la app por la mañana y por la tarde, y evita reiniciar el dispositivo con frecuencia.
- También puedes introducir el recuento de pasos manualmente.
- Si no lo necesitas, oculta el podómetro en `Ajustes` → `Aspecto`.

</details>

## ✅ Tareas

<details>
<summary>¿Puedo ocultar el diálogo de recompensa al completar una tarea?</summary>

Sí. En el flujo normal de finalización, el diálogo de recompensa aparece solo cuando una tarea tiene recompensas configuradas, como Puntos de Experiencia (XP) u Objetos. Si dejas las recompensas sin configurar, completar la tarea no mostrará este diálogo.

También recomendamos elegir un intervalo de finalización sensato en lugar de dividir una actividad en muchas tareas pequeñas. Esto reduce tanto el trabajo de configuración como el número de acciones de finalización.

Si quieres mantener las recompensas pero omitir los diálogos de finalización, puedes usar cualquiera de estas opciones:

- **Quick Complete:** Activa `Finalización rápida` en la esquina superior derecha de la lista de tareas. Una vez activado, tocar el círculo completa una tarea directamente sin mostrar el diálogo de recompensa.
- **Deslizar para completar:** Ve a `barra lateral` → `Ajustes` → `Tarea` → `Swipe` → `Acción al deslizar la tarjeta`. Selecciona `Deslizar a la izquierda` o `Deslizar a la derecha`, y luego configura la acción como `Terminar (sin diálogo)`.

Ambas opciones sin diálogo siguen otorgando las recompensas configuradas, pero también omiten otros diálogos de finalización, incluida la entrada de Reflexiones y el uso automático de objetos.

</details>

<details>
<summary>¿Cómo deshago una tarea completada?</summary>

Puedes deshacer la finalización en varios lugares:

1. Justo después de completar, toca **Undo** en el aviso inferior.
2. En `barra lateral` → `Historial`, toca `Deshacer`.
3. En `Calendario` → `Terminado`, toca `Deshacer`.

Si la fecha límite de la tarea ya ha pasado, el deshacer directo no está disponible.
En ese caso, edita el estado del registro (por ejemplo, configúralo como vencido o abandonado).

</details>

<details>
<summary>¿Cómo marco una tarea vencida como completada?</summary>

Cuando una tarea se vence, aparece un diálogo de vencimiento que te permite marcarla como completada.

Tras cerrar el diálogo, aún puedes actualizar el estado de la tarea más tarde desde:
- `barra lateral` → `Historial`
- `Calendario` → `Terminado`

</details>

<details>
<summary>¿Hay penalización de EXP/monedas por fallar una tarea?</summary>

Sí.

- La penalización de EXP está activada por defecto (factor: `0.2x`).
- La penalización de monedas está desactivada por defecto (factor: `0`).

Puedes cambiar la configuración global en:
`barra lateral` → `Ajustes` → `Avanzado`

También puedes configurar penalizaciones por tarea en el editor de tareas.

</details>

<details>
<summary>¿Cómo funciona el mecanismo de repetición?</summary>

Configura solo la `Hora de inicio`, `deadline`, frecuencia de repetición y hora de recordatorio opcional del **primer** ciclo.

LifeUp calculará los ciclos posteriores automáticamente.

</details>

<details>
<summary>¿Cómo configuro una tarea que debe completarse N veces de forma irregular dentro de un periodo?</summary>

LifeUp aún no tiene una configuración directa para «al menos/como máximo N veces por ciclo». Sin embargo, puedes lograrlo de varias formas:

| Método | Configuración | Ventajas | Desventajas |
| :--- | :--- | :--- | :--- |
| **Counting Task** | Configura la frecuencia en `Cada semana`, activa `Tarea de recuento`, establece el conteo (p. ej., 3). | Configuración sencilla; el progreso es claro (p. ej., 1/3). | **Las recompensas solo se otorgan tras completar el conteo final.** Sin recompensa por finalizaciones individuales. |
| **Infinite Task + Target** | Configura la frecuencia en `Ilimitadas`, el conteo objetivo en 3, la fecha límite en domingo. | **Las recompensas se otorgan en cada finalización.** | **Debe recrearse manualmente cada semana** (ya que la tarea termina tras completarse). |
| **Subtasks** | Configura la frecuencia en `Cada semana`, añade 3 subtareas dentro. | Puedes configurar recompensas y recordatorios individuales para cada finalización. | Requiere entrar en la página de detalle para marcar subtareas; deben crearse manualmente una a una (adecuado solo para conteos pequeños). |
| **Infinite Task (Stats Only)** | Configura la frecuencia en `Ilimitadas`. | Configuración más sencilla; recompensas y estadísticas en cada finalización. | **Sin restricción forzada.** Debes revisar tus estadísticas manualmente para ver si cumpliste la meta semanal. |

> [!NOTE]
> Estamos considerando añadir una función de «Recompensa en tiempo real» para **Counting Tasks** (recompensar cada conteo de inmediato), que actualmente está en evaluación.

</details>

<details>
<summary>¿Cómo oculto tareas completadas o no iniciadas?</summary>

Esto suele ocurrir en uno de estos casos:

1. Si una tarea muestra `xx deadline`, esa tarea ya ha comenzado.
   - Edita la tarea y ajusta la `Hora de inicio` si es necesario.

2. Si una tarea muestra `xx starts` y la fecha no es hoy:
   - Comprueba si el botón plegable inferior está colapsado.
   - Abre el menú superior derecho (`...`) → `Filtro`.
   - Confirma que `Mostrar Hoy` está activado.

> Nota:
> - Las listas inteligentes (semana/mes) no admiten plegado.
> - Para tareas repetitivas, un ciclo completo es válido por defecto. Por ejemplo, un ciclo de 21 días puede completarse en cualquiera de esos 21 días. Si solo quieres que sea visible cerca del final, ajusta la hora de inicio una vez y deja que LifeUp calcule los ciclos posteriores automáticamente.

</details>

<details>
<summary>¿Cómo evito que las tareas se vuelvan vencidas a medianoche?</summary>

El momento del vencimiento lo controla la hora límite de la tarea.

Tras configurar la fecha límite, toca el botón `time` y elige una hora más tardía.

Por ejemplo, si no quieres que un objeto expire a las `00:00`, configura la hora límite en algo como `02:00` (día siguiente).

También puedes cambiar los valores predeterminados globales en:
`Ajustes` → `Item` → `Ajustes por defecto para nuevas tareas`

(Cambiar los predeterminados no afecta a los objetos existentes.)

</details>

<details>
<summary>¿Por qué el número objetivo de veces empieza desde 1/N?</summary>

A diferencia de las tareas de conteo, (1/N) **aquí no representa el progreso total.**

En su lugar, **indica el recuento de repetición actual. Si esta repetición está completa se muestra con ⚪ o ✅.**

<br/>

Por ejemplo, ⚪1/10 significa:
Esta tarea se repetirá 10 veces en total (se generarán 10 tarjetas en total), y actualmente está en la 1.ª vez y no se ha completado.

Y ✅1/10 significa:
La tarjeta actual pertenece a la 1.ª vez y está completada.

Si se usara el progreso total, las tarjetas completadas mostrarían estados confusos como (⚪1/10 y ✅1/10 coexistiendo). Además, las tarjetas podrían desaparecer al alcanzar la meta (p. ej., ✅9/10), lo cual es contraintuitivo.

</details>

<details>
<summary>¿Cómo configuro varios recordatorios para una tarea?</summary>

Crea subtareas y asigna descripciones/horas de recordatorio distintas a cada una.

Esta es la forma recomendada de simular varios recordatorios para una tarea principal.

</details>

<details>
<summary>¿Pueden mostrarse las subtareas directamente en la lista de tareas?</summary>

De momento, no. Podríamos considerarlo en futuras actualizaciones.

</details>

## 🎁 Recompensas (Puntos de Experiencia, bienes)

<details>
<summary>¿Puedo asignar distintos valores de EXP a distintos Atributos para una tarea?</summary>

No directamente en la versión actual.

Para una configuración rápida, una tarea usa actualmente un valor de EXP por Atributo. Si necesitas distintos valores de EXP por Atributo, usa este workaround:

1. Crea un objeto.
2. Configura distintos efectos de EXP para distintos Atributos en ese objeto.
3. Configura el objeto para que se use automáticamente tras completar la tarea.

Esto te da la finalización de tarea + efecto del objeto como un flujo de recompensa combinado.

Planeamos mejorar el soporte nativo para esto en futuras versiones.

</details>

<details>
<summary>¿Cómo se calculan automáticamente EXP y monedas?</summary>

EXP depende principalmente de:
- `Dificultad`
- `Urgencia`
- `number of selected attributes`

Las monedas dependen principalmente de:
- `Dificultad`
- `Urgencia`

</details>

<details>
<summary>¿Cómo se calcula el Nivel de vida?</summary>

El EXP del Nivel de vida está relacionado positivamente con el EXP obtenido de cualquier Atributo.

Cuando se aplican penalizaciones, el EXP del Nivel de vida también se reduce proporcionalmente.

El Nivel de vida está diseñado como un indicador amplio y agregado, por lo que no recomendamos obsesionarse con la fórmula.

Lo más importante es que refleje tu progreso general a largo plazo.

Referencia de fórmula: cada acción de ganancia/pérdida de EXP contribuye 1/5 al EXP del Nivel de vida, independientemente de cuántos Atributos se recompensen en esa acción.

</details>

<details>
<summary>¿Puedo configurar recompensas personalizadas de EXP y monedas para tareas?</summary>

Sí.

Al crear una tarea o un Logro, toca el botón de recompensa correspondiente y configura los valores manualmente.

</details>

<details>
<summary>¿Por qué faltan las imágenes de objetos o no se muestran?</summary>

LifeUp es *offline-first*, por lo que las imágenes de objetos se almacenan localmente en tu dispositivo.

Si faltan imágenes, revisa qué ocurrió recientemente:

**Tras importar una copia de seguridad:**
- La copia de seguridad puede no incluir archivos de imagen.
- Vuelve a importar una copia de seguridad completa que incluya imágenes.

**Tras operaciones de limpieza/gestión de archivos:**
- LifeUp no elimina archivos de imagen de forma activa.
- Herramientas de limpieza o gestión de archivos de terceros con permisos amplios pueden eliminarlos por error.
- Usa esas herramientas con cuidado.

**Para objetos importados desde Mundo:**
- Puede ser un problema temporal de carga de red.
- Inténtalo de nuevo más tarde, o reemplázalos con imágenes locales.

Si aún tienes una copia de seguridad antigua con imágenes, puedes restaurar esa copia primero para recuperar los medios, y luego restaurar tu copia de datos más reciente.

</details>

<details>
<summary>¿Cómo elimino un objeto de la Tienda?</summary>

En la página `Tienda`, mantén pulsado el objeto y luego toca el botón `Eliminar` en la parte superior.

</details>

<details>
<summary>¿Cómo borro EXP y monedas?</summary>

Ve a:
`barra lateral` → `Ajustes` → `Respaldo/Restauración/Borrar Datos`

Puedes borrar los valores de EXP y monedas allí.

Nota: si usas funciones en línea, las visualizaciones relacionadas en el servidor pueden tardar un breve periodo en actualizarse.

</details>

<details>
<summary>¿Cuáles son los límites de Nivel y los gradientes de experiencia para Atributos?</summary>

Puede considerarse que tiene Niveles ilimitados (actualmente 2000+, difíciles de alcanzar por medios normales).

La experiencia requerida para cada Nivel escala hacia arriba, aunque el gradiente actual es pronunciado. (Por ello, las recompensas no deben evaluarse solo por los límites de Nivel; el límite de experiencia es aproximadamente 2^63).

De hecho, muchos usuarios permanecerán en el gradiente de 2500 EXP durante mucho tiempo. Podríamos optimizar el sistema de Niveles o permitir personalización en el futuro. (Los puntos de experiencia totales no se verán afectados).

| Nivel    | Puntos de Experiencia requeridos para cada Nivel |
| -------- | ------------------------------------------------- |
| 1 → 2     | 300                                               |
| 2 → 3     | 700                                               |
| 3 → 4     | 1500                                              |
| 4 → 99    | 2500                                              |
| 99 → 150  | 5000                                              |
| 150 → 200 | 7500                                              |
| 200 → 250 | 15000                                             |
| 250 → 300 | 30000                                             |
| 300 → 325 | 50000                                             |
| 325 → 350 | 100000                                            |
| >350     | 500000                                            |

</details>

<details>
<summary>¿Cómo configuro préstamos, interés del cajero automático e interés de préstamos?</summary>

En la página `Tienda`, abre el menú superior derecho (`...`) y selecciona `Ajustes`.

</details>

<details>
<summary>¿Cómo personalizo Atributos o Habilidades?</summary>

Ve a:
`barra lateral` → `Ajustes` → `Ajustes personalizados` → `Personalizar atributos`

Puedes personalizar Atributos existentes, crear nuevos Atributos para Habilidades y eliminar Atributos según necesites.

Si quieres hacer seguimiento de Habilidades, crea Atributos con el nombre de la habilidad (por ejemplo, `Fishing` o `Programming`).

</details>

<details>
<summary>¿Puedo modificar los Atributos usados por recompensas deportivas o recompensas por likes en Mundo?</summary>

No en la versión actual.

Estas asignaciones de recompensa integradas están fijas por ahora.

</details>

<details>
<summary>¿Cómo configuro recompensas de Caja de botín?</summary>

Al crear un objeto de la Tienda, añade un efecto `Caja de botín` a ese objeto.

Luego configura el pool de recompensas, la probabilidad y ajustes relacionados en ese efecto.

</details>

<details>
<summary>¿Puedo configurar una probabilidad de Caja de botín inferior al 1%?</summary>

Sí.

Tras configurar el efecto Caja de botín, toca el botón de ayuda `?` en la app para detalles de probabilidad y guía de configuración.

</details>

<details>
<summary>¿Cómo puedo obtener más iconos?</summary>

Somos un equipo indie pequeño y actualmente no podemos mantener un gran conjunto de iconos integrados.

Puedes obtener más iconos de estas formas:

1. Importa objetos desde `Mundo` → `Mercado` y reutiliza sus iconos.
2. Usa recursos de iconos externos (asegúrate de que los derechos de uso sean válidos):
   - [iconfont](https://www.iconfont.cn/)
   - [Flaticon](https://www.flaticon.com/)
3. Si es posible, prefiere iconos con fondo transparente para una mejor visualización en la app.

</details>

<details>
<summary>¿Qué hacer si las imágenes de productos no se pueden mostrar o faltan?</summary>

LifeUp es una app sin conexión. Las imágenes de productos se guardan en tu dispositivo y se almacenan de forma segura en el directorio privado de la app. No podemos investigar directamente los cambios de archivos en tu dispositivo.

Si las imágenes de productos se pierden o no se pueden mostrar, piensa en qué operaciones realizaste recientemente:

**Si faltan imágenes tras restaurar una copia de seguridad:**
- Suele deberse a que el archivo de copia de seguridad no contiene archivos de imagen
- Debes volver a importar una copia de seguridad completa que incluya archivos de imagen

**Si las imágenes se eliminaron accidentalmente:**
- LifeUp en sí no elimina archivos de imagen de forma proactiva
- Si usaste recientemente la función de gestión de imágenes, puede que hayas eliminado imágenes por error y puedas intentar restaurarlas desde una copia de seguridad
- Además, algunas apps de limpieza del sistema con permisos elevados también pueden eliminar archivos de imagen; usa esas apps con precaución
- Si tienes una copia de seguridad antigua con imágenes, haz primero copia de los datos actuales, luego restaura la copia antigua para recuperar las imágenes, y después restaura tus datos actuales

**Si las imágenes de productos importadas desde el módulo Mundo no se pueden mostrar:**
- Puede deberse a problemas de red
- Inténtalo de nuevo más tarde, o reemplaza la imagen del producto con una imagen local

**En casos raros, defectos del sistema pueden causar pérdida de imágenes:**
- Según nuestro conocimiento, ciertas versiones personalizadas del sistema de algunos fabricantes han tenido defectos: cuando la app se bloquea repetidamente, puede borrar incorrectamente los datos de la app, causando la pérdida de datos y archivos de imagen. Mantén tu sistema actualizado. Además, no podemos descartar que aún existan defectos del sistema que puedan causar problemas anómalos, ya que están fuera del control de la app. Recomendamos hacer copias de seguridad con frecuencia
- En casos extremos, almacenamiento inestable del dispositivo o problemas de hardware también pueden causar pérdida de archivos de imagen. Considera hacer copias de seguridad en la nube con regularidad o reemplazar el dispositivo

</details>

## ⏰ Recordatorio / Pomodoro / Cuenta atrás

<details>
<summary>¿Cómo uso el efecto de cuenta atrás de un objeto de la Tienda?</summary>

Los efectos de cuenta atrás se entregan como notificaciones de la app.

Primero, confirma que el permiso de notificaciones para LifeUp está activado.

</details>

<details>
<summary>¿El Pomodoro admite auto-siguiente?</summary>

De momento, no.

Puedes probar el modo de temporizador ascendente.

En modo Pomodoro, cuando termina una sesión de trabajo, el temporizador sigue contando hacia arriba. Luego puedes decidir si añadir tiempo extra a los registros de Enfoque. El auto-siguiente entraría en conflicto con este flujo de trabajo.

</details>

<details>
<summary>¿Cómo inicio Pomodoro rápidamente desde la lista de tareas?</summary>

Puedes:
1. Mantener pulsada una tarea y tocar `Temporizador` en el menú de acciones.
2. O configurar una acción de deslizamiento como `Temporizador` en la configuración de `Tareas`.

</details>

<details>
<summary>¿El Pomodoro ofrece estadísticas resumidas como las apps Pomodoro dedicadas?</summary>

Aún no.

El Pomodoro de LifeUp sigue siendo un módulo ligero en desarrollo temprano.

Actualmente disponible:
- Registros detallados por sesión
- Estadísticas resumidas diarias básicas en la página `Estado`

</details>

## 💾 Copia de seguridad y restauración

<details>
<summary>¿Cómo hago copia de seguridad de los datos?</summary>

Lee primero la [Guía de copia de seguridad y restauración](/guide/backup.md).

En resumen, los métodos de copia de seguridad admitidos incluyen:
- Google Drive (recomendado)
- Dropbox
- Exportar archivos de copia de seguridad
- Servidores WebDAV

</details>

<details>
<summary>¿Por qué LifeUp está diseñada como app offline-first?</summary>

LifeUp sigue una arquitectura offline-first por diseño.

Esto significa:
- Tus datos te pertenecen y los controlas tú.
- Los datos permanecen locales a menos que elijas explícitamente opciones de copia de seguridad/sincronización.
- La mayoría de funciones principales siguen funcionando sin acceso a red.

Como el cliente gestiona la lógica principal localmente, puedes seguir usando LifeUp incluso cuando la red o la disponibilidad del servidor son limitadas (excepto funciones en línea como el módulo Mundo).

</details>

## 🧭 Planificación

<details>
<summary>¿Añadiréis funciones de IA?</summary>

LifeUp es una app de bajo coste y pago único mantenida por un equipo pequeño. Integrar funciones de IA listas para usar directamente (donde nosotros cubrimos los costes de la API) no es realista dado nuestro modelo de precios — a menos que pasáramos a un modelo de suscripción o multiplicáramos varias veces el precio único para igualar los costes operativos de las apps de IA modernas. No vamos a hacer eso.

Dicho esto, LifeUp es inherentemente compatible con la IA:

1. Expusimos gran parte de la [API](/guide/api.md) y la funcionalidad principal desde el principio, lo que la hace naturalmente compatible con agentes de IA y herramientas de terceros. Las herramientas de IA con capacidades de agente ya pueden invocar directamente las funciones de LifeUp — crear Tareas, Objetos y más. De hecho, hemos visto a muchos usuarios compartir flujos de trabajo que combinan IA con nuestra API, incluidos servidores MCP personalizados de la API de LifeUp, herramientas de automatización para entradas de diario generadas por IA, y más.

2. Planeamos introducir capacidades de IA BYOK (Bring Your Own API Key) en el futuro. Así podrás usar tu propia clave para impulsar funciones de IA sin que nosotros asumamos los costes continuos de la API.

3. Al fin y al cabo, la IA no es magia — de lo contrario, podrías igualmente combinar IA con nuestra API para lograr la integración completa tú mismo.

</details>

<details>
<summary>¿Habrá una versión iOS de LifeUp?</summary>

En **2025**, lanzamos [ulives](https://app.ulives.io/), una nueva app de productividad multiplataforma para usuarios de iOS (también en iPadOS y Mac con Apple Silicon).

Un port directo de LifeUp a iOS no es realista:

- LifeUp está construida con tecnología nativa de Android.
- Su arquitectura offline-first vincula la interfaz, el modelo de datos local y la lógica de negocio estrechamente a la implementación de Android.
- Un port directo aún requeriría reescrituras importantes para mantener datos y lógica consistentes.

Por eso reorganizamos y reconstruimos con una dirección multiplataforma a través de ulives.

ulives mantiene el espíritu central de LifeUp y además aborda varios problemas de diseño y producto de larga data de generaciones anteriores. Puedes pensar en ella como una evolución fresca, no solo un clon uno a uno.

**La membresía de LifeUp no desbloquea ulives**, pero puedes importar una copia de seguridad de LifeUp (unidireccional, potencialmente con pérdidas). Consulta [¿Qué es ulives?](/guide/faq?id=ulives_overview). Para razones más detalladas, consulta el documento de comparación: [ulives vs LifeUp — Comparison](https://app.ulives.io/docs/comparison-with-lifeup).

</details>

<details id="ulives_overview">
<summary>¿Qué es ulives? ¿Comparte membresía o datos con LifeUp?</summary>


[ulives](https://app.ulives.io/) es una **reescritura desde cero** con tecnología multiplataforma (KMP). Hereda la filosofía de gamificación de LifeUp, pero el código, el equipo, los precios y los planes a largo plazo son independientes — una sucesora espiritual, **no** un port iOS de LifeUp.

**¿Por qué las membresías son independientes?**

- **El precio de LifeUp refleja el alcance solo Android:** LifeUp siempre se ha construido con tecnología puramente nativa de Android. Su precio de membresía de por vida muy bajo se definió en torno a **tener solo un cliente Android** — nunca estuvo pensado para comprar el mantenimiento de cada app futura que pudiéramos construir.
- **El precio de ulives refleja el coste multiplataforma y la mantenibilidad a largo plazo:** ulives es una reescritura completa con código multiplataforma, un equipo aún no totalmente unificado y trabajo continuo para iOS más futuros objetivos Android y HarmonyOS. Premium se define por **desarrollo sostenible y mantenibilidad a largo plazo**, no por copiar la división histórica gratis/de pago de LifeUp.
- **Equipos de desarrollo distintos:** Un port iOS de LifeUp avanzó lentamente por varias razones. Reorganizamos un equipo dedicado para ulives (aún pequeño hoy) para lanzar un producto multiplataforma más rápido y con más flexibilidad.
- **Ecosistemas de tienda separados:** App Store y Google Play son sistemas de pago y derechos independientes. Las licencias no pueden transferirse directamente entre las dos apps.

**En resumen:**

- **La membresía de LifeUp ↔ la membresía de ulives no se transfieren:** Una compra de LifeUp en Google Play **no** desbloquea ulives en App Store, y viceversa. Cada app requiere su propia compra.
- **Importación unidireccional de datos:** Desde ulives 1.7.22, puedes importar una copia de seguridad de LifeUp (`.lfbak`) en ulives. La conversión puede ser con pérdidas, y la importación **no** se transfiere de vuelta a LifeUp.
- **La importación no transfiere tu licencia:** Las copias de seguridad mueven datos de uso (Tareas, Objetos, etc.), no los derechos de membresía de LifeUp.

**ulives Premium en todas las plataformas de ulives:**

ulives también lanzará su propio cliente **Android** (y soporte nativo HarmonyOS, etc.). **Premium comprado para ulives está pensado para funcionar en todas las plataformas de ulives** — iOS, Android, HarmonyOS — una vez que la gestión de cuentas del lado del servidor esté lista. Los casos multiplataforma tempranos pueden requerir contactarnos.

**Ambas apps ofrecen membresía de por vida muy por debajo de la mayoría de productos comparables** — pero los precios de referencia deben leerse en contexto: el alcance mono-plataforma vs multiplataforma, el coste de desarrollo y el mantenimiento a largo plazo difieren.

Para razones más detalladas (modelo de precios, sostenibilidad, inversión en desarrollo y planes futuros de ambas apps), consulta el documento de comparación: [ulives vs LifeUp — Comparison](https://app.ulives.io/docs/comparison-with-lifeup). FAQ de ulives: [https://app.ulives.io/docs/faq](https://app.ulives.io/docs/faq)

</details>

## 🆘 ¿Aún necesitas ayuda?

<details>
<summary>Contáctanos</summary>

Puedes escribirnos a [lifeup@ulives.io](mailto:lifeup@ulives.io).

También puedes abrir un issue en GitHub:
[https://github.com/Ayagikei/LifeUp/issues](https://github.com/Ayagikei/LifeUp/issues)

</details>

<details>
<summary>¿Te gustaría apoyarnos?</summary>

Gracias por apoyar LifeUp.

Si LifeUp te ha sido útil, puedes apoyarnos de dos formas sencillas:

1. Invítanos un café desde la página **About** en la **versión de Google Play** de la app.
2. Ayuda a que más personas descubran LifeUp compartiendo tu experiencia:
   - Recomienda LifeUp a amigos
   - Publica tus historias de uso y flujos de trabajo
   - Comparte consejos, guías o tutoriales

</details>
