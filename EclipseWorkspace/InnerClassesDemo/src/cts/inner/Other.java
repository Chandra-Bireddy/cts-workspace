package cts.inner;
class Other{
	public static void main(String[] args) {
		//Creating an object of the inner class 
		// from somewhere the outer class

		//RegularInnerClassDemo out = new RegularInnerClassDemo();
		RegularInnerClassDemo.Inner in = new RegularInnerClassDemo().new Inner();

		in.work(); 
	}
}