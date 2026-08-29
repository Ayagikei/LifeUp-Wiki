# Plano de desenvolvimento 2026-2027

> [!WARNING]
> Este é nosso plano de desenvolvimento atual. Faremos o possível para orientar melhorias e atualizações do produto de acordo com este plano. Porém, devido ao ambiente em constante mudança, o conteúdo do plano de desenvolvimento pode ser modificado ou ter adições/subtrações. O lançamento real do produto prevalece.

### I. Plano de desenvolvimento

> Atualizado: 2026/04

Diferente de 2024-2025, esperamos continuar melhorando módulos existentes do LifeUp e **ulives** em 2026-2027, em vez de adicionar módulos funcionais totalmente novos.

| Módulo | Subfunção | Motivo da necessidade | Prioridade | Resultado |
| ---- | ------ | -------- | ------ | ---- |
| Integração com calendário | - Sincronização bidirecional Google Calendar<br/>- Sincronização bidirecional calendário do sistema | - Muito feedback internacional.<br/>- LifeUp é uma ferramenta de lista de tarefas com funções sobrepostas, mas inconsistentes, com apps de agenda (calendário). Desenvolver todos os recursos de calendário no LifeUp seria enorme. Integração externa pode ser uma solução melhor. | P0 | 🚧 |
| Otimização do recurso de Síntese | - Integração com a Loja<br/>- Filtragem aprimorada | - Síntese é um dos recursos centrais do LifeUp. Otimizar continuamente sua integração com a Loja e eficiência de filtragem para melhorar a conveniência do usuário. | P0 | ✅ Lançado |
| Otimização do recurso de Itens | - Efeitos de uso mais ricos (modificar quantidades de outros Itens)<br/>- Acionar efeitos sonoros<br/>- Suportar limites de uso<br/>- Condições de limite expandidas | - O sistema de Itens é central para a gamificação do LifeUp. Atualmente sendo ajustado na v1.103, aprimorando continuamente flexibilidade e jogabilidade de Itens. | P0 | 🚧 Ajuste v1.103 |
| Otimização do recurso de Atributos | - Subcategorias de Atributos (agrupamento)<br/>- Suporte a sistema de títulos<br/>- Suportar tipo [Status]<br/>- Otimização da página de status<br/>- Widget de Nível de vida | - O sistema de Atributos é outro núcleo da gamificação. Continuaremos melhorando o sistema de Atributos com mais personalização dimensional e exibição. | P0 | 🚧 Subcategorias lançadas, outros em planejamento |
| Otimização do recurso de Tarefas | - Edição e filtragem explícita de tags<br/>- Otimização da interação de edição de subtarefas<br/>- Comportamento personalizado de conclusão forçada de subtarefas<br/>- Comportamento personalizado de atraso ou adiamento | - Tarefa é o recurso central do LifeUp, otimizando continuamente edição e experiência de interação de Tarefas. | P1 | 🚧 |
| Recompensas em lote de Tarefas de contagem | - Suportar resgate de Recompensas em lote para Tarefas de contagem | - O mecanismo atual de Recompensa de Tarefa de contagem é relativamente simples, Recompensas em lote podem fornecer incentivos de meta mais flexíveis. | P1 | 🚧 |
| Otimização do recurso de Reflexões | - Suportar mais estilos de navegação | - O recurso de Reflexões é característico do LifeUp, otimizando continuamente sua exibição e interação. | P2 | 🚧 |
| Expansão de Conquistas | - Estatísticas de tipo semanal/mensal/anual<br/>- Desbloquear outras condições de Conquistas | - O sistema de Conquistas precisa de condições de desbloqueio mais diversas para experiência de Conquistas mais rica. | P2 | 🚧 |
| Sistema de dados | - Backup separado de dados e imagens<br/>- Suportar exportação/importação parcial de dados<br/>- Suportar troca de múltiplos arquivos integrada | - Upload WebDAV de arquivos grandes falha facilmente, serviços de nuvem gratuitos têm limites de tráfego, backup completo com imagens é muito grande.<br/>- Exportação/importação parcial pode ser usada para usuários compartilharem sistemas de Recompensas.<br/>- Múltiplos arquivos integrados permitem que usuários alternem diretamente entre sistemas para depuração sem limpar dados repetidamente. | P1 | 🚧 |
| API | - Expandir capacidades e cobertura da API para todas as funções básicas | - Ainda faltam algumas APIs como algumas operações relacionadas a reflexões.<br/>- LifeUp não pode ser tudo-em-um, mas a API permite que todos personalizem e expandam seu LifeUp, e realizem comunidade open source. | P1 | 🚧 |
| Desenvolvimento **ulives** | - Continuar melhorando recursos do **ulives**<br/>- Explorar suporte multiplataforma (iOS/iPadOS/macOS/outros) | - **ulives** é o produto de próxima geração do LifeUp, desenvolvido com tecnologia multiplataforma moderna.<br/>- No futuro, pode cruzar Android ou outras plataformas. | P0 | 🚧 |

Em resumo:

1. Continuaremos seguindo a direção estabelecida, focando em estabilidade e otimização de recursos existentes.
2. Melhorar continuamente a profundidade funcional de cada módulo para aprimorar a experiência do usuário.
3. Avançar o desenvolvimento do **ulives** e explorar mais suporte de plataforma.
4. Continuar melhorando APIs e outros aspectos.

---

### II. Revisão e perspectivas

#### 2.1 Sobre o **ulives**

