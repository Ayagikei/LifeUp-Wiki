# Notas de versão

## Linha do tempo

![timeline](_media/release_log/timeline.png)

## Notas

| Plataforma        | Versão                | Data de atualização         |
| :---------------- |:-----------------------|:----------------------------|
| LifeUp-Android    | v1.105.3              | 2026/08/26                  |
| LifeUp-iOS        | consulte [feature/ulives] | 🎉App alternativo disponível |
| LifeUp-Desktop    | v1.2.0                 | 2025/01/01                  |
| LifeUp Cloud(SDK) | v2.1.1                 | 2026/06/16                  |

(Parte da tradução foi feita por tradução automática ou IA e pode conter imprecisões)

<!-- tabs:start -->

### **LifeUp-Android**

**v1.105.3 (2026/08/26)**

**🐛 Correções de bugs**

1. **Corrigida a conclusão anormal de Tarefas ao converter localmente uma tarefa de equipe em tarefa cronometrada.**

**v1.105.2 (2026/08/24)**

**🐛 Correções de bugs**

1. **Corrigido o seletor de Tarefas que exibia uma lista vazia ao selecionar uma lista inteligente.**
2. **Corrigida a busca em uma lista inteligente que também mostrava Tarefas que não pertenciam a essa lista.**

**v1.105.1 (2026/08/19)**

**✨ Novidades**

1. **Efeitos sonoros personalizados podem ser desativados por cena**: silencie um alerta sem afetar os outros; a pré-visualização ainda reproduz para você conferir o som.

**♻️ Otimização**

1. **Orientação de backup mais clara quando os serviços do Google Play não estão disponíveis**: se o Google Drive não puder ser usado, o App explica o motivo e sugere um arquivo local, Dropbox ou WebDAV.

**🐛 Correções de bugs**

1. **Corrigido o toque em Desfazer na página Concluídas do calendário que não fazia nada.**
2. **Corrigidos os limites de compra/uso que não eram restaurados (ou eram salvos vazios) ao editar um Item.**

**v1.105.0 (2026/08/04)**

**ℹ️ Nota importante**

1. **Android 6.0 passa a ser a versão mínima compatível**: para dar suporte proativo a recursos e requisitos de comportamento de versões mais recentes do Android, a versão mínima compatível foi elevada de Android 5.0 para Android 6.0. Usuários do Android 5.x não podem instalar nem atualizar para esta versão.

**✨ Novidades**

1. **Nova API URL Scheme para controle do Pomodoro**: os usuários podem consultar o status, selecionar uma Tarefa e iniciar, pausar, pular, abandonar ou concluir sessões Pomodoro ou de cronômetro crescente.
2. **Mecanismo de ordenação personalizada de Tarefas aprimorado**: introduzido um novo mecanismo de ordenação para manter a ordem personalizada estável ao copiar, concluir, desfazer e gerenciar Tarefas em outros casos extremos.

**♻️ Otimização**

1. **Suporte ao gesto de voltar preditivo do Android**: os editores de Tarefas, Loja, Síntese e Conquistas agora suportam o gesto de voltar preditivo do sistema.
2. **Inicialização do login com Facebook aprimorada**: o SDK é inicializado quando o login é solicitado, com melhor tratamento de estados de erro.

**🐛 Correções de bugs**

1. **Corrigidas solicitações URL Scheme de edição que sobrescreviam campos existentes inesperadamente**: campos omitidos agora mantêm os valores anteriores, e parâmetros inválidos de Recompensa ou relação não limpam mais os dados existentes.
2. **Corrigidos títulos de notificação do temporizador crescente que não seguiam a Tarefa selecionada em certos casos extremos.**
3. **Corrigida a pré-visualização RGB que não era atualizada após colar o primeiro valor hexadecimal de cor.**
4. **Corrigidas sombras ausentes na barra de ferramentas de seleção nas páginas de detalhes de Síntese e Conquistas.**

**v1.104.6 (2026/07/19, Google Play)**

**🐛 Correções de bugs**

1. **Corrigida a restauração incorreta de sessões Pomodoro após parada inesperada do App ou do serviço do temporizador**: sessões válidas agora são restauradas corretamente, enquanto estados obsoletos inválidos são limpos.
2. **Corrigidos avisos repetidos após mudança de fuso horário do sistema**: após confirmar o ajuste, os horários das Tarefas são atualizados corretamente sem exibir o mesmo aviso novamente.

**v1.104.5 (2026/07/17)**

**🐛 Correções de bugs**

1. **Corrigido um problema na compilação da versão v1.104.4 em que abrir a página Pomodoro podia causar o fechamento do App.**

**v1.104.4 (2026/07/17)**

**✨ Novidades**

1. **Itens agora suportam restrições de compra/uso com base em intervalos de Pontos de Experiência de Atributos**: defina condições mínimas e máximas de XP para controlar se um Item pode ser comprado, usado ou ambos.
2. **Nova condição de Conquista por concluir Tarefas um total de N vezes em um dia**: diferente da condição existente de Tarefas distintas, esta condição conta cada conclusão válida de Tarefa naquele dia, incluindo repetições da mesma Tarefa.

**♻️ Otimização**

1. **Fluxo de liquidação e recuperação do Pomodoro reconstruído**: o estado do temporizador, registros de Foco e liquidação de Recompensas agora seguem um processo unificado. A recuperação também é mais confiável se o processo do App for encerrado, reduzindo casos extremos como perda de tempo de Foco. Se notar mudanças de comportamento inesperadas, entre em contato em lifeup@ulives.io.
2. **Edição de quantidades mais fluida em receitas de Síntese**: toque um ingrediente ou resultado existente para editar a quantidade diretamente, sem selecionar o mesmo Item novamente. Você ainda pode selecionar o Item novamente quando necessário.
3. **Pomodoro agora pode ser aberto em paisagem diretamente da página inicial**: visualize e opere o temporizador com mais conforto em layout horizontal.

**v1.104.3 (2026/07/09)**

**✨ Novidades**

1. **Novo guia «Configuração rápida» na tela de boas-vindas**: duas páginas novas (5 e 6) após os cartões introdutórios permitem configurar permissões de notificação, método de lembrete, estilo da interface (Material 2/3) e exibição em várias janelas direto no onboarding — com cartões em acordeão. Todas as opções podem ser ajustadas depois em Configurações.

**♻️ Otimização**

1. **Texto introdutório da página de boas-vindas atualizado**: as páginas 1–4 foram reescritas para comunicar melhor o valor principal do App: Tarefas personalizadas → crescimento de estatísticas → sistema de Recompensas → conexão com o mundo.
2. **Diálogo de Síntese redesenhado como folha inferior**: materiais e resultados agora são exibidos em uma grade vertical, deixando o layout mais limpo e intuitivo.
3. **Carregamento de dados mais rápido ao alternar entre listas de pendências, alterar a ordenação ou alternar configurações de agrupamento**.

**🐛 Correções de bugs**

1. **Corrigidas notificações duplicadas de «Conquista desbloqueada»** para certas Conquistas do sistema.
2. **Corrigida a contagem imprecisa da Conquista «Concluir N Tarefas distintas por dia»**: Tarefas infinitas não são mais excluídas, e concluir a mesma Tarefa várias vezes no mesmo dia agora conta como uma.
3. **Corrigido o botão adicionar (+) na lista de Tarefas que ocasionalmente se deslocava da posição correta**.
4. **Corrigidas listas inteligentes que não filtravam Tarefas arquivadas quando «Agrupar por lista» estava desativado**.

**v1.104.2 (2026/07/03)**

**✨ Novidades**

1. **«Dias de uso» renomeado para «Dias de companhia» na página de estatísticas**: toque no cartão para personalizar a data de início e definir seu próprio aniversário. Descrições de condições de Conquistas relacionadas também foram atualizadas para usar a terminologia de «companhia».
2. **Opção «Backup e compartilhar» adicionada ao menu de backup**: compartilhe arquivos de backup diretamente com outros apps pelo painel de compartilhamento do sistema.
3. **API de efeitos de Caixa de saque v2**: uma nova rota `loot_box/v2` suporta correspondência precisa de Itens via `sub_amount`, adicionar/remover Itens e controle independente de modos de quantidade e probabilidade.

**♻️ Otimização**

1. **URL Scheme agora prioriza correspondência exata por nome** ao editar Itens da Loja, Caixas de saque ou subtarefas, recorrendo a correspondência aproximada somente quando não houver correspondência exata — evitando edições indesejadas.
2. **«FAQ» da barra lateral renomeado para «Notice» em inglês**: a versão em chinês já era «公告» e permanece inalterada.
3. **Efeitos ripple dos botões agora respeitam o raio das bordas em todos os lugares**: animações ripple em controles arredondados não ultrapassam mais as bordas, deixando os toques mais refinados em todo o App.

**🐛 Correções de bugs**

1. **Corrigida a página Pomodoro que não atualizava automaticamente a contagem de tomates após adicionar ou editar um registro.**
2. **Corrigido o toast de tomates ganhos que ocasionalmente não aparecia após adicionar um registro Pomodoro.**
3. **Corrigidos registros Pomodoro adicionados manualmente que calculavam tomates com base na Tarefa selecionada no momento em vez da Tarefa escolhida no registro**: o cálculo agora usa a duração de Foco específica da Tarefa realmente selecionada no registro. Se você definiu durações de Foco diferentes para Tarefas diferentes, os tomates registrados manualmente serão mais precisos.
4. **Corrigida a exibição incorreta da «contagem de conclusões» para Tarefas ilimitadas no histórico**: agora exibida como ordinal diário (por exemplo, «a N.ª vez naquele dia»).
5. **Corrigido o texto de motivação de Tarefas com penalidade que não aparecia** — agora aparece após concluir a penalidade.

**v1.104.1 (2026/06/17)**

**✨ Novidades**

1. **Opções de exportação de backup aprimoradas**: ao criar um backup manual, uma nova folha inferior permite escolher se deseja incluir arquivos de mídia, informações sensíveis da conta (estado de login, credenciais WebDAV etc.) e imagens emoji — facilitando compartilhar um backup sanitizado. A seção de backup automático também recebe três alternadores persistentes correspondentes.
2. **Seletor de Tarefas do Pomodoro aprimorado**: Tarefas cronometradas agora aparecem primeiro no seletor com o progresso de Foco atual (duração focada / duração alvo / porcentagem). Um alternador permite ativar ou desativar a priorização de Tarefas cronometradas para acesso rápido.
3. **Redesign da página Sobre**: a página Sobre foi reorganizada em seções Links, Feedback, Comunidade e Desenvolvedor, com novas entradas para o site, registro de alterações, FAQ e documentação da API. Usuários de chinês simplificado recebem uma entrada Tencent Channel; usuários internacionais ganham acesso à comunidade GitHub Issues/Discussions.
4. **Remover seguidores**: agora você pode remover seguidores na página de membros da equipe.
5. **Aprimoramento do seletor de Atributos na Loja**: botão seletor de Atributos adicionado ao diálogo de entrada de exp/efeito da Loja, com filtragem rápida por grupo de Habilidades e seleção múltipla em lote — muito mais fácil ao lidar com muitos Atributos.

**♻️ Otimização**

1. **Estatísticas Pomodoro agora suportam alternância de formato de tempo**: toque a área de estatísticas Pomodoro na página de detalhes da Tarefa para alternar entre «horas/minutos», «dias/horas/minutos» e «minutos totais».
2. **Estado de conclusão de subtarefas mais claro**: subtarefas concluídas agora exibem tachado, deixando a distinção entre feito e pendente muito mais clara.
3. **Ordenação de registros Pomodoro corrigida**: registros Pomodoro agora são ordenados por hora de término em ordem decrescente.

**🐛 Correções de bugs**

1. **Corrigido o texto do botão de saque do caixa eletrônico em vários idiomas**: corrigido uso incorreto de gerúndio no texto do botão de saque do caixa eletrônico em alguns idiomas.
2. **Corrigido o comportamento ao compartilhar Itens da Loja sem login**: resolvido comportamento anormal ao compartilhar Itens da Loja sem estar conectado.
3. **Corrigido o estado de seleção do seletor de cores**: corrigido um problema em que o diálogo do seletor de cores exibia estado de seleção incorreto.

**v1.104.0 (2026/05/23)**

**✨ Novidades**

1. **Tarefas de contagem agora suportam liquidação de Recompensas proporcional em tempo real**: útil para Tarefas em que você avança várias vezes em momentos flexíveis dentro de um ciclo, como hábitos concluídos algumas vezes por semana. Quando o progresso da contagem muda, o LifeUp pode conceder ou reverter Exp, moedas e Recompensas de Itens de acordo com o progresso atual em vez de esperar a conclusão final.
2. **Ferramentas de histórico nos detalhes da Tarefa mais poderosas**: selecionar uma data no calendário do histórico agora mostra a contagem daquele dia, e você pode adicionar, editar ou criar registros de histórico em lote.
3. **Reflexões e Itens melhor conectados**: detalhes de Itens agora podem ir diretamente para Reflexões relacionadas, e a página Reflexões suporta filtrar por Item da Loja.
4. **Horários de conclusão de subtarefas agora são registrados**: o LifeUp agora registra quando cada subtarefa é concluída, preparando os dados para futura API e suporte ao LifeUp Cloud.

**♻️ Otimização**

1. **Filtros de visibilidade de Itens da Loja mais precisos**: além de Itens esgotados, agora você pode ocultar Itens com compra desabilitada, compra limitada ou atualmente inacessíveis. Widgets da Loja seguem as mesmas regras.
2. **Busca e atualização da lista de Tarefas mais estáveis**: a busca em listas regulares pode incluir Tarefas concluídas visíveis conforme as configurações, e a atualização de Tarefas repetidas mais ordenação personalizada na lista Todas é mais estável com muitas Tarefas.
3. **Estatísticas de histórico nos detalhes da Tarefa agora seguem a data selecionada**: Tarefas de contagem e ilimitadas agora usam níveis de cor diferentes no mapa de contribuição com base na contagem de conclusões de cada dia. As estatísticas mensais, anuais, totais e de sequência abaixo da visualização do histórico também são calculadas a partir da data selecionada em vez de sempre usar os dados de hoje.
4. **Ordenação alfabética mais intuitiva**: a ordenação alfabética entre módulos agora segue ordenação numérica natural, de modo que nomes com números são ordenados pelo valor numérico em vez de comparação caractere a caractere.
5. **Comportamento de entrada nas configurações da Loja aprimorado**: as configurações da Loja agora rolam campos focados acima do teclado virtual.
6. **Tratamento do modo escuro do sistema mais confiável**: corrigidas condições de corrida entre seguir o tema do sistema e alternar o modo noturno manualmente.
7. **Suporte expandido à API URL Scheme**: Adicionar/Editar Tarefa agora suporta a semântica `no_deadline`, e APIs de Tarefas de contagem suportam a flag de liquidação em tempo real.
8. **Registros de juros do histórico mais claros**: registros de juros do caixa eletrônico e do crédito agora mostram o principal e os dias de juros, facilitando verificar a origem dos juros.

**🐛 Correções de bugs**

1. **Corrigidas estatísticas de Conquistas em Minha página**: quando Conquistas do sistema estão ocultas, as contagens agora seguem a mesma regra de visibilidade.
2. **Corrigida a redação de registros do histórico**: registros de desistência não são mais exibidos com redação de penalidade por atraso.
3. **Corrigido o tratamento de textos longos nas APIs URL Scheme**: descrições longas de Habilidades e Conquistas não são mais truncadas cedo demais.

**v1.103.6 (2026/05/10)**

**🐛 Correções de bugs**

1. **Corrigida a dica de intervalo de pausa longa que não voltava ao estado inicial da sessão de Foco após tocar em Abandonar.**
2. **Corrigido um problema em que o temporizador de Foco adicional podia permanecer visível e continuar contando após tocar em Abandonar.**

**v1.103.5 (2026/05/10)**

**🐛 Correções de bugs**

1. **Corrigida a dica de pausa longa do temporizador Pomodoro que não era atualizada prontamente após uma sessão de trabalho terminar naturalmente.**
2. **Corrigido um problema em que o temporizador Pomodoro podia exibir o intervalo antigo de pausa longa de 2 sessões antes de abrir as configurações Pomodoro, em vez do padrão de 4 sessões.**

**v1.103.4 (2026/05/05)**

**🐛 Correções de bugs**

1. **Corrigido um problema em que Tarefas podiam desaparecer devido a interrupção anormal enquanto congeladas em alguns cenários extremos.**

**v1.103.3 (2026/05/05)**

**ℹ️ Nota de versão**

1. **Esta versão foi ignorada e não foi publicada.**

**v1.103.2 (2026/04/30)**

**🐛 Correções de bugs**

1. **Corrigido um problema de compatibilidade em que campos de entrada podiam não aparecer ao editar restrições de compra ou uso de Itens em certos idiomas ou telas menores.**
2. **Corrigido um problema em que usar um Item podia acionar incorretamente um diálogo de penalidade.**

**v1.103.1 (2026/04/25)**

**🐛 Correções de bugs**

1. **Corrigido comportamento anormal quando o efeito de uso de um Item modifica sua própria quantidade**
2. **Corrigidos alguns fechamentos inesperados e problemas de lentidão capturados em produção**
3. **Corrigidos valores de quantidade incorretos preenchidos ao editar o efeito «Modificar quantidade do Item» de um Item**

**v1.103.0 (2026/04/12)**

**✨ Novidades**

1. **Atributos agora suportam subcategorias e movimentação rápida**: você pode agrupar Atributos com mais clareza e mover um Atributo para um grupo alvo mais rapidamente.
2. **Interações de seleção de Atributos mais fluidas**: edição de Tarefas, fluxos relacionados a Recompensas e outros seletores de Atributos agora são mais fáceis de navegar quando você tem muitos Atributos.
3. **Itens agora suportam restrições de compra/uso**: limites podem se aplicar à compra, ao uso ou a ambos, com condições mais ricas como horário, Conquistas desbloqueadas, Tarefas concluídas, contagem de Itens possuídos e intervalos de Nível de Atributos.
4. **Conquistas adicionam mais opções de ordenação integradas**: além da ordem personalizada, listas de Conquistas agora suportam ordenação integrada por ordem alfabética, hora de conclusão e data de criação.
5. **Conquistas suportam movimentação rápida para subcategorias**: mova uma ou várias Conquistas para uma subcategoria alvo com mais eficiência.
6. **Tratamento de atraso agora inclui uma entrada de ajuda**: o diálogo de atraso agora inclui uma entrada de ajuda e apresenta mudanças de Recompensa com mais clareza ao marcar novamente como concluída uma Tarefa em atraso.

**♻️ Otimização**

1. **Exibição agrupada de Atributos mais clara**: a página de status e os diálogos de descrição de Atributos agora apresentam Atributos agrupados de forma mais estruturada.
2. **Interações relacionadas a Atributos mais consistentes**: exibição agrupada e comportamentos de seleção estão mais unificados entre diálogos de Atributos e fluxos de edição relacionados.
3. **Edição de restrições de Itens mais fácil de entender**: tipos de restrição mais ricos são mais fáceis de configurar e revisar.
4. **Renderização da barra de status e barra superior mais estável em várias páginas**: áreas superiores em páginas como Loja, Mundo, Busca, Status, Conquistas, Minha página e WebDAV agora se comportam de forma mais consistente durante rolagem, no modo escuro e com Material You.
5. **Layout de Atributos na página de status lida melhor com textos longos**: nomes de Atributos e rótulos de Nível mais longos agora cabem com mais confiabilidade, inclusive em telas estreitas ou com texto maior.

**🐛 Correções de bugs**

1. **Corrigido problema de variação de gid na geração de cópias**: corrigido um problema em que Tarefas copiadas geradas a partir de Tarefas em atraso únicas ou infinitas tinham gids inconsistentes.
2. **Corrigida caixa «Aleatório» não funcional na seleção de Atributos**: corrigido um problema em que algumas caixas de seleção de Atributos exibiam uma caixa «Aleatório» não funcional.
3. **Corrigidos problemas de posicionamento de banners de Recompensa**: corrigido um problema em que banners de Recompensa ficavam posicionados incorretamente, ocultos ou instáveis em certos cenários (especialmente quando acionados pela conclusão de Tarefas).
4. **Corrigida pré-visualização/animação imprecisa de Recompensas por atraso em alguns casos**: quando uma Tarefa em atraso é marcada novamente como concluída, mudanças de XP, moedas e Itens agora são apresentadas com mais precisão, sem misturar valores confusos.
5. **Corrigida quebra/desalinhamento do layout de Nível na página de status em alguns casos**: o layout agora é mais estável com nomes de Atributos longos ou rótulos de Nível extensos.
6. **Corrigida a troca de página quando a lista de Síntese tem poucos Itens**: agora você pode deslizar horizontalmente a partir de áreas vazias com mais confiabilidade quando o conteúdo da lista é curto.
7. **Corrigido fechamento inesperado ao resgatar Recompensas de Conquistas em casos especiais**: corrigido um possível fechamento ao resgatar Recompensas de Conquistas em certos casos extremos.

**v1.102.11 (2026/04/02)**

**🐛 Correções de bugs**

1. **Corrigidas falhas ocasionais de liquidação e anomalias de atualização nas Tarefas de contagem da página inicial.**

