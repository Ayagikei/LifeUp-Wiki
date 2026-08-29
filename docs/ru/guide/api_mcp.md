<h1 align="center" padding="100">MCP & Skills</h1>

Хотите, чтобы AI работал с LifeUp? Есть два уровня:

| | Что делает | Кто использует |
|---|---|---|
| **MCP** `@lifeup/mcp` | Обнаруживает LifeUp Cloud, отправляет HTTP-запросы, кодирует параметры, разбирает ответы | Cursor, Claude Desktop, WorkBuddy и любой MCP-клиент |
| **Skills** `lifeup-cloud/` | Как подключиться, что запрашивать и как вызывать каждый API | Встроено в MCP как `help`; Claude Code / Pi могут также загрузить папку как skill с диска |

Агент на компьютере достигает LifeUp Cloud на телефоне по LAN и затем общается с LifeUp. Детали HTTP — в [LifeUp Cloud API](guide/api_cloud.md). Исходники MCP: [LifeUp-SDK/mcp](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp).

> [!NOTE]
> Требуется **LifeUp 1.106.0**+ и **LifeUp Cloud 3.0.0**+. Старые сборки могут подключаться, но журналы, статистика и кривая уровней неполные. `status.update` может предложить пользователю обновиться.

MCP даёт агенту **API чтения/записи**; слой AI добавляет **рассуждения** — приоритизацию сегодняшнего бэклога, сводку недельной статистики из журналов, проектирование задач по уровням атрибутов или **полную тематическую геймификацию одним промптом** (indie game dev, магическая академия и др.) — а не только сырые списки.

## Примеры запросов

После установки MCP не нужно запоминать API — просто говорите с AI.

**План на день**

- «Что осталось на сегодня? Отсортируй по приоритету и скажи, с чего начать.»
- «Выбери одну незавершённую задачу, которую я успею за ~25 минут.»

**Анализ данных**

- «Вытащи статистику Pomodoro, фокуса, монет и очков опыта за эту неделю — разбей по источникам и опиши закономерности.»
- «Откуда пришли монеты в этом месяце? Покажи крупнейшие источники и неожиданное.»

**Коучинг и проектирование**

- «Посмотри уровни моих атрибутов и спроектируй набор ежедневных задач для прокачки слабых навыков.»

**Тематическая настройка одним шагом**

- «Удали примеры и собери полную настройку indie game developer: списки, магазин, достижения и атрибуты.»
- «Спроектируй полную RPG-рутину магической академии — задачи, атрибуты, предметы магазина и достижения.»

**Рефлексия**

- «Посмотри, что я сегодня завершил, и напиши короткий журнал: что сделал и что улучшить завтра.»
- «Создай список достижений Morning Routine и добавь 8 достижений с emoji-иконками и наградами монетами.»
<br/>

## Быстрый старт

Отправьте агенту эту однострочную команду для установки MCP и первого подключения:

```
Follow this doc to install the LifeUp MCP server and complete the first connection: https://raw.githubusercontent.com/Ayagikei/LifeUp-Wiki/master/docs/en/guide/api_mcp.md
```

<br/>

## Skills

Файлы skill лежат в [`mcp/skills/lifeup-cloud/`](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp/skills/lifeup-cloud) (одна копия в репозитории — отдельного npm-пакета нет).

- **Cursor / Claude Desktop / WorkBuddy:** установите только MCP. `help` читает этот skill; не устанавливайте дважды.
- **Claude Code / Pi / свой workflow:** скопируйте папку в путь skills агента или укажите напрямую на репозиторий.

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

Агент читает документацию поэтапно:

1. `help` (или `SKILL.md` с диска) — общий workflow
2. `help api-index` — какие методы есть
3. `help add_task` — параметры одного метода
4. `call_api` / `list_data` — выполнить вызов

Для кастомизации: скопируйте папку и отредактируйте `SKILL.md` и `references/`. MCP `help` по-прежнему читает упакованную копию, пока вы не пересоберёте MCP из своего форка.

<br/>

## Настройка

