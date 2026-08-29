<h1 align="center" padding="100">MCP & Skills</h1>

¿Quieres que la IA trabaje con LifeUp? Hay dos capas:

| | Qué hace | Quién lo usa |
|---|---|---|
| **MCP** `@lifeup/mcp` | Descubre LifeUp Cloud, envía peticiones HTTP, codifica parámetros y analiza respuestas | Cursor, Claude Desktop, WorkBuddy y cualquier cliente MCP |
| **Skills** `lifeup-cloud/` | Cómo conectar, qué consultar y cómo llamar a cada API | Incluido en MCP como `help`; Claude Code / Pi también pueden cargar la carpeta como skill en disco |

El agente en tu ordenador llega a LifeUp Cloud en el teléfono por la LAN y luego habla con LifeUp. Los detalles HTTP están en la [API de LifeUp Cloud](guide/api_cloud.md). Código fuente MCP: [LifeUp-SDK/mcp](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp).

> [!NOTE]
> Requiere **LifeUp 1.106.0**+ y **LifeUp Cloud 3.0.0**+. Versiones anteriores pueden seguir conectando, pero diarios, estadísticas y la curva de nivel están incompletos. `status.update` puede pedir al usuario que actualice.

MCP ofrece al agente **API de lectura/escritura**; la capa de IA añade **razonamiento** — priorizar el backlog de hoy, resumir estadísticas semanales desde diarios, diseñar Tareas según tus Niveles de Atributos, o **montar una gamificación temática completa en un solo prompt** (desarrollo indie, academia de magia y más) — no solo obtener listas en bruto.

## Prueba a preguntar

Una vez instalado MCP, no necesitas memorizar las API — solo habla con la IA.

**Planifica tu día**

- «¿Qué queda hoy? Ordénalo por prioridad y dime por dónde empezar.»
- «Elige una Tarea sin terminar que pueda completar en unos 25 minutos.»

**Analiza tus datos**

- «Saca las estadísticas de pomodoro, Enfoque, monedas y Puntos de Experiencia de esta semana — desglosa de dónde vienen y resume los patrones.»
- «¿De dónde vinieron mis monedas este mes? Muestra las fuentes principales y algo sorprendente.»

**Entrena y diseña**

- «Mira mis Niveles de Atributos y diseña un conjunto de Tareas diarias para subir mis Habilidades más débiles.»

**Configuración temática de un solo paso**

- «Borra los ejemplos y monta una configuración completa de desarrollador indie: listas, Tienda, Logros y Atributos.»
- «Diseña una rutina RPG completa de academia de magia — Tareas, Atributos, Objetos de la Tienda y Logros.»

**Reflexiona**

- «Mira lo que terminé hoy y escribe un diario breve: qué hice y qué podría mejorar mañana.»
- «Crea una lista de Logros llamada Morning Routine y añade 8 Logros con iconos emoji y Recompensas en monedas.»
<br/>

## Inicio rápido

Envía esta línea a tu agente para instalar MCP y completar la primera conexión:

```
Follow this doc to install the LifeUp MCP server and complete the first connection: https://raw.githubusercontent.com/Ayagikei/LifeUp-Wiki/master/docs/en/guide/api_mcp.md
```

<br/>

## Skills

Los archivos de Skills están en [`mcp/skills/lifeup-cloud/`](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp/skills/lifeup-cloud) (una copia en el repo — sin paquete npm aparte).

- **Cursor / Claude Desktop / WorkBuddy:** instala solo MCP. `help` lee este skill; no lo instales dos veces.
- **Claude Code / Pi / flujo personalizado:** copia la carpeta en la ruta de skills del agente, o apunta directamente al repo.

```text
mcp/skills/lifeup-cloud/
  SKILL.md                 conexión + operaciones habituales (léelo primero)
  references/
    basics.md              errores, codificación, JSON, timeouts
    discovery.md           mDNS / token
    query.md               recursos list_data
    tasks.md / economy.md
    api-index.md           una línea por método
    methods/*.md           tabla completa de parámetros (cargar al llamar)
    broadcasts.md / gaps.md
```

El agente lee la documentación de forma progresiva:

1. `help` (o `SKILL.md` en disco) — flujo general
2. `help api-index` — qué métodos existen
3. `help add_task` — parámetros de un método
4. `call_api` / `list_data` — hacer la llamada

Para personalizar: copia la carpeta y edita `SKILL.md` y `references/`. MCP `help` sigue leyendo la copia empaquetada salvo que recompiles MCP desde tu fork.

<br/>

## Configuración

