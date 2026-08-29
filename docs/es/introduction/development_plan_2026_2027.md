# Plan de desarrollo 2026-2027

> [!IMPORTANT]
> Este es nuestro plan de desarrollo actual. Haremos todo lo posible por guiar las mejoras y actualizaciones del producto según este plan. Sin embargo, debido al entorno en constante cambio, el contenido del plan puede modificarse o ampliarse/reducirse. La publicación real del producto prevalecerá.

### I. Plan de desarrollo

> Actualizado: 2026/04

A diferencia de 2024-2025, en 2026-2027 esperamos seguir mejorando los módulos existentes de LifeUp y **ulives**, en lugar de añadir módulos funcionales completamente nuevos.

| Módulo | Subfunción | Motivo del requisito | Prioridad | Resultado |
| ---- | ------ | -------- | ------ | ---- |
| Integración con calendario | - Sincronización bidireccional con Google Calendar<br/>- Sincronización bidireccional con calendario del sistema | - Muchos comentarios del extranjero.<br/>- LifeUp es una herramienta de tareas con funciones superpuestas pero inconsistentes con apps de agenda (calendario). Desarrollar todas las funciones de calendario en LifeUp sería enorme. La integración externa puede ser una mejor solución. | P0 | 🚧 |
| Optimización de Síntesis | - Integración con la Tienda<br/>- Filtrado mejorado | - Síntesis es una de las funciones principales de LifeUp. Optimizar continuamente su integración con la Tienda y la eficiencia del filtrado para mejorar la comodidad del usuario. | P0 | ✅ Publicado |
| Optimización de Objetos | - Efectos de uso más ricos (modificar cantidades de otros Objetos)<br/>- Efectos de sonido al activarse<br/>- Admitir límites de uso<br/>- Condiciones de límite ampliadas | - El sistema de Objetos es central en la gamificación de LifeUp. Actualmente en ajuste en v1.103, mejorando continuamente la flexibilidad y el gameplay de Objetos. | P0 | 🚧 Ajuste v1.103 |
| Optimización de Atributos | - Subcategorías de Atributos (agrupación)<br/>- Soporte de sistema de títulos<br/>- Admitir tipo [Estado]<br/>- Optimización de página de estado<br/>- Widget de Nivel de vida | - El sistema de Atributos es otro núcleo de la gamificación. Seguiremos mejorando el sistema de Atributos con más personalización dimensional y visualización. | P0 | 🚧 Subcategorías publicadas, resto en planificación |
| Optimización de Tareas | - Edición y filtrado explícitos de etiquetas<br/>- Optimización de interacción de edición de subtareas<br/>- Comportamiento personalizado de finalización forzada de subtareas<br/>- Comportamiento personalizado de vencimiento o aplazamiento | - Tareas es la función principal de LifeUp; optimizamos continuamente la edición y la experiencia de interacción. | P1 | 🚧 |
| Recompensas por lotes en tareas de conteo | - Admitir reclamar Recompensas por lotes en tareas de conteo | - El mecanismo actual de Recompensas en tareas de conteo es relativamente simple; las Recompensas por lotes pueden ofrecer incentivos de objetivos más flexibles. | P1 | 🚧 |
| Optimización de Reflexiones | - Admitir más estilos de navegación | - Reflexiones es una característica distintiva de LifeUp; optimizamos continuamente su visualización e interacción. | P2 | 🚧 |
| Ampliación de Logros | - Estadísticas semanales/mensuales/anuales<br/>- Otras condiciones de desbloqueo de Logros | - El sistema de Logros necesita condiciones de desbloqueo más diversas para una experiencia de Logros más rica. | P2 | 🚧 |
| Sistema de datos | - Copia de seguridad separada de datos e imágenes<br/>- Exportación/importación parcial de datos<br/>- Cambio entre múltiples archivos integrados | - WebDAV falla fácilmente al subir archivos grandes, servicios en la nube gratuitos tienen límites de tráfico, copia completa con imágenes es demasiado grande.<br/>- Exportación/importación parcial puede usarse para que usuarios compartan sistemas de Recompensas.<br/>- Múltiples archivos integrados permiten cambiar directamente entre sistemas para depurar sin borrar datos repetidamente. | P1 | 🚧 |
| API | - Ampliar capacidades y cobertura de API a todas las funciones básicas | - Aún faltan algunas APIs como operaciones relacionadas con reflexiones.<br/>- LifeUp no puede ser todo en uno, pero la API permite que cada uno personalice y amplíe su LifeUp, y materialice una comunidad open source. | P1 | 🚧 |
| Desarrollo de **ulives** | - Seguir mejorando funciones de **ulives**<br/>- Explorar soporte multiplataforma (iOS/iPadOS/macOS/otros) | - **ulives** es el producto de nueva generación de LifeUp, desarrollado con tecnología multiplataforma moderna.<br/>- En el futuro podría expandirse a Android u otras plataformas. | P0 | 🚧 |

En resumen:

1. Seguiremos la dirección establecida, centrándonos en estabilidad y optimización de funciones existentes.
2. Mejoraremos continuamente la profundidad funcional de cada módulo para mejorar la experiencia del usuario.
3. Avanzaremos el desarrollo de **ulives** y exploraremos más soporte de plataformas.
4. Seguiremos mejorando las APIs y otros aspectos.

---

### II. Repaso y perspectivas

#### 2.1 Sobre **ulives**

En 2025 lanzamos **ulives** en iOS como producto de nueva generación de LifeUp. Algunos usuarios pueden preguntarse: ¿por qué lanzar una app nueva? ¿Por qué pagar de nuevo?

