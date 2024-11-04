package sorting;

import java.util.Collections;
import java.util.Comparator;

public class Insertion {

    // This class should not be instantiated.
    private Insertion() {
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     *
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    /**
     * Rearranges the subarray a[lo..hi) in ascending order, using a comparator.
     * @param a the array
     * @param lo left endpoint (inclusive)
     * @param hi right endpoint (exclusive)
     * @param comparator the comparator specifying the order
     */
    public static void sort(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i < hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    /**
     * Rearranges the array in ascending order, using a comparator.
     *
     * @param a the array
     * @param comparator the comparator specifying the order
     */
    public static void sort(Object[] a, Comparator comparator) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1], comparator); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    /**
     * Rearranges the subarray a[lo..hi) in ascending order, using a comparator.
     *
     * @param a the array
     * @param lo left endpoint (inclusive)
     * @param hi right endpoint (exclusive)
     * @param comparator the comparator specifying the order
     */
    public static void sort(Object[] a, int lo, int hi, Comparator comparator) {
        for (int i = lo + 1; i < hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1], comparator); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    /**
     * *************************************************************************
     * Helper sorting functions.
    **************************************************************************
     */
    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // is v < w ?
    private static boolean less(Object v, Object w, Comparator comparator) {
        return comparator.compare(v, w) < 0;
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // exchange a[i] and a[j]  (for indirect sort)
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    /**
     * Reads in a sequence of strings from standard input; insertion sorts them;
     * and prints them to standard output in ascending order.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        String[] a = new String[5];
        a[0] = "1";
        a[1] = "2";
        a[2] = "3";
        a[3] = "4";
        a[4] = "5";
        Insertion.sort(a);
        show(a);
        System.out.println("");
        
        a[0] = "1";
        a[1] = "2";
        a[2] = "3";
        a[3] = "4";
        a[4] = "5";
        Insertion.sort(a, 1, 4);
        show(a);
        System.out.println("");
        
        a[0] = "1";
        a[1] = "2";
        a[2] = "3";
        a[3] = "4";
        a[4] = "5";
        Insertion.sort(a, new SpecifyingOrder());
        show(a);
        System.out.println("");
        
        a[0] = "1";
        a[1] = "2";
        a[2] = "3";
        a[3] = "4";
        a[4] = "5";
        Insertion.sort(a, 1, 4, Collections.reverseOrder());
        show(a);
        
        
        
    }

    static class SpecifyingOrder implements Comparator<String> {

        public int compare(String a, String b) {
            return b.compareTo(a);                 // descending 
        }
    }
}
