plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.10.1"
}

group = "com.peng.idea.plugin"
version = "1.1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.slf4j:slf4j-api:1.7.25")
    implementation("org.slf4j:slf4j-simple:1.7.25")
    implementation("com.google.code.gson:gson:2.10.1")

//    implementation("com.alibaba:fastjson:2.0.1")

//    testImplementation("org.springframework:spring-test:5.2.22.RELEASE")
//    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
//    testImplementation("org.assertj:assertj-core:3.22.0")
//    testImplementation("org.mockito:mockito-inline:4.5.1")
//    testImplementation("org.mockito:mockito-core:4.5.1")
//    testImplementation("net.bytebuddy:byte-buddy-agent:1.12.9")
//    testImplementation("net.bytebuddy:byte-buddy:1.12.9")
}


// Configure Gradle IntelliJ Plugin - read more: https://github.com/JetBrains/gradle-intellij-plugin
intellij {
    version.set("2022.3")
    type.set("IC") // Target IDE Platform

//    plugins.set(listOf(/* Plugin Dependencies */))
    plugins.set(listOf("java"))


}

tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }

    patchPluginXml {
        sinceBuild.set("211")
        untilBuild.set("223.*")
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }
}
