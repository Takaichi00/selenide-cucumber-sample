package com.takaichi00.selenidecucumbersample.application;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationFormController {

  @RequestMapping(path = "/sample", method = {GET, POST})
  public String showBootPage() {
    return "sample";
  }

}