**v1.102.10 (2026/03/24)**

**🐛 Correções de bugs**

1. **Corrigido um problema em que listas de fórmulas de Síntese ocultas não podiam ser pressionadas por longo tempo para editar ou excluir fórmulas.**

**v1.102.9 (2026/03/23)**

**♻️ Otimização**

1. **Regra de desativação da navegação inferior atualizada**: no nível de interação, os usuários não podem mais desativar todos os módulos da navegação inferior.

**🐛 Correções de bugs**

1. **Corrigido um fechamento inesperado na inicialização**: corrigido um problema em que o App podia fechar ao abrir após todos os módulos da navegação inferior serem desativados.

**v1.102.8 (2026/03/23)**

**✨ Novidades**

1. **Redefinir layout padrão de módulos**: botão «Restaurar layout padrão» adicionado à página de configuração de módulos.
2. **Novo evento de broadcast de fórmula de Síntese**: adicionado o evento de broadcast da API `app.lifeup.synthesis.complete`, enviado quando uma fórmula de Síntese é concluída com sucesso.
3. **Busca do Mundo suporta filtragem por tag de origem**: a seção Mundo agora pode buscar por tags de origem, como filtrar Itens de API na Vitrine antes de buscar.

**♻️ Otimização**

1. **Melhorias tipográficas do popup de desbloqueio de Conquistas**: renderização de fonte aprimorada e menos problemas de layout quando tamanhos de fonte do sistema grandes são usados.
2. **Melhorias na lógica de ocultação de módulos**: comportamento de ocultação refinado para que Conquistas relacionadas ao módulo Mundo sejam exibidas ou ocultadas corretamente.
3. **Comportamento padrão de atribuição de Tarefas aleatórias ajustado**: Tarefas aleatórias recém-criadas não são mais atribuídas automaticamente à lista padrão, evitando atribuição silenciosa.

**🐛 Correções de bugs**

1. **Corrigido um fechamento inesperado raro durante atualização da lista de Tarefas**.
2. **Corrigido o problema de título na API Reflexões**: corrigido um problema em que a API não fornecia corretamente o título de Reflexões, o que também podia afetar títulos de Itens.
3. **Corrigidos problemas de layout em paisagem do Pomodoro**.
4. **Corrigido o tipo de timestamp de hora de término na API de histórico de Tarefas**.
5. **Campos de resposta da API ausentes adicionados**: progresso da Tarefa, status de conclusão, condições de fim de recorrência e campos relacionados agora são retornados corretamente.
6. **Corrigidos valores desatualizados na página de detalhes de Tarefas de contagem**: valores agora são atualizados imediatamente após atualizar a Tarefa de contagem.
7. **Corrigido um problema que podia causar durações anormais em registros Pomodoro**.
8. **Corrigida a página inicial que não era reconstruída imediatamente após entrar no modo offline**: isso podia deixar a seção Mundo visível inesperadamente.
9. **Corrigido um problema de carregamento na página de Tarefas aleatórias**: em alguns casos, a página podia ficar presa em estado de carregamento.

**v1.102.2 - v1.102.7 (2026/02/03)**

**♻️ Otimização**

1. **Tutorial de widgets + melhorias de texto**: adicionada orientação para adicionar widgets e refinados o texto e as dicas relacionadas.

**🐛 Correções de bugs**

1. **Corrigido deadlock do Pomodoro com dados anormais**: a página Pomodoro não trava mais quando há dados anormais.
2. **Corrigida dessincronização do temporizador de adição de tempo após desligar a tela**: o temporizador de «adicionar tempo» agora permanece sincronizado após a tela desligar ou o dispositivo entrar em repouso.
3. **Corrigida a seleção de lista padrão para novas Tarefas**: tratamento aprimorado ao criar Tarefas a partir de listas inteligentes, especialmente se a lista padrão estiver arquivada (agora recorre corretamente).

**v1.102.1 (2026/01/27)**

**✨ Novidades**

1. **Zoom na pré-visualização de imagens**: restaurada a funcionalidade de zoom em imagens perdida durante a refatoração da página, permitindo visualizar detalhes de imagens com mais facilidade.

**🐛 Correções de bugs**

1. **Otimização de memória WebDAV**: corrigido um problema em que downloads do WebDAV consumiam memória excessiva, podendo causar fechamentos ou problemas de desempenho.
2. **Atualização de imagens em Reflexões**: corrigido um bug em que imagens editadas na página Reflexões não eram atualizadas imediatamente.

**v1.102.0 (2026/01/25, substituída por v1.102.1 durante lançamento gradual)**

**✨ Novidades**

1. **Gerenciador de sons**: importar, pré-visualizar, excluir e reutilizar efeitos sonoros, e usá-los como efeitos de uso de Itens.
2. **Loja: novos efeitos de uso de Itens**: adicionados EXP aleatório, mudanças de estoque, reprodução de som e fluxo de configuração aprimorado.
3. **Tarefas cronometradas**: novo tipo de Tarefa com duração de Foco esperada; conclua a Tarefa após atingir a meta do temporizador.
4. **Opções de início da semana**: escolha segunda / sábado / domingo, e o calendário e as estatísticas seguirão.
5. **Pular onboarding**: opção para pular o tutorial na primeira inicialização.
6. **Entrada de emoji para ícones**: insira um emoji (incluindo emojis combinados) para criar um ícone rapidamente.
7. **Calendário: abrir detalhes de Tarefas recorrentes futuras**: tocar uma Tarefa recorrente em uma data futura agora abre seus detalhes corretamente.
8. **Usuários avançados: aprimoramentos de API**: a API URL Scheme adiciona/estende CRUD de modelos de Tarefas, condições de fim de recorrência, navegação de filtros de Síntese e mais.

**♻️ Otimização**

1. **Melhorias de desempenho e fluidez**: otimizado acesso a dados e estratégias de indexação para tornar listas de Tarefas, histórico do Inventário e estatísticas mais fluidos com grandes volumes de dados.
2. **Melhor UX de configuração de efeitos de Itens**: interações de seleção e exibição de efeitos aprimoradas, com diálogos e ícones refinados.
3. **Melhorias de localização**: traduções ausentes preenchidas em vários idiomas.

**🐛 Correções de bugs**

1. **Corrigido reinício do efeito de contagem regressiva ao editar**: corrigido um problema em que confirmar um efeito de contagem regressiva editado podia redefinir o valor para 1.
2. **Corrigido uso automático de Recompensas de Itens em Tarefas de equipe que não era acionado**: corrigido um problema em que o uso automático não era acionado após resgatar Recompensas de Itens em Tarefas de equipe.
3. **Corrigido aviso de «registrar Reflexões» ausente após Caixa de saque / Síntese**: corrigido um problema em que o diálogo de Reflexões podia não aparecer após abrir Caixas de saque ou usar Síntese simples quando o Item tem efeito «registrar Reflexões».
4. **Corrigidos diálogos de liquidação ausentes ao concluir manualmente no Pomodoro**: corrigido um problema em que concluir manualmente uma Tarefa na página Pomodoro podia pular diálogos de liquidação de Recompensas/Reflexões; restaurada a conclusão com toque longo no título da Tarefa.
5. **Corrigido filtro de dobra de widgets que não funcionava**: o filtro do widget de lista inteligente «Dobrar Tarefas que ainda não começaram» não surtia efeito.
6. **Corrigido um fechamento inesperado raro**: corrigido um fechamento causado por salvar muito estado em certas situações.
7. **Corrigida navegação do calendário para detalhes de Tarefas futuras**: corrigidas falhas ao abrir detalhes de Tarefas recorrentes futuras a partir do calendário.
8. **Corrigidos problemas com Tarefas recorrentes Ebbinghaus**: corrigidos estágios anormais e geração repetida indesejada em casos raros, com salvaguarda de limite superior adicionada.

**v1.101.8 (2026/01/12)**

**🐛 Correções de bugs**

1. **Corrigidas configurações de condição de fim de recorrência**: resolvido um problema em que a condição de fim não podia ser definida para frequências «A cada 2 dias» ou personalizadas «A cada N dias».
2. **Corrigida duração anormal do temporizador Pomodoro**: corrigido um problema em que o temporizador podia executar por muito mais tempo do que o esperado devido à suspensão do sistema ou congelamento do processo quando a otimização de bateria não estava desativada corretamente.

**v1.101.7 (2026/01/11)**

**🐛 Correções de bugs**

1. **Corrigido um problema que podia encurtar anormalmente a duração do temporizador Pomodoro**.

**v1.101.6 (2026/01/10)**

**🐛 Correções de bugs**

1. **Corrigidas anomalias relacionadas à alternância do modo escuro do sistema**.

**v1.101.5 (2026/01/08)**

**♻️ Otimização**

1. **Alternância do modo escuro do sistema otimizada**: corrigidos problemas em que o App podia falhar ao alternar temas automaticamente junto com as configurações do sistema.
2. **Seleção de Atributos para Recompensas otimizada**: tratamento aprimorado para casos em que nenhum Atributo está selecionado em «Recompensas por persistência», «Recompensas por etapas» e «Recompensas por curtidas». Suporta desmarcar Atributos e corrige problemas em que Recompensas de experiência não eram concedidas corretamente.
3. **Otimização de configuração de desempenho**: configurações internas otimizadas para potencialmente melhorar o desempenho do App.

**🐛 Correções de bugs**

1. **Corrigidas consultas de estatísticas e exibição de gráficos**: condições de consulta corrigidas para estatísticas de hora de conclusão de Tarefas e problemas com dados imprecisos em gráficos resolvidos.
2. **Corrigida interação do diálogo de configurações de widget**: corrigido um bug em que o botão «Confirmar» estava ausente no diálogo de filtro de Tarefas do widget.
3. **Corrigida sincronização da contagem de Tarefas**: corrigido um problema em que a contagem de Tarefas na tela inicial não era atualizada corretamente após ser alterada na página de detalhes da Tarefa.
4. **Corrigido tratamento de uso de Item na API Reflexões**: corrigido tratamento incorreto de tipos «Uso de Item» na API Reflexões.
5. **Corrigida navegação do calendário para detalhes**: resolvidos vários problemas ao navegar da visualização do calendário para os detalhes da Tarefa.

**v1.101.4 (2025/12/30)**

**♻️ Otimização**

1. **Lógica de detecção de atualizações para membros otimizada**: convida os membros a mudar para o «Canal estável para membros» para receber atualizações e garantir a experiência funcional mais estável.
2. **Reduzidas solicitações de rede desnecessárias**: economia adicional de dados do usuário e redução de custos do servidor.

**🐛 Correções de bugs**

1. **Corrigida a atualização do progresso de Conquistas (prioritário)**: corrigido um bug em que o progresso de Conquistas não era acionado corretamente ao completar registros Pomodoro.

**v1.101.3 (2025/12/14)**

**🐛 Correções de bugs**

1. Corrigido um problema em que a opção «Vence hoje» ignorava incorretamente o deslocamento de prazo para o dia seguinte.

**v1.101.2 (2025/12/13)**

**🐛 Correções de bugs**

1. Corrigido um problema em que o estado de busca era redefinido ao voltar às páginas Loja, Inventário ou Tarefas.
2. Corrigido um fechamento inesperado relacionado aos limites do `AlarmManager` (aprox. 500 alarmes simultâneos).
3. Corrigidos fechamentos inesperados relacionados a cores dinâmicas, diálogos de fuso horário e menus pop-up.
4. Otimizado o relatório de fechamentos inesperados para ignorar erros de rede comuns.

**v1.101.1 (2025/12/01)**

**🐛 Correções de bugs**

1. Corrigidos possíveis fechamentos inesperados causados por erros de formatação em traduções.

**v1.101.0 (2025/11/29)**

**✨ Novidades**

1. **Filtro de Itens na Síntese**: filtra a Síntese por Itens para buscar e gerenciar com mais rapidez.
2. **Detalhes do Item → receita de Síntese**: veja a receita de Síntese de um Item diretamente na página de detalhes do Item.
3. **Loja → entrada de Síntese**: se um Item pode ser usado na Síntese, um botão Síntese aparece ao lado do botão Comprar.
4. **Filtros do histórico do Inventário**: filtros por data, Itens e descrição.
5. **Diálogo de novidades**: destaques da nova versão no primeiro início após a atualização.
6. **Tempo de Foco Pomodoro por Tarefa**: lógica Pomodoro refatorada; suporta duração de Foco personalizada por Tarefa.
7. **Efeito de uso de Item: «Registrar Reflexões após o uso»**; a página Reflexões também suporta filtrar por Item.
8. **Transmissões do ciclo de vida Pomodoro (API)**: adicionados eventos de transmissão do ciclo de vida.
9. **API de consulta simples**: agora suporta obter os detalhes de uma única Tarefa.
10. **Incremento automático em Tarefas de contagem**: suporta incremento automático.
11. **Fim de recorrência por data**: Tarefas agora suportam encerrar a recorrência em uma data específica.
12. **Melhoria nas configurações de widgets de desktop**: aprimorada a página de configurações de widgets dentro do App para que cada widget compatível possa ser pré-visualizado e, quando o sistema permitir, adicionado rapidamente à tela inicial.

**♻️ Otimização**

1. **UX de gerenciamento de listas + modo escuro**: interações e modo escuro refinados; a lista «Todas» agora mostra um estado de exclusão desabilitado em vez de uma ação impossível de excluir.
2. **Página de configurações da Loja**: movida para uma página independente e acessível nas Configurações principais.
3. **Plano de fundo padrão de Tarefas**: redação esclarecida no diálogo de ajuda.
4. **Indicador de Conclusão rápida**: quando ativado, a página de Tarefas mostra um indicador superior do estado de Conclusão rápida.
5. **Memória de recolhimento por lista**: o estado recolhido/expandido é registrado por lista para evitar que «Todas» afete a lista do dia.
6. **Diálogo de vencimento (modo escuro)**: estilos de modo escuro aprimorados ao processar Tarefas vencidas.
7. **Lógica do botão de filtro Reflexões**: exibido apenas para tipos que suportam filtragem (Itens/Tarefas).
8. **Fluxo de apenas Tarefas locais em equipes**: interação aprimorada ao coletar somente Tarefas locais.
9. **Refinamento da UI da página Síntese**: layout e feedback visual refinados para uma apresentação mais fluida.
10. **Refinamento das interações com Itens**: interações relacionadas a Itens mais ágeis e responsivas.

**🐛 Correções de bugs**

1. Corrigido um problema em que a barra de filtros superior não era exibida corretamente após filtrar na página Histórico.
2. Corrigido um problema em que Tarefas negativas podiam não calcular penalidades com a contagem correta de penalidade 1× em certos casos.
3. Corrigido um problema em que o seletor de Tarefas do temporizador Pomodoro podia perder a opção «Cancelar seleção» em certas condições.
4. Corrigidos vários problemas ao seguir as configurações de modo escuro do sistema.
5. Corrigida a ausência do pop-up de Recompensa quando um widget concluía uma Tarefa de contagem.

**v1.100.6 (2025/11/08)**

**🐛 Correções de bugs**

1. Corrigido um fechamento inesperado ao selecionar Itens se o foco de entrada transbordava por teclados externos/controles; eficácia da correção em verificação.
2. Corrigido o diálogo inteligente de gerenciamento de fuso horário para que possa rolar e revelar o conteúdo inferior e os botões.

**v1.100.5 (2025/09/28)**

**✨ Novidades**

1. **Efeitos sonoros personalizados agora suportam seleção de sons integrados**: acesse uma biblioteca de efeitos de áudio integrados para personalizar com mais conveniência.
2. **Filtragem de Síntese aprimorada**: opção de filtro «Mostrar apenas sintetizáveis» na página Síntese para melhor gerenciamento de Itens.
3. **Suporte a emoji na API**: as APIs de Item, Atributo e Conquista agora suportam entrada direta de emoji para maior personalização.
4. **Melhorias na criação de equipes**: adicionada a capacidade de selecionar listas de destino ao criar equipes para melhor organização.
5. **Cópia de Tarefas de equipe**: suporte para copiar Tarefas de equipe como Tarefas locais sem exigir participação na equipe.
6. **Aprimoramento da API de Tarefas**: suporte a parâmetros para definir o estado «fonte de nota clara» em APIs relacionadas a Tarefas.

**♻️ Otimização**

1. **Lógica de «descartar alterações» aprimorada**: diálogo de confirmação otimizado ao editar Itens, Síntese, Conquistas e listas de Conquistas — agora aparece apenas quando há alterações reais.
2. **Condições de desbloqueio de Conquistas**: condições de desbloqueio agora expandidas por padrão para melhor visibilidade.
3. **Desempenho de Síntese aprimorado**: consultas otimizadas na página de detalhes de Síntese.
4. **Estabilidade da API toast**: maior estabilidade e confiabilidade nas chamadas da API toast.
5. **Fluxo de conclusão de Tarefas de equipe**: processo aprimorado com melhor tratamento de erros e orientação ao usuário.
6. **Comportamento de arrastar na Síntese**: rolagem até a borda aprimorada ao ordenar Itens personalizadamente na página Síntese.
7. **Fluxo de coleta de Tarefas de equipe**: fluxo aprimorado após coletar Tarefas de equipe, com suporte para ir às listas correspondentes.
8. **Otimização de lembretes de calendário**: lógica de lembretes de calendário aprimorada para maior confiabilidade.

**🐛 Correções de bugs**

1. Corrigido um problema em que planos de fundo personalizados de versões antigas usavam incorretamente o estado global padrão de «fonte de nota clara».
2. Corrigida a adaptação da barra de status na página de efeitos sonoros personalizados.
3. Corrigida a possível sobreposição da descrição da Conquista com os botões de desbloqueio.
4. Corrigidos problemas de rolagem ao ordenar por arrastar na página de detalhes de Síntese.
5. Corrigido o desaparecimento ocasional do botão de busca quando o módulo Mundo está na barra lateral.
6. Tentativa de corrigir anomalias ao seguir o modo noturno do sistema.
7. Tentativa de corrigir um problema em que conclusões consecutivas de Tarefas de equipe podiam levar à duplicação de Tarefas.
8. Corrigida a falha da funcionalidade Reflexões ao desbloquear Conquistas.

**v1.100.4 (2025/09/07)**

**♻️ Otimização**

1. **Melhorias no relatório de fechamentos inesperados**: coleta e relatórios aprimorados para melhor análise e depuração de problemas.

**🐛 Correções de bugs**

1. Corrigido um fechamento inesperado causado pelo SDK do Facebook.

**v1.100.3 (2025/09/06)**

**🐛 Correções de bugs**

1. Corrigido um problema em que a busca não funcionava ao selecionar Itens.

**v1.100.2 (2025/09/05)**

**🐛 Correções de bugs**

1. Corrigido um problema em que **a lista padrão não podia ser selecionada** em certas situações ao criar ou editar Itens na Loja.

**v1.100.1 (2025/09/03)**

**✨ Novidades**

1. **Opções de cor da fonte em plano de fundo personalizado**: suporte a opções de cor personalizada da fonte de notas, personalizando ainda mais a interface.
2. **Efeitos de uso de Item aprimorados**: efeitos aleatórios de redução de moedas agora também suportam a função «Limitar uso».

**♻️ Otimização**

1. **Otimização da funcionalidade de lembretes de calendário**: opções para ajustar a duração de eventos de lembrete inseridos no calendário.
2. **Otimização da interação de edição de Tarefas**: lógica aprimorada do pop-up «Descartar alterações» ao editar Tarefas — não aparece mais ao sair sem nenhuma edição.
3. **Atualizações de localização multilíngue**: textos localizados atualizados para melhorar a experiência do usuário.

**🐛 Correções de bugs**

1. Corrigida a **página de configuração de compatibilidade e a página de configurações de lembretes** que não se adaptavam ao modo escuro.
2. Tentativa de corrigir **fechamentos inesperados relacionados a pop-ups e foco do método de entrada** em várias páginas, melhorando a estabilidade do App.
3. Corrigido um problema em que **editar Conquistas não permitia alterar se Itens seriam usados automaticamente**.

**v1.100.0-alpha (2025/07/29)**

**✨ Novidades**

1. **Temporizador Pomodoro, Pontos de Experiência, histórico do Inventário, detalhes de moedas**: adicionado salto com um toque para a página de estatísticas correspondente.
2. Suporte a configurações de lembrete mais flexíveis (X minutos antes do início ou do prazo).
3. Suporte para ocultar listas de Síntese.
4. Suporte para alterar Atributos em Recompensas por etapas e por persistência.
5. Suporte para personalizar módulos funcionais da barra lateral (como colocar Loja, comunidade na barra lateral ou ocultar módulos desnecessários).
6. Adicionada opção experimental **«Modo de baixa restrição»**: relaxa limites numéricos no App (Pontos de Experiência, dígitos de moedas, número de Atributos selecionáveis para Tarefas, etc.).
7. Otimizada a UI e a lógica de interação do pop-up de processamento de vencimentos.
8. Adicionada descrição para opções de uso automático de Item.
9. Mais condições de desbloqueio repetíveis:
   - Aquisição diária da árvore Pomodoro.
   - Tempo de Foco Pomodoro diário.
   - Conclusão diária de N Tarefas diferentes.
   - Uso diário de um Item específico N vezes.
   - Conclusão diária de uma Tarefa específica N vezes.
