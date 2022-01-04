import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Teleportation {
	public static void main(String args[]) {
		try {
			int[] teleporter = new int[2];
			int[] FJ = new int[2];
			
			Scanner sc1 = new Scanner(new File("./teleport.in"));
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("./teleport.out")));
			FJ[0] = sc1.nextInt();
			FJ[1] = sc1.nextInt();
			teleporter[0] = sc1.nextInt();
			teleporter[1] = sc1.nextInt();
			Arrays.sort(FJ);
			Arrays.sort(teleporter);
			if(FJ[1] - FJ[0] < find_dist(FJ,teleporter)) {
				pw.print(Math.abs(FJ[0] - FJ[1]));
				pw.close();
			}
			else {
				pw.print(find_dist(teleporter,FJ));
				pw.close();
			}
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}
	public static int find_dist(int[] teleporter, int[]FJ) {
		int one = Math.abs(teleporter[0] - FJ[0]);
		int two = Math.abs(teleporter[1] - FJ[1]);
		return one + two;
	}
}