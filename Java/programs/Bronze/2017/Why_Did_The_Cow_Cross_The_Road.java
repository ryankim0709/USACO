import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Why_Did_The_Cow_Cross_The_Road {
	public static void main(String args[]) throws IOException {
		//Scanner sc1 = new Scanner(new File("/crossroad_bronze_feb17/1.in"));
		Scanner sc1 = new Scanner(new File("./crossroad.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("./crossroad.out")));
		
		int[] cows = new int[10];
		for(int x = 0; x < 10;x++) {
			cows[x] = -1;
		}
		
		int length = sc1.nextInt();
		int count = 0;
		for(int x = 0; x < length;x++) {
			int cow = sc1.nextInt() - 1;
			int road = sc1.nextInt();
			
			if(cows[cow] == -1) {
				cows[cow] = road;
			}
			else if(cows[cow] == 1 && road == 0) {
				count ++;
				cows[cow] = 0;
			}
			else if(cows[cow] == 0 && road == 1) {
				count ++;
				cows[cow] = 1;
			}
		}
		pw.println(count);
		pw.close();
	}
}