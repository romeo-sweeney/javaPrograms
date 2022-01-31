// Roméo Sweeney 
//  This program reads an array, and then checks to see how many distinct pairs of numbers in the array add up to a given value.

import java.util.Scanner;

public class TwoSum {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt(); // size of array a
		int[] a = new int[num];
		int count = 0;
		
		// grabbing input and filling into a[]
		for (int i = 0; i < num; i++) {
			a[i] = sc.nextInt();
		}
		
		// target number
		int target = sc.nextInt();
		sc.close();
		
		int inc = 1;
		for (int i = 0; i < num - 1; i++) {
			for (int j = inc; j < num; j++) {
				if ((a[i] + a[j]) == target) {
					++count;
				}
			}++inc;
		}
		System.out.println(count);
	}
}
