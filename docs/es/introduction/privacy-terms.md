# Privacidad y términos de la App *LifeUp*

?> La siguiente descripción del servidor de la aplicación no aplica a la versión Lite. La versión Lite no tiene ninguna interacción con el servidor de la aplicación.

LifeUp es una App que te ayuda a mejorar tu vida. Respetamos tu privacidad y estamos comprometidos a proteger tu información personal. Esta política de privacidad explica cómo recopilamos, usamos, compartimos y eliminamos tu información personal cuando usas nuestra App.

### 1. Información personal

LifeUp es una App offline primero. No recopilamos activamente datos del usuario, por ejemplo tu nombre o dirección de correo electrónico. Opcionalmente puedes proporcionar algunos datos para autorizar el inicio de sesión y acceder al módulo Mundo, autorizar Google Drive o Dropbox para obtener capacidades de respaldo en la nube, etc.

Usamos Google Firebase y Sentry para recopilar informes de problemas y datos de rendimiento únicamente con fines analíticos.

Aquí hay un resumen de algunos datos:

- **Apodo, avatar, género**
  Opcional, usado para la función de inicio de sesión para acceder al módulo «Mundo», se transferirá al servidor para almacenamiento, pero puede cambiarse y eliminarse
- **Correo electrónico**
  Opcional, para sincronización con Google Drive, almacenamiento local, no se transmite al servidor
- **URL, cuenta y contraseña de WebDAV**
  Opcional, para sincronización WebDAV, almacenamiento local cifrado, no se transmite al servidor
- **Información de fallos, datos de rendimiento**
  Transmitidos a proveedores de servicios (Google Firebase, Sentry) para análisis de problemas y rendimiento, pero nunca vinculados a identificadores de usuario o dispositivo, ni contienen datos del usuario

Los métodos detallados de recopilación y procesamiento de datos para cada función se muestran a continuación.

#### 1.1 Información del usuario (autorización de terceros)

##### Inicio de sesión con Google/Facebook

**Solo después de que confirmes la autorización para iniciar sesión,** crearemos una cuenta con el apodo y la foto de perfil que autorizaste proporcionar (y no incluirá información como cuentas de correo electrónico).

##### Google Drive

Como los respaldos de Google Drive dependen de direcciones de correo electrónico, *LifeUp* solicitará permiso de dirección de correo electrónico cuando autorices Google Drive. **Pero esta dirección solo se usará localmente; *LifeUp* no la pasará al servidor de la aplicación ni la almacenará allí.**

Y *LifeUp* solo solicita almacenamiento específico de la App, lo que significa que no tenemos permiso para acceder a tus archivos privados.

##### Dropbox

Después de que autorices Dropbox, **la información relevante solo se mantendrá en tu dispositivo para respaldo y no se pasa al servidor de la aplicación.**

Y *LifeUp* solo solicita **almacenamiento específico de la App, lo que significa que no tenemos permiso para acceder a tus archivos privados.**

##### Servidor WebDAV

**Tu URL, cuenta y contraseña de WebDAV solo se almacenarán localmente y no se enviarán al servidor de la aplicación.** Y la contraseña se almacena cifrada en la base de datos.

##### Modo sin conexión

***LifeUp* también funciona completamente en modo sin conexión; simplemente no puede acceder al módulo «Mundo».**

En modo sin conexión, **no necesitas enviar ninguna información a nuestro servidor de aplicación.**
**Tu apodo, avatar y otra información se almacenarán y estarán disponibles localmente.**

Solo podemos solicitar al servidor de la aplicación los últimos anuncios y actualizaciones, que no involucran envío de información.

Tus interacciones con otros SDK como Dropbox, Google Drive y Facebook responderán normalmente bajo tu uso activo.

En uso sin conexión, aún podemos usar Google Firebase y Sentry para recopilar informes de fallos y problemas, pero como se explica a continuación, **esta información no contiene datos del usuario y no está vinculada a información del usuario. Solo para análisis de rendimiento y resolución de fallos, y solo almacenada temporalmente.**

También nos comunicaremos con Google Play Services para verificar tu licencia según la solicitud de Google Play.

