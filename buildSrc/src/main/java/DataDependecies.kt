object DataImplementationDependencies {
    val androidCore by lazy { "androidx.core:core-ktx:${Versions.androidCore}" }
}

object DataTestImplementationDependencies {
    val jUnit by lazy { "junit:junit:${Versions.jUnit}" }
}

object DataAndroidTestImplementationDependencies {
    val testJUnit by lazy { "androidx.test.ext:junit:${Versions.androidJUnit}" }
    val espresso by lazy { "androidx.test.espresso:espresso-core:${Versions.espresso}" }
}