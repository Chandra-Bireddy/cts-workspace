package cts.overloading;

class Some{
	void work(Object val){
		System.out.println("Object");
	}

	void work(int val){
		System.out.println("long");
}
}

class OverloadRevisit{
	public static void main(String[] args) {
		short b=5;
		Short a=b;
		System.out.println(a);
		byte var = 9;

		new Some().work(var);


	}
}


 // byte -> Byte -> Long
 // byte -> Byte -> Object

	


