import java.util.*;
import java.io.*;
public class Subarray_Sums {
	public static void main(String[] agrs) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int nums = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		HashMap<Integer,Integer> occured = new HashMap<>();
		occured.put(0, 1);
		
		int sum = 0;
		int ans = 0;
		st = new StringTokenizer(br.readLine());
		for(int x = 0; x < nums; x++) {
			sum = sum + Integer.parseInt(st.nextToken());
			if(occured.containsKey(sum-target)) {
				ans = ans + occured.get(sum-target);
			}
			
			if(occured.containsKey(sum)) {
				occured.put(sum,occured.get(sum)+1);
			}
			else {
				occured.put(sum, 1);
			}
		}
		System.out.println(ans);
	}
}
