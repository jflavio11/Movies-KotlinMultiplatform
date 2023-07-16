### Layered Architecture in a Kotlin Multiplatform project

This project was created by a series of posts you can find on my blog [https://jflavio.com](https://jflavio.com)
Follow the series here 👉 [https://jflavio.com/categories/kmm-serie/](https://jflavio.com/categories/kmm-serie/)

The domain and data layers are both inside the `shared` module of the Kotlin Multiplatform project. The final architecture looks like this:

<img src="https://miro.medium.com/v2/resize:fit:720/format:webp/1*DqpOyFM5N59EbAWwIPCCag.png" align="center" alt="Image of architecture" width="500">

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
Here is where magic happens. We define the domain and data layers inside this package. By the way, we support Kotlin Coroutines 😉.

---

#### Android module
Implements the MVVM pattern using Jetpack Compose. The ViewModels depends on the interactors interfaces that are defined in the domain layer inside the `shared` module.

<img src="https://user-images.githubusercontent.com/17575387/161411178-de4d4b56-5132-488c-9859-183fa6156171.png" align="center" width="360" >

---

#### iOS module

Implements the MVVM pattern using SwiftUI. The ViewModels depends on the interactors interfaces that are defined in the domain layer inside the `shared` module (currently in progress).
