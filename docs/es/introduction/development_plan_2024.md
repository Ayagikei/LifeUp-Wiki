# Plan de desarrollo 2024-2025

> [!IMPORTANT]
> Este es nuestro plan de desarrollo actual. Haremos todo lo posible por guiar las mejoras y actualizaciones del producto según este plan. Sin embargo, debido al entorno en constante cambio, el contenido del plan puede modificarse o ampliarse/reducirse. La publicación concreta del producto prevalecerá.

### I. Plan de desarrollo

> Actualizado: 2025/09/14

| Módulo | Subfunción | Motivo del requisito | Prioridad | Resultado |
| ---- | ------ | -------- | ------ | ---- |
| Capacidades básicas (1) | Selección múltiple de Objetos y uso automático al obtenerlos | ~ | P0 | ✅ Selección múltiple publicada en v1.94<br/>✅ Uso automático de Objetos publicado en v1.96 |
| Capacidades básicas (2) | Ventana emergente de Recompensas generalizada (admite cualquier número de Atributos y Objetos) | ~ | P0 | ✅ Publicado en v1.96; los ajustes se relajarán en versiones futuras |
| Capacidades básicas (3) | Gestión de recursos de sonido y efectos de sonido de Objetos | ~ | P0 | ✅ Publicado |
| Capacidades básicas (4) | Optimización de notificaciones | ~ | P0 | ✅ Publicado |
| Adaptación a pantallas grandes (tablet/plegable) | Adaptación para tablets y plegables basada en Activity embedding | ~ | P1 | ✅ Previsto en v1.95 |
| Widgets | Expansión de widgets (widget de Inventario) | ~ | | ✅ Publicado en v1.94 |
| Integración con calendario | - Sincronización bidireccional con Google Calendar<br/>- Sincronización bidireccional con calendario del sistema | - Muchos comentarios del extranjero.<br/>- LifeUp es una herramienta de tareas con funciones superpuestas pero inconsistentes con apps de agenda (calendario). | P1 | 🚧 |
| API | - Ampliar capacidades de API para cubrir todas las funciones básicas<br/>- Completar funciones del cliente de escritorio, admitir copia de seguridad/restauración, etc. | - Aún faltan muchas APIs como edición.<br/>- LifeUp no puede ser todo en uno, pero la API permite personalización y ampliación. | P1 | 🚧 Previsto en v1.98.x |
| Logros | - Logros de tipo repetición | ~ | P2 | ✅ Publicado |
| Sistema de datos | - Copia de seguridad separada de datos e imágenes<br/>- Exportación/importación parcial de datos<br/>- Cambio entre múltiples archivos integrados | - WebDAV falla fácilmente al subir archivos grandes.<br/>- Exportación/importación parcial puede usarse para compartir sistemas de Recompensas.<br/>- Múltiples archivos integrados para pruebas fáciles sin borrar datos. | P1 | 🚧 |
| Multiplataforma (dirección Flutter) | - Seguir aprendiendo y usando Flutter para versión multiplataforma | - Prototipo de versión iOS | P2 | 🚧 En pausa |
| Multiplataforma (dirección KMP) | - Explorar más posibilidades con KMP | - Explorar y aprender tecnología KMP para el futuro | P0 | ✅ Publicado ulives — nueva app iOS |

En resumen:

1. Implementaremos la dirección establecida previamente: estabilidad y optimización de funciones existentes, sin añadir módulos funcionales nuevos arbitrariamente.
2. Usaremos una o dos versiones mayores para resolver algunos defectos funcionales básicos y puntos de dolor.
3. Luego avanzaremos con integración de calendario y Logros de tipo repetición.
4. Seguiremos mejorando las APIs y otros aspectos.

Multiplataforma será uno de nuestros objetivos clave para 2024.

---

### II. Repaso de 2023

El camino de desarrollo semiprofesional y a ratos de ocio de LifeUp ha superado su quinto aniversario, entrando en su sexto año. Hemos publicado cientos de versiones, con casi 5000 commits de código solo en el repositorio Android.

<br/>

Aunque el plan de desarrollo propuesto en octubre de 2022 se centraba en profundizar el sistema funcional de LifeUp, debido a cambios del entorno, aún encontramos muchos obstáculos y problemas en el camino.

#### 1.1 Entorno

