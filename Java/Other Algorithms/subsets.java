import java.util.*;
import java.io.*;

public class subsets {
    static int[] lst = { 0, 1, 2 };
    static int n = 3;
    static ArrayList<Integer> subset = new ArrayList<>();

    public static void main(String[] args) {
        generate(0);
    }
    
    public static void generate(int k) {
        print();
        if (k == n) {
            return;
        }
        generate(k + 1); // Not added

        subset.add(lst[k]); // Added
        generate(k + 1);
        subset.remove(subset.size() - 1); // Then remove
    }
    
    public static void print() {
        for (int i : subset) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}