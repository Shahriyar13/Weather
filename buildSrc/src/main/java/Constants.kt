import org.gradle.api.JavaVersion

object Constants {
    const val compileSdk = 33
    const val targetSdk = compileSdk
    const val minSdk = 21
    const val versionCode = 1
    const val versionName = "1.0.0"
    const val namespace = "com.github.shahriyar13.data"
    const val jvmTarget = "1.8"
    val javaTarget = JavaVersion.VERSION_1_8
}