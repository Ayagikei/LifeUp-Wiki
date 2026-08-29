<h1 align="center" padding="100">Local Network (API) Desktop Client 🖥</h1>

<p align="center">
 <img src="guide/_media/api/desktop.png" />
</p>

بنينا عميل سطح مكتب خفيفًا لـ LifeUp يعتمد على واجهات LifeUp API. يدعم Windows وLinux وmacOS.

**ليس تطبيقًا مستقلًا.** يقرأ بيانات LifeUp غير المتصلة من هاتفك عبر الوصول إلى API.

<br/>

## الميزات

> [!NOTE]
> الإصدار الحالي معاينة تقنية أساسًا لقدرات API. يركز على عمليات التصفح الأساسية ولا يغطي كل ميزة داخل App.

- مفتوح المصدر بالكامل. يمكنك تخصيص الواجهة وتنفيذ ميزاتك.
- القدرات الأساسية الحالية:
  - استعلام قائمة المهام وإتمام المهام
  - استعلام قائمة السمات والمستويات
  - استعلام قائمة العناصر وشراء العناصر
  - استعلام المشاعر وعرض الصور بالحجم الكامل على سطح المكتب
  - تصدير المشاعر إلى ملفات Markdown
  - إضافة مهام (لم تُغطَّ كل خيارات App بعد)

<br/>

## التنزيل

