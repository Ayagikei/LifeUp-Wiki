## Вклад сообщества 🤝

Мы очень благодарны сообществу за инструменты, расширяющие возможности LifeUp. Ниже — официальные наборы инструментов и избранные проекты сообщества.

## Официальные наборы инструментов

| Проект | Описание |
| --- | --- |
| [LifeUp Cloud](guide/api_cloud.md) | HTTP API на телефоне; доступ по LAN и **сканирование QR-кодов** (`lifeup://`, веб-URL, схемы других приложений) |
| [@lifeup/mcp](guide/api_mcp.md) | Официальный MCP-сервер + Skills для Cursor, Claude Desktop и других AI-агентов по LAN |
| [LifeUp Desktop](guide/api_desktop.md) | Официальный десктопный клиент на базе HTTP LifeUp Cloud |
| [Демо интеграции Wordle](example/wordle/index.html) | Мини-игра «угадай слово»; при победе вызывает `lifeup://api/reward` |

**Настройка Wordle:** Создайте предмет в Магазине → добавьте эффект ссылки типа 9 на страницу Wordle → **Использовать** открывает игру в браузере; победа даёт 10 монет, поражение — утешительную монету. Также можно закодировать URL Wordle в QR-код и отсканировать его через LifeUp Cloud. См. [API · Внешний веб (Wordle)](guide/api.md).

<br/>

## Проекты сообщества

| Проект | Описание | Автор |
| :--- | :--- | :--- |
| [lifeup-mcp](https://github.com/derekprovance/lifeup-mcp) | Ранний MCP-сервер сообщества (заменён официальным `@lifeup/mcp`). | [@derekprovance](https://github.com/derekprovance) |
| [lifeup_mod_coins](https://github.com/klienkross/lifeup_mod_coins) | Плагин Obsidian ↔ LifeUp: синхронизация to-do, синхронизация рефлексий, дашборд данных LifeUp в Obsidian. *Примечание: репозиторий только на китайском.* | [@klienkross](https://github.com/klienkross) |

> [!TIP]
> **Сделали что-то интересное?** Если вы разработали инструмент, скрипт или интеграцию для LifeUp, сообщите нам через GitHub Issues или по электронной почте!
