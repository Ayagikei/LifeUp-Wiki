<h1 align="center" padding="100">MCP & Skills</h1>

تريد أن يعمل الذكاء الاصطناعي مع LifeUp؟ هناك طبقتان:

| | ماذا تفعل | من يستخدمها |
|---|---|---|
| **MCP** `@lifeup/mcp` | اكتشاف LifeUp Cloud، إرسال طلبات HTTP، ترميز المعلمات، تحليل الاستجابات | Cursor، Claude Desktop، WorkBuddy، وأي عميل MCP |
| **Skills** `lifeup-cloud/` | كيفية الاتصال، ماذا تستعلم، وكيف تستدعي كل واجهة API | مضمّنة في MCP `help`؛ Claude Code / Pi يمكنهما أيضًا تحميل المجلد كمهارة على القرص |

الوكيل على الكمبيوتر يصل إلى LifeUp Cloud على هاتفك عبر LAN، ثم يتحدث مع LifeUp. تفاصيل HTTP تبقى في [واجهة LifeUp Cloud API](guide/api_cloud.md). مصدر MCP: [LifeUp-SDK/mcp](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp).

> [!NOTE]
> يتطلب **LifeUp 1.106.0**+ و**LifeUp Cloud 3.0.0**+. الإصدارات الأقدم قد تتصل، لكن اليوميات والإحصائيات ومنحنى المستويات غير مكتملة. `status.update` يمكنه مطالبة المستخدم بالترقية.

MCP يمنح الوكيل **واجهات قراءة/كتابة**؛ طبقة الذكاء الاصطناعي تضيف **الاستدلال** — ترتيب مهام اليوم، تلخيص إحصائيات الأسبوع من اليوميات، تصميم مهام من مستويات السمات، أو **بناء إعداد تلعيب كامل بموضوع واحد في مطالبة واحدة** (مطوّر ألعاب مستقل، أكاديمية سحر، والمزيد) — وليس مجرد جلب قوائم خام.

## جرّب أن تسأل

بعد تثبيت MCP، لا حاجة لحفظ واجهات API — تحدّث مع الذكاء الاصطناعي فقط.

**خطّط يومك**

- «ما المتبقي اليوم؟ رتّب حسب الأولوية وأخبرني بما أبدأ به.»
- «اختر مهمة غير منجزة يمكنني إتمامها في نحو 25 دقيقة.»

**حلّل بياناتك**

- «اسحب إحصائيات pomodoro والتركيز والعملات ونقاط الخبرة لهذا الأسبوع — فصّل مصادرها واختصر الأنماط.»
- «من أين جاءت عملاتي هذا الشهر؟ اعرض أكبر المصادر وأي شيء مفاجئ.»

**درب وصمّم**

- «انظر إلى مستويات السمات لدي وصمّم مجموعة مهام يومية لرفع المهارات الأضعف.»

**إعداد بموضوع واحد**

- «امسح العينات، ثم ابنِ إعدادًا كاملًا لمطوّر ألعاب مستقل: قوائم، متجر، إنجازات، وسمات.»
- «صمّم روتين RPG لأكاديمية سحر كاملة — مهام، سمات، عناصر متجر، وإنجازات.»

**تأمّل**

- «انظر ما أنجزته اليوم واكتب يومية قصيرة: ماذا فعلت، وماذا يمكن تحسينه غدًا.»
- «أنشئ قائمة إنجازات اسمها Morning Routine، ثم أضف 8 إنجازات بأيقونات emoji ومكافآت عملات.»
<br/>

## البدء السريع

أرسل هذا السطر الواحد إلى وكيلك لتثبيت MCP وإكمال الاتصال الأول:

```
Follow this doc to install the LifeUp MCP server and complete the first connection: https://raw.githubusercontent.com/Ayagikei/LifeUp-Wiki/master/docs/en/guide/api_mcp.md
```

<br/>

## Skills

ملفات المهارة في [`mcp/skills/lifeup-cloud/`](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp/skills/lifeup-cloud) (نسخة واحدة في المستودع — لا حزمة npm منفصلة).

- **Cursor / Claude Desktop / WorkBuddy:** ثبّت MCP فقط. `help` يقرأ هذه المهارة؛ لا تثبّتها مرتين.
- **Claude Code / Pi / سير عمل مخصص:** انسخ المجلد إلى مسار مهارات الوكيل، أو أشر مباشرة إلى المستودع.

