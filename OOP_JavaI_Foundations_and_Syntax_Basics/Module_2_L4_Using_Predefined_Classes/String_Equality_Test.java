public class String_Equality_Test {
	public static void main(String[] args) {
		String x = "test";
		String m = "test";
		String y = new String("test");
		String z = new String("test");

		
		if (x==m) {
			System.out.println("x and m are alias");
		}

		if (x==y) {
			System.out.println("x and y are alias");
		}

		if (x!=y) {
			System.out.println("x and y are not aliases");
		}

		if (y!=z) {
			System.out.println("y and z are not aliases");
		}


	}



}