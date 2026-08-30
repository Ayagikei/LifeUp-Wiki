<h1 align="center" padding="100">오픈 인터페이스</h1>

<p align="center">무한한 가능성을 만들어 보세요! </p>

> [!NOTE]
> 현재 **LifeUp v1.106.0**과 **LifeUp Cloud v3.0.0**을 순차 배포 중입니다. 플랫폼 심사 일정은 지역·스토어에 따라 달라, 문서가 App이 널리 제공되기 전에 먼저 업데이트될 수 있습니다. 여기에 표시된 날짜보다 실제 출시일이 늦어질 수 있습니다.

?> v1.90 버전부터 `LifeUp`은 다양한 기능 인터페이스를 공개했으며, 외부 App 연동을 환영합니다. <br/>상점 아이템의 "URL" 효과도 제공되어, 사용자가 아이템을 사용해 외부 App 또는 `LifeUp` 인터페이스를 직접 호출할 수 있습니다. <br/>이 기능으로 `LifeUp`의 가능성을 크게 넓힐 수 있지만, 약간의 학습과 직접 실습이 필요합니다.

**최종 업데이트: 2026/08/28**

이 문서의 API 매개변수와 정의는 **v1.106.0** 버전을 기준으로 합니다.

최신 API를 사용하기 전에 App이 **v1.106.0**으로 업데이트되었는지 확인하세요.

업데이트는 Google Play를 통해 순차적으로 배포되며, 아직 받지 못했다면 조금만 기다려 주세요.

## 시나리오 예시

