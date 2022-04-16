
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Shell_Game {
	public static void main(String args[]) {
		Scanner sc1;
		Boolean[] shells = {false,false,false};
		ArrayList<int[]> steps = new ArrayList<>();
		int[] changes = new int[3];
		
		try {
			sc1 = new Scanner(new File("/Users/youjungkim/DropBox/ryankim/usaco/shell_bronze_jan19/4.in"));
			sc1.nextLine();
			
			while (sc1.hasNextLine()) {
				String moves = sc1.nextLine();
				Scanner change = new Scanner(moves);
				int count = 0;
				while (change.hasNext()) {
					changes[count] = change.nextInt();
					count ++;
				}
				steps.add(changes.clone());
			}
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}

		for (int x = 0; x < 3; x++)
		changes[x] = 0;

		for (int x = 0; x < 3;x++) {
			shells[0] = false;
			shells[1] = false;
			shells[2] = false;
			shells[x] = true;
			for (int[] a:steps) {
				shells = shell_switch(a,shells);
				
				if (shells[a[2]-1] == true) {
					changes[x]++;
				}
			}
		}
		Arrays.sort(changes);
		System.out.println(changes[2]);
	}
	public static Boolean[] shell_switch(int[] step, Boolean[] shells) {
		Boolean[] end = shells.clone();
		
		int replace = step[0] - 1;
		int replace1 = step[1] - 1;
		end[replace] = shells[replace1];
		end[replace1] = shells[replace];
		
		return end;
	}
}