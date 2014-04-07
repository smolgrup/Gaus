import java.util.Scanner;

public class Gaus {

	double[][] A;
	double[] b;
	int n;

	public Gaus(int n) {

		this.n = n;
		A = new double[n][n]; // Basic matrix
		b = new double[n]; // Free coefficient
		System.out
				.print("Input the basic matrix, press enter after each number \n");
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {

				A[i][j] = sc.nextDouble();

			}

		}

		System.out
				.print("Input free coefficient in line, press enter after each number \n");

		for (int i = 0; i < n; i++) {
			b[i] = sc.nextDouble();
		}

	}

	public void writeMatrix() {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				System.out.print(A[i][j] + " ");

			}
			System.out.print("| " + b[i] + "\n");

		}
		System.out.println();
	}

	public void solve() {
		// direct flow
		for (int k = 0; k < n; k++) {
			for (int j = k + 1; j < n; j++) {

				A[k][j] = A[k][j] / A[k][k];
			}
			b[k] = b[k] / A[k][k];
			A[k][k] = 1;
			for (int i = k + 1; i < n; i++) {
				for (int j = k + 1; j < n; j++)
					A[i][j] = A[i][j] - A[i][k] * A[k][j];
				b[i] = b[i] - A[i][k] * b[k];
				A[i][k] = 0;
			}

		}
		System.out.print("Your set of equations after  transformations: \n");
		writeMatrix();
		System.out.println();
		// reverse flow

		for (int i = n - 1; i >= 0; i--) {
			for (int j = n - 1; j >= i + 1; j--) {
				b[i] = b[i] - A[i][j] * b[j];
				A[i][j] = 0;
			}
		}
		// answer
		System.out.println("Roots are: \n");
		for (int i = 0; i < n; i++) {
			System.out.println("X" + i + " = " + b[i]);
		}

	}

}
