# Notas de la versión

## Cronología

![timeline](_media/release_log/timeline.png)

## Notas

| Plataforma        | Versión                | Fecha de actualización      |
| :---------------- |:-----------------------|:----------------------------|
| LifeUp-Android    | v1.105.3              | 2026/08/26                  |
| LifeUp-iOS        | consulta [feature/ulives] | 🎉App alternativa disponible |
| LifeUp-Desktop    | v1.2.0                 | 2025/01/01                  |
| LifeUp Cloud(SDK) | v2.1.1                 | 2026/06/16                  |

(Parte de la traducción se ha generado con traducción automática o IA y puede contener imprecisiones)

<!-- tabs:start -->

### **LifeUp-Android**

**v1.105.3 (2026/08/26)**

**🐛 Correcciones de errores**

1. **Corregida la finalización anómala de Tareas al convertir localmente una tarea de equipo en una tarea cronometrada.**

**v1.105.2 (2026/08/24)**

**🐛 Correcciones de errores**

1. **Corregido el selector de Tareas que mostraba una lista vacía al elegir una lista inteligente.**
2. **Corregida la búsqueda en una lista inteligente que también mostraba Tareas que no pertenecían a esa lista.**

**v1.105.1 (2026/08/19)**

**✨ Novedades**

1. **Los efectos de sonido personalizados se pueden desactivar por escena**: silencia una señal sin afectar a las demás; la vista previa sigue reproduciéndose para que puedas comprobar el sonido.

**♻️ Optimización**

1. **Guía de respaldo más clara cuando los servicios de Google Play no están disponibles**: si no se puede usar Google Drive, la App explica el motivo y sugiere un archivo local, Dropbox o WebDAV.

**🐛 Correcciones de errores**

1. **Corregido el botón Deshacer en la página Completadas del calendario, que no respondía al pulsarlo.**
2. **Corregidos los límites de compra/uso que no se restauraban (o se guardaban vacíos) al editar un Objeto.**

**v1.105.0 (2026/08/04)**

**ℹ️ Nota importante**

1. **Android 6.0 pasa a ser la versión mínima compatible**: para dar soporte proactivo a funciones y requisitos de comportamiento de versiones más recientes de Android, la versión mínima compatible se ha elevado de Android 5.0 a Android 6.0. Los usuarios de Android 5.x no pueden instalar ni actualizar a esta versión.

**✨ Novedades**

1. **Nueva API URL Scheme para controlar el Pomodoro**: los usuarios pueden consultar el estado, seleccionar una Tarea e iniciar, pausar, omitir, abandonar o completar sesiones Pomodoro o de cronómetro ascendente.
2. **Mejorado el mecanismo de orden personalizado de Tareas**: se ha introducido un nuevo mecanismo de ordenación para mantener estable el orden personalizado al copiar, completar, deshacer y gestionar Tareas en otros casos límite.

**♻️ Optimización**

1. **Compatibilidad con retroceso predictivo de Android**: los editores de Tareas, Tienda, Síntesis y Logros admiten ahora el gesto de retroceso predictivo del sistema.
2. **Mejorada la inicialización del inicio de sesión con Facebook**: el SDK se inicializa al solicitar el inicio de sesión, con mejor gestión de estados de error.

**🐛 Correcciones de errores**

1. **Corregidas las solicitudes URL Scheme de edición que sobrescribían campos existentes de forma inesperada**: los campos omitidos conservan ahora sus valores anteriores, y los parámetros de Recompensa o relación no válidos ya no borran los datos existentes.
2. **Corregidos los títulos de notificación del temporizador ascendente que no seguían la Tarea seleccionada en ciertos casos límite.**
3. **Corregida la vista previa RGB que no se actualizaba tras pegar el primer valor de color hexadecimal.**
4. **Corregidas las sombras ausentes en la barra de herramientas de selección en las páginas de detalle de Síntesis y Logros.**

**v1.104.6 (2026/07/19, Google Play)**

**🐛 Correcciones de errores**

1. **Corregida la restauración incorrecta de sesiones Pomodoro tras una detención inesperada de la App o del servicio del temporizador**: las sesiones válidas se restauran correctamente y se elimina el estado obsoleto no válido.
2. **Corregidos los avisos repetidos tras un cambio de zona horaria del sistema**: tras confirmar el ajuste, las horas de las Tareas se actualizan correctamente sin volver a mostrar el mismo aviso.

**v1.104.5 (2026/07/17)**

**🐛 Correcciones de errores**

1. **Corregido un problema en la compilación de la versión v1.104.4 en el que abrir la página Pomodoro podía provocar un cierre inesperado de la App.**

**v1.104.4 (2026/07/17)**

**✨ Novedades**

1. **Los Objetos admiten ahora restricciones de compra/uso según rangos de Puntos de Experiencia de Atributos**: define condiciones mínimas y máximas de XP para controlar si un Objeto se puede comprar, usar o ambas cosas.
2. **Nueva condición de Logro por completar Tareas un total de N veces en un día**: a diferencia de la condición existente de Tareas distintas, esta condición cuenta cada finalización válida de Tarea ese día, incluidas repeticiones de la misma Tarea.

**♻️ Optimización**

1. **Reconstruido el flujo de liquidación y recuperación del Pomodoro**: el estado del temporizador, los registros de Enfoque y la liquidación de Recompensas siguen ahora un proceso unificado. La recuperación también es más fiable si se termina el proceso de la App, reduciendo casos límite como la pérdida de tiempo de Enfoque. Si notas cambios de comportamiento inesperados, escríbenos a lifeup@ulives.io.
2. **Edición de cantidades más fluida en recetas de Síntesis**: pulsa un ingrediente o resultado existente para editar su cantidad directamente, sin volver a seleccionar el mismo Objeto. Puedes volver a seleccionar el Objeto cuando lo necesites.
3. **El Pomodoro se puede abrir ahora en horizontal directamente desde la página de inicio**: consulta y controla el temporizador con más comodidad en disposición horizontal.

**v1.104.3 (2026/07/09)**

**✨ Novedades**

1. **Nueva guía «Configuración rápida» en la pantalla de bienvenida**: dos páginas nuevas (5 y 6) tras las tarjetas introductorias permiten configurar permisos de notificación, método de recordatorio, estilo de interfaz (Material 2/3) y visualización en ventanas múltiples desde el onboarding, con tarjetas en acordeón. Todas las opciones se pueden ajustar más tarde en Ajustes.

**♻️ Optimización**

1. **Texto introductorio de la página de bienvenida actualizado**: las páginas 1–4 se han reescrito para comunicar mejor el valor principal de la App: Tareas personalizadas → crecimiento de estadísticas → sistema de Recompensas → conexión con el mundo.
2. **Diálogo de Síntesis rediseñado como hoja inferior**: materiales y resultados se muestran ahora en una cuadrícula vertical, con un diseño más limpio e intuitivo.
3. **Carga de datos más rápida al cambiar entre listas de pendientes, modificar el orden o alternar la agrupación**.

**🐛 Correcciones de errores**

1. **Corregidas las notificaciones duplicadas de «Logro desbloqueado»** para ciertos Logros del sistema.
2. **Corregido el recuento inexacto del Logro «Completar N Tareas distintas al día»**: las Tareas infinitas ya no se excluyen, y completar la misma Tarea varias veces el mismo día cuenta como una.
3. **Corregido el botón de añadir (+) de la lista de Tareas que a veces se desplazaba de su posición correcta**.
4. **Corregidas las listas inteligentes que no filtraban Tareas archivadas cuando «Agrupar por lista» estaba desactivado**.

**v1.104.2 (2026/07/03)**

**✨ Novedades**

1. **«Días de uso» renombrado a «Días de compañía» en la página de estadísticas**: pulsa la tarjeta para personalizar la fecha de inicio y definir tu propio aniversario. Las descripciones de condiciones de Logros relacionadas también usan la terminología de «compañía».
2. **Opción «Copia de seguridad y compartir» añadida al menú de respaldo**: comparte archivos de respaldo directamente con otras apps mediante el panel de compartir del sistema.
3. **API de efectos de Caja de botín v2**: una nueva ruta `loot_box/v2` admite coincidencia precisa de Objetos mediante `sub_amount`, añadir/eliminar Objetos y control independiente de modos de cantidad y probabilidad.

**♻️ Optimización**

1. **URL Scheme prioriza ahora la coincidencia exacta por nombre** al editar Objetos de la Tienda, Cajas de botín o subtareas, recurriendo a coincidencia aproximada solo si no hay coincidencia exacta, evitando ediciones no deseadas.
2. **«FAQ» de la barra lateral renombrado a «Notice» en inglés**: la versión en chino ya era «公告» y no cambia.
3. **Efectos de onda de los botones alineados con el radio de esquina en todas partes**: las animaciones de onda en controles redondeados ya no se desbordan más allá de las esquinas, haciendo que los toques se sientan más pulidos en toda la App.

**🐛 Correcciones de errores**

1. **Corregida la página Pomodoro que no actualizaba automáticamente el recuento de tomates tras añadir o editar un registro.**
2. **Corregido el aviso de tomates obtenidos que a veces no aparecía tras añadir un registro Pomodoro.**
3. **Corregidos los registros Pomodoro añadidos manualmente que calculaban tomates según la Tarea seleccionada en ese momento en lugar de la Tarea elegida en el registro**: el cálculo usa ahora la duración de Enfoque específica de la Tarea realmente seleccionada en el registro. Si has definido duraciones de Enfoque distintas para distintas Tareas, los tomates registrados manualmente serán más precisos.
4. **Corregida la visualización incorrecta del «recuento de finalizaciones» para Tareas ilimitadas en el historial**: ahora se muestra como ordinal diario (p. ej., «la N.ª vez ese día»).
5. **Corregido el texto de motivación de Tareas con penalización que no aparecía**: ahora se muestra tras completar la penalización.

**v1.104.1 (2026/06/17)**

**✨ Novedades**

1. **Opciones de exportación de respaldo mejoradas**: al crear una copia manual, una nueva hoja inferior permite elegir si incluir archivos multimedia, información sensible de la cuenta (estado de inicio de sesión, credenciales WebDAV, etc.) e imágenes emoji, facilitando compartir una copia depurada. La sección de respaldo automático también incluye tres interruptores persistentes correspondientes.
2. **Selector de Tareas del Pomodoro mejorado**: las Tareas cronometradas aparecen primero en el selector con su progreso de Enfoque actual (duración enfocada / duración objetivo / porcentaje). Un interruptor permite activar o desactivar la prioridad de Tareas cronometradas para acceso rápido.
3. **Rediseño de la página Acerca de**: se reorganiza en secciones Enlaces, Comentarios, Comunidad y Desarrollador, con entradas nuevas para el sitio web, registro de cambios, FAQ y documentación de la API. Los usuarios de chino simplificado obtienen una entrada de Tencent Channel; los usuarios internacionales acceden a GitHub Issues/Discussions.
4. **Eliminar seguidores**: ahora puedes eliminar seguidores desde la página de miembros del equipo.
5. **Mejora del selector de Atributos en la Tienda**: botón selector de Atributos añadido al diálogo de entrada de exp/efecto de la Tienda, con filtrado rápido por grupo de Habilidades y selección múltiple por lotes, mucho más cómodo con muchos Atributos.

**♻️ Optimización**

1. **Estadísticas Pomodoro con formato de tiempo conmutable**: pulsa el área de estadísticas Pomodoro en el detalle de la Tarea para alternar entre «horas/minutos», «días/horas/minutos» y «minutos totales».
2. **Estado de subtareas completadas más claro**: las subtareas completadas muestran tachado, distinguiendo mejor lo hecho de lo pendiente.
3. **Ordenación de registros Pomodoro corregida**: los registros Pomodoro se ordenan ahora por hora de fin descendente.

**🐛 Correcciones de errores**

1. **Corregido el texto del botón de retirada del cajero automático en varios idiomas**: corregido el uso incorrecto del gerundio en algunos idiomas.
2. **Corregido el comportamiento al compartir Objetos de la Tienda sin iniciar sesión**: resuelto el comportamiento anómalo al compartir Objetos de la Tienda sin estar conectado.
3. **Corregido el estado de selección del selector de color**: el diálogo del selector de color mostraba un estado de selección incorrecto.

**v1.104.0 (2026/05/23)**

**✨ Novedades**

1. **Las Tareas de recuento admiten liquidación de Recompensas proporcional en tiempo real**: útil para Tareas en las que avanzas varias veces en momentos flexibles dentro de un ciclo, como hábitos completados unas pocas veces por semana. Cuando cambia el progreso del recuento, LifeUp puede otorgar o revertir Exp, monedas y Recompensas de Objetos según el progreso actual en lugar de esperar a la finalización.
2. **Herramientas del historial en el detalle de Tarea más potentes**: al seleccionar una fecha en el calendario del historial se muestra el recuento de ese día, y puedes añadir, editar o crear registros del historial por lotes.
3. **Reflexiones y Objetos mejor conectados**: el detalle de Objetos puede saltar directamente a Reflexiones relacionadas, y la página Reflexiones admite filtrar por Objeto de la Tienda.
4. **Registradas las horas de finalización de subtareas**: LifeUp registra ahora cuándo se completa cada subtarea, preparando los datos para futura API y soporte de LifeUp Cloud.

**♻️ Optimización**

1. **Filtros de visibilidad de Objetos de la Tienda más precisos**: además de Objetos agotados, puedes ocultar los de compra deshabilitada, compra limitada o no asequibles en ese momento. Los widgets de la Tienda siguen las mismas reglas.
2. **Búsqueda y actualización de la lista de Tareas más estables**: la búsqueda en listas normales puede incluir Tareas completadas visibles según la configuración, y la actualización de Tareas repetidas más orden personalizado en la lista Todas es más estable con muchas Tareas.
3. **Estadísticas del historial en el detalle de Tarea según la fecha seleccionada**: las Tareas de recuento e ilimitadas usan distintos niveles de color del mapa de contribución según el recuento diario de finalizaciones. Las estadísticas mensuales, anuales, totales y de racha bajo la vista del historial se calculan también desde la fecha seleccionada en lugar de usar siempre los datos de hoy.
4. **Orden alfabético más intuitivo**: el orden alfabético en los módulos sigue ahora orden numérico natural, de modo que nombres con números se ordenan por valor numérico y no carácter a carácter.
5. **Mejor comportamiento de entrada en ajustes de la Tienda**: los ajustes de la Tienda desplazan los campos enfocados por encima del teclado virtual.
6. **Gestión del modo oscuro del sistema más fiable**: corregidas condiciones de carrera entre seguir el tema del sistema y alternar el modo nocturno manualmente.
7. **API URL Scheme ampliada**: Añadir/Editar Tarea admite la semántica `no_deadline`, y las API de Tareas de recuento admiten la marca de liquidación en tiempo real.
8. **Registros de intereses del historial más claros**: los registros de intereses del cajero automático y del crédito muestran el principal y los días de interés, facilitando verificar el origen del interés.

**🐛 Correcciones de errores**

1. **Corregidas las estadísticas de Logros en Mi página**: cuando los Logros del sistema están ocultos, los recuentos siguen la misma regla de visibilidad.
2. **Corregida la redacción de registros del historial**: los registros de abandono ya no se muestran con redacción de penalización por vencimiento.
3. **Corregido el manejo de textos largos en las API URL Scheme**: las descripciones largas de Habilidades y Logros ya no se truncan demasiado pronto.

**v1.103.6 (2026/05/10)**

**🐛 Correcciones de errores**

1. **Corregida la pista del intervalo de descanso largo que no volvía al estado inicial de la sesión de Enfoque tras pulsar Abandonar.**
2. **Corregido el temporizador de Enfoque adicional que podía seguir visible y contando tras pulsar Abandonar.**

**v1.103.5 (2026/05/10)**

**🐛 Correcciones de errores**

1. **Corregida la pista de descanso largo del temporizador Pomodoro que no se actualizaba con prontitud al terminar naturalmente una sesión de trabajo.**
2. **Corregido el temporizador Pomodoro que podía mostrar el intervalo antiguo de descanso largo de 2 sesiones antes de abrir los ajustes Pomodoro, en lugar del valor predeterminado de 4 sesiones.**

**v1.103.4 (2026/05/05)**

**🐛 Correcciones de errores**

1. **Corregido un problema por el que las Tareas podían desaparecer tras una interrupción anómala mientras estaban congeladas en algunos escenarios límite.**

**v1.103.3 (2026/05/05)**

**ℹ️ Nota de la versión**

1. **Esta versión se omitió y no se publicó.**

**v1.103.2 (2026/04/30)**

**🐛 Correcciones de errores**

1. **Corregido un problema de compatibilidad en el que los campos de entrada podían no aparecer al editar restricciones de compra o uso de Objetos en ciertos idiomas o pantallas más pequeñas.**
2. **Corregido un problema en el que usar un Objeto podía activar incorrectamente un diálogo de penalización.**

**v1.103.1 (2026/04/25)**

**🐛 Correcciones de errores**

1. **Corregido el comportamiento anómalo cuando el efecto de uso de un Objeto modifica su propia cantidad**
2. **Corregidos algunos cierres inesperados y problemas de lentitud detectados en producción**
3. **Corregidos valores de cantidad incorrectos al rellenar al editar el efecto «Modificar cantidad del Objeto» de un Objeto**

**v1.103.0 (2026/04/12)**

**✨ Novedades**

1. **Los Atributos admiten subcategorías y movimiento rápido**: puedes agrupar Atributos con más claridad y mover un Atributo a un grupo objetivo más rápido.
2. **Interacciones de selección de Atributos más fluidas**: la edición de Tareas, flujos relacionados con Recompensas y otros selectores de Atributos son más fáciles de recorrer cuando tienes muchos Atributos.
3. **Los Objetos admiten restricciones de compra/uso**: los límites pueden aplicarse a compra, uso o ambos, con condiciones más ricas como hora, Logros desbloqueados, Tareas completadas, recuento de Objetos poseídos y rangos de Nivel de Atributos.
4. **Los Logros añaden más opciones de orden integradas**: además del orden personalizado, las listas de Logros admiten orden alfabético, por hora de finalización y por fecha de creación.
5. **Los Logros admiten movimiento rápido a subcategorías**: mueve uno o varios Logros a una subcategoría objetivo con más eficiencia.
6. **El tratamiento de vencimiento incluye ahora una entrada de ayuda**: el diálogo de vencimiento incluye una entrada de ayuda y presenta los cambios de Recompensa con más claridad al volver a marcar como completada una Tarea vencida.

**♻️ Optimización**

1. **Visualización agrupada de Atributos más clara**: la página de estado y los diálogos de descripción de Atributos presentan los Atributos agrupados de forma más estructurada.
2. **Interacciones relacionadas con Atributos más coherentes**: la visualización agrupada y la selección son más uniformes en diálogos de Atributos y flujos de edición relacionados.
3. **Edición de restricciones de Objetos más fácil de entender**: los tipos de restricción más complejos son más fáciles de configurar y revisar.
4. **Renderizado de barra de estado y barra superior más estable en varias páginas**: las zonas superiores en páginas como Tienda, Mundo, Búsqueda, Estado, Logros, Mi página y WebDAV se comportan de forma más coherente al desplazarse, en modo oscuro y con Material You.
5. **El diseño de Atributos en la página de estado gestiona mejor textos largos**: nombres de Atributos y etiquetas de Nivel más largos encajan con más fiabilidad, también en pantallas estrechas o con texto grande.

**🐛 Correcciones de errores**

1. **Corregido el problema de variación de gid al generar copias**: las Tareas copiadas generadas desde Tareas vencidas únicas o infinitas tenían gids inconsistentes.
2. **Corregida la casilla «Aleatorio» no funcional en la selección de Atributos**: algunas cajas de selección de Atributos mostraban una casilla «Aleatorio» que no funcionaba.
3. **Corregido el posicionamiento de los banners de Recompensa**: en ciertos escenarios (especialmente al completar Tareas) los banners quedaban mal posicionados, ocultos o saltaban.
4. **Corregida la vista previa/animación de Recompensas por vencimiento en algunos casos**: al volver a completar una Tarea vencida, los cambios de XP, monedas y Objetos se muestran con más precisión sin mezclar valores confusos.
5. **Corregido el ajuste de línea/desalineación del diseño de Nivel en la página de estado en algunos casos**: el diseño es más estable con nombres de Atributos largos o etiquetas de Nivel extensas.
6. **Corregido el cambio de página cuando la lista de Síntesis tiene pocos elementos**: puedes deslizar horizontalmente desde zonas vacías con más fiabilidad cuando el contenido de la lista es corto.
7. **Corregido el cierre inesperado al reclamar Recompensas de Logros en casos especiales**: posible cierre al reclamar Recompensas de Logros en ciertos casos límite.

**v1.102.11 (2026/04/02)**

**🐛 Correcciones de errores**

1. **Corregidas fallos ocasionales de liquidación y anomalías de actualización en Tareas de recuento de la página de inicio.**

**v1.102.10 (2026/03/24)**

**🐛 Correcciones de errores**

1. **Corregido un problema en el que las listas de fórmulas de Síntesis ocultas no se podían mantener pulsadas para editar o eliminar fórmulas.**

**v1.102.9 (2026/03/23)**

**♻️ Optimización**

