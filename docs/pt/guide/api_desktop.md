<h1 align="center" padding="100">Cliente Desktop de API (rede local) 🖥</h1>

<p align="center">
 <img src="guide/_media/api/desktop.png" />
</p>

Construímos um cliente desktop leve para o LifeUp com base nas APIs do LifeUp. Suporta Windows, Linux e macOS.

**Não é um app independente.** Ele lê seus dados offline do LifeUp a partir do celular por meio de acesso à API.

<br/>

## Recursos

> [!NOTE]
> A versão atual é principalmente uma prévia técnica das capacidades da API. Foca em operações básicas de navegação e não cobre todos os recursos do App.

- Totalmente de código aberto. Você pode personalizar a UI e implementar seus próprios recursos.
- Capacidades básicas atuais:
  - Consultar lista de Tarefas e concluir Tarefas
  - Consultar lista de Atributos e Níveis
  - Consultar lista de Itens e comprar Itens
  - Consultar Reflexões e ver imagens em tamanho completo no desktop
  - Exportar Reflexões para arquivos Markdown
  - Adicionar Tarefas (nem todas as opções do App estão cobertas ainda)

<br/>

## Download

Todos os pacotes desktop são publicados em [GitHub Releases do LifeUp Desktop](https://github.com/Ayagikei/LifeUp-Desktop/releases).

> [!WARNING]
> Antes de usar o desktop, certifique-se de que o LifeUp Cloud seja v2.0.0 ou superior.<br/>
> Se você usa o build do GitHub Releases, atualize o LifeUp Cloud em `Configurações` → `Labs`.<br/>
> Se você usa o build do Google Play, pode atualizar pelo [Google Play](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http) ou [GitHub Releases do LifeUp SDK](https://github.com/Ayagikei/LifeUp-SDK/releases/latest).<br/>
> Alguns navegadores podem bloquear downloads de instaladores por política de segurança. Escolha **Manter/Permitir** (a redação varia por navegador) ou use outro downloader.

### Plataformas de instalação

<!-- tabs:start -->

#### **Windows**

- `LifeUp Desktop.msi`

> [!TIP]
> **Windows SmartScreen**<br/>
> O MSI não está atualmente assinado com EV, então o Windows pode mostrar um aviso de "aplicativo não reconhecido".<br/>
> Depois de confirmar que o arquivo veio do GitHub Releases oficial, clique em **Mais informações → Executar mesmo assim**.

#### **Linux**

- Baixe em [GitHub Releases do LifeUp Desktop](https://github.com/Ayagikei/LifeUp-Desktop/releases) e use `lifeup-desktop.deb`.

#### **macOS**

- Intel / x64: `LifeUp-Desktop-x64.dmg`
- Apple Silicon / ARM64: `LifeUp-Desktop-arm64.dmg`
- Builds macOS ainda não foram totalmente testados, e alguns recursos como **Conexão automática** podem estar indisponíveis.

> [!TIP]
> **macOS Gatekeeper / assinatura**<br/>
> Builds macOS atuais não são notarizados. Você pode ver um aviso de "desenvolvedor não identificado".<br/>
> Você pode abrir o `.dmg`, mover o app para Aplicativos, depois clicar com o botão direito no app e escolher **Abrir**,<br/>
> ou ir em **Ajustes do sistema → Privacidade e segurança** e clicar em **Abrir mesmo assim**.<br/>
> Veja o [guia oficial da Apple](https://support.apple.com/en-hk/guide/mac-help/mh40616/mac) para detalhes.

<!-- tabs:end -->

Se um pacote estiver temporariamente ausente, atualize mais tarde. Os assets de release ainda podem estar sendo enviados.

<br/>

## Como usar

### Configuração inicial

#### Pré-requisitos

- Seu celular e o desktop devem estar na mesma LAN (por exemplo, mesma Wi-Fi).
- <del>Se sua rede for complexa, teste primeiro se o desktop consegue fazer ping no IP do celular.</del>
  - Novas versões do desktop suportam detecção automática de IP do celular, então isso frequentemente é desnecessário.

#### No celular

1. Atualize o LifeUp para a versão mais recente.
2. No LifeUp, abra `Configurações` → `Labs`, depois instale o **LifeUp Cloud**.
3. Abra o LifeUp Cloud e conceda as permissões necessárias:
   - Permissão de janela flutuante / desenhar sobre outros apps
   - Permissão de leitura de dados do LifeUp
4. Toque em **Iniciar serviço** no LifeUp Cloud.

**Configuração adicional recomendada**

- Faça a configuração de compatibilidade tanto para o LifeUp quanto para o LifeUp Cloud, e desative a otimização de bateria para reduzir encerramentos em segundo plano.
- Se você usa MIUI (Xiaomi/Redmi), permita **Exibir UI em segundo plano** para ambos os apps.
- Mantenha o LifeUp e o LifeUp Cloud em execução.

#### No desktop

1. Instale o app desktop a partir do pacote de release.
2. Nas configurações do desktop, insira o IP do serviço mostrado no LifeUp Cloud.
   - No desktop v1.1.0+, você pode tentar **Conexão automática**.
3. Se tudo estiver configurado corretamente, você deve conseguir ver os dados do LifeUp no desktop.
   - Se falhar, revise a configuração adicional acima.

### Uso subsequente

1. Abra o LifeUp e o LifeUp Cloud no celular.
2. Toque em **Iniciar serviço** no LifeUp Cloud.
3. Inicie o cliente desktop.

<br/>

## Perguntas frequentes

<details>
<summary>Posso adicionar Tarefas pelo desktop?</summary>

Sim. O build desktop atual suporta criação básica de Tarefas.

Porém, nem todas as opções avançadas de Tarefas do App estão disponíveis no desktop ainda. Para configurações complexas, use o app mobile ou chame APIs via LifeUp Cloud.

</details>

<details>
<summary>Cliquei em "Solicitar permissão do LifeUp" no LifeUp Cloud, mas nada aconteceu / API não encontrada.</summary>

1. Se nada acontecer, você pode já ter concedido a permissão.
2. Se aparecer API não encontrada, entre no beta de membros e atualize o LifeUp para a versão beta mais recente.

</details>

<details>
<summary>Depois que o celular fica bloqueado por um tempo, o desktop não consegue mais ler dados.</summary>

Faça a configuração de compatibilidade tanto para o LifeUp quanto para o LifeUp Cloud.

</details>

<details>
<summary>Quando o LifeUp e o LifeUp Cloud estão em segundo plano, algumas APIs falham ao executar.</summary>

> Isso geralmente não afeta o uso básico do desktop, mas pode afetar chamadas de API personalizadas.

Certifique-se de que o LifeUp Cloud tenha permissão de janela flutuante/desenhar sobre outros apps.

Se você está no MIUI (Xiaomi/Redmi), também ative a permissão **Exibir UI em segundo plano** para ambos os apps.

</details>

<details>
<summary>A instalação no Windows falha com `Failed to launch JVM`.</summary>

Referência: [Issue #2](https://github.com/Ayagikei/LifeUp-Desktop/issues/2)

Isso geralmente está relacionado à configuração local de acessibilidade da JVM.

Uma solução comum é comentar estas linhas em `~/.accessibility.properties`:

```txt
# assistive_technologies=com.sun.java.accessibility.AccessBridge
# screen_magnifier_present=true
```

Depois de editar, reinicie o app e teste novamente.

> `~` significa o diretório home do usuário.

</details>

<br/>

## Contribuição

O SDK, o LifeUp Cloud e o LifeUp Desktop são todos de código aberto.

Código-fonte:

- [Ayagikei/LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop](https://github.com/Ayagikei/LifeUp-Desktop)
