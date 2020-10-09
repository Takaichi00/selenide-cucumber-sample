package com.takaichi00.selenidecucumbersample.cucumber.steps;

import com.takaichi00.selenidecucumbersample.cucumber.page.TopPage;
import io.cucumber.java.ja.ならば;
import io.cucumber.java.ja.もし;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class BookSteps {

  @もし("トップページにアクセスした")
  public void トップページにアクセスした() {
    open("/top");
  }

  @ならば("管理している以下の本の情報を確認することができる")
  public void 管理している以下の本の情報を確認することができる(List<Map<String, String>> dataTable) {
    TopPage topPage = page(TopPage.class);
    topPage.getBookListTable().getRow(1).getTitle().shouldHave(text(dataTable.get(0).get("タイトル")));
    topPage.getBookListTable().getRow(1).getIsbn().shouldHave(text(dataTable.get(0).get("ISBN")));
    topPage.getBookListTable().getRow(1).getRegisterDate().shouldHave(text(dataTable.get(0).get("登録日")));
  }
}
