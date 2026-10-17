# مرجع HTTP API :id=http-query-reference

يوثّق هذا المرجع معاملات طلبات LifeUp Cloud ونماذج استجابة HTTP كاملة. ابدأ بدليل [LifeUp Cloud](/guide/api_cloud) للتثبيت والأذونات والاتصال. تتطلب مسارات السجلات الأحدث LifeUp **1.106.0+** وLifeUp Cloud **3.0.0+**؛ استخدم `/info` لمعرفة الإصدارات المثبتة. يصف المرجع عقود المصدر الحالية ولا يثبت إتاحة إصدار معين.

## فهرس الواجهات :id=interface-index

| المورد | الطرق والمسارات | المعاملات والنموذج |
| --- | --- | --- |
| القواعد المشتركة | استجابات JSON والأذونات وشروط التخزين المؤقت والصفحات | [القواعد](#representations)، [التخزين والإذن](#auth-cache)، [الصفحات](#pagination) |
| المهام | `GET /tasks`, `GET /tasks/{categoryId}`, `GET /tasks_categories` | [الاستعلامات](#get-tasks)، [نموذج المهمة](#task-fields)، [الفئات](#get-tasks-categories) |
| سجل المهام | `GET /history` | [المعاملات](#get-history)، [الأوقات](#task-times)، [التقارير اليومية](#daily-report) |
| العناصر | `GET /items`, `GET /items/{listId}`, `GET /items_categories` | [معرّفات العناصر والفئات والنماذج الكاملة](#get-items) |
| المهارات | `GET /skills`, `GET /skill_groups` | [المهارات والمجموعات](#get-skills) |
| الإنجازات | `GET /achievements`, `GET /achievements/{id}`, `GET /achievement_categories`, `GET /achievement_conditions/{id}` | [الإنجازات والشروط](#get-achievements) |
| التصنيع | `GET /synthesis`, `GET /synthesis/{id}`, `GET /synthesis_categories`, `GET /synthesis_categories/{id}` | [الوصفات والفئات](#get-synthesis) |
| المشاعر | `GET /feelings` | [صفحات المشاعر](#get-feelings) |
| EXP / العملات | `GET /exp_records`, `GET /coin_records` | [معاملات السجلات ونماذجها](#reward-journals) |
| سجلات أخرى | `GET /pomodoro_records`, `GET /inventory_records`, `GET /step_records` | [بومودورو](#get-pomodoro-records)، [المخزون](#get-inventory-records)، [الخطوات](#get-step-records) |
| المستويات / الإحصاءات | `GET /level_defines`, `GET /statistics` | [المستويات](#get-level-defines)، [الإحصاءات](#get-statistics) |
| التطبيق / الرصيد | `GET /info`, `GET /coin` | [معلومات الإصدار](#get-info)، [نتيجة العملات](#get-coin) |
| استدعاء الإجراءات | `GET` / `POST /api`, `GET` / `POST /api/contentprovider` | [جسر الاستدعاء](#invoke-api)؛ تبقى طرق العمل في [دليل URL Scheme](/guide/api) |
| الملفات / النسخ | `GET /files/{url}`, `POST /files/upload`, `GET /data/export`, `POST /data/import` | [الملفات](#files-download)، [نقل النسخ](#files-backup) |
| الأحداث | `GET /events`, WebSocket `/events` | [الاستطلاع والأحداث الحية](#get-events) |
| صفحة البداية | `GET /` | مقدمة HTML وليست مورد JSON. |

يستخدم MCP تمثيلًا منفصلًا للعميل/الأدوات؛ راجع [اختلافات MCP](#mcp-differences) و[دليله](/guide/api_mcp).

## النقل وتمثيل البيانات :id=representations

| الواجهة | التمثيل | الفرق المهم |
| --- | --- | --- |
| استعلامات Cloud عبر HTTP | JSON ضمن الغلاف `{code, message, data}` | تصف مراجع نقاط النهاية أدناه صيغة JSON العامة هذه. |
| Android ContentProvider | أعمدة Cursor مثل `_ID` / `_GID`، تحتوي أحيانًا على نص JSON | يحوّل محلل SDK هذه الأعمدة إلى حقول HTTP مثل `id` / `gid` ومصفوفات متداخلة. لا تستخدم تعريفات أعمدة Cursor بوصفها مخطط HTTP. |
| إجراءات URL Scheme | `lifeup://api/{method}` ومعاملات/نتائج خاصة بكل أسلوب | قد تستخدم معاملات الكتابة snake_case حتى عندما تستخدم حقول القراءة عبر HTTP صيغة camelCase. |
| أدوات القوائم في MCP | غلاف خاص بالأداة وسجلات مختصرة أو مفصلة | ترقيم الصفحات وحقول الإخراج في MCP سلوك إضافي للعميل، وليسا حقولًا في استجابة HTTP. |

## الاستجابات والأخطاء :id=response-errors

غلاف JSON المشترك عبر HTTP هو `HttpResponse<T>`:

| الحقل | النوع | المعنى |
| --- | --- | --- |
| `code` | integer | `200` عند نجاح الاستعلام؛ وتشير أي قيمة غير `200` إلى خطأ. هذا حقل في جسم الاستجابة، منفصل عن حالة HTTP. |
| `message` | string | عادةً `success` عند النجاح؛ ووصف الخطأ في غير ذلك. |
| `data` | `T` أو `null` | قيمة خاصة بالمسار (مصفوفة أو كائن أو سلسلة) عند النجاح؛ `null` عند الخطأ. |

مثال على قائمة فارغة ناجحة:

```json
{"code":200,"message":"success","data":[]}
```

مثال توضيحي لخطأ الإذن/الوصول إلى المزوّد:

```json
{"code":10001,"message":"Cursor is null, check if LifeUp is installed and running and you have granted the permission","data":null}
```

| الإشارة | كيفية التعامل معها |
| --- | --- |
| HTTP `401` | أرسل رمز Cloud المهيّأ بوصفه القيمة الخام لترويسة `Authorization`. لا تضف `Bearer`. |
| `code = 10001` في الجسم | تحقّق من تثبيت LifeUp وتشغيله ومن منح Cloud إذن قراءة بيانات LifeUp. |
| `code = 10002` في الجسم | فشل استعلام ContentProvider؛ افحص رسالة الخطأ. |
| أي حالة/رمز آخر لا يدل على النجاح | اعتبر الاستعلام فاشلًا، لا نتيجة فارغة. |

افحص **كلًا من** حالة HTTP و`code` في الجسم. تستخدم بعض أخطاء المسارات حالة HTTP `200` مع رمز خطأ في الجسم. وتتطلب الإجراءات عبر `/api/contentprovider` أيضًا فحص كل `data[].result.api_result`؛ فقيمة `code=200` في الغلاف لا تثبت نجاح جميع الإجراءات.

## الأذونات والقراءات الشرطية :id=auth-cache

عند ضبط رمز Cloud أرسل قيمته الخام المطابقة في `Authorization` دون `Bearer`. يقبل الخادم أيضًا معامل `token`، بما فيه عملاء WebSocket الذين لا يضبطون ترويسة. الرمز الغائب أو الخاطئ يعيد HTTP `401` و`code=401` في الجسم. يشمل الفحص صفحة البداية والموارد والجسر والملفات والنسخ والأحداث.

تضيف قراءات موارد JSON الناجحة `ETag` قويًا بـ SHA-256 و`Cache-Control: private, no-cache`. يشمل ذلك المهام/السجل والعناصر/الفئات والمهارات/المجموعات والإنجازات/الشروط والمشاعر والتصنيع/الفئات والسجلات والمستويات والإحصاءات والمعلومات والعملات؛ ولا يشمل جسر الاستدعاء أو نقل الملفات والنسخ أو بث/استطلاع الأحداث.

| ترويسة الطلب | السلوك الحالي للاستجابة |
| --- | --- |
| `If-Match` | الإصدار غير المطابق يفشل بـ HTTP `412`؛ يُقيّم قبل `If-None-Match`. |
| `If-None-Match` | الإصدار المطابق يعيد HTTP `304` دون جسم JSON؛ أعد استخدام التمثيل الناجح المخزّن. |

لا تحتوي أغلفة الأخطاء ترويسة إصدار المورد. القراءة الشرطية تخص طلب مورد واحد وليست لقطة أو معاملة عبر صفحات أو مسارات.

يمكن لطلبات المتصفح عبر الأصول استخدام `If-None-Match`. لا يسمح إعداد CORS الحالي بـ `If-Match` في الفحص التمهيدي؛ لا تعتمد عليه عبر الأصول قبل تعديل التنفيذ. العملاء الأصليون غير خاضعين لـ CORS المتصفح.

## اتفاقيات البيانات المشتركة :id=data-conventions

| الاتفاقية | القاعدة |
| --- | --- |
| الوقت | تستخدم حقول الطوابع الزمنية مللي ثانية Unix. تعتمد حدود اليوم التقويمي على المنطقة الزمنية المقصودة. وتظل لكل حقل دلالته الخاصة بالمورد. |
| الهوية | يحدد `id` للمهمة مهمة/دورة واحدة؛ ويحدد `gid` مجموعتها عبر الدورات المتكررة. أما معرّف الفئة/القائمة فيحدد موردًا منفصلًا. |
| القيم الفارغة | الغياب و`null` و`0` و`""` و`[]` حالات مختلفة. يوثّق كل نموذج سلوكه الفعلي بشأن القيم البديلة أو الحذف. |
| المعرّفات العددية | قد تكون المعرّفات أعدادًا صحيحة موقعة من 64 بت؛ لا يمثل JavaScript Number جميع القيم بدقة. استخدم محلّل JSON مناسبًا للحفاظ على المعرّفات الكبيرة. |
| المصفوفات والكائنات | القيم المتداخلة في HTTP، مثل `items` و`subTasks`، مصفوفات وليست سلاسل نصية تحتوي JSON. |
| رموز الحالات والأسباب | استخدم التعداد الموثّق لكل مورد. تنتمي حالة المهمة وحالة الإنجاز ورموز أسباب السجلات إلى نطاقات مختلفة. |

راجع [تعريفات الطوابع الزمنية للمهام](/guide/api-reference?id=task-times) لمعرفة `startTime` و`deadline` و`endTime`.

## ترقيم الصفحات والتصفية :id=pagination

ترقيم الصفحات قدرة تخص نقطة النهاية، وليس خاصية لكل قائمة. تحتوي استجابات قوائم HTTP الخام على `data: [...]`؛ وهي **لا** تضيف `total` أو `count` أو `hasMore`.

| نقطة نهاية HTTP | ترقيم الصفحات | نطاق التاريخ | تصفية أخرى |
| --- | --- | --- | --- |
| `/tasks`, `/tasks/{categoryId}` | لا؛ مصفوفة كاملة | لا | فئة اختيارية في المسار |
| `/history` | `offset` / `limit` على الخادم | لا | `gid` اختياري |
| `/feelings` | `offset` / `limit` على الخادم | لا | راجع [المشاعر](#get-feelings) |
| `/pomodoro_records`, `/coin_records`, `/inventory_records`, `/exp_records`, `/step_records` | `offset` / `limit` على الخادم | `time_range_start` / `time_range_end` | راجع نقطة النهاية المحددة |
| `/statistics` | لا؛ كائن واحد | `time_range_start` / `time_range_end` | استعلام تجميعي |
| `/coin`, `/info` | لا؛ كائن واحد | لا | استعلام مورد مفرد |

في نقاط النهاية التي تدعم الصفحات، القيم الافتراضية عبر HTTP هي `offset=0` و`limit=100`. استخدم إزاحات غير سالبة وأحجام صفحات ضمن `1..100` في حلقة الصفحات المشتركة. لا يطبّق جسر HTTP قيد MCP البالغ `1..100`، وقد تفرض المزوّدات اللاحقة حدودًا أخرى؛ راجع ملاحظات حجم الصفحة الفعلي والتحقق لكل نقطة نهاية.

باستثناء [قيد بومودورو المصفّى زمنيًا](#get-pomodoro-records)، زِد `offset` بعد كل صفحة ناجحة بعدد السجلات المعادة. توقف إذا قل العدد عن الحجم الفعلي (أي `limit` المطلوب عند استخدام `1..100`، باستثناء بومودورو المصفّى زمنيًا). لا تخلط صفحة قيدها المزوّد بآخر صفحة. الصفحة الفارغة بعد النهاية طبيعية. لا تنشئ الصفحات المتعددة لقطة وقد تتغير السجلات أثناء الاستعلام.

في SDK HTTP الحالي، لا تُمرَّر حدود التاريخ إلا إذا أمكن تحليل **كليهما** كعدد صحيح وتحقق `start < end`. يؤدي إرسال حد واحد أو قيمة غير قابلة للتحليل أو حدود معكوسة إلى استعلام بلا تصفية؛ لا تعتمد على ظهور خطأ لاكتشاف ذلك. تحقّق من الحدين قبل الإرسال. يوضح مرجع السجلات أن نقاط نهايتها تشمل الحدين.

## اختلافات MCP :id=mcp-differences

تستخدم أدوات القوائم في MCP القيمة الافتراضية `limit=20`، وتقيّدها إلى `1..100`، وتقيّد `offset` بحيث لا يقل عن `0`. ترسل معاملات الصفحات إلى الموارد التي يرقّمها الخادم مثل السجل/سجلات المعاملات، لكنها تجلب مصفوفات HTTP كاملة وتقتطعها محليًا لموارد مثل المهام. تنتمي `items` و`count` و`hasMore` و`total` الاختياري إلى غلاف MCP. كما يزيل `detail=false` حقولًا من كل سجل؛ استخدم `detail=true` عند الحاجة إلى نموذج HTTP الكامل.

## المصادر ونطاق الإصدارات :id=api-common-sources

تصف هذه المراجع SDK العام الحالي وسلوك مزوّد LifeUp المقابل. تستخدم الأمثلة بيانات مختلقة. روابط المصدر مراجع للتنفيذ، وليست إثباتًا بأن إصدارًا مثبتًا بعينه يحتوي جميع الحقول: [مسارات HTTP](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt)، [غلاف HTTP](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/vo/HttpResponse.kt)، [ربط استعلامات MCP](https://github.com/Ayagikei/LifeUp-SDK/blob/main/mcp/src/query.ts).

## نماذج بيانات المهام والسجل :id=task-history-models

تعرّف هذه الصفحة **JSON عبر HTTP** الذي تعيده [استعلامات المهام/السجل](/guide/api-reference?id=task-queries). قد تختلف أسماء أعمدة Android Cursor ومعاملات إجراءات URL Scheme وتمثيلاتها؛ راجع [الاتفاقيات المشتركة](/guide/api-reference?id=representations).

يستخدم SDK صنف `Task` واحدًا للتسلسل لتمثيل عرضين. يشير `Task` هنا إلى عرض `/tasks`، ويشير `HistoryRecord` إلى عرض `/history`. تصف هذه الأسماء المخرجات الموجودة ولا تضيف API أخرى. يتضمن تسلسل Cloud الحالي القيم الافتراضية وحقول `null`.

### حقول Task / HistoryRecord :id=task-fields

تظهر جميع الحقول أدناه في كائن HTTP الحالي. غالبًا ما تُحوّل قيم المزوّد الغائبة إلى القيم البديلة المذكورة؛ ولا تثبت القيمة البديلة أن بيانات المصدر احتوت تلك القيمة.

| الحقل | نوع JSON | المعنى / القيمة البديلة |
| --- | --- | --- |
| `id` | integer أو `null` | معرّف هذه المهمة/الدورة. |
| `gid` | integer أو `null` | معرّف مجموعة المهمة المشترك عبر الدورات المتكررة. |
| `name` | string | اسم المهمة. يتحول اسم المزوّد الغائب إلى `ERROR: name is null`. |
| `notes` | string | الملاحظات؛ سلسلة فارغة عند الغياب. |
| `status` | integer | حالة المهمة؛ القيمة الافتراضية عند الغياب `0`. راجع جدول الحالات أدناه. |
| `startTime` | integer | وقت البدء المهيّأ بالمللي ثانية؛ القيمة البديلة في SDK هي `0`. |
| `deadline` | integer | وقت الاستحقاق بالمللي ثانية؛ القيمة البديلة في SDK عند الغياب `0`. |
| `remindTime` | integer | وقت التذكير بالمللي ثانية؛ القيمة البديلة في SDK عند الغياب `0`. |
| `frequency` | integer | رمز التكرار؛ `0` لمرة واحدة، `1` يوميًا، `-1` بلا حد. تصف [إجراءات المهام](/guide/api) أوضاع التكرار الأخرى. القيمة البديلة في SDK هي `0`. |
| `weekdays` | string | اختيار أيام الأسبوع، مثل `1,3,5` (الاثنين `1`، الأحد `7`)؛ فارغ عند عدم توفيره، وقيمة نائبة فارغة ثابتة في السجل. |
| `exp` | integer | مكافأة EXP المهيّأة، وليست مقدار معاملة؛ الافتراضي `0`. |
| `skillIds` | مصفوفة integer | السمات المرتبطة بالمكافأة؛ مصفوفة فارغة إذا لم تتوفر. |
| `coin` | integer | مكافأة العملات المهيّأة؛ الافتراضي `0`. |
| `coinVariable` | integer | إعداد مكافأة العملات العشوائية؛ الافتراضي `0`. |
| `itemId` | integer | الحقل القديم لمعرّف أول عنصر مكافأة؛ الافتراضي `0`. استخدم `items` للقائمة الكاملة. |
| `itemAmount` | integer | الحقل القديم لكمية أول عنصر مكافأة؛ الافتراضي `0`. يختلف اسم HTTP هذا عن عمود المزوّد `itemCount`. |
| `words` | string | النص التحفيزي عند الإكمال؛ فارغ عند الغياب. |
| `categoryId` | integer | معرّف فئة/قائمة المهمة؛ الافتراضي `0` عند الغياب. |
| `order` | integer | قيمة ترتيب المهمة في القائمة؛ قيمة نائبة ثابتة `0` في السجل لأن مزوّده لا يعيد هذا العمود. |
| `nameExtended` | string | اسم العرض الموسّع؛ قيمة نائبة فارغة ثابتة في السجل لأن مزوّده لا يعيد هذا العمود. |
| `endTime` | integer | وقت الانتهاء المسجّل في السجل. يملؤه `/tasks` بالقيمة `0`؛ راجع [دلالات الوقت](/guide/api-reference?id=task-times). |
| `items` | `RewardItem[]` | مكافآت العناصر؛ مصفوفة فارغة إذا لم تتوفر. |
| `subTasks` | `SubTask[]` | المهام الفرعية المتداخلة؛ مصفوفة فارغة إذا لم تتوفر. |
| `countProgress` | `TaskCountProgress` أو `null` | لقطة لتقدم العدّ عند توفرها؛ قد تظهر في كلا العرضين. |
| `repeatEndCondition` | `TaskRepeatEndCondition` أو `null` | قاعدة إنهاء التكرار في `/tasks`؛ دائمًا `null` في `/history`. |

### حالة المهمة والطوابع الزمنية :id=task-times

| `status` | المعنى | معنى `endTime` في السجل |
| --- | --- | --- |
| `0` | غير مكتملة | ليس وقت إكمال؛ إذ يختار `/history` السجلات المنتهية. |
| `1` | مكتملة | وقت الإكمال المسجّل. |
| `2` | متأخرة | وقت التأخر المسجّل. |
| `3` | تم التخلي عنها | وقت التخلي المسجّل. |

| حقل الوقت | التعريف |
| --- | --- |
| `startTime` | وقت بدء المهمة المهيّأ/المجدول، وليس وقت بدء المستخدم العمل فعليًا. |
| `deadline` | وقت الاستحقاق المجدول، وهو منفصل عن وقت الانتهاء المسجّل. |
| `endTime` | الوقت المسجّل لانتهاء المهمة في السجل؛ يُفسّر مع `status` كما سبق. |

تستخدم الحقول الثلاثة مللي ثانية Unix. عند الإكمال العادي، يسجّل App الوقت الحالي. يأخذ `history_operation` مع `operation=edit_completed_time` المدخل `completed_time` ويعدّل وقت الإكمال المحفوظ نفسه؛ وتظل قراءة السجل تعيد اسم الحقل `endTime`.

يمكن تعديل الأوقات المحفوظة. إذا لم يكن للسجل المنتهي تاريخ انتهاء محفوظ، يستخدم App الوقت الحالي كقيمة بديلة. لذلك فإن `endTime` هو الوقت المسجّل حاليًا، وليس طابع تدقيق ثابتًا لا يتغير. أما `0` في `/tasks` فمجرد قيمة نائبة من SDK، وليس حدثًا حقيقيًا عند بداية حقبة Unix.

### RewardItem :id=reward-item

| الحقل | نوع JSON | المعنى |
| --- | --- | --- |
| `itemId` | integer | معرّف عنصر المكافأة. |
| `itemCount` | integer | كمية المكافأة. |

```json
{"itemId":7,"itemCount":1}
```

### SubTask :id=subtask

| الحقل | نوع JSON | المعنى / الافتراضي |
| --- | --- | --- |
| `id` | integer | معرّف المهمة الفرعية. |
| `gid` | integer | معرّف مجموعة المهام الفرعية. |
| `todo` | string | نص المهمة الفرعية. |
| `status` | integer | `0` غير مكتملة، `1` مكتملة. |
| `remindTime` | integer أو `null` | طابع التذكير الزمني بالمللي ثانية؛ `null` إذا لم يتوفر. |
| `endTime` | integer أو `null` | طابع إكمال المهمة الفرعية الزمني بالمللي ثانية؛ `null` إذا لم يتوفر. |
| `exp` | integer | مكافأة EXP المهيّأة. |
| `coin` | integer أو `null` | مكافأة العملات المهيّأة. |
| `coinVariable` | integer أو `null` | إعداد مكافأة العملات العشوائية. |
| `items` | `RewardItem[]` | مكافآت العناصر؛ الافتراضي مصفوفة فارغة. |
| `order` | integer أو `null` | قيمة الترتيب؛ الافتراضي في النموذج `0`. |
| `autoUseItem` | boolean أو `null` | هل تُستخدم المكافآت تلقائيًا؛ الافتراضي في النموذج `false`. |

```json
{
  "id":201,"gid":20,"todo":"Read ten pages","status":1,
  "remindTime":null,"endTime":1792072800000,"exp":2,
  "coin":0,"coinVariable":0,"items":[{"itemId":7,"itemCount":1}],
  "order":0,"autoUseItem":false
}
```

### TaskCountProgress :id=count-progress

| الحقل | نوع JSON | المعنى |
| --- | --- | --- |
| `currentCount` | integer | العدد الحالي لهذه المهمة/الدورة. |
| `targetCount` | integer | العدد المستهدف لهذه المهمة/الدورة. |

```json
{"currentCount":2,"targetCount":5}
```

### TaskRepeatEndCondition :id=repeat-end-condition

| الحقل | نوع JSON | المعنى / الافتراضي |
| --- | --- | --- |
| `mode` | string | `COUNT` أو `DATE`. هذه سلاسل جهة القراءة، وليست معاملات الإجراءات الرقمية. |
| `behavior` | string | `TERMINATE` أو `FREEZE`. |
| `targetCycleCount` | integer أو `null` | عدد الدورات المستهدف لـ`COUNT`؛ الافتراضي `null`. |
| `endDateMillis` | integer أو `null` | طابع تاريخ الانتهاء الزمني بالمللي ثانية لـ`DATE`؛ الافتراضي `null`. |
| `inclusive` | boolean | علامة شمول تاريخ الانتهاء؛ الافتراضي `false`. |

```json
{"mode":"COUNT","behavior":"TERMINATE","targetCycleCount":10,"endDateMillis":null,"inclusive":false}
```

### مقادير المكافآت :id=reward-amounts

تصف حقول المهام والمهام الفرعية هذه المكافآت المهيّأة. قد تغيّر المضاعفات والعملات العشوائية وقواعد التسوية المكافأة الفعلية. استخدم [سجلات EXP والعملات](/guide/api-reference?id=reward-journals) لمعرفة مقادير المعاملات، وميّز المكافآت الموجبة عن صافي التغيرات الذي يشمل العكس أو العقوبات.

### مراجع التنفيذ :id=api-task-model-sources

[Task](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/Task.kt) · [المحلل](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TasksApi.kt) · [SubTask](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/SubTask.kt) · [RewardItem](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/common/RewardItem.kt) · [تقدم العدّ](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TaskCountProgress.kt) · [قاعدة التكرار](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TaskRepeatEndCondition.kt).

## استعلامات المهام والسجل :id=task-queries

اقرأ [الاتفاقيات المشتركة](/guide/api-reference?id=http-query-reference) و[نموذج Task/History الكامل](/guide/api-reference?id=task-history-models). تتطلب نقاط النهاية هذه إذن قراءة بيانات LifeUp في Cloud. استعلامات القوائم الأساسية موثّقة لـLifeUp v1.91+ مع أحدث Cloud؛ وتصف الأمثلة حقول SDK الحالي. افحص `/info` عند التكامل مع تثبيتات أقدم.

### GET /tasks و/tasks/{categoryId} :id=get-tasks

استعلم عن قائمة المهام الحالية **غير المكتملة**، مع إمكانية تقييدها بفئة/قائمة. النتيجة مصفوفة كاملة، وليست استجابة يرقّم الخادم صفحاتها. تنتمي السجلات المكتملة والمتأخرة والمتروكة إلى `/history`.

| المعامل | الموضع | النوع | مطلوب | الافتراضي / السلوك |
| --- | --- | --- | --- | --- |
| `categoryId` | المسار | integer | فقط لـ`/tasks/{categoryId}` | احذف مقطع المسار كله للحصول على قائمة المهام غير المقيّدة. |

لا تدعم هذه المسارات معاملات الاستعلام `offset` أو `limit` أو `gid` أو نطاق التاريخ. يُحلّل مقطع الفئة غير الصحيح عدديًا حاليًا كما لو لم تُحدّد فئة؛ تحقّق منه قبل الطلب حتى لا تستعلم عن جميع المهام دون قصد.

```text
GET http://{host:port}/tasks
GET http://{host:port}/tasks/1
```

**الاستجابة:** `HttpResponse<Task[]>`. تُعرّف جميع حقول السجلات والبنى المتداخلة في [حقول Task/History](/guide/api-reference?id=task-fields). يوضح السجل المختلق التالي بنية HTTP الكاملة في المستوى الأعلى؛ و`endTime=0` قيمة نائبة لهذا المسار، وليس طابع إكمال زمنيًا.

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

**السلوك والأخطاء:** يتبع اختيار القائمة وترتيبها منطق قائمة المهام في LifeUp؛ ولا تضمن نقطة النهاية الترتيب بحسب وقت الإكمال. تعني الاستجابة الناجحة `data: []` أن قائمة المهام المحددة لم تُعد سجلات. تستخدم أخطاء الإذن/المزوّد [غلاف الأخطاء المشترك](/guide/api-reference?id=response-errors)، وليست مصفوفات فارغة. لتقارير الإكمال، استخدم `/history` أدناه بدلًا من `endTime` في هذا المسار.

### GET /history :id=get-history

استعلم عن سجلات المهام المنتهية المرئية، بما فيها المهام المكتملة والمتأخرة والمتروكة. يُستبعد السجل المحذوف.

| المعامل | الموضع | النوع | مطلوب | الافتراضي / السلوك |
| --- | --- | --- | --- | --- |
| `offset` | الاستعلام | integer | لا | `0`؛ عدد السجلات المطلوب تجاوزها، بدءًا من الصفر. |
| `limit` | الاستعلام | integer | لا | `100`؛ اطلب حجم صفحة موجبًا، ويفضل `1..100`. |
| `gid` | الاستعلام | integer | لا | بلا تصفية مجموعة؛ وعند توفيره يختار مجموعة المهمة تلك عبر الدورات. |

يستخدم محلل HTTP القيم البديلة `0` / `100` عندما يتعذر تحليل `offset` / `limit`، ويسقط `gid` غير القابل للتحليل. لا يقيّد هذا المسار الأرقام التي تُحلّل بنجاح. تحقّق بنفسك من أن الإزاحات غير سالبة والحدود موجبة. `time_range_start` / `time_range_end` **غير مدعومين**؛ وإرسالهما لا يصفي السجل.

```text
GET http://{host:port}/history?offset=0&limit=100
GET http://{host:port}/history?offset=0&limit=100&gid=10
```

**الاستجابة:** `HttpResponse<HistoryRecord[]>` باستخدام [حقول Task/History المنقولة](/guide/api-reference?id=task-fields). `HistoryRecord` اسم توثيقي لعرض السجل من نموذج `Task` في SDK. يكون `repeatEndCondition` مساويًا لـ`null` في هذا العرض؛ وقد يتوفر `countProgress`. يُفسّر `endTime` المحفوظ بالاقتران مع `status`.

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

**الترتيب:** تاريخ الانتهاء المحفوظ تنازليًا، الأحدث أولًا. لا توجد قاعدة موثّقة لكسر التعادل عند تساوي تواريخ الانتهاء. ترقيم الصفحات ليس لقطة ثابتة؛ تجنّب تعديل البيانات أثناء جمع التقرير، وأزل السجلات المكررة بحسب `id` عند دمج الصفحات.

**الصفحات والنتائج الفارغة:** استخدم [إجراء الصفحات المشترك](/guide/api-reference?id=pagination). تعني المصفوفة الفارغة الناجحة أنه لا توجد سجلات مرئية مطابقة لهذه الصفحة/المجموعة، بما في ذلك عندما يتجاوز `offset` النهاية. ولا تثبت أن أي نشاط لم يحدث قط: فالسجلات المحذوفة مستبعدة ولا توجد علامة اكتمال. إذا فشل أي طلب، أبلغ عن بيانات غير متاحة/غير مكتملة بدلًا من صفر مهام. تنطبق [الأخطاء المشتركة](/guide/api-reference?id=response-errors).

### إنشاء تقرير يومي :id=daily-report

1. اختر المنطقة الزمنية للتقرير. احسب بداية اليوم التقويمي (`dayStart`) وبداية اليوم التقويمي التالي (`nextDayStart`). لا تفترض أن كل يوم محلي يساوي 24 ساعة بالضبط.
2. اقرأ `/history` باستخدام `offset=0&limit=100`، وافحص كل استجابة، واجمع جميع الصفحات. حافظ على ثبات أي تصفية مقصودة بـ`gid`.
3. اختر `status == 1` و`dayStart <= endTime < nextDayStart`. استخدم [قيود الوقت المسجّل](/guide/api-reference?id=task-times) عند وصف النتائج.
4. لمعرفة تغيّرات EXP والعملات الفعلية، اقرأ [سجلات المكافآت](/guide/api-reference?id=reward-journals) لليوم نفسه. تشمل مرشحات التاريخ كلا الحدين، لذا استخدم `time_range_start=dayStart` و`time_range_end=nextDayStart-1`.
5. ميّز بين «لم تُعثر على سجلات في البيانات المتاحة» وبين قراءة فاشلة/غير مكتملة. حدّد هل يعرض التقرير المكافآت الموجبة فقط أم صافي التغيرات بما فيها العكس، وطبّق الخيار باستمرار.

يمثل `exp` و`coin` في المهام/السجل المكافآت المهيّأة؛ وليسا بديلًا موثوقًا لمقادير السجلات. تعديل وقت الإكمال إلى يوم آخر لا يعني انتقال وقت المعاملة في سجل المكافآت معه.

### مراجع التنفيذ :id=api-task-queries-sources

[مسارات HTTP](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt) · [تحليل المهام والسجل](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TasksApi.kt).

## استعلامات سجلات EXP والعملات :id=reward-journals

تتطلب نقاط نهاية HTTP هذه، المخصصة للقراءة فقط، إذن قراءة بيانات LifeUp وLifeUp **1.106.0+** وLifeUp Cloud **3.0.0+**. تعيد التغيّرات المسجّلة، بما فيها النقصان والعكس، بدلًا من إعداد مكافأة المهمة. اقرأ [الاتفاقيات المشتركة](/guide/api-reference?id=http-query-reference) أولًا.

### معاملات الطلب لنقطتي النهاية :id=journal-parameters

ينطبق العقد التالي تحديدًا على **كلتا** نقطتي النهاية `GET /exp_records` و`GET /coin_records`.

| المعامل | الموضع | النوع | مطلوب | الافتراضي / السلوك الفعلي |
| --- | --- | --- | --- | --- |
| `offset` | الاستعلام | integer | لا | الافتراضي عبر HTTP هو `0`؛ يقيّد المزوّد القيم السالبة إلى `0`. |
| `limit` | الاستعلام | integer | لا | الافتراضي عبر HTTP هو `100`؛ يقيّده المزوّد إلى `1..200`. استخدم `1..100` لإجراء الصفحات المشترك. |
| `time_range_start` | الاستعلام | integer (مللي ثانية Unix) | لا، أو مع قرينه | الحد الأدنى المشمول لوقت المعاملة المسجّل. |
| `time_range_end` | الاستعلام | integer (مللي ثانية Unix) | لا، أو مع قرينه | الحد الأعلى المشمول؛ تتطلب التصفية الصحيحة `start < end`. |

تستخدم قيم الصفحات غير القابلة للتحليل أو الخارجة عن النطاق القيم الافتراضية عبر HTTP. وتصبح قيم التاريخ غير القابلة للتحليل غائبة. لا يمرّر SDK الحالي نطاق التاريخ إلا إذا وُجد الحدان وتحقق `start < end`؛ وإلا يستعلم **دون مرشح تاريخ**. للتحقق من النطاقات غير الصحيحة في استدعاءات ContentProvider الخام المباشرة سلوك مختلف. تحقّق من الحدود في عميل HTTP المستدعي.

ترتّب نقطتا النهاية النتائج بحسب وقت المعاملة المسجّل تنازليًا، الأحدث أولًا، وتستبعدان إدخالات السجلات المحذوفة. ولا تضمنان كسر التعادل بالمعرّف أو لقطة ثابتة عبر صفحات متعددة. اتبع [ترقيم الصفحات](/guide/api-reference?id=pagination)، مع مراعاة الحد الفعلي للمزوّد. تعني المصفوفة الفارغة الناجحة عدم مطابقة أي إدخال للنطاق/الصفحة المحددة؛ والقراءة الفاشلة لا تعني انعدام النشاط. لا توفر أي من النقطتين علامة اكتمال للبيانات المحذوفة أو غير المتاحة.

### GET /exp_records :id=get-exp-records

استعلم عن تغيّرات EXP. المعاملات هي بالضبط [معاملات السجلات الأربعة أعلاه](/guide/api-reference?id=journal-parameters)؛ لا توجد تصفية بـ`gid`.

```text
GET http://{host:port}/exp_records?offset=0&limit=100&time_range_start=1792022400000&time_range_end=1792108799999
```

**الاستجابة:** `HttpResponse<ExpRecord[]>`. يتضمن التسلسل الحالي جميع الحقول المذكورة، بما فيها القيم التي تقبل null.

| الحقل | نوع JSON | المعنى / القيمة البديلة للمحلل |
| --- | --- | --- |
| `id` | integer أو `null` | معرّف إدخال السجل. |
| `time` | integer أو `null` | وقت المعاملة بمللي ثانية Unix، وهو منفصل عن وقت إكمال المهمة القابل للتعديل. |
| `value` | integer | تغيّر EXP لكل سمة مرتبطة؛ القيمة البديلة `0`. استخدم `isDecrease` للاتجاه. |
| `isDecrease` | boolean | `true` للنقصان، و`false` للزيادة؛ يعامل المحلل عدد المزوّد الصحيح `1` بوصفه true. |
| `totalValue` | integer | إجمالي تغيّر EXP المسجّل، **وليس رصيد EXP**؛ القيمة البديلة `0`. قد تتداخل دفعات السمات المتعددة في هذا الإجمالي المخزّن؛ راجع [إجماليات التقارير](/guide/api-reference?id=journal-totals). |
| `resCode` | integer | رمز سبب خاص بـEXP؛ القيمة البديلة `0`. |
| `relatedId` | integer أو `null` | معرّف كائن المصدر المرتبط. عند إكمال مهمة عاديًا، يكون `id` لسجل المهمة، لا `gid` الخاص بها. قد تشير الأسباب الأخرى إلى موارد أخرى. |
| `content` | string أو `null` | وصف التغيّر. |
| `skillIds` | مصفوفة integer | معرّفات السمات/المهارات المرتبطة؛ القيمة البديلة مصفوفة فارغة. |
| `relatedAttributes` | مصفوفة string | السلاسل القديمة للسمات المرتبطة؛ القيمة البديلة مصفوفة فارغة. |

مثال مختلق: تطبيق 10 EXP على كل من سمتين، بإجمالي 20 EXP.

```json
{
  "code":200,"message":"success","data":[{
    "id":301,"time":1792072800000,"value":10,"isDecrease":false,
    "totalValue":20,"resCode":1,"relatedId":100,"content":"Task completed",
    "skillIds":[2,3],"relatedAttributes":[]
  }]
}
```

**الأخطاء:** [أخطاء HTTP/المزوّد المشتركة](/guide/api-reference?id=response-errors). قد تلغي حدود التاريخ غير الصحيحة عبر HTTP التصفية بصمت كما سبق، بدلًا من إنتاج خطأ.

### GET /coin_records :id=get-coin-records

استعلم عن تغيّرات العملات. المعاملات هي بالضبط [معاملات السجلات الأربعة أعلاه](/guide/api-reference?id=journal-parameters)؛ لا توجد تصفية بـ`gid`.

```text
GET http://{host:port}/coin_records?offset=0&limit=100&time_range_start=1792022400000&time_range_end=1792108799999
```

**الاستجابة:** `HttpResponse<CoinRecord[]>`. يتضمن التسلسل الحالي جميع الحقول المذكورة، بما فيها القيم التي تقبل null.

| الحقل | نوع JSON | المعنى / القيمة البديلة للمحلل |
| --- | --- | --- |
| `id` | integer أو `null` | معرّف إدخال السجل. |
| `time` | integer أو `null` | وقت المعاملة بمللي ثانية Unix. |
| `value` | integer | مقدار تغيّر العملات؛ القيمة البديلة `0`. استخدم `isDecrease` للاتجاه. |
| `isDecrease` | boolean | `true` للنقصان، و`false` للزيادة؛ يعامل المحلل عدد المزوّد الصحيح `1` بوصفه true. |
| `totalValue` | integer | رصيد العملات بعد العملية؛ القيمة البديلة `0`. بخلاف `totalValue` في EXP، هذه قيمة رصيد. |
| `resCode` | integer | رمز سبب خاص بالعملات؛ القيمة البديلة `0`. |
| `relatedId` | integer أو `null` | معرّف كائن المصدر المرتبط؛ يستخدم إكمال المهمة العادي `id` لسجل المهمة. فسّر المصادر الأخرى باستخدام رمز سببها. |
| `content` | string أو `null` | وصف التغيّر. |
| `savingBalance` | integer أو `null` | رصيد الادخار المسجّل للعملية. |

مثال مختلق: نقصان 5 عملات، ليصبح رصيد العملات 95.

```json
{
  "code":200,"message":"success","data":[{
    "id":401,"time":1792072800000,"value":5,"isDecrease":true,
    "totalValue":95,"resCode":0,"relatedId":null,"content":"Example purchase",
    "savingBalance":0
  }]
}
```

**الأخطاء:** [أخطاء HTTP/المزوّد المشتركة](/guide/api-reference?id=response-errors). قد تلغي حدود التاريخ غير الصحيحة عبر HTTP التصفية بصمت كما سبق، بدلًا من إنتاج خطأ.

### رموز الأسباب وإجماليات التقارير :id=journal-totals

تختلف نطاقات رموز الأسباب. أمثلة مختارة:

| السبب | EXP `resCode` | العملات `resCode` |
| --- | --- | --- |
| إكمال مهمة | `1` | `2` |
| التراجع عن إكمال مهمة | `101` | `3` |
| إكمال مهمة فرعية | `12` | `11` |
| التراجع عن مهمة فرعية | `106` | `12` |
| تغيير عبر API | `200` | `28` |

رموز EXP كاملة: `0` غير معروف؛ `1` إكمال مهمة؛ `2` إنجاز؛ `3` مبادلة إعجابات؛ `4` أيام استخدام متتالية؛ `5` مبادلة خطوات؛ `6` تعيين كمكتمل؛ `7` تراجع عن الترك؛ `8` تراجع عن التأخر؛ `9` أكل طماطم؛ `10` استخدام عنصر؛ `11` فتح إنجاز مستخدم؛ `12` إكمال مهمة فرعية؛ `200` API؛ `101` تراجع عن الإكمال؛ `102` ترك؛ `103` تأخر؛ `104` نقص EXP باستخدام عنصر؛ `105` إعادة قفل إنجاز المستخدم؛ `106` تراجع عن إكمال مهمة فرعية. رموز العملات في نطاق [سجلات المخزون](#get-inventory-records) نفسه. احتفظ بالرموز المستقبلية غير المعروفة. لحساب صافي التغيّر، طبّق الاتجاه باستخدام `isDecrease` (تطرح `true` المقدار المسجّل). لا تفترض أن النقصان يُرمّز بقيمة `value` سالبة؛ فالأنواع الرقمية موقّعة ولا يوجد ضمان بقيمة غير موقّعة/مطلقة.

تخص `value` في EXP كل سمة على حدة. لا تجمع `totalValue` في سجلات EXP عشوائيًا: فقد يخزّن منطق تجميع السمات المتعددة الحالي إجماليات متداخلة عند وجود أكثر من ثلاث سمات. مثلًا، قد ينتج عن تغيير أربع سمات بمقدار 10 EXP لكل منها إجماليان مخزّنان هما 40 و10، ولا يصح جمعهما للوصول إلى الإجمالي الصحيح 40. طابق `value` لكل سمة مع السمات المدرجة في كل سجل لإعداد تقارير دقيقة؛ ويحد غياب الارتباطات مما يمكن إثباته. لا تجمع `value` و`totalValue` معًا، ولا تصف `totalValue` في EXP بأنه رصيد.

ليوم تقويمي واحد، احسب `dayStart` و`nextDayStart` المحليين، ثم اطلب `[dayStart, nextDayStart - 1]` لأن الحدين مشمولان. اختر رموز الأسباب عند إعداد تقرير مكافآت المهام فقط؛ واترك الأسباب بلا تصفية عند إعداد تقرير لجميع التغيّرات المسجّلة. [إجراء التقرير اليومي](/guide/api-reference?id=daily-report).

### مراجع التنفيذ :id=api-ledgers-sources

[CoinRecord](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/CoinRecord.kt) · [ExpRecord](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/ExpRecord.kt) · [تمرير معاملات التاريخ](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/LedgerUri.kt).

## العناصر والفئات :id=get-items

يعيد `GET /items` مصفوفة `ShopItem[]`. يختار معامل `id` المتكرر العناصر، مثل `/items?id=1&id=2`. تُهمل القيم غير الصحيحة وتُتجاوز المعرّفات غير الموجودة، مع الاحتفاظ بترتيب المعرّفات الصالحة وتكراراتها. إذا لم يصح أي معرّف، لا يرسل SDK مرشحًا وتُعاد القائمة العادية. لا توجد صفحات.

يعيد `GET /items/{listId}` عناصر `ShopItem[]` **داخل فئة**، وليس عنصرًا واحدًا. `listId` معرّف فئة صحيح موقّع من 64 بت؛ تعني `-1` الكل، وكذلك القيمة غير الصالحة. تستبعد القائمة العادية العناصر الملغاة/المحذوفة (`isDel=0`) وتتبع ترتيب المتجر/الفئة المضبوط. يمكن للاختيار بالمعرّف استرجاع عنصر دون مرشح القائمة العادية.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Coffee","desc":"A small reward","icon":"","categoryId":0,"stockNumber":-1,"ownNumber":2,"price":10,"order":0,"disablePurchase":false,"maxPurchaseNumber":5,"titleColorString":"","actionText":"Use","unlist":false,"disableUse":false,"purchaseLimit":"[]","limitScope":"purchase"}]}
```

### ShopItem :id=model-shop-item

| الحقل | نوع JSON | المعنى |
| --- | --- | --- |
| `id` | integer or null | معرّف العنصر. |
| `name` | string | اسم العنصر. |
| `desc` | string | الوصف. |
| `icon` | string | URI لصورة قابلة للقراءة، أو سلسلة فارغة. نزّلها عبر `/files/{url}`. |
| `categoryId` | integer | معرّف فئة المتجر. |
| `stockNumber` | integer | المخزون المتاح؛ تُعامل القيمة السالبة كمخزون غير محدود عند حساب `maxPurchaseNumber`. |
| `ownNumber` | integer | الكمية المملوكة في المخزون. |
| `price` | integer | السعر بالعملات. |
| `order` | integer | ترتيب العنصر المحفوظ داخل فئته. |
| `disablePurchase` | boolean | علامة تعطيل الشراء. |
| `maxPurchaseNumber` | integer or null | تُحسب من العملات المتاحة والائتمان والمخزون المحدود؛ تكون 0 عند تعطيل الشراء، وقد تبلغ 2147483647 للعنصر المجاني غير المحدود. لا يفحص هذا الحساب جميع قواعد حدود الشراء. |
| `titleColorString` | string or null | لون العنوان المخصص. |
| `actionText` | string or null | نص زر الاستخدام المخصص. |
| `unlist` | boolean | علامة إلغاء الإدراج/الحذف؛ عادةً false في نتائج القائمة العادية. |
| `disableUse` | boolean | هل يحتوي العنصر على تأثير يمنع استخدامه. |
| `purchaseLimit` | string or null | إعداد حدود شراء العنصر، في **سلسلة مرمّزة بصيغة JSON** وليس مصفوفة متداخلة. |
| `limitScope` | string or null | `purchase` أو `use` أو `both`. |

### GET /items_categories :id=get-items-categories

يعيد `ShopCategory[]`. القيمة الافتراضية لـ `include_hidden` الاختياري هي `false`؛ لا يُقبل إلا النصان الصغيران المطابقان `true` و`false`، وتصبح القيم الأخرى false. يشمل فئة «الكل» الافتراضية. لا يوفّر HTTP المسار `/items_categories/{id}`.

```json
{"code":200,"message":"success","data":[{"id":0,"name":"Default","isAsc":true,"sort":"order","order":0,"hidden":false,"inventoryHidden":false}]}
```

### ShopCategory :id=model-shop-category

| الحقل | نوع JSON | المعنى |
| --- | --- | --- |
| `id` | integer or null | معرّف الفئة. |
| `name` | string | اسم الفئة. |
| `isAsc` | boolean | علامة الترتيب التصاعدي المضبوطة. |
| `sort` | string | تفضيل الترتيب المحفوظ. |
| `order` | integer | ترتيب الفئة. |
| `hidden` | boolean | مخفي في المتجر. |
| `inventoryHidden` | boolean | مخفي في المخزون. |

### GET /tasks_categories :id=get-tasks-categories

يعيد `TaskCategory[]`، بما فيها فئة الكل والفئات المؤرشفة. لا معاملات استعلام ولا صفحات. لا يوفّر HTTP المسار `/tasks_categories/{id}`. قيم ترتيب/تصفية الفئة تفضيلات محفوظة في التطبيق وليست مرشحات تُطبّق على الطلب.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Daily","isAsc":true,"sort":"order","filter":"","order":0,"status":0,"type":0}]}
```

### TaskCategory :id=model-task-category

| الحقل | نوع JSON | المعنى |
| --- | --- | --- |
| `id` | integer or null | معرّف الفئة. |
| `name` | string | الاسم. |
| `isAsc` | boolean | علامة الترتيب التصاعدي المحفوظة. |
| `sort` | string | تفضيل الترتيب المحفوظ. |
| `filter` | string | تفضيل التجميع/التصفية المحفوظ. |
| `order` | integer | ترتيب الفئة. |
| `status` | integer | 0 عادية؛ 1 مؤرشفة. |
| `type` | integer | 0 عادية؛ القوائم الذكية: 10 يومية، 11 أسبوعية، 12 شهرية، 20 قيد التنفيذ. |

## المهارات ومجموعاتها :id=get-skills

يعيد `GET /skills` مصفوفة `Skill[]` بلا معاملات أو صفحات. تُستبعد المهارات المخفية/المحذوفة ويُستخدم الترتيب المحفوظ. حقلا `group_id` و`status` في ContentProvider **ليسا** من حقول نموذج HTTP.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Strength","desc":"","icon":"","order":0,"color":-65536,"exp":150,"level":2,"untilNextLevelExp":50,"currentLevelExp":50,"type":1}]}
```

### Skill :id=model-skill

| الحقل | نوع JSON | المعنى |
| --- | --- | --- |
| `id` | integer or null | معرّف المهارة. |
| `name` | string | اسم المهارة المترجم. |
| `desc` | string | الوصف. |
| `icon` | string | URI لأيقونة قابلة للقراءة، أو سلسلة فارغة. |
| `order` | integer | الترتيب المحفوظ. |
| `color` | integer | قيمة لون Android المعبأة كعدد صحيح. |
| `exp` | integer | إجمالي EXP الحالي. |
| `level` | integer | المستوى الحالي. |
| `untilNextLevelExp` | integer | EXP المتبقي للمستوى التالي. |
| `currentLevelExp` | integer | EXP المكتسب منذ بداية المستوى الحالي. |
| `type` | integer | 0 مخصصة؛ 1 القوة؛ 2 التعلم؛ 3 الجاذبية؛ 4 التحمل؛ 5 الحيوية؛ 6 الإبداع. |

### GET /skill_groups :id=get-skill-groups

يعيد `SkillGroup[]`. يتبع `include_hidden` التحليل المنطقي الصارم نفسه في `/items_categories` وقيمته الافتراضية false. تتجاهل طبقة المستودع الحالية هذا العلم للمجموعات وتستبعد المحذوفة دائمًا. الترتيب المحفوظ تصاعدي، ولا توجد صفحات.

```json
{"code":200,"message":"success","data":[{"id":1,"content":"Personal","order":0,"collapsed":false}]}
```

### SkillGroup :id=model-skill-group

| الحقل | نوع JSON | المعنى |
| --- | --- | --- |
| `id` | integer or null | معرّف المجموعة. |
| `content` | string | عنوان المجموعة. |
| `order` | integer | ترتيب المجموعة المحفوظ. |
| `collapsed` | boolean | حالة الطي. |

## الإنجازات :id=get-achievements

يحمّل `GET /achievements` كل فئة بترتيب الفئات ويجمع إنجازاتها في `Achievement[]`. يعيد `GET /achievements/{id}` الإنجازات **في الفئة `id`** وليس تفاصيل إنجاز واحد. يُعامل المعرّف غير الصالح كطلب بلا تصفية. يتبع ترتيب كل فئة إعدادها في التطبيق. لا صفحات في المسارين.

```json
{"code":200,"message":"success","data":[{"id":10,"name":"First step","desc":"Complete a task","iconUri":"","categoryId":1,"status":0,"exp":10,"coin":5,"coinVariable":0,"type":0,"progress":0,"order":0,"itemId":null,"itemAmount":null,"unlockedTime":null,"items":[],"color":""}]}
```

### Achievement :id=model-achievement

| الحقل | نوع JSON | المعنى |
| --- | --- | --- |
| `id` | integer or null | معرّف الإنجاز. |
| `name` | string | العنوان. |
| `desc` | string | الوصف. |
| `iconUri` | string | URI للأيقونة، أو سلسلة فارغة. |
| `categoryId` | integer | معرّف الفئة. |
| `status` | integer | 0 غير مكتمل؛ 1 مكتمل والمكافأة لم تُستلم؛ 2 استُلمت المكافأة/حالة اكتمال أخرى. |
| `exp` | integer | مكافأة EXP. |
| `coin` | integer | مكافأة العملات. |
| `coinVariable` | integer | مكافأة العملات المتغيرة. |
| `type` | integer | 0 إنجاز؛ 1 عنوان فئة فرعية. |
| `progress` | integer | التقدم المحفوظ. |
| `order` | integer | الترتيب داخل الفئة. |
| `itemId` | integer or null | معرّف أول عنصر مكافأة (حقل قديم للتيسير). |
| `itemAmount` | integer or null | كمية أول عنصر مكافأة. |
| `unlockedTime` | integer or null | وقت الفتح بمللي ثانية Unix. |
| `items` | RewardItem[] or null | قائمة عناصر المكافأة كاملة؛ يعيد المحلّل الحالي مصفوفة فارغة إذا غاب JSON للعناصر أو كان تالفًا. |
| `color` | string or null | لون العنوان المخصص. |

تستخدم عناصر المكافأة نموذج [RewardItem](#reward-item) المشترك.

### GET /achievement_categories :id=get-achievement-categories

يعيد `AchievementCategory[]` بلا معاملات أو صفحات. لا يوفّر HTTP المسار `/achievement_categories/{id}`.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Milestones","desc":"","iconUri":"","isAsc":true,"sort":"order","filter":"","order":0,"type":0}]}
```

### AchievementCategory :id=model-achievement-category

| الحقل | نوع JSON | المعنى |
| --- | --- | --- |
| `id` | integer or null | معرّف الفئة. |
| `name` | string | الاسم. |
| `desc` | string | الوصف. |
| `iconUri` | string | URI/سلسلة الأيقونة. |
| `isAsc` | boolean | علامة الترتيب التصاعدي. |
| `sort` | string | تفضيل الترتيب المحفوظ. |
| `filter` | string | تفضيل التجميع/التصفية المحفوظ. |
| `order` | integer | ترتيب الفئة. |
| `type` | integer | 0 إنجازات المستخدم؛ 1 إنجازات النظام. |

### GET /achievement_conditions/{id} :id=get-achievement-conditions

يعيد `AchievementCondition[]` **للإنجاز** ذي المعرّف `id`. المعرّف غير الصحيح يعيد غلاف خطأ برمز 500، وعدم وجود شروط مطابقة يعيد مصفوفة فارغة. لا يوجد مسار مجموعة `/achievement_conditions`.

```json
{"code":200,"message":"success","data":[{"id":1,"type":0,"relatedId":42,"target":10,"current":3,"progress":30}]}
```

### AchievementCondition :id=model-achievement-condition

| الحقل | نوع JSON | المعنى |
| --- | --- | --- |
| `id` | integer or null | معرّف الشرط. |
| `type` | integer | رمز الشرط؛ انظر أدناه. |
| `relatedId` | integer | معرّف المهمة/العنصر/المهارة المرتبطة بحسب الشرط. |
| `target` | integer | القيمة المستهدفة. |
| `current` | integer | القيمة المتراكمة الحالية. |
| `progress` | integer | التقدم المحفوظ. |

رموز الشروط: 0 إكمال المهام؛ 1 سلسلة الإكمال الحالية؛ 2 مستوى السمة القديم؛ 3 الطماطم؛ 4 أيام الاستخدام؛ 5 الإعجابات؛ 6 أيام الإكمال المتتالية؛ 7 العملات الحالية؛ 8 العملات المكتسبة بيوم؛ 9 طماطم المهمة؛ 10 شراء العناصر؛ 11 استخدامها؛ 12 كسب العناصر من الصناديق؛ 13 مستوى المهارة؛ 14 مستوى الحياة؛ 15 كسب العناصر التراكمي؛ 16 كسبها بالتصنيع؛ 17 الكمية المملوكة؛ 18 وقت تركيز المهمة؛ 19 مدخرات ATM؛ 20 API خارجي. الشروط المتكررة: 500 إكمال المهام؛ 501 ترقيات المهارة؛ 502 الطماطم؛ 503 العملات؛ 504 كسب العناصر؛ 505 الشراء؛ 506 مكاسب الصناديق؛ 507 مكاسب التصنيع؛ 508 الاستخدام؛ 509 دقائق تركيز المهمة؛ 510 طماطم المهمة؛ 511 الإعجابات؛ 512 زيادة المدخرات؛ 513 استدعاءات API الخارجي؛ 514 أيام الاستخدام؛ 515 ترقيات مستوى الحياة؛ 516 العملات اليومية؛ 517 إكمالات متتالية؛ 518 الطماطم اليومية؛ 519 دقائق التركيز اليومية؛ 520 مجموعات مهام يومية مختلفة؛ 521 الاستخدام اليومي؛ 522 الشراء اليومي؛ 523 إكمال مهمة محددة يوميًا؛ 524 إجمالي سجلات إكمال المهام اليومية. هذه رموز أعداد صحيحة وليست أسماء تعدادات متسلسلة.

## التصنيع :id=get-synthesis

يعيد `GET /synthesis` مصفوفة `Synthesis[]` للفئات المرئية. يعيد `GET /synthesis/{id}` الوصفات **في الفئة `id`** بما فيها محتواها المخفي. المعرّفات غير السالبة تحدد فئة، والسالبة تعني جميع الفئات المرئية؛ غير الصالحة تعود لطلب المجموعة. تُستبعد الوصفات المحذوفة ويكون ترتيبها المحفوظ تصاعديًا، بلا صفحات.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Tea","desc":"","input":[{"itemId":2,"itemName":"Tea leaf","amount":2,"ownedNumber":5,"icon":""}],"output":[{"itemId":3,"itemName":"Tea","amount":1,"ownedNumber":0,"icon":""}],"categoryId":0,"canSynthesisTimes":2}]}
```

### Synthesis :id=model-synthesis

| الحقل | نوع JSON | المعنى |
| --- | --- | --- |
| `id` | integer or null | معرّف الوصفة. |
| `name` | string | الاسم. |
| `desc` | string | الوصف. |
| `input` | SynthesisItemInfo[] | العناصر المطلوبة. |
| `output` | SynthesisItemInfo[] | العناصر الناتجة. |
| `categoryId` | integer or null | معرّف الفئة. |
| `canSynthesisTimes` | integer | عدد مرات التصنيع المتاحة حاليًا. |

### SynthesisItemInfo :id=model-synthesis-item-info

| الحقل | نوع JSON | المعنى |
| --- | --- | --- |
| `itemId` | integer | معرّف العنصر. |
| `itemName` | string | اسم العنصر. |
| `amount` | integer | كمية الإدخال/الإخراج لكل عملية تصنيع. |
| `ownedNumber` | integer | الكمية المملوكة. |
| `icon` | string | URI لأيقونة قابلة للقراءة، أو سلسلة فارغة. |

### GET /synthesis_categories و /synthesis_categories/{id} :id=get-synthesis-categories

يعيد المساران `SynthesisCategory[]`. يصفّي `id` الاختياري الفئة دون تغيير شكل المصفوفة؛ غير الصالح يعيد جميع الفئات. يُحلّل `include_hidden` منطقيًا بنص صغير صارم، وافتراضيًا false حتى مع معرّف فئة. لا صفحات.

```json
{"code":200,"message":"success","data":[{"id":0,"name":"Default","isAsc":true,"sort":"order","order":0,"hidden":false}]}
```

### SynthesisCategory :id=model-synthesis-category

| الحقل | نوع JSON | المعنى |
| --- | --- | --- |
| `id` | integer or null | معرّف الفئة. |
| `name` | string | الاسم. |
| `isAsc` | boolean | علامة الترتيب التصاعدي المحفوظة. |
| `sort` | string | تفضيل الترتيب المحفوظ. |
| `order` | integer | ترتيب الفئة. |
| `hidden` | boolean | علامة الإخفاء. |

## المشاعر :id=get-feelings

يعيد `GET /feelings` مصفوفة `Feelings[]`. الافتراضي `offset=0` و`limit=100`، وكذلك عند الغياب أو عدم صحة العدد. لا ضبط حدود صريحًا؛ استخدم إزاحة غير سالبة وحدًا موجبًا. تُستبعد المشاعر المحذوفة ويتبع الترتيب تفضيل التطبيق (`createTime` تصاعديًا/تنازليًا)، وليس معامل طلب. لا مرشح زمني.

```json
{"code":200,"message":"success","data":[{"id":1,"content":"A good day","isFav":false,"title":"Read","time":1700000000000,"attachments":[],"type":0}]}
```

### Feelings :id=model-feelings

| الحقل | نوع JSON | المعنى |
| --- | --- | --- |
| `id` | integer or null | معرّف الشعور. |
| `content` | string | النص. |
| `isFav` | boolean | علامة المفضلة. |
| `title` | string | العنوان المرتبط. |
| `time` | integer | وقت الإنشاء بمللي ثانية Unix. |
| `attachments` | string[] | عناوين URI لمرفقات قابلة للقراءة؛ للملفات الموجودة غير الفارغة فقط. |
| `type` | integer | 0 مهمة؛ 1 إنجاز؛ 2 إدخال مستقل. |

## سجلات بومودورو :id=get-pomodoro-records

يعيد `GET /pomodoro_records` مصفوفة `PomodoroRecord[]`. الافتراضي `offset=0` و`limit=100` بلا ضبط حدود صريح. الحدّان الاختياريان `time_range_start` و`time_range_end` بمللي ثانية Unix؛ يمررهما SDK فقط إذا كانا عددين صحيحين من 64 بت والبداية أصغر من النهاية، وإلا يُهمل النطاق بصمت.

دون نطاق، تُعاد السجلات المنتهية غير المحذوفة ذات `startTime != endTime` و`endTime` الموجب، بترتيب `endTime DESC, startTime DESC, id DESC`. يختار النطاق الصالح `start < endTime <= end` ويستبعد المحذوفة.

> [!WARNING]
> كانت التطبيقات السابقة تمرّر `limit` و`offset` إلى DAO بترتيب معكوس في استعلامات النطاق الزمني دون تحديد ترتيب النتائج. صُحّح مصدر LifeUp المحلي باستخدام معاملات مسماة وترتيب الصفحات حسب `endTime DESC, startTime DESC, id DESC`؛ لم يُنشر هذا الإصلاح المحلي بعد. إلى أن تتأكد من احتواء إصدار LifeUp المثبّت عليه، احذف النطاق وصفِّ السجلات في العميل للحصول على صفحات موثوقة.

```json
{"code":200,"message":"success","data":[{"id":1,"startTime":1700000000000,"endTime":1700001500000,"duration":1500000,"reward":1.0}]}
```

### PomodoroRecord :id=model-pomodoro-record

| الحقل | نوع JSON | المعنى |
| --- | --- | --- |
| `id` | integer or null | معرّف السجل. |
| `startTime` | integer or null | وقت البدء بمللي ثانية Unix. |
| `endTime` | integer or null | وقت الانتهاء بمللي ثانية Unix. |
| `duration` | integer | بالمللي ثانية: قيمة `lastTime` المحفوظة إن لم تكن صفرًا، وإلا وقت الانتهاء ناقص البدء. |
| `reward` | number | الطماطم المكتسبة: 0 عند التخلي؛ نصف جلسة = 0.5 × المضاعف؛ وإلا المضاعف. |

## سجلات المخزون :id=get-inventory-records

يعيد `GET /inventory_records` مصفوفة `InventoryRecord[]`. الافتراضي `offset=0` ويُضبط إلى 0 على الأقل؛ و`limit=100` ضمن 1–200. لا يُمرّر الحدّان الزمانيان إلا إذا كانا صحيحين من 64 بت وstart < end؛ يُهمل الناقص أو غير الصالح بصمت. النطاق شامل للطرفين (`time >= start AND time <= end`). تُستبعد المحذوفة (`isDel` يساوي null أو 0)، والترتيب `time DESC, id DESC`. لا تصفية بمعرّف عنصر.

```json
{"code":200,"message":"success","data":[{"id":1,"time":1700000000000,"itemId":2,"itemName":"Tea","changeNumber":1,"isDecrease":false,"resCode":0,"desc":"Purchase"}]}
```

### InventoryRecord :id=model-inventory-record

| الحقل | نوع JSON | المعنى |
| --- | --- | --- |
| `id` | integer or null | معرّف السجل. |
| `time` | integer or null | وقت الإنشاء بمللي ثانية Unix. |
| `itemId` | integer or null | معرّف العنصر المرتبط. |
| `itemName` | string or null | اسم العنصر المرتبط إن توفر. |
| `changeNumber` | integer | تغير الكمية المسجل. |
| `isDecrease` | boolean | هل يقلل التغيير المخزون. |
| `resCode` | integer | رمز سبب المصدر؛ انظر أدناه. |
| `desc` | string or null | وصف السجل. |

رموز الأسباب: 0 شراء؛ 1 استخدام؛ 2 إكمال مهمة؛ 3 تراجع عنه؛ 4 مسح البيانات؛ 5 ترك مهمة؛ 6 تأخر مهمة؛ 7 فتح إنجاز مدمج؛ 8 تراجع عن الترك؛ 9 تراجع عن التأخر؛ 10 إرجاع عنصر؛ 11 إكمال مهمة فرعية؛ 12 تراجع عنه؛ 13 فتح إنجاز المستخدم؛ 14 تراجع عنه؛ 15 إيداع؛ 16 سحب؛ 17 بيع طماطم؛ 20 مكافأة عنصر؛ 21 تراجع عنها؛ 23 تصنيع؛ 24 صندوق؛ 25 فائدة ATM؛ 26 مبادلة طماطم بعنصر؛ 27 فائدة ائتمان؛ 28 API؛ 29 تغيير المخزون بتأثير عنصر. احتفظ بالرموز المستقبلية غير المعروفة.

## سجلات الخطوات :id=get-step-records

يعيد `GET /step_records` مصفوفة `StepRecord[]`. افتراضيات وحدود الصفحات وقواعد إهمال النطاق في SDK مماثلة لـ `/inventory_records`. النطاق شامل للطرفين على `date` والترتيب `date DESC` بلا مفتاح ثانوي صريح.

```json
{"code":200,"message":"success","data":[{"id":1,"date":1700000000000,"dailyStepCount":5000,"totalStepCount":120000,"isGotReward":true,"isUserInput":false,"rewardLevel":1}]}
```

### StepRecord :id=model-step-record

| الحقل | نوع JSON | المعنى |
| --- | --- | --- |
| `id` | integer or null | معرّف السجل. |
| `date` | integer or null | التاريخ المسجل بمللي ثانية Unix. |
| `dailyStepCount` | integer | عدد الخطوات اليومي. |
| `totalStepCount` | integer | عدد الخطوات التراكمي المحفوظ. |
| `isGotReward` | boolean | علامة استلام المكافأة. |
| `isUserInput` | boolean | علامة الإدخال اليدوي. |
| `rewardLevel` | integer or null | مستوى المكافأة المحفوظ. |

## تعريفات المستويات :id=get-level-defines

يعيد `GET /level_defines` كائن `LevelDefines` واحدًا بلا معاملات. يستخدم التعريفات المخصصة عند تفعيل وضعها، وإلا التعريفات المدمجة.

```json
{"code":200,"message":"success","data":{"custom":true,"levels":[{"id":1,"levelStart":1,"levelEnd":10,"perLevelExp":100}]}}
```

### LevelDefines :id=model-level-defines

| الحقل | نوع JSON | المعنى |
| --- | --- | --- |
| `custom` | boolean | وضع المستويات المخصصة. |
| `levels` | LevelDefine[] | نطاقات المستويات. |

### LevelDefine :id=model-level-define

| الحقل | نوع JSON | المعنى |
| --- | --- | --- |
| `id` | integer or null | معرّف التعريف. |
| `levelStart` | integer | مستوى البداية. |
| `levelEnd` | integer | مستوى النهاية. |
| `perLevelExp` | integer | EXP المطلوب لكل مستوى ضمن النطاق. |

يتحول JSON التالف للمستويات حاليًا إلى مصفوفة `levels` فارغة بدل إفشال الطلب كله.

## الإحصاءات :id=get-statistics

يعيد `GET /statistics` كائن `Statistics` واحدًا. الحدّان الاختياريان بمللي ثانية Unix، ولا يمررهما SDK إلا إن صحّا وكان start < end. دونهما يُستخدم أول سجل حتى الآن، أو آخر 30 يومًا إن لم يوجد سجل. يبقى `usingDays` و`companionDays` إجماليين حتى مع نطاق. تُحسب المقاييس الأخرى بطرق التطبيق الخاصة بها؛ لا تفترض توحّد قواعد شمول الحدود.

```json
{"code":200,"message":"success","data":{"start":1700000000000,"end":1700086400000,"tomatoes":4,"pomodoroMinutes":100,"focusCount":4,"tasksCompleted":3,"tasksTotal":4,"taskCompleteRate":0.75,"feelingsCount":1,"usingDays":30,"companionDays":32,"interestChanged":2,"coinPurchaseConsumed":10}}
```

### Statistics :id=model-statistics

| الحقل | نوع JSON | المعنى |
| --- | --- | --- |
| `start` | integer or null | بداية النطاق الفعلية بمللي ثانية Unix. |
| `end` | integer or null | نهاية النطاق الفعلية بمللي ثانية Unix. |
| `tomatoes` | integer | إحصاء الطماطم المكتسبة. |
| `pomodoroMinutes` | integer | مدة التركيز بالدقائق. |
| `focusCount` | integer | عدد جلسات التركيز. |
| `tasksCompleted` | integer | عدد المهام المكتملة المستخدم في إحصاء الاكتمال. |
| `tasksTotal` | integer | إجمالي المهام المستخدم في ذلك الإحصاء. |
| `taskCompleteRate` | number | نسبة الاكتمال. |
| `feelingsCount` | integer | عدد المشاعر. |
| `usingDays` | integer | إجمالي أيام الاستخدام. |
| `companionDays` | integer | إجمالي أيام الرفقة. |
| `interestChanged` | integer | إحصاء تغير العملات من الفوائد. |
| `coinPurchaseConsumed` | integer | إحصاء العملات المستهلكة في الشراء. |

## معلومات التطبيق ورصيد العملات :id=get-info

يعيد `GET /info` نموذج `Info`. يضيف LifeUp Cloud إصداره المثبّت إلى معلومات التطبيق/المزوّد. لا معاملات.

```json
{"code":200,"message":"success","data":{"appVersion":1,"appVersionName":"example","apiVersion":1,"cloudVersion":1,"cloudVersionName":"example"}}
```

### Info :id=model-info

| الحقل | نوع JSON | المعنى |
| --- | --- | --- |
| `appVersion` | integer | رمز إصدار LifeUp المثبّت. |
| `appVersionName` | string | اسم إصدار LifeUp المثبّت. |
| `apiVersion` | integer | إصدار API لـ LifeUp. |
| `cloudVersion` | integer | رمز إصدار LifeUp Cloud المثبّت. |
| `cloudVersionName` | string | اسم إصدار LifeUp Cloud المثبّت. |

### GET /coin :id=get-coin

يستدعي `lifeup://api/query?key=coin` عبر ContentProvider ويعيد كائن نتيجته بلا معاملات. تتحول النتيجة null إلى كائن فارغ. يحدد المزوّد الحقول، وليست استجابة `CoinData` مكتوبة النوع. يوفر النجاح `value` (رصيد صحيح موقّع من 64 بت) و`api_result: true`؛ وقد يحتوي الفشل حقول الحالة/الخطأ أدناه.

```json
{"code":200,"message":"success","data":{"value":50,"api_result":true}}
```

## استدعاء URL Scheme API :id=invoke-api

يحدد [دليل URL Scheme API](/guide/api) أسماء الطرق ومعاملاتها ونتائجها. يقبل جسر HTTP الرابط الكامل `lifeup://api/...`.

| النقل | المدخلات | التنفيذ والاستجابة |
| --- | --- | --- |
| `GET /api` | معامل الاستعلام `url` المكرر والمرمّز للرابط | يشغّل Activity في Android لكل رابط بالترتيب، ويعيد السلسلة `success`. غياب الروابط يُعد نجاحًا أيضًا. |
| `POST /api` | JSON `RawQueryVo` | يعالج كل `urls` أولًا ثم `url` إن وُجد، ويعيد `success`. ينجح الكائن الفارغ أيضًا. |
| `GET /api/contentprovider` | معامل الاستعلام `url` المكرر والمرمّز للرابط | يستدعي المزوّد بشكل متزامن ويعيد `CallUrlResult[]` بالترتيب. غياب الروابط يعيد غلاف خطأ (`No url found`). |
| `POST /api/contentprovider` | JSON `RawQueryVo` | يستدعي كل `urls` أولًا ثم `url`، ويعيد `CallUrlResult[]`. الكائن الفارغ يعيد مصفوفة فارغة. |

اضبط `Content-Type: application/json` لطلبات POST JSON. رمّز الرابط كاملًا عند وضعه في استعلام GET للحفاظ على `&` و`?` و`+` والترميز المئوي داخله. نجاح جسر Activity يؤكد الإرسال فقط لا اكتمال فعل LifeUp. تتطلب طرق ContentProvider إذن Cloud داخل LifeUp، ويعتمد الدعم على الطريقة. التنفيذ تسلسلي؛ خطأ لاحق لا يتراجع عن آثار سابقة.

```json
{"urls":["lifeup://api/query?key=coin"],"url":"lifeup://api/query?key=atm"}
```

استجابة جسر Activity:

```json
{"code":200,"message":"success","data":"success"}
```

استجابة جسر المزوّد (نتيجة توضيحية):

```json
{"code":200,"message":"success","data":[{"url":"lifeup://api/query?key=coin","result":{"value":50,"api_result":true}},{"url":"lifeup://api/query?key=atm","result":{"value":100,"api_result":true}}]}
```

### RawQueryVo :id=model-raw-query

| الحقل | نوع JSON | المعنى |
| --- | --- | --- |
| `url` | string or null | رابط منفرد اختياري. |
| `urls` | string[] or null | قائمة روابط اختيارية؛ تُعالج قبل `url`. |

### CallUrlResult :id=model-call-url-result

| الحقل | نوع JSON | المعنى |
| --- | --- | --- |
| `url` | string | الرابط المرسل. |
| `result` | object or null | حزمة Bundle المحوّلة من المزوّد؛ null وحده لا يفشل غلاف HTTP. |

يحافظ تحويل Bundle على Int/Long/Double/String/Boolean والحزم المتداخلة. تتحول المصفوفات إلى مصفوفات سلاسل، وباقي الأنواع إلى ناتج `toString()` (حتى null تصبح السلسلة `"null"`). افحص فشل الطريقة داخل `result` حتى لو كان الرمز الخارجي 200.

يضيف معالج LifeUp الحالي `api_result` المنطقي للاستدعاءات المكتملة. الفشل الملتقط يعيد `api_result: false` و`error_code` و`error_message` النصيين. تشمل الرموز `missing_required_parameter` و`invalid_parameter` و`entity_not_found` و`invalid_format` و`unsupported_api` و`cancelled` و`internal_error`، وقد تضيف الطرق رموزًا أخرى. أثناء الاستعادة قد يعيد المزوّد `error_code: "503"` و`error_message` بلا `api_result`. غياب معالج API قد يطرح خطأ قبل التحويل فيصبح خطأ جسر خارجيًا.

## قراءة الملفات ورفعها :id=files-download

### GET /files/{url} :id=files-get

رمّز URI القابل للقراءة كاملًا كجزء مسار واحد. يقرأ بايتات عبر محلّل محتوى Android، مثل الأيقونات ومرفقات المشاعر والنسخ المصدّرة والملفات المرفوعة. النتيجة تدفق بايتات لا غلاف نجاح JSON، ولا يُحدد اسم ملف أو MIME. التدفق الفارغ/غير المقروء لا يتحول إلى نتيجة «غير موجود» منظمة؛ الاستثناءات تستخدم معالج HTTP 500 العام. المعامل المطابق الفارغ يعيد خطأ (`url is required`).

```bash
curl "$BASE/files/content%3A%2F%2Fexample.provider%2Fimages%2F1" -o image.bin
```

### POST /files/upload :id=files-upload

أرسل `multipart/form-data`. تُقبل جميع أجزاء الملفات مهما كان اسم الحقل وتُهمل الأجزاء الأخرى. يُستخدم الاسم الأصلي للملف المؤقت، أو `uploaded_image_<time>.jpg` عند غيابه. تُعاد مصفوفة URI محتوى قابلة للقراءة. الرفع يوفّر URI لاستدعاءات لاحقة ولا يربطه تلقائيًا بعنصر أو مهمة. غياب الملفات يعيد `No files received`.

```bash
curl -X POST "$BASE/files/upload" -F 'file=@image.png'
```

```json
{"code":200,"message":"success","data":["content://example.fileprovider/cache/image.png"]}
```

## تصدير النسخ الاحتياطية واستيرادها :id=files-backup

### GET /data/export :id=files-export

ينشئ نسخة احتياطية عبر المزوّد. الافتراضي `withMedia=true`؛ عند وجوده تعني `true` دون حساسية للحالة صحيحًا وكل قيمة أخرى خطأ. يعيد Bundle محوّلًا يحتوي حاليًا `backup_file_uri` للتنزيل عبر `/files/{url}`. ينشئ تصديرًا رغم أن الطريقة GET. افحص حقول حالة/خطأ API إن وُجدت؛ URI الفارغ يعني عدم إنتاج ملف صالح، ونتيجة null تصبح خطأ.

```json
{"code":200,"message":"success","data":{"backup_file_uri":"content://example.provider/backup/LifeUpExportBackup.zip","api_result":true}}
```

### POST /data/import :id=files-import

أرسل ملف النسخة بصيغة `multipart/form-data`. يُستخدم آخر جزء ملف عند التعدد دون فحص اسم الحقل. الاسم الافتراضي `backup.lfbak`. يُقرأ `description` الاختياري بلا تأثير. يخزّن Cloud الملف مؤقتًا ويفتح شاشة النسخ في LifeUp؛ تؤكد الاستجابة الرفع وفتح الشاشة **لا اكتمال الاستعادة**. غياب الملف يعيد `No file received`.

```bash
curl -X POST "$BASE/data/import" -F 'file=@backup.lfbak'
```

```json
{"code":200,"message":"success","data":"File uploaded and BackupActivity launched"}
```

## الأحداث :id=get-events

### GET /events :id=get-events-poll

يعيد `EventsPage`. `after` مؤشر معرّف حدث مستبعد من النتيجة (64 بت، افتراضيًا 0). `limit` افتراضيًا 50 ضمن 1–200؛ غير الصحيح يستخدم الافتراضي. تُعاد الأحداث `id > after` من الأقدم داخل المخزن. تُحفظ 200 فقط في الذاكرة، وتُحذف الأقدم وتُعاد المعرّفات بعد إعادة تشغيل العملية. `latestId` أحدث معرّف عام وليس بالضرورة آخر حدث بالصفحة؛ تابع من آخر حدث عالجته لتجنب تخطي المتراكم. لا سجل دائم ولا إقرار تسليم.

```json
{"code":200,"message":"success","data":{"latestId":2,"eventWs":true,"events":[{"id":1,"time":1700000000000,"action":"app.lifeup.task.complete","extras":{"id":"42"}}],"broadcasts":true}}
```

### EventsPage :id=model-events-page

| الحقل | نوع JSON | المعنى |
| --- | --- | --- |
| `latestId` | integer | أحدث معرّف حدث حاليًا. |
| `eventWs` | boolean | إعداد WebSocket في Cloud. |
| `events` | CloudEvent[] | الأحداث المحفوظة بعد المؤشر. |
| `broadcasts` | boolean or null | هل بث LifeUp مفعّل؛ تعني null أن الحالة مجهولة أو غير مدعومة. تُخزّن الحالة مؤقتًا لخمس ثوانٍ. |

### CloudEvent :id=model-cloud-event

| الحقل | نوع JSON | المعنى |
| --- | --- | --- |
| `id` | integer | الرقم التسلسلي للحدث في الذاكرة. |
| `time` | integer | وقت استلام Cloud بمللي ثانية Unix. |
| `action` | string | إجراء بث Android. |
| `extras` | كائن بقيم نصية | إضافات البث بعد تحويلها بـ `toString()`؛ تتحول null إلى سلسلة فارغة. تختلف المفاتيح باختلاف الإجراء. |

### WebSocket /events :id=get-events-websocket

عندما يكون `eventWs` صحيحًا اتصل بـ `ws://HOST:PORT/events?after=ID` مع الرمز المضبوط. يعيد الخادم الأحداث المحفوظة ثم يرسل الحية كإطارات نصية JSON منفردة من `CloudEvent` **دون** غلاف HTTP. الإعادة مقيدة بذاكرة 200 حدث ولا معامل `limit` للـ WebSocket. تُرسل Ping كل 30 ثانية. أعد الاتصال بآخر معرّف عالجته فعليًا. عند التعطيل لا يُسجل المسار، وتظل استطلاعات HTTP متاحة.

```json
{"id":2,"time":1700000001000,"action":"app.lifeup.item.use","extras":{"id":"3"}}
```

اشتراكات الإجراءات المدعومة: `app.lifeup.task.complete`, `app.lifeup.task.overdue`, `app.lifeup.task.giveup`, `app.lifeup.achievement.unlock`, `app.lifeup.achievement.condition.unlock`, `app.lifeup.item.purchase`, `app.lifeup.item.reward`, `app.lifeup.item.use`, `app.lifeup.synthesis.complete`, `app.lifeup.pomodoro.start`, `app.lifeup.pomodoro.pause`, `app.lifeup.pomodoro.complete`, `app.lifeup.pomodoro.stop`, `app.lifeup.feelings.add`, `app.lifeup.level.up`, `app.lifeup.level.down`, `app.lifeup.item.countdown.start`, `app.lifeup.item.countdown.complete`, `app.lifeup.item.countdown.stop`, `app.lifeup.timing.start`, `app.lifeup.timing.complete`, `app.lifeup.timing.pause`, `app.lifeup.timing.abandon`. يتطلب جمع الأحداث تفعيل البث في LifeUp. يتحقق استطلاع `/events` من الإعداد ولا يفعّله تلقائيًا.
