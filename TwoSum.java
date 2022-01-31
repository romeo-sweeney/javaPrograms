import java.util.Scanner;

// 10
// 1    5   -3  -8  1   -7  4   9   4   -9
// 6
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
