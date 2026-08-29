# Termos e política de privacidade da App *LifeUp*

?> A descrição a seguir do servidor da aplicação não se aplica à versão Lite. A versão Lite não tem nenhuma interação com o servidor da aplicação.

LifeUp é um App que ajuda você a melhorar sua vida. Respeitamos sua privacidade e estamos comprometidos em proteger suas informações pessoais. Esta política de privacidade explica como coletamos, usamos, compartilhamos e excluímos suas informações pessoais quando você usa nosso App.

### 1. Informações pessoais

LifeUp é um App offline-first. Não coletamos ativamente dados do usuário, como seu nome ou endereço de e-mail. Você pode, opcionalmente, fornecer alguns dados para autorizar login e acessar o módulo Mundo, autorizar Google Drive ou Dropbox para obter recursos de backup na nuvem, etc.

Usamos Google Firebase e Sentry para coletar relatórios de problemas e dados de desempenho apenas para fins analíticos.

Aqui estão alguns resumos de dados:

- **Apelido, avatar, gênero**
  Opcionais, usados para a função de login para acessar o módulo "Mundo"; serão transferidos ao servidor para armazenamento, mas podem ser alterados e excluídos
- **E-mail**
  Opcional, para sincronização com Google Drive; armazenamento local, não transmitido ao servidor
- **URL, conta e senha do WebDAV**
  Opcionais, para sincronização WebDAV; armazenamento local criptografado, não transmitido ao servidor
- **Informações de crash, dados de desempenho**
  Transmitidos a provedores de serviço (Google Firebase, Sentry) para análise de problemas e desempenho, mas nunca vinculados a identificadores de usuário ou dispositivo, nem contêm dados do usuário

Os métodos detalhados de coleta e processamento de dados para cada função estão descritos abaixo.

#### 1.1 Informações do usuário (autorização de terceiros)

##### Login com Google/Facebook

**Somente depois que você confirmar a autorização para fazer login,** criaremos uma conta com o apelido e a foto de perfil que você autorizou fornecer (e não incluirá informações como contas de e-mail).

##### Google Drive

Como os backups do Google Drive dependem de endereços de e-mail, o *LifeUp* solicitará permissão de endereço de e-mail quando você autorizar o Google Drive. **Mas esse endereço será usado apenas localmente; o *LifeUp* não o repassará ao servidor da aplicação nem o armazenará lá.**

E o *LifeUp* solicita apenas armazenamento específico do App, o que significa que não temos permissão para acessar seus arquivos privados.

##### Dropbox

Depois que você autorizar o Dropbox, **as informações relevantes ficarão apenas no seu dispositivo para backup e não serão repassadas ao servidor da aplicação.**

E o *LifeUp* solicita apenas **armazenamento específico do App, o que significa que não temos permissão para acessar seus arquivos privados.**

##### Servidor WebDAV

**Sua URL, conta e senha do WebDAV serão armazenadas apenas localmente e não serão enviadas ao servidor da aplicação.** A senha é armazenada criptografada no banco de dados.

##### Modo offline

***LifeUp* também funciona plenamente no modo offline; apenas não pode acessar o módulo "Mundo".**

No modo offline, **você não precisa enviar nenhuma informação ao nosso servidor da aplicação.**
**Seu apelido, avatar e outras informações serão armazenados e disponíveis localmente.**

Podemos solicitar ao servidor da aplicação apenas os anúncios e atualizações mais recentes, que não envolvem envio de informações.

Suas interações com outros SDKs, como Dropbox, Google Drive e Facebook, responderão normalmente sob seu uso ativo.

No uso offline, ainda podemos usar Google Firebase e Sentry para coletar relatórios de crash e problemas, mas conforme explicado abaixo, **essas informações não contêm dados do usuário e não estão vinculadas a informações do usuário. Apenas para análise de desempenho e resolução de crashes, e armazenadas temporariamente.**

Também nos comunicaremos com Google Play Services para verificar sua licença conforme solicitado pela Google Play.

