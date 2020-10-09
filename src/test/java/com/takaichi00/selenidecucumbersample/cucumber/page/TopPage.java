package com.takaichi00.selenidecucumbersample.cucumber.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.sql.ResultSet;
import java.util.List;

public class TopPage {
  public BookListTable getBookListTable() {
    return null;
  }

  public class BookListTable {

    public BookListRow getRow(int i) {
      return null;
    }
  }

  public class BookListRow {

    public SelenideElement getTitle() {
      return null;
    }

    public SelenideElement getIsbn() {
      return null;
    }

    public SelenideElement getRegisterDate() {
      return null;
    }
  }

}