10. Opções de lista inteligente migradas para o pop-up de gerenciamento de listas (botão de lista no topo da página de Tarefas).
11. Adicionada opção **«Conclusão rápida»**: quando ativada, concluir Tarefas pula todos os pop-ups.
12. Ampliado o alcance de ícones de moeda personalizados; agora suporta ícones monocromáticos (como ícones de moeda no topo da Loja).
13. Os detalhes do Item agora identificam a qual lista o Item pertence, facilitando confirmar a propriedade a partir do Inventário.
14. Ao editar receitas de Síntese, suporta ordenar por arrastar e tocar para editar Itens.
15. Adicionada API para editar diretamente a quantidade de moedas.
16. A API de consulta suporta informações Pomodoro (contagem Pomodoro).
17. Limites numéricos de algumas APIs relaxados (a API padrão é de baixa restrição).
18. **Mecanismo de cálculo do progresso de condições de Conquistas redesenhado e otimizado**: melhor desempenho de cálculo e velocidade de atualização do progresso.

**♻️ Otimização**

1. Otimizados os dias de persistência na página **«Meu»**, suporta recalcular manualmente com um toque.
2. Corrigidos problemas de layout RTL na página calendário; início da semana definido como **«Segunda-feira»** (anteriormente domingo).
3. A exibição agrupada em listas inteligentes de Tarefas e Loja suporta recolher/expandir por rótulos de grupo.
4. Quando a lista de Tarefas expande concluídas, não iniciadas ou congeladas na parte inferior, os rótulos correspondentes também aparecem no topo.
5. Ícones de Item importados do módulo Mundo são salvos localmente de forma persistente, evitando incapacidade de carregar offline.
6. O pop-up de seleção de listas agora identifica listas inteligentes.
7. Otimizada a lógica de lista padrão para Tarefas de equipe e aleatórias: quando a lista padrão está arquivada, seleciona a primeira lista por padrão.
8. Otimizada a lógica de processamento de vencimento em Tarefas de contagem: se a contagem for atingida, o status padrão é **«Concluída»**.

**🐛 Correções de bugs**

1. Corrigido um problema em que o estado da caixa **«usar Item automaticamente»** não era restaurado corretamente ao editar Conquistas.
2. Corrigida a contagem do cartão superior de listas inteligentes: falhava em excluir Tarefas de listas arquivadas.
3. Corrigida a memória global do estado **«usar automaticamente»** na compra de Item; alterada para memória independente por Item.
4. Corrigido um problema em que a API de desbloqueio de Conquista não atualizava o progresso corretamente em certas situações.
5. Corrigidos problemas de lógica de lista padrão para Tarefas de equipe e aleatórias.
6. Atualização de bibliotecas de dependências técnicas; versão da API de destino ajustada para 35 (Android 15).

**Correções Alpha/Beta**

1. Removidas dependências desnecessárias e adaptação a tamanho de página 16K, **reduzindo o tamanho do pacote do App**.
2. Corrigida a lógica de **uso automático de Item**: para Itens URL, agora apenas 1 Item será usado e o restante armazenado no Inventário. (Antes apenas 1 surtia efeito, mas não era armazenado no Inventário, causando perda do efeito de uso)
3. Corrigido um problema em que **condições de Conquistas repetíveis** não recalculavam o progresso.
4. Corrigido um problema em que **arquivos de backup** não incluíam modelos de Tarefas.
5. Corrigido um problema em que a maioria dos emojis regenerava ícones anormais após restauração de backup.
6. Atualizado o **link do canal QQ** para feedback no App.
7. Adicionada a **transmissão de publicação de Reflexões**.
8. **Redesenhada** a interface de configuração de compatibilidade e métodos de lembrete.
9. Adicionada a opção «Restringir uso do Item» para **efeitos de redução de moedas**.
10. **Atualizações relacionadas à API**: a API de Tarefas suporta parâmetros de mensagem motivacional.
11. Corrigido espaçamento superior anormal na página de configurações padrão de Item novo.

**v1.99.5 (2025/07/29)**

**🐛 Correções de bugs**

1. Tentativa de corrigir um problema em que planos de fundo personalizados podiam não ser exibidos corretamente em certas situações.

**v1.99.3 (2025/06/30)**

**✨ Novidades**

1. A API de subtarefas suporta ajuste relativo (`set_type`).
2. Suporte para limpeza automática de eventos de lembrete de calendário expirados.
3. Otimizada a lógica de processamento de listas arquivadas:

* Listas inteligentes não exibem mais Tarefas arquivadas.
- Tarefas em listas arquivadas não avançam automaticamente por padrão (similar ao status congelado).

**♻️ Otimização**

1. Ao adicionar Tarefas/Conquistas continuamente, suporta rolagem automática para o topo e foco no campo de entrada.
2. Otimizada a redação relacionada à conclusão de Tarefas negativas.
3. Otimizada a lógica de exibição do pop-up «Descartar alterações» na página de edição de Tarefas.
4. Otimizada a duração de eventos de lembretes de calendário para evitar problemas potenciais em alguns dispositivos.

**🐛 Correções de bugs**

1. Corrigido um problema em que widgets não suportavam exibir ícones de moeda personalizados.
2. Corrigido um problema em que a página de detalhes da Tarefa não suportava exibir Recompensas de vários Itens.
3. Corrigidos problemas em que certos cenários (p. ex., widgets) podiam não respeitar as regras de ordenação de listas.

**v1.99.1-rc02 (2025/06/20)**

**✨ Novidades**

1. Suporte a condições de desbloqueio repetíveis de Conquistas «Completar N Tarefas consecutivas».
2. A API de criar/editar Tarefa agora suporta tipo de Tarefa e ajuste relativo de moedas/Pontos de Experiência.
3. A API de Conquista suporta definir moedas e ajuste relativo de moedas/Pontos de Experiência.
4. As APIs suportam ir a listas específicas de Conquistas e de Síntese.

**♻️ Otimização**

1. Otimizada a ordem dos registros de histórico de Item no Inventário ao abrir caixas.
2. As opções de filtro da página de estatísticas agora suportam memória.
3. As opções da página de filtros suportam a operação «Selecionar tudo».
4. Reforçada a lógica de interceptação de deduplicação na criação de Tarefas.
5. Operações complementadas na página de detalhes da Tarefa: congelar, ajustar prazo.
6. Suporte para exibir o ID da lista de Síntese.

**🐛 Correções de bugs**

1. Corrigido um problema em que a API de Tarefas anterior não podia criar/editar Tarefas Ebbinghaus.
2. Corrigido um problema em que a exibição da lista de Tarefas e o nome da lista na barra superior podiam ser inconsistentes ao abrir o App a partir do widget de lista de Tarefas.
3. Corrigido um problema em que o texto no cartão do modo simples podia não ser exibido por completo.

**v1.99.0 (2025/05/17)**

**✨ Novidades**

1. Adicionado suporte a tipos de Conquistas repetíveis
2. Ações de lembrete em notificações: concluir Tarefa, lembrar depois
3. Plano de fundo personalizado: opção para melhorar a legibilidade do texto
4. Adicionado suporte para ajustar estilos de recorte do ícone de Conquista
5. Adicionado suporte para ajustar datas-âncora de Tarefas mensais/anuais

**♻️ Otimização**

1. Otimizada a lógica de cálculo do progresso de desbloqueio de Conquistas
2. Melhoradas as interações de seleção de Itens
3. Ajustada a posição do botão de permissão de lembrete nas telas de criar/editar Tarefa
4. Otimizada a lógica de armazenamento de hora de lembrete relativa
5. Permitido congelar Tarefas não repetitivas e com repetição infinita

**🐛 Correções de bugs**

> Algumas correções serão implantadas gradualmente em [Versão estável para membros] e [Versão oficial]

1. Corrigido um problema em que editar Conquistas podia redefinir acidentalmente o progresso de condições de desbloqueio da API
2. Corrigido um problema em que Itens com estoque 0 ainda podiam ser comprados via API
3. Corrigido um problema em que listas excluídas podiam ser selecionadas na página de Item novo em certas condições
4. Corrigido um problema em que modelos de Tarefas não salvavam o status de Recompensa de moedas calculada automaticamente
5. Removidas animações de transição na página de detalhes para corrigir falhas de interação com toque longo
6. Corrigido um problema em que Tarefas congeladas apareciam na seleção de Tarefas Pomodoro
7. Corrigido um problema em que editar Tarefas por certos métodos redefinia incorretamente o status para incompleto
8. Corrigidos problemas de interação com pop-ups de Reflexões

**v1.98.5 (2025/05/01)**

**✨ Novidades**

1. Adicionado suporte para definir datas-âncora (p. ex., fim do mês) em Tarefas recorrentes mensais e anuais.
2. Interação de seleção múltipla aprimorada para Itens: modo de multiseleção por padrão e restauração de seleções anteriores ao selecionar novamente.

**♻️ Otimização**

1. Adicionado suporte para lembrar configurações de hora de lembrete relativa.
2. Otimizações menores de UI.

**🐛 Correções de bugs**

1. Corrigido um problema em que Itens ainda podiam ser comprados via API com estoque insuficiente na Loja.
2. Corrigido um problema em que modelos de Tarefas não restauravam Recompensas automáticas de moedas.
3. Corrigida a falha ocasional de toque longo em títulos de Tarefas.
4. Corrigido um problema em que Itens novos podiam selecionar listas excluídas em certas condições.
5. Corrigida a ausência do botão limpar no campo de hora de lembrete ao editar Tarefas.

**v1.98.4 (2025/04/14)**

**🐛 Correções de bugs**

1. Corrigido um problema em que a barra de progresso podia não atualizar prontamente após concluir subtarefas na página de detalhes da Tarefa.
2. Corrigido um problema em que editar uma Tarefa concluída podia reverter incorretamente seu status para «incompleta».
3. Corrigido um problema em que modificar o status de Tarefas vencidas podia afetar incorretamente a contagem alvo de conclusão.
4. Corrigido um problema em que a lógica de seleção de Tarefas Pomodoro exibia incorretamente Tarefas congeladas e listas arquivadas.

**v1.98.3 (2025/02/16)**

**♻️ Otimização**

1. Adicionado um aviso ao usar o método de lembrete por notificação padrão sem a permissão de «alarme exato».

**🐛 Correções de bugs**

1. Corrigido um problema em que a API «concluir Tarefa» não funcionava quando o campo UI era true.
2. Corrigido um problema em que a compra e uso de certas quantidades de Itens podiam não funcionar corretamente (p. ex., 10).
3. Corrigido um problema em que a página Reflexões podia ficar em «carregando» indefinidamente em certos cenários.

**v1.98.2 (2025/02/06)**

**🐛 Correções de bugs**

1. Corrigido um problema em que, ao usar um Item que deduz experiência, podia indicar experiência insuficiente mesmo quando havia suficiente.
2. Corrigido um problema em que editar um Item após copiá-lo podia resultar em efeitos de uso duplicados anormais.
3. Corrigido um problema em que chamar a API «adjust item» podia resultar em limites de compra anormais.
4. Corrigido um problema em que modificar certos registros Pomodoro podia resultar em redução anormal na contagem Pomodoro.

**v1.98.1 (2025/01/14)**

**🐛 Correções de bugs**

1. Tentativa de corrigir um problema com a autorização de login do Google, em que os dados de um número limitado de contas não podiam ser autorizados e analisados corretamente.

**v1.98.0 (2025/01/01)**

**✨ Novidades**

1. Integrados login do Google e autorização do Drive usando Credential Manager.
2. Suporte para selecionar Emoji como ícones.
3. Adicionada API ContentProvider Query: funcionalidade de Síntese.
4. Adicionada API ContentProvider Query: funcionalidade de registro Pomodoro.
5. Adicionada API ContentProvider Query: suporte para retornar vários Itens.
6. Adicionada API tomato (ajustar contagem Pomodoro).
7. Adicionada API export_backup (exportar backup).
8. Adicionada API purchase_item (comprar Item).
9. Adicionada API synthesize (acionar Síntese).
10. Adicionada API subtask (criar ou ajustar subtarefas).
11. Adicionada API subtask_operation (operar subtarefas, p. ex., concluir).
12. Adicionada API synthesis_formula (fórmula de Síntese).
13. Adicionada API edit_task (editar Tarefa).
14. Adicionada API category (criar ou ajustar lista).
15. Adicionada API history_operation (ajustar histórico).
16. Adicionada API AppSettingsScheme (ajustar algumas configurações do App).
17. Adicionada API achievement (criar ou editar Conquista).
18. Adicionada API skill (criar ou editar Atributo).
19. Adicionado suporte para exibir id e gid de subtarefas.
20. Adicionado suporte para exibir id de Síntese.
21. Adicionado suporte para consultar creditLimit.
22. A API ContentProvider suporta consultar subtarefas (id, gid).
23. API ContentProvider consulta Itens: adicionado retorno do campo «quantidade máxima comprável».
24. A API ContentProvider Shop suporta consultar Itens por lista de id especificada.
25. Otimizado o valor retornado ao consultar URL ContentProvider incorreta.
26. A interface de consulta suporta consultar uma única Conquista.

**♻️ Otimização**

1. Otimizada a ordenação personalizada padrão para Itens recém-adicionados.
2. Otimizada a ordenação personalizada padrão para Atributos recém-adicionados.
3. Adicionados parâmetros `purchase_limit`, `disable_use` e `effects` à API «add_item».
4. Adicionados parâmetros `background_alpha`, `items`, `start_time`, `auto_use_item`, `remind_time` e `pin` à API «add_task».
5. Adicionado suporte a mais frequências de Tarefas na API «add_task».
6. Adicionado suporte aos parâmetros `effects` e `purchase_limit` na API «item».
7. Adicionado suporte para encerrar operações em APIs anteriores (p. ex., entrada).
8. Adicionado suporte para especificar o parâmetro `signed` em marcadores numéricos.
9. Adicionados marcadores de número aleatório e decimal aleatório.

**v1.97.3 (2024/12/16)**

**✨ Novidades**

1. Passa a lembrar a última seleção do interruptor «Usar descrição da equipe como notas da Tarefa».

**♻️ Otimização**

1. Otimizado o desempenho relacionado ao efeito de uso de produtos.

**🐛 Correções de bugs**

1. Corrigida a falha de chamadas específicas de API. Ao usar uma função de callback específica para chamar a API de produto, a função de desempacotamento funciona normalmente, mas a operação interna de API para adicionar Itens não podia ser executada.

**1.97.2 (2024/12/08)**

**✨ Novidades**

1. Adicionada geração automática de Tarefas usando o mecanismo WorkManager do sistema, para evitar a ausência de geração de Tarefas quando widgets não são usados e o App não foi aberto por mais de um dia.
2. Aprimorado o tratamento de exceções da API, retornando um campo `success` unificado e repassando informações de exceção à interface do Content Provider.

**♻️ Otimização**

1. Otimizada a lógica padrão de geração de horários para melhorar a precisão da geração de horários mensais e anuais.
2. Otimizada a lógica de exclusão de arquivos de imagem não utilizados, adicionando uma etapa secundária de verificação no banco de dados para evitar exclusão acidental de arquivos.

**🐛 Correções de bugs**

1. Aprimoradas as mensagens de erro da API quando entidades não são encontradas.
2. Corrigidos problemas de concorrência no downloader integrado.
3. Corrigida a lógica de estatísticas Pomodoro em cenários que cruzam dias, unificando a atribuição de registros ao período de tempo do horário de término (antes, registros que cruzavam dias não podiam ser atribuídos corretamente ao período do dia).
4. Corrigidos problemas em que a continuidade de Tarefas e as contagens de conclusão por período podiam estar incorretas em certos cenários.

**1.97.1 (2024/11/20)**

**✨ Novidades**

1. Traduções atualizadas.
2. Suporte à exibição automática de várias Recompensas de Item nas notas.

**♻️ Otimização**

1. Otimizado o tratamento de requisições de rede para reduzir requisições HTTP desnecessárias e melhorar o desempenho.
2. Otimizada a exibição de Nível na página de status, melhorando a experiência visual e a eficiência na transmissão de informações.

**🐛 Correções de bugs**

1. Corrigida a cor do texto de contagem de subtarefas.
2. Corrigidos erros de cálculo de horário para Tarefas mensais e anuais, garantindo horários de acionamento precisos.
3. Corrigidos problemas de cálculo de horário para subtarefas mensais e anuais, garantindo que todas as subtarefas sejam agendadas corretamente.
4. Corrigido o problema em que o fundo da Tarefa não podia ser restaurado corretamente ao restaurar a partir de um modelo de Tarefa, garantindo que as configurações de fundo sejam aplicadas adequadamente.

**1.97.0 (2024/10/21)**

**♻️ Otimização**

1. Otimizado o efeito de exibição de cartões de Tarefa para Tarefas não iniciadas.
2. Resolvidos alguns problemas de desempenho.
3. Otimizada a página de detalhes da Tarefa, resolvendo o problema em que tocar no nome da Tarefa ocasionalmente não acionava interações.

**✨ Novidades**

1. Adicionados campos em formato JSON à transmissão de API para Tarefa vencida.

**🐛 Correções de bugs**

1. Corrigido um problema em que ativar o Material 3 causava falhas ao executar certas APIs relacionadas à UI.
2. Removidas algumas opções experimentais obsoletas, como o interruptor de Reflexões e o interruptor de novo Atributo.

**🎉1.97.0-rc (2024/09/11)**

**✨ Novidades**

**Principais atualizações**

- Esta atualização concentra-se principalmente em otimizações de desempenho e correções de bugs.
- Desempenho geral do App significativamente otimizado. Recuperar listas de Tarefas e realizar várias operações agora é mais fluido. A versão alvo da API Android foi atualizada para Android 14.

**Outros**

1. Quando não há moedas suficientes, o botão de compra de Item agora aparece desativado.
2. Adicionada a capacidade de buscar Conquistas por nome na lista de Conquistas 🔍.
3. Adicionado suporte a configurações de tamanho de fonte no App.
4. Otimizada a lógica aleatória de Mundo → Tarefas aleatórias, reduzindo a frequência com que o lote mais recente de Tarefas aparece, tornando-a mais aleatória.
5. Otimizada a lógica de agrupamento de notificações; notificações como desbloqueio de Atributos e Conquistas agora devem agrupar corretamente.
6. Estatísticas → Compartilhar agora suporta alternar a exibição de códigos QR.

**♻️ Otimizações**

1. Otimizada a lógica de acesso à rede.
2. Adicionado efeito de desfoque de fundo aos pop-ups.
3. Otimizados botões nas páginas Loja, Inventário e Vitrine, agora usando estilos oficiais de botão Material.
4. A API Content Provider para consultar registros de histórico de Tarefas agora retorna o horário de término da Tarefa.
5. A API Content Provider para consultar registros de histórico de Tarefas agora suporta filtragem por Group Id da Tarefa.
6. Atualizadas as versões de muitas dependências.
7. A API Goto agora suporta navegação para a página «Configurações padrão de novo Item».
8. Ao navegar para a página «Criar Conquista» via API Goto, o parâmetro `category_id` agora é obrigatório.
9. Adicionada orientação no App para efeitos de link de Tarefa, Tarefa contadora e Item na API.
10. Otimizada a lógica e as mensagens de erro para novos usuários verificarem atualizações.
11. Adicionadas mensagens de carregamento e erro para operações de exclusão de conta.
12. Otimizada a área clicável para concluir a Tarefa principal na página de detalhes da Tarefa.
13. Aprimorada a mensagem de erro ao importar backups, impedindo com mais rigor a importação de arquivos de backup inválidos.

**🐛 Correções de bugs**

1. Corrigido um problema em que, ao criar uma nova Tarefa, se a mensagem de erro de conteúdo vazio da Tarefa fosse acionada primeiro, a mensagem de erro não desaparecia automaticamente mesmo após inserir texto.
2. Corrigido um problema em que o botão de filtro não era exibido na página Estatísticas ao usar o modo de navegação inferior.
3. Corrigidos problemas de layout em certos dispositivos de tela pequena com proporções estreitas.
4. Corrigido um problema em que Recompensas de subtarefas podiam ser vinculadas anormalmente ao copiar Tarefas (este problema ocorria desde a versão 1.96.0).
5. Corrigidas mensagens de erro causadas por conexão anormal do Dropbox durante backup automático do Dropbox.
6. Tentativa de corrigir consumo de memória e falhas ao pré-visualizar imagens extremamente grandes.
7. Corrigido um problema em que, após comprar um Item e marcá-lo para uso, os dados do widget não eram atualizados corretamente se o uso falhasse.
8. Corrigido um problema em que editar uma Conquista alterava o horário de conclusão da Conquista e podia acionar incorretamente notificações de desbloqueio de Conquista.
9. Corrigido um problema em que, no modo de tela dividida em telas grandes, ao exibir a página de lista de Tarefas e a página de detalhes simultaneamente, concluir Tarefas, subtarefas ou atualizar contadores não sincronizava as duas páginas.
10. Corrigido um problema em que toque longo em Tarefas únicas vencidas na página de lista de Tarefas não permitia limpar a exibição do prazo.

**1.96.1(2024/07/11)**

**🐛 Correções de bugs**

1. Corrigido um problema em que a contagem exibida de Itens de Recompensa estava incorreta ao concluir subtarefas (as Recompensas reais não foram afetadas).

