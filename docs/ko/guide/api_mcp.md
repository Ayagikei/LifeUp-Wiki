<h1 align="center" padding="100">MCP & Skills</h1>

AI가 LifeUp과 함께 일하게 하려면? 두 계층이 있습니다:

| | 역할 | 사용자 |
|---|---|---|
| **MCP** `@lifeup/mcp` | LifeUp Cloud 탐색, HTTP 요청 전송, 파라미터 인코딩, 응답 파싱 | Cursor, Claude Desktop, WorkBuddy 및 모든 MCP 클라이언트 |
| **Skills** `lifeup-cloud/` | 연결 방법, 조회 대상, 각 API 호출 방법 | MCP `help`로 번들 제공; Claude Code / Pi는 폴더를 디스크 스킬로 로드 가능 |

컴퓨터의 에이전트는 LAN을 통해 휴대폰의 LifeUp Cloud에 연결한 뒤 LifeUp과 통신합니다. HTTP 세부 사항은 [LifeUp Cloud API](guide/api_cloud.md)를 참고하세요. MCP 소스: [LifeUp-SDK/mcp](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp).

> [!NOTE]
> **LifeUp 1.106.0**+ 및 **LifeUp Cloud 3.0.0**+가 필요합니다. 이전 빌드도 연결될 수 있지만 저널, 통계, 레벨 곡선이 불완전합니다. `status.update`가 사용자에게 업그레이드를 안내할 수 있습니다.

MCP는 에이전트에 **읽기/쓰기 API**를 제공하고, AI 계층은 **추론**을 더합니다 — 오늘 백로그 우선순위 정하기, 저널에서 주간 통계 요약, 속성 레벨에 맞춘 작업 설계, 또는 **한 번의 프롬프트로 테마 게이미피케이션 전체 구성**(인디 게임 개발, 마법 학원 등) — 단순히 원시 목록을 가져오는 것 이상입니다.

## 이렇게 물어보세요

MCP를 설치하면 API를 외울 필요 없이 AI와 대화하면 됩니다.

**하루 계획**

- "오늘 남은 작업은? 우선순위로 정렬하고 먼저 할 일을 알려줘."
- "약 25분 안에 끝낼 수 있는 미완료 작업 하나 골라줘."

**데이터 분석**

- "이번 주 포모도로, 집중, 코인, 경험치 통계를 뽑아서 — 어디서 왔는지 분류하고 패턴을 요약해줘."
- "이번 달 코인은 어디서 왔어? 가장 큰 출처와 의외의 항목을 보여줘."

**코칭 & 설계**

- "내 속성 레벨을 보고 약한 스킬을 올리는 일일 작업 세트를 설계해줘."

**한 번에 테마 설정**

- "샘플을 지우고 인디 게임 개발자 전체 세트를 만들어줘: 목록, 상점, 업적, 속성."
- "마법 학원 RPG 루틴 전체를 설계해줘 — 작업, 속성, 상점 아이템, 업적."

**회고**

- "오늘 완료한 것을 보고 짧은 저널을 써줘: 한 일, 내일 개선할 점."
- "Morning Routine이라는 업적 목록을 만들고 이모지 아이콘과 코인 보상이 있는 업적 8개를 추가해줘."
<br/>

## 빠른 시작

에이전트에게 아래 한 줄을 보내면 MCP 설치와 첫 연결을 진행할 수 있습니다:

```
Follow this doc to install the LifeUp MCP server and complete the first connection: https://raw.githubusercontent.com/Ayagikei/LifeUp-Wiki/master/docs/en/guide/api_mcp.md
```

<br/>

## Skills

스킬 파일은 [`mcp/skills/lifeup-cloud/`](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp/skills/lifeup-cloud)에 있습니다(저장소에 한 벌 — 별도 npm 패키지 없음).

- **Cursor / Claude Desktop / WorkBuddy:** MCP만 설치하세요. `help`가 이 스킬을 읽습니다; 두 번 설치하지 마세요.
- **Claude Code / Pi / 커스텀 워크플로:** 폴더를 에이전트 스킬 경로에 복사하거나 저장소를 직접 가리키세요.

