plugins {
    id("org.springframework.boot") version "3.2.6"
    id("io.spring.dependency-management") version "1.1.4"
    id("java")
    id("application")
    id("com.google.cloud.tools.jib") version "3.4.5"
}

group = "dev.donaldsonblack"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_21

repositories {
    mavenCentral()
}

dependencies {
    // Spring Boot dependencies
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.postgresql:postgresql:42.7.3") 
    implementation(platform("software.amazon.awssdk:bom:2.27.21"))

    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // AWS SDK for Java v2
    implementation(platform("software.amazon.awssdk:bom:2.25.8"))

    // AWS SDK for Secrets Manager
    implementation("software.amazon.awssdk:secretsmanager")
    implementation("software.amazon.awssdk:auth")
    implementation("software.amazon.awssdk:regions")
    implementation("software.amazon.awssdk:aws-core")

    implementation("org.json:json:20090211")

    // HikariCP datasource
    implementation("com.zaxxer:HikariCP")
    
    // Use for JWT and cognito authentication lateer
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
    implementation("org.springframework.security:spring-security-jwt:1.1.1.RELEASE")
}


tasks.jar {
    manifest {
        attributes["Main-Class"] = "dev.donaldsonblack.cura.backend.Cura"
    }

    // Optionally include compileClasspath in the JAR
    // This is not recommended for Spigot, usually just use 'compileOnly'
    // To shade dependencies instead, use the Shadow plugin
}

application {
    mainClass.set("dev.donaldsonblack.cura.backend.Cura")
}

jib {
    from {
        image = "eclipse-temurin:21-jdk"
    }
    to {
        image = "ghcr.io/donaldsonblack/cura"
        auth {
            username = System.getenv("GHCR_USERNAME")
            password = System.getenv("GHCR_PAT")
        }
        
    }
}