| 호출 주체 | 시나리오 | 참고 |
| ------ | -------- | ----- |
|**LifeUp→다른 App**<br/>상점 아이템의 "URL" 효과로 구현| **상점 아이템 사용 후:**<br/>1. 브라우저로 웹페이지 방문<br/>2. WeChat으로 이동해 스캔하거나 특정 미니 프로그램 지정<br/>3. 가계부 기록 자동 추가([예: "Qianji"가 가계부 인터페이스 지원](http://docs.qianjiapp.com/plugin/auto_tasker.html))<br/>4. 자동화 도구 Tasker 설정 저장(Market에서 공유 가능), 사용 후 Tasker에 설정 자동 가져오기<br/>5. Tasker로 배경화면 변경 트리거<br/>6. ... (외부 App이 이 방식의 호출을 지원하는 한) | [Tasker](https://play.google.com/store/apps/details?id=net.dinglisch.android.taskerm&hl=en_US&gl=US)는 자동화 도구이며, 설정을 Uri로 내보낼 수 있습니다 |
|**LifeUp→LifeUp**<br/>상점 아이템의 "URL" 효과로 구현| **상점 아이템 사용 후:**<br/>1. 특정 페이지 열기<br/>2. ATM 이자율 올리기<br/>3. 팝업에서 상품 선택 후 가격 할인(할인 쿠폰)<br/>4. 작업 완료 트리거<br/>5. 맞춤 동기 부여 메시지 팝업<br/>6. 작업 보상 템플릿 만들기: 이름만 입력하면 작업 자동 생성<br/>7. 팝업으로 분기 선택을 묻는 작은 맥락형 상호작용<br/>8. App 내 더 많은 동작... |  |
|**외부 App/웹페이지→LifeUp** | **자동화 도구 설정:**<br/>1. 매일 첫 기기 부팅 시점을 감지해 일찍 일어나기 작업 완료, 또는 "늦잠" 페널티 직접 트리거<br/>2. 25단어를 쓸 때마다 특정 NFC 카드를 태그해 작업 자동 완료<br/>3. GPS로 새 장소 도착을 감지해 "새 장소" 업적 해제<br/>4. 매일 직장 Wi-Fi에 연결될 때 해제 조건 진행도 증가 트리거. 20일 누적 후 "Worker" 업적 해제<br/>5. 매일 첫 집 Wi-Fi 연결 시 "귀가" 금화 보상<br/>6. 다른 포모도로·집중 App 알림을 캡처해 타이밍을 `LifeUp`에 자동 기록<br/>7. 운동·학습 소프트웨어 완료/종료 알림을 캡처해 "strength"·"knowledge" 경험치 자동 지급<br/>8. 직접 설정한 시간대에 휴대폰을 열 때마다 페널티 트리거<br/>9. ...<br/>**외부 App 연동/자체 개발 App:**<br/>1. `LifeUp` 포모도로가 마음에 들지 않으면: 웹 또는 Android App으로 자체 타이머를 만들고 인터페이스로 "LifeUp"과 연동해 타이밍 기록 추가 또는 보상 추가<br/>2. 일부 지능형 미니게임(아래 Wordle 예시 등)을 수정해, 게임 성공 시 `LifeUp`에 보상 지급 트리거<br/>3. ... |  |

<br/>즉, 위 시나리오는 모두 "이벤트"가 "동작"을 트리거하는 것입니다.

이번 `LifeUp` 업데이트는 "아이템 사용" 이벤트 트리거 지점을 제공하고, 다양한 "동작"(보상, 작업 완료 등)을 제공합니다.

다음과 같은 이벤트가 필요하면

- 웹 버튼 클릭
- NFC 카드 태그
- 매일 첫 화면 잠금 해제

외부 App 개입이 필요합니다. 직접 2차 개발하거나 `Tasker`, `MacroDroid` 같은 자동화 도구를 사용하세요.

**LifeUp 1.90.2 업데이트에서 일련의 "이벤트"가 추가되며, 자동화 도구나 외부 App이 이 이벤트를 수신할 수 있습니다.**

예를 들어:

아이템 사용 후 Tasker 등 자동화 도구로 런처 배경화면 전환.

작업 완료 후 Tasker 등 자동화 도구로 App 열기.

**1.90.2 버전에서는 "LifeUp 이벤트"가 "Tasker 동작"을 트리거할 수 있습니다.**

Tasker는 배경화면 변경, App 제거, 볼륨 조절, 지정 App 열기 등 매우 높은 권한을 가집니다. 프로그래밍 기초 없이도 UI 상호작용 로직을 작성할 수 있습니다.

---

## 권장 사항

**프로그래밍에 익숙하지 않다면,** [World] → [Market] → [Link]/[API]/[Automate] 태그에서 특수 상점 아이템을 검색해 바로 가져올 수 있습니다. 매개변수를 편집해 필요에 맞출 수도 있습니다.

**컴퓨터 지식에 익숙하다면,** 아래 인터페이스 문서를 읽고 원하는 효과를 직접 편집해 보세요. [*Tasker*](https://play.google.com/store/apps/details?id=net.dinglisch.android.taskerm) 같은 자동화 소프트웨어와 함께 사용할 수 있습니다. Tasker 설정을 직접 편집하지 않아도, Tasker 설치만 성공하면 Market이나 다른 커뮤니티에서 공유된 자동화 설정을 가져올 수 있습니다.

**프로그래밍 기초가 있다면,** LifeUp과 연동되는 웹페이지나 Android App을 개발해 볼 수 있습니다. 이 페이지와 맞춤 Wordle이 그 예입니다. 자동화 도구 설정을 만들어 공유하는 것도 환영합니다.

---

## 다른 App 호출

*LifeUp*에서 외부 App을 호출하려면 상점 아이템에 "Link" 효과를 추가하고, **웹페이지 또는 App 전용 링크**를 입력한 뒤 상점 아이템을 사용해 호출을 트리거하면 됩니다.

**다음은 몇 가지 예시입니다("World"→"Market"→"Link"에서 인터페이스 호출 효과가 있는 공개 아이템도 볼 수 있습니다):**

- 브라우저로 Google 열기: https://www.google.com
- Facebook: [fb://](fb://)
- 패키지 이름/App ID로 App 열기: [market://launch?id=net.sarasarasa.lifeup](market://launch?id=net.sarasarasa.lifeup)
- ...

이론적으로 외부 App이 URL을 제공하면 상점 아이템으로 이동할 수 있습니다.

**Google에서 `URL Schemes`를 검색해 필요한 App 링크를 찾을 수 있습니다.**

**이 링크는 `LifeUp`과 무관하며, `LifeUp`은 URL 이동 기능만 제공합니다.**

**따라서 URL 목록을 유지·관리하지 않습니다. 다만 [World]→[Market]→[Link] 페이지에서 링크 효과가 있는 공개 상점 아이템을 볼 수 있습니다.**

App 패키지 이름(즉 ID)은 다음 방법으로 확인할 수 있습니다:

- Play Store URL: https://play.google.com/store/apps/details?id=net.sarasarasa.lifeup
- App 관리 App 사용
- Tasker의 App Info 동작 사용
- MacroDroid의 Launch App 동작 사용

---

## LifeUp API 호출

다음과 같은 경우:

- `LifeUp` 안에서 `LifeUp` 인터페이스를 호출해야 할 때: 상점 아이템에 "link" 효과를 추가하고, API 문서에 따라 **특정 URL**을 입력한 뒤 상점 아이템으로 호출을 완료하면 됩니다.
- 웹페이지에서 호출할 때: 하이퍼링크로 LifeUp API로 이동하면 됩니다.
- 직접 개발한 App에서 호출할 때: Intent로 해당 인터페이스 링크로 이동하면 됩니다.
- 자동화 도구(예: Tasker)로 호출할 때: Tasker의 Browser URL에 해당 API 링크를 입력하면 됩니다.

**예시:**

아래 링크를 클릭하면 "LifeUp"에 "You have learned to call APIs!"가 표시됩니다.

<a href="lifeup://api/toast?text=You have learned to call APIs!&type=1&isLong=true">lifeup://api/toast?text=You have learned to call APIs!&type=1&isLong=true</a>

아래 링크를 클릭하면 "LifeUp"에서 금화 1개를 받으며, 사유는 "Learn API Calls"입니다.

<a href="lifeup://api/reward?type=coin&content=Learn API Calls&number=1">lifeup://api/reward?type=coin&content=Learn API Calls&number=1</a>

링크를 아이템의 "link" 효과에 복사하면, 아이템 사용으로도 같은 효과를 트리거할 수 있습니다.

**외부 App 연동 예시:**

[Wordle Clone (lifeupapp.fun)](https://wiki.lifeupapp.fun/en/example/wordle/index.html)

Wordle은 5글자 단어를 맞히는 작은 단어 추측 게임입니다. 주황색은 정답에 포함된 글자, 초록색은 포함되었고 위치도 맞는 글자입니다.

**이 Wordle 버전은 "LifeUp"과 연동을 지원합니다:**

1. 단어를 맞히면 금화 10개를 받을 수 있으며, 획득 사유도 맞춤 설정됩니다.
2. 끝까지 맞히지 못하면 위로금으로 금화 1개를 받습니다.

![](_media/api/wordle.png ':size=30%')

<br/>

**Tasker 연동 예시:**

> Tasker는 `Action Category`→`Program`→`Shortcut`을 선택해 호출합니다. shortcut 열에 lifeup://로 시작하는 링크를 입력하세요.

매일 5시 이후 첫 화면 잠금 해제 시 지정한 작업(예: 기상) 완료를 트리거할 수 있습니다.

**참고: 이 설정을 가져오려면 Task Group Id가 필요합니다. [Settings]→[Labs]에서 [Developer Mode]를 켠 뒤 작업 상세 페이지에서 gid를 확인하세요.**

Tasker가 설치되어 있다면 [여기를 클릭해 설정된 작업을 가져오세요.](taskerproject://H4sIAAAAAAAAAKVWTW/bOBA9p7+CENCeshZlfcWtzMJts0ABY1EkaS49FKxE20xlSZDG3s2/3xmSku1ELer25OF7Q/LNB0fO7mT3XbUfJEjWtXPPY8Vez73AY7Cfe8mETwLuiRcX2ae2XulSGacG7ejKY3s196bEXmR5IUGJIEl4NONxMAvDMPMtaOiyEdDuFGJoEaKON4RRMA2vMl8NG1alXHcCIWsQpAsRIYA/tNrqgosozXxjEFJtlVgAi9mN6hSwu41iH+Rj5hNO/J3eWvl5XZmY6JqNiPGOjVttBcfV1q7AcOA4MBwYLvPpLMqK79IymqHZORk6yUcc8YDPfiEfsyf5SJ7k42/ddsA+V2Wdf1fFJXtfb5tSgWJU9kNqrveqgkNujmSj7rpAXZxj9MY08ZsNxrwFlNhvDca2JvFh50X2vq4KDbqulrqzV+qVdT/i7HlOSOjoi6zcdOJlpf4tqKy0cHjdiGCa+XXTAy1ymd/2Hpk/nGxF+CcqbEgmkJGaPqgc+po+8B+VNJmm05TPro5LWklM71Kv1OeGyR3ULHfZx8RLl/lGFx229SVV0tgEggGTS2pvsKBRRVLIpuIZSYBGlJyKQRlREiVpMEvO6C9qpmRopqbVVHKUhAYBi3woi8zBZSE9LnNMERzKfAut9W7XhzIOtUPWun10bYdu1DuynHvc859x059w4SmX+VbriOxgRHaY8mPZnRIrWXZYoc4h73ZV4R61icV11D16GRDvHvqzUjApdLUudZdvJrIq2loXEzATdnJzvby+X/xz9/V+cfNx8W55fStelfAGU4E7Fm0rH+0A9l+t4Q12yJln/Z6Ev+CxUeLL8kHu5aSU1Xpi9ZwvwJ7knhtlx700m79nTREMTVHiA9k1r31fNtrvX8jbtS7mL+myr2gNDXNSXPdM72Wr5bd+7u77yZ6XSrb1Dvp6DmvDqv+augWsHY6Jg20ovd3ugA7sdx4Awzf7XLtvmTEdWAhaF8OyEp/wxk4xXTU7YIBfIwqHrVFEwygm4+Tc8d0FVwTp4QQNAgwCPVKJo4zQ0uHO0fl1cBy2W5ncPUmYmSo0Sp6PlHRspHAeh/zHIyXk6TR+OlLSPxsp6W+MlNEmC8Znzhlz5YSLfsLFjgtHuMRxwbNZ1VfC/to/ZOLF/9uCy6GeCQAA)

![](_media/api/tasker_01.png ':size=30%')

![](_media/api/tasker_02.png ':size=30%')

<br/>

**MacroDroid로 LifeUp API 호출하기:**

> [MacroDroid](https://play.google.com/store/apps/details?id=com.arlosoft.macrodroid&hl=en_US&gl=US)도 자동화 도구이며, 무료 다운로드 가능하고 UI가 더 쉽습니다.

1. 매크로를 추가한 뒤 필요한 조건 설정(나중에 설정해도 됨)
2. `Actions` 추가
3. `Applications` 선택
4. `Open Website` 선택
5. `Enter URL` 필드에 `lifeup://`로 시작하는 URL 입력
6. 아래 옵션(예: `URL encode parameters`...)은 **[체크 해제]**
7. 저장 후 동작을 클릭하고 `Test action`으로 확인

<br/>

**이 기능으로 프로그래밍 지식 여부와 관계없이 LifeUp의 가능성을 크게 확장할 수 있습니다!**

구체적인 호출 규칙은 아래를 참고하세요.

---

## 인터페이스 문서

### 기본 - 예시

| 유형             | 설명   |
| ---------------- | ------------- |
| 예시          | <a href="lifeup://api/toast?text=You learned to call! &type=1&isLong=true">lifeup://api/toast?text=You learned to call! &type=1&isLong=true</a> |
| 인터페이스 형식 | fixed prefix/method name?parameter1=value1&parameter2=value2 |
| 고정 접두사     | lifeup://api/ |
| 메서드 이름      | toast         |
| 매개변수       | ?text=You learned to call! &type=1&isLong=true |

<br/>

### 기본 - 이스케이프 (URL Encode)

매개변수 값에 +, 공백, =, %, &, # 등 특수 기호가 포함되면 이스케이프가 필요합니다:

| 특수 문자 | 의미                                         | 치환 |
| :----------------- | :---------------------------------------------- | :--------- |
| +                  | URL에서 +는 공백을 나타냄        | +          |
| spaces             | URL의 공백은 + 또는 인코딩 가능              | %20        |
| /                  | 디렉터리와 하위 디렉터리 구분            | %2F        |
| ?                  | 실제 URL과 매개변수 구분         | %3F        |
| %                  | 특수 문자 지정                      | %          |
| #                  | 북마크를 의미                                  | %23        |
| &                  | URL에 지정된 매개변수 구분자   | %26        |
| =                  | URL에서 매개변수 값 지정 | %3D        |

위 팝업 메시지 인터페이스를 예로 들면, 최종 표시 텍스트가 `You have learned to call APIs!`이어야 한다면 공백을 +로 바꿔야 하며, 최종 결과는 다음과 같습니다:

<a href="lifeup://api/toast?text=You learned to call! &type=1&isLong=true">lifeup://api/toast?text=You learned to call! &type=1&isLong=true</a>
<br/>

**Javascript로 구현한 간단한 인코딩 도구입니다:**

<iframe src="guide/html/url_encoded.html" frameborder="0" scrolling="no" width="90%"> </iframe>

<br/>

### 기본 - LifeUp Data ID

LifeUp의 거의 모든 데이터 저장에는 고유 id가 있습니다.

아래 일부 인터페이스는 **지정된** 상점 아이템 수정과 **지정된** 작업 완료를 지원합니다.

`LifeUp`이 해당 데이터를 찾으려면 id를 제공해야 합니다.

**App에서 [Settings] → [Labs] → [Developer Mode]를 켜면 각 상세 페이지에서 데이터의 원본 id를 볼 수 있습니다.**

예를 들어 "strength (1)"처럼 표시되는 속성 이름의 속성 id는 1입니다.

#### Task id

작업 상세 페이지에서 확인할 수 있습니다.

id: 반복 작업이면 반복할 때마다 id가 갱신됩니다.

gid: 아이템 그룹 id. 같은 반복 작업의 gid는 변하지 않습니다.

#### List id

"Developer Mode"를 켠 뒤 "Select List" 팝업에서 확인합니다.

#### Attribute id

"Developer Mode"를 켠 뒤 "Custom Attributes" 페이지에서 확인합니다.

#### Shop item id

"Developer Mode"를 켠 뒤 상점 아이템을 클릭해 상세를 확인합니다.

#### Achievement condition id

업적 "requires an external API call to unlock" 해제 조건을 맞춤 설정한 뒤, 상세 페이지에서 condition id를 확인할 수 있습니다.and

<br/>

### 기본 - 이름 매칭

API가 이름으로 작업, 상점 아이템, 하위 작업을 조회할 수 있으면, LifeUp은 먼저 대소문자를 무시한 정확한 이름 일치를 시도합니다. 정확히 일치하는 항목이 없으면 포함 관계 기반의 퍼지 매칭으로 넘어갑니다.

예를 들어 "Coin"과 "Coin Box"가 모두 있으면 `name=Coin`을 전달하면 퍼지 결과 순서와 관계없이 "Coin"이 먼저 매칭됩니다.

중복되거나 유사한 이름으로 모호할 수 있으면 해당 id를 전달하는 편이 좋습니다.

<br/>

### 기본 - 반환값

일부 인터페이스는 반환값을 가질 수 있습니다.

**Android App을 개발 중이라면,** `onActivityResult` 메서드로 반환값을 받을 수 있습니다.

**Tasker 같은 자동화 App을 사용 중이라면:**

일반적으로 이런 App은 Activity 유형 반환값을 받을 수 없습니다. `broadcast` 매개변수를 추가한 뒤 `received intent` 이벤트로 반환값을 받아야 합니다.

자세한 내용은 아래 broadcast 매개변수를 참고하세요.

<br/>

### 기본 - JSON Data Structure

?> v1.98.0+ 필요

이 절에서는 API에서 자주 쓰는 JSON 데이터 구조를 소개합니다.

#### 1. 아이템 보상 구조

아이템 보상을 지정하는 JSON 배열이며, 각 항목은 ID와 수량을 포함합니다.

```json
[
    {
        "item_id": 1,    // Item ID
        "amount": 2      // Quantity
    },
    {
        "item_id": 2,
        "amount": 3
    }
]
```

#### 2. 업적 해제 조건 구조

```json
[
    {
        "type": 7,           // Condition type
        "related_id": null,  // Related ID (some types must provide)
        "target": 1000000    // Target value
    }
]
```

#### 3. 구매 제한 구조

`purchase_limit`는 JSON 배열입니다. 각 객체는 하나의 제한 규칙을 나타냅니다.

| 필드 | 의미 | 유형 | 필수 | 참고 |
| ----- | ------- | ---- | -------- | ----- |
| limitType | 제한 유형 | number | Yes | 아래 유형 표 참고 |
| limitNumber | 주 숫자 값 | number | No* | 수량/범위 기반 규칙에 사용 |
| maxNumber | 범위 상한 | number | No | 속성 레벨 범위 / 보유 아이템 수량 범위에 사용 |
| limitId | 관련 대상 ID | number | No* | 속성 / 아이템 / 작업 / 작업 주기 / 업적 기반 규칙에 필요 |
| extendInfo | 추가 페이로드 | string | No | 시간 기반 규칙에 사용; 값 자체는 JSON 문자열 |

**유형 정의**

| limitType | 의미 | 필수 필드 / 참고 |
| --------- | ------- | ----------------------- |
| 0 | 일일 수량 제한 | `limitNumber`: 하루 최대 횟수 |
| 1 | 주간 수량 제한 | `limitNumber`: 주당 최대 횟수 |
| 2 | 월간 수량 제한 | `limitNumber`: 월 최대 횟수 |
| 3 | 연간 수량 제한 | `limitNumber`: 연 최대 횟수 |
| 10 | 속성 레벨 규칙 | `limitId`: attribute ID<br/>`limitNumber`: 최소 레벨<br/>`maxNumber`: 선택적 최대 레벨 |
| 20 | 일일 시간 범위 | `extendInfo`: `{"startMinuteOfDay":540,"endMinuteOfDay":1320}` |
| 21 | 요일 선택 | `extendInfo`: `{"weekdays":[1,2,3,4,5]}`<br/>월요일 = 1, 일요일 = 7 |
| 22 | 절대 시간 범위 | `extendInfo`: `{"startMillis":1710000000000,"endMillis":1710086400000}` |
| 23 | 월 선택 | `extendInfo`: `{"months":[1,6,12]}` |
| 24 | 월중 일 선택 | `extendInfo`: `{"daysOfMonth":[1,15,31]}` |
| 30 | 보유 아이템 수량 규칙 | `limitId`: 대상 item ID<br/>`limitNumber`: 최소 보유 수<br/>`maxNumber`: 선택적 최대 보유 수 |
| 31 | 작업 완료 규칙 | `limitId`: task ID |
| 32 | 업적 해제 규칙 | `limitId`: achievement ID |
| 33 | 작업 주기 완료 규칙 | `limitId`: 반복 작업 group ID (`groupId`)<br/>해당 그룹에서 가장 최근 시작된 주기 기준으로 검증 |

**참고**

- `limitType=33`일 때 `limitId`는 task ID가 아닙니다. 반복 작업 `groupId`여야 합니다.

- 레거시 호환 페이로드는 `maxNumber`와 `extendInfo`를 생략할 수 있습니다.
- `extendInfo`는 문자열 필드이므로, URL로 API를 호출할 때 내부 JSON 문자열은 보통 한 번 더 이스케이프/인코딩이 필요합니다.

**예시:**

```json
[
    {
        "limitType": 0,
        "limitNumber": 5
    },
    {
        "limitType": 10,
        "limitId": 1,
        "limitNumber": 5,
        "maxNumber": 10
    }
]
```

#### 4. 아이템 효과 구조

```json
[
    {
        "type": 2,           // Effect type
        "info": {            // Effect parameters, different for different types
            "min": 100,      // Minimum value (used for gold rewards, etc.)
            "max": 200       // Maximum value (used for gold rewards, etc.)
        }
    }
]
```

#### 효과 유형 설명

?> 유형 10–16은 v1.102.0+부터 지원됩니다.

| 유형 코드 | 의미 | 매개변수 설명 |
| ------- | ---- | ------- |
| 0 | 특수 효과 없음 | 매개변수 없음 |
| 1 | 사용 불가 | 매개변수 없음 |
| 2 | 금화 추가 | min: 최소 금화<br/>max: 최대 금화(선택, 기본값 min)<br/>using_limit: 시스템 제한 적용 여부(선택) |
| 3 | 금화 제거 | min: 최소 금화<br/>max: 최대 금화(선택, 기본값 min)<br/>using_limit: 시스템 제한 적용 여부(선택) |
| 4 | 경험치 추가 | ids: 스킬 ID 배열<br/>value: 경험치 값(레거시, min과 동일)<br/>min: 최소 경험치(선택, value가 없을 때)<br/>max: 최대 경험치(선택, 기본값 min/value)<br/>using_limit: 제한 사용 여부(선택, 기본 false) |
| 5 | 경험치 제거 | ids: 스킬 ID 배열<br/>value: 경험치 값(레거시, min과 동일)<br/>min: 최소 경험치(선택, value가 없을 때)<br/>max: 최대 경험치(선택, 기본값 min/value)<br/>using_limit: 제한 사용 여부(선택, 기본 false) |
| 6 | 간단 합성 | require_number: 필요 수량<br/>item_id: Item ID |
| 7 | 전리품 상자 열기 | items: 아이템 배열, 각 항목 포함:<br/>- item_id: Item ID<br/>- amount: 수량<br/>- probability: 확률<br/>- is_fixed_reward: 고정 보상 여부 |
| 8 | 카운트다운 | seconds: 카운트다운 초 |
| 9 | Web link | url: 링크 주소<br/>use_web_view: 내장 브라우저 사용 여부(선택, 기본 false) |
| 10 | 감정 기록 | 매개변수 없음 |
| 11 | 금화 변경(증감) | min: 최소 금화(음수 가능)<br/>max: 최대 금화(선택, 기본값 min)<br/>using_limit: 시스템 제한 적용 여부(선택) |
| 12 | 경험치 변경(증감) | ids: 스킬 ID 배열<br/>value: 경험치 값(레거시, min과 동일)<br/>min: 최소 경험치(음수 가능)<br/>max: 최대 경험치(선택, 기본값 min/value)<br/>using_limit: 제한 사용 여부(선택, 기본 false) |
| 13 | 아이템 재고 추가 | item_id: 대상 item ID<br/>min: 최소 재고 변경량<br/>max: 최대 재고 변경량(선택, 기본값 min)<br/>using_limit: 재고 제한 적용 여부(선택) |
| 14 | 아이템 재고 제거 | item_id: 대상 item ID<br/>min: 최소 재고 변경량<br/>max: 최대 재고 변경량(선택, 기본값 min)<br/>using_limit: 재고 제한 적용 여부(선택) |
| 15 | 아이템 재고 변경(증감) | item_id: 대상 item ID<br/>min: 최소 재고 변경량(음수 가능)<br/>max: 최대 재고 변경량(선택, 기본값 min)<br/>using_limit: 재고 제한 적용 여부(선택) |
| 16 | 사운드 재생 | file_name: 로컬 사운드 파일 이름(권장)<br/>uri: 가져올 사운드 URI(file_name 대안)<br/>display_name: 표시 이름(선택) |

**효과 예시:**

무작위 금화 증가:

```json
{
    "type": 2,
    "info": {
        "min": 100,
        "max": 200
    }
}
```

경험치 증가:

```json
{
    "type": 4,
    "info": {
        "ids": [1, 2],
        "value": 50,
        "using_limit": false
    }
}
```

금화 변경(무작위 +/-):

```json
{
    "type": 11,
    "info": {
        "min": -10,
        "max": 20
    }
}
```

아이템 재고 변경(무작위 +/-):

```json
{
    "type": 15,
    "info": {
        "item_id": 1,
        "min": -3,
        "max": 5
    }
}
```

사운드 재생:

```json
{
    "type": 16,
    "info": {
        "display_name": "API test sound",
        "uri": "android.resource://net.sarasarasa.lifeup/raw/bellringing"
    }
}
```

전리품 상자 효과:

```json
{
    "type": 7,
    "info": {
        "items": [
            {
                "item_id": 1,
                "amount": 1,
                "probability": 50,
                "is_fixed_reward": false
            },
            {
                "item_id": 2,
                "amount": 1,
                "probability": 50,
                "is_fixed_reward": true
            }
        ]
    }
}
```

<br/>

### Popup message

**메서드 이름:** toast

**설명:** 다양한 스타일의 메시지가 팝업으로 표시됩니다.

**예시:** <a href="lifeup://api/toast?text=Live well, eat well!&type=1&isLong=true">lifeup://api/toast?text=Live well, eat well!&type=1&isLong=true</a>

**설명:** "Live well, eat well!" 메시지가 보너스 스타일로 팝업되며 더 오래 표시됩니다.

> 예시 링크를 클릭해 효과를 테스트해 보세요.

| 매개변수 | 의미 | 유형 | 예시 | 필수 | 참고 |
| --------- | ---------------------- | ------------------ | -------------------- | -------- | ----- |
| text | 표시할 텍스트 메시지 | 임의 텍스트 | You learned to call! | 예 | |
| type | 텍스트 스타일 유형 | 0~6 숫자 | 1 | 아니오 | 0 - 일반 스타일<br/>1 - 보너스 스타일<br/>2 - 토마토 스타일<br/>3 - 성공 스타일<br/>4 - 안내 스타일<br/>5 - 경고 스타일<br/>6 - 오류 스타일 |
| isLong | 표시 시간 | true 또는 false | true | 아니오 | true - 길게<br/>false - 짧게 |

<br/>

### Reward

**메서드 이름:** reward

**설명:** 보상을 직접 지급합니다. 보상 사유는 사용자 지정할 수 있습니다.

**예시:**

- 금화 1개를 받으며, 획득 사유는 "Learn API Calls"입니다. 사유는 금화 상세 페이지에 표시됩니다:

  <a href="lifeup://api/reward?type=coin&content=Learn API Calls&number=1">lifeup://api/reward?type=coin&content=Learn API Calls&number=1</a>

- "Learning, Creativity"에 대해 경험치 300을 받으며, 획득 사유는 "Learn API Calls"입니다. 사유는 경험치 상세 페이지에 표시됩니다:

  <a href="lifeup://api/reward?type=exp&content=Learn API Calls&number=300&skills=2&skills=6">lifeup://api/reward?type=exp&content=Learn API Calls&number=300&skills=2&skills=6</a>

- "treasure"와 퍼지 매칭되는 아이템 1개를 받으며, 획득 사유는 "Learn API Calls"입니다. 사유는 인벤토리 기록 페이지에 표시됩니다:

  <a href="lifeup://api/reward?type=item&content=Learn API Calls&number=1&item_name=treasure">lifeup://api/reward?type=item&content=Learn API Calls&number=1&item_name=treasure</a>

| 매개변수 | 의미 | 유형 | 예시 | 필수 | 참고 |
| --------- | ----------------------------- | ------------------------------- | ------------------ | -------- | -------------------------------- |
| type | 보상 유형 | 현재 다음 값만 지원:<br/>coin<br/>exp<br/>item | coin | 예 | coin - 금화<br/>exp - 경험치<br/>item - 상점 아이템 |
| content | 보상 사유 | 임의 텍스트 | Learning API Calls | 예 | |
| skills | 스킬(속성) | 0보다 큰 숫자 배열 | 1 | 아니오 | type이 exp일 때만 사용 가능<br/>배열 지원(예: &skills=1&skills=2&skills=3)<br/>확인 방법은 위 "기본 - LifeUp Data ID" 절 참고 |
| number | 보상 수량 | 0보다 큰 숫자 | 1 | 예 | 금화일 때 최대 999999<br/>경험치일 때 최대 99999<br/>아이템일 때 최대 999 |
| item_id | item id | 0보다 큰 숫자 | 1 | 아니오* | type이 item일 때만 사용 가능 |
| item_name | item name | 임의 텍스트 | treasure | 아니오* | type이 item일 때만 사용 가능, 아이템 이름 퍼지 매칭 |
| silent | UI 알림 비활성화 여부 | true 또는 false | false | 아니오 | 기본값 false |

<br/>

### Penalty

**메서드 이름:** penalty

**설명:** 페널티를 직접 적용합니다. 페널티 사유는 사용자 지정할 수 있습니다.

**예시:** *기본적으로 reward 인터페이스와 동일

- 금화 1개를 차감하며, 사유는 "sleep in"입니다. 사유는 금화 상세 페이지에 표시됩니다:

  <a href="lifeup://api/penalty?type=coin&content=sleep in&number=1">lifeup://api/penalty?type=coin&content=sleep in&number=1</a>

- "sleep in"에 대해 "Strength" 경험치 300을 차감합니다. 사유는 경험치 상세 페이지에 표시됩니다:

  <a href="lifeup://api/penalty?type=exp&content=sleep in&number=300&skills=1">lifeup://api/penalty?type=exp&content=sleep in&number=300&skills=1</a>

- "sleep in"에 대해 "treasure"와 퍼지 매칭되는 아이템 1개를 차감합니다. 사유는 인벤토리 기록 페이지에 표시됩니다:

  <a href="lifeup://api/penalty?type=item&content=sleep in&number=1&item_name=treasure">lifeup://api/penalty?type=item&content=sleep in&number=1&item_name=treasure</a>

| 매개변수 | 의미 | 유형 | 예시 | 필수 | 참고 |
| --------- | ----------------------------- | ---------------------------------------------------- | -------- | -------- | ---------------- |
| type | 페널티 유형 | 현재 다음만 지원:<br/>coin<br/>exp<br/>item | coin | 예 | coin - 금화<br/>exp - 경험치<br/>item - 상점 아이템 |
| content | 페널티 사유 | 임의 텍스트 | Sleep In | 예 | |
| skills | 스킬(속성) | 0보다 큰 숫자 배열 | 1 | 아니오 | type이 exp일 때만 사용 가능<br/>배열 지원(예: &skills=1&skills=2&skills=3)<br/>확인 방법은 위 "기본 - LifeUp Data ID" 절 참고 |
| number | 페널티 수량 | 0보다 큰 숫자 | 1 | 예 | 금화일 때 최대 999999<br/>경험치일 때 최대 99999<br/>아이템일 때 최대 999 |
| item_id | item id | 0보다 큰 숫자 | 1 | 아니오* | type이 item일 때만 사용 가능 |
| item_name | item name | 임의 텍스트 | treasure | 아니오* | type이 item일 때만 사용 가능, 아이템 이름 퍼지 매칭 |
| silent | UI 알림 비활성화 여부 | true 또는 false | false | 아니오 | 기본값 false |

<br/>

### Edit Coin

**메서드 이름:** edit_coin

**설명:** 사용자의 금화 잔액을 직접 편집합니다. 현재 금화 수량이 지정한 값으로 설정됩니다. 변경 사유는 사용자 지정할 수 있으며 금화 기록에 표시됩니다.

**예시:**

- 사유 "API adjustment"로 금화를 1000으로 설정: <a href="lifeup://api/edit_coin?coin=1000&content=API adjustment">lifeup://api/edit_coin?coin=1000&content=API adjustment</a>
- 조용히 금화를 500으로 설정: <a href="lifeup://api/edit_coin?coin=500&silent=true">lifeup://api/edit_coin?coin=500&silent=true</a>

| 매개변수 | 의미 | 유형 | 예시 | 필수 | 참고 |
| --------- | ------- | ---- | ------- | -------- | ----- |
| coin | 목표 금화 수량 | number >= 0 | 1000 | 예 | 작업 후 최종 금화 잔액, 최대 999999 |
| content | 변경 사유 | 임의 텍스트 | API adjustment | 아니오 | 미지정 시 시스템 기본 사유 사용 |
| reason | 변경 사유(별칭) | 임의 텍스트 | API adjustment | 아니오 | content 매개변수 대안 |
| silent | UI 알림 비활성화 | true 또는 false | false | 아니오 | 기본값 false, true로 설정하면 toast 메시지 억제 |

<br/>

### Tasks

#### Add a Task

?> `pin` 같은 일부 필드는 v1.98.0+ 필요

**메서드 이름:** add_task

**설명:** 작업을 직접 생성합니다.

**예시:**
[lifeup://api/add_task?todo=This is an auto-added task&notes=notes&coin=10&coin_var=1&exp=2048&skills=1&skills=2&skills=3&category=0&item_name=coin](lifeup://api/add_task?todo=This is an auto-added task&notes=notes&coin=10&coin_var=1&exp=2048&skills=1&skills=2&skills=3&category=0&item_name=coin)

| 매개변수 | 의미 | 값 | 예시 | 필수 | 참고 |
| ---------------- | ------------------- | -------------------- | --------- | -------- | ------------------------------- |
| todo | 작업 내용 | 임의 텍스트 | Write diary | 예 | |
| notes | 메모 | 임의 텍스트 | Notes | 아니오 | 기본값 빈 문자열 |
| coin | 금화 보상 | number >= 0 | 10 | 아니오 | 기본값 0, 시스템 제한 적용 |
| coin_var | 금화 보상 변동 | number >= 0 | 1 | 아니오 | 기본값 0; >0이면 [coin, coin+coin_var] 사이 무작위 보상 |
| exp | 경험치 보상 | number >= 0 | 100 | 아니오 | 기본값 0, 시스템 제한 적용 |
| skills | 스킬 ID | 0보다 큰 숫자 배열 | 1 | 아니오 | 배열 지원(예: &skills=1&skills=2) |
| category | 목록 ID | number >= 0 | 0 | 아니오 | 기본값 0(기본 목록); 스마트 목록 불가 |
| frequency | 반복 주기 | 정수 | 0 | 아니오 | 기본값 0(1회)<br/>0 - 1회<br/>1 - 매일<br/>N (N>1) - N일마다<br/>-1 - 무제한<br/>-3 - 에빙하우스(v1.99.1 필요)<br/>-4 - 매월<br/>-5 - 매년 |
| weekdays | 요일 | `1,3,5` 또는 `none` | 1,3,5 | 아니오 | v1.106.0+; 1=월요일 … 7=일요일, **반복할** 요일. 지정 시 frequency는 생략하거나 1이어야 함. 추가 시 `none`은 거부됨; 편집 시 `none`은 매일로 되돌림. 7일 모두 지정하면 매일로 처리 |
| importance | 중요도 | [1, 4] | 1 | 아니오 | 기본값 1 |
| difficulty | 난이도 | [1, 4] | 1 | 아니오 | 기본값 1 |
| deadline | 마감 시간 | 타임스탬프(밀리초) | 1640995200000 | 아니오 | |
| no_deadline | 마감 없음 | true/false | true | 아니오 | v1.104.0+; 반복 작업에만 유효. `&no_deadline=true` 전달 시 특정 마감 시간 해제 |
| color | 태그 색상 | 색상 문자열 | #66CCFF | 아니오 | #는 %23으로 이스케이프 필요 |
| background_url | 배경 이미지 URL | 웹 URL | http://example.com/bg.jpg | 아니오 | 접근 가능한 웹 이미지여야 함 |
| background_alpha | 배경 불투명도 | [0, 1] 실수 | 0.5 | 아니오 | 기본값 1.0 |
| enable_outline | 텍스트 외곽선 활성화 | true 또는 false | false | 아니오 | background_url과 함께만 유효, 가독성을 위해 텍스트 외곽선 추가 |
| use_light_remark_text_color | 메모에 밝은 텍스트 사용 | true 또는 false | false | 아니오 | background_url과 함께만 유효, 메모 텍스트에 밝은 색 사용 |
| start_time | 시작 시간 | 타임스탬프(밀리초) | 1640995200000 | 아니오 | 작업 시작 시간 |
| auto_use_item | 보상 아이템 자동 사용 | true 또는 false | false | 아니오 | 완료 시 보상 자동 사용 |
| remind_time | 알림 시간 | 타임스탬프(밀리초) | 1640995200000 | 아니오 | 작업 알림 시간 |
| pin | 작업 고정 | true 또는 false | false | 아니오 | 작업을 상단에 고정 |
| words | 완료 보상 텍스트 | 임의 텍스트 | Great job! | 아니오 | 작업 완료 시 표시되는 동기 부여 문구 |
| frozen | 동결 상태 | true 또는 false | false | 아니오 | 기본값 false |
| freeze_until | 동결 종료 시각 | 타임스탬프(밀리초) | 1640995200000 | 아니오 | frozen이 true일 때만 적용 |
| coin_penalty_factor | 금화 페널티 계수 | [0, 100) 실수 | 0.5 | 아니오 | |
| exp_penalty_factor | 경험치 페널티 계수 | [0, 100) 실수 | 0.5 | 아니오 | |
| write_feelings | 감정 기록 활성화 | true 또는 false | false | 아니오 | 기본값 false |
| item_id | Item ID | number > 0 | 1 | 아니오* | item_id 또는 item_name 중 하나 필수 |
| item_name | Item name | 임의 텍스트 | Treasure | 아니오* | item_id 또는 item_name 중 하나 필수 |
| item_amount | 아이템 수량 | [1, 99] | 1 | 아니오 | 기본값 1 |
| items | 아이템 보상 | JSON 텍스트 | [아이템 보상 구조](#1-item-rewards-structure) 참고 | 아니오 | 여러 아이템 보상 설정 |
| task_type | 작업 유형 | [0, 4] | 0 | 아니오 | v1.99.1 필요<br/>0 - 일반 작업<br/>1 - 카운트 작업<br/>2 - 부정 작업<br/>3 - API 작업<br/>4 - 시간 제한 작업(v1.102.0+) |
| target_times | 목표 횟수 | number > 0 | 1 | 아니오 | task_type이 1(카운트 작업)일 때만 유효 |
| is_affect_shop_reward | 상점 보상에 영향 | true/false | false | 아니오 | task_type이 1(카운트 작업)일 때만 유효, 아이템 보상 계산에 영향을 줄지 여부 |
| enable_proportional_settlement | 비례 정산 활성화 | true/false | false | 아니오 | v1.104.0+; task_type이 1(카운트 작업)일 때만 유효. 활성화 시 카운트 진행 정산이 비례 보상을 지급하며, 최종 완료 시 이미 정산된 보상은 다시 지급하지 않음 |
| expected_focus_minutes | 예상 집중 시간(분) | number > 0 | 25 | 아니오 | task_type이 4(시간 제한 작업)일 때만 유효; 기본값 25(v1.102.0+) |
| repeat_end_mode | 반복 종료 모드 | 0 또는 1 | 0 | 아니오 | 반복 작업에만 유효(frequency가 0 / -1이 아님)<br/>0 - 횟수로 종료<br/>1 - 날짜로 종료(v1.102.0+) |
| repeat_target_times | 반복 종료 횟수 | number > 0 | 3 | 아니오 | repeat_end_mode=0일 때 사용(또는 이 필드 존재로 추론); target_times와 혼동하지 말 것(v1.102.0+) |
| repeat_end_date | 반복 종료 날짜 | 타임스탬프(밀리초) | 1640995200000 | 아니오 | repeat_end_mode=1일 때 사용(또는 이 필드 존재로 추론)(v1.102.0+) |
| repeat_end_behavior | 반복 종료 동작 | 0 또는 1 | 0 | 아니오 | 0 - 종료 조건 도달 후 작업 종료<br/>1 - 종료 조건 도달 후 작업 동결(v1.102.0+) |

**반환값:**

| 필드 | 유형 | 설명 | 예시 | 참고 |
| -------- | ------- | ---------------- | ------- | ------------------------ |
| task_id | Number | 작업 ID | 1000 | |
| task_gid | Number | 작업 그룹 ID | 1000 | |

<br/>

#### Complete a Task

**메서드 이름:** complete

**설명:** 작업 완료를 트리거합니다. 미완료 작업만 검색됩니다.

**예시:**

- id가 1인 작업 완료: [lifeup://api/complete?id=1](lifeup://api/complete?id=1)
- "task group id"가 1인 작업 완료: [lifeup://api/complete?gid=1](lifeup://api/complete?gid=1)
- 이름으로 작업을 검색해 완료: <a href="lifeup://api/complete?name=Start using&ui=true">lifeup://api/complete?name=Start using&ui=true</a>

**설명:**

각 작업에는 id가 있습니다.

반복 작업의 경우 id는 반복할 때마다 갱신되지만 "task group id"는 동일합니다.

id 확인 방법: [Labs] 페이지에서 "Developer Mode"를 연 뒤 "Task Details" 페이지에서 확인합니다.

| 매개변수 | 의미 | 유형 | 예시 | 필수 | 참고 |
| --------- | ------------------------------- | --------------------- | ------- | -------- | ----- |
| id | task id | 0보다 큰 숫자 | 1 | 아니오* | task id; 반복 작업이면 반복할 때마다 id가 갱신됨 |
| gid | task group id | 0보다 큰 숫자 | 1 | 아니오* | task group id |
| name | 이름 | 임의 텍스트 | get up | 아니오* | 퍼지 검색, 찾은 작업 중 하나만 |
| ui | 팝업 UI 표시 여부 | true 또는 false | true | 아니오 | 기본값 false, 백그라운드에서 메시지만 표시 |
| count | 카운트 값 | Number | 1 | 아니오 | 카운트 작업에만 적용, `count_set_type` 매개변수와 함께 사용 |
| count_set_type | 카운트 값 설정 방식 | 다음 중 하나:<br/>absolute<br/>relative | absolute | 아니오 | 기본값 relative<br/>absolute - 값을 직접 설정<br/>relative - 원래 값 기준 가감 |
| count_force_sum_up | 카운트 작업 보상 강제 합산 | true 또는 false | true | 아니오 | |
| reward_factor | 보상 계수 | 0보다 큰 실수 | 1.1 | 아니오 | 카운트 작업에는 적용되지 않음<br/>보상 계수는 경험치·금화 수량에 영향(아이템 수량에는 영향 없음) |

**주의:**

1. 작업을 매칭하려면 id, gid, name 중 하나를 제공해야 합니다.
2. 시간 제한 작업은 이 API로 수동 완료할 수 없습니다(v1.102.0+).

<br/>

#### Give up a Task

**메서드 이름:** give_up

**설명:** 작업 포기를 트리거합니다.

**예시:**

- 이름으로 작업을 검색해 포기: [lifeup://api/give_up?name=get up early](lifeup://api/give_up?name=get up early)

**설명:**

| 매개변수 | 의미 | 유형 | 예시 | 필수 | 참고 |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id | task id | 0보다 큰 숫자 | 1 | 아니오* | task id; 반복 작업이면 반복할 때마다 id가 갱신됨 |
| gid | task group id | 0보다 큰 숫자 | 1 | 아니오* | task group id |
| name | 이름 | 임의 텍스트 | get up | 아니오* | 퍼지 검색, 매칭된 작업 하나만 대상 |

**주의:**

1. 작업을 매칭하려면 id, gid, name 중 하나를 제공해야 합니다.

<br/>

#### Freeze a task

**메서드 이름:** freeze

**설명:** 작업 동결을 트리거합니다. 반복 작업에만 해당합니다.

**예시:**

- 이름으로 작업을 검색해 동결: [lifeup://api/freeze?name=get up early](lifeup://api/freeze?name=get up early)

**설명:**

| 매개변수 | 의미 | 유형 | 예시 | 필수 | 참고 |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id | task id | 0보다 큰 숫자 | 1 | 아니오* | task id; 반복 작업이면 반복할 때마다 id가 갱신됨 |
| gid | task group id | 0보다 큰 숫자 | 1 | 아니오* | task group id |
| name | 이름 | 임의 텍스트 | get up | 아니오* | 퍼지 검색, 매칭된 작업 하나만 대상 |
| time | 동결 종료 시각 | timestamp | 1661688800682 | 아니오 | - |

**주의:**

1. 작업을 매칭하려면 id, gid, name 중 하나를 제공해야 합니다.

<br/>

#### Unfreeze a task

**메서드 이름:** unfreeze

**설명:** 작업 동결 해제를 트리거합니다.

**예시:**

- 이름으로 작업을 검색해 동결 해제: [lifeup://api/unfreeze?name=get up early](lifeup://api/unfreeze?name=get up early)

**설명:**

| 매개변수 | 의미 | 유형 | 예시 | 필수 | 참고 |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id | task id | 0보다 큰 숫자 | 1 | 아니오* | task id; 반복 작업이면 반복할 때마다 id가 갱신됨 |
| gid | task group id | 0보다 큰 숫자 | 1 | 아니오* | task group id |
| name | 이름 | 임의 텍스트 | get up | 아니오* | 퍼지 검색, 매칭된 작업 하나만 대상 |

**주의:**

1. 작업을 매칭하려면 id, gid, name 중 하나를 제공해야 합니다.

<br/>

#### Delete a task

**메서드 이름:** delete_task

**설명:** 작업을 삭제합니다.

**예시:**

- 이름으로 작업을 검색해 삭제: [lifeup://api/delete_task?name=get up early](lifeup://api/delete_task?name=get up early)

**설명:**

| 매개변수 | 의미 | 유형 | 예시 | 필수 | 참고 |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id | task id | 0보다 큰 숫자 | 1 | 아니오* | task id; 반복 작업이면 반복할 때마다 id가 갱신됨 |
| gid | task group id | 0보다 큰 숫자 | 1 | 아니오* | task group id |
| name | 이름 | 임의 텍스트 | get up | 아니오* | 퍼지 검색, 매칭된 작업 하나만 대상 |

**주의:**

1. 작업을 매칭하려면 id, gid, name 중 하나를 제공해야 합니다.

<br/>

### Edit Task

?> v1.98.0+ 필요

**메서드 이름:** edit_task

**설명:** 기존 작업의 내용과 속성을 편집합니다.

**예시:**
[lifeup://api/edit_task?id=1&todo=Modified task content&notes=notes&coin=10&exp=20&skills=1&skills=2&category=0](lifeup://api/edit_task?id=1&todo=Modified task content&notes=notes&coin=10&exp=20&skills=1&skills=2&category=0)

| 매개변수 | 의미 | 값 | 예시 | 필수 | 참고 |
| ------------------ | -------------------- | -------------------- | --------- | -------- | ------------------------------- |
| id | 작업 ID | 0보다 큰 숫자 | 1 | 아니오* | id, gid, name 중 하나 필수 |
| gid | 작업 그룹 ID | 0보다 큰 숫자 | 1 | 아니오* | id, gid, name 중 하나 필수 |
| name | 작업 이름 | 임의 텍스트 | Write diary | 아니오* | id, gid, name 중 하나 필수 |
| todo | 작업 내용 | 임의 텍스트 | Write weekly | 아니오 | |
| notes | 메모 | 임의 텍스트 | Note content | 아니오 | |
| coin | 금화 보상 | number >= 0 | 10 | 아니오 | 완료 시 획득 금화, 시스템 제한 적용 |
| coin_var | 금화 변동 | 0보다 큰 숫자 | 1 | 아니오 | [coin, coin+coin_var] 사이 무작위 보상 |
| exp | 경험치 보상 | number >= 0 | 20 | 아니오 | 획득 경험치, 시스템 제한 적용 |
| skills | 스킬 ID | 0보다 큰 숫자 배열 | 1 | 아니오 | 배열 지원(예: &skills=1&skills=2) |
| category | 목록 ID | 0 이상 숫자 | 0 | 아니오 | 0은 기본 목록, 스마트 목록 미지원 |
| frequency | 반복 주기 | 정수 | 0 | 아니오 | 기본값 0(1회)<br/>0 - 1회<br/>1 - 매일<br/>N (N>1) - N일마다<br/>-1 - 무제한<br/>-3 - 에빙하우스(v1.99.1 필요)<br/>-4 - 매월<br/>-5 - 매년 |
| weekdays | 요일 | `1,3,5` 또는 `none` | 1,3,5 | 아니오 | v1.106.0+; add_task와 동일. 생략 시 변경 없음; `none`은 매일로 되돌림; frequency를 1이 아닌 값으로 설정해도 weekdays 해제 |
| importance | 중요도 | [1, 4] | 1 | 아니오 | 기본값 1 |
| difficulty | 난이도 | [1, 4] | 2 | 아니오 | 기본값 1 |
| deadline | 마감일 | 타임스탬프(밀리초) | 1640995200000 | 아니오 | |
| no_deadline | 마감 없음 | true/false | true | 아니오 | v1.104.0+; 반복 작업에만 유효. `&no_deadline=true` 전달 시 특정 마감 시간 해제 |
| remind_time | 알림 시간 | 타임스탬프(밀리초) | 1640995200000 | 아니오 | |
| start_time | 시작 시간 | 타임스탬프(밀리초) | 1640995200000 | 아니오 | |
| color | 태그 색상 | 색상 문자열 | #66CCFF | 아니오 | #는 %23으로 이스케이프 필요 |
| background_url | 배경 이미지 URL | 웹 URL 주소 | http://example.com/bg.jpg | 아니오 | |
| background_alpha | 배경 불투명도 | [0, 1] 실수 | 0.5 | 아니오 | |
| enable_outline | 텍스트 외곽선 활성화 | true 또는 false | false | 아니오 | background_url과 함께만 유효, 가독성을 위해 텍스트 외곽선 추가 |
| use_light_remark_text_color | 메모에 밝은 텍스트 사용 | true 또는 false | false | 아니오 | background_url과 함께만 유효, 메모 텍스트에 밝은 색 사용 |
| item_id | Item ID | 0보다 큰 숫자 | 1 | 아니오* | item_id 또는 item_name 중 하나 필수 |
| item_name | Item name | 임의 텍스트 | Treasure | 아니오* | item_id 또는 item_name 중 하나 필수 |
| item_amount | 아이템 수량 | [1, 99] | 1 | 아니오 | 기본값 1 |
| items | 아이템 보상 JSON | JSON 텍스트 | [{"itemId":1,"amount":1}] | 아니오 | 여러 아이템 보상 설정 |
| auto_use_item | 아이템 자동 사용 | true 또는 false | false | 아니오 | |
| frozen | 동결 상태 | true 또는 false | false | 아니오 | 기본값 false |
| freeze_until | 동결 종료 시각 | 타임스탬프(밀리초) | 1640995200000 | 아니오 | frozen이 true일 때만 적용 |
| coin_penalty_factor | 금화 페널티 계수 | [0, 100) 실수 | 0.5 | 아니오 | |
| exp_penalty_factor | 경험치 페널티 계수 | [0, 100) 실수 | 0.5 | 아니오 | |
| write_feelings | 감정 기록 활성화 | true 또는 false | false | 아니오 | |
| pin | 작업 고정 | true 또는 false | false | 아니오 | |
| words | 완료 보상 텍스트 | 임의 텍스트 | Great job! | 아니오 | 작업 완료 시 표시되는 동기 부여 문구 |
| task_type | 작업 유형 | [0, 4] | 0 | 아니오 | v1.99.1 필요<br/>0 - 일반 작업<br/>1 - 카운트 작업<br/>2 - 부정 작업<br/>3 - API 작업<br/>4 - 시간 제한 작업(v1.102.0+) |
| target_times | 목표 횟수 | number > 0 | 1 | 아니오 | task_type이 1(카운트 작업)일 때만 유효 |
| is_affect_shop_reward | 상점 보상에 영향 | true/false | false | 아니오 | task_type이 1(카운트 작업)일 때만 유효, 아이템 보상 계산에 영향을 줄지 여부 |
| enable_proportional_settlement | 비례 정산 활성화 | true/false | false | 아니오 | v1.104.0+; task_type이 1(카운트 작업)일 때만 유효. 기존 카운트 작업에서는 이 매개변수만 전달해 비례 정산을 켜거나 끌 수 있음; 이 설정이나 보상 구성을 변경하면 App 규칙에 따라 정산 진행도가 초기화되거나 롤백될 수 있음 |
| expected_focus_minutes | 예상 집중 시간(분) | number > 0 | 25 | 아니오 | task_type이 4(시간 제한 작업)일 때만 유효; 기본값 25(v1.102.0+) |
| repeat_target_times | 반복 종료 횟수 | number > 0 | 3 | 아니오 | 반복 작업에만 유효(frequency가 0 / -1이 아님); repeat_target_times와 repeat_end_date를 모두 제공하면 repeat_target_times가 우선(v1.102.0+) |
| repeat_end_date | 반복 종료 날짜 | 타임스탬프(밀리초) | 1640995200000 | 아니오 | 반복 작업에만 유효(frequency가 0 / -1이 아님)(v1.102.0+) |
| repeat_end_behavior | 반복 종료 동작 | 0 또는 1 | 0 | 아니오 | 0 - 종료 조건 도달 후 작업 종료<br/>1 - 종료 조건 도달 후 작업 동결(v1.102.0+) |
| coin_set_type | 금화 값 설정 방식 | 다음 중 하나:<br/>absolute<br/>relative | absolute | 아니오 | absolute - 금화를 값으로 직접 설정<br/>relative - 원래 금화 값 기준 가감 |
| exp_set_type | 경험치 값 설정 방식 | 다음 중 하나:<br/>absolute<br/>relative | absolute | 아니오 | absolute - 경험치를 값으로 직접 설정<br/>relative - 원래 경험치 값 기준 가감 |

**반환값:**

| 필드 | 유형 | 설명 | 예시 | 참고 |
| --------- | ------- | ---------------- | ------- | ---------------- |
| task_id | Number | 작업 ID | 1000 | |
| task_gid | Number | 작업 그룹 ID | 1000 | |

<br/>

### Task Templates

?> v1.102.0+에서 도입

**메서드 이름:** task_template

**설명:** 작업 템플릿 CRUD.

**예시:**

- 템플릿 목록: `lifeup://api/task_template?method=list`
- 매개변수로 생성: `lifeup://api/task_template?method=create&name=MyTemplate&todo=Write diary&frequency=0`
- 기존 작업에서 생성: `lifeup://api/task_template?method=create&name=MyTemplate&from_task_id=1`
- 템플릿 조회: `lifeup://api/task_template?method=get&id=1`
- 템플릿 이름 업데이트: `lifeup://api/task_template?method=update&id=1&name=NewName`
- 작업에서 템플릿 내용 업데이트: `lifeup://api/task_template?method=update&id=1&from_task_id=1`
- 템플릿 삭제: `lifeup://api/task_template?method=delete&id=1`

| 매개변수 | 의미 | 값 | 예시 | 필수 | 참고 |
| --------- | ------- | ----- | ------- | -------- | ----- |
| method | 작업 | list / get / create / update / delete | list | 예 | - |
| id | Template id | number > 0 | 1 | 아니오* | get/update/delete에 필수; 별칭: template_id |
| template_id | Template id | number > 0 | 1 | 아니오* | id의 별칭 |
| name | 템플릿 이름 | text | MyTemplate | 아니오* | create에 필수; update에서는 from_task_id/from_task_gid 미사용 시 필수 |
| from_task_id | task id로부터 생성 | number > 0 | 1 | 아니오 | create/update용 |
| from_task_gid | task group id로부터 생성 | number > 0 | 1 | 아니오 | create/update용 |
| todo | 작업 내용 | text | Write diary | 아니오* | from_task_id/from_task_gid 미사용 create 시 필수 |
| notes | 메모 | text | Notes | 아니오 | 기본값 빈 문자열 |
| category | 목록 ID | number >= 0 | 0 | 아니오 | 별칭: category_id |
| category_id | 목록 ID | number >= 0 | 0 | 아니오 | category의 별칭 |
| frequency | 반복 주기 | integer | 0 | 아니오 | add_task와 동일 |
| weekdays | 요일 | `1,3,5` | 1,3,5 | 아니오 | v1.106.0+; add_task와 동일; create 시 `none` 거부 |
| importance | 중요도 | [1, 4] | 1 | 아니오 | - |
| difficulty | 난이도 | [1, 4] | 1 | 아니오 | - |
| coin | 금화 보상 | number | 10 | 아니오 | - |
| coin_var | 금화 보상 변동 | number | 1 | 아니오 | - |
| exp | 경험치 보상 | number | 100 | 아니오 | - |
| skills | 스킬 ID | array params | 1 | 아니오 | 배열 지원(예: &skills=1&skills=2) |
| skill_ids | 스킬 ID | JSON 배열 또는 쉼표 목록 | [1,2] | 아니오 | skills 대안 |
| deadline | 마감 시간 | 타임스탬프(밀리초) | 1640995200000 | 아니오 | - |
| start_time | 시작 시간 | 타임스탬프(밀리초) | 1640995200000 | 아니오 | - |
| remind_time | 알림 시간 | 타임스탬프(밀리초) | 1640995200000 | 아니오 | - |
| words | 완료 보상 텍스트 | text | Great job! | 아니오 | - |
| task_type | 작업 유형 | [0, 4] | 0 | 아니오 | 0 - 일반<br/>1 - 카운트<br/>2 - 부정<br/>3 - API<br/>4 - 시간 제한 |
| target_times | 목표 횟수 | number > 0 | 10 | 아니오 | task_type이 1(카운트 작업)일 때만 유효 |
| is_affect_shop_reward | 상점 보상에 영향 | true / false | false | 아니오 | task_type이 1(카운트 작업)일 때만 유효 |
| enable_proportional_settlement | 비례 정산 활성화 | true / false | false | 아니오 | v1.104.0+; task_type이 1(카운트 작업)일 때만 유효. 템플릿에서 만든 작업은 이 카운트 작업 정산 설정을 유지 |
| expected_focus_minutes | 예상 집중 시간(분) | number > 0 | 25 | 아니오 | task_type이 4(시간 제한 작업)일 때만 유효 |
| repeat_end_mode | 반복 종료 모드 | 0 또는 1 | 0 | 아니오 | 반복 작업에만 유효(frequency가 0 / -1이 아님)<br/>0 - 횟수로 종료<br/>1 - 날짜로 종료 |
| repeat_target_times | 반복 종료 횟수 | number > 0 | 3 | 아니오 | repeat_end_mode=0일 때 사용(또는 이 필드 존재로 추론) |
| repeat_end_date | 반복 종료 날짜 | 타임스탬프(밀리초) | 1640995200000 | 아니오 | repeat_end_mode=1일 때 사용(또는 이 필드 존재로 추론) |
| repeat_end_behavior | 반복 종료 동작 | 0 또는 1 | 0 | 아니오 | 0 - 종료<br/>1 - 동결 |

**반환값:**

| 필드 | 의미 | 유형 | 참고 |
| ----- | ------- | ---- | ----- |
| templates | 템플릿 목록(JSON 문자열) | text | method=list일 때만 |
| count | 템플릿 수 | number | method=list일 때만 |
| template | 템플릿 상세(JSON 문자열) | text | method=get일 때만 |
| id | template id | number | get/create/update/delete용 |
| name | 템플릿 이름 | text | get/create/update용 |
| success | 성공 여부 | true / false | create/update/delete용 |

<br/>

### History Task Operation

?> v1.98.0+ 필요

**메서드 이름:** history_operation

**설명:** 완료/포기/만료된 작업을 조작합니다.

**예시:**

- 기록 작업 삭제: [lifeup://api/history_operation?id=1&operation=delete](lifeup://api/history_operation?id=1&operation=delete)
- 작업을 포기로 표시: [lifeup://api/history_operation?id=1&operation=set_to_give_up](lifeup://api/history_operation?id=1&operation=set_to_give_up)
- 작업 재시작: [lifeup://api/history_operation?id=1&operation=restart](lifeup://api/history_operation?id=1&operation=restart)

!> 이 API는 미완료가 아닌 작업(완료, 포기, 만료)에만 적용됩니다.

| 매개변수 | 의미 | 값 | 예시 | 필수 | 참고 |
| ------------- | ----------------- | -------------------- | ---------- | -------- | ------------------------------- |
| id | 작업 ID | 0보다 큰 숫자 | 1 | 예 | 기록 작업 ID |
| operation | 작업 유형 | 다음 중 하나:<br/>delete<br/>complete<br/>undo_complete<br/>set_to_give_up<br/>set_to_overdue<br/>edit_completed_time<br/>restart | delete | 예 | delete - 작업 삭제<br/>complete - 완료로 표시<br/>undo_complete - 완료 취소<br/>set_to_give_up - 포기로 표시<br/>set_to_overdue - 만료로 표시<br/>edit_completed_time - 완료 시간 수정<br/>restart - 작업 재시작 |
| completed_time | 완료 시간 | 타임스탬프(밀리초) | 1640995200000 | 아니오* | operation이 edit_completed_time일 때만 필수 |

**반환값:**

| 필드 | 유형 | 설명 | 예시 | 참고 |
| -------- | ------- | -------------- | ------- | ------------------------ |
| task_id | Number | 작업 ID | 1000 | 조작된 작업 ID |

<br/>

### Shop Settings

**메서드 이름:** shop_settings

**안내:** 다양한 상점 설정을 조정합니다.

**예시:**

- ATM 이자율을 0.01%로 설정: [lifeup://api/shop_settings?key=atm_interest&value=0.01](lifeup://api/shop_settings?key=atm_interest&value=0.01)
- 클릭마다 이자율 0.01% 증가: [lifeup://api/shop_settings?key=atm_interest&value=0.01&set_type=relative](lifeup://api/shop_settings?key=atm_interest&value=0.01&set_type=relative)

| 매개변수 | 의미 | 유형 | 예시 | 필수 | 참고 |
| --------- | -------------------- | ---- | ------- | -------- | ----- |
| key | 유형 | 현재 다음 값만 지원:<br/>atm_interest<br/>credit_interest<br/>line_of_credit<br/>discount_rate_for_returning<br/>atm_balance | atm_interest | 예 | atm_interest - ATM 일일 이율<br/>credit_interest - 대출 일일 이율<br/>line_of_credit - 대출 가능 금액<br/>discount_rate_for_returning - 반품 할인 비율<br/>atm_balance - ATM 잔액 설정 |
| value | 숫자 값 | 소수 또는 정수 | 0.01 | 예 | key마다 값 범위가 다름<br/>예: ATM 잔액은 소수점 미지원 |
| set_type | 값 설정 방식 | 다음 중 하나:<br/>absolute<br/>relative | absolute | 아니오 | absolute - 절대값, 즉 목표를 value로 직접 설정<br/>relative - 상대값, 원래 값 기준 가감 |
| silent | UI 없이 조용히 실행 여부 | Boolean | false | 아니오 | v1.93.0-beta01(502) 이상 지원<br/>기본값 false, UI 알림 표시 |

<br/>

### Jump

**메서드 이름:** goto

**설명:** `LifeUp` 내 페이지로 이동합니다.

**예시:** [lifeup://api/goto?page=lab](lifeup://api/goto?page=lab)

**설명:** 실험실 페이지로 이동합니다.

| 매개변수 | 의미 | 값 | 예시 | 필수 | 참고 |
| --------- | ------- | ----- | ------- | -------- | ----- |
| page | page | 다음 값 중 하나:<br/>main<br/>setting<br/>about<br/>pomodoro<br/>feelings<br/>achievement<br/>history<br/>add_task<br/>add_achievement<br/>add_achievement_cate<br/>exp<br/>coin<br/>backup<br/>add_item<br/>lab<br/>custom_attributes<br/>pomodoro_record<br/>synthesis<br/>pic_manage<br/>purchase_dialog<br/>task_detail<br/>dlc<br/>new_default<br/>use_item_dialog<br/>achievement_list<br/>user_achievement | lab | 예 | `purchase_dialog`는 구매 팝업을 가리킵니다<br/> `use_item_dialog`는 아이템 사용 팝업을 가리킵니다<br/>그 외 항목은 특정 주요 페이지를 가리킵니다 |

#### 1. Jump to the item purchase/use pop-up window

`page` 매개변수가 `purchase_dialog` 또는 `use_item_dialog`일 때 아이템 ID를 지정할 수 있습니다:

예: `lifeup://api/goto?page=purchase_dialog&id=1`

| 매개변수 | 의미 | 값 | 예시 | 필수 | 참고 |
| --------- | ------- | ---------------- | ------- | -------- | ------- |
| id        | Item ID | Positive integer | 1       | 예      | Item ID |

<br/>

#### 2. Jump to the subpage of the home page

`page` 매개변수가 `main`일 때 이동할 하위 페이지를 추가로 지정할 수 있습니다:

예, 상점 페이지로 이동: `lifeup://api/goto?page=main&sub_page=shop`

| 매개변수   | 의미       | 값 | 예시 | 필수 | 참고  |
| ----------- | ------------- | ----- | ------- | -------- | ------ |
| sub_page    | sub page name | One of:<br/>todo<br/>shop<br/>inventory<br/>achievement<br/>status<br/>me<br/>statistic<br/>pomodoro<br/>feelings<br/>world | shop    | 아니오       |      |
| category_id | list id       | number | 0      | 아니오       | `sub_page`가 목록 페이지일 때 이동할 목록 id를 지정할 수 있습니다. <br/>예: 상점 아이템 목록, 인벤토리 목록, 작업 목록. |

<br/>

#### 3. Jump to task details

`page` 매개변수가 `task_detail`일 때 이동할 task id를 추가로 지정할 수 있습니다:

예, task id 53의 상세 페이지로 이동: `lifeup://api/goto?page=task_detail&task_id=53`

| 매개변수 | 의미       | 값         | 예시      | 필수 | 참고 |
| --------- | ------------- | ------------- | ------------ | -------- | ----- |
| task_id   | task id       | task id       | 53           | 아니오*      | task id; 반복 작업이면 반복할 때마다 id가 갱신됨 |
| task_gid  | task group id | task group id | 3            | 아니오*      | task group id |
| task_name | task name     | string        | get up early | 아니오*      | task name, 퍼지 매칭 하나 |

**주의:**

1. 세 매개변수 중 하나만 제공하면 됩니다.
    - 여러 개를 동시에 제공하면 내부 우선순위가 적용됩니다. 다만 이는 정의되지 않은 동작이며, App은 순서를 보장하지 않습니다.

<br/>

#### 4. Jump to new achievement page

`page` 매개변수가 `add_achievement`일 때 category id를 **반드시** 추가로 지정해야 합니다:

예, category id 1로 새 업적 페이지로 이동: `lifeup://api/goto?page=add_achievement&category_id=1`

| 매개변수    | 의미         | 값         | 예시 | 필수 | 참고  |
| ------------ | --------------- | ------------- | ------- | -------- | ------ |
| category_id  | Achievement category id | Achievement category id | 1       | 예      |        |

#### 5. Jump to specific achievement category page

`page` 매개변수가 `user_achievement`일 때 category id를 **반드시** 추가로 지정해야 합니다:

예, id 1 업적 카테고리 페이지로 이동: `lifeup://api/goto?page=user_achievement&category_id=1`

| 매개변수    | 의미         | 값         | 예시 | 필수 | 참고  |
| ------------ | --------------- | ------------- | ------- | -------- | ------ |
| category_id  | Achievement category id | Achievement category id | 1       | 예      |        |

#### 6. Jump to specific synthesis category page

`page` 매개변수가 `synthesis`일 때 category id를 선택적으로 지정할 수 있습니다:

예, id 1 합성 카테고리 페이지로 이동: `lifeup://api/goto?page=synthesis&category_id=1`

| 매개변수    | 의미         | 값         | 예시 | 필수 | 참고  |
| ------------ | --------------- | ------------- | ------- | -------- | ------ |
| category_id  | Synthesis category id | Synthesis category id | 1       | 아니오       |        |

필터와 함께 합성 페이지를 열 수도 있습니다(v1.102.0+):

예, product item id 1로 필터: `lifeup://api/goto?page=synthesis&filter_type=product&filter_item_id=1&filter_item_name=Gem`

| 매개변수        | 의미           | 값 | 예시 | 필수 | 참고 |
| --------------- | ----------------- | ----- | ------- | -------- | ----- |
| filter_type     | Filter type       | product / ingredient / related | product | 아니오* | filter_item_id 필요 |
| filter_item_id  | Filter item id    | number > 0 | 1 | 아니오* | filter_type 필요 |
| filter_item_name| Filter item name  | text | Gem | 아니오 | 선택 사항, 표시용 |

### Shop

#### Adding Items

?> `effects` 같은 일부 필드는 v1.98.0+ 필요

**메서드 이름:** add_item

**설명:** 구매 제한 및 사용 효과 등 사용자 지정 속성을 포함한 상점 아이템을 생성합니다.

**예시:** [lifeup://api/add_item?name=Take a 10-minute break&desc=Go and take a short break!&price=10&action_text=rest&icon=☕](lifeup://api/add_item?name=Take a 10-minute break&desc=Go and take a short break!&price=10&action_text=rest&icon=☕)

| 매개변수        | 의미                | 값               | 예시       | 필수 | 참고                           |
| --------------- | --------------------- | -------------------- | ------------- | -------- | ------------------------------- |
| name            | Item name             | any text             | 10 minute break | 예    |                                 |
| desc            | Description           | any text             | Take a break  | 아니오       |                                 |
| icon            | Icon                  | emoji, http(s) URL, or built-in sample name | ☕ | 아니오 | `emoji_*.webp`, `lifeup_sample_*`, 또는 URL로 저장됨. 이름 이모지는 아이콘을 설정하지 않음 |
| price           | Price                 | [0, 999999]         | 10            | 아니오       | 기본값 0                    |
| stock_number    | Stock quantity        | [-1, 99999]         | -1            | 아니오       | -1은 무제한              |
| action_text     | Action button text    | any text             | rest          | 아니오       |                                 |
| disable_purchase| Disable purchase      | true or false        | false         | 아니오       | 기본값 false                |
| disable_use     | Disable use           | true or false        | false         | 아니오       | 기본값 false                |
| category        | Category ID           | number greater than or equal to 0 | 0 | 아니오    | 0은 기본 카테고리          |
| order           | Display order         | integer              | 1             | 아니오       | 카테고리 내 표시 순서            |
| purchase_limit  | Restriction rules     | JSON text            | [구매 제한 구조](#3-purchase-limit-structure) 참고 | 아니오 | 구매/사용 제한 설정 |
| limit_scope     | Restriction scope     | purchase / use / both | purchase | 아니오 | `purchase_limit`가 비어 있지 않을 때만 유효; 기본값 `purchase` |
| effects         | Use effects           | JSON text            | [아이템 효과 구조](#4-item-effects-structure) 참고 | 아니오 | 아이템 사용 효과 |
| own_number      | Initial owned quantity | integer             | 0             | 아니오       | 초기 인벤토리 수량 설정  |
| unlist          | Hide from shop        | true or false        | false         | 아니오       | 기본값 false                |

**반환값:**

| 필드    | 유형    | 설명    | 예시 | 참고                    |
| -------- | ------- | -------------- | ------- | ------------------------ |
| item_id  | Number  | Item ID        | 1000    | 생성된 아이템 ID   |

!> `effects` 매개변수는 `disable_use`를 덮어씁니다. 사용 불가 아이템을 나타내도록 `effects`를 설정하면 `disable_use`는 무시됩니다.

<br/>

#### Edit Item

?> v1.98.0+ 필요

**메서드 이름:** item

**설명:** 가격, 재고, 효과 등 기존 아이템 속성을 수정합니다.

**예시:**

- 가격 조정: [lifeup://api/item?id=1&set_price=1&set_price_type=relative](lifeup://api/item?id=1&set_price=1&set_price_type=relative)
- 효과 수정: [lifeup://api/item?effects=%5B%7B%22type%22%3A2%2C%22info%22%3A%7B%22min%22%3A100%2C%22max%22%3A200%7D%7D%5D&id=1](lifeup://api/item?effects=%5B%7B%22type%22%3A2%2C%22info%22%3A%7B%22min%22%3A100%2C%22max%22%3A200%7D%7D%5D&id=1)
  - effects 매개변수 디코딩 내용: `[{"type":2,"info":{"min":100,"max":200}}]`

| 매개변수         | 의미             | 값               | 예시   | 필수 | 참고                           |
| ---------------- | ------------------- | -------------------- | --------- | -------- | ------------------------------- |
| id               | Item ID             | number greater than 0| 1         | 아니오*      | id 또는 name 중 하나 필수      |
| name             | Item name           | any text             | Treasure  | 아니오*      | 퍼지 검색용, 이름 변경 아님  |
| set_name         | Set name            | any text             | Treasure  | 아니오       | 비울 수 없음                 |
| set_desc         | Set description     | any text             | Get gift  | 아니오       |                                |
| set_icon         | Set icon            | emoji, http(s) URL, or built-in sample name | ☕ | 아니오 | `icon`과 동일. 지원하지 않는 값은 `unsupported_parameter` 반환 |
| set_price        | Adjust price        | integer              | 1         | 아니오       |                                |
| set_price_type   | Price adjust method | absolute or relative | relative  | 아니오       | absolute-값 직접 설정<br/>relative-가감 |
| own_number       | Adjust owned quantity| integer             | 1         | 아니오       | relative일 때 음수 지원 |
| own_number_type  | Own number adjustment| absolute or relative| relative  | 아니오       | absolute-값 직접 설정<br/>relative-가감 |
| stock_number     | Adjust stock        | [-1, 99999]         | 1         | 아니오       | -1은 무제한 재고        |
| stock_number_type| Stock adjust method | absolute or relative | relative  | 아니오       | absolute-값 직접 설정<br/>relative-가감 |
| disable_purchase | Disable purchase    | true or false        | false     | 아니오       | 기본값 false              |
| disable_use      | Disable use         | true or false        | false     | 아니오       | 기본값 false              |
| action_text      | Use button text     | any text             | Use       | 아니오       |                                |
| title_color_string| Title color        | color string         | #66CCFF   | 아니오       | #는 %23으로 이스케이프 필요<br/>빈 값은 기본값 복원 |
| effects          | Use effects         | JSON text            | [아이템 효과 구조](#4-item-effects-structure) 참고 | 아니오 | 아이템 사용 효과 설정 |
| purchase_limit   | Restriction rules   | JSON text            | [구매 제한 구조](#3-purchase-limit-structure) 참고 | 아니오 | `null` 전달 시 모든 제한 해제 |
| limit_scope      | Restriction scope   | purchase / use / both | purchase | 아니오 | 이 필드를 제공할 때만 갱신; `purchase_limit`가 비면 자동 해제 |
| category_id      | Category ID         | number >= 0          | 1         | 아니오       | 0은 기본 카테고리         |
| order            | Display order       | integer              | 1         | 아니오       | 카테고리 내 표시 순서           |
| unlist           | Remove from shop    | true or false        | false     | 아니오       | 기본값 false              |

!> 수정할 아이템을 찾으려면 id 또는 name 매개변수 중 하나를 제공해야 합니다

<br/>

#### Adjust the Loot Box effect

**메서드 이름:** loot_box

**설명:** 지정한 상자 아이템의 전리품 상자 효과를 수정합니다. 확률, 보상 수량 조정 및 내용 추가를 지원합니다. (현재 삭제는 지원하지 않음)

**예시:** <a href="lifeup://api/loot_box?name=Coin loot box&sub_name=A big bag of coins&set_type=relative&probability=1&fixed=false">lifeup://api/loot_box?name=Coin loot box&sub_name=A big bag of coins&set_type=relative&probability=1&fixed=false</a>

**설명:** 금화 상자에서 [대형] 금화 주머니 비율을 1포인트 증가시킵니다.

| 매개변수   | 의미                               | 유형                                                    | 예시        | 필수 | 참고                                                        |
| ----------- | ------------------------------------- | ------------------------------------------------------- | -------------- | -------- | ------------------------------------------------------------ |
| id          | item id                               | a number greater than 0                                 | 1              | 아니오*      | 획득 방법은 위 "기본 - LifeUp Data ID" 절 참고 |
| name        | item name                             | any text                                                | Treasure chest | 아니오*      | id를 모를 때 퍼지 검색용, 이름 변경 아님 |
| sub_id      | content item id                       | a number greater than 0                                 | 1              | 아니오*      | 상자 내용물 id                                         |
| sub_name    | content item name                     | any text                                                | Get a gift     | 아니오*      | 상자 내용물 id를 모를 때 아이템 퍼지 검색용 |
| set_type    | adjustment method (absolute/relative) | one of the following values: <br/>absolute<br/>relative | relative       | 아니오       | absolute - 절대값, 즉 목표를 value로 직접 설정<br/>relative - 상대값, 원래 값 기준 가감 |
| amount      | number of content item                | number                                                  | 1              | 아니오       | 단일 아이템 보상 수                          |
| probability | probability of the content item       | number                                                  | 1              | 아니오       | -                                                            |
| fixed       | whether it is a fixed reward          | boolean                                                 | true/false     | 아니오       | -                                                            |

**주의:**

1. 상품을 검색하려면 id 또는 name 중 하나를 제공해야 합니다.
1. 내용물을 검색하려면 sub_id 또는 sub_name 중 하나를 제공해야 합니다.
1. `name`과 `sub_name`은 정확 매칭을 먼저 시도한 뒤 퍼지 매칭으로 폴백합니다.
1. 레거시 `loot_box` API는 호환 동작을 유지합니다: 같은 내용 아이템이 서로 다른 수량으로 여러 번 등장하면 첫 번째 매칭 항목만 편집하며 `sub_amount`로 구분하지 않습니다. 수량별 편집, 삭제, 병합이 필요하면 `loot_box/v2`를 사용하세요.

<br/>

#### Adjust the Loot Box effect (v2)

?> v1.104.2에서 도입된 API입니다.

**메서드 이름:** loot_box/v2

**설명:** loot_box API의 개선 버전입니다. 지정한 상자 아이템의 전리품 상자 효과를 수정하며, 확률·보상 수량 조정, 내용 추가 및 **내용 삭제**를 지원합니다.

**v1 대비 개선 사항:**
- **`sub_amount`로 정밀 매칭**: 상자에 같은 아이템이 서로 다른 수량으로 여러 항목 있을 때(예: A x1 50%, A x2 30%) `sub_amount`로 특정 항목을 지정합니다. 기본값 `1`. 매칭 항목이 없으면 LifeUp이 `sub_id` / `sub_name`으로 아이템을 조회해 새 항목을 추가합니다. `amount=0` 삭제 요청이면 새 항목은 추가하지 않습니다.
- **독립 `set_type`**: `amount_set_type`과 `probability_set_type`을 각각 제어할 수 있습니다. 전역 `set_type`은 폴백 기본값입니다.
- **삭제 지원**: `amount_set_type=absolute`로 `amount=0` 설정(또는 `relative`로 계산 결과 `<=0`) 시 매칭 항목을 삭제합니다.
- **중복 병합**: `amount` 변경으로 같은 상자에 동일 아이템·수량 항목이 중복되면 LifeUp이 기존 항목에 병합하고 요청의 `probability` / `fixed` 값을 계속 적용합니다.

**예시:** <a href="lifeup://api/loot_box/v2?name=Coin loot box&sub_name=A big bag of coins&sub_amount=2&probability_set_type=relative&probability=10">lifeup://api/loot_box/v2?name=Coin loot box&sub_name=A big bag of coins&sub_amount=2&probability_set_type=relative&probability=10</a>

**설명:** 금화 상자에서 [대형] 금화 주머니(x2) 확률을 10포인트 증가시킵니다.

| 매개변수              | 의미                               | 유형                                                    | 예시        | 필수 | 참고                                                        |
| ---------------------- | ------------------------------------- | ------------------------------------------------------- | -------------- | -------- | ------------------------------------------------------------ |
| id                     | item id                               | a number greater than 0                                 | 1              | 아니오*      | 획득 방법은 위 "기본 - LifeUp Data ID" 절 참고 |
| name                   | item name                             | any text                                                | Treasure chest | 아니오*      | id를 모를 때 퍼지 검색용, 이름 변경 아님 |
| sub_id                 | content item id                       | a number greater than 0                                 | 1              | 아니오*      | 상자 내용물 id. sub_id와 sub_name을 모두 제공하면 sub_id 우선 |
| sub_name               | content item name                     | any text                                                | Get a gift     | 아니오*      | 상자 내용물 id를 모를 때 아이템 퍼지 검색용 |
| sub_amount             | content item amount for matching      | number                                                  | 2              | 아니오       | 이 수량으로 항목을 정밀 매칭. 최소 `1`, 기본 `1`. 매칭 없고 삭제 요청이 아니면 새 항목 추가 |
| set_type               | global adjustment method              | one of: `absolute` / `relative`                         | relative       | 아니오       | 미지정 시 `amount_set_type`·`probability_set_type` 기본값 |
| amount_set_type        | adjustment method for amount          | one of: `absolute` / `relative`                         | relative       | 아니오       | amount 필드에 대해 `set_type` 덮어씀                    |
| probability_set_type   | adjustment method for probability     | one of: `absolute` / `relative`                         | absolute       | 아니오       | probability 필드에 대해 `set_type` 덮어씀               |
| amount                 | number of content item                | number                                                  | 1              | 아니오       | 단일 아이템 보상 수. `0`(absolute) 또는 계산 `<=0`(relative) 시 항목 삭제 |
| probability            | probability of the content item       | number                                                  | 1              | 아니오       | -                                                            |
| fixed                  | whether it is a fixed reward          | boolean                                                 | true/false     | 아니오       | -                                                            |
| query                  | list box contents                     | true or false                                           | true           | 아니오       | v1.105.1+. 아이템 JSON만 반환; sub_id / sub_name 불필요 |

**주의:**

1. 상품을 검색하려면 id 또는 name 중 하나를 제공해야 합니다.
1. 내용물을 검색하려면 sub_id 또는 sub_name 중 하나를 제공해야 합니다. sub_id / sub_name 없이 목록을 보려면 `query=true`를 사용하세요.
1. `sub_id`와 `sub_name`을 모두 제공하면 `sub_id`가 우선합니다. 유효한 `sub_id`가 없을 때만 `sub_name`을 사용합니다.
1. `name`과 `sub_name`은 정확 매칭을 먼저 시도한 뒤 퍼지 매칭으로 폴백합니다.
1. `sub_amount` 기본값은 `1`입니다. 같은 아이템이 서로 다른 수량으로 여러 항목 있으면 `sub_amount`로 특정 항목을 지정하세요. 매칭 없고 삭제 요청이 아니면 `amount=sub_amount`인 새 항목이 추가됩니다.
1. 항목을 삭제하려면 `amount_set_type=absolute`로 `amount=0`을 설정하거나, `amount_set_type=relative`로 합계가 `<=0`이 되도록 음수 값을 사용하세요. 삭제는 매칭된 항목에만 적용됩니다. 기존 항목이 매칭되지 않으면 `amount=0`으로 새 항목을 추가하지 않습니다.
1. 항목 `amount` 변경으로 같은 상자에 동일 아이템·수량 항목이 중복되면 LifeUp이 기존 항목에 병합하고 요청의 `probability` / `fixed` 값을 계속 적용합니다.
1. 삭제로 상자가 비면 전리품 상자 효과 전체가 소프트 삭제됩니다(아이템 자체는 유지되며 이후 전리품 상자 항목을 다시 추가할 수 있음).

<br/>

#### Use items

?> v1.93.0-beta01(502)에서 도입된 API입니다.

**메서드 이름:** use_item

**설명:** 지정한 아이템을 사용합니다.

**예시:**

- 금화 상자 열기: [lifeup://api/use_item?name=coin_box&use_times=1](lifeup://api/use_item?name=coin_box&use_times=1)

| 매개변수 | 의미     | 유형                    | 예시  | 필수 | 참고                                                        |
| --------- | ----------- | ----------------------- | -------- | -------- | ------------------------------------------------------------ |
| id        | Item ID     | a number greater than 0 | 1        | 아니오*      | Item ID 획득 방법은 "기본 - LifeUp Data ID" 절 참고 |
| name      | Item name   | Any text                | coin_box | 아니오*      | id를 모를 때 사용; 아이템 퍼지 검색      |
| use_times | Usage times | a number greater than 0 | 1        | 아니오       | 기본값 1회<br/>일반 아이템 또는 상자 열기 시 아이템 수량에 해당<br/>단순 합성 아이템은 소모 아이템 수가 아니라 "합성 수량"에 해당 |

**반환:**

!> 이 API는 여러 이유로 실패할 수 있으며, 반환값에 구체적인 실패 사유가 포함될 수 있습니다.

| 매개변수 | 의미            | 유형     | 예시          | 필수 | 참고                                                        |
| --------- | ------------------ | -------- | ---------------- | -------- | ------------------------------------------------------------ |
| result    | Result code        | a number | 0                | 예      | 0 - 사용 성공<br/>1 - 데이터베이스 예외<br/>2 - 경험치 부족 제한<br/>3 - 아이템 없음<br/>4 - 실행 중 카운트다운 충돌<br/>5 - 인벤토리 부족<br/>6 - 사용 불가 아이템<br/>7 - 금화 한도<br/>8 - 대상 재고 한도<br/>9 - 속성 레벨 제한<br/>10 - 시간 제한<br/>11 - 보유 아이템 수량 제한<br/>12 - 작업 완료 제한<br/>13 - 업적 해제 제한<br/>14 - 기간 수량 제한<br/>15 - 작업 주기 완료 제한 |
| desc      | Result description | Text     | RunningCountDown | 예      |                                                              |

<br/>

### ATM

**⚠ v1.91+에서만 사용 가능**

> 여기서 입금·출금 작업은 검증됩니다.
>
> ATM 잔액을 직접 조정하려면 위 "Shop Settings" 인터페이스를 확인하세요.

#### Deposit

**메서드 이름:** deposit

**설명:** 입금 시 합법성(금화 잔액 충분 여부)을 검사합니다.

**예시:**[lifeup://api/deposit?amount=500](lifeup://api/deposit?amount=500)

**설명:** 금화 500을 입금합니다.

| 매개변수 | 의미        | 유형                    | 예시 | 필수 | 참고 |
| --------- | -------------- | ----------------------- | ------- | -------- | ----- |
| amount    | deposit amount | a number greater than 0 | 100     | 예      | -     |

**반환:**

| 매개변수 | 의미                              | 유형              | 예시 | 필수 | 참고 |
| --------- | ------------------------------------ | ----------------- | ------- | -------- | ----- |
| result    | Whether the operation was successful | `true` or `false` | true    | 예      | -     |

<br/>

#### Withdraw

**메서드 이름:** withdraw

**설명:** 출금 시 합법성(ATM 잔액 충분 여부)을 검사합니다.

**예시:** [lifeup://api/withdraw?amount=500](lifeup://api/withdraw?amount=500)

**설명:** 금화 500을 출금합니다.

| 매개변수 | 의미           | 유형                    | 예시 | 필수 | 참고 |
| --------- | ----------------- | ----------------------- | ------- | -------- | ----- |
| amount    | withdrawal amount | a number greater than 0 | 100     | 예      | -     |

**반환:**

| 매개변수 | 의미                              | 유형              | 예시 | 필수 | 참고 |
| --------- | ------------------------------------ | ----------------- | ------- | -------- | ----- |
| result    | Whether the operation was successful | `true` or `false` | true    | 예      | -     |

<br/>

### Pomodoro Timer

**메서드 이름:** pomodoro_timer

**설명:** LifeUp의 실제 Pomodoro 카운트다운 또는 카운트업 타이머를 제어합니다. 이 API는 App UI와 동일한 타이머 세션을 시작하며, Pomodoro 기록이나 토마토를 직접 추가하지는 않습니다.

**예시:**

- 기본 작업 카운트다운 시작 또는 재개:
  [lifeup://api/pomodoro_timer?action=start&mode=countdown](lifeup://api/pomodoro_timer?action=start&mode=countdown)
- 카운트업 타이머를 시작하고 작업 101 선택:
  [lifeup://api/pomodoro_timer?action=start&mode=count_up&task_id=101](lifeup://api/pomodoro_timer?action=start&mode=count_up&task_id=101)
- 활성 카운트다운 일시 정지:
  [lifeup://api/pomodoro_timer?action=pause&mode=countdown](lifeup://api/pomodoro_timer?action=pause&mode=countdown)
- Pomodoro 라이프사이클 포기 및 초기화:
  [lifeup://api/pomodoro_timer?action=abandon&mode=countdown](lifeup://api/pomodoro_timer?action=abandon&mode=countdown)
- 현재 Pomodoro 단계 건너뛰기:
  [lifeup://api/pomodoro_timer?action=skip](lifeup://api/pomodoro_timer?action=skip)
- 토마토 보상 없이 카운트업 타이머 정산:
  [lifeup://api/pomodoro_timer?action=complete&mode=count_up&receive_reward=false](lifeup://api/pomodoro_timer?action=complete&mode=count_up&receive_reward=false)
- 두 타이머 모드 조회:
  [lifeup://api/pomodoro_timer?action=status](lifeup://api/pomodoro_timer?action=status)

**매개변수:**

| 매개변수 | 의미 | 유형 / 값 | 필수 | 참고 |
| --------- | ------- | ------------- | -------- | ----- |
| action | Operation | `start`, `pause`, `abandon`, `skip`, `complete`, `select_task`, `status` | 예 | - |
| mode | Timer mode | `countdown`, `count_up` | `start`, `pause`, `abandon`, `complete`에 필요 | `skip`은 항상 카운트다운 대상 |
| stage | Countdown stage | `work`, `short_break`, `long_break` | 아니오 | `mode=countdown`일 때만 유효. 생략 시 활성·일시 정지·다음 단계 canonical stage 사용; 새 라이프사이클은 `work`로 시작 |
| receive_reward | Whether to receive tomato rewards | `true` or `false` | `complete`에 필요 | 엄격한 boolean. `complete`는 `mode=count_up`만 지원 |
| task_id | Task ID | positive integer | 아니오 | `task_gid` 또는 `task_name`과 함께 사용 불가 |
| task_gid | Task group ID | positive integer | 아니오 | `task_name`과 함께 사용해 매칭 범위 축소 가능 |
| task_name | Task name | text | 아니오 | 정확 매칭 우선, 퍼지 매칭 폴백 |
| clear_task | Clear the timer task | `true` or `false` | 아니오 | `true`는 작업 지정자와 함께 사용 불가 |

`select_task`는 작업 지정자 또는 `clear_task=true` 중 하나가 필요합니다. `start`에도 동일한 작업 선택 매개변수를 포함할 수 있습니다. 사용자 지정 duration 매개변수는 지원하지 않습니다: 카운트다운은 현재 기본 duration 또는 선택한 작업의 Pomodoro duration을 사용합니다.

`abandon&mode=countdown`은 App 왼쪽 동작과 같습니다: 현재 단계를 포기하고 Pomodoro 라이프사이클을 초기화한 뒤 정지된 work 단계로 돌아갑니다. `skip`은 오른쪽 동작과 같습니다: work → 짧은/긴 휴식, 또는 휴식 → work로 진행하며 다음 단계를 자동 시작하지 않습니다. 각 `skip` 호출은 실제 비멱등 동작입니다. 호출자가 자동 재시도하면 안 됩니다.

`complete&mode=count_up`은 실제 카운트업 세션을 정산합니다. 30초 미만 세션은 기록 없이 소모됩니다. `receive_reward=false`이면 임계값을 충족하는 기록도 포기로 저장되지만 토마토는 지급되지 않습니다.

**작업 전환 규칙:**

- 실행 중인 work 카운트다운은 작업 변경을 거부합니다.
- 실행 중인 카운트업 타이머는 작업 변경을 허용하고 알림을 갱신합니다.
- 일시 정지된 카운트다운은 작업 변경을 허용하며, 경과 시간은 유지하고 새 작업 설정으로 총 duration을 재계산합니다.

**성공 반환값:**

| 매개변수 | 의미 | 유형 |
| --------- | ------- | ---- |
| api_result | Whether the API call succeeded | boolean |
| applied | Whether this call changed timer state | boolean |
| mode | Target or currently selected timer mode | `countdown` or `count_up` |
| state | State of `mode` | `running`, `paused`, or `stopped` |
| selected_task_id | Current timer task ID, or `0` | number |
| can_start_in_background | Whether Android currently allows a background timer start | boolean |
| countdown_state | Canonical countdown state | `running`, `paused`, or `stopped` |
| countdown_phase | Countdown lifecycle phase | `idle`, `running`, `paused`, `completing`, `completed`, or `cancelled` |
| countdown_stage | Canonical countdown stage | `work`, `short_break`, or `long_break` |
| countdown_session_id | Canonical countdown session ID | text or null |
| countdown_total_millis | Countdown total duration | milliseconds |
| countdown_remaining_millis | Countdown remaining duration | milliseconds |
| count_up_state | Canonical count-up state | `running`, `paused`, or `stopped` |
| count_up_elapsed_millis | Count-up elapsed duration | milliseconds |
| battery_optimization_ignored | Whether LifeUp is exempt from battery optimization | boolean |

성공한 `complete` 응답에는 추가로 `record_created`, `reward_tomatoes`, `settled_elapsed_millis`가 포함됩니다.

요청 상태와 이미 일치하는 `start`, `pause`, `abandon` 반복 호출은 `applied=false`로 성공합니다. 변경 호출은 프로세스 간 재시도 중복 제거를 제공하지 않습니다.

**오류:**

실패 시 `api_result=false`, `error_code`, `error_message`를 반환합니다. 타이머 전용 안정 error code:

- `invalid_parameter`
- `missing_required_parameter`
- `unsupported_action_for_mode`
- `task_not_found`
- `task_change_not_allowed`
- `timer_mode_locked`
- `timer_state_conflict`
- `background_start_not_allowed`
- `timer_start_failed`
- `timer_settlement_failed`

Android 12 이상에서는 LifeUp이 배터리 최적화 예외일 때만 백그라운드 ContentProvider 호출로 타이머를 시작할 수 있습니다. 그렇지 않으면 타이머 상태를 변경하기 전에 `background_start_not_allowed`를 반환합니다. Activity를 통해 URL Scheme을 열면 시작 전에 LifeUp이 포그라운드로 올라옵니다. Android가 백그라운드에서 서드파티 App의 Activity 실행을 차단하면 LifeUp은 API 호출을 받지 못하고 오류를 반환할 수 없습니다.

<br/>

### Pomodoro Record

#### Add Pomodoro Record

**메서드 이름:** add_pomodoro

**설명:** 토마토 타이밍 기록을 추가합니다.

**예시:**

- 25분(1500000 ms) duration으로, 이름에 learning이 포함된 작업을 지정해 타이밍 기록 추가: [lifeup://api/add_pomodoro?task_name=learning&duration=1500000](lifeup://api/add_pomodoro?task_name=learning&duration=1500000)
- `2022-08-01 11:00:00` - `2022-08-01 12:00:00` 타이밍 기록 추가: [lifeup://api/add_pomodoro?start_time=1659322800000&end_time=1659326400000](lifeup://api/add_pomodoro?start_time=1659322800000&end_time=1659326400000)

**설명:**

| 매개변수        | 의미                    | 유형                    | 예시       | 필수 | 참고 |
| ---------------- | -------------------------- | ----------------------- | ------------- | -------- | ----- |
| start_time       | timing start time          | timestamp               | 1659322800000 | 아니오*      | Timestamp를 모르면 검색해 보세요! |
| duration         | focus duration             | number (in milliseconds) <br/>must be greater than 30000 | 1500000 | 아니오* | |
| end_time         | timing end time            | timestamp               | 1659326400000 | 아니오*      |       |
| reward_tomatoes  | whether to reward tomatoes | true or false           | true          | 아니오       | 기본값 false |
| task_id          | task id                    | a number greater than 0 | 1             | 아니오       |       |
| task_gid         | task group id              | a number greater than 0 | 1             | 아니오       |       |
| task_name        | name                       | any text                | learning      | 아니오       | 퍼지 검색, 찾은 작업 중 하나만 |
| ui               | Display rewarded tomatoes UI | true or false         | true          | 아니오       | v1.94.0 도입, 기본값 true |

**주의:**

1. start_time, duration, end_time 중 하나는 제공해야 합니다.
2. duration만 제공하면 기본 end_time은 현재 시각입니다.
3. end_time은 start_time보다 커야 합니다.
4. duration은 최소 30000밀리초(30초)입니다.
5. start_time, duration, end_time을 모두 제공하면 duration은 (end_time - start_time) 이하여야 합니다.

<br/>

#### Edit Pomodoro Record

> v1.94.0 도입
> **메서드 이름:** edit_pomodoro

**설명:** 기존 Pomodoro 타이밍 기록을 편집합니다. 유효한 `edit_item_id`가 제공되면 해당 기록을 편집하고, 그렇지 않으면 다른 매개변수로 새 기록을 추가합니다.

**예시:**

- 지정 ID 기록을 duration 45분(2700000 ms)으로 편집하고 토마토 보상: [lifeup://api/edit_pomodoro?edit_item_id=123&duration=2700000&reward_tomatoes=true](lifeup://api/edit_pomodoro?edit_item_id=123&duration=2700000&reward_tomatoes=true)
- 시작·종료 시각으로 기록 편집: [lifeup://api/edit_pomodoro?start_time=1659322800000&end_time=1659326400000&edit_item_id=456](lifeup://api/edit_pomodoro?start_time=1659322800000&end_time=1659326400000&edit_item_id=456)

**매개변수:**

| 매개변수       | 의미                    | 유형                  | 예시       | 필수 | 참고                                            |
| --------------- | -------------------------- | --------------------- | ------------- | -------- | ------------------------------------------------ |
| task_id         | Task ID                    | Number greater than 0 | 101           | 아니오       | 작업 고유 식별자                   |
| task_gid        | Task group ID              | Number greater than 0 | 5             | 아니오       | 제공 시 task_id를 덮어씀                |
| task_name       | Task name                  | Any text              | Study         | 아니오       | task_id 또는 task_gid가 없으면 제공 필요   |
| start_time      | Timing start time          | Timestamp             | 1659322800000 | 아니오*      | 타임스탬프가 무엇인지 검색해 이해할 수 있음     |
| end_time        | Timing end time            | Timestamp             | 1659326400000 | 아니오*      | -                                                |
| duration        | Focus duration             | Number (milliseconds) | 2700000       | 아니오*      | 최소 30000밀리초(30초) |
| reward_tomatoes | Whether to reward tomatoes | true or false         | true          | 아니오       | 기본값 false                                 |
| edit_item_id    | ID of the item to edit     | Number greater than 0 | 123           | 예      | 편집할 기록 ID                  |
| ui              | Display reward tomatoes UI | true or false         | true          | 아니오       |                                                  |
| delete          | Delete the record          | true or false         | true          | 아니오       | v1.105.1+. Pomodoro 기록 소프트 삭제(`isDel`), App과 동일 |

**반환값:**

| 매개변수 | 의미                          | 유형   | 예시 | 필수 | 참고                    |
| --------- | -------------------------------- | ------ | ------- | -------- | ------------------------ |
| tomatoes  | Tomatoes gained from this action | Number | 2       | 아니오       | `ui`가 true일 때 반환 |

**참고:**

1. `start_time`, `duration`, `end_time` 중 최소 하나는 제공해야 합니다.
2. `end_time`은 `start_time`보다 커야 합니다.
3. `duration`은 (`end_time` - `start_time`) 이하여야 합니다.
4. `edit_item_id`가 제공되고 해당 기록을 찾으면 편집합니다. 그렇지 않으면 다른 매개변수로 새 기록을 생성합니다.

<br/>

### 업적 해제 조건

**메서드 이름:** unlock_condition

**설명:** 업적 해제 조건: 외부 API 호출로 해제해야 합니다.

**예시:**

- 해제 id 2로 해제 조건 호출: [lifeup://api/unlock_condition?id=2](lifeup://api/unlock_condition?id=2)

| 매개변수 | 의미 | 유형 | 예시 | 필수 | 참고 |
| --------- | ------------ | --------------------- | ------- | -------- |------ |
| id        | condition id | number greater than 0 | 2       | 예      |       |

<br/>

### 업적 완료 / 보상 수령

?> v1.105.1에서 도입된 API입니다.

**메서드 이름:** complete_achievement

**설명:** 수동 업적을 완료하고 보상을 수령하거나, 이미 해제된 자동 업적의 보상을 수령합니다. App에서 완료 체크박스 / 보상 수령 버튼을 누르는 것과 동일합니다.

**예시:**

- id 1 업적 완료 또는 보상 수령: [lifeup://api/complete_achievement?id=1](lifeup://api/complete_achievement?id=1)

| 매개변수 | 의미 | 유형 | 예시 | 필수 | 참고 |
| --------- | -------------- | --------------------- | ------- | -------- | ----- |
| id        | achievement id | number greater than 0 | 1       | 예      |       |

**반환값:**

| 필드 | 유형 | 설명 | 예시 | 참고 |
| ------ | ------ | ----------- | ------- | ----- |
| id     | number | achievement ID | 1 | |
| status | number | 호출 후 상태 | 2 | `0` 잠금 · `1` 해제, 보상 미수령 · `2` 해제, 보상 수령 |

**참고:**

1. 수동 업적(해제 조건 없음): 아직 잠겨 있으면 이 호출로 업적을 완료하고 보상을 지급합니다.
2. 자동 업적(해제 조건 있음): 이미 해제되었고 수령 대기 보상이 있을 때만 보상을 수령합니다. 조건을 충족하지 않으면 `error_code=achievement_not_unlocked`로 실패합니다.
3. 보상을 이미 수령한 뒤 다시 호출하면 `status=2`로 성공하며 보상을 중복 지급하지 않습니다.
4. `achievement?unlocked=true`와 다릅니다. 후자는 해제 상태만 기록하며 보상을 지급하지 않습니다.

<br/>

### 걸음 수 설정

**메서드 이름:** step

**설명:** 지정한 날짜의 걸음 수를 설정합니다. 예: 밴드 + 자동화 도구로 걸음 수를 입력하거나, 과거 기록을 수정할 때 사용합니다.

**예시:**

- GMT+8 기준 2022-10-21의 걸음 수를 9999보로 조정: [lifeup://api/step?count=9999&time=1666282995643](lifeup://api/step?count=9999&time=1666282995643)

| 매개변수 | 의미 | 유형 | 예시 | 필수 | 참고 |
| --------- | ------------------------------- | ----------------------------------- | ------------- | -------- | ----- |
| count     | 걸음 수 | a number greater than or equal to 0 | 9999          | 예      |       |
| time      | 해당 날짜의 임의 타임스탬프 | timestamp (ms) | 1666282995643 | 예      |       |

<br/>

### 경험치 편집

?> v1.93.0-beta01(502)에서 도입된 API입니다.

**메서드 이름:** edit_exp

**설명:** 속성의 현재 경험치를 일괄 설정합니다. 특정 경험치 값 또는 특정 레벨을 직접 설정할 수 있습니다.

**예시:**

> 이 API는 데이터에 영향을 주므로, 실수 방지를 위해 여기서는 클릭 가능한 링크를 제공하지 않습니다.

- [Strength]와 [Knowledge] 속성의 경험치를 0으로 초기화: lifeup://api/edit_exp?skills=1&skills=2&exp=0
- [Charm] 속성의 경험치를 레벨 50으로 직접 조정: lifeup://api/edit_exp?skills=3&level=50

| 매개변수 | 의미 | 유형 | 예시 | 필수 | 참고 |
| --------- | -------------------- | ----------------------------------------- | ------- | -------- | ----- |
| skills    | 속성(스킬) ID | Array of numbers greater than 0 | 1 | 아니오 | 배열 지원(예: &skills=1&skills=2&skills=3)<br/>속성 ID는 "기본 - LifeUp Data ID" 절 참고 |
| exp       | 경험치 설정 | Number greater than or equal to 0 (int32) | 9999 | 아니오, exp 또는 level 중 하나 필수 | |
| level     | 레벨 설정 | Number greater than or equal to 0 (int32) | 50 | 아니오, exp 또는 level 중 하나 필수 | 특정 레벨의 시작 경험치를 나타내며<br/>사용자 정의 레벨 곡선의 영향을 받습니다. |

<br/>

### 감정 추가 또는 편집

?> v1.93.4(536)부터 사용 가능합니다.

**메서드 이름:** feeling

**설명:** 감정 기록을 생성하거나 업데이트합니다.

**예시:**

- 새 감정 기록 생성: [lifeup://api/feeling?content=Happy&time=1633036800](lifeup://api/feeling?content=Happy&time=1633036800)
- 기존 감정 기록 업데이트 및 즐겨찾기 표시: [lifeup://api/feeling?id=1&is_favorite=true](lifeup://api/feeling?id=1&is_favorite=true)
- 감정 삭제: [lifeup://api/feeling?id=1&delete=true](lifeup://api/feeling?id=1&delete=true)

| 매개변수 | 의미 | 유형 | 예시 | 필수 | 참고 |
| -------------------- | ----------------- | ---------------------------------- | ----------------- | -------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| id                   | 감정 기록 ID | Number greater than 0 | 1 | 아니오 | 제공 시 해당 기록을 업데이트합니다. 삭제 시 필수. |
| content              | 내용 | Any text | Happy | 아니오 | 새 기록 생성 또는 기존 기록 내용 업데이트 |
| time                 | 타임스탬프 | Unix timestamp | 1633036800 | 아니오 | 기록 시각, 기본값은 현재 시각 |
| is_favorite          | 즐겨찾기 여부 | true or false | true | 아니오 | 기록을 즐겨찾기로 표시 |
| delete               | 삭제 | true or false | true | 아니오 | v1.105.1+. App과 동일하게 감정을 소프트 삭제(첨부 파일 제거). |
| relate_type          | 연관 유형 | Number between 0 and 3 | 1 | 아니오 | 기록과 연관된 유형:<br/>0: 작업<br/>1: 맞춤 업적<br/>2: 연관 없음<br/>3: 아이템 사용 |
| relate_id            | 연관 ID | Number greater than 0 | 2 | 아니오 | 연관 항목 ID:<br/>relate_type 0: 작업 ID<br/>relate_type 1: 업적 ID<br/>relate_type 3: 아이템 ID<br/>relate_type 2: ID 불필요 |
| usage_count          | 사용 횟수 | Integer greater than 1 | 1 | 아니오 | relate_type 3(아이템 사용)일 때만 유효, 아이템 사용 횟수 기록 |
| image_uris           | 이미지 URI | List of URI strings | | 아니오 | 로컬 file URI(file://) 또는 원격 웹 이미지(http/https) 지원. 배열 지원(예: &image_uris=uri1&image_uris=uri2). |
| image_uris_update_mode | 업데이트 모드 | APPEND or REPLACE | REPLACE | 아니오 | 기존 기록 업데이트 시 image_uris 제공할 때만 유효.<br/>APPEND: 기존 이미지에 추가.<br/>REPLACE: 기존 이미지 교체(기본값). |
    
**참고:**

1. `id` 매개변수가 제공되면 해당 감정 기록을 업데이트합니다. 일치하는 기록이 없으면 예외가 발생합니다.
2. `id`가 없고 `content`만 있으면 새 감정 기록을 생성합니다.

<br/>

### 토마토 수

?> v1.98.0+ 필요

**메서드 이름:** tomato

**설명:** 토마토 수 조정(증가, 감소, 특정 값으로 설정)

**예시:**

- 토마토 1개 추가: [lifeup://api/tomato?action=increase&number=1](lifeup://api/tomato?action=increase&number=1)
- 토마토 2개 제거: [lifeup://api/tomato?action=decrease&number=2](lifeup://api/tomato?action=decrease&number=2)
- 포모도로 수를 10으로 설정: [lifeup://api/tomato?action=set&number=10](lifeup://api/tomato?action=set&number=10)

| 매개변수 | 의미 | 값 | 예시 | 필수 | 참고 |
| --------- | -------------- | --------------------------------------------- | --------- | -------- | ------------------------------------------------------------- |
| action    | 조작 유형 | 다음 중 하나:<br/>increase<br/>decrease<br/>set | increase | 아니오 | increase - 포모도로 추가(기본값)<br/>decrease - 포모도로 제거<br/>set - 지정 값으로 설정 |
| number    | 수량 | Integer | 1 | 예 | action에 따라 의미가 다름:<br/>increase/decrease - 추가/제거 수량<br/>set - 목표 수량 |

**응답:**

| 필드 | 유형 | 설명 | 예시 |
| -------- | ------- | ------------------------ | ------- |
| tomatoes | Integer | 현재 포모도로 수 | 10 |

<br/>

### 아이템 구매

?> v1.98.0+ 필요

**메서드 이름:** purchase_item

**설명:** 특정 아이템 구매

**예시:**

- 아이템 ID 1 구매: [lifeup://api/purchase_item?id=1](lifeup://api/purchase_item?id=1)
- "Health Potion" 이름 아이템 구매: [lifeup://api/purchase_item?name=Health%20Potion](lifeup://api/purchase_item?name=Health%20Potion)
- 아이템 ID 1을 5개 구매: [lifeup://api/purchase_item?id=1&purchase_quantity=5](lifeup://api/purchase_item?id=1&purchase_quantity=5)

아이템에 `purchase_limit`가 설정되어 있고 `limit_scope`에 `purchase`가 포함되면, 이 API도 해당 제한을 적용합니다.

| 매개변수 | 의미 | 값 | 예시 | 필수 | 참고 |
| ----------------- | ---------------- | --------------------- | ------------- | -------- | -------------------------- |
| id                | Item ID | number greater than 0 | 1 | 아니오* | id 또는 name 중 하나 필수 |
| name              | 아이템 이름 | any text | Health Potion | 아니오* | id 또는 name 중 하나 필수 |
| purchase_quantity | 구매 수량 | number greater than 0 | 5 | 아니오 | 기본값 1 |

**응답:**

| 필드 | 유형 | 설명 | 예시 | 참고 |
| ------ | ------- | ------------------ | --------------- | --------------------------- |
| itemId | Number | Item ID | 1 | 구매 성공 시 반환 |
| result | Integer | 결과 코드 | 0 | 아래 결과 코드 참고 |
| desc   | Text | 결과 설명 | PurchaseSuccess | 아래 결과 코드 참고 |

**결과 코드:**

| 코드 | 설명 | 참고 |
| ---- | ------------------------- | ----------------------------- |
| 0    | PurchaseSuccess | 구매 성공 |
| 1    | DatabaseError | 데이터베이스 오류 |
| 2    | NotEnoughCoin | 금화 부족 |
| 3    | ItemNotFound | 아이템 없음 |
| 4    | PurchaseAndUseSuccess | 구매 및 사용 성공 |
| 5    | PurchaseSuccessAndUseFailure | 구매 성공, 사용 실패 |
| 6    | NotPurchaseable | 아이템 설정 또는 제한으로 구매 차단 |
| 7    | OutOfStock | 상점 재고 부족 |

<br/>

### 합성

?> v1.98.0+ 필요

**메서드 이름:** synthesize

**설명:** 기존 레시피로 아이템 합성

**예시:**

- 레시피 ID 1로 1회 합성: [lifeup://api/synthesize?id=1](lifeup://api/synthesize?id=1)
- 레시피 ID 1로 5회 합성: [lifeup://api/synthesize?id=1&times=5](lifeup://api/synthesize?id=1&times=5)

**브로드캐스트 동작:**

- 이 API는 **레시피 합성**용입니다.
- `Broadcast events`가 켜져 있고 합성에 성공하면 LifeUp은 브로드캐스트 이벤트 `app.lifeup.synthesis.complete`도 전송합니다.
- `use_item` 내부의 단순 합성에는 이 이벤트가 **전송되지 않습니다**. 해당 경로는 여전히 `app.lifeup.item.use`에 속합니다.

| 매개변수 | 의미 | 값 | 예시 | 필수 | 참고 |
| --------- | ----------------- | -------------------- | ------- | -------- | ------------------------ |
| id        | Formula ID | number greater than 0 | 1 | 예 | 합성 레시피 ID |
| times     | 횟수 | number greater than 0 | 5 | 아니오 | 기본값 1 |

**응답:**

| 필드 | 유형 | 설명 | 예시 | 참고 |
| -------------- | ------- | --------------- | ---------------- | ------------------------ |
| formulaId      | Number  | Formula ID | 1 | |
| result         | Integer | 결과 코드 | 0 | 아래 결과 코드 참고 |
| desc           | Text    | 결과 설명 | SynthesisSuccess | 아래 결과 코드 참고 |
| synthesisResults| Text   | 합성 결과 | {...} | 성공 시에만 반환 |

**결과 코드:**

| 코드 | 설명 | 참고 |
| ---- | ------------------- | --------------------- |
| 0    | SynthesisSuccess | 합성 성공 |
| 1    | FormulaNotFound | 레시피 없음 |
| 2    | InsufficientMaterials | 재료 부족 |
| 3    | DatabaseError | 데이터베이스 오류 |
| 4    | UnknownError | 기타 오류 |

<br/>

### 합성 레시피 관리

?> v1.98.0+ 필요

**메서드 이름:** synthesis_formula

**설명:** 합성 레시피 생성, 수정, 삭제

**예시:**

- 새 레시피 생성: [lifeup://api/synthesis_formula?inputItems=%5B%7B%22item_id%22%3A%20296%2C%20%22amount%22%3A%2088%7D%5D&outputItems=%5B%7B%22item_id%22%3A%20295%2C%20%22amount%22%3A%201%7D%5D](lifeup://api/synthesis_formula?inputItems=%5B%7B%22item_id%22%3A%20296%2C%20%22amount%22%3A%2088%7D%5D&outputItems=%5B%7B%22item_id%22%3A%20295%2C%20%22amount%22%3A%201%7D%5D)
  - inputItems는 `[{"item_id": 296, "amount": 88}]`
  - outputItems는 `[{"item_id": 295, "amount": 1}]`
- 레시피 삭제: [lifeup://api/synthesis_formula?id=1&delete=true](lifeup://api/synthesis_formula?id=1&delete=true)

| 매개변수 | 의미 | 값 | 예시 | 필수 | 참고 |
| ----------- | -------------- | -------------------- | ------------------------------ | -------- | ------------------------------ |
| id          | Formula ID | number greater than 0 | 1 | 아니오 | 수정 또는 삭제 시 필수 |
| delete      | 삭제 플래그 | true or false | true | 아니오 | 삭제 시에만 사용 |
| inputItems  | 입력 아이템 | Item array, see below | [{"item_id":1,"amount":2}] | 예 | 생성 또는 수정 시 필수 |
| outputItems | 출력 아이템 | Item array, see below | [{"item_id":3,"amount":1}] | 예 | 생성 또는 수정 시 필수 |
| category    | Category ID | number greater than 0 | 1 | 아니오 | 기본값은 공통 카테고리 |

!> inputItems와 outputItems는 각 항목에 item_id와 amount 필드가 있는 JSON 배열입니다. 모든 item ID가 존재해야 하며 amount는 0보다 커야 합니다.

**응답:**

| 필드 | 유형 | 설명 | 예시 | 참고 |
| --------- | ------- | ---------------- | ----------- | ------------------------ |
| formulaId | Number  | Formula ID | 1 | 성공 시 반환 |
| result    | Integer | 결과 코드 | 0 | 아래 결과 코드 참고 |
| desc      | Text    | 결과 설명 | AddSuccess | 아래 결과 코드 참고 |

**결과 코드:**

| 코드 | 설명 | 참고 |
| ---- | -------------- | ----------------- |
| 0    | Success | 작업 성공 |
| 1    | Failed | 작업 실패 |

<br/>

### 하위 작업 관리

?> v1.98.0+ 필요

**메서드 이름:** subtask

**설명:** 하위 작업 생성 또는 편집

**예시:**

- 메인 작업 ID 1에 하위 작업 추가: [lifeup://api/subtask?main_id=1&todo=Complete%20homework](lifeup://api/subtask?main_id=1&todo=Complete%20homework)
- 하위 작업 편집 및 보상 설정: [lifeup://api/subtask?main_id=1&edit_id=2&coin=10&exp=5](lifeup://api/subtask?main_id=1&edit_id=2&coin=10&exp=5)

| 매개변수 | 의미 | 값 | 예시 | 필수 | 참고 |
| ------------ | ------------------ | -------------------- | ---------- | -------- | ------------------------------- |
| main_id      | 메인 작업 ID | number greater than 0 | 1 | 아니오* | main_id, main_gid, main_name 중 하나 필수 |
| main_gid     | 메인 작업 그룹 ID | number greater than 0 | 1 | 아니오* | main_id, main_gid, main_name 중 하나 필수 |
| main_name    | 메인 작업 이름 | any text | Study task | 아니오* | main_id, main_gid, main_name 중 하나 필수 |
| edit_id      | 편집할 하위 작업 ID | number greater than 0 | 2 | 아니오* | 편집 시 edit_id, edit_gid, edit_name 중 하나 필수; 생성 시 불필요 |
| edit_gid     | 하위 작업 그룹 ID | number greater than 0 | 2 | 아니오* | 편집 시 edit_id, edit_gid, edit_name 중 하나 필수; 생성 시 불필요 |
| edit_name    | 하위 작업 이름 | any text | Do homework | 아니오* | 편집 시 edit_id, edit_gid, edit_name 중 하나 필수; 생성 시 불필요 |
| todo         | 작업 내용 | any text | Do homework | 아니오 | 새 하위 작업 생성 시 필수 |
| remind_time  | 알림 시각 | timestamp (milliseconds) | 1640995200000 | 아니오 | null을 전달하면 알림 해제 |
| order        | 순서 | integer | 1 | 아니오 | 작업 목록 내 위치 |
| coin         | 금화 보상 | [0, 999999] | 10 | 아니오 | 완료 시 획득 금화 |
| coin_var     | 금화 변동 | integer | 5 | 아니오 | 금화 보상 랜덤 변동 |
| exp          | 경험치 보상 | [0, 99999] | 5 | 아니오 | 획득 경험치 |
| auto_use_item| 자동 아이템 사용 | true or false | true | 아니오 | 완료 시 아이템 자동 사용 여부 |
| item_id      | Item ID | number greater than 0 | 1 | 아니오* | item_id 또는 item_name 중 하나 필수 |
| item_name    | 아이템 이름 | any text | Health Potion | 아니오* | item_id 또는 item_name 중 하나 필수 |
| item_amount  | 아이템 수량 | number greater than 0 | 1 | 아니오 | 아이템 보상 설정 시에만 유효 |
| items        | Items JSON | JSON text | [{"item_id":1,"amount":1}] | 아니오 | 여러 아이템 보상을 한 번에 설정 |
| coin_set_type     | 금화 값 설정 방식 | 다음 중 하나:<br/>absolute<br/>relative | absolute | 아니오 | absolute - 금화를 값으로 직접 설정<br/>relative - 기존 금화에 가감 |
| exp_set_type      | 경험치 값 설정 방식 | 다음 중 하나:<br/>absolute<br/>relative | absolute | 아니오 | absolute - 경험치를 값으로 직접 설정<br/>relative - 기존 경험치에 가감 |

**응답:**

| 필드 | 유형 | 설명 | 예시 | 참고 |
| ------------ | ------- | ---------------- | ------- | ---------------- |
| main_task_id | Number  | 메인 작업 ID | 1 | |
| subtask_id   | Number  | 하위 작업 ID | 2 | |
| subtask_gid  | Number  | 하위 작업 그룹 ID | 3 | 비어 있을 수 있음 |

<br/>

### 카테고리 관리

?> v1.98.0+ 필요

**메서드 이름:** category

**설명:** 카테고리 추가 또는 편집(작업 목록, 업적 목록, 상점 목록, 합성 목록)

**예시:**

- 작업 목록 생성: [lifeup://api/category?type=tasks&name=Study List](lifeup://api/category?type=tasks&name=Study List)
- 상점 목록 편집: [lifeup://api/category?type=shop&edit_id=1&name=Equipment Shop&order=1](lifeup://api/category?type=shop&edit_id=1&name=Equipment Shop&order=1)

| 매개변수 | 의미 | 값 | 예시 | 필수 | 참고 |
| --------------- | ----------------- | -------------------- | ---------- | -------- | ------------------------------- |
| type            | 카테고리 유형 | 다음 중 하나:<br/>tasks<br/>achievements<br/>shop<br/>synthesis | tasks | 예 | tasks - 작업 목록<br/>achievements - 업적 목록<br/>shop - 상점 목록<br/>synthesis - 합성 목록 |
| edit_id         | 편집할 카테고리 ID | number greater than 0 | 1 | 아니오 | 편집 시 필수 |
| name            | 카테고리 이름 | any text | Study List | 아니오 | 새 카테고리 생성 시 필수; 편집 시 선택 |
| order           | 정렬 순서 | integer | 1 | 아니오 | 목록 내 위치 |
| hidden          | 카테고리 숨기기 | true or false | false | 아니오 | tasks=보관; shop=상점 숨김; synthesis=숨김. 업적 목록과 합성 ALL 목록은 `unsupported_parameter`로 거부. `false`는 숨김 해제 |
| inventory_hidden| 인벤토리에서 숨기기 | true or false | false | 아니오 | 상점 목록에서만 지원 |
| icon_uri        | 아이콘 URI | emoji, http(s) URL, content URI, or empty | 🏆 | 아니오 | 업적 목록에서만 지원. 이모지는 `emoji_*.webp`로 저장. 빈 값은 초기화. |
| desc            | 설명 | any text | This is a description | 아니오 | 업적 목록에서만 지원 |
| color           | 태그 색상 | color string | #66CCFF | 아니오 | 작업 목록에서만 지원; #는 %23으로 이스케이프 |

**응답:**

| 필드 | 유형 | 설명 | 예시 | 참고 |
| ----- | ------- | -------------- | ------- | ------------------------ |
| id    | Number  | Category ID | 1000 | 새로 생성하거나 편집한 카테고리 ID |

<br/>

### 백업 내보내기

?> v1.98.0+ 필요

**메서드 이름:** export_backup

**설명:** 백업 파일을 생성하고 URI를 반환합니다(Content Provider 호출 전용)

!> 이 API는 Content Provider를 통해서만 호출할 수 있으며, URL Scheme 직접 호출은 지원하지 않습니다.

| 매개변수 | 의미 | 값 | 예시 | 필수 | 참고 |
| ------------- | -------------- | --------------- | ------- | -------- | --------------------------------------------- |
| withMedia     | 미디어 파일 포함 | true or false | true | 아니오 | 백업에 미디어 파일(이미지, 효과음 등) 포함 여부<br/>기본값 true |
| callingPackage| 호출자 패키지 이름 | any text | com.example.app | 아니오 | Content Provider 호출용 패키지 식별자 |

**응답:**

| 필드 | 유형 | 설명 | 예시 |
| -------------- | ------ | -------------------- | --------------------------------------------- |
| backup_file_uri | Text   | 백업 파일 URI | content://net.sarasarasa.lifeup.api/backup/file.zip |

<br/>

### 하위 작업 조작

?> v1.98.0+ 필요

**메서드 이름:** subtask_operation

**설명:** 하위 작업 완료, 완료 취소, 삭제

**예시:**

- 하위 작업 완료: [lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=complete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=complete)
- 하위 작업 삭제: [lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=delete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=delete)
- 하위 작업 완료 취소: [lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=undo_complete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=undo_complete)

| 매개변수 | 의미 | 값 | 예시 | 필수 | 참고 |
| ------------ | ---------------- | ------------------- | ---------- | -------- | ------------------------------ |
| main_id      | 메인 작업 ID | number greater than 0 | 1 | 아니오* | main_id, main_gid, main_name 중 하나 필수 |
| main_gid     | 메인 작업 그룹 ID | number greater than 0 | 1 | 아니오* | main_id, main_gid, main_name 중 하나 필수 |
| main_name    | 메인 작업 이름 | any text | Study task | 아니오* | main_id, main_gid, main_name 중 하나 필수 |
| edit_id      | 하위 작업 ID | number greater than 0 | 2 | 아니오* | edit_id, edit_gid, edit_name 중 하나 필수 |
| edit_gid     | 하위 작업 그룹 ID | number greater than 0 | 2 | 아니오* | edit_id, edit_gid, edit_name 중 하나 필수 |
| edit_name    | 하위 작업 이름 | any text | Do homework | 아니오* | edit_id, edit_gid, edit_name 중 하나 필수 |
| operation    | 조작 유형 | 다음 중 하나:<br/>complete<br/>undo_complete<br/>delete | complete | 예 | complete - 작업 완료<br/>undo_complete - 완료 취소<br/>delete - 작업 삭제 |

**응답:**

| 필드 | 유형 | 설명 | 예시 | 참고 |
| ------------ | ------- | ---------------- | ------- | ---------------- |
| main_task_id | Number  | 메인 작업 ID | 1 | |
| subtask_id   | Number  | 하위 작업 ID | 2 | |
| subtask_gid  | Number  | 하위 작업 그룹 ID | 3 | 비어 있을 수 있음 |

<br/>

### 업적 관리

?> v1.98.0+ 필요

**메서드 이름:** achievement

**설명:** 맞춤 업적 및 업적 하위 카테고리 추가 또는 편집

**예시:**

- 업적 생성: [lifeup://api/achievement?name=Collector&desc=Collect 100 items&category_id=1](lifeup://api/achievement?name=Collector&desc=Collect 100 items&category_id=1)
  - 예시 테스트 시 `category_id`를 실제 사용 가능한 업적 목록 id로 바꿔야 할 수 있습니다
- 해제 조건이 있는 업적 생성: [lifeup://api/achievement?name=Millionaire&conditions_json=%5B%7B%22type%22%3A7%2C%22target%22%3A1000000%7D%5D&category_id=1](lifeup://api/achievement?name=Millionaire&conditions_json=%5B%7B%22type%22%3A7%2C%22target%22%3A1000000%7D%5D&category_id=1)
  - 예시 테스트 시 `category_id`를 실제 사용 가능한 업적 목록 id로 바꿔야 할 수 있습니다
  - `conditions_json` 디코드 내용은 `[{"type":7,"target":1000000}]`
- 기존 업적 편집: [lifeup://api/achievement?edit_id=1&name=New Achievement Name&exp=100](lifeup://api/achievement?edit_id=1&name=New Achievement Name&exp=100)

#### 1. 업적 매개변수

| 매개변수 | 의미 | 값 | 예시 | 필수 | 참고 |
| ------------- | ----------------- | -------------------- | --------- | -------- | ------------------------------- |
| edit_id       | 편집할 업적 ID | number greater than 0 | 1 | 아니오 | 편집 시 필수 |
| is_subcategory| 하위 카테고리 여부 | true or false | false | 아니오 | 기본값 false |
| name          | 업적 이름 | any text | Collector | 아니오* | 새 업적 생성 시 필수 |
| desc          | 설명 | any text | Collect 100 items | 아니오 | |
| icon_uri      | 아이콘 | emoji, http(s) URL, content URI, or empty | 🏆 | 아니오 | `icon` 아님. 이모지는 `emoji_` 파일로 저장. 빈 값은 초기화. |
| order         | 정렬 순서 | integer | 1 | 아니오 | 목록 내 위치 |
| category_id   | Category ID | number greater than 0 | 1 | 아니오* | 하위 카테고리 생성 시 필수 |
| unlocked      | 해제 상태 | true or false | true | 아니오 | true - 즉시 해제<br/>false - 잠금으로 초기화 |
| unlock_time   | 해제 시각 | timestamp (milliseconds) | 1640995200000 | 아니오 | 이미 해제된 경우에만 적용 |
| delete        | 삭제 플래그 | true or false | false | 아니오 | |
| secret        | 숨김 업적 | true or false | false | 아니오 | |
| write_feeling | 감정 기록 | true or false | false | 아니오 | |
| color         | 제목 색상 | color string | #66CCFF | 아니오 | #는 %23으로 이스케이프 |
| auto_use_item | 자동 아이템 사용 | true or false | false | 아니오 | |
| skills        | Skill IDs | array of numbers greater than 0 | 1 | 아니오 | 배열 지원(예: &skills=1&skills=2) |
| exp           | 경험치 보상 | integer | 100 | 아니오 | |
| item_id       | Item ID | number greater than 0 | 1 | 아니오* | item_id 또는 item_name 중 하나 필수 |
| item_name     | 아이템 이름 | any text | Treasure | 아니오* | item_id 또는 item_name 중 하나 필수 |
| item_amount   | 아이템 수량 | [1, 99] | 1 | 아니오 | 기본값 1 |
| items         | 아이템 보상 JSON | JSON text | [{"item_id":1,"amount":2}] | 아니오 | 여러 아이템 보상 설정, 아래 형식 참고 |
| conditions_json| 해제 조건 JSON | JSON text | [{"type":7,"target":1000000}] | 아니오 | 해제 조건 설정, 아래 형식 참고 |
| coin         | 금화 보상 | [0, 999999] | 10 | 아니오 | 업적 해제 시 획득 금화 |
| coin_var     | 금화 보상 변동 | integer | 5 | 아니오 | 금화 보상 변동 범위 |
| coin_set_type| 금화 값 설정 방식 | 다음 중 하나:<br/>absolute<br/>relative | absolute | 아니오 | absolute - 금화를 값으로 직접 설정<br/>relative - 기존 금화에 가감 |
| exp_set_type | 경험치 값 설정 방식 | 다음 중 하나:<br/>absolute<br/>relative | absolute | 아니오 | absolute - 경험치를 값으로 직접 설정<br/>relative - 기존 경험치에 가감 |

**응답:**

| 필드 | 유형 | 설명 | 예시 | 참고 |
| ------ | ------- | ---------------- | ------- | ------------------------ |
| id     | Number  | Achievement ID | 1000 | 새로 생성하거나 편집한 업적 ID |

#### 2. 하위 카테고리 매개변수

| 매개변수 | 의미 | 값 | 예시 | 필수 | 참고 |
| ------------ | ----------------- | -------------------- | --------- | -------- | ------------------------------- |
| is_collapsed | 접힘 상태 | true or false | false | 아니오 | 하위 카테고리에만 적용 |

하위 카테고리는 `icon_uri`(이모지 포함)를 `unsupported_parameter`로 거부합니다. `is_subcategory=true` 없이 하위 카테고리를 편집하면 `is_subcategory_required`를 반환합니다.

**응답:**

| 필드 | 유형 | 설명 | 예시 | 참고 |
| ------ | ------- | ---------------- | ------- | ------------------------ |
| id     | Number  | Achievement ID | 1000 | 새로 생성하거나 편집한 업적(하위 카테고리) ID |

#### 3. 해제 조건 유형

| 유형 코드 | 설명 | related_id 필요 | related_id 유형 | target 설명 |
| --------- | ----------------------- | ------------------ | --------------- | ------------------ |
| 0         | 작업 완료 횟수 | 예 | Task ID | 완료 횟수 |
| 1         | 작업 연속 완료 | 예 | Task ID | 연속 횟수 |
| 3         | 포모도로 수 | 아니오 | - | 포모도로 수 |
| 4         | LifeUp 사용 일수 | 아니오 | - | 일수 |
| 5         | 좋아요 수 | 아니오 | - | 좋아요 수 |
| 6         | 일일 완료 연속 | 아니오 | - | 연속 일수 |
| 7         | 현재 금화 | 아니오 | - | 금화 수량 |
| 8         | 하루 획득 금화 | 아니오 | - | 금화 수량 |
| 9         | 작업 포모도로 수 | 예 | Task ID | 포모도로 수 |
| 10        | 아이템 구매 횟수 | 예 | Item ID | 구매 횟수 |
| 11        | 아이템 사용 횟수 | 예 | Item ID | 사용 횟수 |
| 12        | 전리품 상자 아이템 수 | 예 | Item ID | 획득 수 |
| 13        | 스킬 레벨 도달 | 예 | Skill ID | 레벨 값 |
| 14        | Life 레벨 | 아니오 | - | 레벨 값 |
| 15        | 총 아이템 획득 수 | 예 | Item ID | 총 획득 수 |
| 16        | 합성으로 획득한 아이템 | 예 | Item ID | 합성 횟수 |
| 17        | 현재 아이템 보유 수 | 예 | Item ID | 보유 수 |
| 18        | 작업 집중 시간 | 예 | Task ID | 시간(분) |
| 19        | ATM 저축 | 아니오 | - | 저축 금액 |
| 20        | 외부 API | 아니오 | - | API 정의 |
| 520       | 하루 N개 서로 다른 작업 완료 | 아니오 | - | 서로 다른 작업 수(그룹 ID로 중복 제거; 기존 유형) |
| 524       | 하루 N회 작업 완료 | 아니오 | - | 하루 유효 완료 총 횟수(v1.104.4+) |

> v1.104.4부터 유형 `520`과 `524`는 다음 의미를 사용합니다:
>
> - 둘 다 동일한 완료 정의와 로컬 달력 일 경계(`TimeRange.today()`)를 공유합니다.
> - 일반 작업은 `COMPLETED`, 음수 작업은 `GIVE_UP`으로 집계합니다.
> - 유형 `520`은 유효 `groupId`로 중복 제거(그룹 id가 없으면 작업 기록 id로 폴백). 같은 무제한 작업을 하루에 여러 번 완료해도 서로 다른 작업 1개로 집계됩니다.
> - 유형 `524`는 각 유효 완료 행을 집계합니다. 같은 무제한 작업을 5번 완료하면 `completionCount = 5`입니다.
> - `type=520`인 기존 업적은 서로 다른 작업 의미를 유지하며, 마이그레이션은 필요 없습니다.

#### 4. JSON 형식 명세

##### 해제 조건(conditions_json)

```json
[
    {
        "type": 7,           // Condition type (refer to table above)
        "related_id": null,  // Related ID (required for some types)
        "target": 1000000    // Target value
    },
    {
        "type": 10,          // Example: Purchase specific item
        "related_id": 1,     // Item ID
        "target": 5          // Purchase 5 times
    },
    {
        "type": 520,         // Complete N distinct tasks daily
        "related_id": null,
        "target": 5
    },
    {
        "type": 524,         // Complete N task completions daily
        "related_id": null,
        "target": 10
    }
]
```

##### 아이템 보상(items)

```json
[
    {
        "item_id": 1,    // Item ID
        "amount": 2      // Quantity
    },
    {
        "item_id": 2,
        "amount": 3
    }
]
```

<br/>

### 스킬 관리

?> v1.98.0+ 필요

**메서드 이름:** skill

**설명:** 맞춤 스킬(속성) 생성 또는 편집

**예시:**

- 스킬 생성: [lifeup://api/skill?content=Programming&desc=Coding ability&color=%23FF6B6B](lifeup://api/skill?content=Programming&desc=Coding ability&color=%23FF6B6B)
- 스킬 경험치 편집: [lifeup://api/skill?id=1&exp=100](lifeup://api/skill?id=1&exp=100)
- 스킬 삭제: [lifeup://api/skill?id=1&delete=true](lifeup://api/skill?id=1&delete=true)

| 매개변수 | 의미 | 값 | 예시 | 필수 | 참고 |
| ----------- | ----------------- | -------------------- | ---------- | -------- | ------------------------------- |
| id          | Skill ID | number greater than 0 | 1 | 아니오 | 편집 시 필수 |
| content     | 스킬 이름 | any text | Programming | 아니오* | 새 스킬 생성 시 필수 |
| desc        | 설명 | any text | Coding ability | 아니오 | |
| icon        | 아이콘 | any text | 💻 | 아니오 | 이모지 사용 가능 |
| color       | 색상 | color string | #FF6B6B | 아니오 | #는 %23으로 이스케이프 |
| type        | 유형 | integer | 0 | 아니오 | |
| order       | 정렬 순서 | integer | 1 | 아니오 | 원시 혼합 목록 위치. 단독 사용 시 해당 위치에 배치되고 최종 그룹은 레이아웃에서 추론; `group_id`와 함께 사용 시 대상 그룹 내 가장 가까운 합법 위치로 스냅 |
| group_id    | 스킬 그룹 ID | integer | 10 | 아니오 | v1.103.0+ 필요; `0` 미만 불가, `0`만 그룹 없음 영역으로 이동. 단독 사용 시 새 스킬은 대상 그룹 끝에 추가, 편집 스킬은 이미 해당 그룹이면 현재 위치 유지, 아니면 그룹 끝으로 이동; `order`와 함께 사용 시 `group_id` 우선 |
| status      | 상태 | integer | 0 | 아니오 | |
| exp         | 경험치 | number greater than or equal to 0 | 100 | 아니오 | 현재 스킬 경험치 |
| delete      | 삭제 플래그 | true or false | false | 아니오 | 편집 시에만 유효 |

**응답:**

| 필드 | 유형 | 설명 | 예시 | 참고 |
| ------ | ------- | -------------- | ------- | ------------------------ |
| id     | Number  | Skill ID | 1000 | 새로 생성하거나 편집한 스킬 ID |

<br/>

### 스킬 그룹 관리 :id=skill_group_management

v1.103.0+ 필요

**메서드 이름:** skill_group

**설명:** 스킬 그룹 생성, 편집, 삭제, 재정렬. 정렬 API는 그룹과 스킬의 혼합 정렬도 지원합니다.

**예시:**

- 그룹 생성: [lifeup://api/skill_group?content=Combat](lifeup://api/skill_group?content=Combat)
- 그룹 편집: [lifeup://api/skill_group?id=10&content=Combat&order=20&collapsed=true](lifeup://api/skill_group?id=10&content=Combat&order=20&collapsed=true)
- 그룹 삭제: [lifeup://api/skill_group?id=10&delete=true](lifeup://api/skill_group?id=10&delete=true)
- 그룹과 스킬 함께 정렬:

```text
lifeup://api/skill_group?sort_json=[{"type":"skill","id":2},{"type":"group","id":10},{"type":"skill","id":3}]
```

| 매개변수 | 의미 | 값 | 예시 | 필수 | 참고 |
| --------- | ------- | ------ | ------- | -------- | ----- |
| id | 스킬 그룹 ID | number greater than 0 | 10 | 아니오* | 편집 또는 삭제 시 필수 |
| content | 그룹 이름 | any text | Combat | 아니오* | 생성 시 필수 |
| order | 정렬 순서 | integer | 20 | 아니오 | 원시 `orderInCategory` 값; 혼합 스킬/그룹 목록에서 고유해야 함 |
| collapsed | 접힘 상태 | true or false | true | 아니오 | 그룹 접힘 여부 |
| delete | 삭제 플래그 | true or false | false | 아니오 | 편집 시에만 유효 |
| sort_json | 혼합 정렬 노드 | JSON array | `[{"type":"skill","id":2},{"type":"group","id":10}]` | 아니오* | 제공 시 CRUD 매개변수는 무시되고 혼합 정렬 계획이 적용됩니다. 부분 정렬 지원: 지정되지 않은 노드는 상대 순서 유지 |

`sort_json` 노드 형식:

| 필드 | 의미 | 값 |
| ----- | ------- | ------ |
| type | 노드 유형 | `skill` / `group` |
| id | 엔티티 ID | number greater than 0 |

**응답:**

| 필드 | 유형 | 설명 | 예시 | 참고 |
| ----- | ---- | ----------- | ------- | ----- |
| id | Number | Skill group ID | 10 | 생성 / 편집 / 삭제 시 반환 |
| count | Number | 정렬된 노드 수 | 3 | `sort_json` 요청 시 반환 |

<br/>

### App 설정

?> v1.98.0+ 필요

**메서드 이름:** app_settings

**설명:** App 인터페이스 설정 조정

**예시:**

- 컴팩트 모드 활성화: [lifeup://api/app_settings?is_enable_compact_mode=true](lifeup://api/app_settings?is_enable_compact_mode=true)
- Material You 테마 활성화: [lifeup://api/app_settings?is_enable_material_you=true](lifeup://api/app_settings?is_enable_material_you=true)
- 설정 변경 후 UI 즉시 재시작: [lifeup://api/app_settings?is_enable_compact_mode=true&restart_activities=true](lifeup://api/app_settings?is_enable_compact_mode=true&restart_activities=true)

| 매개변수              | 의미           | 값          | 예시 | 필수 | 참고                           |
| --------------------- | ----------------- | --------------- | ------- | -------- | ------------------------------- |
| is_enable_compact_mode| 컴팩트 모드 활성화| true or false  | true    | 아니오       | 인터페이스 요소 단순화     |
| is_enable_material_you| Material You 활성화| true or false  | true    | 아니오       | Material You 테마 활성화       |
| restart_activities    | 인터페이스 재시작 | true or false   | true    | 아니오       | 인터페이스 변경 즉시 적용 |
| broadcast_event | LifeUp Labs 브로드캐스트 이벤트 | true or false | true | 아니오 | 기본값 꺼짐. 설정 → Labs의 동일 스위치 |

**응답:**

| 필드  | 유형    | 설명  | 예시 | 참고                    |
| ------ | ------- | ------------ | ------- | ------------------------ |
| result | Integer | 결과 코드  | 0       | 0은 성공을 나타냄      |

<br/>

### 간단 조회

!> 이 기능은 자동화 도구/2차 개발과 함께 사용합니다. 전체 데이터 목록을 조회하려면 [`LifeUp SDK`, `LifeUp Cloud`](https://github.com/Ayagikei/LifeUp-SDK)와 [`LifeUp Desktop`.](https://github.com/Ayagikei/LifeUp-Desktop)을 참고하세요.

**메서드 이름:** query

**설명:** 매개변수 조회

**예시:** - 현재 금화 수 조회: [lifeup://api/query?key=coin](lifeup://api/query?key=coin)
- 브로드캐스트 이벤트 스위치 조회: [lifeup://api/query?key=broadcast](lifeup://api/query?key=broadcast) → `{enabled}`

| 매개변수   | 의미              | 유형                                                         | 예시 | 필수                                    | 참고                                                        |
| ----------- | -------------------- | ------------------------------------------------------------ | ------- | ------------------------------------------- | ------------------------------------------------------------ |
| key         | 조회 유형        | 다음 값 중 하나만:<br/>coin<br/>atm<br/>item<br/>item_id_list<br/>tomato<br/>task<br/>broadcast | coin    | 예                                         | coin - 현재 금화 수<br/>atm - 현재 ATM 잔액<br/>item - 지정 `itemId`의 아이템 정보<br/>item_id_list - `categoryId`로 지정한 아이템 ID 목록<br/>tomato - 토마토 데이터<br/>task - 작업 정보 (v1.101.0+)<br/>broadcast - Labs 브로드캐스트 이벤트 스위치 (`{enabled}`) |
| item_id     | 아이템 id   | a number greater than 0                                      | 1       | key가 `item`일 때 필수 |                                                              |
| category_id | 상점 카테고리 id | Number greater than or equal to 0                            | 0       | 아니오*                                         | key가 `item_id_list`일 때만 필수, 조회할 목록 ID |
| task_id / taskId | 작업 ID          | Number greater than 0                                        | 1       | key가 `task`일 때 셋 중 하나* 필수 | 조회할 작업 ID |
| task_gid / taskGid / task_group_id / taskGroupId | 작업 그룹 ID | Number greater than 0 | 1 | key가 `task`일 때 셋 중 하나* 필수 | 조회할 작업 그룹 ID |
| task_name / taskName | 작업 이름      | Any text                                                     | Study   | key가 `task`일 때 셋 중 하나* 필수 | 퍼지 매칭 작업 이름 |
| withSubTasks | 하위 작업 포함   | true or false                                                | true    | 아니오                                          | key가 `task`일 때만 사용 가능; 기본값 true |

**반환값:**

1.90.2 버전부터만 지원

금화/atm 조회 시:

| 매개변수 | 의미                             | 유형               | 예시 | 필수 | 참고 |
| --------- | ----------------------------------- | ------------------ | ------- | -------- | ----- |
| value     | 조회로 반환된 숫자 값 | number             | 1000    | 예      |       |

아이템 조회 시:

| 매개변수        | 의미                         | 유형     | 예시   | 필수 | 참고 |
| ---------------- | ------------------------------- | -------- | --------- | -------- | ----- |
| item_id          | 아이템 id              | number   | 1         | 예      |       |
| name             | 아이템 이름            | any text | Coffee    | 예      |       |
| desc             | 설명                     | any text |           | 아니오       |       |
| icon             | 아이콘 URL                        | any text | icon.webp | 아니오       | 로컬 파일이면 파일 이름만 반환 |
| category_id      | 카테고리 data id                | number   | 1         | 예      |       |
| stock_number     | 상점 재고 수량             | number   | -1        | 예      | `-1`은 무한 상점 재고 |
| own_number       | 인벤토리 보유 수 | number   | 10        | 예      |       |
| price            | 가격                       | number   | 100       | 예      |       |
| order            | 정렬 기준                         | number   | 100       | 예      | 사용자 정의 정렬 시 가중치 |
| disable_purchase | 구매 비활성화 여부     | true or false | true | 예 |       |
| purchase_limit   | 제한 규칙               | JSON text | [{"limitType":0,"limitNumber":5}] | 예 | 현재 제한 목록 |
| limit_scope      | 제한 범위               | purchase / use / both | use | 예 | API 텍스트 값으로 반환 |

item_id_list 조회 시:

| 매개변수 | 의미                           | 유형   | 예시 | 필수 | 참고 |
| --------- | --------------------------------- | ------ | ------- | -------- | ----- |
| item_ids  | 쉼표로 구분된 아이템 ID 배열     | string | 1,2,3,4 | 예      |       |

토마토 조회 시:

| 매개변수 | 의미                  | 유형   | 예시 | 필수 | 참고 |
| --------- | ------------------------ | ------ | ------- | -------- | ----- |
| total     | 토마토 총 수       | number | 100     | 예      |       |
| available | 사용 가능 토마토 수   | number | 50      | 예      |       |
| exchanged | 교환된 토마토 수   | number | 50      | 예      |       |

작업 조회 시 (v1.101.0+):

| 매개변수   | 의미                      | 유형        | 예시 | 필수 | 참고                           |
| ----------- | ---------------------------- | ----------- | ------- | -------- | ------------------------------- |
| _ID         | 작업 ID                      | number      | 1       | 예      | -                               |
| _GID        | 작업 그룹 ID                | number      | 1       | 예      | -                               |
| name        | 작업 이름                    | text        | Study   | 예      | -                               |
| notes       | 메모                        | text        | -       | 아니오       | 비어 있을 수 있음                    |
| status      | 작업 상태                  | number      | 0       | 예      | 0=미완료, 1=완료       |
| startTime   | 시작 시각                   | number      | -       | 예      | Unix 타임스탬프 (밀리초)   |
| deadline    | 마감 시각                | number      | -       | 아니오       | Unix 타임스탬프 (밀리초), 비어 있을 수 있음 |
| remindTime  | 알림 시각                  | number      | -       | 아니오       | Unix 타임스탬프 (밀리초), 비어 있을 수 있음 |
| frequency   | 반복 주기         | number      | -       | 예      | -                               |
| weekdays    | 요일                     | text        | 1,3,5   | 아니오       | v1.106.0+; 요일 모드가 아니면 비어 있음. 1=월요일 … 7=일요일 |
| exp         | 경험치 보상                   | number      | -       | 예      | -                               |
| skillIds    | 스킬 ID 목록                | JSON text   | -       | 예      | JSON 배열 형식               |
| coin        | 금화 보상                  | number      | -       | 아니오       | 비어 있을 수 있음                    |
| coinVariable| 랜덤 금화 보상           | number      | -       | 아니오       | 비어 있을 수 있음                    |
| itemId      | 첫 번째 보상 아이템 ID         | number      | -       | 아니오       | 비어 있을 수 있음                    |
| itemCount   | 첫 번째 보상 아이템 수      | number      | -       | 아니오       | itemId가 있을 때 반환     |
| items       | 아이템 보상 목록             | JSON text   | -       | 예      | JSON 배열 형식               |
| words       | 완료 격려 문구   | text        | -       | 아니오       | 비어 있을 수 있음                    |
| categoryId  | 카테고리 ID                  | number      | -       | 아니오       | 비어 있을 수 있음                    |
| order       | 순서                        | number      | -       | 예      | -                               |
| name_extended | 확장 이름              | text        | -       | 예      | name과 동일                    |
| subTasks    | 하위 작업 목록                | JSON text   | -       | 예      | JSON 배열 형식, 아래 참고    |

**하위 작업(subTasks) 필드 설명:**

`subTasks` 필드는 JSON 배열이며, 각 요소는 다음 필드를 포함합니다:

- `id`: 하위 작업 ID
- `gid`: 하위 작업 그룹 ID
- `todo`: 하위 작업 내용
- `status`: 하위 작업 상태 (0=미완료, 1=완료)
- `remindTime`: 알림 시각 (Unix 타임스탬프, 밀리초)
- `exp`: 경험치 보상
- `coin`: 금화 보상
- `coinVariable`: 랜덤 금화 보상
- `items`: 아이템 보상 목록
- `order`: 순서
- `autoUseItem`: 아이템 자동 사용 여부

<br/>

### 속성 조회 :id=query_skill

!> 이 기능은 자동화 도구/2차 개발과 함께 사용합니다.

**메서드 이름:** query_skill

**설명:** 지정 스킬의 기본 정보, 원시 정렬 필드, 레벨/경험치 데이터를 조회합니다.

이 API로 속성 위젯을 맞춤 설정할 수 있습니다.

**예시:**

- 힘 속성 조회: [lifeup://api/query_skill?id=1](lifeup://api/query_skill?id=1)

| 매개변수 | 의미              | 유형                    | 예시 | 필수 | 참고 |
| --------- | -------------------- | ----------------------- | ------- | -------- | ----- |
| id        | 속성(스킬) id | a number greater than 0 | 1       | 예      | 획득 방법은 위 "기본 - LifeUp Data ID" 절 참고 |

**반환값:**

1.90.6 버전부터만 지원

| 매개변수            | 의미                              | 유형   | 예시  | 필수 | 참고 |
| -------------------  | ------------------------------------ | ------ | -------- | -------- | ----- |
| id                   | skill id                             | number | 1        | 예      | v1.103.0+부터 `query_skill`에 추가 |
| name                 | 속성 이름                       | string | strength | 예      |       |
| order                | 원시 정렬 순서                       | number | 20       | 예      | v1.103.0+ 추가; `orderInCategory` |
| group_id             | 스킬 그룹 ID                       | number | 10       | 예      | v1.103.0+ 추가; 그룹에 없으면 `0` 반환 |
| status               | 상태                               | number | 0        | 예      | v1.103.0+ 추가; `0` = 일반, `1` = 숨김 |
| level                | 레벨                                | number | 10       | 예      |       |
| total_exp            | 총 경험치              | number | 10000    | 예      |       |
| until_next_level_exp | 다음 레벨까지 필요 경험치 | number | 99       | 예      |       |
| current_level_exp    | 현재 레벨 이상 획득 경험치       | Number | 1000     | 예      |       |

<br/>

### 스킬 그룹 조회 :id=query_skill_group

v1.103.0+ 필요

**메서드 이름:** query_skill_group

**설명:** 단일 스킬 그룹을 조회하고 원시 정렬 및 접힘 상태를 반환합니다.

**예시:**

- 스킬 그룹 조회: [lifeup://api/query_skill_group?id=10](lifeup://api/query_skill_group?id=10)

| 매개변수 | 의미 | 유형 | 예시 | 필수 | 참고 |
| --------- | ------- | ---- | ------- | -------- | ----- |
| id | 스킬 그룹 ID | number greater than 0 | 10 | 예 | - |

**반환값:**

| 매개변수 | 의미 | 유형 | 예시 | 필수 | 참고 |
| --------- | ------- | ---- | ------- | -------- | ----- |
| id | 스킬 그룹 ID | number | 10 | 예 | - |
| content | 그룹 이름 | string | Combat | 예 | - |
| order | 원시 정렬 순서 | number | 20 | 예 | `orderInCategory` |
| collapsed | 접힘 상태 | string | true | 예 | `true` / `false` 텍스트로 반환 |

<br/>

<br/>

### 특수 인터페이스

#### 랜덤

?> v1.93.0에서 공개되었습니다.

**메서드 이름:** random

**설명:** 여러 API 중 하나를 무작위로 트리거하는 간단한 랜덤 인터페이스입니다.

**예시:**

- `scissors`, `rock`, `paper`를 동일 확률로 무작위 표시: [lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper](lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper)

- `rock` 90%, `scissors` 5%, `paper` 5% 확률: [lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper&weight=90&weight=5&weight=5](lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper&weight=90&weight=5&weight=5)

| 매개변수 | 의미    | 값                 | 예시                                | 필수 | 참고 |
| --------- | ---------- | ---------------------- | -------------------------------------- | -------- | ----- |
| api       | 랜덤 API | Any text               | lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock | 예      | 배열 형태 호출 지원(즉, 위 예시처럼 api 매개변수 여러 개) |
| weight    | 가중치     | Numbers greater than 0 | 1                                      | 아니오       | 배열 형태 호출 지원.<br/><br/>weight를 지정하지 않으면 모든 가중치가 동일(균등 확률).<br/>weight를 지정하면 순서대로 할당: 예를 들어 첫 weight는 첫 api 매개변수에 대응.<br/><br/>**weight 매개변수 수가 api 매개변수 수와 일치하는지 확인하세요. 그렇지 않으면 적용되지 않을 수 있습니다.** |

<br/>

#### 확인 대화상자

**메서드 이름:** confirm_dialog

**설명:** 팝업 선택 창이 표시됩니다. 제목, 텍스트, 긍정/부정 버튼을 맞춤 설정할 수 있으며, 버튼 클릭 시 다른 인터페이스도 호출할 수 있습니다.

**예시:**

- [<a href="lifeup://api/confirm_dialog?title=Do you believe in love&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dbelieve&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Ddo not believe">lifeup://api/confirm_dialog?title=Do you believe in love&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dbelieve&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Ddo not believe</a>](lifeup://api/confirm_dialog?title=Do you believe in love&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dbelieve&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Ddo not believe)
- 기타 사용 시나리오:
  - 보상 선택
  - 이벤트 분기 선택

| 매개변수       | 의미              | 유형     | 예시  | 필수 | 참고 |
| --------------- | -------------------- | -------- | -------- | -------- | ----- |
| title           | 팝업 제목          | any text | Title    | 예      |       |
| message         | 팝업 창 상세 설명 | any text | This is the content of the popup window | 아니오 |  |
| positive_text   | 긍정 버튼 텍스트 | any text | YES      | 아니오       |       |
| negative_text   | 부정 버튼 텍스트 | any text | NO       | 아니오       |       |
| neutral_text    | 중립 버튼 텍스트  | any text | QUESTION | 아니오       |       |
| positive_action | 긍정 버튼 링크 응답 | URL (other interface) | lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D You clicked OK | 아니오 | 실제로는 팝업 메시지 인터페이스의 이스케이프 텍스트입니다. 이스케이프 규칙은 `기본 - 이스케이프 (URL Encode)` 참고. |
| negative_action | 부정 버튼 링크 응답 | URL (other interface) | 위와 동일 | 아니오 |  |
| neutral_action  | 중립 버튼 링크 응답  | URL (other interface) | 위와 동일 | 아니오 |  |
| cancel_action   | 취소 동작 링크 응답   | URL (other interface) | 위와 동일 | 아니오 |  |

<br/>

#### 동작 없음

**메서드 이름:** placeholder

**참고:** 이 인터페이스 자체는 로직을 처리하지 않지만, callback과 broadcast와 함께 사용할 수 있습니다.

**예시:**

- [lifeup://api/placeholder?broadcast=app.lifeup.item.rest](lifeup://api/placeholder?broadcast=app.lifeup.item.rest)

<br/>

#### 변수 플레이스홀더

`LifeUp`은 매개변수에 대한 사용자 개입 처리 방법을 제공합니다.

| 플레이스홀더                          | 의미                                                      | 예시                                                      |
|--------------------------------------|--------------------------------------------------------------|--------------------------------------------------------------|
| [$text\|title]                       | 텍스트 플레이스홀더                                             | [$text\|Enter task name]                                     |
| [$number\|Title]                     | 숫자 플레이스홀더 (소수점 없음)                   | [$number\|Enter price]                                       |
| [$number\|Title\|signed]             | 숫자 플레이스홀더 (소수점 없음), 부호 표시        | [$number\|Enter price\|signed]                               |
| [$decimal\|title]                    | 숫자 플레이스홀더 (소수점 있음)                      | [$decimal\|Enter ATM rate]                                   |
| [$decimal\|title\|signed]            | 숫자 플레이스홀더 (소수점 있음), 부호 표시           | [$decimal\|Enter ATM rate\|signed]                           |
| [$item]                              | 아이템 선택, item id로 대체됨              | [$item]                                                      |
| [$task_category]                     | 작업 목록 선택, 작업 목록 id로 대체됨    | [$task_category]                                             |
| [$time\|Anchor Time\|Offset in Milliseconds(optional)] | 시간 플레이스홀더<br/><br/>Anchor Time 가능 값:<br/>`current`, `today`, `this_monday`, `last_monday`, `this_month`, `last_month`, `this_year`, `last_year` <br/><br/>밀리초 오프셋은 정수, 기본값 0밀리초 | 오늘 자정: [$time\|today]<br/>내일 자정: [$time\|today\|86400000] |
| [$random_number\|Min\|Max]           | 랜덤 숫자 플레이스홀더 (소수점 없음)             | [$random_number\|0\|3000]                                    |
| [$random_decimal\|Min\|Max]          | 랜덤 숫자 플레이스홀더 (소수점 있음)                | [$random_decimal\|1.0\|2.0]                                  |

**예시 1: 사용 시 아이템을 선택해 가격을 1금화 인하**

예를 들어 특정 상점 아이템 가격 인하 API를 설정한 뒤, id를 미리 지정하지 않고 호출 시 사용자가 아이템을 선택하게 하려면:

다음 API는 id 1인 상점 아이템 가격만 1금화 인하할 수 있습니다:

````url
lifeup://api/item?id=1&set_price=-1&set_price_type=relative
````

item id를 플레이스홀더 [$item]로 바꾸면, 호출 시 사용자가 가격을 인하할 아이템을 직접 선택할 수 있습니다:

<a href="lifeup://api/item?id=[$item]&set_price=-1&set_price_type=relative">lifeup://api/item?id=[$item]&set_price=-1&set_price_type=relative</a>

**예시 2: 작업 템플릿, 작업 이름과 선택 목록만 입력하면 사전 설정 보상 템플릿 생성**

<a href="lifeup://api/add_task?todo=[$text|Enter a task name]&notes=This is a reward template for a task&coin=10&coin_var=10&exp=2048&skills=1&skills=2&skills=3&category=[$task_category]]">lifeup://api/add_task?todo=[$text|Enter a task name]&notes=This is a reward template for a task&coin=10&coin_var=10&exp=2048&skills=1&skills=2&skills=3&category=[$task_category]]</a>

<br/>

#### 종료 콜백

모든 인터페이스에 callback 매개변수를 추가해 호출 후 URL을 콜백하는 처리를 구현할 수 있습니다.

여러 인터페이스를 이어 붙이는 데도 사용할 수 있습니다. 예를 들어 이동 후 프롬프트를 표시하려면:

lifeup://api/goto?page=lab + lifeup://api/toast?text=callback

callback 매개변수를 사용할 수 있습니다. 위 **기본 - 이스케이프 (URL Encode)** 도 참고하세요. 다음과 같은 처리를 작성할 수 있습니다:

<a href="lifeup://api/goto?page=lab&callback=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dtest callback">lifeup://api/goto?page=lab&callback=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dtest callback</a>

물론 상점 아이템에 여러 링크를 추가해 같은 효과를 낼 수도 있습니다.

또한 이 callback은 다음에 더 자주 사용됩니다:

X App → LifeUp → X App

또는

X App → LifeUp → Y App

<br/>

#### 브로드캐스트 반환값

!> 이 기능은 자동화 도구/2차 개발과 함께 사용하며, 일정한 진입 장벽이 있습니다.

이 매개변수를 추가하면 API의 원래 반환값을 브로드캐스트로도 전송할 수 있어 Tasker 같은 자동화 도구가 수신할 수 있습니다.

broadcast 값은 Tasker의 "Intent Received" 작업 열 값과 같습니다. 두 값이 일치하기만 하면 임의 텍스트를 입력할 수 있습니다.

**예: Tasker로 금화 조회 API 사용 ([MacroDroid를 사용 중이면 이 링크를 확인하세요.](https://github.com/Ayagikei/LifeUp/issues/43)):**

[lifeup://api/query?key=coin](lifeup://api/query?key=coin)

1. broadcast 매개변수를 추가해 반환값을 Tasker로 브로드캐스트합니다. `app.lifeup.query.coin` 같은 임의 텍스트 가능.

   [lifeup://api/query?key=coin&broadcast=app.lifeup.query.coin](lifeup://api/query?key=coin&broadcast=app.lifeup.query.coin)

2. Tasker에서 이벤트 추가 → "Intent Received", 작업 열에 "app.lifeup.query.coin" 입력

3. Tasker 작업은 `%value` 변수 형태로 `value` 반환값을 수신할 수 있습니다.

4. Tasker에서 금화 수를 판단해 다양한 효과를 구현할 수 있습니다. (예: 금화 수에 따라 데스크톱 배경화면 변경?)

![](_media/api/broadcast_01.png ':size=30%')

![](_media/api/broadcast_02.png ':size=30%')

![](_media/api/broadcast_03.png ':size=30%')

![](_media/api/broadcast_04.png ':size=30%')

<br/>

---

## 브로드캐스트 이벤트 알림

!> 이 기능은 자동화 도구/2차 개발과 함께 사용합니다.

> 1.90.2 버전부터 다양한 이벤트를 외부로 브로드캐스트합니다. Tasker 같은 자동화 도구로 이벤트를 수신해 Tasker 동작을 트리거할 수 있습니다.
>
### 활성화

**기본적으로 브로드캐스트 이벤트는 꺼져 있습니다.**

`설정`-`Labs`-`개발자 모드`-`브로드캐스트 이벤트`에서 활성화할 수 있습니다.

### 예시: 아이템으로 배경화면 변경

1. "Change Wallpaper"라는 새 아이템을 만듭니다.
2. Tasker에서 `Configuration file`→`Event`→`System`→`Intent Received`로 이동, 작업 열에 `app.lifeup.item.use` 입력 후 돌아갑니다.
3. New Task를 클릭하고 임의 이름 입력(예: change wallpaper).
4. 오른쪽 하단 +를 클릭해 작업 추가, `Task`→`If` 선택
5. 조건 열을 `%name eq change wallpaper`로 조정합니다.
6. 돌아가서 `Insert Action`에서 `If` 선택.
7. 오른쪽 하단 +를 다시 클릭해 작업 추가, `Display` → `Set Wallpaper` 선택
8. (선택) `Type`을 `All`로 변경
9. 이미지 열에서 🔍 아이콘을 클릭하고 원하는 배경화면 파일 선택
10. 종료하고 이 구성이 활성화되어 있는지 확인합니다.
11. `LifeUp`에서 "Wallpaper Change" 아이템을 사용하면 배경화면이 성공적으로 변경되는 것을 볼 수 있습니다

![](_media/api/broadcast_sample_01.png ':size=30%')

![](_media/api/broadcast_sample_02.png ':size=30%')

![](_media/api/broadcast_sample_03.png ':size=30%')

![](_media/api/broadcast_sample_04.png ':size=30%')

`동작 없음`+`브로드캐스트 반환값`으로 더 간결하게 같은 효과를 낼 수 있습니다. 직접 탐색해 보세요.

<br/>

### 작업 완료

**이름:** app.lifeup.task.complete

**반환값:**

| 매개변수  | 의미          | 예시        |
| ----------- | ---------------- | --------------- |
| task_id     | task id          | 1               |
| task_gid    | task group id    | 1               |
| name        | task name        | Getting started |
| category_id | task category id | 1               |

### 작업 포기

**이름:** app.lifeup.task.giveup

**반환값:**

| 매개변수  | 의미          | 예시        |
| ----------- | ---------------- | --------------- |
| task_id     | task id          | 1               |
| task_gid    | task group id    | 1               |
| name        | task name        | Getting started |
| category_id | task category id | 1               |

### 작업 기한 초과

**이름:** app.lifeup.task.overdue

**반환값:**

| 매개변수 | 의미                 | 예시                        |
| ---------- | ----------------------- | ------------------------------- |
| task_ids   | task id **array**       | [1, 2, 3]                       |
| task_gids  | task group id **array** | [1, 2, 3]                       |
| names      | task name **array**     | [Getting started, Drink Waters] |
| task_ids_json  | task id **Json array**   | [1, 2, 3]                       |
| task_gids_json | task group id **Json array** | [1, 2, 3]                       |
| names_json     | task name **Json array** | ["Getting started", "Drink Waters"]                      |

### 업적 해제

**이름:** app.lifeup.achievement.unlock

**반환값:**

| 매개변수     | 의미          | 예시                 |
| -------------- | ---------------- | ------------------------ |
| achievement_id | achievement id   | 1                        |
| name           | achievement name | Using LifeUp for 30 days |

### 아이템 구매

**이름:** app.lifeup.item.purchase

**반환값:**

| 매개변수 | 의미           | 예시          |
| ---------- | ----------------- | ----------------- |
| item_id    | item id           | 1                 |
| name       | item name         | Break 10 branches |
| amount     | purchase quantity | 1                 |

### 아이템 사용

**이름:** app.lifeup.item.use

**설명:** 일반 아이템 사용 또는 간단한 합성 사용 흐름이 성공할 때 전송됩니다.

**반환값:**

| 매개변수 | 의미      | 예시          |
| ---------- | ------------ | ----------------- |
| item_id    | item id      | 1                 |
| name       | item name    | Break 10 branches |
| amount     | use quantity | 1                 |

### 합성 완료

> [!NOTE]
> 이 브로드캐스트 이벤트는 v1.102.8에서 공개되었습니다.

**이름:** app.lifeup.synthesis.complete

**설명:** 레시피 합성이 성공적으로 완료될 때 전송됩니다.

**반환값:**

| 매개변수   | 의미                            | 예시                                              |
| ------------ | ---------------------------------- | ----------------------------------------------------- |
| formula_id   | formula id                         | 1                                                     |
| formula_name | formula name                       | Toolbox Recipe                                        |
| times        | execution times                    | 3                                                     |
| input_count  | number of input item entries       | 2                                                     |
| output_count | number of output item entries      | 1                                                     |
| inputs_json  | JSON array of all consumed inputs  | [{"item_id":7,"name":"Wood","amount":6}]              |
| outputs_json | JSON array of all produced outputs | [{"item_id":9,"name":"Toolbox","amount":3}]           |

**참고:**

- 이 이벤트는 합성 성공 후에만 전송됩니다.
- 재료 부족, 레시피 없음, 저장 실패, `Broadcast events` 비활성화 시 전송되지 않습니다.
- `times > 1`이어도 단일 API 호출당 이벤트는 하나만 전송됩니다.
- `inputs_json`과 `outputs_json`의 각 항목은 다음 구조를 사용합니다:

```json
{
  "item_id": 7,
  "name": "Wood",
  "amount": 6
}
```

- `amount`는 레시피당 수량이 아니라 **이번 실행에서 총 소비/총 생산**입니다.

### 감정 추가 / 수정

**이름:** app.lifeup.feelings.add

**반환값:**

| 매개변수 | 의미 | 예시 |
| --- | --- | --- |
| feelings_id | feeling id | 1 |
| action_type | `add` or `update` | add |
| content | feeling text | Feeling good today! |
| create_time | created-at timestamp (ms) | 1642060800000 |
| relate_type | related object type | 0 |
| related_id | related object id | 1 |
| attachments_count | attachment count | 2 |
| attachments | attachment path array | ["/path/1", "/path/2"] |

### 레벨 업

**이름:** app.lifeup.level.up

**반환값:**

| 매개변수 | 의미       | 예시 |
| ---------- | ------------- | -------- |
| skill_id   | task id       | 1        |
| name       | name          | strength |
| level      | current level | 2        |

### 레벨 다운

**이름:** app.lifeup.level.down

**반환값:**

| 매개변수 | 의미       | 예시 |
| ---------- | ------------- | -------- |
| skill_id   | task id       | 1        |
| name       | name          | strength |
| level      | current level | 2        |

### 상점 아이템 카운트다운

**이름:**

- Start: app.lifeup.item.countdown.start
- Stop: app.lifeup.item.countdown.stop
- Complete: app.lifeup.item.countdown.complete

**반환값:**

| 매개변수 | 의미                       | 예시                  |
| ---------- | ----------------------------- | ------------------------- |
| item_id    | item id                       | 1                         |
| name       | item name                     | play games for 30 minutes |
| time_left  | time remaining (milliseconds) | 30000                     |

### 포모도로 수명 주기

?> v1.101.0에서 공개된 브로드캐스트 이벤트로, 더 풍부한 이벤트 데이터를 제공합니다.

**이름:**

- Start: app.lifeup.pomodoro.start
- Pause: app.lifeup.pomodoro.pause (v1.101.0 신규)
- Stop: app.lifeup.pomodoro.stop
- Complete: app.lifeup.pomodoro.complete

**설명:** 포모도로 타이머가 시작, 일시정지, 중지, 완료될 때 작업 정보, 타이밍 상태 등 상세 데이터를 담은 브로드캐스트 이벤트가 전송됩니다.

**반환값:**

| 매개변수          | 의미                       | 예시        | 참고                                                      |
| ------------------ | ----------------------------- | -------------- | ---------------------------------------------------------- |
| task_id            | 작업 ID                       | 1              | 선택, 포모도로가 작업과 연결된 경우에만 존재 |
| task_gid           | 작업 그룹 ID                 | 1              | 선택, 포모도로가 작업과 연결된 경우에만 존재 |
| name               | 작업 이름                     | Study English  | 포모도로에 연결된 작업 이름 또는 사용자 지정 이름         |
| service_type       | 서비스 유형                  | 0              | 0=집중, 1=짧은 휴식, 2=긴 휴식                      |
| service_type_label | 서비스 유형 레이블            | Focus          | 현지화된 서비스 유형 텍스트                                |
| duration           | 총 시간 (밀리초) | 1500000        | 집중 또는 휴식 총 시간                           |
| remaining          | 남은 시간 (밀리초) | 900000     | 현재 남은 시간                                 |
| elapsed            | 경과 시간 (밀리초) | 600000       | 경과한 시간                                           |
| start              | 시작 시각                    | 1639123456789  | Unix 타임스탬프 (밀리초)                              |
| event_time         | 이벤트 트리거 시각            | 1639123456789  | Unix 타임스탬프 (밀리초)                              |
| reason             | 중지 사유                   | user           | stop 이벤트에만 해당, 가능 값: manual, cancel, complete, auto |

**중지 사유 설명:**

`reason` 매개변수는 `app.lifeup.pomodoro.stop` 이벤트에만 존재하며, 포모도로 중지 사유를 나타냅니다:

- `manual`: 사용자가 수동 중지
- `cancel`: 사용자가 취소
- `complete`: 정상 완료 (완료 시 `app.lifeup.pomodoro.complete` 이벤트도 트리거됨)
- `auto`: 자동 중지 (예: 작업 삭제)

### 정방향 타이머 수명 주기 :id=broadcast_positive_timing

> [!NOTE]
> 이 이벤트는 위 포모도로 카운트다운 이벤트가 아니라 정방향 타이머 기능용입니다. 사용 전 `설정` → `Labs` → `개발자 모드` → `브로드캐스트 이벤트`가 활성화되어 있는지 확인하세요.

**이름:**

- Start: app.lifeup.timing.start
- Pause: app.lifeup.timing.pause
- Complete: app.lifeup.timing.complete
- Abandon: app.lifeup.timing.abandon

**설명:** 정방향 타이머가 시작, 일시정지, 완료되거나 수동으로 포기될 때 LifeUp이 해당 브로드캐스트를 전송합니다. `complete`는 세션이 정상 종료되어 기록된 경우입니다. `abandon`은 현재 세션이 수동으로 중지되거나 폐기된 경우입니다.

**반환값:**

| 매개변수 | 의미                        | 예시      | 참고                                            |
| ---------- | ------------------------------ | ------------- | ------------------------------------------------ |
| task_id    | 작업 ID                        | 1             | 선택, 타이머가 작업과 연결된 경우에만 존재 |
| name       | 작업 이름                      | Study English | 연결된 작업 이름 또는 사용자 지정 타이머 이름          |
| time       | 누적 시간 (ms)      | 600000        | 현재 정방향 타이머 총 경과 시간 |
| start      | 시작 시각                     | 1639123456789 | Unix 타임스탬프 (밀리초)                    |
| end        | 종료 시각                       | 1639127056789 | `complete` / `abandon` 이벤트에만 존재    |

---

## 연동

다른 개발자의 모든 형태의 연동을 환영합니다.

> 자세한 내용은 곧 제공됩니다...

### 더 많은 API가 필요하신가요?

API 기능은 현재 한 버전 반복에 불과합니다.

앞으로 더 많은 사용 시나리오를 위해 API를 계속 추가할 예정입니다.

더 많은 API가 필요하면 [Github](https://github.com/Ayagikei/LifeUp/issues/new/choose)에 Issue를 남겨 주세요.

<br/>

### 호출 방법

#### Android

##### SDK 사용

https://github.com/Ayagikei/LifeUp-SDK의 `core` 모듈을 참고하세요.

##### SDK 없이 사용

```kotlin
    /**
    * Define a method to handle the uri
    */
    private fun call(context: Context, uriString: String){
        try {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(uriString)
            }
            context.startActivity(intent)
        }catch (e: Exception) {
            e.printStackTrace()
        }
    }

fun xxx() {
        ...
        // Then call it where appropriate
        call(context, "lifeup://api/toast?text=You+learned+to+call!&type=1&isLong=true")
        ...
    }
````

<br/>

#### 웹 페이지

웹페이지에서 호출할 때 트리거 여부는 브라우저에 따라 다릅니다. Quark, Chrome, Edge 같은 일반 브라우저는 문제없습니다. 하지만 일부 시스템 내장 브라우저는 팝업마다 "Rensheng를 열지" 사용자에게 물을 수 있습니다.

자체 임베디드 WebView App을 개발 중이라면 WebView가 lifeup scheme을 처리할 수 있어야 합니다.

일관된 경험을 위해 `LifeUp`의 상품 링크 효과에서 "내장 브라우저 사용"을 선택해 열 수 있습니다. 보안 설정상 이 방식은 HTTPS 링크만 지원합니다(HTTP 아님)

**HTML**

하이퍼링크로 직접 이동

````htm
<a href="lifeup://api/toast?text=You learned to call!&type=1&isLong=true" target="_blank" rel="noopener">Click here to call</a>
````

**Javascript**

실제로도 하이퍼링크 호출입니다

````javascript
location.href='lifeup://api/reward?type=coin&content=consolation+prize&number=1'
````

<br/>

### App/웹/자동화 개발자

LifeUp 관련 개발을 하셨다면 알려 주세요!

<br/>

### HTTP 프로토콜을 지원하는 모든 프로그래밍 언어/플랫폼

자세한 내용은 https://github.com/Ayagikei/LifeUp-SDK 및 [LifeUp Cloud - HTTP APIs - Google Play](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http)를 참고하세요.
