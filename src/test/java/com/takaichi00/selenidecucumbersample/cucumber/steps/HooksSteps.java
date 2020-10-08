package com.takaichi00.selenidecucumbersample.cucumber.steps;

import io.cucumber.java.ja.前提;
import java.util.List;
import java.util.Map;

public class HooksSteps {

  @前提("以下の本を管理している")
  public void 以下の本を管理している(List<Map<String, String>> dataTable) {
  }
}
