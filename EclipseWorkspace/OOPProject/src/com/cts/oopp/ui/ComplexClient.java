package com.cts.oopp.ui;

import com.cts.oopp.model.Complex;

class ComplexClient {

	public static void main(String[] args) {
			Complex first= new Complex(2,-5);
			first.show();
			Complex second= new Complex(2, -5);
			second.show();
			if(first==second)
				System.out.println("Equal"); // The references are compared
			else
				System.out.println("Not Equal");
			
//			if(first.getRealPart()== second.getRealPart() && first.getImaginaryPart()==second.getImaginaryPart())
//				System.out.println("Equal");
//			else
//				System.out.println("Not Equal");
			
			boolean a= first.isEqual(second);
			System.out.println(a);
			
			Complex result= first.add(second);
			result.show();
			Complex third= second; // Object initialization statement
			third.show();
			if(second== third)
				System.out.println("second and third are equal");
			else
				System.out.println("second and third are not equal");
	}

}
