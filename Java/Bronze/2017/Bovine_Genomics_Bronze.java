import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Bovine_Genomics_Bronze {
	public static void main(String[] args) throws IOException {
		/* Slowest time: 413 ms
		 * Basic function: Once we scan, we see if the position can explain spottiness by looking at the genes
		 * in the spotty cows and comparing them to the genes of the plain cows. If the position
		 * does work, we increment to a counter and print.
		 */
		Scanner sc1 = new Scanner(new File("./cownomics.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("./cownomics.out")));
		
		int cows = sc1.nextInt();
		int length = sc1.nextInt();
		
		char[][] spotty = new char[cows][length];
		char[][] plain = new char[cows][length];
		String genomics = "";
			
		for(int x = 0; x < cows; x++) {
			sc1.nextLine();
			genomics = sc1.next();
			for(int y = 0; y < length; y ++) {
				spotty[x][y] = genomics.charAt(y);
			}
		}
		
		for(int x = 0; x < cows; x++) {
			sc1.nextLine();
			genomics = sc1.next();
			for(int y = 0; y < length; y ++) {
				plain[x][y] = genomics.charAt(y);
			}
		}

		char[] plains = new char[cows];
		
		char gene = 'A';
		boolean going = true;
		int possible = 0;
		
		for(int x = 0; x < length; x++) {
			going = true;
			for(int y = 0; y < cows; y++) {
				plains[y] = plain[y][x];
			}
			
			for(int y = 0; y < cows; y++) {
				gene = spotty[y][x];
				
				for(int z = 0; z < cows; z++) {
					if(plains[z] == gene) {
						going = false;
						break;
					}
				}
				if(!going) {
					break;
				}
				else if(y == cows - 1) {
					possible ++;
				}
			}
		}
		pw.print(possible);
		pw.close();
	}
}
