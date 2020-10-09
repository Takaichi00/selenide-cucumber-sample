package com.takaichi00.selenidecucumbersample.cucumber.steps;

import com.takaichi00.selenidecucumbersample.cucumber.page.TopPage;
import io.cucumber.java.ja.ならば;
import io.cucumber.java.ja.もし;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertEquals;

public class BookSteps {

  @もし("トップページにアクセスした")
  public void トップページにアクセスした() {
    open("/top");
  }

  @ならば("管理している以下の本の情報を確認することができる")
  public void 管理している以下の本の情報を確認することができる(List<Map<String, String>> dataTable) {
    TopPage topPage = page(TopPage.class);
    topPage.getBookListTableTitle(0).shouldHave(text(dataTable.get(0).get("タイトル")));
//    topPage.getBookListTableIsbn(1).getIsbn().shouldHave(text(dataTable.get(0).get("ISBN")));
//    topPage.getBookListTableRegisterDate(1).shouldHave(text(dataTable.get(0).get("登録日")));
  }

  @もし("顧客が{string}だった")
  public void 顧客が顧客タイプだった(String type) {
    
  }

  @ならば("料金は{string}となる")
  public void 料金は料金となる(String price) {
  }
}
