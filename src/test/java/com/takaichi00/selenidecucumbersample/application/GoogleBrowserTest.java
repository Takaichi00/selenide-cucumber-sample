package com.takaichi00.selenidecucumbersample.application;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class GoogleBrowserTest {

  @BeforeAll
  static void setup() {
    Configuration.browser = WebDriverRunner.CHROME;
    Configuration.timeout = 5000;

    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver-mac.86.0.4240.22");

    //テスト実行後もブラウザを開いた状態にすることができる
//    Configuration.holdBrowserOpen = true;

    //HeadLessモード指定
//    ChromeOptions chromeOptions = new ChromeOptions();
//    chromeOptions.addArguments("--headless");
//    ChromeDriver driver = new ChromeDriver(chromeOptions);
//    WebDriverRunner.setWebDriver(driver);
  }

  @Test
  void Googleのページを開くテスト() {
    open("https://www.google.com/");
    $("#hptl").shouldHave(text("Googleについて"));
    $("input.gLFyf.gsfi").setValue("こんにちは");
    $("input.gNO89b").click();
    $("#result-stats").should(visible);
  }

  @Test
  void Googleのページを開くテスト_PageObject() {
    open("https://www.google.com/");

    GooglePage googlePage = page(GooglePage.class);
    googlePage.getInformation().shouldHave(text("Googleについて"));
    googlePage.getSearchBox().setValue("こんにちは");
    googlePage.getSearchExecuteButton().click();
    googlePage.getResultStats().should(visible);
  }
}