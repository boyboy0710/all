import kr.entree.spigradle.kotlin.spigot

plugins {
    kotlin("jvm") version "1.3.71"
    id("kr.entree.spigradle") version "1.2.2"
}

group = "boyboy0710.kotlin" // 본인의 홈페이지 주소 또는 이메일 주소를 거꾸로 적음
version = "1.0.0"

repositories {
    maven("https://github.com/boyboy0710")
}

dependencies {
    implementation(kotlin("stdlib-jdk8")) // kotlin stdlib

    compileOnly(spigot("1.16.3")) // spigot api
}

spigot { // plugin.yml 설정
    authors = listOf("HeartPattern")
}

val shade = configurations.create("shade")
shade.extendsFrom(configurations.implementation.get())

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }

    jar {
        from(
            shade.map {
                if (it.isDirectory)
                    it
                else
                    zipTree(it)
            }
        )
    }
}