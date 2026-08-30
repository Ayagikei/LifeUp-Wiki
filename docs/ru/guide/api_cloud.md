<h1 align="center" padding="100">LifeUp Cloud ☁️</h1>

<p align="center">
 <img src="guide/_media/api/cloud.png" />
</p>

> [!NOTE]
> Мы постепенно выпускаем **LifeUp v1.106.0** и **LifeUp Cloud v3.0.0**. Сроки проверки на разных платформах различаются, поэтому документация может быть обновлена до широкой доступности приложений; фактическая дата выхода может быть позже указанной здесь.

LifeUp Cloud — один из ключевых API-инструментов LifeUp. Он превращает телефон в **API-мост**: управляйте LifeUp с **компьютера или других устройств**, создавайте **собственные интеграции** (десктоп, веб, скрипты автоматизации) или подключайте **AI-агентов**.

### Типичные сценарии

| Сценарий | Для кого | В двух словах | Подробнее |
| --- | --- | --- | --- |
| **HTTP + своими руками** | Разработчики, автоматизация | Вызывайте API и запрашивайте данные из Python, веб-приложений или скриптов по LAN — опыт Android не нужен | [HTTP API](#http-api-definition), [Desktop](guide/api_desktop.md) |
| **Сканирование QR** | Любители чек-ина в реальном мире | Печатайте QR-коды для выполнения задач, запуска таймеров, открытия диалогов или веб-страниц / других приложений | [Сканирование QR-кодов](#qr-code-scanning) |
| **Ярлыки запуска / остановки** | Автоматизация, NFC, Tasker | `lifeupcloud://start` и `lifeupcloud://stop` открывают Cloud и запускают или останавливают HTTP-сервер | [Запуск и остановка](#cloud-scheme) |
| **AI Agent + MCP** | Cursor, Claude и т. д. | Один промпт — списки задач, предметы в магазине, достижения и многое другое | [MCP & Skills](guide/api_mcp.md) |
> **Пример AI-промпта:** Удалите примеры задач и предметов магазина, затем создайте полную настройку indie game developer: списки задач, атрибуты, предметы магазина и достижения.

<br/>

## Загрузка

- Если вы используете версию с подпиской для материкового Китая, загрузку LifeUp Cloud можно найти в `Sidebar` → `Settings` → `Experiments`.
- [Google Play Store](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http)

<br/>


## Запуск и остановка службы Cloud :id=cloud-scheme

HTTP-сервер можно запустить или остановить без нажатия **Start Service** — через эти URL-схемы:

```txt
lifeupcloud://start
lifeupcloud://stop
```

Открытие любого из URL запускает LifeUp Cloud и выполняет действие. Используйте их как ярлык на главном экране, NFC-метку, действие Tasker/автоматизации или:

```txt
adb shell am start -a android.intent.action.VIEW -d lifeupcloud://start
```

Те же URL указаны на карточке статуса Cloud — нажмите, чтобы скопировать.

> [!NOTE]
> `lifeupcloud://` управляет самим HTTP-сервером Cloud. Это не игровой API `lifeup://api/…`.

<br/>

## Сканирование QR-кодов :id=qr-code-scanning

Кнопка **Scan** вверху LifeUp Cloud считывает URL из QR-кода и сразу открывает его — без ручного ввода.

Сканирование **не ограничено API LifeUp**: работают `lifeup://api/…`, веб-страницы `https://…` и URL-схемы других приложений (например, `weixin://`) — Android открывает нужную цель.

### Как использовать

1. Выберите URL в LifeUp или в wiki-[списке API](guide/api.md) (выполнить задачу, запустить помодоро, открыть диалог покупки/использования или внешнюю веб-страницу).

2. Сгенерируйте QR-код из полного URL (распечатайте и приклейте на стол, стену или устройство).

3. Откройте LifeUp Cloud, нажмите **Scan** (**?** рядом — краткая справка в App), наведите на код.

### Что можно делать

| Сценарий | Пример (иллюстративный) |
| --- | --- |
| Чек-ин Pomodoro | `lifeup://api/pomodoro?...` запуск/остановка таймера |
| Чек-ин задачи | `lifeup://api/complete?name=...` выполнить задачу |
| Взаимодействие с магазином | `lifeup://api/goto?page=shop` или диалоги покупки/использования |
| Награда / штраф | `lifeup://api/reward?...` / `lifeup://api/penalty?...` |
| Веб-мини-игра | `https://wiki.lifeupapp.fun/en/example/wordle/index.html` |
| Другие приложения | `weixin://`, `intent://` или схема любого установленного приложения |
| Свои сценарии | Любая сканируемая комбинация URL |

### Взаимодействие в реальном мире

QR-коды связывают **физические места или действия** с геймификацией в App:

- Наклейка на **тренажёре** → сканирование для выполнения силовой задачи

- Наклейка на **учебном столе** → сканирование для запуска фокус-помодоро

- Наклейка на **рабочем месте** → сканирование для фиксации stand-up или code review

- Наклейка на **доске событий** → сканирование для получения награды или открытия достижения

Короче: **превратите URL Schemes в сканируемые физические триггеры**, а LifeUp Cloud — исполнитель между App и реальным миром.

<br/>

> [!NOTE]
> LifeUp Cloud — HTTP-мост только в LAN. Как достичь телефона — IP-адрес, роутер, файрвол, одна подсеть, VPN или изоляция AP — зависит от вашей домашней сети. Если подключиться не удаётся, мы не можем отладить ваш личный LAN. Проверьте сеть сами, используйте стандартные сетевые инструменты или попросите помощи у AI-агента.

## Описание HTTP API :id=http-api-definition

> [!WARNING]
> Документация API на этой странице может отставать от реализации. Окончательный источник — исходный код: [KtorService.kt](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt)

### 1. API вызова URL Scheme

#### GET

Функция:

> Вызывает API, начинающиеся с `lifeup://api`.

URL запроса:

```txt
// Рекомендуется: режим content provider (лучшая совместимость)
http://{host:port}/api/contentprovider

// режим startActivity (на некоторых устройствах блокируется UI в фоне)
http://{host:port}/api
```

**Method: `GET`**

**Query-параметры:**

| Поле | Описание | Расположение | Тип | Обязательно | Примечания |
| --- | --- | --- | --- | --- | --- |
| url | URL API, начинающийся с `lifeup://api` | Query | string | Да | При ручной сборке URL-кодируйте. Поддерживается несколько параметров `url`. |

**Примеры запросов:**

```txt
// Одиночный вызов (content provider)
http://{host:port}/api/contentprovider?url=YOUR_ENCODED_API_URL

// Пакетный вызов
http://{host:port}/api/contentprovider?url=YOUR_ENCODED_API_URL_1&url=YOUR_ENCODED_API_URL_2

// Одиночный вызов (startActivity)
http://{host:port}/api?url=YOUR_ENCODED_API_URL
```

<br/>

#### POST

Функция:

> Вызывает API, начинающиеся с `lifeup://api`.

URL запроса:

```txt
// Рекомендуется: режим content provider (лучшая совместимость)
http://{host:port}/api/contentprovider

// режим startActivity (на некоторых устройствах блокируется UI в фоне)
http://{host:port}/api
```

**Method: `POST`**

**Параметры JSON body:**

| Поле | Описание | Расположение | Тип | Обязательно | Примечания |
| --- | --- | --- | --- | --- | --- |
| urls | Массив URL, начинающихся с `lifeup://api` | Body | List<string> | Да | В JSON body дополнительное URL-кодирование не нужно. |

**Пример запроса:**

```txt
// POST
http://{host:port}/api/contentprovider

// JSON body
{
  "urls": ["lifeup://api/goto?page=lab"]
}
```

<br/>

### 2. API запроса данных

> [!NOTE]
> Требования:
> 1. LifeUp v1.91+ и актуальный LifeUp Cloud.
> 2. Выдайте разрешение **Read LifeUp Data** в LifeUp Cloud.

Функция:

> Запрашивает полные наборы данных LifeUp, например задачи и предметы.

**Эндпоинты задач**

```txt
// Все задачи
http://{host:port}/tasks

// Задачи в категории/списке ${id}
http://{host:port}/tasks/${id}

// История (с пагинацией)
// gid необязателен — фильтрует всю историю повторяющейся задачи
http://{host:port}/history?offset=${offset}&limit=${limit}&gid=${gid}

// Категории задач
http://{host:port}/tasks_categories
```

**Эндпоинты предметов**

```txt
// Все предметы
http://{host:port}/items

// Предметы в категории/списке ${id}
http://{host:port}/items/${id}

// Категории предметов
http://{host:port}/items_categories

// Включая скрытые списки
http://{host:port}/items_categories?include_hidden=true
```

**Эндпоинты достижений**

```txt
// Все достижения
http://{host:port}/achievements

// Достижения в категории/списке ${id}
http://{host:port}/achievements/${id}

// Категории достижений
http://{host:port}/achievement_categories
```

**Эндпоинты чувств**

```txt
// Все чувства (с пагинацией)
http://{host:port}/feelings?offset=${offset}&limit=${limit}
```

**Эндпоинты категорий синтеза**

```txt
// Все категории синтеза
http://{host:port}/synthesis_categories

// Категории синтеза в списке ${id}
http://{host:port}/synthesis_categories/${id}
```

**Эндпоинты рецептов синтеза**

```txt
// Все рецепты синтеза
http://{host:port}/synthesis

// Рецепты синтеза в категории ${id}
http://{host:port}/synthesis/${id}
```

**Эндпоинты атрибутов**

```txt
// Все атрибуты
http://{host:port}/skills
```


**Прочее**

```txt
// Баланс монет
http://{host:port}/coin

// Версии LifeUp / Cloud
http://{host:port}/info

// Записи Pomodoro (с пагинацией; необязательный диапазон времени)
http://{host:port}/pomodoro_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}

// Журналы (с пагинацией; необязательный диапазон времени). Мягко удалённые строки пропускаются.
http://{host:port}/coin_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/inventory_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/exp_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/step_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/level_defines
http://{host:port}/statistics?time_range_start=${ms}&time_range_end=${ms}
// Все достижения (реализовано; id категории необязателен)
http://{host:port}/achievements

// События broadcast. LifeUp Labs → Broadcast events по умолчанию выключено; Cloud Advanced может показать статус и включить. GET data.broadcasts — это переключатель (пропускается, если не прочитано). Настройка WebSocket Cloud — только транспорт.
http://{host:port}/events?after=${id}&limit=50

// WebSocket push (по умолчанию включён; настройка Cloud WebSocket event push)
ws://{host:port}/events?after=${id}
```

Обёртка: `{ code, message, data }`. `200` — только успех транспорта. `10001` LifeUp не запущен или Read Data не выдано. `10002` сбой запроса ContentProvider.

### Значения полей списков

| Эндпоинт | Поле | Значения |
| --- | --- | --- |
| `/tasks` `/history` | `status` | `0` не завершено · `1` выполнено · `2` просрочено · `3` отказ |
| `/tasks` | `frequency` | `0` один раз · `1` ежедневно · `N>1` каждые N дней · `-1` без ограничений · `-3` Ebbinghaus · `-4` ежемесячно · `-5` ежегодно |
| `/tasks` | `weekdays` | `1,3,5` (Пн=1 … Вс=7). Пусто вне режима по дням недели. v1.106.0+ |
| `/tasks_categories` | `status` | `0` обычный · `1` в архиве |
| `/tasks_categories` | `type` | `<10` обычный · `10` ежедневный · `11` еженедельный · `12` ежемесячный · `20` в процессе |
| `/achievements` | `status` | `0` заблокировано · `1` разблокировано, награда не получена · `2` разблокировано, получено |
| `/achievements` | `type` | `0` обычный · `1` подкатегория |
| `/achievement_categories` | `type` | `0` пользовательский · `1` системный |
| `/feelings` | `type` | `0` задача · `1` достижение · `2` сырое · `3` использование предмета |
| `/feelings` | `isFav` | bool (CP 0/1) |
| `/skills` | `type` | `0` пользовательский · `1` сила · `2` обучение · `3` обаяние · `4` выносливость · `5` жизненная сила · `6` креативность |
| `/items_categories` | `hidden` / `inventoryHidden` | `0` видимый · `1` скрытый (независимые флаги) |
| `/synthesis_categories` | `hidden` | `0` видимый · `1` скрытый |
| `/pomodoro_records` | `reward` | `0` прервано · `0.5×n` половина · иначе полный множитель |
| `/coin_records` `/inventory_records` | `resCode` | Магазин: `0` покупка · `1` использование · `2` выполнение задачи · `3` отмена выполнения · `4` очистка · `5` отказ · `6` просрочка · `7` разблокировка достижения · `8` отмена отказа · `9` отмена просрочки · `10` возврат · `11` выполнение подзадачи · `12` отмена подзадачи · `13` разблокировка пользовательского достижения · `14` отмена пользовательского достижения · `15` депозит · `16` снятие · `17` продажа помидоров · `20` награда предметом · `21` отмена награды предметом · `23` синтез · `24` лутбокс · `25` проценты ATM · `26` обмен помидоров · `27` проценты по кредиту · `28` API · `29` эффект запаса |
| `/exp_records` | `resCode` | Очки опыта (не магазин `28`): `0` неизвестно · `1` выполнение · `2` достижение · `3` обмен лайков · `4` серия дней · `5` шаги · `6` пометить выполненным · `7` отмена отказа · `8` отмена просрочки · `9` съесть помидор · `10` использован предмет · `11` разблокировка пользовательского достижения · `12` выполнение подзадачи · `200` API · `101` отмена выполнения · `102` отказ · `103` просрочка · `104` списание за использование предмета · `105` блокировка пользовательского достижения · `106` отмена подзадачи |

`GET /items_categories`, `GET /synthesis_categories` и `GET /skill_groups` принимают `include_hidden=true` (скрытые списки по умолчанию пропускаются). Условия разблокировки достижений: `GET /achievement_conditions/{id}`. `status` навыка (0 обычный / 1 скрытый) только в `query`/`query_skill`, **не** в `GET /skills`.

**Method: `GET`**

**Параметры:**

| Поле | Описание | Расположение | Тип | Обязательно | Примечания |
| --- | --- | --- | --- | --- | --- |
| id | ID данных | Path/Query | Number | Да (для эндпоинтов по ID) | - |
| offset | Смещение запроса | Query | Number | Нет | Только для некоторых эндпоинтов с пагинацией |
| limit | Размер страницы | Query | Number | Нет | Только для некоторых эндпоинтов с пагинацией |
| gid | Фильтр истории повторяющейся задачи | Query | Number | Нет | Необязательно для запроса истории |
| include_hidden | Включить скрытые списки | Query | Boolean | Нет | По умолчанию false. Для `/items_categories`, `/synthesis_categories`, `/skill_groups` |
| time_range_start | Начало диапазона (мс) | Query | Number | Нет* | Должен быть в паре с `time_range_end`. Частичный/неверный диапазон вернёт `invalid_parameter` |
| time_range_end | Конец диапазона (мс) | Query | Number | Нет* | Должен быть больше `time_range_start` |

**Примеры запросов**

**Задачи**

```txt
// Все задачи
http://{host:port}/tasks

// Задачи в списке ID 1
http://{host:port}/tasks/1

// История (100 записей с индекса 0)
http://{host:port}/history?offset=0&limit=100

// Категории задач
http://{host:port}/tasks_categories
```

**Предметы**

```txt
// Все предметы
http://{host:port}/items

// Запрос предметов с ID 1 и 4
http://{host:port}/items?id=1&id=4

// Предметы в списке ID 1
http://{host:port}/items/1

// Категории предметов
http://{host:port}/items_categories
```

**Достижения**

```txt
// Достижения в списке/категории ${id}
http://{host:port}/achievements/${id}

// Категории достижений
http://{host:port}/achievement_categories
```

**Чувства**

```txt
// 100 записей с индекса 0
http://{host:port}/feelings?offset=0&limit=100
```

**Атрибуты**

```txt
http://{host:port}/skills
```

**Категории синтеза**

```txt
http://{host:port}/synthesis_categories
http://{host:port}/synthesis_categories/1
```

**Рецепты синтеза**

```txt
http://{host:port}/synthesis
http://{host:port}/synthesis/1
```

<br/>

### 3. API изображений/файлов

> [!NOTE]
> Из-за ограничений хранилища Android LifeUp Cloud при отдаче изображений из LifeUp может создавать копию файла.

Функция:

> Загружает ресурсы изображений/файлов, возвращаемые API данных (обычно `content://...`).

URL запроса:

```txt
http://{host:port}/files/${url}
```

**Method: `GET`**

**Path-параметры:**

| Поле | Описание | Расположение | Тип | Обязательно | Примечания |
| --- | --- | --- | --- | --- | --- |
| url | URL файла | Path | String | Да | - |

**Пример запроса:**

```txt
http://{host:port}/files/xxx
```

<br/>

### 4. Запросы ContentProvider навыков

> [!NOTE]
> Требуется v1.103.0+

Для списковых или структурированных запросов можно читать следующие URI ContentProvider через эндпоинт `http://{host:port}/api/contentprovider`.

#### `content://net.sarasarasa.lifeup.provider.api/skills`

Возвращает только видимые навыки.

| Столбец | Значение | Тип | Примечания |
| ------ | ------- | ---- | ----- |
| _ID | ID навыка | number | - |
| name | Имя навыка | string | - |
| desc | Описание | string | Может быть пустым |
| icon | URI иконки | string | Может быть пустым |
| order | Исходный порядок сортировки | number | `orderInCategory` |
| group_id | ID группы навыков | number / null | Пусто, если навык не в группе |
| color | Цвет | number / null | Может быть пустым |
| exp | Очки опыта | number | - |
| level | Текущий уровень | number | - |
| until_next_level_exp | Очки опыта до следующего уровня | number | - |
| current_level_exp | Очки опыта на текущем уровне | number | - |
| type | Тип навыка | number | - |
| status | Статус навыка | number | `0` = обычный, `1` = скрытый |

#### `content://net.sarasarasa.lifeup.provider.api/skill_groups`

Возвращает только видимые группы навыков.

| Столбец | Значение | Тип | Примечания |
| ------ | ------- | ---- | ----- |
| _ID | ID группы навыков | number | - |
| content | Имя группы | string | - |
| order | Исходный порядок сортировки | number | `orderInCategory` |
| collapsed | Состояние свёрнутости | string | Возвращается как текст `true` / `false` |

<br/>

## Участие в разработке

SDK, LifeUp Cloud и LifeUp Desktop — проекты с открытым исходным кодом.

Исходный код:

- [Ayagikei/LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop](https://github.com/Ayagikei/LifeUp-Desktop)