Si deseas denegar toda la comunicación anterior, puedes desactivar directamente el permiso de solicitudes de red de LifeUp. Esto no afecta el uso de LifeUp en sí, pero puede afectar la funcionalidad de SDK como Google Drive.


#### 1.2 Permisos

#### Almacenamiento

La aplicación **no solicitará permiso de lectura del espacio de almacenamiento**, por lo que no leerá ningún archivo que no hayas autorizado.

La aplicación ha solicitado el permiso de cámara para facilitar al usuario el uso de archivos adjuntos de imagen, subir avatares y otras funciones, y **solo podrá llamar a la cámara después de que el usuario conceda los permisos.**

Por ejemplo, cuando seleccionas una imagen adjunta, llamamos directamente al framework de almacenamiento de archivos del sistema para acceder a ella.

Solo autorizará a *LifeUp* el archivo individual que selecciones; no tendremos permiso para leer otros archivos.

Al mismo tiempo, a menos que compartas activamente archivos fuera del módulo Mundo, solo se almacenarán localmente y no pasarán por el servidor.

#### Red

El permiso de acceso a la red es para acceder al módulo «MUNDO», inicio de sesión autorizado, y sincronización opcional con Dropbox/WebDAV y otras funciones.

#### Calendario

La aplicación también proporciona la función de escribir eventos en la aplicación de calendario del sistema para recordarte.

**Esta función requerirá permisos de lectura y escritura del calendario, y este permiso requerirá autorización del usuario solo cuando el usuario use la función correspondiente. Y *LifeUp* solo leerá eventos escritos por la propia aplicación.**

#### 1.3 Almacenamiento de datos

**La aplicación es offline primero y no tiene una función de sincronización en línea integrada, por lo que la mayoría de los datos se almacenan localmente en el teléfono móvil del usuario.**

Por ejemplo, todas las Tareas locales que creaste, todas las Reflexiones registradas, los Logros que diseñaste y los Objetos de la Tienda.

**Solo el contenido que compartes activamente de forma pública en el módulo «Mundo» se almacenará en el servidor.
Y todo este contenido admite operaciones de eliminación y destrucción.**

Por ejemplo, el equipo que creaste en el módulo «Mundo», las actividades que publicaste después de completar las Tareas del equipo, los Objetos de la Tienda que se comparten activamente, etc.

Al mismo tiempo, la gran mayoría de las solicitudes dentro de la aplicación se transmitirán en forma cifrada.

#### 1.4 Datos de rendimiento e informes de fallos

