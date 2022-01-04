import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Subsequences_summing_to_sevens {
	public static void main(String[] args) throws IOException {
		//Scanner sc1 = new Scanner(new File("/Users/youjungkim/DropBox/ryankim/USACO_Silver_1/div7_silver_jan16/10.in"));
		Scanner sc1 = new Scanner(new File("./div7.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("./div7.out")));
		
		int cows = sc1.nextInt();
		//int[] cow = new int[cows+1];
		//cow[0] = 0;
		int sum = 0;
		String cow = "";
		for(int x = 1; x <= cows;x++) {
			sum = sum + sc1.nextInt();
			sum = sum % 7;
			
			cow = cow + " "+sum;
		}
		int length = 0;
		int max = 0;
		for(int x = 6; x >= 1;x--) {
			//System.out.println(x);
			length = ((cow.lastIndexOf(String.valueOf(x))-1)/2) - ((cow.indexOf(String.valueOf(x))-1)/2);
			//System.out.println("Looking for: "+x+" First Index: "+cow.indexOf(String.valueOf(x))+" Last Index "+cow.lastIndexOf(String.valueOf(x)));
			
			if(length > max) {
				max = length;
			}
		}
		//System.out.println(max);
		pw.print(max);
		pw.close();

	}
}
