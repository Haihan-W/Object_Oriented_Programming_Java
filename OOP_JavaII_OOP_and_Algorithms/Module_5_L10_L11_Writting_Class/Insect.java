public class Insect {
	
	//instance variables
	private double weight;
	private int x;
	private int y;


	//static constants/variables
	private static int population;


	//constructor
	public Insect(double initWeight, int initX, int initY) {
		weight = initWeight;
		x = initX;
		y = initY;
		population = 0;
		population++;

	}

	//methods
	public static void main(String[] args) {

		System.out.println("Insect Population: " + population);
		Insect bug1 = new Insect(10,100,90);
		System.out.println("Insect Population: " + population);
		Insect bug2 = new Insect(9.5,-300,400);
		System.out.println("Insect Population: " + population);
		Insect bug3 = new Insect(9.8,300,500);
		System.out.println("Insect Population: " + population);
		

	}  



	
}