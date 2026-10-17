# Referência da API HTTP :id=http-query-reference

Use esta referência para os parâmetros de requisição do LifeUp Cloud e os modelos completos de resposta HTTP. Para instalação, autorização e conexão, comece por [LifeUp Cloud](/guide/api_cloud). Os endpoints de registros mais recentes exigem LifeUp **1.106.0+** e LifeUp Cloud **3.0.0+**; use `/info` para identificar as versões instaladas. Esta referência descreve os contratos do código-fonte atual, sem comprovar a disponibilidade em uma versão específica.

## Índice de interfaces :id=interface-index

| Recurso | Métodos e caminhos | Parâmetros e modelo |
| --- | --- | --- |
| Regras comuns | Respostas JSON, autorização, condições de cache, paginação | [Convenções](#representations), [cache e autorização](#auth-cache), [paginação](#pagination) |
| Tarefas | `GET /tasks`, `GET /tasks/{categoryId}`, `GET /tasks_categories` | [Consultas](#get-tasks), [modelo de tarefa](#task-fields), [categorias](#get-tasks-categories) |
| Histórico de tarefas | `GET /history` | [Parâmetros](#get-history), [datas e horas](#task-times), [relatórios diários](#daily-report) |
| Itens | `GET /items`, `GET /items/{listId}`, `GET /items_categories` | [IDs de itens, IDs de categorias e modelos completos](#get-items) |
| Atributos | `GET /skills`, `GET /skill_groups` | [Atributos e grupos](#get-skills) |
| Conquistas | `GET /achievements`, `GET /achievements/{id}`, `GET /achievement_categories`, `GET /achievement_conditions/{id}` | [Conquistas e condições](#get-achievements) |
| Síntese | `GET /synthesis`, `GET /synthesis/{id}`, `GET /synthesis_categories`, `GET /synthesis_categories/{id}` | [Receitas e categorias](#get-synthesis) |
| Sentimentos | `GET /feelings` | [Sentimentos paginados](#get-feelings) |
| EXP / moedas | `GET /exp_records`, `GET /coin_records` | [Parâmetros e modelos dos registros](#reward-journals) |
| Outros registros | `GET /pomodoro_records`, `GET /inventory_records`, `GET /step_records` | [Pomodoro](#get-pomodoro-records), [inventário](#get-inventory-records), [passos](#get-step-records) |
| Níveis / estatísticas | `GET /level_defines`, `GET /statistics` | [Níveis](#get-level-defines), [estatísticas](#get-statistics) |
| App / saldo | `GET /info`, `GET /coin` | [Informações de versão](#get-info), [resultado de moedas](#get-coin) |
| Invocar ações | `GET` / `POST /api`, `GET` / `POST /api/contentprovider` | [Ponte de invocação](#invoke-api); os métodos de negócio estão no [catálogo de URL Schemes](/guide/api) |
| Arquivos / backups | `GET /files/{url}`, `POST /files/upload`, `GET /data/export`, `POST /data/import` | [Arquivos](#files-download), [transferência de backups](#files-backup) |
| Eventos | `GET /events`, WebSocket `/events` | [Consulta periódica e eventos em tempo real](#get-events) |
| Página inicial | `GET /` | Apresentação em HTML, não um recurso JSON. |

O MCP usa uma representação própria de cliente/ferramenta; veja [diferenças do MCP](#mcp-differences) e o [guia do MCP](/guide/api_mcp).

## Transporte e representação :id=representations

| Interface | Representação | Diferença importante |
| --- | --- | --- |
| Consultas HTTP do Cloud | JSON encapsulado em `{code, message, data}` | As referências de endpoints abaixo descrevem esse JSON público. |
| ContentProvider do Android | Colunas Cursor, como `_ID` / `_GID`, às vezes contendo texto JSON | O analisador do SDK as converte em campos HTTP como `id` / `gid` e arrays aninhados. Não use as definições de colunas Cursor como esquema HTTP. |
| Ações por URL Scheme | `lifeup://api/{method}` e parâmetros/resultados específicos do método | Os parâmetros de escrita podem usar snake_case mesmo quando os campos de leitura HTTP usam camelCase. |
| Ferramentas de listagem MCP | Envelope específico da ferramenta e registros compactos ou detalhados | A paginação e os campos de saída MCP são comportamentos adicionais do cliente, não campos de resposta HTTP. |

## Resposta e erros :id=response-errors

O envelope JSON HTTP comum é `HttpResponse<T>`:

| Campo | Tipo | Significado |
| --- | --- | --- |
| `code` | integer | `200` para uma consulta bem-sucedida; um valor diferente de `200` indica erro. Este é um campo do corpo, separado do status HTTP. |
| `message` | string | Geralmente `success` em caso de sucesso; uma descrição do erro nos demais casos. |
| `data` | `T` or `null` | Valor específico do endpoint (array, objeto ou string) em caso de sucesso; `null` em caso de erro. |

Exemplo de uma lista vazia retornada com sucesso:

```json
{"code":200,"message":"success","data":[]}
```

Exemplo ilustrativo de erro de permissão/acesso ao provedor:

```json
{"code":10001,"message":"Cursor is null, check if LifeUp is installed and running and you have granted the permission","data":null}
```

| Sinal | Como tratar |
| --- | --- |
| HTTP `401` | Forneça o token configurado do Cloud diretamente como valor do cabeçalho `Authorization`. Não adicione `Bearer`. |
| Corpo `code = 10001` | Verifique se o LifeUp está instalado/em execução e se o Cloud tem a permissão Read LifeUp Data. |
| Corpo `code = 10002` | A consulta ao ContentProvider falhou; examine a mensagem de erro. |
| Outro status/código sem sucesso | Trate a consulta como falha, não como resultado vazio. |

Verifique **tanto** o status HTTP quanto o `code` do corpo. Algumas falhas de rotas ainda usam HTTP `200` com um código de erro no corpo. Ações por `/api/contentprovider` também exigem verificar cada `data[].result.api_result`; o `code=200` do envelope não comprova que todas as ações tiveram sucesso.

## Autorização e leituras condicionais :id=auth-cache

Quando houver um token do Cloud configurado, envie seu valor exato em `Authorization`, sem prefixo `Bearer`. O servidor também aceita o parâmetro de consulta `token`, inclusive para clientes que não podem definir um cabeçalho WebSocket. Token ausente ou incorreto produz HTTP `401` e `code=401` no corpo. Essa verificação abrange página inicial, recursos, ponte, arquivos, transferência de backups e eventos.

Leituras bem-sucedidas de recursos JSON incluem um `ETag` forte SHA-256 e `Cache-Control: private, no-cache`. Isso se aplica a tarefas/histórico, itens/categorias, atributos/grupos, conquistas/condições, sentimentos, síntese/categorias, registros, níveis, estatísticas, informações e moedas. Não se aplica à ponte de invocação, transferência de arquivos/backups ou fluxos/consulta periódica de eventos.

| Cabeçalho da requisição | Comportamento atual da resposta |
| --- | --- |
| `If-Match` | Uma versão que não corresponde falha com HTTP `412`; avaliado antes de `If-None-Match`. |
| `If-None-Match` | Uma versão correspondente retorna HTTP `304`, sem corpo JSON para analisar. Reutilize a representação bem-sucedida em cache. |

Envelopes de erro não têm cabeçalho de versão do recurso. Leituras condicionais valem por requisição de recurso, sem criar snapshot ou transação entre páginas ou rotas.

Requisições de navegador entre origens podem usar `If-None-Match`. A configuração CORS atual não permite `If-Match` no preflight; não dependa dessas requisições entre origens sem alterar a implementação. Clientes nativos não estão sujeitos ao CORS do navegador.

## Convenções comuns de dados :id=data-conventions

| Convenção | Regra |
| --- | --- |
| Tempo | Os campos de data e hora usam milissegundos Unix. Os limites de dias do calendário dependem do fuso horário pretendido. Cada campo mantém um significado específico do recurso. |
| Identidade | O `id` da tarefa identifica uma tarefa/ciclo; seu `gid` identifica o grupo ao longo de ciclos repetidos. Um ID de categoria/lista identifica um recurso separado. |
| Valores vazios | Ausência, `null`, `0`, `""` e `[]` são distintos. Cada modelo documenta seu comportamento real de valor alternativo ou omissão. |
| IDs numéricos | IDs podem ser inteiros de 64 bits com sinal; um Number de JavaScript não representa exatamente todos os valores. Preserve IDs grandes com um parser JSON adequado. |
| Arrays e objetos | Valores HTTP aninhados como `items` e `subTasks` são arrays, não strings contendo JSON. |
| Códigos de estado e motivo | Use a enumeração documentada para aquele recurso. Estados de tarefas, estados de conquistas e motivos dos registros pertencem a domínios diferentes. |

Veja as [definições de data e hora das tarefas](/guide/api-reference?id=task-times) para `startTime`, `deadline` e `endTime`.

## Paginação e filtros :id=pagination

A paginação é uma capacidade do endpoint, não uma propriedade de toda lista. Respostas HTTP brutas de listas contêm `data: [...]`; **não** acrescentam `total`, `count` ou `hasMore`.

| Endpoint HTTP | Paginação | Intervalo de datas | Outros filtros |
| --- | --- | --- | --- |
| `/tasks`, `/tasks/{categoryId}` | Não; array completo | Não | Categoria opcional no caminho |
| `/history` | `offset` / `limit` no servidor | Não | `gid` opcional |
| `/feelings` | `offset` / `limit` no servidor | Não | Veja [sentimentos](#get-feelings) |
| `/pomodoro_records`, `/coin_records`, `/inventory_records`, `/exp_records`, `/step_records` | `offset` / `limit` no servidor | `time_range_start` / `time_range_end` | Veja as seções específicas de cada endpoint abaixo |
| `/statistics` | Não; um objeto | `time_range_start` / `time_range_end` | Consulta agregada |
| `/coin`, `/info` | Não; um objeto | Não | Consulta de recurso único |

Para endpoints paginados, os padrões HTTP são `offset=0` e `limit=100`. Use deslocamentos não negativos e tamanhos de página em `1..100` para um ciclo de paginação compartilhado. A ponte HTTP não aplica o limite `1..100` do MCP, e os provedores posteriores podem impor outros limites; consulte as notas de tamanho efetivo da página e validação de cada endpoint.

Exceto pela [limitação de Pomodoro filtrado por tempo](#get-pomodoro-records), após cada página bem-sucedida, avance `offset` pelo número de registros retornados. Pare quando esse número for menor que o tamanho efetivo da página (o `limit` solicitado ao usar `1..100`, excluindo Pomodoro filtrado por tempo). Não confunda uma página limitada pelo provedor com a última página. Uma página vazia após o fim é normal. Consultar várias páginas não cria um snapshot: os registros podem mudar durante a consulta.

No SDK HTTP atual, os limites de data só são encaminhados quando **ambos** podem ser interpretados como inteiros e `start < end`. Um limite isolado, ilegível ou invertido resulta em consulta sem filtro; não dependa de um erro para detectar isso. Valide ambos os limites antes de enviar. A referência dos registros informa o comportamento inclusivo dos limites dos seus endpoints.

## Diferenças do MCP :id=mcp-differences

As ferramentas de listagem MCP usam `limit=20` por padrão, limitam esse valor a `1..100` e impõem a `offset` um mínimo de `0`. Enviam paginação para recursos paginados pelo servidor, como histórico/registros, mas buscam os arrays HTTP completos e os recortam localmente para recursos como tarefas. Seus `items`, `count`, `hasMore` e `total` opcional pertencem ao envelope MCP. `detail=false` também remove campos de cada registro; use `detail=true` quando precisar do modelo HTTP completo.

## Fontes e escopo de versões :id=api-common-sources

Estas referências descrevem o SDK público atual e o comportamento correspondente do provedor do LifeUp. Os exemplos usam dados inventados. Os links de código são referências de implementação, não prova de que determinada versão instalada contenha todos os campos: [rotas HTTP](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt), [envelope HTTP](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/vo/HttpResponse.kt), [mapeamento de consultas MCP](https://github.com/Ayagikei/LifeUp-SDK/blob/main/mcp/src/query.ts).


## Modelos de dados de tarefas e histórico :id=task-history-models

Esta página define o **JSON HTTP** retornado pelas [consultas de tarefas/histórico](/guide/api-reference?id=task-queries). As colunas Cursor do Android e os parâmetros de ações por URL Scheme podem ter nomes e representações diferentes; veja as [convenções comuns](/guide/api-reference?id=representations).

O SDK usa uma única classe serializada `Task` para duas visualizações. Aqui, `Task` nomeia a visualização `/tasks` e `HistoryRecord` nomeia a visualização `/history`. Esses nomes descrevem a saída existente; não introduzem outra API. A serialização atual do Cloud inclui valores padrão e campos `null`.

### Campos de Task / HistoryRecord :id=task-fields

Todos os campos abaixo aparecem no objeto HTTP atual. Valores ausentes no provedor são frequentemente convertidos nos valores alternativos listados; um valor alternativo não comprova que os dados de origem continham esse valor.

| Campo | Tipo JSON | Significado / valor alternativo |
| --- | --- | --- |
| `id` | integer or `null` | ID desta tarefa/ciclo. |
| `gid` | integer or `null` | ID do grupo de tarefas compartilhado entre ciclos repetidos. |
| `name` | string | Nome da tarefa. Um nome ausente no provedor se torna `ERROR: name is null`. |
| `notes` | string | Notas; string vazia se ausentes. |
| `status` | integer | Estado da tarefa; valor padrão `0` se ausente. Veja a tabela de estados abaixo. |
| `startTime` | integer | Hora de início configurada em milissegundos; valor alternativo do SDK `0`. |
| `deadline` | integer | Prazo em milissegundos; valor alternativo do SDK `0` se ausente. |
| `remindTime` | integer | Hora do lembrete em milissegundos; valor alternativo do SDK `0` se ausente. |
| `frequency` | integer | Código de recorrência; `0` uma vez, `1` diariamente, `-1` ilimitado. Outros modos são descritos em [ações de tarefas](/guide/api). Valor alternativo do SDK `0`. |
| `weekdays` | string | Seleção de dias da semana, por exemplo `1,3,5` (segunda-feira `1`, domingo `7`); vazio quando não fornecido e sempre um campo vazio de preenchimento no histórico. |
| `exp` | integer | Recompensa EXP configurada, não o valor de uma transação; padrão `0`. |
| `skillIds` | integer array | Atributos associados à recompensa; array vazio se indisponíveis. |
| `coin` | integer | Recompensa em moedas configurada; padrão `0`. |
| `coinVariable` | integer | Configuração de recompensa em moedas aleatórias; padrão `0`. |
| `itemId` | integer | ID do primeiro item de recompensa no formato antigo; padrão `0`. Use `items` para a lista completa. |
| `itemAmount` | integer | Quantidade do primeiro item de recompensa no formato antigo; padrão `0`. Este nome HTTP difere da coluna `itemCount` do provedor. |
| `words` | string | Texto de incentivo à conclusão; vazio se ausente. |
| `categoryId` | integer | ID da categoria/lista da tarefa; padrão `0` se ausente. |
| `order` | integer | Valor de ordenação na lista de tarefas; preenchimento fixo `0` no histórico porque esse provedor não retorna a coluna. |
| `nameExtended` | string | Nome de exibição estendido; preenchimento sempre vazio no histórico porque esse provedor não retorna a coluna. |
| `endTime` | integer | Hora de término registrada para o histórico. `/tasks` preenche este campo com `0`; veja a [semântica dos horários](/guide/api-reference?id=task-times). |
| `items` | `RewardItem[]` | Recompensas em itens; array vazio se indisponíveis. |
| `subTasks` | `SubTask[]` | Subtarefas aninhadas; array vazio se indisponíveis. |
| `countProgress` | `TaskCountProgress` or `null` | Retrato do progresso de contagem quando disponível; pode aparecer em ambas as visualizações. |
| `repeatEndCondition` | `TaskRepeatEndCondition` or `null` | Regra de encerramento de repetição em `/tasks`; sempre `null` em `/history`. |

### Estado e horários das tarefas :id=task-times

| `status` | Significado | Significado de `endTime` no histórico |
| --- | --- | --- |
| `0` | Não concluída | Não é uma hora de conclusão; `/history` seleciona registros encerrados. |
| `1` | Concluída | Hora de conclusão registrada. |
| `2` | Atrasada | Hora de atraso registrada. |
| `3` | Abandonada | Hora de desistência registrada. |

| Campo de horário | Definição |
| --- | --- |
| `startTime` | A hora de início configurada/programada da tarefa, não quando o usuário realmente começou a trabalhar. |
| `deadline` | O prazo programado, separado da hora de término registrada. |
| `endTime` | A hora registrada em que a tarefa do histórico terminou; interprete com `status` conforme acima. |

Os três usam milissegundos Unix. Na conclusão normal, o app registra a hora atual. `history_operation` com `operation=edit_completed_time` recebe `completed_time` e edita essa mesma hora de conclusão salva; a leitura do histórico continua retornando o campo com o nome `endTime`.

Os horários salvos podem ser editados. Se um registro encerrado não tiver uma data de término salva, o app usa a hora atual. Portanto, `endTime` é o horário atualmente registrado, não um carimbo imutável de auditoria. `0` em `/tasks` é apenas um preenchimento do SDK, não um evento real na época Unix.

### RewardItem :id=reward-item

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `itemId` | integer | ID do item de recompensa. |
| `itemCount` | integer | Quantidade da recompensa. |

```json
{"itemId":7,"itemCount":1}
```

### SubTask :id=subtask

| Campo | Tipo JSON | Significado / padrão |
| --- | --- | --- |
| `id` | integer | ID da subtarefa. |
| `gid` | integer | ID do grupo de subtarefas. |
| `todo` | string | Texto da subtarefa. |
| `status` | integer | `0` não concluída, `1` concluída. |
| `remindTime` | integer or `null` | Data e hora do lembrete em milissegundos; `null` se indisponível. |
| `endTime` | integer or `null` | Data e hora de conclusão da subtarefa em milissegundos; `null` se indisponível. |
| `exp` | integer | Recompensa EXP configurada. |
| `coin` | integer or `null` | Recompensa em moedas configurada. |
| `coinVariable` | integer or `null` | Configuração de recompensa em moedas aleatórias. |
| `items` | `RewardItem[]` | Recompensas em itens; array vazio por padrão. |
| `order` | integer or `null` | Valor de ordenação; padrão do modelo `0`. |
| `autoUseItem` | boolean or `null` | Se as recompensas são usadas automaticamente; padrão do modelo `false`. |

```json
{
  "id":201,"gid":20,"todo":"Read ten pages","status":1,
  "remindTime":null,"endTime":1792072800000,"exp":2,
  "coin":0,"coinVariable":0,"items":[{"itemId":7,"itemCount":1}],
  "order":0,"autoUseItem":false
}
```

### TaskCountProgress :id=count-progress

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `currentCount` | integer | Contagem atual para esta tarefa/ciclo. |
| `targetCount` | integer | Contagem desejada para esta tarefa/ciclo. |

```json
{"currentCount":2,"targetCount":5}
```

### TaskRepeatEndCondition :id=repeat-end-condition

| Campo | Tipo JSON | Significado / padrão |
| --- | --- | --- |
| `mode` | string | `COUNT` ou `DATE`. São strings de leitura, não os parâmetros numéricos de ações. |
| `behavior` | string | `TERMINATE` ou `FREEZE`. |
| `targetCycleCount` | integer or `null` | Meta de número de ciclos para `COUNT`; padrão `null`. |
| `endDateMillis` | integer or `null` | Data e hora de término em milissegundos para `DATE`; padrão `null`. |
| `inclusive` | boolean | Indicador de inclusão da data de término; padrão `false`. |

```json
{"mode":"COUNT","behavior":"TERMINATE","targetCycleCount":10,"endDateMillis":null,"inclusive":false}
```

### Valores das recompensas :id=reward-amounts

Estes campos de tarefas e subtarefas descrevem recompensas configuradas. Multiplicadores, moedas aleatórias e regras de liquidação podem alterar a recompensa real. Use os [registros EXP e moedas](/guide/api-reference?id=reward-journals) para os valores de transações e diferencie recompensas positivas de alterações líquidas que incluem estornos ou penalidades.

### Referências de implementação :id=api-task-model-sources

[Task](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/Task.kt) · [Analisador](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TasksApi.kt) · [SubTask](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/SubTask.kt) · [RewardItem](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/common/RewardItem.kt) · [Progresso de contagem](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TaskCountProgress.kt) · [Regra de repetição](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TaskRepeatEndCondition.kt).


## Consultas de tarefas e histórico :id=task-queries

Leia as [convenções comuns](/guide/api-reference?id=http-query-reference) e o [modelo completo de Task/History](/guide/api-reference?id=task-history-models). Estes endpoints exigem a permissão Read LifeUp Data do Cloud. As consultas básicas de listas são documentadas para LifeUp v1.91+ com o Cloud mais recente; os exemplos descrevem os campos do SDK atual. Verifique `/info` ao integrar instalações mais antigas.

### GET /tasks e /tasks/{categoryId} :id=get-tasks

Consulte a lista atual de tarefas **não concluídas**, opcionalmente restrita a uma categoria/lista. O resultado é um array completo, não uma resposta paginada pelo servidor. Registros concluídos, atrasados e abandonados pertencem a `/history`.

| Parâmetro | Local | Tipo | Obrigatório | Padrão / comportamento |
| --- | --- | --- | --- | --- |
| `categoryId` | Caminho | integer | Apenas para `/tasks/{categoryId}` | Omita todo o segmento do caminho para a lista de tarefas sem restrições. |

Estas rotas não oferecem parâmetros de consulta `offset`, `limit`, `gid` ou intervalo de datas. Um segmento de categoria que não seja inteiro é atualmente interpretado como categoria ausente; valide-o antes da requisição para evitar consultar todas as tarefas por acidente.

```text
GET http://{host:port}/tasks
GET http://{host:port}/tasks/1
```

**Resposta:** `HttpResponse<Task[]>`. Todos os campos e estruturas aninhadas estão definidos em [campos Task/History](/guide/api-reference?id=task-fields). O registro inventado a seguir mostra a estrutura HTTP completa no nível superior; `endTime=0` é um preenchimento para esta rota, não uma data e hora de conclusão.

```json
{
  "code": 200,
  "message": "success",
  "data": [{
    "id": 101, "gid": 10, "name": "Read a chapter", "notes": "",
    "status": 0, "startTime": 1792108800000, "deadline": 1792195199999,
    "remindTime": 0, "frequency": 1, "weekdays": "",
    "exp": 5, "skillIds": [2], "coin": 10, "coinVariable": 0,
    "itemId": 0, "itemAmount": 0, "words": "", "categoryId": 1,
    "order": 0, "nameExtended": "Read a chapter", "endTime": 0,
    "items": [], "subTasks": [], "countProgress": null,
    "repeatEndCondition": null
  }]
}
```

**Comportamento e erros:** a seleção/ordenação segue a lógica da lista de tarefas do LifeUp; este endpoint não promete ordenação pela hora de conclusão. Um `data: []` bem-sucedido significa que a lista selecionada não retornou registros. Falhas de permissão/provedor usam o [envelope comum de erros](/guide/api-reference?id=response-errors); não são arrays vazios. Para relatórios de conclusão, use `/history` abaixo em vez de `endTime` desta rota.

### GET /history :id=get-history

Consulte os registros visíveis de tarefas encerradas, incluindo tarefas concluídas, atrasadas e abandonadas. O histórico excluído é omitido.

| Parâmetro | Local | Tipo | Obrigatório | Padrão / comportamento |
| --- | --- | --- | --- | --- |
| `offset` | Consulta | integer | Não | `0`; número de registros a pular, com índice inicial zero. |
| `limit` | Consulta | integer | Não | `100`; solicite um tamanho de página positivo, de preferência `1..100`. |
| `gid` | Consulta | integer | Não | Sem filtro de grupo; quando presente, seleciona esse grupo de tarefas ao longo dos ciclos. |

O analisador HTTP usa `0` / `100` para `offset` / `limit` ilegíveis e descarta um `gid` ilegível. Esta rota não limita os números analisados. Valide por conta própria os deslocamentos não negativos e limites positivos. `time_range_start` / `time_range_end` **não são suportados**; fornecê-los não filtra o histórico.

```text
GET http://{host:port}/history?offset=0&limit=100
GET http://{host:port}/history?offset=0&limit=100&gid=10
```

**Resposta:** `HttpResponse<HistoryRecord[]>`, usando os [campos de transporte de Task/History](/guide/api-reference?id=task-fields). `HistoryRecord` é o nome usado na documentação para a visualização de histórico do modelo `Task` do SDK. `repeatEndCondition` é `null` nesta visualização; `countProgress` pode estar presente. O `endTime` salvo é interpretado com `status`.

```json
{
  "code": 200,
  "message": "success",
  "data": [{
    "id": 100, "gid": 10, "name": "Read a chapter", "notes": "",
    "status": 1, "startTime": 1792022400000, "deadline": 1792108799999,
    "remindTime": 0, "frequency": 1, "weekdays": "",
    "exp": 5, "skillIds": [2], "coin": 10, "coinVariable": 0,
    "itemId": 0, "itemAmount": 0, "words": "", "categoryId": 1,
    "order": 0, "nameExtended": "", "endTime": 1792072800000,
    "items": [], "subTasks": [], "countProgress": null,
    "repeatEndCondition": null
  }]
}
```

**Ordenação:** data de término salva em ordem decrescente, mais recente primeiro. Não há critério de desempate documentado para datas de término iguais. A paginação não é um retrato fixo dos dados; evite editá-los durante a coleta do relatório e remova duplicatas por `id` ao combinar páginas.

**Paginação e resultados vazios:** use o [procedimento compartilhado de paginação](/guide/api-reference?id=pagination). Um array vazio bem-sucedido significa que nenhum registro visível correspondeu à página/grupo, inclusive quando `offset` está após o fim. Não comprova que nunca houve atividade: registros excluídos são omitidos e não há indicador de completude. Se alguma requisição falhar, informe dados indisponíveis/incompletos em vez de zero tarefas. Aplicam-se os [erros comuns](/guide/api-reference?id=response-errors).

### Criar um relatório diário :id=daily-report

1. Escolha o fuso horário do relatório. Calcule o início do dia do calendário (`dayStart`) e o início do dia seguinte (`nextDayStart`). Não presuma que todo dia local tenha exatamente 24 horas.
2. Leia `/history` com `offset=0&limit=100`, verifique cada resposta e colete todas as páginas. Mantenha consistente qualquer filtro `gid` pretendido.
3. Selecione `status == 1` e `dayStart <= endTime < nextDayStart`. Considere as [limitações dos horários registrados](/guide/api-reference?id=task-times) ao descrever os resultados.
4. Para alterações reais de EXP e moedas, leia os [registros de recompensas](/guide/api-reference?id=reward-journals) do mesmo dia. Seus filtros de data incluem ambos os extremos, então use `time_range_start=dayStart` e `time_range_end=nextDayStart-1`.
5. Diferencie “nenhum registro encontrado nos dados disponíveis” de uma leitura com falha/incompleta. Decida se o relatório mostra apenas recompensas positivas ou alterações líquidas incluindo estornos e aplique essa escolha de modo consistente.

Os campos `exp` e `coin` de tarefas/histórico são recompensas configuradas; não substituem de forma confiável os valores registrados. Uma hora de conclusão editada para outro dia não implica que a hora da transação do registro de recompensas mudou junto.

### Referências de implementação :id=api-task-queries-sources

[Rotas HTTP](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt) · [Análise de tarefas e histórico](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TasksApi.kt).


## Consultas de registros EXP e moedas :id=reward-journals

Estes endpoints HTTP de somente leitura exigem a permissão Read LifeUp Data, LifeUp **1.106.0+** e LifeUp Cloud **3.0.0+**. Retornam as alterações registradas, incluindo reduções e estornos, em vez da configuração de recompensas das tarefas. Leia primeiro as [convenções comuns](/guide/api-reference?id=http-query-reference).

### Parâmetros de requisição dos dois endpoints :id=journal-parameters

O contrato a seguir se aplica especificamente a **ambos** `GET /exp_records` e `GET /coin_records`.

| Parâmetro | Local | Tipo | Obrigatório | Padrão / comportamento real |
| --- | --- | --- | --- | --- |
| `offset` | Consulta | integer | Não | Padrão HTTP `0`; o provedor ajusta valores negativos para `0`. |
| `limit` | Consulta | integer | Não | Padrão HTTP `100`; o provedor limita a `1..200`. Use `1..100` para o procedimento compartilhado de paginação. |
| `time_range_start` | Consulta | integer (Unix milliseconds) | Não, ou em par | Limite inferior inclusivo do horário registrado da transação. |
| `time_range_end` | Consulta | integer (Unix milliseconds) | Não, ou em par | Limite superior inclusivo; um filtro válido exige `start < end`. |

Valores de paginação ilegíveis ou fora do intervalo usam os padrões HTTP. Datas ilegíveis são tratadas como ausentes. O SDK atual só encaminha um intervalo quando os dois limites existem e `start < end`; caso contrário, consulta **sem filtro de data**. Chamadas brutas diretas ao ContentProvider validam intervalos inválidos de outra forma. Valide os limites no chamador HTTP.

Os dois endpoints ordenam pela hora registrada da transação em ordem decrescente, mais recente primeiro, e excluem entradas eliminadas. Não prometem desempate por ID nem um retrato fixo entre páginas. Siga a [paginação](/guide/api-reference?id=pagination), considerando o limite efetivo do provedor. Um array vazio bem-sucedido significa que nenhuma entrada corresponde ao intervalo/página; uma leitura com falha não equivale a zero atividade. Nenhum endpoint fornece um indicador de completude para dados excluídos ou indisponíveis.

### GET /exp_records :id=get-exp-records

Consulte alterações de EXP. Os parâmetros são exatamente os [quatro parâmetros de registros acima](/guide/api-reference?id=journal-parameters); não há filtro `gid`.

```text
GET http://{host:port}/exp_records?offset=0&limit=100&time_range_start=1792022400000&time_range_end=1792108799999
```

**Resposta:** `HttpResponse<ExpRecord[]>`. A serialização atual inclui todos os campos listados, inclusive os valores anuláveis.

| Campo | Tipo JSON | Significado / valor alternativo do analisador |
| --- | --- | --- |
| `id` | integer or `null` | ID da entrada do registro. |
| `time` | integer or `null` | Hora da transação em milissegundos Unix, distinta da hora editável de conclusão de uma tarefa. |
| `value` | integer | Alteração de EXP por atributo associado; valor alternativo `0`. Use `isDecrease` para a direção. |
| `isDecrease` | boolean | `true` para redução, `false` para aumento; o analisador trata o inteiro `1` do provedor como true. |
| `totalValue` | integer | Alteração agregada de EXP registrada, **não um saldo de EXP**; valor alternativo `0`. Lotes de vários atributos podem se sobrepor nesse total armazenado; veja os [totais dos relatórios](/guide/api-reference?id=journal-totals). |
| `resCode` | integer | Código de motivo específico de EXP; valor alternativo `0`. |
| `relatedId` | integer or `null` | ID do objeto de origem relacionado. Na conclusão normal de tarefa, é o `id` do registro da tarefa, não seu `gid`. Outros motivos podem se referir a outros recursos. |
| `content` | string or `null` | Descrição da alteração. |
| `skillIds` | integer array | IDs dos atributos/habilidades associados; array vazio como alternativa. |
| `relatedAttributes` | string array | Strings antigas dos atributos associados; array vazio como alternativa. |

Exemplo inventado: 10 EXP aplicados a cada um de dois atributos, 20 EXP no total.

```json
{
  "code":200,"message":"success","data":[{
    "id":301,"time":1792072800000,"value":10,"isDecrease":false,
    "totalValue":20,"resCode":1,"relatedId":100,"content":"Task completed",
    "skillIds":[2,3],"relatedAttributes":[]
  }]
}
```

**Erros:** [erros comuns HTTP/provedor](/guide/api-reference?id=response-errors). Limites HTTP de data inválidos podem remover silenciosamente o filtro, conforme explicado acima, em vez de produzir erro.

### GET /coin_records :id=get-coin-records

Consulte alterações de moedas. Os parâmetros são exatamente os [quatro parâmetros de registros acima](/guide/api-reference?id=journal-parameters); não há filtro `gid`.

```text
GET http://{host:port}/coin_records?offset=0&limit=100&time_range_start=1792022400000&time_range_end=1792108799999
```

**Resposta:** `HttpResponse<CoinRecord[]>`. A serialização atual inclui todos os campos listados, inclusive os valores anuláveis.

| Campo | Tipo JSON | Significado / valor alternativo do analisador |
| --- | --- | --- |
| `id` | integer or `null` | ID da entrada do registro. |
| `time` | integer or `null` | Hora da transação em milissegundos Unix. |
| `value` | integer | Valor da alteração de moedas; valor alternativo `0`. Use `isDecrease` para a direção. |
| `isDecrease` | boolean | `true` para redução, `false` para aumento; o analisador trata o inteiro `1` do provedor como true. |
| `totalValue` | integer | Saldo de moedas após a operação; valor alternativo `0`. Ao contrário de `totalValue` de EXP, este é um saldo. |
| `resCode` | integer | Código de motivo específico de moedas; valor alternativo `0`. |
| `relatedId` | integer or `null` | ID do objeto de origem relacionado; a conclusão normal de tarefa usa o `id` do registro da tarefa. Interprete outras origens pelo seu código de motivo. |
| `content` | string or `null` | Descrição da alteração. |
| `savingBalance` | integer or `null` | Saldo de poupança registrado para a operação. |

Exemplo inventado: redução de 5 moedas, deixando um saldo de moedas de 95.

```json
{
  "code":200,"message":"success","data":[{
    "id":401,"time":1792072800000,"value":5,"isDecrease":true,
    "totalValue":95,"resCode":0,"relatedId":null,"content":"Example purchase",
    "savingBalance":0
  }]
}
```

**Erros:** [erros comuns HTTP/provedor](/guide/api-reference?id=response-errors). Limites HTTP de data inválidos podem remover silenciosamente o filtro, conforme explicado acima, em vez de produzir erro.

### Códigos de motivo e totais dos relatórios :id=journal-totals

Os domínios dos códigos de motivo são diferentes. Alguns exemplos:

| Motivo | EXP `resCode` | Moedas `resCode` |
| --- | --- | --- |
| Concluir tarefa | `1` | `2` |
| Desfazer conclusão de tarefa | `101` | `3` |
| Concluir subtarefa | `12` | `11` |
| Desfazer subtarefa | `106` | `12` |
| Alteração por API | `200` | `28` |

Códigos completos de EXP: `0` desconhecido; `1` conclusão de tarefa; `2` conquista; `3` troca de curtidas; `4` sequência de dias de uso; `5` troca de passos; `6` definir como concluída; `7` desfazer desistência; `8` desfazer atraso; `9` comer tomate; `10` usar item; `11` desbloqueio de conquista do usuário; `12` conclusão de subtarefa; `200` API; `101` desfazer conclusão; `102` desistência; `103` atraso; `104` uso de item reduz EXP; `105` bloquear novamente conquista do usuário; `106` desfazer conclusão de subtarefa. Os códigos de motivo de moedas usam o mesmo domínio dos [registros de inventário](#get-inventory-records). Preserve códigos futuros desconhecidos. Para uma alteração líquida, aplique a direção com `isDecrease` (`true` subtrai a quantidade registrada). Não presuma que uma redução esteja codificada como `value` negativo; os tipos numéricos têm sinal e não há garantia de valores sem sinal/absolutos.

O `value` de EXP é por atributo. Não some indiscriminadamente o `totalValue` de EXP entre registros: a lógica atual de lotes de vários atributos pode armazenar totais sobrepostos quando há mais de três atributos. Por exemplo, uma alteração de 10 EXP para cada um de quatro atributos pode gerar totais armazenados de 40 e 10, em vez de uma soma confiável de 40. Concilie o `value` por atributo com os atributos listados em cada registro para relatórios precisos; associações ausentes limitam o que pode ser comprovado. Não some `value` e `totalValue` nem descreva `totalValue` de EXP como saldo.

Para um dia do calendário, calcule `dayStart` e `nextDayStart` locais e solicite `[dayStart, nextDayStart - 1]`, pois os dois limites são inclusivos. Selecione os códigos de motivo ao relatar apenas recompensas de tarefas; deixe-os sem filtro ao relatar todas as alterações registradas. [Procedimento de relatório diário](/guide/api-reference?id=daily-report).

### Referências de implementação :id=api-ledgers-sources

[CoinRecord](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/CoinRecord.kt) · [ExpRecord](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/ExpRecord.kt) · [Encaminhamento de parâmetros de data](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/LedgerUri.kt).

## Itens e categorias :id=get-items

`GET /items` retorna `ShopItem[]`. O parâmetro de consulta repetível e opcional `id` seleciona IDs de itens: `/items?id=1&id=2`. Valores não inteiros são descartados. IDs inexistentes são ignorados; IDs válidos mantêm a ordem da requisição, incluindo duplicatas. Se todos os IDs fornecidos forem inválidos, o SDK não envia filtro de ID e o resultado é a lista normal de itens. Não há paginação.

`GET /items/{listId}` retorna `ShopItem[]` de uma **categoria**, não um único item. `listId` é um ID de categoria inteiro de 64 bits com sinal; `-1` significa todas. Um valor de caminho inválido usa todas. A lista normal exclui itens retirados/excluídos (`isDel=0`) e segue a ordenação configurada da loja/categoria. A seleção por ID pode recuperar um item independentemente desse filtro da lista normal.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Coffee","desc":"A small reward","icon":"","categoryId":0,"stockNumber":-1,"ownNumber":2,"price":10,"order":0,"disablePurchase":false,"maxPurchaseNumber":5,"titleColorString":"","actionText":"Use","unlist":false,"disableUse":false,"purchaseLimit":"[]","limitScope":"purchase"}]}
```

### ShopItem :id=model-shop-item

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `id` | inteiro ou null | ID do item. |
| `name` | string | Nome do item. |
| `desc` | string | Descrição. |
| `icon` | string | URI de imagem legível, ou string vazia. Baixe por `/files/{url}`. |
| `categoryId` | integer | ID da categoria da loja. |
| `stockNumber` | integer | Estoque disponível; valores negativos são tratados como ilimitados ao calcular `maxPurchaseNumber`. |
| `ownNumber` | integer | Quantidade possuída no inventário. |
| `price` | integer | Preço em moedas. |
| `order` | integer | Ordem salva dentro da categoria. |
| `disablePurchase` | boolean | Indicador de compra desativada. |
| `maxPurchaseNumber` | inteiro ou null | Calculado com base nas moedas disponíveis mais crédito e estoque finito; compras desativadas resultam em 0, e estoque gratuito ilimitado pode resultar em 2147483647. O cálculo não avalia todas as regras de limite de compra. |
| `titleColorString` | string ou null | Cor personalizada do título. |
| `actionText` | string ou null | Texto personalizado do botão de uso. |
| `unlist` | boolean | Indicador de item retirado/excluído; normalmente false nos resultados de lista. |
| `disableUse` | boolean | Se o item tem um efeito que impede o uso. |
| `purchaseLimit` | string ou null | **String codificada em JSON**, não um array aninhado; configuração de limite de compra do item. |
| `limitScope` | string ou null | `purchase`, `use` ou `both`. |

### GET /items_categories :id=get-items-categories

Retorna `ShopCategory[]`. O parâmetro opcional `include_hidden` tem padrão `false`; apenas as strings exatas em minúsculas `true` e `false` são interpretadas; qualquer outro valor usa false. Inclui a categoria virtual de todos os itens. O servidor HTTP não expõe `/items_categories/{id}`.

```json
{"code":200,"message":"success","data":[{"id":0,"name":"Default","isAsc":true,"sort":"order","order":0,"hidden":false,"inventoryHidden":false}]}
```

### ShopCategory :id=model-shop-category

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `id` | inteiro ou null | ID da categoria. |
| `name` | string | Nome da categoria. |
| `isAsc` | boolean | Indicador configurado de ordenação crescente. |
| `sort` | string | Preferência de ordenação salva. |
| `order` | integer | Ordem da categoria. |
| `hidden` | boolean | Oculta na loja. |
| `inventoryHidden` | boolean | Oculta no inventário. |

### GET /tasks_categories :id=get-tasks-categories

Retorna `TaskCategory[]`, incluindo a categoria de todas as tarefas e as categorias arquivadas. Sem parâmetros de consulta ou paginação. O servidor HTTP não expõe `/tasks_categories/{id}`. Os valores de ordenação/filtro da categoria são preferências salvas do app; o endpoint não os aplica como filtros da requisição.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Daily","isAsc":true,"sort":"order","filter":"","order":0,"status":0,"type":0}]}
```

### TaskCategory :id=model-task-category

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `id` | inteiro ou null | ID da categoria. |
| `name` | string | Nome. |
| `isAsc` | boolean | Indicador salvo de ordenação crescente. |
| `sort` | string | Preferência de ordenação salva. |
| `filter` | string | Preferência salva de agrupamento/filtro. |
| `order` | integer | Ordem da categoria. |
| `status` | integer | 0 normal; 1 arquivada. |
| `type` | integer | 0 normal; listas inteligentes usam 10 diária, 11 semanal, 12 mensal, 20 em andamento. |

## Atributos e grupos de atributos :id=get-skills

`GET /skills` retorna `Skill[]`, sem parâmetros ou paginação. Atributos ocultos/excluídos são excluídos e a ordem salva é usada. `group_id` e `status` do ContentProvider subjacente **não** são campos do modelo HTTP.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Strength","desc":"","icon":"","order":0,"color":-65536,"exp":150,"level":2,"untilNextLevelExp":50,"currentLevelExp":50,"type":1}]}
```

### Skill :id=model-skill

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `id` | inteiro ou null | ID do atributo. |
| `name` | string | Nome localizado do atributo. |
| `desc` | string | Descrição. |
| `icon` | string | URI de ícone legível, ou vazio. |
| `order` | integer | Ordem salva. |
| `color` | integer | Inteiro de cor empacotada do Android. |
| `exp` | integer | EXP total atual. |
| `level` | integer | Nível atual. |
| `untilNextLevelExp` | integer | EXP restante até o próximo nível. |
| `currentLevelExp` | integer | EXP ganho desde o início do nível atual. |
| `type` | integer | 0 usuário; 1 força; 2 aprendizado; 3 carisma; 4 resistência; 5 vitalidade; 6 criatividade. |

### GET /skill_groups :id=get-skill-groups

Retorna `SkillGroup[]`. `include_hidden` usa a mesma interpretação booleana estrita de `/items_categories`, com padrão false. O repositório atual do app ignora esse indicador para grupos e sempre exclui grupos apagados. A ordem salva é crescente. Sem paginação.

```json
{"code":200,"message":"success","data":[{"id":1,"content":"Personal","order":0,"collapsed":false}]}
```

### SkillGroup :id=model-skill-group

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `id` | inteiro ou null | ID do grupo. |
| `content` | string | Título do grupo. |
| `order` | integer | Ordem salva do grupo. |
| `collapsed` | boolean | Estado recolhido. |

## Conquistas :id=get-achievements

`GET /achievements` retorna `Achievement[]`, carregando cada categoria na ordem das categorias e concatenando suas conquistas. `GET /achievements/{id}` retorna conquistas **na categoria `id`**, não detalhes de uma conquista. IDs de caminho inválidos se comportam como a rota sem filtro. A ordenação dentro de cada categoria segue a preferência da categoria no app. Nenhum dos endpoints tem paginação.

```json
{"code":200,"message":"success","data":[{"id":10,"name":"First step","desc":"Complete a task","iconUri":"","categoryId":1,"status":0,"exp":10,"coin":5,"coinVariable":0,"type":0,"progress":0,"order":0,"itemId":null,"itemAmount":null,"unlockedTime":null,"items":[],"color":""}]}
```

### Achievement :id=model-achievement

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `id` | inteiro ou null | ID da conquista. |
| `name` | string | Título. |
| `desc` | string | Descrição. |
| `iconUri` | string | URI do ícone ou vazio. |
| `categoryId` | integer | ID da categoria. |
| `status` | integer | 0 incompleta; 1 concluída com recompensa não resgatada; 2 recompensa resgatada/outro estado concluído. |
| `exp` | integer | Recompensa de EXP. |
| `coin` | integer | Recompensa de moedas. |
| `coinVariable` | integer | Recompensa variável de moedas. |
| `type` | integer | 0 conquista; 1 título de subcategoria. |
| `progress` | integer | Progresso salvo. |
| `order` | integer | Ordem dentro da categoria. |
| `itemId` | inteiro ou null | ID do primeiro item de recompensa (campo auxiliar legado). |
| `itemAmount` | inteiro ou null | Quantidade do primeiro item de recompensa. |
| `unlockedTime` | inteiro ou null | Horário Unix do desbloqueio em milissegundos. |
| `items` | RewardItem[] ou null | Lista completa de itens de recompensa; o parser atual fornece um array vazio quando o JSON dos itens está ausente ou malformado. |
| `color` | string ou null | Cor personalizada do título. |

Os itens de recompensa usam o modelo compartilhado [RewardItem](#reward-item).

### GET /achievement_categories :id=get-achievement-categories

Retorna `AchievementCategory[]`, sem parâmetros ou paginação. O servidor HTTP não expõe `/achievement_categories/{id}`.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Milestones","desc":"","iconUri":"","isAsc":true,"sort":"order","filter":"","order":0,"type":0}]}
```

### AchievementCategory :id=model-achievement-category

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `id` | inteiro ou null | ID da categoria. |
| `name` | string | Nome. |
| `desc` | string | Descrição. |
| `iconUri` | string | URI/string do ícone. |
| `isAsc` | boolean | Indicador de ordenação crescente. |
| `sort` | string | Preferência de ordenação salva. |
| `filter` | string | Preferência salva de agrupamento/filtro. |
| `order` | integer | Ordem da categoria. |
| `type` | integer | 0 conquistas do usuário; 1 conquistas do sistema. |

### GET /achievement_conditions/{id} :id=get-achievement-conditions

Retorna `AchievementCondition[]` para o ID de **conquista** `id`. Um ID não inteiro retorna um envelope de erro com código 500. Sem condições correspondentes, retorna um array vazio. Não existe rota de coleção `/achievement_conditions`.

```json
{"code":200,"message":"success","data":[{"id":1,"type":0,"relatedId":42,"target":10,"current":3,"progress":30}]}
```

### AchievementCondition :id=model-achievement-condition

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `id` | inteiro ou null | ID da condição. |
| `type` | integer | Código da condição; veja abaixo. |
| `relatedId` | integer | Identificador da tarefa/item/atributo relacionado, conforme a condição. |
| `target` | integer | Valor-alvo. |
| `current` | integer | Valor acumulado atual. |
| `progress` | integer | Progresso salvo. |

Códigos de condição: 0 conclusões de tarefas; 1 sequência atual da tarefa; 2 nível de atributo legado; 3 tomates; 4 dias de uso do app; 5 curtidas; 6 dias consecutivos com conclusões; 7 moedas atuais; 8 moedas ganhas em um dia; 9 tomates da tarefa; 10 compras de itens; 11 usos de itens; 12 itens ganhos em caixas-surpresa; 13 nível do atributo; 14 nível de vida; 15 itens ganhos acumulados; 16 itens ganhos por síntese; 17 quantidade de itens possuída atualmente; 18 tempo de foco da tarefa; 19 poupança no ATM; 20 API externa. Condições repetíveis: 500 conclusões de tarefas; 501 aumentos de nível de atributo; 502 tomates; 503 moedas; 504 itens ganhos; 505 compras de itens; 506 ganhos em caixas-surpresa; 507 ganhos por síntese; 508 usos de itens; 509 minutos de foco da tarefa; 510 tomates da tarefa; 511 curtidas; 512 aumentos da poupança no ATM; 513 chamadas de API externa; 514 dias de uso; 515 aumentos do nível de vida; 516 moedas diárias; 517 conclusões consecutivas de tarefas; 518 tomates diários; 519 minutos diários de foco; 520 grupos de tarefas distintos por dia; 521 usos diários de itens; 522 compras diárias de itens; 523 conclusões diárias de uma tarefa específica; 524 total diário de registros de conclusão de tarefas. São códigos inteiros brutos, não nomes de enums serializados.

## Síntese :id=get-synthesis

`GET /synthesis` retorna `Synthesis[]` das categorias visíveis. `GET /synthesis/{id}` retorna receitas **na categoria `id`**, incluindo conteúdo oculto dessa categoria. IDs não negativos selecionam uma categoria; negativos significam todas as categorias visíveis. IDs inválidos usam a rota de coleção. Os resultados seguem a ordem salva das receitas em ordem crescente; receitas excluídas são omitidas. Sem paginação.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Tea","desc":"","input":[{"itemId":2,"itemName":"Tea leaf","amount":2,"ownedNumber":5,"icon":""}],"output":[{"itemId":3,"itemName":"Tea","amount":1,"ownedNumber":0,"icon":""}],"categoryId":0,"canSynthesisTimes":2}]}
```

### Synthesis :id=model-synthesis

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `id` | inteiro ou null | ID da receita. |
| `name` | string | Nome. |
| `desc` | string | Descrição. |
| `input` | SynthesisItemInfo[] | Itens necessários. |
| `output` | SynthesisItemInfo[] | Itens produzidos. |
| `categoryId` | inteiro ou null | ID da categoria. |
| `canSynthesisTimes` | integer | Quantidade de sínteses disponíveis atualmente. |

### SynthesisItemInfo :id=model-synthesis-item-info

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `itemId` | integer | ID do item. |
| `itemName` | string | Nome do item. |
| `amount` | integer | Quantidade de entrada/saída por síntese. |
| `ownedNumber` | integer | Quantidade possuída. |
| `icon` | string | URI de ícone legível ou vazio. |

### GET /synthesis_categories e /synthesis_categories/{id} :id=get-synthesis-categories

Ambos retornam `SynthesisCategory[]`. O `id` opcional no caminho filtra o ID da categoria; não altera o formato de array. IDs inválidos usam todas as categorias. O `include_hidden` opcional usa interpretação booleana estrita em minúsculas e padrão false, inclusive quando um ID de categoria é fornecido. Sem paginação.

```json
{"code":200,"message":"success","data":[{"id":0,"name":"Default","isAsc":true,"sort":"order","order":0,"hidden":false}]}
```

### SynthesisCategory :id=model-synthesis-category

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `id` | inteiro ou null | ID da categoria. |
| `name` | string | Nome. |
| `isAsc` | boolean | Indicador salvo de ordenação crescente. |
| `sort` | string | Preferência de ordenação salva. |
| `order` | integer | Ordem da categoria. |
| `hidden` | boolean | Indicador de ocultação. |

## Sentimentos :id=get-feelings

`GET /feelings` retorna `Feelings[]`. Na consulta, `offset` tem padrão 0 e `limit`, 100; valores ausentes ou não inteiros usam esses padrões. O endpoint não tem limitação explícita. Use offsets não negativos e limites positivos. Sentimentos excluídos são omitidos. A ordenação segue a preferência de sentimentos do app (`createTime` crescente ou decrescente), não um parâmetro de requisição. Não há filtro de tempo exposto.

```json
{"code":200,"message":"success","data":[{"id":1,"content":"A good day","isFav":false,"title":"Read","time":1700000000000,"attachments":[],"type":0}]}
```

### Feelings :id=model-feelings

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `id` | inteiro ou null | ID do sentimento. |
| `content` | string | Texto. |
| `isFav` | boolean | Indicador de favorito. |
| `title` | string | Título relacionado. |
| `time` | integer | Horário Unix de criação em milissegundos. |
| `attachments` | string[] | URIs de anexos legíveis para arquivos existentes e não vazios. |
| `type` | integer | 0 tarefa; 1 conquista; 2 registro independente. |

## Registros Pomodoro :id=get-pomodoro-records

`GET /pomodoro_records` retorna `PomodoroRecord[]`. `offset` tem padrão 0 e `limit`, 100; sem limitação explícita. Os parâmetros opcionais `time_range_start` e `time_range_end` usam milissegundos Unix. O SDK só encaminha o intervalo quando ambos são interpretados como inteiros de 64 bits e o início é menor que o fim; caso contrário, o intervalo é omitido silenciosamente.

Sem intervalo, registros concluídos e não excluídos com `startTime != endTime` e `endTime` positivo são retornados na ordem `endTime DESC, startTime DESC, id DESC`. Um intervalo válido seleciona `start < endTime <= end` e exclui linhas apagadas.

> [!WARNING]
> As implementações anteriores passavam `limit` e `offset` ao DAO em posições invertidas nas consultas por intervalo, sem definir ordenação. O código local do LifeUp agora usa argumentos nomeados e ordena os resultados paginados por `endTime DESC, startTime DESC, id DESC`; esta correção local ainda não foi publicada. Até confirmar que sua versão instalada do LifeUp a inclui, omita o intervalo e filtre os registros no cliente para uma paginação confiável.

```json
{"code":200,"message":"success","data":[{"id":1,"startTime":1700000000000,"endTime":1700001500000,"duration":1500000,"reward":1.0}]}
```

### PomodoroRecord :id=model-pomodoro-record

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `id` | inteiro ou null | ID do registro. |
| `startTime` | inteiro ou null | Horário Unix de início em milissegundos. |
| `endTime` | inteiro ou null | Horário Unix de término em milissegundos. |
| `duration` | integer | Milissegundos: `lastTime` salvo diferente de zero; caso contrário, término menos início. |
| `reward` | número | Tomates ganhos: abandonado = 0; metade = 0.5 × multiplicador; caso contrário, multiplicador. |

## Registros de inventário :id=get-inventory-records

`GET /inventory_records` retorna `InventoryRecord[]`. `offset` tem padrão 0 e mínimo 0; `limit` tem padrão 100 e é limitado a 1–200. `time_range_start` e `time_range_end` opcionais só são encaminhados se ambos forem inteiros de 64 bits e início < fim; o SDK omite silenciosamente intervalos inválidos/incompletos. Intervalos válidos usam limites inclusivos `time >= start AND time <= end`. Registros excluídos são omitidos (`isDel` null ou 0); ordenação `time DESC, id DESC`. Não há filtro por ID de item exposto.

```json
{"code":200,"message":"success","data":[{"id":1,"time":1700000000000,"itemId":2,"itemName":"Tea","changeNumber":1,"isDecrease":false,"resCode":0,"desc":"Purchase"}]}
```

### InventoryRecord :id=model-inventory-record

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `id` | inteiro ou null | ID do registro. |
| `time` | inteiro ou null | Horário Unix de criação em milissegundos. |
| `itemId` | inteiro ou null | ID do item relacionado. |
| `itemName` | string ou null | Nome do item relacionado, quando disponível. |
| `changeNumber` | integer | Alteração de quantidade registrada. |
| `isDecrease` | boolean | Se a alteração reduz o inventário. |
| `resCode` | integer | Código do motivo de origem; veja abaixo. |
| `desc` | string ou null | Descrição do registro. |

Códigos de motivo: 0 compra; 1 uso; 2 conclusão de tarefa; 3 desfazer conclusão; 4 limpar dados; 5 desistir de tarefa; 6 tarefa atrasada; 7 desbloqueio de conquista integrada; 8 desfazer desistência; 9 desfazer atraso; 10 devolver item; 11 conclusão de subtarefa; 12 desfazer conclusão de subtarefa; 13 desbloqueio de conquista do usuário; 14 desfazer desbloqueio de conquista do usuário; 15 depósito; 16 saque; 17 venda de tomates; 20 recompensar item; 21 desfazer recompensa; 23 síntese; 24 caixa-surpresa; 25 juros do ATM; 26 troca de tomates por item; 27 juros de crédito; 28 API; 29 alteração de estoque por efeito de item. Clientes devem preservar códigos futuros desconhecidos.

## Registros de passos :id=get-step-records

`GET /step_records` retorna `StepRecord[]`. Os padrões/limites de paginação e as regras de omissão de intervalo do SDK são os mesmos de `/inventory_records`. O filtro de tempo válido inclui os limites em `date`; a ordenação é `date DESC`, sem chave secundária explícita.

```json
{"code":200,"message":"success","data":[{"id":1,"date":1700000000000,"dailyStepCount":5000,"totalStepCount":120000,"isGotReward":true,"isUserInput":false,"rewardLevel":1}]}
```

### StepRecord :id=model-step-record

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `id` | inteiro ou null | ID do registro. |
| `date` | inteiro ou null | Data registrada em milissegundos Unix. |
| `dailyStepCount` | integer | Contagem diária de passos. |
| `totalStepCount` | integer | Contagem acumulada de passos salva. |
| `isGotReward` | boolean | Indicador de recompensa resgatada. |
| `isUserInput` | boolean | Indicador de entrada pelo usuário. |
| `rewardLevel` | inteiro ou null | Nível de recompensa salvo. |

## Definições de níveis :id=get-level-defines

`GET /level_defines` retorna um único objeto `LevelDefines`. Sem parâmetros. Usa definições personalizadas quando o modo de níveis personalizados está ativado; caso contrário, usa as integradas.

```json
{"code":200,"message":"success","data":{"custom":true,"levels":[{"id":1,"levelStart":1,"levelEnd":10,"perLevelExp":100}]}}
```

### LevelDefines :id=model-level-defines

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `custom` | boolean | Modo de níveis personalizados. |
| `levels` | LevelDefine[] | Intervalos de níveis. |

### LevelDefine :id=model-level-define

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `id` | inteiro ou null | ID da definição. |
| `levelStart` | integer | Nível inicial. |
| `levelEnd` | integer | Nível final. |
| `perLevelExp` | integer | EXP necessário por nível no intervalo. |

JSON de níveis malformado atualmente resulta em um array `levels` vazio, sem falhar a requisição inteira.

## Estatísticas :id=get-statistics

`GET /statistics` retorna um objeto `Statistics`. Os parâmetros opcionais `time_range_start` e `time_range_end` usam milissegundos Unix e a mesma regra do SDK: ambos válidos e início < fim, ou nenhum intervalo é enviado. Sem intervalo, o app usa a primeira data registrada até agora; se não existir, usa os últimos 30 dias. `usingDays` e `companionDays` são valores de todo o período, mesmo com intervalo. As outras métricas são calculadas pelos métodos de estatísticas correspondentes do app; não presuma regras idênticas de inclusão dos limites em todas as consultas subjacentes.

```json
{"code":200,"message":"success","data":{"start":1700000000000,"end":1700086400000,"tomatoes":4,"pomodoroMinutes":100,"focusCount":4,"tasksCompleted":3,"tasksTotal":4,"taskCompleteRate":0.75,"feelingsCount":1,"usingDays":30,"companionDays":32,"interestChanged":2,"coinPurchaseConsumed":10}}
```

### Statistics :id=model-statistics

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `start` | inteiro ou null | Início efetivo do intervalo em milissegundos Unix. |
| `end` | inteiro ou null | Fim efetivo do intervalo em milissegundos Unix. |
| `tomatoes` | integer | Estatística de tomates ganhos. |
| `pomodoroMinutes` | integer | Duração do foco em minutos. |
| `focusCount` | integer | Quantidade de sessões de foco. |
| `tasksCompleted` | integer | Quantidade de tarefas concluídas usada na estatística de conclusão. |
| `tasksTotal` | integer | Total de tarefas usado nessa estatística. |
| `taskCompleteRate` | número | Taxa de conclusão. |
| `feelingsCount` | integer | Quantidade de sentimentos. |
| `usingDays` | integer | Dias de uso desde o início. |
| `companionDays` | integer | Dias de companhia desde o início. |
| `interestChanged` | integer | Estatística de alteração de moedas por juros. |
| `coinPurchaseConsumed` | integer | Estatística de moedas gastas em compras. |

## Informações do app e saldo de moedas :id=get-info

`GET /info` retorna `Info`. O LifeUp Cloud adiciona sua própria versão instalada às informações do app/provedor. Sem parâmetros.

```json
{"code":200,"message":"success","data":{"appVersion":1,"appVersionName":"example","apiVersion":1,"cloudVersion":1,"cloudVersionName":"example"}}
```

### Info :id=model-info

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `appVersion` | integer | Código da versão instalada do LifeUp. |
| `appVersionName` | string | Nome da versão instalada do LifeUp. |
| `apiVersion` | integer | Versão da API do LifeUp. |
| `cloudVersion` | integer | Código da versão instalada do LifeUp Cloud. |
| `cloudVersionName` | string | Nome da versão instalada do LifeUp Cloud. |

### GET /coin :id=get-coin

Invoca `lifeup://api/query?key=coin` pelo ContentProvider e retorna seu objeto de resultado. Sem parâmetros. Resultado null do provedor vira objeto vazio. Os campos são definidos pelo provedor, não por uma resposta tipada `CoinData`. Uma consulta bem-sucedida fornece `value` (saldo de moedas como inteiro de 64 bits com sinal) e `api_result: true`; falhas podem fornecer os campos de estado/erro do provedor descritos abaixo.

```json
{"code":200,"message":"success","data":{"value":50,"api_result":true}}
```

## Invocar uma API de URL Scheme :id=invoke-api

O [catálogo de APIs de URL Scheme](/guide/api) define nomes dos métodos, parâmetros e resultados específicos. A ponte HTTP aceita a URL completa `lifeup://api/...`.

| Transporte | Entrada | Execução e resposta |
| --- | --- | --- |
| `GET /api` | Parâmetro de consulta repetido `url`, codificado como URL | Inicia uma atividade Android para cada URL, na ordem fornecida. Retorna a string `success`. URLs ausentes também retornam sucesso. |
| `POST /api` | JSON `RawQueryVo` | Inicia primeiro cada entrada de `urls`, depois `url`, se presente. Retorna a string `success`. Um objeto de entrada vazio também tem sucesso. |
| `GET /api/contentprovider` | Parâmetro de consulta repetido `url`, codificado como URL | Chama o provedor de forma síncrona e retorna `CallUrlResult[]` na ordem fornecida. URLs ausentes retornam um envelope de erro (`No url found`). |
| `POST /api/contentprovider` | JSON `RawQueryVo` | Chama primeiro cada entrada de `urls`, depois `url`; retorna `CallUrlResult[]`. Objeto vazio retorna array vazio. |

Defina `Content-Type: application/json` para POSTs JSON. Codifique a URL inteira ao incluí-la em uma consulta GET, preservando `&`, `?`, `+` internos e a codificação percentual. O sucesso da ponte por atividade confirma o envio, não a conclusão da ação no LifeUp. Métodos ContentProvider exigem permissão do Cloud no LifeUp; o suporte depende do método URL Scheme. As chamadas são sequenciais; se uma chamada posterior lançar erro, os efeitos anteriores não são revertidos.

```json
{"urls":["lifeup://api/query?key=coin"],"url":"lifeup://api/query?key=atm"}
```

Resposta da ponte por atividade:

```json
{"code":200,"message":"success","data":"success"}
```

Resposta da ponte por provedor (resultado ilustrativo):

```json
{"code":200,"message":"success","data":[{"url":"lifeup://api/query?key=coin","result":{"value":50,"api_result":true}},{"url":"lifeup://api/query?key=atm","result":{"value":100,"api_result":true}}]}
```

### RawQueryVo :id=model-raw-query

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `url` | string ou null | URL única opcional. |
| `urls` | string[] ou null | Lista opcional de URLs; processada antes de `url`. |

### CallUrlResult :id=model-call-url-result

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `url` | string | URL enviada. |
| `result` | objeto ou null | Bundle convertido do provedor; null por si só não causa falha no envelope HTTP. |

A conversão do Bundle preserva valores Int/Long/Double/String/Boolean e Bundles aninhados. Arrays viram arrays de strings. Outros tipos de valor viram sua string `toString()` (inclusive null do Bundle vira a string `"null"`). Os campos de falha do método em `result` devem ser verificados mesmo quando o envelope externo tem código 200.

O manipulador atual de métodos do LifeUp adiciona `api_result` (booleano) às chamadas concluídas. Uma falha capturada retorna `api_result: false`, `error_code` (string) e `error_message` (string). Códigos incluem `missing_required_parameter`, `invalid_parameter`, `entity_not_found`, `invalid_format`, `unsupported_api`, `cancelled` e `internal_error`; métodos específicos podem fornecer outros códigos. Durante a restauração de backup, o provedor pode retornar `error_code: "503"` e `error_message` sem `api_result`. Manipuladores de API ausentes podem lançar erro antes dessa conversão, produzindo um erro externo da ponte.

## Ler e enviar arquivos :id=files-download

### GET /files/{url} :id=files-get

Codifique o URI legível completo como um único segmento de caminho. Isso lê bytes pelo resolvedor de conteúdo do Android, normalmente de ícones, anexos de sentimentos, backups exportados ou arquivos enviados. O resultado é um fluxo de bytes, não um envelope JSON de sucesso. A rota não especifica nome de arquivo nem tipo MIME. Fluxos vazios/ilegíveis não são convertidos em resultado estruturado de não encontrado; falhas lançadas usam o manipulador global HTTP 500. Um parâmetro correspondente vazio produz um envelope de erro (`url is required`).

```bash
curl "$BASE/files/content%3A%2F%2Fexample.provider%2Fimages%2F1" -o image.bin
```

### POST /files/upload :id=files-upload

Envie `multipart/form-data`. Toda parte de arquivo é aceita, independentemente do nome do campo; partes que não são arquivos são ignoradas. O nome original é usado no arquivo de cache; sem ele, o Cloud escolhe `uploaded_image_<time>.jpg`. Retorna um array de strings de URIs de conteúdo legíveis. O envio fornece um URI para chamadas posteriores da API; não anexa automaticamente a itens ou tarefas. Sem arquivos, retorna um envelope de erro com `No files received`.

```bash
curl -X POST "$BASE/files/upload" -F 'file=@image.png'
```

```json
{"code":200,"message":"success","data":["content://example.fileprovider/cache/image.png"]}
```

## Exportar e importar backups :id=files-backup

### GET /data/export :id=files-export

Aciona a criação de backup pelo provedor. A consulta opcional `withMedia` tem padrão `true`; se presente, `true` sem diferenciar maiúsculas significa verdadeiro, qualquer outro valor significa falso. Retorna o Bundle convertido do provedor, atualmente com `backup_file_uri`; use `/files/{url}` para baixar esse URI. O endpoint cria uma exportação, embora use GET. Campos de estado/erro da API do provedor podem estar presentes e devem ser verificados. `backup_file_uri` vazio indica que a exportação não produziu arquivo utilizável. Resultado null vira erro.

```json
{"code":200,"message":"success","data":{"backup_file_uri":"content://example.provider/backup/LifeUpExportBackup.zip","api_result":true}}
```

### POST /data/import :id=files-import

Envie `multipart/form-data` com um arquivo de backup. Se houver vários arquivos, o último prevalece; o nome do campo não é verificado. O nome de arquivo padrão é `backup.lfbak`. O campo opcional `description` é lido, mas não tem efeito. O Cloud armazena o arquivo em cache e abre a atividade de backup do LifeUp; a resposta confirma o envio e a abertura da atividade, **não a restauração concluída**. Sem arquivo, retorna `No file received`.

```bash
curl -X POST "$BASE/data/import" -F 'file=@backup.lfbak'
```

```json
{"code":200,"message":"success","data":"File uploaded and BackupActivity launched"}
```

## Eventos :id=get-events

### GET /events :id=get-events-poll

Retorna `EventsPage`. `after` é um cursor exclusivo de ID de evento (inteiro de 64 bits, padrão 0). `limit` é inteiro, padrão 50, limitado a 1–200. Valores não inteiros usam os padrões. Eventos vêm dos mais antigos aos mais novos no buffer retido, com `id > after`. No máximo 200 eventos ficam na memória; os antigos são descartados e reiniciar o processo redefine IDs. `latestId` é o ID global mais recente disponível, não necessariamente o último da página limitada. Continue do último evento realmente processado para não pular eventos acumulados. Não há histórico persistente nem confirmação de entrega.

```json
{"code":200,"message":"success","data":{"latestId":2,"eventWs":true,"events":[{"id":1,"time":1700000000000,"action":"app.lifeup.task.complete","extras":{"id":"42"}}],"broadcasts":true}}
```

### EventsPage :id=model-events-page

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `latestId` | integer | ID do evento mais recente atual. |
| `eventWs` | boolean | Configuração WebSocket do Cloud. |
| `events` | CloudEvent[] | Eventos retidos após o cursor. |
| `broadcasts` | booleano ou null | Se as transmissões do LifeUp estão ativadas; null significa desconhecido ou não suportado. O estado consultado é armazenado em cache por cinco segundos. |

### CloudEvent :id=model-cloud-event

| Campo | Tipo JSON | Significado |
| --- | --- | --- |
| `id` | integer | ID sequencial do evento na memória. |
| `time` | integer | Horário Unix de recebimento no Cloud em milissegundos. |
| `action` | string | Ação de transmissão do Android. |
| `extras` | objeto com valores string | Extras da transmissão convertidos com `toString()`; null vira string vazia. As chaves dependem da ação. |

### WebSocket /events :id=get-events-websocket

Quando `eventWs` é true, conecte a `ws://HOST:PORT/events?after=ID` (e forneça o token configurado). O servidor reproduz eventos retidos após `after` e depois envia eventos ao vivo como quadros de texto JSON `CloudEvent` individuais, **sem** o envelope de resposta HTTP. A reprodução é limitada pelo buffer de 200 eventos; não existe parâmetro WebSocket `limit`. O servidor envia quadros Ping a cada 30 segundos. Reconecte com o ID do último evento realmente processado. Quando desativado, a rota WebSocket não é registrada; a consulta periódica HTTP continua disponível.

```json
{"id":2,"time":1700000001000,"action":"app.lifeup.item.use","extras":{"id":"3"}}
```

As assinaturas de ações suportadas são `app.lifeup.task.complete`, `app.lifeup.task.overdue`, `app.lifeup.task.giveup`, `app.lifeup.achievement.unlock`, `app.lifeup.achievement.condition.unlock`, `app.lifeup.item.purchase`, `app.lifeup.item.reward`, `app.lifeup.item.use`, `app.lifeup.synthesis.complete`, `app.lifeup.pomodoro.start`, `app.lifeup.pomodoro.pause`, `app.lifeup.pomodoro.complete`, `app.lifeup.pomodoro.stop`, `app.lifeup.feelings.add`, `app.lifeup.level.up`, `app.lifeup.level.down`, `app.lifeup.item.countdown.start`, `app.lifeup.item.countdown.complete`, `app.lifeup.item.countdown.stop`, `app.lifeup.timing.start`, `app.lifeup.timing.complete`, `app.lifeup.timing.pause` e `app.lifeup.timing.abandon`. A coleta de eventos exige transmissões do LifeUp ativadas. A consulta periódica a `/events` verifica essa configuração; não a ativa automaticamente.
