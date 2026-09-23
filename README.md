# Molamax — Android App

A native Android app (Kotlin + Jetpack Compose) for Molamax, built from the
content in the `molamax.org` PHP/MySQL site package: product categories,
the full product catalogue, Knowledge Centre articles, FAQs, stockists,
and contact details.

**No login/account screen** — the app opens straight into a bottom-tab,
scrollable experience: Home, Products, Learn, Stockists, Contact.

## How to build and run

1. Install **Android Studio** (Koala/2024.1 or newer) — https://developer.android.com/studio
2. Unzip this project and choose **File → Open** in Android Studio, selecting the
   `MolamaxApp` folder.
3. Let Gradle sync. On first sync, Android Studio will automatically download
   the Gradle wrapper JAR referenced in `gradle/wrapper/gradle-wrapper.properties`
   (Gradle 8.9) and the Android/Kotlin Gradle plugins — this needs an internet
   connection once.
4. Press **Run ▶** with an emulator or a physical device connected (USB debugging
   enabled). Minimum supported Android version is **7.0 (API 24)**.
5. To produce an installable `.apk`: **Build → Build Bundle(s) / APK(s) → Build APK(s)**.
   The file appears under `app/build/outputs/apk/debug/app-debug.apk` — copy it to a
   phone and tap to install (allow "install unknown apps" if prompted).

## What's inside

- `app/src/main/java/org/molamax/app/data/MolamaxData.kt` — all site content as
  Kotlin data (5 categories, 14 products, 5 articles, 4 FAQs, 6 stockists, contact
  numbers/email/hours), pulled from `database.sql`, `product-catalog.sql`,
  `stockists-update.sql` and `seed.php` in the original package.
- `ui/screens/` — Home, Products (with category filter chips), Learn (articles +
  expandable FAQs), Stockists (tap-to-call), Contact (call / email / WhatsApp).
- `ui/MolamaxApp.kt` — bottom navigation bar wiring the five screens together.
- `util/IntentUtils.kt` — opens the phone dialer, email client, or WhatsApp for
  quote requests, replacing the original site's PHP form handlers (no backend
  server is bundled with the app).
- Brand colors (`#C0201C` red, dark green/black header) and typography match the
  original Molamax site design.

## Notes / next steps

- The original PHP site stores contact and quote-request submissions in MySQL and
  has an admin dashboard. This app is the public-facing storefront only — "Ask about
  this product" and "Request a quote" open WhatsApp/email instead of posting to a
  server, since there's no backend included here.
- To add a real backend (so leads land in a database instead of WhatsApp), the
  existing `config/`, `admin/`, and `*.sql` files in the site package could be
  deployed as a small REST API that this app calls with Retrofit — let me know if
  you'd like that wired up.
- App icon is a simple placeholder vector (`res/drawable/ic_launcher.xml`) in
  Molamax's colors — swap in real artwork before publishing.
