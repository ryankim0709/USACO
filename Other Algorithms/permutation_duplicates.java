import java.util.*;
import java.io.*;

public class permutation_duplicates {
    public static void main(String[] args) {
        char[] name = { 'R', 'Y', 'A', 'N' };
        int n = name.length;
        findPermutations(name, 0, n);
    }

    public static void findPermutations(char[] str, int index, int n) {
        if (index == n) {
            System.out.println(str);
            return;
        }

        for (int i = index; i < n; i++) {
            if (shouldSwap(str, index, i)) {
                swap(str, index, i);
                findPermutations(str, index + 1, n);
                swap(str, index, i);
            }
        }
    }
    
    public static boolean shouldSwap(char[] str, int first, int last) {
        for (int i = first; i < last; i++) {
            if (str[i] == str[last]) {
                return false;
            }
        }
        return true;
    }

    public static void swap(char[] name, int i, int j) {
        char c = name[i];
        name[i] = name[j];
        name[j] = c;

    }
}
