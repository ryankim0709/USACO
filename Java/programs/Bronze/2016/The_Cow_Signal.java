
import java.util.Scanner;
import java.io.File;

public class The_Cow_Signal {
	public static void main(String args[]) {
		char signal[][] = null;
		Scanner sc1;
		int row = 0;
		int column= 0;
		int magnify = 0;
		
		try {
			sc1 = new Scanner(new File("/Users/youjungkim/DropBox/ryankim/usaco/cowsignal_bronze_dec16/4.in"));
			row = sc1.nextInt();
			column = sc1.nextInt();
			magnify = sc1.nextInt();
			sc1.nextLine();
			signal = new char[row][column];
			
			int RowCount = 0;
			
			while (sc1.hasNextLine()) {
				String line = sc1.nextLine();
				for (int x = 0; x < line.length();x++) {
					signal[RowCount][x] = line.charAt(x);
				}
				RowCount ++;
			}
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		
		char answer[][] = new char[row][column*magnify];

		for (int x = 0; x < row;x++) {
			for (int y = 0; y < column;y++) {
				for (int z = 0; z < magnify;z++) {
					answer[x][y*magnify+z] = signal[x][y];
				}
			}
		}
		
			for (int x = 0; x < row;x++) {
				for (int z = 0; z < magnify; z++) {
					System.out.println();
					for (int y = 0; y < column*magnify;y++) {
						System.out.print(answer[x][y]);
				}
			}
		}
	}
}