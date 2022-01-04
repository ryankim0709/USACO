import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class Why_Did_The_Cow_Cross_The_Road_II {
	public static void main(String args[]) {
		Scanner sc1;
		String cows_order = null;
		char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		
		try {
			sc1 = new Scanner(new File("/Users/youjungkim/DropBox/ryankim/usaco/circlecross_bronze_feb17/3.in"));
			cows_order = sc1.nextLine();
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		
		int count = 0;
		for (int x = 0; x < 25;x++) {
			for (int y = x+1; y < 26; y++) {
				char first = alphabet[x];
				char second = alphabet[y];
				if (is_crossing(first,second,cows_order)) {
					count ++;
				}
			}
		}
		System.out.println(count);
	}
	
	public static boolean is_crossing(char first, char second,String cows_order) {
		
		int test_first = cows_order.indexOf(first);
		int test_second = cows_order.indexOf(second);
		int first_end = 0;
		int last_start = 0;
		int last_end = 0;
		
		if (test_first < test_second) {
			first_end = cows_order.lastIndexOf(first);
			last_start = cows_order.indexOf(second);
			last_end = cows_order.lastIndexOf(second);
		}
		else {
			first_end = cows_order.lastIndexOf(second);
			last_start = cows_order.indexOf(first);
			last_end = cows_order.lastIndexOf(first);
		}
		
		if (first_end > last_start && first_end < last_end) {
			return true;
		}
		return false;
	}
}