1. **Regla de deshabilitación de la navegación inferior actualizada**: a nivel de interacción, ya no se permite deshabilitar todos los módulos de la navegación inferior.

**🐛 Correcciones de errores**

1. **Corregido un cierre inesperado al iniciar**: la App podía cerrarse al abrirse si todos los módulos de la navegación inferior estaban deshabilitados.

**v1.102.8 (2026/03/23)**

**✨ Novedades**

1. **Restablecer diseño predeterminado de módulos**: botón «Restaurar diseño predeterminado» añadido a la página de configuración de módulos.
2. **Nuevo evento de difusión de fórmula de Síntesis**: evento API `app.lifeup.synthesis.complete`, enviado cuando una fórmula de Síntesis se completa correctamente.
3. **La búsqueda del Mundo admite filtrado por etiqueta de origen**: la sección Mundo puede buscar por etiquetas de origen, como filtrar Objetos de API en Escaparate antes de buscar.

**♻️ Optimización**

1. **Mejoras tipográficas del popup de desbloqueo de Logros**: mejor renderizado de fuentes y menos problemas de diseño con tamaños de fuente del sistema grandes.
2. **Mejoras en la lógica de ocultación de módulos**: comportamiento de ocultación refinado para que los Logros relacionados con el módulo Mundo se muestren u oculten correctamente.
3. **Ajuste del comportamiento predeterminado de asignación de Tareas aleatorias**: las Tareas aleatorias nuevas ya no se asignan automáticamente a la lista predeterminada, evitando asignaciones silenciosas.

**🐛 Correcciones de errores**

1. **Corregido un cierre inesperado poco frecuente durante la actualización de la lista de Tareas**.
2. **Corregido el problema del título en la API Reflexiones**: la API no proporcionaba correctamente el título de Reflexiones, lo que también podía afectar a títulos de Objetos.
3. **Corregidos problemas de diseño horizontal del Pomodoro**.
4. **Corregido el tipo de marca de tiempo de hora de fin en la API del historial de Tareas**.
5. **Campos de respuesta API ausentes añadidos**: progreso de Tarea, estado de finalización, condiciones de fin de recurrencia y campos relacionados se devuelven correctamente.
6. **Corregidos valores obsoletos en la página de detalle de Tareas de recuento**: los valores se actualizan de inmediato tras modificar la Tarea de recuento.
7. **Corregido un problema que podía provocar duraciones anómalas en registros Pomodoro**.
8. **Corregida la página de inicio que no se reconstruía de inmediato al entrar en modo sin conexión**: antes podía dejar visible la sección Mundo de forma inesperada.
9. **Corregido un problema de carga en la página de Tareas aleatorias**: en algunos casos la página podía quedarse en estado de carga.

**v1.102.2 - v1.102.7 (2026/02/03)**

**♻️ Optimización**

1. **Tutorial de widgets + mejoras de texto**: guía para añadir widgets y refinamiento del texto e indicaciones relacionadas.

**🐛 Correcciones de errores**

1. **Corregido el bloqueo del Pomodoro con datos anómalos**: la página Pomodoro ya no se queda bloqueada/congelada cuando hay datos anómalos.
2. **Corregida la desincronización del temporizador de tiempo añadido tras apagar la pantalla**: el temporizador de «añadir tiempo» se mantiene sincronizado tras apagar la pantalla o suspender el dispositivo.
3. **Corregida la selección de lista predeterminada para Tareas nuevas**: mejor gestión al crear Tareas desde listas inteligentes, especialmente si la lista predeterminada está archivada (ahora recurre correctamente).

**v1.102.1 (2026/01/27)**

**✨ Novedades**

1. **Zoom en vista previa de imágenes**: restaurada la función de zoom en imágenes perdida durante la refactorización de páginas, para ver detalles con más facilidad.

**🐛 Correcciones de errores**

1. **Optimización de memoria WebDAV**: corregido un problema en el que descargar desde WebDAV consumía memoria excesiva, pudiendo provocar cierres o problemas de rendimiento.
2. **Actualización de imágenes en Reflexiones**: corregido un error por el que las imágenes editadas en la página Reflexiones no se actualizaban de inmediato.

**v1.102.0 (2026/01/25, sustituida por v1.102.1 durante el despliegue gradual)**

**✨ Novedades**

1. **Administrador de sonidos**: importar, previsualizar, eliminar y reutilizar efectos de sonido, y usarlos como efectos de uso de Objetos.
2. **Tienda: nuevos efectos de uso de Objetos**: EXP aleatorio, cambios de stock, reproducción de sonido y flujo de configuración mejorado.
3. **Tareas cronometradas**: nuevo tipo de Tarea con duración de Enfoque esperada; completa la Tarea al alcanzar el objetivo del temporizador.
4. **Opciones de inicio de semana**: elige lunes / sábado / domingo, y el calendario y las estadísticas se adaptan.
5. **Omitir onboarding**: opción para saltar el tutorial en el primer inicio.
6. **Entrada emoji para iconos**: introduce un emoji (incluidos emojis combinados) para crear un icono rápidamente.
7. **Calendario: abrir detalle de Tareas recurrentes futuras**: al pulsar una Tarea recurrente en una fecha futura se abre correctamente su detalle.
8. **Usuarios avanzados: mejoras de API**: la API URL Scheme añade/extiende CRUD de plantillas de Tareas, condiciones de fin de recurrencia, navegación de filtros de Síntesis y más.

**♻️ Optimización**

1. **Mejoras de rendimiento y fluidez**: optimizado el acceso a datos e indexación para listas de Tareas, historial de Inventario y estadísticas más fluidas con grandes volúmenes de datos.
2. **Mejor UX de configuración de efectos de Objetos**: interacciones de selección y visualización de efectos mejoradas, con diálogos e iconos refinados.
3. **Mejoras de localización**: traducciones faltantes completadas en varios idiomas.

**🐛 Correcciones de errores**

1. **Corregido el reinicio del efecto de cuenta atrás al editar**: confirmar un efecto de cuenta atrás editado podía restablecer el valor a 1.
2. **Corregido el uso automático de Recompensas de Objetos en Tareas de equipo que no se activaba**: el uso automático no se activaba tras reclamar Recompensas de Objetos en Tareas de equipo.
3. **Corregido el aviso de «registrar Reflexiones» ausente tras Caja de botín / Síntesis**: el diálogo de Reflexiones podía no aparecer tras abrir Cajas de botín o usar Síntesis simple cuando el Objeto tiene efecto «registrar Reflexiones».
4. **Corregidos diálogos de liquidación ausentes al completar manualmente en Pomodoro**: completar manualmente una Tarea en la página Pomodoro podía omitir diálogos de liquidación de Recompensas/Reflexiones; restaurada la finalización con pulsación prolongada en el título de la Tarea.
5. **Corregido el filtro plegado de widgets que no funcionaba**: el filtro del widget de lista inteligente «Plegar Tareas que aún no han empezado» no surtía efecto.
6. **Corregido un cierre inesperado poco frecuente**: cierre por guardar demasiado estado en ciertas situaciones.
7. **Corregida la navegación del calendario al detalle para Tareas futuras**: fallos al abrir detalles de Tareas recurrentes futuras desde el calendario.
8. **Corregidos problemas con Tareas recurrentes Ebbinghaus**: etapas anómalas y generación repetida no deseada en casos raros, con salvaguarda de límite superior añadida.

**v1.101.8 (2026/01/12)**

**🐛 Correcciones de errores**

1. **Corregida la configuración de condición de fin de recurrencia**: no se podía definir la condición de fin para frecuencias «Cada 2 días» o personalizadas «Cada N días».
2. **Corregida la duración anómala del temporizador Pomodoro**: el temporizador podía ejecutarse mucho más de lo esperado por suspensión del sistema o congelación del proceso cuando la optimización de batería no estaba deshabilitada correctamente.

**v1.101.7 (2026/01/11)**

**🐛 Correcciones de errores**

1. **Corregido un problema que podía acortar anormalmente la duración del temporizador Pomodoro**.

**v1.101.6 (2026/01/10)**

**🐛 Correcciones de errores**

1. **Corregidas anomalías relacionadas con el cambio de modo oscuro del sistema**.

**v1.101.5 (2026/01/08)**

**♻️ Optimización**

1. **Optimizado el cambio de modo oscuro del sistema**: corregidos problemas en los que la App no cambiaba automáticamente de tema junto con los ajustes del sistema.
2. **Optimizada la selección de Atributos para Recompensas**: mejor gestión cuando no hay Atributo seleccionado en «Recompensas por persistencia», «Recompensas por pasos» y «Recompensas por me gusta». Admite deseleccionar Atributos y corrige problemas en los que las Recompensas de experiencia no se otorgaban correctamente.
3. **Optimización de configuración de rendimiento**: ajustes internos que pueden mejorar el rendimiento de la App.

**🐛 Correcciones de errores**

1. **Corregidas consultas de estadísticas y visualización de gráficos**: condiciones de consulta corregidas para estadísticas de hora de finalización de Tareas y datos de gráficos imprecisos resueltos.
2. **Corregida la interacción del diálogo de ajustes del widget**: faltaba el botón «Confirmar» en el diálogo de filtro de Tareas del widget.
3. **Corregida la sincronización del recuento de Tareas**: el recuento en la pantalla de inicio no se actualizaba correctamente tras modificarlo desde el detalle de la Tarea.
4. **Corregido el manejo de uso de Objetos en la API Reflexiones**: manejo incorrecto de tipos «Uso de Objeto» en la API Reflexiones.
5. **Corregida la navegación del calendario al detalle**: resueltos varios problemas al ir del calendario al detalle de la Tarea.

**v1.101.4 (2025/12/30)**

**♻️ Optimización**

1. **Optimizada la detección de actualizaciones para miembros**: se invita a los miembros a cambiar al «Canal estable para miembros» para recibir actualizaciones y garantizar la experiencia funcional más estable.
2. **Reducidas las solicitudes de red innecesarias**: ahorro adicional de datos del usuario y reducción de costes del servidor.

**🐛 Correcciones de errores**

1. **Corregida la actualización del progreso de Logros (prioritario)**: corregido un error por el que el progreso de Logros no se activaba correctamente al completar registros Pomodoro.

**v1.101.3 (2025/12/14)**

**🐛 Correcciones de errores**

1. Corregido un problema por el que la opción «Vence hoy» ignoraba incorrectamente el desplazamiento de plazo al día siguiente.

**v1.101.2 (2025/12/13)**

**🐛 Correcciones de errores**

1. Corregido un problema por el que el estado de búsqueda se restablecía al volver a las páginas Tienda, Inventario o Tareas.
2. Corregido un cierre inesperado relacionado con los límites de `AlarmManager` (aprox. 500 alarmas simultáneas).
3. Corregidos cierres inesperados relacionados con colores dinámicos, diálogos de zona horaria y menús emergentes.
4. Optimizado el informe de cierres inesperados para ignorar errores de red habituales.

**v1.101.1 (2025/12/01)**

**🐛 Correcciones de errores**

1. Corregidos posibles cierres inesperados causados por errores de formato en traducciones.

**v1.101.0 (2025/11/29)**

**✨ Novedades**

1. **Filtro de Objetos en Síntesis**: filtra la Síntesis por Objetos para buscar y gestionar con más rapidez.
2. **Detalle del Objeto → receta de Síntesis**: consulta la receta de Síntesis de un Objeto directamente en su página de detalle.
3. **Tienda → entrada de Síntesis**: si un Objeto sirve para Síntesis, aparece un botón Síntesis junto al de Comprar.
4. **Filtros del historial de Inventario**: filtros por fecha, Objetos y descripción.
5. **Diálogo de novedades**: resumen de la nueva versión al primer inicio tras actualizar.
6. **Tiempo de Enfoque Pomodoro por Tarea**: lógica Pomodoro refactorizada; admite duración de Enfoque personalizada por Tarea.
7. **Efecto de uso de Objeto: «Registrar Reflexiones tras el uso»**; la página Reflexiones también admite filtrar por Objeto.
8. **Difusiones del ciclo de vida Pomodoro (API)**: añadidos eventos de difusión del ciclo de vida.
9. **API de consulta simple**: ahora admite obtener los detalles de una sola Tarea.
10. **Incremento automático en Tareas de recuento**: admite incremento automático.
11. **Fin de recurrencia por fecha**: las Tareas admiten terminar la recurrencia en una fecha concreta.
12. **Mejora de ajustes de widgets de escritorio**: mejorada la página de ajustes de widgets dentro de la App para previsualizar cada widget compatible y, cuando el sistema lo permita, añadirlo rápidamente a la pantalla de inicio.

**♻️ Optimización**

1. **UX de gestión de listas + modo oscuro**: interacciones y modo oscuro pulidos; la lista «Todas» muestra ahora un estado de eliminación deshabilitado en lugar de una acción imposible de eliminar.
2. **Página de ajustes de Tienda**: movida a una página independiente y accesible desde Ajustes principales.
3. **Fondo predeterminado de Tareas**: redacción aclarada en el diálogo de ayuda.
4. **Indicador de Completado rápido**: cuando está activado, la página de Tareas muestra un indicador superior del estado de Completado rápido.
5. **Memoria de plegado por lista**: el estado plegado/expandido se guarda por lista para evitar que «Todas» afecte a la lista del día.
6. **Diálogo de vencimiento (modo oscuro)**: estilos de modo oscuro mejorados al procesar Tareas vencidas.
7. **Lógica del botón de filtro Reflexiones**: solo se muestra en tipos que admiten filtrado (Objetos/Tareas).
8. **Flujo de solo Tareas locales en equipos**: interacción mejorada al recopilar únicamente Tareas locales.
9. **Pulido de UI de la página Síntesis**: diseño y retroalimentación visual refinados para una presentación más fluida.
10. **Pulido de interacciones con Objetos**: interacciones relacionadas con Objetos más ágiles y coherentes.

**🐛 Correcciones de errores**

1. Corregido un problema por el que la barra de filtros superior no se mostraba correctamente tras filtrar en la página Historial.
2. Corregido un problema por el que las Tareas negativas podían no calcular penalizaciones con el recuento correcto de penalización 1× en ciertos casos.
3. Corregido un problema por el que el selector de Tareas del temporizador Pomodoro podía perder la opción «Cancelar selección» en ciertas condiciones.
4. Corregidos varios problemas al seguir los ajustes de modo oscuro del sistema.
5. Corregida la ausencia del popup de Recompensa cuando un widget completaba una Tarea de recuento.

**v1.100.6 (2025/11/08)**

**🐛 Correcciones de errores**

1. Corregido un cierre inesperado al seleccionar Objetos si el foco de entrada desbordaba por teclados externos/mandos; eficacia de la corrección en verificación.
2. Corregido el diálogo inteligente de gestión de zona horaria para que pueda desplazarse y mostrar el contenido inferior y los botones.

**v1.100.5 (2025/09/28)**

**✨ Novedades**

1. **Los efectos de sonido personalizados admiten sonidos integrados**: accede a una biblioteca de efectos de audio integrados para personalizar con más comodidad.
2. **Filtrado de Síntesis mejorado**: opción de filtro «Mostrar solo sintetizables» en la página Síntesis para gestionar mejor los Objetos.
3. **Soporte emoji en API**: las API de Objetos, Atributos y Logros admiten emoji directo para mayor personalización.
4. **Mejoras al crear equipos**: posibilidad de seleccionar listas destino al crear equipos para mejor organización.
5. **Copia de Tareas de equipo**: copiar Tareas de equipo como Tareas locales sin requerir membresía del equipo.
6. **Mejora de la API de Tareas**: soporte de parámetros para el estado «fuente de nota clara» en API relacionadas con Tareas.

**♻️ Optimización**

1. **Mejorada la lógica de «descartar cambios»**: diálogo de confirmación optimizado al editar Objetos, Síntesis, Logros y listas de Logros; solo aparece cuando hay cambios reales.
2. **Condiciones de desbloqueo de Logros**: las condiciones de desbloqueo se expanden por defecto para mayor visibilidad.
3. **Rendimiento de Síntesis mejorado**: consultas optimizadas en la página de detalle de Síntesis.
4. **Estabilidad de la API toast**: mayor estabilidad y fiabilidad en las llamadas toast.
5. **Flujo de finalización de Tareas de equipo**: proceso mejorado con mejor manejo de errores y orientación al usuario.
6. **Comportamiento de arrastre en Síntesis**: desplazamiento al borde mejorado al ordenar Objetos personalizadamente en la página Síntesis.
7. **Flujo de recopilación de Tareas de equipo**: flujo mejorado tras recopilar Tareas de equipo, con salto a listas correspondientes.
8. **Optimización de recordatorios de calendario**: lógica de recordatorios de calendario más fiable.

**🐛 Correcciones de errores**

1. Corregido un problema por el que fondos personalizados de versiones antiguas usaban incorrectamente el estado global predeterminado de «fuente de nota clara».
2. Corregida la adaptación de la barra de estado en la página de efectos de sonido personalizados.
3. Corregido un solapamiento posible entre la descripción del Logro y los botones de desbloqueo.
4. Corregidos problemas de desplazamiento al ordenar por arrastre en la página de detalle de Síntesis.
5. Corregida la desaparición ocasional del botón de búsqueda cuando el módulo Mundo está en la barra lateral.
6. Intento de corregir anomalías al seguir el modo nocturno del sistema.
7. Intento de corregir un problema por el que completar Tareas de equipo consecutivas podía duplicar Tareas.
8. Corregido el fallo de la funcionalidad Reflexiones al desbloquear Logros.

**v1.100.4 (2025/09/07)**

**♻️ Optimización**

1. **Mejoras en informes de cierres inesperados**: recopilación e informes mejorados para analizar y depurar problemas.

**🐛 Correcciones de errores**

1. Corregido un cierre inesperado causado por el SDK de Facebook.

**v1.100.3 (2025/09/06)**

**🐛 Correcciones de errores**

1. Corregido un problema por el que la búsqueda no funcionaba al seleccionar Objetos.

**v1.100.2 (2025/09/05)**

**🐛 Correcciones de errores**

1. Corregido un problema por el que **no se podía seleccionar la lista predeterminada** en ciertas situaciones al crear o editar Objetos en la Tienda.

**v1.100.1 (2025/09/03)**

**✨ Novedades**

1. **Opciones de color de fuente en fondo personalizado**: soporte para personalizar el color de la fuente de notas y la interfaz.
2. **Efectos de uso de Objetos mejorados**: los efectos aleatorios de reducción de monedas admiten también la función «Limitar uso».

**♻️ Optimización**

1. **Optimización de recordatorios de calendario**: opciones para ajustar la duración de eventos de recordatorio insertados en el calendario.
2. **Optimización de edición de Tareas**: mejorada la lógica del popup «Descartar cambios» al editar Tareas; ya no aparece al salir sin cambios.
3. **Actualizaciones de localización multilingüe**: textos localizados actualizados para mejorar la experiencia.

**🐛 Correcciones de errores**

1. Corregida la **página de configuración de compatibilidad y la de ajustes de recordatorios** que no se adaptaban al modo oscuro.
2. Intento de corregir **cierres inesperados relacionados con popups y foco del método de entrada** en varias páginas, mejorando la estabilidad de la App.
3. Corregido un problema por el que **al editar Logros no se podía cambiar si usar Objetos automáticamente**.

**v1.100.0-alpha (2025/07/29)**

**✨ Novedades**

1. **Temporizador Pomodoro, Puntos de Experiencia, historial de Inventario, detalle de monedas**: salto con un toque a la página de estadísticas correspondiente.
2. Soporte para ajustes de recordatorio más flexibles (X minutos antes del inicio o del plazo).
3. Soporte para ocultar listas de Síntesis.
4. Soporte para cambiar Atributos en Recompensas por pasos y por persistencia.
5. Soporte para personalizar módulos funcionales de la barra lateral (por ejemplo, poner Tienda o comunidad en la barra lateral u ocultar módulos innecesarios).
6. Añadida opción experimental **«Modo de baja restricción»**: relaja límites numéricos en la App (Puntos de Experiencia, dígitos de monedas, Atributos seleccionables en Tareas, etc.).
7. Optimizada la UI y la lógica de interacción del popup de procesamiento de vencimientos.
8. Añadida descripción para opciones de uso automático de Objetos.
9. Más condiciones de desbloqueo repetibles:
   - Obtención diaria del árbol Pomodoro.
   - Tiempo de Enfoque Pomodoro diario.
   - Completar N Tareas distintas al día.
   - Usar un Objeto concreto N veces al día.
   - Completar una Tarea concreta N veces al día.
10. Opciones de lista inteligente migradas al popup de gestión de listas (botón de lista en la parte superior de la página de Tareas).
11. Añadida opción **«Completado rápido»**: al activarla, completar Tareas omite todos los popups.
12. Ampliado el alcance de iconos de moneda personalizados; ahora admite iconos monocromos (como los de la parte superior de la Tienda).
13. El detalle del Objeto identifica a qué lista pertenece, facilitando confirmar la propiedad desde Inventario.
14. Al editar recetas de Síntesis, admite ordenar por arrastre y pulsar para editar Objetos.
15. Añadida API para editar directamente la cantidad de monedas.
16. La API de consulta admite información Pomodoro (recuento Pomodoro).
17. Límites numéricos de algunas API relajados (la API predeterminada es de baja restricción).
18. **Rediseñado y optimizado el cálculo del progreso de condiciones de Logros**: mejor rendimiento de cálculo y velocidad de actualización del progreso.

