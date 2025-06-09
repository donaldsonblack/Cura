plugins {
    id("org.springframework.boot") version "3.2.6"
    id("io.spring.dependency-management") version "1.1.4"
    id("java")
    id("application")
}

group = "dev.donaldsonblack"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_21

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.postgresql:postgresql:42.7.3") 
    implementation(platform("software.amazon.awssdk:bom:2.27.21"))
    implementation("software.amazon.awssdk:s3")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    
    // Use for JWT and cognito authentication lateer
    //implementation("org.springframework.boot:spring-boot-starter-security")
    //implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
    //implementation("org.springframework.security:spring-security-jwt:1.1.1.RELEASE")
}


tasks.jar {
    manifest {
        attributes["Main-Class"] = "dev.donaldsonblack.medtrace.backend.MedtraceBackend"
    }

    // Optionally include compileClasspath in the JAR
    // This is not recommended for Spigot, usually just use 'compileOnly'
    // To shade dependencies instead, use the Shadow plugin
}

application {
    mainClass.set("dev.donaldsonblack.medtrace.backend.MedtraceBackend")
}
