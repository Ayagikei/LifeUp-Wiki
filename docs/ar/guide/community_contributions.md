## مساهمات المجتمع 🤝

نحن ممتنون جدًا لمجتمعنا الذي يبني أدوات توسّع قدرات LifeUp. فيما يلي مجموعات الأدوات الرسمية ومشاريع المجتمع المميزة.

## مجموعات الأدوات الرسمية

| المشروع | الوصف |
| --- | --- |
| [LifeUp Cloud](guide/api_cloud.md) | جسر HTTP API على الهاتف؛ الوصول عبر LAN و**مسح QR** (`lifeup://`، عناوين web، schemes تطبيقات أخرى) |
| [@lifeup/mcp](guide/api_mcp.md) | خادم MCP رسمي + Skills لـ Cursor وClaude Desktop ووكلاء AI آخرين عبر LAN |
| [LifeUp Desktop](guide/api_desktop.md) | عميل سطح مكتب رسمي مبني على LifeUp Cloud HTTP |
| [Wordle integration demo](example/wordle/index.html) | لعبة مصغّرة لتخمين الكلمات؛ تستدعي `lifeup://api/reward` عند الفوز |

**إعداد Wordle:** أنشئ عنصرًا في المتجر → أضف تأثير رابط من النوع 9 يشير إلى صفحة Wordle → **Use** يفتح اللعبة في المتصفح؛ الفوز يمنح 10 عملات، والخسارة ما زالت تمنح عملة تعزية. يمكنك أيضًا ترميز عنوان Wordle كرمز QR ومسحه بـ LifeUp Cloud. راجع [API · External web (Wordle)](guide/api.md).

<br/>

## مشاريع المجتمع

| المشروع | الوصف | المؤلف |
| :--- | :--- | :--- |
| [lifeup-mcp](https://github.com/derekprovance/lifeup-mcp) | خادم MCP مبكر من المجتمع (حلّ محله `@lifeup/mcp` الرسمي). | [@derekprovance](https://github.com/derekprovance) |
| [lifeup_mod_coins](https://github.com/klienkross/lifeup_mod_coins) | إضافة Obsidian ↔ LifeUp: مزامنة المهام، مزامنة التأمل، لوحة بيانات LifeUp في Obsidian. *ملاحظة: المستودع بالصينية فقط.* | [@klienkross](https://github.com/klienkross) |

> [!TIP]
> **بنيتَ شيئًا رائعًا؟** إذا طوّرت أداة أو سكربت أو تكاملًا لـ LifeUp، أخبرنا عبر GitHub Issues أو البريد الإلكتروني!
