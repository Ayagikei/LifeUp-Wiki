<h1 align="center" padding="100">Bem-vindo ao mundo do LifeUp!</h1>

<p align="center">
 <img src="guide/_media/hello_world/banner.png" />
</p>

[中文](https://wiki.lifeupapp.fun/zh-cn/#/guide/hello_lifeup)

## Introdução

> [!TIP]
> **Obrigado por comprar e baixar o *LifeUp*!**



**O LifeUp é um aplicativo Android único de tarefas e formação de hábitos gamificado.**

Ele é diferente de alguns apps de gamificação que incorporam um jogo integrado.

O foco está em usar elementos de jogo para motivar você a agir na vida real.

Você pode personalizar seus Atributos, Recompensas, Conquistas, Síntese e até baús do tesouro no LifeUp.

No entanto, isso também significa que a configuração inicial e a curva de aprendizado podem levar algum tempo.

Uma coisa a observar: o LifeUp é posicionado como app de lista de tarefas e formação de hábitos, não como app de calendário.


### Perguntas frequentes antes de usar

Antes de começar, você pode querer saber o seguinte:

- **Baixei pelo Google Play. Se não gostar, como posso obter reembolso?**

  Nós e o Google Play entendemos que um app pode não agradar a todo mundo.

  Antes de comprar o LifeUp, você pode acessar uma versão de teste de 7 dias disponível no nosso [GitHub](https://github.com/Ayagikei/LifeUp/releases).

  Se você não ficar satisfeito com o App e desinstalá-lo nas primeiras horas após a compra, o Google Play normalmente processa um reembolso automático em até 24 horas.

  Se ultrapassar esse período de reembolso automático (24 horas), mas estiver dentro de 7 dias da compra, ainda pode entrar em contato conosco em lifeup@ulives.io e informar seu número de pedido GPA. Ajudaremos com uma solicitação de reembolso manual. Certifique-se de usar o endereço Gmail associado à compra.

  Solicitações de reembolso não serão processadas após 7 dias da data de compra.

  Observe que deixar uma avaliação no Google Play não ajuda no processo de reembolso. Sem as informações essenciais, não podemos ajudar com reembolsos por meio de avaliações do App no Google Play.

  

- **Meus dados são privados e seguros?**

  Com certeza. Valorizamos sua privacidade!

  Você pode consultar [nossos documentos de política de privacidade](https://wiki.lifeupapp.fun/en/#/introduction/privacy-terms)
  para obter mais informações.
  
  Resumindo: exceto o módulo Mundo (similar à função de compartilhar designs), os demais dados
  não passam pelo nosso servidor; ficam armazenados apenas no seu dispositivo. O mesmo vale para as
  imagens e outras informações que você escolher. **Você também pode escolher o modo offline.**
  
- **Como o servidor não armazena dados, como faço backup?**

  O LifeUp suporta funções de exportar e importar dados.

  Você também pode configurar um servidor WebDAV, Google Drive ou Dropbox para backup automático.

- **Preciso fazer login? Ou por que recebo erro de rede ao entrar?**

  Não! O LifeUp é um App *offline-first*.

  O login serve apenas para acessar o módulo «Mundo», que permite ver equipes, Itens e Tarefas
  aleatórias criadas por outras pessoas.

  Se não conseguir entrar, pode ser um problema na sua rede local ou uma anormalidade
  no nosso servidor.

  Tente primeiro trocar de rede e DNS.

  Se achar que há um problema no nosso servidor, envie um e-mail para confirmarmos.

  Você também pode usar diretamente o modo offline, que dá acesso à maioria dos
  recursos do LifeUp!

- **Como configurar notificações de Tarefas e execução em segundo plano?**

  O LifeUp suporta lembretes por notificação e por eventos de calendário.

  Devido às limitações de bateria do Android, **e a medidas adicionais agressivas de otimização de bateria de alguns fabricantes de celulares**, o lembrete por notificação padrão exige configuração adicional do usuário para funcionar.

  Você também pode tentar mudar para lembretes por eventos de calendário, que só exigem conceder permissões de calendário.

  > *Mas outros recursos (como Pomodoro) também podem precisar ser configurados para rodar em segundo plano.

  Para mais informações, consulte este documento: https://wiki.lifeupapp.fun/en/index.html#/guide/background_running

- **Como posso ver mais perguntas frequentes sobre o uso do App?**

  Você sempre encontra o link para **a página de perguntas frequentes** no App em `barra lateral` → `Perguntas e Respostas`.

  Ou basta lembrar do nosso site:

  https://wiki.lifeupapp.fun/en/#/guide/faq

  > Se usar um computador, a leitura fica melhor.

---

## Sistema de incentivos

![](_media/hello_lifeup/incentive_system.png)

## Recursos

> 🚧 Esta seção ainda está sendo aprimorada. Você pode notar problemas gramaticais ou capturas em outros idiomas. Correções são bem-vindas.

Já existem muitos exemplos e guias dentro do App.

Como o *LifeUp* suporta personalização profunda, há uma pequena curva de aprendizado no início.

A boa notícia é que a maioria das opções avançadas é opcional.

**Você pode começar com uma configuração mínima** e adicionar mais opções passo a passo.

Pense como um jogo: você vai evoluindo seu fluxo de trabalho com o tempo.



<h3 align="center" padding="100" id="task">I. Tarefas</h3>

<p align="center">As Tarefas são a base de tudo. Defina Tarefas, configure Recompensas e tente se desafiar!</p>

<p align="center">
 <img src="guide/_media/hello_world/tasks.png" style="height:600px" />
</p>

No LifeUp, uma Tarefa é algo que você consegue concluir de forma realista.

O módulo de Tarefas é principalmente uma ferramenta de `registro`. Ele ajuda a acompanhar a conclusão real e conectá-la a Recompensas ou penalidades.

Não foi projetado para automatizar tudo. Você pode usar o módulo de `Conquistas` para acompanhar o progresso ao longo do tempo.

#### # Início rápido
1. **Pendentes**
    Uma Tarefa não repetitiva, similar a um item comum da lista de tarefas.
    Normalmente, basta inserir o conteúdo do `pendente`.

2. **Hábitos**

  Tarefas repetitivas são normalmente usadas para hábitos, como `acordar cedo` ou `ler todo dia`.

  Na maioria dos casos, você só precisa definir o `pendente` e a `Frequência de repetição`.


<br/>

#### # Uso avançado
##### 0. Conceitos de repetição
**Horário limite**

O `Horário limite` é quando **o ciclo atual** é considerado falho e penalidades são aplicadas. Também é quando o ciclo reinicia, não quando toda a Tarefa repetitiva termina.

> No *LifeUp*, você precisa `excluir` manualmente para encerrar a Tarefa; se quiser que ela termine após 30 repetições, marque a opção `número alvo (de repetições)`.

Para Tarefas diárias, o padrão ``23:59:59`` costuma ser suficiente.

Você pode ajustar se normalmente conclui Tarefas depois da meia-noite (por exemplo, até `2:00 AM`).

<br/>

> [!WARNING]
> **«Sem prazo»** significa que a Tarefa não expirará nem se repetirá automaticamente. Na maioria dos cenários, basta manter o prazo padrão e não é necessário definir como «Sem prazo».

<br/>

**Horário de início**

Use para controlar quando uma Tarefa aparece.

Para **Tarefas repetitivas**, também pode limitar a janela válida de conclusão (por exemplo, uma Tarefa de acordar antes das 6:00 AM).

Para uso comum, o valor padrão costuma ser adequado.

<br/>

**Repetição**

As Tarefas executam a lógica de *repetição* após conclusão, abandono ou vencimento.

O LifeUp **calculará automaticamente** o `horário de início`, o `horário limite` e o `horário de lembrete` do próximo ciclo com base na frequência de repetição configurada.


<br/>

**Vezes alvo**

Indica quantos ciclos de repetição a Tarefa deve executar.

Para Tarefas diárias, isso é essencialmente `quantos` dias você quer completá-la.

<br/>

**Tarefas de contagem**

Tarefas de contagem ajudam a acompanhar ações repetidas dentro de um ciclo.

Por exemplo, o 7 em `beber 7 copos de água` é um valor de contagem.

<br/>

##### 1. Modelos de Tarefas
Você pode criar seus próprios modelos de Tarefas usando as funções `Congelar` + `Copiar`.

Por exemplo, crie uma Tarefa relacionada a exercícios e `congele`-a.

Quando precisar criar Tarefas similares, basta `copiar` esse modelo e editá-lo para usar.

<br/>

##### 2. Arquivar Tarefas

Você pode usar as funções `Congelar` + `Listar arquivo` para obter funcionalidade similar ao arquivamento de Tarefas.

<br/>

#### # Detalhes

> WIP...

<br/>

#### # Vinculação

As Tarefas podem ser vinculadas a quase qualquer outra função.
- **Atributos:**
   Você ganha Pontos de Experiência ao concluir Tarefas, mas recebe penalidade se falhar.
- **Loja:**
   Ganhe moedas ou Itens da Loja ao concluir.
- **Conquistas:**
  Defina a condição de desbloqueio de Conquistas personalizadas para concluir a Tarefa um certo número de vezes.
- **Pomodoro:**
   Associe uma Tarefa a um Pomodoro e registre o tempo de Foco na Tarefa e o número de Pomodoros obtidos.
- **Reflexões:**
   Conclua Tarefas para registrar Reflexões: com Tarefas diárias para um diário simples, com Tarefas ilimitadas para anotar a qualquer momento.

---

<h3 align="center" padding="100" id="skills">II. Atributos</h3>

<p align="center">Quantifique suas capacidades e seu crescimento de forma abstrata</p>

<p align="center">
 <img src="guide/_media/hello_world/tasks.png" style="height:600px" />
</p>


#### # Início rápido

Os Atributos são um sistema abstrato de incentivo autodirigido.

O objetivo dos Atributos é quantificar o crescimento, permitindo visualizar seu desenvolvimento com uma perspectiva única enquanto conclui suas Tarefas e, assim, motivá-lo a se esforçar mais.

Em outro sentido, os Atributos dividem várias dimensões. Ver a diferença no crescimento dos Atributos também pode fazer você refletir se vale a pena explorar mais áreas.

O conceito é similar à versão gamificada da `regra das 10 mil horas`, contabilizada por valor de experiência.

Você pode criar os Atributos e Habilidades em que quer trabalhar, acompanhar e comemorar seu crescimento e implementar Recompensas pessoais únicas com o recurso de `Conquistas`.

1. **Atributos integrados:**

  O *LifeUp* tem seis Atributos principais integrados.

  Você pode usá-los e tentar subir de Nível!

  Consulte também a diferença de Nível entre Atributos e melhore seus pontos fracos.



2. **Atributos ou Habilidades personalizados**.

  No *LifeUp*, você pode personalizar totalmente seus próprios Atributos ou Habilidades!

  Por exemplo: `Pesca`, `Programação`, `Leitura`.

<br/>

#### # Detalhes

- WIP

<br/>

#### # Vinculação
> A vinculação já descrita em outros módulos não se repete aqui
- **Conquistas:**
   Um Atributo atinge certo Nível para desbloquear a Conquista.
- **Pomodoro:**
   Coma tomates para ganhar Pontos de Experiência.
- **Loja**.
   Crie Itens que afetem a quantidade de Pontos de Experiência.

---

<h3 align="center" padding="100" id="shop">III. Loja</h3>

<p align="center">Sistemas de Recompensas e penalidades pessoais altamente personalizáveis.</p>

<p align="center">
 <img src="guide/_media/hello_world/shop.png" style="height:600px" />
</p>

Defina um preço para suas missões e Recompensas.

Conclua suas Tarefas, ganhe moedas e compre Recompensas para se manter motivado.

#### # Início rápido
##### Tipo de Item
De forma geral, podem ser divididos em duas categorias de produtos.

**1. Recompensas realistas.**

O App pode ajudar com registros, compras e limites. Porém, a implementação exata das Recompensas exige ações na vida real.

De forma geral, podem ser divididas em:

- Recompensas em espécie (como um computador, um mouse)
- Tempo de descanso e lazer / bônus de tempo
- ...

Por exemplo: «fazer uma pausa de cinco minutos», «assistir a um filme», «comprar uma garrafa de refrigerante».

**2. Recompensas dentro do App.**

Você pode obter Recompensas de dados dentro do App combinando-as com «Efeitos de uso».

Como recompensar uma certa quantidade de moedas, valor de experiência, abrir Caixas de saque para obter Recompensas aleatórias, etc.

Essas Recompensas também podem ser combinadas com Recompensas realistas para vários efeitos.

> [!TIP]
> Usar aleatoriedade para aumentar a incerteza da Recompensa pode aumentar significativamente o efeito motivador.

<br/>

##### Não sabe quais Itens criar?

Vá ao módulo `Mundo`-`Mercado` para consultar e importar Itens criados por outras pessoas.

Se vir um ícone que goste, clique no botão `Menu (três pontos)`-`Ícones` para adicioná-lo à sua área local.

<br/>

##### Inventário

O Inventário pode ser usado como área temporária para Recompensas ainda não utilizadas.

Por exemplo, suponha que você compre a Recompensa «assistir a um filme».

Se ainda não quiser usar essa Recompensa, deixe desmarcada a opção `Usar` no momento da compra; o Item será armazenado automaticamente no Inventário.

Além disso,

- As Recompensas de Itens de Tarefas e Conquistas também serão colocadas aqui automaticamente.
- Itens com operações especiais (como Síntese e abertura de caixas) também serão forçados primeiro ao Inventário.

<br/>

#### # Uso avançado

##### 0. Configurar Caixas de saque.

<p align="center">
 <img src="guide/_media/hello_world/loot_box.png" style="height:600px" />
</p>


A aleatoriedade é uma ótima forma de motivação!

No *LifeUp*, você pode criar sua própria Caixa de saque.

> As Caixas de saque no *LifeUp* usam cálculo de probabilidade real; não há efeito de pseudoaleatoriedade flutuante como em jogos. **Recomenda-se definir probabilidades mais altas que em jogos reais.**

<br/>

##### 1. Síntese (elaboração).

Clique no ícone do `frasco` na página da Loja para entrar no sistema de Síntese.

O sistema de Síntese pode implementar trocas arbitrárias de Itens.

Por exemplo, pode ser usado para Recompensas de `multi-moeda`, `multi-Item`, ou com `Caixas de saque` para coleções complexas de `pesca`, `upgrade de cartas`.

Por exemplo:
- `linha` + `isca` + `local de pesca` → `🐟 caixa surpresa`
- `Caixa trancada` (obtenha fazendo check-in diário) + `Chave` (probabilidade de obter ao concluir a Tarefa) → `Caixas de saque`
- ...

A utilidade do sistema de Síntese depende da sua imaginação (você encontra mais usos em `3. Crie sua própria moeda` e `4. Colete cinco bênçãos (Menino Cabeça de Abóbora salva o avô)` abaixo).

<br/>

##### 2. Recompensas de múltiplos Itens.

**Após atualizar para a versão 1.94.0, você poderá definir Recompensas de múltiplos Itens para Tarefas ou Conquistas. A seguir, algumas alternativas de versões anteriores que ainda se aplicam.**

Por padrão, só é possível definir um tipo de Recompensa de Item para uma Tarefa.

Mas você pode empacotar vários Itens em um baú do tesouro.

Isso também facilita compartilhar Recompensas de Itens entre várias Tarefas.

Por exemplo:
- Usar o mecanismo de Recompensa fixa ao abrir caixa: a Tarefa recompensa um `baú do tesouro`; ao abrir o `baú do tesouro`, Recompensas fixas `Item A`, `Item B`.
- Usar o sistema de Síntese: a Tarefa recompensa um `Baú do tesouro`; depois use o `Baú do tesouro` no sistema de Síntese para obter `Item A`, `Item B`.

<br/>

##### 3. Moeda personalizada.

As moedas padrão podem não atender a todo tipo de necessidade.

Você pode usar o sistema de `Síntese` para construir sua moeda e Loja.

<br/>

Implementação:
- Missão esportiva → Recompensa `Moedas esportivas` → Use `Moedas esportivas` para sintetizar Recompensas `esportivas`
- `Tomates` → `Moedas de tomate` → Síntese de Itens exclusivos

<br/>

##### 4. Coleções de cartas

Coletar um conjunto de cartas para trocar por Recompensas muito raras?

<br/>

Em resumo:
`Conclua a missão para obter uma caixa surpresa de fragmentos` → `Obtenha um tipo de fragmento aleatório`

<br/>

#### # Detalhes

- WIP

<br/>

#### # Vinculação
A vinculação já foi descrita em outros módulos e não se repete aqui
- **Conquistas:**
   Comprar e usar um Item certo número de vezes para desbloquear Conquistas.
   Sintetizar Itens únicos para obter Conquistas.
   Recompensar certos Itens não compráveis por meio de Conquistas.
- **Pomodoro:**
   Resgatar um Item específico com tomates.
- **Mundo:**
   Você pode compartilhar os Itens que cria ou importar diretamente Itens criados por outras pessoas.

---

<h3 align="center" padding="100" id="achievements">IV. Conquistas</h3>

<p align="center">Metas médias e grandes, marcos, acompanhamento automatizado de progresso</p>


<p align="center">
 <img src="guide/_media/hello_world/achievements.png" style="height:600px" />
</p>


#### # Início rápido
**1. Conquistas normais**.

Conquistas normais são aquelas que **não definem condições de desbloqueio**; exigem toque manual para concluir, de forma similar às Tarefas.

Conquistas normais podem definir ícones. E, após desbloquear, a exibição também é mantida.

Por isso são recomendadas para cenários como `Marcos`, `Metas de longo prazo`, `Metas de vida`, etc.

Por exemplo:
- Experimentar uma vez 🎣
- Chegar a XX lugares em uma viagem
- 20 anos!
- 🎓 Formado
- Primeira publicação de artigo
- ...

**2. Conquistas condicionais**.

Para criar esse tipo de Conquista, basta definir suas condições de desbloqueio.

O *LifeUp* acompanhará e calculará automaticamente o progresso das condições. A Conquista será desbloqueada quando você concluir todas as condições.

<br/>

**Atualmente o App suporta dezenas de condições de desbloqueio de Conquistas em vários aspectos, como:**
- Número total de Tarefas concluídas
- Número de Tarefas concluídas consecutivamente
- Número de vezes de uso do produto
- Número de Itens sintetizados
- Foco em uma Tarefa específica por certo tempo
- E mais...



<br/>

#### # Detalhes
- WIP

<br/>

#### # Vinculação
> A vinculação já descrita em outros módulos não se repete aqui
- Acompanhamento de progresso compatível com quase todos os módulos (Tarefas, Loja, Pomodoro)
- Você pode escrever uma Reflexão ao concluir a Conquista.

---

<h3 align="center" padding="100" id="pomodoro">V. Pomodoro</h3>

<p align="center">Pomodoros gamificados como você nunca viu, com a possibilidade de comer e vender suas Recompensas de tomate e um sistema de temporização bem estruturado</p>

<p align="center">
 <img src="guide/_media/hello_world/pomodoro.png" style="height:600px" />
</p>

#### # Início rápido
O Pomodoro é baseado no método do temporizador de tomate, que em resumo alterna trabalho e descanso (25 minutos de trabalho e 5 de descanso).

O Pomodoro do *LifeUp* é um módulo secundário, com funções simples e outros módulos como foco principal. Ainda há margem de melhoria, e continuaremos aprimorando estatísticas e outros recursos.

<br/>

##### Contagem regressiva Pomodoro
> Para usar a contagem regressiva corretamente, configure conforme a `configuração de compatibilidade`.

Por padrão, o `LifeUp` está no estado de temporizador Pomodoro.
Antes de usar, vá às configurações para ajustar `tempo de trabalho`, `tempo de descanso`, `intervalo`, etc.

Você ganha um tomate a cada bloco de trabalho concluído.

Cada temporização precisa ser iniciada manualmente para fins de lembrete.

<br/>

##### Temporizador progressivo
Clique no ícone do `Relógio` no canto superior direito da página de tomate para alternar para o modo de temporização progressiva.

> Clique novamente para voltar ao modo de contagem regressiva.

**Função dos botões do temporizador progressivo, da esquerda para a direita:**
- Desistir
- Pausar
- Resumir a Recompensa

<br />

##### Tarefas associadas

Ao cronometrar tomates, você pode associar a temporização a uma Tarefa.

Os registros de temporização gerados pela associação também ficam vinculados à Tarefa.

Depois, consulte a página de detalhes da Tarefa para ver `Duração de Foco` e `Número de tomates obtidos`.

Se for uma Tarefa repetitiva, é possível ver separadamente o registro de Foco atual e o acumulado.

Com esse recurso, você pode obter **estatísticas simples de 10 mil horas** ou outras coisas.

<br/>

##### Adicionar temporização manualmente

Você pode adicionar qualquer período ao registro do temporizador de tomate.

E pode definir as Tarefas associadas ao temporizador.

<br/>

##### Usos do tomate
<p align="center">
 <img src="guide/_media/hello_world/tomato.png" style="height:600px" />
</p>

- Comer: ganhar valor de experiência (resistência padrão)
- Vender: obter moedas
- Trocar: obter Itens específicos

#### # Detalhes

##### > Ainda não disponível

<br/>

#### # Vinculação
A vinculação já foi descrita em outros módulos e não se repete aqui

- **Tarefas:**
   Ao iniciar o temporizador, você pode especificar a Tarefa em que está com Foco e contabilizar o tempo de Foco para ela.
   
- **Loja:**
   Coma ou troque tomates para obter moedas e Recompensas de Itens da Loja
   
- **Conquistas:**
  Conquistas suportam acompanhamento de informações como horas de Foco em um tipo específico de Tarefa, número acumulado de tomates obtidos, etc.
  
- **API:**
  Use ferramentas de automação + API para interceptar notificações de outro software de temporização e adicionar registros de temporização

---

<h3 align="center" padding="100" id="feelings">VI. Reflexões</h3>

<p align="center">Registros simples de texto e imagem. Reflita sobre o passado e olhe para o futuro.</p>

<p align="center">
 <img src="guide/_media/hello_world/feelings.png" style="height:600px" />
</p>

#### # Início rápido

O recurso Reflexões é um submódulo do *LifeUp* que oferece apenas registro breve de texto e imagem.

> [!WARNING]
> Cada Reflexão está limitada atualmente a 750 caracteres e 9 imagens.

Estas são formas de criar Reflexões.

- Quando você ativa o interruptor de Reflexões para a Tarefa, a caixa de entrada de Reflexões aparece automaticamente ao concluir a Tarefa
- Quando você ativa o interruptor de Reflexões para a Conquista, a caixa de entrada aparece automaticamente ao receber a Recompensa da Conquista
- Ao concluir **Tarefas de equipe**, uma caixa de entrada de Reflexões aparece por padrão, e a Reflexão das Tarefas de equipe é publicada automaticamente no módulo Mundo
- Você pode adicionar proativamente notas de Reflexões a qualquer registro de Tarefa a qualquer momento nas páginas `Histórico`, `Calendário-Concluídas` (Tarefas vencidas e abandonadas também são suportadas)
- Você pode adicionar Reflexões a qualquer momento na página de Conquistas; basta **pressionar e segurar** qualquer Conquista

<br/>

##### Diário simples

Você pode criar uma Tarefa diária e ativar Reflexões nela, como gatilho de um diário simples.

<br/>

##### Acompanhe suas Reflexões

Você pode criar uma Tarefa ilimitada e ativar Reflexões nela para registrar seus sentimentos a qualquer momento.

Como Reflexões suporta filtrar por Tarefas repetitivas, você também pode criar várias Tarefas ilimitadas de tipos diferentes para registrar categorias distintas de Reflexões.

<br />

#### # Detalhes

-

#### # Vinculação
- Registrar Reflexões sobre Tarefas
- Registrar Reflexões sobre Conquistas



<br/>

<h3 align="center" padding="100" id="world">VII. Mundo</h3>

<p align="center">Já existem apps sociais suficientes no mundo. Aqui não há elemento de comunicação. Apenas seu pequeno mundo para compartilhar momentos e designs.</p>

<p align="center">
 <img src="guide/_media/hello_world/world.png" style="height:600px" />
</p>

#### # Início rápido

##### Equipe

Trabalhe com membros da equipe para concluir certos hábitos.

Por exemplo, o Desafio «dormir cedo e acordar cedo».

Aqui não há elemento social, então não precisa se preocupar com interrupções.

<br/>

##### Momentos

Aqui você pode ver outros usuários **que concluíram Tarefas de equipe** e publicaram suas Reflexões ao concluir.

Você também pode seguir usuários positivos, observar o progresso deles e usar isso para se motivar passivamente.

<br/>

##### Mercado

Não sabe quais Recompensas de Itens criar? Precisa aprender a criar Recompensas avançadas com recursos de API? Ou quer encontrar ícones legais?

Você sempre pode importar Itens criados por outros usuários no Mercado e modificá-los localmente para personalizá-los como suas próprias Recompensas.

<br />

##### Tarefas aleatórias

Não sabe quais Tarefas fazer quando se sente perdido?

Venha a este módulo para receber convites a Tarefas aleatórias.

Conclua com as próprias mãos uma Tarefa pequena e significativa~

Por exemplo, fazer as malas, conversar com quem você ama e tirar fotos para registrar a boa vida.

<br/>

#### # Detalhes

-

#### # Vinculação

- **Tarefas:**
  - Entrar ou criar uma equipe e obter Tarefas de equipe
  - Receber Tarefas aleatórias
- **Reflexões:**
  Concluir Tarefas de equipe e publicar suas Reflexões publicamente no módulo Momentos
- **Loja:**
  - Importar produtos criados por outros usuários
  - Adicionar ícones de produtos criados por outros usuários



<br/>

---

<h3 align="center" padding="100" id="api">VIII. Interface aberta (API)</h3>

<p align="center">Aberta nos dois sentidos (apps externas ↔ LifeUp), automatize seu LifeUp e crie possibilidades infinitas de vinculação~</p>




#### # Início rápido

**Interface aberta** é um recurso avançado do `LifeUp`.

Com ela, você pode

- Vincular aplicativos externos usando Itens (abrir aplicativos externos, acionar ações de aplicativos externos)
- Usar Itens que afetem valores no `LifeUp`, como a taxa do caixa eletrônico, a probabilidade de um Item estar em uma caixa específica.
- Vincular aplicativos externos para oferecer Recompensas ao seu `LifeUp`. Por exemplo, no exemplo há um jogo web Wordle de adivinhar palavras; ao acertar, você ganha 10 moedas no *LifeUp*.
- Vincular ferramentas de automação externas para determinar localização, despertar, passar cartões NFC, automatizar Tarefas, penalidades, registrar tempo de Foco para outros aplicativos, e mais...

<br/>

##### Importar Itens

Pode parecer complicado, mas se você não precisa de personalização.

Você pode importar Itens de API diretamente na aba **Mundo**-**Mercado**-**(Link, API, Automation)** e usá-los diretamente.

<br/>


#### # Detalhes

[Clique aqui para uma descrição detalhada da interface aberta](/guide/api)

#### # Uso de vinculação

- A funcionalidade de API pode ser testada junto com quase qualquer módulo; consulte a documentação da interface para detalhes.
- Aplicativos externos, páginas web: além disso, a função API pode ser vinculada a aplicativos externos e páginas web; participe do desenvolvimento secundário.
- Ferramentas de automação: você pode usar Tasker e Macrodroid para obter funções de automação.

<br/>

## Fale conosco

Se tiver mais feedback ou perguntas, ou precisar de ajuda com reembolso, **escreva para lifeup@ulives.io.**

Na maioria dos casos, respondemos em até 48 horas.



Porém, circunstâncias especiais (como filtro de spam de e-mail ou algum descuido nosso) podem fazer com que alguns e-mails se percam. Se não receber resposta, considere reenviar o e-mail.

Para uma forma mais confiável de entrar em contato e enviar feedback, recomendamos a [página de issues do GitHub](https://github.com/Ayagikei/LifeUp/issues).