```text
mcp/skills/lifeup-cloud/
  SKILL.md                 اتصال + عمليات شائعة (اقرأ هذا أولًا)
  references/
    basics.md              أخطاء، ترميز، JSON، مهلة
    discovery.md           mDNS / token
    query.md               موارد list_data
    tasks.md / economy.md
    api-index.md           سطر واحد لكل method
    methods/*.md           جدول معلمات كامل (حمّل عند الاستدعاء)
    broadcasts.md / gaps.md
```

الوكيل يقرأ الوثائق تدريجيًا:

1. `help` (أو `SKILL.md` على القرص) — سير العمل العام
2. `help api-index` — أي methods موجودة
3. `help add_task` — معلمات method واحد
4. `call_api` / `list_data` — تنفيذ الاستدعاء

للتخصيص: انسخ المجلد وعدّل `SKILL.md` و`references/`. MCP `help` ما زال يقرأ النسخة المضمّنة ما لم تعِد بناء MCP من fork لديك.

<br/>

## الإعداد

1. الهاتف والكمبيوتر على نفس LAN
2. LifeUp قيد التشغيل، مع منح Cloud **Read LifeUp Data**
3. LifeUp Cloud مفعّل (المنفذ الافتراضي `13276`)
4. [Node.js 20+](https://nodejs.org/) على الكمبيوتر

الرمز اختياري. إن وُجد، أرسل الرمز **الخام** في الترويسة — وليس `Bearer`.

<br/>

## تثبيت MCP

حتى ينشر الحزمة على npm، ثبّت من GitHub:

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

`npx` يستنسخ المستودع ويبني `mcp/`. بعد الدمج في `main`، احذف `#feat/mcp`.

إذا استنسخت [LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK) مسبقًا، استخدم المثبّت (يبني MCP ويحدّث العملاء المكتشفين؛ إعادة التشغيل لا تسجّل نسخة ثانية):

```bash
./scripts/install-mcp.sh
```

العملاء الافتراضيون: Codex، Cursor، Claude Code، Claude Desktop، Pi. إعدادات Pi التي تستخدم `imports: ["codex"]` ترث Codex ولا تُكرّر.

تطبيقات الواجهة على macOS غالبًا لا تجد `npx` على `PATH` — استخدم مسارًا مطلقًا لـ `npx`/`node`، أو استنسخ وشغّل `cd mcp && npm install && npm run build`.

| المتغير | الدور |
|---|---|
| `LIFEUP_HOST` | مثل `192.168.1.8:13276`، تخطّ mDNS |
| `LIFEUP_TOKEN` | في الذاكرة فقط، لا يُكتب على القرص |
| `LIFEUP_MCP_CONFIG` | مسار إعداد مخصص |

بعد النشر: `npx -y @lifeup/mcp` (npmmirror في الصين).
<br/>

## سير عمل الوكيل :id=agent-workflow

1. `discover` — mDNS `_lifeup._tcp`؛ TXT `port` هو منفذ HTTP. يتصل تلقائيًا إذا وُجدت نسخة Cloud واحدة بالضبط.
2. `connect` — مرّر `host` عندما لا توجد نسخ أو توجد عدة نسخ.
3. `status` — تحقق من الإصدارات؛ إن كانت دون 1.106.0 / 3.0.0، راقب `update`.
4. القوائم: `list_data` (حقول مدمجة افتراضيًا).
5. الكتابة: `complete_task` / `add_task` / `reward` / `purchase_item`؛ كل شيء آخر عبر `call_api`. استخدم `via=launch` لفتح واجهة App.

الاستدعاءات المدمّرة تحتاج `confirm: true`. لا ترمّز قيم المعلمات مسبقًا.

## الأحداث

LifeUp: فعّل Labs → Broadcast events (معطّل افتراضيًا؛ Cloud Advanced يمكنه عرض الحالة وتفعيله). **دفع WebSocket event push في Cloud مفعّل افتراضيًا** (3.0.0+) وهو للنقل فقط.

- `list_events` — `GET /events`، متاح دائمًا
- `subscribe_events` — `WS /events`؛ خطأ إن كان مفتاح Cloud معطّلًا، HTTP ما زال يعمل

التفاصيل: MCP `help broadcasts`.

<br/>

---

## مثال: إعداد مطوّر ألعاب مستقل

فيما يلي نتيجة جلسة MCP حقيقية: طلب المستخدم من الذكاء الاصطناعي **مسح عينات المطوّر المدمجة في LifeUp**، ثم بناء إعداد RPG كامل حول **تطوير الألعاب المستقلة** (قوائم المهام، السمات، المتجر، الإنجازات).

يمكنك البدء بمطالبات مثل:

> امسح المهام وعناصر المتجر النموذجية، ثم أنشئ إعدادًا كاملًا لمطوّر ألعاب مستقل: قوائم المهام، السمات، عناصر المتجر، والإنجازات.

### ما تم بناؤه

| المجال | المحتوى |
| --- | --- |
| قوائم المهام | Morning Ritual، Coding Daily، Game Dev، Deep Learning، Learning & Recharge، Wrap-up |
| السمات | Execution / Technical / Collaboration / Focus / Wellness / Creativity، بالإضافة إلى **Developer Stats** (Game Design، Debugging، Architecture) |
| المتجر | **Dev Supplies** (استهلاكيات) + **Fun Collectibles** (عناصر easter egg) |
| الإنجازات | **Indie Dev Journey** (Hello World، First Bug Kill، Ship It!، …) |

> [!TIP]
> اضغط أي صورة للتكبير. استخدم التبويبات أدناه للتبديل أفقيًا بدل التمرير في صفحة طويلة.

<!-- tabs:start -->

#### **1 · نظرة عامة على المهام**

مهام Morning Ritual المتكررة في عرض **All**، مع شرائح فئات Coding Daily وGame Dev والمزيد.

![Tasks · Morning Ritual and categories](_media/mcp/game-dev-example/02-tasks-overview.jpg ':size=45%')

#### **2 · السمات**

السمات الست الأساسية بالإضافة إلى مجموعة **Developer Stats**. إتمام المهام يمنح نقاط الخبرة للمهارات المطابقة.

![Attributes panel](_media/mcp/game-dev-example/03-skills.jpg ':size=45%')

#### **3 · Fun Collectibles**

عناصر متجر easter egg: Inspiration Dice، RGB Keycap، Desk Cat، LEGO Brick، Retro Gamepad، Rubber Duck — بعضها بعملات عشوائية أو مكافآت سمات.

![Shop · Fun Collectibles](_media/mcp/game-dev-example/04-shop-fun-collection.jpg ':size=45%')

#### **4 · الإنجازات**

إنجازات معالم: أول مهمة، أول إصلاح bug، إطلاق demo، سلاسل، pomodoros، Piggy Bank، Daily Pentakill، والمزيد — بأيقونات emoji وشروط فتح.

![Indie Dev Journey achievements](_media/mcp/game-dev-example/06-achievements.jpg ':size=45%')

#### **5 · تفاصيل Piggy Bank**

مثال على شرط تقدّم: الوصول إلى **500 عملة** في الرصيد الحالي.

![Achievement detail · Piggy Bank](_media/mcp/game-dev-example/07-achievement-detail-piggy-bank.jpg ':size=45%')

#### **6 · تفاصيل Daily Pentakill**

مثال على شرط عدّ: إتمام **5 مهام مختلفة في يوم واحد**.

![Achievement detail · Daily Pentakill](_media/mcp/game-dev-example/08-achievement-detail-pentakill.jpg ':size=45%')

<!-- tabs:end -->

### ما يفعله الذكاء الاصطناعي عادةً

1. `list_tasks` / `list_items` — فحص العينات الموجودة؛ حذف الصفوف القديمة عند الحاجة (`confirm: true` للاستدعاءات المدمّرة).
2. إنشاء قوائم مهام / متجر / إنجازات (`category`).
3. إنشاء سمات ومجموعات (`skill` / `skill_group`).
4. كتابة دفعية للمهام والعناصر والإنجازات (`add_task` / `add_item` / `achievement`).
5. تحديث الشاشات المطابقة في App للتحقق.

لمعلمات API راجع [Skills](#skills) و[سير عمل الوكيل](#agent-workflow) أعلاه؛ جداول كل method عبر MCP `help add_task`، إلخ.
