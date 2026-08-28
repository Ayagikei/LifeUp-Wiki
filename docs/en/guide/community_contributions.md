## Community Contributions 🤝

We are incredibly grateful to our community for building tools that extend LifeUp's capabilities. Below are official toolkits and featured community projects.

## Official toolkits

| Project | Description |
| --- | --- |
| [LifeUp Cloud](guide/api_cloud.md) | Phone-side HTTP API bridge; LAN access and **QR scanning** (`lifeup://`, web URLs, other app schemes) |
| [@lifeup/mcp](guide/api_mcp.md) | Official MCP server + Skills for Cursor, Claude Desktop, and other AI agents over LAN |
| [LifeUp Desktop](guide/api_desktop.md) | Official desktop client built on LifeUp Cloud HTTP |
| [Wordle integration demo](example/wordle/index.html) | Word-guessing mini-game; calls `lifeup://api/reward` on win |

**Wordle setup:** Create a shop item → add a type-9 link effect pointing to the Wordle page → **Use** opens the game in the browser; win grants 10 coins, loss still gives a consolation coin. You can also encode the Wordle URL as a QR code and scan it with LifeUp Cloud. See [API · External web (Wordle)](guide/api.md).

<br/>

## Community projects

| Project | Description | Author |
| :--- | :--- | :--- |
| [lifeup-mcp](https://github.com/derekprovance/lifeup-mcp) | Early community MCP server (superseded by official `@lifeup/mcp`). | [@derekprovance](https://github.com/derekprovance) |
| [lifeup_mod_coins](https://github.com/klienkross/lifeup_mod_coins) | Obsidian ↔ LifeUp plugin: to-do sync, reflection sync, LifeUp data dashboard in Obsidian. *Note: Chinese-only repo.* | [@klienkross](https://github.com/klienkross) |

> [!TIP]
> **Built something cool?** If you've developed a tool, script, or integration for LifeUp, please let us know via GitHub Issues or email!
