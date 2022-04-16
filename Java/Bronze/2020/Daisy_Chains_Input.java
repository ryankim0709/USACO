import java.util.Scanner;
import java.util.ArrayList;

public class Daisy_Chains_Input{ 
	public static void main(String args[]) {
		int length = 0;
		int[] flowers = null;
		try {
			Scanner sc1 = new Scanner(System.in);
			length = sc1.nextInt();
			sc1.nextLine();
			flowers = new int[length];
			for(int x = 0; x < length;x++) {
				flowers[x] = sc1.nextInt();
			}
			
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		
		int count = 0;
		for(int x = 0; x < length;x++) {
			for(int y = x; y < length;y++) {
				if(check_average(x,y,flowers)) {
					count ++;
				}
			}
		}
		System.out.println(count);
	}
	public static boolean check_average(int start, int end, int[] flowers) {
		double ave = 0;
		for(int x = start; x <= end;x++) {
			ave += flowers[x];
		}
		ave = ave / (end - start + 1);
		//System.out.println("Average "+ave);
		
		for(int x = start; x <= end;x++) {
			if(flowers[x] == ave) {
				return true;
			}
		}
		return false;
	}
}