Ejemplos típicos:

- Afectados por denuncias falsas de «anti-fraude» en algunas provincias sin canal de apelación, tardamos varias rondas en resolver algunos problemas. Pero recientemente volvieron a aparecer denuncias falsas en Shandong, y aún no hemos encontrado vía de apelación o reproducción.
- Los estándares de revisión del mercado Android doméstico chino aumentan capa a capa, con estándares inconsistentes entre mercados y personal, y revisores poco profesionales.
  - Algunos mercados de apps rechazan revisiones en partes sin cambios.
  - Un mercado de apps V casi rechazó nuestra app LifeUp usando «cumplimiento de privacidad» como motivo. El mercado exigía que nuestra app solicitara [leer todos los permisos de archivos] o [leer todos los permisos de fotos] con explicaciones correspondientes, para que los usuarios pudieran seleccionar imágenes del álbum. Sin embargo, LifeUp usa un enfoque más protector de la privacidad, no necesita esos permisos y no lee directamente archivos del usuario. En su lugar, nuestra app salta a la app de álbum integrada del sistema y solo recibe la imagen seleccionada por el usuario, garantizando la máxima protección de privacidad.
    Pero los revisores no estaban familiarizados con esta buena práctica, y tardó varios días laborables de comunicación con atención al cliente en conseguir la aprobación.

<br/>

Para reducir el impacto ambiental sobre nosotros:

Reforzamos el mecanismo de actualización en la app y redujimos la frecuencia de envío a revisión de mercados.

La versión doméstica ahora admite actualizaciones en la app y puede cambiar entre canales estable o beta.

![Screenshot_2023-12-09-15-45-33-18_50eeeb96828cbaa](_media/development_plan_2024/Screenshot_2023-12-09-15-45-33-18_50eeeb96828cbaa.jpg)

