# Plano de desenvolvimento 2024-2025

> [!WARNING]
> Este é nosso plano de desenvolvimento atual. Faremos o possível para orientar melhorias e atualizações do produto de acordo com este plano. Porém, devido ao ambiente em constante mudança, o conteúdo do plano de desenvolvimento pode ser modificado ou ter adições/subtrações. O lançamento específico do produto prevalece.

### I. Plano de desenvolvimento

> Atualizado: 2025/09/14

| Módulo | Subfunção | Motivo da necessidade | Prioridade | Resultado |
| ---- | ------ | -------- | ------ | ---- |
| Capacidades básicas (1) | Seleção múltipla de Itens e uso automático de Itens ao adquirir | ~ | P0 | ✅ Seleção múltipla lançada na v1.94<br/>✅ Uso automático de Itens lançado na v1.96 |
| Capacidades básicas (2) | Popup de Recompensa generalizado (suporta qualquer número de Atributos e Itens) | ~ | P0 | ✅ Lançado na v1.96; configurações a serem relaxadas em versões futuras |
| Capacidades básicas (3) | Gerenciamento de recursos de som e efeitos sonoros de Itens | ~ | P0 | ✅ Lançado |
| Capacidades básicas (4) | Otimização de notificações | ~ | P0 | ✅ Lançado |
| Adaptação para telas grandes (tablet/dobrável) | Adaptar para tablets e dobráveis com base em Activity embedding | ~ | P1 | ✅ Esperado na v1.95 |
| Widgets | Expansão de widgets (widget de Inventário) | ~ | | ✅ Lançado na v1.94 |
| Integração com calendário | - Sincronização bidirecional Google Calendar<br/>- Sincronização bidirecional calendário do sistema | - Muito feedback internacional.<br/>- LifeUp é uma ferramenta de lista de tarefas com funções sobrepostas, mas inconsistentes, com apps de agenda (calendário). | P1 | 🚧 |
| API | - Expandir capacidades da API para cobrir todas as funções básicas<br/>- Conclusão de recursos do cliente desktop, suportar backup/restauração, etc. | - Ainda faltam muitas APIs como edição.<br/>- LifeUp não pode ser tudo-em-um, mas a API permite personalização e expansão. | P1 | 🚧 Esperado na v1.98.x |
| Conquistas | - Conquistas de tipo repetível | ~ | P2 | ✅ Lançado |
| Sistema de dados | - Backup separado de dados e imagens<br/>- Suportar exportação/importação parcial de dados<br/>- Suportar troca de múltiplos arquivos integrada | - Upload WebDAV de arquivos grandes falha facilmente.<br/>- Exportação/importação parcial pode ser usada para compartilhar sistemas de Recompensas.<br/>- Múltiplos arquivos integrados para testes fáceis sem limpar dados. | P1 | 🚧 |
| Multiplataforma (direção Flutter) | - Continuar aprendendo e usando Flutter para versão multiplataforma | - Desenvolvimento de protótipo da versão iOS | P2 | 🚧 Pausado |
| Multiplataforma (direção KMP) | - Explorar mais possibilidades usando KMP | - Explorar e aprender tecnologia KMP para o futuro | P0 | ✅ Lançado ulives - novo app iOS |

Em resumo:

1. Implementaremos a direção estabelecida anteriormente: estabilidade e otimização de recursos existentes, sem adicionar novos módulos funcionais arbitrariamente.
2. Usaremos uma ou duas versões principais para resolver alguns defeitos funcionais básicos e pontos de dor.
3. Depois prosseguiremos com integração com calendário e Conquistas de tipo repetível.
4. Continuaremos melhorando APIs e outros aspectos.

Multiplataforma será um de nossos objetivos-chave para 2024.

---

### II. Revisão de 2023

A jornada de desenvolvimento meio amador meio lazer do LifeUp passou seu quinto aniversário, entrando no sexto ano. Lançamos centenas de versões, com quase 5000 commits de código apenas no repositório Android.

<br/>

Embora o plano de desenvolvimento proposto em outubro de 2022 focasse em aprofundar o sistema funcional do LifeUp, devido a mudanças ambientais, ainda encontramos muitos obstáculos e problemas ao longo do caminho.

#### 1.1 Ambiente

