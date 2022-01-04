import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Bucket_Brigade {
	public static void main(String args[]) {
		try {
			int[] barn = new int[2];
			int[] lake = new int[2];
			int[] rock = new int[2];
			Scanner sc1 = new Scanner(new File("./buckets.in"));
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("./buckets.out")));
			
			for(int x = 0; x < 10; x++) {
				if(x != 0) {
					sc1.nextLine();
				}
				String line = sc1.next();
				for(int y = 0; y < 10; y ++) {
					if(line.charAt(y) == 'B') {
						barn[0] = y;
						barn[1] = x;
					}
					if(line.charAt(y) == 'L') {
						lake[0] = y;
						lake[1] = x;
					}
					if(line.charAt(y) == 'R') {
						rock[0] = y;
						rock[1] = x;
					}
				}
			}
			
			if((barn[0] == lake[0] && lake[0] == rock[0] && barn[0] == rock[0]) ||
					(barn[1] == lake[1] && lake[1] == rock[1] && barn[1] == rock[1])) {
				if((rock[0] > barn[0] && rock[0] < lake[0] || (rock[0] < barn[0] && rock[0] > lake[0]))) {
					pw.println(find_distance(barn,lake) + 2);
				}
				else if((rock[1] > barn[1] && rock[1] < lake[1] || (rock[1] < barn[1] && rock[1] > lake[1]))) {
					pw.println(find_distance(barn,lake) + 2);
				}
				else {
					pw.println(find_distance(barn,lake));
				}
			}
			else {
				pw.println(find_distance(barn,lake));
			}
			pw.close();
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}
	public static int find_distance(int[] barn,int[] lake) {
		int length = Math.abs(barn[0] - lake[0]);
		int height = Math.abs(barn[1] - lake[1]);
		return height + length - 1;
	}
}