**♻️ Optimización**

1. Optimizados los días de persistencia en la página **«Mi»**; admite recalcular manualmente con un toque.
2. Corregidos problemas de diseño RTL en la página calendario; inicio de semana fijado en **«Lunes»** (antes domingo).
3. La visualización agrupada en listas inteligentes de Tareas y Tienda admite plegar/expandir por etiquetas de grupo.
4. Cuando la lista de Tareas expande completadas, no iniciadas o congeladas abajo, las etiquetas correspondientes también aparecen arriba.
5. Los iconos de Objetos importados del módulo Mundo se guardan localmente de forma persistente, evitando no poder cargarlos sin conexión.
6. El popup de selección de listas identifica ahora listas inteligentes.
7. Optimizada la lógica de lista predeterminada para Tareas de equipo y aleatorias: si la lista predeterminada está archivada, se selecciona la primera lista.
8. Optimizada la lógica de vencimiento en Tareas de recuento: si se alcanza el recuento, el estado predeterminado es **«Completada»**.

**🐛 Correcciones de errores**

1. Corregido un problema por el que el estado de la casilla **«usar Objeto automáticamente»** no se restauraba correctamente al editar Logros.
2. Corregido el recuento de la tarjeta superior de listas inteligentes: no excluía Tareas de listas archivadas.
3. Corregida la memoria global del estado **«usar automáticamente»** al comprar Objetos; ahora es independiente por Objeto.
4. Corregido un problema por el que la API de desbloqueo de Logros no actualizaba el progreso correctamente en ciertas situaciones.
5. Corregidos problemas de lógica de lista predeterminada para Tareas de equipo y aleatorias.
6. Actualización de dependencias técnicas; versión API objetivo ajustada a 35 (Android 15).

**Correcciones Alpha/Beta**

1. Eliminadas dependencias innecesarias y adaptación a tamaño de página 16K, **reduciendo el tamaño del paquete de la App**.
2. Corregida la lógica de **uso automático de Objetos**: en Objetos URL, solo se usa 1 y el resto se guarda en Inventario. (Antes solo 1 surtía efecto pero no se guardaba en Inventario, perdiendo el efecto de uso)
3. Corregido un problema por el que las **condiciones de Logros repetibles** no recalculaban el progreso.
4. Corregido un problema por el que los **archivos de copia de seguridad** no incluían plantillas de Tareas.
5. Corregido un problema por el que la mayoría de emojis regeneraban iconos anómalos tras restaurar una copia de seguridad.
6. Actualizado el **enlace del canal QQ** para comentarios dentro de la App.
7. Añadida la **difusión de publicación de Reflexiones**.
8. **Rediseñada** la interfaz de configuración de compatibilidad y métodos de recordatorio.
9. Añadida la opción «Restringir uso del Objeto» para **efectos de reducción de monedas**.
10. **Actualizaciones relacionadas con API**: la API de Tareas admite parámetros de mensaje motivacional.
11. Corregido un espaciado superior anómalo en la página de ajustes predeterminados de Objetos nuevos.

**v1.99.5 (2025/07/29)**

**🐛 Correcciones de errores**

1. Intento de corregir un problema por el que los fondos personalizados podían no mostrarse correctamente en ciertas situaciones.

**v1.99.3 (2025/06/30)**

**✨ Novedades**

1. La API de subtareas admite ajuste relativo (`set_type`).
2. Soporte para limpieza automática de eventos de recordatorio de calendario caducados.
3. Optimizada la lógica de procesamiento de listas archivadas:

* Las listas inteligentes ya no muestran Tareas archivadas.
- Las Tareas en listas archivadas no avanzan automáticamente por defecto (similar al estado congelado).

**♻️ Optimización**

1. Al añadir Tareas/Logros de forma continua, admite desplazamiento automático arriba y foco en el campo de entrada.
2. Optimizada la redacción relacionada con completar Tareas negativas.
3. Optimizada la lógica de visualización del popup «Descartar cambios» en la página de edición de Tareas.
4. Optimizada la duración de eventos de recordatorios de calendario para evitar problemas en algunos dispositivos.

**🐛 Correcciones de errores**

1. Corregido un problema por el que los widgets no admitían iconos de moneda personalizados.
2. Corregido un problema por el que la página de detalle de Tareas no mostraba Recompensas de varios Objetos.
3. Corregidos problemas por los que ciertos escenarios (p. ej., widgets) podían no respetar las reglas de orden de listas.

**v1.99.1-rc02 (2025/06/20)**

**✨ Novedades**

1. Soporte para condiciones de desbloqueo repetibles de Logros «Completar N Tareas consecutivas».
2. La API de crear/editar Tareas admite tipo de Tarea y ajuste relativo de monedas/Puntos de Experiencia.
3. La API de Logros admite fijar monedas y ajuste relativo de monedas/Puntos de Experiencia.
4. Las API admiten saltar a listas concretas de Logros y de Síntesis.

**♻️ Optimización**

1. Optimizado el orden de registros del historial de Objetos en Inventario al abrir cajas.
2. Las opciones de filtro de la página de estadísticas ahora se recuerdan.
3. Las opciones de la página de filtros admiten la operación «Seleccionar todo».
4. Reforzada la lógica de deduplicación al crear Tareas.
5. Operaciones ampliadas en la página de detalle de Tareas: congelar, ajustar plazo.
6. Soporte para mostrar el ID de lista de Síntesis.

**🐛 Correcciones de errores**

1. Corregido un problema por el que la API de Tareas anterior no podía crear/editar Tareas Ebbinghaus.
2. Corregido un problema por el que la lista de Tareas y el nombre de lista en la barra superior podían no coincidir al abrir la App desde el widget de lista de Tareas.
3. Corregido un problema por el que el texto de la tarjeta en modo simple podía no mostrarse por completo.

**v1.99.0 (2025/05/17)**

**✨ Novedades**

1. Soporte para tipos de Logros repetibles
2. Acciones de recordatorio en notificaciones: completar Tarea, recordar más tarde
3. Fondo personalizado: opción para mejorar la legibilidad del texto
4. Soporte para ajustar el estilo de recorte del icono de Logros
5. Soporte para ajustar fechas ancla de Tareas mensuales/anuales

**♻️ Optimización**

1. Optimizada la lógica de cálculo del progreso de desbloqueo de Logros
2. Mejoradas las interacciones de selección de Objetos
3. Ajustada la posición del botón de permiso de recordatorio al crear/editar Tareas
4. Optimizada la lógica de almacenamiento de hora de recordatorio relativa
5. Permitido congelar Tareas no repetitivas y con repetición infinita

**🐛 Correcciones de errores**

> Algunas correcciones se desplegarán gradualmente en [Versión estable para miembros] y [Versión oficial]

1. Corregido un problema por el que editar Logros podía restablecer accidentalmente el progreso de condiciones de desbloqueo por API
2. Corregido un problema por el que Objetos con stock 0 aún podían comprarse por API
3. Corregido un problema por el que en la página de Objeto nuevo podían seleccionarse listas eliminadas en ciertas condiciones
4. Corregido un problema por el que las plantillas de Tareas no guardaban el estado de Recompensa de monedas calculada automáticamente
5. Eliminadas animaciones de transición en la página de detalle para corregir fallos de interacción con pulsación prolongada
6. Corregido un problema por el que las Tareas congeladas aparecían en la selección de Tareas Pomodoro
7. Corregido un problema por el que editar Tareas por ciertos métodos restablecía incorrectamente el estado a incompleto
8. Corregidos problemas de interacción con popups de Reflexiones

**v1.98.5 (2025/05/01)**

**✨ Novedades**

1. Soporte para fijar fechas ancla (p. ej., fin de mes) en Tareas recurrentes mensuales y anuales.
2. Interacción de selección múltiple mejorada para Objetos: modo multiselección por defecto y restauración de selecciones previas al volver a seleccionar.

**♻️ Optimización**

1. Soporte para recordar ajustes de hora de recordatorio relativa.
2. Optimizaciones menores de UI.

**🐛 Correcciones de errores**

1. Corregido un problema por el que los Objetos aún podían comprarse por API con stock insuficiente en la Tienda.
2. Corregido un problema por el que las plantillas de Tareas no restauraban Recompensas automáticas de monedas.
3. Corregido el fallo ocasional de pulsación prolongada en títulos de Tareas.
4. Corregido un problema por el que Objetos nuevos podían seleccionar listas eliminadas en ciertas condiciones.
5. Corregida la ausencia del botón borrar en el campo de hora de recordatorio al editar Tareas.

**v1.98.4 (2025/04/14)**

**🐛 Correcciones de errores**

1. Corregido un problema por el que la barra de progreso podía no actualizarse de inmediato tras completar subtareas en la página de detalle de Tareas.
2. Corregido un problema por el que editar una Tarea completada podía revertir incorrectamente su estado a «incompleta».
3. Corregido un problema por el que modificar el estado de Tareas vencidas podía afectar incorrectamente el recuento objetivo de finalización.
4. Corregido un problema por el que la lógica de selección de Tareas Pomodoro mostraba incorrectamente Tareas congeladas y listas archivadas.

**v1.98.3 (2025/02/16)**

**♻️ Optimización**

1. Añadida una advertencia al usar el método de recordatorio por notificación predeterminado sin el permiso de «alarma exacta».

**🐛 Correcciones de errores**

1. Corregido un problema por el que la API «completar Tarea» no funcionaba cuando el campo UI era true.
2. Corregido un problema por el que la compra y uso de ciertas cantidades de Objetos podían fallar (p. ej., 10).
3. Corregido un problema por el que la página Reflexiones podía quedarse en «cargando» indefinidamente en ciertos escenarios.

**v1.98.2 (2025/02/06)**

**🐛 Correcciones de errores**

1. Corregido un problema por el que, al usar un Objeto que resta experiencia, podía indicar experiencia insuficiente aunque hubiera suficiente.
2. Corregido un problema por el que editar un Objeto tras copiarlo podía producir efectos de uso duplicados anómalos.
3. Corregido un problema por el que llamar a la API «adjust item» podía producir límites de compra anómalos.
4. Corregido un problema por el que modificar ciertos registros Pomodoro podía reducir anómalamente el recuento Pomodoro.

**v1.98.1 (2025/01/14)**

**🐛 Correcciones de errores**

1. Intento de corregir un problema con la autorización de inicio de sesión de Google, por el que los datos de un número limitado de cuentas no se autorizaban ni analizaban correctamente.

**v1.98.0 (2025/01/01)**

**✨ Novedades**

1. Integrados inicio de sesión de Google y autorización de Drive con Credential Manager.
2. Soporte para seleccionar Emoji como iconos.
3. Añadida API ContentProvider Query: funcionalidad de Síntesis.
4. Añadida API ContentProvider Query: funcionalidad de registro Pomodoro.
5. Añadida API ContentProvider Query: soporte para devolver varios Objetos.
6. Añadida API tomato (ajustar recuento Pomodoro).
7. Añadida API export_backup (exportar copia de seguridad).
8. Añadida API purchase_item (comprar Objeto).
9. Añadida API synthesize (activar Síntesis).
10. Añadida API subtask (crear o ajustar subtareas).
11. Añadida API subtask_operation (operar subtareas, p. ej., completar).
12. Añadida API synthesis_formula (fórmula de Síntesis).
13. Añadida API edit_task (editar Tarea).
14. Añadida API category (crear o ajustar lista).
15. Añadida API history_operation (ajustar historial).
16. Añadida API AppSettingsScheme (ajustar algunos ajustes de la App).
17. Añadida API achievement (crear o editar Logro).
18. Añadida API skill (crear o editar Atributo).
19. Soporte para mostrar id y gid de subtareas.
20. Soporte para mostrar id de Síntesis.
21. Soporte para consultar creditLimit.
22. La API ContentProvider admite consultar subtareas (id, gid).
23. API ContentProvider consulta Objetos: devuelve el campo «cantidad máxima comprable».
24. La API ContentProvider Shop admite consultar Objetos por lista de id especificada.
25. Optimizado el valor devuelto al consultar una URL ContentProvider incorrecta.
26. La interfaz de consulta admite consultar un Logro individual.

**♻️ Optimización**

1. Optimizado el orden personalizado predeterminado para Objetos nuevos.
2. Optimizado el orden personalizado predeterminado para Atributos nuevos.
3. Añadidos parámetros `purchase_limit`, `disable_use` y `effects` a la API «add_item».
4. Añadidos parámetros `background_alpha`, `items`, `start_time`, `auto_use_item`, `remind_time` y `pin` a la API «add_task».
5. Añadido soporte para más frecuencias de Tareas en la API «add_task».
6. Añadido soporte para parámetros `effects` y `purchase_limit` en la API «item».
7. Añadido soporte para terminar operaciones en API anteriores (p. ej., entrada).
8. Añadido soporte para especificar el parámetro `signed` en marcadores numéricos.
9. Añadidos marcadores de número aleatorio y decimal aleatorio.


**v1.97.3 (2024/12/16)**

**✨ Novedades**

1. Permite recordar la última selección del interruptor «Usar descripción del equipo como notas de la Tarea».

**♻️ Optimización**

1. Optimizado el rendimiento relacionado con el efecto de uso de productos.

**🐛 Correcciones de errores**

1. Corregido el fallo de ciertas llamadas API. Al usar una función de callback específica para llamar a la API de producto, la función de desempaquetado funciona con normalidad, pero la operación interna de la API para añadir Objetos no se ejecutaba.

**1.97.2 (2024/12/08)**

**✨ Novedades**

1. Añadida generación automática de Tareas mediante el mecanismo WorkManager del sistema, para evitar que falten Tareas cuando no se usan widgets y la App no se ha abierto en más de un día.
2. Mejorado el manejo de excepciones de la API: devuelve un campo `success` unificado y pasa la información de excepción a la interfaz del content provider.

**♻️ Optimización**

1. Optimizada la lógica de generación de hora predeterminada para mejorar la precisión de la generación de horas mensuales y anuales.
2. Optimizada la lógica de eliminación de archivos de imagen no usados, añadiendo una verificación secundaria desde la base de datos para evitar borrados accidentales.

**🐛 Correcciones de errores**

1. Mejorados los mensajes de error de la API cuando no se encuentran entidades.
2. Corregidos problemas de concurrencia en el descargador integrado.
3. Corregida la lógica de estadísticas Pomodoro en escenarios que cruzan días, unificando la atribución del registro al periodo de la hora de fin (antes, los registros que cruzaban días no se atribuían correctamente al periodo del día).
4. Corregidos problemas por los que la continuidad de Tareas y los recuentos de finalización por periodo podían ser incorrectos en ciertos escenarios.

**1.97.1 (2024/11/20)**

**✨ Novedades**

1. Traducciones actualizadas.
2. Soporte para mostrar automáticamente varias Recompensas de Objetos en las notas.

**♻️ Optimización**

1. Optimizado el manejo de solicitudes de red para reducir peticiones HTTP innecesarias y mejorar el rendimiento.
2. Optimizada la visualización del Nivel en la página de estado, mejorando la experiencia visual y la eficiencia al transmitir información.

**🐛 Correcciones de errores**

1. Corregido el color del texto del recuento de subtareas.
2. Corregidos errores de cálculo de hora en Tareas mensuales y anuales, garantizando horas de activación precisas.
3. Corregidos problemas de cálculo de hora en subtareas mensuales y anuales, garantizando que todas las subtareas se programen con precisión.
4. Corregido el problema por el que el fondo de la Tarea no se restauraba correctamente al restaurar desde una plantilla de Tarea, garantizando que se apliquen los ajustes de fondo.

**1.97.0 (2024/10/21)**

**♻️ Optimización**

1. Optimizado el efecto visual de las tarjetas de Tareas no iniciadas.
2. Abordados algunos problemas de rendimiento.
3. Optimizada la página de detalle de Tareas, resolviendo el problema por el que pulsar el nombre de la Tarea a veces no activaba interacciones.

**✨ Novedades**

1. Añadidos campos en formato JSON a la emisión API por vencimiento de Tarea.

**🐛 Correcciones de errores**

1. Corregido un problema por el que activar Material 3 provocaba cierres inesperados al ejecutar ciertas API relacionadas con la UI.
2. Eliminadas algunas opciones experimentales obsoletas, como el interruptor de Reflexiones y el de Atributos nuevos.

**🎉1.97.0-rc (2024/09/11)**

**✨ Novedades**

**Actualizaciones clave**

- Esta actualización se centra principalmente en optimizaciones de rendimiento y correcciones de errores.
- Optimizado de forma significativa el rendimiento general de la App. Obtener listas de Tareas y realizar diversas operaciones es ahora más fluido. La versión objetivo de la API de Android se actualiza a Android 14.

**Otros**

1. Cuando no hay monedas suficientes, el botón de compra de Objetos aparece deshabilitado.
2. Añadida la posibilidad de buscar Logros por nombre en la lista de Logros 🔍.
3. Añadido soporte para ajustes de tamaño de fuente dentro de la App.
4. Optimizada la lógica aleatoria de World → Tareas aleatorias, reduciendo la frecuencia con la que aparece el último lote de Tareas para mayor aleatoriedad.
5. Optimizada la lógica de agrupación de notificaciones; las notificaciones como desbloqueos de Atributos y Logros deberían agruparse correctamente.
6. Estadísticas → Compartir admite activar o desactivar la visualización de códigos QR.

**♻️ Optimizaciones**

1. Optimizada la lógica de acceso a red.
2. Añadido efecto de desenfoque de fondo a las ventanas emergentes.
3. Optimizados los botones en las páginas de Tienda, Inventario y escaparate, usando ahora estilos oficiales de botones Material.
4. La API Content Provider para consultar registros del historial de Tareas devuelve ahora la hora de fin de la Tarea.
5. La API Content Provider para consultar registros del historial de Tareas admite filtrar por Group Id de Tarea.
6. Actualizadas las versiones de muchas dependencias.
7. La API Goto admite navegar a la página «Ajustes predeterminados de Objeto nuevo».
8. Al navegar a la página «Crear Logro» mediante la API Goto, el parámetro `category_id` es ahora obligatorio.
9. Añadida guía en la App para efectos de enlace de Tareas, Tareas contador y Objetos en la API.
10. Optimizada la lógica y los mensajes de error al comprobar actualizaciones para usuarios nuevos.
11. Añadidos mensajes de carga y error para operaciones de eliminación de cuenta.
12. Optimizada el área pulsable para completar la Tarea principal en la página de detalle de Tareas.
13. Mejorado el mensaje de error al importar copias de seguridad, impidiendo con más rigor importar archivos de copia no válidos.

**🐛 Correcciones de errores**

1. Corregido un problema por el que, al crear una Tarea nueva, si primero se mostraba el error de contenido vacío, el mensaje no desaparecía automáticamente aunque se introdujera texto.
2. Corregido un problema por el que el botón de filtro no se mostraba en la página de Estadísticas en modo de barra de navegación inferior.
3. Corregidos problemas de diseño en ciertos dispositivos de pantalla pequeña con relaciones de aspecto estrechas.
4. Corregido un problema por el que las Recompensas de subtareas podían vincularse de forma anómala al copiar Tareas (desde la versión 1.96.0).
5. Corregidos mensajes de error por conexión anómala de Dropbox durante la copia de seguridad automática en Dropbox.
6. Intento de corregir consumo de memoria y cierres inesperados al previsualizar imágenes extremadamente grandes.
7. Corregido un problema por el que, tras comprar un Objeto y marcarlo para usar, los datos del widget no se actualizaban correctamente si el uso fallaba.
8. Corregido un problema por el que editar un Logro cambiaba la hora de finalización y podía disparar incorrectamente notificaciones de desbloqueo de Logro.
9. Corregido un problema por el que, en modo pantalla dividida en pantallas grandes, al mostrar la lista y el detalle de Tareas, completar Tareas, subtareas o actualizar contadores no sincronizaba ambas páginas.
10. Corregido un problema por el que mantener pulsada una Tarea única vencida en la lista de Tareas no permitía borrar la visualización de la fecha límite.

**1.96.1(2024/07/11)**

**🐛 Correcciones de errores**

1. Corregido un problema por el que el recuento mostrado de Objetos de Recompensa era incorrecto al completar subtareas (las Recompensas reales no se veían afectadas).

**🎉1.96.0 - beta01(2024/06/19)**

**✨ Novedades**

**Actualizaciones clave**

1. Al completar Tareas o desbloquear Logros, los Objetos pueden usarse directamente para activar sus efectos.
2. El límite de Objetos usados a la vez se amplía a 1000.
3. La compra de cajas de botín u Objetos de Síntesis admite también uso directo (abrir/sintetizar).
4. Las Tareas de equipo admiten publicar Reflexiones en Reflexiones locales.
5. Los URL Schemes de terceros en las notas de Tareas se analizan y abren directamente.
6. La página de Historial admite buscar registros históricos por notas de Tarea.
7. Añadido soporte para cronometrar Tareas históricas.
8. La página de Estadísticas admite filtrar por categorías principales.
9. Refactorizadas las ventanas emergentes de Recompensa y penalización de Puntos de Experiencia de Atributos: optimizada la lógica de límites de selección de Atributos al usar Objetos y separadas las ventanas de reducción de experiencia por vencimiento.

