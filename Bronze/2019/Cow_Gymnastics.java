import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class Cow_Gymnastics {
	public static void main(String args[]) {
		Scanner sc1;
		ArrayList<int[]> test_scores = new ArrayList<>();
		int[] test_rate = null;
		int tests = 0;
		int cows = 0;
		
		try {
			sc1 = new Scanner(new File("/Users/youjungkim/DropBox/ryankim/usaco/gymnastics_bronze_dec19/10.in"));
			tests = sc1.nextInt();
			cows = sc1.nextInt();
			test_rate = new int[cows];
			for (int x = 0;x <= tests;x++) {
				sc1.nextLine();
				if(x != 0) {
					test_scores.add(test_rate.clone());
				}
				for (int y = 0; y < cows;y++) {
					test_rate[y] = sc1.nextInt();
				}
			}
			
		}
		catch(Exception e) {
			e.getStackTrace();
		}

		int count = 0;
		for (int x = 0; x < cows - 1;x++) {
			for (int y = x + 1; y < cows;y++) {
				if (check(test_scores.get(0)[x],test_scores.get(0)[y],test_scores,cows)) {
					count ++;
				}
			}
		}
		System.out.println(count);
	}
	
	public static boolean check(int x, int y,ArrayList<int[]> test_scores,int length) {
		int size = test_scores.size();
		boolean found_x = false;
		for (int a = 0;a < size;a++) {
			found_x = false;
			
			for(int b = 0; b < length;b ++) {
				if(test_scores.get(a)[b] == y && found_x == false) {
					return false;
				}
				if (test_scores.get(a)[b] == x) {
					break;
				}
			}
		}
		return true;
	}
}