Se quiser negar toda a comunicação acima, você pode desativar diretamente a permissão de rede do LifeUp. Isso não afeta o uso do LifeUp em si, mas pode afetar a funcionalidade de SDKs como Google Drive.


#### 1.2 Permissões

#### Armazenamento

A aplicação **não solicitará permissão de leitura do espaço de armazenamento**, portanto não lerá nenhum arquivo que você não autorizar.

A aplicação solicitou permissão de câmera para facilitar o uso de anexos de imagem, upload de avatares e outras funções, e **só poderá chamar a câmera depois que o usuário conceder as permissões.**

Por exemplo, quando você seleciona uma imagem anexada, chamamos diretamente o framework de armazenamento de arquivos do sistema para acessá-la.

Ele autorizará o *LifeUp* apenas para o arquivo único que você selecionar; não teremos permissão para ler outros arquivos.

Ao mesmo tempo, a menos que você compartilhe arquivos ativamente fora do módulo Mundo, eles ficarão armazenados apenas localmente e não passarão pelo servidor.

#### Rede

A permissão de acesso à rede serve para acessar o módulo "MUNDO", login autorizado e sincronização opcional com Dropbox/WebDAV e outras funções.

#### Calendário

A aplicação também oferece a função de escrever eventos no aplicativo de calendário do sistema para lembrá-lo.

**Essa função exigirá permissões de leitura e gravação do calendário, e essa permissão só será solicitada quando o usuário usar a função correspondente. E o *LifeUp* lerá apenas eventos escritos pela própria aplicação.**

#### 1.3 Armazenamento de dados

**A aplicação é offline-first e não possui função integrada de sincronização online, portanto a maior parte dos dados fica armazenada localmente no celular do usuário.**

Por exemplo, todas as Tarefas locais que você criou, todas as Reflexões registradas, as Conquistas que você projetou e os Itens da Loja.

**Somente o conteúdo que você compartilha publicamente no módulo "Mundo" será armazenado no servidor.
E esse conteúdo suporta operações de exclusão e destruição.**

Por exemplo, a equipe que você criou no módulo "Mundo", as atividades que publicou após concluir Tarefas da equipe, os Itens da Loja compartilhados ativamente e assim por diante.

Ao mesmo tempo, a grande maioria das requisições dentro da aplicação será transmitida de forma criptografada.

#### 1.4 Dados de desempenho e relatórios de crash

