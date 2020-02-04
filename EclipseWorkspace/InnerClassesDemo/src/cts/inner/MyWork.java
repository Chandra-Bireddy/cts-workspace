package cts.inner;
interface Remote{
	 void doSomething();

	//This method was added later
	 // static void doMore(){
		// System.out.println("Generic doMore...");
	 // }


}

	class MyWork{
	public static void main(String[] args) {
		//	
		Remote ref = new Remote(){
			@Override
			public void doSomething(){
				System.out.println("Inside doSomething...");
			}
		};

		ref.doSomething();

	}
}


// class Another implements Remote{

// 	@Override
// 	public void doSomething(){
// 		System.out.println("Sub's doSomething...");
// 	}

// 	void own(){
// 		System.out.println("Sub's own()...");
// 	}

// }