**🎉1.96.0 - beta01(2024/06/19)**

**✨ Novidades**

**Principais atualizações**

1. Ao concluir Tarefas ou desbloquear Conquistas, Itens agora podem ser usados diretamente para acionar efeitos de Item.
2. O limite de Itens usados de uma vez agora foi ampliado para 1000.
3. A compra de Caixas de saque ou Itens de Síntese agora também suporta uso direto (abrir/sintetizar).
4. Tarefas de equipe agora suportam publicar Reflexões nas Reflexões locais.
5. URL Schemes de terceiros nas notas de Tarefa agora são suportados para análise e navegação diretas.
6. A página Histórico agora suporta buscar registros históricos pelas notas da Tarefa.
7. Adicionado suporte para cronometrar Tarefas históricas.
8. A página Estatísticas agora suporta filtragem por categorias principais.
9. Refatorados os pop-ups de Recompensa e penalidade de experiência de Atributo: otimizada a lógica de limites de seleção de Atributo ao usar Itens e separados os pop-ups de redução de experiência de Atributo por vencimento.

**♻️ Otimizações**

1. O efeito de UI para seleção única ao escolher Itens agora é consistente com a multiseleção.
2. Otimizada a velocidade de carregamento da lista de Tarefas.
3. Ao adicionar ou editar Tarefas, o horário de vencimento não precisa mais ser posterior ao horário atual, oferecendo flexibilidade para criar registros históricos.
4. Se a exibição de IDs de dados estiver ativada, o pop-up de Reflexões agora também exibe o ID correspondente.
5. Otimizados problemas de desempenho relacionados ao pop-up de processamento de vencimento.
6. Unificada a ordem dos botões para cronômetro regressivo e estados de pausa.
7. A interação para excluir publicações na página Módulo Mundo → Perfil pessoal agora é mais intuitiva.
8. Otimizados efeitos de carregamento nas páginas Reflexões e Conquistas.

**🐛 Correções de bugs**

-

**🎉1.95.0-rc01 (2024/05/24)**

**✨ Novidades**

**Principais atualizações**

1. Suporte a exibição em tela dividida no App em dispositivos de tela grande, como tablets e telas dobráveis

**♻️ Otimizações**

1. Widgets de Loja e Inventário agora suportam efeitos de recorte consistentes com o App para imagens
2. Na página de estatísticas, quando apenas um dia é selecionado, gráficos de linha agora são suportados

**🐛 Correções de bugs**

1. Corrigido um problema em que o tipo de Tarefa era exibido incorretamente ao editar Tarefas de API
2. Corrigido um problema com estatísticas anormais de conclusão, abandono e vencimento de Tarefas na página de estatísticas

**1.94.3 (2024/05/10)**

**♻️ Otimizações**

1. Widgets agora tentam atualizar o tema para se adaptar quando o modo escuro do sistema muda
2. Quando o módulo «Mundo» está oculto, a notificação de ponto vermelho para Conquistas do sistema não conta mais dados relacionados ao módulo «Mundo»

**🐛 Correções de bugs**

1. Corrigida uma falha de baixa probabilidade ao selecionar vários Itens
2. Corrigida uma falha de baixa probabilidade relacionada a janelas pop-up
3. Corrigido um problema em que o widget de Inventário podia não atualizar ao chamar a API de modificação de Item
4. Corrigido um problema em que o widget de Inventário podia usar Itens «inutilizáveis»

**1.94.2 (2024/04/26)**

**🐛 Correções de bugs**

1. Corrigido um problema com cálculos anormais da contagem atual de Tarefas (que causava progresso impreciso para Tarefas com contagem alvo de repetições definida)
   - Esta correção reverte uma otimização anterior relacionada ao desempenho de desfazer Tarefas, aguardando uma solução mais adequada no futuro

**1.94.1 (2024/04/22)**

**🐛 Correções de bugs**

1. Corrigido um problema em que a contagem de Pomodoros era calculada com um a menos do que o real ao usar cronômetro, adicionar tempo via API ou adicionar registros de tempo manualmente.
2. Corrigido um glitch em que a barra de seleção podia piscar e desaparecer após selecionar Itens nas páginas Loja/Inventário e rolar.

**🎉1.94.0 (2024/04/22)**

**Principais atualizações**

1. Suporte a várias Recompensas de Item
2. Widgets de Inventário

**Temas de UI**

1. Cores personalizadas (texto de Tarefa, Item) agora incluem mais valores predefinidos
2. Adaptado ao recurso de ícone adaptativo monocromático do Android 14
3. Adicionadas muitas adaptações de idioma (versão Google Play)

**Conquistas**

1. Se houver Conquistas com Recompensas não reclamadas, um pequeno ponto vermelho agora será exibido na lista de Conquistas.

**Tarefas**

1. Subtarefas de Tarefas com penalidade agora executam a lógica de penalidade corretamente
2. Adicionado «Gerenciamento inteligente de fuso horário»; se você trabalha em fusos horários diferentes, o LifeUp também suporta detecção automática de mudanças de fuso horário e ajustes globais de horário
3. A base estatística na página de detalhes agora lembra a última seleção, e otimizamos alguns valores padrão em certos cenários
4. Otimizado o tratamento de tolerância de dias consecutivos de conclusão de Tarefas na página «Minha», agora se você esquecer de concluir uma Tarefa um dia, recuperar ainda pode continuar a sequência

**Atributos**

1. Suporte à exclusão de registros de experiência
2. Suporte à redefinição da experiência de um Atributo individual

**Widgets**

1. Agora, tocar no espaço em branco nos widgets de Loja ou Inventário entra diretamente na lista apontada pelo widget, em vez da última lista
2. Widgets de Tarefa agora exibem o progresso de Tarefas contadoras

**API**

1. Adicionada API para editar registros Pomodoro
2. A API de conclusão de Tarefas agora também trata corretamente Tarefas com penalidade
3. A API de conclusão de Tarefas agora também suporta processamento de Tarefas contadoras (adiciona parâmetro `count`)
4. A API de conclusão de Tarefas agora suporta parâmetro de coeficiente de Recompensa
5. A API de ajuste de Itens agora suporta alteração do id da lista de Item
6. APIs de criação e ajuste de Itens suportam parâmetro de critério de ordenação
7. A API Jump agora suporta salto para o pop-up de uso de Item
8. Unificadas algumas definições de parâmetros, como `itemId` → `item_id`
9. Adicionadas notificações de transmissão para iniciar, pausar e encerrar cronômetro
10. O `title_color_string` da API de ajuste de Itens agora suporta passar string vazia para restaurar o valor padrão
11. A transmissão de conclusão de Tarefas agora inclui id da lista
12. Abrir caixas e fabricar agora também acionam a transmissão de uso de Item

**♻️ Otimizações**

1. Adicionar ou editar Tarefas agora inclui aviso se nenhum Atributo for selecionado e experiência for inserida
2. Otimizados registros de nova tentativa de upload
3. Otimizada a exibição do título e restrições de entrada na página de Nível personalizado
4. Otimizados desempenho e problemas de temporização ao desfazer Tarefas repetidas extensivamente
5. Refatorados o pop-up de uso de Item, lógica da interface de calendário etc.
6. Otimizada a lógica relacionada a lembretes de Tarefa, garantindo que lembretes de dados excluídos ou anteriores não sejam emitidos novamente
7. Otimizado texto de espera na interface de backup
8. Imagens selecionadas na página de Atributo personalizado agora também são adicionadas ao histórico de seleção
9. Editar registros Pomodoro agora tenta corrigir (aumentar ou diminuir) o número correto de Pomodoros

**🐛 Correções de bugs**

1. Corrigida uma Conquista do sistema relacionada a estatísticas e backups que não era acionada normalmente após reestruturação
2. Corrigidos conflitos potenciais entre widgets de API random e toast com o toast padrão
3. Corrigido o detalhe da Tarefa que não atualizava em alguns cenários ao entrar a partir de um widget
4. Corrigido o potencial de erros em aberturas múltiplas de caixas em algumas situações especiais (usando antecipadamente o estoque de Item)
5. Corrigido o problema de não exibir subtarefas na página de detalhes após editar uma Tarefa sem subtarefas e adicionar novas
6. Corrigidos alguns casos especiais em que editar Recompensas de moedas não era possível
7. Corrigidos alguns casos em que resgatar Itens de equipe podia não funcionar
8. Corrigidas anomalias de estilo MD2 em alguns pop-ups inferiores
9. Corrigidos valores potencialmente incorretos de tempo adicional em temporizadores Pomodoro
10. Corrigido o problema em que a barra de cor no widget de alteração de experiência podia não exibir
11. Corrigidas algumas Tarefas que não exibiam corretamente no calendário em andamento
12. Corrigidos alguns problemas de carregamento de lista nas páginas histórico e Reflexões
13. Corrigido um problema em que chamar a API de conclusão de Tarefa duas vezes em rápida sucessão não permitia duas conclusões consecutivas

**1.93.3 (2024/01/09)**

**✨ Novidades**

1. Adicionada a API [Reflexões].

**♻️ Otimização**

1. O cálculo de indicadores de valor médio na página de estatísticas agora exclui datas futuras.
2. Após ocultar a lista de Conquistas do sistema, não há mais alertas de desbloqueio de Conquistas do sistema.
3. Atualizada a API `goto` para não suportar mais pop-ups de compra de Itens «incobráveis».
4. Otimizada a edição de Tarefas para resolver o problema em que a entrada de contagem alvo de repetição ficava oculta.

**🐛 Correções de bugs**

1. Corrigido o efeito de UI edge-to-edge na página de Atributo personalizado.
2. Corrigido um problema em que a penalidade não era revogada se uma Tarefa fosse definida como abandonada e depois concluída na página histórico/calendário.
3. Corrigido o problema de estilo de exibição do pop-up inferior e da barra de navegação do sistema inferior no modo Material2.
4. Corrigida a cor incorreta da borda da caixa de entrada de item a fazer no modo noturno.
5. Corrigido um problema de exibição que podia ocorrer após rotação de tela ao usar o modo de navegação do sistema com três botões.

**1.93.3 (2023/12/02)**

**♻️ Otimização**

1. Adição unificada de parâmetro debug às APIs para facilitar depuração

**🐛 Correções de bugs**

1. Corrigido o problema em que selecionar «Ignorar pop-up de lembrete» não era efetivo
2. Corrigido o problema com edição de Reflexões criadas diretamente na página Reflexões
3. Corrigido o problema em que upload de fotos dinâmicas de equipe permitia selecionar até 9 imagens, enquanto o limite real deveria ser 3
4. Corrigido o problema em que a API use_item não acionava efeitos de contagem regressiva ou URL quando ui era definido como false
5. Corrigido o problema em que usar Itens no widget de Loja podia acionar o efeito duas vezes

**1.93.1 -> 1.93.2 (2023/11/18)**

**♻️ Otimização**

1. Otimizada a lógica de atualizações do banco de dados para evitar atrasos nos processos de upgrade do banco de dados
2. Otimizado o valor padrão de «Horário de início» ao editar Tarefas

**🐛 Correções de bugs**

1. Corrigido um problema em que editar APIs de produto levava à perda de efeitos de uso de produto
2. Corrigido o problema em que Tarefas vencidas e abandonadas definidas como concluídas não restauravam Recompensas
3. Corrigido um problema com ordenação personalizada de Tarefas que não atendia às expectativas
4. Corrigidos problemas de exibição e ordenação relacionados a Tarefas únicas vencidas
5. Corrigido um problema de exceção SQL ao filtrar a página de histórico
6. Corrigido um problema no modo simplificado em que tocar novamente no título da Tarefa não tinha resposta
7. Corrigido um problema em que renomear modelos de Tarefa não surtia efeito

**🎉1.93.0 (2023/10/24)**

**✨ Novidades**

**Tema de UI**

1. Adaptação completa ao Material Design 3.
2. Suporte à personalização de cores de tema Material Design 3, incluindo cores personalizadas, cores do papel de parede e cores de imagens.
3. Melhorados alguns efeitos de animação, como pop-ups.
4. Otimizados efeitos de adaptação edge-to-edge (imersivo).

**Tarefas**

1. Suporte a modelos de Tarefa.
2. Estatísticas na página de detalhes suportam alternância com base em critérios de tempo e otimizam opções padrão.
3. A página de histórico suporta busca por nomes de Tarefa e ajusta a UI e interações relacionadas.

**Conquistas**

1. Suporte a Conquistas secretas.
2. Ao adicionar Conquistas, suporte a «Continuar adicionando próxima Conquista».

**Atributos**

1. Suporte a ocultar Atributos.

**Temporizador Pomodoro**

1. Suporte à edição de registros de tempo.
2. Na página Pomodoro, suporte à conclusão de Tarefa (toque longo na Tarefa selecionada no modo pausa).

**Reflexões**

1. Suporte a adicionar Reflexões diretamente na página Reflexões.

**API**

1. Adicionada a API «use_item».
2. Adicionada a API «random».
3. Adicionada a API «edit_exp».
4. A API «item» agora suporta ajuste de parâmetros como «action_text», «disable_use» e «title_color_string».
5. A API «shop_settings» suporta o parâmetro «silent».
6. Suporte ao placeholder «time». Agora você pode definir Tarefas com datas como «vence amanhã» ou «vence no próximo mês» sem ferramentas de automação.

**♻️ Otimização**

1. Adicionados prefixos a alguns locais que exibem IDs de dados.
2. Otimizada a exibição de atividades de equipe.
3. Tentativa de resolver o problema em que algumas notificações Toast eram longas demais para exibir completamente.
4. Aprimorada a lógica de conclusão de widget em equipes, garantindo consistência com o comportamento no App.
5. Página Estatísticas: após selecionar um intervalo de tempo «Personalizado», clicar em «Personalizado» novamente agora aciona nova seleção de datas.
6. Garantida compatibilidade com Harmony OS 4 para notificações de barra de progresso exibirem botões de ação.
7. Aprimorada a lógica de interação de solicitações de notificação.
8. Resolvido o problema em que o método de entrada podia obstruir a entrada de «Contagem de repetições».
9. Agora, ao criar Tarefas, a escolha do usuário de horários de início não específicos (como automático ou vence hoje) é registrada. Ao editar, essas opções são restauradas, em vez de horários específicos, para evitar discrepâncias nos horários editados.
10. Ao criar Tarefas, se avisos inesperados sobre duplicatas ocorrerem, eles agora também serão exibidos no pop-up «Verificar duplicatas».
11. Adicionado suporte ao idioma indonésio.
12. Traduções atualizadas.

**🐛 Correções de bugs**

1. Corrigido o problema em que, em certos casos, o módulo Mundo podia ficar preso em carregamento (girando indefinidamente).
2. Corrigido o problema em que, em certos casos, Loja/Inventário podia continuar exibindo carregamento (girando indefinidamente).
3. Corrigidos problemas que podiam ocorrer ao chamar APIs com conteúdo de UI via Content Provider.
4. Corrigidos problemas de ordenação de Tarefas que não atendiam às expectativas.
5. Corrigido o problema em que dados na página de estatísticas estavam incorretos após selecionar um intervalo de tempo «Personalizado».
6. Corrigido o problema em que pop-ups de solicitação de notificação não suportavam rolagem.
7. Corrigido o problema em que, em certos casos, a busca do módulo Mundo exibia todo o conteúdo.
8. Corrigido o problema em que a opção «Mostrar concluídas» também exibia Tarefas congeladas.
9. Corrigidos problemas com cálculo de valores médios na página de estatísticas.

**1.92.2 (2023/08/29)**

**✨ Novidades**

