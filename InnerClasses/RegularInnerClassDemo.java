

	// - Regular Inner Classes
	   - Method Local Inner Classes



	public class RegularInnerClassDemo{

		private int var;

		// private char ch;

		static void met(){
			//CEO doesnt exist
			RegularInnerClassDemo.Inner in = new RegularInnerClassDemo().new Inner();
			in.work();

		}

		
		class Inner{
			int var;
			void work(){
				int var = 60;
				System.out.println("Inside Inner's work..., var = " + var);
				System.out.println("Instance var = " + this.var);
				System.out.println("Outer Instance var = " + RegularInnerClassDemo.this.var);
			}
		}

		public static void main(String[] args) {
			new RegularInnerClassDemo().met(); //RegularInnerClassDemo.met();


		}

	}