Usamos [Google Firebase](https://firebase.google.com/) e [Sentry](https://sentry.io/) para coletar dados de desempenho do usuário e relatórios de crash para rastrear e corrigir problemas.

Esses dados de desempenho podem incluir o modelo do seu dispositivo, status da rede, ID da instância, quando o problema ocorreu e páginas relacionadas, **mas esses dados não serão associados aos seus dados de usuário** (não incluem seu apelido, ID de usuário, endereço de e-mail ou qualquer informação de contato, e não coletam o conteúdo que você insere e cria) e serão usados apenas para analisar o problema e melhorar o desempenho.

E esses dados ficam armazenados temporariamente apenas pelo Firebase e Sentry por um período, **e nós**
**não os compartilharemos/venderemos/alugaremos a terceiros.**

#### 1.5 Solicitação de exclusão de dados para *LifeUp Lite*

##### 1. Armazenamento e exclusão de dados

LifeUp Lite, a versão gratuita do LifeUp, armazena dados principalmente no dispositivo do usuário. Valorizamos sua privacidade e autonomia. No LifeUp Lite, como contas de usuário não são criadas, todos os dados pessoais ficam armazenados localmente no seu dispositivo.

**Para excluir esses dados, basta desinstalar a aplicação LifeUp Lite do seu dispositivo. Após a desinstalação, todos os dados armazenados localmente serão removidos permanentemente.**

##### 2. Serviços de terceiros

LifeUp Lite integra serviços de terceiros, como Firebase e Admob, para funcionalidade e publicidade. Observe que os dados coletados por esses serviços não incluem informações pessoais vinculadas à sua identidade e são usados em conformidade com suas respectivas políticas de privacidade. Esses dados são excluídos automaticamente após um certo período, conforme as políticas desses serviços.

##### 3. Assistência com exclusão de dados

Se precisar de assistência ou tiver dúvidas sobre a exclusão dos seus dados, entre em contato conosco em lifeup@ulives.io. Nossa equipe está comprometida em ajudá-lo com quaisquer perguntas ou preocupações relacionadas à privacidade dos seus dados e orientará você no processo, se necessário.

##### 4. Conformidade e atualizações

Revisamos e atualizamos continuamente nossas práticas para garantir conformidade com as regulamentações e padrões do setor mais recentes. Esta seção da Política de Privacidade será atualizada conforme necessário para refletir quaisquer mudanças em nossos processos de gerenciamento e exclusão de dados.


#### 1.6 Solicitação de exclusão de dados para *LifeUp Pro*

##### 1. Exclusão de dados no LifeUp Pro

Usuários do LifeUp Pro têm a capacidade de excluir seus dados de forma independente dentro do App.

Como o LifeUp Pro é principalmente uma aplicação offline, você pode gerenciar seus dados diretamente no seu dispositivo.

Para excluir seus dados, siga estes passos:

1. Vá à página 'Configurações - Backup/Restauração/Limpeza' no App LifeUp Pro.
2. Escolha os dados específicos que deseja excluir, como Tarefas, Recompensas de Itens, Reflexões locais e dados do modo offline.
3. Confirme sua ação para excluir permanentemente os dados selecionados.

**Alternativamente, desinstalar o App LifeUp Pro do seu dispositivo também resultará na exclusão de todos os dados armazenados localmente.**



##### 2. Exclusão de conta no LifeUp Pro

Excluir sua conta no LifeUp Pro é um processo separado da exclusão de dados.

Quando você exclui sua conta, serão removidos:

- Suas publicações públicas, como equipes e atualizações, publicadas em nossos servidores.
- Seu apelido e outras informações pessoais associadas à sua conta.
- Associações OAuth vinculadas à sua conta.

**Para excluir sua conta LifeUp Pro, siga os passos descritos anteriormente:**

1. Navegue até a página 'Configurações - Backup/Restauração/Limpeza'.
2. Toque no botão 'Excluir conta' na parte inferior da página.
3. Confirme sua ação para excluir permanentemente sua conta e todas as informações associadas.

<br/>

**Se você não estiver mais usando o App LifeUp Pro, mas quiser excluir sua conta e dados pessoais, entre em contato conosco em [lifeup@ulives.io](mailto:lifeup@ulives.io).**

Forneça os detalhes necessários relacionados à sua conta, e nossa equipe ajudará você no processo de exclusão.

Estamos comprometidos em garantir sua privacidade e trataremos sua solicitação com o máximo cuidado e confidencialidade.



##### 3. Serviços de terceiros

Semelhante ao LifeUp Lite, o LifeUp Pro integra serviços de terceiros, como Firebase, para funcionalidade aprimorada. Os dados coletados por esses serviços não são pessoalmente identificáveis e são gerenciados de acordo com suas políticas de privacidade. Esses dados são agendados automaticamente para exclusão após um certo período, conforme as políticas dos serviços de terceiros.



##### 4. Atualizações e conformidade

Monitoramos e atualizamos continuamente nossas práticas para alinhar com as leis de privacidade e padrões do setor mais recentes. Esta seção da Política de Privacidade será alterada conforme necessário para refletir com precisão nossos processos de gerenciamento e exclusão de dados para usuários do LifeUp Pro.


### 2. Acordo

Ao usar esta aplicação, você concorda com os termos desta política de privacidade.

Você concorda que é responsável pelos seus próprios dados.

Não nos responsabilizamos de forma alguma por qualquer perda de dados causada por ou em conexão com o uso deste App, já que se trata de uma aplicação offline-first.