**♻️ Optimizaciones**

1. El efecto de UI de selección única al elegir Objetos es ahora coherente con la selección múltiple.
2. Optimizada la velocidad de carga de la lista de Tareas.
3. Al añadir o editar Tareas, la hora de vencimiento ya no tiene que ser posterior a la hora actual, facilitando crear registros históricos.
4. Si mostrar id de datos está activado, la ventana emergente de Reflexiones muestra también el id correspondiente.
5. Optimizados problemas de rendimiento relacionados con la ventana de procesamiento de vencimientos.
6. Unificado el orden de botones en estados de cronómetro regresivo y pausa.
7. La interacción para eliminar publicaciones en Módulo World → Perfil personal es ahora más intuitiva.
8. Optimizados los efectos de carga en las páginas de Reflexiones y Logros.

**🐛 Correcciones de errores**

-

**🎉1.95.0-rc01 (2024/05/24)**

**✨ Novedades**

**Actualizaciones principales**

1. Soporte para pantalla dividida en la App en dispositivos de pantalla grande, como tablets y pantallas plegables

**♻️ Optimizaciones**

1. Los widgets de Tienda e Inventario admiten efectos de recorte coherentes con la App para imágenes
2. En la página de estadísticas, cuando solo se selecciona un día, se admiten gráficos de líneas

**🐛 Correcciones de errores**

1. Corregido un problema por el que el tipo de Tarea se mostraba incorrectamente al editar Tareas API
2. Corregido un problema con estadísticas anómalas de finalización, abandono y vencimiento de Tareas en la página de estadísticas

**1.94.3 (2024/05/10)**

**♻️ Optimizaciones**

1. Los widgets intentan actualizar el tema para adaptarse cuando cambia el modo oscuro del sistema
2. Cuando el módulo «World» está oculto, la notificación de punto rojo de Logros del sistema ya no cuenta datos del módulo «World»

**🐛 Correcciones de errores**

1. Corregido un cierre inesperado de baja probabilidad al seleccionar varios Objetos
2. Corregido un cierre inesperado de baja probabilidad relacionado con ventanas emergentes
3. Corregido un problema por el que el widget de Inventario podía no actualizarse al llamar a la API de modificar Objeto
4. Corregido un problema por el que el widget de Inventario podía usar Objetos «no utilizables»

**1.94.2 (2024/04/26)**

**🐛 Correcciones de errores**

1. Corregido un problema con cálculos anómalos del recuento actual de Tareas (lo que provocaba progreso impreciso en Tareas con recuento objetivo de repeticiones)
   - Esta corrección revierte una optimización previa del rendimiento al deshacer Tareas; se espera una solución más razonable en el futuro

**1.94.1 (2024/04/22)**

**🐛 Correcciones de errores**

1. Corregido un problema por el que el recuento de Pomodoros era uno menos de lo real al usar cronómetro, añadir tiempo por API o añadir registros de tiempo manualmente.
2. Corregido un fallo por el que la barra de selección podía parpadear y desaparecer tras seleccionar Objetos en las páginas de Tienda/Inventario y desplazarse.

**🎉1.94.0 (2024/04/22)**

**Actualizaciones clave**

1. Soporte para varias Recompensas de Objetos
2. Widgets de Inventario

**Temas de UI**

1. Los colores personalizados (texto de Tarea y Objeto) incluyen más valores predefinidos
2. Adaptación al icono adaptativo monocromo de Android 14
3. Añadidas muchas adaptaciones de idioma (versión Google Play)

**Logros**

1. Si hay Logros con Recompensas sin reclamar, se muestra un punto rojo en la lista de Logros.

**Tareas**

1. Las subtareas de Tareas con penalización ejecutan correctamente la lógica de penalización
2. Añadida «Gestión inteligente de zona horaria»; si trabajas entre zonas horarias, LifeUp detecta cambios de zona horaria y admite ajustes globales de hora
3. La base estadística en la página de detalle recuerda la última selección y se optimizaron algunos valores predeterminados en ciertos escenarios
4. Optimizado el manejo de gracia de días consecutivos de finalización de Tareas en la página «Yo»: si olvidas completar una Tarea un día, recuperarla puede mantener la racha

**Atributos**

1. Soporte para eliminar registros de experiencia
2. Soporte para restablecer la experiencia de un Atributo individual

**Widgets**

1. Al pulsar el espacio en blanco en widgets de Tienda o Inventario, se entra directamente en la lista a la que apunta el widget, no en la última lista
2. Los widgets de Tareas muestran el progreso de Tareas contador

**API**

1. Añadida una API para editar registros Pomodoro
2. La API de completar Tareas gestiona correctamente Tareas con penalización
3. La API de completar Tareas admite procesar Tareas contador (añade parámetro `count`)
4. La API de completar Tareas admite un parámetro de coeficiente de Recompensa
5. La API de ajustar Objetos admite cambiar el id de lista de Objetos
6. Las API de crear y ajustar Objetos admiten parámetro de criterio de ordenación
7. La API Jump admite saltar a la ventana emergente de usar Objeto
8. Unificadas algunas definiciones de parámetros, como `itemId` → `item_id`
9. Añadidas notificaciones de emisión al iniciar, pausar y terminar un cronómetro
10. `title_color_string` de la API de ajustar Objetos admite pasar una cadena vacía para restaurar el valor predeterminado
11. La emisión de completar Tareas incluye ahora el id de lista
12. Abrir cajas y fabricar activan también la emisión de usar Objeto

**♻️ Optimizaciones**

1. Al añadir o editar Tareas se muestra una advertencia si no se selecciona Atributo y se introduce experiencia
2. Optimizados registros de reintento de subida
3. Optimizada la visualización del título y restricciones de entrada en la página de Niveles personalizados
4. Optimizados rendimiento y problemas de temporización al deshacer Tareas repetidas muchas veces
5. Refactorizada la ventana emergente de usar Objeto, lógica de interfaz de calendario, etc.
6. Optimizada la lógica de recordatorios de Tareas, evitando emitir recordatorios de datos eliminados o anteriores
7. Optimizado el texto de espera en la interfaz de copia de seguridad
8. Las imágenes seleccionadas en la página de Atributo personalizado se añaden también al historial de selección
9. Al editar registros Pomodoro se intenta corregir (aumentar o disminuir) el número correcto de Pomodoros

**🐛 Correcciones de errores**

1. Corregido un Logro del sistema relacionado con estadísticas y copias de seguridad que no se activaba con normalidad tras la reestructuración
2. Corregidos posibles conflictos entre widgets de API random y toast con el toast predeterminado
3. Corregido el detalle de Tarea que no se actualizaba en algunos escenarios al entrar desde un widget
4. Corregida la posibilidad de errores al abrir varias cajas en situaciones especiales (agotando Inventario de Objetos de forma anticipada)
5. Corregido el problema de no mostrar subtareas en la página de detalle tras editar una Tarea sin subtareas y añadir otras nuevas
6. Corregidos algunos casos especiales en los que no era posible editar Recompensas de monedas
7. Corregidos algunos casos en los que reclamar Objetos de equipo podía fallar
8. Corregidas anomalías de estilo MD2 en algunas ventanas emergentes inferiores
9. Corregidos posibles valores de tiempo adicional incorrectos en temporizadores Pomodoro
10. Corregido el problema por el que la barra de color del widget de cambio de experiencia podía no mostrarse
11. Corregidas algunas Tareas que no se mostraban correctamente en calendario-en-curso
12. Corregidos algunos problemas de carga de listas en las páginas de historial y Reflexiones
13. Corregido un problema por el que llamar dos veces seguidas a la API de completar Tarea no permitía dos finalizaciones consecutivas

**1.93.3 (2024/01/09)**

**✨ Novedades**

1. Añadida la API [Reflexiones].

**♻️ Optimización**

1. El cálculo de indicadores de valor medio en la página de estadísticas excluye fechas futuras.
2. Tras ocultar la lista de Logros del sistema, ya no hay alertas por desbloquear Logros del sistema.
3. Actualizada la API `goto` para dejar de admitir ventanas emergentes de compra de Objetos «no comprables».
4. Optimizada la edición de Tareas para resolver el problema por el que la entrada del recuento objetivo de repeticiones quedaba oculta.

**🐛 Correcciones de errores**

1. Corregido el efecto UI edge-to-edge en la página de Atributo personalizado.
2. Corregido un problema por el que la penalización no se revocaba si una Tarea se marcaba como abandonada y luego se completaba en la página de historial/calendario.
3. Corregido el estilo de visualización de la ventana emergente inferior y la barra de navegación del sistema en modo Material2.
4. Corregido el color de borde incorrecto del cuadro de entrada de tareas pendientes en modo nocturno.
5. Corregido un problema de visualización tras rotar la pantalla en modo de navegación de tres botones.

**1.93.3 (2023/12/02)**

**♻️ Optimización**

1. Añadido de forma unificada un parámetro debug a las API para facilitar la depuración

**🐛 Correcciones de errores**

1. Corregido el problema por el que seleccionar «Ignorar ventana emergente de recordatorio» no surtía efecto
2. Corregido el problema al editar Reflexiones creadas directamente en la página Reflexiones
3. Corregido el problema por el que al subir fotos dinámicas de equipo se podían seleccionar hasta 9 imágenes cuando el límite real es 3
4. Corregido el problema por el que la API `use_item` no activaba efectos de cuenta atrás o URL cuando `ui` es false
5. Corregido el problema por el que usar Objetos en el widget de Tienda podía activar el efecto dos veces

**1.93.1 -> 1.93.2 (2023/11/18)**

**♻️ Optimización**

1. Optimizada la lógica de actualización de base de datos para evitar retrasos en el proceso
2. Optimizado el valor predeterminado de «Hora de inicio» al editar Tareas

**🐛 Correcciones de errores**

1. Corregido un problema por el que editar API de producto provocaba pérdida de efectos de uso del producto
2. Corregido el problema por el que Tareas vencidas y abandonadas marcadas como completadas no restauraban Recompensas
3. Corregido un problema con ordenación personalizada de Tareas que no cumplía expectativas
4. Corregidos problemas de visualización y ordenación de Tareas únicas vencidas
5. Corregida una excepción SQL al filtrar la página de historial
6. Corregido un problema en modo simplificado por el que pulsar de nuevo el título de la Tarea no respondía
7. Corregido un problema por el que renombrar plantillas de Tareas no surtía efecto

**🎉1.93.0 (2023/10/24)**

**✨ Novedades**

**Tema de UI**

1. Adaptación completa a Material Design 3.
2. Soporte para personalizar colores del tema Material Design 3, incluidos colores personalizados, del fondo de pantalla y de imágenes.
3. Mejora de algunos efectos de animación, como ventanas emergentes.
4. Optimización de efectos de adaptación edge-to-edge (inmersiva).

**Tareas**

1. Soporte para plantillas de Tareas.
2. Las estadísticas en la página de detalle admiten cambiar según criterios de tiempo y se optimizan opciones predeterminadas.
3. La página de historial admite buscar nombres de Tareas y ajusta la UI e interacciones relacionadas.

**Logros**

1. Soporte para Logros secretos.
2. Al añadir Logros, soporte para «Continuar añadiendo siguiente Logro».

**Atributos**

1. Soporte para ocultar Atributos.

**Temporizador Pomodoro**

1. Soporte para editar registros de tiempo.
2. En la página Pomodoro, soporte para completar Tareas (pulsación prolongada en la Tarea seleccionada en modo pausa).

**Reflexiones**

1. Soporte para añadir Reflexiones directamente en la página Reflexiones.

**API**

1. Añadida la API «use_item».
2. Añadida la API «random».
3. Añadida la API «edit_exp».
4. La API «item» admite ajustar parámetros como «action_text», «disable_use» y «title_color_string».
5. La API «shop_settings» admite el parámetro «silent».
6. Soporte para el marcador «time». Ahora puedes configurar Tareas con fechas como «vence mañana» o «vence el mes que viene» sin herramientas de automatización.

**♻️ Optimización**

1. Añadidos prefijos en algunos lugares que muestran id de datos.
2. Optimizada la visualización de actividades de equipo.
3. Intento de resolver el problema por el que algunas notificaciones Toast eran demasiado largas para mostrarse por completo.
4. Mejorada la lógica de finalización por widget en equipos, garantizando coherencia con el comportamiento en la App.
5. Página de estadísticas: tras seleccionar un rango «Personalizado», pulsar «Personalizado» de nuevo vuelve a abrir la selección de fechas.
6. Garantizada compatibilidad con Harmony OS 4 para que las notificaciones de barra de progreso muestren botones de acción.
7. Mejorada la lógica de interacción de solicitudes de notificación.
8. Abordado el problema por el que el método de entrada podía obstruir la entrada de «Recuento de repeticiones».
9. Al crear Tareas, se registra la elección del usuario de horas de inicio no específicas (como automática o vence hoy). Al editar, se restauran esas opciones en lugar de horas concretas, evitando discrepancias.
10. Al crear Tareas, si aparecen advertencias inesperadas de duplicados, también se muestran en la ventana «Comprobar duplicados».
11. Añadido soporte de idioma indonesio.
12. Traducciones actualizadas.

**🐛 Correcciones de errores**

1. Corregido el problema por el que, en ciertos casos, el módulo world quedaba cargando indefinidamente.
2. Corregido el problema por el que, en ciertos casos, Tienda/Inventario seguían mostrando carga indefinidamente.
3. Corregidos problemas al llamar API con contenido UI mediante content provider.
4. Corregidos problemas de ordenación de Tareas que no cumplían expectativas.
5. Corregido el problema por el que los datos de la página de estadísticas eran incorrectos tras seleccionar un rango «Personalizado».
6. Corregido el problema por el que las ventanas de solicitud de notificación no admitían desplazamiento.
7. Corregido el problema por el que, en ciertos casos, la búsqueda del módulo world mostraba todo el contenido.
8. Corregido el problema por el que la opción «Mostrar completadas» también mostraba Tareas congeladas.
9. Corregidos problemas al calcular valores medios en la página de estadísticas.

**1.92.2 (2023/08/29)**

**✨ Novedades**

