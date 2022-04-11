import java.util.Scanner;

public class Scanner_test {
	public static void main(String[] args) {
		System.out.print("Enter integer: ");
		Scanner input = new Scanner(System.in);
		//int test = input.nextInt();
		input.nextLine(); //clean up a newline character at the end of the last user input (note: This line of code can only clean up ONE newline character)
		System.out.print("Enter a line of sentence: ");
		String test1 = input.nextLine();
		System.out.println("Output: "+test1);
	}
}
