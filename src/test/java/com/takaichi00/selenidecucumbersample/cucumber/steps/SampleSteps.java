package com.takaichi00.selenidecucumbersample.cucumber.steps;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import io.cucumber.java.ja.かつ;
import io.cucumber.java.ja.もし;
import io.cucumber.java.ja.ならば;
import io.cucumber.java.ja.前提;

import java.util.List;
import java.util.Map;

public class SampleSteps {

  @前提("商品検索ページにアクセスする")
  public void 商品検索ページにアクセスする() {
    open("/search");
  }
  @かつ("商品検索バーに{string}を入力する")
  public void 商品検索バーにを入力する(String searchText) {
    $("#search-bar").setValue(searchText);
  }
  @ならば("検索結果一覧に以下が表示される")
  public void 検索結果一覧に以下が表示される(List<Map<String, String>> dataTable) {

    $("#header").shouldHave(text("ヘッダーです"));

    for (int i = 0; i < dataTable.size(); ++i) {
      $(".result-list tbody").$$("tr").get(i).$(".title")
        .shouldHave(text(dataTable.get(i).get("title")));
    }
  }

  @ならば("ヘッダーという文字がある")
  public void ヘッダーという文字がある() {
    $("#header").shouldHave(text("ヘッダーです"));
  }


  @もし("{string}を選択する")
  public void を選択する(String arg0) {
    // ...
  }
  @ならば("確認画面に遷移する")
  public void 確認画面に遷移する() {
    // ...
  }
  @もし("購入するボタンを押す")
  public void 購入するボタンを押す() {
    $("#purchase-button").click();
  }

  @ならば("購入が完了する")
  public void 購入が完了する() {
  }

  @もし("サンプルページにアクセスした")
  public void もしサンプルページにアクセスした() {
    open("/sample");
  }

  @ならば("{string}が表示される")
  public void ならば_string_が表示される(String sampleStr) {
    $("#sample").shouldHave(text("sample"));
  }

  @もし("顧客が{string}だった")
  public void 顧客が顧客タイプだった(String type) {
  }

  @ならば("料金は{string}となる")
  public void 料金は料金となる(String price) {
  }

  @もし("フッターまでスクロールする")
  public void フッターまでスクロールする() {
    $("#footer").scrollTo().shouldNotBe();
  }

  @もし("ドラックアンドドロップする")
  public void ドラックアンドドロップする() {
    $("#from").dragAndDropTo($("#to"));
  }

  @前提("名前が{string}であるユーザーがログインしている")
  public void 名前がであるユーザーがログインしている(String arg0) {
  }
}