جميع حزم سطح المكتب منشورة على [LifeUp Desktop Releases](https://github.com/Ayagikei/LifeUp-Desktop/releases).

> [!WARNING]
> قبل استخدام سطح المكتب، تأكد أن LifeUp Cloud v2.0.0 أو أحدث.<br/>
> إذا كنت تستخدم build من GitHub Releases، حدّث LifeUp Cloud في `Settings` → `Labs`.<br/>
> إذا كنت تستخدم build من Google Play، يمكنك التحديث من [Google Play](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http) أو [LifeUp SDK Releases](https://github.com/Ayagikei/LifeUp-SDK/releases/latest).<br/>
> قد تمنع بعض المتصفحات تنزيل المثبّت بسبب سياسة الأمان. اختر **Keep/Allow** (الصياغة تختلف حسب المتصفح)، أو استخدم أداة تنزيل أخرى.

### منصات التثبيت

<!-- tabs:start -->

#### **Windows**

- `LifeUp Desktop.msi`

> [!TIP]
> **Windows SmartScreen**<br/>
> ملف MSI غير موقّع EV حاليًا، لذا قد يعرض Windows تحذير «تطبيق غير معروف».<br/>
> بعد التأكد أن الملف من إصدار GitHub الرسمي، اضغط **More info → Run anyway**.

#### **Linux**

- نزّل من [LifeUp Desktop Releases](https://github.com/Ayagikei/LifeUp-Desktop/releases) واستخدم `lifeup-desktop.deb`.

#### **macOS**

- Intel / x64: `LifeUp-Desktop-x64.dmg`
- Apple Silicon / ARM64: `LifeUp-Desktop-arm64.dmg`
- builds macOS لم تُختبر بالكامل بعد، وبعض الميزات مثل **Auto Connect** قد تكون غير متاحة.

> [!TIP]
> **macOS Gatekeeper / التوقيع**<br/>
> builds macOS الحالية غير notarized. قد ترى تحذير «مطوّر غير معروف».<br/>
> يمكنك فتح `.dmg`، نقل App إلى Applications، ثم النقر بزر الماوس الأيمن على App واختيار **Open**،<br/>
> أو اذهب إلى **System Settings → Privacy & Security** واضغط **Open Anyway**.<br/>
> راجع [دليل Apple الرسمي](https://support.apple.com/en-hk/guide/mac-help/mh40616/mac) للتفاصيل.

<!-- tabs:end -->

إذا كان الحزمة مفقودة مؤقتًا، حدّث لاحقًا. قد تكون أصول الإصدار ما زالت تُرفع.

<br/>

## كيفية الاستخدام

### الإعداد الأول

#### المتطلبات المسبقة

- يجب أن يكون الهاتف وسطح المكتب على نفس LAN (مثلًا، نفس Wi-Fi).
- <del>إذا كانت شبكتك معقدة، اختبر أولًا إن كان سطح المكتب يستطيع ping عنوان IP للهاتف.</del>
  - إصدارات سطح المكتب الأحدث تدعم اكتشاف IP الهاتف تلقائيًا، لذا غالبًا لا حاجة لهذا.

#### على الهاتف

1. حدّث LifeUp إلى أحدث إصدار.
2. في LifeUp، افتح `Settings` → `Labs`، ثم ثبّت **LifeUp Cloud**.
3. افتح LifeUp Cloud وامنح الأذونات المطلوبة:
   - إذن النافذة العائمة / الرسم فوق التطبيقات
   - إذن قراءة بيانات LifeUp
4. اضغط **Start Service** في LifeUp Cloud.

**إعداد إضافي موصى به**

- نفّذ إعداد التوافق لكل من LifeUp وLifeUp Cloud، وعطّل تحسين البطارية لتقليل إيقاف التطبيق في الخلفية.
- إذا كنت تستخدم MIUI (Xiaomi/Redmi)، اسمح بـ **Display UI in background** لكلا التطبيقين.
- أبقِ LifeUp وLifeUp Cloud قيد التشغيل.

#### على سطح المكتب

1. ثبّت تطبيق سطح المكتب من حزمة الإصدار.
2. في إعدادات سطح المكتب، أدخل IP الخدمة المعروض في LifeUp Cloud.
   - في سطح المكتب v1.1.0+، جرّب **Auto Connect**.
3. إذا كان كل شيء مضبوطًا بشكل صحيح، يجب أن تتمكن من عرض بيانات LifeUp على سطح المكتب.
   - إن فشل، راجع الإعداد الإضافي أعلاه.

### الاستخدام بعد المرة الأولى

1. افتح LifeUp وLifeUp Cloud على هاتفك.
2. اضغط **Start Service** في LifeUp Cloud.
3. شغّل عميل سطح المكتب.

<br/>

## الأسئلة الشائعة

<details>
<summary>هل يمكنني إضافة مهام من سطح المكتب؟</summary>

نعم. build سطح المكتب الحالي يدعم إنشاء مهام أساسي.

لكن ليست كل خيارات المهام المتقدمة في App متاحة على سطح المكتب بعد. للإعدادات المعقدة، استخدم App على الهاتف أو استدعِ واجهات API عبر LifeUp Cloud.

</details>

<details>
<summary>ضغطت "Request LifeUp Permission" في LifeUp Cloud، لكن لم يحدث شيء / API not found.</summary>

1. إن لم يحدث شيء، ربما منحت الإذن مسبقًا.
2. إن ظهر API not found، انضم إلى beta الأعضاء وحدّث LifeUp إلى أحدث beta.

</details>

<details>
<summary>بعد قفل الهاتف لفترة، سطح المكتب لا يقرأ البيانات.</summary>

نفّذ إعداد التوافق لكل من LifeUp وLifeUp Cloud.

</details>

<details>
<summary>عندما يكون LifeUp وLifeUp Cloud في الخلفية، بعض واجهات API تفشل.</summary>

> هذا عادةً لا يؤثر على الاستخدام الأساسي لسطح المكتب، لكن قد يؤثر على استدعاءات API مخصصة.

تأكد أن LifeUp Cloud لديه إذن النافذة العائمة/الرسم فوق التطبيقات.

إذا كنت على MIUI (Xiaomi/Redmi)، فعّل أيضًا **Display UI in background** لكلا التطبيقين.

</details>

<details>
<summary>فشل التثبيت على Windows مع `Failed to launch JVM`.</summary>

مرجع: [Issue #2](https://github.com/Ayagikei/LifeUp-Desktop/issues/2)

هذا عادةً مرتبط بإعداد accessibility المحلي لـ JVM.

حل شائع: علّق هذه الأسطر في `~/.accessibility.properties`:

```txt
# assistive_technologies=com.sun.java.accessibility.AccessBridge
# screen_magnifier_present=true
```

بعد التعديل، أعد تشغيل App واختبر مجددًا.

> `~` يعني مجلد home للمستخدم.

</details>

<br/>

## المساهمة

SDK وLifeUp Cloud وLifeUp Desktop مفتوحة المصدر.

الكود المصدري:

- [Ayagikei/LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop](https://github.com/Ayagikei/LifeUp-Desktop)
