public class BinarySearch {

    /*
    exists - returns true if value is in a[lo,hi), false otherwise

    Parameters:
        a - array to search
        lo - low index of half-open range to search
        hi - high index of half-open range to search
        value - value to search for

     Return value (and postcondition):
        true if the value is in a[lo,hi)
        false if the value is not in a[lo,hi)

     Precondition:
        The array subrange must be sorted.
     */
    public static boolean exists(int[] a, int lo, int hi, int value) {
        int curLo = lo;
        int curHi = hi;

        // Loop invariant:
        //      a[lo,curLo) != value AND a[curHi,hi) != value
        //      trivially true initially
        while (curLo < curHi) {
            int mid = curLo + (curHi - curLo) / 2;
            if (a[mid] == value)
                return true;
            else if (a[mid] < value)
                // Since the array is sorted, we know that a[curLo,mid] < value
                // And therefore a[curLo,mid+1) < value
                curLo = mid + 1;
            else /* a[mid] > value */
                // Since the array is sorted, we know that a[mid,hi) > value
                curHi = mid;
        }

        // We know that a[lo,curLo) != value, and [curHi,hi) != value.
        // But since curLo >= curHi, we know that [lo,hi) != value.
        return false;
    }

    public static boolean exists(int[] a, int value) {
        return exists(a, 0, a.length, value);
    }

    /*
    lowerBound - returns index of first element a[lo,hi)
        greater than or equal to the given vaue

    Parameters:
        a - array to search
        lo - low index of half-open range to search
        hi - high index of half-open range to search
        value - value to search for

     Precondition:
        The array subrange must be sorted.

     Return value:
        Returns the index ret such that
            a[lo,ret) < value
            a[ret,hi) >= value
        If all values in a[lo,hi) < value, hi is returned.
     */
    public static int lowerBound(int[] a, int lo, int hi, int value) {
        int curLo = lo;
        int curHi = hi;

        // Loop invariant:
        //      a[lo,curLo) < value AND a[curHi,hi) >= value
        while (curLo < curHi) {
            int mid = curLo + (curHi - curLo) / 2;
            if (a[mid] < value)
                // Since the array is sorted, we know that a[curLo,mid] < value
                // And therefore a[curLo,mid+1) < value
                curLo = mid + 1;
            else /* a[mid] >= value */
                // Since the array is sorted, we know that a[mid,hi) >= value
                curHi = mid;
        }

        // We know that a[lo,curLo) != value, and [curHi,hi) != value.
        // But since curLo >= curHi, we know that [lo,hi) != value.
        return curLo;
    }

    public static int lowerBound(int[] a, int value) {
        return lowerBound(a, 0, a.length, value);
    }

    /*
    lowerBound - returns index of first element a[lo,hi)
        greater than or equal to the given vaue

    Parameters:
        a - array to search
        lo - low index of half-open range to search
        hi - high index of half-open range to search
        value - value to search for

     Precondition:
        The array subrange must be sorted.

     Return value:
        Returns the index ret such that
            a[lo,ret) < value
            a[ret,hi) >= value
        If all values in a[lo,hi) < value, hi is returned.
     */
    public static int upperBound(int[] a, int lo, int hi, int value) {
        int curLo = lo;
        int curHi = hi;

        // Loop invariant:
        //      a[lo,curLo) <= value AND a[curHi,hi) > value
        while (curLo < curHi) {
            int mid = curLo + (curHi - curLo) / 2;
            if (a[mid] <= value)
                // Since the array is sorted, we know that a[curLo,mid] <= value
                // And therefore a[curLo,mid+1) <= value
                curLo = mid + 1;
            else /* a[mid] > value */
                // Since the array is sorted, we know that a[mid,hi) > value
                curHi = mid;
        }

        // We know that a[lo,curLo) != value, and [curHi,hi) != value.
        // But since curLo >= curHi, we know that [lo,hi) != value.
        return curLo;
    }

    public static int upperBound(int[] a, int value) {
        return upperBound(a, 0, a.length, value);
    }

    private static void testExists() {
        int[] a = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31 };
        int[] b = { -1, 1, 4, 6, 9, 12, 15, 21, 26, 30, 32 };
        for (int value : a)
            assert exists(a, value);
        for (int value : b)
            assert !exists(a, value);
    }

    private static void testLowerBound() {
        int[] a = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31 };
        for (int i = 0; i < a.length; i++)
            assert lowerBound(a, a[i]) == i;
        assert lowerBound(a, -1) == 0;
        assert lowerBound(a,  1) == 0;
        assert lowerBound(a,  4) == 2;
        assert lowerBound(a,  6) == 3;
        assert lowerBound(a,  9) == 4;
        assert lowerBound(a, 12) == 5;
        assert lowerBound(a, 15) == 6;
        assert lowerBound(a, 18) == 7;
        assert lowerBound(a, 21) == 8;
        assert lowerBound(a, 26) == 9;
        assert lowerBound(a, 30) == 10;
        assert lowerBound(a, 32) == 11;
    }

    private static void testUpperBound() {
        int[] a = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31 };
        for (int i = 0; i < a.length; i++)
            assert upperBound(a, a[i]) == i + 1;
        assert upperBound(a, -1) == 0;
        assert upperBound(a,  1) == 0;
        assert upperBound(a,  4) == 2;
        assert upperBound(a,  6) == 3;
        assert upperBound(a,  9) == 4;
        assert upperBound(a, 12) == 5;
        assert upperBound(a, 15) == 6;
        assert upperBound(a, 18) == 7;
        assert upperBound(a, 21) == 8;
        assert upperBound(a, 26) == 9;
        assert upperBound(a, 30) == 10;
        assert upperBound(a, 32) == 11;
    }

    private static boolean checkEA() {
        try {
            assert false;
            return false;
        } catch (AssertionError e) {
            return true;
        }
    }

    public static void main(String[] args) {
    	int[] a = { 11, 11, 11, 14, 15, 18, 18, 19, 20 };
    	System.out.println(BinarySearch.upperBound(a, 25));

    	//
//        if (!checkEA()) {
//            System.out.println("This program needs to be run with the -ea option");
//            return;
//        }
//
//        testExists();
//        testLowerBound();
//        testUpperBound();
//
//        System.out.println("All tests complete.");
    }
}
