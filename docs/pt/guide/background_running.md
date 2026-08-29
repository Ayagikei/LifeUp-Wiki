# Manter o LifeUp em execução em segundo plano

## Por que isso é necessário

Alguns fabricantes de celular restringem agressivamente apps em segundo plano para melhorar resultados de benchmark de bateria. Como resultado, recursos que dependem de execução em segundo plano podem falhar.

### Matriz de impacto de compatibilidade

| Recurso | Requer manter ativo em segundo plano? | Permissões extras | Observações |
| --- | --- | --- | --- |
| Lembrete de Tarefa (notificação do sistema) | ✔️ | Permissão de notificação | Este é o método padrão de lembrete. Se os lembretes atrasarem ou não aparecerem, configure a execução em segundo plano e verifique se as notificações estão ativadas para o LifeUp. |
| Lembrete de Tarefa (evento de calendário) | ✖️ | Permissão de leitura/gravação de calendário | Você pode alternar para este modo em `Configurações` → `Tarefas` → `Alterar sistema de lembretes`. |
| Lembrete de fim do Pomodoro | ✔️ | - | Se a execução em segundo plano não estiver configurada, lembretes podem ser perdidos, e a contagem regressiva pode pausar ou congelar em segundo plano. |
| Temporizador progressivo | ✖️ | - | - |
| Atualização automática do widget do App | Geralmente sim (depende do dispositivo/SO) | - | Sem execução adequada em segundo plano, widgets podem ficar em "Carregando" ou mostrar estados desatualizados como "Todas as Tarefas concluídas". |
| Ação do widget: concluir Tarefa de contagem / abrir detalhe da Tarefa (não-MIUI) | ✖️ | - | - |
| Ação do widget: concluir Tarefa de contagem / abrir detalhe da Tarefa (MIUI) | Depende | Pode exigir permissão MIUI de popup/exibição em segundo plano | O MIUI pode bloquear ações de UI acionadas pelo widget em segundo plano. |

- Alguns sistemas congelam ou encerram Tarefas em segundo plano quando a tela está desligada.
- Widgets podem se comportar de forma diferente entre launchers e variantes do SO.
- Se você só se importa com lembretes, pode alternar para lembretes de calendário para reduzir a dependência de segundo plano.

## Como configurar

> [!WARNING]
> Essas configurações podem aumentar levemente o consumo de bateria.

Com base em nossos testes em um OnePlus 8T, o uso em segundo plano por 24 horas consumiu cerca de **30 mAh**. Para a maioria dos usuários, isso é um impacto pequeno.

O LifeUp realiza apenas operações passivas limitadas em segundo plano, como lembretes, atualizações de widget e temporização Pomodoro.

---

### Passos comuns de configuração

#### Configurações gerais

> Você não precisa concluir todos os passos. Cada passo pode melhorar a prioridade e a estabilidade em segundo plano.

**Configurações do sistema Android**

1. No LifeUp, abra `Barra lateral` → `Configurações` → `Problemas de compatibilidade`, depois toque em `Ir para configurações de otimização de bateria`. Encontre o LifeUp e defina como **Não otimizar**.

   a. Em alguns dispositivos, o LifeUp pode não aparecer após ir para esta página. Nesse caso, pule este passo.

2. Se precisar de lembretes, garanta que a permissão de notificação foi concedida ao LifeUp.

3. (Opcional) Nas configurações de Tarefas, ative `Notificação de adição rápida`.

<br/>

**Gerenciador de segundo plano do fabricante (Gerenciador do celular)**

Muitos fabricantes adicionam restrições extras de segundo plano. Se você não usa um dispositivo estilo Pixel/AOSP, geralmente precisa de configuração adicional.

1. Trave o LifeUp na tela de multitarefa/apps recentes do sistema.

2. No gerenciamento de apps do sistema / gerenciamento de bateria / gerenciador do celular, defina o LifeUp para permitir execução em segundo plano (sem restrições) e permitir inicialização automática.

   a. Para guias específicos por fabricante, veja [dontkillmyapp.com](https://dontkillmyapp.com/).

3. Ao usar recursos do LifeUp, evite modos agressivos como super economia de energia ou políticas rígidas de não perturbe, ou adicione o LifeUp às listas de permissão relevantes.

<br/>

**Ainda não funciona?**

Com base em relatos de usuários e nossos testes, o LifeUp funciona normalmente em dispositivos populares após a configuração correta. Porém, atualizações do sistema podem mover ou renomear configurações.

1. Revise todos os passos acima e preencha configurações que faltaram.

   a. Restrições do gerenciador do celular costumam estar espalhadas em várias páginas e não aparecem como permissões padrão de app.

   b. Tente passos opcionais (por exemplo, ativar notificação persistente) e teste novamente.

   c. Pesquise nas configurações do sistema por otimização de bateria, restrições de segundo plano, inicialização automática e opções de popup/exibição em segundo plano.

   d. Se você só se importa com lembretes, tente o modo `Lembrete de calendário`.

2. Pergunte a outros usuários com a mesma marca/modelo de celular na comunidade, e inclua sua versão do SO.

3. Entre em contato com o suporte do fabricante do celular e pergunte como evitar que um app específico seja encerrado em segundo plano.

---

### Widgets do App não funcionam

1. Abra o LifeUp primeiro e mantenha-o em primeiro plano por um momento.
2. Adicione o widget novamente (se necessário, tente mais de uma vez).
3. Se falhar de novo depois, revise este guia e verifique novamente as configurações de execução em segundo plano.
4. Se você usa um launcher de terceiros, mude para o launcher do sistema e teste novamente.
5. Se você usa um tema personalizado, mude para o tema padrão do sistema e teste novamente.
6. Reinicie o celular.
7. Tente outro launcher para descartar problemas específicos do launcher.
