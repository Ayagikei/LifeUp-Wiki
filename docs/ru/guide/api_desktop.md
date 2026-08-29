<h1 align="center" padding="100">Local Network (API) Desktop Client 🖥</h1>

<p align="center">
 <img src="guide/_media/api/desktop.png" />
</p>

Мы создали лёгкий десктопный клиент для LifeUp на основе API LifeUp. Поддерживаются Windows, Linux и macOS.

**Это не автономное приложение.** Оно читает офлайн-данные LifeUp с телефона через API.

<br/>

## Возможности

> [!NOTE]
> Текущая версия в основном технический предпросмотр возможностей API. Она сосредоточена на базовом просмотре и не покрывает каждую функцию в App.

- Полностью открытый исходный код. Можно настраивать UI и реализовывать свои функции.
- Текущие базовые возможности:
  - Запрос списка задач и выполнение задач
  - Запрос списка атрибутов и уровней
  - Запрос списка предметов и покупка предметов
  - Запрос чувств и просмотр изображений в полном размере на десктопе
  - Экспорт чувств в файлы Markdown
  - Добавление задач (ещё не все опции из App)

<br/>

## Загрузка

Все десктопные пакеты публикуются на [LifeUp Desktop Releases](https://github.com/Ayagikei/LifeUp-Desktop/releases).

> [!WARNING]
> Перед использованием десктопа убедитесь, что LifeUp Cloud v2.0.0 или выше.<br/>
> При сборке из GitHub Releases обновите LifeUp Cloud в `Settings` → `Labs`.<br/>
> При сборке из Google Play можно обновить через [Google Play](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http) или [LifeUp SDK Releases](https://github.com/Ayagikei/LifeUp-SDK/releases/latest).<br/>
> Некоторые браузеры блокируют загрузку установщиков из соображений безопасности. Выберите **Keep/Allow** (формулировка зависит от браузера) или используйте другой загрузчик.

### Платформы установки

<!-- tabs:start -->

#### **Windows**

- `LifeUp Desktop.msi`

> [!TIP]
> **Windows SmartScreen**<br/>
> MSI пока не подписан EV, поэтому Windows может показать предупреждение «неопознанное приложение».<br/>
> Убедившись, что файл с официального GitHub release, нажмите **More info → Run anyway**.

#### **Linux**

- Скачайте с [LifeUp Desktop Releases](https://github.com/Ayagikei/LifeUp-Desktop/releases) и используйте `lifeup-desktop.deb`.

#### **macOS**

- Intel / x64: `LifeUp-Desktop-x64.dmg`
- Apple Silicon / ARM64: `LifeUp-Desktop-arm64.dmg`
- Сборки macOS ещё не полностью протестированы; некоторые функции вроде **Auto Connect** могут быть недоступны.

> [!TIP]
> **macOS Gatekeeper / подпись**<br/>
> Текущие сборки macOS не нотаризованы. Может появиться предупреждение «unidentified developer».<br/>
> Откройте `.dmg`, перенесите App в Applications, затем правый клик по App → **Open**,<br/>
> или перейдите в **System Settings → Privacy & Security** и нажмите **Open Anyway**.<br/>
> Подробнее — в [официальном руководстве Apple](https://support.apple.com/en-hk/guide/mac-help/mh40616/mac).

<!-- tabs:end -->

Если пакет временно отсутствует, обновите страницу позже. Файлы release могут ещё загружаться.

<br/>

## Использование

### Первоначальная настройка

#### Предварительные условия

- Телефон и десктоп должны быть в одной LAN (например, одна Wi-Fi).
- <del>Если сеть сложная, сначала проверьте, может ли десктоп пинговать IP телефона.</del>
  - В новых версиях десктопа есть автоматическое определение IP телефона — часто это уже не нужно.

#### На телефоне

1. Обновите LifeUp до последней версии.
2. В LifeUp откройте `Settings` → `Labs` и установите **LifeUp Cloud**.
3. Откройте LifeUp Cloud и выдайте необходимые разрешения:
   - Плавающее окно / отображение поверх других приложений
   - Чтение данных LifeUp
4. Нажмите **Start Service** в LifeUp Cloud.

**Рекомендуемая дополнительная настройка**

- Настройка совместимости для LifeUp и LifeUp Cloud; отключите оптимизацию батареи, чтобы реже убивали процесс в фоне.
- На MIUI (Xiaomi/Redmi) разрешите **Display UI in background** для обоих приложений.
- Держите LifeUp и LifeUp Cloud запущенными.

#### На десктопе

1. Установите десктопное приложение из release-пакета.
2. В настройках десктопа введите IP службы из LifeUp Cloud.
   - В десктопе v1.1.0+ можно попробовать **Auto Connect**.
3. При правильной настройке вы должны видеть данные LifeUp на десктопе.
   - При сбое проверьте дополнительную настройку выше.

### Повторное использование

1. Откройте LifeUp и LifeUp Cloud на телефоне.
2. Нажмите **Start Service** в LifeUp Cloud.
3. Запустите десктопный клиент.

<br/>

## FAQ

<details>
<summary>Можно ли добавлять задачи с десктопа?</summary>

Да. Текущая сборка десктопа поддерживает базовое создание задач.

Однако не все расширенные опции задач из App пока доступны на десктопе. Для сложных настроек используйте мобильное приложение или вызывайте API через LifeUp Cloud.

</details>

<details>
<summary>Нажал «Request LifeUp Permission» в LifeUp Cloud, но ничего не произошло / API not found.</summary>

1. Если ничего не произошло, разрешение, возможно, уже выдано.
2. При «API not found» вступите в member beta и обновите LifeUp до последней beta.

</details>

<details>
<summary>После блокировки телефона на время десктоп перестаёт читать данные.</summary>

Выполните настройку совместимости для LifeUp и LifeUp Cloud.

</details>

<details>
<summary>Когда LifeUp и LifeUp Cloud в фоне, некоторые API не выполняются.</summary>

> Обычно это не мешает базовому использованию десктопа, но может затронуть пользовательские вызовы API.

Убедитесь, что у LifeUp Cloud есть разрешение на плавающее окно / отображение поверх других приложений.

На MIUI (Xiaomi/Redmi) также включите **Display UI in background** для обоих приложений.

</details>

<details>
<summary>Установка на Windows падает с `Failed to launch JVM`.</summary>

Ссылка: [Issue #2](https://github.com/Ayagikei/LifeUp-Desktop/issues/2)

Обычно это связано с локальной конфигурацией доступности JVM.

Частый обходной путь — закомментировать эти строки в `~/.accessibility.properties`:

```txt
# assistive_technologies=com.sun.java.accessibility.AccessBridge
# screen_magnifier_present=true
```

После правки перезапустите App и проверьте снова.

> `~` — домашний каталог пользователя.

</details>

<br/>

## Участие в разработке

SDK, LifeUp Cloud и LifeUp Desktop — проекты с открытым исходным кодом.

Исходный код:

- [Ayagikei/LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop](https://github.com/Ayagikei/LifeUp-Desktop)
