package net.kujiracan.paiza.common;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.lang.reflect.Method;

public abstract class PaizaHelper {

	/***
	 * 指定したクラスを実行する（直接文字列渡し）
	 * @param className クラスのフルネーム
	 * @param tryNum 実行回数
	 * @param inputString 標準入力から渡す文字列
	 */
	public static void exec(String className, int tryNum, String inputString) {
		try {
			System.out.printf(">>> exec %s.main()\n", className);
			System.out.println("args:");
			System.out.println(inputString);
			System.out.printf(">>> start\n");
			Class<? extends Object> clazz = Class.forName(className);

			//Method m = clazz.getMethod(methodName, String[].class);
			Method m = clazz.getDeclaredMethod("main", String[].class);

			long startTime = System.currentTimeMillis();
			for(int i = 0; i < tryNum; i++) {
				System.setIn(new ByteArrayInputStream(inputString.getBytes()));
				m.invoke(null, (Object)new String[]{});
			}
			long endTime = System.currentTimeMillis();
			System.out.printf(">>> done %d times in %dms.\n", tryNum, endTime - startTime);
		} catch(Throwable t) {
			t.printStackTrace();
		}
	}

	/***
	 * 指定したクラスを実行する（ファイル指定）
	 * @param className クラスのフルネーム
	 * @param tryNum 実行回数
	 * @param inputString 標準入力から渡す文字列を記載したファイルのフルパス
	 */
	public static void exec2(String className, int tryNum, String filePath) {
		StringBuilder sb = new StringBuilder();
		try(BufferedReader r = new BufferedReader(new FileReader(filePath))) {
			String line;
			while((line = r.readLine()) != null) {
				sb.append(r).append("\n");
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		sb.setLength(Integer.max(0, sb.length() - 1));

		exec(className, tryNum, sb.toString());
	}
}