1. Gráfico de estadísticas de pasos (<https://github.com/Ayagikei/LifeUp/issues/85>)

**♻️ Optimización**

1. La nueva página de equipo muestra ahora un recordatorio del recuento de palabras actual y del límite superior

**🐛 Correcciones de errores**

1. Corregido el problema por el que «LifeUp» podía crear repetidamente cuentas de recordatorio de calendario en ciertas condiciones especiales
2. Corregido el problema por el que el botón de menú al editar equipo no se mostraba correctamente
3. Corregido el problema por el que Pomodoro podía no activar la vibración en modo de inicio automático del cronómetro
4. Corregido el problema por el que la notificación Pomodoro podía mostrar incorrectamente los Objetos de Enfoque cuando no había ninguno seleccionado

**1.92.1-rc02 - 1.92.1 (2023/08/18)**

**♻️ Optimización**

1. La duración en la página de estado y estadísticas puede mostrarse en formato «XX días XX horas XX minutos».

**🐛 Correcciones de errores**

1. Corregido el problema por el que la interacción para cerrar la ventana de permiso de notificación no era la esperada en Android 12 y versiones posteriores.
2. Corregido el problema por el que el gráfico circular de Atributos podía mostrarse en color transparente y no verse.

**1.92.1-rc01 (2023/08/13)**

> Fecha de lanzamiento de la beta cerrada de membresía

**✨ Novedades**

1. La nueva versión de estadísticas integra las tarjetas estadísticas de la versión anterior, ahora fusionadas en una sola página y adaptadas al modo de barra de navegación inferior.

2. Actualizado el mecanismo de actualización en la App y la función de recordatorio.

   Ahora admite tres canales de actualización: Stable Release, versión estable de la beta cerrada de membresía y versión experimental de la beta cerrada de membresía, para centrar las actualizaciones posteriores en miembros de la beta cerrada.

3. TargetSdkVersion adaptado a Android 13 y solicitudes dinámicas de permiso de notificación.

4. Rediseñada la página de edición de perfil.

5. La versión GP optimizó el proceso de selección de inicio de sesión/modo sin conexión y las instrucciones.

**♻️ Optimización**

1. Mantenimiento y actualización de dependencias técnicas relevantes.
2. Mejorada la adaptación WSA e instrucciones de inicio de sesión.
3. Cuando falla la copia de seguridad, se muestra una ventana emergente que explica el motivo, evitando la visualización incompleta de mensajes toast.

**🐛 Correcciones de errores**

1. Corregido un posible cierre por desbordamiento de cálculo en la página de historial de monedas.
2. Corregida la posibilidad de problemas de menú en la página de detalle de equipo que no coincidían con los permisos esperados.
3. Intento de corregir la desviación de tiempo en el temporizador de cuenta atrás.
4. Corregida la interrupción del proceso de finalización de Tarea y la desaparición de la ventana de escribir Reflexión causadas por rotar la pantalla.

**1.92.0-rc02 (2023/07/16)**

**🐛 Correcciones**

1. Corregido el problema por el que el widget de Tienda podía no funcionar al saltar a otras apps (ejecutando API)
2. Corregida la anomalía ocasional al cambiar listas en el widget de Tienda
3. Corregido el problema por el que el widget de Tienda no ocultaba Objetos agotados o no comprables según los ajustes de la App
4. Corregido el problema por el que el widget de Tienda podía no responder al pulsar cierto Objeto
5. Corregidos algunos cierres inesperados poco frecuentes

**🎉1.92.0-rc01 (2023/07/11)**

**✨ Novedades**

1. Estadísticas 2.0
2. Tarjeta para compartir

**♻️ Optimización**

1. Ahora puedes fijar precios a Objetos «no comprables» y usarlos en escenarios como devoluciones
2. Al desactivar «Configurar penalización de Tarea por separado» en ajustes, ya no se muestra el botón de penalización
3. Optimizada la UI de subtareas en detalle de equipo
4. Optimizada la UI de impresiones

**🐛 Correcciones**

1. Corregido el problema por el que, al cambiar el estilo de recorte de Atributo a «rectángulo redondeado», el icono de edición podía mostrar el icono antiguo durante mucho tiempo

**1.91.3-rc04 (2023/06/07)**

**♻️ Optimización**

1. La API para saltar al detalle de Tarea admite ahora parámetros `task_gid` y `task_name`
2. El Content Provider admite la URL del icono remoto del producto
   - Para corregir en el futuro el problema por el que algunos iconos de producto no se muestran correctamente en el escritorio

**🐛 Correcciones de errores**

1. Corregido el problema por el que el widget de lista de Tienda no mostraba correctamente las monedas actuales

**1.91.3 (2023/06/03)**

**✨ Novedades**

1. Widget de lista de Objetos de Tienda (versión grande y pequeña)
2. Widget de cambio del día en Puntos de Experiencia
3. Añadida una API para saltar al detalle de Tarea
4. Reflexiones: admite ordenación cronológica ascendente y muestra el año

**♻️ Optimización**

1. Ahora se admite fijar precios a Objetos «no comprables» y usarlos en escenarios como devoluciones
2. Al desactivar «Configuración independiente de penalización de Tarea» en ajustes, ya no se muestra el botón de penalización
3. Optimizada la UI de visualización de subtareas en detalle de equipo
4. Optimizada la UI de visualización de impresiones

**🐛 Correcciones de errores**

1. Corregido el problema por el que, si borras las palabras motivacionales al editar una Tarea, no podías pulsar «Confirmar» para cerrar la ventana emergente
2. Corregido el problema por el que la Tarea congelada no se podía buscar con la API
3. Corregido el problema por el que Tienda e Inventario no podían ocultar la lista predeterminada

**1.91.2 (2023/05/09)**

**✨ Novedades**

1. Las listas de Tienda e Inventario admiten ocultar por separado
2. La API `Goto` admite saltar a subpáginas de la página principal (Tareas, estado, Tienda, Inventario)
3. Las estadísticas de monedas admiten excluir el consumo por compras

**♻️ Optimizaciones**

1. Al crear un Logro nuevo o editar uno bloqueado, ya no se muestra el botón «Restablecer»
2. El widget de monedas admite pulsar para ir a la Tienda
3. Cuando falla la reproducción del efecto de sonido, se muestra un mensaje de error claro

**🐛 Correcciones de errores**

1. Corregido el problema por el que, al añadir registros Tomato, si se fijaba directamente la hora de fin, la duración esperada podía no cumplirse
2. Corregido el problema por el que, tras reparar la etiqueta de filtro de Tareas, aparecía el método de entrada
3. Corregido el problema por el que el interés del ATM no admitía fijar el valor absoluto mediante la API
4. Corregido el problema de carga anómala de datos en la página de historial
5. Corregido el problema por el que, cuando el widget completaba una Tarea contador, pulsar «Cancelar» dejaba la pantalla transparente bloqueada
6. Corregido el problema por el que la página de estadísticas no se actualizaba automáticamente en modo barra de navegación inferior
7. Corregido el problema por el que la recogida de Tareas de equipo era anómala en zonas horarias GMT ±x,5

**1.91.1 (2023/03/27)**

**✨ Novedades**

1. Añadida la opción «Gestión de notificaciones» en Ajustes.
2. La API de Tarea nueva admite configurar fondos.
3. Añadidos eventos de emisión API relacionados con cuentas atrás de producto ([New API · Issue #64 · Ayagikei/LifeUp (github.com)](https://github.com/Ayagikei/LifeUp/issues/64)).

**♻️ Optimizaciones**

1. La ventana emergente de comentarios ya no se cierra automáticamente al pulsar fuera.
2. Los widgets ya no fuerzan la finalización de Tareas no iniciadas.
3. La API de finalización de Tareas ya no fuerza la finalización de Tareas no iniciadas cuando el parámetro «ui» es true.
4. Al desactivar el ajuste de coeficientes de penalización individuales por Tarea, se ignoran los coeficientes configurados previamente y se usa el valor global.
5. Elimina automáticamente espacios en blanco de las URL introducidas por el usuario.
6. Cuando «Ocultar Objetos no comprables» está activado y se crea un Objeto no comprable, se muestra un aviso.
7. Cuando el usuario activa Niveles personalizados pero no define ninguno, se restablece la tabla de Niveles integrada.
8. Mejoradas las imágenes de vista previa de widgets.
9. Las entradas de pasos quedan restringidas a números. (<https://github.com/Ayagikei/LifeUp/issues/75>)
10. Al usar el navegador integrado para enlaces de producto, ya no hace falta el prefijo «https».
11. Añadidas instrucciones de «Configuración de compatibilidad» para la función de cuenta atrás de producto.

**🐛 Correcciones de errores**

1. Corregido el comportamiento inesperado al seleccionar productos en Tienda e Inventario.
2. Corregido el problema por el que las Tareas no repetitivas no podían tener fecha límite al añadirlas por API.
3. Corregido el problema por el que las imágenes de Atributo personalizado podían no actualizarse en ciertos dispositivos.
4. Corregido el problema por el que los efectos de sonido personalizados podían cerrar la App. Se implementó un método nuevo que debería hacer los efectos en segundo plano más estables y con menos memoria, aunque la reproducción puede ser más lenta.
5. Corregido el problema por el que, en Android 12 y superior sin la configuración «Ignorar optimización de batería», activar el temporizador Pomodoro automático o el descanso podía cerrar la App en segundo plano.
6. Corregido el problema por el que los efectos de sonido de cuenta atrás de producto se veían afectados por el ajuste de efectos de sonido Pomodoro.
7. Corregido el problema por el que había errores de cálculo en coma flotante al fijar tipos de interés diarios del ATM en la API.
8. Corregido el problema por el que algunas imágenes no se cargaban en Android 6.
9. Corregido el problema por el que, al restaurar datos de la App desde una versión superior a una inferior, los avisos de error no se mostraban correctamente.
10. Corregido el problema por el que algunos dispositivos tenían solapamiento de diseño en la página Pomodoro.

**🎉1.91.0 (2023/02/13-2023/02/26)**

**✨ Novedades**

1. Soporte para gradientes de Nivel personalizados.
2. Primer lote de widgets:
   - Monedas (pequeño, grande, objetivo)
   - Atributos (pequeño, grande)
3. Soporte para consultar la mayoría de los detalles de datos de LifeUp mediante la API Content Provider, incluyendo:
   - Ofrecer una nueva versión de «LifeUp Cloud».
   - Proporcionar una primera versión rudimentaria de escritorio (Windows, Linux, macOS) para uso en red local.
4. Soporte para eliminación múltiple de registros del temporizador tomato.
5. Soporte para configurar inicio automático de descanso y trabajo en el reloj tomato.
6. Mejoras de API y campos añadidos, incluyendo:
   - Depósitos y retiros en ATM.
   - Configurar si se prohíbe comprar bienes.
   - Configurar colores de etiqueta para Tareas.
   - Fijar directamente el saldo del ATM.
   - Consulta simple de detalles de producto especificados.
   - Añadir un tercer botón y opción de operación a la interfaz emergente.

**♻️ Optimizaciones**

1. Mejora de velocidad de consulta, procesamiento y rendimiento con grandes volúmenes de datos.
2. Corregidos márgenes incorrectos de iconos adaptativos.
3. Optimizado el efecto visual de registros del temporizador tomato.
4. Mejorada la interacción al restaurar copia de seguridad.
5. Añadida visualización UI para obtener licencia de membresía mediante Google Play.
6. Aviso para desactivar la importación con un toque si el archivo de copia seleccionado no es de LifeUp al importar directamente desde el sistema de archivos.
7. Cierre automático del método de entrada al buscar bienes en la ventana emergente de selección de producto.
8. Cambios de comportamiento de API, incluyendo:
   - API de ventana emergente confirm_dialog. Si no se proporciona texto u operación de cierto botón, el botón no se muestra. Esto da más flexibilidad al control de ventanas emergentes; por ejemplo, puedes configurar una ventana solo de texto sin botones para mostrar texto y frases motivacionales.
   - API Penalty. En versiones anteriores solo podía deducir hasta 100 Objetos; ahora el límite se extiende a 9 dígitos.

**🐛 Correcciones de errores**

1. Corregido el problema por el que la página del temporizador tomato mostraba «cargando» al final en ciertas circunstancias.
2. Corregidos cierres inesperados causados por ciertas bibliotecas de terceros.
3. Corregido el problema por el que la App se cerraba al colocar el reloj tomato en la barra de navegación inferior por una ventana emergente de aviso.
4. Corregida la visualización anómala de valores de Atributo al ver perfiles de otros usuarios.
5. Corregido el problema por el que los eventos API y notificaciones de reducción de Nivel de Atributo no se enviaban correctamente.
6. Corregidos algunos problemas de interacción en páginas de edición con pulsación prolongada.
7. Corregidos algunos márgenes anómalos en las páginas de gestión de imágenes y Síntesis.
8. Corregidas algunas ventanas emergentes no desplazables, lo que provocaba uso anómalo en modo horizontal.

**✨Special Release: LifeUp Cloud v1.1.1 (2023/02/13)**

1. Soporte para operaciones de lectura y autorización de información de Content Provider.
2. Durante el arranque del servicio, solicita un wake lock para permitir respuesta incluso con la pantalla bloqueada.
3. Añade una serie de interfaces para Content Providers.

**✨Special Release: LifeUp Desktop v1.0.1 (2023/02/13)**

Versión inicial, diseñada para usarse junto con «LifeUp Cloud» y la App móvil.

Admite las siguientes operaciones:

- Consultar Tareas, listas, Objetos, Logros y listas de Reflexiones.
- Comprar Objetos y completar Tareas.
- Usar el visor de imágenes de escritorio para ver imágenes ampliadas de Reflexiones.

**1.90.7 (2022/11/07)**

**✨ Novedades**

1. Añadido: traducción al vietnamita y firma del traductor (versión Google)
2. Añadido: método de selección de imagen «Omitir recorte», adecuado para seleccionar animaciones gif (función de miembro)
3. Añadido: API de eliminación de Tareas
4. Añadido: soporte para configurar la desactivación del efecto de sonido al completar Tareas
5. Añadido: operación de cantidad MAX en Síntesis simple
6. Soporte para volver a bloquear Logros desbloqueados
7. La API «Añadir producto» admite especificar el id de lista

**♻️ Optimización**

1. Mejora de la descripción al eliminar historial
2. El límite de Puntos de Experiencia pasa de (3/4 decimales) a (4/5 decimales)
3. Añadida visualización del coeficiente de penalización en la página de detalles
4. Mejora global del diseño de interacción del selector de fecha y hora
5. La ventana emergente de detalles de Logro diferencia ahora el color del icono según si las condiciones están completadas o no
6. Cambio del icono de acceso directo de tomato
7. Al crear una Tarea desde una lista inteligente, si la lista seleccionable es 0 o 1, se selecciona automáticamente
8. El modo desarrollador muestra el ID de lista de Objetos
9. Limitada la longitud de entrada de algunos campos habituales para evitar cierres inesperados

**🐛 Correcciones**

1. Corregido el cálculo anómalo de Recompensas al modificar registros de historial de Objetos en algunos escenarios
2. Corregido el desajuste entre el interruptor «Mostrar archivadas» y la visualización en algunos escenarios
3. Mejorada la lógica de carga de datos del widget (puede corregir algunos problemas anómalos)
4. Reparada la lógica de cálculo automático al añadir registros de temporización manualmente; ahora basta con rellenar cualquier campo
5. Corregido el problema de actualización anómala en la página de registros del temporizador tomato
6. Corregido el problema por el que las subtareas no podían borrar Recompensas de Objetos
7. Corregido el problema por el que, tras seleccionar todos los Objetos, volver a seleccionar algunos no surtía efecto
8. Optimizada la memoria necesaria para previsualizar imágenes
9. El widget se actualiza ahora tras ajustar el orden de las listas
10. Optimizado el bloqueo de la interfaz en algunos métodos de copia de seguridad

**1.90.6 (2022/10/21)**

**✨ Novedades**

1. Añadida API para configurar el número de pasos en una fecha determinada
2. Añadida API para consultar el estado de Atributos especificados (Puntos de Experiencia, Nivel)
3. Soporte para importar directamente datos de copia de seguridad desde el gestor de archivos
4. Las API relacionadas con Objetos de Recompensa ya no están limitadas a 99

**♻️ Optimización**

1. Optimizado el efecto de animación de transición al entrar en la página de detalles del evento
2. Optimizada la página de edición de Tareas, con mayor efecto visual al activar penalización y mejor guía
3. Cambiados los iconos de operación en la página de temporización
4. En la ventana emergente de compra, añadidas advertencias e instrucciones para Objetos con cantidad propia negativa
5. Optimizado el efecto de barra de estado inmersiva en la página principal
6. Añadido recordatorio de configuración de compatibilidad en la página Pomodoro
7. Mejorada la velocidad de exportación y restauración de copias de seguridad
8. Instrucciones para la configuración del número de stock
9. Eliminada temporalmente la opción [Cuando el inventario del producto es 0, la Recompensa de Tarea correspondiente se elimina automáticamente].
10. Optimizado el mecanismo de verificación de licencia con versión de prueba gratuita
11. Cuando se selecciona una Tarea «Fijada», la acción se muestra ahora como «Desfijar»
12. Al cambiar a temporización positiva, la advertencia *experimental* ya no aparece cada vez

**🐛 Correcciones**

1. Corregido el límite anómalo del sistema en algunas páginas o con tabletas
2. Corregido el problema por el que se mostraban datos incorrectos al entrar por primera vez en el Inventario en algunos casos
3. Corregido el problema por el que no se podían recuperar datos por daños internos (como imágenes dañadas) al restaurar copias dañadas
4. Corregido el problema por el que el botón «Comprar» aparecía inesperadamente tras pulsación prolongada en un Objeto agotado
5. Corregido el problema por el que la introducción de Atributos en la nueva página de equipo era la versión antigua

**1.90.5 (2022/09/22)**

**♻️ Optimización**

1. Adaptación a dispositivos con conversión webp anómala (la imagen recortada puede ser mayor que la original). Tras seleccionar una imagen, se determina su tamaño y se aplica compresión secundaria.
2. Mejora de la descripción de repeticiones objetivo en la página de detalles
3. Soporte para usar el mismo Objeto para acumular tiempo durante la cuenta atrás
4. Añadidas más Tareas guía para principiantes
5. Actualización de traducciones

**🐛 Correcciones**

1. Corregido el problema de UI anómala en la página de composición
2. Corregidos varios cierres inesperados conocidos
3. Mejorado el problema por el que la cuenta atrás de Objetos podía interrumpirse anormalmente y acumular tiempo en cuentas atrás prolongadas
4. Corregida la excepción de UI en la ventana emergente de Reflexiones al completar una Tarea con el widget

**1.90.4 (2022/09/15)**

1. Corregido el problema anómalo cuando el widget completa una Tarea (puede provocar una página transparente e impedir continuar la operación)
2. Deshabilitada la capacidad del widget para seleccionar imágenes de Reflexiones

**1.90.3 (2022/09/14)**

1. Corregido el problema de foco al ordenar subtareas
2. Mejorado el color de Atributos en Tareas congeladas o no iniciadas
3. Añadida difusión de eventos de Tareas abandonadas
4. Corregido el color del texto de probabilidad
5. Mejoradas las Tareas iniciales (Tareas predefinidas)
6. Corregido el problema por el que el diálogo de importación de Tareas podía seleccionar la lista «Todas» por defecto
7. Corregidos problemas de agrupación de Objetos en la Tienda
8. Ahora se muestra una advertencia al configurar una hora inusual (la hora no coincide con la frecuencia de repetición).
9. Mejoradas las reglas de cálculo de Tareas en el calendario; ahora deberían predecir con precisión los plazos de Tareas futuras.
10. Corregido el problema por el que el calendario calculaba la finalización de Tareas congeladas.
11. Mejorada la configuración predeterminada de hora de inicio al editar Tareas.
12. Mejorado el mecanismo de detección de licencia.
13. Optimizado el procesamiento de la cuenta atrás de Objetos. Se prohíbe la ejecución repetida para reducir la acumulación de tiempo no deseada.
14. Corregido el problema edge-to-edge al usar teclas virtuales en algunas páginas.
15. Corregido el problema por el que no se podía seleccionar una imagen de Reflexión cuando el widget de escritorio completaba una Tarea.

**1.90.2 (2022/08/31)**

**✨ Novedades**

1. Añadidos eventos de difusión.
   Ahora puedes usar Tasker/MacroDroid para recibir eventos como uso de Objetos, finalización de Tareas, etc., y activar acciones de Tasker.

   Por ejemplo: si se usa un Objeto, se activará el cambio de fondos de pantalla aleatorios.
   En teoría, si lo deseas, puedes implementar funciones como bloqueo de aplicaciones y escenarios de interacción con juegos.

2. Nuevas API:

- Abandonar Tareas
- Congelar Tareas
- Descongelar Tareas
- Interfaz vacía
- Consulta

3. Añadido valor de retorno para las API de añadir Objeto y Tarea
4. Al importar Objetos del mercado, ahora puedes seleccionar la lista de destino
5. Adaptación al color secundario de Material 3
6. Actualización de traducciones; añadido soporte para coreano

**♻️ Mejoras**

1. Al abrir Cajas de botín en lote, también se muestra la probabilidad de un solo producto
2. Optimizados algunos efectos de visualización de UI en modo nocturno
3. Optimizada la lógica interactiva de la ventana emergente de selección de fecha y hora. Al seleccionar el día actual, cambia automáticamente a la página de selección de hora.
4. Cuando la API invoca selección de Objetos y selección de listas, la ventana emergente ya no admite cierre directo (para evitar pérdida de llamadas API)
5. Optimizada la altura predeterminada de algunas ventanas emergentes en la parte inferior en pantalla horizontal de tableta
6. Optimizado el cierre automático de ventanas emergentes

**🐛 Correcciones**

1. Corregido el problema por el que la búsqueda de Tareas por API podía fallar en algunos casos
2. Corregido cierre inesperado ocasional en la página de lista de Tareas
3. Corregido el problema por el que aparecía el botón «Deshacer» al pulsación prolongada en Logros normales no desbloqueados
4. Corregido el problema por el que la ventana emergente de detalles de Logro podía mostrarse incompleta
5. Corregido el problema por el que la subida podía fallar por imágenes anormalmente grandes
6. Corregido el problema por el que own_number y stock_number de la API de Objetos no admitían números negativos
7. Corregido el problema por el que los días de persistencia en la página «Yo» a veces se mostraban anormalmente como 1
8. Corregido el problema por el que a veces se mostraba «-x días atrás»
9. Corregido el problema por el que las API posteriores podían cancelarse anormalmente al llamar API en lote
10. Corregido el problema por el que el contenido rellenado al crear un equipo nuevo podía perderse al destruirse la página

**1.90.1 (2022/08/22)**

**🐛 Correcciones**

1. Corregido el problema de concurrencia en llamadas API
2. Corregido el problema por el que, al seleccionar un gran número de productos (miles), la selección múltiple podía provocar bloqueo
3. Corregido el problema anómalo cuando el widget completa una Tarea de equipo
4. Corregido el problema por el que la edición de Puntos de Experiencia de subtareas no se rellenaba

**🎉1.90.0 (rc01, rc02) (2022/08/15)**

**✨ Novedades**

1. Optimización de la configuración de Recompensas de Tareas:
   - Ajuste de UI de configuración de Recompensas
   - Las subtareas admiten configurar Recompensas de Puntos de Experiencia y Objetos
   - La Recompensa original «solo texto» pasa a ser una Recompensa independiente de «palabras»
   - Soporte para configurar el valor predeterminado de Puntos de Experiencia

2. Los Objetos admiten restricciones de compra por Nivel de Atributo.

3. Los Objetos admiten el efecto «URL».
   No solo puedes abrir páginas web, sino también invocar otras aplicaciones o la API de LifeUp. Permite efectos como subir el precio tras usar el Objeto.

4. **API abiertas.**
   Ahora puedes integrar software de automatización o realizar desarrollo secundario.

   [Para más detalles, consulta la documentación de la API.](https://wiki.lifeupapp.fun/en/#/guide/api)

5. La Tienda admite ver el efecto de recuento sin refinar

6. Optimización de notificaciones:

   - Añadida notificación de cambio de Nivel de Atributo
   - Añadida notificación de Logro desbloqueado
   - Optimización de grupos de notificaciones

7. Soporte para añadir registros de temporización manualmente.

8. Ahora se puede configurar la página Pomodoro en la barra de navegación

9. Soporte para ocultar la lista [Logro del sistema]

10. La versión objetivo de API se adapta a Android 12L

11. Optimización de efectos de inmersión

12. Los widgets de la App admiten mostrar la ventana emergente de completar Tarea

13. Ahora puedes completar la Tarea en la página de detalles del asunto

14. En la ventana emergente de vencimiento, puedes configurar el número de Tareas contador

15. Ahora puedes editar el nombre de la Tarea de equipo

16. Optimizado el momento de solicitudes de red del módulo mundo, reduciendo tráfico y presión en el servidor

**♻️ Mejoras**

1. El modo nocturno admite ahora todos los colores de tema, con personalización nocturna independiente para cada color, adaptado a Material 3
1. Añadido el enlace «Optimización de batería» en el diálogo de configuración de compatibilidad
1. Añadido el interruptor «Mantener pantalla encendida» en Ajustes de Pomodoro
1. Ofrece las dos opciones «Finalizar» y «Acumular» para la cuenta atrás del Objeto en estado pausado
1. Cuando el número de objetivos editados es mayor que el actual, se muestra un aviso de error
1. Los asuntos negativos no deben mostrarse en la configuración de coeficientes de penalización
1. Optimizado el efecto de actualización en la página de historial
1. Optimizada la lógica de activación automática de la Tarea principal tras completar una subtarea; ahora se procesa directamente en la página de detalles
1.

**🐛 Correcciones**

1. Corregido el problema por el que el botón + aparecía a veces en la página Momentos
2. Corregido el problema por el que las Tareas negativas no mostraban el diálogo de Reflexiones
3. Corregido el problema por el que el objetivo de Tareas negativas no surtía efecto
4. Intento de reparar el efecto de configurar «congelar hasta...» en Tareas de equipo
5. Corregido el problema por el que la imagen de la página de Reflexiones podía mostrarse incorrectamente

**1.89.5 (2022/8/5)**

1. Optimizado el problema de conexión de red
2. Actualización de traducciones

**1.89.4 (2022/7/13)**

1. Corregida la información sobre preguntas de Xiaohong Dot
2. Corregido el problema de generación repetida de Tareas repetitivas (esta vez debería estar realmente reparado .jpg)

**1.89.3 (2022/7/05)**

**♻️ Mejoras**

1. Optimizado el criterio de la lista de interruptores deslizantes

**🐛 Correcciones**

1. Corregido el problema por el que el cálculo podía no completarse cuando hay muchas condiciones de Logro
2. Corregido el problema por el que el recordatorio de notificación de Tareas indefinidas mostraba un plazo anómalo
3. Corregido el problema por el que editar el fondo de un Objeto afectaba al Objeto copiado tras copiarlo
4. Corregido el problema por el que la Habilidad al editar Tareas de equipo podía no heredarse

**1.89.2 (2022/6/23)**

**♻️ Mejoras**

1. Eliminado permiso CARMRA innecesario
2. Actualización de traducciones

**🐛 Correcciones**

1. Corregidos algunos cierres inesperados

**1.89.0-1.89.1 (2022/6/09)**

**✨ Novedades**

1. Soporte para desbloqueo múltiple de Logros condicionales
2. Los detalles de Logro admiten ver detalles y progreso de condiciones
3. Etiquetas de Tareas
4. Tareas repetitivas sin plazo
5. Ocultar Objetos agotados o con compra deshabilitada
6. Al configurar el efecto de reducción de Puntos de Experiencia de un Objeto, es opcional limitar el uso
7. La página de Inventario admite selección múltiple, seleccionar todo y devoluciones en lote
8. La lista de Tareas predeterminada admite operación de archivado
9. Rediseño de algunas páginas como ajustes, preguntas y respuestas, barra de herramientas de la Tienda y página de añadir listas
10. Rediseñados algunos iconos de la App (iconos de tarjetas de Tareas predeterminadas, monedas, Puntos de Experiencia, iconos de Logros)
11. El almacenamiento de imágenes se movió a la ruta privada externa de la App para evitar eliminación accidental de archivos

**♻️ Mejoras**

1. Añadido enlace al artículo [Configuración de compatibilidad] en la página de ajustes
2. La cuenta atrás Pomodoro — la operación de reinicio añade diálogo de confirmación
3. Añadida descripción para congelar Tareas
4. Añadida descripción para subcategorías de Logros
5. En modo sin conexión, añadido botón para salir del modo sin conexión en la página de editar perfil
6. Optimizadas las estadísticas de Tareas negativas; admite mostrar el número de abandonos del día y el seguimiento de Logros
7. Optimizada la velocidad de inicio de la App
8. Los iconos de Logro admiten ver imagen ampliada
9. Añadidas estadísticas de «me gusta» (recibidos) para Tareas aleatorias
10. Optimización unificada de la interacción de búsqueda
11. Al seleccionar un Objeto, cambiar a una lista vacía muestra un diseño vacío (en lugar de cargando)
12. La página de imagen ampliada se adapta a la configuración de color de tema actual
13. Optimizado el efecto de animación cuando cambia la altura de la ventana emergente de Objetos y Tareas seleccionados
14. En ajustes de copia de seguridad, «Eliminar datos locales» también admite eliminar archivos multimedia
15. Unificada la lógica de almacenamiento y eliminación de archivos temporales al tomar fotos
16. Distinción entre el icono predeterminado del Objeto y el icono que no carga
17. Activada por defecto la configuración independiente de penalización para Tareas
18. Optimizada la actualización, lógica de animación y velocidad de carga de la página de Reflexiones
19. Algunas ventanas emergentes de detalles añaden un botón de acceso directo «Seleccionar»
20. Cuando los interruptores principales de «efectos de sonido» y «vibración» en ajustes avanzados están desactivados, también se muestran instrucciones correspondientes en ajustes de tomato
21. Optimización de ordenación de Logros nuevos y subcategorías
22. Actualización de biblioteca base y dependencias
23. Optimizado el método y la velocidad de cálculo del progreso de Logros
24. Mejorado el método de cálculo de «veces objetivo (repeticiones)» para seguir la mejora estadística de registros históricos, coherente con el número de veces en detalles
25. Al introducir el número de monedas y repeticiones objetivo, se seleccionan automáticamente todos los valores actuales
26. Optimizado el aviso de error cuando la configuración WebDAV es anómala
27. Optimizado el aviso de error cuando la copia de seguridad de Google Drive es anómala
28. Ahora se puede seleccionar el nombre de la Tarea en la página de detalles

**🐛 Correcciones**

1. Corregido el problema por el que el recuento configurado invalidaba la Recompensa de Tareas tras ejecutar la lógica de repetición
2. Corregido el problema de ordenación y agrupación en la página de la Tienda
3. Corregido el problema anómalo de desplazamiento arriba/abajo en Tareas aleatorias en algunos casos
4. Corregido el problema por el que la estadística Pomodoro en la página de estado era imprecisa tras usar temporización positiva en algunos casos
5. Corregido el problema por el que la lógica de repetición de Tareas de equipo perdía la configuración de tipo contador
6. Corregido el problema por el que la Tarea seleccionada por Tomato quedaba resaltada al seleccionar Tareas relacionadas con condiciones de Logro
7. Corregido el problema por el que la imagen de Reflexión no se almacenaba de forma independiente y problemas de visualización
8. Corregido el problema por el que el aviso de fallo de inicio de sesión podía aparecer con frecuencia
9. Algunos campos de entrada especiales para Tareas, equipos y subtareas nuevas no deben permitir entrada por teclado, lo que podía provocar cierre de la App
10. Optimizada la forma de contar finalizaciones de Objetos ilimitados en widgets, coherente con la App
11. Corregido el problema por el que, tras ajustar la tasa de interés del ATM, el interés podía calcularse según el tiempo acumulado y la tasa ajustada
12. Corregido el problema por el que las Tareas congeladas podían seguir mostrándose en la lista inteligente
13. Optimizado el problema por el que el botón de acción bloqueado por la barra de selección seguía siendo clicable al seleccionar ciertos objetos (Tareas, Objetos de la Tienda)
14. Corregido el problema por el que cambiar el color de un Objeto no actualizaba la UI de inmediato
15. Corregido el problema por el que fijar de repente una tasa de interés alta tras mantenerla baja (sin obtener 1 moneda) podía generar intereses enormes
16. Corregido el problema por el que la caja de búsqueda aparecía tras completar una Tarea tras abrir la barra de búsqueda y usar el producto
17. Corregido el problema por el que el número de finalizaciones del día en la App podía no coincidir con el widget tras cambiar el nombre de una Tarea infinita
18. Corregidas animaciones extrañas al completar Tareas ilimitadas
19. Corregido el problema por el que copiar una Tarea no copiaba su fondo
20. Corregido el problema por el que, en algunos casos, se cumplían las condiciones de Logro pero no se podía desbloquear
21. Corregida excepción en el cálculo de intervalos de fechas (puede afectar a múltiples lógicas)
22. Corregido el problema por el que las Reflexiones no se filtraban automáticamente desde la página de detalles de Tareas

**1.88.4 (2022/4/21)**

1. Corregido el cierre inesperado al buscar en el almacén
2. Corregido el desorden de visualización del fondo personalizado y la página de historial
3. Corregido el solapamiento de UI al editar
4. Corregido el problema por el que la cantidad podía mostrarse anormalmente cuando el Logro otorgaba Objetos como Recompensa
5. Corregido el problema por el que las veces de finalización en el cálculo de Logros podían no coincidir con las reales en algunos casos especiales
6. Corregido el problema por el que el título podía desaparecer al pulsar rápidamente en la página de historial
7. Al crear o editar una Tarea, tras pulsar en la propiedad, el teclado virtual no podía volver a mostrarse al pulsar de nuevo el campo de entrada con foco
8. Corregido el cierre inesperado al configurar el límite de compra mensual en francés

**1.88.3 (2022/4/09)**

1. Corregido el problema por el que, tras restaurar la copia de seguridad, la copia en la nube mostraba conflicto
2. Corregido el problema por el que la hora de inicio de Tarea editada y la hora de recordatorio de subtarea no seleccionaban por defecto la hora rellenada
3. Corregido el problema por el que otros efectos solo se calculaban una vez durante la Síntesis simple en lote
4. Corregido el problema por el que cualquier Atributo de Logro del sistema al alcanzar Nivel 10 no se contabilizaba en el Atributo personalizado
5. Corregida la visualización anómala de la UI de texto en la página «Yo» para no miembros

**1.88.2(-)**

> Actualizaciones incluidas en 1.88.3

**1.88.1 (2022/4/02)**

1. Corregido un cierre inesperado causado por el recordatorio de copia de seguridad

**1.88.0 (2022/3/30)**

✨ Novedades

1. Añadida la función de compartir «Tareas aleatorias» en el módulo mundo
2. Los Objetos contador pueden configurar opcionalmente un coeficiente que afecte al número de Objetos
3. Soporte para configurar la tasa de interés de préstamos
4. La gestión de imágenes admite filtrado con un clic de imágenes no usadas + seleccionar todo
5. Soporte para tamaño de recorte de imagen personalizado (iconos de mayor definición, función de membresía)
6. Visualización explícita del interruptor «Reflexiones» dentro del Logro
7. Optimizado el algoritmo de ordenación de la lista «Todas»

⚡️ Optimizado

1. Optimizados los efectos visuales de algunas ventanas emergentes
2. Optimizada la interacción de funciones de copia de seguridad/restauración
3. Optimizada la velocidad de carga de la página de delegación
4. Optimizada en gran medida la velocidad de carga de la ventana emergente de selección de productos

🐛 Correcciones

1. Corregido el desorden del fondo personalizado
2. Corregido el problema por el que la Tarea podía crearse en una lista eliminada
3. Corregidos algunos errores de cierre inesperado

**1.87.1（2022/3/07）**

1. El menú de ordenación de Tienda e Inventario muestra explícitamente la ordenación «personalizada»
2. Corregido el problema por el que podía producirse una ordenación anómala en el Inventario
3. Añadido un botón para ir al feedback por correo en la página de comentarios
4. Optimizado el aviso de fallo de restauración por problemas de versión de base de datos
5. Corregido el problema por el que el número de monedas no se mostraba en la tarjeta de modo compacto

**1.87.0 official version (2022/3/04)**

1. Corregido el problema por el que el fondo de tarjeta personalizado podía ampliarse anormalmente en algunos casos
2. Corregido el problema por el que pulsar la notificación de recordatorio de Tarea podía abrir detalles incorrectos al recibir recordatorios continuos
3. Corregido el problema por el que los números de la tarjeta no se actualizaban al deslizar para aumentar el recuento de Tareas contador
4. Añadida nueva Tarea guía para algunos idiomas

**1.87.0-rc02（2022/2/25）**

1. Mejorado el manejo de errores y avisos en operaciones de recuperación
2. Optimizada la interacción al configurar «día de la semana»; añadida advertencia de configuración anómala (inicio y periodo no en el mismo día)
3. Optimizada la combinación de colores en modo nocturno de algunas páginas
4. Corregido el problema por el que la caché podía mostrarse incorrectamente en el selector de imágenes y la gestión de imágenes
5. Corregido el problema por el que la operación «Descargar» en la ventana emergente de conflicto de copia de seguridad no admitía Google Drive/Dropbox
6. Corregido el problema por el que la búsqueda de la Tienda podía mostrar resultados incorrectos
7. Corregido el problema por el que fijar una Tarea podía fallar
8. Corregidas algunas excepciones de UI y problemas de texto

**1.87.0-rc01（2022/2/23）**

**✨ Novedades**

1. Las subcategorías de Logros admiten operación de plegado
2. Introducido el interruptor de estilo Material You (experimental)
3. El Inventario admite ordenación por Tienda
4. El Inventario admite operación «favorito» de Objetos
5. La Tienda admite operación seleccionar todo
6. Las operaciones relacionadas con Tienda e Inventario admiten seleccionar cantidad MAX
7. Las Tareas admiten creación continua
8. Configuración de Tareas: la descripción de la Recompensa de Objeto se añade automáticamente a las notas de la tarjeta (es decir, se muestra automáticamente «Recompensa: [un producto] x1»)
9. Las Tareas admiten duración de congelación especificada

**⚡️ Mejoras**

1. Añadido botón «Omitir» en la ventana emergente de conflicto de copia de seguridad
2. La versión de Google Play admite francés/polaco
3. El recordatorio de notificación al pulsar una Tarea ahora admite saltar a los detalles de la Tarea
4. Al editar la hora relacionada con la Tarea, la ventana emergente predeterminada apunta a la hora anterior a la edición en lugar de la hora actual
5. Cada entrada de selección de lista de la Tienda admite operaciones «Renombrar», «Eliminar» y «Nuevo»
6. Rediseño de UI de la página de extensiones
7. Añadida segunda ventana emergente de confirmación para «Eliminar cuenta de calendario»
8. El producto ya no se retira automáticamente de la venta si está agotado
9. La Tarea «Levantarse temprano» del ejemplo pasa a penalización 0
10. Al obtener una Recompensa de Objeto, si la cantidad es negativa, ahora aparece una advertencia relacionada
11. Optimizado el algoritmo aleatorio de monedas en el efecto de uso de Objetos
12. La operación «Marcar como completada» añade efecto de sonido de finalización
13. Optimizada parte de la visualización de UI en modo nocturno
14. Optimizado el rendimiento de la lista de Tareas

**🐛 Correcciones**

1. Corregida la anomalía del texto «unconcerned» en algunos idiomas
2. Corregido el problema por el que el icono del producto en la ventana emergente «Devolver» podía mostrarse anormalmente
3. Corregido el problema por el que la Tarea podía generarse repetidamente al completarse rápidamente
4. Corregido el problema por el que la memoria de la lista actual del sistema «Síntesis» podía invalidarse
5. Corregido el problema por el que el inicio de sesión QQ podía no ser posible en pantalla horizontal
6. Corregido el problema por el que, al editar una receta en la lista [Todas] del sistema «Síntesis», la receta podía desaparecer de la lista original
7. Corregido el problema por el que pulsar varias veces seguidas para completar una Tarea infinita podía hacer que el número de finalizaciones volviera a cero
8. Corregido el problema por el que el intervalo de copia de seguridad no podía configurarse como «Mensual»
9. Corregido el problema por el que el icono de Puntos de Experiencia no se mostraba en modo simple
10. Corregido el problema por el que faltaban las columnas «Logros» y «Lista de Logros» en la gestión de imágenes
11. Corregido el problema por el que la página de detalles de Tarea no admitía abandonar Tareas de equipo
12. Corregido el problema por el que la guía del módulo mundo no se mostraba correctamente
13. Corregido el problema por el que el producto podía compartirse con éxito cuando fallaba la subida de imagen, pero la imagen local se sobrescribía
14. Corregidos algunos cierres inesperados y excepciones poco frecuentes

**1.86.0（2022/1/20）**

**Novedades**

1. Subcategoría de Logros: divide categorías y cuenta automáticamente por categoría
2. Copia de seguridad en Google Drive
3. Función de gestión de imágenes (en la página de copia de seguridad)
4. Efecto aleatorio de monedas de oro en Objetos
5. Copia en lote de Logros
6. El conteo de pasos admite entrada múltiple de pasos y múltiples Recompensas
7. Pomodoro admite configurar intercambio de Objetos
8. Soporte para ratio de descuento de devolución personalizado
9. Formato exclusivo para copia de seguridad (algunos sistemas admiten abrir e importar directamente)
10. La Síntesis simple admite operación en lote
11. Nueva opción de efecto de sonido personalizado: uso de Objetos
12. Nueva condición de desbloqueo de Logro: depósito actual en ATM
13. Las estadísticas de veces de asuntos negativos admiten página de detalles
14. La lista «Todas» admite renombrar
15. Unificados el nombre y la descripción de canales de notificación de la App

**Mejoras**

1. Priorizar Logros desbloqueados pero sin Recompensa recibida
2. El tiempo de Enfoque de hoy de Pomodoro en la página de estado se muestra en horas según la duración
3. El almacén añade visualización de descripción de Objetos
4. El registro de cuenta nueva muestra un diálogo de confirmación
5. Soporte para mostrar anuncios de mantenimiento
6. Añadido diálogo de confirmación «Omitir» para tiempo extra de Pomodoro
7. Soporte para guardar datos al desinstalar la App (requiere soporte del sistema)
8. Optimizada la lógica de copia de seguridad y recuperación
9. Optimizada la lógica de vencimiento de Objetos únicos e ilimitados, con soporte de edición
10. Optimizada la base temporal de estadísticas de gráficos de eventos ilimitados, basada en la hora de finalización en lugar del plazo
11. La tarjeta de modo compacto también muestra el tiempo de vencimiento de Objetos únicos e ilimitados
12. Intento de mejorar la supervivencia de la función de cuenta atrás en segundo plano
13. Optimizada la función de Reflexiones:
    -Activada por defecto
    -La página de configuración de Tareas de equipo no muestra el interruptor «Reflexiones» que en realidad no surte efecto
    -Eliminada la confusa función de memoria del interruptor de Reflexiones
14. Aumentado el número de Objetos mostrados en la ventana emergente de selección de listas de Objetos e Inventario
15. Cuando la barra de notificaciones continúa temporizando, también se cancela el efecto de vibración en curso
16. El texto dinámico del módulo mundo admite copia parcial
17. Optimizado el efecto de animación de actualización de datos en la página de Logros personalizados
18. Optimizada la lógica de recuperación; muestra el cuadro de diálogo «Cargando» en lugar de bloquear la interfaz
19. Optimizado el problema por el que el botón inferior podía no verse en la «ventana emergente de cierre inesperado»
20. Al pulsar el recordatorio de notificación de Tarea, ahora salta a la página de lista donde está la Tarea
21. El icono de Atributo personalizado admite seleccionar la biblioteca de iconos integrada de la App
22. Optimizado el nombre de la operación de compartir «Leer más tarde» en lugar de mostrar directamente el nombre de la App
23. Optimizada la notificación de desbloqueo de Logro; ahora se muestra la descripción del Logro
24. Cuando el widget de escritorio entra en la página principal, salta automáticamente al módulo «delegación»
25. Optimizada la visualización del texto tras completar la lista del día
26. Optimizado el texto y la secuencia de operación del efecto de cuenta atrás de Objetos
27. Cuando todos los Atributos están ocultos, la página de estado ya no muestra la tarjeta «Atributo»

**Correcciones**

1. Corregido un cierre inesperado poco frecuente en ventanas emergentes de desbloqueo de Logros
2. Corregido el problema por el que una Tarea podía ocupar varias líneas en widgets de escritorio con ancho insuficiente
3. Corregido el problema por el que la primera autorización de ejercicio para conteo de pasos podía mostrar el total acumulado por el sensor
4. Corregido el cierre inesperado o confusión al recuperar tras pausar una cuenta atrás e iniciar otra
5. Corregido el cierre inesperado al introducir un efecto de cuenta atrás de 0 minutos en Objetos
6. Corregido el problema por el que el nombre de la lista seleccionada no se actualizaba al renombrar la lista actual en la página de añadir o editar Objetos
7. Corregida la visualización anómala de tarjetas con frecuencia de repetición «anual»
8. Corregido el problema por el que las monedas personalizadas no surtían efecto a tiempo en algunos casos
9. Corregido el problema por el que los widgets mostraban Objetos congelados
10. Corregido el problema por el que el Logro personalizado no mostraba el aviso de «pulsación prolongada»
11. Corregido el problema por el que el total de Puntos de Experiencia en la página «Yo» no contabilizaba los de Atributos personalizados
12. Corregido el problema por el que la página «Reflexiones» volvía arriba tras previsualizar una imagen anormalmente
13. Corregido el problema por el que el acceso directo estático «Tomato» solo saltaba a la página principal si la App ya estaba iniciada en MIUI
14. Corregido el problema por el que los no miembros también podían cargar fondos personalizados
15. Corregido el problema por el que el número de monedas en la página de la Tienda no se actualizaba a tiempo
16. Corregido el problema por el que el calendario no podía pasar al año siguiente
17. Corregido el problema por el que el nombre de lista del widget no se actualizaba tras modificar el nombre de la lista

**Release Candidate → Versión oficial**

1. Optimizada la tasa de éxito al subir archivos grandes a Google Drive; más reintentos y estrategia de bloques optimizada
2. Corregido el problema por el que los miembros podían no ver el botón de fondo personalizado individual de Tareas en entornos no chinos
3. Si fallaba la copia de seguridad de Google Drive/DropBox, saltaba a la página de copia de seguridad en lugar de la configuración WebDAV
4. Añadida descripción en ventana emergente de fallo de verificación de Google Play, con ruta de exportación de datos
5. El apodo en la página «Yo» cambia de color según el estado de membresía
6. Eliminado el error de punto flotante de la tasa de interés del ATM en la mayoría de escenarios
7. Al eliminar datos locales, también se eliminan sincrónicamente fondo personalizado, imágenes de Atributos y archivos de efectos de sonido
8. Corregido el problema anómalo del gráfico de conteo de pasos
9. Corregido el problema por el que los Atributos de la página de nueva Tarea no se actualizaban tras pulsar el botón de ayuda, ir a personalización de Atributos y volver
10. Al personalizar el efecto de un Objeto, pulsar fuera de la ventana emergente ya no la cierra automáticamente, evitando perder el contenido editado
11. Optimizado el problema de UI en idiomas extranjeros en la página de configuración de Objetos (texto ruso demasiado largo)
12. Intento de corregir el cierre inesperado del toast de color en algunos modelos
13. Corregido el problema por el que el botón de uso seguía siendo clicable cuando la página de Inventario estaba seleccionada
14. Corregida la lógica de visualización de Tareas únicas vencidas en la lista inteligente, adaptada al nuevo método de almacenamiento de hora de vencimiento
15. Cuando el Inventario está seleccionado, la lista conmutada debe deseleccionarse

**1.85.4 (2021/12/08)**

Versión habitual de corrección de errores; la próxima versión con novedades sigue en desarrollo~

1. Corregido el problema por el que el icono predeterminado de monedas del widget no se mostraba correctamente fuera del modo oscuro
2. Corregido el problema por el que la animación de la barra de progreso no se reproducía con normalidad en ascensos/descensos continuos de Nivel
3. Corregido el problema por el que el número de monedas en la página de Inventario no se actualizaba a tiempo
4. Corregido el problema por el que el plazo podía cambiarse forzosamente al editar el elemento «día de la semana»
5. Corregido el problema por el que la rotación de pantalla podía hacer perder la información de subtareas modificadas al editar Tareas
6. Corregido el problema por el que el número de monedas no surtía efecto al crear o editar productos
7. Condiciones de visualización de las veces de finalización anual en la página de detalles de enmienda
8. Optimizado el almacenamiento de imágenes en la App; no deberían indexarse en el álbum del sistema
9. Optimizada la descripción del interruptor de Reflexiones
10. Corregidos algunos cierres inesperados

**1.85.3 (2021/11/18)**

1. Optimizado el método de cálculo de tiempo de temporización; compensa el tiempo de suspensión de CPU
2. Corregido el problema por el que editar el icono al copiar un producto hacía perder el icono del producto original
3. Otras correcciones menores (como etiqueta de equipo)

**1.85.2 (2021/11/07)**

1. Corregido el problema por el que no se generaban registros ni Recompensas en la liquidación tras suspender la temporización
2. Corregido el problema por el que la operación «mover a» bajo la lista inteligente hacía que la lista se mostrara incorrectamente
3. Corregido el problema por el que el valor actual de «Número actual de monedas» no coincidía con el cálculo real (el valor mostrado no incluía depósitos en ATM)
4. Corregido el problema por el que el registro y la Recompensa se repetían tras finalizar el trabajo Pomodoro y pulsar dos veces seguidas el botón omitir

**1.85.1 (2021/11/02)**

0. Corregido el problema de carga de la lista de Reflexiones

**1.85.0 2021/10/20)**
*Novedades*

1. Pomodoro admite modo de temporización positiva
2. Pegar varias líneas de texto para crear subtareas rápidamente
3. Los Objetos admiten operación de copia
4. Deslizar para cambiar la dirección de la lista de Objetos; admite inverso (ajustes-Objetos)
5. Soporte para borrar el registro obtenido de Pomodoro
6. Pomodoro añade botón forzado de cambio horizontal/vertical
7. Aumentadas las condiciones de desbloqueo de Logros:
   ● Número de productos obtenidos por Síntesis
   ● Cantidad acumulada de Objetos obtenidos
   ● Cantidad actual del producto
   ● Nivel de vida
   ● (Repetitiva) tiempo de Enfoque de la Tarea
8. El icono de Habilidad también admite varios ajustes de recorte
9. Acceso directo estático:
   ● Nueva Tarea
   ● Entrar en la página Pomodoro
10. Aumentada la personalización de efectos de sonido:
    ● Obtener Recompensas de Logros (incluidos Logros del sistema y personalizados)
    ● Abrir Caja de botín
    ● Síntesis (incluida Síntesis simple y Síntesis)
    ● Efecto de sonido de notificación
11. Personalización del icono de monedas
12. El efecto de uso de Objeto admite configurar múltiples efectos de cambio de Puntos de Experiencia
13. Cambios en la adaptación de Habilidades del gráfico circular de Puntos de Experiencia
14. La página de historial admite filtrado por estado
15. Función de etiqueta de equipo

*Mejoras*

1. Cuando la Recompensa de monedas de subtarea es 0, no se muestra en los detalles
2. Nueva página de lista de Logros y guía para «Crear Logro»
3. Optimizada la visualización de iconos de widgets
4. Añadidos efectos de sonido al completar subtareas (detalles, páginas nuevas)
5. Tras introducir contenido en páginas de crear o editar (Tareas, Objetos, Logros, Síntesis), al pulsar volver aparece un cuadro de confirmación para descartar cambios
6. Optimizada la ordenación al crear productos (con ordenación personalizada, los productos nuevos tienen prioridad máxima)
7. Al editar Tareas/Objetos, el método de entrada no debe abrirse automáticamente
8. La página de nueva Tarea admite pantalla horizontal sin pérdida de datos
9. Adaptación del color de tema de miembro para widgets de escritorio
10. Optimizado el selector de Objetos; muestra primero y carga datos de forma asíncrona
11. La etiqueta de Inventario también añade entradas «Síntesis» y «ATM»
12. Las operaciones [Marcar como completada] y [Deshacer] en cambio de estado del historial vuelven al menú de primer nivel
13. Añadida entrada rápida Pomodoro en detalles del evento
14. Optimizada la ordenación de la lista «Todas» de la Tienda (añadida opción de agrupar por lista, solo Tienda)
15. Tras seleccionar días de la semana para repetir, se recalcula la hora límite. (Evita que, al repetir en días laborables, el plazo siga en sábado o domingo.)
16. Al volver a la página «Delegación», si el botón «+» no se muestra, se activa su visualización.

*Correcciones*

1. Corregido el problema por el que el progreso de la lista no se actualizaba a tiempo cuando la página de Logros estaba en la barra de navegación inferior
2. Corregido el problema de cambio de estado de Objetos históricos
3. Reparada la visualización de vencimiento en cuentas atrás negativas
4. Los Logros de monedas deben incluirse en el depósito del ATM
5. Corregido el problema por el que, con Pomodoro en pausa, volver a entrar dos veces borraba el tiempo
6. Corregido el problema por el que la restricción de compra podía invalidarse en ciertas circunstancias
7. Corregido el problema por el que los registros de cuenta atrás podían repetirse en casos poco frecuentes
8. Corregido el problema por el que pulsar distintas tarjetas de Tarea seguidas podía dejar el contenido de una tarjeta en blanco al volver a la página
9. Ajuste de la lógica de cálculo automático de monedas y Puntos de Experiencia
10. Corregidos algunos cierres inesperados

**1.84.4 (2021/10/09)**

1. Corregido el problema por el que el icono integrado podía no mostrarse

2. Actualización del grupo Q

**1.84.3 (2021/10)**

1. Actualización de textos para el extranjero

**1.84.2 (2021/09/26)**

1. Corregido el bloqueo que podía provocar la Síntesis

2. Corregido el problema por el que los detalles del producto mostraban efectos de uso anómalos de productos no disponibles

3. Optimizado el efecto visual de esquinas redondeadas de los widgets

**1.84.1 (2021/09/20)**

1. Corregido el problema por el que no se podía borrar el número de repeticiones objetivo al editar

**1.84.0 (2021/09/19)**

***Novedades***

1. Sistema de Habilidades (personalización de Atributos)

   Todos los mecanismos originales se adaptan al sistema de personalización de Atributos, como Atributos de Logros que alcanzan condiciones de desbloqueo, Recompensas de Puntos de Experiencia de productos, etc.

2. Personalizar el efecto comestible del Pomodoro, permitiendo cambiar el valor de Puntos de Experiencia y los tipos de Atributo

3. El icono de la Tienda admite cambiar el estilo de recorte (ajustes de la Tienda)

4. Los detalles del producto ahora muestran una lista de efectos de uso

5. Añadido color de tema de miembro #6bab8b

6. Soporte para eliminar la cuenta de calendario de recordatorios

***Mejoras***

1. La página Pomodoro admite visualización horizontal

2. Añadida la descripción de «Cantidad prestable» en los ajustes del producto

3. Añadido un aviso del tamaño de archivo de la sincronización en la nube

4. Actualizadas dependencias relacionadas con Facebook y Dropbox

5. Optimización parcial de la interfaz y textos de algunas páginas

6. Optimizada la interacción al crear subtareas

***Correcciones***

1. Corregido el problema por el que la versión predeterminada del icono del Atributo era inconsistente

2. Corregido el problema por el que pulsar rápido para abrir la caja podía provocar aperturas repetidas o cierres inesperados

3. Corregido el problema por el que los eventos de calendario ya recordados no se eliminaban al borrar Objetos

4. Corregido el estado anómalo tras cambiar un Objeto de «Completado» a «Vencido» en la página de historial. Los datos históricos deberían repararse automáticamente al actualizar a la nueva versión

5. Corregido el problema por el que la lista seleccionada se marcaba incorrectamente en el diálogo de selección de lista al crear un producto nuevo; eliminada la visualización de la lista «todas»

6. Corregido el problema por el que, al editar otro contenido y las veces de repetición objetivo, la edición volvía a fallar

7. En la página de nuevo Logro, corregido el problema por el que la selección de Atributo no se podía editar y quedaba en blanco

8. Otras correcciones menores y optimizaciones

**1.83.16 (2021/08/20)**

1. Corregido el cierre inesperado y la ineficacia al modificar el avatar en modo sin conexión
2. Optimizada la interacción al seleccionar el efecto de apertura de producto
3. Corregido el problema de foco en algunos campos de texto largo
4. Corregido el problema por el que el plazo y la hora del recordatorio se mostraban incorrectamente en algunos casos
5. Corregido el problema por el que los cambios de configuración del modo conciso no surtían efecto de inmediato

**1.83.15**

1. Soporte para marcar Tareas de penalización en widgets de la App
2. Corregido el comportamiento anómalo de «plegar asuntos fuera de siete días»
3. Aumentado el límite de imágenes de Reflexiones a 9
4. La página de inicio de sesión muestra el último método de acceso
5. Al cancelar la penalización (marcada como completada), no se otorga Recompensa adicional
6. La lista inteligente ahora admite mostrar Objetos completados
7. Corregida la situación anómala de copia de seguridad automática en la carpeta «download» en algunos casos
8. Corregidos algunos problemas de visualización de la interfaz

**1.83.14**

1. Corregido el problema por el que Pomodoro podía no registrar la duración al ejecutar «omitir»
2. Corregido el problema por el que los Objetos de penalización ejecutaban la lógica de vencimiento y penalización
3. Corregidos problemas relacionados con la edición de penalizaciones
4. Corregidos problemas relacionados con la selección de imágenes en modo horizontal
5. Corregido el fallo ocasional al restaurar una copia de seguridad desde una ruta personalizada

**1.83.8-1.83.13**
Novedades

1. Soporte para configurar el fondo de la tarjeta de forma independiente
2. La función de eliminar registro ahora admite borrar Reflexiones, almacenes y registros de temporización
3. Los Logros del sistema pueden elegir Recompensa de Puntos de Experiencia o de monedas
4. Función de búsqueda de eventos
5. Soporte para copia de seguridad automática local en la carpeta «download» (Android 10 y superior)

Mejoras

1. Mejorado el método de invocación predeterminado de recordatorios por notificación, que en teoría aumenta la tasa de éxito por encima de Android 6
2. Aumentada la prioridad de notificación del temporizador Pomodoro a [Alta], mejorando la supervivencia del temporizador en segundo plano y la visualización de notificaciones
3. En la página, añadidos enlaces al grupo QQ y al sitio web oficial, optimizada la interfaz; QQ admite unirse al grupo con un clic
4. Mejorado el momento de activación de notificaciones de Logros, que deberían mostrarse de inmediato tras activarse en la página principal
5. Añadida la casilla «Aplicar solo a la lista actual» en la opción «Filtrar» de la lista de Objetos, separando las opciones predeterminada y todas las listas
6. Añadidos efectos de animación al componer
7. Comentarios: ampliado el canal de la comunidad Rabbit Xiaochao, más cómodo para subir imágenes y hacer seguimiento de incidencias
8. Añadida visualización del valor relativo en el campo de entrada de Objetos de recuento
9. Optimizado el efecto de visualización de pestañas no seleccionadas
10. Eliminado el aviso aleatorio al pulsar el avatar; ahora se entra en la página personal
11. Cuando la Recompensa de monedas no está configurada, se muestra «sin configurar» en lugar de «0»
12. Cuando la probabilidad de apertura de caja es inferior al 0,01 %, ya no se muestra «0,00 %» sino «<0,01 %»
13. El interruptor de Reflexiones ya no se memoriza y queda desactivado por defecto
14. Optimizado el proceso de solicitud de permisos de calendario y cámara
15. Optimizados el efecto al pulsar y la visualización de algunas páginas
16. Optimizado el método de recordatorio de calendario, intentando resolver el problema por el que algunos dispositivos pueden eliminar la cuenta de calendario

Correcciones

1. Corregido el cierre inesperado por filtrado continuo en la página de Reflexiones
2. Intento de corregir el cierre inesperado poco frecuente del cuadro de diálogo configurado de fábrica
3. Corregido el problema por el que, con un campo de entrada largo, al pulsar el texto saltaba automáticamente al final
4. Corregido el problema por el que no se podían configurar Recompensas aleatorias de monedas al crear un equipo
5. La versión de distribución nacional elimina por completo dependencias relacionadas con Firebase
6. Corregida la excepción ocasional al actualizar la página de lista de Logros
7. Corregido un cierre inesperado ocasional al seleccionar el icono integrado
8. Corregido el problema por el que las subtareas seguían visibles al volver a la página de detalles tras borrarlas todas
9. Corregido el problema por el que no se podía editar el nombre de la lista predeterminada de Síntesis
10. Corregido el problema por el que el cuadro de filtro aparecía en la página de perfil
11. Corregido el problema por el que el Objeto de equipo no se heredaba tras configurar la Recompensa de producto

**1.83.7 (2021/06/24)**

1. Ordenación de listas por monedas añadidas
2. Añadida selección de idioma en la página de guía
3. Optimizada la velocidad de carga de la página de Logros
4. Cambiada la información del grupo QQ para unirse con un clic
5. Corregido el problema por el que pulsar repetidamente durante la apertura podía provocar cambios múltiples en el Inventario
6. Corregida la visualización incorrecta de Objetos vencidos individuales en la lista diaria de Objetos

**1.83.6 (2021/06/22)**

Novedades

1. (Miembros) Soporte para configurar el fondo de la tarjeta de forma independiente
2. La función de eliminar registro ahora admite borrar Reflexiones, almacenes y registros de temporización
3. Los Logros del sistema pueden elegir Recompensa de Puntos de Experiencia o de monedas
4. Función de búsqueda de eventos
5. Soporte para copia de seguridad automática local en la carpeta «download» (Android 10 y superior)

Optimización

1. Mejorado el método de invocación predeterminado de recordatorios por notificación, que en teoría aumenta la tasa de éxito por encima de Android 6
2. Aumentada la prioridad de notificación del temporizador Pomodoro a [Alta], mejorando la supervivencia del temporizador en segundo plano y la visualización de notificaciones
3. En la página, añadidos enlaces al grupo QQ y al sitio web oficial, optimizada la interfaz; QQ admite unirse al grupo con un clic
4. Mejorado el momento de activación de notificaciones de Logros, que deberían mostrarse de inmediato tras activarse en la página principal
5. Añadida la casilla «Aplicar solo a la lista actual» en la opción «Filtrar» de la lista de Objetos, separando las opciones predeterminada y todas las listas
6. Añadidos efectos de animación al componer
7. Comentarios: ampliado el canal de la comunidad Rabbit Xiaochao, más cómodo para subir imágenes y hacer seguimiento de incidencias
8. Añadida visualización del valor relativo en el campo de entrada de Objetos de recuento
9. Optimizado el efecto de visualización de pestañas no seleccionadas
10. Eliminado el aviso aleatorio al pulsar el avatar; ahora se entra en la página personal
11. Cuando la Recompensa de monedas no está configurada, se muestra «sin configurar» en lugar de «0»
12. Cuando la probabilidad de apertura de caja es inferior al 0,01 %, ya no se muestra «0,00 %» sino «<0,01 %»

**1.83.0-alpha04 (2021/05/23)**

1. Soporte para configurar, ordenar y desactivar libremente el módulo inferior
   Los módulos se irán adaptando gradualmente; por ahora solo algunos módulos funcionales (como Pomodoro; historial aún sin adaptar)
2. Añadido un segundo modo de pausa al efecto de cuenta atrás del producto, que permanece en la barra de notificaciones y puede reanudarse en cualquier momento
    Y añadido el logotipo «experimental»
3. Al elegir omitir el Pomodoro, añadido un aviso de que no se puede obtener un Pomodoro
4. Añadida una pista para expandir y contraer la Tarea de ejemplo
5. Corregido el cierre inesperado que podía provocar el diseño en la parte superior de la lista en algunas páginas
6. Optimizado el aviso de error de red cuando no hay conexión
7. Optimizado el aviso de Recompensa de monedas al completar subtareas, cambiado a Toast no intrusivo

**1.83.0-alpha03 (2021/05)**

1. Corregido el problema por el que el diseño vacío de la página de composición podía superar la pantalla
2. Corregido el problema por el que el nombre del Atributo «Encanto» se mostraba incorrectamente en la página de creación
3. Corregidos algunos problemas con la configuración de monedas
4. Optimizado el efecto de animación de la página de Logros para adaptarse al escenario en la barra de navegación inferior
    (Adaptado, pero la interfaz aún no está lista; espere actualizaciones posteriores)
5. Actualizada la versión SDK objetivo a Android 11
6. Corregido el problema de diseño vacío en la página «Moment»
7. Corregido el problema de cálculo anómalo de intereses

**1.83.0-alpha02 (2021/05/16)**

1. Corregido el problema por el que se podían crear recetas de Síntesis en la lista «Todas»
2. Tras entrar en la interfaz del sistema de Síntesis, independientemente de la lista en la que estés, el contenido mostrado es la lista «Todas».
3. Reparación simple del método de cálculo de intereses del ATM

**1.83.0-alpha01 (2021/05/16)**

1. Sistema de Síntesis completo, con soporte para cualquier implementación N-a-N
   - Lista de comprobación
   - Crear/Editar
   - Diálogo de Síntesis
   - Modo nocturno y soporte multilingüe
   - La «entrada» está en la parte superior de la página de la Tienda
2. Refactorización del código interno de la página de nueva Tarea
    Por escalabilidad de la App, hemos reorganizado casi por completo el código de creación de Tareas y podríamos rediseñar la interfaz en el futuro.
    Las actualizaciones alpha posteriores añadirán también «fecha de repetición objetivo», «hora de recordatorio relativa», «Tareas de tipo penalización (por determinar)» y otras funciones.
    Si encuentras un problema, puedes volver a la versión antigua de la página en cualquier momento.

3. Añadida entrada al ATM en la parte superior de la Tienda
4. Los adjuntos de Tarea admiten hasta 9 imágenes y se ha ajustado la ruta de almacenamiento
5. Función TAG de equipo
    La implementación está integrada, pero el contenido TAG concreto aún no está configurado, así que no se muestra por ahora

**1.82.16 (2021/05)**

1. Corregido el problema por el que las Tareas de ejemplo no ejecutaban correctamente la lógica de vencimiento (solo válido para usuarios nuevos)
2. Corregido el problema por el que el número de finalizaciones de Tareas ilimitadas podía faltar 1 vez en ciertos escenarios

**1.82.15 (2021/05)**

1. Corregido el problema de reproducción de efectos de sonido en segundo plano

**1.82.14 (2021/05)**

-

**1.82.13 (2021/05)**

1. Corregido el problema por el que las Tareas ilimitadas podían ralentizar la carga de la lista y hacer impreciso el recuento de cancelaciones
2. Corregido el problema por el que completar la Tarea en el widget de escritorio podía reproducir varias veces el efecto de sonido de finalización
3. Corregido el problema por el que el recuento total de Objetos superiores en la lista inteligente no era preciso
4. Soporte para eliminar todos los datos locales y eliminar la cuenta
5. Corregido el problema por el que la edición de subtareas de Tareas de equipo no se heredaba

**1.82.12 (2021/05)**

1. Corregido el problema de recuento al deshacer la finalización de Tareas ilimitadas
2. Corregido el problema por el que las Tareas congeladas seguían recordándose
3. Optimizado el cambio de lista, lo que puede aumentar la velocidad en dispositivos antiguos y añadir animaciones de carga
4. Corregido el problema por el que el efecto de sonido personalizado al terminar el descanso no surtía efecto; admite configurar el efecto de fin de temporización de producto
5. Corregido el problema por el que Pomodoro no contabilizaba el tiempo de Enfoque al usar la operación «omitir»
6. Corregido el problema por el que el botón de pausa de la cuenta atrás del producto no surtía efecto

**1.82.11 (2021/05)**

1. Corregido el problema de recuento al deshacer la finalización de Tareas ilimitadas
2. Corregido el problema por el que las Tareas congeladas seguían recordándose
3. Optimizado el cambio de lista, lo que puede aumentar la velocidad en dispositivos antiguos y añadir animaciones de carga
4. Corregido el problema por el que el efecto de sonido personalizado al terminar el descanso no surtía efecto; admite configurar el efecto de fin de temporización de producto
5. Soporte para idioma ruso

**1.82.10 (2021/05)**

1. Corregido el problema por el que Pomodoro no contabilizaba el tiempo de Enfoque al usar la operación «omitir»
2. Corregido el problema por el que el botón de pausa de la cuenta atrás del producto no surtía efecto
3. Capturado un cierre inesperado provocado por fallo al crear un recordatorio de calendario

**1.82.9 (2021/05)**

1. Corregido el problema por el que el límite de tiempo de la Tarea copiada podía vaciarse y provocar cierre inesperado al repetir
2. Optimizada la velocidad de actualización tras completar Tareas ilimitadas
2. Corregido el problema de cálculo de la hora de recordatorio en Tareas de equipo
3. Corregido el problema por el que completar deslizando podía dejar la animación sin terminar y la pantalla en blanco
4. Las Tareas de equipo admiten abandono deslizando
5. La introducción del producto en la ventana de compra admite desplazamiento

**1.82.8 (2021/04/28)**

**novedades**

1. Añadida visualización de la racha de finalizaciones actual
2. Optimizado el efecto de cuenta atrás de Objetos de la Tienda, con operaciones de finalizar y pausar; al terminar de forma anómala se calcula en tiempo absoluto
3. Soporte para configurar por separado el modo de vibración y el interruptor de campana del Pomodoro
4. Soporte parcial para previsualizar plazos futuros de eventos en curso en el calendario
5. Soporte para reiniciar eventos únicos e ilimitados
6. Modificada la visualización de datos en la página «Yo»: «Vencido» y «Abandonar» pasan a «Logro (desbloqueado)» y «Reflexiones»; la página de estadísticas muestra el número de «Vencidos» y «Abandonados»
7. Soporte para solicitar directamente la creación de widgets desde la página de ajustes «widgets de escritorio» (solo Android 8 o superior)

**mejoras**

1. Soporte para ver imágenes ampliadas de Objetos de la Tienda
2. Optimizado el consumo de energía que podía provocar el conteo de pasos
3. Corregidos algunos problemas de visualización cuando la fuente es demasiado grande
4. Optimizada la cancelación de Tareas ilimitadas
5. Optimizada la visualización de notificaciones Pomodoro y añadida barra de progreso
6. Tras completar el evento, se elimina el recordatorio de notificación que se estaba mostrando
7. Optimizadas las estadísticas de ingresos y gastos de monedas
8. Añadidas algunas guías y consejos para el usuario
9. Al editar Tareas, soporte para borrar la selección de Recompensa de producto
10. Al tratar cierres inesperados continuos, añadido aviso de «Problemas conocidos»
11. Optimizado el efecto de visualización cuando no hay Atributo seleccionado

【reparación】

1. Tras ordenar la lista en la página principal, el estado debería actualizarse de inmediato
2. Corregido el problema por el que la página de detalles no actualizaba de inmediato la lista de subtareas
3. Corregido de forma forzada el cierre inesperado del inicio de sesión autorizado con Weibo
4. Corregido el problema por el que el nombre de la Tarea mostrado en la notificación Pomodoro podía ser incorrecto
5. Corregido el problema por el que la cuenta atrás en la notificación Pomodoro era imprecisa
6. Corregido el problema por el que no aparecía el cuadro de Recompensa cuando la Tarea y el Logro solo tenían Recompensas de mercancía
7. Corregido el problema por el que no se podían comprar Objetos de 0 monedas en ciertas circunstancias
8. Optimizado el método de cálculo de reparación de Objetos Ebbinghaus
9. Optimizado el método de cálculo del número de finalizaciones de hoy para eventos ilimitados

**1.82.7 (2021/04/10)**

1. Corregida la visualización de la interfaz con datos vacíos en la pantalla [Moments]
2. El tamaño de fuente vuelve a seguir los ajustes del sistema
3. Actualizada la traducción al inglés y al portugués

**1.82.5 (2021/04/02)**

1. Corregidos algunos problemas del registro Pomodoro
2. Añadidas nuevas guías

**1.82.4-alpha01/beta (2021/03/25)**

1. Corregidas Recompensas de Cajas de botín
2. Ver Reflexiones de Tareas seleccionadas
3. Recompensas de Puntos de Experiencia/monedas aleatorias para Logros personalizados
4. Las Tareas de la lista inteligente ahora se agrupan por lista
5. Repetición anual
6. Más mejoras y correcciones de errores

**1.82.1 (2021/03/12)**

1. Corregidos algunos problemas de listas inteligentes
2. Corregido el problema por el que la barra de progreso podía no cambiar tras completar una Tarea
3. Corregido un problema al forzar la finalización de una Tarea de recuento
4. Corregido el problema por el que se mostraba «NULL» en el diálogo inferior de vencimiento

**1.82.0 (2021/03/11)**

1. Listas inteligentes
2. Rediseño de iconos de Atributos
3. Nuevo efecto de Objeto «Cuenta atrás»
4. El temporizador Pomodoro sigue registrando tiempo extra tras completar el temporizador; puedes elegir actualizar el tiempo de Enfoque y obtener Recompensa extra.
5. Las Tareas de recuento ahora pueden forzarse a completarse sin alcanzar el objetivo.
6. Ahora puedes elegir completar Tareas no iniciadas y decidir si posponer la hora
7. Más correcciones y mejoras

**1.81.6**

1. Corregidos problemas del aviso de recordatorio Pomodoro

**1.81.5 (2021/03/02)**

1. Traducción al italiano (parcial)
2. Corregido el icono de notificación
3. Corregido el recordatorio que no funcionaba bien con repetición entre días laborables
4. Corregida la selección «hacer foto» que no funcionaba
5. Más correcciones menores

**1.81.0~1.81.4**

1. Rediseño de parte de la interfaz y animaciones
2. La Tarea se completa automáticamente cuando se completan todas sus subtareas
3. Corregido un error de cambio múltiple de Puntos de Experiencia
4. Corregido un error de restauración desde Dropbox
5. Ahora puedes devolver un Objeto sin recibir monedas
6. Ajuste de visualización en formato de 12 horas
7. Congelar/Descongelar varias Tareas

**1.80.7（2021/01/26)**

1. Añadidas estadísticas de Objetos de la Tienda
2. Rediseño del diálogo de descripción de Atributos
3. Descripción personalizada de Atributos
4. Añadido ajuste de modo compacto: ocultar toda la información extra
5. Corregido un error al restaurar desde archivo de copia de seguridad
6. Más correcciones y mejoras...

**1.80.6（2021/01/22)**

1. Los Objetos con efecto de Caja de botín ahora pueden compartirse en el mercado
2. Nueva página de búsqueda: ahora puedes buscar usuarios por apodo
3. Filtrar Objetos de equipo/mercado por rango de tiempo
4. Notificación de añadir Tareas rápido
5. Los archivos multimedia pueden ignorarse al hacer copia de seguridad.
6. Más correcciones y mejoras...

**1.80.5（2021/01/14)**

1. Abrir 10/50 Cajas de botín con un clic
2. Añadida condición de desbloqueo [Obtener el Objeto seleccionado un número determinado de veces de Cajas de botín]
3. Ajustes de tipo de interés del ATM
4. Introducir cantidad para vender/comer tomates
5. Efecto de sonido personalizado al terminar el temporizador de descanso
6. Añadidas algunas guías de usuario
7. Corregidos algunos problemas y mejoras

**1.80.4（2021/01/04)**

