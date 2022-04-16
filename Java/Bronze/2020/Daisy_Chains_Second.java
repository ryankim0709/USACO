import java.util.Scanner;
import java.io.File;

public class Daisy_Chains_Second {
	public static void main(String args[]) {
		Scanner sc1;
		int[] daisy_petals = null;
		int length = 0;
		
		try {
			sc1 = new Scanner(new File("/Users/youjungkim/DropBox/ryankim/usaco/prob2_bronze_dec20/1.in"));
			length = sc1.nextInt();
			sc1.nextLine();
			daisy_petals = new int[length];
			for (int x = 0; x < length;x++) {
				daisy_petals[x] = sc1.nextInt();
			}
		}
		catch (Exception e) {
			e.getStackTrace();
		}
		
		int count = 0;
		for (int x = 0; x < length;x++) {
			for (int y = x; y < length;y++) {
				if (check_average(x,y,daisy_petals)) {
					count ++;
				}	
			}
		}
		System.out.println(count);
	}
	
	public static boolean check_average(int start,int end, int[] flower_petals) {
		double average = 0;
		for (int x = start; x <= end;x++) {
			average = average + flower_petals[x];
		}
		average = average/(end - start + 1);
		
		for (int x = start; x <= end;x++) {
			if (flower_petals[x] == average) {
				return true;
			}
		}
		return false;
	}
}