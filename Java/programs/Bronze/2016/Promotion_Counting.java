import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Promotion_Counting {
	public static void main(String args[]) {
		try {
			//Scanner sc1 = new Scanner(new File("/Users/youjungkim/DropBox/ryankim/usaco/promote_bronze_jan16/4.in"));
			Scanner sc1 = new Scanner(new File("./promote.in"));
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("./promote.out")));
			int[] bronze = new int[2];
			int[] silver = new int[2];
			int[] gold = new int[2];
			int[] platinum = new int[2];
			int bronze_to_silver = 0;
			int silver_to_gold = 0;
			int gold_to_platinum = 0;
			bronze[0] = sc1.nextInt();
			bronze[1] = sc1.nextInt();
			silver[0] = sc1.nextInt();
			silver[1] = sc1.nextInt();
			gold[0] = sc1.nextInt();
			gold[1] = sc1.nextInt();
			platinum[0] = sc1.nextInt();
			platinum[1] = sc1.nextInt();
			
			gold_to_platinum += platinum[1] - platinum[0];
			silver_to_gold = (gold_to_platinum + gold[1]) - gold[0];
			bronze_to_silver = (silver_to_gold + silver[1]) - silver[0];
			
			pw.println(bronze_to_silver);
			pw.println(silver_to_gold);
			pw.println(gold_to_platinum);
			pw.close();
			//System.out.println(bronze_to_silver);
			//System.out.println(silver_to_gold);
			//System.out.println(gold_to_platinum);
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}
}