1. Gráfico de estatísticas de passos (<https://github.com/Ayagikei/LifeUp/issues/85>)

**♻️ Otimização**

1. A nova página de equipe agora adiciona lembrete da contagem atual de palavras e limite superior de palavras

**🐛 Correções de bugs**

1. Corrigido o problema em que o «LifeUp» pode criar repetidamente contas de lembrete de calendário sob certas condições especiais
2. Corrigido o problema em que o botão de menu da equipe em edição não era exibido corretamente
3. Corrigido o problema em que o Pomodoro pode não acionar o lembrete de vibração no modo de início automático de cronometragem
4. Corrigido o problema em que a notificação Pomodoro pode exibir incorretamente os Itens em Foco quando nenhum Item em Foco foi selecionado

**1.92.1-rc02 - 1.92.1 (2023/08/18)**

**♻️ Otimização**

1. A duração na página de status e na página de estatísticas agora pode ser exibida no formato «XX dias XX horas XX minutos».

**🐛 Correções de bugs**

1. Corrigido o problema em que a interação para fechar o pop-up de permissão de notificação não era a esperada no Android 12 e versões posteriores.
2. Corrigido o problema em que o gráfico de pizza de Atributo podia exibir uma cor transparente, fazendo-o não aparecer.

**1.92.1-rc01 (2023/08/13)**

> Data de lançamento do beta fechado de assinatura

**✨ Novidades**

1. A nova versão de estatísticas integra os cartões estatísticos da versão antiga, agora unificados em uma única página e adaptados ao modo de barra de navegação inferior.

2. Atualizado o mecanismo de atualização no App e a função de lembrete.

   Agora suporta três canais de atualização: Lançamento estável, Versão estável do beta fechado de assinatura e Versão experimental do beta fechado de assinatura, para concentrar atualizações subsequentes em membros do beta fechado.

3. TargetSdkVersion agora adaptado para Android 13 e solicitações dinâmicas de permissão de notificação.

4. Redesenhada a página de edição de perfil.

5. Versão GP otimizou o processo e instruções de seleção de login/modo offline.

**♻️ Otimização**

1. Manutenção e atualizações de dependências técnicas relevantes.
2. Melhorada adaptação WSA e instruções de login.
3. Quando o backup falha, agora exibe um pop-up explicando o motivo da falha, evitando exibição incompleta de mensagens toast.

**🐛 Correções de bugs**

1. Corrigida possível falha de overflow de cálculo na página de registro de histórico de moedas.
2. Corrigida a possibilidade de problemas de menu na página de detalhes da equipe que não alinhavam com as permissões esperadas.
3. Tentativa de corrigir o problema de desvio de horário no cronômetro regressivo.
4. Corrigida a interrupção do processo de conclusão de Tarefa e o desaparecimento do pop-up de escrita de Reflexão causados por rotação de tela.

**1.92.0-rc02 (2023/07/16)**

**🐛 Correções**

1. Corrigido o problema em que o widget de Loja pode não funcionar ao saltar para outros apps (executando API)
2. Corrigida a anormalidade ocasional ao alternar listas no widget de Loja
3. Corrigido o problema em que o widget de Loja não oculta Itens esgotados ou não compráveis de acordo com as configurações do App
4. Corrigido o problema em que o widget de Loja pode não responder ao tocar em um Item
5. Corrigidas algumas falhas raras

**🎉1.92.0-rc01 (2023/07/11)**

**✨ Novidades**

1. Estatísticas 2.0
2. Cartão de compartilhamento

**♻️ Otimização**

1. Agora você pode definir preços para Itens «não compráveis» e usá-los em cenários como devoluções
2. Quando você desativa «Definir penalidade de Tarefa separadamente» nas configurações, o botão de penalidade não será mais exibido
3. Otimizada a UI de subtarefas nos detalhes da equipe
4. Otimizada a UI de impressões

**🐛 Correções**

1. Corrigido o problema em que, quando o estilo de recorte de Atributo é alterado para «retângulo arredondado», o ícone de edição pode exibir o ícone antigo por muito tempo

**1.91.3-rc04 (2023/06/07)**

**♻️ Otimização**

1. A API para saltar para detalhes da Tarefa agora suporta parâmetros task_gid e task_name
2. O Content Provider suporta a URL do ícone remoto do produto
   - Para corrigir no futuro o problema em que alguns ícones de produto não podem ser exibidos corretamente na área de trabalho

**🐛 Correções de bugs**

1. Corrigido o problema em que o widget de lista da Loja não exibia as moedas atuais corretamente

**1.91.3 (2023/06/03)**

**✨ Novidades**

1. Widget de lista de Itens da Loja (versão grande e pequena)
2. Widget de alteração de hoje para Pontos de Experiência
3. Adicionada API para saltar para detalhes da Tarefa
4. Reflexões: agora suporta ordenação em ordem positiva de tempo e adiciona exibição de ano

**♻️ Otimização**

1. Agora é suportado definir preços para Itens «não compráveis» e usá-los em cenários como devoluções
2. Quando «penalidade de Tarefa definida independentemente» está desativada nas configurações, o botão de penalidade não será mais exibido
3. Otimizada a UI de exibição de subtarefas nos detalhes da equipe
4. Otimizada a UI de exibição de impressões

**🐛 Correções de bugs**

1. Corrigido o problema em que, se você limpar as palavras motivacionais ao editar uma Tarefa, não podia clicar em «Confirmar» para fechar o pop-up
2. Corrigido o problema em que a Tarefa congelada não podia ser buscada usando a API
3. Corrigido o problema em que Loja e Inventário não podiam ocultar a lista padrão

**1.91.2 (2023/05/09)**

**✨ Novidades**

1. Listas de Loja e Inventário suportam ocultação definida separadamente
2. A API `Goto` agora suporta salto para subpáginas da página principal (como Tarefas, status, Loja, Inventário)
3. As estatísticas de moedas nas estatísticas agora suportam exclusão de consumo de compra

**♻️ Otimizações**

1. Ao criar uma nova Conquista ou editar uma Conquista bloqueada, o botão «Redefinir» não será mais exibido
2. O widget de moedas agora suporta toque para saltar para a Loja
3. Quando o efeito sonoro falha ao reproduzir, uma mensagem de erro clara será exibida

**🐛 Correções de bugs**

1. Ao adicionar registros Pomodoro, se o horário de término for definido diretamente, a duração esperada pode não ser atendida
2. Após reparar o rótulo de filtro de Tarefa, o problema do método de entrada aparece
3. Corrigido o problema em que os juros do ATM não suportavam definir valor absoluto via API
4. Corrigido o problema anormal de carregamento de dados da página de histórico
5. Corrigido o problema em que, quando o widget conclui a Tarefa contadora, clicar em «Cancelar» fica preso na página transparente
6. Corrigido o problema em que a página de estatísticas não podia ser atualizada automaticamente no modo de barra de navegação inferior
7. Corrigido o problema em que a coleta de Tarefas de equipe era anormal quando estava no fuso horário GMT +-x.5

**1.91.1 (2023/03/27)**

**✨ Novidades**

1. Adicionada opção «Gerenciamento de notificações» em Configurações.
2. A API Nova Tarefa agora suporta definir fundos.
3. Adicionados eventos de transmissão de API relacionados a contagens regressivas de produto ([New API · Issue #64 · Ayagikei/LifeUp (github.com)](https://github.com/Ayagikei/LifeUp/issues/64)).

**♻️ Otimizações**

1. O pop-up de feedback não fechará mais automaticamente ao clicar fora.
2. Widgets não forçarão mais a conclusão de Tarefas que não foram iniciadas.
3. A API de conclusão de Tarefa não forçará mais a conclusão de Tarefas não iniciadas quando o parâmetro «ui» for true.
4. Quando a configuração de coeficientes de penalidade de Tarefa individual estiver desativada, os coeficientes de penalidade de Tarefa definidos anteriormente serão ignorados e o valor global será usado.
5. Remove automaticamente espaços em branco de URLs inseridas por usuários.
6. Quando a opção «Ocultar Itens não compráveis» estiver ativada e um Item não comprável for criado, um aviso será exibido.
7. Quando o usuário ativa Níveis personalizados mas não define nenhum Nível, agora será redefinido para a tabela de Níveis integrada.
8. Melhoradas imagens de pré-visualização de widgets.
9. Entradas de passos agora são restritas a números. (<https://github.com/Ayagikei/LifeUp/issues/75>)
10. Ao usar o navegador integrado para links de produto, o prefixo «https» não é mais necessário.
11. Adicionadas instruções de «Configuração de compatibilidade» para o recurso de contagem regressiva de produto.

**🐛 Correções de bugs**

1. Corrigido comportamento inesperado de toque ao selecionar produtos na Loja e Inventário.
2. Corrigido o problema em que Tarefas não repetitivas não podiam ter prazo definido ao adicioná-las via API.
3. Corrigido o problema em que imagens de Atributo personalizado podiam não atualizar em certos dispositivos.
4. Corrigido o problema em que efeitos sonoros personalizados podiam causar falha no App. Um novo método foi implementado, que deve tornar efeitos sonoros em segundo plano mais estáveis e usar menos memória, mas a velocidade de reprodução pode ser mais lenta.
5. Corrigido o problema em que, em dispositivos Android 12 e superiores sem a configuração «Ignorar otimização de bateria», ativar o temporizador Pomodoro automático ou intervalo pode causar falha em segundo plano.
6. Corrigido o problema em que efeitos sonoros de contagem regressiva de produto eram afetados pela configuração de efeitos sonoros Pomodoro.
7. Corrigido o problema em que erros de cálculo de ponto flutuante ocorriam ao definir taxas de juros diários do ATM na API.
8. Corrigido o problema em que algumas imagens não podiam ser carregadas no Android 6.
9. Corrigido o problema em que, ao restaurar dados do App de backup de versão superior para versão inferior, avisos de erro não eram exibidos corretamente.
10. Corrigido o problema em que alguns dispositivos apresentavam sobreposição de layout na página Pomodoro.

**🎉1.91.0 (2023/02/13-2023/02/26)**

**✨ Novidades**

1. Suporte a gradientes de Nível personalizado.
2. Adicionado lote inicial de widgets:
   - Moedas (pequeno, grande, alvo)
   - Atributos (pequeno, grande)
3. Suporte a consultar a maioria dos detalhes de dados no LifeUp via API Content Provider, incluindo:
   - Oferecer uma nova versão do «LifeUp Cloud».
   - Fornecer uma versão inicial rudimentar da versão desktop (Windows, Linux, macOS) para uso em rede local.
4. Suporte à exclusão de seleção múltipla para registros do temporizador Pomodoro.
5. Suporte a definir início automático de descanso e trabalho para o relógio Pomodoro.
6. Melhorias de API e campos adicionados, incluindo:
   - Depósitos e saques no ATM.
   - Definir se a compra de produtos é proibida.
   - Definir cores de rótulo para Tarefas.
   - Definir saldo do ATM diretamente.
   - Consulta simples de detalhes de produto especificado.
   - Adicionar um terceiro botão e opção de operação à interface pop-up.

**♻️ Otimizações**

1. Melhorada velocidade de consulta, processamento e desempenho ao lidar com grandes volumes de dados.
2. Corrigidas margens incorretas para ícones adaptativos.
3. Otimizado o efeito de exibição dos registros do temporizador Pomodoro.
4. Melhorada a interação ao restaurar backup.
5. Adicionada exibição de UI para obter licença de assinatura via Google Play.
6. Exibido aviso para desativar o recurso de importação com um clique se o arquivo de backup selecionado não for do LifeUp ao importar diretamente do sistema de arquivos.
7. Fecha o método de entrada automaticamente ao buscar produtos no pop-up de seleção de produto.
8. Alterações de comportamento da API, incluindo:
   - API pop-up confirm_dialog. Se certo texto ou operação de botão não for fornecido, o botão não será exibido. Isso oferece maior flexibilidade no controle de pop-ups; por exemplo, você pode configurar um pop-up apenas de texto sem botões para exibir texto e linguagem motivacional.
   - API de penalidade. Em versões anteriores, podia deduzir no máximo 100 Itens; agora o limite foi estendido para 9 dígitos.

**🐛 Correções de bugs**

1. Corrigido o problema em que a página do temporizador Pomodoro exibia «carregando» no final em certas circunstâncias.
2. Corrigidas falhas causadas por certas bibliotecas de terceiros.
3. Corrigido o problema em que o App falhava ao colocar o relógio Pomodoro na barra de navegação inferior devido a um pop-up de aviso.
4. Corrigida a exibição anormal de valores de Atributo ao navegar perfis de outros usuários.
5. Corrigido o problema em que eventos de API e notificações de redução de Nível de Atributo não eram enviados corretamente.
6. Corrigidos alguns problemas de interação com páginas de edição por toque longo.
7. Corrigidas algumas margens anormais nas páginas de gerenciamento de imagem e Síntese.
8. Corrigidas algumas janelas pop-up que não eram roláveis, resultando em uso anormal no modo paisagem.

**✨Special Release: LifeUp Cloud v1.1.1 (2023/02/13)**

1. Suporte a operações de leitura e autorização de informações do Content Provider.
2. Durante a inicialização do serviço, solicita um wake lock para permitir resposta mesmo com a tela bloqueada.
3. Adicionada uma série de interfaces para Content Providers.

**✨Special Release: LifeUp Desktop v1.0.1 (2023/02/13)**

Lançamento inicial, projetado para uso em conjunto com o «LifeUp Cloud» e o App móvel.

Suporta as seguintes operações:

- Consultar Tarefas, listas, produtos, Conquistas, listas de Reflexões.
- Comprar produtos, concluir Tarefas.
- Suporte ao uso do navegador de imagens desktop para visualizar imagens ampliadas de Reflexões.

**1.90.7 (2022/11/07)**

**✨ Novidades**

1. Adicionado: tradução para vietnamita e assinatura do tradutor (versão Google)
2. Adicionado: método de seleção de imagem «Pular recorte», adequado para selecionar animações gif (função de membro)
3. Adicionado: API de exclusão de Tarefa
4. Adicionado: suporte para definir abandono do efeito sonoro da Tarefa
5. Adicionado: operação de quantidade MAX na Síntese simples
6. Suporte a bloquear novamente Conquistas desbloqueadas
7. A «API Adicionar produto» suporta especificar o id da lista

**♻️ Otimizações**

1. Melhorada a descrição de exclusão de histórico
2. O limite de Pontos de Experiência foi alterado de (3/4 casas) para (4/5 casas)
3. Adicionada exibição do coeficiente de penalidade na página de detalhes
4. Melhorado globalmente o design de interação da caixa de seleção de data e hora
5. A janela pop-up de detalhes da Conquista agora diferencia a cor do ícone conforme as condições estejam concluídas ou não
6. Alterado o ícone de atalho do Pomodoro
7. Ao criar um Item a partir de uma lista inteligente, se a lista selecionável for 0 ou 1, seleciona automaticamente
8. O modo desenvolvedor exibe o ID da lista de Itens
9. Limitado o comprimento de entrada de alguns campos comuns para evitar falhas

**🐛 Correções de bugs**

1. Corrigido o problema em que o cálculo de Recompensa ao alterar o registro de histórico do Item era anormal em alguns cenários
2. Corrigido o problema em que o interruptor «Mostrar arquivados» não correspondia à exibição em alguns cenários
3. Melhorada a lógica de carregamento de dados do widget (pode corrigir alguns problemas anormais)
4. Reparada a lógica de cálculo automático ao adicionar manualmente registros de temporização; agora basta preencher qualquer Item
5. Corrigido o problema anormal de atualização da página de registros de temporização Pomodoro
6. Corrigido o problema em que subtarefas não podiam limpar Recompensas de produto
7. Corrigido o problema em que, após selecionar todos os Itens, reselecionar alguns Itens não surtia efeito
8. Otimizada a memória necessária para imagens de pré-visualização
9. A atualização do widget agora é acionada após ajustar a ordem da lista
10. Otimizado o problema em que alguns métodos de backup ficavam presos na interface

**1.90.6 (2022/10/21)**

**✨ Novidades**

1. Adicionada API para definir o número de passos em uma data especificada
2. Adicionada API para consultar o status de Atributos especificados (valor de Pontos de Experiência, Nível)
3. Suporte à importação direta de dados de backup pelo gerenciador de arquivos
4. APIs relacionadas a Itens de Recompensa não são mais limitadas a 99

**♻️ Otimizações**

1. Otimizado o efeito de animação de transição ao entrar na página de detalhes do evento
2. Otimizada a página de edição de Itens, aumentado o efeito de UI ao ativar penalidade e melhorado o guia
3. Alterados os ícones de operação na página de temporização
4. Na janela pop-up de compra, adicionados avisos e instruções para Itens com own_number negativo
5. Otimizado o efeito de barra de status imersiva da página inicial
6. Adicionado lembrete de configuração de compatibilidade na página Pomodoro
7. Melhorada a velocidade de exportação e restauração de arquivos de backup
8. Instruções para a configuração de stock_number
9. Removida temporariamente a configuração [Quando o estoque do produto for 0, a Recompensa de Tarefa correspondente será removida automaticamente].
10. Otimizado o mecanismo de verificação de licença com versão de teste gratuita
11. Quando uma Tarefa «Fixada» está selecionada, a ação agora é exibida como «Desafixar»
12. Ao alternar para temporização positiva, o aviso *experimental* não aparece mais toda vez

**🐛 Correções de bugs**

1. Corrigido o limite anormal do sistema em algumas páginas ou com tablets
2. Corrigido um problema em que dados incorretos eram exibidos ao entrar no Inventário pela primeira vez em alguns casos
3. Corrigido um problema em que os dados não podiam ser recuperados devido a danos internos (como imagem corrompida) ao restaurar arquivos de backup danificados
4. Corrigido um problema em que o botão «Comprar» era exibido inesperadamente após toque longo em produto esgotado
5. Corrigido um problema em que a introdução de Atributos da nova página de equipe era a versão antiga

**1.90.5 (2022/09/22)**

**♻️ Otimizações**

1. Adaptação a alguns dispositivos com conversão webp anormal (a imagem recortada pode ficar maior que a original nesses dispositivos). Após selecionar uma imagem, determina o tamanho e realiza compressão secundária.
2. Melhorada a descrição de repetições alvo na página de detalhes
3. Suporte ao uso do mesmo produto para acumular tempo durante a contagem regressiva
4. Adicionadas mais Tarefas guia para iniciantes
5. Atualização de traduções

**🐛 Correções de bugs**

1. Corrigido o problema anormal de UI da página de composição
2. Corrigidas várias falhas conhecidas
3. Melhorado o problema em que a contagem regressiva de produtos podia ser interrompida anormalmente e acumular tempo em contagens regressivas longas
4. Corrigida a exceção de UI da janela pop-up de entrada de Reflexões quando o widget conclui a Tarefa

**1.90.4 (2022/09/15)**

1. Corrigido o problema anormal quando o widget conclui a Tarefa (pode causar aparição de página transparente e impossibilitar continuar a operação)
2. Desabilitada a capacidade do widget de selecionar imagens de Reflexões

**1.90.3 (2022/09/14)**

1. Corrigido o problema de foco ao ordenar subtarefas
2. Melhorada a cor de Atributos em Tarefas congeladas/não iniciadas
3. Adicionada transmissão de evento de Tarefas abandonadas
4. Corrigida a cor do texto de probabilidade
5. Melhoradas as Tarefas iniciais (Tarefas predefinidas)
6. Corrigido o problema em que o diálogo de importação de Itens podia selecionar a lista «Todas» por padrão
7. Corrigidos problemas de agrupamento de Itens da Loja
8. Agora é exibido um aviso ao definir horário incomum (horário não corresponde à frequência de repetição)
9. Melhoradas as regras de cálculo de Tarefas no calendário, que agora devem prever com precisão os prazos de Tarefas futuras
10. Corrigido um problema em que a conclusão do calendário podia ser calculada para Tarefas congeladas
11. Melhoradas as configurações padrão de horário de início ao editar Tarefas
12. Melhorado o mecanismo de detecção de licença
13. Otimizado o processamento da contagem regressiva de Itens. Execução repetida é proibida para reduzir o problema de acúmulo de tempo fora do esperado
14. Corrigido problema edge-to-edge ao usar teclas virtuais em algumas páginas
15. Corrigido um problema em que não era possível selecionar imagem de Reflexão quando o widget desktop concluía uma Tarefa

**1.90.2 (2022/08/31)**

**✨ Novidades**

1. Adicionados eventos de transmissão.
   Agora você pode usar Tasker/MacroDroid para receber eventos como uso de Itens, conclusão de Tarefas etc. e acionar ações do Tasker.

   Por exemplo: se o Item for usado, acionará a troca de papéis de parede aleatórios.
   Em teoria, se quiser, pode implementar funções como bloqueio de aplicativos e cenários de interação com jogos.

2. Novas APIs:

- Abandonar Tarefas
- Congelar Tarefas
- Descongelar Tarefas
- Interface vazia
- Consulta

3. Adicionado valor de retorno para as APIs de adicionar novo Item e Tarefa
4. Ao importar Itens do mercado, agora é possível selecionar a lista de destino
5. Adaptação à cor secundária do Material 3
6. Atualização de traduções de idioma, adicionado suporte ao coreano

**♻️ Otimizações**

1. Ao abrir Caixas de saque em lote, também exibe a probabilidade de um único produto
2. Otimizados alguns efeitos de exibição de UI no modo noturno
3. Otimizada a lógica interativa da janela pop-up de seleção de data e hora. Ao selecionar o dia atual, alterna automaticamente para a página de seleção de hora
4. Quando a API chama seleção de Item e seleção de lista, a janela pop-up não suporta mais fechamento direto (para evitar perda de chamadas de API)
5. Otimizada a altura padrão de algumas janelas pop-up na parte inferior da tela horizontal do tablet
6. Otimizado o tempo de fechamento automático da janela pop-up

**🐛 Correções de bugs**

1. Corrigido o problema em que a busca de Tarefa via API podia falhar em alguns casos
2. Corrigida falha ocasional na página de lista de Tarefas
3. Corrigido o problema em que o botão de operação «Desfazer» aparecia ao pressionar longamente Conquistas normais não desbloqueadas
4. Corrigido um problema em que a janela pop-up de detalhes da Conquista podia ser exibida incompleta
5. Corrigido o problema em que o upload na janela podia falhar devido a imagem anormalmente grande
6. Corrigido o problema em que own_number e stock_number da API de Item não suportavam números negativos
7. Corrigido o problema em que o número de dias de persistência na página «Eu» às vezes era exibido anormalmente como 1
8. Corrigido o problema em que às vezes era exibido «-x dias atrás»
9. Corrigido o problema em que APIs subsequentes podiam ser canceladas anormalmente ao chamar APIs em lote
10. Corrigido o problema em que o conteúdo preenchido pela nova equipe podia ser perdido quando a página era destruída

**1.90.1 (2022/08/22)**

**🐛 Correções de bugs**

1. Corrigido problema de concorrência em chamadas de API
2. Corrigido o problema em que, ao selecionar um grande número de produtos (milhares), múltiplas seleções podiam causar travamento
3. Corrigido o problema anormal quando o widget conclui a Tarefa de equipe
4. Corrigido o problema em que a edição de Pontos de Experiência de subtarefa não era preenchida retroativamente

**🎉1.90.0 (rc01, rc02) (2022/08/15)**

**✨ Novidades**

1. Otimização das configurações de Recompensa de Tarefa:
   - Ajuste de UI das configurações de Recompensa
   - Subtarefas suportam definir Recompensas de Pontos de Experiência e Itens
   - A Recompensa original «apenas texto» passa a ser uma Recompensa independente de «palavras»
   - Suporte para definir valor padrão de Pontos de Experiência

2. Itens suportam definir restrições de compra por Nível de Atributo.

3. Itens suportam o efeito «URL».
   Não só é possível abrir páginas web, mas também chamar outros aplicativos ou a API do LifeUp. Permite efeitos como aumentar o preço após usar o Item.

4. **APIs abertas.**
   Agora você pode integrar software de automação ou realizar desenvolvimento secundário.

   [Para mais detalhes, consulte a documentação da API.](https://wiki.lifeupapp.fun/en/#/guide/api)

5. A Loja suporta visualizar o efeito de contagem não refinada

6. Otimização de notificações:

   - Adicionada notificação de alteração de Nível de Atributo
   - Adicionada notificação de Conquista desbloqueada
   - Otimização de grupos de notificações

7. Suporte à adição manual de registros de temporização.

8. Agora é possível definir a página Pomodoro na barra de navegação

9. Suporte para ocultar a lista [Conquista do sistema]

10. A versão alvo da API foi adaptada ao Android 12L

11. Otimização de efeitos de imersão

12. Widgets do App suportam exibir a janela pop-up de conclusão de Tarefa

13. Agora é possível concluir a Tarefa na página de detalhes do assunto

14. Na janela pop-up de vencimento, é possível definir o número de Tarefas contadoras

15. Agora é possível editar o nome da Tarefa de equipe

16. Otimizado o momento das solicitações de rede do módulo mundo, reduzindo consumo de tráfego e pressão no servidor

**♻️ Otimizações**

1. O modo noturno agora suporta todas as cores de tema, com personalização noturna separada para cada cor, adaptado ao Material 3
1. Adicionado o link «Otimização de bateria» no diálogo de configuração de compatibilidade
1. Adicionado o interruptor «Manter tela ligada» nas Configurações Pomodoro
1. Oferece as duas opções «Encerrar» e «Acumular» para a contagem regressiva do Item em estado pausado
1. Quando o número de metas editadas é maior que o atual, é exibido um aviso de erro
1. Assuntos negativos não devem ser exibidos nas configurações de coeficiente de penalidade
1. Otimizado o efeito de atualização na página de histórico
1. Otimizada a lógica de acionamento automático da Tarefa principal após concluir a subtarefa; agora processada diretamente na página de detalhes
1.

**🐛 Correções de bugs**

1. Corrigido o problema em que o botão + aparecia às vezes na página Momentos
2. Corrigido o problema em que Tarefas negativas não exibiam o diálogo de Reflexões
3. Corrigido o problema da meta de Tarefas negativas que não surtia efeito
4. Tentativa de reparar o efeito de definir «congelar até...» para Tarefas de equipe
5. Corrigido o problema em que a imagem da página de Reflexões podia ser exibida incorretamente

**1.89.5 (2022/8/5)**

1. Otimizado o problema de conexão de rede
2. Atualização de traduções

**1.89.4 (2022/7/13)**

1. Corrigidas informações sobre perguntas do Xiaohong Dot
2. Corrigido o problema de geração repetida de Tarefas repetitivas (desta vez deve estar realmente reparado .jpg)

**1.89.3 (2022/7/05)**

**♻️ Otimizações**

1. Otimizado o critério da lista de interruptores deslizantes

**🐛 Correções de bugs**

1. Corrigido o problema em que o cálculo podia não ser concluído quando há muitas condições de Conquista
2. Corrigido o problema em que o lembrete de notificação de Tarefa indefinida exibia prazo anormal
3. Corrigido o problema em que editar o fundo de um Item afetava o Item copiado após a cópia
4. Corrigido o problema em que a Habilidade ao editar Tarefas de equipe podia não ser herdada

**1.89.2 (2022/6/23)**

**♻️ Otimizações**

1. Removida permissão CARMRA desnecessária
2. Atualização de traduções

**🐛 Correções de bugs**

1. Corrigidas algumas falhas

**1.89.0-1.89.1 (2022/6/09)**

**✨ Novidades**

1. Suporte a desbloqueio múltiplo de Conquistas condicionais
2. Detalhes de Conquista suportam visualizar detalhes e progresso das condições
3. Etiquetas de Tarefas
4. Tarefas repetitivas sem prazo
5. Ocultar Itens esgotados ou com compra desabilitada
6. Ao configurar o efeito de redução de Pontos de Experiência de um Item, é opcional limitar o uso
7. A página de Inventário suporta seleção múltipla, selecionar tudo e devoluções em lote
8. A lista de Tarefas padrão suporta operação de arquivamento
9. Redesign de algumas páginas como configurações, perguntas e respostas, barra de ferramentas da Loja e página de adicionar listas
10. Redesenhados alguns ícones do App (ícones de cartões de Tarefas padrão, moedas, Pontos de Experiência, ícones de Conquistas)
11. O armazenamento de imagens foi movido para o caminho privado externo do App para evitar exclusão acidental de arquivos

**♻️ Otimizações**

1. Adicionado link do artigo [Configuração de compatibilidade] na página de configurações
2. Contagem regressiva Pomodoro — a operação de redefinir adiciona diálogo de confirmação
3. Adicionada descrição para congelar Tarefas
4. Adicionada descrição para subcategorias de Conquistas
5. No modo offline, adicionado botão para sair do modo offline na página de editar perfil
6. Otimizadas as estatísticas de Tarefas negativas; suporta exibir o número de abandonos do dia e acompanhamento de Conquistas
7. Otimizada a velocidade de inicialização do App
8. Ícones de Conquista suportam visualizar imagem ampliada
9. Adicionadas estatísticas de «curtidas» (recebidas) para Tarefas aleatórias
10. Otimização unificada da interação de busca
11. Ao selecionar um Item, mudar para uma lista vazia exibe layout vazio (em vez de carregando)
12. A página de visualização de imagem ampliada se adapta às configurações de cor de tema atuais
13. Otimizado o efeito de animação quando a altura da janela pop-up de Item e Tarefa selecionados muda
14. Nas configurações de backup, «Excluir dados locais» também suporta excluir arquivos de mídia
15. Unificada a lógica de armazenamento e exclusão de arquivos temporários ao tirar fotos
16. Distinção entre o ícone padrão do Item e o ícone que falha ao carregar
17. Ativada por padrão a configuração independente de penalidade para Tarefas
18. Otimizados a atualização, a lógica de animação e a velocidade de carregamento da página de Reflexões
19. Algumas janelas pop-up de detalhes adicionam um botão de atalho «Selecionar»
20. Quando os interruptores principais de «efeitos sonoros» e «vibração» nas configurações avançadas estão desativados, instruções correspondentes também são exibidas nas configurações Pomodoro
21. Otimização de ordenação de Conquistas novas e subcategorias
22. Atualização de biblioteca base e dependências
23. Otimizados o método e a velocidade de cálculo do progresso de Conquistas
24. Melhorado o método de cálculo de «vezes alvo (repetições)» para seguir a melhoria estatística de registros históricos, coerente com o número de vezes nos detalhes
25. Ao inserir o número de moedas e repetições alvo, todos os valores atuais são selecionados automaticamente
26. Otimizado o aviso de erro quando a configuração WebDAV está anormal
27. Otimizado o aviso de erro quando o backup do Google Drive está anormal
28. Agora é possível selecionar o nome da Tarefa na página de detalhes

**🐛 Correções de bugs**

1. Corrigido o problema em que a contagem definida invalidava a Recompensa de Tarefas após executar a lógica de repetição
2. Corrigido o problema de ordenação e agrupamento na página da Loja
3. Corrigido o problema anormal de rolagem para cima/baixo em Tarefas aleatórias em alguns casos
4. Corrigido o problema em que a estatística Pomodoro na página de status era imprecisa após usar temporização positiva em alguns casos
5. Corrigido o problema em que a lógica de repetição de Tarefas de equipe perdia a configuração de tipo contador
6. Corrigido o problema em que a Tarefa selecionada pelo Pomodoro ficava destacada ao selecionar Tarefas relacionadas a condições de Conquista
7. Corrigido o problema em que a imagem de Reflexão não era armazenada independentemente e problemas de exibição
8. Corrigido o problema em que o aviso de falha podia aparecer com frequência quando o login falhava
9. Alguns campos de entrada especiais para novas Tarefas, equipes e subtarefas não devem permitir entrada por teclado, o que podia causar falha do App
10. Otimizada a forma de contar finalizações de Itens ilimitados em widgets, coerente com o App
11. Corrigido o problema em que, após o ATM ajustar a taxa de juros, os juros podiam ser calculados com base no tempo acumulado e na taxa ajustada
12. Corrigido o problema em que Tarefas congeladas ainda podiam ser exibidas na lista inteligente
13. Otimizado o problema em que o botão de ação bloqueado pela barra de seleção ainda era clicável ao selecionar certos objetos (Tarefas, Itens da Loja)
14. Corrigido o problema em que alterar a cor de um Item não atualizava a UI imediatamente
15. Corrigido o problema em que definir de repente uma taxa de juros alta após mantê-la baixa (sem obter 1 moeda) podia gerar juros enormes
16. Corrigido o problema em que a caixa de busca aparecia após concluir a Tarefa após abrir a barra de busca e usar o produto
17. Corrigido o problema em que o número de conclusões do dia no App podia não coincidir com o widget após alterar o nome de uma Tarefa infinita
18. Corrigidas animações estranhas ao concluir Tarefas ilimitadas
19. Corrigido o problema em que copiar uma Tarefa não copiava o fundo da Tarefa
20. Corrigido o problema em que, em alguns casos, as condições de Conquista eram cumpridas, mas a Conquista não podia ser desbloqueada
21. Corrigida exceção no cálculo de intervalos de datas (pode afetar várias lógicas)
22. Corrigido o problema em que as Reflexões não eram filtradas automaticamente a partir da página de detalhes de Tarefas

**1.88.4 (2022/4/21)**

1. Corrigida a falha ao buscar no armazém
2. Corrigido o desordenamento de exibição do fundo personalizado e da página de histórico
3. Corrigido o problema de sobreposição de UI ao editar
4. Corrigido o problema em que a quantidade podia ser exibida anormalmente quando a Conquista concedia produtos como Recompensa
5. Corrigido o problema em que as vezes de conclusão no cálculo de Conquistas podiam não coincidir com as reais em alguns casos especiais
6. Corrigido o problema em que o título podia desaparecer ao clicar rapidamente na página de histórico
7. Ao criar ou editar um Item, após clicar na propriedade, o teclado virtual não podia ser exibido novamente ao clicar no campo de entrada com foco
8. Corrigida a falha ao definir limite de compra mensal em francês

**1.88.3 (2022/4/09)**

1. Corrigido o problema em que, após restaurar o backup, o backup na nuvem exibia conflito
2. Corrigido o problema em que o horário de início da Tarefa editada e o horário de lembrete da subtarefa não selecionavam por padrão o horário preenchido
3. Corrigido o problema em que outros efeitos eram calculados apenas uma vez durante a Síntese simples em lote
4. Corrigido o problema em que qualquer Atributo de Conquista do sistema ao atingir Nível 10 não era contabilizado no Atributo personalizado
5. Corrigida a exibição anormal da UI de texto na página «Eu» para não membros

**1.88.2(-)**

> Atualizações incluídas em 1.88.3

**1.88.1 (2022/4/02)**

1. Corrigida uma falha causada pelo lembrete de backup

**1.88.0 (2022/3/30)**

✨ Novidades

1. Adicionada a função de compartilhar «Tarefas aleatórias» no módulo mundo
2. Itens contadores podem definir opcionalmente o coeficiente para afetar a quantidade de Itens
3. Suporte para definir taxa de juros de empréstimo
4. O gerenciamento de imagens suporta filtragem com um clique de imagens não usadas + operações de selecionar tudo
5. Suporte a tamanho personalizado de recorte de imagem (ou seja, usar ícones de maior definição, função de membro)
6. Exibição explícita do interruptor «Reflexões» dentro da Conquista
7. Otimizado o algoritmo de ordenação da lista «Todas»

⚡️ Otimizado

1. Otimizados os efeitos visuais de algumas janelas pop-up
2. Otimizada a interação das funções de backup/restauração
3. Otimizada a velocidade de carregamento da página de delegação
4. Otimizada significativamente a velocidade de carregamento da janela pop-up de seleção de produto

🐛 Correções

1. Corrigido o problema de desordem do fundo personalizado
2. Corrigido o problema em que a Tarefa podia ser criada na lista excluída
3. Corrigidas algumas falhas

**1.87.1（2022/3/07）**

1. O menu de ordenação da Loja e do Inventário exibe explicitamente a ordenação «personalizada»
2. Corrigido o problema em que a ordenação anormal podia ocorrer no Inventário
3. Adicionado botão para ir ao feedback por e-mail na página de feedback
4. Otimizado o aviso de falha de restauração devido a problemas de versão do banco de dados
5. Corrigido o problema em que o número de moedas no cartão do modo compacto não era exibido

**1.87.0 official version (2022/3/04)**

1. Corrigido o problema em que o fundo personalizado do cartão podia ampliar anormalmente em alguns casos
2. Corrigido um problema em que clicar na notificação de lembrete de Tarefa podia ir para detalhes errados ao receber lembretes continuamente
3. Corrigido o problema em que os números no cartão não eram atualizados normalmente ao deslizar para aumentar a contagem de Tarefa contadora
4. Adicionada nova Tarefa guia para alguns idiomas

**1.87.0-rc02（2022/2/25）**

1. Melhorado o tratamento de erros e avisos para operações de recuperação
2. Otimizada a interação ao definir «dia da semana» e aumentado o aviso de configuração anormal (início-período não no mesmo dia)
3. Otimizada a combinação de cores do modo noturno em algumas páginas
4. Corrigido o problema em que o cache podia ser exibido incorretamente na caixa de seleção de imagem e no gerenciamento de imagens
5. Corrigido o problema em que a operação «Download» na janela pop-up de conflito de backup não suportava Google Drive/Dropbox
6. Corrigido o problema em que a busca da Loja podia mostrar resultados errados
7. Corrigido o problema em que o topo da Tarefa podia falhar
8. Corrigidas algumas exceções de UI e problemas de texto

**1.87.0-rc01（2022/2/23）**

**✨ Novidades**

1. Subcategoria de Conquista suporta operação de recolher
2. Introduzido o interruptor de estilo Material You (experimental)
3. Inventário suporta ordenação por Loja
4. Inventário suporta operação «estrela» de produto
5. A Loja suporta operações de selecionar tudo
6. Operações relacionadas à Loja e ao Inventário suportam selecionar quantidade MAX
7. Tarefas suportam criação contínua
8. Tarefas suportam configuração: a descrição da Recompensa de produto será adicionada automaticamente às observações do cartão (ou seja, «Recompensa: [um produto] x1» será exibido automaticamente)
9. Tarefas suportam duração de congelamento especificada

**⚡️ Otimizações**

1. Adicionado botão «Pular» na janela pop-up de conflito de backup
2. Versão Play suporta francês/polonês
3. O lembrete de notificação ao clicar na Tarefa agora suporta ir para detalhes da Tarefa
4. Ao editar horário relacionado à Tarefa, a janela pop-up padrão apontará para o horário antes da edição em vez do horário atual
5. Cada entrada de seleção de lista da Loja suporta operações «Renomear», «Excluir», «Novo»
6. Redesign da UI da página de extensões
7. Adicionada segunda janela pop-up de confirmação para «Excluir conta do calendário»
8. O produto não será mais removido automaticamente da prateleira se estiver esgotado
9. A Tarefa «Acordar cedo» nas Tarefas de exemplo foi alterada para penalidade 0
10. Ao obter Recompensa de Item, se a quantidade do Item for negativa, agora aparece um aviso relacionado
11. Otimizado o algoritmo aleatório de moedas no efeito de uso de produto
12. A operação «Definir como concluído» adiciona efeito sonoro de conclusão
13. Otimizada alguma exibição de UI no modo noturno
14. Otimizado o desempenho da lista de Tarefas

**🐛 Correções de bugs**

1. Corrigida a anormalidade da cópia «não relacionado» em alguns idiomas
2. Corrigido o problema em que o ícone do produto na janela pop-up «Devolver» podia ser exibido anormalmente
3. Corrigido o problema em que a Tarefa podia ser gerada repetidamente ao concluir rapidamente
4. Corrigido o problema em que a memória da lista atual do sistema «Síntese» podia ser inválida
5. Corrigido o problema em que o login QQ podia não ser possível em modo paisagem
6. Corrigido o problema em que, ao editar uma receita na lista [Todas] no sistema «Síntese», a receita podia desaparecer da lista original
7. Corrigido um problema em que clicar para concluir uma Tarefa infinita várias vezes seguidas podia fazer o número de conclusões voltar a zero
8. Corrigido o problema em que o intervalo de backup não podia ser definido como «Mensal»
9. Corrigido o problema em que o ícone de Pontos de Experiência não era exibido no modo simples
10. Corrigido o problema em que as colunas «Conquistas» e «Lista de Conquistas» estavam ausentes no gerenciamento de imagens
11. Corrigido o problema em que a página de detalhes da Tarefa não suportava abandonar Tarefas de equipe
12. Corrigido o problema em que o guia do módulo mundo não era exibido corretamente
13. Corrigido o problema em que o produto podia ser compartilhado com sucesso quando o upload de imagem falhava, mas a imagem local era sobrescrita
14. Corrigidas algumas falhas e exceções raras

**1.86.0（2022/1/20）**

**Novidades**

1. Subcategoria de Conquista: divide categorias, conta automaticamente as contagens de categoria
2. Backup do Google Drive
3. Função de gerenciamento de imagens (na página de backup)
4. Efeito de moedas aleatórias de produto
5. Cópia em lote de Conquistas
6. Contagem de passos suporta múltiplas entradas de passos e múltiplas Recompensas
7. Pomodoro suporta configurar troca de produto
8. Suporte a proporção personalizada de desconto na devolução
9. Usa formato exclusivo para backup (alguns sistemas suportam abertura e importação direta de backup)
10. Síntese simples suporta operação em lote
11. Nova opção de efeito sonoro personalizado: uso de produto
12. Nova condição de desbloqueio de Conquista: depósito atual no ATM
13. Estatísticas do número de vezes que assuntos negativos suportam a página de detalhes
14. A lista «Todas» suporta renomeação
15. Nomeação e descrição unificados dos canais de notificação do App

**Otimizações**

1. Prioriza Conquistas desbloqueadas mas sem Recompensa recebida
2. O tempo de Foco de hoje do Pomodoro na página de status será exibido em horas conforme o tempo
3. O armazém adiciona exibição da descrição do produto
4. O registro de nova conta exibirá um diálogo de confirmação
5. Suporte para exibir anúncios de manutenção
6. Adicionado diálogo de confirmação «Pular» para tempo extra Pomodoro
7. Suporte para salvar dados ao desinstalar o aplicativo (requer suporte do sistema)
8. Otimizada a lógica de backup e recuperação
9. Otimizada a lógica de vencimento de Itens únicos e ilimitados, com suporte à edição
10. Otimizada a base de tempo das estatísticas de gráfico de eventos ilimitados, com base no horário de conclusão em vez do prazo
11. O cartão do modo compacto também mostrará o horário de vencimento de Itens únicos e ilimitados
12. Tentativa de melhorar a taxa de sobrevivência da função de contagem regressiva em segundo plano
13. Otimizada a função de Reflexões:
    -Ativada por padrão
    -A página de configuração de Tarefa de equipe não exibe o interruptor «Reflexões» que não surte efeito de fato
    -Removida a função confusa de memória do interruptor de Reflexões
14. Selecionar a janela pop-up para a lista de produtos e armazéns aumenta o número de produtos exibidos
15. Quando a barra de notificação continua temporizando, o efeito de vibração em andamento também será cancelado
16. O texto dinâmico no módulo mundo suporta cópia selecionada
17. Otimizado o efeito de animação de atualização de dados da página de Conquista personalizada
18. Otimizada a lógica de recuperação, exibindo a caixa de diálogo «Carregando» em vez de travar a interface diretamente
19. Otimizado o problema em que o botão inferior podia não ser visto na «janela pop-up de falha»
20. Clicar no lembrete de notificação de Tarefa agora vai para a página de lista onde a Tarefa está localizada
21. Ícone de Atributo personalizado agora suporta selecionar a biblioteca de ícones integrada do App
22. Otimizada a operação de compartilhamento «Ler depois» em vez de exibir diretamente o nome do App
23. Otimizada a notificação de desbloqueio de Conquista; a descrição da Conquista agora será exibida
24. Quando o widget desktop entra na página inicial, salta automaticamente para o módulo «delegação»
25. Otimizada a exibição do texto após a conclusão da lista do dia
26. Otimizada a cópia e a sequência de operação do efeito de contagem regressiva de produto
27. Quando todos os Atributos estão ocultos, a página de status não exibe mais o cartão «Atributo»

**Correções**

1. Corrigida uma falha rara em janelas pop-up de desbloqueio de Conquistas
2. Corrigido o problema de exibição em que uma Tarefa podia ocupar várias linhas ao esvaziar widgets desktop com largura insuficiente
3. Corrigido o problema em que a primeira autorização de exercício para contagem de passos podia exibir o número total de passos acumulados pelo sensor
4. Corrigida a falha ou confusão de recuperação ao pausar uma contagem regressiva e iniciar outra
5. Corrigido o problema em que o efeito de contagem regressiva de 0 minutos do produto podia ser inserido e causar falha
6. Corrigido o problema em que o nome da lista selecionada atualmente não era atualizado a tempo ao renomear a lista selecionada na página de adicionar ou editar Itens
7. Corrigida a exibição anormal de cartões com frequência repetida «anual»
8. Corrigido o problema em que moedas personalizadas não surtiam efeito a tempo em alguns casos
9. Corrigido o problema em que widgets exibiam Itens congelados
10. Corrigido o problema em que a Conquista personalizada não exibia o aviso de «operação de toque longo»
11. Corrigido o problema em que o valor total de Pontos de Experiência na página «Eu» não contabilizava Pontos de Experiência de Atributo personalizado
12. Corrigido o problema em que a página «Reflexões» voltava ao topo após pré-visualizar a imagem anormalmente
13. Corrigido o problema em que o atalho estático «Pomodoro» só saltava para a página inicial quando o App já havia sido iniciado no sistema MIUI
14. Corrigido um problema em que não membros também podiam carregar fundos personalizados
15. Corrigido o problema em que o número de moedas na página da Loja não era atualizado a tempo
16. Corrigido o problema em que o calendário não podia avançar para o próximo ano
17. Corrigido o problema em que o nome da lista no widget não era atualizado a tempo após modificar o nome da lista

**Release Candidate → Versão oficial**

1. Otimizada a taxa de sucesso de upload de arquivos grandes no Google Drive, aumentadas as tentativas e otimizada a estratégia de blocos
2. Corrigido o problema em que membros podiam não exibir o botão de fundo personalizado individual de Tarefa em ambiente não chinês
3. Quando o backup do Google Drive/DropBox falhava, saltava para a página de backup em vez da página de configuração WebDAV
4. Adicionada descrição em janela pop-up de falha de verificação do Google Play e fornecido caminho de exportação de dados
5. O apelido na página «Eu» muda de cor conforme o status de membro
6. Eliminado o problema de erro de ponto flutuante da taxa de juros do ATM na maioria dos cenários
7. Ao excluir dados locais, fundo personalizado, imagem de Atributo e arquivos de efeito sonoro também são excluídos sincronamente
8. Corrigido o problema anormal do gráfico de contagem de passos
9. Corrigido o problema em que as propriedades da nova página de afazeres não eram atualizadas após clicar no botão de interrogação da propriedade, ir para a página de personalização de propriedade e voltar
10. Ao personalizar o efeito do produto, clicar fora da janela pop-up não cancelará mais automaticamente a janela pop-up, evitando perda de conteúdo editado
11. Otimizado o problema de UI em idiomas estrangeiros na página de configuração de produto (texto russo muito longo)
12. Tentativa de corrigir a falha de toast de cor em alguns modelos
13. Corrigido o problema em que o botão de uso ainda podia ser clicado quando a página do armazém estava selecionada
14. Corrigida a lógica de exibição de Tarefas únicas vencidas na lista inteligente e adaptado ao novo método de armazenamento de horário de vencimento
15. Quando o armazém está selecionado, a lista alternável deve ser desmarcada

**1.85.4 (2021/12/08)**

Versão regular de correção de bugs; a próxima versão com novidades ainda está em desenvolvimento~

1. Corrigido o problema em que o ícone padrão de moeda do widget no modo não escuro não era exibido corretamente
2. Corrigido o problema em que a animação da barra de progresso não reproduzia normalmente em caso de upgrade/downgrade contínuo
3. Corrigido o problema em que o número de moedas na página do armazém não era atualizado a tempo
4. Corrigido o problema em que o prazo podia ser alterado à força ao editar o Item «dia da semana»
5. Corrigido o problema em que a rotação de tela podia causar perda de informações de subtarefas alteradas ao editar Itens
6. Corrigido o problema em que o número de moedas não surtia efeito de fato ao criar ou editar produtos
7. Condições de exibição das vezes de conclusão anual na página de detalhes da emenda
8. Otimizado o armazenamento de imagens no App, que não deve ser escaneado pelo álbum de fotos do sistema
9. Otimizada a descrição do interruptor de Reflexões
10. Corrigidas algumas falhas

**1.85.3 (2021/11/18)**

1. Otimizado o método de cálculo de tempo da temporização, compensará o tempo de suspensão da CPU
2. Corrigido o problema em que editar o ícone ao copiar o produto causava perda do ícone do produto original
3. Outras pequenas correções de bugs (como etiqueta de equipe)

**1.85.2 (2021/11/07)**

1. Corrigido o problema em que registros e Recompensas não podiam ser gerados durante a liquidação após suspender a temporização
2. Corrigido o problema em que usar a operação «mover para» na lista inteligente causava exibição imprecisa da lista
3. Corrigido o problema em que a exibição do valor atual de «Número atual de moedas» não correspondia ao cálculo real (a exibição do valor atual não inclui depósitos no ATM)
4. Corrigido o problema em que o registro e a Recompensa eram repetidos após o trabalho Pomodoro terminar e o botão pular ser clicado duas vezes seguidas

**1.85.1 (2021/11/02)**

0. Corrigido problema de carregamento da lista de Reflexões

**1.85.0 2021/10/20)**
*Novidades*

1. Pomodoro suporta modo de temporização positiva
2. Colar várias linhas de texto para criar subtarefas rapidamente
3. Produtos suportam operação de cópia
4. Deslizar para alternar a direção da lista de Itens, suporta inverso (configurações-Itens)
5. Suporte para limpar o registro obtido pelo Pomodoro
6. O Pomodoro adiciona botão forçado de alternância horizontal/vertical
7. Condições de desbloqueio de Conquista aumentadas:
   ● Número de produtos obtidos por Síntese
   ● Quantidade acumulada de aquisição de produtos
   ● Quantidade atual do produto
   ● Nível de vida
   ● (Repetitivo) tempo de Foco da Tarefa
8. O ícone de Habilidade também suporta múltiplas configurações de recorte
9. Atalho estático:
   ● Nova Tarefa
   ● Entrar na página Pomodoro
10. Efeito sonoro personalizado aumentado:
    ● Obter Recompensas de Conquista (incluindo Conquistas do sistema e personalizadas)
    ● Abrir Caixa de saque
    ● Síntese (incluindo Síntese simples e Síntese)
    ● Efeito sonoro de notificação
11. Personalização do ícone de moeda
12. Efeito de uso de produto suporta definir múltiplos efeitos de alteração de Pontos de Experiência
13. Alterações na adaptação de Habilidades do gráfico de pizza de Pontos de Experiência
14. A página de histórico suporta filtragem por status
15. Função de etiqueta de equipe

*Otimizações*

1. Quando a Recompensa de moedas da subtarefa é 0, a Recompensa de moedas não será exibida nos detalhes
2. Criada nova página de lista de Conquistas e adicionado guia «Criar Conquista»
3. Otimizada a exibição de ícones de widgets
4. Concluir subtarefas adiciona efeitos sonoros (detalhes, novas páginas)
5. Após inserir conteúdo na página de novo ou edição (Itens, produtos, Conquistas, Síntese), clicar no botão voltar exibirá uma caixa de confirmação para descartar alterações
6. Otimização de ordenação na criação de produto (em caso de ordenação personalizada, produtos recém-adicionados devem ter prioridade máxima)
7. Ao editar Itens/produtos, o método de entrada não deve abrir automaticamente
8. A nova página de Item deve suportar tela horizontal sem perda de dados
9. Adaptação de cor de tema de membro para widgets desktop
10. Otimizada a caixa de seleção de produto, alterada a exibição e carregamento assíncrono dos dados
11. A etiqueta do armazém também adiciona entradas «composição» e «ATM»
12. Colocadas as operações [Definir como concluído] e [Desfazer] na alteração de status do histórico de volta ao menu de primeiro nível
13. Adicionada entrada rápida Pomodoro nos detalhes do evento
14. Otimização da ordenação da lista «Todas» da Loja (adição da opção de agrupar por lista, apenas Lojas)
15. Após selecionar os dias da semana para repetir, o horário de prazo deve ser recalculado. (Evita que o usuário escolha um dia útil para repetir e o prazo permaneça no sábado e domingo.)
16. Ao voltar para a página «Delegação», se o botão «+» não for exibido, a exibição será acionada.

*Correções*

1. Corrigido o problema em que o progresso na lista não era atualizado a tempo quando a página de Conquistas estava configurada na barra de navegação inferior
2. Corrigido o problema de alternância de estado de Itens históricos
3. Reparada a exibição de vencimento de contagem regressiva negativa
4. A Conquista de moedas deve ser incluída no depósito no ATM
5. Corrigido o problema em que, quando o Pomodoro estava pausado, entrar novamente duas vezes no Pomodoro causava limpeza do tempo
6. Corrigido o problema em que a restrição de compra podia se tornar inválida em certas circunstâncias
7. Corrigido o problema em que registros de contagem regressiva podiam se repetir em casos raros
8. Corrigido o problema em que clicar rapidamente em cartões de Tarefa diferentes podia deixar o conteúdo de um dos cartões em branco após voltar à página
9. Ajuste de lógica do cálculo automático de moedas e Pontos de Experiência
10. Corrigidas algumas falhas

**1.84.4 (2021/10/09)**

1. Corrigido o problema em que o ícone integrado podia não ser exibido

2. Atualização do grupo Q

**1.84.3 (2021/10)**

1. Atualização de textos para o exterior

**1.84.2 (2021/09/26)**

1. Corrigido o deadlock que podia ser causado pela Síntese

2. Corrigido o problema em que os detalhes do produto exibiam efeitos de uso anormais de produtos indisponíveis

3. Otimizado o efeito visual de cantos arredondados dos widgets

**1.84.1 (2021/09/20)**

1. Corrigido o problema em que o número de repetições alvo não podia ser limpo durante a edição

**1.84.0 (2021/09/19)**

***Novidades***

1. Sistema de Habilidades (personalização de Atributos)

   Todos os mecanismos originais foram adaptados ao sistema de personalização de Atributos, como Atributos de Conquistas que atingem condições de desbloqueio, Recompensas de Pontos de Experiência de produtos, etc.

2. Personalizar o efeito comestível do Pomodoro, permitindo alterar o valor de Pontos de Experiência e os tipos de Atributo

3. O ícone da Loja suporta alteração do estilo de recorte (configurações da Loja)

4. Os detalhes do produto agora exibem uma lista de efeitos de uso

5. Adicionada cor de tema de membro #6bab8b

6. Suporte para excluir a conta de calendário de lembretes

***Melhorias***

1. A página Pomodoro suporta exibição horizontal

2. Adicionada a descrição de «Quantidade emprestável» nas configurações do produto

3. Adicionado um aviso sobre o tamanho do arquivo da sincronização na nuvem

4. Atualizadas dependências relacionadas ao Facebook e Dropbox

5. Otimização parcial da interface e textos de algumas páginas

6. Otimizada a interação ao criar subtarefas

***Correções***

1. Corrigido o problema em que a versão padrão do ícone do Atributo era inconsistente

2. Corrigido o problema em que toques rápidos para abrir a caixa podiam causar aberturas repetidas ou falhas

3. Corrigido o problema em que eventos de calendário já lembrados não eram removidos ao excluir Itens

4. Corrigido o status anormal após alterar um Item de «Concluído» para «Vencido» na página de histórico. Os dados históricos devem ser reparados automaticamente ao atualizar para a nova versão

5. Corrigido o problema em que a lista selecionada era marcada incorretamente no diálogo de seleção de lista ao criar um produto novo; removida a exibição da lista «todas»

6. Corrigido o problema em que, ao editar outro conteúdo e as vezes de repetição alvo, a edição falhava novamente

7. Na página de nova Conquista, corrigido o problema em que a seleção de Atributo não podia ser editada e ficava em branco

8. Outras correções menores e otimizações

**1.83.16 (2021/08/20)**

1. Corrigida a falha e a ineficácia ao modificar o avatar no modo offline
2. Otimizada a interação ao selecionar o efeito de abertura de produto
3. Corrigido o problema de foco em alguns campos de texto longo
4. Corrigido o problema em que o prazo e a hora do lembrete eram exibidos incorretamente em alguns casos
5. Corrigido o problema em que alterações de configuração do modo conciso não surtiam efeito imediatamente

**1.83.15**

1. Suporte para marcar Tarefas de penalidade em widgets da App
2. Corrigido o comportamento anormal de «dobrar assuntos fora de sete dias»
3. Aumentado o limite de imagens de Reflexões para 9
4. A página de login exibe o último método de acesso
5. Ao cancelar a penalidade (marcada como concluída), nenhuma Recompensa adicional é concedida
6. A lista inteligente agora suporta exibir Itens concluídos
7. Corrigida a situação anormal de backup automático na pasta «download» em alguns casos
8. Corrigidos alguns problemas de exibição da interface

**1.83.14**

1. Corrigido o problema em que o Pomodoro podia não registrar a duração ao executar «pular»
2. Corrigido o problema em que Itens de penalidade executavam a lógica de vencimento e penalidade
3. Corrigidos problemas relacionados à edição de penalidades
4. Corrigidos problemas relacionados à seleção de imagens no modo horizontal
5. Corrigida a falha ocasional ao restaurar um backup de um caminho personalizado

**1.83.8-1.83.13**
Novidades

1. Suporte para configurar o fundo do cartão de forma independente
2. A função de excluir registro agora suporta excluir Reflexões, armazéns e registros de temporização
3. Conquistas do sistema podem escolher Recompensa de Pontos de Experiência ou de moedas
4. Função de busca de eventos
5. Suporte para backup automático local na pasta «download» (Android 10 e superior)

Melhorias

1. Melhorado o método padrão de chamada de lembretes por notificação, que teoricamente aumenta a taxa de sucesso acima do Android 6
2. Aumentada a prioridade de notificação do temporizador Pomodoro para [Alta], melhorando a sobrevivência do temporizador em segundo plano e a exibição de notificações
3. Na página, adicionados links ao grupo QQ e ao site oficial, otimizada a interface; QQ suporta entrar no grupo com um clique
4. Melhorado o momento de acionamento de notificações de Conquistas, que devem ser exibidas imediatamente após serem acionadas na página inicial
5. Adicionada a caixa «Aplicar apenas à lista atual» na opção «Filtrar» da lista de Itens, separando as opções padrão e todas as listas
6. Adicionados efeitos de animação ao compor
7. Feedback: ampliado o canal da comunidade Rabbit Xiaochao, mais conveniente para enviar imagens e acompanhar problemas
8. Adicionada exibição do valor relativo no campo de entrada de Itens de contagem
9. Otimizado o efeito de exibição de abas não selecionadas
10. Removido o aviso aleatório ao tocar no avatar; agora entra na página pessoal
11. Quando a Recompensa de moedas não está configurada, é exibido «não configurado» em vez de «0»
12. Quando a probabilidade de abertura de caixa é inferior a 0,01%, não exibe mais «0,00%», e sim «<0,01%»
13. O interruptor de Reflexões não é mais memorizado e fica desativado por padrão
14. Otimizado o processo de solicitação de permissões de calendário e câmera
15. Otimizados o efeito ao tocar e a exibição de algumas páginas
16. Otimizado o método de lembrete de calendário, tentando resolver o problema em que alguns dispositivos podem excluir a conta de calendário

Correções

1. Corrigida a falha por filtragem contínua na página de Reflexões
2. Tentativa de corrigir a falha rara do diálogo configurado de fábrica
3. Corrigido o problema em que, com um campo de entrada longo, tocar no texto saltava automaticamente para o final
4. Corrigido o problema em que Recompensas aleatórias de moedas não podiam ser configuradas ao criar uma equipe
5. A versão de distribuição nacional remove completamente dependências relacionadas ao Firebase
6. Corrigida a exceção ocasional ao atualizar a página de lista de Conquistas
7. Corrigida uma falha ocasional ao selecionar o ícone integrado
8. Corrigido o problema em que as subtarefas ainda ficavam visíveis ao voltar à página de detalhes após excluí-las todas
9. Corrigido o problema em que o nome da lista padrão de Síntese não podia ser editado
10. Corrigido o problema em que a caixa de filtro aparecia na página de perfil
11. Corrigido o problema em que o Item de equipe não era herdado após configurar a Recompensa de produto

**1.83.7 (2021/06/24)**

1. Ordenação de listas por moedas adicionadas
2. Adicionada seleção de idioma na página de guia
3. Otimizada a velocidade de carregamento da página de Conquistas
4. Alteradas as informações do grupo QQ para entrar com um clique
5. Corrigido o problema em que toques repetidos durante a abertura podiam provocar alterações múltiplas no Inventário
6. Corrigida a exibição incorreta de Itens vencidos individuais na lista diária de Itens

**1.83.6 (2021/06/22)**

Novidades

1. (Membros) Suporte para configurar o fundo do cartão de forma independente
2. A função de excluir registro agora suporta excluir Reflexões, armazéns e registros de temporização
3. Conquistas do sistema podem escolher Recompensa de Pontos de Experiência ou de moedas
4. Função de busca de eventos
5. Suporte para backup automático local na pasta «download» (Android 10 e superior)

Otimização

1. Melhorado o método padrão de chamada de lembretes por notificação, que teoricamente aumenta a taxa de sucesso acima do Android 6
2. Aumentada a prioridade de notificação do temporizador Pomodoro para [Alta], melhorando a sobrevivência do temporizador em segundo plano e a exibição de notificações
3. Na página, adicionados links ao grupo QQ e ao site oficial, otimizada a interface; QQ suporta entrar no grupo com um clique
4. Melhorado o momento de acionamento de notificações de Conquistas, que devem ser exibidas imediatamente após serem acionadas na página inicial
5. Adicionada a caixa «Aplicar apenas à lista atual» na opção «Filtrar» da lista de Itens, separando as opções padrão e todas as listas
6. Adicionados efeitos de animação ao compor
7. Feedback: ampliado o canal da comunidade Rabbit Xiaochao, mais conveniente para enviar imagens e acompanhar problemas
8. Adicionada exibição do valor relativo no campo de entrada de Itens de contagem
9. Otimizado o efeito de exibição de abas não selecionadas
10. Removido o aviso aleatório ao tocar no avatar; agora entra na página pessoal
11. Quando a Recompensa de moedas não está configurada, é exibido «não configurado» em vez de «0»
12. Quando a probabilidade de abertura de caixa é inferior a 0,01%, não exibe mais «0,00%», e sim «<0,01%»

**1.83.0-alpha04 (2021/05/23)**

1. Suporte para configurar, ordenar e desativar livremente o módulo inferior
   Os módulos serão adaptados gradualmente; por enquanto apenas alguns módulos funcionais (como Pomodoro; histórico ainda não adaptado)
2. Adicionado um segundo modo de pausa ao efeito de contagem regressiva do produto, que permanece na barra de notificações e pode ser retomado a qualquer momento
    E adicionado o logotipo «experimental»
3. Ao escolher pular o Pomodoro, adicionado um aviso de que não é possível obter um Pomodoro
4. Adicionada uma dica para expandir e recolher a Tarefa de exemplo
5. Corrigida a falha que podia ser causada pelo layout no topo da lista em algumas páginas
6. Otimizado o aviso de erro de rede quando não há conexão
7. Otimizado o aviso de Recompensa de moedas ao concluir subtarefas, alterado para Toast não intrusivo

**1.83.0-alpha03 (2021/05)**

1. Corrigido o problema em que o layout vazio da página de composição podia ultrapassar a tela
2. Corrigido o problema em que o nome do Atributo «Charme» era exibido incorretamente na página de criação
3. Corrigidos alguns problemas com a configuração de moedas
4. Otimizado o efeito de animação da página de Conquistas para se adaptar ao cenário na barra de navegação inferior
    (Adaptado, mas a interface ainda não está pronta; aguarde atualizações posteriores)
5. Atualizada a versão SDK alvo para Android 11
6. Corrigido o problema de layout vazio na página «Moment»
7. Corrigido o problema de cálculo anormal de juros

**1.83.0-alpha02 (2021/05/16)**

1. Corrigido o problema em que receitas de Síntese podiam ser criadas na lista «Todas»
2. Após entrar na interface do sistema de Síntese, independentemente da lista em que você estiver, o conteúdo exibido é a lista «Todas».
3. Reparo simples do método de cálculo de juros do ATM

**1.83.0-alpha01 (2021/05/16)**

1. Sistema de Síntese completo, com suporte para qualquer implementação N-para-N
   - Lista de verificação
   - Criar/Editar
   - Diálogo de Síntese
   - Modo noturno e suporte multilíngue
   - A «entrada» fica no topo da página da Loja
2. Refatoração do código interno da página de novo Item
    Por escalabilidade da App, reorganizamos quase completamente o código de criação de Itens e podemos redesenhar a interface no futuro.
    Atualizações alpha posteriores também adicionarão «data de repetição alvo», «hora de lembrete relativa», «Itens de tipo penalidade (a determinar)» e outras funções.
    Se encontrar um problema, você pode voltar à versão antiga da página a qualquer momento.

3. Adicionada entrada do ATM no topo da Loja
4. Anexos de Item suportam até 9 imagens, e o caminho de armazenamento foi ajustado
5. Função TAG de equipe
    A implementação está integrada, mas o conteúdo TAG específico ainda não foi configurado, então não é exibido por enquanto

**1.82.16 (2021/05)**

1. Corrigido o problema em que Itens de exemplo não executavam corretamente a lógica de vencimento (válido apenas para novos usuários)
2. Corrigido o problema em que o número de conclusões de Itens ilimitados podia faltar 1 vez em certos cenários

**1.82.15 (2021/05)**

1. Corrigido o problema de reprodução de efeitos sonoros em segundo plano

**1.82.14 (2021/05)**

-

**1.82.13 (2021/05)**

1. Corrigido o problema em que Itens ilimitados podiam tornar o carregamento da lista lento e tornar imprecisa a contagem de cancelamentos
2. Corrigido o problema em que concluir a Tarefa no widget da área de trabalho podia reproduzir várias vezes o efeito sonoro de conclusão
3. Corrigido o problema em que a contagem total de Itens superiores na lista inteligente não era precisa
4. Suporte para excluir todos os dados locais e excluir a conta
5. Corrigido o problema em que a edição de subtarefas de Itens de equipe não era herdada

**1.82.12 (2021/05)**

1. Corrigido o problema de contagem ao desfazer a conclusão de Itens ilimitados
2. Corrigido o problema em que Itens congelados ainda eram lembrados
3. Otimizada a troca de lista, o que pode aumentar a velocidade em dispositivos antigos e adicionar animações de carregamento
4. Corrigido o problema em que o efeito sonoro personalizado ao terminar o descanso não surtia efeito; suporta configurar o efeito de fim de temporização de produto
5. Corrigido o problema em que o Pomodoro não contabilizava o tempo de Foco ao usar a operação «pular»
6. Corrigido o problema em que o botão de pausa da contagem regressiva do produto não surtia efeito

**1.82.11 (2021/05)**

1. Corrigido o problema de contagem ao desfazer a conclusão de Itens ilimitados
2. Corrigido o problema em que Itens congelados ainda eram lembrados
3. Otimizada a troca de lista, o que pode aumentar a velocidade em dispositivos antigos e adicionar animações de carregamento
4. Corrigido o problema em que o efeito sonoro personalizado ao terminar o descanso não surtia efeito; suporta configurar o efeito de fim de temporização de produto
5. Suporte para idioma russo

**1.82.10 (2021/05)**

1. Corrigido o problema em que o Pomodoro não contabilizava o tempo de Foco ao usar a operação «pular»
2. Corrigido o problema em que o botão de pausa da contagem regressiva do produto não surtia efeito
3. Capturada uma falha causada por falha ao criar um lembrete de calendário

**1.82.9 (2021/05)**

1. Corrigido o problema em que o limite de tempo do Item copiado podia ser esvaziado e provocar falha ao repetir
2. Otimizada a velocidade de atualização após concluir Itens ilimitados
2. Corrigido o problema de cálculo da hora de lembrete em Tarefas de equipe
3. Corrigido o problema em que concluir deslizando podia deixar a animação sem terminar e a tela em branco
4. Tarefas de equipe suportam abandono deslizando
5. A introdução do produto na janela de compra suporta rolagem

**1.82.8 (2021/04/28)**

**novidades**

1. Adicionada exibição da sequência de conclusões atual
2. Otimizado o efeito de contagem regressiva de Itens da Loja, com operações de encerrar e pausar; ao terminar de forma anormal, é calculado em tempo absoluto
3. Suporte para configurar separadamente o modo de vibração e o interruptor de campainha do Pomodoro
4. Suporte parcial para pré-visualizar prazos futuros de eventos em andamento no calendário
5. Suporte para reiniciar eventos únicos e ilimitados
6. Alterada a exibição de dados na página «Eu»: «Vencido» e «Desistir» passam a «Conquista (desbloqueada)» e «Reflexões»; a página de estatísticas exibe o número de «Vencidos» e «Abandonados»
7. Suporte para solicitar diretamente a criação de widgets na página de configurações «widgets da área de trabalho» (apenas Android 8 ou superior)

**melhorias**

1. Suporte para ver imagens ampliadas de Itens da Loja
2. Otimizado o consumo de energia que podia ser causado pela contagem de passos
3. Corrigidos alguns problemas de exibição quando a fonte é muito grande
4. Otimizado o cancelamento de Itens ilimitados
5. Otimizada a exibição de notificações Pomodoro e adicionada barra de progresso
6. Após concluir o evento, remove o lembrete de notificação que estava sendo exibido
7. Otimizadas as estatísticas de receitas e despesas de moedas
8. Adicionados alguns guias e dicas para o usuário
9. Ao editar Itens, suporte para limpar a seleção de Recompensa de produto
10. Ao tratar falhas contínuas, adicionado aviso de «Problemas conhecidos»
11. Otimizado o efeito de exibição quando nenhum Atributo está selecionado

【reparo】

1. Após ordenar a lista na página inicial, o status deve ser atualizado imediatamente
2. Corrigido o problema em que a página de detalhes não atualizava imediatamente a lista de subtarefas
3. Corrigida de forma forçada a falha do login autorizado com Weibo
4. Corrigido o problema em que o nome do Item exibido na notificação Pomodoro podia estar incorreto
5. Corrigido o problema em que a contagem regressiva na notificação Pomodoro era imprecisa
6. Corrigido o problema em que a caixa de Recompensa não aparecia quando o Item e a Conquista tinham apenas Recompensas de mercadoria
7. Corrigido o problema em que não era possível comprar Itens de 0 moedas em certas circunstâncias
8. Otimizado o método de cálculo de reparo de Itens Ebbinghaus
9. Otimizado o método de cálculo do número de conclusões de hoje para eventos ilimitados

**1.82.7 (2021/04/10)**

1. Corrigida a exibição da interface com dados vazios na tela [Moments]
2. O tamanho da fonte volta a seguir as configurações do sistema
3. Atualizada a tradução para inglês e português

**1.82.5 (2021/04/02)**

1. Corrigidos alguns problemas do registro Pomodoro
2. Adicionados novos guias

**1.82.4-alpha01/beta (2021/03/25)**

1. Corrigidas Recompensas de Caixa de saque
2. Ver Reflexões de Tarefas selecionadas
3. Recompensas de Pontos de Experiência/moedas aleatórias para Conquistas personalizadas
4. Tarefas na lista inteligente agora são agrupadas por lista
5. Repetição anual
6. Mais melhorias e correções de erros

**1.82.1 (2021/03/12)**

1. Corrigidos alguns problemas de listas inteligentes
2. Corrigido o problema em que a barra de progresso podia não mudar após concluir uma Tarefa
3. Corrigido um problema ao forçar a conclusão de uma Tarefa de contagem
4. Corrigido o problema em que «NULL» era exibido no diálogo inferior de vencimento

**1.82.0 (2021/03/11)**

1. Listas inteligentes
2. Redesign dos ícones de Atributos
3. Novo efeito de Item «Contagem regressiva»
4. O temporizador Pomodoro continua registrando tempo extra após concluir o temporizador; você pode escolher atualizar o tempo de Foco e obter Recompensa extra.
5. Tarefas de contagem agora podem ser forçadas a concluir sem atingir o objetivo.
6. Agora você pode escolher concluir Tarefas não iniciadas e decidir se adia a hora
7. Mais correções e melhorias

**1.81.6**

1. Corrigidos problemas do aviso de lembrete Pomodoro

**1.81.5 (2021/03/02)**

1. Tradução para italiano (parcial)
2. Corrigido o ícone de notificação
3. Corrigido o lembrete que não funcionava bem com repetição em dias úteis
4. Corrigida a seleção «tirar foto» que não funcionava
5. Mais correções menores

**1.81.0~1.81.4**

1. Redesign de parte da interface e animações
2. A Tarefa é concluída automaticamente quando todas as subtarefas são concluídas
3. Corrigido um bug de alteração múltipla de Pontos de Experiência
4. Corrigido um bug de restauração do Dropbox
5. Agora você pode devolver um Item sem receber moedas
6. Configuração de exibição em formato de 12 horas
7. Congelar/Descongelar várias Tarefas

**1.80.7（2021/01/26)**

1. Adicionadas estatísticas de Itens da Loja
2. Redesign do diálogo de descrição de Atributos
3. Descrição personalizada de Atributos
4. Adicionada configuração do modo compacto: ocultar todas as informações extras
5. Corrigido um bug ao restaurar de arquivo de backup
6. Mais correções e melhorias...

**1.80.6（2021/01/22)**

1. Itens com efeito de Caixa de saque agora podem ser compartilhados no mercado
2. Nova página de busca: agora você pode buscar usuários por apelido
3. Filtrar Itens de equipe/mercado por intervalo de tempo
4. Notificação de adicionar Tarefas rapidamente
5. Arquivos de mídia podem ser ignorados ao fazer backup.
6. Mais correções e melhorias...

**1.80.5（2021/01/14)**

1. Abrir 10/50 Caixas de saque com um clique
2. Adicionada condição de desbloqueio [Obter o Item selecionado um número determinado de vezes de Caixas de saque]
3. Configurações de taxa de juros do ATM
4. Inserir quantidade para vender/comer tomates
5. Efeito sonoro personalizado ao terminar o temporizador de descanso
6. Adicionados alguns guias de usuário
7. Corrigidos alguns problemas e melhorias

**1.80.4（2021/01/04)**

