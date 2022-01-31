// Roméo Sweeney
// ADT that tracks if it's a minimum or maximum value.

import java.util.Scanner;

public class IntTrackMinMax { 
	private int max_int = Integer.MIN_VALUE;
	private int min_int = Integer.MAX_VALUE;
	

	public int getMin() {
		return this.min_int;
	}
	
	public int getMax() {
		return this.max_int;
	}

	public void check(int i) {
		if (i <= this.min_int) {
			this.min_int = i;
		}
		if(i >= this.max_int) {
			this.max_int = i;
		}
	}
	
	public String toString() {
		return String.format("[%d,%d]", this.min_int, this.max_int);
	}
	
	
	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		IntTrackMinMax tmm = new IntTrackMinMax();
		
		while (scnr.hasNext()) {
			tmm.check(scnr.nextInt());
		}scnr.close();
		
		System.out.println("Minimum: " + tmm.getMin());
		System.out.println("Maximum: " + tmm.getMax());
		System.out.println(tmm);
	}
}
