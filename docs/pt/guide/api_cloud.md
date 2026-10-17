<h1 align="center" padding="100">LifeUp Cloud ☁️</h1>

<p align="center">
 <img src="guide/_media/api/cloud.png" />
</p>

> [!NOTE]
> Estamos liberando **LifeUp v1.106.0** e **LifeUp Cloud v3.0.0** gradualmente. Os prazos de revisão variam conforme a plataforma, então esta documentação pode ser atualizada antes que os apps estejam amplamente disponíveis; a data real de lançamento pode ser posterior à indicada aqui.

O LifeUp Cloud é um dos principais kits de ferramentas de API do LifeUp. Ele transforma seu celular em uma **ponte de API**: controle o LifeUp a partir do **computador ou de outros dispositivos**, crie **integrações personalizadas** (desktop, web, scripts de automação) ou combine com **agentes de IA**.

### Cenários típicos

| Cenário | Para quem | Em uma frase | Saiba mais |
| --- | --- | --- | --- |
| **HTTP + faça você mesmo** | Desenvolvedores, usuários de automação | Chame APIs e consulte dados via Python, apps web ou scripts na LAN — sem experiência com Android | [Referência da API HTTP](/guide/api-reference), [Desktop](guide/api_desktop.md) |
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

## Conectar ao LifeUp Cloud :id=connect

1. Instale versões compatíveis do LifeUp e LifeUp Cloud. Abra o LifeUp Cloud e conceda a permissão de dados/API do LifeUp quando solicitada.
2. Inicie o serviço HTTP. Em um dispositivo que possa alcançar o celular pela rede, use o endereço e a porta exibidos pelo Cloud como URL base.
3. Se configurou um token do Cloud, envie o token bruto no cabeçalho `Authorization`. Consulte `/info` para verificar a conexão e as versões instaladas; verifique o estado HTTP e o `code` do JSON.

## Referência da API HTTP :id=http-api-definition

A [referência completa de interfaces e parâmetros](/guide/api-reference) contém índice de rotas, regras comuns de resposta/paginação, modelos de dados completos, parâmetros de requisição e exemplos JSON. Consulte-a ao criar uma integração. Os [métodos URL Scheme](/guide/api) descrevem ações individuais; [MCP & Skills](/guide/api_mcp) descrevem ferramentas de agentes de IA.

### Datas e horas de tarefas e histórico :id=task-history-timestamps

Veja o [modelo de tempo das tarefas](/guide/api-reference?id=task-times): `startTime` é o início planejado, `deadline` é o prazo e `endTime` do histórico é o horário registrado de conclusão/atraso/desistência, interpretado com `status`.

#### Relatórios diários e integridade do histórico :id=history-daily-reports

Veja [paginação do histórico e relatórios diários](/guide/api-reference?id=daily-report) e [registros de EXP/moedas](/guide/api-reference?id=reward-journals) para alterações reais de recompensas.

## Contribuição

O SDK, o LifeUp Cloud e o LifeUp Desktop são todos projetos de código aberto.

Você pode obter o código-fonte em:

- [Ayagikei/LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop](https://github.com/Ayagikei/LifeUp-Desktop)
