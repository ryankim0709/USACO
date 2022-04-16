import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class Diamod_Collector {
	public static void main(String args[]) {
		Scanner sc1;
		ArrayList<Integer> diamond_sizes = new ArrayList<>();
		int vary = 0;
		int length = 0;
		
		try {
			sc1 = new Scanner(new File("/diamond_bronze_open16/4.in")); //5 7 8
			length = sc1.nextInt();
			vary = sc1.nextInt();
			
			for(int x = 0;x < length;x++) {
				sc1.nextLine();
				diamond_sizes.add(sc1.nextInt());
			}
		}
		catch (Exception e) {
			e.getStackTrace();
		}
		
		Collections.sort(diamond_sizes);

		int test_num = 0;
		int count = 0;
		int max = 0;
		
		for (int x = 0; x < length;x++) {
			test_num = diamond_sizes.get(x);
			count = 0;
			for (int y = x; y < length; y++) {
				if (Math.abs(test_num - diamond_sizes.get(y)) <= vary) {
					count ++;
				}
			}
			if (count > max) {
				max = count;
			}
		}
		
		System.out.println(max);
	}
}