import java.util.Scanner;
import java.util.ArrayList;

public class Just_Stalling {
	public static void main(String args[]) {
		/*Slowest time: 353ms
		 */
		int cows = 0;
		ArrayList<Integer> cow_height = new ArrayList<>();
		ArrayList<Integer> stall_height = new ArrayList<>();
		
		try {
			Scanner sc1 = new Scanner(System.in);
			cows = sc1.nextInt();
			
			sc1.nextLine();
			for(int x = 0; x < cows;x++) {
				cow_height.add(sc1.nextInt());
			}
			sc1.nextLine();
			for(int x = 0; x < cows;x++) {
				stall_height.add(sc1.nextInt());
			}
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		cow_height.sort(null);
		stall_height.sort(null);
		
		long count = 1;
		
		for(int x = cows - 1;x > 0;x--) {
			count = count * find_possiblities(cow_height.get(x),stall_height);
			stall_height.remove(stall_height.size()-1);
		}
		System.out.println(count);
		
	}
	public static int find_possiblities(int number,ArrayList<Integer> stall_height) {
		int count = 0;
		
		for(int x = stall_height.size() - 1; x >= 0;x--) {
			if(stall_height.get(x) >= number) {
				count ++;
			}
			else {
				return count;
			}
		}
		return count;
		
	}
}