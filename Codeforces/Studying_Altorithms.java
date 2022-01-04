import java.util.*;
import java.io.*;

public class Studying_Altorithms {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int algorithms = Integer.parseInt(st.nextToken());
		int minutes = Integer.parseInt(st.nextToken());
		
		int[] learnTime = new int[algorithms];
		
		st = new StringTokenizer(br.readLine());
		for(int x = 0; x < algorithms; x++) {
			learnTime[x] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(learnTime);
		
		int ans = 0;
		int timeTaken = 0;
		int timeNeeded = 0;
		
		for(int x = 0; x < algorithms; x++) {
			timeNeeded = learnTime[x];
			
			if(timeTaken + timeNeeded <= minutes) {
				timeTaken = timeTaken + timeNeeded;
				ans ++;
			}
		}
		System.out.println(ans);
	}
}
