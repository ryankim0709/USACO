import java.util.Scanner;
import java.io.File;

public class Milk_Pails {
	public static void main(String args[]) {
		Scanner sc1;
		int small_pail = 0;
		int big_pail = 0;
		int goal = 0;
		int greatest_milk = 0;
		
		try {
			sc1 = new Scanner(new File("/pails_bronze_feb16/1.in"));
			small_pail = sc1.nextInt();
			big_pail = sc1.nextInt();
			goal = sc1.nextInt();
		}
		catch(Exception e) {
			e.fillInStackTrace();
		}

		int num_of_big_pails = goal/big_pail;
		int test = 0;
		
		for (int x = 0; x <= num_of_big_pails;x++) {
			test = 0;
			test = test + big_pail*x;
			while(test+small_pail <= goal) {
				test = small_pail + test;
			}
			
			if (test > greatest_milk) {
				greatest_milk = test;
			}
		}
		
		System.out.println(greatest_milk);
	}
}