import java.util.*;
import java.io.*;

public class Sum_of_Three_Values {
	public static void main(String args[]) throws IOException{
		/*We choose 2 distinct numbers then check if we have target - num1 - num2 in our 
		 * dictionary. If we do, we have to make sure that number 3(z) != x and z !=y,
		 * or else it's a duplicate. We add going to reduce the number of computations.
		 * Passes 100%.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int elements = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		int[] nums = new int[elements];
		HashMap<Integer,Integer> nums2 = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		int z;
		for(int x = 0; x < elements; x++) {
			z = Integer.parseInt(st.nextToken());
			nums[x] = z;
			nums2.put(z, x);
		}
		int num1;
		int num2;
		int tar;
		int index = 0;
		boolean going = true;
		for(int x = 0; x < elements; x ++) {
			if(!going) {
				break;
			}
			num1 = nums[x];
			tar = target - num1;
			for(int y = 0; y < elements; y++) {
				if(y == x) {
					continue;
				}
				else {
					num2 = nums[y];
					index = tar - num2;
					if(nums2.containsKey(index)) {
						
						if(!(x == nums2.get(index) || y == nums2.get(index))) {
							System.out.println((x+1)+" "+(y+1)+" "+(nums2.get(index)+1));
							going = false;
							break;
						}
						
					}
				}
			}
		}
		if(going) {
			System.out.println("IMPOSSIBLE");
		}
	}
}
