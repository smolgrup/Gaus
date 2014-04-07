import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		System.out.print("Input n \n");
		Scanner sc = new Scanner(System.in);
		Gaus test = new Gaus(sc.nextInt());

		System.out.print("Your set of equations is: \n");
		test.writeMatrix();
		test.solve();
		

	}

}
