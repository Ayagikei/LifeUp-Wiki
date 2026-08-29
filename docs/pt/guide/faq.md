# Perguntas frequentes

O LifeUp é mantido por dois colegas indie no nosso tempo livre:

- Um desenvolvedor cuida principalmente do App.
- Outro colega foca em serviços de backend e operações.

## Por trás do app indie

Quando lançamos o LifeUp em 2020, apps indie ainda eram relativamente raros. Em 2026, desenvolvedores e apps indie estão por toda parte — e isso é ótimo.

Mas também vimos muitas tendências pouco recomendáveis: lançar um app novo a cada mês ou dois e abandoná-lo após o lançamento; apps construídos inteiramente com código gerado por IA, sem engenharia real por trás, cheios de bugs, com desempenho ruim e impossíveis de manter; preços agressivos impulsionados por hype que saltam de dezenas para centenas de dólares antes mesmo de o app estar pronto, com posts urgentes em fóruns pressionando os usuários a comprar uma assinatura vitalícia «antes que seja tarde»; ou apps que lucram com uma assinatura vitalícia na v1, mal a mantêm e de repente «revivem» com uma v2.0 para vender assinaturas vitalícias de novo — só para o app continuar sem manutenção, quebrar ou ser removido das lojas, tornando essas assinaturas vitalícias praticamente inúteis.