Usamos [Google Firebase](https://firebase.google.com/) y [Sentry](https://sentry.io/) para recopilar datos de rendimiento del usuario e informes de fallos para rastrear y corregir problemas.

Estos datos de rendimiento pueden incluir el modelo de tu dispositivo, estado de la red, ID de instancia, cuándo ocurrió el problema y las páginas relacionadas, **pero estos datos no se asociarán con tus datos de usuario** (no incluyen tu apodo, ID de usuario, dirección de correo electrónico ni ninguna información de contacto, y no recopilarán el contenido que ingreses y crees) y solo se usarán para analizar el problema y mejorar el rendimiento.

Y estos datos solo se almacenan temporalmente por Firebase y Sentry durante un período de tiempo, **y nosotros no los compartiremos/venderemos/alquilaremos con terceros.**

#### 1.5 Solicitud de eliminación de datos para *LifeUp Lite*

##### 1. Almacenamiento y eliminación de datos

LifeUp Lite, la versión gratuita de LifeUp, almacena principalmente los datos en el dispositivo del usuario. Valoramos tu privacidad y autonomía. En LifeUp Lite, como no se crean cuentas de usuario, todos los datos personales se almacenan localmente en tu dispositivo.

**Para eliminar estos datos, simplemente desinstala la aplicación LifeUp Lite de tu dispositivo. Al desinstalar, todos los datos almacenados localmente se eliminarán permanentemente.**

##### 2. Servicios de terceros

LifeUp Lite se integra con servicios de terceros como Firebase y Admob para funcionalidad y publicidad. Ten en cuenta que los datos recopilados por estos servicios no incluyen información personal vinculada a tu identidad y se usan de acuerdo con sus respectivas políticas de privacidad. Estos datos se eliminan automáticamente después de un cierto período según las políticas de estos servicios.

##### 3. Asistencia para la eliminación de datos

Si necesitas asistencia o tienes alguna pregunta sobre la eliminación de tus datos, no dudes en contactarnos en lifeup@ulives.io. Nuestro equipo está comprometido a ayudarte con cualquier consulta o inquietud relacionada con la privacidad de tus datos y te guiará en el proceso si es necesario.

##### 4. Cumplimiento y actualizaciones

Revisamos y actualizamos continuamente nuestras prácticas para garantizar el cumplimiento de las últimas regulaciones y estándares de la industria. Esta sección de la Política de privacidad se actualizará según sea necesario para reflejar cualquier cambio en nuestros procesos de gestión y eliminación de datos.


#### 1.6 Solicitud de eliminación de datos para *LifeUp Pro*

##### 1. Eliminación de datos en LifeUp Pro

Los usuarios de LifeUp Pro tienen la capacidad de eliminar sus datos de forma independiente dentro de la App.

Como LifeUp Pro es principalmente una aplicación offline, puedes gestionar tus datos directamente en tu dispositivo.

Para eliminar tus datos, sigue estos pasos:

1. Ve a la página «Ajustes → Respaldo/Restaurar/Borrar» en la App LifeUp Pro.
2. Elige los datos específicos que deseas eliminar, como Tareas, Recompensas de Objetos, Reflexiones locales y datos del modo sin conexión.
3. Confirma tu acción para eliminar permanentemente los datos seleccionados.

**Alternativamente, desinstalar la App LifeUp Pro de tu dispositivo también resultará en la eliminación de todos los datos almacenados localmente.**



##### 2. Eliminación de cuenta en LifeUp Pro

Eliminar tu cuenta en LifeUp Pro es un proceso separado de la eliminación de datos.

Cuando eliminas tu cuenta, se eliminará:

- Tus publicaciones públicas, como equipos y actualizaciones, publicadas en nuestros servidores.
- Tu apodo y otra información personal asociada a tu cuenta.
- Asociaciones OAuth vinculadas a tu cuenta.

**Para eliminar tu cuenta de LifeUp Pro, sigue los pasos descritos anteriormente:**

1. Ve a la página «Ajustes → Respaldo/Restaurar/Borrar».
2. Toca el botón «Eliminar cuenta» en la parte inferior de la página.
3. Confirma tu acción para eliminar permanentemente tu cuenta y toda la información asociada.

<br/>

**Si ya no usas la App LifeUp Pro pero deseas eliminar tu cuenta y datos personales, contáctanos en [lifeup@ulives.io](mailto:lifeup@ulives.io).**

Proporciónanos los detalles necesarios relacionados con tu cuenta, y nuestro equipo te ayudará con el proceso de eliminación.

Estamos comprometidos a garantizar tu privacidad y manejaremos tu solicitud con el máximo cuidado y confidencialidad.



##### 3. Servicios de terceros

Al igual que LifeUp Lite, LifeUp Pro se integra con servicios de terceros como Firebase para funcionalidad mejorada. Los datos recopilados por estos servicios no son personalmente identificables y se gestionan de acuerdo con sus políticas de privacidad. Estos datos se programan automáticamente para eliminación después de un cierto período según las políticas de los servicios de terceros.



##### 4. Actualizaciones y cumplimiento

Monitoreamos y actualizamos continuamente nuestras prácticas para alinearnos con las últimas leyes de privacidad y estándares de la industria. Esta sección de la Política de privacidad se modificará según sea necesario para reflejar con precisión nuestros procesos de gestión y eliminación de datos para usuarios de LifeUp Pro.


### 2. Acuerdo

Al usar esta aplicación, aceptas los términos de esta política de privacidad.

Aceptas que eres responsable de tus propios datos.

No somos responsables de ninguna manera por cualquier pérdida de datos causada por o en conexión con el uso de esta App, ya que es una aplicación offline primero.
