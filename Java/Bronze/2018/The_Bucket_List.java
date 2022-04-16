import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;

public class The_Bucket_List {
	public static void main(String[] args) throws IOException {
		/* SLowest time: 444ms
		 * Time complexity: O(n)
		 * Basic function: We need x buckets from times y -> z for a given 
		 * cow, so we put that into an array representing the time then keep
		 * track of the maximum.
		 */
		int[] buckets = new int[1000000];
		
		int max = 0;
		
		Scanner sc1 = new Scanner(new File("./blist.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("./blist.out")));
		int cows = sc1.nextInt();
		
		int start = 0;//start time for a cow
		int end = 0;//end time for a cow
		int bneeded = 0;//buckets needed
		for(int x = 0; x < cows;x++) {
			sc1.nextLine();
			
			start = sc1.nextInt();
			end = sc1.nextInt();
			bneeded = sc1.nextInt();
			
			for(int y = start; y <= end;y ++) {
				buckets[y] = buckets[y] + bneeded;//add to array
				
				if(buckets[y] > max) {//check if it is the max amount of buckets
					max = buckets[y];
				}
			}
		}
		pw.print(max);
		pw.close();
	}
}
