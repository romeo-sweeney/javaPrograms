// Roméo Sweeney
// This program prints out a formatted receipt with given input

import java.util.Scanner;

public class FormatReceipt1 {
	public static void main(String[] args) {
		  
		Scanner sc = new Scanner(System.in);
		  int n = sc.nextInt(); // first int data of input
		  
		  // Reads items
		  String[] items = new String[n];
		  int j = 0;
		  
		  while (j < n) {
			  
			  String s = sc.nextLine();
			  if (s == "") {
				  continue;
			  }else {
				  items[j] = s;
				  j++;
			  }
			  
		  }
		  
		  // Reads item quantities
		  int[]  items_quantity = new int[n];
		  for (int i = 0; i < n; i++) {
		     if (sc.hasNextInt()) {
		        items_quantity[i] = sc.nextInt();
		     }
		  }
		  
		  // Reads price per item
		  double[]  items_price = new double[n];
		  for (int i = 0; i < n; i++) {
		     if (sc.hasNextDouble()) {
		        items_price[i] = sc.nextDouble();
		     }
		  }      
		  sc.close();
		  
		  // Formatted Output & Calculation
		  double total = 0.0;
		  for (int i = 0; i < n; i++) {
		     System.out.printf("%-15s%7.2f\n", items[i], items_price[i] * items_quantity[i]);
		     total += items_price[i] * items_quantity[i];
		  }
		  String line = "------";
		  System.out.printf("%22s\n", line);
		  System.out.printf("%22.2f\n", total);
	}		
}
