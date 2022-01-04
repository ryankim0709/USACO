import java.util.*;
import java.io.*;
public class They_Are_Everywhere {
	public static void main(String[] args) throws IOException{
		/*Basic function: Use the sliding window method to test out possible "windows"
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(br.readLine());
		String sequence = br.readLine();
		HashMap<Character, Integer> required = new HashMap<>();
		
		for(int x = 0; x < length; x++) {
			required.put(sequence.charAt(x), 0);
		}
		
		int left = 0;
		int ans = length;
		
		for(int right = 0; right < length; right ++) {
			
			required.put(sequence.charAt(right), required.get(sequence.charAt(right))+1);
			
			while(is_valid(required) && left <= right) {
				ans = Math.min(ans, right - left + 1);
				//System.out.println("Right: "+right+" Left: "+left);
				required.put(sequence.charAt(left), required.get(sequence.charAt(left))-1);
				left ++;
			}
		}
		System.out.println(ans);
	}
	
	public static boolean is_valid(HashMap<Character, Integer> required) {
		for(int x:required.values()) {
			if(x == 0) {
				return false;
			}
		}
		return true;
	}
}