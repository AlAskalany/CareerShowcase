plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "com.alaskalany.careershowcase"
        minSdkVersion(21)
        targetSdkVersion(28)
        versionCode = 7
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    dataBinding.isEnabled = true
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    testOptions {
        unitTests.isIncludeAndroidResources = true
    }
    lintOptions {
        isAbortOnError = false
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("androidx.core:core-ktx:1.0.1")
    implementation("androidx.fragment:fragment-ktx:1.0.0")
    implementation("androidx.palette:palette-ktx:1.0.0")
    implementation("androidx.sqlite:sqlite-ktx:2.0.0")
    implementation("androidx.collection:collection-ktx:1.0.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.0.0")
    implementation("android.arch.navigation:navigation-common-ktx:1.0.0-alpha07")
    implementation("android.arch.navigation:navigation-fragment-ktx:1.0.0-alpha07")
    implementation("android.arch.navigation:navigation-runtime-ktx:1.0.0-alpha07")
    implementation("android.arch.navigation:navigation-testing-ktx:1.0.0-alpha06")
    implementation("android.arch.navigation:navigation-ui-ktx:1.0.0-alpha07")
    implementation("android.arch.work:work-runtime-ktx:1.0.0-alpha11")
    implementation("androidx.appcompat:appcompat:1.0.2")
    implementation("com.google.android.material:material:1.1.0-alpha01")
    implementation("androidx.constraintlayout:constraintlayout:2.0.0-alpha2")
    implementation("androidx.vectordrawable:vectordrawable:1.0.1")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.recyclerview:recyclerview:1.0.0")
    // Room components
    implementation("androidx.room:room-runtime:2.1.0-alpha02")
    kapt("androidx.room:room-compiler:2.1.0-alpha02")
    androidTestImplementation("androidx.room:room-testing:2.1.0-alpha02")
    // Lifecycle components
    implementation("androidx.lifecycle:lifecycle-extensions:2.0.0")
    kapt("androidx.lifecycle:lifecycle-compiler:2.0.0")
    // Glide
    implementation("com.github.bumptech.glide:glide:4.8.0")
    kapt("com.github.bumptech.glide:compiler:4.8.0")
    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test:runner:1.1.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.1.0")
    implementation("com.google.firebase:firebase-core:16.0.5")
    implementation("com.google.firebase:firebase-firestore:17.1.3")
    implementation("com.google.code.gson:gson:2.8.5")
    // Robolectric
    testImplementation("org.robolectric:robolectric:4.0.1")
    testImplementation("androidx.test:core:1.0.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.0")
}

apply(mapOf("plugin" to "com.google.gms.google-services"))