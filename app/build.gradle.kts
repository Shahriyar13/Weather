import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = Constants.namespace
    compileSdk = Constants.compileSdk

    defaultConfig {
        applicationId = Constants.namespace
        minSdk = Constants.minSdk
        targetSdk = Constants.targetSdk
        versionCode = Constants.versionCode
        versionName = Constants.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    signingConfigs {
        create("release") {
            val properties = Properties().apply {
                load(File("$rootDir/keystore.properties").reader())
            }
            storeFile = File(properties.getProperty("storeFile"))
            storePassword = properties.getProperty("storePassword")
            keyAlias = properties.getProperty("keyAlias")
            keyPassword = properties.getProperty("keyPassword")
        }
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("release") {
            signingConfig = signingConfigs.getByName("release")
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = Constants.javaTarget
        targetCompatibility = Constants.javaTarget
    }
    kotlinOptions {
        jvmTarget = Constants.jvmTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}


dependencies {
    implementation(AppImplementationDependencies.androidCore)
    implementation(AppImplementationDependencies.lifeCycle)
    implementation(AppImplementationDependencies.activityCompose)
    implementation(AppImplementationDependencies.composeMaterial)
    implementation(AppImplementationDependencies.composeUi)
    implementation(AppImplementationDependencies.composeUiToolingPreview)
    testImplementation(AppTestImplementationDependencies.jUnit)
    androidTestImplementation(AppAndroidTestImplementationDependencies.testJUnit)
    androidTestImplementation(AppAndroidTestImplementationDependencies.composeJUnit)
    androidTestImplementation(AppAndroidTestImplementationDependencies.espresso)
    debugImplementation(AppDebugImplementationDependencies.composeUiTooling)
    debugImplementation(AppDebugImplementationDependencies.composeUiTestManifest)
}