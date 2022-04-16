
import java.util.Scanner;
import java.io.File;

public class Mixing_Milk {
	public static void main(String args[]) {
		int[] bucket_a = new int[2];
		int[] bucket_b = new int[2];
		int[] bucket_c = new int[2];
		int count = 0;
		Scanner sc1;
		
		try {
			sc1 = new Scanner(new File("/Users/youjungkim/DropBox/ryankim/usaco/mixmilk_bronze_dec18/6.in"));
			
			while (sc1.hasNext()) {
				if (count == 0) {
					bucket_a[0] = sc1.nextInt();
					bucket_a[1] = sc1.nextInt();
					count ++;
				}
				else if (count == 1) {
					bucket_b[0] = sc1.nextInt();
					bucket_b[1] = sc1.nextInt();
					count ++;
				}
				else if (count == 2) {
					bucket_c[0] = sc1.nextInt();
					bucket_c[1] = sc1.nextInt();
					count ++;
				}
				sc1.nextLine();
			}
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		
		boolean one_two = true;
		boolean two_three = false;
		boolean three_one = false;
		int amount = 0;
		for (int x = 0; x < 100;x++) {
			
			if (one_two) {
				amount = pour_amount(bucket_a,bucket_b);
				one_two = false;
				two_three = true;
				bucket_a[1] = bucket_a[1] - amount;
				bucket_b[1] = bucket_b[1] + amount;
			}
			else if (two_three) {
				amount = pour_amount(bucket_b,bucket_c);
				two_three = false;
				three_one = true;
				bucket_b[1] = bucket_b[1] - amount;
				bucket_c[1] = bucket_c[1] + amount;
				
			}
			else if (three_one) {
				amount = pour_amount(bucket_c,bucket_a);
				three_one = false;
				one_two = true;
				bucket_c[1] = bucket_c[1] - amount;
				bucket_a[1] = bucket_a[1] + amount;
				
			}
		}
		System.out.println(bucket_a[1]);
		System.out.println(bucket_b[1]);
		System.out.println(bucket_c[1]);
	}
	public static int pour_amount(int[] bucket_a, int[] bucket_b) {
		int pour = bucket_b[0] - bucket_b[1];
		if (bucket_a[1] < pour) {
			pour = bucket_a[1];
		}
		return pour;
	}
}