1. Corrigida uma falha no Android 6

**1.80.3（2021/01/04)**

1. Recorte de imagem livre
2. Ver/Adicionar o ícone de Itens no mercado
3. Ao selecionar Tarefa/Item, agora você pode criar um novo diretamente
4. Suporte para ação COPIAR em Conquistas de usuário
5. Muitas correções e melhorias

**1.80.0（2020/12/24)**

1. Efeito de Caixa de saque em Itens da Loja!
2. Integração com backup Dropbox
3. Configurações do modo compacto
4. Adicionada barra de histórico de seleção de fotos
5. Muitas correções e melhorias

**1.79.x（2020/12)**

1. Mais 3 configurações de condições de desbloqueio
2. Configuração de efeitos sonoros personalizados
3. Configurar Recompensa de Item para Conquistas
4. Página de registro do temporizador Pomodoro
5. Criar Tarefa a partir da página Calendário
6. 5 novas cores de tema.
7. Muitas melhorias e correções

**1.78.x（2020/11)**

1. Condição de desbloqueio de Conquistas personalizadas
2. Pontos de Experiência personalizados de Tarefa
3. Muitas melhorias e correções

**1.77.1（2020/11/05)**

1. Barra de ferramentas para trocar de lista
2. Interruptor para exibir Tarefas concluídas
3. Listas agora podem ser arquivadas
4. Adicionado cartão de status de moedas
5. Agora você pode criar Reflexões para Conquistas de usuário
6. Adicionada configuração para seguir o modo noturno do sistema

