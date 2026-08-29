<h1 align="center" padding="100">MCP & Skills</h1>

Quer que a IA trabalhe com o LifeUp? Há duas camadas:

| | O que faz | Quem usa |
|---|---|---|
| **MCP** `@lifeup/mcp` | Descobre o LifeUp Cloud, envia requisições HTTP, codifica parâmetros, analisa respostas | Cursor, Claude Desktop, WorkBuddy e qualquer cliente MCP |
| **Skills** `lifeup-cloud/` | Como conectar, o que consultar e como chamar cada API | Incluído como MCP `help`; Claude Code / Pi também podem carregar a pasta como skill em disco |

O agente no seu computador alcança o LifeUp Cloud no celular pela LAN e então conversa com o LifeUp. Detalhes HTTP ficam na [API do LifeUp Cloud](guide/api_cloud.md). Código-fonte MCP: [LifeUp-SDK/mcp](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp).

> [!NOTE]
> Requer **LifeUp 1.106.0**+ e **LifeUp Cloud 3.0.0**+. Builds mais antigos ainda podem conectar, mas diários, estatísticas e a curva de Níveis ficam incompletos. `status.update` pode pedir ao usuário para atualizar.

O MCP dá ao agente **APIs de leitura/escrita**; a camada de IA adiciona **raciocínio** — priorizar o backlog de hoje, resumir estatísticas semanais a partir de diários, projetar Tarefas a partir dos seus Níveis de Atributos ou **montar uma configuração gamificada temática completa em um prompt** (dev indie, academia de magia e mais) — não apenas buscar listas brutas.

## Experimente perguntar

Depois que o MCP estiver instalado, você não precisa memorizar APIs — basta conversar com a IA.

**Planeje seu dia**

- "O que falta hoje? Ordene por prioridade e me diga o que atacar primeiro."
- "Escolha uma Tarefa não concluída que eu consiga terminar em cerca de 25 minutos."

**Analise seus dados**

- "Puxe as estatísticas de pomodoro, Foco, moedas e Pontos de Experiência desta semana — detalhe de onde vieram e resuma os padrões."
- "De onde vieram minhas moedas este mês? Mostre as maiores fontes e algo surpreendente."

**Orientação e design**

- "Olhe meus Níveis de Atributos e projete um conjunto de Tarefas diárias para subir minhas Habilidades mais fracas."

**Configuração temática em um passo**

- "Limpe os exemplos, depois monte uma configuração completa de desenvolvedor indie: listas, Loja, Conquistas e Atributos."
- "Projete uma rotina RPG completa de academia de magia — Tarefas, Atributos, Itens da Loja e Conquistas."

**Reflexão**

- "Olhe o que concluí hoje e escreva um diário curto: o que fiz e o que posso melhorar amanhã."
- "Crie uma lista de Conquistas chamada Rotina matinal, depois adicione 8 Conquistas com ícones emoji e Recompensas em moedas."
<br/>

## Início rápido

Envie esta frase ao seu agente para instalar o MCP e conectar pela primeira vez:

```
Follow this doc to install the LifeUp MCP server and complete the first connection: https://raw.githubusercontent.com/Ayagikei/LifeUp-Wiki/master/docs/en/guide/api_mcp.md
```

<br/>

## Skills

Os arquivos de skill ficam em [`mcp/skills/lifeup-cloud/`](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp/skills/lifeup-cloud) (uma cópia no repositório — sem pacote npm separado).

- **Cursor / Claude Desktop / WorkBuddy:** instale apenas o MCP. `help` lê esta skill; não instale duas vezes.
- **Claude Code / Pi / fluxo personalizado:** copie a pasta para o caminho de skills do agente, ou aponte diretamente para o repositório.

```text
mcp/skills/lifeup-cloud/
  SKILL.md                 conectar + operações comuns (leia primeiro)
  references/
    basics.md              erros, codificação, JSON, timeouts
    discovery.md           mDNS / token
    query.md               recursos list_data
    tasks.md / economy.md
    api-index.md           uma linha por método
    methods/*.md           tabela completa de parâmetros (carregar ao chamar)
    broadcasts.md / gaps.md
```

O agente lê a documentação progressivamente:

1. `help` (ou `SKILL.md` em disco) — fluxo geral
2. `help api-index` — quais métodos existem
3. `help add_task` — parâmetros de um método
4. `call_api` / `list_data` — fazer a chamada

Para personalizar: copie a pasta e edite `SKILL.md` e `references/`. O MCP `help` ainda lê a cópia empacotada, a menos que você recompile o MCP a partir do seu fork.

<br/>

## Configuração

