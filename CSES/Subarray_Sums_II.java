import java.util.*;
import java.io.*;

public class Subarray_Sums_II {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken());
		HashMap<Long,Integer> frequency = new HashMap<>();
		frequency.put((long) 0,1);
		long sum = 0;
		
		st = new StringTokenizer(br.readLine());
		long ans = 0;
		for(int x = 0; x < size; x++) {
			sum = sum + Integer.parseInt(st.nextToken());
			
			if(frequency.containsKey((sum-size)%size)) {
				ans = ans + frequency.get((sum-size)%size);
			}
			
			if(frequency.containsKey(sum)) {
				frequency.put(sum, frequency.get(sum)+1);
			}
			else {
				frequency.put(sum, 1);
			}
		}
		System.out.println(ans);
	}
}
