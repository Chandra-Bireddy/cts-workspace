package cts.overriding;

interface Furniture{
	void material();
	void dimension();
	void price();
}

class Chair implements Furniture{
	@Override
	public void material() {
		System.out.println("Chair's material is plastic");
	}

	@Override
	public void dimension() {
		// TODO Auto-generated method stub
		System.out.println("Chair's dimension is 20x50");
	}

	@Override
	public void price() {
		// TODO Auto-generated method stub
		System.out.println("The price is 800");
	}
}

class Sofa implements Furniture{

	@Override
	public void material() {
		// TODO Auto-generated method stub
		System.out.println("Sofa's material is Leather");
	}

	@Override
	public void dimension() {
		// TODO Auto-generated method stub
		System.out.println("Sofa's dimension is 30x32x90");
	}

	@Override
	public void price() {
		// TODO Auto-generated method stub
		System.out.println("Sofa's price is 5000");
	}
	public void softness() {
		System.out.println("The softness rating is 9.0");
	}
}

class Table implements Furniture{

	@Override
	public void material() {
		// TODO Auto-generated method stub
		System.out.println("The material of table is wood");
	}

	@Override
	public void dimension() {
		// TODO Auto-generated method stub
		System.out.println("The dimension of table is 190x200x100");
	}

	@Override
	public void price() {
		// TODO Auto-generated method stub
		System.out.println("The price is 3200");
	}
}

public class RuntimePolyDemo {

	public static void main(String[] args) {
		
		Furniture []f = new Furniture[3];
		f[0] = new Chair();
		f[1]= new Sofa();
		f[2] = new Table();
		
		for(Furniture fn:f) {
			fn.material();
			fn.dimension();
			fn.price();
			if(fn instanceof Sofa)
				((Sofa) fn).softness();
		}
		
//		f[0].material();
//		f[0].dimension();
//		f[0].price();
//		f[1].softness();
	}

}
