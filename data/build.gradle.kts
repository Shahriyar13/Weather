plugins {
    id ("com.android.library")
    id ("org.jetbrains.kotlin.android")
}

android {
    namespace = Constants.namespace
    compileSdk = Constants.compileSdk

    defaultConfig {
        minSdk = Constants.minSdk
        targetSdk = Constants.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = Constants.javaTarget
        targetCompatibility = Constants.javaTarget
    }
    kotlinOptions {
        jvmTarget = Constants.jvmTarget
    }
}

dependencies {
    implementation(DataImplementationDependencies.androidCore)
    testImplementation(DataTestImplementationDependencies.jUnit)
    androidTestImplementation(DataAndroidTestImplementationDependencies.testJUnit)
    androidTestImplementation(DataAndroidTestImplementationDependencies.espresso)
}