También actualizamos el sitio web oficial (https://lifeupapp.fun/en/index.html) como canal alternativo de descarga.

![image-20231209154445462](_media/development_plan_2024/image-20231209154445462.png)

Para que sea más cómodo descargar e instalar la app desde el sitio web, evitando riesgos y retrasos de revisión de mercados.

Las peticiones de red en la app también añadieron canales de respaldo para aliviar y prevenir problemas de acceso causados por denuncias falsas en algunas provincias.

<br/>

A medida que los estándares de revisión se vuelven cada vez más estrictos, y al presenciar diversos obstáculos que encuentran otros desarrolladores independientes en el mercado Android doméstico,

se puede decir que, para desarrolladores independientes, la plataforma Android doméstica ya no es el objetivo ideal de lanzamiento prioritario.

Después de todo, Android doméstico tiene los requisitos de cualificación más estrictos y los estándares de revisión más complejos y **cambiantes**.

> Pero irónicamente, al mismo tiempo, algunas apps copia de baja calidad pueden subir fácilmente y marcar «reinspección manual aprobada».

Quizá por eso muchas obras de desarrolladores independientes vistas en Xiaohongshu solo tienen versión iOS.

Google Play y App Store siguen siendo la primera opción.

> [!TIP]
> Todos podemos prestar más atención y apoyar a esos desarrolladores independientes y equipos pequeños que siguen en la plataforma Android doméstica~

<br/>

Así, en 2024:

- Moveremos las partes inacabadas del plan anterior a este periodo, como integración con calendario, Logros de tipo repetición, capacidades básicas, sistema de datos, etc.
- El desarrollo multiplataforma será un objetivo importante para nosotros, posiblemente incluyendo dos direcciones:
  - Usar Flutter para replicar LifeUp (por limitación de personal, lo avanzará nuestro compañero de backend — Xiao Xiao)
  - Explorar más posibilidades usando KMP (Kotlin Multiplatform)

#### 1.2 Crecimiento de usuarios domésticos

Además, LifeUp también tuvo un crecimiento significativo de usuarios en el mercado de apps chino en 2023. ¡Gracias a todos por el apoyo!

- Para reducir el tiempo dedicado a emitir códigos de canje manualmente y centrarnos más en el desarrollo: en 2023 conectamos además métodos de pago automatizados (WeChat, Alipay) y admitimos inicio de sesión con WeChat.
  - Esto nos liberó mucho tiempo.

- En 2023, hubo una difusión de usuarios en Qzone que volvió a tumbar nuestro servidor durante varios días.
- También probamos operar cuenta pública de WeChat, Xiaohongshu, Bilibili, etc., para promocionar e introducir actualizaciones de LifeUp y usos creativos.

- Tras conversar con otros desarrolladores independientes, encontramos que la mayoría ha experimentado dificultades similares, acabando por cerrar ciertos canales de mensajería instantánea y redes sociales. Lo entendemos profundamente.
  - En grandes empresas, suele haber equipos dedicados de atención al cliente o bots para gestionar numerosas consultas, convirtiéndolas eficazmente en necesidades concretas o feedback de problemas para desarrolladores.
  - **Pero los desarrolladores independientes generalmente deben asumir atención al cliente y operaciones; lidiar con usuarios irrazonables consume el 100 % del tiempo de desarrollo de ese desarrollador independiente, afectando finalmente al desarrollador, al producto y a los usuarios principales del producto.**
  - Por tanto, tendemos cada vez más a recomendar que los usuarios envíen feedback por correo, etc.

<br/>

Así, en 2024:

- Seguiremos reduciendo la inversión humana en consultas repetitivas, y en su lugar mejoraremos documentación y FAQ. Aunque existan consultas, se gestionarán de forma unificada por correo, canal QQ, etc.
- Probaremos una pequeña cantidad de operación en redes sociales.

#### 1.3 Crecimiento de usuarios internacionales

A principios de 2022 nos unimos a Google Play Pass y vimos una ola de crecimiento de usuarios.

Pero ese crecimiento no duró mucho; a mediados de 2022, el crecimiento de usuarios disminuyó gradualmente de forma significativa, sin señales de mejora.

Como LifeUp es una app de compra única, el crecimiento de usuarios es muy importante para nosotros, y es la base para seguir operando y tener oportunidad de desarrollar a tiempo completo en el futuro.

Probamos muchos métodos para mejorar el crecimiento:

![image-20231209154347665](_media/development_plan_2024/image-20231209154347665.png)

- Contratamos a un diseñador profesional para rediseñar imágenes promocionales de la tienda
- Mejoramos soporte multilingüe de la app e imágenes promocionales
- Mejoramos la descripción de la app
- Mejoramos la documentación de primeros pasos
- Aumentamos la frecuencia de actualizaciones
- ...

Aunque implementamos muchos métodos y mejoramos algunos indicadores, no pudimos volver a un periodo de crecimiento estable.

Solo pudimos dejarlo estar.

<br/>

La buena noticia es que a finales de 2023 parece haber cierta mejora.

<br/>

Así, en 2024:

- Mejorar la construcción de internacionalización (documentación, soporte de idiomas en la app, etc.).

#### 1.4 Gestión de calidad

Como LifeUp es una app de herramientas offline desarrollada y probada únicamente por mí, evitar problemas graves de cierre inesperado es especialmente importante.

El proceso de iteración de versiones en 2023 tardó más que antes, y reservamos tiempo suficiente para pruebas beta para asegurar una preparación exhaustiva.

![image-20231209154314651](_media/development_plan_2024/image-20231209154314651.png)

Estas medidas parecen prevenir eficazmente que ocurran cierres inesperados graves a gran escala.

Sin embargo, cada actualización de versión sigue trayendo inevitablemente algunos problemas, incluidos algunos en rutas críticas.

Por tanto, seguiremos mejorando la gestión de calidad de LifeUp, con la estabilidad como indicador más importante (especialmente bajo el entorno cada vez más severo y los retos de revisión).

<br/>

Así, en 2024:

- Reforzar la gestión de calidad.

#### 1.5 Profundización de funciones

Como se mencionó en el artículo del tercer aniversario, LifeUp es una app que fue explorando y creciendo gradualmente.

Así que cosas como Tienda, Logros personalizados, API y otras funciones no estaban en el plan inicial, sino que se fueron desarrollando y añadiendo con actualizaciones y feedback.

Pero esto también introdujo algunos problemas:

- Algunos módulos tienen detalles de planificación toscos.
  - Por ejemplo, las Recompensas de Objetos inicialmente solo consideraban recompensas individuales.
  - Atributos y otros sistemas tampoco consideraron inicialmente la personalización, y solo con refactorización gradual se pudo admitir adiciones/eliminaciones y Niveles personalizados, etc.
  - Hay muchos problemas así, como ventanas emergentes de recompensa/castigo de Atributos e historial que como máximo admiten 3.
- Estos módulos añadidos carecen de análisis y planificación global para la app.

Seguiremos en la dirección indicada en el artículo del tercer aniversario, profundizando los módulos funcionales existentes de la app y resolviendo algunos puntos de dolor, en lugar de perseguir módulos funcionales nuevos.

Por ejemplo, admitiremos Recompensas de Objetos con selección múltiple directa, mejoraremos el mecanismo de copia de seguridad, optimización de notificaciones, completado desde widgets, etc.

#### 1.6 API y extensibilidad

Como se mencionó arriba, ya no planeamos introducir módulos funcionales nuevos.

Pero sin duda habrá demandas de extender la app.

Por eso introdujimos la función API en 2023.

Ofrecemos el núcleo de LifeUp como capacidad base.

Incluso si los usuarios no entienden programación, pueden usar herramientas de automatización como Tasker/MacroDroid para extender funciones, logrando capacidades de automatización.

Ejemplos típicos:

- NFC, código QR para completar Tareas
- Auto check-in al despertar
- Widgets personalizados
- Y así sucesivamente...

Si los usuarios entienden programación, pueden extender aún más gameplay o incluso Apps a partir de esto.

![img](_media/development_plan_2024/desktop.png)

También desarrollamos una versión de escritorio sencilla basada en API (y la open-sourceamos).

Incluso tras varias versiones de expansión de API, aún nos faltan muchas capacidades.

Por ejemplo, no admitir operaciones relacionadas con «pensamientos», no admitir actualización de datos mediante Content Provider, etc.

Seguiremos ampliando la API en 2024 para cubrir cada aspecto de la app en la medida de lo posible.

> Aunque actualmente vemos muchos usuarios usando la API para uso personal, aún hay pocos productos compartidos y ejecutables. Necesitamos seguir ofreciendo capacidades API más fuertes para construir un ecosistema API.

#### 1.7 Sobre el futuro

Con los problemas anteriores y los cambios del entorno, también ajustamos gradualmente el precio de membresía de por vida de LifeUp (aun así, el precio de membresía de LifeUp está muy por debajo de la mayoría de otras apps), y las actualizaciones tenderán gradualmente a ofrecer funciones como funciones de membresía.

Gradualmente nos damos cuenta de que las apps en última instancia sirven a usuarios principales.

El feedback y apoyo de usuarios principales puede reflejarse finalmente en mejoras de la app, logrando co-creación y ciclo positivo entre desarrollador y usuarios.

Si intentamos complacer a todos, la app se convertirá en un caos de código, se desviará de las demandas de usuarios principales y reducirá ingresos y motivación del desarrollador.

<br/>

Mencionamos KMP (Kotlin Multiplatform) arriba, que es una tecnología multiplataforma relativamente emergente. También puede usar capacidades nativas de forma mixta.

Durante el desarrollo de LifeUp, gradualmente tuvimos algunas ideas nuevas. Pero no todas las ideas pueden o son adecuadas para aterrizar en LifeUp.

Por ejemplo, reemplazar toda la UI, cambios mayores en la lógica de la Tienda, etc., que inevitablemente impactarían seriamente la experiencia de usuarios existentes. También hemos visto muchos casos de cambios mayores en apps que llevan al fracaso.

<br/>

Además, cuando LifeUp se desarrolló inicialmente, el framework oficial de base de datos «Room» aún no estaba disponible, así que elegimos un framework de base de datos doméstico de nicho.

Ahora algunos problemas de rendimiento se han vuelto prominentes, y es difícil reemplazarlo.

Además, LifeUp ahora admite Material 3 y Material Design heredado, más modo oscuro, multilingüe, fragmentación de sistemas de teléfonos domésticos (la documentación de configuración de compatibilidad solo se alarga, sistemas nativos y versiones internacionales generalmente solo necesitan configuración de una página) y otros problemas. Cada página debe considerar muchas cosas complejas.

<br/>

Así que planeamos explorar KMP para ver si podemos usar alguna tecnología con KMP.

También para tener la oportunidad de implementar más ideas y proyectos nuevos en el futuro — más habilidades no sobran.
