package com.takaichi00.selenidecucumbersample;

import java.sql.SQLException;
import lombok.extern.slf4j.Slf4j;
import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class SelenideCucumberSampleApplication {

  public static void main(String[] args) {
    SpringApplication.run(SelenideCucumberSampleApplication.class, args);
  }

  @Bean(initMethod = "start", destroyMethod = "stop")
  public Server inMemoryH2DatabaseaServer() throws SQLException {
    return Server.createTcpServer(
      "-tcp", "-tcpAllowOthers", "-tcpPort", "9090");
  }

}
