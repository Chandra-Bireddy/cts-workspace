package com.cts.collections.ui;

import java.util.Iterator;
import java.util.Vector;

public class VectorClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<String> v = new Vector<>();
		v.add("Dipesh");
		v.add("Tapas");
		v.add("Akash");
		v.add("Ravi");
		v.add("Manas");
		
		Iterator<String> it = v.iterator();
		while(it.hasNext())
			System.out.println(it.next());
	}

}
