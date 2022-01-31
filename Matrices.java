// Roméo Sweeney
// Program that creates two matrices and computes operations.

import java.util.Scanner;

public class Matrices {

	private int[][] a1;
	private int[][] a2;
	private int m;
	private int n;
	
	public Matrices() {
		this.a1 = null;
		this.a2 = null;
		this.m = 0;
		this.n = 0;
	}
	
	public Matrices(int[][] a1, int[][] a2, int m, int n) {
		this.a1 = a1;
		this.a2 = a2;
		this.m = m;
		this.n = n;
	}
	
	public int[][] add() {
		int[][] a = new int[this.m][this.n];
		if (this.a1.length == this.a2.length) {
			for(int i = 0; i < this.m; i++) {
				for(int j = 0; j < this.n; j++) {
					a[i][j] = this.a1[i][j] + this.a2[i][j];
				}
			}
		}
		return a;
	}
	
	public int[][] sub() {
		int[][] a = new int[this.m][this.n];
		if (this.a1.length == this.a2.length) {
			for(int i = 0; i < this.m; i++) {
				for(int j = 0; j < this.n; j++) {
					a[i][j] = this.a1[i][j] - this.a2[i][j];
				}
			}
		}
		return a;
	}
	
	public int[][] mult(){
		int[][] a = new int[this.m][this.n];
		if (this.a1.length == this.a2.length) {
			for (int i = 0; i < this.n; i++) {
				for(int j = 0; j < this.n; j++) {
					for (int k = 0; k < this.n; k++) {
						a[i][j] += (this.a1[i][k] * this.a2[k][j]);
					}
				}
			}
		}
		return a;
	}
	
	


	public static void main(String[] args) {
		
		// matrix size mxn
		int m = 3;
		int n = 3;
		
		// matrix a1
		int a1[][] = {{3, 4, 0}, {1, 3, 8}, {3, 9, 3}};
		
		// matrix a2
		int a2[][] = {{1, 3, 6}, {8, 4, 6}, {3, 8, 2}};
		
		// computed matrix
		int[][] a = new int[m][n];
		
		// matrices object declaration 
		Matrices mtrx1 = new Matrices(a1, a2, m, n); 
		
		System.out.println("Which operation would you like to perform on your matrix? (+, -, *)");
		Scanner scrn = new Scanner(System.in);
		String key = scrn.next();
		scrn.close();
		
		switch(key) {
	
			case "+":
				System.out.println("Matrix Addition");
				a = mtrx1.add();
				Matrices.printMatrix(a, a1, a2, m, n, key);
				break;
				
			case "-":
				System.out.println("Matrix Subtraction");
				a = mtrx1.sub();
				Matrices.printMatrix(a, a1, a2, m, n, key);
				break;
				
			case "*":
				System.out.println("Matrix Multiplication");
				a = mtrx1.mult();
				Matrices.printMatrix(a, a1, a2, m, n, key);
				break;
		}
	}
	
		
	public static void printMatrix(int[][] a, int[][] a1, int[][]a2, int m, int n, String key) {
		// first matrix
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				System.out.printf("%2d ", a1[i][j]);
			}
			System.out.println();
		}
		
		
		System.out.printf("%5s\n", key);
		
		// second matrix
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				System.out.printf("%2d ", a2[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("    =");
		
		// answer
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				System.out.printf("%2d ", a[i][j]);
			}
			System.out.println();
		}
	}
}
