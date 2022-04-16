
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Speeding_Ticket{
	public static void main(String args[]) {
		Scanner sc1;
		 ArrayList<int[]> actual_speed = new ArrayList<>();
		 ArrayList<int[]> bessie_speed = new ArrayList<>();
		 int[] add = new int[2];
		 
		 try {
			 sc1 = new Scanner(new File("/speeding_bronze_dec15/10.in"));
			 int actual = sc1.nextInt();
			 int bessie = sc1.nextInt();
			 sc1.nextLine();
			 
			 for (int x = 0; x < actual;x++) {
				 add[0] = sc1.nextInt();
				 add[1] = sc1.nextInt();
				 actual_speed.add(add.clone());
			 }
			 for (int x = 0; x < bessie;x++) {
				 add[0] = sc1.nextInt();
				 add[1] = sc1.nextInt();
				 bessie_speed.add(add.clone());
			 }
		 }
		 catch(Exception e) {
			 e.getStackTrace();
		 }
		 int greatest_diff = 0;
		 int bessie_start = 0;
		 int bessie_end = 0;
		 for (int x = 0; x < bessie_speed.size();x++) {
			 if (x == 0) {
				 bessie_end =  bessie_speed.get(0)[0];
			 }
			 else {
				 bessie_start = bessie_end;
				 bessie_end = bessie_end + bessie_speed.get(x)[0];
			 }
			 if (find_diff(bessie_speed,actual_speed,bessie_start,bessie_end,x) > greatest_diff) {
				 greatest_diff = find_diff(bessie_speed,actual_speed,bessie_start,bessie_end,x);
			 }
		 }
		 System.out.println(greatest_diff);
	}
	public static int find_diff(ArrayList<int[]> bessie_speed,ArrayList<int[]> actual_speed,int bessie_start,int bessie_end, int index) {
		int diff = 0;
		int bessie_speeds = bessie_speed.get(index)[1];
		int actual_start = 0;
		int actual_end = 0;
		
		for (int[] a:actual_speed) {
			actual_end = actual_end + a[0];
			
			if ((bessie_start >= actual_end) || (bessie_end <= actual_start)) {
				continue;
			}
			else {
				if (bessie_speeds-a[1] > diff) {
					diff = bessie_speeds-a[1];
				 }
			}
			actual_start = actual_end;
		}
		
		return diff;
	}
}
