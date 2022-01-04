import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class Bovine_Genomics {
	public static void main(String args[]) {
		Scanner sc1;
		
		char[][] spotted_genetics = null;
		char[][] plain_genetics = null;
		int each_type = 0;
		int genetic_length = 0;
		
		try {
			sc1 = new Scanner(new File("/cownomics_bronze_open17/10.in"));
			each_type = sc1.nextInt();
			genetic_length = sc1.nextInt();
			spotted_genetics = new char[each_type][genetic_length];
			plain_genetics = new char[each_type][genetic_length];
			sc1.nextLine();
			for (int row = 0; row < each_type; row++) {
				String b = sc1.next();
				for (int column = 0; column < genetic_length; column++) {
					spotted_genetics[row][column] = b.charAt(column);
				}
			}
			
			for (int row = 0; row < each_type; row++) {
				String b = sc1.next();
				for (int column = 0; column < genetic_length; column++) {
					plain_genetics[row][column] = b.charAt(column);
				}
			}
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		
		int count = 0;
		int max_count = 0;
		
		for (int x = 0; x < genetic_length;x++) {
			count = 0;
			for (int y = 0; y < each_type;y++) {
				char gene = spotted_genetics[y][x];
				if(!check_other_side(gene,plain_genetics,each_type,x)) {
					count ++;
				}
				if (count == each_type) {
					max_count ++;	
				}
			}
		}
		System.out.println(max_count);
	}
	public static boolean check_other_side(char check, char[][] plain_genetics,int each_type,int initial_pos) {
		for (int x = 0; x < each_type;x++) {
			if (plain_genetics[x][initial_pos] == check) {
				return true;
			}
		}
		return false;
	}
}