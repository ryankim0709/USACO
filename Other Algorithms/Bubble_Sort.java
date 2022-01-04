import java.util.Scanner;

public class Bubble_Sort {
	public static void main(String args[]) {
		Scanner sc1 = new Scanner(System.in);
		int length = sc1.nextInt();
		int[] a = new int[length];
		
		for(int x = 0; x < length; x++) {
			a[x] = sc1.nextInt();
		}
		System.out.println("Array is sorted in "+swaps(a)+" swaps.");
		System.out.println("First Element: "+a[0]);
		System.out.println("Last Element: "+a[a.length-1]);
		
	}
	
	public static int swaps(int[] a) {
		int n = a.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
		    for (int j = 0; j < n - 1; j++) {
		        // Swap adjacent elements if they are in decreasing order
		        if (a[j] > a[j + 1]) {
		            swap(j, j + 1,a);
		            count ++;
		        }
		    }
		}
		return count;
	}
	public static void swap(int pos_one, int pos_two, int[] a) {
		int one = a[pos_one];
		int two = a[pos_two];
		a[pos_one] = two;
		a[pos_two] = one;
	}
}