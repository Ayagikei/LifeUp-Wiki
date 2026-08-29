<h1 align="center" padding="100">LifeUp Cloud ☁️</h1>

<p align="center">
 <img src="guide/_media/api/cloud.png" />
</p>

LifeUp Cloud هو أحد أدوات واجهة API الأساسية في LifeUp. يحوّل هاتفك إلى **جسر API**: تحكم في LifeUp من **الكمبيوتر أو أجهزة أخرى**، أنشئ **تكاملات مخصصة** (سطح المكتب، الويب، سكربتات الأتمتة)، أو اربطه مع **وكلاء الذكاء الاصطناعي**.

### سيناريوهات نموذجية

| السيناريو | لمن | في جملة واحدة | اعرف المزيد |
| --- | --- | --- | --- |
| **HTTP + ابنِ بنفسك** | المطوّرون، مستخدمو الأتمتة | استدعِ واجهات API واستعلم عن البيانات من Python أو تطبيقات الويب أو السكربتات عبر LAN — دون خبرة Android | [واجهة HTTP API](#http-api-definition)، [سطح المكتب](guide/api_desktop.md) |
| **مسح QR** | عشّاق تسجيل الحضور في العالم الحقيقي | اطبع رموز QR لإتمام المهام، بدء المؤقتات، فتح الحوارات، أو تشغيل صفحات الويب / تطبيقات أخرى | [مسح رمز QR](#qr-code-scanning) |
| **اختصارات بدء / إيقاف** | الأتمتة، NFC، Tasker | `lifeupcloud://start` و`lifeupcloud://stop` يفتحان Cloud ويبدآن أو يوقفان خادم HTTP | [البدء والإيقاف](#cloud-scheme) |
| **وكيل ذكاء اصطناعي + MCP** | Cursor، Claude، إلخ | مطالبة واحدة لبناء قوائم المهام، عناصر المتجر، الإنجازات، والمزيد | [MCP & Skills](guide/api_mcp.md) |
> **مثال على مطالبة ذكاء اصطناعي:** امسح المهام وعناصر المتجر النموذجية، ثم أنشئ إعدادًا كاملًا لمطوّر ألعاب مستقل: قوائم المهام، السمات، عناصر المتجر، والإنجازات.

<br/>

## التنزيل

- إذا كنت تستخدم نسخة العضوية في الصين القارية، تجد مدخل تنزيل LifeUp Cloud في `Sidebar` → `Settings` → `Experiments`.
- [Google Play Store](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http)

<br/>


## بدء وإيقاف خدمة Cloud :id=cloud-scheme

يمكنك بدء أو إيقاف خادم HTTP دون الضغط على **Start Service**، باستخدام مخططات URL التالية:

```txt
lifeupcloud://start
lifeupcloud://stop
```

فتح أي من هاتين العنوانين يشغّل LifeUp Cloud وينفّذ الإجراء. استخدمهما كاختصار على الشاشة الرئيسية، أو بطاقة NFC، أو إجراء Tasker/أتمتة، أو:

```txt
adb shell am start -a android.intent.action.VIEW -d lifeupcloud://start
```

نفس العناوين مدرجة في بطاقة حالة Cloud — اضغط للنسخ.

> [!NOTE]
> `lifeupcloud://` يتحكم في خادم HTTP الخاص بـ Cloud نفسه. ليس واجهة لعبة `lifeup://api/…`.

<br/>

## مسح رمز QR :id=qr-code-scanning

زر **Scan** أعلى LifeUp Cloud يقرأ العنوان المرمّز في رمز QR ويفتحه فورًا — دون إدخال يدوي.

المسح **لا يقتصر على واجهات LifeUp API**: `lifeup://api/…`، صفحات الويب `https://…`، ومخططات URL لتطبيقات أخرى (مثل `weixin://`) تعمل جميعها — Android يفتح الهدف المطابق.

### كيفية الاستخدام

1. اختر عنوانًا من LifeUp أو [قائمة API](guide/api.md) في الويكي (إتمام مهمة، بدء pomodoro، فتح حوارات الشراء/الاستخدام، أو فتح صفحة ويب خارجية).

2. أنشئ رمز QR من العنوان الكامل (اطبعه والصقه على مكتب أو جدار أو جهاز).

3. افتح LifeUp Cloud، اضغط **Scan** (اضغط **?** بجانبه للدليل المختصر داخل App)، ووجّه الكاميرا نحو الرمز.

### ما يمكنك فعله

| السيناريو | مثال (توضيحي) |
| --- | --- |
| تسجيل حضور Pomodoro | `lifeup://api/pomodoro?...` بدء/إيقاف المؤقت |
| تسجيل حضور مهمة | `lifeup://api/complete?name=...` إتمام مهمة |
| تفاعل المتجر | `lifeup://api/goto?page=shop` أو حوارات شراء/استخدام |
| مكافأة / عقوبة | `lifeup://api/reward?...` / `lifeup://api/penalty?...` |
| لعبة ويب مصغّرة | `https://wiki.lifeupapp.fun/en/example/wordle/index.html` |
| تطبيقات أخرى | `weixin://`، `intent://`، أو مخطط أي تطبيق مثبّت |
| تدفقات مخصصة | أي تركيبة من عناوين URL قابلة للمسح |

### تفاعل في العالم الحقيقي

رموز QR تربط **أماكن أو إجراءات مادية** بالتلعيب داخل App:

- ملصق **معدات الجيم** → امسح لإتمام مهمة تدريب القوة

- ملصق **مكتب الدراسة** → امسح لبدء pomodoro تركيز

- ملصق **محطة العمل** → امسح لتسجيل stand-up أو مراجعة كود

- ملصق **لوحة الفعاليات** → امسح للمطالبة بمكافأة أو فتح إنجاز

باختصار: **حوّل URL Schemes إلى محفّزات مادية قابلة للمسح**، مع LifeUp Cloud كمنفّذ بين App والعالم الحقيقي.

<br/>

> [!NOTE]
> LifeUp Cloud جسر HTTP على LAN فقط. كيفية الوصول إلى هاتفك — عنوان IP، الموجّه، جدار الحماية، نفس الشبكة الفرعية، VPN، أو عزل AP — يعتمد على شبكتك المنزلية. إذا تعذّر الاتصال، لا يمكننا تشخيص LAN الشخصي لديك. تحقق من إعدادات الشبكة بنفسك، أو استخدم أدوات شبكة قياسية، أو اطلب المساعدة من وكيل ذكاء اصطناعي.

## تعريف واجهة HTTP API :id=http-api-definition

> [!WARNING]
> قد تتأخر وثائق API في هذه الصفحة عن تحديثات التنفيذ. استخدم الكود المصدري كمرجع نهائي: [KtorService.kt](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt)

### 1. واجهة استدعاء URL Scheme

#### GET

الوظيفة:

> استدعِ واجهات API التي تبدأ بـ `lifeup://api`.

عنوان الطلب:

```txt
// موصى به: وضع content provider (توافق أفضل)
http://{host:port}/api/contentprovider

// وضع startActivity (قد تمنع بعض الأجهزة واجهة المستخدم في الخلفية)
http://{host:port}/api
```

**Method: `GET`**

**معلمات الاستعلام:**

| الحقل | الوصف | الموقع | النوع | مطلوب | ملاحظات |
| --- | --- | --- | --- | --- | --- |
| url | عنوان API يبدأ بـ `lifeup://api` | Query | string | نعم | رمّز العنوان عند البناء يدويًا. يدعم عدة معلمات `url`. |

**أمثلة الطلب:**

```txt
// استدعاء واحد (content provider)
http://{host:port}/api/contentprovider?url=YOUR_ENCODED_API_URL

// استدعاء دفعي
http://{host:port}/api/contentprovider?url=YOUR_ENCODED_API_URL_1&url=YOUR_ENCODED_API_URL_2

// استدعاء واحد (startActivity)
http://{host:port}/api?url=YOUR_ENCODED_API_URL
```

<br/>

#### POST

الوظيفة:

> استدعِ واجهات API التي تبدأ بـ `lifeup://api`.

عنوان الطلب:

```txt
// موصى به: وضع content provider (توافق أفضل)
http://{host:port}/api/contentprovider

// وضع startActivity (قد تمنع بعض الأجهزة واجهة المستخدم في الخلفية)
http://{host:port}/api
```

**Method: `POST`**

**معلمات جسم JSON:**

| الحقل | الوصف | الموقع | النوع | مطلوب | ملاحظات |
| --- | --- | --- | --- | --- | --- |
| urls | مصفوفة عناوين تبدأ بـ `lifeup://api` | Body | List<string> | نعم | لا حاجة لترميز URL إضافي في جسم JSON. |

**مثال الطلب:**

```txt
// POST
http://{host:port}/api/contentprovider

// JSON body
{
  "urls": ["lifeup://api/goto?page=lab"]
}
```

<br/>

### 2. واجهات استعلام البيانات

> [!NOTE]
> المتطلبات:
> 1. LifeUp v1.91+ وأحدث LifeUp Cloud.
> 2. امنح إذن **Read LifeUp Data** في LifeUp Cloud.

الوظيفة:

> استعلم عن مجموعات بيانات LifeUp الكاملة، مثل المهام والعناصر.

**نقاط نهاية المهام**

```txt
// جميع المهام
http://{host:port}/tasks

// المهام في الفئة/القائمة ${id}
http://{host:port}/tasks/${id}

// السجل (يدعم التصفح)
// gid اختياري ويمكن استخدامه لتصفية كل سجلات مهمة متكررة
http://{host:port}/history?offset=${offset}&limit=${limit}&gid=${gid}

// فئات المهام
http://{host:port}/tasks_categories
```

**نقاط نهاية العناصر**

```txt
// جميع العناصر
http://{host:port}/items

// العناصر في الفئة/القائمة ${id}
http://{host:port}/items/${id}

// فئات العناصر
http://{host:port}/items_categories

// تضمين القوائم المخفية
http://{host:port}/items_categories?include_hidden=true
```

**نقاط نهاية الإنجازات**

```txt
// جميع الإنجازات
http://{host:port}/achievements

// الإنجازات في الفئة/القائمة ${id}
http://{host:port}/achievements/${id}

// فئات الإنجازات
http://{host:port}/achievement_categories
```

**نقاط نهاية المشاعر**

```txt
// جميع المشاعر (يدعم التصفح)
http://{host:port}/feelings?offset=${offset}&limit=${limit}
```

**نقاط نهاية فئات التركيب**

```txt
// جميع فئات التركيب
http://{host:port}/synthesis_categories

// فئات التركيب في القائمة ${id}
http://{host:port}/synthesis_categories/${id}
```

**نقاط نهاية وصفات التركيب**

```txt
// جميع وصفات التركيب
http://{host:port}/synthesis

// وصفات التركيب في الفئة ${id}
http://{host:port}/synthesis/${id}
```

**نقاط نهاية السمات**

```txt
// جميع السمات
http://{host:port}/skills
```


**أخرى**

```txt
// رصيد العملات
http://{host:port}/coin

// إصدارات LifeUp / Cloud
http://{host:port}/info

// سجلات Pomodoro (مع تصفح؛ نطاق زمني اختياري)
http://{host:port}/pomodoro_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}

// اليوميات (مع تصفح؛ نطاق زمني اختياري). الصفوف المحذوفة مؤقتًا مستبعدة.
http://{host:port}/coin_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/inventory_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/exp_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/step_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/level_defines
http://{host:port}/statistics?time_range_start=${ms}&time_range_end=${ms}
// جميع الإنجازات (منفّذ؛ معرّف الفئة اختياري)
http://{host:port}/achievements

// أحداث البث. LifeUp Labs → Broadcast events معطّل افتراضيًا؛ Cloud Advanced يمكنه عرض الحالة وتفعيله. GET data.broadcasts هو هذا المفتاح (يُحذف إن لم يُقرأ). إعداد WebSocket في Cloud للنقل فقط.
http://{host:port}/events?after=${id}&limit=50

// دفع WebSocket (مفعّل افتراضيًا؛ إعداد Cloud WebSocket event push)
ws://{host:port}/events?after=${id}
```

الغلاف: `{ code, message, data }`. `200` يعني نجاح النقل فقط. `10001` LifeUp غير قيد التشغيل أو Read Data غير ممنوح. `10002` فشل استعلام ContentProvider.

### قيم حقول القوائم

| Endpoint | الحقل | القيم |
| --- | --- | --- |
| `/tasks` `/history` | `status` | `0` غير منجزة · `1` منجزة · `2` متأخرة · `3` متروكة |
| `/tasks` | `frequency` | `0` مرة واحدة · `1` يوميًا · `N>1` كل N أيام · `-1` غير محدود · `-3` Ebbinghaus · `-4` شهري · `-5` سنوي |
| `/tasks` | `weekdays` | `1,3,5` (الإث=1 … الأحد=7). فارغ خارج وضع أيام الأسبوع. v1.106.0+ |
| `/tasks_categories` | `status` | `0` عادي · `1` مؤرشف |
| `/tasks_categories` | `type` | `<10` عادي · `10` يومي · `11` أسبوعي · `12` شهري · `20` قيد التنفيذ |
| `/achievements` | `status` | `0` مقفل · `1` مفتوح، المكافأة غير مطلوبة · `2` مفتوح، مطلوب |
| `/achievements` | `type` | `0` عادي · `1` فئة فرعية |
| `/achievement_categories` | `type` | `0` مستخدم · `1` نظام |
| `/feelings` | `type` | `0` مهمة · `1` إنجاز · `2` خام · `3` استخدام عنصر |
| `/feelings` | `isFav` | bool (CP 0/1) |
| `/skills` | `type` | `0` مستخدم · `1` قوة · `2` تعلّم · `3` جاذبية · `4` تحمّل · `5` حيوية · `6` إبداع |
| `/items_categories` | `hidden` / `inventoryHidden` | `0` ظاهر · `1` مخفي (أعلام مستقلة) |
| `/synthesis_categories` | `hidden` | `0` ظاهر · `1` مخفي |
| `/pomodoro_records` | `reward` | `0` متروك · `0.5×n` نصف · وإلا مضاعف كامل |
| `/coin_records` `/inventory_records` | `resCode` | المتجر: `0` شراء · `1` استخدام · `2` إتمام مهمة · `3` تراجع إتمام · `4` مسح · `5` ترك · `6` تأخير · `7` فتح إنجاز · `8` إلغاء ترك · `9` إلغاء تأخير · `10` إرجاع · `11` إتمام مهمة فرعية · `12` تراجع مهمة فرعية · `13` فتح إنجاز مستخدم · `14` تراجع إنجاز مستخدم · `15` إيداع · `16` سحب · `17` بيع طماطم · `20` مكافأة عنصر · `21` تراجع مكافأة عنصر · `23` تركيب · `24` صندوق الغنائم · `25` فائدة ATM · `26` تبادل طماطم · `27` فائدة ائتمان · `28` API · `29` مخزون تأثير |
| `/exp_records` | `resCode` | نقاط الخبرة (ليس المتجر `28`): `0` غير معروف · `1` إتمام · `2` إنجاز · `3` تبادل إعجاب · `4` سلسلة أيام · `5` خطوات · `6` تعيين منجز · `7` إلغاء ترك · `8` إلغاء تأخير · `9` أكل طماطم · `10` عنصر مستخدم · `11` فتح إنجاز مستخدم · `12` إتمام مهمة فرعية · `200` API · `101` تراجع إتمام · `102` ترك · `103` تأخير · `104` خصم عنصر مستخدم · `105` قفل إنجاز مستخدم · `106` تراجع مهمة فرعية |

`GET /items_categories` و`GET /synthesis_categories` و`GET /skill_groups` يقبل `include_hidden=true` (القوائم المخفية مستبعدة افتراضيًا). شروط فتح الإنجاز: `GET /achievement_conditions/{id}`. `status` للمهارة (0 عادي / 1 مخفي) موجود فقط في `query`/`query_skill`، **وليس** في `GET /skills`.

**Method: `GET`**

**المعلمات:**

| الحقل | الوصف | الموقع | النوع | مطلوب | ملاحظات |
| --- | --- | --- | --- | --- | --- |
| id | معرّف البيانات | Path/Query | Number | نعم (لنقاط النهاية حسب المعرّف) | - |
| offset | إزاحة الاستعلام | Query | Number | لا | مطلوب فقط لبعض نقاط النهاية مع التصفح |
| limit | حجم الصفحة | Query | Number | لا | مطلوب فقط لبعض نقاط النهاية مع التصفح |
| gid | تصفية سجل مهمة متكررة | Query | Number | لا | اختياري لاستعلام السجل |
| include_hidden | تضمين القوائم المخفية | Query | Boolean | لا | الافتراضي false. يُستخدم مع `/items_categories` و`/synthesis_categories` و`/skill_groups` |
| time_range_start | بداية النطاق (ms) | Query | Number | لا* | يجب إقرانه مع `time_range_end`. نطاق جزئي/غير صالح يُرجع `invalid_parameter` |
| time_range_end | نهاية النطاق (ms) | Query | Number | لا* | يجب أن يكون أكبر من `time_range_start` |

**أمثلة الطلب**

**المهام**

```txt
// جميع المهام
http://{host:port}/tasks

// المهام في القائمة ذات المعرّف 1
http://{host:port}/tasks/1

// السجل (100 سجل من الفهرس 0)
http://{host:port}/history?offset=0&limit=100

// فئات المهام
http://{host:port}/tasks_categories
```

**العناصر**

```txt
// جميع العناصر
http://{host:port}/items

// استعلام عناصر محددة بالمعرّفات 1 و4
http://{host:port}/items?id=1&id=4

// العناصر في القائمة ذات المعرّف 1
http://{host:port}/items/1

// فئات العناصر
http://{host:port}/items_categories
```

**الإنجازات**

```txt
// الإنجازات في القائمة/الفئة ${id}
http://{host:port}/achievements/${id}

// فئات الإنجازات
http://{host:port}/achievement_categories
```

**المشاعر**

```txt
// 100 سجل من الفهرس 0
http://{host:port}/feelings?offset=0&limit=100
```

**السمات**

```txt
http://{host:port}/skills
```

**فئات التركيب**

```txt
http://{host:port}/synthesis_categories
http://{host:port}/synthesis_categories/1
```

**وصفات التركيب**

```txt
http://{host:port}/synthesis
http://{host:port}/synthesis/1
```

<br/>

### 3. واجهة الصورة/الملف

> [!NOTE]
> بسبب قيود تخزين Android، قد يحتاج LifeUp Cloud إلى إنشاء ملف منسوخ عند تقديم محتوى صورة من LifeUp.

الوظيفة:

> تحميل موارد الصورة/الملف التي تُرجعها واجهات بيانات API (عادةً `content://...`).

عنوان الطلب:

```txt
http://{host:port}/files/${url}
```

**Method: `GET`**

**معلمات المسار:**

| الحقل | الوصف | الموقع | النوع | مطلوب | ملاحظات |
| --- | --- | --- | --- | --- | --- |
| url | عنوان الملف | Path | String | نعم | - |

**مثال الطلب:**

```txt
http://{host:port}/files/xxx
```

<br/>

### 4. استعلامات ContentProvider للمهارات

> [!NOTE]
> يتطلب v1.103.0+

للاستعلامات القائمة أو المهيكلة، يمكنك قراءة عناوين ContentProvider التالية عبر نقطة النهاية `http://{host:port}/api/contentprovider`.

#### `content://net.sarasarasa.lifeup.provider.api/skills`

يُرجع المهارات الظاهرة فقط.

| العمود | المعنى | النوع | ملاحظات |
| ------ | ------- | ---- | ----- |
| _ID | معرّف المهارة | number | - |
| name | اسم المهارة | string | - |
| desc | الوصف | string | قد يكون فارغًا |
| icon | URI الأيقونة | string | قد يكون فارغًا |
| order | ترتيب خام | number | `orderInCategory` |
| group_id | معرّف مجموعة المهارات | number / null | قد يكون فارغًا عندما لا تكون المهارة في مجموعة |
| color | اللون | number / null | قد يكون فارغًا |
| exp | نقاط الخبرة | number | - |
| level | المستوى الحالي | number | - |
| until_next_level_exp | نقاط الخبرة للمستوى التالي | number | - |
| current_level_exp | نقاط الخبرة المكتسبة في المستوى الحالي | number | - |
| type | نوع المهارة | number | - |
| status | حالة المهارة | number | `0` = عادي، `1` = مخفي |

#### `content://net.sarasarasa.lifeup.provider.api/skill_groups`

يُرجع مجموعات المهارات الظاهرة فقط.

| العمود | المعنى | النوع | ملاحظات |
| ------ | ------- | ---- | ----- |
| _ID | معرّف مجموعة المهارات | number | - |
| content | اسم المجموعة | string | - |
| order | ترتيب خام | number | `orderInCategory` |
| collapsed | حالة الطي | string | يُرجع كنص `true` / `false` |

<br/>

## المساهمة

SDK وLifeUp Cloud وLifeUp Desktop مشاريع مفتوحة المصدر.

يمكنك الحصول على الكود المصدري من:

- [Ayagikei/LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop](https://github.com/Ayagikei/LifeUp-Desktop)