1. Teléfono y ordenador en la misma LAN
2. LifeUp en ejecución, con Cloud autorizado para **Read LifeUp Data**
3. LifeUp Cloud iniciado (puerto predeterminado `13276`)
4. [Node.js 20+](https://nodejs.org/) en el ordenador

El token es opcional. Si lo usas, envía el token **en bruto** en la cabecera — no `Bearer`.

<br/>

## Instalar MCP

Hasta que el paquete esté en npm, instala desde GitHub:

```json
{
  "mcpServers": {
    "lifeup": {
      "command": "npx",
      "args": ["-y", "github:Ayagikei/LifeUp-SDK#feat/mcp"]
    }
  }
}
```

`npx` clona el repo y compila `mcp/`. Cuando esto llegue a `main`, quita `#feat/mcp`.

Si ya clonaste [LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK), usa el instalador (compila MCP y actualiza clientes detectados; repetir no registra una segunda copia):

```bash
./scripts/install-mcp.sh
```

Clientes predeterminados: Codex, Cursor, Claude Code, Claude Desktop, Pi. Las configs de Pi con `imports: ["codex"]` heredan Codex y no se duplican.

Las apps con GUI en macOS a menudo no tienen `npx` en el `PATH` — usa una ruta absoluta a `npx`/`node`, o clona y ejecuta `cd mcp && npm install && npm run build`.

| Variable | Función |
|---|---|
| `LIFEUP_HOST` | p. ej. `192.168.1.8:13276`, omitir mDNS |
| `LIFEUP_TOKEN` | Solo en proceso, nunca escrito en disco |
| `LIFEUP_MCP_CONFIG` | Ruta de config personalizada |

Tras publicar: `npx -y @lifeup/mcp` (npmmirror en China).
<br/>

## Flujo del agente :id=agent-workflow

1. `discover` — mDNS `_lifeup._tcp`; el `port` del TXT es el puerto HTTP. Se conecta automáticamente si encuentra exactamente una instancia de Cloud.
2. `connect` — pasa `host` cuando hay cero o varias instancias.
3. `status` — comprueba versiones; si están por debajo de 1.106.0 / 3.0.0, atento a `update`.
4. Listas: `list_data` (campos compactos por defecto).
5. Escrituras: `complete_task` / `add_task` / `reward` / `purchase_item`; todo lo demás vía `call_api`. Usa `via=launch` para abrir la interfaz de la App.

Las llamadas destructivas requieren `confirm: true`. No codifiques los valores de parámetros por adelantado.

## Eventos

LifeUp: activa Labs → Broadcast events (desactivado por defecto; Cloud Advanced puede mostrar el estado y activarlo). **WebSocket event push** de Cloud está activado por defecto (3.0.0+) y es solo transporte.

- `list_events` — `GET /events`, siempre disponible
- `subscribe_events` — `WS /events`; error si el interruptor de Cloud está apagado; HTTP sigue funcionando

Detalles: MCP `help broadcasts`.

<br/>

---

## Ejemplo: configuración de desarrollador indie

A continuación, el resultado de una sesión MCP real: el usuario pidió a la IA **borrar los ejemplos de desarrollador integrados en LifeUp** y montar una configuración RPG completa en torno al **desarrollo de juegos indie** (listas de Tareas, Atributos, Tienda, Logros).

Puedes empezar con prompts como:

> Clear the sample tasks and shop items, then create a full indie game developer setup: task lists, attributes, shop items, and achievements.

### Qué se creó

| Área | Contenido |
| --- | --- |
| Listas de Tareas | Morning Ritual, Coding Daily, Game Dev, Deep Learning, Learning & Recharge, Wrap-up |
| Atributos | Execution / Technical / Collaboration / Focus / Wellness / Creativity, más **Developer Stats** (Game Design, Debugging, Architecture) |
| Tienda | **Dev Supplies** (consumibles) + **Fun Collectibles** (Objetos easter egg) |
| Logros | **Indie Dev Journey** (Hello World, First Bug Kill, Ship It!, …) |

> [!TIP]
> Haz clic en cualquier imagen para ampliar. Usa las pestañas de abajo para cambiar horizontalmente en lugar de desplazarte por una página larga.

<!-- tabs:start -->

#### **1 · Resumen de Tareas**

Tareas recurrentes de Morning Ritual en la vista **All**, con chips de categoría para Coding Daily, Game Dev y más.

![Tasks · Morning Ritual and categories](_media/mcp/game-dev-example/02-tasks-overview.jpg ':size=45%')

#### **2 · Atributos**

Seis Atributos principales más el grupo **Developer Stats**. Completar Tareas otorga EXP a las Habilidades correspondientes.

![Attributes panel](_media/mcp/game-dev-example/03-skills.jpg ':size=45%')

#### **3 · Fun Collectibles**

Objetos easter egg de la Tienda: Inspiration Dice, RGB Keycap, Desk Cat, LEGO Brick, Retro Gamepad, Rubber Duck — algunos con monedas aleatorias o bonificaciones de Atributos.

![Shop · Fun Collectibles](_media/mcp/game-dev-example/04-shop-fun-collection.jpg ':size=45%')

#### **4 · Logros**

Logros por hitos: primera Tarea, primer bug corregido, publicar demo, rachas, pomodoros, Piggy Bank, Daily Pentakill y más — con iconos emoji y condiciones de desbloqueo.

![Indie Dev Journey achievements](_media/mcp/game-dev-example/06-achievements.jpg ':size=45%')

#### **5 · Detalle de Piggy Bank**

Ejemplo de condición por progreso: alcanzar **500 monedas** de saldo actual.

![Achievement detail · Piggy Bank](_media/mcp/game-dev-example/07-achievement-detail-piggy-bank.jpg ':size=45%')

#### **6 · Detalle de Daily Pentakill**

Ejemplo de condición por contador: completar **5 Tareas distintas en un día**.

![Achievement detail · Daily Pentakill](_media/mcp/game-dev-example/08-achievement-detail-pentakill.jpg ':size=45%')

<!-- tabs:end -->

### Qué suele hacer la IA

1. `list_tasks` / `list_items` — inspecciona ejemplos existentes; elimina filas antiguas cuando haga falta (`confirm: true` en llamadas destructivas).
2. Crea listas de Tareas / Tienda / Logros (`category`).
3. Crea Atributos y grupos (`skill` / `skill_group`).
4. Escribe Tareas, Objetos y Logros en lote (`add_task` / `add_item` / `achievement`).
5. Actualiza las pantallas correspondientes en la App para verificar.

Para parámetros de API, consulta [Skills](#skills) y [Flujo del agente](#agent-workflow) arriba; tablas por método vía MCP `help add_task`, etc.
