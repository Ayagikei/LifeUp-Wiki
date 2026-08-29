<h1 align="center" padding="100">واجهة مفتوحة</h1>

<p align="center">أنشئ إمكانيات لا حدود لها!</p>

?> في الإصدار v1.90، فتح `LifeUp` مجموعة متنوعة من الواجهات الوظيفية، ونرحب بأي تكامل مع تطبيقات خارجية. <br/>كما يوفر تأثير «URL» لعناصر المتجر، ويمكن للمستخدمين استخدام السلع مباشرةً لاستدعاء تطبيقات خارجية أو واجهة `LifeUp`. <br/>يمكن لهذه الميزات أن تمنح `LifeUp` إمكانيات لا حدود لها، لكنها تتطلب قليلاً من الفهم والتعلم والقدرة على التطبيق العملي.

**آخر تحديث: 2026/08/28**

تستند معلمات واجهة API وتعريفاتها في هذا المستند إلى الإصدار **v1.106.0**.

يُرجى التأكد من تحديث تطبيقك إلى **v1.106.0** قبل استخدام أحدث واجهة API.

يتم طرح التحديث تدريجياً عبر Google Play، وإذا لم يصلك بعد، فانتظر قليلاً وسيصل قريباً.

## مثال سيناريو

| المُستدعي | السيناريو | ملاحظات |
| ------ | -------- | ----- |
|**LifeUp → تطبيقات أخرى**<br/>يُنفَّذ عبر تأثير «URL» لعنصر المتجر| **بعد استخدام عنصر المتجر:**<br/>1. استخدام متصفح لزيارة صفحة ويب<br/>2. الانتقال إلى WeChat والمسح، أو تحديد برنامج مصغّر<br/>3. إضافة سجلات محاسبة تلقائياً ([مثل أن «Qianji» يدعم واجهة المحاسبة](http://docs.qianjiapp.com/plugin/auto_tasker.html))<br/>4. حفظ إعدادات أداة الأتمتة Tasker (حتى مشاركتها في السوق)، واستيراد الإعدادات تلقائياً إلى Tasker بعد الاستخدام<br/>5. تشغيل Tasker لتغيير خلفية الشاشة<br/>6. ... (طالما يدعم التطبيق الخارجي طريقة الاستدعاء هذه) | [Tasker](https://play.google.com/store/apps/details?id=net.dinglisch.android.taskerm&hl=en_US&gl=US) أداة أتمتة وتدعم تصدير الإعدادات كـ Uri |
|**LifeUp → LifeUp**<br/>يُنفَّذ عبر تأثير «URL» لعنصر المتجر| **بعد استخدام عنصر المتجر:**<br/>1. فتح صفحة محددة<br/>2. رفع سعر فائدة الصراف الآلي<br/>3. نافذة منبثقة تتيح للمستخدم اختيار المنتج وتخفيض سعره (قسيمة خصم)<br/>4. تشغيل إكمال مهمة<br/>5. إظهار رسالة تحفيزية مخصصة<br/>6. إنشاء قالب مكافأة مهمة: أدخل الاسم فقط لإنشاء مهمة تلقائياً<br/>7. نافذة منبثقة تطلب من المستخدم اختيار فرع، لإنشاء تفاعل سياقي صغير<br/>8. المزيد من العمليات داخل التطبيق... |  |
|**تطبيقات/صفحات ويب خارجية → LifeUp** | **إعداد أدوات الأتمتة:**<br/>1. تحديد وقت تشغيل الهاتف لأول مرة كل يوم، وإكمال مهمة الاستيقاظ مبكراً، أو تشغيل عقوبة «الاستيقاظ متأخراً» مباشرةً<br/>2. بعد كل 25 كلمة، تمرير بطاقة NFC محددة وإكمال المهمة تلقائياً<br/>3. يحدد GPS الوصول إلى مكان جديد، ويفتح إنجاز «مكان جديد»<br/>4. عند الاتصال بـ Wi-Fi العمل كل يوم، زيادة تقدم شرط الفتح. بعد تراكم 20 يوماً، فتح إنجاز «Worker»<br/>5. مكافأة نفسك بعملات «الوصول إلى المنزل» عند الاتصال بـ Wi-Fi المنزل لأول مرة كل يوم<br/>6. التقاط إشعارات من تطبيقات Pomodoro أو التركيز الأخرى، وتسجيل التوقيت تلقائياً في `LifeUp`<br/>7. التقاط إشعار إكمال أو انتهاء برامج الرياضة والتعلم، ومنح نقاط خبرة «strength» و«knowledge» تلقائياً<br/>8. خلال الفترة الزمنية التي تحددها، كل مرة تفتح فيها هاتفك، تُشغَّل عقوبة<br/>9. ...<br/>**ربط تطبيق خارجي / تطبيق مطوّر ذاتياً:**<br/>1. إذا لم تكن راضياً عن Pomodoro في `LifeUp`: يمكنك تطوير برنامج توقيت خاص بك، سواء تطبيق ويب أو Android، والربط مع «LifeUp» عبر الواجهة لإضافة سجلات التوقيت أو المكافآت<br/>2. تعديل بعض الألعاب المصغّرة الذكية (مثل مثال Wordle أدناه). عند إكمال اللعبة بنجاح، تشغيل `LifeUp` لإرسال المكافآت<br/>3. ... |  |

<br/>بعبارة أخرى، جميع الأمثلة أعلاه هي في الواقع «أحداث» تُشغّل «إجراءات».

يوفر تحديث `LifeUp` هذا نقطة تشغيل الحدث «استخدام العناصر»، ثم يوفر «إجراءات» متنوعة (المكافآت، إكمال المهام، إلخ).

إذا كنت تحتاج إلى

- النقر على زر الويب
- تمرير بطاقة NFC
- الاستيقاظ كل يوم وفتح قفل الشاشة لأول مرة

فهذا النوع من الأحداث يتطلب تدخّل تطبيقات خارجية. مثلاً التطوير الثانوي بنفسك أو استخدام أدوات أتمتة مثل `Tasker` و`MacroDroid`.

**سيضيف تحديث LifeUp 1.90.2 سلسلة من «الأحداث»، ويمكن لأدوات الأتمتة أو التطبيقات الخارجية استقبال هذه الأحداث.**

يمكن استخدامها لتحقيق:

بعد استخدام العنصر، تشغيل أدوات أتمتة مثل Tasker لتبديل خلفية المشغّل.

بعد إكمال المهمة، تشغيل أداة أتمتة مثل Tasker لفتح تطبيق.

**في الإصدار 1.90.2، يمكن تحقيق «حدث LifeUp» يُشغّل «عملية Tasker».**

Tasker يمتلك صلاحيات عالية جداً، يمكن استخدامها لتغيير الخلفيات، إلغاء تثبيت التطبيقات، رفع الصوت، اختيار فتح تطبيقات محددة، والمزيد. يمكنك حتى كتابة منطق تفاعل واجهة المستخدم دون أساس برمجي.

---

## توصيات

**إذا لم تكن على دراية بالبرمجة،** يمكنك البحث عن عناصر متجر خاصة واستيرادها مباشرةً في [World] → [Market] → [Link]/[API]/[Automate]. يمكنك أيضاً محاولة تعديل المعلمات لتلبية احتياجاتك.

**إذا كنت على دراية بأساسيات الحاسوب،** جرّب قراءة توثيق الواجهة أدناه وتعديل التأثير المطلوب بنفسك. واستخدمه مع برامج الأتمتة مثل [*Tasker*](https://play.google.com/store/apps/details?id=net.dinglisch.android.taskerm). حتى إذا لم تعدّل إعدادات Tasker، طالما نجحت في تثبيت Tasker، يمكنك استيراد إعدادات الأتمتة التي يشاركها الآخرون في Market أو مجتمعات أخرى.

**إذا كان لديك أساس برمجي،** جرّب تطوير صفحات ويب أو تطبيقات Android لتكاملها مع LifeUp. هذه الصفحة ونسخ Wordle المخصصة أمثلة. نرحب أيضاً بإنشاء إعدادات أدوات الأتمتة ومشاركتها.

---

## استدعاء تطبيق آخر

إذا أردت استدعاء تطبيق خارجي في *LifeUp*، يكفي إضافة تأثير «Link» إلى عنصر المتجر، **وإدخال رابط صفحة ويب أو رابط خاص بالتطبيق**، ثم استخدام عنصر المتجر لتشغيل الاستدعاء.

**فيما يلي بعض الأمثلة (يمكنك أيضاً الذهاب إلى «World» → «Market» → «Link» لعرض العناصر العامة ذات تأثير استدعاء الواجهة):**

- فتح Google في المتصفح: https://www.google.com
- Facebook: [fb://](fb://)
- فتح تطبيق باسم الحزمة/معرّف App: [market://launch?id=net.sarasarasa.lifeup](market://launch?id=net.sarasarasa.lifeup)
- ...

نظرياً، طالما يوفر التطبيق الخارجي URL، يمكنك الانتقال باستخدام عنصر المتجر.

**يمكنك البحث عن رابط التطبيق الذي تحتاجه عبر البحث عن `URL Schemes` في Google.**

**هذه الروابط لا علاقة لها بـ `LifeUp`، `LifeUp` يوفر فقط وظيفة الانتقال عبر URL.**

**لذلك لا نقدّم قائمة URLs ولا نحافظ عليها. لكن يمكنك عرض عناصر المتجر العامة التي تحتوي على تأثير الرابط في صفحة [World] → [Market] → [Link].**

يمكنك العثور على اسم حزمة التطبيق (أي المعرّف):

- في رابط Google Play: https://play.google.com/store/apps/details?id=net.sarasarasa.lifeup
- باستخدام تطبيق إدارة التطبيقات
- باستخدام إجراء App Info في Tasker
- باستخدام إجراء Launch App في Macrodroid

---

## استدعاء واجهات LifeUp API

إذا:

- احتجت إلى استدعاء واجهة `LifeUp` داخل `LifeUp`. يكفي إضافة تأثير «link» إلى عنصر المتجر، وإدخال **URL محدد** وفقاً لوثائق API، ثم استخدام عنصر المتجر لإكمال الاستدعاء.
- الاستدعاء عبر صفحة الويب، يكفي الانتقال إلى واجهات LifeUp API عبر رابط تشعبي.
- الاستدعاء عبر App مطوّر بنفسك، يكفي استخدام Intent للانتقال إلى رابط الواجهة المقابل.
- الاستدعاء عبر أداة أتمتة (مثل Tasker)، أدخل رابط API المقابل في Browser URL في Tasker.

**بعض الأمثلة:**

عند النقر على الرابط أدناه، سيعرض «LifeUp» «You have learned to call APIs!».

<a href="lifeup://api/toast?text=You have learned to call APIs!&type=1&isLong=true">lifeup://api/toast?text=You have learned to call APIs!&type=1&isLong=true</a>

عند النقر على الرابط أدناه، ستحصل على عملة في «LifeUp»، والسبب هو «Learn API Calls».

<a href="lifeup://api/reward?type=coin&content=Learn API Calls&number=1">lifeup://api/reward?type=coin&content=Learn API Calls&number=1</a>

إذا نسخت الرابط إلى تأثير «link» للعنصر، يمكن لاستخدام العنصر أيضاً تشغيل نفس التأثير.

**مثال على الربط مع تطبيق خارجي:**

[Wordle Clone (lifeupapp.fun)](https://wiki.lifeupapp.fun/en/example/wordle/index.html)

Wordle لعبة تخمين كلمات صغيرة: خمّن كلمات بطول 5 أحرف. البرتقالي يعني أن الإجابة تحتوي الحرف. الأخضر يعني أن الحرف موجود وفي الموضع الصحيح.

**يدعم هذا الإصدار من Wordle الربط مع «LifeUp»:**

1. إذا خمّنت الكلمة بشكل صحيح، يمكنك الحصول على 10 عملات. وهناك سبب مخصص للحصول عليها.
2. إذا فشلت في تخمين الكلمة في النهاية، ستكون هناك جائزة مواساة بقيمة عملة واحدة.

![](_media/api/wordle.png ':size=30%')

<br/>

**مثال على الربط مع Tasker:**

> يُستدعى Tasker باختيار `Action Category` → `Program` → `Shortcut`. أدخل الرابط الذي يبدأ بـ lifeup:// في عمود الاختصار.

يمكن أن يُشغّل فتح قفل الشاشة لأول مرة بعد الساعة الخامسة كل يوم إكمال المهمة التي تحددها (مثل الاستيقاظ).

**ملاحظة: يلزم Task Group Id لاستيراد هذا الإعداد. يمكنك تشغيل [Developer Mode] في [Settings] → [Labs]، ثم التحقق من gid في صفحة تفاصيل المهمة.**

إذا كان Tasker مثبتاً لديك، [انقر هنا لاستيراد المهام المُعدّة.](taskerproject://H4sIAAAAAAAAAKVWTW/bOBA9p7+CENCeshZlfcWtzMJts0ABY1EkaS49FKxE20xlSZDG3s2/3xmSku1ELer25OF7Q/LNB0fO7mT3XbUfJEjWtXPPY8Vez73AY7Cfe8mETwLuiRcX2ae2XulSGacG7ejKY3s196bEXmR5IUGJIEl4NONxMAvDMPMtaOiyEdDuFGJoEaKON4RRMA2vMl8NG1alXHcCIWsQpAsRIYA/tNrqgosozXxjEFJtlVgAi9mN6hSwu41iH+Rj5hNO/J3eWvl5XZmY6JqNiPGOjVttBcfV1q7AcOA4MBwYLvPpLMqK79IymqHZORk6yUcc8YDPfiEfsyf5SJ7k42/ddsA+V2Wdf1fFJXtfb5tSgWJU9kNqrveqgkNujmSj7rpAXZxj9MY08ZsNxrwFlNhvDca2JvFh50X2vq4KDbqulrqzV+qVdT/i7HlOSOjoi6zcdOJlpf4tqKy0cHjdiGCa+XXTAy1ymd/2Hpk/nGxF+CcqbEgmkJGaPqgc+po+8B+VNJmm05TPro5LWklM71Kv1OeGyR3ULHfZx8RLl/lGFx229SVV0tgEggGTS2pvsKBRRVLIpuIZSYBGlJyKQRlREiVpMEvO6C9qpmRopqbVVHKUhAYBi3woi8zBZSE9LnNMERzKfAut9W7XhzIOtUPWun10bYdu1DuynHvc859x059w4SmX+VbriOxgRHaY8mPZnRIrWXZYoc4h73ZV4R61icV11D16GRDvHvqzUjApdLUudZdvJrIq2loXEzATdnJzvby+X/xz9/V+cfNx8W55fStelfAGU4E7Fm0rH+0A9l+t4Q12yJln/Z6Ev+CxUeLL8kHu5aSU1Xpi9ZwvwJ7knhtlx700m79nTREMTVHiA9k1r31fNtrvX8jbtS7mL+myr2gNDXNSXPdM72Wr5bd+7u77yZ6XSrb1Dvp6DmvDqv+augWsHY6Jg20ovd3ugA7sdx4Awzf7XLtvmTEdWAhaF8OyEp/wxk4xXTU7YIBfIwqHrVFEwygm4+Tc8d0FVwTp4QQNAgwCPVKJo4zQ0uHO0fl1cBy2W5ncPUmYmSo0Sp6PlHRspHAeh/zHIyXk6TR+OlLSPxsp6W+MlNEmC8Znzhlz5YSLfsLFjgtHuMRxwbNZ1VfC/to/ZOLF/9uCy6GeCQAA)

![](_media/api/tasker_01.png ':size=30%')

![](_media/api/tasker_02.png ':size=30%')

<br/>

**كيفية استخدام MacroDroid لاستدعاء واجهات LifeUp API:**

> [MacroDroid](https://play.google.com/store/apps/details?id=com.arlosoft.macrodroid&hl=en_US&gl=US) أداة أتمتة أيضاً، مجانية للتنزيل وواجهتها أسهل في الاستخدام.

1. أضف ماكرو، ثم حدّد الشروط التي تحتاجها (أو حدّدها لاحقاً)
2. أضف `Actions`
3. اختر `Applications`
4. اختر `Open Website`
5. أدخل URL يبدأ بـ `lifeup://` في حقل `Enter URL`
6. **[ألغِ التحديد]** لجميع الخيارات أدناه، مثل `URL encode parameters`...
7. احفظ، يمكنك النقر على الإجراء، ثم اختيار `Test action` للتحقق

<br/>

**عبر هذه الوظيفة، يمكنك توسيع إمكانيات LifeUp بلا حدود، سواء كنت تعرف البرمجة أم لا!**

يُرجى الاطلاع أدناه على قواعد الاستدعاء المحددة.

---

## توثيق الواجهة

### Basics - Examples

| النوع             | الوصف   |
| ---------------- | ------------- |
| مثال          | <a href="lifeup://api/toast?text=You learned to call! &type=1&isLong=true">lifeup://api/toast?text=You learned to call! &type=1&isLong=true</a> |
| تنسيق الواجهة | fixed prefix/method name?parameter1=value1&parameter2=value2 |
| البادئة الثابتة     | lifeup://api/ |
| اسم الدالة      | toast         |
| المعلمات       | ?text=You learned to call! &type=1&isLong=true |

<br/>

### Basics - Escaping (URL Encode)

إذا كانت قيمة المعلمة تحتوي على رموز خاصة مثل + أو مسافة أو = أو % أو & أو #، إلخ، فيجب ترميزها:

| الرموز الخاصة | المعنى                                         | استبدل بـ |
| :----------------- | :---------------------------------------------- | :--------- |
| +                  | علامة + في URL تمثل مسافة        | +          |
| مسافات             | المسافات في URLs يمكن أن تكون + أو مُرمّزة              | %20        |
| /                  | يفصل المجلد والمجلد الفرعي            | %2F        |
| ?                  | يفصل URL الفعلي والمعلمات         | %3F        |
| %                  | يحدد رموزاً خاصة                      | %          |
| #                  | يعني إشارة مرجعية                                  | %23        |
| &                  | فاصل بين المعلمات المحددة في URL   | %26        |
| =                  | قيمة المعلمة المحددة في URL | %3D        |

لنأخذ واجهة الرسالة المنبثقة أعلاه كمثال. إذا أردت أن يكون النص المعروض نهائياً: `You have learned to call APIs!`
فعليك استبدال المسافات بـ +، والنتيجة النهائية:

<a href="lifeup://api/toast?text=You learned to call! &type=1&isLong=true">lifeup://api/toast?text=You learned to call! &type=1&isLong=true</a>
<br/>

**هذه أداة ترميز بسيطة مُنفَّذة في Javascript:**

<iframe src="guide/html/url_encoded.html" frameborder="0" scrolling="no" width="90%"> </iframe>

<br/>

### Basics - LifeUp Data ID

تخزّن تقريباً جميع البيانات في LifeUp معرّفاً فريداً.

تدعم بعض الواجهات التالية تعديل عناصر متجر **محددة** وإكمال **مهام** محددة.

لكي يجد `LifeUp` البيانات المقابلة، عليك تزويده بمعرّف.

**يمكنك تشغيل «Settings» → «Labs» → «Developer Mode» لعرض المعرّف الأصلي للبيانات في كل صفحة تفاصيل داخل App.**

على سبيل المثال، اسم السمة المعروض مثل «strength (1)»، معرّف السمة هو 1.

#### Task id

يمكن عرضه في صفحة تفاصيل الحدث.

id: إذا كانت مهمة متكررة، يُحدَّث المعرّف في كل مرة تتكرر فيها.

gid: معرّف مجموعة العناصر. بالنسبة لنفس المهمة المتكررة، لا يتغير gid.

#### List id

بعد تشغيل «Developer Mode»، اعرضه في نافذة «Select List» المنبثقة.

#### Attribute id

بعد تشغيل «Developer Mode»، اعرضه في صفحة «Custom Attributes».

#### Shop item id

بعد تشغيل «Developer Mode»، انقر على عنصر المتجر لعرض التفاصيل.

#### Achievement condition id

بعد تخصيص شرط الفتح للإنجاز «يتطلب استدعاء API خارجي للفتح»، يمكنك رؤية معرّف الشرط في صفحة التفاصيل.

<br/>

### Basics - Name Matching

عندما تدعم واجهة API البحث عن المهام أو عناصر المتجر أو المهام الفرعية بالاسم، يحاول LifeUp أولاً مطابقة الاسم حرفياً مع تجاهل حالة الأحرف. إذا لم يُعثر على مطابقة حرفية، يلجأ إلى مطابقة تقريبية بالاحتواء.

على سبيل المثال، إذا وُجد كل من «Coin» و«Coin Box»، فإن تمرير `name=Coin` يطابق «Coin» أولاً بدلاً من أي نتيجة تقريبية تظهر سابقاً.

إذا كانت الأسماء المكررة أو المتشابهة قد تسبب غموضاً، يُفضَّل تمرير المعرّف المقابل.

<br/>

### Basics - Return Values

قد يكون لبعض الواجهات قيم إرجاع.

**إذا كنت تطوّر تطبيق Android،** يمكنك استخدام طريقة `onActivityResult` لاستقبال قيمة الإرجاع.

**إذا كنت تستخدم تطبيق أتمتة مثل Tasker:**

عادةً لا تستطيع هذه التطبيقات استقبال قيم إرجاع من نوع Activity. لذا عليك إضافة معلمة `broadcast` ثم استخدام حدث `received intent` لاستقبال قيمة الإرجاع.

للتفاصيل، راجع معلمات broadcast أدناه.

<br/>

### Basics - JSON Data Structure

?> يتطلب v1.98.0+

يقدّم هذا القسم هياكل JSON الشائعة الاستخدام في API.

#### 1. Item Reward Structure

مصفوفة JSON تحدد مكافآت العناصر، كل عنصر يحتوي على معرّف وكمية.

```json
[
    {
        "item_id": 1,    // Item ID
        "amount": 2      // Quantity
    },
    {
        "item_id": 2,
        "amount": 3
    }
]
```

#### 2. Achievement Unlock Condition Structure

```json
[
    {
        "type": 7,           // Condition type
        "related_id": null,  // Related ID (some types must provide)
        "target": 1000000    // Target value
    }
]
```

#### 3. Purchase Limit Structure

`purchase_limit` مصفوفة JSON. كل كائن يمثل قاعدة قيد واحدة.

| Field | Meaning | Type | Required | Notes |
| ----- | ------- | ---- | -------- | ----- |
| limitType | نوع القيد | number | Yes | راجع جدول الأنواع أدناه |
| limitNumber | القيمة الرقمية الأساسية | number | No* | تُستخدم في قواعد الكمية/النطاق |
| maxNumber | الحد الأعلى للنطاق | number | No | تُستخدم في نطاق مستوى السمة / نطاق كمية العنصر المملوك |
| limitId | معرّف الهدف المرتبط | number | No* | مطلوب لقواعد السمة / العنصر / المهمة / دورة المهمة / الإنجاز |
| extendInfo | حمولة إضافية | string | No | تُستخدم في القواعد الزمنية؛ القيمة نفسها سلسلة JSON |

**تعريفات الأنواع**

| limitType | المعنى | الحقول المطلوبة / ملاحظات |
| --------- | ------- | ----------------------- |
| 0 | حد الكمية اليومي | `limitNumber`: الحد الأقصى للمرات في اليوم |
| 1 | حد الكمية الأسبوعي | `limitNumber`: الحد الأقصى للمرات في الأسبوع |
| 2 | حد الكمية الشهري | `limitNumber`: الحد الأقصى للمرات في الشهر |
| 3 | حد الكمية السنوي | `limitNumber`: الحد الأقصى للمرات في السنة |
| 10 | قاعدة مستوى السمة | `limitId`: معرّف السمة<br/>`limitNumber`: الحد الأدنى للمستوى<br/>`maxNumber`: الحد الأقصى للمستوى (اختياري) |
| 20 | نطاق زمني يومي | `extendInfo`: `{"startMinuteOfDay":540,"endMinuteOfDay":1320}` |
| 21 | اختيار أيام الأسبوع | `extendInfo`: `{"weekdays":[1,2,3,4,5]}`<br/>الاثنين = 1، الأحد = 7 |
| 22 | نطاق زمني مطلق | `extendInfo`: `{"startMillis":1710000000000,"endMillis":1710086400000}` |
| 23 | اختيار الأشهر | `extendInfo`: `{"months":[1,6,12]}` |
| 24 | اختيار أيام الشهر | `extendInfo`: `{"daysOfMonth":[1,15,31]}` |
| 30 | قاعدة كمية العنصر المملوك | `limitId`: معرّف العنصر المستهدف<br/>`limitNumber`: الحد الأدنى للعدد المملوك<br/>`maxNumber`: الحد الأقصى للعدد المملوك (اختياري) |
| 31 | قاعدة إكمال المهمة | `limitId`: معرّف المهمة |
| 32 | قاعدة فتح الإنجاز | `limitId`: معرّف الإنجاز |
| 33 | قاعدة إكمال دورة المهمة | `limitId`: معرّف مجموعة المهمة المتكررة (`groupId`)<br/>يُتحقَّق مقابل أحدث دورة بدأت في تلك المجموعة |

**ملاحظات**

- عند `limitType=33`، `limitId` ليس معرّف مهمة. يجب أن يكون `groupId` للمهمة المتكررة.

- يمكن للحمولات المتوافقة مع الإصدارات القديمة حذف `maxNumber` و`extendInfo`.
- `extendInfo` حقل نصي، لذا عند استدعاء API عبر URL، عادةً تحتاج سلسلة JSON بداخله إلى طبقة إضافية من الترميز/التشفير.

**مثال:**

```json
[
    {
        "limitType": 0,
        "limitNumber": 5
    },
    {
        "limitType": 10,
        "limitId": 1,
        "limitNumber": 5,
        "maxNumber": 10
    }
]
```

#### 4. Item Effect Structure

```json
[
    {
        "type": 2,           // Effect type
        "info": {            // Effect parameters, different for different types
            "min": 100,      // Minimum value (used for gold rewards, etc.)
            "max": 200       // Maximum value (used for gold rewards, etc.)
        }
    }
]
```

#### Effect Type Description

?> الأنواع 10-16 مدعومة من v1.102.0+

| Type Code | المعنى | وصف المعلمات |
| ------- | ---- | ------- |
| 0 | لا تأثير خاص | لا معلمات |
| 1 | غير قابل للاستخدام | لا معلمات |
| 2 | إضافة عملات | min: الحد الأدنى للعملات<br/>max: الحد الأقصى للعملات (اختياري، الافتراضي min)<br/>using_limit: ما إذا كان سيتم تطبيق حدود النظام (اختياري) |
| 3 | إزالة عملات | min: الحد الأدنى للعملات<br/>max: الحد الأقصى للعملات (اختياري، الافتراضي min)<br/>using_limit: ما إذا كان سيتم تطبيق حدود النظام (اختياري) |
| 4 | إضافة نقاط خبرة | ids: مصفوفة معرّفات المهارة<br/>value: قيمة نقاط الخبرة (قديم، نفس min)<br/>min: الحد الأدنى لنقاط الخبرة (اختياري، إذا لم تُقدَّم value)<br/>max: الحد الأقصى لنقاط الخبرة (اختياري، الافتراضي min/value)<br/>using_limit: ما إذا كان سيتم استخدام الحد (اختياري، الافتراضي false) |
| 5 | إزالة نقاط خبرة | ids: مصفوفة معرّفات المهارة<br/>value: قيمة نقاط الخبرة (قديم، نفس min)<br/>min: الحد الأدنى لنقاط الخبرة (اختياري، إذا لم تُقدَّم value)<br/>max: الحد الأقصى لنقاط الخبرة (اختياري، الافتراضي min/value)<br/>using_limit: ما إذا كان سيتم استخدام الحد (اختياري، الافتراضي false) |
| 6 | تركيب بسيط | require_number: الكمية المطلوبة<br/>item_id: معرّف العنصر |
| 7 | فتح صندوق | items: مصفوفة عناصر، كل عنصر يحتوي:<br/>- item_id: معرّف العنصر<br/>- amount: الكمية<br/>- probability: الاحتمال<br/>- is_fixed_reward: ما إذا كانت مكافأة ثابتة |
| 8 | عد تنازلي | seconds: ثواني العد التنازلي |
| 9 | رابط ويب | url: عنوان الرابط<br/>use_web_view: ما إذا كان سيتم استخدام المتصفح المدمج (اختياري، الافتراضي false) |
| 10 | تسجيل مشاعر | لا معلمات |
| 11 | تغيير العملات (زيادة أو نقصان) | min: الحد الأدنى للعملات (يمكن أن يكون سالباً)<br/>max: الحد الأقصى للعملات (اختياري، الافتراضي min)<br/>using_limit: ما إذا كان سيتم تطبيق حدود النظام (اختياري) |
| 12 | تغيير نقاط الخبرة (زيادة أو نقصان) | ids: مصفوفة معرّفات المهارة<br/>value: قيمة نقاط الخبرة (قديم، نفس min)<br/>min: الحد الأدنى لنقاط الخبرة (يمكن أن يكون سالباً)<br/>max: الحد الأقصى لنقاط الخبرة (اختياري، الافتراضي min/value)<br/>using_limit: ما إذا كان سيتم استخدام الحد (اختياري، الافتراضي false) |
| 13 | إضافة مخزون عنصر | item_id: معرّف العنصر المستهدف<br/>min: الحد الأدنى لتغيير المخزون<br/>max: الحد الأقصى لتغيير المخزون (اختياري، الافتراضي min)<br/>using_limit: ما إذا كان سيتم تطبيق حدود المخزون (اختياري) |
| 14 | إزالة مخزون عنصر | item_id: معرّف العنصر المستهدف<br/>min: الحد الأدنى لتغيير المخزون<br/>max: الحد الأقصى لتغيير المخزون (اختياري، الافتراضي min)<br/>using_limit: ما إذا كان سيتم تطبيق حدود المخزون (اختياري) |
| 15 | تغيير مخزون عنصر (زيادة أو نقصان) | item_id: معرّف العنصر المستهدف<br/>min: الحد الأدنى لتغيير المخزون (يمكن أن يكون سالباً)<br/>max: الحد الأقصى لتغيير المخزون (اختياري، الافتراضي min)<br/>using_limit: ما إذا كان سيتم تطبيق حدود المخزون (اختياري) |
| 16 | تشغيل صوت | file_name: اسم ملف الصوت المحلي (مُفضَّل)<br/>uri: URI الصوت للاستيراد (بديل لـ file_name)<br/>display_name: اسم العرض (اختياري) |

**مثال على التأثير:**

زيادة ذهب عشوائي:

```json
{
    "type": 2,
    "info": {
        "min": 100,
        "max": 200
    }
}
```

زيادة نقاط الخبرة:

```json
{
    "type": 4,
    "info": {
        "ids": [1, 2],
        "value": 50,
        "using_limit": false
    }
}
```

تغيير العملات (عشوائي +/-):

```json
{
    "type": 11,
    "info": {
        "min": -10,
        "max": 20
    }
}
```

تغيير مخزون العنصر (عشوائي +/-):

```json
{
    "type": 15,
    "info": {
        "item_id": 1,
        "min": -3,
        "max": 5
    }
}
```

تشغيل صوت:

```json
{
    "type": 16,
    "info": {
        "display_name": "API test sound",
        "uri": "android.resource://net.sarasarasa.lifeup/raw/bellringing"
    }
}
```

تأثير فتح الصندوق:

```json
{
    "type": 7,
    "info": {
        "items": [
            {
                "item_id": 1,
                "amount": 1,
                "probability": 50,
                "is_fixed_reward": false
            },
            {
                "item_id": 2,
                "amount": 1,
                "probability": 50,
                "is_fixed_reward": true
            }
        ]
    }
}
```

<br/>

### Popup message

**اسم الدالة:** toast

**الوصف:** تظهر رسائل بأنماط متنوعة.

**مثال:** <a href="lifeup://api/toast?text=Live well, eat well!&type=1&isLong=true">lifeup://api/toast?text=Live well, eat well!&type=1&isLong=true</a>

**شرح:** تظهر رسالة «Live well, eat well!» بنمط المكافأة ولمدة أطول.

> انقر رابط المثال لاختبار التأثير.

| Parameter | Meaning | Type | Example | Required | Notes |
| --------- | ------- | ---- | ------- | -------- | ----- |
| text | نص الرسالة المعروض | Any text | You learned to call! | yes | |
| type | نوع نمط النص | Number from 0 to 6 | 1 | no | 0 - Normal style<br/>1 - Bonus style<br/>2 - Tomato style<br/>3 - Success style<br/>4 - Prompt style<br/>5 - Warning style<br/>6 - Error style |
| isLong | مدة العرض | true or false | true | no | true - long<br/>false - short |

<br/>

### Reward

**اسم الدالة:** reward

**الوصف:** منح المكافأة مباشرةً. يمكن تخصيص سبب المكافأة.

**مثال:**

- الحصول على عملة واحدة، وسبب الحصول «Learn API Calls». يُعرض السبب في صفحة تفاصيل العملات:

  <a href="lifeup://api/reward?type=coin&content=Learn API Calls&number=1">lifeup://api/reward?type=coin&content=Learn API Calls&number=1</a>

- الحصول على 300 نقطة خبرة لـ «Learning, Creativity»، وسبب الحصول «Learn API Calls». يُعرض السبب في صفحة تفاصيل نقاط الخبرة:

  <a href="lifeup://api/reward?type=exp&content=Learn API Calls&number=300&skills=2&skills=6">lifeup://api/reward?type=exp&content=Learn API Calls&number=300&skills=2&skills=6</a>

- الحصول على عنصر واحد يطابق تقريباً «treasure»، وسبب الحصول «Learn API Calls». يُعرض السبب في صفحة سجل المخزون:

  <a href="lifeup://api/reward?type=item&content=Learn API Calls&number=1&item_name=treasure">lifeup://api/reward?type=item&content=Learn API Calls&number=1&item_name=treasure</a>

| Parameter | Meaning | Type | Example | Required | Notes |
| --------- | ------- | ---- | ------- | -------- | ----- |
| type | نوع المكافأة | currently only supported following values: <br/>coin<br/>exp<br/>item | coin | yes | coin - coins<br/>exp - experience points<br/>item - shop items |
| content | سبب المكافأة | any text | Learning API Calls | Yes | |
| skills | المهارات (السمات) | array of numbers greater than 0 | 1 | No | Available only when type is exp<br/>Supported arrays (eg &skills=1&skills=2&skills=3)<br/>For how to obtain, see above The article "Basic Knowledge - LifeUp Data ID" |
| number | عدد المكافآت | a number greater than 0 | 1 | Yes | If it is a gold coin, the maximum value is 999999<br/>If it is an experience value, the maximum value is 99999<br/>If it is a item, the maximum value is 999 |
| item_id | item id | number greater than 0 | 1 | no* | only available when type is item |
| item_name | item name | any text | treasure | no* | only available when type is item, fuzzy matching with item names |
| silent | تعطيل مطالبات الواجهة | true or false | false | no | default is false |

<br/>

### Penalty

**اسم الدالة:** penalty

**الوصف:** تطبيق عقوبة مباشرةً. يمكن تخصيص سبب العقوبة.

**مثال:** *أساساً نفس واجهة reward

- خصم عملة واحدة، والسبب «sleep in». يُعرض السبب في صفحة تفاصيل العملات:

  <a href="lifeup://api/penalty?type=coin&content=sleep in&number=1">lifeup://api/penalty?type=coin&content=sleep in&number=1</a>

- خصم 300 نقطة خبرة «Strength» بسبب «sleep in». يُعرض السبب في صفحة تفاصيل نقاط الخبرة:

  <a href="lifeup://api/penalty?type=exp&content=sleep in&number=300&skills=1">lifeup://api/penalty?type=exp&content=sleep in&number=300&skills=1</a>

- خصم عنصر واحد يطابق تقريباً «treasure» بسبب «sleep in». يُعرض السبب في صفحة سجل المخزون:

  <a href="lifeup://api/penalty?type=item&content=sleep in&number=1&item_name=treasure">lifeup://api/penalty?type=item&content=sleep in&number=1&item_name=treasure</a>

| Parameter | Meaning | Type | Example | Required | Notes |
| --------- | ------- | ---- | ------- | -------- | ----- |
| type | نوع العقوبة | Currently only supported: <br/>coin<br/>exp<br/>item | coin | yes | coin - coins<br/>exp - experience points<br/>item - shop items |
| content | سبب العقوبة | any text | Sleep In | Yes | |
| skills | المهارات (السمات) | array of numbers greater than 0 | 1 | No | Available only when type is exp<br/>Supported arrays (eg &skills=1&skills=2&skills=3)<br/>For how to obtain, see above The article "Basic Knowledge - LifeUp Data ID" |
| number | عدد العقوبات | a number greater than 0 | 1 | Yes | If it is a coin, the maximum value is 999999<br/>If it is an experience value, the maximum value is 99999<br/>If it is a item, the maximum value is 999 |
| item_id | item id | number greater than 0 | 1 | no* | only available when type is item |
| item_name | item name | any text | treasure | no* | only available when type is item, fuzzy matching with item names |
| silent | تعطيل مطالبات الواجهة | true or false | false | no | default is false |

<br/>

### Edit Coin

**اسم الدالة:** edit_coin

**الوصف:** تعديل رصيد عملات المستخدم مباشرةً. تُضبط كمية العملات الحالية على القيمة المحددة. يمكن تخصيص سبب التغيير وسيُعرض في سجل العملات.

**مثال:**

- ضبط العملات على 1000 بسبب «API adjustment»: <a href="lifeup://api/edit_coin?coin=1000&content=API adjustment">lifeup://api/edit_coin?coin=1000&content=API adjustment</a>
- ضبط العملات على 500 بصمت: <a href="lifeup://api/edit_coin?coin=500&silent=true">lifeup://api/edit_coin?coin=500&silent=true</a>

| Parameter | Meaning | Type | Example | Required | Notes |
| --------- | ------- | ---- | ------- | -------- | ----- |
| coin | كمية العملات المستهدفة | number >= 0 | 1000 | Yes | The final coin balance after the operation, maximum value is 999999 |
| content | سبب التغيير | any text | API adjustment | No | Defaults to system default reason if not provided |
| reason | سبب التغيير (اسم بديل) | any text | API adjustment | No | Alternative to content parameter |
| silent | تعطيل إشعار الواجهة | true or false | false | No | Defaults to false, set to true to suppress toast message |

<br/>

### Tasks

#### Add a Task

?> بعض الحقول مثل `pin` تتطلب v1.98.0+

**اسم الدالة:** add_task

**الوصف:** إنشاء مهمة مباشرةً.

**مثال:**
[lifeup://api/add_task?todo=This is an auto-added task&notes=notes&coin=10&coin_var=1&exp=2048&skills=1&skills=2&skills=3&category=0&item_name=coin](lifeup://api/add_task?todo=This is an auto-added task&notes=notes&coin=10&coin_var=1&exp=2048&skills=1&skills=2&skills=3&category=0&item_name=coin)

| Parameter | Meaning | Values | Example | Required | Notes |
| ---------------- | ------- | ------ | ------- | -------- | ----- |
| todo | محتوى المهمة | any text | Write diary | Yes | |
| notes | ملاحظات | any text | Notes | No | Defaults to empty |
| coin | مكافأة العملات | number >= 0 | 10 | No | Defaults to 0, subject to system limits |
| coin_var | تباين مكافأة العملات | number >= 0 | 1 | No | Defaults to 0; if >0, random reward between [coin, coin+coin_var] |
| exp | مكافأة نقاط الخبرة | number >= 0 | 100 | No | Defaults to 0, subject to system limits |
| skills | معرّفات المهارات | array of numbers > 0 | 1 | No | Supports arrays (e.g., &skills=1&skills=2) |
| category | معرّف القائمة | number >= 0 | 0 | No | Defaults to 0 (default list); smart lists not allowed |
| frequency | تكرار المهمة | integer | 0 | No | Defaults to 0 (once)<br/>0 - Once<br/>1 - Daily<br/>N (N>1) - Every N days<br/>-1 - Unlimited<br/>-3 - Ebbinghaus (requires v1.99.1)<br/>-4 - Monthly<br/>-5 - Yearly |
| weekdays | أيام الأسبوع | `1,3,5` or `none` | 1,3,5 | No | v1.106.0+; 1=Monday … 7=Sunday, days **to repeat**. If present, frequency must be omitted or 1. `none` is rejected on add; on edit, `none` clears back to daily. All 7 days is treated as daily |
| importance | مستوى الأهمية | [1, 4] | 1 | No | Defaults to 1 |
| difficulty | مستوى الصعوبة | [1, 4] | 1 | No | Defaults to 1 |
| deadline | وقت الاستحقاق | timestamp (milliseconds) | 1640995200000 | No | |
| no_deadline | بلا موعد استحقاق | true/false | true | No | v1.104.0+; only valid for repeating tasks. Passing `&no_deadline=true` clears the specific due time |
| color | لون الوسم | color string | #66CCFF | No | # must be escaped as %23 |
| background_url | رابط صورة الخلفية | web URL | http://example.com/bg.jpg | No | Must be accessible web image |
| background_alpha | شفافية الخلفية | float between [0, 1] | 0.5 | No | Defaults to 1.0 |
| enable_outline | تفعيل حدود النص | true or false | false | No | Only valid with background_url, adds outline to text for better readability |
| use_light_remark_text_color | نص فاتح للملاحظات | true or false | false | No | Only valid with background_url, uses light color for notes text |
| start_time | وقت البدء | timestamp (milliseconds) | 1640995200000 | No | Task start time |
| auto_use_item | استخدام مكافآت العناصر تلقائياً | true or false | false | No | Automatically use rewards on completion |
| remind_time | وقت التذكير | timestamp (milliseconds) | 1640995200000 | No | Task reminder time |
| pin | تثبيت المهمة | true or false | false | No | Pin task to top |
| words | نص مكافأة الإكمال | any text | Great job! | No | Motivational text shown when task is completed |
| frozen | حالة التجميد | true or false | false | No | Defaults to false |
| freeze_until | تجميد حتى | timestamp (milliseconds) | 1640995200000 | No | Only effective when frozen is true |
| coin_penalty_factor | معامل عقوبة العملات | float between [0, 100) | 0.5 | No | |
| exp_penalty_factor | معامل عقوبة نقاط الخبرة | float between [0, 100) | 0.5 | No | |
| write_feelings | تفعيل المشاعر | true or false | false | No | Defaults to false |
| item_id | Item ID | number > 0 | 1 | No* | Either item_id or item_name required |
| item_name | Item name | any text | Treasure | No* | Either item_id or item_name required |
| item_amount | كمية العنصر | [1, 99] | 1 | No | Defaults to 1 |
| items | مكافآت العناصر | JSON text | See [Item Rewards Structure](#1-item-rewards-structure) | No | Set multiple item rewards |
| task_type | نوع المهمة | [0, 4] | 0 | No | Requires v1.99.1<br/>0 - Normal task<br/>1 - Count task<br/>2 - Negative task<br/>3 - API task<br/>4 - Timed task (v1.102.0+) |
| target_times | عدد المرات المستهدف | number > 0 | 1 | No | Only valid when task_type is 1 (count task) |
| is_affect_shop_reward | التأثير على مكافأة المتجر | true/false | false | No | Only valid when task_type is 1 (count task), whether to affect the reward calculation of items |
| enable_proportional_settlement | تفعيل التسوية النسبية | true/false | false | No | v1.104.0+; only valid when task_type is 1 (count task). When enabled, count progress settlement grants rewards proportionally, and final completion will not grant already-settled rewards again |
| expected_focus_minutes | دقائق التركيز المتوقعة | number > 0 | 25 | No | Only valid when task_type is 4 (timed task); defaults to 25 (v1.102.0+) |
| repeat_end_mode | وضع انتهاء التكرار | 0 or 1 | 0 | No | Only valid for repeating tasks (frequency is not 0 / -1)<br/>0 - End by count<br/>1 - End by date (v1.102.0+) |
| repeat_target_times | عدد مرات انتهاء التكرار | number > 0 | 3 | No | Used when repeat_end_mode=0 (or inferred by presence of this field); do not confuse with target_times (v1.102.0+) |
| repeat_end_date | تاريخ انتهاء التكرار | timestamp (milliseconds) | 1640995200000 | No | Used when repeat_end_mode=1 (or inferred by presence of this field) (v1.102.0+) |
| repeat_end_behavior | سلوك انتهاء التكرار | 0 or 1 | 0 | No | 0 - Terminate task after reaching end condition<br/>1 - Freeze task after reaching end condition (v1.102.0+) |

**Response:**

| Field | Type | Description | Example | Notes |
| -------- | ------- | -------- | ------- | -------- |
| task_id | Number | Task ID | 1000 | |
| task_gid | Number | Task group ID | 1000 | |

<br/>

#### Complete a Task

**اسم الدالة:** complete

**الوصف:** تشغيل إكمال المهمة. يُبحث فقط عن المهام غير المكتملة.

**مثال:**

- إكمال المهمة ذات id 1: [lifeup://api/complete?id=1](lifeup://api/complete?id=1)
- إكمال المهمة ذات «task group id» 1: [lifeup://api/complete?gid=1](lifeup://api/complete?gid=1)
- البحث عن مهام بالاسم وإكمالها: <a href="lifeup://api/complete?name=Start using&ui=true">lifeup://api/complete?name=Start using&ui=true</a>

**شرح:**

لكل مهمة id.

بالنسبة للمهام المتكررة، يُحدَّث id في كل مرة، لكن «task group id» يبقى كما هو.

للحصول على id: فعّل «Developer Mode» في صفحة «Labs» ثم اعرضه في صفحة «Task Details».

| Parameter | Meaning | Type | Example | Required | Notes |
| --------- | ------- | ---- | ------- | -------- | ----- |
| id | task id | number greater than 0 | 1 | no* | task id; if it is a repeating task, the id will be updated every time it repeats. |
| gid | task group id | number greater than 0 | 1 | no* | task group id; |
| name | name | any text | get up | no* | fuzzy search, only one of the tasks found |
| ui | عرض واجهة منبثقة | true or false | true | no | the default is false, only a message is displayed in the background |
| count | قيمة العد | Number | 1 | No | Only applicable to count tasks, please use in conjunction with the `count_set_type` parameter |
| count_set_type | طريقة ضبط قيمة العد | One of the following:<br/>absolute<br/>relative | absolute | No | Default is relative<br/>absolute - Set the target to the value directly<br/>relative - Add or subtract based on the original value |
| count_force_sum_up | فرض جمع مكافآت مهمة العد | true or false | true | No | |
| reward_factor | معامل المكافأة | Floating point number greater than 0 | 1.1 | No | Not applicable to count tasks<br/>Reward factor affects the amount of experience and coins (not the quantity of goods) |

**Notice:**

1. لمطابقة المهمة، يجب تقديم أحد id أو gid أو name.
2. لا يمكن إكمال المهام المؤقتة يدوياً عبر هذه الواجهة (v1.102.0+).

<br/>

#### Give up a Task

**اسم الدالة:** give_up

**الوصف:** تشغيل التخلي عن المهمة.

**مثال:**

- البحث عن مهام بالاسم والتخلي عنها: [lifeup://api/give_up?name=get up early](lifeup://api/give_up?name=get up early)

**شرح:**

| Parameter | Meaning | Type | Example | Required | Notes |
| --------- | ------- | ---- | ------- | -------- | ----- |
| id | task id | number greater than 0 | 1 | no* | task id; if it is a repeating task, the id will be updated every time it repeats. |
| gid | task group id | number greater than 0 | 1 | no* | task group id; |
| name | name | any text | get up | no* | fuzzy search, operate on only one matched task |

**Notice:**

1. لمطابقة المهمة، يجب تقديم أحد id أو gid أو name.

<br/>

#### Freeze a task

**اسم الدالة:** freeze

**الوصف:** تشغيل تجميد المهمة، للمهام المتكررة فقط.

**مثال:**

- البحث عن مهام بالاسم وتجميدها: [lifeup://api/freeze?name=get up early](lifeup://api/freeze?name=get up early)

**شرح:**

| Parameter | Meaning | Type | Example | Required | Notes |
| --------- | ------- | ---- | ------- | -------- | ----- |
| id | task id | number greater than 0 | 1 | no* | task id; if it is a repeating task, the id will be updated every time it repeats. |
| gid | task group id | number greater than 0 | 1 | no* | task group id; |
| name | name | any text | get up | no* | fuzzy search, operate on only one matched task |
| time | تجميد حتى | timestamp | 1661688800682 | no | - |

**Notice:**

1. لمطابقة المهمة، يجب تقديم أحد id أو gid أو name.

<br/>

#### Unfreeze a task

**اسم الدالة:** unfreeze

**الوصف:** تشغيل إلغاء تجميد المهمة.

**مثال:**

- البحث عن مهام بالاسم وإلغاء تجميدها: [lifeup://api/unfreeze?name=get up early](lifeup://api/unfreeze?name=get up early)

**شرح:**

| Parameter | Meaning | Type | Example | Required | Notes |
| --------- | ------- | ---- | ------- | -------- | ----- |
| id | task id | number greater than 0 | 1 | no* | task id; if it is a repeating task, the id will be updated every time it repeats. |
| gid | task group id | number greater than 0 | 1 | no* | task group id; |
| name | name | any text | get up | no* | fuzzy search, operate on only one matched task |

**Notice:**

1. لمطابقة المهمة، يجب تقديم أحد id أو gid أو name.

<br/>

#### Delete a task

**اسم الدالة:** delete_task

**الوصف:** حذف مهمة.

**مثال:**

- البحث عن مهام بالاسم وحذفها: [lifeup://api/delete_task?name=get up early](lifeup://api/delete_task?name=get up early)

**شرح:**

| Parameter | Meaning | Type | Example | Required | Notes |
| --------- | ------- | ---- | ------- | -------- | ----- |
| id | task id | number greater than 0 | 1 | no* | task id; if it is a repeating task, the id will be updated every time it repeats. |
| gid | task group id | number greater than 0 | 1 | no* | task group id; |
| name | name | any text | get up | no* | fuzzy search, operate on only one matched task |

**Notice:**

1. لمطابقة المهمة، يجب تقديم أحد id أو gid أو name.

<br/>

### Edit Task

?> يتطلب v1.98.0+

**اسم الدالة:** edit_task

**الوصف:** تعديل محتوى وخصائص مهمة موجودة.

**مثال:**
[lifeup://api/edit_task?id=1&todo=Modified task content&notes=notes&coin=10&exp=20&skills=1&skills=2&category=0](lifeup://api/edit_task?id=1&todo=Modified task content&notes=notes&coin=10&exp=20&skills=1&skills=2&category=0)

| Parameter | Meaning | Values | Example | Required | Notes |
| ------------------ | ------- | ------ | ------- | -------- | ----- |
| id | Task ID | number greater than 0 | 1 | No* | One of id, gid, or name required |
| gid | Task group ID | number greater than 0 | 1 | No* | One of id, gid, or name required |
| name | Task name | any text | Write diary | No* | One of id, gid, or name required |
| todo | محتوى المهمة | any text | Write weekly | No | |
| notes | ملاحظات | any text | Note content | No | |
| coin | مكافأة العملات | number >= 0 | 10 | No | Coins earned upon completion, subject to system limits |
| coin_var | تباين العملات | number greater than 0 | 1 | No | Random reward between [coin, coin+coin_var] |
| exp | مكافأة نقاط الخبرة | number >= 0 | 20 | No | Experience points earned, subject to system limits |
| skills | معرّفات المهارات | array of numbers greater than 0 | 1 | No | Supports arrays (e.g., &skills=1&skills=2) |
| category | معرّف القائمة | number greater than or equal to 0 | 0 | No | 0 for default list, smart lists not supported |
| frequency | تكرار المهمة | integer | 0 | No | Defaults to 0 (once)<br/>0 - Once<br/>1 - Daily<br/>N (N>1) - Every N days<br/>-1 - Unlimited<br/>-3 - Ebbinghaus (requires v1.99.1)<br/>-4 - Monthly<br/>-5 - Yearly |
| weekdays | أيام الأسبوع | `1,3,5` or `none` | 1,3,5 | No | v1.106.0+; same as add_task. Omit to leave unchanged; `none` clears to daily; setting frequency to a non-1 value also clears weekdays |
| importance | مستوى الأهمية | [1, 4] | 1 | No | Defaults to 1 |
| difficulty | مستوى الصعوبة | [1, 4] | 2 | No | Defaults to 1 |
| deadline | موعد الاستحقاق | timestamp (milliseconds) | 1640995200000 | No | |
| no_deadline | بلا موعد استحقاق | true/false | true | No | v1.104.0+; only valid for repeating tasks. Passing `&no_deadline=true` clears the specific due time |
| remind_time | وقت التذكير | timestamp (milliseconds) | 1640995200000 | No | |
| start_time | وقت البدء | timestamp (milliseconds) | 1640995200000 | No | |
| color | لون الوسم | color string | #66CCFF | No | # must be escaped as %23 |
| background_url | رابط صورة الخلفية | web URL address | http://example.com/bg.jpg | No | |
| background_alpha | شفافية الخلفية | floating point between [0, 1] | 0.5 | No | |
| enable_outline | تفعيل حدود النص | true or false | false | No | Only valid with background_url, adds outline to text for better readability |
| use_light_remark_text_color | نص فاتح للملاحظات | true or false | false | No | Only valid with background_url, uses light color for notes text |
| item_id | Item ID | number greater than 0 | 1 | No* | One of item_id or item_name required |
| item_name | Item name | any text | Treasure | No* | One of item_id or item_name required |
| item_amount | كمية العنصر | [1, 99] | 1 | No | Defaults to 1 |
| items | JSON مكافآت العناصر | JSON text | [{"itemId":1,"amount":1}] | No | Set multiple item rewards |
| auto_use_item | استخدام العنصر تلقائياً | true or false | false | No | |
| frozen | حالة التجميد | true or false | false | No | Defaults to false |
| freeze_until | تجميد حتى | timestamp (milliseconds) | 1640995200000 | No | Only effective when frozen is true |
| coin_penalty_factor | معامل عقوبة العملات | floating point between [0, 100) | 0.5 | No | |
| exp_penalty_factor | معامل عقوبة نقاط الخبرة | floating point between [0, 100) | 0.5 | No | |
| write_feelings | تفعيل المشاعر | true or false | false | No | |
| pin | تثبيت المهمة | true or false | false | No | |
| words | نص مكافأة الإكمال | any text | Great job! | No | Motivational text shown when task is completed |
| task_type | نوع المهمة | [0, 4] | 0 | No | Requires v1.99.1<br/>0 - Normal task<br/>1 - Count task<br/>2 - Negative task<br/>3 - API task<br/>4 - Timed task (v1.102.0+) |
| target_times | عدد المرات المستهدف | number > 0 | 1 | No | Only valid when task_type is 1 (count task) |
| is_affect_shop_reward | التأثير على مكافأة المتجر | true/false | false | No | Only valid when task_type is 1 (count task), whether to affect the reward calculation of items |
| enable_proportional_settlement | تفعيل التسوية النسبية | true/false | false | No | v1.104.0+; only valid when task_type is 1 (count task). For existing count tasks, this parameter can be passed alone to turn proportional settlement on or off; changing this setting or reward configuration may reset or roll back settled progress according to app rules |
| expected_focus_minutes | دقائق التركيز المتوقعة | number > 0 | 25 | No | Only valid when task_type is 4 (timed task); defaults to 25 (v1.102.0+) |
| repeat_target_times | عدد مرات انتهاء التكرار | number > 0 | 3 | No | Only valid for repeating tasks (frequency is not 0 / -1); when both repeat_target_times and repeat_end_date are provided, repeat_target_times takes priority (v1.102.0+) |
| repeat_end_date | تاريخ انتهاء التكرار | timestamp (milliseconds) | 1640995200000 | No | Only valid for repeating tasks (frequency is not 0 / -1) (v1.102.0+) |
| repeat_end_behavior | سلوك انتهاء التكرار | 0 or 1 | 0 | No | 0 - Terminate task after reaching end condition<br/>1 - Freeze task after reaching end condition (v1.102.0+) |
| coin_set_type | طريقة ضبط قيمة العملات | One of:<br/>absolute<br/>relative | absolute | No | absolute - directly set coin to value<br/>relative - add/subtract from original coin value |
| exp_set_type | طريقة ضبط قيمة نقاط الخبرة | One of:<br/>absolute<br/>relative | absolute | No | absolute - directly set exp to value<br/>relative - add/subtract from original exp value |

**Response:**

| Field | Type | Description | Example | Notes |
| --------- | ------- | -------- | ------- | -------- |
| task_id | Number | Task ID | 1000 | |
| task_gid | Number | Task group ID | 1000 | |

<br/>

### Task Templates

?> أُضيف في v1.102.0+

**اسم الدالة:** task_template

**الوصف:** CRUD لقوالب المهام.

**أمثلة:**

- عرض القوالب: `lifeup://api/task_template?method=list`
- إنشاء من المعلمات: `lifeup://api/task_template?method=create&name=MyTemplate&todo=Write diary&frequency=0`
- إنشاء من مهمة موجودة: `lifeup://api/task_template?method=create&name=MyTemplate&from_task_id=1`
- الحصول على قالب: `lifeup://api/task_template?method=get&id=1`
- تحديث اسم القالب: `lifeup://api/task_template?method=update&id=1&name=NewName`
- تحديث محتوى القالب من مهمة: `lifeup://api/task_template?method=update&id=1&from_task_id=1`
- حذف القالب: `lifeup://api/task_template?method=delete&id=1`

| Parameter | Meaning | Value | Example | Required | Notes |
| --------- | ------- | ----- | ------- | -------- | ----- |
| method | العملية | list / get / create / update / delete | list | Yes | - |
| id | Template id | number > 0 | 1 | No* | Required for get/update/delete; alias: template_id |
| template_id | Template id | number > 0 | 1 | No* | Alias of id |
| name | اسم القالب | text | MyTemplate | No* | Required for create; required for update if not using from_task_id/from_task_gid |
| from_task_id | Build from task id | number > 0 | 1 | No | For create/update |
| from_task_gid | Build from task group id | number > 0 | 1 | No | For create/update |
| todo | محتوى المهمة | text | Write diary | No* | Required for create when not using from_task_id/from_task_gid |
| notes | ملاحظات | text | Notes | No | Default is empty |
| category | معرّف القائمة | number >= 0 | 0 | No | Alias: category_id |
| category_id | معرّف القائمة | number >= 0 | 0 | No | Alias of category |
| frequency | تكرار المهمة | integer | 0 | No | Same as add_task |
| weekdays | أيام الأسبوع | `1,3,5` | 1,3,5 | No | v1.106.0+; same as add_task; create rejects `none` |
| importance | مستوى الأهمية | [1, 4] | 1 | No | - |
| difficulty | مستوى الصعوبة | [1, 4] | 1 | No | - |
| coin | مكافأة العملات | number | 10 | No | - |
| coin_var | تباين مكافأة العملات | number | 1 | No | - |
| exp | مكافأة نقاط الخبرة | number | 100 | No | - |
| skills | معرّفات المهارات | array params | 1 | No | Supports arrays (e.g., &skills=1&skills=2) |
| skill_ids | معرّفات المهارات | JSON array or comma list | [1,2] | No | Alternative to skills |
| deadline | وقت الاستحقاق | timestamp (milliseconds) | 1640995200000 | No | - |
| start_time | وقت البدء | timestamp (milliseconds) | 1640995200000 | No | - |
| remind_time | وقت التذكير | timestamp (milliseconds) | 1640995200000 | No | - |
| words | نص مكافأة الإكمال | text | Great job! | No | - |
| task_type | نوع المهمة | [0, 4] | 0 | No | 0 - Normal<br/>1 - Count<br/>2 - Negative<br/>3 - API<br/>4 - Timed |
| target_times | عدد المرات المستهدف | number > 0 | 10 | No | Only valid when task_type is 1 (count task) |
| is_affect_shop_reward | التأثير على مكافأة المتجر | true / false | false | No | Only valid when task_type is 1 (count task) |
| enable_proportional_settlement | تفعيل التسوية النسبية | true / false | false | No | v1.104.0+; only valid when task_type is 1 (count task). Tasks created from the template keep this count-task settlement setting |
| expected_focus_minutes | دقائق التركيز المتوقعة | number > 0 | 25 | No | Only valid when task_type is 4 (timed task) |
| repeat_end_mode | وضع انتهاء التكرار | 0 or 1 | 0 | No | Only valid for repeating tasks (frequency is not 0 / -1)<br/>0 - End by count<br/>1 - End by date |
| repeat_target_times | عدد مرات انتهاء التكرار | number > 0 | 3 | No | Used when repeat_end_mode=0 (or inferred by presence of this field) |
| repeat_end_date | تاريخ انتهاء التكرار | timestamp (milliseconds) | 1640995200000 | No | Used when repeat_end_mode=1 (or inferred by presence of this field) |
| repeat_end_behavior | سلوك انتهاء التكرار | 0 or 1 | 0 | No | 0 - Terminate<br/>1 - Freeze |

**Return:**

| Field | Meaning | Type | Notes |
| ----- | ------- | ---- | ----- |
| templates | قائمة القوالب (JSON string) | text | Only for method=list |
| count | عدد القوالب | number | Only for method=list |
| template | تفاصيل القالب (JSON string) | text | Only for method=get |
| id | template id | number | For get/create/update/delete |
| name | اسم القالب | text | For get/create/update |
| success | whether success | true / false | For create/update/delete |

<br/>

### History Task Operation

?> يتطلب v1.98.0+

**اسم الدالة:** history_operation

**الوصف:** التعامل مع المهام المكتملة/المتروكة/منتهية الصلاحية.

**أمثلة:**

- حذف مهمة من السجل: [lifeup://api/history_operation?id=1&operation=delete](lifeup://api/history_operation?id=1&operation=delete)
- وضع علامة تخلي على المهمة: [lifeup://api/history_operation?id=1&operation=set_to_give_up](lifeup://api/history_operation?id=1&operation=set_to_give_up)
- إعادة تشغيل المهمة: [lifeup://api/history_operation?id=1&operation=restart](lifeup://api/history_operation?id=1&operation=restart)

!> هذه الواجهة تنطبق فقط على مهام السجل (المكتملة، المتروكة، أو منتهية الصلاحية)

| Parameter | Meaning | Values | Example | Required | Notes |
| ------------- | ------- | ------ | -------- | -------- | ----- |
| id | Task ID | number greater than 0 | 1 | Yes | ID of the history task |
| operation | نوع العملية | One of:<br/>delete<br/>complete<br/>undo_complete<br/>set_to_give_up<br/>set_to_overdue<br/>edit_completed_time<br/>restart | delete | Yes | delete - Delete task<br/>complete - Mark as completed<br/>undo_complete - Undo completion<br/>set_to_give_up - Mark as given up<br/>set_to_overdue - Mark as expired<br/>edit_completed_time - Modify completion time<br/>restart - Restart task |
| completed_time | وقت الإكمال | timestamp (milliseconds) | 1640995200000 | No* | Required only when operation is edit_completed_time |

**Response:**

| Field | Type | Description | Example | Notes |
| -------- | ------- | -------- | ------- | -------- |
| task_id | Number | Task ID | 1000 | ID of the operated task |

<br/>

### Shop Settings

**اسم الدالة:** shop_settings

**Instructions:** ضبط إعدادات المتجر المختلفة

**مثال:**

- ضبط معدل فائدة الصراف الآلي على 0.01%: [lifeup://api/shop_settings?key=atm_interest&value=0.01](lifeup://api/shop_settings?key=atm_interest&value=0.01)
- زيادة معدل الفائدة 0.01% في كل نقرة: [lifeup://api/shop_settings?key=atm_interest&value=0.01&set_type=relative](lifeup://api/shop_settings?key=atm_interest&value=0.01&set_type=relative)

| Parameter | Meaning | Type | Example | Required | Notes |
| --------- | ------- | ---- | ------- | -------- | ----- |
| key | النوع | Currently only following values  supported: <br/>atm_interest<br/>credit_interest<br/>line_of_credit<br/>discount_rate_for_returning<br/>atm_balance | atm_interest | yes | atm_interest - ATM daily rate<br/>credit_interest - loan daily rate<br/>line_of_credit - loanable amount<br/>discount_rate_for_returning - return discount Scale<br/>atm_balance - Set ATM balance |
| value | القيمة الرقمية | decimal number or integer | 0.01 | yes | different keys correspond to different value ranges<br/>For example, ATM balances do not support decimal points |
| set_type | طريقة ضبط القيمة | One of the following values:<br/>absolute<br/>relative | absolute | no |absolute - absolute value, that is, directly set the target to value<br/>relative - relative values, adding or subtracting from the original value|
| silent | التنفيذ بصمت (دون عرض الواجهة) | Boolean | false | No | Supported from v1.93.0-beta01 (502) and later<br/>Default is false, which means it will display UI prompts |

<br/>

### Jump

**اسم الدالة:** goto

**الوصف:** الانتقال إلى صفحة في `LifeUp`

**مثال:** [lifeup://api/goto?page=lab](lifeup://api/goto?page=lab)

**شرح:** الانتقال إلى صفحة المختبرات

| Parameter | Meaning | Value | Example | Required | Notes |
| --------- | ------- | ----- | ------- | -------- | ----- |
| page | الصفحة | One of the following values:<br/>main<br/>setting<br/>about<br/>pomodoro<br/>feelings<br/>achievement<br/>history<br/>add_task<br/>add_achievement<br/>add_achievement_cate<br/>exp<br/>coin<br/>backup<br/>add_item<br/>lab<br/>custom_attributes<br/>pomodoro_record<br/>synthesis<br/>pic_manage<br/>purchase_dialog<br/>task_detail<br/>dlc<br/>new_default<br/>use_item_dialog<br/>achievement_list<br/>user_achievement | lab | yes | `purchase_dialog` يشير إلى نافذة الشراء المنبثقة<br/> `use_item_dialog` يشير إلى نافذة استخدام العنصر المنبثقة<br/>باقي القيم تشير إلى صفحات رئيسية محددة |

#### 1. Jump to the item purchase/use pop-up window

عند ضبط المعامل `page` على `purchase_dialog` أو `use_item_dialog`، يمكنك تحديد معرّف العنصر:

مثال: `lifeup://api/goto?page=purchase_dialog&id=1`

| Parameter | Meaning | Value            | Example | Required | Notes   |
| --------- | ------- | ---------------- | ------- | -------- | ------- |
| id        | Item ID | Positive integer | 1       | Yes      | Item ID |

<br/>

#### 2. Jump to the subpage of the home page

عند ضبط المعامل `page` على `main`، يمكنك أيضاً تحديد الصفحة الفرعية للانتقال إليها:

مثال، الانتقال إلى صفحة المتجر: `lifeup://api/goto?page=main&sub_page=shop`

| Parameter   | Meaning       | Value | Example | Required | Notes  |
| ----------- | ------------- | ----- | ------- | -------- | ------ |
| sub_page    | sub page name | One of:<br/>todo<br/>shop<br/>inventory<br/>achievement<br/>status<br/>me<br/>statistic<br/>pomodoro<br/>feelings<br/>world | shop    | no       |      |
| category_id | list id       | number | 0      | no       | إذا كانت `sub_page` صفحة قائمة، يمكنك تحديد معرّف القائمة للانتقال إليها. <br/>مثل قائمة عناصر المتجر، قائمة المخزون، قائمة المهام. |

<br/>

#### 3. Jump to task details

عند ضبط المعامل `page` على `task_detail`، يمكنك أيضاً تحديد معرّف المهمة للانتقال إليها:

مثال، الانتقال إلى صفحة تفاصيل المهمة ذات المعرّف 53: `lifeup://api/goto?page=task_detail&task_id=53`

| Parameter | Meaning       | Value         | Example      | Required | Notes |
| --------- | ------------- | ------------- | ------------ | -------- | ----- |
| task_id   | task id       | task id       | 53           | No*      | معرّف المهمة؛ إذا كانت مهمة متكررة، يُحدَّث المعرّف في كل مرة تتكرر فيها. |
| task_gid  | task group id | task group id | 3            | No*      | معرّف مجموعة المهام |
| task_name | task name     | string        | get up early | No*      | اسم المهمة؛ مطابقة تقريبية لمهمة واحدة. |

**Notice:**

1. يكفي تقديم أحد المعاملات الثلاثة.
    - إذا قُدّمت عدة معاملات في آن واحد، يُطبَّق ترتيب أولوية داخلي. لكن هذا سلوك غير معرَّف، ولن تضمن App الترتيب.

<br/>

#### 4. Jump to new achievement page

عند ضبط المعامل `page` على `add_achievement`، **يجب** أيضاً تحديد معرّف الفئة:

مثال، الانتقال إلى صفحة إنشاء إنجاز جديد بفئة المعرّف 1: `lifeup://api/goto?page=add_achievement&category_id=1`

| Parameter    | Meaning         | Value         | Example | Required | Notes  |
| ------------ | --------------- | ------------- | ------- | -------- | ------ |
| category_id  | Achievement category id | Achievement category id | 1       | Yes      |        |

#### 5. Jump to specific achievement category page

عند ضبط المعامل `page` على `user_achievement`، **يجب** أيضاً تحديد معرّف الفئة:

مثال، الانتقال إلى صفحة فئة الإنجازات ذات المعرّف 1: `lifeup://api/goto?page=user_achievement&category_id=1`

| Parameter    | Meaning         | Value         | Example | Required | Notes  |
| ------------ | --------------- | ------------- | ------- | -------- | ------ |
| category_id  | Achievement category id | Achievement category id | 1       | Yes      |        |

#### 6. Jump to specific synthesis category page

عند ضبط المعامل `page` على `synthesis`، يمكنك اختيارياً تحديد معرّف الفئة:

مثال، الانتقال إلى صفحة فئة التركيب ذات المعرّف 1: `lifeup://api/goto?page=synthesis&category_id=1`

| Parameter    | Meaning         | Value         | Example | Required | Notes  |
| ------------ | --------------- | ------------- | ------- | -------- | ------ |
| category_id  | Synthesis category id | Synthesis category id | 1       | No       |        |

يمكنك أيضاً فتح صفحة التركيب مع عامل تصفية (v1.102.0+):

مثال، التصفية حسب معرّف عنصر المنتج 1: `lifeup://api/goto?page=synthesis&filter_type=product&filter_item_id=1&filter_item_name=Gem`

| Parameter        | Meaning           | Value | Example | Required | Notes |
| --------------- | ----------------- | ----- | ------- | -------- | ----- |
| filter_type     | Filter type       | product / ingredient / related | product | No* | يتطلب filter_item_id |
| filter_item_id  | Filter item id    | number > 0 | 1 | No* | يتطلب filter_type |
| filter_item_name| Filter item name  | text | Gem | No | اختياري، يُستخدم للعرض |

### Shop

#### Adding Items

?> بعض الحقول مثل `effects` تتطلب v1.98.0+

**اسم الدالة:** add_item

**الوصف:** إنشاء عنصر في المتجر بخصائص قابلة للتخصيص، بما في ذلك قيود الشراء وتأثيرات الاستخدام.

**مثال:** [lifeup://api/add_item?name=Take a 10-minute break&desc=Go and take a short break!&price=10&action_text=rest&icon=☕](lifeup://api/add_item?name=Take a 10-minute break&desc=Go and take a short break!&price=10&action_text=rest&icon=☕)

| Parameter        | Meaning                | Values               | Example       | Required | Notes                           |
| --------------- | --------------------- | -------------------- | ------------- | -------- | ------------------------------- |
| name            | Item name             | any text             | 10 minute break | Yes    |                                 |
| desc            | Description           | any text             | Take a break  | No       |                                 |
| icon            | Icon                  | emoji, http(s) URL, or built-in sample name | ☕ | No | يُخزَّن كـ `emoji_*.webp` أو `lifeup_sample_*` أو URL. إيموجي الاسم لا يضبط الأيقونة. |
| price           | Price                 | [0, 999999]         | 10            | No       | الافتراضي 0                    |
| stock_number    | Stock quantity        | [-1, 99999]         | -1            | No       | -1 يعني غير محدود              |
| action_text     | Action button text    | any text             | rest          | No       |                                 |
| disable_purchase| Disable purchase      | true or false        | false         | No       | الافتراضي false                |
| disable_use     | Disable use           | true or false        | false         | No       | الافتراضي false                |
| category        | Category ID           | number greater than or equal to 0 | 0 | No    | 0 للفئة الافتراضية          |
| order           | Display order         | integer              | 1             | No       | الموضع داخل الفئة            |
| purchase_limit  | Restriction rules     | JSON text            | See [Purchase Limit Structure](#3-purchase-limit-structure) | No | قيود شراء/استخدام قابلة للضبط |
| limit_scope     | Restriction scope     | purchase / use / both | purchase | No | يُطبَّق فقط عندما لا يكون `purchase_limit` فارغاً؛ الافتراضي `purchase` |
| effects         | Use effects           | JSON text            | See [Item Effects Structure](#4-item-effects-structure) | No | تأثيرات استخدام العنصر |
| own_number      | Initial owned quantity | integer             | 0             | No       | ضبط الكمية الأولية في المخزون  |
| unlist          | Hide from shop        | true or false        | false         | No       | الافتراضي false                |

**Return Data:**

| Field    | Type    | Description    | Example | Notes                    |
| -------- | ------- | -------------- | ------- | ------------------------ |
| item_id  | Number  | Item ID        | 1000    | معرّف العنصر المُنشأ   |

!> معامل effects يلغي disable_use. إذا ضبطت effects لتدل على عنصر غير قابل للاستخدام، يُتجاهَل disable_use.

<br/>

#### Edit Item

?> يتطلب v1.98.0+

**اسم الدالة:** item

**الوصف:** تعديل عناصر موجودة، بما في ذلك السعر والمخزون والتأثيرات وخصائص أخرى

**أمثلة:**

- ضبط السعر: [lifeup://api/item?id=1&set_price=1&set_price_type=relative](lifeup://api/item?id=1&set_price=1&set_price_type=relative)
- تعديل التأثيرات: [lifeup://api/item?effects=%5B%7B%22type%22%3A2%2C%22info%22%3A%7B%22min%22%3A100%2C%22max%22%3A200%7D%7D%5D&id=1](lifeup://api/item?effects=%5B%7B%22type%22%3A2%2C%22info%22%3A%7B%22min%22%3A100%2C%22max%22%3A200%7D%7D%5D&id=1)
  - المحتوى المفكوك لمعامل effects هو: `[{"type":2,"info":{"min":100,"max":200}}]`

| Parameter         | Meaning             | Values               | Example   | Required | Notes                           |
| ---------------- | ------------------- | -------------------- | --------- | -------- | ------------------------------- |
| id               | Item ID             | number greater than 0| 1         | No*      | يلزم id أو name      |
| name             | Item name           | any text             | Treasure  | No*      | للبحث التقريبي، وليس لإعادة التسمية  |
| set_name         | Set name            | any text             | Treasure  | No       | لا يمكن أن يكون فارغاً                 |
| set_desc         | Set description     | any text             | Get gift  | No       |                                |
| set_icon         | Set icon            | emoji, http(s) URL, or built-in sample name | ☕ | No | مثل `icon`. القيم غير المدعومة تُرجع `unsupported_parameter`. |
| set_price        | Adjust price        | integer              | 1         | No       |                                |
| set_price_type   | Price adjust method | absolute or relative | relative  | No       | absolute - ضبط مباشر<br/>relative - إضافة/طرح |
| own_number       | Adjust owned quantity| integer             | 1         | No       | يدعم القيم السالبة مع relative |
| own_number_type  | Own number adjustment| absolute or relative| relative  | No       | absolute - ضبط مباشر<br/>relative - إضافة/طرح |
| stock_number     | Adjust stock        | [-1, 99999]         | 1         | No       | -1 يعني مخزوناً غير محدود        |
| stock_number_type| Stock adjust method | absolute or relative | relative  | No       | absolute - ضبط مباشر<br/>relative - إضافة/طرح |
| disable_purchase | Disable purchase    | true or false        | false     | No       | الافتراضي false              |
| disable_use      | Disable use         | true or false        | false     | No       | الافتراضي false              |
| action_text      | Use button text     | any text             | Use       | No       |                                |
| title_color_string| Title color        | color string         | #66CCFF   | No       | يجب ترميز # كـ %23<br/>القيمة الفارغة تستعيد الافتراضي |
| effects          | Use effects         | JSON text            | See [Item Effects Structure](#4-item-effects-structure) | No | ضبط تأثيرات استخدام العنصر |
| purchase_limit   | Restriction rules   | JSON text            | See [Purchase Limit Structure](#3-purchase-limit-structure) | No | مرّر `null` لمسح جميع القيود |
| limit_scope      | Restriction scope   | purchase / use / both | purchase | No | يُحدَّث فقط عند تقديم هذا الحقل؛ يُمسح تلقائياً عندما يصبح `purchase_limit` فارغاً |
| category_id      | Category ID         | number >= 0          | 1         | No       | 0 للفئة الافتراضية         |
| order            | Display order       | integer              | 1         | No       | الموضع داخل الفئة           |
| unlist           | Remove from shop    | true or false        | false     | No       | الافتراضي false              |

!> يجب تقديم id أو name لتحديد العنصر المراد تعديله

<br/>

#### Adjust the Loot Box effect

**اسم الدالة:** loot_box

**الوصف:** تعديل تأثير صندوق الغنائم للعنصر الصندوقي المحدد؛ يدعم ضبط الاحتمال وعدد المكافآت وإضافة محتوى. (الحذف غير مدعوم حالياً)

**مثال:** <a href="lifeup://api/loot_box?name=Coin loot box&sub_name=A big bag of coins&set_type=relative&probability=1&fixed=false">lifeup://api/loot_box?name=Coin loot box&sub_name=A big bag of coins&set_type=relative&probability=1&fixed=false</a>

**شرح:** زيادة نسبة [كيس] العملات الذهبية الكبير في صندوق العملات بمقدار نقطة واحدة.

| Parameter   | Meaning                               | Type                                                    | Example        | Required | Notes                                                        |
| ----------- | ------------------------------------- | ------------------------------------------------------- | -------------- | -------- | ------------------------------------------------------------ |
| id          | item id                               | a number greater than 0                                 | 1              | no*      | راجع «Basic Knowledge - LifeUp Data ID» أعلاه لمعرفة كيفية الحصول عليه |
| name        | item name                             | any text                                                | Treasure chest | no*      | عند id مجهول، بحث تقريبي عن المنتج، وليس لتعديل الاسم |
| sub_id      | content item id                       | a number greater than 0                                 | 1              | no*      | معرّف محتوى الصندوق                                         |
| sub_name    | content item name                     | any text                                                | Get a gift     | no*      | بحث تقريبي عند مجهولية معرّف محتوى الصندوق |
| set_type    | adjustment method (absolute/relative) | one of the following values: <br/>absolute<br/>relative | relative       | no       | absolute - قيمة مطلقة، أي ضبط الهدف مباشرة<br/>relative - قيم نسبية، إضافة أو طرح من القيمة الأصلية |
| amount      | number of content item                | number                                                  | 1              | no       | عدد المكافآت لعنصر واحد                          |
| probability | probability of the content item       | number                                                  | 1              | no       | -                                                            |
| fixed       | whether it is a fixed reward          | boolean                                                 | true/false     | no       | -                                                            |

**Notice:**

1. للبحث عن منتج، يجب تقديم id أو name.
1. للبحث عن محتوى، يجب تقديم sub_id أو sub_name.
1. `name` و `sub_name` يجربان المطابقة التامة أولاً، ثم ينتقلان إلى المطابقة التقريبية.
1. واجهة `loot_box` القديمة تحافظ على سلوك التوافق: إذا ظهر نفس عنصر المحتوى عدة مرات بكميات مختلفة، تُعدَّل أول إدخال مطابق ولا تُستخدم `sub_amount` للتمييز. استخدم `loot_box/v2` عند الحاجة إلى تعديل/حذف/دمج حسب الكمية.

<br/>

#### Adjust the Loot Box effect (v2)

?> أُدخلت هذه الواجهة في الإصدار v1.104.2.

**اسم الدالة:** loot_box/v2

**الوصف:** نسخة محسّنة من واجهة loot_box. تعديل تأثير صندوق الغنائم للعنصر الصندوقي المحدد؛ يدعم ضبط الاحتمال وعدد المكافآت وإضافة محتوى و**حذف محتوى**.

**التحسينات مقارنةً بـ v1:**
- **`sub_amount` للمطابقة الدقيقة**: عندما يحتوي الصندوق على عدة إدخالات لنفس العنصر بكميات مختلفة (مثل A x1 50%، A x2 30%)، استخدم `sub_amount` لاستهداف إدخال محدد. القيمة الافتراضية `1`. إذا لم يُعثر على إدخال مطابق، يبحث LifeUp عن العنصر عبر `sub_id` / `sub_name` ويضيف إدخالاً جديداً؛ إذا كان الطلب حذفاً (`amount=0`)، لا يُضاف إدخال جديد.
- **`set_type` مستقل**: يمكن التحكم في `amount_set_type` و `probability_set_type` بشكل مستقل. `set_type` العام يعمل كافتراضي احتياطي.
- **دعم الحذف**: ضبط `amount=0` مع `amount_set_type=absolute` (أو حساب `<=0` مع `relative`) يحذف الإدخال المطابق.
- **دمج التكرار**: إذا كان تغيير `amount` سيُكرّر إدخالاً موجوداً بنفس العنصر والكمية في نفس الصندوق، يدمج LifeUp في الإدخال الموجود ويواصل تطبيق قيم `probability` / `fixed` من الطلب.

**مثال:** <a href="lifeup://api/loot_box/v2?name=Coin loot box&sub_name=A big bag of coins&sub_amount=2&probability_set_type=relative&probability=10">lifeup://api/loot_box/v2?name=Coin loot box&sub_name=A big bag of coins&sub_amount=2&probability_set_type=relative&probability=10</a>

**شرح:** زيادة احتمال [كيس] العملات الذهبية الكبير (x2) في صندوق العملات بمقدار 10 نقاط.

| Parameter              | Meaning                               | Type                                                    | Example        | Required | Notes                                                        |
| ---------------------- | ------------------------------------- | ------------------------------------------------------- | -------------- | -------- | ------------------------------------------------------------ |
| id                     | item id                               | a number greater than 0                                 | 1              | no*      | راجع «Basic Knowledge - LifeUp Data ID» أعلاه لمعرفة كيفية الحصول عليه |
| name                   | item name                             | any text                                                | Treasure chest | no*      | عند id مجهول، بحث تقريبي عن المنتج، وليس لتعديل الاسم |
| sub_id                 | content item id                       | a number greater than 0                                 | 1              | no*      | معرّف محتوى الصندوق. إذا قُدّم sub_id و sub_name معاً، يُقدَّم sub_id |
| sub_name               | content item name                     | any text                                                | Get a gift     | no*      | بحث تقريبي عند مجهولية معرّف محتوى الصندوق |
| sub_amount             | content item amount for matching      | number                                                  | 2              | no       | لمطابقة إدخال بهذه الكمية بدقة. الحد الأدنى `1`، الافتراضي `1`. إذا لم يُعثر على مطابق وليس طلب حذف، يُضاف إدخال جديد. |
| set_type               | global adjustment method              | one of: `absolute` / `relative`                         | relative       | no       | افتراضي لـ `amount_set_type` و `probability_set_type` إذا لم يُحدَّد |
| amount_set_type        | adjustment method for amount          | one of: `absolute` / `relative`                         | relative       | no       | يلغي `set_type` لحقل amount                    |
| probability_set_type   | adjustment method for probability     | one of: `absolute` / `relative`                         | absolute       | no       | يلغي `set_type` لحقل probability               |
| amount                 | number of content item                | number                                                  | 1              | no       | عدد المكافآت لعنصر واحد. `0` (absolute) أو حساب `<=0` (relative) يحذف الإدخال |
| probability            | probability of the content item       | number                                                  | 1              | no       | -                                                            |
| fixed                  | whether it is a fixed reward          | boolean                                                 | true/false     | no       | -                                                            |
| query                  | list box contents                     | true or false                                           | true           | no       | v1.105.1+. يُرجع JSON العناصر فقط؛ sub_id / sub_name غير مطلوبين |

**Notice:**

1. للبحث عن منتج، يجب تقديم id أو name.
1. للبحث عن محتوى، يجب تقديم sub_id أو sub_name. استخدم `query=true` لعرض المحتويات دون sub_id / sub_name.
1. إذا قُدّم `sub_id` و `sub_name` معاً، يُقدَّم `sub_id`. يُستخدم `sub_name` فقط عند عدم وجود `sub_id` صالح.
1. `name` و `sub_name` يجربان المطابقة التامة أولاً، ثم ينتقلان إلى المطابقة التقريبية.
1. `sub_amount` الافتراضي `1`. عند وجود عدة إدخالات لنفس العنصر بكميات مختلفة، قدّم `sub_amount` لاستهداف إدخال محدد. إذا لم يُعثر على مطابق وليس طلب حذف، يُضاف إدخال جديد بـ `amount=sub_amount`.
1. لحذف إدخال، ضبط `amount=0` مع `amount_set_type=absolute`، أو `amount_set_type=relative` بقيمة سالبة تجعل المجموع `<=0`. الحذف ينطبق على الإدخالات المطابقة فقط؛ إذا لم يُطابق إدخال موجود، `amount=0` لا يضيف إدخالاً جديداً.
1. إذا كان تغيير `amount` لإدخال سيُكرّر إدخالاً موجوداً بنفس العنصر والكمية في نفس الصندوق، يدمج LifeUp في الإدخال الموجود ويواصل تطبيق `probability` / `fixed` من الطلب.
1. عندما يُفرغ الحذف الصندوق، يُحذَف تأثير صندوق الغنائم بالكامل بشكل soft-delete (العنصر نفسه يبقى ويمكن إعادة إضافة إدخالات صندوق الغنائم لاحقاً).

<br/>

#### Use items

?> أُدخلت هذه الواجهة في الإصدار v1.93.0-beta01 (502).

**اسم الدالة:** use_item

**الوصف:** استخدام عنصر محدد.

**مثال:**

- فتح صندوق عملات: [lifeup://api/use_item?name=coin_box&use_times=1](lifeup://api/use_item?name=coin_box&use_times=1)

| Parameter | Meaning     | Type                    | Example  | Required | Notes                                                        |
| --------- | ----------- | ----------------------- | -------- | -------- | ------------------------------------------------------------ |
| id        | Item ID     | a number greater than 0 | 1        | No*      | للحصول على معرّف العنصر، راجع قسم «Basic Knowledge - LifeUp Data ID» |
| name      | Item name   | Any text                | coin_box | No*      | عند id مجهول؛ يُجرى بحث تقريبي عن العناصر      |
| use_times | Usage times | a number greater than 0 | 1        | No       | الافتراضي مرة واحدة<br/>للعناصر العادية أو فتح الصناديق، يُطابق كمية العنصر<br/>لعناصر التركيب البسيط، تُطابق هذه القيمة «كمية التركيب» وليس عدد العناصر المستهلكة |

**Return:**

!> قد تفشل هذه الواجهة لأسباب متعددة، وقد تُقدَّم أسباب محددة في قيم الإرجاع.

| Parameter | Meaning            | Type     | Example          | Required | Notes                                                        |
| --------- | ------------------ | -------- | ---------------- | -------- | ------------------------------------------------------------ |
| result    | Result code        | a number | 0                | Yes      | 0 - استخدام ناجح<br/>1 - استثناء قاعدة البيانات<br/>2 - قيد نقاط الخبرة غير كافية<br/>3 - العنصر غير موجود<br/>4 - تعارض عدٍّ تنازلي قيد التشغيل<br/>5 - مخزون غير كافٍ<br/>6 - عنصر غير قابل للاستخدام<br/>7 - حد العملات<br/>8 - حد مخزون الهدف<br/>9 - قيد مستوى السمة<br/>10 - قيد الوقت<br/>11 - قيد كمية العناصر المملوكة<br/>12 - قيد إكمال المهمة<br/>13 - قيد فتح الإنجازات<br/>14 - قيد الكمية الدورية<br/>15 - قيد اكتمال دورة المهمة |
| desc      | Result description | Text     | RunningCountDown | Yes      |                                                              |

<br/>

### ATM

**⚠ متاح فقط في v1.91+**

> عمليات الإيداع والسحب هنا تُتحقَّق منها.
>
> إذا احتجت ضبط رصيد الصراف الآلي مباشرةً، راجع واجهة «Shop Settings» أعلاه.

#### Deposit

**اسم الدالة:** deposit

**الوصف:** يُتحقَّق من صحة الإيداع (هل رصيد العملات كافٍ).

**مثال:**[lifeup://api/deposit?amount=500](lifeup://api/deposit?amount=500)

**شرح:** إيداع 500 عملة.

| Parameter | Meaning        | Type                    | Example | Required | Notes |
| --------- | -------------- | ----------------------- | ------- | -------- | ----- |
| amount    | deposit amount | a number greater than 0 | 100     | yes      | -     |

**Return:**

| Parameter | Meaning                              | Type              | Example | Required | Notes |
| --------- | ------------------------------------ | ----------------- | ------- | -------- | ----- |
| result    | Whether the operation was successful | `true` or `false` | true    | yes      | -     |

<br/>

#### Withdraw

**اسم الدالة:** withdraw

**الوصف:** يُتحقَّق من صحة السحب (هل رصيد الصراف الآلي كافٍ).

**مثال:** [lifeup://api/withdraw?amount=500](lifeup://api/withdraw?amount=500)

**شرح:** سحب 500 عملة.

| Parameter | Meaning           | Type                    | Example | Required | Notes |
| --------- | ----------------- | ----------------------- | ------- | -------- | ----- |
| amount    | withdrawal amount | a number greater than 0 | 100     | yes      | -     |

**Return:**

| Parameter | Meaning                              | Type              | Example | Required | Notes |
| --------- | ------------------------------------ | ----------------- | ------- | -------- | ----- |
| result    | Whether the operation was successful | `true` or `false` | true    | yes      | -     |

<br/>

### Pomodoro Timer

**اسم الدالة:** pomodoro_timer

**الوصف:** التحكم في مؤقت Pomodoro الحقيقي (عدٌّ تنازلي أو تصاعدي) في LifeUp. تبدأ هذه الواجهة
نفس جلسة المؤقت كواجهة App؛ ولا تضيف سجلات Pomodoro أو طماطم مباشرةً.

**أمثلة:**

- بدء أو استئناف العدّ التنازلي الافتراضي للعمل:
  [lifeup://api/pomodoro_timer?action=start&mode=countdown](lifeup://api/pomodoro_timer?action=start&mode=countdown)
- بدء المؤقت التصاعدي واختيار المهمة 101:
  [lifeup://api/pomodoro_timer?action=start&mode=count_up&task_id=101](lifeup://api/pomodoro_timer?action=start&mode=count_up&task_id=101)
- إيقاف العدّ التنازلي النشط مؤقتاً:
  [lifeup://api/pomodoro_timer?action=pause&mode=countdown](lifeup://api/pomodoro_timer?action=pause&mode=countdown)
- التخلي عن دورة Pomodoro وإعادة ضبطها:
  [lifeup://api/pomodoro_timer?action=abandon&mode=countdown](lifeup://api/pomodoro_timer?action=abandon&mode=countdown)
- تخطّي مرحلة Pomodoro الحالية:
  [lifeup://api/pomodoro_timer?action=skip](lifeup://api/pomodoro_timer?action=skip)
- تسوية مؤقت تصاعدي دون الحصول على مكافآت الطماطم:
  [lifeup://api/pomodoro_timer?action=complete&mode=count_up&receive_reward=false](lifeup://api/pomodoro_timer?action=complete&mode=count_up&receive_reward=false)
- الاستعلام عن كلا وضعي المؤقت:
  [lifeup://api/pomodoro_timer?action=status](lifeup://api/pomodoro_timer?action=status)

**Parameters:**

| Parameter | Meaning | Type / values | Required | Notes |
| --------- | ------- | ------------- | -------- | ----- |
| action | Operation | `start`, `pause`, `abandon`, `skip`, `complete`, `select_task`, `status` | yes | - |
| mode | Timer mode | `countdown`, `count_up` | for `start`, `pause`, `abandon`, and `complete` | `skip` يستهدف العدّ التنازلي دائماً. |
| stage | Countdown stage | `work`, `short_break`, `long_break` | no | صالح فقط مع `mode=countdown`. عند الإهمال، تُستخدم المرحلة النشطة أو المتوقفة أو التالية؛ تبدأ دورة جديدة بـ `work`. |
| receive_reward | Whether to receive tomato rewards | `true` or `false` | for `complete` | قيمة منطقية صارمة. `complete` يدعم `mode=count_up` فقط. |
| task_id | Task ID | positive integer | no | لا يمكن دمجه مع `task_gid` أو `task_name`. |
| task_gid | Task group ID | positive integer | no | يمكن دمجه مع `task_name` لتضييق المطابقة. |
| task_name | Task name | text | no | تُفضَّل المطابقة التامة، مع المطابقة التقريبية كاحتياط. |
| clear_task | Clear the timer task | `true` or `false` | no | `true` لا يمكن دمجه مع محدّد مهمة. |

يتطلب `select_task` إما محدّد مهمة أو `clear_task=true`. قد يتضمن `start` معاملات
اختيار المهمة نفسها. معاملات المدة المخصصة غير مدعومة: العدّ التنازلي يستخدم
المدة الافتراضية الحالية أو مدة Pomodoro للمهمة المختارة.

`abandon&mode=countdown` يعادل الإجراء الأيسر في App: يتخلى عن المرحلة الحالية،
يعيد ضبط دورة Pomodoro، ويعود إلى مرحلة عمل متوقفة. `skip` يعادل
الإجراء الأيمن: ينقل من العمل إلى استراحة قصيرة/طويلة، أو من استراحة إلى عمل، دون
بدء المرحلة التالية تلقائياً. كل استدعاء `skip` إجراء حقيقي غير idempotent؛ لا ينبغي
إعادة المحاولة تلقائياً.

`complete&mode=count_up` يسوّي جلسة التصاعد الحقيقية. الجلسات الأقصر من 30 ثانية
تُستهلك دون إنشاء سجل. مع `receive_reward=false`، يُحفظ السجل الذي يبلغ العتبة
كمتروك لكن دون منح طماطم.

**Task switching rules:**

- عدٌّ تنازلي للعمل قيد التشغيل يرفض تغيير المهمة.
- مؤقت تصاعدي قيد التشغيل يسمح بتغيير المهمة ويحدّث إشعاره.
- عدٌّ تنازلي متوقف مؤقتاً يسمح بتغيير المهمة ويحافظ على الوقت المنقضي مع إعادة
  حساب المدة الإجمالية من إعدادات المهمة الجديدة.

**Successful return values:**

| Parameter | Meaning | Type |
| --------- | ------- | ---- |
| api_result | Whether the API call succeeded | boolean |
| applied | Whether this call changed timer state | boolean |
| mode | Target or currently selected timer mode | `countdown` or `count_up` |
| state | State of `mode` | `running`, `paused`, or `stopped` |
| selected_task_id | Current timer task ID, or `0` | number |
| can_start_in_background | Whether Android currently allows a background timer start | boolean |
| countdown_state | Canonical countdown state | `running`, `paused`, or `stopped` |
| countdown_phase | Countdown lifecycle phase | `idle`, `running`, `paused`, `completing`, `completed`, or `cancelled` |
| countdown_stage | Canonical countdown stage | `work`, `short_break`, or `long_break` |
| countdown_session_id | Canonical countdown session ID | text or null |
| countdown_total_millis | Countdown total duration | milliseconds |
| countdown_remaining_millis | Countdown remaining duration | milliseconds |
| count_up_state | Canonical count-up state | `running`, `paused`, or `stopped` |
| count_up_elapsed_millis | Count-up elapsed duration | milliseconds |
| battery_optimization_ignored | Whether LifeUp is exempt from battery optimization | boolean |

استجابات `complete` الناجحة تتضمن أيضاً `record_created` و `reward_tomatoes` و
`settled_elapsed_millis`.

استدعاءات `start` أو `pause` أو `abandon` المتكررة التي تطابق الحالة المطلوبة
تنجح مع `applied=false`. الاستدعاءات المعدِّلة لا توفر إلغاء تكرار عبر العمليات.

**Errors:**

عند الفشل تُرجَع `api_result=false` و `error_code` و `error_message`. رموز
الأخطاء الثابتة الخاصة بالمؤقت:

- `invalid_parameter`
- `missing_required_parameter`
- `unsupported_action_for_mode`
- `task_not_found`
- `task_change_not_allowed`
- `timer_mode_locked`
- `timer_state_conflict`
- `background_start_not_allowed`
- `timer_start_failed`
- `timer_settlement_failed`

في Android 12 وما بعده، يمكن لاستدعاء ContentProvider في الخلفية بدء مؤقت
فقط عندما يُسمح لـ LifeUp بتجاهل تحسين البطارية. وإلا يُرجَع `background_start_not_allowed`
قبل تغيير حالة المؤقت. فتح URL Scheme عبر Activity يُعرض LifeUp إلى الواجهة الأمامية قبل البدء. قد يمنع Android تطبيقاً طرفاً ثالثاً من تشغيل ذلك Activity من
الخلفية؛ عندها لا يتلقى LifeUp أي استدعاء API ولا يمكنه إرجاع خطأ.

<br/>

### Pomodoro Record

#### Add Pomodoro Record

**اسم الدالة:** add_pomodoro

**الوصف:** إضافة سجل توقيت طماطم

**مثال:**

- إضافة سجل توقيت بمدة 25 دقيقة (1500000 ms) وربطه بمهمة يحتوي اسمها على learning: [lifeup://api/add_pomodoro?task_name=learning&duration=1500000](lifeup://api/add_pomodoro?task_name=learning&duration=1500000)
- إضافة سجل توقيت من `2022-08-01 11:00:00` إلى `2022-08-01 12:00:00`: [lifeup://api/add_pomodoro?start_time=1659322800000&end_time=1659326400000](lifeup://api/add_pomodoro?start_time=1659322800000&end_time=1659326400000)

**شرح:**

| Parameter        | Meaning                    | Type                    | Example       | Required | Notes |
| ---------------- | -------------------------- | ----------------------- | ------------- | -------- | ----- |
| start_time       | timing start time          | timestamp               | 1659322800000 | no*      | إذا لم تكن تعرف Timestamp، ابحث عنه! |
| duration         | focus duration             | number (in milliseconds) <br/>must be greater than 30000 | 1500000 | no* | |
| end_time         | timing end time            | timestamp               | 1659326400000 | no*      |       |
| reward_tomatoes  | whether to reward tomatoes | true or false           | true          | no       | الافتراضي false |
| task_id          | task id                    | a number greater than 0 | 1             | no       |       |
| task_gid         | task group id              | a number greater than 0 | 1             | no       |       |
| task_name        | name                       | any text                | learning      | no       | بحث تقريبي، مهمة واحدة من النتائج |
| ui               | Display rewarded tomatoes UI | true or false         | true          | no       | أُدخل في v1.94.0، الافتراضي true |

**Notice:**

1. يجب تقديم أحد start_time أو duration أو end_time.
2. عند تقديم duration فقط، end_time الافتراضي هو الوقت الحالي.
3. يجب أن يكون end_time أكبر من start_time.
4. duration 30000 milliseconds (30 ثانية) على الأقل.
5. إذا قُدّمت start_time و duration و end_time معاً، يجب أن تكون duration أقل من أو تساوي (end_time - start_time).

<br/>

#### Edit Pomodoro Record

> أُدخل في v1.94.0
> **اسم الدالة:** edit_pomodoro

**الوصف:** تعديل سجل توقيت Pomodoro موجود أو إضافة سجل جديد إذا قُدّم `edit_item_id` صالح.

**مثال:**

- تعديل سجل بمعرّف محدد، ضبط المدة على 45 دقيقة (2700000 ms)، ومنح طماطم: [lifeup://api/edit_pomodoro?edit_item_id=123&duration=2700000&reward_tomatoes=true](lifeup://api/edit_pomodoro?edit_item_id=123&duration=2700000&reward_tomatoes=true)
- تعديل سجل بوقت البدء والانتهاء: [lifeup://api/edit_pomodoro?start_time=1659322800000&end_time=1659326400000&edit_item_id=456](lifeup://api/edit_pomodoro?start_time=1659322800000&end_time=1659326400000&edit_item_id=456)

**Parameters:**

| Parameter       | Meaning                    | Type                  | Example       | Required | Notes                                            |
| --------------- | -------------------------- | --------------------- | ------------- | -------- | ------------------------------------------------ |
| task_id         | Task ID                    | Number greater than 0 | 101           | No       | المعرّف الفريد للمهمة                   |
| task_gid        | Task group ID              | Number greater than 0 | 5             | No       | إذا قُدّم، يلغي task_id                |
| task_name       | Task name                  | Any text              | Study         | No       | يلزم إذا لم يُقدَّم task_id أو task_gid   |
| start_time      | Timing start time          | Timestamp             | 1659322800000 | No*      | ابحث عن timestamp إذا لم تكن تعرفه     |
| end_time        | Timing end time            | Timestamp             | 1659326400000 | No*      | -                                                |
| duration        | Focus duration             | Number (milliseconds) | 2700000       | No*      | 30000 milliseconds (30 ثانية) على الأقل |
| reward_tomatoes | Whether to reward tomatoes | true or false         | true          | No       | الافتراضي false                                 |
| edit_item_id    | ID of the item to edit     | Number greater than 0 | 123           | Yes      | يحدّد معرّف السجل المراد تعديله                  |
| ui              | Display reward tomatoes UI | true or false         | true          | No       |                                                  |
| delete          | Delete the record          | true or false         | true          | No       | v1.105.1+. soft-delete لسجل pomodoro (`isDel`)، مثل App |

**Return values:**

| Parameter | Meaning                          | Type   | Example | Required | Notes                    |
| --------- | -------------------------------- | ------ | ------- | -------- | ------------------------ |
| tomatoes  | Tomatoes gained from this action | Number | 2       | No       | يُرجَع إذا كان `ui` true |

**Notes:**

1. يجب تقديم أحد `start_time` أو `duration` أو `end_time` على الأقل.
2. يجب أن يكون `end_time` أكبر من `start_time`.
3. يجب أن تكون `duration` أقل من أو تساوي (`end_time` - `start_time`).
4. إذا قُدّم `edit_item_id` ووُجد السجل المقابل، يُعدَّل؛ وإلا يُنشأ سجل جديد بناءً على المعاملات الأخرى.

<br/>


### فتح شروط الإنجاز

**اسم الدالة:** unlock_condition

**الوصف:** فتح شرط إنجاز: يتطلب استدعاء API خارجي للفتح

**مثال:**

- استدعاء شرط الفتح بمعرّف unlock id 2: [lifeup://api/unlock_condition?id=2](lifeup://api/unlock_condition?id=2)

| Parameter | Meaning      | Type                  | Example | Required | Notes |
| --------- | ------------ | --------------------- | ------- | -------- |------ |
| id        | condition id | number greater than 0 | 2       | yes      |       |

<br/>

### إكمال / المطالبة بإنجاز

?> أُدخلت هذه الواجهة في v1.105.1.

**اسم الدالة:** complete_achievement

**الوصف:** إكمال إنجاز يدوي والمطالبة بمكافأته، أو المطالبة بمكافأة إنجاز تلقائي مفتوح مسبقاً. نفس سلوك النقر على خانة الإكمال / زر المطالبة بالمكافأة في App.

**مثال:**

- إكمال أو المطالبة بالإنجاز ذي المعرّف 1: [lifeup://api/complete_achievement?id=1](lifeup://api/complete_achievement?id=1)

| Parameter | Meaning        | Type                  | Example | Required | Notes |
| --------- | -------------- | --------------------- | ------- | -------- | ----- |
| id        | achievement id | number greater than 0 | 1       | yes      |       |

**Return value:**

| Field  | Type   | Description | Example | Notes |
| ------ | ------ | ----------- | ------- | ----- |
| id     | number | achievement ID | 1 | |
| status | number | status after the call | 2 | `0` locked · `1` unlocked, reward unclaimed · `2` unlocked, reward claimed |

**Notes:**

1. الإنجازات اليدوية (بدون شروط فتح): إذا كانت ما زالت مقفلة، يُكمل هذا الإنجاز ويمنح المكافآت.
2. الإنجازات التلقائية (مع شروط فتح): تطالب بالمكافآت فقط عندما يكون الإنجاز مفتوحاً ومكافأة ما زالت معلّقة. إذا لم تُستوفَ الشروط، يفشل الاستدعاء مع `error_code=achievement_not_unlocked`.
3. إعادة الاستدعاء بعد المطالبة بالمكافأة مسبقاً تنجح مع `status=2` ولا تمنح المكافآت مرتين.
4. يختلف هذا عن `achievement?unlocked=true`، الذي يكتب حالة الفتح فقط ولا يمنح المكافآت.

<br/>

### ضبط عدد الخطوات

**اسم الدالة:** step

**الوصف:** ضبط عدد الخطوات في التاريخ المحدد؛ مثلاً يمكن استخدامه لإدخال عدد الخطوات عبر سوار + أداة أتمتة. ويمكن استخدامه لتعديل السجلات التاريخية.

**مثال:**

- ضبط عدد خطوات 2022-10-21 في المنطقة الزمنية GMT+8 إلى 9999 خطوة: [lifeup://api/step?count=9999&time=1666282995643](lifeup://api/step?count=9999&time=1666282995643)

| Parameter | Meaning                         | Type                                | Example       | Required | Notes |
| --------- | ------------------------------- | ----------------------------------- | ------------- | -------- | ----- |
| count     | number of steps                 | a number greater than or equal to 0 | 9999          | yes      |       |
| time      | arbitrary timestamp of the date | timestamp (ms)                      | 1666282995643 | yes      |       |

<br/>

### تعديل نقاط الخبرة

?> أُدخلت هذه الواجهة في الإصدار v1.93.0-beta01 (502).

**اسم الدالة:** edit_exp

**الوصف:** يمكن لهذه الواجهة ضبط قيم نقاط الخبرة الحالية للسمات دفعة واحدة. يمكنها ضبط قيمة خبرة محددة أو مستوى معيّن مباشرةً.

**مثال:**

> تؤثر هذه الواجهة على البيانات، ولمنع الاستخدام العرضي، لا تُوفَّر روابط قابلة للنقر هنا.

- إعادة ضبط قيم نقاط الخبرة للسمات [Strength] و [Knowledge] إلى 0: lifeup://api/edit_exp?skills=1&skills=2&exp=0
- ضبط قيمة نقاط الخبرة لـ [Charm] مباشرةً إلى المستوى 50: lifeup://api/edit_exp?skills=3&level=50

| Parameter | Meaning              | Type                                      | Example | Required | Notes |
| --------- | -------------------- | ----------------------------------------- | ------- | -------- | ----- |
| skills    | Attribute (Skill) ID | Array of numbers greater than 0           | 1       | No       | Supports arrays (i.e., &skills=1&skills=2&skills=3)<br/>للحصول على معرّف السمة، راجع قسم «Basic Knowledge - LifeUp Data ID» |
| exp       | Set experience value | Number greater than or equal to 0 (int32) | 9999    | No, but either exp or level must be provided |                                                               |
| level     | Set level            | Number greater than or equal to 0 (int32) | 50      | No, but either exp or level must be provided | يمثل قيمة نقاط الخبرة الابتدائية لمستوى معيّن<br/>ويتأثر بتدرّجات المستويات المخصصة. |

<br/>

### إضافة أو تعديل المشاعر

?> هذه الواجهة متاحة اعتباراً من الإصدار v1.93.4 (536).

**اسم الدالة:** feeling

**الوصف:** تُستخدم لإنشاء سجلات المشاعر أو تحديثها.

**مثال:**

- إنشاء سجل مشاعر جديد: [lifeup://api/feeling?content=Happy&time=1633036800](lifeup://api/feeling?content=Happy&time=1633036800)
- تحديث سجل مشاعر موجود ووضع علامة مفضّل: [lifeup://api/feeling?id=1&is_favorite=true](lifeup://api/feeling?id=1&is_favorite=true)
- حذف مشاعر: [lifeup://api/feeling?id=1&delete=true](lifeup://api/feeling?id=1&delete=true)

| Parameter            | Meaning           | Type                               | Example           | Required | Notes                                                                                                                                                                                                                                        |
| -------------------- | ----------------- | ---------------------------------- | ----------------- | -------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| id                   | Feeling Record ID | Number greater than 0              | 1                 | No       | إذا قُدّم، تحاول الدالة تحديث سجل محدد. مطلوب عند الحذف.                                                                                                                                                           |
| content              | Content           | Any text                           | Happy             | No       | يُستخدم لإنشاء سجل جديد أو تحديث محتوى سجل موجود                                                                                                                                                                    |
| time                 | Timestamp         | Unix timestamp                     | 1633036800        | No       | وقت السجل، الافتراضي الوقت الحالي                                                                                                                                                                                             |
| is_favorite          | Favorite Flag     | true or false                      | true              | No       | يحدّد ما إذا كان السجل مفضّلاً                                                                                                                                                                                                        |
| delete               | Delete            | true or false                      | true              | No       | v1.105.1+. soft-delete للمشاعر بنفس طريقة App (تُزال المرفقات).                                                                                                                                                       |
| relate_type          | Relation Type     | Number between 0 and 3             | 1                 | No       | يحدّد نوع العلاقة المرتبطة بالسجل:<br/>0: Task<br/>1: Custom Achievement<br/>2: No relation<br/>3: Item usage                                                                                                        |
| relate_id            | Related ID        | Number greater than 0              | 2                 | No       | يحدّد معرّف العنصر المرتبط:<br/>عند relate_type = 0: يمثل task ID<br/>عند relate_type = 1: يمثل achievement ID<br/>عند relate_type = 3: يمثل item ID<br/>عند relate_type = 2: لا حاجة لمعرّف                |
| usage_count          | Usage count       | Integer greater than 1             | 1                 | No       | صالح فقط عند relate_type = 3 (Item usage)، يسجّل عدد مرات استخدام العنصر.                                                                                                                                                          |
| image_uris           | Image URIs        | List of URI strings                |                   | No       | Supports local file URIs (file://) or remote web images (http/https). Supports arrays (e.g., &image_uris=uri1&image_uris=uri2). |
| image_uris_update_mode | Update Mode       | APPEND or REPLACE | REPLACE           | No       | صالح فقط عند تحديث سجل موجود مع image_uris.<br/>APPEND: يُلحق بالصور الموجودة.<br/>REPLACE: يستبدل الصور الموجودة (الافتراضي).                                                               |
    
**Note:**

1. إذا قُدّم معامل `id`، تحاول الدالة تحديث سجل المشاعر المقابل. يُرمى استثناء إذا لم يُعثر على سجل مطابق.
2. إذا لم يُقدَّم `id` لكن `content` موجود، تنشئ الدالة سجل مشاعر جديد.

<br/>

### عدد الطماطم

?> يتطلب v1.98.0+

**اسم الدالة:** tomato

**الوصف:** ضبط عدد الطماطم (زيادة أو نقصان أو ضبط على قيمة محددة)

**أمثلة:**

- إضافة طماطمة واحدة: [lifeup://api/tomato?action=increase&number=1](lifeup://api/tomato?action=increase&number=1)
- إزالة طماطمتين: [lifeup://api/tomato?action=decrease&number=2](lifeup://api/tomato?action=decrease&number=2)
- ضبط عدد Pomodoro على 10: [lifeup://api/tomato?action=set&number=10](lifeup://api/tomato?action=set&number=10)

| Parameter | Meaning        | Values                                        | Example   | Required | Notes                                                         |
| --------- | -------------- | --------------------------------------------- | --------- | -------- | ------------------------------------------------------------- |
| action    | Operation type | One of:<br/>increase<br/>decrease<br/>set     | increase  | No       | increase - إضافة pomodoros (الافتراضي)<br/>decrease - إزالة pomodoros<br/>set - ضبط عدد Pomodoro على القيمة المحددة |
| number    | Amount         | Integer                                       | 1         | Yes      | معانٍ مختلفة حسب action:<br/>increase/decrease - الكمية المراد إضافتها/إزالتها<br/>set - الكمية المستهدفة |

**Response:**

| Field    | Type    | Description              | Example |
| -------- | ------- | ------------------------ | ------- |
| tomatoes | Integer | Current pomodoro count   | 10      |

<br/>

### شراء عنصر

?> يتطلب v1.98.0+

**اسم الدالة:** purchase_item

**الوصف:** شراء عنصر محدد

**أمثلة:**

- شراء العنصر ذي المعرّف 1: [lifeup://api/purchase_item?id=1](lifeup://api/purchase_item?id=1)
- شراء عنصر باسم «Health Potion»: [lifeup://api/purchase_item?name=Health%20Potion](lifeup://api/purchase_item?name=Health%20Potion)
- شراء 5 نسخ من العنصر ذي المعرّف 1: [lifeup://api/purchase_item?id=1&purchase_quantity=5](lifeup://api/purchase_item?id=1&purchase_quantity=5)

إذا كان للعنصر `purchase_limit` مُعدّاً و`limit_scope` يتضمن `purchase`، تفرض هذه الواجهة تلك القيود أيضاً.

| Parameter         | Meaning          | Values                | Example       | Required | Notes                      |
| ----------------- | ---------------- | --------------------- | ------------- | -------- | -------------------------- |
| id                | Item ID          | number greater than 0 | 1             | No*      | One of id or name required |
| name              | Item name        | any text              | Health Potion | No*      | One of id or name required |
| purchase_quantity | Purchase quantity| number greater than 0 | 5             | No       | Defaults to 1              |

**Response:**

| Field  | Type    | Description        | Example         | Notes                       |
| ------ | ------- | ------------------ | --------------- | --------------------------- |
| itemId | Number  | Item ID            | 1               | Returned on successful buy  |
| result | Integer | Result code        | 0               | See result codes below      |
| desc   | Text    | Result description | PurchaseSuccess | See result codes below      |

**Result Codes:**

| Code | Description               | Notes                         |
| ---- | ------------------------- | ----------------------------- |
| 0    | PurchaseSuccess           | نجح الشراء            |
| 1    | DatabaseError             | خطأ في قاعدة البيانات                |
| 2    | NotEnoughCoin             | عملات غير كافية              |
| 3    | ItemNotFound              | العنصر غير موجود                |
| 4    | PurchaseAndUseSuccess     | نجح الشراء والاستخدام    |
| 5    | PurchaseSuccessAndUseFailure | نجح الشراء لكن فشل الاستخدام |
| 6    | NotPurchaseable           | حُظر الشراء بإعدادات العنصر أو القيود |
| 7    | OutOfStock                | مخزون المتجر غير كافٍ      |

<br/>

### التركيب

?> يتطلب v1.98.0+

**اسم الدالة:** synthesize

**الوصف:** تركيب عناصر باستخدام صيغة موجودة

**أمثلة:**

- تركيب مرة واحدة باستخدام formula ID 1: [lifeup://api/synthesize?id=1](lifeup://api/synthesize?id=1)
- تركيب 5 مرات باستخدام formula ID 1: [lifeup://api/synthesize?id=1&times=5](lifeup://api/synthesize?id=1&times=5)

**Broadcast behavior:**

- هذه الواجهة مخصّصة **لتركيب الوصفات**.
- عند تفعيل `Broadcast events` ونجاح التركيب، يرسل LifeUp أيضاً حدث البث `app.lifeup.synthesis.complete`.
- **لا** يُرسَل هذا الحدث للتركيب البسيط داخل `use_item`؛ ذلك المسار ما زال ينتمي إلى `app.lifeup.item.use`.

| Parameter | Meaning            | Values                | Example | Required | Notes                    |
| --------- | ----------------- | -------------------- | ------- | -------- | ------------------------ |
| id        | Formula ID        | number greater than 0 | 1       | Yes      | ID of synthesis formula  |
| times     | Number of times   | number greater than 0 | 5       | No       | Defaults to 1           |

**Response:**

| Field           | Type    | Description     | Example          | Notes                    |
| -------------- | ------- | --------------- | ---------------- | ------------------------ |
| formulaId      | Number  | Formula ID      | 1                |                          |
| result         | Integer | Result code     | 0                | See result codes below   |
| desc           | Text    | Result description | SynthesisSuccess | See result codes below |
| synthesisResults| Text   | Synthesis results | {...}           | Only returned on success |

**Result Codes:**

| Code | Description          | Notes                 |
| ---- | ------------------- | --------------------- |
| 0    | SynthesisSuccess    | نجح التركيب  |
| 1    | FormulaNotFound     | الصيغة غير موجودة     |
| 2    | InsufficientMaterials| مواد غير كافية |
| 3    | DatabaseError       | خطأ في قاعدة البيانات        |
| 4    | UnknownError        | أخطاء أخرى         |

<br/>

### إدارة صيغ التركيب

?> يتطلب v1.98.0+

**اسم الدالة:** synthesis_formula

**الوصف:** إنشاء صيغ تركيب أو تعديلها أو حذفها

**أمثلة:**

- إنشاء صيغة جديدة: [lifeup://api/synthesis_formula?inputItems=%5B%7B%22item_id%22%3A%20296%2C%20%22amount%22%3A%2088%7D%5D&outputItems=%5B%7B%22item_id%22%3A%20295%2C%20%22amount%22%3A%201%7D%5D](lifeup://api/synthesis_formula?inputItems=%5B%7B%22item_id%22%3A%20296%2C%20%22amount%22%3A%2088%7D%5D&outputItems=%5B%7B%22item_id%22%3A%20295%2C%20%22amount%22%3A%201%7D%5D)
  - هنا inputItems هي `[{"item_id": 296, "amount": 88}]`
  - هنا outputItems هي `[{"item_id": 295, "amount": 1}]`
- حذف صيغة: [lifeup://api/synthesis_formula?id=1&delete=true](lifeup://api/synthesis_formula?id=1&delete=true)

| Parameter   | Meaning        | Values                | Example                        | Required | Notes                          |
| ----------- | -------------- | -------------------- | ------------------------------ | -------- | ------------------------------ |
| id          | Formula ID     | number greater than 0 | 1                             | No       | Required for modify or delete  |
| delete      | Delete flag    | true or false        | true                          | No       | Used only for deletion         |
| inputItems  | Input items    | Item array, see below | [{"item_id":1,"amount":2}]     | Yes      | Required for create or modify  |
| outputItems | Output items   | Item array, see below | [{"item_id":3,"amount":1}]     | Yes      | Required for create or modify  |
| category    | Category ID    | number greater than 0 | 1                             | No       | Defaults to common category    |

!> inputItems و outputItems مصفوفات JSON حيث يحتوي كل عنصر على حقول item_id و amount. يجب أن تكون جميع معرّفات العناصر موجودة وأن تكون الكميات أكبر من 0

**Response:**

| Field     | Type    | Description      | Example     | Notes                    |
| --------- | ------- | ---------------- | ----------- | ------------------------ |
| formulaId | Number  | Formula ID       | 1           | Returned on success      |
| result    | Integer | Result code      | 0           | See result codes below   |
| desc      | Text    | Result description | AddSuccess | See result codes below   |

**Result Codes:**

| Code | Description     | Notes             |
| ---- | -------------- | ----------------- |
| 0    | Success        | نجحت العملية |
| 1    | Failed         | فشلت العملية  |

<br/>

### إدارة المهام الفرعية

?> يتطلب v1.98.0+

**اسم الدالة:** subtask

**الوصف:** إنشاء مهام فرعية أو تعديلها

**أمثلة:**

- إضافة مهمة فرعية للمهمة الرئيسية ذات المعرّف 1: [lifeup://api/subtask?main_id=1&todo=Complete%20homework](lifeup://api/subtask?main_id=1&todo=Complete%20homework)
- تعديل مهمة فرعية وضبط المكافآت: [lifeup://api/subtask?main_id=1&edit_id=2&coin=10&exp=5](lifeup://api/subtask?main_id=1&edit_id=2&coin=10&exp=5)

| Parameter     | Meaning            | Values                | Example    | Required | Notes                           |
| ------------ | ------------------ | -------------------- | ---------- | -------- | ------------------------------- |
| main_id      | Main task ID       | number greater than 0 | 1         | No*      | One of main_id, main_gid, or main_name required |
| main_gid     | Main task group ID | number greater than 0 | 1         | No*      | One of main_id, main_gid, or main_name required |
| main_name    | Main task name     | any text             | Study task | No*      | One of main_id, main_gid, or main_name required |
| edit_id      | Subtask ID to edit | number greater than 0 | 2         | No*      | One of edit_id, edit_gid, or edit_name required when editing; not needed for creation |
| edit_gid     | Subtask group ID   | number greater than 0 | 2         | No*      | One of edit_id, edit_gid, or edit_name required when editing; not needed for creation |
| edit_name    | Subtask name       | any text             | Do homework| No*      | One of edit_id, edit_gid, or edit_name required when editing; not needed for creation |
| todo         | Task content       | any text             | Do homework| No       | Required when creating new subtask |
| remind_time  | Reminder time      | timestamp (milliseconds)| 1640995200000 | No | Pass null to clear reminder    |
| order        | Order              | integer              | 1          | No       | Position in task list           |
| coin         | Coin reward        | [0, 999999]         | 10         | No       | Coins earned upon completion    |
| coin_var     | Coin variance      | integer              | 5          | No       | Random variance in coin reward  |
| exp          | Experience reward  | [0, 99999]          | 5          | No       | Experience points earned        |
| auto_use_item| Auto use item      | true or false        | true       | No       | Whether to use item automatically on completion |
| item_id      | Item ID            | number greater than 0 | 1         | No*      | One of item_id or item_name required |
| item_name    | Item name          | any text             | Health Potion| No*    | One of item_id or item_name required |
| item_amount  | Item amount        | number greater than 0 | 1         | No       | Only valid when setting item reward |
| items        | Items JSON         | JSON text            | [{"item_id":1,"amount":1}] | No | Set multiple item rewards at once |
| coin_set_type     | How to set coin value | One of:<br/>absolute<br/>relative | absolute | No | absolute - ضبط العملات مباشرة على القيمة<br/>relative - إضافة/طرح من قيمة العملات الأصلية |
| exp_set_type      | How to set exp value | One of:<br/>absolute<br/>relative | absolute | No | absolute - ضبط نقاط الخبرة مباشرة على القيمة<br/>relative - إضافة/طرح من قيمة نقاط الخبرة الأصلية |

**Response:**

| Field        | Type    | Description      | Example | Notes            |
| ------------ | ------- | ---------------- | ------- | ---------------- |
| main_task_id | Number  | Main task ID     | 1       |                  |
| subtask_id   | Number  | Subtask ID       | 2       |                  |
| subtask_gid  | Number  | Subtask group ID | 3       | May be empty     |

<br/>

### إدارة الفئات

?> يتطلب v1.98.0+

**اسم الدالة:** category

**الوصف:** إضافة فئات أو تعديلها (قوائم المهام، قوائم الإنجازات، قوائم المتجر، قوائم التركيب)

**أمثلة:**

- إنشاء قائمة مهام: [lifeup://api/category?type=tasks&name=Study List](lifeup://api/category?type=tasks&name=Study List)
- تعديل قائمة متجر: [lifeup://api/category?type=shop&edit_id=1&name=Equipment Shop&order=1](lifeup://api/category?type=shop&edit_id=1&name=Equipment Shop&order=1)

| Parameter        | Meaning           | Values               | Example    | Required | Notes                           |
| --------------- | ----------------- | -------------------- | ---------- | -------- | ------------------------------- |
| type            | Category type     | One of:<br/>tasks<br/>achievements<br/>shop<br/>synthesis | tasks | Yes | tasks - قوائم المهام<br/>achievements - قوائم الإنجازات<br/>shop - قوائم المتجر<br/>synthesis - قوائم التركيب |
| edit_id         | Category ID to edit| number greater than 0| 1         | No       | Required when editing           |
| name            | Category name     | any text             | Study List | No       | Required for new categories; optional when editing |
| order           | Sort order        | integer              | 1         | No       | Position in the list            |
| hidden          | Hide category     | true or false        | false     | No       | tasks=archive; shop=shop hide; synthesis=hide. قوائم الإنجازات وقائمة synthesis ALL ترفض مع `unsupported_parameter`. `false` يُظهر |
| inventory_hidden| Hide in inventory | true or false        | false     | No       | Only supported for shop lists   |
| icon_uri        | Icon URI          | emoji, http(s) URL, content URI, or empty | 🏆 | No | Only supported for achievement lists. Emoji stored as `emoji_*.webp`. Empty clears. |
| desc            | Description       | any text             | This is a description | No | Only supported for achievement lists |
| color           | Tag color         | color string         | #66CCFF   | No       | Only supported for task lists; # must be escaped as %23 |

**Response:**

| Field | Type    | Description    | Example | Notes                    |
| ----- | ------- | -------------- | ------- | ------------------------ |
| id    | Number  | Category ID    | 1000    | ID of new or edited category |

<br/>

### تصدير النسخة الاحتياطية

?> يتطلب v1.98.0+

**اسم الدالة:** export_backup

**الوصف:** إنشاء ملف نسخة احتياطية وإرجاع URI الخاص به (استدعاءات Content Provider فقط)

!> يمكن استدعاء هذه الواجهة فقط عبر Content Provider؛ استدعاءات URL Scheme المباشرة غير مدعومة

| Parameter      | Meaning        | Values          | Example | Required | Notes                                         |
| ------------- | -------------- | --------------- | ------- | -------- | --------------------------------------------- |
| withMedia     | Include media files | true or false | true    | No       | Whether to include media files (images, sound effects, etc.) in backup<br/>Defaults to true |
| callingPackage| Caller package name | any text      | com.example.app | No | Package identifier for Content Provider calls |

**Response:**

| Field          | Type   | Description          | Example                                       |
| -------------- | ------ | -------------------- | --------------------------------------------- |
| backup_file_uri | Text   | Backup file URI      | content://net.sarasarasa.lifeup.api/backup/file.zip |

<br/>

### عمليات المهام الفرعية

?> يتطلب v1.98.0+

**اسم الدالة:** subtask_operation

**الوصف:** إكمال مهام فرعية أو التراجع عن الإكمال أو حذفها

**أمثلة:**

- إكمال مهمة فرعية: [lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=complete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=complete)
- حذف مهمة فرعية: [lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=delete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=delete)
- التراجع عن إكمال مهمة فرعية: [lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=undo_complete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=undo_complete)

| Parameter     | Meaning          | Values               | Example    | Required | Notes                          |
| ------------ | ---------------- | ------------------- | ---------- | -------- | ------------------------------ |
| main_id      | Main task ID     | number greater than 0| 1         | No*      | One of main_id, main_gid, or main_name required |
| main_gid     | Main task group ID| number greater than 0| 1        | No*      | One of main_id, main_gid, or main_name required |
| main_name    | Main task name   | any text            | Study task | No*      | One of main_id, main_gid, or main_name required |
| edit_id      | Subtask ID       | number greater than 0| 2         | No*      | One of edit_id, edit_gid, or edit_name required |
| edit_gid     | Subtask group ID | number greater than 0| 2         | No*      | One of edit_id, edit_gid, or edit_name required |
| edit_name    | Subtask name     | any text            | Do homework| No*      | One of edit_id, edit_gid, or edit_name required |
| operation    | Operation type   | One of the following:<br/>complete<br/>undo_complete<br/>delete | complete | Yes | complete - إكمال المهمة<br/>undo_complete - التراجع عن الإكمال<br/>delete - حذف المهمة |

**Response:**

| Field        | Type    | Description      | Example | Notes            |
| ------------ | ------- | ---------------- | ------- | ---------------- |
| main_task_id | Number  | Main task ID     | 1       |                  |
| subtask_id   | Number  | Subtask ID       | 2       |                  |
| subtask_gid  | Number  | Subtask group ID | 3       | May be empty     |

<br/>

### إدارة الإنجازات

?> يتطلب v1.98.0+

**اسم الدالة:** achievement

**الوصف:** إضافة إنجازات مخصصة وفئات فرعية للإنجازات أو تعديلها

**أمثلة:**

- إنشاء إنجاز: [lifeup://api/achievement?name=Collector&desc=Collect 100 items&category_id=1](lifeup://api/achievement?name=Collector&desc=Collect 100 items&category_id=1)
  - قد تحتاج إلى استبدال `category_id` بمعرّف قائمة الإنجازات المتاحة لديك لاختبار هذا المثال
- إنشاء إنجاز مع شروط فتح: [lifeup://api/achievement?name=Millionaire&conditions_json=%5B%7B%22type%22%3A7%2C%22target%22%3A1000000%7D%5D&category_id=1](lifeup://api/achievement?name=Millionaire&conditions_json=%5B%7B%22type%22%3A7%2C%22target%22%3A1000000%7D%5D&category_id=1)
  - قد تحتاج إلى استبدال `category_id` بمعرّف قائمة الإنجازات المتاحة لديك لاختبار هذا المثال
  - المحتوى المفكوك لـ `conditions_json` هو `[{"type":7,"target":1000000}]`
- تعديل إنجاز موجود: [lifeup://api/achievement?edit_id=1&name=New Achievement Name&exp=100](lifeup://api/achievement?edit_id=1&name=New Achievement Name&exp=100)

#### 1. معاملات الإنجاز

| Parameter      | Meaning           | Values               | Example   | Required | Notes                           |
| ------------- | ----------------- | -------------------- | --------- | -------- | ------------------------------- |
| edit_id       | Achievement ID to edit | number greater than 0 | 1      | No       | Required when editing          |
| is_subcategory| Is subcategory    | true or false        | false     | No       | Defaults to false               |
| name          | Achievement name   | any text             | Collector | No*      | Required for new achievements   |
| desc          | Description       | any text             | Collect 100 items | No |                               |
| icon_uri      | Icon              | emoji, http(s) URL, content URI, or empty | 🏆 | No | Not `icon`. Emoji is stored as an `emoji_` file. Empty clears. |
| order         | Sort order        | integer              | 1         | No       | Position in list                |
| category_id   | Category ID       | number greater than 0 | 1        | No*      | Required when creating subcategory |
| unlocked      | Unlock status     | true or false        | true      | No       | true - فتح فوري<br/>false - إعادة إلى مقفل |
| unlock_time   | Unlock time       | timestamp (milliseconds) | 1640995200000 | No | Only effective when already unlocked |
| delete        | Delete flag       | true or false        | false     | No       |                                |
| secret        | Hidden achievement| true or false        | false     | No       |                                |
| write_feeling | Record feelings   | true or false        | false     | No       |                                |
| color         | Title color       | color string         | #66CCFF   | No       | # must be escaped as %23        |
| auto_use_item | Auto use item     | true or false        | false     | No       |                                |
| skills        | Skill IDs         | array of numbers greater than 0 | 1 | No    | Supports arrays (e.g., &skills=1&skills=2) |
| exp           | Experience reward | integer              | 100       | No       |                                |
| item_id       | Item ID           | number greater than 0 | 1        | No*      | One of item_id or item_name required |
| item_name     | Item name         | any text             | Treasure  | No*      | One of item_id or item_name required |
| item_amount   | Item quantity     | [1, 99]             | 1         | No       | Defaults to 1                   |
| items         | Item rewards JSON | JSON text            | [{"item_id":1,"amount":2}] | No | Set multiple item rewards, see format below |
| conditions_json| Unlock conditions JSON | JSON text      | [{"type":7,"target":1000000}] | No | Set unlock conditions, see format below |
| coin         | Coin reward       | [0, 999999]      | 10         | No       | Amount of coins earned when unlocking the achievement |
| coin_var     | Coin reward variation | integer              | 5          | No       | Variation range for coin rewards |
| coin_set_type| How to set coin value | One of:<br/>absolute<br/>relative | absolute | No | absolute - ضبط العملات مباشرة على القيمة<br/>relative - إضافة/طرح من قيمة العملات الأصلية |
| exp_set_type | How to set exp value | One of:<br/>absolute<br/>relative | absolute | No | absolute - ضبط نقاط الخبرة مباشرة على القيمة<br/>relative - إضافة/طرح من قيمة نقاط الخبرة الأصلية |

**Response:**

| Field  | Type    | Description      | Example | Notes                    |
| ------ | ------- | ---------------- | ------- | ------------------------ |
| id     | Number  | Achievement ID   | 1000    | ID of new or edited achievement |

#### 2. معاملات الفئة الفرعية

| Parameter     | Meaning           | Values               | Example   | Required | Notes                           |
| ------------ | ----------------- | -------------------- | --------- | -------- | ------------------------------- |
| is_collapsed | Collapse status   | true or false        | false     | No       | Only applies to subcategories   |

الفئات الفرعية ترفض `icon_uri` (بما في ذلك emoji) مع `unsupported_parameter`. تعديل فئة فرعية بدون `is_subcategory=true` يُرجع `is_subcategory_required`.
**Response:**

| Field  | Type    | Description      | Example | Notes                    |
| ------ | ------- | ---------------- | ------- | ------------------------ |
| id     | Number  | Achievement ID   | 1000    | ID of new or edited achievement (subcategory) |

#### 3. أنواع شروط الفتح

| Type Code | Description             | Requires related_id | related_id Type | target Description  |
| --------- | ----------------------- | ------------------ | --------------- | ------------------ |
| 0         | Task completion count   | Yes                | Task ID         | Number of completions |
| 1         | Task completion streak  | Yes                | Task ID         | Streak count       |
| 3         | Pomodoro count         | No                 | -               | Number of pomodoros |
| 4         | Days using LifeUp      | No                 | -               | Number of days     |
| 5         | Like count             | No                 | -               | Number of likes    |
| 6         | Daily completion streak | No                 | -               | Streak days        |
| 7         | Current coins          | No                 | -               | Amount of coins    |
| 8         | Coins earned in one day| No                 | -               | Amount of coins    |
| 9         | Task pomodoro count    | Yes                | Task ID         | Number of pomodoros |
| 10        | Item purchase count    | Yes                | Item ID         | Purchase count     |
| 11        | Item usage count       | Yes                | Item ID         | Usage count        |
| 12        | Loot box item count    | Yes                | Item ID         | Obtained count     |
| 13        | Skill level reached    | Yes                | Skill ID        | Level value        |
| 14        | Life level            | No                 | -               | Level value        |
| 15        | Total items obtained   | Yes                | Item ID         | Total obtain count |
| 16        | Items from synthesis   | Yes                | Item ID         | Synthesis count    |
| 17        | Current item quantity  | Yes                | Item ID         | Own count          |
| 18        | Task focus duration    | Yes                | Task ID         | Duration (minutes) |
| 19        | ATM savings           | No                 | -               | Savings amount     |
| 20        | External API          | No                 | -               | API defined        |
| 520       | Complete N distinct tasks daily | No         | -               | Distinct task count (deduplicated by group ID; existing type) |
| 524       | Complete N task completions daily | No       | -               | Total valid completion count in a day (v1.104.4+) |

> اعتباراً من v1.104.4، يستخدم النوعان `520` و `524` الدلالات التالية:
>
> - يتشاركان نفس تعريف الإكمال وحدود اليوم التقويمي المحلي (`TimeRange.today()`).
> - المهام العادية تُحسب `COMPLETED`؛ المهام السلبية تُحسب `GIVE_UP`.
> - النوع `520` يُزيل التكرار حسب `groupId` الفعلي (يرجع إلى task record id عند غياب group id). إكمال نفس المهمة غير المحدودة عدة مرات في يوم واحد ما زال يُحسب كمهمة مميزة واحدة.
> - النوع `524` يعدّ كل صف إكمال صالح. إكمال نفس المهمة غير المحدودة 5 مرات يُنتج `completionCount = 5`.
> - الإنجازات الموجودة مع `type=520` تحتفظ بدلالات المهام المميزة؛ لا حاجة للترحيل.

#### 4. مواصفات تنسيق JSON

##### شروط الفتح (conditions_json)

```json
[
    {
        "type": 7,           // Condition type (refer to table above)
        "related_id": null,  // Related ID (required for some types)
        "target": 1000000    // Target value
    },
    {
        "type": 10,          // Example: Purchase specific item
        "related_id": 1,     // Item ID
        "target": 5          // Purchase 5 times
    },
    {
        "type": 520,         // Complete N distinct tasks daily
        "related_id": null,
        "target": 5
    },
    {
        "type": 524,         // Complete N task completions daily
        "related_id": null,
        "target": 10
    }
]
```

##### مكافآت العناصر (items)

```json
[
    {
        "item_id": 1,    // Item ID
        "amount": 2      // Quantity
    },
    {
        "item_id": 2,
        "amount": 3
    }
]
```

<br/>

### إدارة المهارات

?> يتطلب v1.98.0+

**اسم الدالة:** skill

**الوصف:** إنشاء مهارات مخصصة (سمات) أو تعديلها

**أمثلة:**

- إنشاء مهارة: [lifeup://api/skill?content=Programming&desc=Coding ability&color=%23FF6B6B](lifeup://api/skill?content=Programming&desc=Coding ability&color=%23FF6B6B)
- تعديل خبرة المهارة: [lifeup://api/skill?id=1&exp=100](lifeup://api/skill?id=1&exp=100)
- حذف مهارة: [lifeup://api/skill?id=1&delete=true](lifeup://api/skill?id=1&delete=true)

| Parameter    | Meaning           | Values               | Example    | Required | Notes                           |
| ----------- | ----------------- | -------------------- | ---------- | -------- | ------------------------------- |
| id          | Skill ID          | number greater than 0 | 1         | No       | Required when editing           |
| content     | Skill name        | any text             | Programming| No*      | Required for new skills         |
| desc        | Description       | any text             | Coding ability | No    |                                |
| icon        | Icon              | any text             | 💻         | No       | Can use emoji                   |
| color       | Color             | color string         | #FF6B6B    | No       | # must be escaped as %23        |
| type        | Type              | integer              | 0          | No       |                                |
| order       | Sort order        | integer              | 1          | No       | Raw mixed-list position. When used alone, the skill is placed at that position and the final group is inferred from layout; when used with `group_id`, it is snapped to the nearest legal position inside the target group |
| group_id    | Skill group ID    | integer              | 10         | No       | Requires v1.103.0+; it cannot be less than `0`, and only `0` moves the skill to the ungrouped area. When used alone, new skills are appended to the target group tail, while edited skills keep their current position if already in that group, otherwise they move to the group tail; when used with `order`, `group_id` takes priority |
| status      | Status            | integer              | 0          | No       |                                |
| exp         | Experience points | number greater than or equal to 0 | 100 | No | Current skill experience        |
| delete      | Delete flag       | true or false        | false      | No       | Only valid when editing         |

**Response:**

| Field  | Type    | Description    | Example | Notes                    |
| ------ | ------- | -------------- | ------- | ------------------------ |
| id     | Number  | Skill ID       | 1000    | ID of new or edited skill |

<br/>

### Skill Group Management :id=skill_group_management

يتطلب v1.103.0+

**اسم الدالة:** skill_group

**الوصف:** إنشاء مجموعات مهارات أو تعديلها أو حذفها أو إعادة ترتيبها. تدعم واجهة الفرز أيضاً الترتيب المختلط للمجموعات والمهارات.

**أمثلة:**

- إنشاء مجموعة: [lifeup://api/skill_group?content=Combat](lifeup://api/skill_group?content=Combat)
- تعديل مجموعة: [lifeup://api/skill_group?id=10&content=Combat&order=20&collapsed=true](lifeup://api/skill_group?id=10&content=Combat&order=20&collapsed=true)
- حذف مجموعة: [lifeup://api/skill_group?id=10&delete=true](lifeup://api/skill_group?id=10&delete=true)
- فرز المجموعات والمهارات معاً:

```text
lifeup://api/skill_group?sort_json=[{"type":"skill","id":2},{"type":"group","id":10},{"type":"skill","id":3}]
```

| Parameter | Meaning | Values | Example | Required | Notes |
| --------- | ------- | ------ | ------- | -------- | ----- |
| id | Skill group ID | number greater than 0 | 10 | No* | Required when editing or deleting |
| content | Group name | any text | Combat | No* | Required when creating |
| order | Sort order | integer | 20 | No | Raw `orderInCategory` value; it must be unique in the mixed skill/group list |
| collapsed | Collapse state | true or false | true | No | Whether the group is collapsed |
| delete | Delete flag | true or false | false | No | Only valid when editing |
| sort_json | Mixed sort nodes | JSON array | `[{"type":"skill","id":2},{"type":"group","id":10}]` | No* | When provided, CRUD parameters are ignored and the mixed sort plan is applied. Partial sorting is supported: unspecified nodes keep their relative order |

تنسيق عقدة `sort_json`:

| Field | Meaning | Values |
| ----- | ------- | ------ |
| type | Node type | `skill` / `group` |
| id | Entity ID | number greater than 0 |

**Response:**

| Field | Type | Description | Example | Notes |
| ----- | ---- | ----------- | ------- | ----- |
| id | Number | Skill group ID | 10 | Returned for create / edit / delete |
| count | Number | Number of sorted nodes | 3 | Returned for `sort_json` requests |

<br/>

### إعدادات التطبيق

?> يتطلب v1.98.0+

**اسم الدالة:** app_settings

**الوصف:** ضبط إعدادات واجهة التطبيق

**أمثلة:**

- تفعيل الوضع المدمج: [lifeup://api/app_settings?is_enable_compact_mode=true](lifeup://api/app_settings?is_enable_compact_mode=true)
- تفعيل سمة Material You: [lifeup://api/app_settings?is_enable_material_you=true](lifeup://api/app_settings?is_enable_material_you=true)
- تغيير الإعدادات وإعادة تشغيل الواجهة فوراً: [lifeup://api/app_settings?is_enable_compact_mode=true&restart_activities=true](lifeup://api/app_settings?is_enable_compact_mode=true&restart_activities=true)

| Parameter              | Meaning           | Values          | Example | Required | Notes                           |
| --------------------- | ----------------- | --------------- | ------- | -------- | ------------------------------- |
| is_enable_compact_mode| Enable compact mode| true or false  | true    | No       | تبسيط عناصر الواجهة     |
| is_enable_material_you| Enable Material You| true or false  | true    | No       | تفعيل سمة Material You       |
| restart_activities    | Restart interface | true or false   | true    | No       | تطبيق تغييرات الواجهة فوراً |
| broadcast_event | LifeUp Labs broadcast events | true or false | true | No | مغلق افتراضياً. نفس المفتاح في Settings → Labs |

**Response:**

| Field  | Type    | Description  | Example | Notes                    |
| ------ | ------- | ------------ | ------- | ------------------------ |
| result | Integer | Result code  | 0       | 0 يعني النجاح      |

<br/>

### استعلام بسيط

!> الوظائف هنا مخصصة لأدوات الأتمتة والتطوير الثانوي. إذا احتجت استعلام قائمة بيانات كاملة، راجع [`LifeUp SDK`, `LifeUp Cloud`](https://github.com/Ayagikei/LifeUp-SDK) و[`LifeUp Desktop`.](https://github.com/Ayagikei/LifeUp-Desktop)

**اسم الدالة:** query

**الوصف:** معاملات الاستعلام

**Example:** - استعلام عدد العملات الحالي: [lifeup://api/query?key=coin](lifeup://api/query?key=coin)
- استعلام مفتاح أحداث البث: [lifeup://api/query?key=broadcast](lifeup://api/query?key=broadcast) → `{enabled}`

| Parameter   | Meaning              | Type                                                         | Example | Required                                    | Notes                                                        |
| ----------- | -------------------- | ------------------------------------------------------------ | ------- | ------------------------------------------- | ------------------------------------------------------------ |
| key         | type of query        | Only one of the following values:<br/>coin<br/>atm<br/>item<br/>item_id_list<br/>tomato<br/>task<br/>broadcast | coin    | yes                                         | coin - عدد العملات الحالي<br/>atm - رصيد الصراف الآلي الحالي<br/>item - معلومات العنصر للـ `itemId` المحدد<br/>item_id_list - قائمة معرّفات العناصر حسب `categoryId`<br/>tomato - بيانات الطماطم<br/>task - معلومات المهمة (v1.101.0+)<br/>broadcast - مفتاح أحداث بث Labs (`{enabled}`) |
| item_id     | the id of the item   | a number greater than 0                                      | 1       | When the key is `item`, it must be provided |                                                              |
| category_id | the Shop category id | Number greater than or equal to 0                            | 0       | no*                                         | مطلوب فقط عندما يكون key هو `item_id_list`، ويمثل معرّف القائمة المراد استعلامها. |
| task_id / taskId | Task ID          | Number greater than 0                                        | 1       | When key is `task`, one of three* is required | معرّف المهمة المستعلَم عنها |
| task_gid / taskGid / task_group_id / taskGroupId | Task group ID | Number greater than 0 | 1 | When key is `task`, one of three* is required | معرّف مجموعة المهام المستعلَم عنها |
| task_name / taskName | Task name      | Any text                                                     | Study   | When key is `task`, one of three* is required | اسم المهمة (مطابقة تقريبية) |
| withSubTasks | Include sub-tasks   | true or false                                                | true    | No                                          | متاح فقط عندما يكون key هو `task`؛ الافتراضي true |

**Return Value:**

مدعوم منذ الإصدار 1.90.2 فقط

عند استعلام coin/atm:

| Parameter | Meaning                             | Type               | Example | Required | Notes |
| --------- | ----------------------------------- | ------------------ | ------- | -------- | ----- |
| value     | Numeric value returned by the query | number             | 1000    | yes      |       |

عند استعلام item:

| Parameter        | Meaning                         | Type     | Example   | Required | Notes |
| ---------------- | ------------------------------- | -------- | --------- | -------- | ----- |
| item_id          | the id of the item              | number   | 1         | yes      |       |
| name             | the name of the item            | any text | Coffee    | yes      |       |
| desc             | description                     | any text |           | no       |       |
| icon             | icon URL                        | any text | icon.webp | no       | إذا كان ملفاً محلياً، يُعاد اسم الملف فقط |
| category_id      | category data id                | number   | 1         | yes      |       |
| stock_number     | shop stock quantity             | number   | -1        | yes      | `-1` يعني مخزوناً غير محدود في المتجر |
| own_number       | the own number in the Inventory | number   | 10        | yes      |       |
| price            | the price                       | number   | 100       | yes      |       |
| order            | sort by                         | number   | 100       | yes      | قيمة الوزن عند الفرز المخصص |
| disable_purchase | Whether to disable purchase     | true or false | true | yes |       |
| purchase_limit   | Restriction rules               | JSON text | [{"limitType":0,"limitNumber":5}] | yes | قائمة القيود الحالية |
| limit_scope      | Restriction scope               | purchase / use / both | use | yes | يُعاد كقيمة نصية API |

عند استعلام item_id_list:

| Parameter | Meaning                           | Type   | Example | Required | Notes |
| --------- | --------------------------------- | ------ | ------- | -------- | ----- |
| item_ids  | Comma-separated item ID array     | string | 1,2,3,4 | yes      |       |

عند استعلام tomato:

| Parameter | Meaning                  | Type   | Example | Required | Notes |
| --------- | ------------------------ | ------ | ------- | -------- | ----- |
| total     | Total tomato count       | number | 100     | yes      |       |
| available | Available tomato count   | number | 50      | yes      |       |
| exchanged | Exchanged tomato count   | number | 50      | yes      |       |

عند استعلام task (v1.101.0+):

| Parameter   | Meaning                      | Type        | Example | Required | Notes                           |
| ----------- | ---------------------------- | ----------- | ------- | -------- | ------------------------------- |
| _ID         | Task ID                      | number      | 1       | yes      | -                               |
| _GID        | Task group ID                | number      | 1       | yes      | -                               |
| name        | Task name                    | text        | Study   | yes      | -                               |
| notes       | Notes                        | text        | -       | no       | قد يكون فارغاً                    |
| status      | Task status                  | number      | 0       | yes      | 0=غير مكتمل، 1=مكتمل       |
| startTime   | Start time                   | number      | -       | yes      | Unix timestamp (milliseconds)   |
| deadline    | Deadline time                | number      | -       | no       | Unix timestamp (milliseconds)، قد يكون فارغاً |
| remindTime  | Remind time                  | number      | -       | no       | Unix timestamp (milliseconds)، قد يكون فارغاً |
| frequency   | Repetition frequency         | number      | -       | yes      | -                               |
| weekdays    | Weekdays                     | text        | 1,3,5   | no       | v1.106.0+؛ فارغ عند عدم استخدام وضع أيام الأسبوع. 1=الاثنين … 7=الأحد |
| exp         | EXP reward                   | number      | -       | yes      | -                               |
| skillIds    | Skill ID list                | JSON text   | -       | yes      | JSON array format               |
| coin        | Coin reward                  | number      | -       | no       | قد يكون فارغاً                    |
| coinVariable| Random coin reward           | number      | -       | no       | قد يكون فارغاً                    |
| itemId      | First reward item ID         | number      | -       | no       | قد يكون فارغاً                    |
| itemCount   | First reward item count      | number      | -       | no       | يُعاد عند وجود itemId     |
| items       | Item reward list             | JSON text   | -       | yes      | JSON array format               |
| words       | Completion incentive words   | text        | -       | no       | قد يكون فارغاً                    |
| categoryId  | Category ID                  | number      | -       | no       | قد يكون فارغاً                    |
| order       | Order                        | number      | -       | yes      | -                               |
| name_extended | Extended name              | text        | -       | yes      | Same as name                    |
| subTasks    | Sub-task list                | JSON text   | -       | yes      | JSON array format, see below    |

**وصف حقل المهام الفرعية (subTasks):**

حقل `subTasks` هو مصفوفة JSON، وكل عنصر يحتوي الحقول التالية:

- `id`: معرّف المهمة الفرعية
- `gid`: معرّف مجموعة المهمة الفرعية
- `todo`: محتوى المهمة الفرعية
- `status`: حالة المهمة الفرعية (0=غير مكتمل، 1=مكتمل)
- `remindTime`: وقت التذكير (Unix timestamp، milliseconds)
- `exp`: مكافأة نقاط الخبرة
- `coin`: مكافأة العملات
- `coinVariable`: مكافأة عملات عشوائية
- `items`: قائمة مكافآت العناصر
- `order`: الترتيب
- `autoUseItem`: ما إذا كان سيتم استخدام العنصر تلقائياً

<br/>

### استعلام السمات :id=query_skill

!> الوظائف هنا مخصصة لأدوات الأتمتة والتطوير الثانوي.

**اسم الدالة:** query_skill

**الوصف:** استعلام المعلومات الأساسية، حقول الفرز الخام، وبيانات المستوى/نقاط الخبرة لمهارة (سمة) محددة.

يمكن استخدام هذه الواجهة لتخصيص ويدجت السمات.

**Example:**

- استعلام سمة القوة: [lifeup://api/query_skill?id=1](lifeup://api/query_skill?id=1)

| Parameter | Meaning              | Type                    | Example | Required | Notes |
| --------- | -------------------- | ----------------------- | ------- | -------- | ----- |
| id        | attribute (skill) id | a number greater than 0 | 1       | yes      | لطريقة الحصول، راجع «Basic Knowledge - Person Level Data ID» أعلاه |

**Return Value:**

مدعوم منذ الإصدار 1.90.6

| Parameter            | Meaning                              | Type   | Example  | Required | Notes |
| -------------------  | ------------------------------------ | ------ | -------- | -------- | ----- |
| id                   | skill id                             | number | 1        | yes      | أُضيف إلى `query_skill` في v1.103.0+ |
| name                 | attribute name                       | string | strength | yes      |       |
| order                | raw sort order                       | number | 20       | yes      | أُضيف في v1.103.0+؛ `orderInCategory` |
| group_id             | skill group ID                       | number | 10       | yes      | أُضيف في v1.103.0+؛ يُعاد `0` عندما لا تكون المهارة ضمن مجموعة |
| status               | status                               | number | 0        | yes      | أُضيف في v1.103.0+؛ `0` = عادي، `1` = مخفي |
| level                | level                                | number | 10       | yes      |       |
| total_exp            | total experience points              | number | 10000    | yes      |       |
| until_next_level_exp | EXP required to reach the next level | number | 99       | yes      |       |
| current_level_exp    | Earned EXP above current level       | Number | 1000     | Yes      |       |

<br/>

### استعلام مجموعة المهارات :id=query_skill_group

يتطلب v1.103.0+

**اسم الدالة:** query_skill_group

**الوصف:** استعلام مجموعة مهارات واحدة وإرجاع الفرز الخام وحالة الطي.

**Example:**

- استعلام مجموعة مهارات: [lifeup://api/query_skill_group?id=10](lifeup://api/query_skill_group?id=10)

| Parameter | Meaning | Type | Example | Required | Notes |
| --------- | ------- | ---- | ------- | -------- | ----- |
| id | Skill group ID | number greater than 0 | 10 | yes | - |

**Return Value:**

| Parameter | Meaning | Type | Example | Required | Notes |
| --------- | ------- | ---- | ------- | -------- | ----- |
| id | Skill group ID | number | 10 | yes | - |
| content | Group name | string | Combat | yes | - |
| order | Raw sort order | number | 20 | yes | `orderInCategory` |
| collapsed | Collapse state | string | true | yes | يُعاد كنص `true` / `false` |

<br/>

<br/>

### واجهة خاصة

#### Random

?> أُطلقت هذه الواجهة في v1.93.0.

**اسم الدالة:** random

**الوصف:** واجهة عشوائية بسيطة يمكنها تشغيل واحدة من عدة واجهات API عشوائياً.

**Example:**

- عرض `scissors` أو `rock` أو `paper` باحتمال متساوٍ: [lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper](lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper)

- احتمال 90% لـ `rock`، 5% لـ `scissors`، 5% لـ `paper`: [lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper&weight=90&weight=5&weight=5](lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper&weight=90&weight=5&weight=5)

| Parameter | Meaning    | Values                 | Example                                | Required | Notes |
| --------- | ---------- | ---------------------- | -------------------------------------- | -------- | ----- |
| api       | Random API | Any text               | lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock | Yes      | يدعم الاستدعاء بصيغة مصفوفة (أي عدة معاملات api، كما في الأمثلة أعلاه) |
| weight    | Weight     | Numbers greater than 0 | 1                                      | No       | يدعم الاستدعاء بصيغة مصفوفة.<br/><br/>إذا لم يُحدَّد weight، تكون جميع الأوزان متساوية (احتمال متساوٍ).<br/>إذا حُدِّدت أوزان، تُخصَّص بالتتابع: مثلاً الوزن الأول يقابل معامل api الأول.<br/><br/>**تأكد من تطابق عدد معاملات weight مع عدد معاملات api، وإلا قد لا يسري.** |

<br/>

#### Confirm Dialog

**اسم الدالة:** confirm_dialog

**الوصف:** تظهر نافذة اختيار منبثقة. يمكنك تخصيص العنوان والنص وزر التأكيد وزر الإلغاء. يمكن أيضاً استدعاء واجهات أخرى عند النقر على الأزرار.

**Example:**

- [<a href="lifeup://api/confirm_dialog?title=Do you believe in love&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dbelieve&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Ddo not believe">lifeup://api/confirm_dialog?title=Do you believe in love&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dbelieve&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Ddo not believe</a>](lifeup://api/confirm_dialog?title=Do you believe in love&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dbelieve&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Ddo not believe)
- سيناريوهات استخدام أخرى:
  - اختيار المكافآت
  - اختيار فرع الحدث

| Parameter       | Meaning              | Type     | Example  | Required | Notes |
| --------------- | -------------------- | -------- | -------- | -------- | ----- |
| title           | popup title          | any text | Title    | yes      |       |
| message         | detailed description of the popup window | any text | This is the content of the popup window | no |  |
| positive_text   | positive button text | any text | YES      | no       |       |
| negative_text   | negative button text | any text | NO       | no       |       |
| neutral_text    | neutral button text  | any text | QUESTION | no       |       |
| positive_action | the link response of the positive button | URL (other interface) | lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D You clicked OK | no | في الواقع هو النص المُهرَّب لواجهة الرسالة المنبثقة. لقواعد الهروب، راجع `Basic Knowledge - Escape`. |
| negative_action | the link response of the negative button | URL (other interface) | Same as above | no |  |
| neutral_action  | the link response of the neutral button  | URL (other interface) | Same as above | no |  |
| cancel_action   | the link response of the cancel action   | URL (other interface) | Same as above | no |  |

<br/>

#### No Action

**اسم الدالة:** placeholder

**Note:** هذه الواجهة لا تنفّذ أي منطق بحد ذاتها، لكن يمكن استخدامها مع callback و broadcast.

**Example:**

- [lifeup://api/placeholder?broadcast=app.lifeup.item.rest](lifeup://api/placeholder?broadcast=app.lifeup.item.rest)

<br/>

#### Variable Placeholder

يوفر `LifeUp` طرق معالجة تدخل المستخدم للمعاملات.

| Placeholder                          | Meaning                                                      | Example                                                      |
|--------------------------------------|--------------------------------------------------------------|--------------------------------------------------------------|
| [$text\|title]                       | Text placeholder                                             | [$text\|Enter task name]                                     |
| [$number\|Title]                     | Number placeholder (without decimal point)                   | [$number\|Enter price]                                       |
| [$number\|Title\|signed]             | Number placeholder (without decimal point), show sign        | [$number\|Enter price\|signed]                               |
| [$decimal\|title]                    | Number placeholder (with decimal point)                      | [$decimal\|Enter ATM rate]                                   |
| [$decimal\|title\|signed]            | Number placeholder (with decimal point), show sign           | [$decimal\|Enter ATM rate\|signed]                           |
| [$item]                              | Select an item, it will be replaced with item id              | [$item]                                                      |
| [$task_category]                     | Select task list, which will be replaced with task list id    | [$task_category]                                             |
| [$time\|Anchor Time\|Offset in Milliseconds(optional)] | Time Placeholder<br/><br/>Possible values for Anchor Time:<br/>`current`, `today`, `this_monday`, `last_monday`, `this_month`, `last_month`, `this_year`, `last_year` <br/><br/>Offset in milliseconds should be an integer, default is 0 milliseconds | Midnight today: [$time\|today]<br/>Midnight tomorrow: [$time\|today\|86400000] |
| [$random_number\|Min\|Max]           | Random number placeholder (without decimal point)             | [$random_number\|0\|3000]                                    |
| [$random_decimal\|Min\|Max]          | Random number placeholder (with decimal point)                | [$random_decimal\|1.0\|2.0]                                  |

**مثال 1: عند الاستخدام، اختر عنصراً لتخفيض السعر بعملة واحدة**

مثلاً، بعد ضبط واجهة تخفيض سعر عنصر متجر محدد، قد ترغب في السماح للمستخدم باختيار العنصر عند الاستدعاء بدلاً من تحديد المعرّف مسبقاً.

الواجهة التالية تخفّض سعر عنصر المتجر ذي المعرّف 1 بعملة واحدة فقط:

````url
lifeup://api/item?id=1&set_price=-1&set_price_type=relative
````

يكفي تعديل معرّف العنصر إلى placeholder [$item]، وعند الاستدعاء يمكن للمستخدم اختيار العنصر الذي يريد تخفيض سعره:

<a href="lifeup://api/item?id=[$item]&set_price=-1&set_price_type=relative">lifeup://api/item?id=[$item]&set_price=-1&set_price_type=relative</a>

**مثال 2: قالب مهمة — أدخل اسم المهمة وقائمة الاختيار فقط لإنشاء قالب مكافأة مسبق**

<a href="lifeup://api/add_task?todo=[$text|Enter a task name]&notes=This is a reward template for a task&coin=10&coin_var=10&exp=2048&skills=1&skills=2&skills=3&category=[$task_category]]">lifeup://api/add_task?todo=[$text|Enter a task name]&notes=This is a reward template for a task&coin=10&coin_var=10&exp=2048&skills=1&skills=2&skills=3&category=[$task_category]]</a>

<br/>

#### End Callback

يمكنك إضافة معامل callback إلى جميع الواجهات لتنفيذ معالجة رد الاتصال بالـ URL بعد الاستدعاء.

يمكن استخدامه أيضاً لربط عدة واجهات، مثلاً إذا أردت عرض رسالة بعد الانتقال:

lifeup://api/goto?page=lab + lifeup://api/toast?text=callback

يمكنك استخدام معامل callback. راجع أيضاً **Basics - Escaping** أعلاه. يمكنك كتابة معالجة من هذا النوع:

<a href="lifeup://api/goto?page=lab&callback=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dtest callback">lifeup://api/goto?page=lab&callback=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dtest callback</a>

بالطبع يمكنك إضافة عدة روابط إلى عنصر متجر لتحقيق نفس التأثير.

إضافة إلى ذلك، يُستخدم callback أكثر في:

تطبيق X → LifeUp → تطبيق X

أو

تطبيق X → LifeUp → تطبيق Y

<br/>

#### Broadcast return value

!> الوظائف هنا مخصصة لأدوات الأتمتة والتطوير الثانوي، ولها عتبة معرفية معينة.

بإضافة هذا المعامل، يمكن أيضاً إرسال القيمة المُرجعة الأصلية للواجهة عبر البث، حتى تستقبلها أدوات الأتمتة مثل Tasker.

قيمة broadcast تعادل قيمة عمود العملية في «Intent Received» في Tasker. يمكنك إدخال أي نص طالما تطابق الطرفان.

**مثلاً، استخدام واجهة استعلام العملات مع Tasker ([إذا كنت تستخدم MacroDroid، راجع هذا الرابط.](https://github.com/Ayagikei/LifeUp/issues/43)):**

[lifeup://api/query?key=coin](lifeup://api/query?key=coin)

1. أضف معامل broadcast لتمكين بث القيمة المُرجعة إلى Tasker، ويمكن أن يكون أي نص، مثل `app.lifeup.query.coin`.

   [lifeup://api/query?key=coin&broadcast=app.lifeup.query.coin](lifeup://api/query?key=coin&broadcast=app.lifeup.query.coin)

2. أضف حدثاً في Tasker → «Intent Received»، واملأ `app.lifeup.query.coin` في عمود العملية

3. يمكن لمهمة Tasker بعد ذلك استقبال القيمة المُرجعة لـ `value` كمتغير `%value`.

4. ثم يمكنك الحكم على عدد العملات في Tasker لتحقيق تأثيرات متنوعة. (مثلاً تغيير خلفية سطح المكتب حسب عدد العملات؟)

![](_media/api/broadcast_01.png ':size=30%')

![](_media/api/broadcast_02.png ':size=30%')

![](_media/api/broadcast_03.png ':size=30%')

![](_media/api/broadcast_04.png ':size=30%')

<br/>

---

## إشعار أحداث البث

!> الوظائف هنا مخصصة لأدوات الأتمتة والتطوير الثانوي.

> في الإصدار 1.90.2، سنبث أحداثاً متنوعة إلى الخارج. يمكنك استخدام أدوات أتمتة مثل Tasker لاستقبال هذه الأحداث وتشغيل إجراءات Tasker.
>
### التفعيل

**أحداث البث مغلقة افتراضياً.**

يمكنك تفعيلها في `Settings` → `Labs` → `Developer mode` → `Broadcast events`.

### مثال: تغيير الخلفية بعنصر

1. أنشئ عنصراً جديداً باسم «Change Wallpaper».
2. في Tasker، انتقل إلى `Configuration file` → `Event` → `System` → `Intent Received`، أدخل `app.lifeup.item.use` في عمود العملية، ثم ارجع.
3. انقر New Task وأدخل أي اسم (مثلاً change wallpaper).
4. انقر + في الزاوية السفلية اليمنى لإضافة مهمة، واختر `Task` → `If`
5. اضبط عمود الشرط إلى `%name eq change wallpaper`.
6. ارجع، واختر `Insert Action` ثم `If`.
7. انقر + مرة أخرى في الزاوية السفلية اليمنى لإضافة مهمة، واختر `Display` → `Set Wallpaper`
8. (اختياري) غيّر `Type` إلى `All`
9. في عمود الصورة، انقر أيقونة 🔍 واختر ملف الخلفية المطلوب
10. اخرج وتحقق من تفعيل هذا الإعداد.
11. استخدم عنصر «Wallpaper Change» في `LifeUp`، ويُفترض أن ترى تغيير الخلفية بنجاح

![](_media/api/broadcast_sample_01.png ':size=30%')

![](_media/api/broadcast_sample_02.png ':size=30%')

![](_media/api/broadcast_sample_03.png ':size=30%')

![](_media/api/broadcast_sample_04.png ':size=30%')

يمكن تحقيق نفس التأثير بطريقة أكثر إيجازاً باستخدام `No Action` + `Broadcast return value`، جرّب ذلك.

<br/>

### اكتمال المهمة

**Name:** app.lifeup.task.complete

**Return value:**

| Parameters  | Meaning          | Examples        |
| ----------- | ---------------- | --------------- |
| task_id     | task id          | 1               |
| task_gid    | task group id    | 1               |
| name        | task name        | Getting started |
| category_id | task category id | 1               |

### التخلي عن المهمة

**Name:** app.lifeup.task.giveup

**Return value:**

| Parameters  | Meaning          | Examples        |
| ----------- | ---------------- | --------------- |
| task_id     | task id          | 1               |
| task_gid    | task group id    | 1               |
| name        | task name        | Getting started |
| category_id | task category id | 1               |

### تأخر المهمة

**Name:** app.lifeup.task.overdue

**Return value:**

| Parameters | Meaning                 | Examples                        |
| ---------- | ----------------------- | ------------------------------- |
| task_ids   | task id **array**       | [1, 2, 3]                       |
| task_gids  | task group id **array** | [1, 2, 3]                       |
| names      | task name **array**     | [Getting started, Drink Waters] |
| task_ids_json  | task id **Json array**   | [1, 2, 3]                       |
| task_gids_json | task group id **Json array** | [1, 2, 3]                       |
| names_json     | task name **Json array** | ["Getting started", "Drink Waters"]                      |

### فتح إنجاز

**Name:** app.lifeup.achievement.unlock

**Return value:**

| Parameters     | Meaning          | Examples                 |
| -------------- | ---------------- | ------------------------ |
| achievement_id | achievement id   | 1                        |
| name           | achievement name | Using LifeUp for 30 days |

### شراء عناصر

**Name:** app.lifeup.item.purchase

**Return value:**

| Parameters | Meaning           | Examples          |
| ---------- | ----------------- | ----------------- |
| item_id    | item id           | 1                 |
| name       | item name         | Break 10 branches |
| amount     | purchase quantity | 1                 |

### استخدام عنصر

**Name:** app.lifeup.item.use

**Description:** يُرسل عند نجاح استخدام عنصر عادي أو تدفق تركيب بسيط.

**Return value:**

| Parameters | Meaning      | Examples          |
| ---------- | ------------ | ----------------- |
| item_id    | item id      | 1                 |
| name       | item name    | Break 10 branches |
| amount     | use quantity | 1                 |

### اكتمال التركيب

> [!NOTE]
> أُطلق حدث البث هذا في v1.102.8.

**Name:** app.lifeup.synthesis.complete

**Description:** يُرسل عند اكتمال تركيب وصفة بنجاح.

**Return value:**

| Parameters   | Meaning                            | Examples                                              |
| ------------ | ---------------------------------- | ----------------------------------------------------- |
| formula_id   | formula id                         | 1                                                     |
| formula_name | formula name                       | Toolbox Recipe                                        |
| times        | execution times                    | 3                                                     |
| input_count  | number of input item entries       | 2                                                     |
| output_count | number of output item entries      | 1                                                     |
| inputs_json  | JSON array of all consumed inputs  | [{"item_id":7,"name":"Wood","amount":6}]              |
| outputs_json | JSON array of all produced outputs | [{"item_id":9,"name":"Toolbox","amount":3}]           |

**Notes:**

- يُرسل هذا الحدث فقط بعد نجاح التركيب.
- إذا كانت المواد غير كافية، أو الوصفة غير موجودة، أو فشل الحفظ، أو كان `Broadcast events` معطّلاً، لا يُرسل هذا الحدث.
- استدعاء API واحد يُرسل حدثاً واحداً فقط حتى لو كان `times > 1`.
- في `inputs_json` و `outputs_json`، يستخدم كل عنصر البنية التالية:

```json
{
  "item_id": 7,
  "name": "Wood",
  "amount": 6
}
```

- `amount` هو **إجمالي المستهلك / إجمالي المُنتَج** في هذا التنفيذ، وليس الكمية لكل وصفة.

### إضافة / تحديث المشاعر

**Name:** app.lifeup.feelings.add

**Return value:**

| Parameters | Meaning | Examples |
| --- | --- | --- |
| feelings_id | feeling id | 1 |
| action_type | `add` or `update` | add |
| content | feeling text | Feeling good today! |
| create_time | created-at timestamp (ms) | 1642060800000 |
| relate_type | related object type | 0 |
| related_id | related object id | 1 |
| attachments_count | attachment count | 2 |
| attachments | attachment path array | ["/path/1", "/path/2"] |

### رفع المستوى

**Name:** app.lifeup.level.up

**Return value:**

| Parameters | Meaning       | Examples |
| ---------- | ------------- | -------- |
| skill_id   | task id       | 1        |
| name       | name          | strength |
| level      | current level | 2        |

### خفض المستوى

**Name:** app.lifeup.level.down

**Return value:**

| Parameters | Meaning       | Examples |
| ---------- | ------------- | -------- |
| skill_id   | task id       | 1        |
| name       | name          | strength |
| level      | current level | 2        |

### العد التنازلي لعنصر المتجر

**Name:**

- Start: app.lifeup.item.countdown.start
- Stop: app.lifeup.item.countdown.stop
- Complete: app.lifeup.item.countdown.complete

**Return value:**

| Parameters | Meaning                       | Examples                  |
| ---------- | ----------------------------- | ------------------------- |
| item_id    | item id                       | 1                         |
| name       | item name                     | play games for 30 minutes |
| time_left  | time remaining (milliseconds) | 30000                     |

### دورة حياة Pomodoro

?> أُطلق حدث البث هذا في v1.101.0، ويوفر بيانات أحداث أغنى.

**Name:**

- Start: app.lifeup.pomodoro.start
- Pause: app.lifeup.pomodoro.pause (new in v1.101.0)
- Stop: app.lifeup.pomodoro.stop
- Complete: app.lifeup.pomodoro.complete

**Description:** عند بدء أو إيقاف مؤقت أو إيقاف أو اكتمال مؤقت Pomodoro، يرسل النظام أحداث بث مقابلة تحمل معلومات المهمة وحالة التوقيت وبيانات تفصيلية أخرى.

**Return value:**

| Parameter          | Meaning                       | Example        | Notes                                                      |
| ------------------ | ----------------------------- | -------------- | ---------------------------------------------------------- |
| task_id            | Task ID                       | 1              | اختياري، موجود فقط عند ربط Pomodoro بمهمة |
| task_gid           | Task group ID                 | 1              | اختياري، موجود فقط عند ربط Pomodoro بمهمة |
| name               | Task name                     | Study English  | اسم المهمة المرتبطة بـ Pomodoro أو اسم مخصص         |
| service_type       | Service type                  | 0              | 0=التركيز، 1=استراحة قصيرة، 2=استراحة طويلة                      |
| service_type_label | Service type label            | Focus          | نص نوع الخدمة المُ localized                                |
| duration           | Total duration (milliseconds) | 1500000        | المدة الإجمالية للتركيز أو الاستراحة                           |
| remaining          | Remaining duration (milliseconds) | 900000     | المدة المتبقية الحالية                                 |
| elapsed            | Elapsed duration (milliseconds) | 600000       | المدة المنقضية                                           |
| start              | Start time                    | 1639123456789  | Unix timestamp (milliseconds)                              |
| event_time         | Event trigger time            | 1639123456789  | Unix timestamp (milliseconds)                              |
| reason             | Stop reason                   | user           | لحدث الإيقاف فقط، القيم المحتملة: manual, cancel, complete, auto |

**وصف سبب الإيقاف:**

معامل `reason` موجود فقط في حدث `app.lifeup.pomodoro.stop`، ويشير إلى سبب إيقاف Pomodoro:

- `manual`: أوقفه المستخدم يدوياً
- `cancel`: ألغاه المستخدم
- `complete`: اكتمل بشكل طبيعي (ملاحظة: عند الاكتمال يُشغَّل أيضاً حدث `app.lifeup.pomodoro.complete`)
- `auto`: توقف تلقائياً (مثلاً حذف المهمة)

### دورة حياة المؤقت التصاعدي :id=broadcast_positive_timing

> [!NOTE]
> هذه الأحداث للمؤقت التصاعدي، وليست أحداث عدّ Pomodoro التنازلي أعلاه. قبل استخدامها، تأكد من تفعيل `Settings` → `Labs` → `Developer mode` → `Broadcast events`.

**Name:**

- Start: app.lifeup.timing.start
- Pause: app.lifeup.timing.pause
- Complete: app.lifeup.timing.complete
- Abandon: app.lifeup.timing.abandon

**Description:** عند بدء أو إيقاف مؤقت أو اكتمال أو التخلي يدوياً عن مؤقت تصاعدي، يرسل LifeUp البث المقابل. `complete` يعني أن الجلسة انتهت بشكل طبيعي وسُجِّلت. `abandon` يعني أن الجلسة الحالية أُوقفت أو تُركت يدوياً.

**Return value:**

| Parameters | Meaning                        | Examples      | Notes                                            |
| ---------- | ------------------------------ | ------------- | ------------------------------------------------ |
| task_id    | Task ID                        | 1             | اختياري، موجود فقط عند ربط المؤقت بمهمة |
| name       | Task name                      | Study English | اسم المهمة المرتبطة أو اسم مؤقت مخصص          |
| time       | Accumulated duration (ms)      | 600000        | إجمالي المدة المنقضية للمؤقت التصاعدي الحالي |
| start      | Start time                     | 1639123456789 | Unix timestamp (milliseconds)                    |
| end        | End time                       | 1639127056789 | موجود فقط في أحداث `complete` / `abandon`    |

---

## التكامل

نرحب بكل ترحيب بأي شكل من أشكال التكامل من المطورين الآخرين.

> ستُقدَّم تفاصيل أكثر قريباً...

### تحتاج المزيد من واجهات API؟

وظائف API حالياً في مرحلة تكرار إصدار واحدة.

في المستقبل، سنستمر في إضافة المزيد من واجهات API لتلبية سيناريوهات استخدام أكثر.

إذا احتجت المزيد من واجهات API، يمكنك فتح Issues على [Github](https://github.com/Ayagikei/LifeUp/issues/new/choose).

<br/>

### كيفية الاستدعاء

#### Android

##### باستخدام SDK

راجع وحدة `core` على: https://github.com/Ayagikei/LifeUp-SDK.

##### بدون SDK

```kotlin
    /**
    * Define a method to handle the uri
    */
    private fun call(context: Context, uriString: String){
        try {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(uriString)
            }
            context.startActivity(intent)
        }catch (e: Exception) {
            e.printStackTrace()
        }
    }

fun xxx() {
        ...
        // Then call it where appropriate
        call(context, "lifeup://api/toast?text=You+learned+to+call!&type=1&isLong=true")
        ...
    }
````

<br/>

#### صفحة ويب

عند استدعاء الصفحة، يعتمد التشغيل على المتصفح. المتصفحات الشائعة مثل Quark و Chrome و Edge تعمل جيداً. لكن بعض المتصفحات المدمجة في النظام قد تسأل المستخدم «هل تريد فتح Rensheng» في كل مرة.

إذا كنت تطوّر تطبيق WebView مدمجاً خاصاً بك، يجب التأكد من أن WebView يتعامل مع مخطط lifeup.

لتجربة متسقة، يمكنك استخدام تأثير رابط المنتج في `LifeUp` وتحديد «Use built-in browser» لفتحه. لكن بسبب إعدادات الأمان، هذه الطريقة تدعم روابط HTTPS فقط (وليس HTTP)

**HTML**

الانتقال مباشرة إلى الرابط التشعبي

````htm
<a href="lifeup://api/toast?text=You learned to call!&type=1&isLong=true" target="_blank" rel="noopener">Click here to call</a>
````

**Javascript**

في الواقع، يُستدعى أيضاً كرابط تشعبي

````javascript
location.href='lifeup://api/reward?type=coin&content=consolation+prize&number=1'
````

<br/>

### مطوّر تطبيق / ويب / أتمتة

أخبرنا إذا طوّرت أي شيء متعلق بـ LifeUp!

<br/>

### أي لغة برمجة / منصة تدعم بروتوكول HTTP

للتفاصيل، راجع https://github.com/Ayagikei/LifeUp-SDK و[LifeUp Cloud - HTTP APIs - Google Play](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http).
