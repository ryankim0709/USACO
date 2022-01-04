import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.io.File;

public class Why_Did_The_Cow_Cross_The_Road_III_redone{
	public static void main(String args[]) {
		Scanner sc1;
		int[][] arrive_time = null;
		int length = 0;
		
		try {
			sc1 = new Scanner(new File("/cowqueue_bronze_feb17/10.in"));
			length = sc1.nextInt();
			arrive_time = new int[length][2];
			
			for(int x = 0; x < length; x++) {
				sc1.nextLine();
				int arrive = sc1.nextInt();
				int time = sc1.nextInt();
				arrive_time[x][0] = arrive;
				arrive_time[x][1] = time;
			}
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		Arrays.sort(arrive_time, Comparator.comparingDouble(o -> o[0]));
		int r_end = 0;
		for (int x = 0; x < length;x++) {
				
			if (arrive_time[x][0] > r_end) {
				r_end = arrive_time[x][0] + arrive_time[x][1];
			}
			else if(arrive_time[x][0] <= r_end) {
				r_end = r_end + arrive_time[x][1];
			}
		}
		System.out.println(r_end);
	}
}