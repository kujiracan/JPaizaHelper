package com.example.sample;

import net.kujiracan.paiza.common.PaizaHelper;

public class EntryPoiont {

	public static void main(String[] args) {
		PaizaHelper.exec("com.example.sample.sample1.Main", 1, "1 2\naaaa\nbbbb");
		PaizaHelper.exec2("com.example.sample.sample1.Main", 1, "D:\\data.txt");
	}

}
