package com.takaichi00.selenidecucumbersample.cucumber.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.ja.ならば;
import io.cucumber.java.ja.もし;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SampleSteps {

  @BeforeStep
  public static void beforeStep(Scenario scenario) {
    Configuration.browser = WebDriverRunner.CHROME;
    Configuration.baseUrl = "http://localhost:8080";
    Configuration.timeout = 5000;

    //テスト実行後もブラウザを開いた状態にすることができる
    //Configuration.holdBrowserOpen = true;

    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver-mac-64.bit.version.2.41");
  }

  @もし("サンプルページにアクセスした")
  public void もしサンプルページにアクセスした() {
    open("/createForm");
  }

  @ならば("{string}が表示される")
  public void ならば_string_が表示される(String sampleStr) {
    $("#sample").shouldHave(text("sample"));
  }

}