Em 2025, lançamos o **ulives** no iOS como produto de próxima geração do LifeUp. Alguns usuários podem se perguntar: por que lançar um app novo? Por que pagar de novo?

Aqui estão nossos pensamentos e explicações:

**Restrições de tecnologia e arquitetura**

O LifeUp é desenvolvido com base em tecnologia Android e acumulou muita lógica e problemas históricos de compatibilidade durante seu desenvolvimento. Dadas as restrições de arquitetura técnica, é quase impossível replicar uma versão idêntica no iOS ou HarmonyOS mantendo compatibilidade de dados.

Além disso, o LifeUp se desenvolveu gradualmente, com alguns designs de produto comprometidos por compatibilidade e decisões de design iniciais, que talvez não possamos mudar facilmente. Por exemplo:

- **Moeda personalizada**: A base do LifeUp é um tipo de moeda, tornando mudanças arquiteturais maiores difíceis.
- **Módulo Mundo**: No início do desenvolvimento do LifeUp, devido a cooperação do lado servidor, planejamos adicionar este módulo, mas a maioria dos recursos não foi considerada a fundo, resultando em falta de recursos de equipe agora.

Criar algo novo nos permite ver isso de uma nova perspectiva de produto com conceitos modernos.

**Dívida técnica**

Tecnologicamente, o LifeUp também pisou em algumas minas:

- Usar um framework ORM de banco de dados adequado para desenvolvimento rápido inicial, mas basicamente sem manutenção, tornando migração difícil.
- A base nem suporta índices compostos, causando gargalos de desempenho.
- Gastamos esforço considerável otimizando continuamente o desempenho do app sob grandes volumes de dados.

Para o **ulives**, usamos tecnologia multiplataforma moderna (Kotlin Multiplatform) para reexaminar e desenvolver esses aspectos. Possibilidades futuras incluem cruzar Android ou outras plataformas (atualmente só suporta iOS, iPadOS e macOS).

**Custo e preços**

O preço único baixo inicial do LifeUp e o posicionamento de plataforma única nos deixaram com controle de custo limitado para recursos que exigem investimento (como Módulo Mundo ou recursos de IA).

O preço baixo do LifeUp (Android) baseia-se em custos de manutenção de plataforma única. O **ulives** pode ter alguns ajustes e mais planejamento.

Como as equipes de desenvolvimento são diferentes, é um re-desenvolvimento completo, e o **ulives** atualmente é totalmente offline. De fato não podemos compartilhar assinaturas ou dar descontos extras, e talvez não forneçamos tais descontos no futuro para evitar prejudicar usuários pagantes.

---

#### 2.2 Eficiência com IA

Nos últimos anos, testemunhamos o desenvolvimento em boom do desenvolvimento assistido por IA, onde muitos desenvolvedores podem usar IA para desenvolver app após app em pouco tempo.

De fato, também tentamos usar IA em nosso processo de desenvolvimento para implementar rapidamente frameworks principais funcionais e scaffolding de código. Porém, a IA não é onipotente — determinar rotas de solução técnica, aceitação final e garantir que tudo funcione ainda requer esforço humano significativo.

O que realmente leva tempo é polir os detalhes. Especialmente para otimização de animação na plataforma iOS, ajuste de suavidade de interação, tratamento de casos extremos — o tempo investido aqui costuma ser várias vezes o da lógica funcional em si.

---

#### 2.3 Extensões de usuários e integração com IA

Também vimos muitos usuários implementar funções interessantes usando IA combinada com a API do LifeUp:

- Alguns usam MCP (Model Context Protocol) para conectar o LifeUp com várias cadeias de ferramentas de IA
- Alguns combinam o LifeUp com apps de notas como Obsidian para automação de fluxo de trabalho
- Alguns implementam suas próprias ferramentas web e scripts de automação através de APIs

Continuamos a receber usuários compartilhando métodos de extensão baseados em IA, e esperamos ver mais ideias interessantes!

---

#### 2.4 Ritmo de desenvolvimento e qualidade

Insistimos na manutenção de longo prazo do LifeUp, **ulives** e nossos outros apps. Já temos planos e objetivos de desenvolvimento de vários anos para o LifeUp, e continuaremos avançando.

Não perseguiremos lançar rapidamente novos recursos ignorando qualidade e estabilidade. Cada recurso passa por design cuidadoso, desenvolvimento, testes e otimização para garantir que o produto final entregue resista ao teste do tempo.

É por isso que escolhemos investir mais tempo em aprofundar e otimizar recursos existentes, em vez de lançar continuamente novos módulos funcionais.

---

#### 2.5 Destaques da comunidade

Tivemos a sorte de encontrar muitos usuários incríveis:

- Um usuário encontrou um problema estranho de crash do LifeUp. Após várias rodadas de troca de informações, exportou seu log do sistema (bugreport) e usou IA para analisar que foi causado por corrupção de dados do calendário do sistema. Como o LifeUp usa notificações de calendário, foi erroneamente encerrado pelo sistema. Isso nos ajudou a identificar este problema de compatibilidade em nível de sistema extremamente obscuro.
- Muitos usuários compartilharam suas criações, incluindo sistemas de Tarefas interessantes, designs de Itens, compartilhamento de Conquistas e outro conteúdo da comunidade.

O apoio avassalador de nossos usuários é o que nos impulsiona a continuar mantendo e atualizando nossos produtos.

---

> Prévia: Em 2025 também lançamos o **ulives**, desenvolvido usando Kotlin Multiplatform, atualmente suportando apenas iOS, iPadOS e macOS, com planos de suportar mais plataformas no futuro.
