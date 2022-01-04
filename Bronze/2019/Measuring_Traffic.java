import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Measuring_Traffic {
	public static void main(String[] args) throws IOException{
		
		/* Slowest time: 500ms
		 * Time complexity: O(2n)
		 * Basic function: We simulate the minimum and maximum traffic for each segment of 
		 * our highway. Note that we must use our functions BACKWARDs when doing the opposite
		 * direction because we have essentially flipped our orientation except for the min's and max's.
		 */
		Scanner sc1 = new Scanner(new File("./traffic.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("./traffic.out")));
		
		int segments = sc1.nextInt();
		
		String[] type = new String[segments];
		int[] first = new int[segments];
		int[] second = new int[segments];
		
		int min = 0;
		int max = 0;
		for(int x = 0; x < segments;x++) {
			sc1.nextLine();
			type[x] = sc1.next();
			first[x] = sc1.nextInt();
			second[x] = sc1.nextInt();
			
			min = min - first[x];
			max = max + second[x];
		}
		
		int[] xy = new int[] {min,max};
		
		for(int x = segments - 1; x >= 0;x --) {//finding traffic prior to mile 1
			if(type[x].equals("on")) {
				off(xy,first[x],second[x]);
			}
			
			else if(type[x].equals("off")) {
				on(xy,first[x],second[x]);
			}
			
			else {
				none(xy,first[x],second[x]);
			}
		}
		pw.println(xy[0]+" "+xy[1]);
		
		xy[0] = min;
		xy[1] = max;
		
		for(int x = 0; x < segments;x ++) {//finding traffic after last mile
			if(type[x].equals("on")) {
				on(xy,first[x],second[x]);
			}
			
			else if(type[x].equals("off")) {
				off(xy,first[x],second[x]);
			}
			
			else {
				none(xy,first[x],second[x]);
			}
		}
		pw.print(xy[0]+" "+xy[1]);
		pw.close();
		
	}
	public static void on(int[] xy, int first, int second) {
		xy[0] = Math.max(0,xy[0] + first);
		xy[1] = Math.max(0,xy[1] + second);
	}
	
	public static void off(int[] xy, int first, int second) {
		xy[0] = Math.max(0, xy[0] - second);
		xy[1] = Math.max(0, xy[1] - first);
	}
	
	public static void none(int[] xy, int first, int second) {
		xy[0] = Math.max(first, xy[0]);
		xy[1] = Math.min(second, xy[1]);
	}
}
