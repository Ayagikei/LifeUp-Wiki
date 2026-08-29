# Mantener LifeUp en ejecución en segundo plano

## Por qué es necesario

Algunos fabricantes de teléfonos restringen agresivamente las apps en segundo plano para mejorar los resultados de las pruebas de batería. Como resultado, las funciones que dependen de la ejecución en segundo plano pueden fallar.

### Matriz de impacto en compatibilidad

| Función | ¿Requiere mantenerse activa en segundo plano? | Permisos adicionales | Notas |
| --- | --- | --- | --- |
| Recordatorio de Tareas (notificación del sistema) | ✔️ | Permiso de notificaciones | Este es el método de recordatorio predeterminado. Si los recordatorios se retrasan o no aparecen, configura el mantenimiento en segundo plano y asegúrate de que las notificaciones estén activadas para LifeUp. |
| Recordatorio de Tareas (evento de calendario) | ✖️ | Permiso de lectura/escritura del calendario | Puedes cambiar a este modo en `Ajustes` → `Tareas` → `Cambiar sistema de recordatorios`. |
| Recordatorio al finalizar Pomodoro | ✔️ | - | Si no se configura el mantenimiento activo, los recordatorios pueden perderse y la cuenta atrás puede pausarse o congelarse en segundo plano. |
| Temporizador ascendente | ✖️ | - | - |
| Actualización automática del widget de la app | Normalmente sí (depende del dispositivo/SO) | - | Sin un mantenimiento adecuado, los widgets pueden quedarse en «Cargando» o mostrar estados obsoletos como «Todas las tareas completadas». |
| Acción del widget: completar tarea de conteo / abrir detalle de tarea (no MIUI) | ✖️ | - | - |
| Acción del widget: completar tarea de conteo / abrir detalle de tarea (MIUI) | Depende | Puede requerir permiso MIUI de ventana emergente/visualización en segundo plano | MIUI puede bloquear acciones de UI activadas desde el widget en segundo plano. |

- Algunos sistemas congelan o cierran tareas en segundo plano cuando la pantalla está apagada.
- Los widgets pueden comportarse de forma distinta según el launcher y la variante del SO.
- Si solo te importan los recordatorios, puedes cambiar a recordatorios de calendario para reducir la dependencia del segundo plano.

## Cómo configurarlo

> [!WARNING]
> Estos ajustes pueden aumentar ligeramente el consumo de batería.

Según nuestras pruebas en un OnePlus 8T, el uso en segundo plano durante 24 horas consumió unos **30 mAh**. Para la mayoría de usuarios, el impacto es pequeño.

LifeUp solo realiza operaciones pasivas limitadas en segundo plano, como recordatorios, actualizaciones de widgets y temporización Pomodoro.

---

### Pasos de configuración habituales

#### Ajustes generales

> No necesitas completar todos los pasos. Cada uno puede mejorar la prioridad y estabilidad en segundo plano.

**Ajustes del sistema Android**

1. En LifeUp, abre `Barra lateral` → `Ajustes` → `Problemas de compatibilidad`, luego toca `Ir a ajustes de optimización de batería`. Busca LifeUp y configúralo en **No optimizar**.

   a. En algunos dispositivos, LifeUp puede no aparecer tras saltar a esta página. En ese caso, omite este paso.

2. Si necesitas recordatorios, asegúrate de que LifeUp tenga concedido el permiso de notificaciones.

3. (Opcional) En los ajustes de Tareas, activa `Notificación de añadir rápido`.

<br/>

**Gestor de segundo plano del fabricante (Phone Manager)**

Muchos fabricantes añaden restricciones adicionales en segundo plano. Si no usas un dispositivo tipo Pixel/AOSP, normalmente necesitas configuración adicional.

1. Bloquea LifeUp en la pantalla de multitarea/apps recientes del sistema.

2. En gestión de apps del sistema / gestión de batería / phone manager, configura LifeUp para permitir ejecución en segundo plano (sin restricciones) y permitir inicio automático.

   a. Para guías específicas del fabricante, consulta [dontkillmyapp.com](https://dontkillmyapp.com/).

3. Al usar funciones de LifeUp, evita modos agresivos como super ahorro de energía o políticas estrictas de no molestar, o añade LifeUp a las listas de permitidos correspondientes.

<br/>

**¿Sigue sin funcionar?**

Según informes de usuarios y nuestras pruebas, LifeUp funciona con normalidad en dispositivos habituales tras una configuración correcta. Sin embargo, las actualizaciones del sistema pueden mover o renombrar ajustes.

1. Revisa todos los pasos anteriores y completa los que falten.

   a. Las restricciones del phone manager suelen estar repartidas en varias páginas y no aparecen como permisos estándar de la app.

   b. Prueba pasos opcionales (por ejemplo, activar notificación persistente) y vuelve a probar.

   c. Busca en los ajustes del sistema optimización de batería, restricciones en segundo plano, inicio automático y opciones de ventana emergente/visualización en segundo plano.

   d. Si solo te importan los recordatorios, prueba el modo `Recordatorio de calendario`.

2. Pregunta a otros usuarios con la misma marca/modelo de teléfono en la comunidad e incluye tu versión del SO.

3. Contacta con el soporte del fabricante del teléfono y pregunta cómo evitar que el sistema cierre una app concreta en segundo plano.

---

### Los widgets de la app no funcionan

1. Abre LifeUp primero y mantenlo en primer plano un momento.
2. Vuelve a añadir el widget (si hace falta, prueba más de una vez).
3. Si vuelve a fallar más tarde, revisa esta guía y vuelve a comprobar los ajustes de mantenimiento activo.
4. Si usas un launcher de terceros, cambia al launcher del sistema y prueba de nuevo.
5. Si usas un tema personalizado, cambia al tema predeterminado del sistema y prueba de nuevo.
6. Reinicia el teléfono.
7. Prueba otro launcher para descartar problemas específicos del launcher.
