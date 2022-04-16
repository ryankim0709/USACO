import java.util.*;
import java.io.*;

public class Salem_And_Sticks {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sticks = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] lengths = new int[sticks];
		
		for(int x = 0; x < sticks; x++) {
			lengths[x] = Integer.parseInt(st.nextToken());
		}
		
		int minCost = Integer.MAX_VALUE;
		int minT = 0;
		
		int cost;
		for(int t = 1; t <= 100; t++) {
			cost = 0;
			for(int x:lengths) {
				
				if(x > t) {
					cost = cost + x - t - 1;
				}
				
				if(x < t) {
					cost = cost + t - 1 - x;
				}
			}
			if(cost < minCost) {
				minCost = cost;
				minT = t;
			}
		}
		System.out.println(minT+" "+minCost);
	}
}
