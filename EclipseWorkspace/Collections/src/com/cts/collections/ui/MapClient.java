package com.cts.collections.ui;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapClient {

	public static void main(String[] args) {
		Map<String,String> hm = new HashMap<>();
		hm.put("java","Language");
		hm.put("dotnet","Framework");
		hm.put("C#","Language");
		for(String key: hm.keySet())
			System.out.printf("%s : %s\n",key, hm.get(key));
		System.out.println("--------------------------------");
		
		Map<String, String> lm = new LinkedHashMap<>();
		lm.put("java","Language");
		lm.put("dotnet","Framework");
		lm.put("C#","Language");
		for(String key: lm.keySet())
			System.out.printf("%s : %s\n",key, lm.get(key));
		System.out.println("--------------------------------");
		
		Map<String, String> tm = new TreeMap<>();
		tm.put("java","Language");
		tm.put("dotnet","Framework");
		tm.put("C#","Language");
		for(String key: tm.keySet())
			System.out.printf("%s : %s\n",key, tm.get(key));
		System.out.println("--------------------------------");
	}

}
