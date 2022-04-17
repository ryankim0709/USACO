import java.util.Scanner;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
public class Year_Of_The_Cow_Clean {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc1 = new Scanner(System.in);
		String[] years = new String[] {"Ox","Tiger","Rabbit","Dragon","Snake","Horse","Goat","Monkey","Rooster","Dog","Pig","Rat",
				"Ox","Tiger","Rabbit","Dragon","Snake","Horse","Goat","Monkey","Rooster","Dog","Pig","Rat"};
		HashMap<String,Integer> cow_births = new HashMap<>();
		HashMap<String,String> cow_zodiac = new HashMap<>();

		cow_births.put("Bessie", 0);
		cow_zodiac.put("Bessie", "Ox");
		
		int cows = sc1.nextInt();
		
		String year_name = "";
		String name = "";
		String when = "";
		String from = "";
		
		int min = 0;
		int age = 0;
		for(int x = 0; x < cows;x++) {
			sc1.nextLine();
			name = sc1.next();
			sc1.next();
			sc1.next();
			when = sc1.next();
			year_name = sc1.next();
			sc1.next();
			sc1.next();
			from = sc1.next();
			
			min = indexOf(years,cow_zodiac.get(from));
			
			if(when.equals("previous")) {
				age = cow_births.get(from) - 12 + indexOfp(years,year_name,min);
			}
			
			else if(when.equals("next")) {
				age = cow_births.get(from) + indexOf(years,year_name,min);
			}
			
			if(name.equals("Elsie")) {
				System.out.println(Math.abs(age));
				break;
			}
			
			cow_births.put(name, age);
			cow_zodiac.put(name, year_name);
		}
	}
	
	public static int indexOfp(String[] years, String name,int from) {
		
		for(int x = 0; x < 12;x++) {
			if(years[from + x].equals(name)) {
				return x;
			}
		}
		return 0;
	}
	
	public static int indexOf(String[] years, String name,int from) {
		
		for(int x = 1; x < 13;x++) {
			if(years[from + x].equals(name)) {
				return x;
			}
		}
		return 0;
	}
	
	public static int indexOf(String[] years, String name) {
		
		for(int x = 0; x < 12;x++) {
			if(years[x].equals(name)) {
				return x;
			}
		}
		return 0;
	}
}