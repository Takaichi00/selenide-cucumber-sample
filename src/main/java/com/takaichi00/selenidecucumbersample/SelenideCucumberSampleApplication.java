package com.takaichi00.selenidecucumbersample;

import com.takaichi00.selenidecucumbersample.integration.SampleEntity;
import com.takaichi00.selenidecucumbersample.integration.SampleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Slf4j
public class SelenideCucumberSampleApplication {

  @Autowired
  SampleRepository sampleRepository;

  public static void main(String[] args) {
    SpringApplication.run(SelenideCucumberSampleApplication.class, args);
  }

  @PostConstruct
  public void init() {
    sampleRepository.save(new SampleEntity(1));
    sampleRepository.save(new SampleEntity(2));
    log.info(sampleRepository.findAll().toString());
  }
}
