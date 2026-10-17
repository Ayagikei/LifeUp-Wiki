<h1 align="center" padding="100">LifeUp Cloud ☁️</h1>

<p align="center">
 <img src="guide/_media/api/cloud.png" />
</p>

> [!NOTE]
> 현재 **LifeUp v1.106.0**과 **LifeUp Cloud v3.0.0**을 순차 배포 중입니다. 플랫폼 심사 일정은 지역·스토어에 따라 달라, 문서가 App이 널리 제공되기 전에 먼저 업데이트될 수 있습니다. 여기에 표시된 날짜보다 실제 출시일이 늦어질 수 있습니다.

LifeUp Cloud는 LifeUp의 핵심 API 툴킷 중 하나입니다. 휴대폰을 **API 브리지**로 바꿔 **컴퓨터나 다른 기기**에서 LifeUp을 제어하고, **커스텀 연동**(데스크톱, 웹, 자동화 스크립트)을 만들거나 **AI 에이전트**와 함께 쓸 수 있습니다.

### 일반적인 시나리오

| 시나리오 | 대상 | 한 줄 요약 | 더 알아보기 |
| --- | --- | --- | --- |
| **HTTP + 직접 구축** | 개발자, 자동화 사용자 | LAN에서 Python, 웹 App, 스크립트로 API 호출 및 데이터 조회 — Android 경험 불필요 | [HTTP API](#http-api-definition), [Desktop](guide/api_desktop.md) |
| **QR 스캔** | 현실 체크인 애호가 | QR 코드를 인쇄해 작업 완료, 타이머 시작, 대화상자 열기, 웹 페이지 / 다른 App 실행 | [QR code scanning](#qr-code-scanning) |
| **시작 / 중지 단축** | 자동화, NFC, Tasker | `lifeupcloud://start`와 `lifeupcloud://stop`으로 Cloud를 열고 HTTP 서버 시작 또는 중지 | [Start and stop](#cloud-scheme) |
| **AI Agent + MCP** | Cursor, Claude 등 | 한 번의 프롬프트로 작업 목록, 상점 아이템, 업적 등 전체 구성 | [MCP & Skills](guide/api_mcp.md) |
> **AI 프롬프트 예시:** 샘플 작업과 상점 아이템을 지우고, 인디 게임 개발자 전체 세트를 만들어줘: 작업 목록, 속성, 상점 아이템, 업적.

<br/>

## 다운로드

- 중국 본토 멤버십 버전을 사용하는 경우 `Sidebar` → `Settings` → `Experiments`에서 LifeUp Cloud 다운로드 항목을 찾을 수 있습니다.
- [Google Play Store](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http)

<br/>


## Cloud 서비스 시작 및 중지 :id=cloud-scheme

**Start Service**를 누르지 않고도 아래 URL 스킴으로 HTTP 서버를 시작하거나 중지할 수 있습니다:

```txt
lifeupcloud://start
lifeupcloud://stop
```

URL을 열면 LifeUp Cloud가 실행되고 해당 동작이 적용됩니다. 홈 화면 단축키, NFC 태그, Tasker/자동화 동작 등으로 사용하거나:

```txt
adb shell am start -a android.intent.action.VIEW -d lifeupcloud://start
```

같은 URL은 Cloud 상태 카드에도 나열되어 있으며 — 탭하여 복사할 수 있습니다.

> [!NOTE]
> `lifeupcloud://`는 Cloud HTTP 서버 자체를 제어합니다. `lifeup://api/…` 게임 API가 아닙니다.

<br/>

## QR code scanning

LifeUp Cloud 상단의 **Scan** 버튼은 QR 코드에 인코딩된 URL을 읽어 즉시 엽니다 — 수동 입력 불필요.

스캔은 **LifeUp API에만 한정되지 않습니다**: `lifeup://api/…`, 웹 페이지 `https://…`, 다른 App URL 스킴(예: `weixin://`) 모두 동작합니다 — Android가 해당 대상을 엽니다.

### 사용 방법

1. LifeUp 또는 wiki [API list](guide/api.md)에서 URL을 고릅니다(작업 완료, 포모도로 시작, 구매/사용 대화상자 열기, 외부 웹 페이지 열기).

2. 전체 URL로 QR 코드를 생성합니다(책상, 벽, 기기에 인쇄해 부착).

3. LifeUp Cloud를 열고 **Scan**을 탭합니다(**?**를 탭하면 App 내 짧은 가이드), 코드를 비춥니다.

### 할 수 있는 것

| 시나리오 | 예시(설명용) |
| --- | --- |
| 포모도로 체크인 | `lifeup://api/pomodoro?...` 타이머 시작/중지 |
| 작업 체크인 | `lifeup://api/complete?name=...` 작업 완료 |
| 상점 상호작용 | `lifeup://api/goto?page=shop` 또는 구매/사용 대화상자 |
| 보상 / 페널티 | `lifeup://api/reward?...` / `lifeup://api/penalty?...` |
| 웹 미니 게임 | `https://wiki.lifeupapp.fun/en/example/wordle/index.html` |
| 다른 App | `weixin://`, `intent://`, 또는 설치된 App의 스킴 |
| 커스텀 플로 | 스캔 가능한 URL 조합 |

### 현실 세계 상호작용

QR 코드는 **물리적 장소나 행동**을 App 내 게이미피케이션에 연결합니다:

- **헬스장 기구** 스티커 → 스캔하여 근력 운동 작업 완료

- **공부 책상** 스티커 → 스캔하여 집중 포모도로 시작

- **워크스테이션** 스티커 → 스캔하여 스탠드업 또는 코드 리뷰 기록

- **이벤트 게시판** 스티커 → 스캔하여 보상 수령 또는 업적 열기

요약: **URL Scheme을 스캔 가능한 물리적 트리거로 바꾸고**, LifeUp Cloud가 App과 현실 사이의 실행자 역할을 합니다.

<br/>

> [!NOTE]
> LifeUp Cloud는 LAN 전용 HTTP 브리지입니다. 휴대폰에 접근하는 방법 — IP 주소, 라우터, 방화벽, 같은 서브넷, VPN, AP 격리 — 은 가정용 네트워크에 따라 다릅니다. 연결되지 않으면 개인 LAN은 디버깅해 드릴 수 없습니다. 네트워크를 직접 확인하거나 표준 네트워크 도구를 사용하거나 AI 에이전트에 도움을 요청하세요.

## LifeUp Cloud에 연결 :id=connect

1. 호환되는 LifeUp 및 LifeUp Cloud를 설치합니다. Cloud를 열고 요청 시 LifeUp 데이터·API 권한을 부여합니다.
2. HTTP 서비스를 시작합니다. 네트워크에서 휴대폰에 접근할 수 있는 기기에서 Cloud에 표시된 주소와 포트를 기본 URL로 사용합니다.
3. Cloud 토큰을 설정했다면 `Authorization` 헤더에 원시 값을 보냅니다. `/info`로 연결과 설치 버전을 확인하고 HTTP 상태 및 JSON `code`를 모두 검사합니다.

## HTTP API 참조 :id=http-api-definition

[전체 인터페이스 및 매개변수 참조](/guide/api-reference)는 경로 색인, 공통 응답·페이지 규칙, 전체 데이터 모델, 요청 매개변수, JSON 예제를 제공합니다. 연동을 구현할 때 참고하세요. [URL Scheme 메서드](/guide/api)는 개별 동작을, [MCP 및 Skills](/guide/api_mcp)는 AI 에이전트 도구를 설명합니다.

### 할 일 및 기록 타임스탬프 :id=task-history-timestamps

[할 일 시간 모델](/guide/api-reference?id=task-times)을 참고하세요. `startTime`은 예정 시작, `deadline`은 기한, 기록의 `endTime`은 완료·기한 초과·포기의 기록 시각이며 `status`와 함께 해석합니다.

#### 일일 보고서 및 기록 완전성 :id=history-daily-reports

[기록 페이지 조회 및 일일 보고서](/guide/api-reference?id=daily-report)와 실제 보상 변동을 설명하는 [EXP·코인 원장](/guide/api-reference?id=reward-journals)을 참고하세요.

## 기여

SDK, LifeUp Cloud, LifeUp Desktop은 모두 오픈 소스 프로젝트입니다.

소스 코드:

- [Ayagikei/LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop](https://github.com/Ayagikei/LifeUp-Desktop)
