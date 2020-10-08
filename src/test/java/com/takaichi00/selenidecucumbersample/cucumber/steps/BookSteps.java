package com.takaichi00.selenidecucumbersample.cucumber.steps;

import io.cucumber.java.ja.ならば;
import io.cucumber.java.ja.もし;

import java.util.List;
import java.util.Map;

public class BookSteps {

  @もし("トップページにアクセスした")
  public void トップページにアクセスした() {
  }

  @ならば("管理している以下の本の情報を確認することができる")
  public void 管理している以下の本の情報を確認することができる(List<Map<String, String>> dataTable) {
  }
}
