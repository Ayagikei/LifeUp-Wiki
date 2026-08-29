# Plan de desarrollo

Como *LifeUp* se mantiene actualmente en tiempo libre y con recursos limitados, no garantizamos que el plan de desarrollo se ejecute con precisión, y no prometemos una fecha de lanzamiento específica.

<br/>

## Estrategia de actualización

El ciclo de actualización de funciones locales se mantendrá entre 14 y 21 días.

Y después de cada actualización de funciones, podemos publicar varias correcciones.

Como la función del módulo «Mundo» involucra múltiples factores como desarrollo conjunto en ambas plataformas, sincronización de requisitos, despliegue de servidores, limitaciones de rendimiento del servidor y compatibilidad.

El ciclo de desarrollo será más largo que el de las funciones locales y se centrará principalmente en mantenimiento en lugar de introducir funciones nuevas.



**Prioridad de actualización (aproximada):**

Corrección de errores críticos >> Corrección de errores de experiencia que afectan a usuarios nuevos >> Actualizaciones de funciones > Corrección de errores de UI y detalles.

<br/>

## Estrategia de numeración de versiones

Se usa un número de versión de tres dígitos, como `1.80.3`.

**El primero** (como **1**.80.3) es el número de versión usado para revisiones mayores de la App, y 1 es la versión oficial inicial. Habrá muchos cambios de refactorización de código/rediseño de UI si mejora.


**El del medio** (como 1.**80**.3) es el número de versión de funciones (feature). El número de versión aumenta cuando se lanza una función de nivel medio o cuando se acumula un número relativamente grande de funciones menores.

Por ejemplo:

> La versión 64 lanzó el sistema Tienda&Almacén&Depósito.
>
> La versión 70 lanzó el Modo simple.
>
> La versión 80 lanzó el sistema de apertura de cajas.



**El tercer dígito** (p. ej., 1.80.**3**) es el número de revisión para corregir algunos problemas/errores críticos con cada lanzamiento de funciones. Al mismo tiempo, también puede traer algunas funciones menores.


> La versión antigua también usaba el número de versión de tres dígitos representado por letras en inglés, como 1.58c.
>
> La estrategia básica es la misma que arriba, excepto que la tercera sección se convierte en una letra en inglés y comienza desde `a`.
>
> Sin embargo, como algunas tiendas de aplicaciones no admiten esta estrategia de numeración de versiones, ahora está abandonada.

<br/>

Consulta el [Plan de desarrollo 2026-2027](introduction/development_plan_2026_2027.md) para ver nuestra hoja de ruta actual.

Consulta el [Plan de desarrollo 2024-2025](introduction/development_plan_2024.md) para la hoja de ruta anterior.

Consulta el [Plan de desarrollo 2022/10 - 2023/12](introduction/development_plan_2023.md) como archivo histórico.
