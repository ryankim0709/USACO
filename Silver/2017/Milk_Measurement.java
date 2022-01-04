import java.util.Arrays;
import java.io.FileWriter;
import java.util.Comparator;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class Milk_Measurement {
	public static void main(String args[])  {
		Scanner sc1;
		String[][] input = null;
		int length = 0;
		int[] Bessie_Elsie_Mildred = {7,7,7};
		ArrayList<String> displayed = new ArrayList<>();
		FileWriter output;
		try {
			output = new FileWriter("/Users/youjungkim/DropBox/ryankim/usaco/measurement.out");
			sc1 = new Scanner(new File("/Users/youjungkim/DropBox/ryankim/usaco/measurement.in"));
			length = sc1.nextInt();
			input = new String[length][3];
			
			for (int x = 0; x < length;x++) {
				sc1.nextLine();
				input[x][0] = sc1.next();
				input[x][1] = sc1.next();
				input[x][2] = sc1.next();
			}
		
			Arrays.sort(input, Comparator.comparingDouble(o -> Integer.parseInt(o[0])));
		
			int change = 0;
		
			for(int x = 0; x < length; x++) {
				switch(input[x][1]) {
			
				case "Bessie":
					if(add_milk(x,Bessie_Elsie_Mildred,input,0,displayed)) {
						change ++;
					}
					break;
			
				case "Elsie":
					if(add_milk(x,Bessie_Elsie_Mildred,input,1,displayed)) {
						change ++;
					}
					break;
				
				case "Mildred":
					if(add_milk(x,Bessie_Elsie_Mildred,input,2,displayed)) {
						change++;
					}
					break;
				}
			}
			System.out.println("change" + change);
			output.write(change);
			output.close();
		}
		catch(Exception e) {
			e.getStackTrace();
		}
}
	
	public static boolean add_milk(int index, int[] Bessie_Elsie_Mildred, String[][] input, int cow,ArrayList<String> displayed) {
		switch(input[index][2].charAt(0)) {
		case '+':
			Bessie_Elsie_Mildred[cow] += Integer.parseInt(input[index][2].substring(1,2));
			if (update_display(displayed,Bessie_Elsie_Mildred)) {
				return true;
			}
			break;
			
		case '-':
			Bessie_Elsie_Mildred[cow] -= Integer.parseInt(input[index][2].substring(1,2));
			if (update_display(displayed,Bessie_Elsie_Mildred)) {
				return true;
			}
			break;
		}
		return false;
	}
	public static boolean update_display(ArrayList<String> displayed, int[] milks) {
		ArrayList<String> changed = new ArrayList<String>();
		int max = find_max(milks);
		
		if (milks[0] == max) {
			changed.add("Bessie");
		}
		if (milks[1] == max) {
			changed.add("Elsie");
		}
		if (milks[2] == max) {
			changed.add("Mildred");
		}
		if (check(displayed,changed)) {
			return false;
		}
		displayed.clear();
		
		for (String a:changed) {
			displayed.add(a);
		}
		
		return true;
	}
	
	public static boolean check(ArrayList<String> current_display, ArrayList<String> changed) {
		
		if (current_display.size() != changed.size()) {
			return false;
		}
		
		for (int x = 0; x < changed.size();x++) {
			if(!(current_display.get(x).equals(changed.get(x)))) {
				return false;
			}
		}
		return true;
	}
	public static int find_max(int[] milks) {
		int max = 0;
		for (int a:milks) {
			if (a > max) {
				max = a;
			}
		}
		return max;
	}
}