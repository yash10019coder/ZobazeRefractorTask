// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
    id("com.google.dagger.hilt.android") version "2.51" apply false
    id("com.android.library") version "8.2.1" apply false
}

rootProject.ext {
    set("dagger_version", "2.51")
    set("hilt_version", "1.0.0-alpha03")
    set("hilt_compiler", "1.0.0")
    set("multidex_version", "2.0.1")
}
