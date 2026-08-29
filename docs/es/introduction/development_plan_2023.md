# Plan de desarrollo 2022/10 - 2023/12

> [!IMPORTANT]
> Este es un plan de desarrollo caducado, conservado solo con fines de archivo y referencia. El entorno sigue cambiando y nuestros planes se ajustarán en consecuencia. Este plan indica en general nuestra dirección de desarrollo, pero no prometemos ejecutarlo por completo, y también podemos desarrollar más allá del plan.

<br/>

El desarrollo de LifeUp en años anteriores siempre se centró en desarrollar nuevos módulos funcionales o añadir nuevas funciones a módulos existentes.

Hoy creemos que los módulos funcionales de LifeUp tienen suficiente amplitud autoconsistente, pero son insuficientes en profundidad.

Por tanto, los siguientes objetivos de desarrollo apuntan a la profundidad funcional, mejorando continuamente los módulos existentes disponibles, aumentando la practicidad (integración con calendario, widgets, estadísticas);

y ampliando continuamente la funcionalidad de las APIs para que puedan extenderse por completo a diversas funciones externas.
Además, intentaremos mejorar nuestro sistema de datos y explorar el uso de Flutter para desarrollar versiones multiplataforma.

<br/>

- **2023/01/26**
  - Añadido el ítem «Lado PC LAN» a «Multiplataforma», también añadida la explicación correspondiente a «APIs».
  - Ajustada la versión estimada de «Integración con calendario», el progreso puede retrasarse.
  - Ajustada la versión estimada de «Experiencia requerida personalizada», el progreso puede adelantarse.
- **2022/10/16**
  - **Añadida hoja de ruta para Atributos, Logros y Capacidades básicas**

| Módulo | Subfunción | Versión estimada | Motivo del requisito | Prioridad | Resultado |
| ---- | ------ | -------- | ------ | ---- | ---- |
| Integración con calendario | - Sincronización bidireccional con Google Calendar<br/>- Sincronización bidireccional con calendario del sistema | v1.91~1.93 | - Muchos comentarios del extranjero.<br/>- LifeUp es una herramienta de tareas con funciones superpuestas pero inconsistentes con apps de agenda (calendario). Desarrollar todas las funciones de calendario en LifeUp sería enorme. La integración externa puede ser una mejor solución. | P0 | ~ |
| Widgets | - Widget de Atributos<br/>- Widget de Objetos<br/>- etc... | v1.92~1.95 | - Usabilidad.<br/>- Los widgets bonitos también aportan gamificación y motivación. | P1 | ~ |
| Estadísticas | - Estadísticas de varios indicadores<br/>- Estadísticas detalladas de Pomodoro<br/>- Generar tarjetas para compartir | v1.92~1.95 | - Falta estadística de Pomodoro.<br/>- El módulo de estadísticas no se ha mejorado en mucho tiempo, diseño y datos desactualizados.<br/>- Las tarjetas para compartir son adecuadas para compartir externamente, pueden aportar incentivos y atraer más usuarios en cierta medida (requiere diseño UI cuidado). | P1 | - Se espera desarrollar algunas tarjetas de estadísticas en v1.91 |
| APIs | - Desarrollar SDK<br/>- Admitir consultas de listas<br/>- Más APIs comunes | v1.91~1.95 | - Falta interfaz de datos de listas. Tras admitir consultas de listas, terceros pueden desarrollar UI personalizada (como listas de Tareas), la extensibilidad puede mejorar mucho.<br/>- Sobre las interfaces anteriores, desarrollar SDKs correspondientes y lado PC LAN.<br/>- LifeUp no puede ser todo en uno, pero la API permite que cada uno personalice y amplíe su LifeUp, y materialice una comunidad open source. | P1 | - Se espera ofrecer la primera versión de API de consulta en v1.91 |
| Atributos | - Experiencia requerida personalizada | v1.91~1.92 | ~ | P2 | - Se espera completar el desarrollo en v1.91 |
| Logros | - Logros de tipo repetición | v1.94~1.97 | ~ | P2 | ~ |
| Capacidades básicas | - Edición por lotes (Tareas, Logros, etc.)<br/>- Selección múltiple de Objetos, empaquetado automático en cajas, etc. | v1.94~1.97 | ~ | P1 | ~ |
| Sistema de datos | - Copia de seguridad separada de datos e imágenes<br/>- Exportación/importación parcial de datos<br/>- Cambio entre múltiples archivos integrados | ~ | - WebDAV falla fácilmente al subir archivos grandes, servicios en la nube gratuitos tienen límites de tráfico, copia completa con imágenes es demasiado grande.<br/>- Exportación/importación parcial puede usarse para que usuarios compartan sistemas de Recompensas.<br/>- Múltiples archivos integrados permiten cambiar directamente entre sistemas para depurar sin borrar datos repetidamente. | P1 | ~ |
| Multiplataforma | - Seguir aprendiendo y usando Flutter para versión multiplataforma | Lado PC LAN: v1.91-1.92<br/>Flutter: v2.0 | - Prototipo de versión iOS.<br/>- Más inclinados a explorar nuevas implementaciones que replicar uno a uno la versión Android.<br/>- Quizá adecuado para Windows/macOS y otras plataformas, hay que investigar.<br/>- Desarrollar lado PC LAN basado en APIs (versión que lee datos del teléfono). | P1 | - Se espera ofrecer la primera versión del lado PC en v1.91 |
