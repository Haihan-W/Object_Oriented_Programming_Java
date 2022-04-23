public class test_overload {
	public static void main(String[] args) {
        sum(1 , 2.0);
        sum(2.0 , 1);

    }

	static void sum(int a, double b){System.out.println(a);}
	static void sum(double a, int b){System.out.println(a);}


}
