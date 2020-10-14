package com.takaichi00.selenidecucumbersample.cucumber.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hooks {

  @BeforeStep
  public void beforeStep(Scenario scenario) {
    System.out.println("before step");
  }

  @Before
  public static void before() {
    System.out.println("before");
    Configuration.browser = WebDriverRunner.CHROME;
    Configuration.baseUrl = "http://localhost:8080";
    Configuration.timeout = 5000;

    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver-mac.86.0.4240.22");

    // テスト実行後もブラウザを開いた状態にすることができる
//    Configuration.holdBrowserOpen = true;

    // HeadLessモード指定
//    ChromeOptions chromeOptions = new ChromeOptions();
//    chromeOptions.addArguments("--headless");
//    ChromeDriver driver = new ChromeDriver(chromeOptions);
//    WebDriverRunner.setWebDriver(driver);
  }

  @AfterStep
  public void afterStep() {
    System.out.println("after step");
  }

  @After
  public void after() {
    System.out.println("after");
  }

}
