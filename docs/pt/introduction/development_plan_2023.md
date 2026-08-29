# Plano de desenvolvimento 2022/10 - 2023/12

> [!WARNING]
> Este é um plano de desenvolvimento expirado, mantido apenas para arquivo e referência. O ambiente continua mudando, e nossos planos se ajustarão de acordo. Este plano indica amplamente nossa direção de desenvolvimento, mas não prometemos executá-lo completamente, e também podemos desenvolver além do plano.

<br/>

O desenvolvimento do LifeUp nos anos anteriores sempre focou em desenvolver novos módulos funcionais ou adicionar novos recursos a módulos existentes.

Hoje, acreditamos que os módulos funcionais do LifeUp têm largura autoconsistente suficiente, mas são insuficientes em profundidade.

Portanto, os seguintes objetivos de desenvolvimento visam profundidade funcional, melhorando continuamente módulos existentes disponíveis, aumentando a praticidade (integração com calendário, widgets, estatísticas);

E expandindo continuamente a funcionalidade das APIs para que possam ser totalmente estendidas para várias funções externas.
Além disso, tentar melhorar nosso sistema de dados e explorar o uso do Flutter para desenvolver versões multiplataforma.

<br/>

- **2023/01/26**
  - Adicionado item "Lado PC LAN" em "Multiplataforma", também adicionada explicação correspondente em "APIs".
  - Ajustada versão estimada de "Integração com calendário", progresso pode atrasar.
  - Ajustada versão estimada de "Experiência necessária personalizada", progresso pode adiantar.
- **2022/10/16**
  - **Adicionado roadmap para Atributos, Conquistas e Capacidades básicas**

| Módulo | Subfunção | Versão estimada | Motivo da necessidade | Prioridade | Resultado |
| ---- | ------ | -------- | ------ | ---- | ---- |
| Integração com calendário | - Sincronização bidirecional Google Calendar<br/>- Sincronização bidirecional calendário do sistema | v1.91~1.93 | - Muito feedback internacional.<br/>- LifeUp é uma ferramenta de lista de tarefas com funções sobrepostas, mas inconsistentes, com apps de agenda (calendário). Desenvolver todos os recursos de calendário no LifeUp seria enorme. Integração externa pode ser uma solução melhor. | P0 | ~ |
| Widgets | - Widget de Atributos<br/>- Widget de Itens<br/>- etc... | v1.92~1.95 | - Usabilidade.<br/>- Widgets bonitos também proporcionam um nível de gamificação e motivação. | P1 | ~ |
| Estatísticas | - Estatísticas de vários indicadores<br/>- Estatísticas detalhadas Pomodoro<br/>- Gerar cartões para compartilhar | v1.92~1.95 | - Estatísticas Pomodoro insuficientes.<br/>- Módulo de estatísticas não foi melhorado há muito tempo, design e dados estão desatualizados.<br/>- Cartões para compartilhar adequados para compartilhamento externo do usuário, podem trazer incentivos e atrair mais usuários em certa medida (requer design de UI requintado). | P1 | - Esperado desenvolver alguns cartões de estatísticas na v1.91 |
| APIs | - Desenvolver SDK<br/>- Suportar consultas de lista<br/>- Mais APIs comuns | v1.91~1.95 | - Falta interface de dados de lista. Após suportar consulta de lista, terceiros podem desenvolver UI personalizada (como lista de Tarefas), extensibilidade pode ser muito ampliada.<br/>- Com base nas interfaces acima, desenvolver SDKs correspondentes e lado PC LAN.<br/>- LifeUp não pode ser tudo-em-um, mas a API permite que todos personalizem e expandam seu LifeUp, e realizem comunidade open source. | P1 | - Esperado fornecer primeira versão de API de consulta na v1.91 |
| Atributos | - Experiência necessária personalizada | v1.91~1.92 | ~ | P2 | - Esperado concluir desenvolvimento na v1.91 |
| Conquistas | - Conquistas de tipo repetível | v1.94~1.97 | ~ | P2 | ~ |
| Capacidades básicas | - Edição em lote (Tarefas, Conquistas, etc.)<br/>- Seleção múltipla de Itens, empacotamento automático em caixas, etc. | v1.94~1.97 | ~ | P1 | ~ |
| Sistema de dados | - Backup separado de dados e imagens<br/>- Suportar exportação/importação parcial de dados<br/>- Suportar troca de múltiplos arquivos integrada | ~ | - Upload WebDAV de arquivos grandes falha facilmente, serviços de nuvem gratuitos têm limites de tráfego, backup completo com imagens é muito grande.<br/>- Exportação/importação parcial pode ser usada para usuários compartilharem sistemas de Recompensas.<br/>- Múltiplos arquivos integrados permitem que usuários alternem diretamente entre sistemas para depuração sem limpar dados repetidamente. | P1 | ~ |
| Multiplataforma | - Continuar aprendendo e usando Flutter para desenvolver versão multiplataforma | Lado PC LAN: v1.91-1.92<br/>Flutter: v2.0 | - Desenvolvimento de protótipo da versão iOS.<br/>- Mais inclinados a explorar novas implementações do que replicar um a um a versão Android.<br/>- Talvez adequado para Windows/macOS e outras plataformas, precisa investigar.<br/>- Desenvolver lado PC LAN com base em APIs (versão lendo dados do celular). | P1 | - Esperado fornecer primeira versão do lado PC na v1.91 |
