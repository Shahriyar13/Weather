object AppImplementationDependencies {
    val androidCore by lazy { "androidx.core:core-ktx:${Versions.androidCore}" }
    val composeMaterial by lazy { "androidx.compose.material3:material3:${Versions.composeMaterial}" }
    val composeUi by lazy { "androidx.compose.ui:ui:${Versions.compose}" }
    val composeUiToolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview:${Versions.compose}" }
    val activityCompose by lazy { "androidx.activity:activity-compose:${Versions.activityCompose}" }
    val lifeCycle by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifeCycle}" }
}

object AppTestImplementationDependencies {
    val jUnit by lazy { "junit:junit:${Versions.jUnit}" }
}

object AppAndroidTestImplementationDependencies {
    val testJUnit by lazy { "androidx.test.ext:junit:${Versions.androidJUnit}" }
    val composeJUnit by lazy { "androidx.compose.ui:ui-test-junit4:${Versions.composeJUnit}" }
    val espresso by lazy { "androidx.test.espresso:espresso-core:${Versions.espresso}" }
}

object AppDebugImplementationDependencies {
    val composeUiTooling by lazy { "androidx.compose.ui:ui-tooling:${Versions.compose}" }
    val composeUiTestManifest by lazy { "androidx.compose.ui:ui-test-manifest:${Versions.compose}" }
}