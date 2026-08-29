# Copia de seguridad y restauración

> [!IMPORTANT]
> LifeUp es una aplicación offline-first. La mayor parte de tus datos personales permanece en tu dispositivo. Si no configuras la copia de seguridad, desinstalar la app, cambiar de teléfono o dañar el dispositivo puede provocar una pérdida permanente de datos.

## Navegación rápida

- [Por qué importa la copia de seguridad](#why-backup)
- [Cómo configurar métodos de copia de seguridad](#configure-methods)
- [Cómo hacer copia de seguridad](#how-to-backup)
- [Cómo restaurar](#how-to-restore)
- [Migración a un teléfono nuevo](#phone-migration)
- [Problemas frecuentes](#common-issues)

## 1) Por qué importa la copia de seguridad :id=why-backup

### ¿Contra qué riesgos te proteges?

La mayoría de usuarios pierden datos en una de estas situaciones:

1. Desinstalación de la app (los archivos en la ruta de copia de seguridad predeterminada pueden eliminarse con la limpieza del sistema)
2. Migración de teléfono sin mover los archivos de copia de seguridad
3. Daño o pérdida del dispositivo

Una copia de seguridad fiable significa que tus datos existen en otro dispositivo o medio de almacenamiento, no solo en el mismo teléfono.

### ¿Qué incluye una copia de seguridad?

Las copias de seguridad incluyen tus datos locales principales, como Tareas, Atributos, datos de la Tienda, Logros, Reflexiones, registros Pomodoro y ajustes. Los archivos multimedia (adjuntos, iconos, fondos, audio) también pueden incluirse.

> [!TIP]
> Si el tamaño de la copia de seguridad supera los 10 MB, activa «Ignorar archivos multimedia/imágenes» o aumenta el intervalo de copia de seguridad para mayor estabilidad.

## 2) Cómo configurar métodos de copia de seguridad :id=configure-methods

Para la mayoría de usuarios, esta prioridad funciona mejor:

| Método | Recomendado | Ideal para | Copia automática | Notas |
| --- | --- | --- | --- | --- |
| Google Drive | ⭐⭐⭐⭐⭐ | Uso diario, sincronización en la nube sencilla | Sí | Autorización con un toque en la app |
| Dropbox | ⭐⭐⭐⭐ | Uso diario, sincronización entre dispositivos | Sí | También admite autorización en la app |
| Exportación local (ruta personalizada) | ⭐⭐⭐⭐ | Copia manual a PC / NAS | No (manual) | Respaldo fiable y archivos versionados |
| WebDAV | ⭐⭐⭐ | Autoalojamiento / servicio WebDAV existente | Sí | Buena alternativa si ya usas WebDAV |
| Copia automática en carpeta Descargas (Android 10+) | ⭐⭐⭐ | Reducir riesgo al desinstalar | Sí | No protege contra daños del dispositivo |

<details>
<summary>Configurar copia automática en Google Drive / Dropbox (recomendado)</summary>

En la app, ve a:
`Barra lateral → Ajustes → Copia de seguridad/Restauración/Borrado de datos`

Luego:

1. Autoriza Google Drive o Dropbox
2. En «Configuración de copia en la nube», selecciona tu método
3. Activa «Habilitar copia automática en la nube»
4. Establece «Intervalo de copia automática»
5. Opcionalmente, activa «Ignorar archivos multimedia/imágenes»

</details>

<details>
<summary>Configurar copia en la nube con WebDAV (opcional)</summary>

Si usas un servicio compatible con WebDAV:

1. Abre `Configuración WebDAV`
2. Completa URL, cuenta y contraseña
3. Ejecuta una prueba de conexión
4. Usa WebDAV como método de copia en la nube

</details>

<details>
<summary>Exportar a ruta personalizada (respaldo manual)</summary>

Úsalo cuando quieras copias de seguridad manuales y portables:

1. Toca `Copia de seguridad`
2. Elige `Ruta personalizada`
3. Guarda el archivo generado (normalmente `.lfbak`)
4. Cópialo a PC / NAS / almacenamiento en la nube

> [!WARNING]
> No mantengas tu única copia de seguridad en el mismo teléfono.

</details>

## 3) Cómo hacer copia de seguridad :id=how-to-backup

<details>
<summary>Flujo de copia automática diaria</summary>

1. Completa una configuración en la nube (Google Drive o Dropbox)
2. Activa la copia automática en la nube y el intervalo
3. Dispara una copia manual una vez para verificar que todo funciona
4. Revisa periódicamente el aviso de «última copia de seguridad»

</details>

<details>
<summary>Copia manual antes de cambios críticos</summary>

Crea una exportación local adicional antes de:

- actualizaciones importantes de la app
- restablecimiento o reflasheo del sistema
- migración de teléfono

Usa: `Copia de seguridad → Ruta personalizada`, luego copia el archivo a almacenamiento externo.

</details>

## 4) Cómo restaurar :id=how-to-restore

<details>
<summary>Restaurar desde copia en la nube (Google Drive / Dropbox / WebDAV)</summary>

1. Configura la misma cuenta/método en la nube en el dispositivo de destino
2. Toca `Restaurar` y elige ese método
3. Confirma la restauración (la app se reiniciará)

> [!WARNING]
> La restauración sobrescribe los datos locales actuales. Si los datos actuales importan, exporta primero una copia local.

</details>

<details>
<summary>Restaurar desde archivo de copia local</summary>

1. Mueve el archivo de copia al dispositivo de destino
2. Toca `Restaurar → Ruta personalizada`
3. Selecciona el archivo de copia y confirma

También puedes activar «Admitir que el sistema de archivos abra archivos de copia de seguridad» para importar directamente desde el gestor de archivos o apps de compartir.

> [!TIP]
> Si la restauración falla con error de lectura/escritura, prueba otra ruta de archivo y vuelve a seleccionarlo.

</details>

### Migración a un teléfono nuevo :id=phone-migration

<details>
<summary>Migrar a un teléfono nuevo (sistema o ruta de copia)</summary>

#### Opción A: Usar primero la migración integrada del teléfono

Algunos teléfonos admiten migración completa de datos de la app (herramientas de migración de marca / clonación del sistema).

1. Ejecuta la migración del sistema del teléfono antiguo al nuevo.
2. Abre LifeUp y verifica los datos clave (Tareas, Atributos, datos de la Tienda, Logros).
3. Aunque la migración parezca correcta, crea una copia de seguridad nueva en el teléfono nuevo.

#### Opción B: Migrar mediante copia en la nube o archivo de copia (universal)

1. En el teléfono antiguo, crea primero una copia de seguridad nueva.
2. En el teléfono nuevo, instala LifeUp.
3. Para migración en la nube: configura el mismo método/cuenta en la nube, luego restaura.
4. Para migración por archivo: transfiere el archivo de copia, luego usa `Restaurar → Ruta personalizada`.
5. Tras restaurar, dispara una copia manual para verificar la cadena de copias en el teléfono nuevo.

> [!WARNING]
> La restauración sobrescribe los datos locales. Si el teléfono nuevo ya tiene entradas importantes nuevas, exporta primero.

</details>

## 5) Problemas frecuentes :id=common-issues

<details>
<summary>Corregir error de restauración: archivo de copia no válido</summary>

- Confirma que el archivo fue generado por LifeUp.
- `.lfbak` es el formato recomendado.

</details>

<details>
<summary>Corregir error de restauración: archivo de copia con versión superior</summary>

Actualiza LifeUp a la última versión y restaura de nuevo.

</details>

<details>
<summary>Mejorar copia en la nube lenta o inestable</summary>

- Activa «Ignorar archivos multimedia/imágenes».
- Aumenta el intervalo de copia automática.
- Limpia archivos multimedia no usados antes de la copia.

</details>

<details>
<summary>Decidir si basta la copia automática en la carpeta Descargas</summary>

- Ayuda contra pérdidas relacionadas con la desinstalación.
- No cubre daño o pérdida del dispositivo.
- Estrategia más segura: combinar copia en la nube + exportación local periódica.

</details>