1. Celular e computador na mesma LAN
2. LifeUp em execução, com Cloud autorizado a **Ler dados do LifeUp**
3. LifeUp Cloud iniciado (porta padrão `13276`)
4. [Node.js 20+](https://nodejs.org/) no computador

Token é opcional. Se definido, envie o token **bruto** no header — não `Bearer`.

<br/>

## Instalar MCP

Até o pacote estar no npm, instale pelo GitHub:

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

O `npx` clona o repositório e compila `mcp/`. Depois que isso entrar em `main`, remova `#feat/mcp`.

Se você já clonou o [LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK), use o instalador (compila o MCP e faz upsert nos clientes detectados; reexecuções não registram uma segunda cópia):

```bash
./scripts/install-mcp.sh
```

Clientes padrão: Codex, Cursor, Claude Code, Claude Desktop, Pi. Configs Pi que usam `imports: ["codex"]` herdam Codex e não são duplicadas.

Apps GUI no macOS frequentemente não têm `npx` no `PATH` — use caminho absoluto de `npx`/`node`, ou clone e execute `cd mcp && npm install && npm run build`.

| Variável | Função |
|---|---|
| `LIFEUP_HOST` | ex.: `192.168.1.8:13276`, pula mDNS |
| `LIFEUP_TOKEN` | Apenas no processo, nunca gravado em disco |
| `LIFEUP_MCP_CONFIG` | Caminho de config personalizado |

Após publicação: `npx -y @lifeup/mcp` (npmmirror na China).
<br/>

## Fluxo do agente :id=agent-workflow

1. `discover` — mDNS `_lifeup._tcp`; o TXT `port` é a porta HTTP. Conecta automaticamente se exatamente uma instância Cloud for encontrada.
2. `connect` — passe `host` quando zero ou várias instâncias forem encontradas.
3. `status` — verifique versões; se abaixo de 1.106.0 / 3.0.0, observe `update`.
4. Listas: `list_data` (campos compactos por padrão).
5. Escritas: `complete_task` / `add_task` / `reward` / `purchase_item`; todo o resto via `call_api`. Use `via=launch` para abrir a UI do App.

Chamadas destrutivas precisam de `confirm: true`. Não pré-codifique valores de parâmetros.

## Eventos

LifeUp: ative Labs → Eventos de broadcast (desativado por padrão; Cloud Avançado pode mostrar status e ativar). **Push de eventos WebSocket do Cloud ativado por padrão** (3.0.0+) e é apenas transporte.

- `list_events` — `GET /events`, sempre disponível
- `subscribe_events` — `WS /events`; erro se a chave do Cloud estiver desligada, HTTP ainda funciona

Detalhes: MCP `help broadcasts`.

<br/>

---

## Exemplo: configuração de desenvolvedor indie

Abaixo está o resultado de uma sessão MCP real: o usuário pediu à IA para **limpar os exemplos de desenvolvedor integrados do LifeUp**, depois montar uma configuração RPG completa em torno do **desenvolvimento de jogos indie** (listas de Tarefas, Atributos, Loja, Conquistas).

Você pode começar com prompts como:

> Limpe as Tarefas e Itens de exemplo, depois crie uma configuração completa de desenvolvedor indie: listas de Tarefas, Atributos, Itens da Loja e Conquistas.

### O que foi construído

| Área | Conteúdo |
| --- | --- |
| Listas de Tarefas | Ritual matinal, Codificação diária, Dev de jogos, Aprendizado profundo, Aprendizado e recarga, Encerramento |
| Atributos | Execução / Técnico / Colaboração / Foco / Bem-estar / Criatividade, mais **Estatísticas de dev** (Game Design, Debugging, Arquitetura) |
| Loja | **Suprimentos de dev** (consumíveis) + **Colecionáveis divertidos** (Itens easter egg) |
| Conquistas | **Jornada dev indie** (Hello World, First Bug Kill, Ship It!, …) |

> [!TIP]
> Clique em qualquer imagem para ampliar. Use as abas abaixo para alternar horizontalmente em vez de rolar uma página longa.

<!-- tabs:start -->

#### **1 · Visão geral de Tarefas**

Tarefas recorrentes do Ritual matinal na visualização **Todas**, com chips de categoria para Codificação diária, Dev de jogos e mais.

![Tarefas · Ritual matinal e categorias](_media/mcp/game-dev-example/02-tasks-overview.jpg ':size=45%')

#### **2 · Atributos**

Seis Atributos principais mais o grupo **Estatísticas de dev**. Concluir Tarefas concede Pontos de Experiência às Habilidades correspondentes.

![Painel de Atributos](_media/mcp/game-dev-example/03-skills.jpg ':size=45%')

#### **3 · Colecionáveis divertidos**

Itens easter egg da Loja: Dado de inspiração, Tecla RGB, Gato de mesa, Tijolo LEGO, Gamepad retrô, Pato de borracha — alguns com moedas aleatórias ou bônus de Atributos.

![Loja · Colecionáveis divertidos](_media/mcp/game-dev-example/04-shop-fun-collection.jpg ':size=45%')

#### **4 · Conquistas**

Conquistas de marco: primeira Tarefa, primeiro bug corrigido, enviar demo, sequências, pomodoros, Cofrinho, Pentakill diário e mais — com ícones emoji e condições de desbloqueio.

![Conquistas Jornada dev indie](_media/mcp/game-dev-example/06-achievements.jpg ':size=45%')

#### **5 · Detalhe Cofrinho**

Exemplo de condição de progresso: atingir **500 moedas** de saldo atual.

![Detalhe da Conquista · Cofrinho](_media/mcp/game-dev-example/07-achievement-detail-piggy-bank.jpg ':size=45%')

#### **6 · Detalhe Pentakill diário**

Exemplo de condição de contador: concluir **5 Tarefas diferentes em um dia**.

![Detalhe da Conquista · Pentakill diário](_media/mcp/game-dev-example/08-achievement-detail-pentakill.jpg ':size=45%')

<!-- tabs:end -->

### O que a IA normalmente faz

1. `list_tasks` / `list_items` — inspeciona exemplos existentes; exclui linhas antigas quando necessário (`confirm: true` para chamadas destrutivas).
2. Cria listas de Tarefas / Loja / Conquistas (`category`).
3. Cria Atributos e grupos (`skill` / `skill_group`).
4. Grava Tarefas, Itens e Conquistas em lote (`add_task` / `add_item` / `achievement`).
5. Atualiza as telas correspondentes no App para verificar.

Para parâmetros de API, veja [Skills](#skills) e [Fluxo do agente](#agent-workflow) acima; tabelas por método via MCP `help add_task`, etc.
