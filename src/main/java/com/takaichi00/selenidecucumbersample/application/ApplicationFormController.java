package com.takaichi00.selenidecucumbersample.application;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import com.takaichi00.selenidecucumbersample.integration.SampleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class ApplicationFormController {

  @Autowired
  SampleRepository sampleRepository;

  @RequestMapping(path = "/sample", method = {GET})
  public String showSamplePage() {
    log.info(sampleRepository.findAll().toString());
    return "sample";
  }

  @RequestMapping(path = "/top", method = {GET})
  public String showTopPage() {
    log.info(sampleRepository.findAll().toString());
    return "top";
  }

}
