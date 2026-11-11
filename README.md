# Neon Snake για Android

Το παιχνίδι (`app/src/main/assets/index.html`) μέσα σε μια εφαρμογή Android που το δείχνει σε WebView.
Δεν ζητά καμία άδεια και δεν χρειάζεται internet.

## Πώς βγαίνει το APK

### Α. Με GitHub (χωρίς να εγκαταστήσεις τίποτα)

1. Φτιάξε ένα νέο repository στο GitHub και ανέβασε όλα τα αρχεία αυτού του φακέλου στο branch `main`
   (μαζί με τον κρυφό φάκελο `.github`).
2. Άνοιξε την καρτέλα **Actions**. Το build «Build APK» ξεκινά μόνο του και κρατά λίγα λεπτά.
3. Όταν τελειώσει, άνοιξέ το και κατέβασε το **NeonSnake-apk** από τα Artifacts.
   Μέσα στο zip είναι το `NeonSnake.apk`.

### Β. Με Android Studio

1. File > Open και διάλεξε αυτόν τον φάκελο.
2. Build > Build App Bundle(s) / APK(s) > Build APK(s).
3. Το APK βγαίνει στο `app/build/outputs/apk/`.

Από γραμμή εντολών: `./gradlew assembleRelease` (θέλει JDK 17 και Android SDK).

## Εγκατάσταση στο κινητό

Στείλε το `NeonSnake.apk` στο κινητό, άνοιξέ το και επίτρεψε την «εγκατάσταση από άγνωστες πηγές»
όταν σου το ζητήσει. Θέλει Android 8.0 ή νεότερο.

## Τι κάνει το κουμπί/η χειρονομία «πίσω»

- Στο παιχνίδι: παύση.
- Στην παύση ή στο τέλος παρτίδας: επιστροφή στο μενού.
- Στο μενού: κλείσιμο της εφαρμογής.

## Αλλαγές

- Παιχνίδι: άλλαξε το `app/src/main/assets/index.html`.
- Όνομα: `app/src/main/res/values/strings.xml`.
- Εικονίδιο: `app/src/main/res/drawable/ic_launcher_foreground.xml`.
- Έκδοση: `versionCode` / `versionName` στο `app/build.gradle` (ανέβαζε το `versionCode` σε κάθε νέα έκδοση).

## Υπογραφή

Το `app/neonsnake.keystore` υπογράφει κάθε build με το ίδιο κλειδί, ώστε οι νέες εκδόσεις να
εγκαθίστανται πάνω από τις παλιές. Ο κωδικός του είναι γραμμένος στο `app/build.gradle`, οπότε
για δημοσίευση στο Play Store φτιάξε δικό σου, ιδιωτικό κλειδί.
