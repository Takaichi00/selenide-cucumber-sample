package com.takaichi00.selenidecucumbersample.cucumber.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@Getter
public class TopPage {

  @FindBy(how = How.CSS, using = ".bookListTable tbody tr")
  private ElementsCollection tableRow;

  public SelenideElement getBookListTableTitle(int i) {
    return tableRow.get(i).$(".title");
  }

  public SelenideElement getBookListTableAuthor(int i) {
    return tableRow.get(i).$(".author");
  }
}
