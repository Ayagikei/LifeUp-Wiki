## Contribuições da comunidade 🤝

Somos muito gratos à nossa comunidade por construir ferramentas que ampliam as capacidades do LifeUp. Abaixo estão os kits oficiais e projetos em destaque da comunidade.

## Kits oficiais

| Projeto | Descrição |
| --- | --- |
| [LifeUp Cloud](guide/api_cloud.md) | Ponte HTTP no celular; acesso LAN e **leitura de QR** (`lifeup://`, URLs web, esquemas de outros apps) |
| [@lifeup/mcp](guide/api_mcp.md) | Servidor MCP oficial + Skills para Cursor, Claude Desktop e outros agentes de IA via LAN |
| [LifeUp Desktop](guide/api_desktop.md) | Cliente desktop oficial construído sobre HTTP do LifeUp Cloud |
| [Demo de integração Wordle](example/wordle/index.html) | Mini-jogo de adivinhar palavras; chama `lifeup://api/reward` ao vencer |

**Configuração do Wordle:** Crie um Item na Loja → adicione um efeito de link tipo 9 apontando para a página Wordle → **Usar** abre o jogo no navegador; vitória concede 10 moedas, derrota ainda dá uma moeda de consolação. Você também pode codificar a URL do Wordle como QR code e escaneá-la com o LifeUp Cloud. Veja [API · Web externa (Wordle)](guide/api.md).

<br/>

## Projetos da comunidade

| Projeto | Descrição | Autor |
| :--- | :--- | :--- |
| [lifeup-mcp](https://github.com/derekprovance/lifeup-mcp) | Servidor MCP comunitário inicial (substituído pelo `@lifeup/mcp` oficial). | [@derekprovance](https://github.com/derekprovance) |
| [lifeup_mod_coins](https://github.com/klienkross/lifeup_mod_coins) | Plugin Obsidian ↔ LifeUp: sincronização de tarefas, sincronização de reflexões, painel de dados do LifeUp no Obsidian. *Nota: repositório apenas em chinês.* | [@klienkross](https://github.com/klienkross) |

> [!TIP]
> **Construiu algo legal?** Se você desenvolveu uma ferramenta, script ou integração para o LifeUp, avise-nos via GitHub Issues ou e-mail!
