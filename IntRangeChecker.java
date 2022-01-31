package javaAssign;

import java.util.Scanner;

public class IntRangeChecker {
	private int lo;
	private int hi;
	
	
	// Constructors 
	public IntRangeChecker() {
		this.lo = 0;
		this.hi = 0; 
	}
	
	public IntRangeChecker(int lo, int hi) {
		this.lo = lo;
		this.hi = hi;
	}
	
	// Instance Methods
	public boolean check(int i) {
		for(int rg = this.lo; rg < this.hi; rg++) {
			if(rg == i) {
				return true;
			}
		}return false;
	}
	
	
	public String toString() {
		return String.format("[%d,%d)", this.lo, this.hi);
	}


	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);
		int lo = scnr.nextInt();
		int hi = scnr.nextInt();
	
		IntRangeChecker rc = new IntRangeChecker(lo, hi);
		System.out.println(rc);
				
		while (scnr.hasNext()) {
			int i = scnr.nextInt();
			System.out.println(rc.check(i));
		}
	}
}
