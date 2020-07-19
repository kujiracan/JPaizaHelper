# PaizaHelper4j
ローカルで作成したソースを編集なしでPaiza上で実行するためのJavaライブラリ

## 使い方
### ローカルでのテスト実行
#### 提出予定のコード例
```Java
package com.example.sample.sample1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			System.out.println(sc.nextLine());
		}
	}

}
```
* Paizaの仕様上クラス名は'Main'である必要があります

#### 実行方法
```Java
PaizaHelper.exec("com.example.sample.sample1.Main", 1, "1 2\naaaa\nbbbb");
```
* 第一引数：実行対象クラスのフルネーム
* 第二引数：実行回数
* 第三引数：実行時標準入力に渡されるテストデータ（文字列）   
`PaizaHelper.exec2`を使用することでテストデータを記載したファイルを渡すことができます

#### 実行結果
```
>>> exec com.example.sample.sample1.Main.main()
args:
1 2
aaaa
bbbb
>>> start
1 2
aaaa
bbbb
>>> done 1 times in 6ms.
```
* `>>> start`から`>>> done {n} times in {t}ms.`の間が出力結果です。


### Paizaへの提出
ローカルでテストしたコードのパッケージ宣言以外をそのまま貼り付けて提出できます。
```Java
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line;
		while(sc.hasNext()) {
			System.out.println(sc.nextLine());
		}
	}

}
```

