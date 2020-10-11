# language: ja

@Developing
機能: Google検索をすることができる

  背景: Googleのトップページにアクセスしている
    前提www.google.comを開いている

  シナリオアウトライン: Googleで文字の意味を検索することができる
    もし検索欄に<検索文字>を入力した
    かつ検索を実行した
    ならば検索結果が表示されること
  例:
    | 検索文字 |
    | "こんにちは" |
    | "さようなら" |

  シナリオ: Googleのinformationを確認することができる
    もしGoogleについてをクリックした
    ならばGoogleの使命が表示される
