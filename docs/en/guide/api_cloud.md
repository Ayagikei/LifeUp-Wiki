<h1 align="center" padding="100">LifeUp Cloud ☁️</h1>

<p align="center">
 <img src="guide/_media/api/cloud.png" />
</p>

> [!NOTE]
> We are rolling out **LifeUp v1.106.0** and **LifeUp Cloud v3.0.0**. Because platform review timelines vary, this documentation may be updated before the apps are widely available, so the actual release date may be later than what you see here.

LifeUp Cloud is one of the core API toolkits for LifeUp. It turns your phone into an **API bridge**: control LifeUp from your **computer or other devices**, build **custom integrations** (desktop, web, automation scripts), or pair it with **AI agents**.

### Typical scenarios

| Scenario | Who it's for | In one sentence | Learn more |
| --- | --- | --- | --- |
| **HTTP + build your own** | Developers, automation users | Call APIs and query data from Python, web apps, or scripts over LAN — no Android experience required | [HTTP API reference](/guide/api-reference), [Desktop](guide/api_desktop.md) |
| **QR scanning** | Real-world check-in fans | Print QR codes to complete tasks, start timers, open dialogs, or launch web pages / other apps | [QR code scanning](#qr-code-scanning) |
| **Start / stop shortcuts** | Automation, NFC, Tasker | `lifeupcloud://start` and `lifeupcloud://stop` open Cloud and start or stop the HTTP server | [Start and stop](#cloud-scheme) |
| **AI Agent + MCP** | Cursor, Claude, etc. | One prompt to build task lists, shop items, achievements, and more | [MCP & Skills](guide/api_mcp.md) |
> **Example AI prompt:** Clear the sample tasks and shop items, then create a full indie game developer setup: task lists, attributes, shop items, and achievements.

<br/>

## Download

- If you use the Mainland China membership version, you can find the LifeUp Cloud download entry in `Sidebar` → `Settings` → `Experiments`.
- [Google Play Store](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http)

<br/>


## Start and stop the Cloud service :id=cloud-scheme

You can start or stop the HTTP server without tapping **Start Service**, using these URL schemes:

```txt
lifeupcloud://start
lifeupcloud://stop
```

Opening either URL launches LifeUp Cloud and applies the action. Use them as a home-screen shortcut, NFC tag, Tasker/automation action, or:

```txt
adb shell am start -a android.intent.action.VIEW -d lifeupcloud://start
```

The same URLs are listed on the Cloud status card — tap to copy.

> [!NOTE]
> `lifeupcloud://` controls the Cloud HTTP server itself. It is not a `lifeup://api/…` game API.

<br/>

## QR code scanning

The **Scan** button at the top of LifeUp Cloud reads the URL encoded in a QR code and opens it immediately — no manual entry.

Scanning is **not limited to LifeUp APIs**: `lifeup://api/…`, web pages `https://…`, and other app URL schemes (e.g. `weixin://`) all work — Android opens the matching target.

### How to use

1. Pick a URL from LifeUp or the wiki [API list](guide/api.md) (complete a task, start a pomodoro, open purchase/use dialogs, or open an external web page).

2. Generate a QR code from the full URL (print and stick it on a desk, wall, or device).

3. Open LifeUp Cloud, tap **Scan** (tap **?** next to it for a short in-app guide), and point at the code.

### What you can do

| Scenario | Example (illustrative) |
| --- | --- |
| Pomodoro check-in | `lifeup://api/pomodoro?...` start/stop timer |
| Task check-in | `lifeup://api/complete?name=...` complete a task |
| Shop interaction | `lifeup://api/goto?page=shop` or purchase/use dialogs |
| Reward / penalty | `lifeup://api/reward?...` / `lifeup://api/penalty?...` |
| Web mini-game | `https://wiki.lifeupapp.fun/en/example/wordle/index.html` |
| Other apps | `weixin://`, `intent://`, or any installed app's scheme |
| Custom flows | Any scannable URL combination |

### Real-world interaction

QR codes map **physical places or actions** to in-app gamification:

- **Gym equipment** sticker → scan to complete a strength-training task

- **Study desk** sticker → scan to start a focus pomodoro

- **Workstation** sticker → scan to log stand-up or code review

- **Event board** sticker → scan to claim a reward or open an achievement

In short: **turn URL Schemes into scannable physical triggers**, with LifeUp Cloud as the executor between the app and the real world.

<br/>

> [!NOTE]
> LifeUp Cloud is a LAN-only HTTP bridge. How you reach your phone—IP address, router, firewall, same subnet, VPN, or AP isolation—depends on your home network. If you cannot connect, we cannot debug your personal LAN. Check your own networking, use standard network tools, or ask an AI agent for help.

## Connect to LifeUp Cloud :id=connect

1. Install compatible LifeUp and LifeUp Cloud versions. Open LifeUp Cloud and grant the LifeUp data/API permission when requested.
2. Start the HTTP service. From a device that can reach the phone on your network, use the address and port displayed by Cloud as your base URL.
3. If you configured a Cloud token, send the raw token in the `Authorization` header. Query `/info` to check connectivity and installed versions; check both HTTP status and JSON `code`.

## HTTP API reference :id=http-api-definition

The [complete interface and parameter reference](/guide/api-reference) contains a route index, shared response/pagination rules, complete data models, request parameters and JSON examples. Read it when building an integration. [URL Scheme methods](/guide/api) describe individual actions; [MCP & Skills](/guide/api_mcp) describe AI-agent tools.

### Task and history timestamps :id=task-history-timestamps

See [the task time model](/guide/api-reference?id=task-times): `startTime` is the planned start, `deadline` is the due time, and history `endTime` is the recorded completed/overdue/given-up time, interpreted with `status`.

#### Daily reports and history completeness :id=history-daily-reports

See [history pagination and daily reports](/guide/api-reference?id=daily-report), and [EXP/coin journals](/guide/api-reference?id=reward-journals) for actual reward changes.

## Contribution

The SDK, LifeUp Cloud, and LifeUp Desktop are all open-source projects.

You can get the source code at:

- [Ayagikei/LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop](https://github.com/Ayagikei/LifeUp-Desktop)
