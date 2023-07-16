### Layered Architecture in a Kotlin Multiplatform project

This project was created by a series of posts you can find on my blog [https://jflavio.com](https://jflavio.com)

Follow the series here 👉 [https://jflavio.com/categories/kmm-serie/](https://jflavio.com/categories/kmm-serie/)

However, this branch is implementing Compose Multiplatform, so the presentation layer (UI and ViewModels) are not implemented for each platform anymore 😉.

---

#### Core or shared module
Here is where all the business logic is defined. It contains cross code for all platform. This includes: repositories interfaces, repositories implementations, data sources implementation, networking access for consuming REST APIs, interactors and main domain models.

We are using the following libraries:
 - [ktor](https://github.com/ktorio/ktor) for networking access
 - [kotlinx serialization](https://github.com/Kotlin/kotlinx.serialization) for transforming JSON responses into DTOs
 - [SQDelight](https://github.com/cashapp/sqldelight) as database management. Each platform implement its own driver.
 - [Kotlin Coroutines](https://kotlinlang.org/docs/multiplatform-add-dependencies.html#kotlinx-libraries)
 - [BuildKonfig](https://github.com/yshrsmz/BuildKonfig) for having build configuration fields across platforms (such as API Key).

##### androidMain
Here we only have an implementation of the database driver interface defined in the `commonMain` package but for Android.

##### iOSMain
Here we only have an implementation of the database driver interface defined in the `commonMain` package but for the iOS project.

##### commonMain
Here is where magic happens. We define the presentation, domain and data layers inside this package. By the way, we support Kotlin Coroutines 😉.

Here's the app running on iPhone, invoking the Movies DB API thanks to KTOR.
<img src="https://github.com/jflavio11/LayeredKotlinMultiplatform/blob/composeMultiplatform/images/ios-compose-multiplatform.png?raw=true" align="center" width="360" alt="Screenshot of iPhone emulator running the app">

**Note: Images are not shown since there's no a stable library for it. There's Kamel, but still investigating.**

---

#### Android module
Only has the `MovieActivity` Kotlin file which invokes the Compose Multiplatform UI. 

---

#### iOS App module
Has the `ComposeView.swift` which invokes the Compose Multiplatform UI.
