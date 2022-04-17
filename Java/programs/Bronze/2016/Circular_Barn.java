import java.util.Scanner;
import java.io.File;

public class Circular_Barn {
	public static void main(String args[]) {
		Scanner sc1;
		int[] barns_cappacity = null;
		int length = 0;
		int total_cows = 0;
		
		try {
			sc1 = new Scanner(new File("/Users/youjungkim/DropBox/ryankim/usaco/cbarn_bronze_feb16/10.in"));
			length = sc1.nextInt();
			barns_cappacity = new int[length];
			for (int x = 0; x < length;x++) {
				sc1.nextLine();
				barns_cappacity[x] = sc1.nextInt();
				total_cows = total_cows + barns_cappacity[x];
			}
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		
		int minimum = total_cows * length;
		for (int x = 0; x < length;x++) {
			
			if (find_steps(barns_cappacity,x,total_cows) < minimum) {
				minimum = find_steps(barns_cappacity,x,total_cows);
			}
		}
		System.out.println(minimum);
	}
	public static int find_steps(int[] barns_cappacity,int starting_pos, int total_cows) {
		int length = barns_cappacity.length;
		int cows_left = total_cows;
		int length_walked = 0;
		int pos = 0;
		
		
		for (int x = starting_pos; x < starting_pos + length;x++) {
			if (x >= length) {
				pos = Math.abs(x-length);
			}
			else {
				pos = x;
			}
			if (x != starting_pos) {
				length_walked = length_walked + cows_left;
			}
			cows_left = cows_left - barns_cappacity[pos];
		}
		return length_walked;
	}
}