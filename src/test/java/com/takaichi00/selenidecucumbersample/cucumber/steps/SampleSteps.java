package com.takaichi00.selenidecucumbersample.cucumber.steps;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import io.cucumber.java.ja.もし;
import io.cucumber.java.ja.ならば;

public class SampleSteps {

  @もし("サンプルページにアクセスした")
  public void もしサンプルページにアクセスした() {
    open("/sample");
  }

  @ならば("{string}が表示される")
  public void ならば_string_が表示される(String sampleStr) {
    $("#sample").shouldHave(text("sample"));
  }

}
