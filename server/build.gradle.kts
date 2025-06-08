plugins {
    id("org.springframework.boot") version "3.2.6"
    id("io.spring.dependency-management") version "1.1.4"
    id("java")
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

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    
    // Use for JWT and cognito authentication lateer
    //implementation("org.springframework.boot:spring-boot-starter-security")
    //implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
    //implementation("org.springframework.security:spring-security-jwt:1.1.1.RELEASE")
}