Exemplos típicos incluem:

- Ser afetados por denúncias falsas de "anti-fraude" em algumas províncias sem canal de recurso, levando várias rodadas para resolver alguns problemas. Mas recentemente houve novamente problemas de denúncias falsas em Shandong, e ainda não encontramos um caminho de recurso ou reprodução.
- Os padrões de revisão do mercado Android doméstico chinês estão aumentando camada a camada, com padrões inconsistentes entre mercados e pessoal, e revisores sendo não profissionais.
  - Alguns mercados de apps frequentemente rejeitam revisões em partes inalteradas.
  - Um mercado de apps V quase rejeitou nosso app LifeUp usando "conformidade de privacidade" como motivo. O mercado exigiu que nosso app solicitasse [ler todas as permissões de arquivo] ou [ler todas as permissões de foto] com explicações correspondentes, para que usuários pudessem selecionar imagens do álbum. Porém, o LifeUp usa uma abordagem mais protetora da privacidade, não precisa de tais permissões, e não lê diretamente arquivos do usuário. Em vez disso, nosso app vai para o app de álbum integrado do sistema e só recebe a imagem selecionada pelo usuário, garantindo máxima proteção de privacidade.
    Mas os revisores não estavam familiarizados com esta melhor prática, e levou vários dias úteis de comunicação com atendimento ao cliente para ser aprovado.

<br/>

Para reduzir o impacto ambiental sobre nós:

Reforçamos o mecanismo de atualização no app e reduzimos a frequência de submissão para revisão de mercado.

A versão doméstica agora suporta atualizações no app e pode alternar entre canais estável ou beta.

![Screenshot_2023-12-09-15-45-33-18_50eeeb96828cbaa](_media/development_plan_2024/Screenshot_2023-12-09-15-45-33-18_50eeeb96828cbaa.jpg)

