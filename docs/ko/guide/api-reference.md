# HTTP API 참조 :id=http-query-reference

LifeUp Cloud 요청 매개변수와 전체 HTTP 응답 모델을 설명합니다. 설치·권한·연결은 [LifeUp Cloud](/guide/api_cloud)에서 시작하세요. 최신 원장 엔드포인트는 LifeUp **1.106.0+** 및 LifeUp Cloud **3.0.0+**가 필요하며 `/info`로 설치된 버전을 확인합니다. 현재 소스 계약을 설명하며 특정 릴리스의 배포 여부를 입증하지는 않습니다.

## 인터페이스 색인 :id=interface-index

| 리소스 | 메서드 및 경로 | 매개변수 및 모델 |
| --- | --- | --- |
| 공통 규칙 | JSON 응답, 권한, 캐시 조건, 페이지 나누기 | [규칙](#representations), [캐시와 인증](#auth-cache), [페이지 나누기](#pagination) |
| 할 일 | `GET /tasks`, `GET /tasks/{categoryId}`, `GET /tasks_categories` | [조회](#get-tasks), [할 일 모델](#task-fields), [카테고리](#get-tasks-categories) |
| 할 일 기록 | `GET /history` | [매개변수](#get-history), [시각](#task-times), [일일 보고서](#daily-report) |
| 상품 | `GET /items`, `GET /items/{listId}`, `GET /items_categories` | [상품·카테고리 ID 및 전체 모델](#get-items) |
| 능력 | `GET /skills`, `GET /skill_groups` | [능력 및 그룹](#get-skills) |
| 업적 | `GET /achievements`, `GET /achievements/{id}`, `GET /achievement_categories`, `GET /achievement_conditions/{id}` | [업적 및 조건](#get-achievements) |
| 합성 | `GET /synthesis`, `GET /synthesis/{id}`, `GET /synthesis_categories`, `GET /synthesis_categories/{id}` | [레시피 및 카테고리](#get-synthesis) |
| 감상 | `GET /feelings` | [감상 페이지 조회](#get-feelings) |
| EXP / 코인 | `GET /exp_records`, `GET /coin_records` | [원장 매개변수 및 모델](#reward-journals) |
| 기타 기록 | `GET /pomodoro_records`, `GET /inventory_records`, `GET /step_records` | [포모도로](#get-pomodoro-records), [인벤토리](#get-inventory-records), [걸음](#get-step-records) |
| 레벨 / 통계 | `GET /level_defines`, `GET /statistics` | [레벨](#get-level-defines), [통계](#get-statistics) |
| 앱 / 잔액 | `GET /info`, `GET /coin` | [버전 정보](#get-info), [코인 결과](#get-coin) |
| 동작 호출 | `GET` / `POST /api`, `GET` / `POST /api/contentprovider` | [호출 브리지](#invoke-api). 업무 메서드는 [URL Scheme 목록](/guide/api) 참조 |
| 파일 / 백업 | `GET /files/{url}`, `POST /files/upload`, `GET /data/export`, `POST /data/import` | [파일](#files-download), [백업 전송](#files-backup) |
| 이벤트 | `GET /events`, WebSocket `/events` | [폴링 및 실시간 이벤트](#get-events) |
| 시작 페이지 | `GET /` | JSON 리소스가 아닌 HTML 소개 페이지. |

MCP는 별도의 클라이언트·도구 표현을 사용합니다. [MCP 차이](#mcp-differences)와 [MCP 가이드](/guide/api_mcp)를 참고하세요.

## 전송 및 표현 형식 :id=representations

| 인터페이스 | 표현 형식 | 주요 차이 |
| --- | --- | --- |
| Cloud HTTP 쿼리 | `{code, message, data}`로 감싼 JSON | 아래 엔드포인트 참조는 이 공개 JSON을 설명합니다. |
| Android ContentProvider | `_ID` / `_GID` 같은 Cursor 열. 일부는 JSON 텍스트 포함 | SDK 파서는 이를 `id` / `gid` 같은 HTTP 필드와 중첩 배열로 변환합니다. Cursor 열 정의를 HTTP 스키마로 사용하지 마세요. |
| URL Scheme 액션 | `lifeup://api/{method}` 및 메서드별 매개변수/결과 | HTTP 읽기 필드는 camelCase여도 쓰기 매개변수는 snake_case일 수 있습니다. |
| MCP 목록 도구 | 도구별 봉투와 간결하거나 상세한 레코드 | MCP 페이지네이션과 출력 필드는 클라이언트 동작이며 HTTP 응답 필드가 아닙니다. |

## 응답 및 오류 :id=response-errors

공통 HTTP JSON 래퍼는 `HttpResponse<T>`입니다.

| 필드 | 유형 | 의미 |
| --- | --- | --- |
| `code` | integer | 쿼리 성공 시 `200`, 그 외에는 오류를 나타냅니다. HTTP 상태와 별개의 본문 필드입니다. |
| `message` | string | 성공 시 보통 `success`, 그 외에는 오류 설명입니다. |
| `data` | `T` 또는 `null` | 성공 시 엔드포인트별 값(배열·객체·문자열), 오류 시 `null`입니다. |

성공한 빈 목록 예:

```json
{"code":200,"message":"success","data":[]}
```

권한/제공자 접근 오류 예:

```json
{"code":10001,"message":"Cursor is null, check if LifeUp is installed and running and you have granted the permission","data":null}
```

| 신호 | 처리 방법 |
| --- | --- |
| HTTP `401` | 설정한 Cloud 토큰을 `Authorization` 헤더 값에 그대로 넣습니다. `Bearer`를 붙이지 마세요. |
| 본문 `code = 10001` | LifeUp 설치 및 실행 여부와 Cloud의 Read LifeUp Data 권한을 확인합니다. |
| 본문 `code = 10002` | ContentProvider 쿼리 실패입니다. 오류 메시지를 확인합니다. |
| 기타 실패 상태/코드 | 빈 결과가 아니라 쿼리 실패로 처리합니다. |

HTTP 상태와 본문 `code`를 **모두** 확인하세요. 일부 경로 오류는 HTTP `200`과 본문 오류 코드를 함께 반환합니다. `/api/contentprovider`를 통한 액션은 각 `data[].result.api_result`도 확인해야 합니다. 래퍼의 `code=200`만으로 모든 액션이 성공한 것은 아닙니다.

## 인증 및 조건부 읽기 :id=auth-cache

Cloud 토큰을 설정했다면 `Authorization`에 정확한 원시 값을 보내고 `Bearer`를 붙이지 마세요. 서버는 WebSocket 헤더를 지정할 수 없는 클라이언트 등을 위해 `token` 쿼리도 받습니다. 토큰이 없거나 틀리면 HTTP `401`과 본문 `code=401`입니다. 시작 페이지, 리소스, 브리지, 파일, 백업 전송, 이벤트 모두에 적용됩니다.

성공한 JSON 리소스 읽기는 강한 SHA-256 `ETag`와 `Cache-Control: private, no-cache`를 첨부합니다. 할 일·기록, 상품·카테고리, 능력·그룹, 업적·조건, 감상, 합성·카테고리, 원장, 레벨, 통계, 정보, 코인에 적용합니다. 호출 브리지, 파일·백업 전송, 이벤트 스트림·폴링에는 적용하지 않습니다.

| 요청 헤더 | 현재 응답 동작 |
| --- | --- |
| `If-Match` | 버전 불일치는 HTTP `412`이며 `If-None-Match`보다 먼저 평가합니다. |
| `If-None-Match` | 일치하면 HTTP `304`로 JSON 본문이 없습니다. 캐시된 성공 표현을 재사용하세요. |

오류 래퍼에는 리소스 버전 헤더가 없습니다. 조건부 읽기는 개별 리소스 요청에만 적용되며 페이지나 경로에 걸친 스냅샷·트랜잭션이 아닙니다.

브라우저 교차 출처 요청은 `If-None-Match`를 사용할 수 있습니다. 현재 CORS는 사전 요청에서 `If-Match`를 허용하지 않으므로 구현 변경 전에는 교차 출처 브라우저 `If-Match`에 의존하지 마세요. 네이티브 클라이언트는 브라우저 CORS의 적용 대상이 아닙니다.

## 공통 데이터 규칙 :id=data-conventions

| 규칙 | 내용 |
| --- | --- |
| 시간 | 타임스탬프는 Unix 밀리초입니다. 날짜 경계는 기준 시간대에 따라 달라집니다. 각 필드의 의미는 리소스별 정의를 따릅니다. |
| 식별자 | 작업 `id`는 개별 작업/주기를 식별하고 `gid`는 반복 주기 간 그룹을 식별합니다. 카테고리/목록 ID는 별도 리소스를 식별합니다. |
| 빈 값 | 누락, `null`, `0`, `""`, `[]`는 서로 다릅니다. 실제 대체값이나 생략 동작은 각 모델에 정의되어 있습니다. |
| 숫자 ID | ID는 부호 있는 64비트 정수일 수 있으며 JavaScript Number로 모든 값을 정확히 표현할 수 없습니다. 적절한 JSON 파서로 큰 ID를 보존하세요. |
| 배열 및 객체 | HTTP의 `items`, `subTasks` 같은 중첩 값은 배열이며 JSON 인코딩 문자열이 아닙니다. |
| 상태 및 사유 코드 | 해당 리소스에 문서화된 열거값을 사용하세요. 작업 상태, 업적 상태, 기록 사유 코드는 서로 다른 영역입니다. |

`startTime`, `deadline`, `endTime` 정의는 [작업 타임스탬프](/guide/api-reference?id=task-times)를 참조하세요.

## 페이지네이션 및 필터링 :id=pagination

페이지네이션은 엔드포인트별 기능이며 모든 목록에 적용되는 속성이 아닙니다. 원시 HTTP 목록 응답은 `data: [...]`를 반환하며 `total`, `count`, `hasMore`를 추가하지 않습니다.

| HTTP 엔드포인트 | 페이지네이션 | 날짜 범위 | 기타 필터 |
| --- | --- | --- | --- |
| `/tasks`, `/tasks/{categoryId}` | 없음; 전체 배열 | 없음 | 경로에서 선택 가능한 카테고리 |
| `/history` | 서버 측 `offset` / `limit` | 없음 | 선택적 `gid` |
| `/feelings` | 서버 측 `offset` / `limit` | 없음 | [감상](#get-feelings) 참조 |
| `/pomodoro_records`, `/coin_records`, `/inventory_records`, `/exp_records`, `/step_records` | 서버 측 `offset` / `limit` | `time_range_start` / `time_range_end` | 엔드포인트별 안내 참조 |
| `/statistics` | 없음; 단일 객체 | `time_range_start` / `time_range_end` | 집계 쿼리 |
| `/coin`, `/info` | 없음; 단일 객체 | 없음 | 단일 항목 쿼리 |

페이지 처리 엔드포인트의 HTTP 기본값은 `offset=0`, `limit=100`입니다. 공통 페이지 루프에는 0 이상의 offset과 `1..100` 페이지 크기를 사용하세요. HTTP 브리지는 MCP의 `1..100` 제한을 적용하지 않으며 하위 제공자가 다른 제한을 적용할 수 있습니다. 엔드포인트별 유효 페이지 크기와 검증 규칙을 확인하세요.

[시간 필터 포모도로 제한](#get-pomodoro-records)을 제외하고 각 페이지 성공 후 반환된 기록 수만큼 `offset`을 늘립니다. 해당 수가 실제 페이지 크기보다 작으면 중단합니다(`1..100` 사용 시 요청한 `limit`, 시간 필터 포모도로 제외). 프로바이더 제한으로 줄어든 페이지를 마지막 페이지로 오인하지 마세요. 끝 이후 빈 페이지는 정상입니다. 여러 페이지는 스냅샷이 아니며 조회 중 기록이 바뀔 수 있습니다.

현재 HTTP SDK는 두 날짜 경계가 모두 정수로 해석되고 `start < end`일 때만 범위를 전달합니다. 하나만 있거나 해석할 수 없거나 순서가 뒤바뀌면 필터 없이 조회합니다. 오류 응답을 기대하지 말고 전송 전에 두 경계를 검증하세요. 기록 참조에는 엔드포인트의 양 끝 경계 포함 여부가 명시되어 있습니다.

## MCP와의 차이 :id=mcp-differences

MCP 목록 도구는 기본 `limit=20`을 사용하고 `1..100`으로 제한하며 `offset`을 최소 0으로 조정합니다. 기록처럼 서버에서 페이지 처리하는 리소스에는 페이지 매개변수를 전달하지만, 작업처럼 전체 HTTP 배열을 반환하는 리소스는 가져온 뒤 로컬에서 분할합니다. `items`, `count`, `hasMore` 및 선택적 `total`은 MCP 봉투에 속합니다. `detail=false`는 각 레코드의 필드도 제거합니다. 전체 HTTP 모델이 필요하면 `detail=true`를 사용하세요.

## 출처 및 버전 범위 :id=api-common-sources

이 참조는 현재 공개 SDK와 이에 대응하는 LifeUp 제공자 동작을 설명합니다. 예제는 가상의 데이터입니다. 소스 링크는 구현 참고 자료이며 특정 설치 버전에 모든 필드가 포함된다는 증거는 아닙니다. [HTTP 경로](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt), [HTTP 래퍼](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/vo/HttpResponse.kt), [MCP 쿼리 매핑](https://github.com/Ayagikei/LifeUp-SDK/blob/main/mcp/src/query.ts).

## 작업 및 기록 데이터 모델 :id=task-history-models

이 페이지는 [작업/기록 쿼리](/guide/api-reference?id=task-queries)가 반환하는 **HTTP JSON**을 정의합니다. Android Cursor 열과 URL Scheme 액션 매개변수는 이름과 표현 방식이 다를 수 있습니다. [공통 규칙](/guide/api-reference?id=representations)을 참조하세요.

SDK는 하나의 직렬화 `Task` 클래스를 두 가지 뷰에 사용합니다. 여기서 `/tasks` 뷰를 `Task`, `/history` 뷰를 `HistoryRecord`라고 부릅니다. 이는 기존 출력을 설명하는 이름이며 새로운 API가 아닙니다. 현재 Cloud 직렬화에는 기본값과 `null` 필드가 포함됩니다.

### Task / HistoryRecord 필드 :id=task-fields

아래 필드는 모두 현재 HTTP 객체에 포함됩니다. 제공자 값이 없으면 많은 경우 아래 대체값으로 변환됩니다. 대체값이 있다고 해서 원본 데이터에 그 값이 있었다는 뜻은 아닙니다.

| 필드 | JSON 유형 | 의미 / 대체값 |
| --- | --- | --- |
| `id` | integer 또는 `null` | 이 작업/주기의 ID. |
| `gid` | integer 또는 `null` | 반복 주기 간 공유되는 작업 그룹 ID. |
| `name` | string | 작업 이름. 제공자 이름이 누락되면 `ERROR: name is null`이 됩니다. |
| `notes` | string | 메모. 없으면 빈 문자열. |
| `status` | integer | 작업 상태. 누락 시 기본값 `0`. 아래 상태 표 참조. |
| `startTime` | integer | 설정된 시작 시각(밀리초). SDK 대체값 `0`. |
| `deadline` | integer | 기한(밀리초). 없을 때 SDK 대체값 `0`. |
| `remindTime` | integer | 알림 시각(밀리초). 없을 때 SDK 대체값 `0`. |
| `frequency` | integer | 반복 코드. `0` 한 번, `1` 매일, `-1` 무제한. 다른 반복 방식은 [작업 액션](/guide/api)을 참조하세요. SDK 대체값 `0`. |
| `weekdays` | string | 요일 선택. 예: `1,3,5` (월요일 `1`, 일요일 `7`). 미지정 시 빈 값이며 기록에서는 고정 빈 플레이스홀더입니다. |
| `exp` | integer | 설정된 EXP 보상이며 거래 금액이 아닙니다. 기본값 `0`. |
| `skillIds` | integer array | 보상에 연결된 속성. 사용할 수 없으면 빈 배열. |
| `coin` | integer | 설정된 코인 보상. 기본값 `0`. |
| `coinVariable` | integer | 랜덤 코인 보상 설정. 기본값 `0`. |
| `itemId` | integer | 레거시 첫 보상 아이템 ID. 기본값 `0`. 전체 목록은 `items`를 사용하세요. |
| `itemAmount` | integer | 레거시 첫 보상 아이템 수량. 기본값 `0`. HTTP 이름은 제공자의 `itemCount` 열과 다릅니다. |
| `words` | string | 완료 인센티브 문구. 없으면 빈 값. |
| `categoryId` | integer | 작업 카테고리/목록 ID. 없으면 `0`. |
| `order` | integer | 작업 목록의 정렬값. 제공자가 열을 반환하지 않으므로 기록에서는 고정 `0` 플레이스홀더입니다. |
| `nameExtended` | string | 확장 표시 이름. 제공자가 열을 반환하지 않으므로 기록에서는 고정 빈 플레이스홀더입니다. |
| `endTime` | integer | 기록의 저장된 종료 시각. `/tasks`에서는 `0`이며 [시간 의미](/guide/api-reference?id=task-times)를 참조하세요. |
| `items` | `RewardItem[]` | 아이템 보상. 사용할 수 없으면 빈 배열. |
| `subTasks` | `SubTask[]` | 중첩된 하위 작업. 사용할 수 없으면 빈 배열. |
| `countProgress` | `TaskCountProgress` 또는 `null` | 제공되는 경우의 개수 진행 상태 스냅샷. 두 뷰 모두에 나타날 수 있습니다. |
| `repeatEndCondition` | `TaskRepeatEndCondition` 또는 `null` | `/tasks`의 반복 종료 규칙. `/history`에서는 항상 `null`입니다. |

### 작업 상태 및 타임스탬프 :id=task-times

| `status` | 의미 | 기록 `endTime`의 의미 |
| --- | --- | --- |
| `0` | 미완료 | 완료 시각이 아닙니다. `/history`는 종료된 기록을 선택합니다. |
| `1` | 완료 | 기록된 완료 시각. |
| `2` | 기한 초과 | 기록된 기한 초과 시각. |
| `3` | 포기 | 기록된 포기 시각. |

| 시간 필드 | 정의 |
| --- | --- |
| `startTime` | 설정/예약된 작업 시작 시각이며 사용자가 실제 작업을 시작한 때가 아닙니다. |
| `deadline` | 예약된 기한이며 기록된 종료 시각과 별개입니다. |
| `endTime` | 기록에서 저장한 종료 시각이며 위와 같이 `status`와 함께 해석합니다. |

세 값 모두 Unix 밀리초를 사용합니다. 일반 완료 시 앱은 현재 시각을 기록합니다. `history_operation`의 `operation=edit_completed_time`은 `completed_time` 입력을 받아 같은 저장 완료 시각을 수정합니다. 기록을 읽을 때 필드 이름은 계속 `endTime`입니다.

저장된 시각은 수정할 수 있습니다. 종료된 기록에 저장된 종료 날짜가 없으면 앱은 현재 시각을 대체값으로 사용합니다. 따라서 `endTime`은 현재 저장된 시각이지 변경할 수 없는 감사 타임스탬프가 아닙니다. `/tasks`의 `0`은 SDK 플레이스홀더이며 Unix epoch 시점의 실제 이벤트가 아닙니다.

### RewardItem :id=reward-item

| 필드 | JSON 유형 | 의미 |
| --- | --- | --- |
| `itemId` | integer | 보상 아이템 ID. |
| `itemCount` | integer | 보상 수량. |

```json
{"itemId":7,"itemCount":1}
```

### SubTask :id=subtask

| 필드 | JSON 유형 | 의미 / 기본값 |
| --- | --- | --- |
| `id` | integer | 하위 작업 ID. |
| `gid` | integer | 하위 작업 그룹 ID. |
| `todo` | string | 하위 작업 텍스트. |
| `status` | integer | `0` 미완료, `1` 완료. |
| `remindTime` | integer 또는 `null` | 알림 타임스탬프(밀리초). 사용할 수 없으면 `null`. |
| `endTime` | integer 또는 `null` | 하위 작업 완료 타임스탬프(밀리초). 사용할 수 없으면 `null`. |
| `exp` | integer | 설정된 EXP 보상. |
| `coin` | integer 또는 `null` | 설정된 코인 보상. |
| `coinVariable` | integer 또는 `null` | 랜덤 코인 보상 설정. |
| `items` | `RewardItem[]` | 아이템 보상. 기본 빈 배열. |
| `order` | integer 또는 `null` | 정렬값. 모델 기본값 `0`. |
| `autoUseItem` | boolean 또는 `null` | 보상을 자동으로 사용할지 여부. 모델 기본값 `false`. |

```json
{
  "id":201,"gid":20,"todo":"Read ten pages","status":1,
  "remindTime":null,"endTime":1792072800000,"exp":2,
  "coin":0,"coinVariable":0,"items":[{"itemId":7,"itemCount":1}],
  "order":0,"autoUseItem":false
}
```

### TaskCountProgress :id=count-progress

| 필드 | JSON 유형 | 의미 |
| --- | --- | --- |
| `currentCount` | integer | 이 작업/주기의 현재 개수. |
| `targetCount` | integer | 이 작업/주기의 목표 개수. |

```json
{"currentCount":2,"targetCount":5}
```

### TaskRepeatEndCondition :id=repeat-end-condition

| 필드 | JSON 유형 | 의미 / 기본값 |
| --- | --- | --- |
| `mode` | string | `COUNT` 또는 `DATE`. 읽기 측 문자열이며 숫자 액션 매개변수가 아닙니다. |
| `behavior` | string | `TERMINATE` 또는 `FREEZE`. |
| `targetCycleCount` | integer 또는 `null` | `COUNT`의 주기 개수 목표. 기본값 `null`. |
| `endDateMillis` | integer 또는 `null` | `DATE` 모드의 종료일 타임스탬프(밀리초). 기본값 `null`. |
| `inclusive` | boolean | 종료일 포함 여부. 기본값 `false`. |

```json
{"mode":"COUNT","behavior":"TERMINATE","targetCycleCount":10,"endDateMillis":null,"inclusive":false}
```

### 보상 금액 :id=reward-amounts

작업 및 하위 작업의 이 필드들은 설정된 보상을 나타냅니다. 배율, 랜덤 코인 및 정산 규칙에 따라 실제 지급량이 달라질 수 있습니다. 거래 금액은 [EXP 및 코인 기록](/guide/api-reference?id=reward-journals)에서 확인하고, 양수 보상과 취소/패널티를 포함한 순변동을 구분하세요.

### 구현 참조 :id=api-task-model-sources

[Task](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/Task.kt) · [파서](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TasksApi.kt) · [SubTask](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/SubTask.kt) · [RewardItem](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/common/RewardItem.kt) · [횟수 진행도](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TaskCountProgress.kt) · [반복 종료 규칙](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TaskRepeatEndCondition.kt).

## 작업 및 기록 쿼리 :id=task-queries

[공통 규칙](/guide/api-reference?id=http-query-reference)과 [Task/History 전체 모델](/guide/api-reference?id=task-history-models)을 읽어보세요. 이 엔드포인트에는 Cloud의 Read LifeUp Data 권한이 필요합니다. 기본 목록 쿼리는 최신 Cloud를 사용하는 LifeUp v1.91+ 기준으로 문서화되어 있으며 예시는 현재 SDK 필드를 설명합니다. 구버전 설치 환경과 연동할 때는 `/info`를 확인하세요.

### GET /tasks 및 /tasks/{categoryId} :id=get-tasks

현재 **미완료** 작업 목록을 조회하며 카테고리/목록으로 제한할 수 있습니다. 결과는 전체 배열이며 서버 측 페이지네이션은 없습니다. 완료, 기한 초과, 포기 기록은 `/history`에서 조회합니다.

| 매개변수 | 위치 | 유형 | 필수 | 기본값 / 동작 |
| --- | --- | --- | --- | --- |
| `categoryId` | Path | integer | `/tasks/{categoryId}`일 때만 | 전체 미완료 작업 목록을 조회하려면 경로 부분 전체를 생략합니다. |

이 경로는 `offset`, `limit`, `gid`, 날짜 범위 쿼리 매개변수를 지원하지 않습니다. 정수가 아닌 카테고리 경로는 현재 카테고리가 없는 것으로 파싱됩니다. 실수로 모든 작업을 조회하지 않도록 요청 전에 검증하세요.

```text
GET http://{host:port}/tasks
GET http://{host:port}/tasks/1
```

**응답:** `HttpResponse<Task[]>`. 모든 레코드 필드와 중첩 구조는 [Task/History 필드](/guide/api-reference?id=task-fields)에 정의되어 있습니다. 다음 가상 레코드는 전체 최상위 HTTP 구조를 보여줍니다. `endTime=0`은 이 경로의 플레이스홀더이며 완료 타임스탬프가 아닙니다.

```json
{
  "code": 200,
  "message": "success",
  "data": [{
    "id": 101, "gid": 10, "name": "Read a chapter", "notes": "",
    "status": 0, "startTime": 1792108800000, "deadline": 1792195199999,
    "remindTime": 0, "frequency": 1, "weekdays": "",
    "exp": 5, "skillIds": [2], "coin": 10, "coinVariable": 0,
    "itemId": 0, "itemAmount": 0, "words": "", "categoryId": 1,
    "order": 0, "nameExtended": "Read a chapter", "endTime": 0,
    "items": [], "subTasks": [], "countProgress": null,
    "repeatEndCondition": null
  }]
}
```

**동작 및 오류:** 목록 선택/순서는 LifeUp 작업 목록 규칙을 따릅니다. 이 엔드포인트는 완료 시각 기준 정렬을 보장하지 않습니다. 성공 응답의 `data: []`는 선택한 작업 목록에 레코드가 없다는 뜻입니다. 권한/제공자 오류는 [공통 오류 래퍼](/guide/api-reference?id=response-errors)로 반환되며 빈 배열이 아닙니다. 완료를 보고할 때는 이 경로의 `endTime` 대신 아래 `/history`를 사용하세요.

### GET /history :id=get-history

완료, 기한 초과, 포기된 작업을 포함해 표시 가능한 종료 작업 기록을 조회합니다. 삭제된 기록은 제외됩니다.

| 매개변수 | 위치 | 유형 | 필수 | 기본값 / 동작 |
| --- | --- | --- | --- | --- |
| `offset` | Query | integer | 아니요 | `0`; 건너뛸 레코드 수. 0부터 시작합니다. |
| `limit` | Query | integer | 아니요 | `100`; 양수 페이지 크기를 요청하세요. `1..100` 권장. |
| `gid` | Query | integer | 아니요 | 그룹 필터 없음. 지정하면 주기를 넘어 해당 작업 그룹을 선택합니다. |

HTTP 파서는 해석할 수 없는 `offset` / `limit`을 `0` / `100`으로 대체하고 해석할 수 없는 `gid`는 버립니다. 이 경로는 파싱된 수치를 제한하지 않습니다. 0 이상의 offset과 양수 limit을 직접 검증하세요. `time_range_start` / `time_range_end`는 **지원되지 않으며** 지정해도 기록이 필터링되지 않습니다.

```text
GET http://{host:port}/history?offset=0&limit=100
GET http://{host:port}/history?offset=0&limit=100&gid=10
```

**응답:** `HttpResponse<HistoryRecord[]>`; [Task/History 와이어 필드](/guide/api-reference?id=task-fields)를 사용합니다. `HistoryRecord`는 SDK `Task` 모델의 기록 뷰를 설명하기 위한 문서상 이름입니다. 이 뷰에서 `repeatEndCondition`은 `null`이며 `countProgress`는 포함될 수 있습니다. 저장된 `endTime`은 `status`와 함께 해석합니다.

```json
{
  "code": 200,
  "message": "success",
  "data": [{
    "id": 100, "gid": 10, "name": "Read a chapter", "notes": "",
    "status": 1, "startTime": 1792022400000, "deadline": 1792108799999,
    "remindTime": 0, "frequency": 1, "weekdays": "",
    "exp": 5, "skillIds": [2], "coin": 10, "coinVariable": 0,
    "itemId": 0, "itemAmount": 0, "words": "", "categoryId": 1,
    "order": 0, "nameExtended": "", "endTime": 1792072800000,
    "items": [], "subTasks": [], "countProgress": null,
    "repeatEndCondition": null
  }]
}
```

**정렬:** 저장 종료 날짜 내림차순, 최신 항목 우선입니다. 종료 날짜가 같을 때의 정렬 기준은 문서화되어 있지 않습니다. 페이지네이션은 스냅샷이 아니므로 보고서를 수집하는 동안 데이터를 수정하지 말고, 여러 페이지를 합칠 때 `id`로 중복을 제거하세요.

**페이지네이션 및 빈 결과:** [공통 페이지 조회 절차](/guide/api-reference?id=pagination)를 따르세요. 성공한 빈 배열은 해당 페이지/그룹에 표시할 기록이 없다는 뜻이며 `offset`이 마지막 페이지를 넘은 경우도 포함합니다. 활동이 한 번도 없었다는 증거는 아닙니다. 삭제된 기록은 제외되고 완전성 표시도 없습니다. 요청이 하나라도 실패하면 작업 수를 0으로 보고하지 말고 데이터를 사용할 수 없거나 불완전하다고 보고하세요. [공통 오류](/guide/api-reference?id=response-errors)가 적용됩니다.

### 일일 보고서 작성 :id=daily-report

1. 보고서 시간대를 정합니다. 달력 날짜의 시작(`dayStart`)과 다음 날짜의 시작(`nextDayStart`)을 계산합니다. 현지의 하루가 항상 24시간인 것은 아닙니다.
2. `/history`를 `offset=0&limit=100`으로 읽고 각 응답을 확인하면서 모든 페이지를 모읍니다. `gid` 필터를 사용한다면 모든 페이지에 동일하게 적용합니다.
3. `status == 1` 및 `dayStart <= endTime < nextDayStart` 조건을 선택합니다. 결과 설명 시 [기록 시각의 한계](/guide/api-reference?id=task-times)를 고려하세요.
4. 실제 EXP 및 코인 변동은 같은 날짜의 [보상 기록](/guide/api-reference?id=reward-journals)에서 읽습니다. 날짜 필터는 양 끝을 포함하므로 `time_range_start=dayStart`, `time_range_end=nextDayStart-1`을 사용합니다.
5. “사용 가능한 데이터에서 기록을 찾지 못함”과 읽기 실패/미완료를 구분합니다. 양수 보상만 표시할지 취소를 포함한 순변동을 표시할지 정하고 일관되게 적용하세요.

작업/기록의 `exp`와 `coin`은 설정 보상이며 기록된 거래 금액을 대신할 수 없습니다. 완료 시각을 다른 날짜로 편집해도 보상 기록의 거래 시각이 옮겨지는 것은 아닙니다.

### 구현 참조 :id=api-task-queries-sources

[HTTP 경로](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt) · [작업 및 기록 파싱](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TasksApi.kt).

## EXP 및 코인 기록 쿼리 :id=reward-journals

이 읽기 전용 HTTP 엔드포인트에는 Read LifeUp Data 권한, LifeUp **1.106.0+**, LifeUp Cloud **3.0.0+**가 필요합니다. 작업에 설정된 보상이 아니라 감소와 취소를 포함한 기록된 변동을 반환합니다. 먼저 [공통 규칙](/guide/api-reference?id=http-query-reference)을 확인하세요.

### 두 엔드포인트의 요청 매개변수 :id=journal-parameters

아래 계약은 `GET /exp_records` 및 `GET /coin_records` **모두**에 적용됩니다.

| 매개변수 | 위치 | 유형 | 필수 | 기본값 / 실제 동작 |
| --- | --- | --- | --- | --- |
| `offset` | Query | integer | 아니요 | HTTP 기본값 `0`; 제공자는 음수를 `0`으로 제한합니다. |
| `limit` | Query | integer | 아니요 | HTTP 기본값 `100`; 제공자는 `1..200`으로 제한합니다. 공통 페이지 조회 절차에는 `1..100`을 사용하세요. |
| `time_range_start` | Query | integer (Unix milliseconds) | 아니요 또는 쌍으로 | 거래 기록 시각의 하한. 경계를 포함합니다. |
| `time_range_end` | Query | integer (Unix milliseconds) | 아니요 또는 쌍으로 | 상한이며 경계를 포함합니다. 유효한 필터링에는 `start < end`가 필요합니다. |

해석할 수 없거나 범위를 벗어난 페이지네이션 값에는 HTTP 기본값이 적용됩니다. 해석할 수 없는 날짜 값은 없는 값으로 처리됩니다. 현재 SDK는 두 경계가 모두 존재하고 `start < end`일 때만 날짜 범위를 전달하며, 그렇지 않으면 **날짜 필터 없이** 조회합니다. 원시 ContentProvider 직접 호출은 잘못된 범위의 검증 방식이 다릅니다. HTTP 호출 쪽에서 경계를 검증하세요.

두 엔드포인트는 기록된 거래 시각 내림차순(최신순)으로 정렬하고 삭제된 기록 항목은 제외합니다. ID 기준 동률 정렬이나 여러 페이지의 스냅샷은 보장하지 않습니다. 제공자의 유효 limit을 고려해 [페이지네이션](/guide/api-reference?id=pagination)을 따르세요. 성공한 빈 배열은 선택한 범위/페이지에 항목이 없다는 뜻이며 읽기 실패가 활동이 없다는 뜻은 아닙니다. 삭제 또는 가져올 수 없는 데이터에 대한 완전성 플래그는 없습니다.

### GET /exp_records :id=get-exp-records

EXP 변동을 조회합니다. 매개변수는 위의 [네 가지 기록 매개변수](/guide/api-reference?id=journal-parameters)이며 `gid` 필터는 없습니다.

```text
GET http://{host:port}/exp_records?offset=0&limit=100&time_range_start=1792022400000&time_range_end=1792108799999
```

**응답:** `HttpResponse<ExpRecord[]>`. 현재 직렬화에는 null 허용 값도 포함해 아래 모든 필드가 포함됩니다.

| 필드 | JSON 유형 | 의미 / 파서 대체값 |
| --- | --- | --- |
| `id` | integer 또는 `null` | 기록 항목 ID. |
| `time` | integer 또는 `null` | Unix 밀리초 거래 시각. 수정 가능한 작업 완료 시각과 별개입니다. |
| `value` | integer | 연결된 속성별 EXP 변동. 대체값 `0`. 증감 방향은 `isDecrease`를 사용합니다. |
| `isDecrease` | boolean | 감소 시 `true`, 증가 시 `false`; 파서는 제공자 정수 `1`을 true로 처리합니다. |
| `totalValue` | integer | 기록된 EXP 집계 변동이며 **EXP 잔액이 아닙니다**. 대체값 `0`. 여러 속성의 일괄 처리에서는 저장된 합계가 중복될 수 있습니다. [보고서 합계](/guide/api-reference?id=journal-totals)를 참조하세요. |
| `resCode` | integer | EXP 전용 사유 코드. 대체값 `0`. |
| `relatedId` | integer 또는 `null` | 관련 원본 객체 ID. 일반 작업 완료에서는 `gid`가 아니라 작업 기록의 `id`입니다. 다른 사유는 다른 리소스를 가리킬 수 있습니다. |
| `content` | string 또는 `null` | 변동 설명. |
| `skillIds` | integer array | 연결된 속성/스킬 ID. 대체값은 빈 배열. |
| `relatedAttributes` | string array | 연결된 레거시 속성 문자열. 대체값은 빈 배열. |

가상 예시: 두 속성 각각에 EXP 10이 적용되어 집계 EXP 20이 된 경우.

```json
{
  "code":200,"message":"success","data":[{
    "id":301,"time":1792072800000,"value":10,"isDecrease":false,
    "totalValue":20,"resCode":1,"relatedId":100,"content":"Task completed",
    "skillIds":[2,3],"relatedAttributes":[]
  }]
}
```

**오류:** [공통 HTTP/제공자 오류](/guide/api-reference?id=response-errors). 잘못된 HTTP 날짜 경계는 오류를 반환하기보다 위 설명대로 날짜 필터를 조용히 제거할 수 있습니다.

### GET /coin_records :id=get-coin-records

코인 변동을 조회합니다. 매개변수는 위의 [네 가지 기록 매개변수](/guide/api-reference?id=journal-parameters)이며 `gid` 필터는 없습니다.

```text
GET http://{host:port}/coin_records?offset=0&limit=100&time_range_start=1792022400000&time_range_end=1792108799999
```

**응답:** `HttpResponse<CoinRecord[]>`. 현재 직렬화에는 null 허용 값도 포함해 아래 모든 필드가 포함됩니다.

| 필드 | JSON 유형 | 의미 / 파서 대체값 |
| --- | --- | --- |
| `id` | integer 또는 `null` | 기록 항목 ID. |
| `time` | integer 또는 `null` | Unix 밀리초 거래 시각. |
| `value` | integer | 코인 변동량. 대체값 `0`. 증감 방향은 `isDecrease`를 사용합니다. |
| `isDecrease` | boolean | 감소 시 `true`, 증가 시 `false`; 파서는 제공자 정수 `1`을 true로 처리합니다. |
| `totalValue` | integer | 작업 후 코인 잔액. 대체값 `0`. EXP `totalValue`와 달리 잔액입니다. |
| `resCode` | integer | 코인 전용 사유 코드. 대체값 `0`. |
| `relatedId` | integer 또는 `null` | 관련 원본 객체 ID. 일반 작업 완료는 작업 기록의 `id`를 사용합니다. 다른 원본은 사유 코드로 해석하세요. |
| `content` | string 또는 `null` | 변동 설명. |
| `savingBalance` | integer 또는 `null` | 작업 시점에 기록된 저축 잔액. |

가상 예시: 코인 5개를 차감하여 잔액이 95가 된 경우.

```json
{
  "code":200,"message":"success","data":[{
    "id":401,"time":1792072800000,"value":5,"isDecrease":true,
    "totalValue":95,"resCode":0,"relatedId":null,"content":"Example purchase",
    "savingBalance":0
  }]
}
```

**오류:** [공통 HTTP/제공자 오류](/guide/api-reference?id=response-errors). 잘못된 HTTP 날짜 경계는 오류를 반환하기보다 위 설명대로 날짜 필터를 조용히 제거할 수 있습니다.

### 사유 코드 및 보고서 합계 :id=journal-totals

사유 코드 영역은 서로 다릅니다. 일부 예:

| 사유 | EXP `resCode` | 코인 `resCode` |
| --- | --- | --- |
| 작업 완료 | `1` | `2` |
| 작업 완료 취소 | `101` | `3` |
| 하위 작업 완료 | `12` | `11` |
| 하위 작업 취소 | `106` | `12` |
| API 변경 | `200` | `28` |

전체 EXP 코드: `0` 알 수 없음, `1` 할 일 완료, `2` 업적, `3` 좋아요 교환, `4` 연속 사용 일수, `5` 걸음 교환, `6` 완료로 설정, `7` 포기 취소, `8` 기한 초과 취소, `9` 토마토 먹기, `10` 상품 사용, `11` 사용자 업적 해제, `12` 하위 할 일 완료, `200` API, `101` 완료 취소, `102` 포기, `103` 기한 초과, `104` 상품 사용에 따른 EXP 감소, `105` 사용자 업적 다시 잠금, `106` 하위 할 일 완료 취소. 코인 원인 코드는 [인벤토리 기록](#get-inventory-records)과 같은 영역입니다. 향후 알 수 없는 코드도 유지하세요. 순변동을 계산할 때 `isDecrease` 방향을 적용하세요 (`true`는 기록 금액을 차감). 감소가 음수 `value`로 인코딩된다고 가정하지 마세요. 숫자 유형은 부호가 있으며 unsigned/절댓값 보장은 없습니다.

EXP `value`는 속성별 값입니다. EXP `totalValue`를 기록 간에 무조건 합산하지 마세요. 현재 여러 속성을 일괄 처리할 때 세 개를 초과하는 속성에 대해 저장된 합계가 겹칠 수 있습니다. 예를 들어 네 속성 각각에 EXP 10을 변경하면 안전한 합계 40 대신 저장값 40과 10이 생길 수 있습니다. 정확한 보고를 위해 레코드별 속성 목록과 `value`를 대조하세요. 연결 정보가 누락되면 확인할 수 있는 범위가 제한됩니다. `value`와 `totalValue`를 더하지 말고 EXP `totalValue`를 잔액으로 설명하지 마세요.

하루의 범위는 현지 `dayStart`, `nextDayStart`를 계산한 뒤 양 끝을 포함하므로 `[dayStart, nextDayStart - 1]`로 요청합니다. 작업 보상만 보고할 때는 사유 코드로 선택하고 전체 기록 변동을 보고할 때는 필터링하지 마세요. [일일 보고서 절차](/guide/api-reference?id=daily-report).

### 구현 참조 :id=api-ledgers-sources

[CoinRecord](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/CoinRecord.kt) · [ExpRecord](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/ExpRecord.kt) · [날짜 매개변수 전달](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/LedgerUri.kt).

## 상품과 카테고리 :id=get-items

`GET /items`는 `ShopItem[]`를 반환합니다. 반복 가능한 `id` 쿼리로 상품을 선택합니다(예: `/items?id=1&id=2`). 정수가 아닌 값과 존재하지 않는 ID는 제외하며, 유효한 ID는 중복을 포함해 요청 순서를 유지합니다. 모두 무효하면 SDK가 ID 필터를 보내지 않아 일반 목록을 반환합니다. 페이지 나누기는 지원하지 않습니다.

`GET /items/{listId}`는 단일 상품이 아닌 **카테고리 내** `ShopItem[]`를 반환합니다. `listId`는 부호 있는 64비트 카테고리 ID이며, `-1`과 잘못된 경로 값은 전체를 의미합니다. 일반 목록은 판매 중지·삭제 상품을 제외하고(`isDel=0`) 상점·카테고리 설정에 따라 정렬합니다. ID 선택은 일반 목록 필터와 독립적으로 상품을 가져올 수 있습니다.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Coffee","desc":"A small reward","icon":"","categoryId":0,"stockNumber":-1,"ownNumber":2,"price":10,"order":0,"disablePurchase":false,"maxPurchaseNumber":5,"titleColorString":"","actionText":"Use","unlist":false,"disableUse":false,"purchaseLimit":"[]","limitScope":"purchase"}]}
```

### ShopItem :id=model-shop-item

| 필드 | JSON 형식 | 의미 |
| --- | --- | --- |
| `id` | integer or null | 상품 ID. |
| `name` | string | 상품 이름. |
| `desc` | string | 설명. |
| `icon` | string | 읽을 수 있는 이미지 URI 또는 빈 문자열. `/files/{url}`로 다운로드합니다. |
| `categoryId` | integer | 상점 카테고리 ID. |
| `stockNumber` | integer | 재고 수량. `maxPurchaseNumber` 계산 시 음수는 무제한으로 처리합니다. |
| `ownNumber` | integer | 보유 수량. |
| `price` | integer | 코인 가격. |
| `order` | integer | 저장된 카테고리 내 정렬 순서. |
| `disablePurchase` | boolean | 구매 금지 여부. |
| `maxPurchaseNumber` | integer or null | 사용 가능한 코인, 신용 한도, 유한 재고로 계산합니다. 구매 금지 시 0이며 무료·무제한 재고는 2147483647이 될 수 있습니다. 모든 구매 제한 규칙을 검사하지는 않습니다. |
| `titleColorString` | string or null | 사용자 지정 제목 색상. |
| `actionText` | string or null | 사용자 지정 사용 버튼 문구. |
| `unlist` | boolean | 판매 중지·삭제 여부. 일반 목록에서는 보통 false입니다. |
| `disableUse` | boolean | 상품에 사용 불가 효과가 있는지 여부. |
| `purchaseLimit` | string or null | 상품의 구매 제한 설정. 중첩 배열이 아닌 **JSON 인코딩 문자열**입니다. |
| `limitScope` | string or null | `purchase`, `use` 또는 `both`. |

### GET /items_categories :id=get-items-categories

`ShopCategory[]`를 반환합니다. 선택적 `include_hidden`의 기본값은 `false`이며 정확한 소문자 `true`·`false`만 해석하고 나머지는 false로 처리합니다. 가상 전체 카테고리를 포함합니다. HTTP는 `/items_categories/{id}`를 제공하지 않습니다.

```json
{"code":200,"message":"success","data":[{"id":0,"name":"Default","isAsc":true,"sort":"order","order":0,"hidden":false,"inventoryHidden":false}]}
```

### ShopCategory :id=model-shop-category

| 필드 | JSON 형식 | 의미 |
| --- | --- | --- |
| `id` | integer or null | 카테고리 ID. |
| `name` | string | 카테고리 이름. |
| `isAsc` | boolean | 설정된 오름차순 정렬 여부. |
| `sort` | string | 저장된 정렬 설정. |
| `order` | integer | 카테고리 순서. |
| `hidden` | boolean | 상점에서 숨김 여부. |
| `inventoryHidden` | boolean | 인벤토리에서 숨김 여부. |

### GET /tasks_categories :id=get-tasks-categories

전체 및 보관된 카테고리를 포함한 `TaskCategory[]`를 반환합니다. 쿼리 매개변수나 페이지 나누기가 없으며 `/tasks_categories/{id}`도 제공하지 않습니다. 카테고리의 정렬·필터 값은 앱에 저장된 설정이며 요청 필터로 적용되지 않습니다.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Daily","isAsc":true,"sort":"order","filter":"","order":0,"status":0,"type":0}]}
```

### TaskCategory :id=model-task-category

| 필드 | JSON 형식 | 의미 |
| --- | --- | --- |
| `id` | integer or null | 카테고리 ID. |
| `name` | string | 이름. |
| `isAsc` | boolean | 저장된 오름차순 정렬 여부. |
| `sort` | string | 저장된 정렬 설정. |
| `filter` | string | 저장된 그룹화·필터 설정. |
| `order` | integer | 카테고리 순서. |
| `status` | integer | 0 일반, 1 보관됨. |
| `type` | integer | 0 일반. 스마트 목록은 10 매일, 11 매주, 12 매월, 20 진행 중. |

## 능력과 능력 그룹 :id=get-skills

`GET /skills`는 매개변수나 페이지 나누기 없이 `Skill[]`를 반환합니다. 숨김·삭제된 능력을 제외하고 저장된 순서로 정렬합니다. 하위 ContentProvider의 `group_id`와 `status`는 HTTP 모델 필드가 **아닙니다**.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Strength","desc":"","icon":"","order":0,"color":-65536,"exp":150,"level":2,"untilNextLevelExp":50,"currentLevelExp":50,"type":1}]}
```

### Skill :id=model-skill

| 필드 | JSON 형식 | 의미 |
| --- | --- | --- |
| `id` | integer or null | 능력 ID. |
| `name` | string | 현지화된 능력 이름. |
| `desc` | string | 설명. |
| `icon` | string | 읽을 수 있는 아이콘 URI 또는 빈 문자열. |
| `order` | integer | 저장된 정렬 순서. |
| `color` | integer | Android의 패킹된 색상 정수. |
| `exp` | integer | 현재 총 EXP. |
| `level` | integer | 현재 레벨. |
| `untilNextLevelExp` | integer | 다음 레벨까지 필요한 EXP. |
| `currentLevelExp` | integer | 현재 레벨에 도달한 후 획득한 EXP. |
| `type` | integer | 0 사용자 정의, 1 힘, 2 학습, 3 매력, 4 지구력, 5 활력, 6 창의력. |

### GET /skill_groups :id=get-skill-groups

`SkillGroup[]`를 반환합니다. `include_hidden`은 `/items_categories`와 같은 엄격한 불리언 해석을 사용하며 기본값은 false입니다. 현재 앱 저장소는 그룹에서 이 값을 무시하고 삭제된 그룹을 항상 제외합니다. 저장된 순서의 오름차순이며 페이지 나누기는 없습니다.

```json
{"code":200,"message":"success","data":[{"id":1,"content":"Personal","order":0,"collapsed":false}]}
```

### SkillGroup :id=model-skill-group

| 필드 | JSON 형식 | 의미 |
| --- | --- | --- |
| `id` | integer or null | 그룹 ID. |
| `content` | string | 그룹 제목. |
| `order` | integer | 저장된 그룹 순서. |
| `collapsed` | boolean | 접힘 상태. |

## 업적 :id=get-achievements

`GET /achievements`는 카테고리 순서로 각 카테고리를 읽고 업적을 합쳐 `Achievement[]`를 반환합니다. `GET /achievements/{id}`는 개별 업적 상세가 아닌 **카테고리 `id` 내** 업적을 반환합니다. 잘못된 경로 ID는 필터 없는 요청으로 처리합니다. 카테고리 내부는 앱의 해당 정렬 설정을 따르며 두 경로 모두 페이지 나누기가 없습니다.

```json
{"code":200,"message":"success","data":[{"id":10,"name":"First step","desc":"Complete a task","iconUri":"","categoryId":1,"status":0,"exp":10,"coin":5,"coinVariable":0,"type":0,"progress":0,"order":0,"itemId":null,"itemAmount":null,"unlockedTime":null,"items":[],"color":""}]}
```

### Achievement :id=model-achievement

| 필드 | JSON 형식 | 의미 |
| --- | --- | --- |
| `id` | integer or null | 업적 ID. |
| `name` | string | 제목. |
| `desc` | string | 설명. |
| `iconUri` | string | 아이콘 URI 또는 빈 문자열. |
| `categoryId` | integer | 카테고리 ID. |
| `status` | integer | 0 미완료, 1 완료·보상 미수령, 2 보상 수령·기타 완료 상태. |
| `exp` | integer | EXP 보상. |
| `coin` | integer | 코인 보상. |
| `coinVariable` | integer | 변동 코인 보상. |
| `type` | integer | 0 업적, 1 하위 카테고리 제목. |
| `progress` | integer | 저장된 진행도. |
| `order` | integer | 카테고리 내 순서. |
| `itemId` | integer or null | 첫 번째 보상 상품 ID(이전 형식의 편의 필드). |
| `itemAmount` | integer or null | 첫 번째 보상 상품 수량. |
| `unlockedTime` | integer or null | 해제 시각(Unix 밀리초). |
| `items` | RewardItem[] or null | 전체 보상 상품 목록. 현재 파서는 상품 JSON이 없거나 잘못되면 빈 배열을 반환합니다. |
| `color` | string or null | 사용자 지정 제목 색상. |

보상 상품은 공통 [RewardItem](#reward-item) 모델을 사용합니다.

### GET /achievement_categories :id=get-achievement-categories

매개변수나 페이지 나누기 없이 `AchievementCategory[]`를 반환합니다. HTTP는 `/achievement_categories/{id}`를 제공하지 않습니다.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Milestones","desc":"","iconUri":"","isAsc":true,"sort":"order","filter":"","order":0,"type":0}]}
```

### AchievementCategory :id=model-achievement-category

| 필드 | JSON 형식 | 의미 |
| --- | --- | --- |
| `id` | integer or null | 카테고리 ID. |
| `name` | string | 이름. |
| `desc` | string | 설명. |
| `iconUri` | string | 아이콘 URI·문자열. |
| `isAsc` | boolean | 오름차순 정렬 여부. |
| `sort` | string | 저장된 정렬 설정. |
| `filter` | string | 저장된 그룹화·필터 설정. |
| `order` | integer | 카테고리 순서. |
| `type` | integer | 0 사용자 업적, 1 시스템 업적. |

### GET /achievement_conditions/{id} :id=get-achievement-conditions

**업적** ID `id`의 `AchievementCondition[]`를 반환합니다. 정수가 아닌 ID는 code 500 오류 래퍼를 반환하며 일치하는 조건이 없으면 빈 배열을 반환합니다. `/achievement_conditions` 목록 경로는 없습니다.

```json
{"code":200,"message":"success","data":[{"id":1,"type":0,"relatedId":42,"target":10,"current":3,"progress":30}]}
```

### AchievementCondition :id=model-achievement-condition

| 필드 | JSON 형식 | 의미 |
| --- | --- | --- |
| `id` | integer or null | 조건 ID. |
| `type` | integer | 조건 코드. 아래 참조. |
| `relatedId` | integer | 조건에 따른 관련 할 일·상품·능력 ID. |
| `target` | integer | 목표값. |
| `current` | integer | 현재 누적값. |
| `progress` | integer | 저장된 진행도. |

조건 코드: 0 할 일 완료 횟수, 1 현재 연속 완료, 2 이전 능력 레벨, 3 토마토 수, 4 사용 일수, 5 좋아요 수, 6 연속 완료 일수, 7 현재 코인, 8 하루 획득 코인, 9 할 일 토마토, 10 상품 구매, 11 사용, 12 상자에서 상품 획득, 13 능력 레벨, 14 인생 레벨, 15 누적 상품 획득, 16 합성 획득, 17 현재 보유 수량, 18 할 일 집중 시간, 19 ATM 저축, 20 외부 API. 반복 조건: 500 할 일 완료, 501 능력 레벨 상승, 502 토마토, 503 코인, 504 상품 획득, 505 구매, 506 상자 획득, 507 합성 획득, 508 사용, 509 할 일 집중 분, 510 할 일 토마토, 511 좋아요, 512 ATM 저축 증가, 513 외부 API 호출, 514 사용 일수, 515 인생 레벨 상승, 516 일일 코인, 517 연속 완료, 518 일일 토마토, 519 일일 집중 분, 520 일일 서로 다른 할 일 그룹 수, 521 일일 사용, 522 일일 구매, 523 지정 할 일 일일 완료, 524 일일 총 완료 기록 수. 직렬화된 열거형 이름이 아닌 정수 코드입니다.

## 합성 :id=get-synthesis

`GET /synthesis`는 표시된 카테고리 전체의 `Synthesis[]`를 반환합니다. `GET /synthesis/{id}`는 숨겨진 내용도 포함해 **카테고리 `id` 내** 레시피를 반환합니다. 0 이상의 ID는 카테고리, 음수는 모든 표시 카테고리를 선택하며 잘못된 값은 목록 경로로 처리합니다. 삭제된 레시피는 제외하고 저장된 순서의 오름차순으로 반환하며 페이지 나누기는 없습니다.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Tea","desc":"","input":[{"itemId":2,"itemName":"Tea leaf","amount":2,"ownedNumber":5,"icon":""}],"output":[{"itemId":3,"itemName":"Tea","amount":1,"ownedNumber":0,"icon":""}],"categoryId":0,"canSynthesisTimes":2}]}
```

### Synthesis :id=model-synthesis

| 필드 | JSON 형식 | 의미 |
| --- | --- | --- |
| `id` | integer or null | 레시피 ID. |
| `name` | string | 이름. |
| `desc` | string | 설명. |
| `input` | SynthesisItemInfo[] | 필요한 상품. |
| `output` | SynthesisItemInfo[] | 생성되는 상품. |
| `categoryId` | integer or null | 카테고리 ID. |
| `canSynthesisTimes` | integer | 현재 합성 가능한 횟수. |

### SynthesisItemInfo :id=model-synthesis-item-info

| 필드 | JSON 형식 | 의미 |
| --- | --- | --- |
| `itemId` | integer | 상품 ID. |
| `itemName` | string | 상품 이름. |
| `amount` | integer | 합성 1회당 투입·산출 수량. |
| `ownedNumber` | integer | 보유 수량. |
| `icon` | string | 읽을 수 있는 아이콘 URI 또는 빈 문자열. |

### GET /synthesis_categories 및 /synthesis_categories/{id} :id=get-synthesis-categories

둘 다 `SynthesisCategory[]`를 반환합니다. 선택적 경로 `id`는 카테고리 ID를 필터링하며 배열 형태는 유지합니다. 잘못된 ID는 전체 카테고리를 반환합니다. `include_hidden`은 소문자 불리언을 엄격히 해석하며 카테고리 ID를 지정해도 기본값은 false입니다. 페이지 나누기는 없습니다.

```json
{"code":200,"message":"success","data":[{"id":0,"name":"Default","isAsc":true,"sort":"order","order":0,"hidden":false}]}
```

### SynthesisCategory :id=model-synthesis-category

| 필드 | JSON 형식 | 의미 |
| --- | --- | --- |
| `id` | integer or null | 카테고리 ID. |
| `name` | string | 이름. |
| `isAsc` | boolean | 저장된 오름차순 정렬 여부. |
| `sort` | string | 저장된 정렬 설정. |
| `order` | integer | 카테고리 순서. |
| `hidden` | boolean | 숨김 여부. |

## 감상 :id=get-feelings

`GET /feelings`는 `Feelings[]`를 반환합니다. `offset`은 기본 0, `limit`은 기본 100이며 없거나 정수가 아니어도 기본값을 씁니다. 명시적인 범위 제한은 없으므로 음수가 아닌 offset과 양수 limit을 사용하세요. 삭제된 감상을 제외하고 앱의 감상 정렬 설정(`createTime` 오름차순·내림차순)을 따릅니다. 요청으로 정렬이나 시간 필터를 지정할 수 없습니다.

```json
{"code":200,"message":"success","data":[{"id":1,"content":"A good day","isFav":false,"title":"Read","time":1700000000000,"attachments":[],"type":0}]}
```

### Feelings :id=model-feelings

| 필드 | JSON 형식 | 의미 |
| --- | --- | --- |
| `id` | integer or null | 감상 ID. |
| `content` | string | 텍스트. |
| `isFav` | boolean | 즐겨찾기 여부. |
| `title` | string | 관련 제목. |
| `time` | integer | 생성 시각(Unix 밀리초). |
| `attachments` | string[] | 존재하며 비어 있지 않은 파일의 읽기 가능한 첨부 URI. |
| `type` | integer | 0 할 일, 1 업적, 2 독립 감상. |

## 포모도로 기록 :id=get-pomodoro-records

`GET /pomodoro_records`는 `PomodoroRecord[]`를 반환합니다. `offset` 기본값은 0, `limit`은 100이며 명시적 범위 제한은 없습니다. 선택적 `time_range_start`·`time_range_end`는 Unix 밀리초이며, 둘 다 64비트 정수이고 시작이 끝보다 작을 때만 SDK가 전달합니다. 그렇지 않으면 범위는 오류 없이 생략됩니다.

범위가 없으면 종료·미삭제 기록 중 `startTime != endTime`이고 `endTime`이 양수인 기록을 `endTime DESC, startTime DESC, id DESC` 순서로 반환합니다. 유효 범위는 `start < endTime <= end`를 선택하고 삭제된 기록을 제외합니다.

> [!WARNING]
> 이전 구현은 날짜 범위 조회에서 `limit`과 `offset`을 반대로 DAO에 전달했고 정렬을 지정하지 않았습니다. 로컬 LifeUp 소스는 이름 있는 인수로 수정했으며 페이지 결과를 `endTime DESC, startTime DESC, id DESC`로 정렬합니다. 이 로컬 수정은 아직 출시되지 않았습니다. 설치된 LifeUp 버전에 수정이 포함되었는지 확인하기 전에는 범위를 생략하고 클라이언트에서 기록을 필터링해 안정적으로 페이지를 조회하세요.

```json
{"code":200,"message":"success","data":[{"id":1,"startTime":1700000000000,"endTime":1700001500000,"duration":1500000,"reward":1.0}]}
```

### PomodoroRecord :id=model-pomodoro-record

| 필드 | JSON 형식 | 의미 |
| --- | --- | --- |
| `id` | integer or null | 기록 ID. |
| `startTime` | integer or null | 시작 시각(Unix 밀리초). |
| `endTime` | integer or null | 종료 시각(Unix 밀리초). |
| `duration` | integer | 밀리초. 저장된 `lastTime`이 0이 아니면 해당 값, 아니면 종료 시각에서 시작 시각을 뺀 값. |
| `reward` | number | 획득 토마토 수. 포기는 0, 절반은 0.5 × 배수, 나머지는 배수. |

## 인벤토리 기록 :id=get-inventory-records

`GET /inventory_records`는 `InventoryRecord[]`를 반환합니다. `offset`은 기본 0이고 최소 0으로, `limit`은 기본 100이고 1–200으로 제한됩니다. `time_range_start`·`time_range_end`가 모두 64비트 정수이고 start < end일 때만 전달하며, 잘못되거나 불완전한 범위는 오류 없이 생략됩니다. 유효 범위는 양 끝을 포함합니다(`time >= start AND time <= end`). 삭제된 기록을 제외하고(`isDel`이 null 또는 0) `time DESC, id DESC` 순서로 반환합니다. 상품 ID 필터는 없습니다.

```json
{"code":200,"message":"success","data":[{"id":1,"time":1700000000000,"itemId":2,"itemName":"Tea","changeNumber":1,"isDecrease":false,"resCode":0,"desc":"Purchase"}]}
```

### InventoryRecord :id=model-inventory-record

| 필드 | JSON 형식 | 의미 |
| --- | --- | --- |
| `id` | integer or null | 기록 ID. |
| `time` | integer or null | 생성 시각(Unix 밀리초). |
| `itemId` | integer or null | 관련 상품 ID. |
| `itemName` | string or null | 확인 가능한 경우 관련 상품 이름. |
| `changeNumber` | integer | 기록된 수량 변화. |
| `isDecrease` | boolean | 재고를 감소시키는 변경인지 여부. |
| `resCode` | integer | 발생 원인 코드. 아래 참조. |
| `desc` | string or null | 기록 설명. |

원인 코드: 0 구매, 1 사용, 2 할 일 완료, 3 완료 취소, 4 데이터 삭제, 5 할 일 포기, 6 기한 초과, 7 기본 업적 해제, 8 포기 취소, 9 기한 초과 취소, 10 반품, 11 하위 할 일 완료, 12 해당 완료 취소, 13 사용자 업적 해제, 14 해당 해제 취소, 15 입금, 16 출금, 17 토마토 판매, 20 상품 보상, 21 보상 취소, 23 합성, 24 상자, 25 ATM 이자, 26 토마토 상품 교환, 27 신용 이자, 28 API, 29 상품 효과에 의한 재고 변경. 클라이언트는 향후 알 수 없는 코드도 유지해야 합니다.

## 걸음 기록 :id=get-step-records

`GET /step_records`는 `StepRecord[]`를 반환합니다. 페이지 기본값·제한과 SDK 범위 생략 규칙은 `/inventory_records`와 같습니다. 유효 시간 범위는 `date`의 양 끝을 포함하며 `date DESC`로 정렬하고 명시적인 보조 정렬 키는 없습니다.

```json
{"code":200,"message":"success","data":[{"id":1,"date":1700000000000,"dailyStepCount":5000,"totalStepCount":120000,"isGotReward":true,"isUserInput":false,"rewardLevel":1}]}
```

### StepRecord :id=model-step-record

| 필드 | JSON 형식 | 의미 |
| --- | --- | --- |
| `id` | integer or null | 기록 ID. |
| `date` | integer or null | 기록된 날짜(Unix 밀리초). |
| `dailyStepCount` | integer | 일일 걸음 수. |
| `totalStepCount` | integer | 저장된 누적 걸음 수. |
| `isGotReward` | boolean | 보상 수령 여부. |
| `isUserInput` | boolean | 사용자 입력 여부. |
| `rewardLevel` | integer or null | 저장된 보상 레벨. |

## 레벨 정의 :id=get-level-defines

`GET /level_defines`는 매개변수 없이 단일 `LevelDefines` 객체를 반환합니다. 사용자 지정 레벨 모드에서는 사용자 정의를, 아니면 기본 정의를 사용합니다.

```json
{"code":200,"message":"success","data":{"custom":true,"levels":[{"id":1,"levelStart":1,"levelEnd":10,"perLevelExp":100}]}}
```

### LevelDefines :id=model-level-defines

| 필드 | JSON 형식 | 의미 |
| --- | --- | --- |
| `custom` | boolean | 사용자 지정 레벨 모드. |
| `levels` | LevelDefine[] | 레벨 범위. |

### LevelDefine :id=model-level-define

| 필드 | JSON 형식 | 의미 |
| --- | --- | --- |
| `id` | integer or null | 정의 ID. |
| `levelStart` | integer | 시작 레벨. |
| `levelEnd` | integer | 끝 레벨. |
| `perLevelExp` | integer | 해당 범위에서 레벨당 필요한 EXP. |

현재 잘못된 레벨 JSON은 전체 요청을 실패시키지 않고 빈 `levels` 배열로 처리됩니다.

## 통계 :id=get-statistics

`GET /statistics`는 단일 `Statistics`를 반환합니다. 선택적 시간 경계는 Unix 밀리초이며 둘 다 유효하고 start < end일 때만 SDK가 전달합니다. 범위가 없으면 첫 기록부터 현재까지, 기록이 없으면 최근 30일을 사용합니다. 범위를 지정해도 `usingDays`와 `companionDays`는 누적값입니다. 다른 지표는 앱의 각 통계 메서드가 계산하므로 모든 조회의 경계 포함 규칙이 같다고 가정하면 안 됩니다.

```json
{"code":200,"message":"success","data":{"start":1700000000000,"end":1700086400000,"tomatoes":4,"pomodoroMinutes":100,"focusCount":4,"tasksCompleted":3,"tasksTotal":4,"taskCompleteRate":0.75,"feelingsCount":1,"usingDays":30,"companionDays":32,"interestChanged":2,"coinPurchaseConsumed":10}}
```

### Statistics :id=model-statistics

| 필드 | JSON 형식 | 의미 |
| --- | --- | --- |
| `start` | integer or null | 실제 범위 시작(Unix 밀리초). |
| `end` | integer or null | 실제 범위 끝(Unix 밀리초). |
| `tomatoes` | integer | 획득 토마토 통계. |
| `pomodoroMinutes` | integer | 집중 시간(분). |
| `focusCount` | integer | 집중 세션 수. |
| `tasksCompleted` | integer | 완료율 통계에 사용되는 완료된 할 일 수. |
| `tasksTotal` | integer | 해당 통계에 사용되는 전체 할 일 수. |
| `taskCompleteRate` | number | 완료율. |
| `feelingsCount` | integer | 감상 수. |
| `usingDays` | integer | 누적 사용 일수. |
| `companionDays` | integer | 누적 동행 일수. |
| `interestChanged` | integer | 이자에 따른 코인 변화 통계. |
| `coinPurchaseConsumed` | integer | 구매에 사용된 코인 통계. |

## 앱 정보와 코인 잔액 :id=get-info

`GET /info`는 `Info`를 반환합니다. LifeUp Cloud는 앱·프로바이더 정보에 자신의 설치된 버전을 추가합니다. 매개변수는 없습니다.

```json
{"code":200,"message":"success","data":{"appVersion":1,"appVersionName":"example","apiVersion":1,"cloudVersion":1,"cloudVersionName":"example"}}
```

### Info :id=model-info

| 필드 | JSON 형식 | 의미 |
| --- | --- | --- |
| `appVersion` | integer | 설치된 LifeUp 버전 코드. |
| `appVersionName` | string | 설치된 LifeUp 버전 이름. |
| `apiVersion` | integer | LifeUp API 버전. |
| `cloudVersion` | integer | 설치된 LifeUp Cloud 버전 코드. |
| `cloudVersionName` | string | 설치된 LifeUp Cloud 버전 이름. |

### GET /coin :id=get-coin

ContentProvider를 통해 `lifeup://api/query?key=coin`을 호출하고 결과 객체를 반환합니다. 매개변수는 없고 null은 빈 객체가 됩니다. 형식화된 `CoinData` 응답이 아닌 프로바이더 정의 필드입니다. 성공 시 `value`(부호 있는 64비트 코인 잔액)와 `api_result: true`를 제공하며, 실패 시 아래 상태·오류 필드가 포함될 수 있습니다.

```json
{"code":200,"message":"success","data":{"value":50,"api_result":true}}
```

## URL Scheme API 호출 :id=invoke-api

[URL Scheme API 목록](/guide/api)에 메서드 이름·매개변수·결과가 정의되어 있습니다. HTTP 브리지는 전체 `lifeup://api/...` URL을 받습니다.

| 전송 방식 | 입력 | 실행 및 응답 |
| --- | --- | --- |
| `GET /api` | 반복 가능한 URL 인코딩 쿼리 `url` | 각 URL에 대해 순서대로 Android Activity를 시작하고 문자열 `success`를 반환합니다. URL이 없어도 성공합니다. |
| `POST /api` | JSON `RawQueryVo` | `urls`를 모두 먼저 처리한 다음 `url`이 있으면 처리하고 `success`를 반환합니다. 빈 객체도 성공합니다. |
| `GET /api/contentprovider` | 반복 가능한 URL 인코딩 쿼리 `url` | 프로바이더를 동기 호출하고 순서대로 `CallUrlResult[]`를 반환합니다. URL이 없으면 오류 래퍼(`No url found`)를 반환합니다. |
| `POST /api/contentprovider` | JSON `RawQueryVo` | 모든 `urls`를 먼저 호출한 뒤 `url`을 호출하고 `CallUrlResult[]`를 반환합니다. 빈 객체는 빈 배열을 반환합니다. |

JSON POST는 `Content-Type: application/json`을 지정하세요. GET 쿼리에 넣을 때는 URL 전체를 인코딩해 내부 `&`, `?`, `+`, 퍼센트 인코딩을 보존하세요. Activity 브리지 성공은 실행 요청 전달을 확인하며 LifeUp 동작 완료를 뜻하지 않습니다. ContentProvider는 LifeUp에서 Cloud 권한을 부여해야 하며 지원 여부는 메서드마다 다릅니다. 호출은 순차 실행되며 나중 호출이 실패해도 이전 효과는 되돌리지 않습니다.

```json
{"urls":["lifeup://api/query?key=coin"],"url":"lifeup://api/query?key=atm"}
```

Activity 브리지 응답:

```json
{"code":200,"message":"success","data":"success"}
```

프로바이더 브리지 응답(예시 결과):

```json
{"code":200,"message":"success","data":[{"url":"lifeup://api/query?key=coin","result":{"value":50,"api_result":true}},{"url":"lifeup://api/query?key=atm","result":{"value":100,"api_result":true}}]}
```

### RawQueryVo :id=model-raw-query

| 필드 | JSON 형식 | 의미 |
| --- | --- | --- |
| `url` | string or null | 선택적 단일 URL. |
| `urls` | string[] or null | 선택적 URL 목록. `url`보다 먼저 처리됩니다. |

### CallUrlResult :id=model-call-url-result

| 필드 | JSON 형식 | 의미 |
| --- | --- | --- |
| `url` | string | 제출한 URL. |
| `result` | object or null | 변환된 프로바이더 Bundle. null 자체로 HTTP 래퍼가 실패하지는 않습니다. |

Bundle 변환은 Int·Long·Double·String·Boolean과 중첩 Bundle을 보존합니다. 배열은 문자열 배열, 다른 형식은 `toString()` 문자열이 됩니다(Bundle의 null도 문자열 `"null"`). 외부 code가 200이어도 `result`의 메서드 실패 필드를 확인해야 합니다.

현재 LifeUp 처리기는 완료한 호출에 불리언 `api_result`를 추가합니다. 포착된 메서드 실패는 `api_result: false` 및 문자열 `error_code`·`error_message`를 반환합니다. 코드는 `missing_required_parameter`, `invalid_parameter`, `entity_not_found`, `invalid_format`, `unsupported_api`, `cancelled`, `internal_error` 등을 포함하며 메서드별 추가 코드도 가능합니다. 백업 복원 중에는 `api_result` 없이 `error_code: "503"`과 `error_message`를 반환할 수 있습니다. API 처리기가 없으면 이 변환 전에 예외가 발생해 외부 브리지 오류가 될 수 있습니다.

## 파일 읽기 및 업로드 :id=files-download

### GET /files/{url} :id=files-get

읽기 가능한 URI 전체를 URL 인코딩한 단일 경로 요소로 전달합니다. Android 콘텐츠 리졸버로 아이콘·감상 첨부·내보낸 백업·업로드 파일 등의 바이트를 읽습니다. 결과는 JSON 성공 래퍼가 아닌 바이트 스트림이며 파일명이나 MIME 형식을 지정하지 않습니다. 비어 있거나 읽을 수 없는 스트림은 구조화된 찾을 수 없음 결과로 변환하지 않고, 예외는 공통 HTTP 500 처리기가 처리합니다. 일치한 매개변수가 공백이면 오류(`url is required`)입니다.

```bash
curl "$BASE/files/content%3A%2F%2Fexample.provider%2Fimages%2F1" -o image.bin
```

### POST /files/upload :id=files-upload

`multipart/form-data`를 전송합니다. 필드명과 관계없이 모든 파일 부분을 받으며 다른 부분은 무시합니다. 캐시 파일에는 원래 파일명을 사용하고 없으면 `uploaded_image_<time>.jpg`를 사용합니다. 읽을 수 있는 content URI 문자열 배열을 반환합니다. 업로드는 후속 API용 URI만 제공하며 상품·할 일에 자동 첨부하지 않습니다. 파일이 없으면 `No files received` 오류입니다.

```bash
curl -X POST "$BASE/files/upload" -F 'file=@image.png'
```

```json
{"code":200,"message":"success","data":["content://example.fileprovider/cache/image.png"]}
```

## 백업 내보내기 및 가져오기 :id=files-backup

### GET /data/export :id=files-export

프로바이더를 통해 백업을 만듭니다. `withMedia` 기본값은 `true`이며, 지정 시 대소문자 구분 없는 `true`만 참이고 나머지는 거짓입니다. 변환한 Bundle에는 현재 `backup_file_uri`가 포함되며 `/files/{url}`로 다운로드합니다. GET이지만 내보내기 파일을 생성합니다. 프로바이더 API 상태·오류 필드도 확인해야 합니다. 빈 URI는 사용 가능한 파일을 만들지 못했다는 뜻이며 null 결과는 오류입니다.

```json
{"code":200,"message":"success","data":{"backup_file_uri":"content://example.provider/backup/LifeUpExportBackup.zip","api_result":true}}
```

### POST /data/import :id=files-import

백업 파일을 `multipart/form-data`로 전송합니다. 여러 파일이면 마지막 파일을 사용하며 필드명을 확인하지 않습니다. 기본 파일명은 `backup.lfbak`입니다. 선택적 `description`은 읽지만 효과는 없습니다. Cloud가 파일을 캐시하고 LifeUp 백업 화면을 시작합니다. 응답은 업로드·화면 시작을 확인하며 **복원 완료를 뜻하지 않습니다**. 파일이 없으면 `No file received`입니다.

```bash
curl -X POST "$BASE/data/import" -F 'file=@backup.lfbak'
```

```json
{"code":200,"message":"success","data":"File uploaded and BackupActivity launched"}
```

## 이벤트 :id=get-events

### GET /events :id=get-events-poll

`EventsPage`를 반환합니다. `after`는 해당 ID를 제외하는 이벤트 커서입니다(64비트 정수, 기본 0). `limit` 기본값은 50이며 1–200으로 제한하고 정수가 아니면 기본값을 사용합니다. 버퍼에서 `id > after`인 이벤트를 오래된 순서로 반환합니다. 메모리에 최대 200개를 보관하며 오래된 것은 버리고 프로세스 재시작 시 ID가 초기화됩니다. `latestId`는 전체 최신 ID이며 현재 페이지의 마지막 ID와 다를 수 있습니다. 누적 이벤트를 건너뛰지 않도록 실제 처리한 마지막 이벤트부터 이어가세요. 영구 기록이나 전달 확인은 없습니다.

```json
{"code":200,"message":"success","data":{"latestId":2,"eventWs":true,"events":[{"id":1,"time":1700000000000,"action":"app.lifeup.task.complete","extras":{"id":"42"}}],"broadcasts":true}}
```

### EventsPage :id=model-events-page

| 필드 | JSON 형식 | 의미 |
| --- | --- | --- |
| `latestId` | integer | 현재 최신 이벤트 ID. |
| `eventWs` | boolean | Cloud의 WebSocket 설정. |
| `events` | CloudEvent[] | 커서 이후 보관된 이벤트. |
| `broadcasts` | boolean or null | LifeUp 브로드캐스트 활성화 여부. null은 알 수 없거나 미지원입니다. 조회 상태는 5초간 캐시됩니다. |

### CloudEvent :id=model-cloud-event

| 필드 | JSON 형식 | 의미 |
| --- | --- | --- |
| `id` | integer | 메모리 내 이벤트 일련번호. |
| `time` | integer | Cloud 수신 시각(Unix 밀리초). |
| `action` | string | Android 브로드캐스트 액션. |
| `extras` | 문자열 값을 가진 객체 | 브로드캐스트 추가 데이터를 `toString()`으로 변환합니다. null은 빈 문자열이 됩니다. 키는 액션에 따라 다릅니다. |

### WebSocket /events :id=get-events-websocket

`eventWs`가 true이면 설정된 토큰과 함께 `ws://HOST:PORT/events?after=ID`에 연결합니다. 서버는 보관된 이벤트를 재전송한 뒤 실시간 이벤트를 개별 JSON `CloudEvent` 텍스트 프레임으로 보냅니다. HTTP 응답 래퍼는 **없습니다**. 재전송은 메모리의 200개 이벤트로 제한되며 WebSocket `limit` 매개변수는 없습니다. 30초마다 Ping을 보내며 재연결에는 실제 처리한 마지막 ID를 쓰세요. 비활성화 시 경로가 등록되지 않지만 HTTP 폴링은 가능합니다.

```json
{"id":2,"time":1700000001000,"action":"app.lifeup.item.use","extras":{"id":"3"}}
```

지원하는 액션 구독: `app.lifeup.task.complete`, `app.lifeup.task.overdue`, `app.lifeup.task.giveup`, `app.lifeup.achievement.unlock`, `app.lifeup.achievement.condition.unlock`, `app.lifeup.item.purchase`, `app.lifeup.item.reward`, `app.lifeup.item.use`, `app.lifeup.synthesis.complete`, `app.lifeup.pomodoro.start`, `app.lifeup.pomodoro.pause`, `app.lifeup.pomodoro.complete`, `app.lifeup.pomodoro.stop`, `app.lifeup.feelings.add`, `app.lifeup.level.up`, `app.lifeup.level.down`, `app.lifeup.item.countdown.start`, `app.lifeup.item.countdown.complete`, `app.lifeup.item.countdown.stop`, `app.lifeup.timing.start`, `app.lifeup.timing.complete`, `app.lifeup.timing.pause`, `app.lifeup.timing.abandon`. 이벤트 수집에는 LifeUp 브로드캐스트 활성화가 필요합니다. `/events` 폴링은 설정만 확인하며 자동으로 켜지 않습니다.
