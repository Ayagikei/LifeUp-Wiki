<h1 align="center" padding="100">Cliente de escritorio (API) en red local 🖥</h1>

<p align="center">
 <img src="guide/_media/api/desktop.png" />
</p>

Hemos creado un cliente de escritorio ligero para LifeUp basado en las API de LifeUp. Es compatible con Windows, Linux y macOS.

**No es una app independiente.** Lee los datos offline de LifeUp desde tu teléfono mediante acceso por API.

<br/>

## Funcionalidades

> [!NOTE]
> La versión actual es principalmente una vista previa técnica de las capacidades de la API. Se centra en operaciones básicas de consulta y no cubre todas las funciones de la app.

- Totalmente de código abierto. Puedes personalizar la interfaz e implementar tus propias funciones.
- Capacidades básicas actuales:
  - Consultar la lista de Tareas y completarlas
  - Consultar la lista de Atributos y Niveles
  - Consultar la lista de Objetos y comprarlos
  - Consultar Reflexiones y ver imágenes a tamaño completo en el escritorio
  - Exportar Reflexiones a archivos Markdown
  - Añadir Tareas (aún no cubre todas las opciones de la app)

<br/>

## Descarga

Todos los paquetes de escritorio se publican en [LifeUp Desktop Releases](https://github.com/Ayagikei/LifeUp-Desktop/releases).

> [!WARNING]
> Antes de usar el escritorio, asegúrate de que LifeUp Cloud sea v2.0.0 o superior.<br/>
> Si usas la compilación de GitHub Releases, actualiza LifeUp Cloud en `Settings` → `Labs`.<br/>
> Si usas la compilación de Google Play, puedes actualizar desde [Google Play](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http) o [LifeUp SDK Releases](https://github.com/Ayagikei/LifeUp-SDK/releases/latest).<br/>
> Algunos navegadores pueden bloquear la descarga del instalador por política de seguridad. Elige **Conservar/Permitir** (el texto varía según el navegador) o usa otro gestor de descargas.

### Plataformas de instalación

<!-- tabs:start -->

#### **Windows**

- `LifeUp Desktop.msi`

> [!TIP]
> **Windows SmartScreen**<br/>
> El MSI no está firmado con EV en este momento, por lo que Windows puede mostrar una advertencia de «aplicación no reconocida».<br/>
> Tras confirmar que el archivo proviene del release oficial de GitHub, haz clic en **Más información → Ejecutar de todos modos**.

#### **Linux**

- Descarga desde [LifeUp Desktop Releases](https://github.com/Ayagikei/LifeUp-Desktop/releases) y usa `lifeup-desktop.deb`.

#### **macOS**

- Intel / x64: `LifeUp-Desktop-x64.dmg`
- Apple Silicon / ARM64: `LifeUp-Desktop-arm64.dmg`
- Las compilaciones para macOS aún no están completamente probadas; algunas funciones como **Auto Connect** pueden no estar disponibles.

> [!TIP]
> **Gatekeeper / firma en macOS**<br/>
> Las compilaciones actuales para macOS no están notarizadas. Puede aparecer una advertencia de «desarrollador no identificado».<br/>
> Puedes abrir el `.dmg`, mover la app a Aplicaciones y luego hacer clic derecho en la app y elegir **Abrir**,<br/>
> o ir a **Ajustes del sistema → Privacidad y seguridad** y hacer clic en **Abrir de todos modos**.<br/>
> Consulta la [guía oficial de Apple](https://support.apple.com/en-hk/guide/mac-help/mh40616/mac) para más detalles.

<!-- tabs:end -->

Si falta algún paquete temporalmente, vuelve a comprobar más tarde. Los recursos del release pueden seguir subiéndose.

<br/>

## Cómo usar

### Configuración inicial

#### Requisitos previos

- El teléfono y el escritorio deben estar en la misma LAN (por ejemplo, la misma Wi-Fi).
- <del>Si tu red es compleja, prueba primero si el escritorio puede hacer ping a la IP del teléfono.</del>
  - Las versiones recientes del escritorio admiten detección automática de la IP del teléfono, así que esto suele ser innecesario.

#### En el teléfono

1. Actualiza LifeUp a la última versión.
2. En LifeUp, abre `Settings` → `Labs` e instala **LifeUp Cloud**.
3. Abre LifeUp Cloud y concede los permisos necesarios:
   - Permiso de ventana flotante / dibujar sobre otras apps
   - Permiso de lectura de datos de LifeUp
4. Toca **Start Service** en LifeUp Cloud.

**Configuración adicional recomendada**

- Realiza la configuración de compatibilidad tanto en LifeUp como en LifeUp Cloud, y desactiva la optimización de batería para reducir cierres en segundo plano.
- Si usas MIUI (Xiaomi/Redmi), permite **Display UI in background** para ambas apps.
- Mantén LifeUp y LifeUp Cloud en ejecución.

#### En el escritorio

1. Instala la app de escritorio desde el paquete del release.
2. En los ajustes del escritorio, introduce la IP del servicio que muestra LifeUp Cloud.
   - En el escritorio v1.1.0+, puedes probar **Auto Connect**.
3. Si todo está configurado correctamente, deberías poder ver los datos de LifeUp en el escritorio.
   - Si falla, revisa la configuración adicional anterior.

### Uso posterior

1. Abre LifeUp y LifeUp Cloud en el teléfono.
2. Toca **Start Service** en LifeUp Cloud.
3. Inicia el cliente de escritorio.

<br/>

## Preguntas frecuentes

<details>
<summary>¿Puedo añadir Tareas desde el escritorio?</summary>

Sí. La compilación actual del escritorio admite la creación básica de Tareas.

Sin embargo, aún no están disponibles en el escritorio todas las opciones avanzadas de Tareas de la app. Para configuraciones complejas, usa la app móvil o llama a las API mediante LifeUp Cloud.

</details>

<details>
<summary>Pulsé «Request LifeUp Permission» en LifeUp Cloud, pero no pasó nada / API not found.</summary>

1. Si no pasa nada, es posible que ya lo hayas concedido.
2. Si aparece API not found, únete a la beta de miembros y actualiza LifeUp a la última versión beta.

</details>

<details>
<summary>Tras bloquear el teléfono un rato, el escritorio ya no puede leer datos.</summary>

Realiza la configuración de compatibilidad tanto en LifeUp como en LifeUp Cloud.

</details>

<details>
<summary>Cuando LifeUp y LifeUp Cloud están en segundo plano, algunas API no se ejecutan.</summary>

> Esto normalmente no afecta al uso básico del escritorio, pero puede afectar a llamadas API personalizadas.

Asegúrate de que LifeUp Cloud tenga permiso de ventana flotante/dibujar sobre otras apps.

Si usas MIUI (Xiaomi/Redmi), activa también el permiso **Display UI in background** para ambas apps.

</details>

<details>
<summary>La instalación en Windows falla con `Failed to launch JVM`.</summary>

Referencia: [Issue #2](https://github.com/Ayagikei/LifeUp-Desktop/issues/2)

Suele estar relacionado con la configuración local de accesibilidad de la JVM.

Una solución habitual es comentar estas líneas en `~/.accessibility.properties`:

```txt
# assistive_technologies=com.sun.java.accessibility.AccessBridge
# screen_magnifier_present=true
```

Tras editar, reinicia la app y prueba de nuevo.

> `~` significa el directorio personal de tu usuario.

</details>

<br/>

## Contribución

El SDK, LifeUp Cloud y LifeUp Desktop son proyectos de código abierto.

Código fuente:

- [Ayagikei/LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop](https://github.com/Ayagikei/LifeUp-Desktop)
