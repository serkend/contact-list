buildscript {

    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Project.Android.androidGradle)
        classpath(Project.Android.kotlinGradle)
        classpath(Libs.Application.Navigation.nav_safe_args)
        classpath (Project.Dagger.daggerHilt)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

tasks.withType<Test> {
    useJUnitPlatform()
}