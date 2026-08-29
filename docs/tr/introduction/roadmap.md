# Geliştirme Yol Haritası

*LifeUp* şu anda boş zamanlarda sürdürüldüğü ve kaynakları sınırlı olduğu için geliştirme planının tam olarak uygulanacağını garanti etmiyoruz ve belirli bir yayın zamanı taahhüt etmiyoruz.

<br/>

## Güncelleme stratejisi

Yerel özelliklerin güncelleme döngüsü 14-21 gün içinde kalacaktır.

Her özellik güncellemesinden sonra birkaç düzeltme yayınlayabiliriz.

"Dünya" modülünün işlevi çift uçlu ortak geliştirme, gereksinim senkronizasyonu, sunucu dağıtımı, sunucu performans sınırlamaları ve uyumluluk gibi birden fazla faktörü içerdiğinden.

Geliştirme döngüsü yerel işlevlerden daha uzun olacak ve yeni özellikler sunmak yerine ağırlıklı olarak bakım odaklı olacaktır.



**Güncelleme önceliği (yaklaşık):**

Çökme hatası düzeltmeleri >> Yeni kullanıcıları etkileyen deneyim hatası düzeltmeleri >> Özellik güncellemeleri > Arayüz ve ayrıntı hatası düzeltmeleri.

<br/>

## Sürüm numarası stratejisi

`1.80.3` gibi üç basamaklı sürüm numarası kullanılır.

**İlk basamak** (`1`.80.3 gibi) uygulamanın büyük revizyonu için kullanılan sürüm numarasıdır; 1 ilk resmi sürümdür. İyileştirme sağlıyorsa kapsamlı kod yeniden düzenleme / arayüz yeniden tasarımı değişiklikleri olabilir.


**Orta basamak** (1.**80**.3 gibi) özellik sürüm numarasıdır (feature). Orta düzey bir özellik işlevi yayınlandığında veya görece çok sayıda küçük özellik işlevi biriktiğinde sürüm numarası artar.

Örneğin:

> 64. sürüm Mağaza ve Depo sistemi getirdi.
>
> 70. sürüm Basit Mod'u getirdi.
>
> 80. sürüm kutudan çıkarma sistemini getirdi.



**Üçüncü basamak** (1.80.**3** gibi) her özellik sürümünde bazı sorunları / çökmeleri düzeltmek için revizyon numarasıdır. Aynı zamanda bazı küçük özellikler de getirebilir.


> Eski sürümde 1.58c gibi İngilizce harflerle temsil edilen üç basamaklı sürüm numarası da kullanılıyordu.
>
> Temel strateji yukarıdakiyle aynıdır; yalnızca üçüncü bölüm İngilizce harf olur ve `a` ile başlar.
>
> Ancak bazı uygulama mağazaları bu sürüm numarası stratejisini desteklemediği için artık terk edilmiştir.

<br/>

Güncel yol haritamız için [2026-2027 Geliştirme Planı](introduction/development_plan_2026_2027.md) sayfasına bakın.

Önceki yol haritası için [2024-2025 Geliştirme Planı](introduction/development_plan_2024.md) sayfasına bakın.

Arşiv için [2022/10 - 2023/12 Geliştirme Planı](introduction/development_plan_2023.md) sayfasına bakın.