1. Corregido un cierre inesperado en Android 6

**1.80.3（2021/01/04)**

1. Recorte de imagen libre
2. Ver/Añadir el icono de Objetos en el mercado
3. Al seleccionar Tarea/Objeto, ahora puedes crear uno nuevo directamente
4. Soporte para acción COPIAR en Logros de usuario
5. Muchas correcciones y mejoras

**1.80.0（2020/12/24)**

1. ¡Efecto de Caja de botín en Objetos de la Tienda!
2. Integración con copia de seguridad Dropbox
3. Configuraciones del modo compacto
4. Añadida barra de historial de selección de fotos
5. Muchas correcciones y mejoras

**1.79.x（2020/12)**

1. 3 ajustes más de condiciones de desbloqueo
2. Configuración de efectos de sonido personalizados
3. Configurar Recompensa de Objeto para Logros
4. Página de registro del temporizador Pomodoro
5. Crear Tarea desde la página Calendario
6. 5 colores de tema nuevos.
7. Muchas mejoras y correcciones

**1.78.x（2020/11)**

1. Condición de desbloqueo de Logros personalizados
2. Puntos de Experiencia personalizados de Tarea
3. Muchas mejoras y correcciones

**1.77.1（2020/11/05)**

1. Barra de herramientas para cambiar de lista
2. Interruptor para mostrar Tareas completadas
3. Las listas ahora pueden archivarse
4. Añadida tarjeta de estado de monedas
5. Ahora puedes crear Reflexiones para Logros de usuario
6. Añadido ajuste para seguir el modo nocturno del sistema

