package com.takaichi00.selenidecucumbersample.cucumber.steps;

import com.takaichi00.selenidecucumbersample.application.GooglePage;
import io.cucumber.java.ja.かつ;
import io.cucumber.java.ja.ならば;
import io.cucumber.java.ja.もし;
import io.cucumber.java.ja.前提;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class GoogleSteps {

  private GooglePage googlePage;

  @前提("www.google.comを開いている")
  public void wwwGoogleComを開いている() {
    open("https://www.google.com/");
    googlePage = page(GooglePage.class);
  }

  @もし("検索欄に{string}を入力した")
  public void 検索欄に検索文字を入力した(String searchText) {
    googlePage.getSearchBox().setValue("こんにちは");
  }

  @かつ("検索を実行した")
  public void 検索を実行した() {
    googlePage.getSearchExecuteButton().click();
  }

  @ならば("検索結果が表示されること")
  public void 検索結果が表示されること() {
    googlePage.getResultStats().should(visible);
  }

}
