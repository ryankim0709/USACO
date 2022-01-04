import java.util.Arrays;
import java.util.Scanner;

public class Do_You_Know_Your_ABCs {
	public static void main(String args[]) {
		int[] hints = new int[7];
		try {
			Scanner sc1 = new Scanner(System.in);
			String input = sc1.nextLine();
			Scanner sc2 = new Scanner(input);
			for(int x = 0; x < 7;x++) {
				hints[x] = sc2.nextInt();
			}
		}
		catch(Exception e) {
			System.out.println("Exception");
			e.getStackTrace();
		}
		Arrays.sort(hints);
		int A = hints[0];
		int B = hints[1];
		int max = hints[hints.length-1];
		int C = max - A - B;
		System.out.println(A+" "+B+" "+C);
	}
}