```text
mcp/skills/lifeup-cloud/
  SKILL.md                 connect + common ops (read this first)
  references/
    basics.md              errors, encoding, JSON, timeouts
    discovery.md           mDNS / token
    query.md               list_data resources
    tasks.md / economy.md
    api-index.md           one line per method
    methods/*.md           full param table (load when calling)
    broadcasts.md / gaps.md
```

에이전트는 문서를 단계적으로 읽습니다:

1. `help`(또는 디스크 `SKILL.md`) — 전체 워크플로
2. `help api-index` — 어떤 메서드가 있는지
3. `help add_task` — 한 메서드의 파라미터
4. `call_api` / `list_data` — 실제 호출

커스터마이즈: 폴더를 복사해 `SKILL.md`와 `references/`를 편집하세요. MCP `help`는 포크에서 MCP를 다시 빌드하지 않는 한 패키지된 사본을 계속 읽습니다.

<br/>

## 설정

1. 휴대폰과 컴퓨터가 같은 LAN에 있음
2. LifeUp 실행 중, Cloud에 **Read LifeUp Data** 권한 부여
3. LifeUp Cloud 시작(기본 포트 `13276`)
4. 컴퓨터에 [Node.js 20+](https://nodejs.org/)

토큰은 선택 사항입니다. 설정한 경우 헤더에 **원문** 토큰을 보내세요 — `Bearer`가 아닙니다.

<br/>

## MCP 설치

npm에 패키지가 올라오기 전까지 GitHub에서 설치:

```json
{
  "mcpServers": {
    "lifeup": {
      "command": "npx",
      "args": ["-y", "github:Ayagikei/LifeUp-SDK#feat/mcp"]
    }
  }
}
```

`npx`가 저장소를 클론하고 `mcp/`를 빌드합니다. `main`에 머지되면 `#feat/mcp`는 제거하세요.

이미 [LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)를 클론했다면 설치 스크립트를 사용하세요(MCP 빌드 및 감지된 클라이언트 upsert; 재실행해도 중복 등록되지 않음):

```bash
./scripts/install-mcp.sh
```

기본 클라이언트: Codex, Cursor, Claude Code, Claude Desktop, Pi. `imports: ["codex"]`인 Pi 설정은 Codex를 상속하므로 중복되지 않습니다.

macOS GUI App은 `PATH`에 `npx`가 없는 경우가 많습니다 — `npx`/`node` 절대 경로를 사용하거나 클론 후 `cd mcp && npm install && npm run build`를 실행하세요.

| Variable | Role |
|---|---|
| `LIFEUP_HOST` | 예: `192.168.1.8:13276`, mDNS 생략 |
| `LIFEUP_TOKEN` | 프로세스 전용, 디스크에 기록하지 않음 |
| `LIFEUP_MCP_CONFIG` | 커스텀 설정 경로 |

게시 후: `npx -y @lifeup/mcp`(중국은 npmmirror).
<br/>

## 에이전트 워크플로 :id=agent-workflow

1. `discover` — mDNS `_lifeup._tcp`; TXT `port`가 HTTP 포트입니다. Cloud 인스턴스가 정확히 하나면 자동 연결됩니다.
2. `connect` — 인스턴스가 0개 또는 여러 개일 때 `host`를 전달합니다.
3. `status` — 버전 확인; 1.106.0 / 3.0.0 미만이면 `update`를 주의하세요.
4. 목록: `list_data`(기본은 간략 필드).
5. 쓰기: `complete_task` / `add_task` / `reward` / `purchase_item`; 나머지는 `call_api`로. App UI를 열려면 `via=launch`를 사용하세요.

파괴적 호출에는 `confirm: true`가 필요합니다. 파라미터 값을 미리 인코딩하지 마세요.

## Events

LifeUp: Labs → Broadcast events 활성화(기본 꺼짐; Cloud Advanced에서 상태 표시 및 활성화 가능). Cloud **WebSocket event push는 기본 켜짐**(3.0.0+)이며 전송 전용입니다.

- `list_events` — `GET /events`, 항상 사용 가능
- `subscribe_events` — `WS /events`; Cloud 토글이 꺼져 있으면 오류, HTTP는 계속 동작

자세한 내용: MCP `help broadcasts`.

<br/>

---

## 예시: 인디 게임 개발자 설정

아래는 실제 MCP 세션 결과입니다. 사용자가 AI에게 **LifeUp 내장 개발자 샘플을 지우고** **인디 게임 개발**을 중심으로 한 RPG 스타일 전체 설정(작업 목록, 속성, 상점, 업적)을 만들도록 요청했습니다.

다음과 같은 프롬프트로 시작할 수 있습니다:

> Clear the sample tasks and shop items, then create a full indie game developer setup: task lists, attributes, shop items, and achievements.

### 구성된 내용

| 영역 | 내용 |
| --- | --- |
| 작업 목록 | Morning Ritual, Coding Daily, Game Dev, Deep Learning, Learning & Recharge, Wrap-up |
| 속성 | Execution / Technical / Collaboration / Focus / Wellness / Creativity, 및 **Developer Stats**(Game Design, Debugging, Architecture) |
| 상점 | **Dev Supplies**(소모품) + **Fun Collectibles**(이스터에그 아이템) |
| 업적 | **Indie Dev Journey**(Hello World, First Bug Kill, Ship It!, …) |

> [!TIP]
> 이미지를 클릭하면 확대됩니다. 아래 탭으로 가로 전환하며 긴 페이지 스크롤을 줄일 수 있습니다.

<!-- tabs:start -->

#### **1 · 작업 개요**

**All** 보기의 Morning Ritual 반복 작업, Coding Daily, Game Dev 등 카테고리 칩.

![Tasks · Morning Ritual and categories](_media/mcp/game-dev-example/02-tasks-overview.jpg ':size=45%')

#### **2 · 속성**

핵심 6개 속성과 **Developer Stats** 그룹. 작업 완료 시 해당 스킬에 경험치가 부여됩니다.

![Attributes panel](_media/mcp/game-dev-example/03-skills.jpg ':size=45%')

#### **3 · Fun Collectibles**

이스터에그 상점 아이템: Inspiration Dice, RGB Keycap, Desk Cat, LEGO Brick, Retro Gamepad, Rubber Duck — 일부는 랜덤 코인 또는 속성 보너스.

![Shop · Fun Collectibles](_media/mcp/game-dev-example/04-shop-fun-collection.jpg ':size=45%')

#### **4 · 업적**

마일스톤 업적: 첫 작업, 첫 버그 수정, 데모 출시, 연속 기록, 포모도로, Piggy Bank, Daily Pentakill 등 — 이모지 아이콘과 해금 조건.

![Indie Dev Journey achievements](_media/mcp/game-dev-example/06-achievements.jpg ':size=45%')

#### **5 · Piggy Bank 상세**

진행형 조건 예시: **500 코인** 현재 잔액 달성.

![Achievement detail · Piggy Bank](_media/mcp/game-dev-example/07-achievement-detail-piggy-bank.jpg ':size=45%')

#### **6 · Daily Pentakill 상세**

카운터 조건 예시: **하루에 서로 다른 작업 5개** 완료.

![Achievement detail · Daily Pentakill](_media/mcp/game-dev-example/08-achievement-detail-pentakill.jpg ':size=45%')

<!-- tabs:end -->

### AI가 보통 하는 일

1. `list_tasks` / `list_items` — 기존 샘플 확인; 필요 시 이전 행 삭제(파괴적 호출은 `confirm: true`).
2. 작업 / 상점 / 업적 목록(`category`) 생성.
3. 속성 및 그룹(`skill` / `skill_group`) 생성.
4. 작업, 아이템, 업적 일괄 작성(`add_task` / `add_item` / `achievement`).
5. App에서 해당 화면을 새로고침해 확인.

API 파라미터는 위 [Skills](#skills) 및 [에이전트 워크플로](#에이전트-워크플로)를 참고하세요; 메서드별 표는 MCP `help add_task` 등으로 확인합니다.