**1.77.0（2020/10/28)**

1. Adicionado módulo Mercado para a comunidade, onde você pode compartilhar designs de Itens da Loja ou importar Itens
2. Corrigida a lógica de repetição mensal
3. Corrigido o backup automático WebDAV quando não havia sido feito pelo menos um backup

**1.76.0（2020/10/13)**

1. Moedas padrão de subtarefa
2. Adicionados ícones no App para criar Itens da Loja e Conquistas
3. Preço personalizado de tomates
4. Configurações globais para ativar efeitos sonoros
5. Agora Reflexões podem ser buscadas por conteúdo de Tarefa

**1.75.2（Released at 2020/10/05）**

1. Configuração do número padrão de moedas de subtarefa
2. Mais de 100 ícones selecionáveis como ícones de Itens da Loja/Conquistas
3. Adicionada configuração «Ativar efeito sonoro»
4. Filtrar Reflexões por conteúdo de Tarefa e melhor interface de filtros
5. Criar atalhos Pomodoro
6. Preços de venda personalizados de tomates
7. A página Pomodoro mantém a tela ligada durante a contagem regressiva
8. Corrigidos alguns problemas

**1.75.1（Released at 2020/09/20）**

1. Corrigidos muitos bugs da 1.75.0

**1.75.0（Released at 2020/09/16）**