Em contraste, o LifeUp é construído por desenvolvedores que se preocupam com a manutenção a longo prazo: ~6 anos de iteração contínua com mais de 400 versões. Mantivemos o modelo de compra única, e nossos preços ficaram bem abaixo da maioria dos apps comparáveis, mesmo após ajustes modestos ao longo dos anos. O LifeUp também oferece de forma única uma [API](/guide/api.md) e um [cliente desktop de código aberto](/guide/api_desktop.md), para que você possa integrar o LifeUp aos seus próprios fluxos de trabalho com IA e suas habilidades de desenvolvimento — ou até construir em cima dele. O LifeUp também suporta backups com exportação completa de dados, que incluem seus arquivos de mídia originais e um banco de dados SQLite — assim você sempre é dono e controla seus dados. Você pode convertê-los para formatos compatíveis com outros apps, fazer a IA analisá-los para gerar gráficos e muito mais (tudo isso também é possível — e mais direto — via API). Você até pode importar seu backup diretamente no [ulives](https://app.ulives.io/), nosso novo app para iOS.

Alguns recursos e detalhes da interface ainda estão sendo polidos, e vamos melhorando passo a passo.

Se o LifeUp te ajuda, compartilhá-lo com outras pessoas também nos ajuda muito.

Se quiser apoiar o desenvolvimento, você também pode nos pagar um café na página **About** do App.

## ⚙️ Configuração de compatibilidade

Se você encontrar problemas como:

- lembretes que não disparam
- lembretes Pomodoro ou contagens regressivas de Itens que não funcionam em segundo plano
- ações do widget que falham (por exemplo, não conseguir marcar Tarefas de contagem)
- problemas de atualização do widget

leia o guia de compatibilidade:

> [!WARNING]
> [Configuração de compatibilidade](/guide/compatibility.md)

## 🌍 Geral

<details>
<summary>Política de reembolso</summary>

O LifeUp está listado como app pago no Google Play por motivos históricos, o que dificulta migrar para um modelo de pagamento pós-download.

O Google Play pode reembolsar automaticamente seu pedido se você desinstalar logo após a compra.

Se esse reembolso automático não acontecer, entre em contato conosco em até **7 dias** em [lifeup@ulives.io](mailto:lifeup@ulives.io).
Inclua seu número de pedido GPA e envie o e-mail da mesma conta Google usada na compra.

Por motivos antiabuso, podemos oferecer suporte a reembolso manual apenas **uma vez por usuário**.
Não processamos solicitações de reembolso após 7 dias da data de compra.

Observação: avaliações no Google Play não incluem detalhes suficientes do pedido para tratar reembolsos.

</details>

<details>
<summary>Meus dados são privados e seguros?</summary>

Sim. Levamos privacidade a sério.

A maior parte dos dados fica no seu dispositivo e não passa pelos nossos servidores.

A principal exceção é o módulo Mundo, onde os usuários podem compartilhar publicamente designs e modelos.
Todo compartilhamento lá é opt-in: nada é publicado a menos que você escolha compartilhar, e você pode excluir conteúdo compartilhado a qualquer momento.

Leia mais em nossa [Política de Privacidade](https://wiki.lifeupapp.fun/en/#/introduction/privacy-terms).

</details>

<details>
<summary>Como faço backup dos meus dados se os servidores não os armazenam?</summary>

O LifeUp suporta exportação/importação de backups e destinos de backup em estilo nuvem.

Você pode usar:
- Arquivos de backup exportados
- WebDAV
- Google Drive
- Dropbox

</details>

<details>
<summary>Por que não há o idioma XX? Ou por que a tradução está incompleta e aparece em inglês?</summary>

A maioria dos idiomas no *LifeUp* é mantida pela comunidade.

A partir de 2026, usaremos tradução por IA para os principais idiomas, para melhorar a qualidade base e acelerar as atualizações.

Revisões e correções da comunidade ainda são muito bem-vindas.

Você pode contribuir aqui: [Crowdin - LifeUp](https://crowdin.com/project/lifeup).

</details>

<details>
<summary>Posso ocultar o módulo Mundo se não precisar dele?</summary>

Sim.

Você pode personalizar a barra de navegação inferior em:
`barra lateral` → `Configurações` → `Exibição` → `Configuração de Módulo`.

A partir daí, você pode ocultar o módulo Mundo ou substituí-lo por outro módulo.

</details>

<details>
<summary>O pedômetro está impreciso, ou não preciso desse módulo?</summary>

> Toque no pequeno ícone de interrogação ao lado do pedômetro no App para ver como ele funciona.

- Para melhor precisão, abra o App de manhã e à noite e evite reiniciar o dispositivo com frequência.
- Você também pode inserir a contagem de passos manualmente.
- Se não precisar dele, oculte o pedômetro em `Configurações` → `Exibição`.

</details>

## ✅ Tarefas

<details>
<summary>Posso ocultar o diálogo de Recompensa ao concluir uma Tarefa?</summary>

Sim. No fluxo normal de conclusão, o diálogo de Recompensa aparece apenas quando uma Tarefa tem Recompensas configuradas, como Pontos de Experiência (XP) ou Itens. Se você deixar as Recompensas sem configurar, concluir a Tarefa não mostrará esse diálogo.

Também recomendamos escolher um intervalo de conclusão sensato em vez de dividir uma atividade em muitas Tarefas pequenas. Isso reduz tanto o trabalho de configuração quanto o número de ações de conclusão.

Se quiser manter as Recompensas, mas pular os diálogos de conclusão, você pode usar uma destas opções:

- **Quick Complete:** Ative `Conclusão Rápida` no canto superior direito da lista de Tarefas. Depois de ativado, tocar no círculo conclui uma Tarefa diretamente, sem mostrar o diálogo de Recompensa.
- **Deslizar para concluir:** Vá em `barra lateral` → `Configurações` → `Tarefa` → `Swipe` → `Ação ao deslizar a tarefa`. Selecione `Deslize para a esquerda` ou `Deslize para a direita` e defina a ação como `Concluir (sem caixa de diálogo)`.

Ambas as opções sem diálogo ainda concedem as Recompensas configuradas, mas também pulam outros diálogos de conclusão, incluindo a entrada de Reflexões e o uso automático de Itens.

</details>

<details>
<summary>Como desfaço uma Tarefa concluída?</summary>

Você pode desfazer a conclusão em vários lugares:

1. Logo após concluir, toque em **Undo** no aviso inferior.
2. Em `barra lateral` → `HistóricoA`, toque em `Desfazer`.
3. Em `Calendário` → `Encerrado`, toque em `Desfazer`.

Se o prazo da Tarefa já passou, o desfazer direto não está disponível.
Nesse caso, edite o status do registro (por exemplo, defina como vencido ou abandonado).

</details>

<details>
<summary>Como marco uma Tarefa vencida como concluída?</summary>

Quando uma Tarefa vence, aparece um diálogo de vencimento que permite marcá-la como concluída.

Depois de fechar o diálogo, você ainda pode atualizar o status da Tarefa mais tarde em:
- `barra lateral` → `HistóricoA`
- `Calendário` → `Encerrado`

</details>

<details>
<summary>Há penalidade de EXP/moedas por falhar uma Tarefa?</summary>

Sim.

- A penalidade de EXP está ativada por padrão (fator: `0.2x`).
- A penalidade de moedas está desativada por padrão (fator: `0`).

Você pode alterar as configurações globais em:
`barra lateral` → `Configurações` → `Avançado`

Também pode definir penalidades por Tarefa no editor de Tarefas.

</details>

<details>
<summary>Como funciona o mecanismo de repetição?</summary>

Configure apenas a `Data e horário de início`, o `deadline`, a frequência de repetição e o horário de lembrete opcional do **primeiro** ciclo.

O LifeUp calculará os ciclos seguintes automaticamente.

</details>

<details>
<summary>Como configuro uma Tarefa que precisa ser concluída N vezes de forma irregular dentro de um período?</summary>

O LifeUp ainda não tem uma configuração direta para «pelo menos/no máximo N vezes por ciclo». No entanto, você pode alcançar isso de várias formas:

| Método | Configuração | Vantagens | Desvantagens |
| :--- | :--- | :--- | :--- |
| **Counting Task** | Defina a frequência como `Semanal`, ative `Tarefa de Contagem`, configure a contagem (ex.: 3). | Configuração simples; o progresso fica claro (ex.: 1/3). | **As Recompensas só são concedidas após a contagem final.** Sem Recompensa por conclusões individuais. |
| **Infinite Task + Target** | Defina a frequência como `Ilimitada`, a meta de contagem como 3, o prazo para domingo. | **As Recompensas são concedidas a cada conclusão.** | **Precisa ser recriada manualmente toda semana** (pois a Tarefa termina após a conclusão). |
| **Subtasks** | Defina a frequência como `Semanal`, adicione 3 subtarefas dentro. | Permite definir Recompensas e lembretes individuais para cada conclusão. | Exige entrar na página de detalhes para marcar subtarefas; precisa criar manualmente uma a uma (adequado só para contagens pequenas). |
| **Infinite Task (Stats Only)** | Defina a frequência como `Ilimitada`. | Configuração mais fácil; Recompensas e estatísticas a cada conclusão. | **Sem restrição forçada.** Você precisa conferir suas estatísticas manualmente para ver se atingiu a meta semanal. |

> [!NOTE]
> Estamos considerando adicionar um recurso de «Recompensa em tempo real» para **Counting Tasks** (recompensar cada contagem imediatamente), que está em avaliação no momento.

</details>

<details>
<summary>Como oculto Tarefas concluídas ou não iniciadas?</summary>

Isso geralmente acontece em um destes casos:

1. Se uma Tarefa mostra `xx deadline`, essa Tarefa já começou.
   - Edite a Tarefa e ajuste a `Data e horário de início`, se necessário.

2. Se uma Tarefa mostra `xx starts` e a data não é hoje:
   - Verifique se o botão de recolher inferior está recolhido.
   - Abra o menu superior direito (`...`) → `Filtrar`.
   - Confirme que `Mostrar hoje` está ativado.

> Observação:
> - Listas inteligentes (semana/mês) não suportam recolhimento.
> - Para Tarefas repetitivas, um ciclo completo é válido por padrão. Por exemplo, um ciclo de 21 dias pode ser concluído em qualquer um desses 21 dias. Se quiser que fique visível só perto do fim, ajuste a `Data e horário de início` uma vez e deixe o LifeUp calcular os ciclos seguintes automaticamente.

</details>

<details>
<summary>Como evito que Tarefas fiquem vencidas à meia-noite?</summary>

O horário de vencimento é controlado pelo prazo da Tarefa.

Depois de definir a data do prazo, toque no botão `time` e escolha um horário mais tarde.

Por exemplo, se não quiser que um Item expire às `00:00`, defina o horário do prazo para algo como `02:00` (no dia seguinte).

Você também pode alterar os padrões globais em:
`Configurações` → `Item` → `Nova configuração padrão de tarefa`

(Alterar os padrões não afeta Itens existentes.)

</details>

<details>
<summary>Por que o número alvo de vezes começa em 1/N?</summary>

Diferente das Tarefas de contagem, (1/N) **aqui não representa o progresso total.**

Em vez disso, **indica a contagem de repetição atual. Se essa repetição está concluída é mostrado por ⚪ ou ✅.**

<br/>

Por exemplo, ⚪1/10 significa:
Esta Tarefa será repetida 10 vezes no total (um total de 10 cartões será gerado) e está atualmente na 1ª vez, ainda não concluída.

E ✅1/10 significa:
O cartão atual pertence à 1ª vez e está concluído.

Se o progresso total fosse usado, cartões concluídos exibiriam status confusos como (⚪1/10 e ✅1/10 coexistindo). Além disso, cartões poderiam desaparecer ao atingir a meta (ex.: ✅9/10), o que é contra-intuitivo.

</details>

<details>
<summary>Como defino vários lembretes para uma Tarefa?</summary>

Crie subtarefas e atribua descrições/horários de lembrete diferentes a cada uma.

Esta é a forma recomendada de simular vários lembretes para uma Tarefa principal.

</details>

<details>
<summary>As subtarefas podem aparecer diretamente na lista de Tarefas?</summary>

Por enquanto, não. Podemos considerar isso em atualizações futuras.

</details>

## 🎁 Recompensas (Pontos de Experiência, Itens)

<details>
<summary>Posso atribuir valores de EXP diferentes a Atributos distintos para uma Tarefa?</summary>

Não diretamente na versão atual.

Para configuração rápida, uma Tarefa usa atualmente um valor de EXP por Atributo. Se precisar de valores de EXP diferentes por Atributo, use esta alternativa:

1. Crie um Item.
2. Configure efeitos de EXP diferentes para Atributos distintos nesse Item.
3. Defina o Item para uso automático após a conclusão da Tarefa.

Isso combina conclusão da Tarefa + efeito do Item como um fluxo de Recompensa integrado.

Planejamos melhorar o suporte nativo a isso em versões futuras.

</details>

<details>
<summary>Como EXP e moedas são calculados automaticamente?</summary>

EXP depende principalmente de:
- `Dificuldade`
- `Urgência`
- `number of selected attributes`

Moedas dependem principalmente de:
- `Dificuldade`
- `Urgência`

</details>

<details>
<summary>Como o Nível de Vida é calculado?</summary>

A EXP do Nível de Vida está positivamente relacionada à EXP ganha em qualquer Atributo.

Quando penalidades se aplicam, a EXP do Nível de Vida também é reduzida proporcionalmente.

O Nível de Vida foi projetado como um indicador amplo e agregado, então não recomendamos focar demais na fórmula.

O que mais importa é que ele reflita seu progresso geral a longo prazo.

Referência da fórmula: cada ação de ganho/perda de EXP contribui com 1/5 para a EXP do Nível de Vida, independentemente de quantos Atributos são recompensados nessa ação.

</details>

<details>
<summary>Posso definir Recompensas personalizadas de EXP e moedas para Tarefas?</summary>

Sim.

Ao criar uma Tarefa ou Conquista, toque no botão de Recompensa correspondente e configure os valores manualmente.

</details>

<details>
<summary>Por que as imagens dos Itens estão ausentes ou não aparecem?</summary>

O LifeUp é offline-first, então as imagens dos Itens ficam armazenadas localmente no seu dispositivo.

Se as imagens estiverem ausentes, verifique o que aconteceu recentemente:

**Após importar um backup:**
- O backup pode não incluir arquivos de imagem.
- Reimporte um backup completo que inclua imagens.

**Após operações de limpeza/gerenciamento de arquivos:**
- O LifeUp não exclui arquivos de imagem ativamente.
- Ferramentas de limpeza/gerenciamento de arquivos de terceiros com permissões amplas podem excluí-los por engano.
- Use essas ferramentas com cuidado.

**Para Itens importados do Mundo:**
- Pode ser um problema temporário de carregamento por rede.
- Tente novamente mais tarde ou substitua por imagens locais.

Se você ainda tiver um backup antigo com imagens, pode restaurar esse backup primeiro para recuperar a mídia e depois restaurar seu backup de dados mais recente.

</details>

<details>
<summary>Como excluo um Item da Loja?</summary>

Na página `Loja`, pressione e segure o Item e toque no botão `Excluir` no topo.

</details>

<details>
<summary>Como limpo EXP e moedas?</summary>

Vá em:
`barra lateral` → `Configurações` → `Backup / Restaurar / Limpar dados`

Você pode limpar valores de EXP e moedas lá.

Observação: se você usa recursos online, exibições relacionadas no servidor podem levar um curto tempo para atualizar.

</details>

<details>
<summary>Quais são os limites de Nível e gradientes de experiência dos Atributos?</summary>

Pode ser considerado como tendo Níveis ilimitados (atualmente 2000+, difícil de alcançar por meios normais).

A experiência necessária para cada Nível aumenta, embora o gradiente atual seja íngreme. (Portanto, Recompensas não devem ser avaliadas só pelos limites de Nível; o limite de experiência é aproximadamente 2^63).

Na prática, muitos usuários permanecerão no gradiente de 2500 EXP por muito tempo. Podemos otimizar o sistema de Níveis ou permitir personalização no futuro. (O total de Pontos de Experiência não será afetado).

| Nível    | Pontos de Experiência necessários para cada Nível |
| -------- | ----------------------------------------- |
| 1 → 2     | 300                                       |
| 2 → 3     | 700                                       |
| 3 → 4     | 1500                                      |
| 4 → 99    | 2500                                      |
| 99 → 150  | 5000                                      |
| 150 → 200 | 7500                                      |
| 200 → 250 | 15000                                     |
| 250 → 300 | 30000                                     |
| 300 → 325 | 50000                                     |
| 325 → 350 | 100000                                    |
| >350     | 500000                                    |

</details>

<details>
<summary>Como configuro empréstimos, juros de caixa eletrônico e juros de empréstimo?</summary>

Na página `Loja`, abra o menu superior direito (`...`) e selecione `Configurações`.

</details>

<details>
<summary>Como personalizo Atributos ou Habilidades?</summary>

Vá em:
`barra lateral` → `Configurações` → `Avançado` → `Personalizar atributo`

Você pode personalizar Atributos existentes, criar novos Atributos para Habilidades e excluir Atributos conforme necessário.

Se quiser acompanhar Habilidades, crie Atributos com nomes de Habilidades (por exemplo, `Fishing` ou `Programming`).

</details>

<details>
<summary>Posso modificar Atributos usados por Recompensas esportivas ou Recompensas de curtidas do Mundo?</summary>

Não na versão atual.

Esses mapeamentos de Recompensa integrados estão fixos por enquanto.

</details>

<details>
<summary>Como configuro Recompensas de Caixa de saque?</summary>

Ao criar um Item na Loja, adicione um efeito `Caixa de saque` a esse Item.

Depois configure o pool de Recompensas, probabilidade e configurações relacionadas nesse efeito.

</details>

<details>
<summary>Posso definir probabilidade de Caixa de saque menor que 1%?</summary>

Sim.

Depois de configurar o efeito Caixa de saque, toque no botão de ajuda `?` no App para detalhes de probabilidade e orientações de configuração.

</details>

<details>
<summary>Como consigo mais ícones?</summary>

Somos uma equipe indie pequena e, no momento, não conseguimos manter um grande conjunto de ícones integrado.

Você pode obter mais ícones destas formas:

1. Importe Itens de `Mundo` → `Mercado` e reutilize os ícones deles.
2. Use recursos de ícones externos (certifique-se de que os direitos de uso são válidos):
   - [iconfont](https://www.iconfont.cn/)
   - [Flaticon](https://www.flaticon.com/)
3. Se possível, prefira ícones com fundo transparente para melhor exibição no App.

</details>

<details>
<summary>O que fazer se imagens de produtos não aparecem ou estão ausentes?</summary>

O LifeUp é um app offline. As imagens de produtos são salvas no seu dispositivo e armazenadas com segurança no diretório privado do App. Não podemos investigar diretamente alterações de arquivos no seu dispositivo.

Se imagens de produtos foram perdidas ou não aparecem, pense nas operações que você fez recentemente:

**Se imagens estão ausentes após restaurar um backup:**
- Isso geralmente ocorre porque o arquivo de backup não contém arquivos de imagem
- Você precisa reimportar um backup completo que inclua arquivos de imagem

**Se imagens foram excluídas acidentalmente:**
- O LifeUp em si não exclui arquivos de imagem proativamente
- Se você usou recentemente o recurso de gerenciamento de imagens, pode ter excluído imagens por engano e pode tentar restaurá-las de um backup
- Além disso, alguns apps de limpeza do sistema com permissões elevadas também podem excluir arquivos de imagem; use esses apps com cautela
- Se você tiver um backup antigo com imagens, faça backup dos dados atuais primeiro, restaure o backup antigo para recuperar as imagens e depois restaure seus dados atuais

**Se imagens de produtos importadas do módulo Mundo não aparecem:**
- Isso pode ser causado por problemas de rede
- Tente novamente mais tarde ou substitua a imagem do produto por uma imagem local

**Em casos raros, defeitos do sistema podem causar perda de imagens:**
- Até onde sabemos, certas versões personalizadas de sistema de alguns fabricantes tiveram defeitos: quando o App trava repetidamente, pode limpar incorretamente os dados do App, causando perda de dados e arquivos de imagem. Mantenha o sistema atualizado. Além disso, não podemos descartar que ainda existam defeitos de sistema que causem problemas anormais, pois isso está fora do controle do App. Recomendamos fazer backup com frequência
- Em casos extremos, armazenamento instável do dispositivo ou problemas de hardware também podem causar perda de arquivos de imagem. Considere fazer backup na nuvem regularmente ou substituir o dispositivo

</details>

## ⏰ Lembrete / Pomodoro / Contagem regressiva

<details>
<summary>Como uso o efeito de contagem regressiva de Item da Loja?</summary>

Efeitos de contagem regressiva são entregues como notificações do App.

Primeiro, confirme que a permissão de notificação do LifeUp está ativada.

</details>

<details>
<summary>O Pomodoro suporta avanço automático?</summary>

Atualmente, não.

Você pode experimentar o modo de cronômetro progressivo.

No modo Pomodoro, quando uma sessão de trabalho termina, o cronômetro continua contando para cima. Você pode então decidir se adiciona tempo extra aos registros de Foco. O avanço automático entraria em conflito com esse fluxo de trabalho.

</details>

<details>
<summary>Como inicio o Pomodoro rapidamente a partir da lista de Tarefas?</summary>

Você pode:
1. Pressionar e segurar uma Tarefa e tocar em `Cronômetro` no menu de ações.
2. Ou configurar uma ação de deslizar para `Cronômetro` nas configurações de `Tarefas`.

</details>

<details>
<summary>O Pomodoro oferece estatísticas resumidas como apps Pomodoro dedicados?</summary>

Ainda não.

O Pomodoro do LifeUp ainda é um módulo leve em desenvolvimento inicial.

Atualmente disponível:
- Registros detalhados por sessão
- Estatísticas resumidas básicas diárias na página `Status`

</details>

## 💾 Backup e restauração

<details>
<summary>Como faço backup dos dados?</summary>

Leia primeiro o [Guia de backup e restauração](/guide/backup.md).

Em resumo, os métodos de backup suportados incluem:
- Google Drive (recomendado)
- Dropbox
- Exportar arquivos de backup
- Servidores WebDAV

</details>

<details>
<summary>Por que o LifeUp foi projetado como app offline-first?</summary>

O LifeUp segue uma arquitetura offline-first por design.

Isso significa:
- Seus dados são de sua propriedade e controlados por você.
- Os dados ficam locais, a menos que você escolha explicitamente opções de backup/sincronização.
- A maioria dos recursos principais ainda funciona sem acesso à rede.

Como o cliente trata a lógica principal localmente, você pode continuar usando o LifeUp mesmo quando a rede ou a disponibilidade do servidor estiver limitada (exceto recursos online como o módulo Mundo).

</details>

## 🧭 Planejamento

<details>
<summary>Vocês vão adicionar recursos de IA?</summary>

O LifeUp é um app de baixo custo, compra única, mantido por uma equipe pequena. Incorporar recursos de IA prontos para uso diretamente (onde nós arcamos com os custos de API) não é realista dado nosso modelo de preços — a menos que mudássemos para assinatura ou multiplicássemos o preço único várias vezes para corresponder aos custos operacionais de apps modernos de IA. Não vamos fazer isso.

Dito isso, o LifeUp é inerentemente compatível com IA:

1. Exponemos a maior parte da [API](/guide/api.md) e da funcionalidade principal cedo, tornando-o naturalmente compatível com agentes de IA e ferramentas de terceiros. Ferramentas de IA com capacidades de agente já podem invocar recursos do LifeUp diretamente — criando Tarefas, Itens e muito mais. Na verdade, vimos muitos usuários compartilhar fluxos de trabalho combinando IA com nossa API, incluindo servidores MCP personalizados da API do LifeUp, ferramentas de automação para diários diários gerados por IA e muito mais.

2. Planejamos introduzir recursos de IA BYOK (Bring Your Own API Key) no futuro. Assim você pode usar sua própria chave para alimentar recursos de IA sem que nós arquemos com os custos contínuos de API.

3. No fim das contas, IA não é mágica — caso contrário, você poderia facilmente combinar IA com nossa API para alcançar integração completa por conta própria.

</details>

<details>
<summary>Haverá uma versão iOS do LifeUp?</summary>

Em **2025**, lançamos o [ulives](https://app.ulives.io/), um novo app de produtividade multiplataforma para usuários de iOS (também em iPadOS e Mac com Apple Silicon).

Uma portagem direta do LifeUp para iOS não é realista:

- O LifeUp é construído com tecnologia Android nativa.
- Sua arquitetura offline-first une interface, modelo de dados local e lógica de negócios de perto à implementação Android.
- Uma portagem direta ainda exigiria reescritas significativas para manter dados e lógica consistentes.

Por isso, reorganizamos e reconstruímos com direção multiplataforma por meio do ulives.

O ulives mantém o espírito central do LifeUp e também aborda vários problemas de design e produto de longa data das gerações anteriores. Você pode pensar nele como uma evolução nova, não apenas um clone um a um.

**A assinatura do LifeUp não desbloqueia o ulives**, mas você pode importar um backup do LifeUp (unidirecional, potencialmente com perdas). Veja [O que é o ulives?](/guide/faq?id=ulives_overview). Para motivos mais detalhados, veja o documento de comparação: [ulives vs LifeUp — Comparação](https://app.ulives.io/docs/comparison-with-lifeup).

</details>

<details id="ulives_overview">
<summary>O que é o ulives? Ele compartilha assinatura ou dados com o LifeUp?</summary>


O [ulives](https://app.ulives.io/) é uma **reescrita do zero** em tecnologia multiplataforma (KMP). Herda a filosofia de gamificação do LifeUp, mas o código, a equipe, os preços e os planos de longo prazo são separados — um sucessor espiritual, **não** uma portagem iOS do LifeUp.

**Por que as assinaturas são separadas?**

- **O preço do LifeUp reflete o escopo só Android:** O LifeUp sempre foi construído com tecnologia Android nativa pura. Seu preço de assinatura vitalícia muito baixo foi definido em torno de **ter apenas um cliente Android** — nunca foi pensado para comprar a manutenção de todo app futuro que pudéssemos construir.
- **O preço do ulives reflete o custo multiplataforma e a manutenibilidade a longo prazo:** O ulives é uma reescrita completa com código multiplataforma, equipe ainda não totalmente unificada e trabalho contínuo para iOS e futuros alvos Android e HarmonyOS. O Premium é definido por **desenvolvimento sustentável e manutenibilidade a longo prazo**, não por copiar a divisão histórica gratuito/pago do LifeUp.
- **Equipes de desenvolvimento diferentes:** Uma portagem iOS do LifeUp avançou lentamente por vários motivos. Reorganizamos uma equipe dedicada para o ulives (ainda pequena hoje) para entregar um produto multiplataforma mais rápido e com mais flexibilidade.
- **Ecossistemas de loja separados:** A App Store e o Google Play são sistemas independentes de pagamento e direitos. Licenças não podem ser transferidas diretamente entre os dois apps.

**Em resumo:**

- **Assinatura do LifeUp ↔ assinatura do ulives não se transferem:** Uma compra do LifeUp no Google Play **não** desbloqueia o ulives na App Store, e vice-versa. Cada app exige sua própria compra.
- **Importação de dados unidirecional:** Desde o ulives 1.7.22, você pode importar um backup do LifeUp (`.lfbak`) para o ulives. A conversão pode ter perdas, e a importação **não** transfere de volta para o LifeUp.
- **A importação não transfere sua licença:** Backups movem dados de uso (Tarefas, Itens etc.), não direitos de assinatura do LifeUp.

**ulives Premium entre plataformas ulives:**

O ulives também terá seu próprio cliente **Android** (e suporte nativo HarmonyOS etc.). **O Premium comprado para o ulives deve funcionar em todas as plataformas ulives** — iOS, Android, HarmonyOS — quando o gerenciamento de conta no servidor estiver pronto. Casos iniciais multiplataforma podem exigir contato conosco.

**Ambos os apps oferecem assinatura vitalícia bem abaixo da maioria dos produtos comparáveis** — mas preços de destaque devem ser lidos no contexto: escopo de plataforma única vs multiplataforma, custo de desenvolvimento e manutenção a longo prazo diferem.

Para motivos mais detalhados (modelo de preços, sustentabilidade, investimento em desenvolvimento e planos futuros para ambos os apps), veja o documento de comparação: [ulives vs LifeUp — Comparação](https://app.ulives.io/docs/comparison-with-lifeup). FAQ do ulives: [https://app.ulives.io/docs/faq](https://app.ulives.io/docs/faq)

</details>

## 🆘 Ainda precisa de ajuda?

<details>
<summary>Entre em contato</summary>

Você pode nos contatar em [lifeup@ulives.io](mailto:lifeup@ulives.io).

Também pode abrir um issue no GitHub:
[https://github.com/Ayagikei/LifeUp/issues](https://github.com/Ayagikei/LifeUp/issues)

</details>

<details>
<summary>Gostaria de nos apoiar?</summary>

Obrigado por apoiar o LifeUp.

Se o LifeUp foi útil para você, pode nos apoiar de duas formas simples:

1. Pague-nos um café na página **About** na **versão Google Play** do App.
2. Ajude mais pessoas a descobrirem o LifeUp compartilhando sua experiência:
   - Recomende o LifeUp a amigos
   - Publique suas histórias de uso e fluxos de trabalho
   - Compartilhe dicas, guias ou tutoriais

</details>
