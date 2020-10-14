package com.takaichi00.selenidecucumbersample.selenide;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class GooglePage {

  @FindBy(how = How.ID, using = "result-stats")
  private SelenideElement resultStats;

  @FindBy(how = How.CSS, using = "g")
  private ElementsCollection resultList;

  public SelenideElement getInformation() {
    return $("#hptl");
  }

  public SelenideElement getSearchBox() {
    return $("input.gLFyf.gsfi");
  }

  public SelenideElement getSearchExecuteButton() {
    return $("input.gNO89b");
  }

  public SelenideElement getGoogleMission() {
    return $("#module-anchor-statement-mission-statement h1");
  }
}