1. Pomodoro gamificado
2. Cor personalizada de etiqueta de Tarefa/lista
3. Backup automático WebDAV
4. Configurações para ocultar módulos
5. Muitas melhorias e correções

**1.74.2（Released at 2020/08/23）**

1. Idioma português

**1.74.0（Released at 2020/08/13）**

1. ATM: Depositar e sacar moedas
2. Agora suporta selecionar Itens da Loja como Recompensa de Tarefa
3. Configuração de quantidade em estoque de Itens da Loja
4. Melhoradas animações e corrigidos alguns bugs
5. Adicionada dica para a configuração de frequência de repetição
6. Mais... (descrição a atualizar)

**1.73.0（Released at 2020/07/26）**

**Novidades:**

- Conquistas de usuário
- Animação de diminuição de Pontos de Experiência
- Editar a hora de conclusão do registro de histórico
- Configuração de moedas de subtarefa de equipe

**Melhorias:**

- Adicionado efeito sonoro de moedas

**Correções:**

- Problema de perda da configuração de moedas de subtarefa ao repetir uma Tarefa

**1.72.1（Released at 2020/06/14）**

**Novidades:**

- Limpar dados de Conquistas

**Melhorias:**

- Melhor exibição da descrição de Itens da Loja

**Correções:**

- Problema ao editar imagens de Itens da Loja
- Problema ao editar o texto de Reflexões

**1.72.0（Released at 2020/06/11）**

**Novidades:**

- Lembrete de subtarefa
- Moedas de subtarefa
- Widget da App
  1. Configuração de opacidade
  2. Exibir número de moedas
  3. Exibir diálogo de entrada de Tarefa de contagem
- Seleção de tempo na página de estatísticas
- Inventário: Devolver Item
- Suporte de subtarefas para equipes

**Melhorias:**

- Deslizar uma Tarefa de contagem agora adiciona 1 conclusão em vez de marcá-la como concluída
- Adicionado botão Ajudar a traduzir
- Adicionada configuração de Recompensa múltipla de Pontos de Experiência para Tarefas de contagem

**Correções:**

- Corrigido que a parte transparente de imagens PNG ficava preta após recortar.
- Corrigido que o widget da App não funcionava bem em alguns dispositivos.
- Corrigido que o número de moedas aparecia na página de detalhes quando estava em 0.
- Corrigido que Deslizar para concluir (sem diálogo) deixava a página mal exibida
- Corrigido que subtarefa não podia ser criada ao pressionar ENTER em alguns dispositivos

**1.71.3/1.71.4（Released at 2020/04/16）**

**Correções menores de ícone e relatório de falha**

**1.71.2（Released at 2020/04/14）**

**Novidades:**

- Idioma turco (obrigado **İbrahim DOĞAN** por ajudar na tradução)

- Personalizar fundo e opacidade do cartão de Tarefa
- Personalizar o texto do botão de ação de Item do Inventário
- Reflexões favoritas
- Busca de Reflexões

**Melhorias:**

- Novo ícone

- O tipo de relatório suporta vários idiomas
- Melhorada a interface da página de Configurações
- Melhorado o método de troca de cor de tema e idioma. Não é mais necessário reiniciar a App.
- Melhorada a página de recorte de imagem
- Melhorada a interface de seleção de lista
- Adicionada descrição de Item da Loja na página de lista da Loja

**Correções:**

- Corrigido bug em que a data de desbloqueio da Conquista era exibida incorretamente
- Corrigido bug em que a imagem do Item da Loja ficava vazia se o arquivo fosse excluído.
- Não limpava o status de subtarefas após uma Tarefa única vencer.
- Corrigido bug por falta de espaço para exibir o Grau de dificuldade na página de detalhes da Tarefa.
- Corrigido bug em que, após marcar uma Tarefa vencida como concluída, as vezes concluídas da próxima Tarefa não somavam um.
- Corrigido bug em que o número máximo de moedas não era exibido corretamente nas configurações padrão de Tarefa.
- A página de backup/restauração de dados agora é rolável.
- Corrigido que deslizar para concluir Tarefa não funcionava bem ao deslizar várias Tarefas rapidamente.
- Widgets da App agora exibem o status Congelado
- Corrigido bug em que a barra de progresso na página de Tarefa às vezes exibia progresso incorreto

**Correções do servidor（2020/4/13）**

- Corrigida a função de relatório que não funcionava

**v1.71.1 (Released at 2020/03/17)**

**Melhorias:**

- Melhor animação da barra de progresso na página de Tarefa

**Correções:**

- Corrigido um bug que podia causar falha ao iniciar a App em alguns dispositivos
- Corrigido um bug ao selecionar fotos

<!-- more -->

**v1.71.0 (Released at 2020/03/13)**

**Novidades:**

- Função Reflexões

- Adicionada ação ao deslizar: Concluir Tarefa (sem diálogo)

**Correções:**

- Corrigido bug em que o status do cartão de Tarefa era exibido incorretamente

- Corrigido bug em que uma Tarefa desfeita podia desaparecer ao vencer

- Corrigido que a ordenação selecionada não era exibida corretamente

**v1.70.6 (Released at 2020/03/09)**

**Melhorias:**

- As cores do aviso de Conquista desbloqueada coincidem com a cor de tema

**Correções:**

- Corrigido que o status do diálogo de vencimento não era exibido corretamente após clicar no botão

- Corrigido um bug em que COPIAR não copiava subtarefas
- Corrigida uma falha ao usar «Mover para...»
- Corrigido que o cartão de seleção não era exibido corretamente em alguns dispositivos

**v1.70.5 (Released at 2020/03/06)**

**Correções:**

- O cartão To-Do continuava carregando ao alterar a cor de tema ou ativar/desativar o modo noturno

**v1.70.4 (Released at 2020/03/05)**

**Melhorias:**

- A página da Loja exibe o número de moedas quando não há Itens
- É possível acessar a página de detalhes de moedas clicando no número na página da Loja
- Melhorado o formato de texto do widget da App em inglês
- É possível acessar a página de detalhes da Tarefa clicando na Tarefa no widget da App

**Correções:**

- Estilo incorreto na atividade de equipe

**v1.70.3 (Released at 2020/03/05)**

**Melhorias:**

- A página da Loja agora exibe o número de moedas quando não há Itens
- Clicar no número de moedas na página da Loja abre a página de detalhes de moedas
- Melhorado o formato de texto em inglês do widget da App
- Clicar em um item do widget da App abre a página de detalhes da Tarefa

**Correções:**

- Corrigido que, ao filtrar Hoje, o aviso inferior «xx tarefa(s) ainda não iniciada(s)» não aparecia após concluir a Tarefa

**v1.70.3 (Released at 2020/03/05)**

**Correções importantes:**

- Corrigidos bugs ao inserir número de moedas
- Corrigidos bugs em que subtarefas não eram atualizadas corretamente
- Corrigidos bugs em que não era possível curtir a atividade de outros
- Corrigidos bugs em que o widget da App não conseguia concluir Tarefas

**v1.70.2 (Released at 2020/03/04)**

**Novidades:**

- A comunidade já está disponível em todos os fusos horários

- Copiar Tarefas
- Suporte para editar configurações padrão de nova Tarefa
- Lista da Loja

- Melhoradas ações do widget da App
- Adicionado menu para Tarefas encerradas na página Calendário

**Melhorias:**

- Melhoradas animações do cartão de Tarefa

- Removida uma permissão desnecessária
- Adicionado som de conclusão
- Melhorado o estilo da interface da página de histórico
- Adicionado diálogo «Permissão de leitura/gravação de calendário perdida» ao ativar lembrete de calendário do sistema sem permissões concedidas

**Correções:**

- Corrigidos bugs de Tarefa de contagem no modo compacto
- Corrigidos bugs de Tarefas repetidas
- Corrigida falha que podia ocorrer ao excluir subtarefas
- Corrigida falha ao inserir URL WebDAV incorreta
- Corrigida exibição incorreta da cor de tema, que podia ocorrer após restaurar um backup


### **LifeUp-Desktop**

**v1.2.0 (2025/01/01)**

**✨ Novidades**

1. Suporte à gestão de arquivos

- Backup no computador
- Restaurar do computador
- Suporte a arrastar e soltar

2. Suporte à criação de novas Reflexões

- Suporte à seleção de imagens
- Suporte à sincronização de imagens com o celular

3. Suporte à visualização de detalhes de Tarefas
4. Melhorias no sistema de compra

- Usar a nova API «Purchase Items»
- Manter limites de compra consistentes com o App

5. Suporte à validação opcional de API Token
6. Suporte multiplataforma

- Windows
- Linux
- macOS (Apple Silicon)
- macOS (Intel) 🆕

7. Melhoria no tratamento de erros e notificações

**v1.1.1 (2023/08/29)**

**🔧 Otimizações e correções de bugs**

1. Corrigido comportamento inesperado ao inserir moedas de ouro
2. Corrigido o problema em que verificar atualizações podia fazer o App fechar inesperadamente

**v1.1.0 (2023/06/25)**

**✨ Novidades**

1. Suporte à verificação automática do endereço IP e da conexão do «LifeUp Cloud» (requer LifeUp Cloud v1.3.0)
2. Suporte à adição de Tarefas, embora as opções atualmente suportadas sejam limitadas (Corrigido [#6](https://github.com/Ayagikei/LifeUp-Desktop/issues/6))
3. Suporte à exportação de Reflexões em formato markdown (Corrigido [#5](https://github.com/Ayagikei/LifeUp-Desktop/issues/5))
4. Adicionado texto em chinês tradicional
5. Adicionada versão de lançamento para macOS
6. Suporte à verificação de atualizações

**🔧 Otimizações e correções de bugs**

1. Corrigido o problema em que subcategorias de Conquistas não eram exibidas corretamente
2. Corrigido o problema em que alguns ícones não eram exibidos corretamente (requer LifeUp v1.91.3)
3. Corrigido o problema de título inconsistente (Corrigido [#8](https://github.com/Ayagikei/LifeUp-Desktop/issues/8))
4. Adicionada opção de atalhos para o instalador do Windows (Corrigido [#13](https://github.com/Ayagikei/LifeUp-Desktop/issues/13))
5. Melhorada a forma de obter o tamanho da janela, adaptado a resoluções inferiores a 1080p

**v1.0.2 (2023/02/20)**

1. Adicionado pop-up de relatório de erros mais detalhado [#2](https://github.com/Ayagikei/LifeUp-Desktop/issues/2)
2. Melhorada a configuração de empacotamento

**v1.0.1 (2023/02/12)**

1. Primeiro lançamento

### **LifeUp Cloud**

**v2.1.1 (2026/06/16)**

**✨ Novidades**

1. Exposto o horário de conclusão de subtarefas (`endTime`) no modelo de dados do SDK e nas respostas da API HTTP.

**v2.1.0 (2026/03/22)**

**✨ Novidades**

1. Adicionado suporte à configuração de locale e atualizações de localização Top-14.
2. Expostos campos de progresso de contagem e condição de término de repetição para Tarefas de API.

**🐛 Correções de bugs**

1. Corrigidos problemas de compatibilidade com ContentProvider.
2. Adaptado comportamento da interface do Android 15 e inicialização do serviço.

**v2.0.0 (2025/01/01)**

**✨ Novidades**

1. Otimização do serviço

- Lógica de descoberta de serviço e compatibilidade aprimoradas
- Mais dispositivos suportam detecção automática de IP
- Otimizadas transições de estado de início/pausa do serviço
- Melhoria no tratamento de erros e notificações

2. Segurança e desempenho

- Adicionada validação opcional de API Token
- Adicionadas opções de configuração CORS
- Suporte a configuração de porta personalizada
- Suporte a duração personalizada de wake lock

3. Melhoria da interface

- Design de interface totalmente novo
- Melhoria da experiência visual geral

**v1.3.0 (2023/06/25)**

**✨ Novidades**

1. Suporte ao registro de serviço mDNS para permitir que o desktop descubra automaticamente seu IP (requer desktop v1.1.0)
2. Adicionados valores de resultado para APIs invocadas via ContentProvider.

**🔧 Melhorias**

1. Ampliada a área clicável do botão de escanear código QR
2. Corrigido crash ActivityNotFound

**v1.2.0 (2023/03/10)**

1. Suporte a escanear código QR para invocar a API
2. Melhorada a exibição da lista de IP

**v1.1.2 (2023/02/12)**

1. Suporte à consulta de dados completos via Content Provider, usado para funções do desktop
2. Padronizado o conteúdo das respostas HTTP

**v1.0.3-preview (2022/11/22)**

1. Primeiro lançamento (mais algumas correções de bugs do primeiro lançamento)

<!-- tabs:end -->
