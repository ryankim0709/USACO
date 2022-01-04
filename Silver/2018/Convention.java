import java.util.*;
import java.io.*;
public class Convention {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("convention.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("convention.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cows = Integer.parseInt(st.nextToken());
		int buses = Integer.parseInt(st.nextToken());
		int capacity = Integer.parseInt(st.nextToken());
		int[] arrivalTimes = new int[cows];
		st = new StringTokenizer(br.readLine());
		for(int x = 0; x < cows; x++) {
			arrivalTimes[x] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arrivalTimes);

		int low = 0;
		int high = arrivalTimes[cows - 1] - arrivalTimes[0];
		int maxWait;
		while(low < high) {
			maxWait = low + (high - low)/2;
			if(tryTime(arrivalTimes, buses,maxWait,capacity)) {
				high = maxWait;
			}
			else {
				low = maxWait + 1;
			}
		}
		pw.print(low);
		pw.close();
	}
	public static boolean tryTime(int[] arrivalTimes, int buses, int maxWait, int busCapacity) {
		int left = 0;
		int size = arrivalTimes.length;
		/*
		  	1 1 3 4 10 15
		  	            l
		  	            r
		 */
		
		for(int right = 0; right < size; right ++) {
			if(buses < 0) {
				return false;
			}
			if(arrivalTimes[right] - arrivalTimes[left] > maxWait) {
				buses --;
				left = right;
			}
			else if(right - left + 1 >= busCapacity || right == size - 1) {
				buses --;
				left = right + 1;
			}
		}
		return buses >= 0 && left == size;
	}
}
