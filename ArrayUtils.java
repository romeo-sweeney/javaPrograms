package javaAssign;

public class ArrayUtils {
		   
	public static int find(int[] a, int lo, int hi, int value) {
		for (int i = lo; i < hi; i++)
			if (a[i] == value)
				return i;
		return -1;
	}
	
	public static int find(int[] a, int value) {
		return find(a, 0, a.length, value);
	}

	public static int count(int[] a, int lo, int hi, int value) {
		int n = 0;
		for (int i = lo; i < hi; i++)
			if (a[i] == value)
				n++;
		return n;
	}
	
	public static int count(int[] a, int value) {
		return count(a, 0, a.length, value);
	}

	public static int minElement(int[] a, int lo, int hi) {
		int minIdx = lo;
		for (int i = lo+1; i < hi; i++)
			if (a[i] < a[minIdx])
				minIdx = i;
		return minIdx;
	}
	
	public static int minElement(int[] a) {
		return minElement(a, 0, a.length);
	}

	public static int maxElement(int[] a, int lo, int hi) {
		int maxIdx = lo;
		for (int i = lo+1; i < hi; i++)
			if (a[i] > a[maxIdx])
				maxIdx = i;
		return maxIdx;
	}
	
	public static int maxElement(int[] a) {
		return maxElement(a, 0, a.length);
	}   
	
	public static boolean anyOf(int a[], int value){
	      for(int i = 0; i < a.length; i++){
	         if(a[i] == value){
	            return true;
	         }
	      }return false;
	   }
   
    public static boolean anyOf(int a[], int lo, int hi, int value){
      for(int i = lo; i < hi; i++){
         if(a[i] == value){
            return true;
         }
      }return false;
   }
   
    public static boolean allOf(int a[], int value){
      for(int i = 0; i < a.length; i++){
         if(a[i] != value){
            return false;
         }
      }return true;
   }
   
    public static boolean allOf(int a[], int lo, int hi, int value){
      for(int i = lo; i < hi; i++){
         if(a[i] != value){
            return false;
         }
      }return true;
   }

    public static boolean noneOf(int a[], int value){
      for(int i = 0; i < a.length; i++){
         if (a[i] == value){
            return false;
         }
      }return true;   
   }
   
    public static boolean noneOf(int a[], int lo, int hi, int value){
      for(int i = lo; i < hi; i++){
         if (a[i] == value){
            return false;
         }
      }return true;   
   }

}

