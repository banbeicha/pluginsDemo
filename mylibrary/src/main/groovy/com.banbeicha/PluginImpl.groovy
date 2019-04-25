package com.banbeicha

import org.gradle.api.Plugin
import org.gradle.api.Project


public class PluginImpl implements Plugin<Project> {
    void apply(Project project) {
        project.extensions.create("packageConfig", PackageExtension)
        PackageExtension ext = project.packageConfig
        println("开始执行")
        project.android.applicationVariants.all { variant ->
            def variantName = variant.name.capitalize()
            println("版本类型${variantName}")
            variant.outputs.all {
                outputFileName = "${ext.appName}V${ext.appVerSionName}${variantName}${new Date().format('MMdd', TimeZone.getTimeZone('UTC'))}.apk"

            }

        }
        project.dependencies {
            implementation 'io.reactivex.rxjava2:rxandroid:2.1.1'
            implementation 'io.reactivex.rxjava2:rxjava:2.2.8'
            implementation 'com.squareup.retrofit2:retrofit:2.5.0'
            implementation 'com.squareup.retrofit2:converter-gson:2.5.0'
            implementation 'com.squareup.retrofit2:adapter-rxjava2:2.5.0'
            implementation 'com.github.tbruyelle:rxpermissions:0.10.2'
            implementation 'com.trello.rxlifecycle3:rxlifecycle:3.0.0'

// If you want to bind to Android-specific lifecycles
            implementation 'com.trello.rxlifecycle3:rxlifecycle-android:3.0.0'

// If you want pre-written Activities and Fragments you can subclass as providers
            implementation 'com.trello.rxlifecycle3:rxlifecycle-components:3.0.0'

// If you want pre-written support preference Fragments you can subclass as providers
            implementation 'com.trello.rxlifecycle3:rxlifecycle-components-preference:3.0.0'

// If you want to use Android Lifecycle for providers
            implementation 'com.trello.rxlifecycle3:rxlifecycle-android-lifecycle:3.0.0'
            implementation 'com.github.bumptech.glide:glide:4.9.0'
            annotationProcessor 'com.github.bumptech.glide:compiler:4.9.0'
        }

    }


}
