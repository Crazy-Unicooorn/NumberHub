/*
 * Unitto is a calculator for Android
 * Copyright (c) 2023-2024 Elshan Agaev
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

plugins {
    id("unitto.library")
    id("unitto.android.hilt")
    id("unitto.room")
    id("unitto.android.library.jacoco")
}

android.namespace = "app.myzel394.numberhub.data.converter"
android.testOptions.unitTests.isIncludeAndroidResources = true

android {
    room {
        val schemaLocation = "$projectDir/schemas"
        schemaDirectory(schemaLocation)
        println("Exported Database schema to $schemaLocation")
    }
}

dependencies {
    testImplementation(libs.org.robolectric.robolectric)
    implementation(libs.com.squareup.moshi.moshi.kotlin)
    implementation(libs.com.squareup.retrofit2.converter.moshi)

    implementation(project(":core:base"))
    implementation(project(":data:common"))
    implementation(project(":data:database"))
    implementation(project(":data:evaluatto"))
    implementation(project(":data:model"))
}
