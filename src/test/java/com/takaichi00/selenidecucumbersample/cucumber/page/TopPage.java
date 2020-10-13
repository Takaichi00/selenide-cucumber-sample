package com.takaichi00.selenidecucumbersample.cucumber.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TopPage {

  public SelenideElement getBookListTableTitle(int i) {
    SelenideElement table = $(".bookListTable tbody");
    ElementsCollection row = table.$$("tr");
    return row.get(i).$(".title");
  }

  public SelenideElement getBookListTableAuthor(int i) {
    SelenideElement table = $(".bookListTable tbody");
    ElementsCollection row = table.$$("tr");
    return row.get(i).$(".author");
  }
}
