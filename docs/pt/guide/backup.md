# Backup e restauração

> [!IMPORTANT]
> O LifeUp é um aplicativo offline-first. A maior parte dos seus dados pessoais fica no seu dispositivo. Se o backup não estiver configurado, desinstalar o app, trocar de celular ou danos no dispositivo podem causar perda permanente de dados.

## Navegação rápida

- [Por que o backup importa](#why-backup)
- [Como configurar métodos de backup](#configure-methods)
- [Como fazer backup](#how-to-backup)
- [Como restaurar](#how-to-restore)
- [Migração para celular novo](#phone-migration)
- [Problemas comuns](#common-issues)

## 1) Por que o backup importa :id=why-backup

### De quais riscos você está se protegendo?

A maioria dos usuários perde dados em uma destas situações:

1. Desinstalação do app (arquivos no caminho padrão de backup podem ser removidos pela limpeza do sistema)
2. Migração de celular sem mover os arquivos de backup
3. Danos ou perda do dispositivo

Um backup confiável significa que seus dados existem em outro dispositivo ou meio de armazenamento, não apenas no mesmo celular.

### O que está incluído em um backup?

Backups incluem seus dados locais principais, como Tarefas, Atributos, dados da Loja, Conquistas, Reflexões, registros Pomodoro e configurações. Arquivos de mídia (anexos, ícones, fundos, áudio) também podem ser incluídos.

> [!TIP]
> Se o tamanho do backup passar de 10 MB, ative "Ignorar arquivos de mídia/imagem" ou aumente o intervalo de backup para maior estabilidade.

## 2) Como configurar métodos de backup :id=configure-methods

Para a maioria dos usuários, esta prioridade funciona melhor:

| Método | Recomendado | Ideal para | Backup automático | Observações |
| --- | --- | --- | --- | --- |
| Google Drive | ⭐⭐⭐⭐⭐ | Uso diário, sincronização fácil na nuvem | Sim | Autorização com um toque no app |
| Dropbox | ⭐⭐⭐⭐ | Uso diário, sincronização entre dispositivos | Sim | Também suporta autorização no app |
| Exportação local (caminho personalizado) | ⭐⭐⭐⭐ | Cópia manual para PC / NAS | Não (manual) | Fallback confiável e arquivos versionados |
| WebDAV | ⭐⭐⭐ | Auto-hospedagem / serviço WebDAV existente | Sim | Boa alternativa se você já usa WebDAV |
| Backup automático na pasta Download (Android 10+) | ⭐⭐⭐ | Reduzir risco de desinstalação | Sim | Não protege contra danos no dispositivo |

<details>
<summary>Configurar backup automático no Google Drive / Dropbox (recomendado)</summary>

No app, acesse:
`Barra lateral → Configurações → Backup/Restauração/Limpeza de dados`

Depois:

1. Autorize o Google Drive ou Dropbox
2. Em "Configuração de backup na nuvem", selecione seu método
3. Ative "Ativar backup automático na nuvem"
4. Defina "Intervalo de backup automático"
5. Opcionalmente, ative "Ignorar arquivos de mídia/imagem"

</details>

<details>
<summary>Configurar backup na nuvem via WebDAV (opcional)</summary>

Se você usa um serviço compatível com WebDAV:

1. Abra `Configuração WebDAV`
2. Preencha URL, conta e senha
3. Execute um teste de conexão
4. Use WebDAV como método de backup na nuvem

</details>

<details>
<summary>Exportar para caminho personalizado (fallback manual)</summary>

Use quando quiser backups manuais e portáveis:

1. Toque em `Backup`
2. Escolha `Caminho personalizado`
3. Salve o arquivo gerado (geralmente `.lfbak`)
4. Copie para PC / NAS / armazenamento na nuvem

> [!WARNING]
> Não mantenha seu único backup no mesmo celular.

</details>

## 3) Como fazer backup :id=how-to-backup

<details>
<summary>Executar fluxo de backup automático diário</summary>

1. Conclua uma configuração na nuvem (Google Drive ou Dropbox)
2. Ative backup automático na nuvem e o intervalo
3. Dispare um backup manual uma vez para verificar se tudo funciona
4. Verifique periodicamente a dica de "último backup"

</details>

<details>
<summary>Fazer backup manual antes de alterações críticas</summary>

Crie uma exportação local extra antes de:

- atualizações importantes do app
- reset/reflash do sistema
- migração de celular

Use: `Backup → Caminho personalizado`, depois copie o arquivo para armazenamento externo.

</details>

## 4) Como restaurar :id=how-to-restore

<details>
<summary>Restaurar a partir de backup na nuvem (Google Drive / Dropbox / WebDAV)</summary>

1. Configure a mesma conta/método na nuvem no dispositivo de destino
2. Toque em `Restaurar` e escolha esse método
3. Confirme a restauração (o app será reiniciado)

> [!WARNING]
> A restauração sobrescreve os dados locais atuais. Se os dados atuais forem importantes, exporte um backup local primeiro.

</details>

<details>
<summary>Restaurar a partir de arquivo de backup local</summary>

1. Mova o arquivo de backup para o dispositivo de destino
2. Toque em `Restaurar → Caminho personalizado`
3. Selecione o arquivo de backup e confirme

Você também pode ativar "Suportar sistema de arquivos para abrir arquivos de backup" para importar diretamente do gerenciador de arquivos ou apps de compartilhamento.

> [!TIP]
> Se a restauração falhar com erro de leitura/gravação, tente outro caminho de arquivo e selecione o arquivo novamente.

</details>

### Migração para celular novo :id=phone-migration

<details>
<summary>Migrar para um celular novo (sistema ou caminho de backup)</summary>

#### Opção A: Usar migração integrada do celular primeiro

Alguns celulares suportam migração completa de dados do app (ferramentas de migração da marca / clone do sistema).

1. Execute a migração do sistema do celular antigo para o novo.
2. Abra o LifeUp e verifique os dados principais (Tarefas, Atributos, dados da Loja, Conquistas).
3. Mesmo que a migração pareça correta, crie um backup novo no celular novo.

#### Opção B: Migrar via backup na nuvem ou arquivo de backup (universal)

1. No celular antigo, crie um backup novo primeiro.
2. No celular novo, instale o LifeUp.
3. Para migração na nuvem: configure o mesmo método/conta na nuvem, depois restaure.
4. Para migração por arquivo: transfira o arquivo de backup, depois use `Restaurar → Caminho personalizado`.
5. Após a restauração, dispare um backup manual para verificar a cadeia de backup no celular novo.

> [!WARNING]
> A restauração sobrescreve os dados locais. Se o celular novo já tiver entradas novas importantes, exporte primeiro.

</details>

## 5) Problemas comuns :id=common-issues

<details>
<summary>Corrigir erro de restauração: arquivo de backup inválido</summary>

- Confirme que o arquivo foi gerado pelo LifeUp.
- `.lfbak` é o formato recomendado.

</details>

<details>
<summary>Corrigir erro de restauração: arquivo de backup com versão superior</summary>

Atualize o LifeUp para a versão mais recente e restaure novamente.

</details>

<details>
<summary>Melhorar backup na nuvem lento ou instável</summary>

- Ative "Ignorar arquivos de mídia/imagem".
- Aumente o intervalo de backup automático.
- Limpe arquivos de mídia não usados antes do backup.

</details>

<details>
<summary>Decidir se backup automático na pasta Download é suficiente</summary>

- Ajuda contra perda relacionada à desinstalação.
- Não cobre danos ou perda do dispositivo.
- Estratégia mais segura: combine backup na nuvem + exportação local periódica.

</details>
