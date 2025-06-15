package dev.donaldsonblack.medtrace.backend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class MedtraceBackend implements CommandLineRunner {

  @Value("${spring.profiles.active}")
  private String activeProfile;

  public static void main(String[] args) {
    SpringApplication.run(MedtraceBackend.class, args);
    // Trigger wofklow
  }

  @Override
  public void run(String... args) {
    System.out.println("=========================================");
    System.out.println(" ACTIVE SPRING PROFILE: " + activeProfile);
    System.out.println("=========================================");
  }
}