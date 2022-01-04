import java.util.*;
import java.io.*;

public class Grass_Planting {
	public static void main(String[] args) throws IOException{
		/*Slowest time:648ms
		 * Time Complexity: O(n)
		 * Basic function: We want to find the minimum number of grass that FJ uses.
		 * The place where FJ will be forced to use different grass types is when
		 * there are n paths to field a. If there are n paths to a, you will need
		 * a different grass type for each n paths plus another type for a. So, we find
		 * the field with most connections then add one.
		 */
		
		BufferedReader br = new BufferedReader(new FileReader("planting.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("planting.out")));
		StringTokenizer st = null;
		
		int fields = Integer.parseInt(br.readLine());
		int[] pathsPerField = new int[fields];
		int num = 0;
		int min = 0;
		
		for(int x = 0; x < fields-1; x++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			pathsPerField[num-1] ++;
			min = Math.max(min, pathsPerField[num-1]);
			num = Integer.parseInt(st.nextToken());
			pathsPerField[num-1] ++;
			min = Math.max(min, pathsPerField[num-1]);
		}
		pw.print(min + 1);
		pw.close();
	}
}