Também atualizamos o site oficial (https://lifeupapp.fun/en/index.html) como canal alternativo de download.

![image-20231209154445462](_media/development_plan_2024/image-20231209154445462.png)

Para tornar mais conveniente para todos baixarem e instalarem o app pelo site, evitando riscos e atrasos de revisão de mercado.

Requisições de rede no app também adicionaram canais de backup para aliviar e prevenir problemas de acesso causados por denúncias falsas em algumas províncias.

<br/>

Conforme os padrões de revisão ficam cada vez mais rigorosos, e testemunhando vários obstáculos encontrados por outros desenvolvedores independentes no mercado Android doméstico,

pode-se dizer que, para desenvolvedores independentes, a plataforma Android doméstica não é mais o alvo ideal de lançamento.

Afinal, o Android doméstico tem os requisitos de qualificação mais rigorosos e os padrões de revisão mais complexos e **mutáveis**.

> Mas ironicamente, ao mesmo tempo, alguns apps copycat de baixa qualidade conseguem entrar nas prateleiras facilmente e marcar "reinspeção manual aprovada".

Isso pode ser o motivo pelo qual muitos trabalhos de desenvolvedores independentes vistos no Xiaohongshu só têm versões iOS.

Google Play e App Store permanecem a primeira escolha.

> [!TIP]
> Todos podem prestar mais atenção e apoiar aqueles desenvolvedores independentes e pequenas equipes que ainda aderem à plataforma Android doméstica~

<br/>

Então, em 2024:

- Moveremos partes não concluídas do plano anterior para este período, como integração com calendário, Conquistas de tipo repetível, capacidades básicas, sistema de dados, etc.
- O desenvolvimento multiplataforma será um objetivo importante para nós, possivelmente incluindo duas direções:
  - Usar Flutter para replicar o LifeUp (devido a mão de obra limitada, isso será adiantado por nosso colega de backend - Xiao Xiao)
  - Explorar mais possibilidades usando KMP (Kotlin Multiplatform)

#### 1.2 Crescimento de usuários domésticos

Além disso, o LifeUp também teve crescimento significativo de usuários no mercado de apps chinês em 2023. Obrigado a todos pelo apoio!

- Para reduzir o tempo gasto emitindo códigos de resgate manualmente e focar mais no desenvolvimento: Em 2023 conectamos adicionalmente métodos de pagamento automatizados (WeChat, Alipay) e suportamos login WeChat.
  - Isso liberou muito do nosso tempo.

- Em 2023, houve uma disseminação de usuários no Qzone que derrubou nosso servidor por vários dias novamente.
- Também tentamos operar conta pública WeChat, Xiaohongshu, Bilibili, etc., para promover e apresentar atualizações do LifeUp e uso criativo.

- Através de discussões com outros desenvolvedores independentes, descobrimos que a maioria passou por dificuldades similares, acabando por fechar certos canais de mensagens instantâneas e redes sociais. Nos identificamos profundamente.
  - Em grandes empresas, geralmente há equipes dedicadas de atendimento ao cliente ou bots para lidar com inúmeras consultas, transformando-as efetivamente em necessidades específicas ou feedback de problemas para desenvolvedores.
  - **Mas desenvolvedores independentes geralmente têm que arcar com atendimento ao cliente e operações; lidar com usuários irracionais consome 100% do tempo de desenvolvimento deste desenvolvedor independente, afetando, em última instância, o desenvolvedor, o produto e os usuários principais do produto.**
  - Portanto, cada vez mais tendemos a recomendar que usuários forneçam feedback via e-mail, etc.

<br/>

Então, em 2024:

- Continuaremos reduzindo investimento humano em trabalho de consulta repetitivo, e em vez disso melhoraremos documentação e FAQs. Mesmo que consultas existam, serão tratadas uniformemente via e-mail, canal QQ, etc.
- Tentar uma pequena quantidade de operação em redes sociais.

#### 1.3 Crescimento de usuários internacionais

No início de 2022, entramos no Google Play Pass e vimos uma onda de crescimento de usuários.

Mas esse crescimento não durou muito; em meados de 2022, o crescimento de usuários diminuiu gradualmente de forma significativa, sem sinal de melhora.

Como o LifeUp é um app de compra única, o crescimento de usuários é muito importante para nós, e é a base para continuarmos operando e ter a chance de desenvolver em tempo integral no futuro.

Tentamos muitos métodos para melhorar o crescimento:

![image-20231209154347665](_media/development_plan_2024/image-20231209154347665.png)

- Contratamos um designer profissional para redesenhar imagens promocionais da loja
- Melhoramos suporte multilíngue do app e imagens promocionais
- Melhoramos descrição do app
- Melhoramos documentação de primeiros passos
- Aumentamos frequência de atualizações
- ...

Embora implementássemos muitos métodos e melhorássemos alguns indicadores. Ainda não conseguimos retornar a um período de crescimento estável.

Só pudemos deixar como está.

<br/>

A boa notícia é que no final de 2023, parece haver alguma melhora.

<br/>

Então, em 2024:

- Melhorar construção de internacionalização (documentação, suporte de idioma no app, etc.).

#### 1.4 Gestão de qualidade

Como o LifeUp é um app de ferramenta offline desenvolvido e testado apenas por mim, evitar problemas graves de crash é especialmente importante.

O processo de iteração de versão em 2023 levou mais tempo que antes, e reservamos tempo suficiente para testes beta para garantir preparação completa.

![image-20231209154314651](_media/development_plan_2024/image-20231209154314651.png)

Essas medidas parecem prevenir efetivamente a ocorrência de crashes graves em larga escala.

Porém, cada atualização de versão ainda inevitavelmente traz alguns problemas, incluindo alguns em caminhos críticos.

Portanto, continuaremos melhorando a gestão de qualidade do LifeUp, com estabilidade como o indicador mais importante (especialmente sob o ambiente cada vez mais severo e desafios de revisão).

<br/>

Então, em 2024:

- Reforçar gestão de qualidade.

#### 1.5 Aprofundamento de funções

Como mencionado no artigo do terceiro aniversário, o LifeUp é um app que explorou e cresceu gradualmente.

Então coisas como Loja, Conquistas personalizadas, API, tais recursos não estavam no plano inicial, mas foram gradualmente desenvolvidos e adicionados com atualizações e feedback.

Mas isso também introduziu alguns problemas:

- Alguns módulos têm detalhes de planejamento grosseiros.
  - Por exemplo, Recompensas de Itens inicialmente só consideravam Recompensas únicas.
  - Atributos e outros sistemas também não consideraram inicialmente personalização, e só refatoração gradual pôde suportar adições/exclusões e Níveis personalizados, etc.
  - Há muitos problemas assim, como popups de Recompensa/punição de Atributos e exibição de histórico suportam no máximo 3.
- Esses módulos recém-adicionados carecem de análise e planejamento geral para o app.

Continuaremos na direção declarada no artigo do terceiro aniversário, aprofundando os módulos funcionais existentes do app e resolvendo alguns problemas de pontos de dor, em vez de perseguir novos módulos funcionais.

Por exemplo, suportaremos Recompensas de Itens com seleção múltipla direta, melhoraremos mecanismo de backup, otimização de notificações, conclusão de widget, etc.

#### 1.6 API e extensibilidade

Como mencionado acima, não planejamos mais introduzir novos módulos funcionais.

Mas definitivamente haverá demandas para estender o app.

Então introduzimos a função API em 2023.

Fornecemos o núcleo do LifeUp como capacidade de base.

Mesmo que usuários não entendam programação, podem usar ferramentas de automação como Tasker/MacroDroid para estender funções, alcançando capacidades de automação.

Exemplos típicos incluem:

- NFC, QR code para concluir Tarefas
- Check-in automático ao acordar
- Widgets personalizados
- E assim por diante...

Se usuários entendem programação, podem estender ainda mais a jogabilidade ou até Apps a partir disso.

![img](_media/development_plan_2024/desktop.png)

Também desenvolvemos uma versão desktop simples com base em API (e código aberto).

Mesmo após várias versões de expansão de API, ainda nos faltam muitas capacidades.

Por exemplo, não suportar operações relacionadas a "pensamento", não suportar atualização de dados via Content Provider, etc.

Continuaremos expandindo API em 2024 para cobrir cada aspecto do app o máximo possível.

> Embora atualmente vejamos muitos usuários usando API para uso pessoal, ainda há poucos produtos executáveis compartilhados. Precisamos continuar fornecendo capacidades de API mais fortes para construir um ecossistema de API.

#### 1.7 Sobre o futuro

Com os problemas acima e mudanças ambientais, também ajustamos gradualmente o preço de assinatura vitalícia do LifeUp (mesmo assim, o preço de assinatura do LifeUp é muito inferior à maioria dos outros apps), e atualizações gradualmente tenderão a fornecer recursos como recursos de assinatura.

Gradualmente percebemos que apps, em última instância, servem usuários principais.

Feedback e apoio de usuários principais podem, em última instância, ser refletidos em melhorias do app, alcançando co-criação e ciclo positivo entre desenvolvedor e usuários.

Se tentarmos agradar a todos, o app se tornará uma bagunça de código, desviará das demandas dos usuários principais, e reduzirá ganhos e motivação do desenvolvedor.

<br/>

Mencionamos KMP (Kotlin Multiplatform) acima, que é uma tecnologia multiplataforma relativamente emergente. Também pode usar capacidades nativas mistas.

Durante o desenvolvimento do LifeUp, gradualmente tivemos algumas novas ideias. Mas nem todas as ideias podem ou são adequadas para aterrizar no LifeUp.

Por exemplo, substituir toda a UI, mudanças maiores na lógica da Loja, etc., que inevitavelmente impactariam seriamente a experiência dos usuários existentes. Também vimos muitos casos de mudanças grandes de apps levando ao fracasso.

<br/>

Além disso, quando o LifeUp foi inicialmente desenvolvido, o framework oficial de banco de dados "Room" ainda não estava disponível, então escolhemos um framework de banco de dados doméstico de nicho.

Agora alguns problemas de desempenho se tornaram proeminentes, e é difícil substituir.

Adicionalmente, o LifeUp agora suporta tanto Material 3 quanto Material Design legado, além de modo escuro, multilíngue, fragmentação de sistemas de celular doméstico (documentação de configuração de compatibilidade só fica mais longa, sistemas nativos e versões internacionais geralmente só precisam de configuração de página única) e outros problemas. Cada página precisa considerar muitas coisas complexas.

<br/>

Então planejamos explorar KMP para ver se podemos usar alguma tecnologia com KMP.

Também para ter a chance de implementar mais ideias e novos projetos no futuro - mais habilidades não fazem mal.
