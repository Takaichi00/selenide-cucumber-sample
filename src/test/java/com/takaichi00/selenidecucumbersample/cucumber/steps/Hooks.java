package com.takaichi00.selenidecucumbersample.cucumber.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.destination.DriverManagerDestination;
import com.ninja_squad.dbsetup.operation.Operation;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

import static com.ninja_squad.dbsetup.Operations.deleteAllFrom;
import static com.ninja_squad.dbsetup.Operations.insertInto;
import static com.ninja_squad.dbsetup.operation.CompositeOperation.sequenceOf;

public class Hooks {

  @BeforeStep
  public static void beforeStep(Scenario scenario) {
    Configuration.browser = WebDriverRunner.CHROME;
    Configuration.baseUrl = "http://localhost:8080";
    Configuration.timeout = 5000;

    //テスト実行後もブラウザを開いた状態にすることができる
    //Configuration.holdBrowserOpen = true;

    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver-mac-64.bit.version.2.41");
  }

  @Before
  public static void before() {
    Operation operation = sequenceOf(
      deleteAllFrom("sample"),
      insertInto("sample").columns("id").values(1).build());

    DriverManagerDestination destination = new DriverManagerDestination("jdbc:h2:tcp://localhost:9090/~/data/sample", "username", "password");

    DbSetup dbSetup = new DbSetup(destination, operation);
    dbSetup.launch();

  }

}