**1.77.0（2020/10/28)**

1. Añadido módulo Mercado para la comunidad, donde puedes compartir diseños de Objetos de la Tienda o importar Objetos
2. Corregida la lógica de repetición mensual
3. Corregida la copia de seguridad automática WebDAV cuando no se había hecho al menos una copia

**1.76.0（2020/10/13)**

1. Monedas predeterminadas de subtarea
2. Añadidos iconos en la App para crear Objetos de la Tienda y Logros
3. Precio personalizado de tomates
4. Ajustes globales para activar efectos de sonido
5. Ahora las Reflexiones pueden buscarse por contenido de Tarea

**1.75.2（Released at 2020/10/05）**

1. Ajuste del número predeterminado de monedas de subtarea
2. Más de 100 iconos seleccionables como iconos de Objetos de la Tienda/Logros
3. Añadido ajuste «Activar efecto de sonido»
4. Filtrar Reflexiones por contenido de Tarea y mejor interfaz de filtros
5. Crear accesos directos Pomodoro
6. Precios de venta personalizados de tomates
7. La página Pomodoro mantiene la pantalla encendida durante la cuenta atrás
8. Corregidos algunos problemas

**1.75.1（Released at 2020/09/20）**

1. Corregidos muchos errores de 1.75.0

**1.75.0（Released at 2020/09/16）**

