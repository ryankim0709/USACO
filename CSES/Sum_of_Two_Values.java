import java.util.*;
import java.io.*;

public class Sum_of_Two_Values {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int numbers = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());

		HashMap<Integer,Integer> nums = new HashMap<>();
		int count = 0;
		
		int num = 0;
		for(int x = 0; x < numbers; x++) {
			num = Integer.parseInt(st.nextToken());
			
			if(nums.keySet().contains(target-num)) {
				System.out.println(x + " "+nums.get(target - num));
				count ++;
			}
			else {
				nums.put(num, x);
			}
		}
		if(count == 0) {
			System.out.println("IMPOSSIBLE");
		}
	}

}
