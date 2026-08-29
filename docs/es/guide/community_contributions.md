## Contribuciones de la comunidad 🤝

Estamos muy agradecidos con nuestra comunidad por crear herramientas que amplían las capacidades de LifeUp. A continuación encontrarás kits oficiales y proyectos destacados de la comunidad.

## Kits oficiales

| Proyecto | Descripción |
| --- | --- |
| [LifeUp Cloud](guide/api_cloud.md) | Puente HTTP API en el teléfono; acceso LAN y **escaneo QR** (`lifeup://`, URLs web, esquemas de otras apps) |
| [@lifeup/mcp](guide/api_mcp.md) | Servidor MCP oficial + Skills para Cursor, Claude Desktop y otros agentes de IA por LAN |
| [LifeUp Desktop](guide/api_desktop.md) | Cliente de escritorio oficial basado en HTTP de LifeUp Cloud |
| [Demo de integración Wordle](example/wordle/index.html) | Minijuego de adivinanza de palabras; llama a `lifeup://api/reward` al ganar |

**Configuración de Wordle:** Crea un Objeto en la Tienda → añade un efecto de enlace tipo 9 que apunte a la página Wordle → **Usar** abre el juego en el navegador; ganar otorga 10 monedas, perder aún da una moneda de consolación. También puedes codificar la URL de Wordle como código QR y escanearla con LifeUp Cloud. Consulta [API · Web externa (Wordle)](guide/api.md).

<br/>

## Proyectos de la comunidad

| Proyecto | Descripción | Autor |
| :--- | :--- | :--- |
| [lifeup-mcp](https://github.com/derekprovance/lifeup-mcp) | Servidor MCP comunitario temprano (sustituido por el oficial `@lifeup/mcp`). | [@derekprovance](https://github.com/derekprovance) |
| [lifeup_mod_coins](https://github.com/klienkross/lifeup_mod_coins) | Plugin Obsidian ↔ LifeUp: sincronización de tareas pendientes, sincronización de reflexiones, panel de datos de LifeUp en Obsidian. *Nota: repositorio solo en chino.* | [@klienkross](https://github.com/klienkross) |

> [!TIP]
> **¿Has creado algo interesante?** Si has desarrollado una herramienta, script o integración para LifeUp, cuéntanoslo mediante GitHub Issues o por correo.
