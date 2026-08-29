## 커뮤니티 기여 🤝

LifeUp의 기능을 확장하는 도구를 만들어 주신 커뮤니티에 깊이 감사드립니다. 아래는 공식 툴킷과 추천 커뮤니티 프로젝트입니다.

## 공식 툴킷

| 프로젝트 | 설명 |
| --- | --- |
| [LifeUp Cloud](guide/api_cloud.md) | 휴대폰 측 HTTP API 브리지; LAN 접근 및 **QR 스캔**(`lifeup://`, 웹 URL, 다른 App 스킴) |
| [@lifeup/mcp](guide/api_mcp.md) | Cursor, Claude Desktop 등 AI 에이전트용 공식 MCP 서버 + Skills(LAN 경유) |
| [LifeUp Desktop](guide/api_desktop.md) | LifeUp Cloud HTTP 기반 공식 데스크톱 클라이언트 |
| [Wordle 연동 데모](example/wordle/index.html) | 단어 맞히기 미니 게임; 승리 시 `lifeup://api/reward` 호출 |

**Wordle 설정:** 상점 아이템 생성 → Wordle 페이지를 가리키는 type-9 링크 효과 추가 → **사용** 시 브라우저에서 게임 실행; 승리 시 10 코인, 패배해도 위로 코인 1개 지급. Wordle URL을 QR 코드로 인코딩해 LifeUp Cloud로 스캔할 수도 있습니다. [API · 외부 웹(Wordle)](guide/api.md) 참고.

<br/>

## 커뮤니티 프로젝트

| 프로젝트 | 설명 | 작성자 |
| :--- | :--- | :--- |
| [lifeup-mcp](https://github.com/derekprovance/lifeup-mcp) | 초기 커뮤니티 MCP 서버(공식 `@lifeup/mcp`로 대체됨). | [@derekprovance](https://github.com/derekprovance) |
| [lifeup_mod_coins](https://github.com/klienkross/lifeup_mod_coins) | Obsidian ↔ LifeUp 플러그인: 할 일 동기화, 회고 동기화, Obsidian 내 LifeUp 데이터 대시보드. *참고: 중국어 전용 저장소.* | [@klienkross](https://github.com/klienkross) |

> [!TIP]
> **멋진 것을 만드셨나요?** LifeUp용 도구, 스크립트, 연동을 개발하셨다면 GitHub Issues나 이메일로 알려 주세요!