1. Телефон и компьютер в одной LAN
2. LifeUp запущен, Cloud получил **Read LifeUp Data**
3. LifeUp Cloud запущен (порт по умолчанию `13276`)
4. На компьютере [Node.js 20+](https://nodejs.org/)

Токен необязателен. Если задан — отправляйте **сырой** токен в заголовке, не `Bearer`.

<br/>

## Установка MCP

Пока пакет не на npm, установка с GitHub:

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

`npx` клонирует репозиторий и собирает `mcp/`. После попадания в `main` уберите `#feat/mcp`.

Если [LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK) уже склонирован, используйте установщик (собирает MCP и обновляет обнаруженные клиенты; повторный запуск не регистрирует вторую копию):

```bash
./scripts/install-mcp.sh
```

Клиенты по умолчанию: Codex, Cursor, Claude Code, Claude Desktop, Pi. Конфиги Pi с `imports: ["codex"]` наследуют Codex и не дублируются.

GUI-приложения на macOS часто не видят `npx` в `PATH` — укажите абсолютный путь к `npx`/`node` или клонируйте и выполните `cd mcp && npm install && npm run build`.

| Переменная | Роль |
|---|---|
| `LIFEUP_HOST` | напр. `192.168.1.8:13276`, пропустить mDNS |
| `LIFEUP_TOKEN` | только в процессе, никогда на диск |
| `LIFEUP_MCP_CONFIG` | свой путь к конфигу |

После публикации: `npx -y @lifeup/mcp` (npmmirror в Китае).
<br/>

## Workflow агента :id=agent-workflow

1. `discover` — mDNS `_lifeup._tcp`; TXT `port` — HTTP-порт. Автоподключение, если найден ровно один экземпляр Cloud.
2. `connect` — передайте `host`, если экземпляров ноль или несколько.
3. `status` — проверьте версии; ниже 1.106.0 / 3.0.0 следите за `update`.
4. Списки: `list_data` (компактные поля по умолчанию).
5. Запись: `complete_task` / `add_task` / `reward` / `purchase_item`; всё остальное через `call_api`. С `via=launch` открывается UI App.

Деструктивные вызовы требуют `confirm: true`. Не кодируйте значения параметров заранее.

## События

LifeUp: включите Labs → Broadcast events (по умолчанию выкл.; Cloud Advanced может показать статус и включить). **WebSocket push событий Cloud включён по умолчанию** (3.0.0+) и это только транспорт.

- `list_events` — `GET /events`, всегда доступен
- `subscribe_events` — `WS /events`; ошибка, если переключатель Cloud выкл., HTTP работает

Подробности: MCP `help broadcasts`.

<br/>

---

## Пример: настройка indie game developer

Ниже результат реальной MCP-сессии: пользователь попросил AI **очистить встроенные developer-примеры LifeUp**, затем собрать полную RPG-настройку вокруг **indie game development** (списки задач, атрибуты, магазин, достижения).

Стартовые промпты, например:

> Clear the sample tasks and shop items, then create a full indie game developer setup: task lists, attributes, shop items, and achievements.

### Что было создано

| Область | Содержимое |
| --- | --- |
| Списки задач | Morning Ritual, Coding Daily, Game Dev, Deep Learning, Learning & Recharge, Wrap-up |
| Атрибуты | Execution / Technical / Collaboration / Focus / Wellness / Creativity плюс **Developer Stats** (Game Design, Debugging, Architecture) |
| Магазин | **Dev Supplies** (расходники) + **Fun Collectibles** (пасхальные предметы) |
| Достижения | **Indie Dev Journey** (Hello World, First Bug Kill, Ship It!, …) |

> [!TIP]
> Нажмите на изображение для увеличения. Переключайте вкладки ниже по горизонтали вместо длинной прокрутки.

<!-- tabs:start -->

#### **1 · Обзор задач**

Повторяющиеся задачи Morning Ritual в представлении **All**, с чипами категорий Coding Daily, Game Dev и др.

![Tasks · Morning Ritual and categories](_media/mcp/game-dev-example/02-tasks-overview.jpg ':size=45%')

#### **2 · Атрибуты**

Шесть базовых атрибутов плюс группа **Developer Stats**. Выполнение задач даёт очки опыта соответствующим навыкам.

![Attributes panel](_media/mcp/game-dev-example/03-skills.jpg ':size=45%')

#### **3 · Fun Collectibles**

Пасхальные предметы магазина: Inspiration Dice, RGB Keycap, Desk Cat, LEGO Brick, Retro Gamepad, Rubber Duck — некоторые со случайными монетами или бонусами к атрибутам.

![Shop · Fun Collectibles](_media/mcp/game-dev-example/04-shop-fun-collection.jpg ':size=45%')

#### **4 · Достижения**

Вехи: первая задача, первый багфикс, релиз демо, серии, помодоро, Piggy Bank, Daily Pentakill и др. — с emoji-иконками и условиями разблокировки.

![Indie Dev Journey achievements](_media/mcp/game-dev-example/06-achievements.jpg ':size=45%')

#### **5 · Детали Piggy Bank**

Пример условия прогресса: текущий баланс **500 монет**.

![Achievement detail · Piggy Bank](_media/mcp/game-dev-example/07-achievement-detail-piggy-bank.jpg ':size=45%')

#### **6 · Детали Daily Pentakill**

Пример счётчика: выполнить **5 разных задач за один день**.

![Achievement detail · Daily Pentakill](_media/mcp/game-dev-example/08-achievement-detail-pentakill.jpg ':size=45%')

<!-- tabs:end -->

### Что обычно делает AI

1. `list_tasks` / `list_items` — проверить существующие примеры; при необходимости удалить старые строки (`confirm: true` для деструктивных вызовов).
2. Создать списки задач / магазина / достижений (`category`).
3. Создать атрибуты и группы (`skill` / `skill_group`).
4. Пакетно записать задачи, предметы и достижения (`add_task` / `add_item` / `achievement`).
5. Обновить соответствующие экраны в App для проверки.

Параметры API см. [Skills](#skills) и [Workflow агента](#agent-workflow) выше; таблицы методов — через MCP `help add_task` и т. д.