Estas son nuestras reflexiones y explicaciones:

**Restricciones tecnológicas y de arquitectura**

LifeUp está desarrollado con tecnología Android y ha acumulado mucha lógica y problemas históricos de compatibilidad durante su desarrollo. Dadas las restricciones de arquitectura técnica, es casi imposible replicar una versión idéntica en iOS o HarmonyOS manteniendo compatibilidad de datos.

Además, LifeUp se desarrolló gradualmente, con algunos diseños de producto comprometidos por compatibilidad y decisiones de diseño tempranas, que quizá no podamos cambiar fácilmente. Por ejemplo:

- **Moneda personalizada**: Lo subyacente de LifeUp es un tipo de moneda, lo que dificulta cambios arquitectónicos mayores.
- **Módulo Mundo**: Al inicio del desarrollo de LifeUp, por cooperación del lado servidor, planeamos añadir este módulo, pero la mayoría de funciones no se consideraron a fondo, resultando en funciones de equipo deficientes ahora.

Crear algo nuevo nos permite ver esto desde una perspectiva de producto nueva con conceptos modernos.

**Deuda técnica**

Tecnológicamente, LifeUp también pisó algunas minas:

- Uso de un framework ORM de base de datos adecuado para desarrollo rápido temprano pero básicamente sin mantenimiento, lo que dificulta la migración.
- Lo subyacente ni siquiera admite índices compuestos, causando cuellos de botella de rendimiento.
- Hemos dedicado un esfuerzo considerable a optimizar continuamente el rendimiento de la app con grandes volúmenes de datos.

Para **ulives**, usamos tecnología multiplataforma moderna (Kotlin Multiplatform) para reexaminar y desarrollar estos aspectos. Posibilidades futuras incluyen cruzar a Android u otras plataformas (actualmente solo admite iOS, iPadOS y macOS).

**Coste y precios**

El precio bajo de compra única temprano de LifeUp y el posicionamiento en una sola plataforma nos dejaron control de costes limitado para funciones que requieren inversión (como el módulo Mundo o funciones de IA).

El precio bajo de LifeUp (Android) se basa en costes de mantenimiento de una sola plataforma. **ulives** puede tener algunos ajustes y más planificación.

Como los equipos de desarrollo son distintos, es un desarrollo completamente nuevo, y **ulives** es actualmente totalmente offline. De hecho no podemos compartir membresías ni ofrecer descuentos extra, y quizá no los ofrezcamos en el futuro para no perjudicar a usuarios de pago.

---

#### 2.2 Eficiencia con IA

En años recientes hemos presenciado el auge del desarrollo asistido por IA, donde muchos desarrolladores pueden usar IA para desarrollar app tras app en poco tiempo.

De hecho, también intentamos usar IA en nuestro proceso de desarrollo para implementar rápidamente marcos funcionales principales y scaffolding de código. Sin embargo, la IA no lo es todo — determinar rutas de solución técnica, aceptación final y asegurar que todo funcione sigue requiriendo un esfuerzo humano considerable.

Lo que realmente lleva tiempo es pulir los detalles. Especialmente para optimización de animaciones en iOS, ajuste de fluidez de interacción, manejo de casos límite — el tiempo invertido aquí suele ser varias veces el de la lógica funcional en sí.

---

#### 2.3 Extensiones de usuarios e integración con IA

También hemos visto a muchos usuarios implementar funciones interesantes combinando IA con la API de LifeUp:

- Algunos usan MCP (Model Context Protocol) para conectar LifeUp con diversas cadenas de herramientas de IA
- Algunos combinan LifeUp con apps de notas como Obsidian para automatización de flujos de trabajo
- Algunos implementan sus propias herramientas web y scripts de automatización mediante APIs

Seguimos dando la bienvenida a usuarios que compartan métodos de extensión basados en IA, ¡y esperamos ver más ideas interesantes!

---

#### 2.4 Ritmo de desarrollo y calidad

Insistimos en el mantenimiento a largo plazo de LifeUp, **ulives** y nuestras otras apps. Ya tenemos planes y objetivos de desarrollo plurianuales para LifeUp, y seguiremos avanzando.

No perseguiremos lanzar funciones nuevas rápidamente ignorando calidad y estabilidad. Cada función pasa por diseño cuidadoso, desarrollo, pruebas y optimización para asegurar que el producto final entregado resista la prueba del tiempo.

Por eso elegimos invertir más tiempo en profundizar y optimizar funciones existentes en lugar de lanzar continuamente módulos funcionales nuevos.

---

#### 2.5 Destacados de la comunidad

Hemos tenido la suerte de encontrar muchos usuarios increíbles:

- Un usuario encontró un extraño cierre inesperado de LifeUp. Tras varias rondas de intercambio de información, exportó su registro del sistema (bugreport) y usó IA para analizar que fue causado por corrupción de datos del calendario del sistema. Como LifeUp usa notificaciones de calendario, el sistema lo cerró por error. Esto nos ayudó a identificar este problema de compatibilidad a nivel de sistema extremadamente oscuro.
- Muchos usuarios han compartido sus creaciones, incluyendo sistemas de Tareas interesantes, diseños de Objetos, compartición de Logros y otro contenido comunitario.

El abrumador apoyo de nuestros usuarios es lo que nos impulsa a seguir manteniendo y actualizando nuestros productos.

---

> Avance: En 2025 también lanzamos **ulives**, desarrollado con Kotlin Multiplatform, actualmente solo compatible con iOS, iPadOS y macOS, con planes de admitir más plataformas en el futuro.
