import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Photoshoot {
	public static void main(String args[]) {

		try {
			Scanner sc1 = new Scanner(new File("./photo.in"));
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("./photo.out")));
			
			int length = sc1.nextInt();
			int []bessie_permute = new int[length - 1];
			int[] original_permute = new int[length];
			sc1.nextLine();
			for(int x = 0; x < length - 1;x++) {
				bessie_permute[x] = sc1.nextInt();
			}
			for(int x = 1; x < bessie_permute[0];x++) {
				if(find_permute(x,bessie_permute,original_permute)) {
					for(int y = 0; y < original_permute.length;y++) {
						if(y == original_permute.length-1) {
							pw.print(original_permute[y]);
						}
						else {
							pw.print(original_permute[y]+" ");
						}
					}
					pw.close();
					break;
				}
			}
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}
	public static boolean find_permute(int original, int[] bessie_permute, int[] original_permute) {
		if(original > bessie_permute.length+1) {
			return false;
		}
		boolean[] tracker = new boolean[bessie_permute.length + 1];
		tracker[original-1] = true;
		int minus = original;
		original_permute[0] = original;
		for(int x = 0; x < bessie_permute.length;x++) {
			int put = bessie_permute[x] - minus;
			
			if(put < 0) {
				return false;
			}
			if(put > original_permute.length) {
				
				return false;
			}
			if(put == 0) {
				return false;
			}
			
			if(tracker[put-1] == true) {
				return false;
			}
			else {
				tracker[put-1] = true;
				original_permute[x+1] = put;
				minus = put;
			}
		}
		return true;
	}
}