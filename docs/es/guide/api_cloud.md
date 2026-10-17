<h1 align="center" padding="100">LifeUp Cloud ☁️</h1>

<p align="center">
 <img src="guide/_media/api/cloud.png" />
</p>

> [!NOTE]
> Estamos desplegando **LifeUp v1.106.0** y **LifeUp Cloud v3.0.0** de forma gradual. Los plazos de revisión varían según la plataforma, por lo que esta documentación puede actualizarse antes de que las apps estén ampliamente disponibles; la fecha real de lanzamiento puede ser posterior a la que aparece aquí.

LifeUp Cloud es uno de los kits de herramientas API principales de LifeUp. Convierte tu teléfono en un **puente API**: controla LifeUp desde tu **ordenador u otros dispositivos**, crea **integraciones personalizadas** (escritorio, web, scripts de automatización) o combínalo con **agentes de IA**.

### Escenarios habituales

| Escenario | Para quién | En una frase | Más información |
| --- | --- | --- | --- |
| **HTTP + construye el tuyo** | Desarrolladores, usuarios de automatización | Llama a las API y consulta datos desde Python, apps web o scripts por LAN — no hace falta experiencia en Android | [Referencia de la API HTTP](/guide/api-reference), [Escritorio](guide/api_desktop.md) |
| **Escaneo QR** | Fans del check-in en el mundo real | Imprime códigos QR para completar Tareas, iniciar temporizadores, abrir diálogos o lanzar páginas web / otras apps | [Escaneo de códigos QR](#qr-code-scanning) |
| **Atajos de inicio / parada** | Automatización, NFC, Tasker | `lifeupcloud://start` y `lifeupcloud://stop` abren Cloud e inician o detienen el servidor HTTP | [Inicio y parada](#cloud-scheme) |
| **Agente IA + MCP** | Cursor, Claude, etc. | Un prompt para crear listas de Tareas, Objetos de la Tienda, Logros y más | [MCP & Skills](guide/api_mcp.md) |
> **Ejemplo de prompt para IA:** Borra las Tareas y Objetos de ejemplo de la Tienda, luego crea una configuración completa de desarrollador indie: listas de Tareas, Atributos, Objetos de la Tienda y Logros.

<br/>

## Descarga

- Si usas la versión de membresía de China continental, encontrarás la entrada de descarga de LifeUp Cloud en `Sidebar` → `Settings` → `Experiments`.
- [Google Play Store](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http)

<br/>


## Iniciar y detener el servicio Cloud :id=cloud-scheme

Puedes iniciar o detener el servidor HTTP sin pulsar **Start Service**, usando estos esquemas de URL:

```txt
lifeupcloud://start
lifeupcloud://stop
```

Abrir cualquiera de las URLs lanza LifeUp Cloud y aplica la acción. Úsalas como acceso directo en la pantalla de inicio, etiqueta NFC, acción de Tasker/automatización, o:

```txt
adb shell am start -a android.intent.action.VIEW -d lifeupcloud://start
```

Las mismas URLs aparecen en la tarjeta de estado de Cloud — tócalas para copiar.

> [!NOTE]
> `lifeupcloud://` controla el propio servidor HTTP de Cloud. No es una API de juego `lifeup://api/…`.

<br/>

## Escaneo de códigos QR :id=qr-code-scanning

El botón **Scan** en la parte superior de LifeUp Cloud lee la URL codificada en un código QR y la abre al instante — sin entrada manual.

El escaneo **no se limita a las API de LifeUp**: `lifeup://api/…`, páginas web `https://…` y esquemas de URL de otras apps (p. ej. `weixin://`) también funcionan — Android abre el destino correspondiente.

### Cómo usarlo

1. Elige una URL de LifeUp o de la [lista de API](guide/api.md) del wiki (completar una Tarea, iniciar un pomodoro, abrir diálogos de compra/uso u abrir una página web externa).

2. Genera un código QR con la URL completa (imprímelo y pégalo en un escritorio, pared o dispositivo).

3. Abre LifeUp Cloud, toca **Scan** (toca **?** junto a él para una guía breve en la app) y apunta al código.

### Qué puedes hacer

| Escenario | Ejemplo (ilustrativo) |
| --- | --- |
| Check-in Pomodoro | `lifeup://api/pomodoro?...` iniciar/detener temporizador |
| Check-in de Tarea | `lifeup://api/complete?name=...` completar una Tarea |
| Interacción con la Tienda | `lifeup://api/goto?page=shop` o diálogos de compra/uso |
| Recompensa / penalización | `lifeup://api/reward?...` / `lifeup://api/penalty?...` |
| Minijuego web | `https://wiki.lifeupapp.fun/en/example/wordle/index.html` |
| Otras apps | `weixin://`, `intent://` o el esquema de cualquier app instalada |
| Flujos personalizados | Cualquier combinación de URL escaneable |

### Interacción en el mundo real

Los códigos QR vinculan **lugares o acciones físicas** con la gamificación en la app:

- Pegatina en **equipo de gimnasio** → escanear para completar una Tarea de entrenamiento de fuerza

- Pegatina en **escritorio de estudio** → escanear para iniciar un pomodoro de Enfoque

- Pegatina en **puesto de trabajo** → escanear para registrar stand-up o revisión de código

- Pegatina en **tablón de eventos** → escanear para reclamar una Recompensa o abrir un Logro

En resumen: **convierte los URL Schemes en disparadores físicos escaneables**, con LifeUp Cloud como ejecutor entre la app y el mundo real.

<br/>

> [!NOTE]
> LifeUp Cloud es un puente HTTP solo en LAN. Cómo llegar a tu teléfono — dirección IP, router, firewall, misma subred, VPN o aislamiento AP — depende de tu red doméstica. Si no puedes conectar, no podemos depurar tu LAN personal. Revisa tu propia red, usa herramientas de red estándar o pide ayuda a un agente de IA.

## Conectar con LifeUp Cloud :id=connect

1. Instala versiones compatibles de LifeUp y LifeUp Cloud. Abre LifeUp Cloud y concede el permiso de datos/API de LifeUp cuando se solicite.
2. Inicia el servicio HTTP. Desde un dispositivo que pueda acceder al teléfono por la red, usa la dirección y el puerto mostrados por Cloud como URL base.
3. Si configuraste un token de Cloud, envía su valor sin modificar en la cabecera `Authorization`. Consulta `/info` para comprobar conexión y versiones instaladas; revisa tanto el estado HTTP como el `code` JSON.

## Referencia de la API HTTP :id=http-api-definition

La [referencia completa de interfaces y parámetros](/guide/api-reference) contiene un índice de rutas, reglas compartidas de respuesta/paginación, modelos completos, parámetros y ejemplos JSON. Consúltala al crear una integración. Los [métodos de esquemas URL](/guide/api) describen acciones individuales; [MCP & Skills](/guide/api_mcp) describe herramientas para agentes de IA.

### Marcas de tiempo de tareas e historial :id=task-history-timestamps

Consulta el [modelo temporal de tareas](/guide/api-reference?id=task-times): `startTime` es el inicio previsto, `deadline` el vencimiento y `endTime` del historial la hora registrada de finalización/vencimiento/abandono, interpretada junto con `status`.

#### Informes diarios e integridad del historial :id=history-daily-reports

Consulta [paginación del historial e informes diarios](/guide/api-reference?id=daily-report) y los [registros de EXP/monedas](/guide/api-reference?id=reward-journals) para cambios reales de recompensas.

## Contribución

El SDK, LifeUp Cloud y LifeUp Desktop son proyectos de código abierto.

Puedes obtener el código fuente en:

- [Ayagikei/LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop](https://github.com/Ayagikei/LifeUp-Desktop)
