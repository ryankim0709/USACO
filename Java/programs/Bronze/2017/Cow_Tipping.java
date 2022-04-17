import java.util.*;
import java.io.*;

public class Cow_Tipping {
	public static void main(String[] args) throws IOException{
		
		/*Slowest time: 176 ms
		 * Basic function: We need to tip the bottom, right most cow. Once we scan our 2D array,
		 * we find the rightmost cow by going backwards, and if there is a tipped cow, we flip
		 * from (0,0) to (a,b) over and add one to our counter.
		 */
		BufferedReader br = new BufferedReader(new FileReader("cowtip.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowtip.out")));
		StringTokenizer st = null;
		
		int cows = Integer.parseInt(br.readLine());
		char[][] field = new char[cows][cows];
		
		for(int x = 0; x < cows; x++) {
			field[x] = br.readLine().toCharArray();
		}
		
		int tips = 0;
		for(int x = cows - 1; x >= 0; x--) {
			for(int y = cows - 1; y >= 0; y --) {
				
				if(field[x][y] == '1') {
					tips ++;
					for(int z = x; z >= 0; z--) {
						for(int a = y; a >= 0; a --) {
							if(field[z][a] == '1') {
								field[z][a] = '0';
							}
							
							else {
								field[z][a] = '1';
							}
						}
					}
				}
			}
		}
		//System.out.println(tips);
		pw.print(tips);
		pw.close();
	}
}
