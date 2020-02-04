package com.cts.test.ui;

import com.cts.test.model.Swap;

public class SwapClient extends Swap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=4, j=6;
		Integer a= new Integer(i);
		Integer b= new Integer(j);
		System.out.println("a:"+a+" b:"+b);
//		Integer i= new Integer(a);
//		Integer j= new Integer(b);
		swap(a,b);
		System.out.println("a:"+a+" b:"+b);
	}

}
