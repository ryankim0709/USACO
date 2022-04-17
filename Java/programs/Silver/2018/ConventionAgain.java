import java.util.*;
import java.io.*;
public class ConventionAgain {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("convention.in"));
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
		
		for(int x:arrivalTimes) {
			System.out.print(x+" ");
		}
		System.out.println();
		
		System.out.println("Total cows: "+cows+" total buses: "+buses+" bus capacity: "+capacity);
		int low = arrivalTimes[0];
		int high = arrivalTimes[cows - 1];
		int maxWait;
		while(low < high) {
			maxWait = low + (high - low)/2;
			if(tryTime(arrivalTimes, buses,maxWait,capacity)) {
				System.out.println("Low: "+low+" high: "+high+" maxWait: "+maxWait+" result: true");
				high = maxWait;
			}
			else {
				System.out.println("Low: "+low+" high: "+high+" maxWait: "+maxWait+" result: false");
				low = maxWait + 1;
			}
		}
		//System.out.println(tryTime(arrivalTimes, buses, capacity, 4));
		System.out.println(low);
		pw.print(low);
		pw.close();
	}
	public static boolean tryTime(int[] arrivalTimes, int buses, int busCapacity, int maxWait) {
		int loaded = 0;
		int busesUsed = 0;
		int minTime = arrivalTimes[0];
		int currTime;
		int index = 0;
		int size = arrivalTimes.length;
		
		while(busesUsed < buses && index < size - 1) {
			currTime = arrivalTimes[index];
			loaded ++;
			if(currTime - minTime > maxWait) {
				loaded = 0;
				busesUsed ++;
				minTime = arrivalTimes[index + 1];
			}
			if(loaded == busCapacity) {
				loaded = 0;
				busesUsed ++;
				minTime = arrivalTimes[index + 1];
			}
			index ++;
		}
		currTime = arrivalTimes[size - 1];
		loaded ++;
		System.out.println(minTime);
		if(currTime - minTime > maxWait) {
			//System.out.println("Here");
			loaded = 0;
			busesUsed += 2;
		}
		if(loaded == busCapacity) {
			System.out.println("Here");
			loaded = 0;
			busesUsed ++;
		}
		System.out.println(busesUsed);
		if(busesUsed > buses) {
			return false;
		}
		return true;
	}
}
