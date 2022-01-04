import java.util.*;
import java.io.*;
public class Cow_Dance_Show {
	public static void main(String[] args) throws IOException{
		/* Slowest time: 2067 ms
		 * Basic function: We binary search through the possible k's and we simulate with 
		 * a given k. Brute force where we try every number would take O(n^2) while
		 * this one takes O(nlogn * n)
		 */
		//scanning
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("cowdance.in"));
		//BufferedReader br = new BufferedReader(new FileReader("/Users/youjungkim/DropBox/ryankim/USACO_Silver_1/cowdance_silver_jan17/1.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowdance.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cows = Integer.parseInt(st.nextToken());
		int maxTime = Integer.parseInt(st.nextToken());
		int[] times = new int[cows];
		
		for(int x = 0; x < cows; x++) {
			times[x] = Integer.parseInt(br.readLine());
		}
		//algorithm start
		int low = 1;
		int high = cows;
		int nextInt;
		boolean time;
		while(low <= high) {
			nextInt = nextInt(high, low);
			time = search(times, maxTime, nextInt);
			if(!time) {
				low = nextInt + 1;
			}
			else {
				high = nextInt - 1;
			}
		}
		pw.print(low);
		pw.close();
	}
	public static int nextInt(int high, int low) {
		return low + (high-low)/2;
	}
	
	public static boolean search(int[] times, int maxTime, int k) {
		//setting
		int[] firstK = new int[k];
		//first k array
		int len = times.length;
		for(int x = 0; x < k; x++) {
			firstK[x] = times[x];
		}
		Arrays.sort(firstK);
		//for loop from k
		for(int x = k; x < len; x++) {
			firstK[0] += times[x];
			Arrays.sort(firstK);
			if(firstK[k-1] > maxTime) {
				return false;
			}
			
		}
		return true;
	}
}
