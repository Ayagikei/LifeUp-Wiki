<h1 align="center" padding="100">로컬 네트워크(API) 데스크톱 클라이언트 🖥</h1>

<p align="center">
 <img src="guide/_media/api/desktop.png" />
</p>

LifeUp API를 기반으로 가벼운 데스크톱 클라이언트를 만들었습니다. Windows, Linux, macOS를 지원합니다.

**독립 App이 아닙니다.** API 접근을 통해 휴대폰의 LifeUp 오프라인 데이터를 읽습니다.

<br/>

## 기능

> [!NOTE]
> 현재 버전은 주로 API 기능의 기술 미리보기입니다. 핵심 탐색 작업에 초점을 맞추며 App 내 모든 기능을 다루지는 않습니다.

- 완전 오픈 소스. UI를 커스터마이즈하고 자신만의 기능을 구현할 수 있습니다.
- 현재 기본 기능:
  - 작업 목록 조회 및 작업 완료
  - 속성 목록 및 레벨 조회
  - 아이템 목록 조회 및 아이템 구매
  - 감정 조회 및 데스크톱에서 원본 크기 이미지 보기
  - 감정을 Markdown 파일로 내보내기
  - 작업 추가(App 내 모든 옵션은 아직 지원되지 않음)

<br/>

## 다운로드

