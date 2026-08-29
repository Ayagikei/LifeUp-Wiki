<h1 align="center" padding="100">LifeUp Cloud ☁️</h1>

<p align="center">
 <img src="guide/_media/api/cloud.png" />
</p>

O LifeUp Cloud é um dos principais kits de ferramentas de API do LifeUp. Ele transforma seu celular em uma **ponte de API**: controle o LifeUp a partir do **computador ou de outros dispositivos**, crie **integrações personalizadas** (desktop, web, scripts de automação) ou combine com **agentes de IA**.

### Cenários típicos

| Cenário | Para quem | Em uma frase | Saiba mais |
| --- | --- | --- | --- |
| **HTTP + faça você mesmo** | Desenvolvedores, usuários de automação | Chame APIs e consulte dados via Python, apps web ou scripts na LAN — sem experiência com Android | [HTTP API](#http-api-definition), [Desktop](guide/api_desktop.md) |
| **Leitura de QR code** | Fãs de check-in no mundo real | Imprima QR codes para concluir Tarefas, iniciar timers, abrir diálogos ou abrir páginas web / outros apps | [Leitura de QR code](#qr-code-scanning) |
| **Atalhos iniciar / parar** | Automação, NFC, Tasker | `lifeupcloud://start` e `lifeupcloud://stop` abrem o Cloud e iniciam ou param o servidor HTTP | [Iniciar e parar](#cloud-scheme) |
| **Agente de IA + MCP** | Cursor, Claude, etc. | Um prompt para montar listas de Tarefas, Itens da Loja, Conquistas e muito mais | [MCP & Skills](guide/api_mcp.md) |
> **Exemplo de prompt de IA:** Limpe as Tarefas e Itens de exemplo, depois crie uma configuração completa de desenvolvedor indie: listas de Tarefas, Atributos, Itens da Loja e Conquistas.

<br/>

## Download

- Se você usa a versão de assinatura da China continental, encontre a entrada de download do LifeUp Cloud em `Barra lateral` → `Configurações` → `Experimentos`.
- [Google Play Store](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http)

<br/>


## Iniciar e parar o serviço Cloud :id=cloud-scheme

Você pode iniciar ou parar o servidor HTTP sem tocar em **Iniciar serviço**, usando estes esquemas de URL:

```txt
lifeupcloud://start
lifeupcloud://stop
```

Abrir qualquer uma dessas URLs abre o LifeUp Cloud e aplica a ação. Use como atalho na tela inicial, tag NFC, ação Tasker/automação ou:

```txt
adb shell am start -a android.intent.action.VIEW -d lifeupcloud://start
```

As mesmas URLs aparecem no cartão de status do Cloud — toque para copiar.

> [!NOTE]
> `lifeupcloud://` controla o próprio servidor HTTP do Cloud. Não é uma API de jogo `lifeup://api/…`.

<br/>

## Leitura de QR code :id=qr-code-scanning

O botão **Escanear** no topo do LifeUp Cloud lê a URL codificada em um QR code e a abre imediatamente — sem digitar manualmente.

A leitura **não se limita às APIs do LifeUp**: `lifeup://api/…`, páginas web `https://…` e esquemas de URL de outros apps (por exemplo, `weixin://`) também funcionam — o Android abre o destino correspondente.

### Como usar

1. Escolha uma URL do LifeUp ou da [lista de APIs](guide/api.md) do wiki (concluir Tarefa, iniciar pomodoro, abrir diálogos de compra/uso ou abrir uma página web externa).

2. Gere um QR code a partir da URL completa (imprima e cole em uma mesa, parede ou dispositivo).

3. Abra o LifeUp Cloud, toque em **Escanear** (toque em **?** ao lado para um guia curto no App) e aponte para o código.

### O que você pode fazer

| Cenário | Exemplo (ilustrativo) |
| --- | --- |
| Check-in Pomodoro | `lifeup://api/pomodoro?...` iniciar/parar timer |
| Check-in de Tarefa | `lifeup://api/complete?name=...` concluir Tarefa |
| Interação com a Loja | `lifeup://api/goto?page=shop` ou diálogos de compra/uso |
| Recompensa / penalidade | `lifeup://api/reward?...` / `lifeup://api/penalty?...` |
| Mini-jogo web | `https://wiki.lifeupapp.fun/en/example/wordle/index.html` |
| Outros apps | `weixin://`, `intent://` ou qualquer esquema de app instalado |
| Fluxos personalizados | Qualquer combinação de URL escaneável |

### Interação no mundo real

QR codes mapeiam **lugares ou ações físicas** para gamificação no App:

- Adesivo em **equipamento de academia** → escaneie para concluir Tarefa de treino de força

- Adesivo na **mesa de estudo** → escaneie para iniciar pomodoro de Foco

- Adesivo na **estação de trabalho** → escaneie para registrar stand-up ou code review

- Adesivo no **quadro de eventos** → escaneie para resgatar Recompensa ou abrir Conquista

Em resumo: **transforme esquemas de URL em gatilhos físicos escaneáveis**, com o LifeUp Cloud como executor entre o App e o mundo real.

<br/>

> [!NOTE]
> O LifeUp Cloud é uma ponte HTTP apenas na LAN. Como alcançar seu celular — endereço IP, roteador, firewall, mesma sub-rede, VPN ou isolamento de AP — depende da sua rede doméstica. Se não conseguir conectar, não podemos depurar sua LAN pessoal. Verifique sua própria rede, use ferramentas de rede padrão ou peça ajuda a um agente de IA.

## Definição da HTTP API :id=http-api-definition

> [!WARNING]
> A documentação de API nesta página pode ficar atrás das atualizações de implementação. Use o código-fonte como referência final: [KtorService.kt](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt)

### 1. API de invocação por esquema de URL

#### GET

Função:

> Invoca APIs que começam com `lifeup://api`.

URL da requisição:

```txt
// Recomendado: modo content provider (melhor compatibilidade)
http://{host:port}/api/contentprovider

// Modo startActivity (alguns dispositivos podem bloquear UI em segundo plano)
http://{host:port}/api
```

**Método: `GET`**

**Parâmetros de query:**

| Campo | Descrição | Local | Tipo | Obrigatório | Notas |
| --- | --- | --- | --- | --- | --- |
| url | URL da API começando com `lifeup://api` | Query | string | Sim | Codifique a URL ao construir manualmente. Vários parâmetros `url` são suportados. |

**Exemplos de requisição:**

```txt
// Chamada única (content provider)
http://{host:port}/api/contentprovider?url=YOUR_ENCODED_API_URL

// Chamada em lote
http://{host:port}/api/contentprovider?url=YOUR_ENCODED_API_URL_1&url=YOUR_ENCODED_API_URL_2

// Chamada única (startActivity)
http://{host:port}/api?url=YOUR_ENCODED_API_URL
```

<br/>

#### POST

Função:

> Invoca APIs que começam com `lifeup://api`.

URL da requisição:

```txt
// Recomendado: modo content provider (melhor compatibilidade)
http://{host:port}/api/contentprovider

// Modo startActivity (alguns dispositivos podem bloquear UI em segundo plano)
http://{host:port}/api
```

**Método: `POST`**

**Parâmetros do corpo JSON:**

| Campo | Descrição | Local | Tipo | Obrigatório | Notas |
| --- | --- | --- | --- | --- | --- |
| urls | Array de URLs começando com `lifeup://api` | Body | List<string> | Sim | Não é necessária codificação extra de URL no corpo JSON. |

**Exemplo de requisição:**

```txt
// POST
http://{host:port}/api/contentprovider

// Corpo JSON
{
  "urls": ["lifeup://api/goto?page=lab"]
}
```

<br/>

### 2. APIs de consulta de dados

> [!NOTE]
> Requisitos:
> 1. LifeUp v1.91+ e o LifeUp Cloud mais recente.
> 2. Conceda a permissão **Ler dados do LifeUp** no LifeUp Cloud.

Função:

> Consulta conjuntos completos de dados do LifeUp, como Tarefas e Itens.

**Endpoints de Tarefas**

```txt
// Todas as Tarefas
http://{host:port}/tasks

// Tarefas na categoria/lista ${id}
http://{host:port}/tasks/${id}

// Histórico (suporta paginação)
// gid é opcional e pode filtrar todo o histórico de uma Tarefa repetitiva
http://{host:port}/history?offset=${offset}&limit=${limit}&gid=${gid}

// Categorias de Tarefas
http://{host:port}/tasks_categories
```

**Endpoints de Itens**

```txt
// Todos os Itens
http://{host:port}/items

// Itens na categoria/lista ${id}
http://{host:port}/items/${id}

// Categorias de Itens
http://{host:port}/items_categories

// Incluir listas ocultas
http://{host:port}/items_categories?include_hidden=true
```

**Endpoints de Conquistas**

```txt
// Todas as Conquistas
http://{host:port}/achievements

// Conquistas na categoria/lista ${id}
http://{host:port}/achievements/${id}

// Categorias de Conquistas
http://{host:port}/achievement_categories
```

**Endpoints de Reflexões**

```txt
// Todas as Reflexões (suporta paginação)
http://{host:port}/feelings?offset=${offset}&limit=${limit}
```

**Endpoints de categorias de Síntese**

```txt
// Todas as categorias de Síntese
http://{host:port}/synthesis_categories

// Categorias de Síntese na lista ${id}
http://{host:port}/synthesis_categories/${id}
```

**Endpoints de receitas de Síntese**

```txt
// Todas as receitas de Síntese
http://{host:port}/synthesis

// Receitas de Síntese na categoria ${id}
http://{host:port}/synthesis/${id}
```

**Endpoints de Atributos**

```txt
// Todos os Atributos
http://{host:port}/skills
```


**Outros**

```txt
// Saldo de moedas
http://{host:port}/coin

// Versões do LifeUp / Cloud
http://{host:port}/info

// Registros de Pomodoro (paginados; intervalo de tempo opcional)
http://{host:port}/pomodoro_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}

// Diários (paginados; intervalo de tempo opcional). Linhas excluídas logicamente omitidas.
http://{host:port}/coin_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/inventory_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/exp_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/step_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/level_defines
http://{host:port}/statistics?time_range_start=${ms}&time_range_end=${ms}
// Todas as Conquistas (implementado; id de categoria opcional)
http://{host:port}/achievements

// Eventos de broadcast. LifeUp Labs → Eventos de broadcast desativado por padrão; Cloud Avançado pode mostrar status e ativar. GET data.broadcasts é essa chave (omitido se não lido). A configuração WebSocket do Cloud é apenas transporte.
http://{host:port}/events?after=${id}&limit=50

// Push WebSocket (ativado por padrão; configuração Cloud Push de eventos WebSocket)
ws://{host:port}/events?after=${id}
```

Envelope: `{ code, message, data }`. `200` indica apenas OK no transporte. `10001` LifeUp não em execução ou Ler dados não concedido. `10002` falha na consulta do ContentProvider.

### Valores de campos de lista

| Endpoint | Campo | Valores |
| --- | --- | --- |
| `/tasks` `/history` | `status` | `0` não concluída · `1` concluída · `2` atrasada · `3` desistida |
| `/tasks` | `frequency` | `0` uma vez · `1` diária · `N>1` a cada N dias · `-1` ilimitada · `-3` Ebbinghaus · `-4` mensal · `-5` anual |
| `/tasks` | `weekdays` | `1,3,5` (Seg=1 … Dom=7). Vazio quando não está no modo dias da semana. v1.106.0+ |
| `/tasks_categories` | `status` | `0` normal · `1` arquivada |
| `/tasks_categories` | `type` | `<10` normal · `10` diária · `11` semanal · `12` mensal · `20` em andamento |
| `/achievements` | `status` | `0` bloqueada · `1` desbloqueada, Recompensa não resgatada · `2` desbloqueada, resgatada |
| `/achievements` | `type` | `0` normal · `1` subcategoria |
| `/achievement_categories` | `type` | `0` usuário · `1` sistema |
| `/feelings` | `type` | `0` Tarefa · `1` Conquista · `2` bruta · `3` uso de Item |
| `/feelings` | `isFav` | bool (CP 0/1) |
| `/skills` | `type` | `0` usuário · `1` força · `2` aprendizado · `3` charme · `4` resistência · `5` vitalidade · `6` criativo |
| `/items_categories` | `hidden` / `inventoryHidden` | `0` visível · `1` oculta (flags independentes) |
| `/synthesis_categories` | `hidden` | `0` visível · `1` oculta |
| `/pomodoro_records` | `reward` | `0` abandonado · `0.5×n` metade · senão múltiplo completo |
| `/coin_records` `/inventory_records` | `resCode` | Loja: `0` comprar · `1` usar · `2` concluir Tarefa · `3` desfazer conclusão · `4` limpar · `5` desistir · `6` atraso · `7` desbloquear Conquista · `8` revogar desistência · `9` revogar atraso · `10` devolver · `11` concluir subtarefa · `12` desfazer subtarefa · `13` desbloquear Conquista de usuário · `14` desfazer Conquista de usuário · `15` depositar · `16` sacar · `17` vender tomates · `20` Item de Recompensa · `21` desfazer Item de Recompensa · `23` Síntese · `24` Caixa de saque · `25` juros ATM · `26` troca de tomate · `27` juros de crédito · `28` API · `29` efeito de ação |
| `/exp_records` | `resCode` | Pontos de Experiência (não Loja `28`): `0` desconhecido · `1` concluir · `2` Conquista · `3` troca de curtida · `4` sequência diária · `5` passos · `6` marcar concluída · `7` revogar desistência · `8` revogar atraso · `9` comer tomate · `10` Item usado · `11` desbloquear Conquista de usuário · `12` concluir subtarefa · `200` API · `101` desfazer conclusão · `102` desistir · `103` atraso · `104` débito de Item usado · `105` bloquear Conquista de usuário · `106` desfazer subtarefa |

`GET /items_categories`, `GET /synthesis_categories` e `GET /skill_groups` aceitam `include_hidden=true` (listas ocultas omitidas por padrão). Condições de desbloqueio de Conquista: `GET /achievement_conditions/{id}`. `status` de Habilidade (0 normal / 1 oculta) aparece apenas em `query`/`query_skill`, **não** em `GET /skills`.

**Método: `GET`**

**Parâmetros:**

| Campo | Descrição | Local | Tipo | Obrigatório | Notas |
| --- | --- | --- | --- | --- | --- |
| id | ID dos dados | Path/Query | Number | Sim (para endpoints específicos por ID) | - |
| offset | Deslocamento da consulta | Query | Number | Não | Obrigatório apenas em alguns endpoints paginados |
| limit | Tamanho da página | Query | Number | Não | Obrigatório apenas em alguns endpoints paginados |
| gid | Filtrar histórico de Tarefa repetitiva | Query | Number | Não | Opcional para consulta de histórico |
| include_hidden | Incluir listas ocultas | Query | Boolean | Não | Padrão false. Usado por `/items_categories`, `/synthesis_categories`, `/skill_groups` |
| time_range_start | Início do intervalo (ms) | Query | Number | Não* | Deve ser pareado com `time_range_end`. Intervalo parcial/inválido retorna `invalid_parameter` |
| time_range_end | Fim do intervalo (ms) | Query | Number | Não* | Deve ser maior que `time_range_start` |

**Exemplos de requisição**

**Tarefas**

```txt
// Todas as Tarefas
http://{host:port}/tasks

// Tarefas na lista ID 1
http://{host:port}/tasks/1

// Histórico (100 registros a partir do índice 0)
http://{host:port}/history?offset=0&limit=100

// Categorias de Tarefas
http://{host:port}/tasks_categories
```

**Itens**

```txt
// Todos os Itens
http://{host:port}/items

// Consultar IDs específicos de Itens 1 e 4
http://{host:port}/items?id=1&id=4

// Itens na lista ID 1
http://{host:port}/items/1

// Categorias de Itens
http://{host:port}/items_categories
```

**Conquistas**

```txt
// Conquistas na lista/categoria ${id}
http://{host:port}/achievements/${id}

// Categorias de Conquistas
http://{host:port}/achievement_categories
```

**Reflexões**

```txt
// 100 registros a partir do índice 0
http://{host:port}/feelings?offset=0&limit=100
```

**Atributos**

```txt
http://{host:port}/skills
```

**Categorias de Síntese**

```txt
http://{host:port}/synthesis_categories
http://{host:port}/synthesis_categories/1
```

**Receitas de Síntese**

```txt
http://{host:port}/synthesis
http://{host:port}/synthesis/1
```

<br/>

### 3. API de imagem/arquivo

> [!NOTE]
> Devido a restrições de armazenamento do Android, o LifeUp Cloud pode precisar criar uma cópia do arquivo ao servir conteúdo de imagem do LifeUp.

Função:

> Carrega recursos de imagem/arquivo retornados pelas APIs de dados (tipicamente `content://...`).

URL da requisição:

```txt
http://{host:port}/files/${url}
```

**Método: `GET`**

**Parâmetros de path:**

| Campo | Descrição | Local | Tipo | Obrigatório | Notas |
| --- | --- | --- | --- | --- | --- |
| url | URL do arquivo | Path | String | Sim | - |

**Exemplo de requisição:**

```txt
http://{host:port}/files/xxx
```

<br/>

### 4. Consultas ContentProvider de Habilidades

> [!NOTE]
> Requer v1.103.0+

Para consultas de lista ou estruturadas, você pode ler os seguintes URIs ContentProvider via o endpoint `http://{host:port}/api/contentprovider`.

#### `content://net.sarasarasa.lifeup.provider.api/skills`

Retorna apenas Habilidades visíveis.

| Coluna | Significado | Tipo | Notas |
| ------ | ------- | ---- | ----- |
| _ID | ID da Habilidade | number | - |
| name | Nome da Habilidade | string | - |
| desc | Descrição | string | Pode estar vazia |
| icon | URI do ícone | string | Pode estar vazia |
| order | Ordem bruta | number | `orderInCategory` |
| group_id | ID do grupo de Habilidades | number / null | Pode estar vazio quando a Habilidade não está em um grupo |
| color | Cor | number / null | Pode estar vazia |
| exp | Pontos de Experiência | number | - |
| level | Nível atual | number | - |
| until_next_level_exp | Pontos de Experiência até o próximo nível | number | - |
| current_level_exp | Pontos de Experiência ganhos no nível atual | number | - |
| type | Tipo de Habilidade | number | - |
| status | Status da Habilidade | number | `0` = normal, `1` = oculta |

#### `content://net.sarasarasa.lifeup.provider.api/skill_groups`

Retorna apenas grupos de Habilidades visíveis.

| Coluna | Significado | Tipo | Notas |
| ------ | ------- | ---- | ----- |
| _ID | ID do grupo de Habilidades | number | - |
| content | Nome do grupo | string | - |
| order | Ordem bruta | number | `orderInCategory` |
| collapsed | Estado de recolhimento | string | Retornado como texto `true` / `false` |

<br/>

## Contribuição

O SDK, o LifeUp Cloud e o LifeUp Desktop são todos projetos de código aberto.

Você pode obter o código-fonte em:

- [Ayagikei/LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop](https://github.com/Ayagikei/LifeUp-Desktop)
