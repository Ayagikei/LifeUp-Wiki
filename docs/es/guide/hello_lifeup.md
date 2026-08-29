<h1 align="center" padding="100">¡Bienvenido al mundo de LifeUp!</h1>

<p align="center">
 <img src="guide/_media/hello_world/banner.png" />
</p>

[中文](https://wiki.lifeupapp.fun/zh-cn/#/guide/hello_lifeup)

## Introducción

> [!TIP]
> **¡Gracias por comprar y descargar *LifeUp*!**



**LifeUp es una aplicación Android única de tareas y formación de hábitos gamificada.**

Es distinta de algunas apps de gamificación que incorporan un juego integrado.

Se centra en usar elementos de juego para motivarte a actuar en la vida real.

Puedes personalizar tus Atributos, Recompensas, Logros, Síntesis e incluso cofres del tesoro en LifeUp.

Sin embargo, esto también significa que la configuración inicial y la curva de aprendizaje pueden llevar algo de tiempo.

Una cosa a tener en cuenta: LifeUp está pensada como app de lista de tareas y formación de hábitos, no como app de calendario.


### Preguntas frecuentes antes de usar

Antes de empezar, puede que quieras conocer la siguiente información:

- **La descargué en Google Play. Si no me convence, ¿cómo puedo obtener un reembolso?**

  Tanto nosotros como Google Play entendemos que una app puede no satisfacer a todo el mundo.

  Antes de comprar LifeUp, puedes acceder a una versión de prueba de 7 días disponible en nuestro [GitHub](https://github.com/Ayagikei/LifeUp/releases).

  Si no quedas satisfecho con la App y la desinstalas en las primeras horas tras la compra, Google Play suele procesar un reembolso automático en un plazo de 24 horas.

  Si superas ese periodo de reembolso automático (24 horas) pero estás dentro de los 7 días posteriores a la compra, aún puedes contactarnos en lifeup@ulives.io y facilitar tu número de pedido GPA. Te ayudaremos con una solicitud de reembolso manual. Asegúrate de usar la dirección de Gmail asociada a la compra.

  No se procesarán solicitudes de reembolso después de 7 días desde la fecha de compra.

  Ten en cuenta que dejar una reseña en Google Play no ayudará con el proceso de reembolso. Sin la información clave, no podemos gestionar reembolsos a través de reseñas de la App en Google Play.

  

- **¿Mis datos son privados y seguros?**

  Por supuesto. ¡Valoramos tu privacidad!

  Puedes consultar [nuestros documentos de política de privacidad](https://wiki.lifeupapp.fun/en/#/introduction/privacy-terms)
  para obtener más información.
  
  En resumen: excepto el módulo Mundo (similar a la función de compartir diseños), el resto de datos
  no pasan por nuestro servidor; solo se almacenan en tu dispositivo. Lo mismo ocurre con las
  imágenes y otra información que elijas. **También puedes elegir el modo sin conexión.**
  
- **Como el servidor no almacena datos, ¿cómo puedo hacer copia de seguridad?**

  LifeUp admite funciones de exportar e importar datos.

  También puedes configurar un servidor WebDAV, Google Drive o Dropbox para copias de seguridad automáticas.

- **¿Tengo que iniciar sesión? ¿O por qué recibo un error de red al iniciar sesión?**

  ¡No! LifeUp es una App *offline-first*.

  Iniciar sesión solo se usa para acceder al módulo «Mundo», que te permite ver equipos, Objetos y Tareas
  aleatorias creadas por otros.

  Si no puedes iniciar sesión, puede deberse a un problema con tu red local o a una anomalía
  en nuestro servidor.

  Puedes probar primero a cambiar de red y DNS.

  Si crees que hay un problema con nuestro servidor, puedes enviarnos un correo para confirmarlo.

  También puedes probar a usar directamente el modo sin conexión, ¡que te da acceso a la mayoría de las
  funciones de LifeUp!

- **¿Cómo configurar las notificaciones de Tareas y la ejecución en segundo plano?**

  LifeUp admite recordatorios por notificación y por eventos de calendario.

  Debido a las limitaciones de batería de Android, **y a medidas adicionales agresivas de optimización de batería de algunos fabricantes de teléfonos**, el recordatorio por notificación predeterminado requiere configuración adicional del usuario para surtir efecto.

  También puedes probar a cambiar a recordatorios por eventos de calendario, que solo requieren conceder permisos de calendario.

  > *Pero otras funciones (como Pomodoro) también pueden necesitar configurarse para ejecutarse en segundo plano.

  Para más información, consulta este documento: https://wiki.lifeupapp.fun/en/index.html#/guide/background_running

- **¿Cómo puedo ver más preguntas frecuentes sobre el uso de la App?**

  Siempre puedes encontrar el enlace a **la página de preguntas frecuentes** en la App mediante `barra lateral` → `FAQ`.

  O simplemente recuerda nuestro sitio web:

  https://wiki.lifeupapp.fun/en/#/guide/faq

  > Si usas un ordenador, obtendrás una mejor experiencia de lectura.

---

## Sistema de incentivos

![](_media/hello_lifeup/incentive_system.png)

## Funciones

> 🚧 Esta sección sigue mejorándose. Puede que notes problemas gramaticales o capturas en otros idiomas. Las correcciones son bienvenidas.

Ya hay muchos ejemplos y guías dentro de la App.

Como *LifeUp* admite una personalización profunda, hay una pequeña curva de aprendizaje al principio.

La buena noticia es que la mayoría de las opciones avanzadas son opcionales.

**Puedes empezar con una configuración mínima** e ir añadiendo más opciones paso a paso.

Piénsalo como un juego: vas subiendo de nivel tu flujo de trabajo con el tiempo.



<h3 align="center" padding="100" id="task">I. Tareas</h3>

<p align="center">Las Tareas son la base de todo. ¡Ponte Tareas, define Recompensas e intenta desafiarte!</p>

<p align="center">
 <img src="guide/_media/hello_world/tasks.png" style="height:600px" />
</p>

En LifeUp, una Tarea es algo que puedes completar de forma realista.

El módulo de Tareas es principalmente una herramienta de `registro`. Te ayuda a hacer seguimiento de la finalización real y conectarla con Recompensas o penalizaciones.

No está diseñado para automatizarlo todo. Puedes usar el módulo de `Logros` para hacer seguimiento del progreso a lo largo del tiempo.

#### # Inicio rápido
1. **Pendientes**
    Una Tarea no repetitiva, similar a un elemento normal de la lista de tareas.
    Normalmente, basta con introducir el contenido del `pendiente`.

2. **Hábitos**

  Las Tareas repetitivas se usan normalmente para hábitos, como `levantarse temprano` o `leer cada día`.

  En la mayoría de los casos, solo necesitas configurar el `pendiente` y la `Frecuencia de repetición`.


<br/>

#### # Uso avanzado
##### 0. Conceptos de repetición
**Hora límite**

La `Hora límite` es cuando **el ciclo actual** se considera fallido y se aplican penalizaciones. También es cuando se reinicia el ciclo, no cuando termina toda la Tarea repetitiva.

> En *LifeUp*, debes `eliminar` manualmente para terminar la Tarea; si quieres que termine tras completar 30 repeticiones, puedes activar el ajuste `número objetivo (de repeticiones)`.

Para Tareas diarias, el valor predeterminado ``23:59:59`` suele ser suficiente.

Puedes ajustarlo si normalmente terminas Tareas después de medianoche (por ejemplo, hasta las `2:00 AM`).

<br/>

> [!WARNING]
> **«Sin fecha límite»** significa que la Tarea no caducará ni se repetirá automáticamente. En la mayoría de los escenarios, solo necesitas mantener la fecha límite predeterminada y no hace falta configurarla como «Sin fecha límite».

<br/>

**Hora de inicio**

Úsala para controlar cuándo aparece una Tarea.

Para **Tareas repetitivas**, también puede limitar la ventana válida de finalización (por ejemplo, una Tarea de despertarse antes de las 6:00 AM).

Para un uso habitual, el valor predeterminado suele ser adecuado.

<br/>

**Repetición**

Las Tareas ejecutan la lógica de *repetición* tras completarse, abandonarse o vencer.

LifeUp **calculará automáticamente** la `hora de inicio`, la `hora límite` y la `hora de recordatorio` del siguiente ciclo según tu configuración de frecuencia de repetición.


<br/>

**Veces objetivo**

Indica cuántos ciclos de repetición debe ejecutar la Tarea.

Para Tareas diarias, esto es esencialmente `cuántos` días quieres completarla.

<br/>

**Tareas de conteo**

Las Tareas de conteo te ayudan a hacer seguimiento de acciones repetidas dentro de un ciclo.

Por ejemplo, el 7 en `beber 7 vasos de agua` es un valor de conteo.

<br/>

##### 1. Plantillas de Tareas
Puedes crear tus propias plantillas de Tareas usando las funciones `Congelar` + `Copiar`.

Por ejemplo, puedes crear una Tarea relacionada con el ejercicio y `congelarla`.

Cuando necesites crear Tareas similares, puedes `copiar` directamente esta plantilla y editarla para usarla.

<br/>

##### 2. Archivar Tareas

Puedes usar las funciones `Congelar` + `Listar archivo` para lograr una funcionalidad similar al archivado de Tareas.

<br/>

#### # Detalles

> WIP...

<br/>

#### # Vinculación

Las Tareas pueden vincularse con casi cualquier otra función.
- **Atributos:**
   Obtienes Puntos de Experiencia por completar Tareas, pero recibes una penalización si las fallas.
- **Tienda:**
   Obtén monedas u Objetos de la Tienda al completarlas.
- **Logros:**
  Configura la condición de desbloqueo de Logros personalizados para completar la Tarea un determinado número de veces.
- **Pomodoro:**
   Asocia una Tarea con un Pomodoro y registra el tiempo de Enfoque en la Tarea y el número de Pomodoros obtenidos.
- **Reflexiones:**
   Completa Tareas para registrar Reflexiones: con Tareas diarias para llevar un diario, con Tareas ilimitadas para anotar en cualquier momento.

---

<h3 align="center" padding="100" id="skills">II. Atributos</h3>

<p align="center">Cuantifica tus capacidades y tu crecimiento de forma abstracta</p>

<p align="center">
 <img src="guide/_media/hello_world/tasks.png" style="height:600px" />
</p>


#### # Inicio rápido

Los Atributos son un sistema abstracto de incentivos autodirigido.

El objetivo de los Atributos es cuantificar el crecimiento, permitiéndote visualizar tu desarrollo con una perspectiva única mientras completas tus Tareas, y así motivarte a esforzarte más.

En otro sentido, los Atributos dividen múltiples dimensiones. Presenciar la diferencia en el crecimiento de los Atributos también puede hacerte reflexionar sobre si probar más áreas.

Su concepto es similar a la versión gamificada de la `regla de las 10 000 horas`, contabilizada por valor de experiencia.

Puedes crear los Atributos y Habilidades en los que quieras trabajar, presenciar y alegrarte de tu crecimiento, e implementar Recompensas personales únicas con la función de `Logros`.

1. **Atributos integrados:**

  *LifeUp* tiene seis Atributos principales integrados.

  ¡Puedes usarlos e intentar subirlos de Nivel!

  También puedes consultar la diferencia de Nivel entre Atributos y mejorar tus aspectos más débiles.



2. **Atributos o Habilidades personalizados**.

  En *LifeUp*, puedes personalizar por completo tus propios Atributos o Habilidades.

  Por ejemplo: `Pesca`, `Programación`, `Lectura`.

<br/>

#### # Detalles

- WIP

<br/>

#### # Vinculación
> La vinculación ya descrita en otros módulos no se repite aquí
- **Logros:**
   Un Atributo alcanza cierto Nivel para desbloquear el Logro.
- **Pomodoro:**
   Come tomates para ganar Puntos de Experiencia.
- **Tienda**.
   Crea Objetos que afecten la cantidad de Puntos de Experiencia.

---

<h3 align="center" padding="100" id="shop">III. Tienda</h3>

<p align="center">Sistemas de Recompensas y penalizaciones personales altamente personalizables.</p>

<p align="center">
 <img src="guide/_media/hello_world/shop.png" style="height:600px" />
</p>

Establece un precio para tus misiones y Recompensas.

Completa tus Tareas, gana monedas y compra Recompensas para motivarte a seguir esforzándote.

#### # Inicio rápido
##### Tipo de Objeto
En términos generales, se pueden dividir en dos categorías de bienes.

**1. Recompensas realistas.**

La App puede ayudar con registros, compras y límites. Sin embargo, la implementación exacta de las Recompensas requiere acciones en la vida real.

En términos generales, se pueden dividir en:

- Recompensas en especie (como un ordenador, un ratón)
- Tiempo de descanso y ocio / bonificación de tiempo
- ...

Por ejemplo: «tomar un descanso de cinco minutos», «ver una película», «comprar una botella de refresco».

**2. Recompensas dentro de la App.**

Puedes lograr Recompensas de datos dentro de la App combinándolas con «Efectos de uso».

Como recompensar una cantidad determinada de monedas, valor de experiencia, abrir Cajas de botín para obtener Recompensas aleatorias, etc.

Estas Recompensas también pueden combinarse con Recompensas realistas para lograr varios efectos.

> [!TIP]
> Usar aleatoriedad para aumentar la incertidumbre de la Recompensa puede incrementar significativamente el efecto motivador.

<br/>

##### ¿No sabes qué Objetos crear?

Puedes ir al módulo `Mundo`-`Mercado` para consultar e importar Objetos creados por otros.

Si ves un icono que te gusta, puedes pulsar el botón `Menú (tres puntos)`-`Iconos` para añadir el icono a tu área local.

<br/>

##### Inventario

El Inventario puede usarse como zona de almacenamiento temporal para Recompensas no utilizadas de momento.

Por ejemplo, supongamos que compras una Recompensa «ver una película».

Si aún no quieres usar esta Recompensa, deja desmarcada la opción `Usar` en el momento de la compra; el Objeto se guardará automáticamente en el Inventario.

Además,

- Las Recompensas de Objetos de Tareas y Logros también se colocarán automáticamente aquí.
- Los Objetos con operaciones especiales (como Síntesis y apertura de cajas) también se forzarán primero al Inventario.

<br/>

#### # Uso avanzado

##### 0. Configurar las Cajas de botín.

<p align="center">
 <img src="guide/_media/hello_world/loot_box.png" style="height:600px" />
</p>


¡La aleatoriedad es una forma excelente de motivarte!

En *LifeUp*, puedes crear tu propia Caja de botín.

> Las Cajas de botín en *LifeUp* se basan en cálculo de probabilidad real; no habrá efecto de pseudoaleatoriedad flotante como en los juegos. **Se recomienda configurar la probabilidad más alta que en un juego real.**

<br/>

##### 1. Síntesis (elaboración).

Pulsa el icono del `matraz` en la página de la Tienda para entrar al sistema de Síntesis.

El sistema de Síntesis puede usarse para implementar intercambios arbitrarios de Objetos.

Por ejemplo, puede usarse para lograr Recompensas de `multi-moneda`, `multi-Objeto`, o con `Cajas de botín` para lograr colecciones complejas de `pesca`, `mejora de cartas`.

Por ejemplo:
- `línea` + `cebo` + `lugar de pesca` → `🐟 caja sorpresa`
- `Caja bloqueada` (obtenerla firmando cada día) + `Llave` (probabilidad de obtenerla al completar la Tarea) → `Cajas de botín`
- ...

La utilidad del sistema de Síntesis depende de tu imaginación (puedes encontrar más usos en `3. Crea tu propia moneda` y `4. Colecciona cinco bendiciones (El niño calabaza salva al abuelo)` más abajo).

<br/>

##### 2. Recompensas de múltiples Objetos.

**Tras actualizar a la versión 1.94.0, podrás configurar Recompensas de múltiples Objetos para Tareas o Logros. A continuación hay algunas alternativas de versiones anteriores que siguen siendo aplicables.**

Por defecto, solo se puede configurar un tipo de Recompensa de Objeto para una Tarea.

Pero puedes empaquetar varios Objetos en un cofre del tesoro.

Esto también facilita compartir Recompensas de Objetos entre varias Tareas.

Por ejemplo:
- Usar el mecanismo de Recompensa fija al abrir caja: la Tarea recompensa una `caja del tesoro`, al abrir la `caja del tesoro` Recompensas fijas `Objeto A`, `Objeto B`.
- Usar el sistema de Síntesis: la Tarea recompensa un `Cofre del tesoro`, luego usar el `Cofre del tesoro` en el sistema de Síntesis para obtener `Objeto A`, `Objeto B`.

<br/>

##### 3. Moneda personalizada.

Las monedas predeterminadas pueden no cubrir todo tipo de necesidades.

Puedes usar el sistema de `Síntesis` para construir tu moneda y Tienda.

<br/>

Implementación:
- Misión deportiva → Recompensa `Monedas deportivas` → Usar `Monedas deportivas` para sintetizar Recompensas `deportivas`
- `Tomates` → `Monedas de tomate` → Síntesis de Objetos exclusivos

<br/>

##### 4. Colecciones de cartas

¿Coleccionar un conjunto de cartas para canjearlas por Recompensas muy raras?

<br/>

En resumen:
`Completa la misión para obtener una caja sorpresa de fragmentos` → `Obtén un tipo de fragmento aleatorio`

<br/>

#### # Detalles

- WIP

<br/>

#### # Vinculación
La vinculación ya se ha descrito en otros módulos y no se repite aquí
- **Logros:**
   Comprar y usar un Objeto un determinado número de veces para desbloquear Logros.
   Sintetizar Objetos únicos para obtener Logros.
   Recompensar ciertos Objetos no comprables mediante Logros.
- **Pomodoro:**
   Canjear un Objeto concreto con tomates.
- **Mundo:**
   Puedes compartir los Objetos que creas o importar directamente Objetos creados por otros.

---

<h3 align="center" padding="100" id="achievements">IV. Logros</h3>

<p align="center">Metas medianas y grandes, hitos, seguimiento automatizado del progreso</p>


<p align="center">
 <img src="guide/_media/hello_world/achievements.png" style="height:600px" />
</p>


#### # Inicio rápido
**1. Logros normales**.

Los Logros normales son aquellos que **no configuran condiciones de desbloqueo**; requieren pulsar manualmente para completarlos, algo similar a las Tareas.

Los Logros normales pueden configurar iconos. Y tras desbloquearlos, su visualización también se conservará.

Por eso se recomiendan para escenarios como `Hitos`, `Metas a largo plazo`, `Metas de vida`, etc.

Por ejemplo:
- Probarlo una vez 🎣
- Llegar a XX lugares en un viaje
- ¡20 años!
- 🎓 Graduado
- Primera publicación de un artículo
- ...

**2. Logros condicionales**.

Para crear este tipo de Logro, solo tienes que configurar sus condiciones de desbloqueo.

*LifeUp* hará seguimiento y calculará automáticamente el progreso de las condiciones. El Logro se desbloqueará cuando completes todas las condiciones.

<br/>

**Actualmente la App admite decenas de condiciones de desbloqueo de Logros en varios aspectos, como:**
- Número total de Tareas completadas
- Número de Tareas completadas consecutivamente
- Número de veces de uso del producto
- Número de Objetos sintetizados
- Enfoque en una Tarea concreta durante cierto tiempo
- Y más...



<br/>

#### # Detalles
- WIP

<br/>

#### # Vinculación
> La vinculación ya descrita en otros módulos no se repite aquí
- Seguimiento de progreso compatible con casi todos los módulos (Tareas, Tienda, Pomodoro)
- Puedes escribir una Reflexión al completar el Logro.

---

<h3 align="center" padding="100" id="pomodoro">V. Pomodoro</h3>

<p align="center">Pomodoros gamificados como nunca los habías vivido, con la posibilidad de comer y vender tus Recompensas de tomate y un sistema de temporización bien establecido</p>

<p align="center">
 <img src="guide/_media/hello_world/pomodoro.png" style="height:600px" />
</p>

#### # Inicio rápido
El Pomodoro se basa en el método del temporizador de tomate, que en resumen significa alternar trabajo y descanso (25 minutos de trabajo y 5 de descanso).

El Pomodoro de *LifeUp* es un módulo secundario, con funciones sencillas y otros módulos como foco principal. Aun así, hay margen de mejora y seguiremos mejorando las estadísticas y otras funciones.

<br/>

##### Cuenta atrás Pomodoro
> Para usar correctamente la cuenta atrás, asegúrate de haber configurado según la `configuración de compatibilidad`.

Por defecto, `LifeUp` está en estado de temporizador Pomodoro.
Antes de usarlo, puedes ir a los ajustes para modificar `tiempo de trabajo`, `tiempo de descanso`, `intervalo`, etc.

Obtienes un tomate por cada sección de trabajo completada.

Cada temporización debe activarse manualmente con fines de recordatorio.

<br/>

##### Temporizador ascendente
Pulsa el icono del `Reloj` en la esquina superior derecha de la página de tomate para cambiar al modo de temporización ascendente.

> Pulsa de nuevo para volver al modo de cuenta atrás.

**Función de los botones del temporizador ascendente de izquierda a derecha:**
- Abandonar
- Pausar
- Resumir la Recompensa

<br />

##### Tareas asociadas

Al hacer temporización de tomate, puedes asociar la temporización con una Tarea.

Los registros de temporización generados por la asociación también quedan vinculados a la Tarea.

Más tarde puedes consultar la página de detalles de la Tarea para ver la información de `Duración de Enfoque` y `Número de tomates obtenidos`.

Si es una Tarea repetitiva, admite ver por separado el registro de Enfoque actual y el acumulado.

Con esta función, puedes lograr **estadísticas sencillas de 10 000 horas** u otras cosas.

<br/>

##### Añadir temporización manualmente

Puedes añadir cualquier periodo de tiempo al registro del temporizador de tomate.

Y puedes configurar las Tareas asociadas al temporizador.

<br/>

##### Usos del tomate
<p align="center">
 <img src="guide/_media/hello_world/tomato.png" style="height:600px" />
</p>

- Comer: ganar valor de experiencia (resistencia predeterminada)
- Vender: obtener monedas
- Intercambiar: obtener Objetos concretos

#### # Detalles

##### > Aún no disponible

<br/>

#### # Vinculación
La vinculación ya se ha descrito en otros módulos y no se repite aquí

- **Tareas:**
   Al iniciar el temporizador, puedes especificar la Tarea en la que te estás enfocando y contabilizar el tiempo de Enfoque para la Tarea.
   
- **Tienda:**
   Come o intercambia tomates para obtener monedas y Recompensas de Objetos de la Tienda
   
- **Logros:**
  Los Logros admiten seguimiento de información como el número de horas de Enfoque en un tipo concreto de Tarea, el número acumulado de tomates obtenidos, etc.
  
- **API:**
  Usa herramientas de automatización + API para interceptar notificaciones de otro software de temporización y añadir registros de temporización

---

<h3 align="center" padding="100" id="feelings">VI. Reflexiones</h3>

<p align="center">Registros sencillos de texto e imágenes. Reflexiona sobre el pasado y mira al futuro.</p>

<p align="center">
 <img src="guide/_media/hello_world/feelings.png" style="height:600px" />
</p>

#### # Inicio rápido

La función Reflexiones es un submódulo de *LifeUp* que ofrece solo registro breve de texto e imágenes.

> [!WARNING]
> Cada Reflexión está limitada actualmente a 750 caracteres y 9 imágenes.

Estas son formas de crear Reflexiones.

- Cuando activas el interruptor de Reflexiones para la Tarea, aparecerá automáticamente el cuadro de entrada de Reflexiones al completar la Tarea
- Cuando activas el interruptor de Reflexiones para el Logro, aparecerá automáticamente el cuadro de entrada de Reflexiones al recibir la Recompensa del Logro
- Al completar **Tareas de equipo**, aparecerá por defecto un cuadro de entrada de Reflexiones, y la Reflexión de las Tareas de equipo se publicará automáticamente en el módulo Mundo
- Puedes añadir proactivamente notas de Reflexiones a cualquier registro de Tarea en cualquier momento en las páginas `Historial`, `Calendario-Finalizadas` (también se admiten Tareas vencidas y abandonadas)
- Puedes añadir proactivamente tus Reflexiones en cualquier momento en la página de Logros; solo tienes que **mantener pulsado** cualquier Logro

<br/>

##### Diario sencillo

Puedes crear una Tarea diaria y activar la función Reflexiones para ella, como activador de un diario sencillo.

<br/>

##### Haz seguimiento de tus Reflexiones

Puedes crear una Tarea ilimitada y activar la función Reflexiones para registrar tus sentimientos en cualquier momento.

Y como Reflexiones admite filtrar por Tareas repetitivas, también puedes crear varias Tareas ilimitadas de distintos tipos para registrar categorías diferentes de Reflexiones.

<br />

#### # Detalles

-

#### # Vinculación
- Registrar Reflexiones sobre Tareas
- Registrar Reflexiones sobre Logros



<br/>

<h3 align="center" padding="100" id="world">VII. Mundo</h3>

<p align="center">Hay suficientes apps sociales en el mundo. Aquí no hay elemento de comunicación. Solo tu pequeño mundo para compartir momentos y diseños.</p>

<p align="center">
 <img src="guide/_media/hello_world/world.png" style="height:600px" />
</p>

#### # Inicio rápido

##### Equipo

Trabaja con miembros del equipo para completar ciertos hábitos.

Por ejemplo, el Desafío «acostarse y levantarse temprano».

Aquí no hay elemento social, así que no tienes que preocuparte por interrupciones.

<br/>

##### Momentos

Aquí puedes explorar a otros usuarios **que han completado Tareas de equipo** y publicaron sus Reflexiones al completarlas.

También puedes seguir a usuarios positivos, observar su progreso y usarlo para motivarte pasivamente.

<br/>

##### Mercado

¿No sabes qué Recompensas de Objetos crear? ¿Necesitas aprender a crear Recompensas avanzadas con funciones de API? ¿O te ayudaría encontrar iconos bonitos?

Siempre puedes importar Objetos creados por otros usuarios en el Mercado y modificarlos localmente para personalizarlos como tus propias Recompensas.

<br />

##### Tareas aleatorias

¿No sabes qué Tareas quieres hacer cuando te sientes perdido?

Ven a este módulo para recibir invitaciones a Tareas aleatorias.

Completa con tus manos una pequeña Tarea significativa~

Por ejemplo, hacer la maleta, hablar con tus seres queridos y tomar fotos para documentar la buena vida.

<br/>

#### # Detalles

-

#### # Vinculación

- **Tareas:**
  - Unirse o crear un equipo y obtener Tareas de equipo
  - Recibir Tareas aleatorias
- **Reflexiones:**
  Completar Tareas de equipo y publicar tus Reflexiones públicamente en el módulo Momentos
- **Tienda:**
  - Importar productos creados por otros usuarios
  - Añadir iconos de productos creados por otros usuarios



<br/>

---

<h3 align="center" padding="100" id="api">VIII. Interfaz abierta (API)</h3>

<p align="center">Abierta en ambas direcciones (apps externas ↔ LifeUp), automatiza tu LifeUp y crea posibilidades de vinculación infinitas~</p>




#### # Inicio rápido

**Interfaz abierta** es una función avanzada en `LifeUp`.

Con ella, puedes lograr

- Vincular aplicaciones externas usando Objetos (abrir aplicaciones externas, activar acciones de aplicaciones externas)
- Usar Objetos que afecten los valores en `LifeUp`, como la tasa del cajero automático, la probabilidad de que un Objeto esté en una caja concreta.
- Vincular aplicaciones externas para ofrecer Recompensas para tu `LifeUp`. Por ejemplo, en el ejemplo hay un juego web Wordle de adivinar palabras, y al acertar obtienes 10 monedas en *LifeUp*.
- Vincular herramientas de automatización externas para determinar ubicación, despertar, pasar tarjetas NFC, automatizar Tareas, penalizaciones, registrar tiempo de Enfoque para otras aplicaciones, y más...

<br/>

##### Importar Objetos

Puede sonar complicado, pero si no necesitas personalización.

Puedes importar Objetos de API directamente en la pestaña **Mundo**-**Mercado**-**(Link, API, Automation)** y usarlos directamente.

<br/>


#### # Detalles

[Haz clic aquí para una descripción detallada de la interfaz abierta](/guide/api)

#### # Uso de vinculación

- La funcionalidad de API puede probarse junto con casi cualquier módulo; consulta la documentación de la interfaz para más detalles.
- Aplicaciones externas, páginas web: además, la función API puede vincularse con aplicaciones externas y páginas web, así que te invitamos a participar en el desarrollo secundario.
- Herramientas de automatización: puedes trabajar con las herramientas de automatización Tasker y Macrodroid para lograr funciones de automatización.

<br/>

## Contáctanos

Si tienes más comentarios o preguntas, o necesitas ayuda con el reembolso, **no dudes en escribirnos a lifeup@ulives.io.**

En la mayoría de los casos, te responderemos en un plazo de 48 horas.



Sin embargo, no se puede descartar que circunstancias especiales (como el filtrado de spam del correo o un descuido nuestro) nos hagan perder algunos correos. Si no recibes respuesta, considera reenviar tu correo.

Para una forma más fiable de contactarnos y enviar comentarios, recomendamos usar la [página de issues de GitHub](https://github.com/Ayagikei/LifeUp/issues).