모든 데스크톱 패키지는 [LifeUp Desktop Releases](https://github.com/Ayagikei/LifeUp-Desktop/releases)에 게시됩니다.

> [!WARNING]
> 데스크톱을 사용하기 전에 LifeUp Cloud가 v2.0.0 이상인지 확인하세요.<br/>
> GitHub Releases 빌드를 사용하는 경우 `Settings` → `Labs`에서 LifeUp Cloud를 업데이트하세요.<br/>
> Google Play 빌드를 사용하는 경우 [Google Play](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http) 또는 [LifeUp SDK Releases](https://github.com/Ayagikei/LifeUp-SDK/releases/latest)에서 업데이트할 수 있습니다.<br/>
> 일부 브라우저는 보안 정책으로 인해 설치 파일 다운로드를 차단할 수 있습니다. **유지/허용**(브라우저마다 표현이 다름)을 선택하거나 다른 다운로더를 사용하세요.

### 설치 플랫폼

<!-- tabs:start -->

#### **Windows**

- `LifeUp Desktop.msi`

> [!TIP]
> **Windows SmartScreen**<br/>
> MSI는 현재 EV 서명되지 않아 Windows에서 "인식할 수 없는 App" 경고가 표시될 수 있습니다.<br/>
> 공식 GitHub 릴리스 파일임을 확인한 뒤 **자세한 정보 → 실행**을 클릭하세요.

#### **Linux**

- [LifeUp Desktop Releases](https://github.com/Ayagikei/LifeUp-Desktop/releases)에서 `lifeup-desktop.deb`를 다운로드해 사용하세요.

#### **macOS**

- Intel / x64: `LifeUp-Desktop-x64.dmg`
- Apple Silicon / ARM64: `LifeUp-Desktop-arm64.dmg`
- macOS 빌드는 아직 충분히 테스트되지 않았으며 **Auto Connect** 같은 일부 기능을 사용할 수 없을 수 있습니다.

> [!TIP]
> **macOS Gatekeeper / 서명**<br/>
> 현재 macOS 빌드는 공증(notarized)되지 않았습니다. "확인되지 않은 개발자" 경고가 표시될 수 있습니다.<br/>
> `.dmg`를 열고 App을 Applications로 옮긴 뒤 App을 우클릭하여 **열기**를 선택하거나,<br/>
> **시스템 설정 → 개인 정보 보호 및 보안**에서 **그래도 열기**를 클릭하세요.<br/>
> 자세한 내용은 [Apple 공식 가이드](https://support.apple.com/en-hk/guide/mac-help/mh40616/mac)를 참고하세요.

<!-- tabs:end -->

패키지가 일시적으로 없으면 나중에 새로고침하세요. 릴리스 자산이 아직 업로드 중일 수 있습니다.

<br/>

## 사용 방법

### 최초 설정

#### 사전 요구 사항

- 휴대폰과 데스크톱이 같은 LAN에 있어야 합니다(예: 같은 Wi-Fi).
- <del>네트워크가 복잡하면 먼저 데스크톱에서 휴대폰 IP로 ping이 되는지 테스트하세요.</del>
  - 새 데스크톱 버전은 휴대폰 IP 자동 감지를 지원하므로 종종 불필요합니다.

#### 휴대폰에서

1. LifeUp을 최신 버전으로 업데이트하세요.
2. LifeUp에서 `Settings` → `Labs`를 연 뒤 **LifeUp Cloud**를 설치하세요.
3. LifeUp Cloud를 열고 필요한 권한을 부여하세요:
   - 플로팅 창 / 다른 App 위에 표시 권한
   - LifeUp 데이터 읽기 권한
4. LifeUp Cloud에서 **Start Service**를 탭하세요.

**권장 추가 설정**

- LifeUp과 LifeUp Cloud 모두 호환성 설정을 하고 배터리 최적화를 비활성화해 백그라운드 종료 문제를 줄이세요.
- MIUI(Xiaomi/Redmi)를 사용하는 경우 두 App 모두 **Display UI in background**를 허용하세요.
- LifeUp과 LifeUp Cloud를 모두 실행 상태로 유지하세요.

#### 데스크톱에서

1. 릴리스 패키지에서 데스크톱 App을 설치하세요.
2. 데스크톱 설정에서 LifeUp Cloud에 표시된 서비스 IP를 입력하세요.
   - 데스크톱 v1.1.0+에서는 **Auto Connect**를 시도할 수 있습니다.
3. 모든 설정이 올바르면 데스크톱에서 LifeUp 데이터를 볼 수 있어야 합니다.
   - 실패하면 위 추가 설정을 다시 확인하세요.

### 이후 사용

1. 휴대폰에서 LifeUp과 LifeUp Cloud를 엽니다.
2. LifeUp Cloud에서 **Start Service**를 탭합니다.
3. 데스크톱 클라이언트를 실행합니다.

<br/>

## FAQ

<details>
<summary>데스크톱에서 작업을 추가할 수 있나요?</summary>

네. 현재 데스크톱 빌드는 기본 작업 생성을 지원합니다.

다만 App 내 고급 작업 옵션은 아직 데스크톱에서 모두 제공되지 않습니다. 복잡한 설정은 모바일 App을 사용하거나 LifeUp Cloud API를 호출하세요.

</details>

<details>
<summary>LifeUp Cloud에서 "Request LifeUp Permission"을 눌렀는데 아무 일도 없거나 API not found가 뜹니다.</summary>

1. 아무 일도 없으면 이미 권한을 부여했을 수 있습니다.
2. API not found가 표시되면 멤버 베타에 참여하고 LifeUp을 최신 베타 버전으로 업데이트하세요.

</details>

<details>
<summary>휴대폰을 잠근 뒤 한동안 지나면 데스크톱에서 더 이상 데이터를 읽을 수 없습니다.</summary>

LifeUp과 LifeUp Cloud 모두 호환성 설정을 하세요.

</details>

<details>
<summary>LifeUp과 LifeUp Cloud가 백그라운드에 있을 때 일부 API 실행이 실패합니다.</summary>

> 이 문제는 기본 데스크톱 사용에는 보통 영향을 주지 않지만, 커스텀 API 호출에는 영향을 줄 수 있습니다.

LifeUp Cloud에 플로팅 창/다른 App 위에 표시 권한이 있는지 확인하세요.

MIUI(Xiaomi/Redmi)를 사용하는 경우 두 App 모두 **Display UI in background** 권한도 활성화하세요.

</details>

<details>
<summary>Windows 설치 시 `Failed to launch JVM` 오류가 납니다.</summary>

참고: [Issue #2](https://github.com/Ayagikei/LifeUp-Desktop/issues/2)

로컬 JVM 접근성 설정과 관련된 경우가 많습니다.

일반적인 해결 방법은 `~/.accessibility.properties`에서 다음 줄을 주석 처리하는 것입니다:

```txt
# assistive_technologies=com.sun.java.accessibility.AccessBridge
# screen_magnifier_present=true
```

편집 후 App을 다시 시작하고 테스트하세요.

> `~`는 사용자 홈 디렉터리를 의미합니다.

</details>

<br/>

## 기여

SDK, LifeUp Cloud, LifeUp Desktop은 모두 오픈 소스입니다.

소스 코드:

- [Ayagikei/LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop](https://github.com/Ayagikei/LifeUp-Desktop)
