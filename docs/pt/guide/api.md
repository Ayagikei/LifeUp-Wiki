<h1 align="center" padding="100">Interface aberta</h1>

<p align="center">Crie possibilidades infinitas!</p>

?> Na versão v1.90, o `LifeUp` abriu diversas interfaces funcionais, e qualquer integração com aplicativos externos é bem-vinda. <br/>Também oferece o efeito «URL» para itens da Loja, e os usuários podem usar os itens diretamente para chamar aplicativos externos ou a interface do `LifeUp`. <br/>Esses recursos podem dar ao seu `LifeUp` possibilidades ilimitadas, mas também exigem um pouco de compreensão e prática.

**Última atualização: 2026/08/28**

Os parâmetros e definições da API neste documento são baseados na versão **v1.106.0**.

Certifique-se de que seu aplicativo foi atualizado para **v1.106.0** antes de usar a API mais recente.

A atualização está sendo liberada gradualmente pelo Google Play; se você ainda não recebeu, aguarde — ela chegará em breve.

## Exemplo de cenário

| Chamador | Cenário | Notas |
| ------ | -------- | ----- |
|**LifeUp→Outros aplicativos**<br/>Implementado pelo efeito «URL» do item da Loja| **Após usar o item da Loja:**<br/>1. Usar um navegador para visitar uma página web<br/>2. Ir para o WeChat e escanear, ou abrir um miniprograma específico<br/>3. Adicionar automaticamente registros contábeis ([por exemplo, o «Qianji» suporta interface de contabilidade](http://docs.qianjiapp.com/plugin/auto_tasker.html))<br/>4. Salvar a configuração da ferramenta de automação Tasker (até compartilhar no Market) e importar automaticamente a configuração no Tasker após o uso<br/>5. Acionar o Tasker para alterar o papel de parede<br/>6. ... (desde que o aplicativo externo suporte esse método de chamada) | [Tasker](https://play.google.com/store/apps/details?id=net.dinglisch.android.taskerm&hl=en_US&gl=US) é uma ferramenta de automação e suporta exportar a configuração como Uri |
|**LifeUp→LifeUp**<br/>Implementado pelo efeito «URL» do item da Loja| **Após usar o item da Loja:**<br/>1. Abrir uma página específica<br/>2. Aumentar a taxa de juros do caixa eletrônico<br/>3. Exibir uma janela pop-up para o usuário selecionar o produto e reduzir o preço (cupom de desconto)<br/>4. Acionar a conclusão de uma Tarefa<br/>5. Exibir uma mensagem motivacional personalizada<br/>6. Criar um modelo de Recompensa de Tarefa: basta informar o nome para criar uma Tarefa automaticamente<br/>7. Exibir uma janela pedindo ao usuário a escolha de um ramo, criando uma pequena interação contextual<br/>8. Mais operações dentro do App... |  |
|**Aplicativos externos/páginas web→LifeUp** | **Configurar ferramentas de automação:**<br/>1. Detectar quando o telefone é ligado pela primeira vez a cada dia, concluir a Tarefa de acordar cedo ou acionar diretamente a penalidade por «acordar tarde»<br/>2. Após cada 25 palavras, passar um cartão NFC específico e concluir automaticamente a Tarefa<br/>3. O GPS detecta que um novo local foi alcançado e desbloqueia a Conquista «novo lugar»<br/>4. Ao conectar-se ao Wi-Fi do trabalho todos os dias, aumenta o progresso da condição de desbloqueio; após acumular 20 dias, desbloqueia a Conquista «Trabalhador»<br/>5. Recompensar-se com moedas de ouro por «chegar em casa» ao conectar-se ao Wi-Fi de casa pela primeira vez a cada dia<br/>6. Capturar notificações de outros apps de Pomodoro ou Foco e registrar automaticamente o tempo no `LifeUp`<br/>7. Capturar a notificação de conclusão de software de esporte ou estudo e conceder automaticamente Pontos de Experiência de «força» e «conhecimento»<br/>8. No período que você definir, cada vez que abrir o telefone acionará uma penalidade<br/>9. ...<br/>**Integração com aplicativos externos/aplicativo próprio:**<br/>1. Se o Pomodoro do `LifeUp` não atender: você pode desenvolver seu próprio software de cronometragem, web ou Android, e integrar com o «LifeUp» pela interface para adicionar registros de tempo ou Recompensas<br/>2. Modificar alguns minijogos de inteligência (como o exemplo de Wordle abaixo). Ao concluir o jogo com sucesso, acionar o `LifeUp` para enviar Recompensas<br/>3. ... |  |

<br/>Em outras palavras, todos os cenários acima são, na verdade, «eventos» que disparam «ações».

Esta atualização do `LifeUp` fornece o ponto de acionamento do evento «uso de itens» e, em seguida, diversas «ações» (Recompensas, conclusão de Tarefas, etc.).

Se você precisar de

- Clicar em um botão web
- Passar um cartão NFC
- Desbloquear a tela pela primeira vez ao acordar todos os dias

Esse tipo de evento exige a intervenção de aplicativos externos. Por exemplo, fazer um desenvolvimento secundário por conta própria ou usar ferramentas de automação como `Tasker` e `MacroDroid`.

**A atualização LifeUp 1.90.2 adicionará uma série de «eventos», que podem ser recebidos por ferramentas de automação ou aplicativos externos.**

Pode ser usado para:

Após usar o item, acionar ferramentas de automação como o Tasker para alterar o papel de parede do launcher.

Após concluir a Tarefa, acionar uma ferramenta de automação como o Tasker para abrir um app.

**Na versão 1.90.2, é possível realizar o «evento do LifeUp» que dispara a «operação do Tasker».**

O Tasker tem permissões muito amplas: pode alterar papéis de parede, desinstalar apps, aumentar o volume, escolher qual app abrir e muito mais. Você pode até escrever lógica de interação de UI sem base em programação.

---

## Recomendações

**Se você não está familiarizado com programação,** pode buscar e importar itens especiais da Loja diretamente em [World] → [Market] → tag [Link]/[API]/[Automate]. Também pode tentar editar os parâmetros para atender às suas necessidades.

**Se você domina informática,** pode ler a documentação de interfaces abaixo e editar o efeito desejado por conta própria. Use junto com software de automação como [*Tasker*](https://play.google.com/store/apps/details?id=net.dinglisch.android.taskerm). Mesmo sem editar a configuração do Tasker, se conseguir instalá-lo, pode importar configurações de automação compartilhadas por outros no Market ou em outras comunidades.

**Se você tem base em programação,** pode desenvolver páginas web ou aplicativos Android para integrá-los ao LifeUp. Esta página e versões personalizadas de Wordle são alguns exemplos. Você também é bem-vindo a criar e compartilhar configurações de ferramentas de automação.

---

## Chamar outro aplicativo

Se quiser chamar um aplicativo externo no *LifeUp*, basta adicionar um efeito «Link» ao item da Loja, **informar um link web ou específico do aplicativo** e usar o item para acionar a chamada.

**Alguns exemplos (também pode ir em «World»→«Market»→«Link» para ver itens públicos com efeito de chamada de interface):**

- Abrir o Google no navegador: https://www.google.com
- Facebook: [fb://](fb://)
- Abrir um app pelo nome do pacote/ID: [market://launch?id=net.sarasarasa.lifeup](market://launch?id=net.sarasarasa.lifeup)
- ...

Em teoria, desde que o app externo forneça a URL, você pode saltar usando o item da Loja.

**Você pode buscar o link de aplicativo que precisa pesquisando `URL Schemes` no Google.**

**Esses links não têm relação com o `LifeUp`; o `LifeUp` apenas oferece a função de salto por URL.**

**Por isso não mantemos (nem manteremos) uma lista de URLs. Mas você pode ver os itens públicos da Loja com efeito de link na página [World]→[Market]→[Link].**

Você pode encontrar o nome do pacote de um app (também chamado de ID):

- na URL da Play Store: https://play.google.com/store/apps/details?id=net.sarasarasa.lifeup
- usando um app gerenciador de aplicativos
- usando a ação App Info no Tasker
- usando a ação Launch App no Macrodroid

---

## Chamar as APIs do LifeUp

Se:

- Precisar chamar a interface do `LifeUp` dentro do `LifeUp`. Basta adicionar um efeito «link» ao item da Loja, informar **uma URL específica** conforme a documentação das APIs e usar o item para concluir a chamada.
- Chamar pela página web, basta saltar para as APIs do LifeUp por hiperlink.
- Chamar por um app que você desenvolveu, use Intent para saltar para o link de interface correspondente.
- Chamar por uma ferramenta de automação (como Tasker), preencha o link da API correspondente em Browser URL do Tasker.

**Alguns exemplos:**

Ao clicar no link abaixo, o «LifeUp» exibirá «You have learned to call APIs!».

<a href="lifeup://api/toast?text=You have learned to call APIs!&type=1&isLong=true">lifeup://api/toast?text=You have learned to call APIs!&type=1&isLong=true</a>

Ao clicar no link abaixo, você receberá uma moeda no «LifeUp», e o motivo será «Learn API Calls».

<a href="lifeup://api/reward?type=coin&content=Learn API Calls&number=1">lifeup://api/reward?type=coin&content=Learn API Calls&number=1</a>

Se copiar o link para o efeito «link» do item, usar o item também acionará o mesmo efeito.

**Exemplo de integração com aplicativo externo:**

[Wordle Clone (lifeupapp.fun)](https://wiki.lifeupapp.fun/en/example/wordle/index.html)

Wordle é um pequeno jogo de adivinhar palavras: adivinhe palavras de 5 letras. Laranja indica que a letra está na resposta; verde, que está na posição correta.

**Esta versão do Wordle suporta integração com o «LifeUp»:**

1. Se acertar a palavra, você recebe 10 moedas, com um motivo personalizado.
2. Se não acertar no final, há um prêmio de consolação de 1 moeda.

![](_media/api/wordle.png ':size=30%')

<br/>

**Exemplo de integração com Tasker:**

> O Tasker é acionado selecionando `Action Category`→`Program`→`Shortcut`. Informe na coluna de atalho o link que começa com lifeup://.

Desbloquear a tela pela primeira vez após as 5h todos os dias pode acionar a conclusão da Tarefa que você indicar (por exemplo, acordar).

**Nota: É necessário um Task Group Id para importar esta configuração. Você pode ativar [Developer Mode] em [Settings]→[Labs] e consultar o gid na página de detalhes da Tarefa.**

Se você tiver o Tasker instalado, [clique aqui para importar as Tarefas configuradas.](taskerproject://H4sIAAAAAAAAAKVWTW/bOBA9p7+CENCeshZlfcWtzMJts0ABY1EkaS49FKxE20xlSZDG3s2/3xmSku1ELer25OF7Q/LNB0fO7mT3XbUfJEjWtXPPY8Vez73AY7Cfe8mETwLuiRcX2ae2XulSGacG7ejKY3s196bEXmR5IUGJIEl4NONxMAvDMPMtaOiyEdDuFGJoEaKON4RRMA2vMl8NG1alXHcCIWsQpAsRIYA/tNrqgosozXxjEFJtlVgAi9mN6hSwu41iH+Rj5hNO/J3eWvl5XZmY6JqNiPGOjVttBcfV1q7AcOA4MBwYLvPpLMqK79IymqHZORk6yUcc8YDPfiEfsyf5SJ7k42/ddsA+V2Wdf1fFJXtfb5tSgWJU9kNqrveqgkNujmSj7rpAXZxj9MY08ZsNxrwFlNhvDca2JvFh50X2vq4KDbqulrqzV+qVdT/i7HlOSOjoi6zcdOJlpf4tqKy0cHjdiGCa+XXTAy1ymd/2Hpk/nGxF+CcqbEgmkJGaPqgc+po+8B+VNJmm05TPro5LWklM71Kv1OeGyR3ULHfZx8RLl/lGFx229SVV0tgEggGTS2pvsKBRRVLIpuIZSYBGlJyKQRlREiVpMEvO6C9qpmRopqbVVHKUhAYBi3woi8zBZSE9LnNMERzKfAut9W7XhzIOtUPWun10bYdu1DuynHvc859x059w4SmX+VbriOxgRHaY8mPZnRIrWXZYoc4h73ZV4R61icV11D16GRDvHvqzUjApdLUudZdvJrIq2loXEzATdnJzvby+X/xz9/V+cfNx8W55fStelfAGU4E7Fm0rH+0A9l+t4Q12yJln/Z6Ev+CxUeLL8kHu5aSU1Xpi9ZwvwJ7knhtlx700m79nTREMTVHiA9k1r31fNtrvX8jbtS7mL+myr2gNDXNSXPdM72Wr5bd+7u77yZ6XSrb1Dvp6DmvDqv+augWsHY6Jg20ovd3ugA7sdx4Awzf7XLtvmTEdWAhaF8OyEp/wxk4xXTU7YIBfIwqHrVFEwygm4+Tc8d0FVwTp4QQNAgwCPVKJo4zQ0uHO0fl1cBy2W5ncPUmYmSo0Sp6PlHRspHAeh/zHIyXk6TR+OlLSPxsp6W+MlNEmC8Znzhlz5YSLfsLFjgtHuMRxwbNZ1VfC/to/ZOLF/9uCy6GeCQAA)

![](_media/api/tasker_01.png ':size=30%')

![](_media/api/tasker_02.png ':size=30%')

<br/>

**Como usar o MacroDroid para chamar as APIs do LifeUp:**

> [MacroDroid](https://play.google.com/store/apps/details?id=com.arlosoft.macrodroid&hl=en_US&gl=US) também é uma ferramenta de automação; é gratuito para download e a interface é mais fácil de usar.

1. Adicione macros e configure as condições que precisar (ou faça isso depois)
2. Adicione `Actions`
3. Selecione `Applications`
4. Selecione `Open Website`
5. Informe uma URL que comece com `lifeup://` no campo `Enter URL`
6. **[Desmarque]** todas as opções abaixo, como `URL encode parameters`...
7. Salve; você pode clicar na ação e selecionar `Test action` para verificar

<br/>

**Com este recurso, você pode expandir infinitamente as possibilidades do LifeUp, tenha ou não conhecimento de programação!**

Consulte abaixo as regras específicas de chamada.

---

## Documentação de interfaces

### Basics - Examples

| Tipo             | Descrição   |
| ---------------- | ------------- |
| Exemplo          | <a href="lifeup://api/toast?text=You learned to call! &type=1&isLong=true">lifeup://api/toast?text=You learned to call! &type=1&isLong=true</a> |
| Formato de interface | fixed prefix/method name?parameter1=value1&parameter2=value2 |
| Prefixo fixo     | lifeup://api/ |
| Nome do método      | toast         |
| Parâmetros       | ?text=You learned to call! &type=1&isLong=true |

<br/>

### Basics - Escaping (URL Encode)

Se o valor do seu parâmetro contiver símbolos especiais como +, espaço, =, %, &, #, etc., é preciso escapá-los:

| Caracteres especiais | Significado                                         | Substituir por |
| :----------------- | :---------------------------------------------- | :--------- |
| +                  | O sinal + na URL representa um espaço        | +          |
| espaços             | Espaços em URLs podem ser + ou codificados              | %20        |
| /                  | Separa diretório e subdiretório            | %2F        |
| ?                  | Separa a URL real e os parâmetros         | %3F        |
| %                  | Especifica caracteres especiais                      | %          |
| #                  | Indica marcador                                  | %23        |
| &                  | Separador entre parâmetros na URL   | %26        |
| =                  | Valor do parâmetro indicado na URL | %3D        |

Tomando como exemplo a interface da mensagem pop-up acima: se quiser que o texto final exibido seja `You have learned to call APIs!`,
é preciso substituir os espaços por +; o resultado final é:

<a href="lifeup://api/toast?text=You learned to call! &type=1&isLong=true">lifeup://api/toast?text=You learned to call! &type=1&isLong=true</a>
<br/>

**Esta é uma ferramenta simples de codificação implementada em Javascript:**

<iframe src="guide/html/url_encoded.html" frameborder="0" scrolling="no" width="90%"> </iframe>

<br/>

### Basics - LifeUp Data ID

Quase todos os dados armazenados no LifeUp têm um id único.

Algumas das interfaces abaixo permitem modificar itens da Loja **específicos** e concluir Tarefas **específicas**.

Para o `LifeUp` encontrar os dados correspondentes, você precisa fornecer um id.

**Você pode ativar «Settings» → «Labs» → «Developer Mode» para ver o id original dos dados em cada página de detalhes do App.**

Por exemplo, se o nome do Atributo for exibido como «strength (1)», seu id de Atributo é 1.

#### Task id

Pode ser consultado na página de detalhes do evento.

id: Se for uma Tarefa repetitiva, o id será atualizado a cada repetição.

gid: O id do grupo de itens. Para a mesma Tarefa repetitiva, seu gid não muda.

#### List id

Após ativar «Developer Mode», consulte na janela pop-up «Select List».

#### Attribute id

Após ativar «Developer Mode», consulte na página «Custom Attributes».

#### Shop item id

Após ativar «Developer Mode», clique no item da Loja para ver os detalhes.

#### Achievement condition id

Após personalizar a condição de desbloqueio da Conquista «requires an external API call to unlock», você pode ver o id da condição na página de detalhes.

<br/>

### Basics - Name Matching

Quando uma API suporta buscar Tarefas, itens da Loja ou subtarefas por nome, o LifeUp tenta primeiro uma correspondência exata ignorando maiúsculas e minúsculas. Se não houver correspondência exata, recorre à correspondência difusa por contenção.

Por exemplo, se existirem «Coin» e «Coin Box», passar `name=Coin` corresponde primeiro a «Coin» em vez do primeiro resultado difuso que aparecer.

Se nomes duplicados ou similares puderem ser ambíguos, prefira informar o id correspondente.

<br/>

### Basics - Return Values

Algumas interfaces podem ter valores de retorno.

**Se você está desenvolvendo um aplicativo Android,** pode usar o método `onActivityResult` para receber o valor de retorno.

**Se você usa um aplicativo de automação como Tasker:**

Em geral, esses aplicativos não conseguem receber valores de retorno do tipo Activity. É preciso adicionar um parâmetro `broadcast` e usar o evento `received intent` para receber o valor de retorno.

Para detalhes, consulte os parâmetros broadcast abaixo.

<br/>

### Basics - JSON Data Structure

?> Requer v1.98.0+

Esta seção apresenta as estruturas JSON de uso frequente na API.

#### 1. Estrutura de Recompensa de Itens

Um array JSON que especifica Recompensas de Itens; cada item contém um ID e uma quantidade.

```json
[
    {
        "item_id": 1,    // Item ID
        "amount": 2      // Quantity
    },
    {
        "item_id": 2,
        "amount": 3
    }
]
```

#### 2. Estrutura de condição de desbloqueio de Conquistas

```json
[
    {
        "type": 7,           // Condition type
        "related_id": null,  // Related ID (some types must provide)
        "target": 1000000    // Target value
    }
]
```

#### 3. Estrutura de limite de compra

`purchase_limit` é um array JSON. Cada objeto representa uma regra de restrição.

| Campo | Significado | Tipo | Obrigatório | Notas |
| ----- | ------- | ---- | -------- | ----- |
| limitType | Tipo de restrição | number | Sim | Veja a tabela de tipos abaixo |
| limitNumber | Valor numérico principal | number | Não* | Usado por regras baseadas em quantidade/intervalo |
| maxNumber | Limite superior de um intervalo | number | Não | Usado por intervalo de Nível de Atributo / quantidade de Itens possuídos |
| limitId | ID do alvo relacionado | number | Não* | Obrigatório para regras baseadas em Atributo / Item / Tarefa / ciclo de Tarefa / Conquista |
| extendInfo | Dados adicionais | string | Não | Usado por regras baseadas em tempo; o valor em si é uma string JSON |

**Definição de tipos**

| limitType | Significado | Campos obrigatórios / notas |
| --------- | ------- | ----------------------- |
| 0 | Limite diário de quantidade | `limitNumber`: máximo de vezes por dia |
| 1 | Limite semanal de quantidade | `limitNumber`: máximo de vezes por semana |
| 2 | Limite mensal de quantidade | `limitNumber`: máximo de vezes por mês |
| 3 | Limite anual de quantidade | `limitNumber`: máximo de vezes por ano |
| 10 | Regra de Nível de Atributo | `limitId`: ID de Atributo<br/>`limitNumber`: nível mínimo<br/>`maxNumber`: nível máximo opcional |
| 20 | Intervalo horário diário | `extendInfo`: `{"startMinuteOfDay":540,"endMinuteOfDay":1320}` |
| 21 | Seleção de dias da semana | `extendInfo`: `{"weekdays":[1,2,3,4,5]}`<br/>Segunda-feira = 1, domingo = 7 |
| 22 | Intervalo horário absoluto | `extendInfo`: `{"startMillis":1710000000000,"endMillis":1710086400000}` |
| 23 | Seleção de meses | `extendInfo`: `{"months":[1,6,12]}` |
| 24 | Seleção de dia do mês | `extendInfo`: `{"daysOfMonth":[1,15,31]}` |
| 30 | Regra de quantidade de Itens possuídos | `limitId`: ID do Item alvo<br/>`limitNumber`: quantidade mínima possuída<br/>`maxNumber`: quantidade máxima possuída opcional |
| 31 | Regra de Tarefa concluída | `limitId`: ID de Tarefa |
| 32 | Regra de Conquista desbloqueada | `limitId`: ID de Conquista |
| 33 | Regra de ciclo de Tarefa concluído | `limitId`: ID do grupo de Tarefas repetitivas (`groupId`)<br/>Validado contra o último ciclo iniciado nesse grupo |

**Notas**

- Quando `limitType=33`, `limitId` não é um ID de Tarefa. Deve ser o `groupId` da Tarefa repetitiva.

- Payloads compatíveis com versões anteriores podem omitir `maxNumber` e `extendInfo`.
- `extendInfo` é um campo do tipo string; ao chamar a API por URL, a string JSON interna geralmente precisa de outra camada de escape/codificação.

**Exemplo:**

```json
[
    {
        "limitType": 0,
        "limitNumber": 5
    },
    {
        "limitType": 10,
        "limitId": 1,
        "limitNumber": 5,
        "maxNumber": 10
    }
]
```

#### 4. Estrutura de efeito de Item

```json
[
    {
        "type": 2,           // Effect type
        "info": {            // Effect parameters, different for different types
            "min": 100,      // Minimum value (used for gold rewards, etc.)
            "max": 200       // Maximum value (used for gold rewards, etc.)
        }
    }
]
```

#### Descrição de tipos de efeito

?> Tipos 10-16 são suportados a partir de v1.102.0+.

| Código de tipo | Significado | Descrição de parâmetros |
| ------- | ---- | ------- |
| 0 | Sem efeito especial | Sem parâmetros |
| 1 | Não utilizável | Sem parâmetros |
| 2 | Adicionar moedas | min: Moedas mínimas<br/>max: Moedas máximas (opcional, padrão min)<br/>using_limit: Se aplicar limites do sistema (opcional) |
| 3 | Remover moedas | min: Moedas mínimas<br/>max: Moedas máximas (opcional, padrão min)<br/>using_limit: Se aplicar limites do sistema (opcional) |
| 4 | Adicionar experiência | ids: Array de ID de Habilidade<br/>value: Valor de experiência (legado, igual a min)<br/>min: Experiência mínima (opcional, se value não for informado)<br/>max: Experiência máxima (opcional, padrão min/value)<br/>using_limit: Se usar limite (opcional, padrão false) |
| 5 | Remover experiência | ids: Array de ID de Habilidade<br/>value: Valor de experiência (legado, igual a min)<br/>min: Experiência mínima (opcional, se value não for informado)<br/>max: Experiência máxima (opcional, padrão min/value)<br/>using_limit: Se usar limite (opcional, padrão false) |
| 6 | Síntese simples | require_number: Quantidade necessária<br/>item_id: ID de Item |
| 7 | Abrir caixa | items: Array de Itens; cada item contém:<br/>- item_id: ID de Item<br/>- amount: Quantidade<br/>- probability: Probabilidade<br/>- is_fixed_reward: Se é Recompensa fixa |
| 8 | Contagem regressiva | seconds: Segundos da contagem regressiva |
| 9 | Link web | url: Endereço do link<br/>use_web_view: Se usar o navegador integrado (opcional, padrão false) |
| 10 | Registrar Reflexão | Sem parámetros |
| 11 | Alterar moedas (aumentar ou diminuir) | min: Moedas mínimas (pode ser negativo)<br/>max: Moedas máximas (opcional, padrão min)<br/>using_limit: Se aplicar limites do sistema (opcional) |
| 12 | Alterar experiência (aumentar ou diminuir) | ids: Array de ID de Habilidade<br/>value: Valor de experiência (legado, igual a min)<br/>min: Experiência mínima (pode ser negativa)<br/>max: Experiência máxima (opcional, padrão min/value)<br/>using_limit: Se usar limite (opcional, padrão false) |
| 13 | Adicionar estoque de Item | item_id: ID do Item alvo<br/>min: Alteração mínima de estoque<br/>max: Alteração máxima de estoque (opcional, padrão min)<br/>using_limit: Se aplicar limites de estoque (opcional) |
| 14 | Remover estoque de Item | item_id: ID do Item alvo<br/>min: Alteração mínima de estoque<br/>max: Alteração máxima de estoque (opcional, padrão min)<br/>using_limit: Se aplicar limites de estoque (opcional) |
| 15 | Alterar estoque de Item (aumentar ou diminuir) | item_id: ID do Item alvo<br/>min: Alteração mínima de estoque (pode ser negativa)<br/>max: Alteração máxima de estoque (opcional, padrão min)<br/>using_limit: Se aplicar limites de estoque (opcional) |
| 16 | Reproduzir som | file_name: Nome do arquivo de som local (preferido)<br/>uri: URI do som a importar (alternativa a file_name)<br/>display_name: Nome de exibição (opcional) |

**Exemplos de efeito:**

Aumentar ouro aleatório:

```json
{
    "type": 2,
    "info": {
        "min": 100,
        "max": 200
    }
}
```

Aumentar Pontos de Experiência:

```json
{
    "type": 4,
    "info": {
        "ids": [1, 2],
        "value": 50,
        "using_limit": false
    }
}
```

Alterar moedas (aleatório +/-):

```json
{
    "type": 11,
    "info": {
        "min": -10,
        "max": 20
    }
}
```

Alterar estoque de Item (aleatório +/-):

```json
{
    "type": 15,
    "info": {
        "item_id": 1,
        "min": -3,
        "max": 5
    }
}
```

Reproduzir som:

```json
{
    "type": 16,
    "info": {
        "display_name": "API test sound",
        "uri": "android.resource://net.sarasarasa.lifeup/raw/bellringing"
    }
}
```

Efeito de abrir caixa:

```json
{
    "type": 7,
    "info": {
        "items": [
            {
                "item_id": 1,
                "amount": 1,
                "probability": 50,
                "is_fixed_reward": false
            },
            {
                "item_id": 2,
                "amount": 1,
                "probability": 50,
                "is_fixed_reward": true
            }
        ]
    }
}
```

<br/>

### Popup message

**Nome do método:** toast

**Descrição:** Exibe mensagens pop-up de vários estilos

**Exemplo:** <a href="lifeup://api/toast?text=Live well, eat well!&type=1&isLong=true">lifeup://api/toast?text=Live well, eat well!&type=1&isLong=true</a>

**Explicação:** A mensagem «Live well, eat well!» aparece no estilo de bônus e permanece visível por mais tempo.

> Clique no link do exemplo para testar o efeito

| Parâmetro | Significado                | Tipo               | Exemplo              | Obrigatório | Notas |
| --------- | ---------------------- | ------------------ | -------------------- | -------- | ----- |
| text      | Texto da mensagem | Qualquer texto           | You learned to call! | sim      |       |
| type      | Estilo do texto        | Número de 0 a 6 | 1                    | não       | 0 - Estilo normal<br/>1 - Estilo bônus<br/>2 - Estilo tomate<br/>3 - Estilo sucesso<br/>4 - Estilo aviso<br/>5 - Estilo alerta<br/>6 - Estilo erro |
| isLong    | Duração da exibição       | true ou false      | true                 | não       | true - longa<br/>false - curta |

<br/>

### Reward

**Nome do método:** reward

**Descrição:** Concede a Recompensa diretamente. O motivo pode ser personalizado.

**Exemplo:**

- Receber 1 moeda; o motivo é «Learn API Calls». O motivo será exibido na página de detalhes de moedas:

  <a href="lifeup://api/reward?type=coin&content=Learn API Calls&number=1">lifeup://api/reward?type=coin&content=Learn API Calls&number=1</a>

- Receber 300 Pontos de Experiência para «Learning, Creativity»; o motivo é «Learn API Calls». O motivo será exibido na página de detalhes de EXP:

  <a href="lifeup://api/reward?type=exp&content=Learn API Calls&number=300&skills=2&skills=6">lifeup://api/reward?type=exp&content=Learn API Calls&number=300&skills=2&skills=6</a>

- Receber 1 Item com correspondência difusa «treasure»; o motivo é «Learn API Calls». O motivo será exibido no histórico do Inventário:

  <a href="lifeup://api/reward?type=item&content=Learn API Calls&number=1&item_name=treasure">lifeup://api/reward?type=item&content=Learn API Calls&number=1&item_name=treasure</a>

| Parâmetro | Significado                       | Tipo                            | Exemplo            | Obrigatório | Notas                            |
| --------- | ----------------------------- | ------------------------------- | ------------------ | -------- | -------------------------------- |
| type      | Tipo de Recompensa                   | atualmente só admite:<br/>coin<br/>exp<br/>item | coin | sim | coin - moedas<br/>exp - Pontos de Experiência<br/>item - Itens da Loja |
| content   | Motivo da Recompensa                 | qualquer texto                        | Learning API Calls | Sim      |                                  |
| skills    | Habilidades (Atributos)           | array de números maiores que 0 | 1                  | Não       | Somente quando type é exp<br/>Admite arrays (p. ex. &skills=1&skills=2&skills=3)<br/>Para saber como obtê-los, consulte o artigo «Basics - LifeUp Data ID» acima |
| number    | Quantidade de Recompensas             | número maior que 0         | 1                  | Sim      | Se forem moedas, o máximo é 999999<br/>Se forem Pontos de Experiência, o máximo é 99999<br/>Se for um Item, o máximo é 999 |
| item_id   | ID do Item                       | número maior que 0           | 1                  | não*      | somente quando type é item |
| item_name | Nome do Item                     | qualquer texto                        | treasure           | não*      | somente quando type é item; correspondência difusa com nomes de Itens |
| silent    | Desativar avisos da interface | true ou false                   | false              | não       | false por padrão                 |

<br/>

### Penalty

**Nome do método:** penalty

**Descrição:** Aplica uma penalidade diretamente. O motivo pode ser personalizado.

**Exemplo:** *Basicamente igual à interface reward

- Penalizar 1 moeda; o motivo é «sleep in». O motivo será exibido na página de detalhes de moedas:

  <a href="lifeup://api/penalty?type=coin&content=sleep in&number=1">lifeup://api/penalty?type=coin&content=sleep in&number=1</a>

- Penalizar 300 Pontos de Experiência de «Strength» por «sleep in». O motivo será exibido na página de detalhes de EXP:

  <a href="lifeup://api/penalty?type=exp&content=sleep in&number=300&skills=1">lifeup://api/penalty?type=exp&content=sleep in&number=300&skills=1</a>

- Penalizar 1 Item com correspondência difusa «treasure» por «sleep in». O motivo será exibido no histórico do Inventário:

  <a href="lifeup://api/penalty?type=item&content=sleep in&number=1&item_name=treasure">lifeup://api/penalty?type=item&content=sleep in&number=1&item_name=treasure</a>

| Parâmetro | Significado                       | Tipo                                                 | Exemplo  | Obrigatório | Notas            |
| --------- | ----------------------------- | ---------------------------------------------------- | -------- | -------- | ---------------- |
| type      | Tipo de penalidade                  | Atualmente só admite:<br/>coin<br/>exp<br/>item | coin     | sim      | coin - moedas<br/>exp - Pontos de Experiência<br/>item - Itens da Loja |
| content   | Motivo da penalidade            | qualquer texto                                             | Sleep In | Sim      |                  |
| skills    | Habilidades (Atributos)           | array de números maiores que 0                      | 1        | Não       | Somente quando type é exp<br/>Admite arrays (p. ex. &skills=1&skills=2&skills=3)<br/>Para saber como obtê-los, consulte o artigo «Basics - LifeUp Data ID» acima |
| number    | Quantidade penalizada             | número maior que 0                              | 1        | Sim      | Se forem moedas, o máximo é 999999<br/>Se forem Pontos de Experiência, o máximo é 99999<br/>Se for um Item, o máximo é 999 |
| item_id   | ID do Item                       | número maior que 0                                | 1        | não*      | somente quando type é item |
| item_name | Nome do Item                     | qualquer texto                                             | treasure | não*      | somente quando type é item; correspondência difusa com nomes de Itens |
| silent    | Desativar avisos da interface | true ou false                                        | false    | não       | false por padrão |

<br/>

### Edit Coin

**Nome do método:** edit_coin

**Descrição:** Edita diretamente o saldo de moedas do usuário. O saldo atual será definido para o valor indicado. O motivo da alteração pode ser personalizado e será exibido no histórico de moedas.

**Exemplo:**

- Definir moedas como 1000 com motivo «API adjustment»: <a href="lifeup://api/edit_coin?coin=1000&content=API adjustment">lifeup://api/edit_coin?coin=1000&content=API adjustment</a>
- Definir moedas como 500 em silêncio: <a href="lifeup://api/edit_coin?coin=500&silent=true">lifeup://api/edit_coin?coin=500&silent=true</a>

| Parâmetro | Significado | Tipo | Exemplo | Obrigatório | Notas |
| --------- | ------- | ---- | ------- | -------- | ----- |
| coin | Saldo alvo de moedas | number >= 0 | 1000 | Sim | Saldo final após a operação; máximo 999999 |
| content | Motivo da alteração | qualquer texto | API adjustment | Não | Se não informado, usa o motivo padrão do sistema |
| reason | Motivo da alteração (alias) | qualquer texto | API adjustment | Não | Alternativa ao parâmetro content |
| silent | Desativar notificação da interface | true ou false | false | Não | false por padrão; true suprime a mensagem toast |

<br/>

### Tasks

#### Add a Task

?> Alguns campos como `pin` exigem v1.98.0+

**Nome do método:** add_task

**Descrição:** Cria uma Tarefa diretamente

**Exemplo:**
[lifeup://api/add_task?todo=This is an auto-added task&notes=notes&coin=10&coin_var=1&exp=2048&skills=1&skills=2&skills=3&category=0&item_name=coin](lifeup://api/add_task?todo=This is an auto-added task&notes=notes&coin=10&coin_var=1&exp=2048&skills=1&skills=2&skills=3&category=0&item_name=coin)

| Parâmetro         | Significado             | Valores                | Exemplo   | Obrigatório | Notas                           |
| ---------------- | ------------------- | -------------------- | --------- | -------- | ------------------------------- |
| todo             | Conteúdo da Tarefa        | qualquer texto             | Write diary | Sim     |                                |
| notes            | Notas               | qualquer texto             | Notes      | Não       | Vazio por padrão               |
| coin             | Recompensa em moedas         | number >= 0         | 10         | Não       | 0 por padrão; sujeito a limites do sistema                   |
| coin_var         | Variação de moedas| number >= 0          | 1          | Não       | 0 por padrão; se >0, Recompensa aleatória entre [coin, coin+coin_var] |
| exp              | Recompensa de Pontos de Experiência   | number >= 0          | 100        | Não       | 0 por padrão; sujeito a limites do sistema                   |
| skills           | ID de Habilidade           | array de números > 0 | 1          | Não       | Admite arrays (p. ex., &skills=1&skills=2) |
| category         | ID da lista             | number >= 0          | 0          | Não       | 0 por padrão (lista padrão); não admite listas inteligentes |
| frequency        | Frequência de repetição    | integer              | 0          | Não       | 0 por padrão (uma vez)<br/>0 - Uma vez<br/>1 - Diária<br/>N (N>1) - A cada N dias<br/>-1 - Ilimitada<br/>-3 - Ebbinghaus (requer v1.99.1)<br/>-4 - Mensal<br/>-5 - Anual |
| weekdays         | Dias da semana            | `1,3,5` ou `none`    | 1,3,5      | Não       | v1.106.0+; 1=segunda … 7=domingo, dias **em que se repete**. Se informado, frequency deve ser omitido ou 1. `none` é rejeitado ao adicionar; ao editar, `none` restaura para diária. Os 7 dias são tratados como diária |
| importance       | Nível de importância    | [1, 4]              | 1          | Não       | 1 por padrão                   |
| difficulty       | Nível de dificuldade    | [1, 4]              | 1          | Não       | 1 por padrão                   |
| deadline         | Prazo            | timestamp (milissegundos) | 1640995200000 | Não |                               |
| no_deadline      | Sem prazo         | true/false         | true      | Não       | v1.104.0+; válido apenas para Tarefas repetitivas. Informar `&no_deadline=true` limpa o prazo específico |
| color            | Cor da etiqueta           | string de cor         | #66CCFF    | Não       | # deve ser escapado como %23        |
| background_url   | URL da imagem de fundo| URL web             | http://example.com/bg.jpg | Não | Deve ser uma imagem web acessível |
| background_alpha | Opacidade do fundo  | float entre [0, 1] | 0.5        | Não       | 1.0 por padrão                |
| enable_outline   | Contorno de texto | true ou false       | false      | Não       | Válido apenas com background_url; adiciona contorno ao texto para melhor legibilidade |
| use_light_remark_text_color | Texto claro para notas | true ou false | false | Não | Válido apenas com background_url; usa cor clara para as notas |
| start_time       | Hora de início          | timestamp (milissegundos) | 1640995200000 | Não | Hora de início da Tarefa              |
| auto_use_item    | Usar Itens de Recompensa automaticamente| true ou false      | false      | Não       | Usa as Recompensas automaticamente ao concluir |
| remind_time      | Hora do lembrete       | timestamp (milissegundos) | 1640995200000 | Não | Hora do lembrete da Tarefa          |
| pin              | Fixar Tarefa            | true ou false       | false      | Não       | Fixa a Tarefa no topo                |
| words            | Texto de Recompensa ao concluir | qualquer texto         | Great job! | Não       | Texto motivacional ao concluir a Tarefa |
| frozen           | Estado de congelamento       | true ou false       | false      | Não       | false por padrão              |
| freeze_until     | Congelar até        | timestamp (milissegundos) | 1640995200000 | Não | Efetivo apenas quando frozen é true |
| coin_penalty_factor | Fator de penalidade em moedas| float entre [0, 100) | 0.5    | Não       |                               |
| exp_penalty_factor | Fator de penalidade de experiência| float entre [0, 100) | 0.5 | Não    |                               |
| write_feelings   | Ativar Reflexões     | true ou false       | false      | Não       | false por padrão              |
| item_id          | ID do Item             | number > 0          | 1          | No*      | É necessário item_id ou item_name |
| item_name        | Nome do Item           | qualquer texto            | Treasure   | No*      | É necessário item_id ou item_name |
| item_amount      | Quantidade do Item       | [1, 99]             | 1          | Não       | 1 por padrão                  |
| items            | Recompensas de Itens        | texto JSON           | Ver [Estrutura de Recompensa de Itens](#1-item-rewards-structure) | Não | Define várias Recompensas de Itens |
| task_type        | Tipo de Tarefa           | [0, 4]              | 0          | Não       | Requer v1.99.1<br/>0 - Tarefa normal<br/>1 - Tarefa de contagem<br/>2 - Tarefa negativa<br/>3 - Tarefa API<br/>4 - Tarefa cronometrada (v1.102.0+) |
| target_times     | Vezes alvo        | number > 0          | 1          | Não       | Válido apenas quando task_type é 1 (tarefa de contagem) |
| is_affect_shop_reward | Afeta Recompensa da Loja | true/false      | false    | Não       | Válido apenas quando task_type é 1 (tarefa de contagem); se afeta o cálculo de Recompensa de Itens |
| enable_proportional_settlement | Liquidação proporcional | true/false | false | Não | v1.104.0+; válido apenas quando task_type é 1 (tarefa de contagem). Quando ativado, a liquidação do progresso de contagem concede Recompensas proporcionalmente e a conclusão final não concede novamente o que já foi liquidado |
| expected_focus_minutes | Minutos de Foco esperados | number > 0 | 25 | Não | Válido apenas quando task_type é 4 (tarefa cronometrada); 25 por padrão (v1.102.0+) |
| repeat_end_mode | Modo de fim de repetição | 0 ou 1 | 0 | Não | Válido apenas para Tarefas repetitivas (frequency não é 0 / -1)<br/>0 - Terminar por quantidade<br/>1 - Terminar por data (v1.102.0+) |
| repeat_target_times | Quantidade de fim de repetição | number > 0 | 3 | Não | Usado quando repeat_end_mode=0 (ou inferido por este campo); não confundir com target_times (v1.102.0+) |
| repeat_end_date | Data de fim de repetição | timestamp (milissegundos) | 1640995200000 | Não | Usado quando repeat_end_mode=1 (ou inferido por este campo) (v1.102.0+) |
| repeat_end_behavior | Comportamento ao terminar a repetição | 0 ou 1 | 0 | Não | 0 - Encerrar a Tarefa ao atingir a condição<br/>1 - Congelar a Tarefa ao atingir a condição (v1.102.0+) |

**Resposta:**

| Campo    | Tipo    | Descrição      | Exemplo | Notas                    |
| -------- | ------- | ---------------- | ------- | ------------------------ |
| task_id  | Number  | ID da Tarefa          | 1000    |                          |
| task_gid | Number  | ID do grupo de Tarefas    | 1000    |                          |

<br/>

#### Complete a Task

**Nome do método:** complete

**Descrição:** Aciona a conclusão de uma Tarefa. Busca apenas Tarefas não concluídas.

**Exemplo:**

- Concluir a Tarefa com id 1: [lifeup://api/complete?id=1](lifeup://api/complete?id=1)
- Concluir a Tarefa com «task group id» 1: [lifeup://api/complete?gid=1](lifeup://api/complete?gid=1)
- Buscar Tarefas por nome e concluí-las: <a href="lifeup://api/complete?name=Start using&ui=true">lifeup://api/complete?name=Start using&ui=true</a>

**Explicação:**

Cada Tarefa tem um id.

Em Tarefas repetitivas, o id é renovado a cada repetição, mas o «task group id» permanece o mesmo.

Para obter o id, ative o «Developer Mode» na página «Labs» e consulte-o na página «Task Details».

| Parâmetro | Significado                         | Tipo                  | Exemplo | Obrigatório | Notas |
| --------- | ------------------------------- | --------------------- | ------- | -------- | ----- |
| id        | ID da Tarefa                         | número maior que 0 | 1       | no*      | ID da Tarefa; em Tarefas repetitivas, o id é atualizado a cada repetição. |
| gid       | ID do grupo de Tarefas                   | número maior que 0 | 1       | no*      | ID do grupo de Tarefas; |
| name      | nome                            | qualquer texto              | get up  | no*      | busca difusa; apenas uma das Tarefas encontradas |
| ui        | Exibir a interface pop-up | true ou false         | true    | não       | false por padrão; apenas uma mensagem é exibida em segundo plano |
| count                    | Valor de contagem                        | Number                                                 | 1         | Não       | Aplicável apenas a tarefas de contagem; use junto com o parâmetro `count_set_type`     |
| count_set_type           | Como definir o valor de contagem         | Um dos seguintes:<br/>absolute<br/>relative        | absolute  | Não       | relative por padrão<br/>absolute - Define o alvo diretamente para o valor<br/>relative - Soma ou subtrai com base no valor original |
| count_force_sum_up       | Forçar soma de Recompensas de tarefa de contagem  | true ou false                                          | true      | Não       |                                                                                                    |
| reward_factor            | Fator de Recompensa                      | Número decimal maior que 0                   | 1.1       | Não       | Não aplicável a tarefas de contagem<br/>O fator afeta a quantidade de experiência e moedas (não a quantidade de Itens) |

**Aviso:**

1. Para localizar a Tarefa, é necessário informar id, gid ou name.
2. Tarefas cronometradas não podem ser concluídas manualmente por esta API (v1.102.0+).

<br/>

#### Give up a Task

**Nome do método:** give_up

**Descrição:** Aciona o abandono de uma Tarefa.

**Exemplo:**

- Buscar Tarefas por nome e abandoná-las: [lifeup://api/give_up?name=get up early](lifeup://api/give_up?name=get up early)

**Explicação:**

| Parâmetro | Significado       | Tipo                  | Exemplo | Obrigatório | Notas |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id        | ID da Tarefa       | número maior que 0 | 1       | no*      | ID da Tarefa; em Tarefas repetitivas, o id é atualizado a cada repetição. |
| gid       | ID do grupo de Tarefas | número maior que 0 | 1       | no*      | ID do grupo de Tarefas; |
| name      | nome          | qualquer texto              | get up  | no*      | busca difusa; opera sobre uma única Tarefa correspondente |

**Aviso:**

1. Para localizar a Tarefa, é necessário informar id, gid ou name.

<br/>

#### Freeze a task

**Nome do método:** freeze

**Descrição:** Congela uma Tarefa; apenas para Tarefas repetitivas.

**Exemplo:**

- Buscar Tarefas por nome e congelá-las: [lifeup://api/freeze?name=get up early](lifeup://api/freeze?name=get up early)

**Explicação:**

| Parâmetro | Significado       | Tipo                  | Exemplo | Obrigatório | Notas |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id        | ID da Tarefa       | número maior que 0 | 1       | no*      | ID da Tarefa; em Tarefas repetitivas, o id é atualizado a cada repetição. |
| gid       | ID do grupo de Tarefas | número maior que 0 | 1       | no*      | ID do grupo de Tarefas; |
| name      | nome          | qualquer texto              | get up  | no*      | busca difusa; opera sobre uma única Tarefa correspondente |
| time      | Congelar até  | timestamp             | 1661688800682 | não | - |

**Aviso:**

1. Para localizar a Tarefa, é necessário informar id, gid ou name.

<br/>

#### Unfreeze a task

**Nome do método:** unfreeze

**Descrição:** Descongela uma Tarefa.

**Exemplo:**

- Buscar Tarefas por nome e descongelá-las: [lifeup://api/unfreeze?name=get up early](lifeup://api/unfreeze?name=get up early)

**Explicação:**

| Parâmetro | Significado       | Tipo                  | Exemplo | Obrigatório | Notas |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id        | ID da Tarefa       | número maior que 0 | 1       | no*      | ID da Tarefa; em Tarefas repetitivas, o id é atualizado a cada repetição. |
| gid       | ID do grupo de Tarefas | número maior que 0 | 1       | no*      | ID do grupo de Tarefas; |
| name      | nome          | qualquer texto              | get up  | no*      | busca difusa; opera sobre uma única Tarefa correspondente |

**Aviso:**

1. Para localizar a Tarefa, é necessário informar id, gid ou name.

<br/>

#### Delete a task

**Nome do método:** delete_task

**Descrição:** Exclui uma Tarefa.

**Exemplo:**

- Buscar Tarefas por nome e excluí-las: [lifeup://api/delete_task?name=get up early](lifeup://api/delete_task?name=get up early)

**Explicação:**

| Parâmetro | Significado       | Tipo                  | Exemplo | Obrigatório | Notas |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id        | ID da Tarefa       | número maior que 0 | 1       | no*      | ID da Tarefa; em Tarefas repetitivas, o id é atualizado a cada repetição. |
| gid       | ID do grupo de Tarefas | número maior que 0 | 1       | no*      | ID do grupo de Tarefas; |
| name      | nome          | qualquer texto              | get up  | no*      | busca difusa; opera sobre uma única Tarefa correspondente |

**Aviso:**

1. Para localizar a Tarefa, é necessário informar id, gid ou name.

<br/>

### Edit Task

?> Requer v1.98.0+

**Nome do método:** edit_task

**Descrição:** Edita o conteúdo e as propriedades de uma Tarefa existente

**Exemplo:**
[lifeup://api/edit_task?id=1&todo=Modified task content&notes=notes&coin=10&exp=20&skills=1&skills=2&category=0](lifeup://api/edit_task?id=1&todo=Modified task content&notes=notes&coin=10&exp=20&skills=1&skills=2&category=0)

| Parâmetro           | Significado              | Valores                | Exemplo   | Obrigatório | Notas                           |
| ------------------ | -------------------- | -------------------- | --------- | -------- | ------------------------------- |
| id                 | ID da Tarefa              | número maior que 0 | 1        | No*      | É necessário id, gid ou name |
| gid                | ID do grupo de Tarefas        | número maior que 0 | 1        | No*      | É necessário id, gid ou name |
| name               | Nome da Tarefa            | qualquer texto             | Write diary| No*      | É necessário id, gid ou name |
| todo               | Conteúdo da Tarefa         | qualquer texto             | Write weekly| Não      |                                |
| notes              | Notas                | qualquer texto             | Note content| Não      |                                |
| coin               | Recompensa em moedas          | number >= 0         | 10        | Não       | Moedas ao concluir; sujeito a limites do sistema    |
| coin_var           | Variação de moedas        | número maior que 0 | 1        | Não       | Recompensa aleatória entre [coin, coin+coin_var] |
| exp                | Recompensa de Pontos de Experiência    | number >= 0          | 20        | Não       | Pontos de Experiência ao concluir; sujeito a limites do sistema        |
| skills             | ID de Habilidade            | array de números maiores que 0 | 1 | Não    | Admite arrays (p. ex., &skills=1&skills=2) |
| category           | ID da lista              | número maior ou igual a 0 | 0 | Não  | 0 para lista padrão; não admite listas inteligentes |
| frequency          | Frequência de repetição     | integer              | 0         | Não       | 0 por padrão (uma vez)<br/>0 - Uma vez<br/>1 - Diária<br/>N (N>1) - A cada N dias<br/>-1 - Ilimitada<br/>-3 - Ebbinghaus (requer v1.99.1)<br/>-4 - Mensal<br/>-5 - Anual |
| weekdays           | Dias da semana             | `1,3,5` ou `none`    | 1,3,5     | Não       | v1.106.0+; igual a add_task. Omitir para não alterar; `none` restaura para diária; definir frequency diferente de 1 também limpa weekdays |
| importance         | Nível de importância     | [1, 4]              | 1         | Não       | 1 por padrão                   |
| difficulty         | Nível de dificuldade     | [1, 4]              | 2         | Não       | 1 por padrão                   |
| deadline           | Prazo             | timestamp (milissegundos) | 1640995200000 | Não |                               |
| no_deadline        | Sem prazo          | true/false         | true     | Não       | v1.104.0+; válido apenas para Tarefas repetitivas. Informar `&no_deadline=true` limpa o prazo específico |
| remind_time        | Hora do lembrete        | timestamp (milissegundos) | 1640995200000 | Não |                               |
| start_time         | Hora de início           | timestamp (milissegundos) | 1640995200000 | Não |                               |
| color              | Cor da etiqueta            | string de cor         | #66CCFF   | Não       | # deve ser escapado como %23        |
| background_url     | URL da imagem de fundo | endereço URL web      | http://example.com/bg.jpg | Não |                         |
| background_alpha   | Opacidade do fundo   | decimal entre [0, 1] | 0.5 | Não   |                                |
| enable_outline     | Contorno de texto  | true ou false       | false      | Não       | Válido apenas com background_url; adiciona contorno ao texto para melhor legibilidade |
| use_light_remark_text_color | Texto claro para notas | true ou false | false | Não | Válido apenas com background_url; usa cor clara para as notas |
| item_id            | ID do Item              | número maior que 0 | 1        | No*      | É necessário item_id ou item_name |
| item_name          | Nome do Item            | qualquer texto             | Treasure  | No*      | É necessário item_id ou item_name |
| item_amount        | Quantidade do Item          | [1, 99]             | 1         | Não       | 1 por padrão                   |
| items              | JSON de Recompensas de Itens    | texto JSON           | [{"itemId":1,"amount":1}] | Não | Define várias Recompensas de Itens |
| auto_use_item      | Usar Item automaticamente        | true ou false        | false     | Não       |                                |
| frozen             | Estado de congelamento        | true ou false        | false     | Não       | false por padrão              |
| freeze_until       | Congelar até         | timestamp (milissegundos) | 1640995200000 | Não | Efetivo apenas quando frozen é true |
| coin_penalty_factor| Fator de penalidade em moedas  | decimal entre [0, 100) | 0.5 | Não |                                |
| exp_penalty_factor | Fator de penalidade de experiência | decimal entre [0, 100) | 0.5 | Não |                             |
| write_feelings     | Ativar Reflexões      | true ou false        | false     | Não       |                                |
| pin                | Fixar Tarefa             | true ou false        | false     | Não       |                                |
| words              | Texto de Recompensa ao concluir | qualquer texto           | Great job!| Não       | Texto motivacional ao concluir a Tarefa |
| task_type        | Tipo de Tarefa           | [0, 4]              | 0          | Não       | Requer v1.99.1<br/>0 - Tarefa normal<br/>1 - Tarefa de contagem<br/>2 - Tarefa negativa<br/>3 - Tarefa API<br/>4 - Tarefa cronometrada (v1.102.0+) |
| target_times     | Vezes alvo        | number > 0          | 1          | Não       | Válido apenas quando task_type é 1 (tarefa de contagem) |
| is_affect_shop_reward | Afeta Recompensa da Loja | true/false      | false    | Não       | Válido apenas quando task_type é 1 (tarefa de contagem); se afeta o cálculo de Recompensa de Itens |
| enable_proportional_settlement | Liquidação proporcional | true/false | false | Não | v1.104.0+; válido apenas quando task_type é 1 (tarefa de contagem). Em tarefas de contagem existentes, este parâmetro pode ser passado isoladamente para ativar ou desativar a liquidação proporcional; alterar esta configuração ou a de Recompensa pode redefinir ou reverter o progresso liquidado conforme as regras do App |
| expected_focus_minutes | Minutos de Foco esperados | number > 0 | 25 | Não | Válido apenas quando task_type é 4 (tarefa cronometrada); 25 por padrão (v1.102.0+) |
| repeat_target_times | Quantidade de fim de repetição | number > 0 | 3 | Não | Válido apenas para Tarefas repetitivas (frequency não é 0 / -1); se repeat_target_times e repeat_end_date forem informados, repeat_target_times tem prioridade (v1.102.0+) |
| repeat_end_date | Data de fim de repetição | timestamp (milissegundos) | 1640995200000 | Não | Válido apenas para Tarefas repetitivas (frequency não é 0 / -1) (v1.102.0+) |
| repeat_end_behavior | Comportamento ao terminar a repetição | 0 ou 1 | 0 | Não | 0 - Encerrar a Tarefa ao atingir a condição<br/>1 - Congelar a Tarefa ao atingir a condição (v1.102.0+) |
| coin_set_type     | Como definir o valor de moedas | Um de:<br/>absolute<br/>relative | absolute | Não | absolute - define coin diretamente para o valor<br/>relative - soma ou subtrai do valor original de coin |
| exp_set_type      | Como definir o valor de exp | Um de:<br/>absolute<br/>relative | absolute | Não | absolute - define exp diretamente para o valor<br/>relative - soma ou subtrai do valor original de exp |

**Resposta:**

| Campo     | Tipo    | Descrição      | Exemplo | Notas             |
| --------- | ------- | ---------------- | ------- | ---------------- |
| task_id   | Number  | ID da Tarefa          | 1000    |                  |
| task_gid  | Number  | ID do grupo de Tarefas    | 1000    |                  |

<br/>

### Task Templates

?> Introduzido em v1.102.0+

**Nome do método:** task_template

**Descrição:** CRUD de modelos de Tarefas.

**Exemplos:**

- Listar modelos: `lifeup://api/task_template?method=list`
- Criar a partir de parâmetros: `lifeup://api/task_template?method=create&name=MyTemplate&todo=Write diary&frequency=0`
- Criar a partir de uma Tarefa existente: `lifeup://api/task_template?method=create&name=MyTemplate&from_task_id=1`
- Obter modelo: `lifeup://api/task_template?method=get&id=1`
- Atualizar nome do modelo: `lifeup://api/task_template?method=update&id=1&name=NewName`
- Atualizar conteúdo do modelo a partir de uma Tarefa: `lifeup://api/task_template?method=update&id=1&from_task_id=1`
- Excluir modelo: `lifeup://api/task_template?method=delete&id=1`

| Parâmetro | Significado | Valor | Exemplo | Obrigatório | Notas |
| --------- | ------- | ----- | ------- | -------- | ----- |
| method | Operação | list / get / create / update / delete | list | Sim | - |
| id | ID do modelo | number > 0 | 1 | No* | Obrigatório para get/update/delete; alias: template_id |
| template_id | ID do modelo | number > 0 | 1 | No* | Alias de id |
| name | Nome do modelo | text | MyTemplate | No* | Obrigatório para create; obrigatório para update se não usar from_task_id/from_task_gid |
| from_task_id | Criar a partir do ID da Tarefa | number > 0 | 1 | Não | Para create/update |
| from_task_gid | Criar a partir do ID do grupo de Tarefas | number > 0 | 1 | Não | Para create/update |
| todo | Conteúdo da Tarefa | text | Write diary | No* | Obrigatório em create quando não usar from_task_id/from_task_gid |
| notes | Notas | text | Notes | Não | Vazio por padrão |
| category | ID da lista | number >= 0 | 0 | Não | Alias: category_id |
| category_id | ID da lista | number >= 0 | 0 | Não | Alias de category |
| frequency | Frequência de repetição | integer | 0 | Não | Igual a add_task |
| weekdays | Dias da semana | `1,3,5` | 1,3,5 | Não | v1.106.0+; igual a add_task; create rejeita `none` |
| importance | Nível de importância | [1, 4] | 1 | Não | - |
| difficulty | Nível de dificuldade | [1, 4] | 1 | Não | - |
| coin | Recompensa em moedas | number | 10 | Não | - |
| coin_var | Variação de moedas | number | 1 | Não | - |
| exp | Recompensa de Pontos de Experiência | number | 100 | Não | - |
| skills | ID de Habilidade | array params | 1 | Não | Admite arrays (p. ex., &skills=1&skills=2) |
| skill_ids | ID de Habilidade | JSON array ou lista separada por vírgulas | [1,2] | Não | Alternativa a skills |
| deadline | Prazo | timestamp (milissegundos) | 1640995200000 | Não | - |
| start_time | Hora de início | timestamp (milissegundos) | 1640995200000 | Não | - |
| remind_time | Hora do lembrete | timestamp (milissegundos) | 1640995200000 | Não | - |
| words | Texto de Recompensa ao concluir | text | Great job! | Não | - |
| task_type | Tipo de Tarefa | [0, 4] | 0 | Não | 0 - Normal<br/>1 - Contagem<br/>2 - Negativa<br/>3 - API<br/>4 - Cronometrada |
| target_times | Vezes alvo | number > 0 | 10 | Não | Válido apenas quando task_type é 1 (tarefa de contagem) |
| is_affect_shop_reward | Afeta Recompensa da Loja | true / false | false | Não | Válido apenas quando task_type é 1 (tarefa de contagem) |
| enable_proportional_settlement | Liquidação proporcional | true / false | false | Não | v1.104.0+; válido apenas quando task_type é 1 (tarefa de contagem). Tarefas criadas a partir do modelo mantêm esta configuração de liquidação de contagem |
| expected_focus_minutes | Minutos de Foco esperados | number > 0 | 25 | Não | Válido apenas quando task_type é 4 (tarefa cronometrada) |
| repeat_end_mode | Modo de fim de repetição | 0 ou 1 | 0 | Não | Válido apenas para Tarefas repetitivas (frequency não é 0 / -1)<br/>0 - Terminar por quantidade<br/>1 - Terminar por data |
| repeat_target_times | Quantidade de fim de repetição | number > 0 | 3 | Não | Usado quando repeat_end_mode=0 (ou inferido por este campo) |
| repeat_end_date | Data de fim de repetição | timestamp (milissegundos) | 1640995200000 | Não | Usado quando repeat_end_mode=1 (ou inferido por este campo) |
| repeat_end_behavior | Comportamento ao terminar a repetição | 0 ou 1 | 0 | Não | 0 - Encerrar<br/>1 - Congelar |

**Retorno:**

| Campo | Significado | Tipo | Notas |
| ----- | ------- | ---- | ----- |
| templates | lista de modelos (string JSON) | text | Apenas para method=list |
| count | quantidade de modelos | number | Apenas para method=list |
| template | detalhe do modelo (string JSON) | text | Apenas para method=get |
| id | ID do modelo | number | Para get/create/update/delete |
| name | nome do modelo | text | Para get/create/update |
| success | se teve sucesso | true / false | Para create/update/delete |

<br/>

### History Task Operation

?> Requer v1.98.0+

**Nome do método:** history_operation

**Descrição:** Opera sobre Tarefas concluídas, abandonadas ou vencidas

**Exemplos:**

- Excluir Tarefa do histórico: [lifeup://api/history_operation?id=1&operation=delete](lifeup://api/history_operation?id=1&operation=delete)
- Marcar Tarefa como abandonada: [lifeup://api/history_operation?id=1&operation=set_to_give_up](lifeup://api/history_operation?id=1&operation=set_to_give_up)
- Reiniciar Tarefa: [lifeup://api/history_operation?id=1&operation=restart](lifeup://api/history_operation?id=1&operation=restart)

!> Esta API se aplica apenas a Tarefas não pendentes (concluídas, abandonadas ou vencidas)

| Parâmetro      | Significado           | Valores               | Exemplo    | Obrigatório | Notas                           |
| ------------- | ----------------- | -------------------- | ---------- | -------- | ------------------------------- |
| id            | ID da Tarefa           | número maior que 0 | 1         | Sim      | ID da Tarefa do histórico          |
| operation     | Tipo de operação    | Um de:<br/>delete<br/>complete<br/>undo_complete<br/>set_to_give_up<br/>set_to_overdue<br/>edit_completed_time<br/>restart | delete | Sim | delete - Excluir Tarefa<br/>complete - Marcar como concluída<br/>undo_complete - Desfazer conclusão<br/>set_to_give_up - Marcar como abandonada<br/>set_to_overdue - Marcar como vencida<br/>edit_completed_time - Modificar hora de conclusão<br/>restart - Reiniciar Tarefa |
| completed_time | Hora de conclusão   | timestamp (milissegundos) | 1640995200000 | No* | Obrigatório apenas quando operation é edit_completed_time |

**Resposta:**

| Campo    | Tipo    | Descrição    | Exemplo | Notas                    |
| -------- | ------- | -------------- | ------- | ------------------------ |
| task_id  | Number  | ID da Tarefa        | 1000    | ID da Tarefa operada  |

<br/>

### Shop Settings

**Nome do método:** shop_settings

**Instruções:** Ajusta várias configurações da Loja

**Exemplo:**

- Definir taxa de juros do caixa eletrônico em 0,01%: [lifeup://api/shop_settings?key=atm_interest&value=0.01](lifeup://api/shop_settings?key=atm_interest&value=0.01)
- Aumentar a taxa de juros em 0,01% por clique: [lifeup://api/shop_settings?key=atm_interest&value=0.01&set_type=relative](lifeup://api/shop_settings?key=atm_interest&value=0.01&set_type=relative)

| Parâmetro | Significado              | Tipo | Exemplo | Obrigatório | Notas |
| --------- | -------------------- | ---- | ------- | -------- | ----- |
| key       | tipo                 | Atualmente só admite:<br/>atm_interest<br/>credit_interest<br/>line_of_credit<br/>discount_rate_for_returning<br/>atm_balance | atm_interest | sim | atm_interest - taxa diária do caixa eletrônico<br/>credit_interest - taxa diária do empréstimo<br/>line_of_credit - valor emprestável<br/>discount_rate_for_returning - escala de desconto por devolução<br/>atm_balance - definir saldo do caixa eletrônico |
| value     | valor numérico        | número decimal ou inteiro | 0.01 | sim | cada key admite intervalos distintos<br/>Por exemplo, saldos do caixa eletrônico não admitem decimais |
| set_type  | Como definir o valor | Um dos seguintes:<br/>absolute<br/>relative | absolute | não | absolute - valor absoluto, ou seja, define o alvo diretamente para o valor<br/>relative - valor relativo, soma ou subtrai do valor original |
| silent    | Executar em silêncio (sem exibir interface) | Boolean | false | Não | Compatível a partir de v1.93.0-beta01 (502)<br/>false por padrão, o que exibe avisos da interface |

<br/>

### Jump

**Nome do método:** goto

**Descrição:** Ir para uma página no `LifeUp`

**Exemplo:** [lifeup://api/goto?page=lab](lifeup://api/goto?page=lab)

**Explicação:** Ir para a página de Laboratórios

| Parâmetro | Significado | Valor | Exemplo | Obrigatório | Notas |
| --------- | ------- | ----- | ------- | -------- | ----- |
| page | página | Um dos seguintes valores:<br/>main<br/>setting<br/>about<br/>pomodoro<br/>feelings<br/>achievement<br/>history<br/>add_task<br/>add_achievement<br/>add_achievement_cate<br/>exp<br/>coin<br/>backup<br/>add_item<br/>lab<br/>custom_attributes<br/>pomodoro_record<br/>synthesis<br/>pic_manage<br/>purchase_dialog<br/>task_detail<br/>dlc<br/>new_default<br/>use_item_dialog<br/>achievement_list<br/>user_achievement | lab | sim | `purchase_dialog` refere-se ao pop-up de compra<br/> `use_item_dialog` refere-se ao pop-up de uso de Item<br/>As demais entradas correspondem a páginas principais específicas |

#### 1. Ir para a janela pop-up de compra/uso de Item

Quando o parâmetro `page` é `purchase_dialog` ou `use_item_dialog`, você pode especificar o ID do Item:

Por exemplo: `lifeup://api/goto?page=purchase_dialog&id=1`

| Parâmetro | Significado | Valor            | Exemplo | Obrigatório | Notas   |
| --------- | ------- | ---------------- | ------- | -------- | ------- |
| id        | ID do Item | Inteiro positivo | 1       | Sim      | ID do Item |

<br/>

#### 2. Ir para a subpágina da página inicial

Quando o parâmetro `page` é `main`, você pode especificar adicionalmente a subpágina de destino:

Por exemplo, ir para a página da Loja: `lifeup://api/goto?page=main&sub_page=shop`

| Parâmetro   | Significado       | Valor | Exemplo | Obrigatório | Notas  |
| ----------- | ------------- | ----- | ------- | -------- | ------ |
| sub_page    | nome da subpágina | Um de:<br/>todo<br/>shop<br/>inventory<br/>achievement<br/>status<br/>me<br/>statistic<br/>pomodoro<br/>feelings<br/>world | shop    | não       |      |
| category_id | id da lista       | number | 0      | não       | Se `sub_page` for uma página de lista, você pode informar o id da lista para ir até ela. <br/>Por exemplo, lista de Itens da Loja, lista do Inventário, lista de Tarefas. |

<br/>

#### 3. Ir para os detalhes da Tarefa

Quando o parâmetro `page` é `task_detail`, você pode especificar adicionalmente o id da Tarefa:

Por exemplo, ir para a página de detalhes da Tarefa com id 53: `lifeup://api/goto?page=task_detail&task_id=53`

| Parâmetro | Significado       | Valor         | Exemplo      | Obrigatório | Notas |
| --------- | ------------- | ------------- | ------------ | -------- | ----- |
| task_id   | id da Tarefa       | id da Tarefa       | 53           | Não*      | id da Tarefa; se for uma Tarefa repetitiva, o id é atualizado a cada repetição. |
| task_gid  | id do grupo de Tarefas | id do grupo de Tarefas | 3            | Não*      | id do grupo de Tarefas |
| task_name | nome da Tarefa     | string        | get up early | Não*      | nome da Tarefa; busca aproximada de uma correspondência. |

**Aviso:**

1. Basta informar um dos três parâmetros.
    - Se vários forem informados ao mesmo tempo, haverá uma ordem de prioridade interna. Isso é comportamento indefinido; o App não garante a ordem.

<br/>

#### 4. Ir para a página de nova Conquista

Quando o parâmetro `page` é `add_achievement`, você **deve** especificar adicionalmente o id da categoria:

Por exemplo, ir para a página de nova Conquista com id de categoria 1: `lifeup://api/goto?page=add_achievement&category_id=1`

| Parâmetro    | Significado         | Valor         | Exemplo | Obrigatório | Notas  |
| ------------ | --------------- | ------------- | ------- | -------- | ------ |
| category_id  | id da categoria de Conquista | id da categoria de Conquista | 1       | Sim      |        |

#### 5. Ir para a página de categoria de Conquista específica

Quando o parâmetro `page` é `user_achievement`, você **deve** especificar adicionalmente o id da categoria:

Por exemplo, ir para a página de categoria de Conquista com id 1: `lifeup://api/goto?page=user_achievement&category_id=1`

| Parâmetro    | Significado         | Valor         | Exemplo | Obrigatório | Notas  |
| ------------ | --------------- | ------------- | ------- | -------- | ------ |
| category_id  | id da categoria de Conquista | id da categoria de Conquista | 1       | Sim      |        |

#### 6. Ir para a página de categoria de Síntese específica

Quando o parâmetro `page` é `synthesis`, você pode especificar opcionalmente o id da categoria:

Por exemplo, ir para a página de categoria de Síntese com id 1: `lifeup://api/goto?page=synthesis&category_id=1`

| Parâmetro    | Significado         | Valor         | Exemplo | Obrigatório | Notas  |
| ------------ | --------------- | ------------- | ------- | -------- | ------ |
| category_id  | id da categoria de Síntese | id da categoria de Síntese | 1       | Não       |        |

Você também pode abrir a página de Síntese com um filtro (v1.102.0+):

Por exemplo, filtrar pelo id do Item produto 1: `lifeup://api/goto?page=synthesis&filter_type=product&filter_item_id=1&filter_item_name=Gem`

| Parâmetro        | Significado           | Valor | Exemplo | Obrigatório | Notas |
| --------------- | ----------------- | ----- | ------- | -------- | ----- |
| filter_type     | Tipo de filtro       | product / ingredient / related | product | Não* | Requer filter_item_id |
| filter_item_id  | id do Item filtro    | number > 0 | 1 | Não* | Requer filter_type |
| filter_item_name| Nome do Item filtro  | text | Gem | Não | Opcional; usado para exibição |

### Shop

#### Adicionar Itens

?> Alguns campos como `effects` requerem v1.98.0+

**Nome do método:** add_item

**Descrição:** Cria um Item da Loja com propriedades personalizáveis, incluindo limites de compra e efeitos de uso.

**Exemplo:** [lifeup://api/add_item?name=Take a 10-minute break&desc=Go and take a short break!&price=10&action_text=rest&icon=☕](lifeup://api/add_item?name=Take a 10-minute break&desc=Go and take a short break!&price=10&action_text=rest&icon=☕)

| Parâmetro        | Significado                | Valores               | Exemplo       | Obrigatório | Notas                           |
| --------------- | --------------------- | -------------------- | ------------- | -------- | ------------------------------- |
| name            | Nome do Item             | any text             | 10 minute break | Sim    |                                 |
| desc            | Descrição           | any text             | Take a break  | Não       |                                 |
| icon            | Ícone                  | emoji, http(s) URL, or built-in sample name | ☕ | Não | Armazenado como `emoji_*.webp`, `lifeup_sample_*` ou URL. Emoji no nome não define o ícone. |
| price           | Preço                 | [0, 999999]         | 10            | Não       | Padrão é 0                    |
| stock_number    | Quantidade em estoque        | [-1, 99999]         | -1            | Não       | -1 significa ilimitado              |
| action_text     | Texto do botão de ação    | any text             | rest          | Não       |                                 |
| disable_purchase| Desabilitar compra      | true or false        | false         | Não       | Padrão é false                |
| disable_use     | Desabilitar uso           | true or false        | false         | Não       | Padrão é false                |
| category        | ID da categoria           | number greater than or equal to 0 | 0 | Não    | 0 para a categoria padrão          |
| order           | Ordem de exibição         | integer              | 1             | Não       | Posição na categoria            |
| purchase_limit  | Regras de restrição     | JSON text            | Ver [Purchase Limit Structure](#3-purchase-limit-structure) | Não | Restrições configuráveis de compra/uso |
| limit_scope     | Escopo de restrição     | purchase / use / both | purchase | Não | Só se aplica quando `purchase_limit` não está vazio; padrão é `purchase` |
| effects         | Efeitos de uso           | JSON text            | Ver [Item Effects Structure](#4-item-effects-structure) | Não | Efeitos ao usar o Item |
| own_number      | Quantidade inicial em posse | integer             | 0             | Não       | Define a quantidade inicial no Inventário  |
| unlist          | Ocultar da Loja        | true or false        | false         | Não       | Padrão é false                |

**Dados de retorno:**

| Campo    | Tipo    | Descrição    | Exemplo | Notas                    |
| -------- | ------- | -------------- | ------- | ------------------------ |
| item_id  | Number  | ID do Item        | 1000    | ID do Item criado   |

!> O parâmetro effects substitui disable_use. Se você definir effects para indicar um Item não utilizável, disable_use será ignorado.

<br/>

#### Editar Item

?> Requer v1.98.0+

**Nome do método:** item

**Descrição:** Modifica Itens existentes, incluindo preço, estoque, efeitos e outras propriedades

**Exemplos:**

- Ajustar preço: [lifeup://api/item?id=1&set_price=1&set_price_type=relative](lifeup://api/item?id=1&set_price=1&set_price_type=relative)
- Modificar efeitos: [lifeup://api/item?effects=%5B%7B%22type%22%3A2%2C%22info%22%3A%7B%22min%22%3A100%2C%22max%22%3A200%7D%7D%5D&id=1](lifeup://api/item?effects=%5B%7B%22type%22%3A2%2C%22info%22%3A%7B%22min%22%3A100%2C%22max%22%3A200%7D%7D%5D&id=1)
  - O conteúdo decodificado do parâmetro effects é: `[{"type":2,"info":{"min":100,"max":200}}]`

| Parâmetro         | Significado             | Valores               | Exemplo   | Obrigatório | Notas                           |
| ---------------- | ------------------- | -------------------- | --------- | -------- | ------------------------------- |
| id               | ID do Item             | number greater than 0| 1         | Não*      | É necessário id ou name      |
| name             | Nome do Item           | any text             | Treasure  | Não*      | Para busca aproximada, não para renomear  |
| set_name         | Definir nome            | any text             | Treasure  | Não       | Não pode ficar vazio                 |
| set_desc         | Definir descrição     | any text             | Get gift  | Não       |                                |
| set_icon         | Definir ícone            | emoji, http(s) URL, or built-in sample name | ☕ | Não | Igual a `icon`. Valores não suportados retornam `unsupported_parameter`. |
| set_price        | Ajustar preço        | integer              | 1         | Não       |                                |
| set_price_type   | Método de ajuste de preço | absolute or relative | relative  | Não       | absolute: definir diretamente<br/>relative: somar/subtrair |
| own_number       | Ajustar quantidade em posse| integer             | 1         | Não       | Aceita valores negativos com relative |
| own_number_type  | Ajuste de quantidade em posse| absolute or relative| relative  | Não       | absolute: definir diretamente<br/>relative: somar/subtrair |
| stock_number     | Ajustar estoque        | [-1, 99999]         | 1         | Não       | -1 significa estoque ilimitado        |
| stock_number_type| Método de ajuste de estoque | absolute or relative | relative  | Não       | absolute: definir diretamente<br/>relative: somar/subtrair |
| disable_purchase | Desabilitar compra    | true or false        | false     | Não       | Padrão é false              |
| disable_use      | Desabilitar uso         | true or false        | false     | Não       | Padrão é false              |
| action_text      | Texto do botão de uso     | any text             | Use       | Não       |                                |
| title_color_string| Cor do título        | color string         | #66CCFF   | Não       | # deve ser escapado como %23<br/>Valor vazio restaura o padrão |
| effects          | Efeitos de uso         | JSON text            | Ver [Item Effects Structure](#4-item-effects-structure) | Não | Define efeitos de uso do Item |
| purchase_limit   | Regras de restrição   | JSON text            | Ver [Purchase Limit Structure](#3-purchase-limit-structure) | Não | Passe `null` para limpar todas as restrições |
| limit_scope      | Escopo de restrição   | purchase / use / both | purchase | Não | Só atualiza quando este campo é informado; é limpo automaticamente quando `purchase_limit` fica vazio |
| category_id      | ID da categoria         | number >= 0          | 1         | Não       | 0 para a categoria padrão         |
| order            | Ordem de exibição       | integer              | 1         | Não       | Posição na categoria           |
| unlist           | Remover da Loja    | true or false        | false     | Não       | Padrão é false              |

!> É necessário informar o parâmetro id ou name para localizar o Item a modificar

<br/>

#### Ajustar o efeito de Caixa de saque

**Nome do método:** loot_box

**Descrição:** Modifica o efeito de Caixa de saque do Item caixa indicado; permite ajustar probabilidade, quantidade de Recompensas e adicionar conteúdo. (Por enquanto não suporta exclusão)

**Exemplo:** <a href="lifeup://api/loot_box?name=Coin loot box&sub_name=A big bag of coins&set_type=relative&probability=1&fixed=false">lifeup://api/loot_box?name=Coin loot box&sub_name=A big bag of coins&set_type=relative&probability=1&fixed=false</a>

**Explicação:** Aumenta em 1 ponto a proporção do saco [grande] de moedas de ouro na caixa de moedas.

| Parâmetro   | Significado                               | Tipo                                                    | Exemplo        | Obrigatório | Notas                                                        |
| ----------- | ------------------------------------- | ------------------------------------------------------- | -------------- | -------- | ------------------------------------------------------------ |
| id          | id do Item                               | a number greater than 0                                 | 1              | não*      | Consulte acima "Basic Knowledge - LifeUp Data ID" para saber como obter |
| name        | nome do Item                             | any text                                                | Treasure chest | não*      | Se o id for desconhecido, busca aproximada do produto; não altera o nome |
| sub_id      | id do Item conteúdo                       | a number greater than 0                                 | 1              | não*      | id do conteúdo do baú                                         |
| sub_name    | nome do Item conteúdo                     | any text                                                | Get a gift     | não*      | Busca aproximada quando o id do conteúdo da caixa é desconhecido |
| set_type    | método de ajuste (absolute/relative) | one of the following values: <br/>absolute<br/>relative | relative       | não       | absolute: valor absoluto, ou seja, define o alvo diretamente<br/>relative: valor relativo, soma ou subtrai do valor original |
| amount      | quantidade do Item conteúdo                | number                                                  | 1              | não       | quantidade de Recompensas de um único Item                          |
| probability | probabilidade do Item conteúdo       | number                                                  | 1              | não       | -                                                            |
| fixed       | se é Recompensa fixa          | boolean                                                 | true/false     | não       | -                                                            |

**Aviso:**

1. Para buscar um produto, é necessário informar id ou name.
1. Para buscar conteúdo, é necessário informar sub_id ou sub_name.
1. `name` e `sub_name` tentam correspondência exata primeiro e depois busca aproximada.
1. A API legada `loot_box` mantém seu comportamento de compatibilidade: se o mesmo Item conteúdo aparecer várias vezes com quantidades distintas, edita a primeira entrada correspondente e não usa `sub_amount` para desambiguar. Use `loot_box/v2` quando precisar de edição, exclusão ou fusão específica por quantidade.

<br/>

#### Ajustar o efeito de Caixa de saque (v2)

?> Esta API foi introduzida na versão v1.104.2.

**Nome do método:** loot_box/v2

**Descrição:** Versão aprimorada da API loot_box. Modifica o efeito de Caixa de saque do Item caixa indicado; permite ajustar probabilidade, quantidade de Recompensas, adicionar conteúdo e **excluir conteúdo**.

**Melhorias em relação à v1:**
- **`sub_amount` para correspondência precisa**: Quando a caixa contém várias entradas do mesmo Item com quantidades distintas (ex.: A x1 50%, A x2 30%), use `sub_amount` para apontar para uma entrada específica. O valor padrão é `1`. Se nenhuma entrada correspondente for encontrada, o LifeUp busca o Item por `sub_id` / `sub_name` e adiciona uma nova entrada; se a solicitação for uma exclusão com `amount=0`, nenhuma entrada nova é adicionada.
- **`set_type` independente**: `amount_set_type` e `probability_set_type` podem ser controlados separadamente. O `set_type` global serve como padrão de fallback.
- **Suporte a exclusão**: Definir `amount=0` com `amount_set_type=absolute` (ou calcular `<=0` com `relative`) exclui a entrada correspondente.
- **Fusão de duplicatas**: Se alterar `amount` duplicar uma entrada existente com o mesmo Item e quantidade na mesma caixa, o LifeUp funde na entrada existente e continua aplicando os valores `probability` / `fixed` da solicitação.

**Exemplo:** <a href="lifeup://api/loot_box/v2?name=Coin loot box&sub_name=A big bag of coins&sub_amount=2&probability_set_type=relative&probability=10">lifeup://api/loot_box/v2?name=Coin loot box&sub_name=A big bag of coins&sub_amount=2&probability_set_type=relative&probability=10</a>

**Explicação:** Aumenta em 10 pontos a probabilidade do saco [grande] de moedas de ouro (x2) na caixa de moedas.

| Parâmetro              | Significado                               | Tipo                                                    | Exemplo        | Obrigatório | Notas                                                        |
| ---------------------- | ------------------------------------- | ------------------------------------------------------- | -------------- | -------- | ------------------------------------------------------------ |
| id                     | id do Item                               | a number greater than 0                                 | 1              | não*      | Consulte acima "Basic Knowledge - LifeUp Data ID" para saber como obter |
| name                   | nome do Item                             | any text                                                | Treasure chest | não*      | Se o id for desconhecido, busca aproximada do produto; não altera o nome |
| sub_id                 | id do Item conteúdo                       | a number greater than 0                                 | 1              | não*      | id do conteúdo do baú. Se sub_id e sub_name forem informados, sub_id tem prioridade |
| sub_name               | nome do Item conteúdo                     | any text                                                | Get a gift     | não*      | Busca aproximada quando o id do conteúdo da caixa é desconhecido |
| sub_amount             | quantidade do Item conteúdo para correspondência      | number                                                  | 2              | não       | Usado para corresponder com precisão a uma entrada com esta quantidade. Mínimo `1`, padrão `1`. Se não houver correspondência e não for uma solicitação de exclusão, uma nova entrada é adicionada. |
| set_type               | método de ajuste global              | one of: `absolute` / `relative`                         | relative       | não       | Padrão para `amount_set_type` e `probability_set_type` se não especificado |
| amount_set_type        | método de ajuste para amount          | one of: `absolute` / `relative`                         | relative       | não       | Substitui `set_type` para o campo amount                    |
| probability_set_type   | método de ajuste para probability     | one of: `absolute` / `relative`                         | absolute       | não       | Substitui `set_type` para o campo probability               |
| amount                 | quantidade do Item conteúdo                | number                                                  | 1              | não       | quantidade de Recompensas de um único Item. `0` (absolute) ou calculado `<=0` (relative) exclui a entrada |
| probability            | probabilidade do Item conteúdo       | number                                                  | 1              | não       | -                                                            |
| fixed                  | se é Recompensa fixa          | boolean                                                 | true/false     | não       | -                                                            |
| query                  | listar conteúdo da caixa                     | true or false                                           | true           | não       | v1.105.1+. Retorna apenas JSON do Item; sub_id / sub_name não são necessários |

**Aviso:**

1. Para buscar um produto, é necessário informar id ou name.
1. Para buscar conteúdo, é necessário informar sub_id ou sub_name. Use `query=true` para listar conteúdo sem sub_id / sub_name.
1. Se `sub_id` e `sub_name` forem informados, `sub_id` tem prioridade. `sub_name` só é usado quando não há um `sub_id` válido.
1. `name` e `sub_name` tentam correspondência exata primeiro e depois busca aproximada.
1. `sub_amount` tem valor padrão `1`. Quando a caixa tem várias entradas do mesmo Item com quantidades distintas, informe `sub_amount` para apontar para uma entrada específica. Se não houver correspondência e não for uma solicitação de exclusão, uma nova entrada é adicionada com `amount=sub_amount`.
1. Para excluir uma entrada, defina `amount=0` com `amount_set_type=absolute`, ou use `amount_set_type=relative` com um valor negativo que deixe o total em `<=0`. A exclusão só se aplica a entradas correspondentes; se nenhuma entrada existente for correspondida, `amount=0` não adiciona uma entrada nova.
1. Se alterar o `amount` de uma entrada duplicar uma entrada existente com o mesmo Item e quantidade na mesma caixa, o LifeUp funde na entrada existente e continua aplicando os valores `probability` / `fixed` da solicitação.
1. Quando a exclusão deixa a caixa vazia, todo o efeito de Caixa de saque é excluído de forma suave (o Item é preservado e você pode readicionar entradas de Caixa de saque depois).

<br/>

#### Usar Itens

?> Esta API foi introduzida na versão v1.93.0-beta01 (502).

**Nome do método:** use_item

**Descrição:** Usa um Item especificado.

**Exemplo:**

- Abrir uma caixa de moedas: [lifeup://api/use_item?name=coin_box&use_times=1](lifeup://api/use_item?name=coin_box&use_times=1)

| Parâmetro | Significado     | Tipo                    | Exemplo  | Obrigatório | Notas                                                        |
| --------- | ----------- | ----------------------- | -------- | -------- | ------------------------------------------------------------ |
| id        | ID do Item     | a number greater than 0 | 1        | Não*      | Para obter o ID do Item, consulte a seção "Basic Knowledge - LifeUp Data ID" |
| name      | Nome do Item   | Any text                | coin_box | Não*      | Para IDs desconhecidos; realiza busca aproximada de Itens      |
| use_times | Vezes de uso | a number greater than 0 | 1        | Não       | Padrão é 1 vez<br/>Para Itens normais ou ao abrir caixas, corresponde à quantidade do Item<br/>Para Itens de Síntese simples, este valor corresponde à "quantidade de síntese" e não ao número de Itens consumidos |

**Retorno:**

!> Esta API pode falhar por diversos motivos; os valores de retorno podem incluir o motivo específico da falha.

| Parâmetro | Significado            | Tipo     | Exemplo          | Obrigatório | Notas                                                        |
| --------- | ------------------ | -------- | ---------------- | -------- | ------------------------------------------------------------ |
| result    | Código de resultado        | a number | 0                | Sim      | 0 - Uso bem-sucedido<br/>1 - Exceção de banco de dados<br/>2 - Restrição por Pontos de Experiência insuficientes<br/>3 - Item não encontrado<br/>4 - Conflito de contagem regressiva em andamento<br/>5 - Inventário insuficiente<br/>6 - Item não utilizável<br/>7 - Limite de moedas<br/>8 - Limite de estoque do alvo<br/>9 - Restrição por nível de Atributo<br/>10 - Restrição de horário<br/>11 - Restrição por quantidade de Itens em posse<br/>12 - Restrição por conclusão de Tarefa<br/>13 - Restrição por desbloqueio de Conquista<br/>14 - Restrição por quantidade do período<br/>15 - Restrição por ciclo de Tarefa concluído |
| desc      | Descrição do resultado | Text     | RunningCountDown | Sim      |                                                              |

<br/>

### ATM

**⚠ Disponível apenas em v1.91+**

> As operações de depósito e saque aqui serão verificadas.
>
> Se você precisar ajustar diretamente o saldo do caixa eletrônico, consulte a interface "Shop Settings" acima.

#### Depósito

**Nome do método:** deposit

**Descrição:** O depósito será verificado quanto à legalidade (se o saldo de moedas é suficiente).

**Exemplo:**[lifeup://api/deposit?amount=500](lifeup://api/deposit?amount=500)

**Explicação:** Depositar 500 moedas.

| Parâmetro | Significado        | Tipo                    | Exemplo | Obrigatório | Notas |
| --------- | -------------- | ----------------------- | ------- | -------- | ----- |
| amount    | valor do depósito | a number greater than 0 | 100     | sim      | -     |

**Retorno:**

| Parâmetro | Significado                              | Tipo              | Exemplo | Obrigatório | Notas |
| --------- | ------------------------------------ | ----------------- | ------- | -------- | ----- |
| result    | Se a operação foi bem-sucedida | `true` or `false` | true    | sim      | -     |

<br/>

#### Saque

**Nome do método:** withdraw

**Descrição:** Os saques serão verificados quanto à legalidade (se o saldo do caixa eletrônico é suficiente).

**Exemplo:** [lifeup://api/withdraw?amount=500](lifeup://api/withdraw?amount=500)

**Explicação:** Sacar 500 moedas.

| Parâmetro | Significado           | Tipo                    | Exemplo | Obrigatório | Notas |
| --------- | ----------------- | ----------------------- | ------- | -------- | ----- |
| amount    | valor do saque | a number greater than 0 | 100     | sim      | -     |

**Retorno:**

| Parâmetro | Significado                              | Tipo              | Exemplo | Obrigatório | Notas |
| --------- | ------------------------------------ | ----------------- | ------- | -------- | ----- |
| result    | Se a operação foi bem-sucedida | `true` or `false` | true    | sim      | -     |

<br/>

### Pomodoro Timer

**Nome do método:** pomodoro_timer

**Descrição:** Controla a contagem regressiva ou o cronômetro progressivo Pomodoro real no LifeUp. Esta API inicia
a mesma sessão de temporizador que a interface do App; não adiciona diretamente registros Pomodoro nem tomates.

**Exemplos:**

- Iniciar ou retomar a contagem regressiva de trabalho padrão:
  [lifeup://api/pomodoro_timer?action=start&mode=countdown](lifeup://api/pomodoro_timer?action=start&mode=countdown)
- Iniciar o cronômetro progressivo e selecionar a Tarefa 101:
  [lifeup://api/pomodoro_timer?action=start&mode=count_up&task_id=101](lifeup://api/pomodoro_timer?action=start&mode=count_up&task_id=101)
- Pausar a contagem regressiva ativa:
  [lifeup://api/pomodoro_timer?action=pause&mode=countdown](lifeup://api/pomodoro_timer?action=pause&mode=countdown)
- Abandonar e reiniciar o ciclo de vida Pomodoro:
  [lifeup://api/pomodoro_timer?action=abandon&mode=countdown](lifeup://api/pomodoro_timer?action=abandon&mode=countdown)
- Pular a etapa Pomodoro atual:
  [lifeup://api/pomodoro_timer?action=skip](lifeup://api/pomodoro_timer?action=skip)
- Finalizar um cronômetro progressivo sem receber Recompensas de tomates:
  [lifeup://api/pomodoro_timer?action=complete&mode=count_up&receive_reward=false](lifeup://api/pomodoro_timer?action=complete&mode=count_up&receive_reward=false)
- Consultar ambos os modos de temporizador:
  [lifeup://api/pomodoro_timer?action=status](lifeup://api/pomodoro_timer?action=status)

**Parâmetros:**

| Parâmetro | Significado | Tipo / valores | Obrigatório | Notas |
| --------- | ------- | ------------- | -------- | ----- |
| action | Operação | `start`, `pause`, `abandon`, `skip`, `complete`, `select_task`, `status` | sim | - |
| mode | Modo do temporizador | `countdown`, `count_up` | para `start`, `pause`, `abandon` e `complete` | `skip` sempre aponta para a contagem regressiva. |
| stage | Etapa da contagem regressiva | `work`, `short_break`, `long_break` | não | Válido apenas com `mode=countdown`. Se omitido, usa a etapa canônica ativa, em pausa ou seguinte por etapas; um ciclo de vida novo começa com `work`. |
| receive_reward | Se receber Recompensas de tomates | `true` or `false` | para `complete` | Booleano estrito. `complete` só suporta `mode=count_up`. |
| task_id | ID da Tarefa | positive integer | não | Não pode ser combinado com `task_gid` ou `task_name`. |
| task_gid | ID do grupo de Tarefas | positive integer | não | Pode ser combinado com `task_name` para restringir a correspondência. |
| task_name | Nome da Tarefa | text | não | Correspondência exata é preferida, com busca aproximada como fallback. |
| clear_task | Limpar a Tarefa do temporizador | `true` or `false` | não | `true` não pode ser combinado com um localizador de Tarefa. |

`select_task` requer um localizador de Tarefa ou `clear_task=true`. `start` pode incluir os mesmos
parâmetros de seleção de Tarefa. Parâmetros de duração personalizada não são suportados: contagens regressivas usam
a duração padrão atual ou a duração Pomodoro da Tarefa selecionada.

`abandon&mode=countdown` equivale à ação esquerda do App: abandona a etapa atual,
reinicia o ciclo de vida Pomodoro e retorna a uma etapa de trabalho parada. `skip` equivale à
ação direita: avança de trabalho para pausa curta/longa, ou de pausa para trabalho, sem iniciar automaticamente
a etapa seguinte. Cada chamada a `skip` é uma ação real não idempotente; quem chama não deve repeti-la
automaticamente.

`complete&mode=count_up` finaliza a sessão progressiva real. Sessões com menos de 30 segundos são
consumidas sem criar registro. Com `receive_reward=false`, um registro que atinge o limiar
ainda é salvo como abandonado, mas não concede tomates.

**Regras de troca de Tarefa:**

- Uma contagem regressiva de trabalho em andamento rejeita mudanças de Tarefa.
- Um cronômetro progressivo em andamento permite mudanças de Tarefa e atualiza sua notificação.
- Uma contagem regressiva pausada permite mudanças de Tarefa e preserva o tempo decorrido enquanto recalcula sua duração total
  conforme as configurações da nova Tarefa.

**Valores de retorno em caso de sucesso:**

| Parâmetro | Significado | Tipo |
| --------- | ------- | ---- |
| api_result | Se a chamada à API foi bem-sucedida | boolean |
| applied | Se esta chamada alterou o estado do temporizador | boolean |
| mode | Modo do temporizador alvo ou selecionado atualmente | `countdown` or `count_up` |
| state | Estado de `mode` | `running`, `paused`, or `stopped` |
| selected_task_id | ID da Tarefa do temporizador atual, ou `0` | number |
| can_start_in_background | Se o Android permite iniciar o temporizador em segundo plano no momento | boolean |
| countdown_state | Estado canônico da contagem regressiva | `running`, `paused`, or `stopped` |
| countdown_phase | Fase do ciclo de vida da contagem regressiva | `idle`, `running`, `paused`, `completing`, `completed`, or `cancelled` |
| countdown_stage | Etapa canônica da contagem regressiva | `work`, `short_break`, or `long_break` |
| countdown_session_id | ID de sessão canônico da contagem regressiva | text or null |
| countdown_total_millis | Duração total da contagem regressiva | milliseconds |
| countdown_remaining_millis | Duração restante da contagem regressiva | milliseconds |
| count_up_state | Estado canônico do cronômetro progressivo | `running`, `paused`, or `stopped` |
| count_up_elapsed_millis | Duração decorrida do cronômetro progressivo | milliseconds |
| battery_optimization_ignored | Se o LifeUp está isento de otimização de bateria | boolean |

Respostas `complete` bem-sucedidas contêm adicionalmente `record_created`, `reward_tomatoes` e
`settled_elapsed_millis`.

Chamadas repetidas a `start`, `pause` ou `abandon` que já correspondem ao estado solicitado têm sucesso com
`applied=false`. Chamadas mutantes não oferecem deduplicação de repetição entre processos.

**Erros:**

Falhas retornam `api_result=false`, `error_code` e `error_message`. Os códigos de erro estáveis
específicos do temporizador são:

- `invalid_parameter`
- `missing_required_parameter`
- `unsupported_action_for_mode`
- `task_not_found`
- `task_change_not_allowed`
- `timer_mode_locked`
- `timer_state_conflict`
- `background_start_not_allowed`
- `timer_start_failed`
- `timer_settlement_failed`

No Android 12 e versões posteriores, uma chamada em segundo plano ao ContentProvider só pode iniciar um temporizador quando o LifeUp
tem permissão para ignorar a otimização de bateria. Caso contrário, retorna `background_start_not_allowed`
antes de alterar o estado do temporizador. Abrir o URL Scheme por meio de sua Activity traz o LifeUp para o
primeiro plano antes de iniciar. O Android pode impedir que um app de terceiros inicie essa Activity a partir do
segundo plano; quando isso ocorre, o LifeUp não recebe nenhuma chamada à API e não pode retornar um erro.

<br/>

### Pomodoro Record

#### Adicionar registro Pomodoro

**Nome do método:** add_pomodoro

**Descrição:** Adiciona um registro de temporização de tomates

**Exemplo:**

- Adicionar um registro de temporização de 25 minutos (1500000 ms) associado a uma Tarefa cujo nome contém learning: [lifeup://api/add_pomodoro?task_name=learning&duration=1500000](lifeup://api/add_pomodoro?task_name=learning&duration=1500000)
- Adicionar registro de temporização para `2022-08-01 11:00:00` - `2022-08-01 12:00:00`: [lifeup://api/add_pomodoro?start_time=1659322800000&end_time=1659326400000](lifeup://api/add_pomodoro?start_time=1659322800000&end_time=1659326400000)

**Explicação:**

| Parâmetro        | Significado                    | Tipo                    | Exemplo       | Obrigatório | Notas |
| ---------------- | -------------------------- | ----------------------- | ------------- | -------- | ----- |
| start_time       | hora de início da temporização          | timestamp               | 1659322800000 | não*      | Se você não sabe o que é timestamp, pesquise! |
| duration         | duração de Foco             | number (in milliseconds) <br/>must be greater than 30000 | 1500000 | não* | |
| end_time         | hora de fim da temporização            | timestamp               | 1659326400000 | não*      |       |
| reward_tomatoes  | se conceder tomates | true or false           | true          | não       | padrão é false |
| task_id          | id da Tarefa                    | a number greater than 0 | 1             | não       |       |
| task_gid         | id do grupo de Tarefas              | a number greater than 0 | 1             | não       |       |
| task_name        | nome                       | any text                | learning      | não       | busca aproximada; apenas uma das Tarefas encontradas |
| ui               | Exibir interface de tomates concedidos | true or false         | true          | não       | Introduzido em v1.94.0; padrão é true |

**Aviso:**

1. É necessário informar um de start_time, duration ou end_time.
2. Se apenas duration for informado, end_time padrão é a hora atual.
3. end_time precisa ser maior que start_time.
4. duration é no mínimo 30000 milissegundos (30 segundos).
5. Se start_time, duration e end_time forem informados, duration deve ser menor ou igual a (end_time - start_time).

<br/>

#### Editar registro Pomodoro

> Introduzido em v1.94.0
> **Nome do método:** edit_pomodoro

**Descrição:** Edita um registro de temporização Pomodoro existente ou adiciona um novo se um `edit_item_id` válido for informado.

**Exemplo:**

- Editar um registro com um ID especificado, definir duração para 45 minutos (2700000 ms) e conceder tomates: [lifeup://api/edit_pomodoro?edit_item_id=123&duration=2700000&reward_tomatoes=true](lifeup://api/edit_pomodoro?edit_item_id=123&duration=2700000&reward_tomatoes=true)
- Editar um registro por hora de início e fim: [lifeup://api/edit_pomodoro?start_time=1659322800000&end_time=1659326400000&edit_item_id=456](lifeup://api/edit_pomodoro?start_time=1659322800000&end_time=1659326400000&edit_item_id=456)

**Parâmetros:**

| Parâmetro       | Significado                    | Tipo                  | Exemplo       | Obrigatório | Notas                                            |
| --------------- | -------------------------- | --------------------- | ------------- | -------- | ------------------------------------------------ |
| task_id         | ID da Tarefa                    | Number greater than 0 | 101           | Não       | Identificador único da Tarefa                   |
| task_gid        | ID do grupo de Tarefas              | Number greater than 0 | 5             | Não       | Se informado, substitui task_id                |
| task_name       | Nome da Tarefa                  | Any text              | Study         | Não       | Obrigatório se task_id ou task_gid não forem informados   |
| start_time      | Hora de início da temporização          | Timestamp             | 1659322800000 | Não*      | Pesquise no Google para entender o que é timestamp     |
| end_time        | Hora de fim da temporização            | Timestamp             | 1659326400000 | Não*      | -                                                |
| duration        | Duração de Foco             | Number (milliseconds) | 2700000       | Não*      | Deve ser no mínimo 30000 milissegundos (30 segundos) |
| reward_tomatoes | Se conceder tomates | true or false         | true          | Não       | Padrão é false                                 |
| edit_item_id    | ID do item a editar     | Number greater than 0 | 123           | Sim      | Especifica o ID do registro a editar                  |
| ui              | Exibir interface de tomates concedidos | true or false         | true          | Não       |                                                  |
| delete          | Excluir o registro          | true or false         | true          | Não       | v1.105.1+. Exclui suavemente o registro pomodoro (`isDel`), igual ao App |

**Valores de retorno:**

| Parâmetro | Significado                          | Tipo   | Exemplo | Obrigatório | Notas                    |
| --------- | -------------------------------- | ------ | ------- | -------- | ------------------------ |
| tomatoes  | Tomates obtidos com esta ação | Number | 2       | Não       | Retornado se `ui` for true |

**Notas:**

1. É necessário informar pelo menos um de `start_time`, `duration` ou `end_time`.
2. `end_time` precisa ser maior que `start_time`.
3. `duration` deve ser menor ou igual a (`end_time` - `start_time`).
4. Se `edit_item_id` for informado e o registro correspondente for encontrado, ele será editado; caso contrário, um registro novo será criado com base nos demais parâmetros.

<br/>

### Condições de desbloqueio de Conquistas

**Nome do método:** unlock_condition

**Descrição:** Condição de desbloqueio de Conquista: requer uma chamada externa à API para desbloquear

**Exemplo:**

- Invocar a condição de desbloqueio com id 2: [lifeup://api/unlock_condition?id=2](lifeup://api/unlock_condition?id=2)

| Parâmetro | Significado      | Tipo                  | Exemplo | Obrigatório | Notas |
| --------- | ---------------- | --------------------- | ------- | -------- |------ |
| id        | id da condição | number greater than 0 | 2       | sim      |       |

<br/>

### Concluir / resgatar Conquista

?> Esta API foi introduzida em v1.105.1.

**Nome do método:** complete_achievement

**Descrição:** Conclui uma Conquista manual e resgata sua Recompensa, ou resgata a Recompensa de uma Conquista automática já desbloqueada. Mesmo comportamento de tocar na caixa de conclusão / no botão de resgatar Recompensa na App.

**Exemplo:**

- Concluir ou resgatar a Conquista com id 1: [lifeup://api/complete_achievement?id=1](lifeup://api/complete_achievement?id=1)

| Parâmetro | Significado        | Tipo                  | Exemplo | Obrigatório | Notas |
| --------- | ------------------ | --------------------- | ------- | -------- | ----- |
| id        | id da Conquista | number greater than 0 | 1       | sim      |       |

**Valor de retorno:**

| Campo  | Tipo   | Descrição | Exemplo | Notas |
| ------ | ------ | ----------- | ------- | ----- |
| id     | number | ID da Conquista | 1 | |
| status | number | status após a chamada | 2 | `0` bloqueado · `1` desbloqueado, Recompensa não resgatada · `2` desbloqueado, Recompensa resgatada |

**Notas:**

1. Conquistas manuais (sem condições de desbloqueio): se ainda estiverem bloqueadas, esta chamada conclui a Conquista e concede Recompensas.
2. Conquistas automáticas (com condições de desbloqueio): só resgata Recompensas quando já estiver desbloqueada e ainda houver Recompensa pendente. Se as condições não forem atendidas, a chamada falha com `error_code=achievement_not_unlocked`.
3. Chamar novamente após a Recompensa já ter sido resgatada tem sucesso com `status=2` e não concede Recompensas duas vezes.
4. Isso difere de `achievement?unlocked=true`, que apenas grava o estado de desbloqueio e não concede Recompensas.

<br/>

### Definir o número de passos

**Nome do método:** step

**Descrição:** Define o número de passos na data indicada; por exemplo, pode ser usado para registrar passos com uma pulseira + ferramenta de automação. Também serve para modificar registros históricos.

**Exemplo:**

- Ajustar o número de passos de 2022-10-21 no fuso horário GMT+8 para 9999 passos: [lifeup://api/step?count=9999&time=1666282995643](lifeup://api/step?count=9999&time=1666282995643)

| Parâmetro | Significado                         | Tipo                                | Exemplo       | Obrigatório | Notas |
| --------- | ----------------------------------- | ----------------------------------- | ------------- | -------- | ----- |
| count     | número de passos                 | a number greater than or equal to 0 | 9999          | sim      |       |
| time      | timestamp arbitrário da data | timestamp (ms)                      | 1666282995643 | sim      |       |

<br/>

### Editar Pontos de Experiência

?> Esta API foi introduzida na versão v1.93.0-beta01 (502).

**Nome do método:** edit_exp

**Descrição:** Esta API pode definir em lote os valores atuais de Pontos de Experiência dos Atributos. Pode definir diretamente um valor específico de experiência ou um Nível determinado.

**Exemplo:**

> Esta API afeta os dados e, para evitar uso acidental, links clicáveis diretos não são fornecidos aqui.

- Redefinir os Pontos de Experiência dos Atributos [Força] e [Conhecimento] para 0: lifeup://api/edit_exp?skills=1&skills=2&exp=0
- Ajustar diretamente os Pontos de Experiência de [Charme] para o Nível 50: lifeup://api/edit_exp?skills=3&level=50

| Parâmetro | Significado              | Tipo                                      | Exemplo | Obrigatório | Notas |
| --------- | -------------------- | ----------------------------------------- | ------- | -------- | ----- |
| skills    | ID de Atributo (Habilidade) | Array of numbers greater than 0           | 1       | Não       | Admite arrays (ou seja, &skills=1&skills=2&skills=3)<br/>Para obter o ID do Atributo, consulte a seção "Basic Knowledge - LifeUp Data ID" acima |
| exp       | Definir Pontos de Experiência | Number greater than or equal to 0 (int32) | 9999    | Não, mas exp ou level deve ser informado |                                                               |
| level     | Definir Nível            | Number greater than or equal to 0 (int32) | 50      | Não, mas exp ou level deve ser informado | Representa os Pontos de Experiência iniciais de um Nível específico<br/>e será afetado por gradientes de Nível personalizados. |

<br/>

### Adicionar ou editar Reflexões

?> Esta API está disponível a partir da versão v1.93.4 (536).

**Nome do método:** feeling

**Descrição:** Serve para criar ou atualizar registros de Reflexões.

**Exemplo:**

- Criar um registro de Reflexão: [lifeup://api/feeling?content=Happy&time=1633036800](lifeup://api/feeling?content=Happy&time=1633036800)
- Atualizar um registro de Reflexão existente e marcá-lo como favorito: [lifeup://api/feeling?id=1&is_favorite=true](lifeup://api/feeling?id=1&is_favorite=true)
- Excluir uma Reflexão: [lifeup://api/feeling?id=1&delete=true](lifeup://api/feeling?id=1&delete=true)

| Parâmetro            | Significado           | Tipo                               | Exemplo           | Obrigatório | Notas                                                                                                                                                                                                                                        |
| -------------------- | ----------------- | ---------------------------------- | ----------------- | -------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| id                   | ID do registro de Reflexão | Number greater than 0              | 1                 | Não       | Se informado, o método tenta atualizar um registro específico. Obrigatório ao excluir.                                                                                                                                                           |
| content              | Conteúdo           | Any text                           | Happy             | Não       | Usado para criar um registro novo ou atualizar o conteúdo de um existente                                                                                                                                                                    |
| time                 | Timestamp         | Unix timestamp                     | 1633036800        | Não       | Hora do registro; padrão é a hora atual                                                                                                                                                                                             |
| is_favorite          | Marca de favorito     | true or false                      | true              | Não       | Marca o registro como favorito ou não                                                                                                                                                                                                        |
| delete               | Excluir            | true or false                      | true              | Não       | v1.105.1+. Exclui suavemente a Reflexão da mesma forma que a App (anexos são removidos).                                                                                                                                                       |
| relate_type          | Tipo de relação     | Number between 0 and 3             | 1                 | Não       | Especifica o tipo de relação associado ao registro:<br/>0: Tarefa<br/>1: Conquista personalizada<br/>2: Sem relação<br/>3: Uso de Item                                                                                                        |
| relate_id            | ID relacionado        | Number greater than 0              | 2                 | Não       | Especifica o ID do item relacionado:<br/>Quando relate_type é 0: representa o ID da Tarefa<br/>Quando relate_type é 1: representa o ID da Conquista<br/>Quando relate_type é 3: representa o ID do Item<br/>Quando relate_type é 2: nenhum ID necessário                |
| usage_count          | Contagem de uso       | Integer greater than 1             | 1                 | Não       | Válido apenas quando relate_type é 3 (uso de Item); registra a contagem de uso do Item.                                                                                                                                                          |
| image_uris           | URIs de imagem        | List of URI strings                |                   | Não       | Suporta URIs de arquivos locais (file://) ou imagens web remotas (http/https). Admite arrays (p. ex., &image_uris=uri1&image_uris=uri2). |
| image_uris_update_mode | Modo de atualização       | APPEND or REPLACE | REPLACE           | Não       | Válido apenas ao atualizar um registro existente e informar image_uris.<br/>APPEND: Anexa às imagens existentes.<br/>REPLACE: Substitui as imagens existentes (padrão).                                                               |
    
**Nota:**

1. Se o parâmetro `id` for informado, o método tenta atualizar o registro de Reflexão correspondente. Uma exceção é lançada se nenhum registro correspondente for encontrado.
2. Se `id` não for informado, mas `content` sim, o método criará um registro de Reflexão novo.

<br/>

### Contagem de tomates

?> Requer v1.98.0+

**Nome do método:** tomato

**Descrição:** Ajusta o número de tomates (aumentar, diminuir ou definir uma quantidade específica)

**Exemplos:**

- Adicionar 1 tomate: [lifeup://api/tomato?action=increase&number=1](lifeup://api/tomato?action=increase&number=1)
- Remover 2 tomates: [lifeup://api/tomato?action=decrease&number=2](lifeup://api/tomato?action=decrease&number=2)
- Definir a contagem Pomodoro em 10: [lifeup://api/tomato?action=set&number=10](lifeup://api/tomato?action=set&number=10)

| Parâmetro | Significado        | Valores                                        | Exemplo   | Obrigatório | Notas                                                         |
| --------- | -------------- | --------------------------------------------- | --------- | -------- | ------------------------------------------------------------- |
| action    | Tipo de operação | One of:<br/>increase<br/>decrease<br/>set     | increase  | Não       | increase - Adicionar pomodoros (padrão)<br/>decrease - Remover pomodoros<br/>set - Definir a contagem Pomodoro no valor indicado |
| number    | Quantidade         | Integer                                       | 1         | Sim      | Significado conforme action:<br/>increase/decrease - Quantidade a adicionar/remover<br/>set - Quantidade alvo |

**Resposta:**

| Campo    | Tipo    | Descrição              | Exemplo |
| -------- | ------- | ------------------------ | ------- |
| tomatoes | Integer | Contagem Pomodoro atual   | 10      |

<br/>

### Comprar Item

?> Requer v1.98.0+

**Nome do método:** purchase_item

**Descrição:** Compra um Item específico

**Exemplos:**

- Comprar Item com ID 1: [lifeup://api/purchase_item?id=1](lifeup://api/purchase_item?id=1)
- Comprar Item chamado "Health Potion": [lifeup://api/purchase_item?name=Health%20Potion](lifeup://api/purchase_item?name=Health%20Potion)
- Comprar 5 unidades do Item com ID 1: [lifeup://api/purchase_item?id=1&purchase_quantity=5](lifeup://api/purchase_item?id=1&purchase_quantity=5)

Se o Item tiver `purchase_limit` configurado e `limit_scope` incluir `purchase`, esta API também aplicará essas restrições.

| Parâmetro         | Significado          | Valores                | Exemplo       | Obrigatório | Notas                      |
| ----------------- | ---------------- | --------------------- | ------------- | -------- | -------------------------- |
| id                | ID do Item          | number greater than 0 | 1             | Não*      | É necessário id ou name |
| name              | Nome do Item        | any text              | Health Potion | Não*      | É necessário id ou name |
| purchase_quantity | Quantidade de compra| number greater than 0 | 5             | Não       | Padrão 1              |

**Resposta:**

| Campo  | Tipo    | Descrição        | Exemplo         | Notas                       |
| ------ | ------- | ------------------ | --------------- | --------------------------- |
| itemId | Number  | ID do Item            | 1               | Retornado em compra bem-sucedida  |
| result | Integer | Código de resultado        | 0               | Ver códigos de resultado abaixo      |
| desc   | Text    | Descrição do resultado | PurchaseSuccess | Ver códigos de resultado abaixo      |

**Códigos de resultado:**

| Código | Descrição               | Notas                         |
| ---- | ------------------------- | ----------------------------- |
| 0    | PurchaseSuccess           | Compra bem-sucedida            |
| 1    | DatabaseError             | Erro de banco de dados                |
| 2    | NotEnoughCoin             | Moedas insuficientes              |
| 3    | ItemNotFound              | Item não encontrado                |
| 4    | PurchaseAndUseSuccess     | Compra e uso bem-sucedidos    |
| 5    | PurchaseSuccessAndUseFailure | Compra bem-sucedida, mas uso falhou |
| 6    | NotPurchaseable           | Compra bloqueada por configurações ou restrições do Item |
| 7    | OutOfStock                | Estoque da Loja insuficiente      |

<br/>

### Síntese

?> Requer v1.98.0+

**Nome do método:** synthesize

**Descrição:** Sintetiza Itens usando uma fórmula existente

**Exemplos:**

- Sintetizar uma vez com a fórmula de ID 1: [lifeup://api/synthesize?id=1](lifeup://api/synthesize?id=1)
- Sintetizar 5 vezes com a fórmula de ID 1: [lifeup://api/synthesize?id=1&times=5](lifeup://api/synthesize?id=1&times=5)

**Comportamento de broadcast:**

- Esta API é para **Síntese por receita**.
- Quando `Broadcast events` está ativado e a Síntese tem sucesso, o LifeUp também envia o evento de broadcast `app.lifeup.synthesis.complete`.
- Este evento **não** é enviado para Síntese simples dentro de `use_item`; esse caminho ainda pertence a `app.lifeup.item.use`.

| Parâmetro | Significado            | Valores                | Exemplo | Obrigatório | Notas                    |
| --------- | ----------------- | -------------------- | ------- | -------- | ------------------------ |
| id        | ID da fórmula        | number greater than 0 | 1       | Sim      | ID da fórmula de Síntese  |
| times     | Número de vezes   | number greater than 0 | 5       | Não       | Padrão 1           |

**Resposta:**

| Campo           | Tipo    | Descrição     | Exemplo          | Notas                    |
| -------------- | ------- | --------------- | ---------------- | ------------------------ |
| formulaId      | Number  | ID da fórmula      | 1                |                          |
| result         | Integer | Código de resultado     | 0                | Ver códigos de resultado abaixo   |
| desc           | Text    | Descrição do resultado | SynthesisSuccess | Ver códigos de resultado abaixo |
| synthesisResults| Text   | Resultados da Síntese | {...}           | Retornado apenas em caso de sucesso |

**Códigos de resultado:**

| Código | Descrição          | Notas                 |
| ---- | ------------------- | --------------------- |
| 0    | SynthesisSuccess    | Síntese bem-sucedida  |
| 1    | FormulaNotFound     | Fórmula não encontrada     |
| 2    | InsufficientMaterials| Materiais insuficientes |
| 3    | DatabaseError       | Erro de banco de dados        |
| 4    | UnknownError        | Outros erros         |

<br/>

### Gerenciamento de fórmulas de Síntese

?> Requer v1.98.0+

**Nome do método:** synthesis_formula

**Descrição:** Criar, modificar ou excluir fórmulas de Síntese

**Exemplos:**

- Criar uma fórmula nova: [lifeup://api/synthesis_formula?inputItems=%5B%7B%22item_id%22%3A%20296%2C%20%22amount%22%3A%2088%7D%5D&outputItems=%5B%7B%22item_id%22%3A%20295%2C%20%22amount%22%3A%201%7D%5D](lifeup://api/synthesis_formula?inputItems=%5B%7B%22item_id%22%3A%20296%2C%20%22amount%22%3A%2088%7D%5D&outputItems=%5B%7B%22item_id%22%3A%20295%2C%20%22amount%22%3A%201%7D%5D)
  - Aqui, inputItems é `[{"item_id": 296, "amount": 88}]`
  - Aqui, outputItems é `[{"item_id": 295, "amount": 1}]`
- Excluir fórmula: [lifeup://api/synthesis_formula?id=1&delete=true](lifeup://api/synthesis_formula?id=1&delete=true)

| Parâmetro   | Significado        | Valores                | Exemplo                        | Obrigatório | Notas                          |
| ----------- | -------------- | -------------------- | ------------------------------ | -------- | ------------------------------ |
| id          | ID da fórmula     | number greater than 0 | 1                             | Não       | Obrigatório para modificar ou excluir  |
| delete      | Marca de exclusão    | true or false        | true                          | Não       | Usado apenas para exclusão         |
| inputItems  | Itens de entrada    | Item array, see below | [{"item_id":1,"amount":2}]     | Sim      | Obrigatório para criar ou modificar  |
| outputItems | Itens de saída   | Item array, see below | [{"item_id":3,"amount":1}]     | Sim      | Obrigatório para criar ou modificar  |
| category    | ID da categoria    | number greater than 0 | 1                             | Não       | Padrão: categoria comum    |

!> inputItems e outputItems são arrays JSON em que cada item contém os campos item_id e amount. Todos os IDs de Item devem existir e as quantidades devem ser maiores que 0

**Resposta:**

| Campo     | Tipo    | Descrição      | Exemplo     | Notas                    |
| --------- | ------- | ---------------- | ----------- | ------------------------ |
| formulaId | Number  | ID da fórmula       | 1           | Retornado em caso de sucesso      |
| result    | Integer | Código de resultado      | 0           | Ver códigos de resultado abaixo   |
| desc      | Text    | Descrição do resultado | AddSuccess | Ver códigos de resultado abaixo   |

**Códigos de resultado:**

| Código | Descrição     | Notas             |
| ---- | -------------- | ----------------- |
| 0    | Success        | Operação bem-sucedida |
| 1    | Failed         | Operação falhou  |

<br/>

### Gerenciamento de subtarefas

?> Requer v1.98.0+

**Nome do método:** subtask

**Descrição:** Criar ou editar subtarefas

**Exemplos:**

- Adicionar uma subtarefa à Tarefa principal com ID 1: [lifeup://api/subtask?main_id=1&todo=Complete%20homework](lifeup://api/subtask?main_id=1&todo=Complete%20homework)
- Editar subtarefa e definir Recompensas: [lifeup://api/subtask?main_id=1&edit_id=2&coin=10&exp=5](lifeup://api/subtask?main_id=1&edit_id=2&coin=10&exp=5)

| Parâmetro     | Significado            | Valores                | Exemplo    | Obrigatório | Notas                           |
| ------------ | ------------------ | -------------------- | ---------- | -------- | ------------------------------- |
| main_id      | ID da Tarefa principal       | number greater than 0 | 1         | Não*      | É necessário um de main_id, main_gid ou main_name |
| main_gid     | ID do grupo de Tarefa principal | number greater than 0 | 1         | Não*      | É necessário um de main_id, main_gid ou main_name |
| main_name    | Nome da Tarefa principal     | any text             | Study task | Não*      | É necessário um de main_id, main_gid ou main_name |
| edit_id      | ID da subtarefa a editar | number greater than 0 | 2         | Não*      | É necessário um de edit_id, edit_gid ou edit_name ao editar; não necessário ao criar |
| edit_gid     | ID do grupo de subtarefa   | number greater than 0 | 2         | Não*      | É necessário um de edit_id, edit_gid ou edit_name ao editar; não necessário ao criar |
| edit_name    | Nome da subtarefa       | any text             | Do homework| Não*      | É necessário um de edit_id, edit_gid ou edit_name ao editar; não necessário ao criar |
| todo         | Conteúdo da Tarefa       | any text             | Do homework| Não       | Obrigatório ao criar subtarefa nova |
| remind_time  | Hora do lembrete      | timestamp (milliseconds)| 1640995200000 | Não | Informe null para limpar o lembrete    |
| order        | Ordem              | integer              | 1          | Não       | Posição na lista de Tarefas           |
| coin         | Recompensa em moedas        | [0, 999999]         | 10         | Não       | Moedas obtidas ao concluir    |
| coin_var     | Variação de moedas      | integer              | 5          | Não       | Variação aleatória da Recompensa em moedas  |
| exp          | Recompensa de Pontos de Experiência  | [0, 99999]          | 5          | Não       | Pontos de Experiência obtidos        |
| auto_use_item| Usar Item automaticamente      | true or false        | true       | Não       | Se o Item é usado automaticamente ao concluir |
| item_id      | ID do Item            | number greater than 0 | 1         | Não*      | É necessário item_id ou item_name |
| item_name    | Nome do Item          | any text             | Health Potion| Não*    | É necessário item_id ou item_name |
| item_amount  | Quantidade do Item        | number greater than 0 | 1         | Não       | Válido apenas ao definir Recompensa de Item |
| items        | JSON de Itens         | JSON text            | [{"item_id":1,"amount":1}] | Não | Define várias Recompensas de Item de uma vez |
| coin_set_type     | Como definir o valor de moedas | One of:<br/>absolute<br/>relative | absolute | Não | absolute - define moedas diretamente no valor<br/>relative - soma ou subtrai do valor original de moedas |
| exp_set_type      | Como definir o valor de exp | One of:<br/>absolute<br/>relative | absolute | Não | absolute - define exp diretamente no valor<br/>relative - soma ou subtrai do valor original de exp |

**Resposta:**

| Campo        | Tipo    | Descrição      | Exemplo | Notas            |
| ------------ | ------- | ---------------- | ------- | ---------------- |
| main_task_id | Number  | ID da Tarefa principal     | 1       |                  |
| subtask_id   | Number  | ID da subtarefa       | 2       |                  |
| subtask_gid  | Number  | ID do grupo de subtarefa | 3       | Pode estar vazio     |

<br/>

### Gerenciamento de categorias

?> Requer v1.98.0+

**Nome do método:** category

**Descrição:** Adicionar ou editar categorias (listas de Tarefas, listas de Conquistas, listas da Loja, listas de Síntese)

**Exemplos:**

- Criar uma lista de Tarefas: [lifeup://api/category?type=tasks&name=Study List](lifeup://api/category?type=tasks&name=Study List)
- Editar uma lista da Loja: [lifeup://api/category?type=shop&edit_id=1&name=Equipment Shop&order=1](lifeup://api/category?type=shop&edit_id=1&name=Equipment Shop&order=1)

| Parâmetro        | Significado           | Valores               | Exemplo    | Obrigatório | Notas                           |
| --------------- | ----------------- | -------------------- | ---------- | -------- | ------------------------------- |
| type            | Tipo de categoria     | One of:<br/>tasks<br/>achievements<br/>shop<br/>synthesis | tasks | Sim | tasks - Listas de Tarefas<br/>achievements - Listas de Conquistas<br/>shop - Listas da Loja<br/>synthesis - Listas de Síntese |
| edit_id         | ID da categoria a editar| number greater than 0| 1         | Não       | Obrigatório ao editar           |
| name            | Nome da categoria     | any text             | Study List | Não       | Obrigatório para categorias novas; opcional ao editar |
| order           | Ordem de classificação        | integer              | 1         | Não       | Posição na lista            |
| hidden          | Ocultar categoria     | true or false        | false     | Não       | tasks=arquivo; shop=ocultar na Loja; synthesis=ocultar. Listas de Conquistas e a lista ALL de Síntese rejeitam com `unsupported_parameter`. `false` exibe novamente |
| inventory_hidden| Ocultar no Inventário | true or false        | false     | Não       | Suportado apenas para listas da Loja   |
| icon_uri        | URI do ícone          | emoji, http(s) URL, content URI, or empty | 🏆 | Não | Suportado apenas para listas de Conquistas. Emoji armazenado como `emoji_*.webp`. Vazio limpa. |
| desc            | Descrição       | any text             | This is a description | Não | Suportado apenas para listas de Conquistas |
| color           | Cor da etiqueta         | color string         | #66CCFF   | Não       | Suportado apenas para listas de Tarefas; # deve ser escapado como %23 |

**Resposta:**

| Campo | Tipo    | Descrição    | Exemplo | Notas                    |
| ----- | ------- | -------------- | ------- | ------------------------ |
| id    | Number  | ID da categoria    | 1000    | ID da categoria nova ou editada |

<br/>

### Exportar backup

?> Requer v1.98.0+

**Nome do método:** export_backup

**Descrição:** Cria um arquivo de backup e retorna sua URI (apenas chamadas via Content Provider)

!> Esta API só pode ser invocada via Content Provider; chamadas diretas por URL Scheme não são suportadas

| Parâmetro      | Significado        | Valores          | Exemplo | Obrigatório | Notas                                         |
| ------------- | -------------- | --------------- | ------- | -------- | --------------------------------------------- |
| withMedia     | Incluir arquivos de mídia | true or false | true    | Não       | Se arquivos de mídia (imagens, efeitos sonoros etc.) são incluídos no backup<br/>Padrão true |
| callingPackage| Nome do pacote chamador | any text      | com.example.app | Não | Identificador do pacote para chamadas via Content Provider |

**Resposta:**

| Campo          | Tipo   | Descrição          | Exemplo                                       |
| -------------- | ------ | -------------------- | --------------------------------------------- |
| backup_file_uri | Text   | URI do arquivo de backup      | content://net.sarasarasa.lifeup.api/backup/file.zip |

<br/>

### Operação de subtarefas

?> Requer v1.98.0+

**Nome do método:** subtask_operation

**Descrição:** Concluir, desfazer conclusão ou excluir subtarefas

**Exemplos:**

- Concluir uma subtarefa: [lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=complete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=complete)
- Excluir uma subtarefa: [lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=delete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=delete)
- Desfazer conclusão de subtarefa: [lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=undo_complete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=undo_complete)

| Parâmetro     | Significado          | Valores               | Exemplo    | Obrigatório | Notas                          |
| ------------ | ---------------- | ------------------- | ---------- | -------- | ------------------------------ |
| main_id      | ID da Tarefa principal     | number greater than 0| 1         | Não*      | É necessário um de main_id, main_gid ou main_name |
| main_gid     | ID do grupo de Tarefa principal| number greater than 0| 1        | Não*      | É necessário um de main_id, main_gid ou main_name |
| main_name    | Nome da Tarefa principal   | any text            | Study task | Não*      | É necessário um de main_id, main_gid ou main_name |
| edit_id      | ID da subtarefa       | number greater than 0| 2         | Não*      | É necessário um de edit_id, edit_gid ou edit_name |
| edit_gid     | ID do grupo de subtarefa | number greater than 0| 2         | Não*      | É necessário um de edit_id, edit_gid ou edit_name |
| edit_name    | Nome da subtarefa     | any text            | Do homework| Não*      | É necessário um de edit_id, edit_gid ou edit_name |
| operation    | Tipo de operação   | One of the following:<br/>complete<br/>undo_complete<br/>delete | complete | Sim | complete - Concluir Tarefa<br/>undo_complete - Desfazer conclusão<br/>delete - Excluir Tarefa |

**Resposta:**

| Campo        | Tipo    | Descrição      | Exemplo | Notas            |
| ------------ | ------- | ---------------- | ------- | ---------------- |
| main_task_id | Number  | ID da Tarefa principal     | 1       |                  |
| subtask_id   | Number  | ID da subtarefa       | 2       |                  |
| subtask_gid  | Number  | ID do grupo de subtarefa | 3       | Pode estar vazio     |

<br/>

### Gerenciamento de Conquistas

?> Requer v1.98.0+

**Nome do método:** achievement

**Descrição:** Adicionar ou editar Conquistas personalizadas e subcategorias de Conquistas

**Exemplos:**

- Criar uma Conquista: [lifeup://api/achievement?name=Collector&desc=Collect 100 items&category_id=1](lifeup://api/achievement?name=Collector&desc=Collect 100 items&category_id=1)
  - Talvez seja necessário substituir `category_id` pelo id real da sua lista de Conquistas disponível para testar este exemplo
- Criar uma Conquista com condições de desbloqueio: [lifeup://api/achievement?name=Millionaire&conditions_json=%5B%7B%22type%22%3A7%2C%22target%22%3A1000000%7D%5D&category_id=1](lifeup://api/achievement?name=Millionaire&conditions_json=%5B%7B%22type%22%3A7%2C%22target%22%3A1000000%7D%5D&category_id=1)
  - Talvez seja necessário substituir `category_id` pelo id real da sua lista de Conquistas disponível para testar este exemplo
  - O conteúdo decodificado de `conditions_json` é `[{"type":7,"target":1000000}]`
- Editar Conquista existente: [lifeup://api/achievement?edit_id=1&name=New Achievement Name&exp=100](lifeup://api/achievement?edit_id=1&name=New Achievement Name&exp=100)

#### 1. Parâmetros de Conquista

| Parâmetro      | Significado           | Valores               | Exemplo   | Obrigatório | Notas                           |
| ------------- | ----------------- | -------------------- | --------- | -------- | ------------------------------- |
| edit_id       | ID da Conquista a editar | number greater than 0 | 1      | Não       | Obrigatório ao editar          |
| is_subcategory| É subcategoria    | true or false        | false     | Não       | Padrão false               |
| name          | Nome da Conquista   | any text             | Collector | Não*      | Obrigatório para Conquistas novas   |
| desc          | Descrição       | any text             | Collect 100 items | Não |                               |
| icon_uri      | Ícone              | emoji, http(s) URL, content URI, or empty | 🏆 | Não | Não é `icon`. Emoji é armazenado como arquivo `emoji_`. Vazio limpa. |
| order         | Ordem de classificação        | integer              | 1         | Não       | Posição na lista                |
| category_id   | ID da categoria       | number greater than 0 | 1        | Não*      | Obrigatório ao criar subcategoria |
| unlocked      | Status de desbloqueio     | true or false        | true      | Não       | true - desbloquear imediatamente<br/>false - redefinir para bloqueado |
| unlock_time   | Hora de desbloqueio       | timestamp (milliseconds) | 1640995200000 | Não | Efetivo apenas quando já desbloqueado |
| delete        | Marca de exclusão       | true or false        | false     | Não       |                                |
| secret        | Conquista oculta| true or false        | false     | Não       |                                |
| write_feeling | Registrar Reflexões   | true or false        | false     | Não       |                                |
| color         | Cor do título       | color string         | #66CCFF   | Não       | # deve ser escapado como %23        |
| auto_use_item | Usar Item automaticamente     | true or false        | false     | Não       |                                |
| skills        | IDs de Habilidade         | array of numbers greater than 0 | 1 | Não    | Admite arrays (p. ex., &skills=1&skills=2) |
| exp           | Recompensa de Pontos de Experiência | integer              | 100       | Não       |                                |
| item_id       | ID do Item           | number greater than 0 | 1        | Não*      | É necessário item_id ou item_name |
| item_name     | Nome do Item         | any text             | Treasure  | Não*      | É necessário item_id ou item_name |
| item_amount   | Quantidade do Item     | [1, 99]             | 1         | Não       | Padrão 1                   |
| items         | JSON de Recompensas de Item | JSON text            | [{"item_id":1,"amount":2}] | Não | Define várias Recompensas de Item; ver formato abaixo |
| conditions_json| JSON de condições de desbloqueo | JSON text      | [{"type":7,"target":1000000}] | Não | Define condições de desbloqueio; ver formato abaixo |
| coin         | Recompensa em moedas       | [0, 999999]      | 10         | Não       | Quantidade de moedas obtidas ao desbloquear a Conquista |
| coin_var     | Variação da Recompensa em moedas | integer              | 5          | Não       | Faixa de variação das Recompensas em moedas |
| coin_set_type| Como definir o valor de moedas | One of:<br/>absolute<br/>relative | absolute | Não | absolute - define moedas diretamente no valor<br/>relative - soma ou subtrai do valor original de moedas |
| exp_set_type | Como definir o valor de exp | One of:<br/>absolute<br/>relative | absolute | Não | absolute - define exp diretamente no valor<br/>relative - soma ou subtrai do valor original de exp |

**Resposta:**

| Campo  | Tipo    | Descrição      | Exemplo | Notas                    |
| ------ | ------- | ---------------- | ------- | ------------------------ |
| id     | Number  | ID da Conquista   | 1000    | ID da Conquista nova ou editada |

#### 2. Parâmetros de subcategoria

| Parâmetro     | Significado           | Valores               | Exemplo   | Obrigatório | Notas                           |
| ------------ | ----------------- | -------------------- | --------- | -------- | ------------------------------- |
| is_collapsed | Status de recolhimento   | true or false        | false     | Não       | Aplica-se apenas a subcategorias   |

Subcategorias rejeitam `icon_uri` (incluindo emoji) com `unsupported_parameter`. Editar uma subcategoria sem `is_subcategory=true` retorna `is_subcategory_required`.
**Resposta:**

| Campo  | Tipo    | Descrição      | Exemplo | Notas                    |
| ------ | ------- | ---------------- | ------- | ------------------------ |
| id     | Number  | ID da Conquista   | 1000    | ID da Conquista nova ou editada (subcategoria) |

#### 3. Tipos de condição de desbloqueio

| Código de tipo | Descrição             | Requer related_id | Tipo de related_id | Descrição de target  |
| --------- | ----------------------- | ------------------ | --------------- | ------------------ |
| 0         | Contagem de conclusões de Tarefa   | Sim                | ID da Tarefa         | Número de conclusões |
| 1         | Sequência de conclusões de Tarefa  | Sim                | ID da Tarefa         | Contagem da sequência       |
| 3         | Contagem Pomodoro         | Não                 | -               | Número de pomodoros |
| 4         | Dias usando LifeUp      | Não                 | -               | Número de dias     |
| 5         | Contagem de curtidas             | Não                 | -               | Número de curtidas    |
| 6         | Sequência diária de conclusões | Não                 | -               | Dias de sequência        |
| 7         | Moedas atuais          | Não                 | -               | Quantidade de moedas    |
| 8         | Moedas obtidas em um dia| Não                 | -               | Quantidade de moedas    |
| 9         | Contagem Pomodoro de Tarefa    | Sim                | ID da Tarefa         | Número de pomodoros |
| 10        | Contagem de compras de Item    | Sim                | ID do Item         | Contagem de compras     |
| 11        | Contagem de usos de Item       | Sim                | ID do Item         | Contagem de usos        |
| 12        | Contagem de Itens de Caixa de saque    | Sim                | ID do Item         | Contagem obtida     |
| 13        | Nível de Habilidade alcançado    | Sim                | ID de Habilidade        | Valor de Nível        |
| 14        | Nível de vida            | Não                 | -               | Valor de Nível        |
| 15        | Total de Itens obtidos   | Sim                | ID do Item         | Contagem total de obtenção |
| 16        | Itens por Síntese   | Sim                | ID do Item         | Contagem de Síntese    |
| 17        | Quantidade atual de Item  | Sim                | ID do Item         | Contagem em posse          |
| 18        | Duração de Foco da Tarefa    | Sim                | ID da Tarefa         | Duração (minutos) |
| 19        | Economias no caixa eletrônico           | Não                 | -               | Valor economizado     |
| 20        | API externa          | Não                 | -               | Definido pela API        |
| 520       | Concluir N Tarefas distintas por dia | Não         | -               | Contagem de Tarefas distintas (deduplicado por ID de grupo; tipo existente) |
| 524       | Concluir N conclusões de Tarefa por dia | Não       | -               | Contagem total de conclusões válidas em um dia (v1.104.4+) |

> A partir de v1.104.4, os tipos `520` e `524` usam a seguinte semântica:
>
> - Ambos compartilham a mesma definição de conclusão e o limite de dia do calendário local (`TimeRange.today()`).
> - Tarefas normais contam `COMPLETED`; Tarefas negativas contam `GIVE_UP`.
> - O tipo `520` deduplica por `groupId` efetivo (recorre ao id do registro da Tarefa quando o id de grupo está ausente). Concluir a mesma Tarefa ilimitada várias vezes em um dia ainda conta como 1 Tarefa distinta.
> - O tipo `524` conta cada linha de conclusão válida. Concluir a mesma Tarefa ilimitada 5 vezes produz `completionCount = 5`.
> - Conquistas existentes com `type=520` mantêm a semântica de Tarefas distintas; nenhuma migração é necessária.

#### 4. Especificações de formato JSON

##### Condições de desbloqueio (conditions_json)

```json
[
    {
        "type": 7,           // Condition type (refer to table above)
        "related_id": null,  // Related ID (required for some types)
        "target": 1000000    // Target value
    },
    {
        "type": 10,          // Example: Purchase specific item
        "related_id": 1,     // Item ID
        "target": 5          // Purchase 5 times
    },
    {
        "type": 520,         // Complete N distinct tasks daily
        "related_id": null,
        "target": 5
    },
    {
        "type": 524,         // Complete N task completions daily
        "related_id": null,
        "target": 10
    }
]
```

##### Recompensas de Item (items)

```json
[
    {
        "item_id": 1,    // Item ID
        "amount": 2      // Quantity
    },
    {
        "item_id": 2,
        "amount": 3
    }
]
```

<br/>

### Gerenciamento de Habilidades

?> Requer v1.98.0+

**Nome do método:** skill

**Descrição:** Criar ou editar Habilidades personalizadas (Atributos)

**Exemplos:**

- Criar uma Habilidade: [lifeup://api/skill?content=Programming&desc=Coding ability&color=%23FF6B6B](lifeup://api/skill?content=Programming&desc=Coding ability&color=%23FF6B6B)
- Editar Pontos de Experiência da Habilidade: [lifeup://api/skill?id=1&exp=100](lifeup://api/skill?id=1&exp=100)
- Excluir Habilidade: [lifeup://api/skill?id=1&delete=true](lifeup://api/skill?id=1&delete=true)

| Parâmetro    | Significado           | Valores               | Exemplo    | Obrigatório | Notas                           |
| ----------- | ----------------- | -------------------- | ---------- | -------- | ------------------------------- |
| id          | ID de Habilidade          | number greater than 0 | 1         | Não       | Obrigatório ao editar           |
| content     | Nome da Habilidade        | any text             | Programming| Não*      | Obrigatório para Habilidades novas         |
| desc        | Descrição       | any text             | Coding ability | Não    |                                |
| icon        | Ícone              | any text             | 💻         | Não       | Pode usar emoji                   |
| color       | Cor             | color string         | #FF6B6B    | Não       | # deve ser escapado como %23        |
| type        | Tipo              | integer              | 0          | Não       |                                |
| order       | Ordem de classificação        | integer              | 1          | Não       | Posição bruta na lista mista. Usado sozinho, a Habilidade é colocada nessa posição e o grupo final é inferido do layout; usado com `group_id`, encaixa na posição legal mais próxima dentro do grupo alvo |
| group_id    | ID do grupo de Habilidade    | integer              | 10         | Não       | Requer v1.103.0+; não pode ser menor que `0`, e apenas `0` move a Habilidade para a área sem grupo. Usado sozinho, Habilidades novas são anexadas ao final do grupo alvo, enquanto Habilidades editadas mantêm a posição atual se já estiverem nesse grupo; caso contrário, movem para o final do grupo; usado com `order`, `group_id` tem prioridade |
| status      | Status            | integer              | 0          | Não       |                                |
| exp         | Pontos de Experiência | number greater than or equal to 0 | 100 | Não | Pontos de Experiência atuais da Habilidade        |
| delete      | Marca de exclusão       | true or false        | false      | Não       | Válido apenas ao editar         |

**Resposta:**

| Campo  | Tipo    | Descrição    | Exemplo | Notas                    |
| ------ | ------- | -------------- | ------- | ------------------------ |
| id     | Number  | ID de Habilidade       | 1000    | ID da Habilidade nova ou editada |

<br/>

### Gerenciamento de grupos de Habilidades :id=skill_group_management

Requer v1.103.0+

**Nome do método:** skill_group

**Descrição:** Criar, editar, excluir ou reordenar grupos de Habilidades. A API de ordenação também suporta ordenação mista de grupos e Habilidades.

**Exemplos:**

- Criar um grupo: [lifeup://api/skill_group?content=Combat](lifeup://api/skill_group?content=Combat)
- Editar um grupo: [lifeup://api/skill_group?id=10&content=Combat&order=20&collapsed=true](lifeup://api/skill_group?id=10&content=Combat&order=20&collapsed=true)
- Excluir um grupo: [lifeup://api/skill_group?id=10&delete=true](lifeup://api/skill_group?id=10&delete=true)
- Ordenar grupos e Habilidades juntos:

```text
lifeup://api/skill_group?sort_json=[{"type":"skill","id":2},{"type":"group","id":10},{"type":"skill","id":3}]
```

| Parâmetro | Significado | Valores | Exemplo | Obrigatório | Notas |
| --------- | ------- | ------ | ------- | -------- | ----- |
| id | ID do grupo de Habilidade | number greater than 0 | 10 | Não* | Obrigatório ao editar ou excluir |
| content | Nome do grupo | any text | Combat | Não* | Obrigatório ao criar |
| order | Ordem de classificação | integer | 20 | Não | Valor bruto de `orderInCategory`; deve ser único na lista mista de Habilidade/grupo |
| collapsed | Estado de recolhimento | true or false | true | Não | Se o grupo está recolhido |
| delete | Marca de exclusão | true or false | false | Não | Válido apenas ao editar |
| sort_json | Nós de ordenação mista | JSON array | `[{"type":"skill","id":2},{"type":"group","id":10}]` | Não* | Quando informado, parâmetros CRUD são ignorados e o plano de ordenação mista é aplicado. Ordenação parcial é suportada: nós não especificados mantêm a ordem relativa |

Formato de nó de `sort_json`:

| Campo | Significado | Valores |
| ----- | ------- | ------ |
| type | Tipo de nó | `skill` / `group` |
| id | ID da entidade | number greater than 0 |

**Resposta:**

| Campo | Tipo | Descrição | Exemplo | Notas |
| ----- | ---- | ----------- | ------- | ----- |
| id | Number | ID do grupo de Habilidade | 10 | Retornado para criar / editar / excluir |
| count | Number | Número de nós ordenados | 3 | Retornado para solicitações `sort_json` |

<br/>

### Configurações do App

?> Requer v1.98.0+

**Nome do método:** app_settings

**Descrição:** Ajusta as configurações da interface do App

**Exemplos:**

- Ativar o modo compacto: [lifeup://api/app_settings?is_enable_compact_mode=true](lifeup://api/app_settings?is_enable_compact_mode=true)
- Ativar o tema Material You: [lifeup://api/app_settings?is_enable_material_you=true](lifeup://api/app_settings?is_enable_material_you=true)
- Alterar configurações e reiniciar a interface imediatamente: [lifeup://api/app_settings?is_enable_compact_mode=true&restart_activities=true](lifeup://api/app_settings?is_enable_compact_mode=true&restart_activities=true)

| Parâmetro              | Significado           | Valores          | Exemplo | Obrigatório | Notas                           |
| --------------------- | ----------------- | --------------- | ------- | -------- | ------------------------------- |
| is_enable_compact_mode| Ativar modo compacto| true or false  | true    | Não       | Simplifica elementos da interface     |
| is_enable_material_you| Ativar Material You| true or false  | true    | Não       | Ativa o tema Material You       |
| restart_activities    | Reiniciar interface | true or false   | true    | Não       | Aplica alterações de interface imediatamente |
| broadcast_event | Eventos de broadcast do LifeUp Labs | true or false | true | Não | Desativado por padrão. Mesmo interruptor que Configurações → Labs |

**Resposta:**

| Campo  | Tipo    | Descrição  | Exemplo | Notas                    |
| ------ | ------- | ------------ | ------- | ------------------------ |
| result | Integer | Código de resultado  | 0       | 0 indica sucesso      |

<br/>

### Consulta simples

!> As funções aqui são usadas com ferramentas de automação/desenvolvimento secundário. Se você precisa consultar uma lista completa de dados, consulte o [`LifeUp SDK`, `LifeUp Cloud`](https://github.com/Ayagikei/LifeUp-SDK) e o [`LifeUp Desktop`.](https://github.com/Ayagikei/LifeUp-Desktop)

**Nome do método:** query

**Descrição:** Consulta parâmetros

**Exemplo:** - Consultar a quantidade atual de moedas: [lifeup://api/query?key=coin](lifeup://api/query?key=coin)
- Consultar o interruptor de eventos de broadcast: [lifeup://api/query?key=broadcast](lifeup://api/query?key=broadcast) → `{enabled}`

| Parâmetro   | Significado              | Tipo                                                         | Exemplo | Obrigatório                                    | Notas                                                        |
| ----------- | -------------------- | ------------------------------------------------------------ | ------- | ------------------------------------------- | ------------------------------------------------------------ |
| key         | tipo de consulta        | Apenas um dos seguintes valores:<br/>coin<br/>atm<br/>item<br/>item_id_list<br/>tomato<br/>task<br/>broadcast | coin    | sim                                         | coin - quantidade atual de moedas<br/>atm - saldo atual do caixa eletrônico<br/>item - informações do Item para o `itemId` especificado<br/>item_id_list - lista de IDs de Itens especificada por `categoryId`<br/>tomato - dados de tomate<br/>task - informações da Tarefa (v1.101.0+)<br/>broadcast - interruptor de eventos de broadcast do Labs (`{enabled}`) |
| item_id     | id do Item   | a number greater than 0                                      | 1       | Quando key é `item`, deve ser informado |                                                              |
| category_id | id da categoria da Loja | Number greater than or equal to 0                            | 0       | não*                                         | Obrigatório apenas quando key é `item_id_list`, representando o ID da lista a consultar. |
| task_id / taskId | ID da Tarefa          | Number greater than 0                                        | 1       | Quando key é `task`, um dos três* é obrigatório | ID da Tarefa consultada |
| task_gid / taskGid / task_group_id / taskGroupId | ID do grupo de Tarefas | Number greater than 0 | 1 | Quando key é `task`, um dos três* é obrigatório | ID do grupo de Tarefas consultado |
| task_name / taskName | Nome da Tarefa      | Any text                                                     | Study   | Quando key é `task`, um dos três* é obrigatório | Nome da Tarefa com correspondência aproximada |
| withSubTasks | Incluir subtarefas   | true or false                                                | true    | Não                                          | Disponível apenas quando key é `task`; padrão é true |

**Valor de retorno:**

Suportado apenas desde a versão 1.90.2

Ao consultar coin/atm:

| Parâmetro | Significado                             | Tipo               | Exemplo | Obrigatório | Notas |
| --------- | ----------------------------------- | ------------------ | ------- | -------- | ----- |
| value     | Valor numérico retornado pela consulta | number             | 1000    | sim      |       |

Ao consultar um Item:

| Parâmetro        | Significado                         | Tipo     | Exemplo   | Obrigatório | Notas |
| ---------------- | ------------------------------- | -------- | --------- | -------- | ----- |
| item_id          | id do Item              | number   | 1         | sim      |       |
| name             | nome do Item            | any text | Coffee    | sim      |       |
| desc             | descrição                     | any text |           | não       |       |
| icon             | URL do ícone                        | any text | icon.webp | não       | Se for arquivo local, apenas o nome do arquivo é retornado |
| category_id      | id de dados da categoria                | number   | 1         | sim      |       |
| stock_number     | quantidade em estoque na Loja             | number   | -1        | sim      | `-1` representa estoque infinito na Loja |
| own_number       | quantidade possuída no Inventário | number   | 10        | sim      |       |
| price            | preço                       | number   | 100       | sim      |       |
| order            | ordenação                         | number   | 100       | sim      | Valor de peso na ordenação personalizada |
| disable_purchase | Desativar compra     | true or false | true | sim |       |
| purchase_limit   | Regras de restrição               | JSON text | [{"limitType":0,"limitNumber":5}] | sim | Lista de restrições atual |
| limit_scope      | Escopo de restrição               | purchase / use / both | use | sim | Retornado como valor de texto da API |

Ao consultar item_id_list:

| Parâmetro | Significado                           | Tipo   | Exemplo | Obrigatório | Notas |
| --------- | --------------------------------- | ------ | ------- | -------- | ----- |
| item_ids  | Array de IDs de Itens separados por vírgula     | string | 1,2,3,4 | sim      |       |

Ao consultar tomato:

| Parâmetro | Significado                  | Tipo   | Exemplo | Obrigatório | Notas |
| --------- | ------------------------ | ------ | ------- | -------- | ----- |
| total     | Contagem total de tomates       | number | 100     | sim      |       |
| available | Contagem de tomates disponíveis   | number | 50      | sim      |       |
| exchanged | Contagem de tomates trocados   | number | 50      | sim      |       |

Ao consultar task (v1.101.0+):

| Parâmetro   | Significado                      | Tipo        | Exemplo | Obrigatório | Notas                           |
| ----------- | ---------------------------- | ----------- | ------- | -------- | ------------------------------- |
| _ID         | ID da Tarefa                      | number      | 1       | sim      | -                               |
| _GID        | ID do grupo de Tarefas                | number      | 1       | sim      | -                               |
| name        | Nome da Tarefa                    | text        | Study   | sim      | -                               |
| notes       | Notas                        | text        | -       | não       | Pode estar vazio                    |
| status      | Status da Tarefa                  | number      | 0       | sim      | 0=incompleta, 1=concluída       |
| startTime   | Hora de início                   | number      | -       | sim      | Unix timestamp (milliseconds)   |
| deadline    | Prazo                | number      | -       | não       | Unix timestamp (milliseconds), pode estar vazio |
| remindTime  | Hora do lembrete                  | number      | -       | não       | Unix timestamp (milliseconds), pode estar vazio |
| frequency   | Frequência de repetição         | number      | -       | sim      | -                               |
| weekdays    | Dias da semana                     | text        | 1,3,5   | não       | v1.106.0+; vazio quando não estiver no modo por dia da semana. 1=segunda … 7=domingo |
| exp         | Recompensa de Pontos de Experiência                   | number      | -       | sim      | -                               |
| skillIds    | Lista de IDs de Habilidades                | JSON text   | -       | sim      | Formato de array JSON               |
| coin        | Recompensa de moedas                  | number      | -       | não       | Pode estar vazio                    |
| coinVariable| Recompensa aleatória de moedas           | number      | -       | não       | Pode estar vazio                    |
| itemId      | ID do primeiro Item de Recompensa         | number      | -       | não       | Pode estar vazio                    |
| itemCount   | Quantidade do primeiro Item de Recompensa      | number      | -       | não       | Retornado quando itemId existe     |
| items       | Lista de Recompensas de Itens             | JSON text   | -       | sim      | Formato de array JSON               |
| words       | Palavras motivacionais de conclusão   | text        | -       | não       | Pode estar vazio                    |
| categoryId  | ID da categoria                  | number      | -       | não       | Pode estar vazio                    |
| order       | Ordem                        | number      | -       | sim      | -                               |
| name_extended | Nome estendido              | text        | -       | sim      | Igual a name                    |
| subTasks    | Lista de subtarefas                | JSON text   | -       | sim      | Formato de array JSON, veja abaixo    |

**Descrição do campo de subtarefas (subTasks):**

O campo `subTasks` é um array JSON; cada elemento contém os seguintes campos:

- `id`: ID da subtarefa
- `gid`: ID do grupo da subtarefa
- `todo`: Conteúdo da subtarefa
- `status`: Status da subtarefa (0=incompleta, 1=concluída)
- `remindTime`: Hora do lembrete (Unix timestamp, milliseconds)
- `exp`: Recompensa de Pontos de Experiência
- `coin`: Recompensa de moedas
- `coinVariable`: Recompensa aleatória de moedas
- `items`: Lista de Recompensas de Itens
- `order`: Ordem
- `autoUseItem`: Usar Item automaticamente

<br/>

### Query Attributes :id=query_skill

!> As funções aqui são usadas com ferramentas de automação/desenvolvimento secundário.

**Nome do método:** query_skill

**Descrição:** Consulta informações básicas, campos brutos de ordenação e dados de Nível/Pontos de Experiência de uma Habilidade especificada.

É possível usar esta API para personalizar widgets de Atributos.

**Exemplo:**

- Consultar o Atributo força: [lifeup://api/query_skill?id=1](lifeup://api/query_skill?id=1)

| Parâmetro | Significado              | Tipo                    | Exemplo | Obrigatório | Notas |
| --------- | -------------------- | ----------------------- | ------- | -------- | ----- |
| id        | id de Atributo (Habilidade) | a number greater than 0 | 1       | sim      | Para saber como obtê-lo, consulte acima «Basics - LifeUp Data ID» |

**Valor de retorno:**

Suportado apenas desde a versão 1.90.6

| Parâmetro            | Significado                              | Tipo   | Exemplo  | Obrigatório | Notas |
| -------------------  | ------------------------------------ | ------ | -------- | -------- | ----- |
| id                   | id de Habilidade                             | number | 1        | sim      | Adicionado a `query_skill` em v1.103.0+ |
| name                 | nome do Atributo                       | string | strength | sim      |       |
| order                | ordem bruta de classificação                       | number | 20       | sim      | Adicionado em v1.103.0+; `orderInCategory` |
| group_id             | ID do grupo de Habilidades                       | number | 10       | sim      | Adicionado em v1.103.0+; retorna `0` quando a Habilidade não está em um grupo |
| status               | status                               | number | 0        | sim      | Adicionado em v1.103.0+; `0` = normal, `1` = oculto |
| level                | Nível                                | number | 10       | sim      |       |
| total_exp            | total de Pontos de Experiência              | number | 10000    | sim      |       |
| until_next_level_exp | Pontos de Experiência necessários para o próximo Nível | number | 99       | sim      |       |
| current_level_exp    | Pontos de Experiência acima do Nível atual       | Number | 1000     | Sim      |       |

<br/>

### Query Skill Group :id=query_skill_group

Requer v1.103.0+

**Nome do método:** query_skill_group

**Descrição:** Consulta um único grupo de Habilidades e retorna sua ordenação bruta e estado de recolhimento.

**Exemplo:**

- Consultar um grupo de Habilidades: [lifeup://api/query_skill_group?id=10](lifeup://api/query_skill_group?id=10)

| Parâmetro | Significado | Tipo | Exemplo | Obrigatório | Notas |
| --------- | ------- | ---- | ------- | -------- | ----- |
| id | ID do grupo de Habilidades | number greater than 0 | 10 | sim | - |

**Valor de retorno:**

| Parâmetro | Significado | Tipo | Exemplo | Obrigatório | Notas |
| --------- | ------- | ---- | ------- | -------- | ----- |
| id | ID do grupo de Habilidades | number | 10 | sim | - |
| content | Nome do grupo | string | Combat | sim | - |
| order | Ordem bruta de classificação | number | 20 | sim | `orderInCategory` |
| collapsed | Estado de recolhimento | string | true | sim | Retornado como texto `true` / `false` |

<br/>

<br/>

### Interface especial

#### Aleatório

?> Esta API foi lançada na v1.93.0.

**Nome do método:** random

**Descrição:** Uma interface aleatória simples que pode acionar uma entre várias APIs de forma aleatória.

**Exemplo:**

- Probabilidade igual de exibir aleatoriamente `scissors`, `rock` ou `paper`: [lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper](lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper)

- 90% de probabilidade de exibir `rock`, 5% para `scissors` e 5% para `paper`: [lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper&weight=90&weight=5&weight=5](lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper&weight=90&weight=5&weight=5)

| Parâmetro | Significado    | Valores                 | Exemplo                                | Obrigatório | Notas |
| --------- | ---------- | ---------------------- | -------------------------------------- | -------- | ----- |
| api       | API aleatória | Any text               | lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock | Sim      | Suporta chamada em forma de array (ou seja, vários parâmetros api, como nos exemplos acima) |
| weight    | Peso     | Numbers greater than 0 | 1                                      | Não       | Suporta chamada em forma de array.<br/><br/>Se weight não for especificado, todos os pesos são iguais (probabilidade igual).<br/>Se pesos forem especificados, são atribuídos sequencialmente: p. ex., o primeiro peso corresponde ao primeiro parâmetro api.<br/><br/>**Certifique-se de que o número de parâmetros weight corresponda ao número de parâmetros api, ou pode não surtir efeito.** |

<br/>

#### Diálogo de confirmação

**Nome do método:** confirm_dialog

**Descrição:** Exibe uma janela de seleção pop-up. Você pode personalizar o título, o texto, o botão positivo e o botão negativo. Outras interfaces também podem ser chamadas quando um botão é clicado.

**Exemplo:**

- [<a href="lifeup://api/confirm_dialog?title=Do you believe in love&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dbelieve&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Ddo not believe">lifeup://api/confirm_dialog?title=Do you believe in love&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dbelieve&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Ddo not believe</a>](lifeup://api/confirm_dialog?title=Do you believe in love&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dbelieve&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Ddo not believe)
- Outros cenários de uso:
  - Escolha de Recompensas
  - Seleção de ramificação de evento

| Parâmetro       | Significado              | Tipo     | Exemplo  | Obrigatório | Notas |
| --------------- | -------------------- | -------- | -------- | -------- | ----- |
| title           | título do pop-up          | any text | Title    | sim      |       |
| message         | descrição detalhada da janela pop-up | any text | This is the content of the popup window | não |  |
| positive_text   | texto do botão positivo | any text | YES      | não       |       |
| negative_text   | texto do botão negativo | any text | NO       | não       |       |
| neutral_text    | texto do botão neutro  | any text | QUESTION | não       |       |
| positive_action | resposta de link do botão positivo | URL (other interface) | lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D You clicked OK | não | Na prática, é o texto escapado da interface de mensagem pop-up. Para regras de escape, consulte `Basics - Escaping`. |
| negative_action | resposta de link do botão negativo | URL (other interface) | Same as above | não |  |
| neutral_action  | resposta de link do botão neutro  | URL (other interface) | Same as above | não |  |
| cancel_action   | resposta de link da ação de cancelamento   | URL (other interface) | Same as above | não |  |

<br/>

#### Sem ação

**Nome do método:** placeholder

**Nota:** Esta interface em si não executa nenhuma lógica, mas você pode usá-la com callback e broadcast.

**Exemplo:**

- [lifeup://api/placeholder?broadcast=app.lifeup.item.rest](lifeup://api/placeholder?broadcast=app.lifeup.item.rest)

<br/>

#### Placeholder de variável

`LifeUp` oferece métodos de intervenção do usuário para parâmetros.

| Placeholder                          | Significado                                                      | Exemplo                                                      |
|--------------------------------------|--------------------------------------------------------------|--------------------------------------------------------------|
| [$text\|title]                       | Placeholder de texto                                             | [$text\|Enter task name]                                     |
| [$number\|Title]                     | Placeholder numérico (sem ponto decimal)                   | [$number\|Enter price]                                       |
| [$number\|Title\|signed]             | Placeholder numérico (sem ponto decimal), exibir sinal        | [$number\|Enter price\|signed]                               |
| [$decimal\|title]                    | Placeholder numérico (com ponto decimal)                      | [$decimal\|Enter ATM rate]                                   |
| [$decimal\|title\|signed]            | Placeholder numérico (com ponto decimal), exibir sinal           | [$decimal\|Enter ATM rate\|signed]                           |
| [$item]                              | Selecionar um Item; será substituído pelo id do Item              | [$item]                                                      |
| [$task_category]                     | Selecionar lista de Tarefas, que será substituída pelo id da lista    | [$task_category]                                             |
| [$time\|Anchor Time\|Offset in Milliseconds(optional)] | Placeholder de hora<br/><br/>Valores possíveis para Anchor Time:<br/>`current`, `today`, `this_monday`, `last_monday`, `this_month`, `last_month`, `this_year`, `last_year` <br/><br/>Offset in milliseconds deve ser um inteiro; padrão é 0 milliseconds | Meia-noite de hoje: [$time\|today]<br/>Meia-noite de amanhã: [$time\|today\|86400000] |
| [$random_number\|Min\|Max]           | Placeholder de número aleatório (sem ponto decimal)             | [$random_number\|0\|3000]                                    |
| [$random_decimal\|Min\|Max]          | Placeholder de número aleatório (com ponto decimal)                | [$random_decimal\|1.0\|2.0]                                  |

**Exemplo 1: ao usar, selecionar um Item para reduzir o preço em 1 moeda**

Por exemplo, depois de configurar a API de redução de preço de um Item específico da Loja, você pode querer permitir que o usuário selecione o Item desejado na chamada, em vez de predefinir o id.

A API a seguir só pode reduzir o preço do Item da Loja com id 1 em 1 moeda:

````url
lifeup://api/item?id=1&set_price=-1&set_price_type=relative
````

Basta alterar o id do Item para o placeholder [$item]; na chamada, o usuário pode selecionar ativamente o Item cujo preço deseja reduzir:

<a href="lifeup://api/item?id=[$item]&set_price=-1&set_price_type=relative">lifeup://api/item?id=[$item]&set_price=-1&set_price_type=relative</a>

**Exemplo 2: modelo de Tarefa — basta informar o nome da Tarefa e a lista de seleção para criar um modelo de Recompensa predefinido**

<a href="lifeup://api/add_task?todo=[$text|Enter a task name]&notes=This is a reward template for a task&coin=10&coin_var=10&exp=2048&skills=1&skills=2&skills=3&category=[$task_category]]">lifeup://api/add_task?todo=[$text|Enter a task name]&notes=This is a reward template for a task&coin=10&coin_var=10&exp=2048&skills=1&skills=2&skills=3&category=[$task_category]]</a>

<br/>

#### Callback ao final

Você pode adicionar o parâmetro callback a todas as interfaces para executar o processamento de chamar de volta a URL após a chamada.

Isso também pode ser usado para encadear várias interfaces; por exemplo, se quiser exibir um aviso após o salto:

lifeup://api/goto?page=lab + lifeup://api/toast?text=callback

Você pode usar o parâmetro callback. Consulte também acima **Basics - Escaping**. É possível escrever esse tipo de processamento:

<a href="lifeup://api/goto?page=lab&callback=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dtest callback">lifeup://api/goto?page=lab&callback=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dtest callback</a>

Claro, você também pode adicionar vários links a um Item da Loja para obter esse efeito.

Além disso, esse callback é mais usado para:

Aplicativo X → LifeUp → Aplicativo X

ou

Aplicativo X → LifeUp → Aplicativo Y

<br/>

#### Valor de retorno por broadcast

!> As funções aqui são usadas com ferramentas de automação/desenvolvimento secundário, e há certa curva de aprendizado.

Ao adicionar este parâmetro, o valor de retorno original da API também pode ser enviado por broadcast, para que ferramentas de automação como Tasker possam recebê-lo.

O valor de broadcast equivale ao valor da coluna de ação de «Intentions Received» no Tasker. Você pode preencher qualquer texto, desde que os dois correspondam.

**Por exemplo, usando a API de consulta de moedas com Tasker ([Se você usa MacroDroid, consulte este link.](https://github.com/Ayagikei/LifeUp/issues/43)):**

[lifeup://api/query?key=coin](lifeup://api/query?key=coin)

1. Adicione o parâmetro broadcast para que o valor de retorno seja transmitido ao Tasker; pode ser qualquer texto, como `app.lifeup.query.coin`.

   [lifeup://api/query?key=coin&broadcast=app.lifeup.query.coin](lifeup://api/query?key=coin&broadcast=app.lifeup.query.coin)

2. Adicione um evento no Tasker → «Intent Received» e preencha «app.lifeup.query.coin» na coluna de ação

3. A tarefa no Tasker pode então receber o valor de retorno de `value` na forma da variável `%value`.

4. Em seguida, você pode avaliar a quantidade de moedas no Tasker para obter vários efeitos. (Por exemplo, alterar o papel de parede da área de trabalho conforme a quantidade de moedas?)

![](_media/api/broadcast_01.png ':size=30%')

![](_media/api/broadcast_02.png ':size=30%')

![](_media/api/broadcast_03.png ':size=30%')

![](_media/api/broadcast_04.png ':size=30%')

<br/>

---

## Notificação de eventos de broadcast

!> As funções aqui são usadas com ferramentas de automação/desenvolvimento secundário.

> Na versão 1.90.2, transmitimos vários eventos para o exterior. Você pode usar ferramentas de automação como Tasker para receber esses eventos e acionar ações no Tasker.
>
### Ativar

**Por padrão, os eventos de broadcast estão desativados.**

Você pode ativá-los em `Settings`-`Labs`-`Developer mode`-`Broadcast events`.

### Exemplo: alterar papel de parede com um Item

1. Crie um Item novo chamado «Change Wallpaper».
2. No Tasker, vá em `Configuration file`→`Event`→`System`→`Intent Received`, informe `app.lifeup.item.use` na coluna de operação e retorne.
3. Clique em New Task e informe qualquer nome (por exemplo, change wallpaper).
4. Clique no sinal + no canto inferior direito para adicionar uma tarefa, selecione `Task`→`If`
5. Ajuste a coluna de condição para `%name eq change wallpaper`.
6. Volte; em `Insert Action`, selecione `If`.
7. Clique novamente no sinal + no canto inferior direito para adicionar uma tarefa, selecione `Display` → `Set Wallpaper`
8. (Opcional) Substitua `Type` por `All`
9. Na coluna de imagem, clique no ícone 🔍 e selecione o arquivo de papel de parede desejado
10. Saia e verifique se esta configuração está ativada.
11. Use o Item «Wallpaper Change» no `LifeUp`; o papel de parede deve ser alterado com sucesso

![](_media/api/broadcast_sample_01.png ':size=30%')

![](_media/api/broadcast_sample_02.png ':size=30%')

![](_media/api/broadcast_sample_03.png ':size=30%')

![](_media/api/broadcast_sample_04.png ':size=30%')

Usar `No Action`+`Broadcast return value` pode obter esse efeito de forma mais concisa; explore essa opção.

<br/>

### Tarefa concluída

**Nome:** app.lifeup.task.complete

**Valor de retorno:**

| Parâmetros  | Significado          | Exemplos        |
| ----------- | ---------------- | --------------- |
| task_id     | id da Tarefa          | 1               |
| task_gid    | id do grupo de Tarefas    | 1               |
| name        | nome da Tarefa        | Getting started |
| category_id | id da categoria de Tarefa | 1               |

### Tarefa abandonada

**Nome:** app.lifeup.task.giveup

**Valor de retorno:**

| Parâmetros  | Significado          | Exemplos        |
| ----------- | ---------------- | --------------- |
| task_id     | id da Tarefa          | 1               |
| task_gid    | id do grupo de Tarefas    | 1               |
| name        | nome da Tarefa        | Getting started |
| category_id | id da categoria de Tarefa | 1               |

### Tarefa vencida

**Nome:** app.lifeup.task.overdue

**Valor de retorno:**

| Parâmetros | Significado                 | Exemplos                        |
| ---------- | ----------------------- | ------------------------------- |
| task_ids   | **array** de ids de Tarefa       | [1, 2, 3]                       |
| task_gids  | **array** de ids de grupo de Tarefas | [1, 2, 3]                       |
| names      | **array** de nomes de Tarefa     | [Getting started, Drink Waters] |
| task_ids_json  | **Json array** de ids de Tarefa   | [1, 2, 3]                       |
| task_gids_json | **Json array** de ids de grupo de Tarefas | [1, 2, 3]                       |
| names_json     | **Json array** de nomes de Tarefa | ["Getting started", "Drink Waters"]                      |

### Conquista desbloqueada

**Nome:** app.lifeup.achievement.unlock

**Valor de retorno:**

| Parâmetros     | Significado          | Exemplos                 |
| -------------- | ---------------- | ------------------------ |
| achievement_id | id da Conquista   | 1                        |
| name           | nome da Conquista | Using LifeUp for 30 days |

### Itens comprados

**Nome:** app.lifeup.item.purchase

**Valor de retorno:**

| Parâmetros | Significado           | Exemplos          |
| ---------- | ----------------- | ----------------- |
| item_id    | id do Item           | 1                 |
| name       | nome do Item         | Break 10 branches |
| amount     | quantidade comprada | 1                 |

### Item usado

**Nome:** app.lifeup.item.use

**Descrição:** Enviado quando o uso normal de um Item ou o fluxo de uso de Síntese simples é bem-sucedido.

**Valor de retorno:**

| Parâmetros | Significado      | Exemplos          |
| ---------- | ------------ | ----------------- |
| item_id    | id do Item      | 1                 |
| name       | nome do Item    | Break 10 branches |
| amount     | quantidade de uso | 1                 |

### Síntese concluída

> [!NOTE]
> Este evento de broadcast foi lançado na v1.102.8.

**Nome:** app.lifeup.synthesis.complete

**Descrição:** Enviado quando uma Síntese de receita é concluída com sucesso.

**Valor de retorno:**

| Parâmetros   | Significado                            | Exemplos                                              |
| ------------ | ---------------------------------- | ----------------------------------------------------- |
| formula_id   | id da fórmula                         | 1                                                     |
| formula_name | nome da fórmula                       | Toolbox Recipe                                        |
| times        | vezes de execução                    | 3                                                     |
| input_count  | número de entradas de Itens de entrada       | 2                                                     |
| output_count | número de entradas de Itens de saída      | 1                                                     |
| inputs_json  | JSON array de todas as entradas consumidas  | [{"item_id":7,"name":"Wood","amount":6}]              |
| outputs_json | JSON array de todas as saídas produzidas | [{"item_id":9,"name":"Toolbox","amount":3}]           |

**Notas:**

- Este evento só é enviado após a Síntese ser bem-sucedida.
- Se os materiais forem insuficientes, a fórmula não existir, o salvamento falhar ou `Broadcast events` estiver desativado, este evento não é enviado.
- Uma única chamada de API envia apenas um evento, mesmo que `times > 1`.
- Em `inputs_json` e `outputs_json`, cada item usa a seguinte estrutura:

```json
{
  "item_id": 7,
  "name": "Wood",
  "amount": 6
}
```

- `amount` é o **total consumido / total produzido** nesta execução, não a quantidade por fórmula.

### Reflexões adicionadas / atualizadas

**Nome:** app.lifeup.feelings.add

**Valor de retorno:**

| Parâmetros | Significado | Exemplos |
| --- | --- | --- |
| feelings_id | id da Reflexão | 1 |
| action_type | `add` ou `update` | add |
| content | texto da Reflexão | Feeling good today! |
| create_time | timestamp de criação (ms) | 1642060800000 |
| relate_type | tipo de objeto relacionado | 0 |
| related_id | id do objeto relacionado | 1 |
| attachments_count | contagem de anexos | 2 |
| attachments | array de caminhos de anexos | ["/path/1", "/path/2"] |

### Subida de Nível

**Nome:** app.lifeup.level.up

**Valor de retorno:**

| Parâmetros | Significado       | Exemplos |
| ---------- | ------------- | -------- |
| skill_id   | id da Habilidade       | 1        |
| name       | nome          | strength |
| level      | Nível atual | 2        |

### Descida de Nível

**Nome:** app.lifeup.level.down

**Valor de retorno:**

| Parâmetros | Significado       | Exemplos |
| ---------- | ------------- | -------- |
| skill_id   | id da Habilidade       | 1        |
| name       | nome          | strength |
| level      | Nível atual | 2        |

### Contagem regressiva de Item da Loja

**Nome:**

- Início: app.lifeup.item.countdown.start
- Parada: app.lifeup.item.countdown.stop
- Conclusão: app.lifeup.item.countdown.complete

**Valor de retorno:**

| Parâmetros | Significado                       | Exemplos                  |
| ---------- | ----------------------------- | ------------------------- |
| item_id    | id do Item                       | 1                         |
| name       | nome do Item                     | play games for 30 minutes |
| time_left  | tempo restante (milliseconds) | 30000                     |

### Ciclo de vida do Pomodoro

?> Este evento de broadcast foi lançado na v1.101.0, com dados de evento mais ricos.

**Nome:**

- Início: app.lifeup.pomodoro.start
- Pausa: app.lifeup.pomodoro.pause (novo na v1.101.0)
- Parada: app.lifeup.pomodoro.stop
- Conclusão: app.lifeup.pomodoro.complete

**Descrição:** Quando o temporizador Pomodoro inicia, pausa, para ou conclui, o sistema envia eventos de broadcast correspondentes com informações da Tarefa, status de temporização e outros dados detalhados.

**Valor de retorno:**

| Parâmetro          | Significado                       | Exemplo        | Notas                                                      |
| ------------------ | ----------------------------- | -------------- | ---------------------------------------------------------- |
| task_id            | ID da Tarefa                       | 1              | Opcional; existe apenas quando o Pomodoro está associado a uma Tarefa |
| task_gid           | ID do grupo de Tarefas                 | 1              | Opcional; existe apenas quando o Pomodoro está associado a uma Tarefa |
| name               | Nome da Tarefa                     | Study English  | Nome da Tarefa associada ao Pomodoro ou nome personalizado         |
| service_type       | Tipo de serviço                  | 0              | 0=Foco, 1=pausa curta, 2=pausa longa                      |
| service_type_label | Rótulo do tipo de serviço            | Focus          | Texto localizado do tipo de serviço                                |
| duration           | Duração total (milliseconds) | 1500000        | Duração total de Foco ou pausa                           |
| remaining          | Duração restante (milliseconds) | 900000     | Duração restante atual                                 |
| elapsed            | Duração decorrida (milliseconds) | 600000       | Tempo já decorrido                                           |
| start              | Hora de início                    | 1639123456789  | Unix timestamp (milliseconds)                              |
| event_time         | Hora de acionamento do evento            | 1639123456789  | Unix timestamp (milliseconds)                              |
| reason             | Motivo da parada                   | user           | Apenas para evento de parada; valores possíveis: manual, cancel, complete, auto |

**Descrição do motivo da parada:**

O parâmetro `reason` existe apenas no evento `app.lifeup.pomodoro.stop`, indicando o motivo da parada do Pomodoro:

- `manual`: usuário parou manualmente
- `cancel`: usuário cancelou
- `complete`: concluído normalmente (nota: ao concluir, o evento `app.lifeup.pomodoro.complete` também é acionado)
- `auto`: parada automática (p. ex., Tarefa excluída)

### Positive Timer Lifecycle :id=broadcast_positive_timing

> [!NOTE]
> Estes eventos referem-se ao recurso de temporizador positivo, não aos eventos de contagem regressiva Pomodoro acima. Antes de usá-los, certifique-se de que `Settings` → `Labs` → `Developer mode` → `Broadcast events` está ativado.

**Nome:**

- Início: app.lifeup.timing.start
- Pausa: app.lifeup.timing.pause
- Conclusão: app.lifeup.timing.complete
- Abandono: app.lifeup.timing.abandon

**Descrição:** Quando um temporizador positivo inicia, pausa, conclui ou é abandonado manualmente, o LifeUp envia o broadcast correspondente. `complete` significa que a sessão terminou normalmente e foi registrada. `abandon` significa que a sessão atual foi interrompida ou descartada manualmente.

**Valor de retorno:**

| Parâmetros | Significado                        | Exemplos      | Notas                                            |
| ---------- | ------------------------------ | ------------- | ------------------------------------------------ |
| task_id    | ID da Tarefa                        | 1             | Opcional; presente apenas quando o temporizador está vinculado a uma Tarefa |
| name       | Nome da Tarefa                      | Study English | Nome da Tarefa vinculada ou nome personalizado do temporizador          |
| time       | Duração acumulada (ms)      | 600000        | Duração total decorrida do temporizador positivo atual |
| start      | Hora de início                     | 1639123456789 | Unix timestamp (milliseconds)                    |
| end        | Hora de término                       | 1639127056789 | Presente apenas em eventos `complete` / `abandon`    |

---

## Integração

Recebemos com entusiasmo qualquer forma de integração de outros desenvolvedores.

> Mais detalhes em breve...

### Precisa de mais APIs?

A funcionalidade de API está atualmente em apenas uma iteração de versão.

No futuro, continuaremos adicionando mais APIs para atender a mais cenários de uso.

Se precisar de mais APIs, abra Issues no [Github](https://github.com/Ayagikei/LifeUp/issues/new/choose).

<br/>

### Como chamar

#### Android

##### Usando o SDK

Consulte o módulo `core` em: https://github.com/Ayagikei/LifeUp-SDK.

##### Sem usar o SDK

```kotlin
    /**
    * Define a method to handle the uri
    */
    private fun call(context: Context, uriString: String){
        try {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(uriString)
            }
            context.startActivity(intent)
        }catch (e: Exception) {
            e.printStackTrace()
        }
    }

fun xxx() {
        ...
        // Then call it where appropriate
        call(context, "lifeup://api/toast?text=You+learned+to+call!&type=1&isLong=true")
        ...
    }
````

<br/>

#### Página web

Se a página web for chamada, se ela pode ser acionada depende do navegador. Navegadores comuns como Quark, Chrome e Edge funcionam bem. Porém, alguns navegadores integrados do sistema podem perguntar ao usuário «whether to open Rensheng» sempre que aparecer.

Se você está desenvolvendo seu próprio aplicativo WebView incorporado, certifique-se de que o WebView consiga tratar o esquema lifeup.

Para garantir uma experiência consistente, você pode usar o efeito de link de produto no `LifeUp` e marcar «Use built-in browser» para abrir. Porém, devido às configurações de segurança, essa forma só suporta links HTTPS (não HTTP)

**HTML**

Salto direto para o hiperlink

````htm
<a href="lifeup://api/toast?text=You learned to call!&type=1&isLong=true" target="_blank" rel="noopener">Click here to call</a>
````

**Javascript**

Na prática, também é um hiperlink

````javascript
location.href='lifeup://api/reward?type=coin&content=consolation+prize&number=1'
````

<br/>

### Desenvolvedor de aplicativo/web/automação

Avise-nos se você desenvolveu algo relacionado ao LifeUp!

<br/>

### Qualquer linguagem/plataforma que suporte o protocolo HTTP

Para detalhes, consulte https://github.com/Ayagikei/LifeUp-SDK e [LifeUp Cloud - HTTP APIs - Google Play](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http).