1. Pomodoro gamificado
2. Color personalizado de etiqueta de Tarea/lista
3. Copia de seguridad automática WebDAV
4. Ajustes para ocultar módulos
5. Muchas mejoras y correcciones

**1.74.2（Released at 2020/08/23）**

1. Idioma portugués

**1.74.0（Released at 2020/08/13）**

1. ATM: Depositar y retirar monedas
2. Ahora puedes seleccionar Objetos de la Tienda como Recompensa de Tarea
3. Ajuste de cantidad en stock de Objetos de la Tienda
4. Mejoradas animaciones y corregidos algunos errores
5. Añadida pista para el ajuste de frecuencia de repetición
6. Más... (descripción pendiente de actualizar)

**1.73.0（Released at 2020/07/26）**

**Novedades:**

- Logros de usuario
- Animación de disminución de Puntos de Experiencia
- Editar la hora de finalización del registro de historial
- Ajuste de monedas de subtarea de equipo

**Mejoras:**

- Añadido efecto de sonido de monedas

**Correcciones:**

- Problema de pérdida del ajuste de monedas de subtarea al repetir una Tarea

**1.72.1（Released at 2020/06/14）**

**Novedades:**

- Borrar datos de Logros

**Mejoras:**

- Mejor visualización de la descripción de Objetos de la Tienda

**Correcciones:**

- Problema al editar imágenes de Objetos de la Tienda
- Problema al editar el texto de Reflexiones

**1.72.0（Released at 2020/06/11）**

**Novedades:**

- Recordatorio de subtarea
- Monedas de subtarea
- Widget de la App
  1. Ajuste de opacidad
  2. Mostrar número de monedas
  3. Mostrar diálogo de entrada de Tarea de recuento
- Selección de tiempo en la página de estadísticas
- Inventario: Devolver Objeto
- Soporte de subtareas para equipos

**Mejoras:**

- Deslizar una Tarea de recuento ahora suma 1 finalización en lugar de marcarla como completada
- Añadido botón Ayudar a traducir
- Añadido ajuste de Recompensa múltiple de Puntos de Experiencia para Tareas de recuento

**Correcciones:**

- Corregido que la parte transparente de imágenes PNG se veía negra tras recortar.
- Corregido que el widget de la App no funcionaba bien en algunos dispositivos.
- Corregido que el número de monedas aparecía en la página de detalles cuando estaba en 0.
- Corregido que Deslizar para finalizar (sin diálogo) dejaba la página mal mostrada
- Corregido que no se podía crear subtarea al pulsar ENTER en algunos dispositivos

**1.71.3/1.71.4（Released at 2020/04/16）**

**Correcciones menores de icono e informe de cierre inesperado**

**1.71.2（Released at 2020/04/14）**

**Novedades:**

- Idioma turco (gracias a **İbrahim DOĞAN** por ayudar con la traducción)

- Personalizar fondo y opacidad de la tarjeta de Tarea
- Personalizar el texto del botón de acción de Objeto del Inventario
- Reflexiones favoritas
- Búsqueda de Reflexiones

**Mejoras:**

- Nuevo icono

- El tipo de informe admite varios idiomas
- Mejorada la interfaz de la página de Ajustes
- Mejorado el método de cambio de color de tema e idioma. Ya no hace falta reiniciar la App.
- Mejorada la página de recorte de imagen
- Mejorada la interfaz de selección de lista
- Añadida descripción de Objeto de la Tienda en la página de lista de la Tienda

**Correcciones:**

- Corregido error por el que la fecha de desbloqueo del Logro se mostraba incorrectamente
- Corregido error por el que la imagen del Objeto de la Tienda quedaba vacía si se eliminaba el archivo.
- No se borraba el estado de subtareas tras vencer una Tarea única.
- Corregido error por falta de espacio para mostrar el Grado de dificultad en la página de detalles de Tarea.
- Corregido error por el que, tras marcar una Tarea vencida como finalizada, las veces completadas de la siguiente Tarea no sumaban uno.
- Corregido error por el que el número máximo de monedas no se mostraba correctamente en los ajustes predeterminados de Tarea.
- La página de copia de seguridad/restauración de datos ahora es desplazable.
- Corregido que deslizar para completar Tarea no funcionaba bien al deslizar varias Tareas rápido.
- Los widgets de la App ahora muestran el estado Congelado
- Corregido error por el que la barra de progreso en la página de Tarea a veces mostraba progreso incorrecto

**Correcciones del servidor（2020/4/13）**

- Corregida la función de informe que no funcionaba

**v1.71.1 (Released at 2020/03/17)**

**Mejoras:**

- Mejor animación de la barra de progreso en la página de Tarea

**Correcciones:**

- Corregido un error que podía provocar cierre inesperado al iniciar la App en algunos dispositivos
- Corregido un error al seleccionar fotos

<!-- more -->

**v1.71.0 (Released at 2020/03/13)**

**Novedades:**

- Función Reflexiones

- Añadida acción al deslizar: Finalizar Tarea (sin diálogo)

**Correcciones:**

- Corregido error por el que el estado de la tarjeta de Tarea se mostraba incorrectamente

- Corregido error por el que una Tarea deshecha podía desaparecer al vencer

- Corregido que el orden seleccionado no se mostraba correctamente

**v1.70.6 (Released at 2020/03/09)**

**Mejoras:**

- Los colores del aviso de Logro desbloqueado coinciden con el color de tema

**Correcciones:**

- Corregido que el estado del diálogo de vencimiento no se mostraba correctamente tras pulsar el botón

- Corregido un error por el que COPIAR no copiaba subtareas
- Corregido un cierre inesperado al usar «Mover a...»
- Corregido que la tarjeta de selección no se mostraba correctamente en algunos dispositivos

**v1.70.5 (Released at 2020/03/06)**

**Correcciones:**

- La tarjeta To-Do seguía cargando al cambiar el color de tema o activar/desactivar el modo nocturno

**v1.70.4 (Released at 2020/03/05)**

**Mejoras:**

- La página de la Tienda muestra el número de monedas cuando no hay Objetos
- Se puede acceder a la página de detalle de monedas pulsando el número en la página de la Tienda
- Mejorado el formato de texto del widget de la App en inglés
- Se puede acceder a la página de detalles de Tarea pulsando la Tarea en el widget de la App

**Correcciones:**

- Estilo incorrecto en la actividad de equipo

**v1.70.3 (Released at 2020/03/05)**

**Mejoras:**

- La página de la Tienda ahora muestra el número de monedas cuando no hay Objetos
- Pulsar el número de monedas en la página de la Tienda abre la página de detalle de monedas
- Mejorado el formato de texto en inglés del widget de la App
- Pulsar un elemento del widget de la App abre la página de detalles de Tarea

**Correcciones:**

- Corregido que, al filtrar Hoy, el aviso inferior «xx tarea(s) aún no iniciada(s)» no aparecía tras completar la Tarea

**v1.70.3 (Released at 2020/03/05)**

**Correcciones importantes:**

- Corregidos errores al introducir número de monedas
- Corregidos errores por los que las subtareas no se actualizaban correctamente
- Corregidos errores por los que no se podía dar me gusta a la actividad de otros
- Corregidos errores por los que el widget de la App no podía completar Tareas

**v1.70.2 (Released at 2020/03/04)**

**Novedades:**

- La comunidad ya está disponible en todas las zonas horarias

- Copiar Tareas
- Soporte para editar ajustes predeterminados de Tarea nueva
- Lista de la Tienda

- Mejoradas acciones del widget de la App
- Añadido menú para Tareas finalizadas en la página Calendario

**Mejoras:**

- Mejoradas animaciones de la tarjeta de Tarea

- Eliminado un permiso innecesario
- Añadido sonido de finalización
- Mejorado el estilo de la interfaz de la página de historial
- Añadido diálogo «Permiso de lectura/escritura de calendario perdido» al activar recordatorio de calendario del sistema sin permisos concedidos

**Correcciones:**

- Corregidos errores de Tarea de recuento en modo compacto
- Corregidos errores de Tareas repetidas
- Corregido cierre inesperado que podía ocurrir al eliminar subtareas
- Corregido cierre inesperado al introducir URL WebDAV incorrecta
- Corregida visualización incorrecta del color de tema, que podía ocurrir tras restaurar una copia de seguridad

### **LifeUp-Desktop**

**v1.2.0 (2025/01/01)**

**✨ Novedades**

1. Soporte de gestión de archivos

- Copia de seguridad en el ordenador
- Restaurar desde el ordenador
- Soporte de arrastrar y soltar

2. Soporte para crear nuevas Reflexiones

- Soporte de selección de imágenes
- Soporte de sincronización de imágenes con el móvil

3. Soporte de vista de detalles de Tareas
4. Mejoras del sistema de compra

- Usar la nueva API «Purchase Items»
- Mantener los límites de compra consistentes con la App

5. Soporte de validación opcional de API Token
6. Soporte multiplataforma

- Windows
- Linux
- macOS (Apple Silicon)
- macOS (Intel) 🆕

7. Mejora del manejo de errores y notificaciones

**v1.1.1 (2023/08/29)**

**🔧 Optimizaciones y correcciones de errores**

1. Corregido comportamiento inesperado al introducir monedas de oro
2. Corregido el problema por el que buscar actualizaciones podía provocar cierre inesperado de la App

**v1.1.0 (2023/06/25)**

**✨ Novedades**

1. Soporte para comprobar automáticamente la dirección IP y la conexión de «LifeUp Cloud» (requiere LifeUp Cloud v1.3.0)
2. Soporte para añadir Tareas, aunque las opciones admitidas actualmente son limitadas (Corregido [#6](https://github.com/Ayagikei/LifeUp-Desktop/issues/6))
3. Soporte para exportar Reflexiones en formato markdown (Corregido [#5](https://github.com/Ayagikei/LifeUp-Desktop/issues/5))
4. Añadido texto en chino tradicional
5. Añadida versión de publicación para macOS
6. Soporte para comprobar actualizaciones

**🔧 Optimizaciones y correcciones de errores**

1. Corregido el problema por el que las subcategorías de Logros no se mostraban correctamente
2. Corregido el problema por el que algunos iconos no se mostraban correctamente (requiere LifeUp v1.91.3)
3. Corregido el problema de desajuste de título (Corregido [#8](https://github.com/Ayagikei/LifeUp-Desktop/issues/8))
4. Añadida opción de accesos directos para el instalador de Windows (Corregido [#13](https://github.com/Ayagikei/LifeUp-Desktop/issues/13))
5. Mejorada la forma de obtener el tamaño de ventana, adaptado a resoluciones inferiores a 1080p

**v1.0.2 (2023/02/20)**

1. Añadido cuadro emergente de informe de errores más detallado [#2](https://github.com/Ayagikei/LifeUp-Desktop/issues/2)
2. Mejorada la configuración de empaquetado

**v1.0.1 (2023/02/12)**

1. Primera publicación

### **LifeUp Cloud**

**v2.1.1 (2026/06/16)**

**✨ Novedades**

1. Expuesto el tiempo de finalización de subtareas (`endTime`) en el modelo de datos del SDK y en las respuestas de la API HTTP.

**v2.1.0 (2026/03/22)**

**✨ Novedades**

1. Añadido soporte de configuración regional y actualizaciones de localización Top-14.
2. Expuestos campos de progreso de recuento y condición de fin de repetición para Tareas de API.

**🐛 Correcciones de errores**

1. Corregidos problemas de compatibilidad con ContentProvider.
2. Adaptado el comportamiento de la interfaz de Android 15 y el inicio del servicio.

**v2.0.0 (2025/01/01)**

**✨ Novedades**

1. Optimización del servicio

- Lógica de descubrimiento de servicio y compatibilidad mejoradas
- Más dispositivos admiten detección automática de IP
- Optimizadas las transiciones de estado de inicio/pausa del servicio
- Mejora del manejo de errores y notificaciones

2. Seguridad y rendimiento

- Añadida validación opcional de API Token
- Añadidas opciones de configuración CORS
- Soporte de configuración de puerto personalizado
- Soporte de duración personalizada de wake lock

3. Mejora de la interfaz

- Diseño de interfaz completamente nuevo
- Mejora de la experiencia visual general

**v1.3.0 (2023/06/25)**

**✨ Novedades**

1. Soporte para registrar servicio mDNS para que el escritorio descubra automáticamente su IP (requiere escritorio v1.1.0)
2. Añadidos valores de resultado para APIs invocadas mediante ContentProvider.

**🔧 Mejoras**

1. Ampliado el área de pulsación del botón de escanear código QR
2. Corregido cierre inesperado ActivityNotFound

**v1.2.0 (2023/03/10)**

1. Soporte para escanear código QR para invocar la API
2. Mejorada la visualización de la lista de IP

**v1.1.2 (2023/02/12)**

1. Soporte para consultar datos completos mediante Content Provider, usado para funciones de escritorio
2. Estandarizado el contenido de respuesta HTTP

**v1.0.3-preview (2022/11/22)**

1. Primera publicación (más algunas correcciones de errores de la primera versión)

<!-- tabs:end -->
