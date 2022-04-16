import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class Lifegaurds {
	public static void main(String ars[]) {
		Scanner sc1;
		ArrayList<int[]> start_end = new ArrayList<>();
		int[] each_lifegaurd = new int[2];
		int num_of_lifegaurds = 0;
		int max = 0;
		
		try {
			sc1 = new Scanner(new File("/Users/youjungkim/DropBox/ryankim/usaco/lifeguards_bronze_jan18/10.in"));
			num_of_lifegaurds = sc1.nextInt();
			
			for (int x = 0; x < num_of_lifegaurds;x++) {
				sc1.nextLine();
				each_lifegaurd[0] = sc1.nextInt();
				if(each_lifegaurd[0] > max) {
					max = each_lifegaurd[0];
				}
				each_lifegaurd[1] = sc1.nextInt();
				if(each_lifegaurd[1] > max) {
					max = each_lifegaurd[1];
				}
				start_end.add(each_lifegaurd.clone());
			}
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		ArrayList<int[]> clone = (ArrayList<int[]>) start_end.clone();
		
		int max_length = 0;
		for (int x = 0; x < num_of_lifegaurds; x++) {
			clone = (ArrayList<int[]>) start_end.clone();
			clone.remove(x);
			
			if (find_max(clone,max) > max_length) {
				//System.out.println(x);
				//System.out.println(find_max(clone));
				//System.out.println();
				max_length = find_max(clone,max);
			}
		}
		System.out.println(max_length);
	}

	public static int find_max(ArrayList<int[]> start_end,int greatest) {
		int length = start_end.size();
		boolean[] nums = new boolean[greatest];
		
		for (int[] x:start_end) {
			int start = x[0];
			int end = x[1];
			
			for (int y = start; y < end;y++) {
				nums[y] = true;
			}
		}
		int count = 0;
		for(boolean x:nums) {
			if (x) {
				count ++;
			}
		}
		return count;
	}
}