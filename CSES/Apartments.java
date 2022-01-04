import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class Apartments {
	public static void main(String args[]) {
		Scanner sc1 = new Scanner(System.in);
		int[] desired = null;
		TreeMap<Integer,Integer> sizes = new TreeMap<>();
		
		int applicants = sc1.nextInt();
		int apartments = sc1.nextInt();
		int min_diff = sc1.nextInt();
		desired = new int[applicants];
		for(int x = 0; x < applicants;x++) {
			int num = sc1.nextInt();
			desired[x] = num;
		}
		for(int x = 0; x < apartments;x++) {
			int num = sc1.nextInt();
			if(sizes.containsKey(num)) {
				sizes.put(num, sizes.get(num) + 1);
			}
			else {
				sizes.put(num, 1);
			}
		}
		Arrays.sort(desired);
		int count = 0;
		
		for(int x = desired.length - 1; x >= 0; x --) {
			int num = desired[x];
			int min = num - min_diff;
			int max = num + min_diff+1;
			
			if(sizes.lowerKey(max) != null) {
				int number = sizes.lowerKey(max);
				
				if(number >= min) {
					count ++;
					sizes.put(number,sizes.get(number)-1);
				}
				if(sizes.get(number) == 0) {
					sizes.remove(number);
				}
			}
		}
		System.out.println(count);
	}
}
