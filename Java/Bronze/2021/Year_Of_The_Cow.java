import java.util.Scanner;
import java.util.HashMap;
public class Year_Of_The_Cow {
	public static void main(String[] args){
		
		//Slowest time for test cases, 376 ms.
		/*
		 Basic function of code:
		 
		 We are given that the first cow will be older or younger than the second cow. 
		 We know that if the first cow is younger, its age range is from (second cow age - 12) - (second cow age - 1).
		 Similarly, we know that if the first cow is older, its age range is from (second cow age + 1) - second cow age + 12).
		 
		 The code checks whether or not the given cow is younger or older, then calculates the minimum/maximum value of the cow.
		 Then we calculate the age using 2 if conditions. indexOfp is used for the "previous" portion and indexOf is used for the "next" portion.
		 The reason we need two different values for the for loop is because we want to make sure we don't include the given year. 
		 
		 If we start at 0 for the indexOf function, it would count itself, and a case such as "Mildred born in next Ox year from Bessie" would 
		 produce the wrong age! If the for loop started at 0, the age of Bessie and Mildred would be same. 
		 But, for the indexOfp function, we have to include 0 because we are counting forward to backward, and thus would not be counting itself.
		 
		 P.S. I'm studying BufferedReader + StreamTokenizer so I am using Scanner at the moment even thought it's slow. Though, this proves
		 that this code is very fast!
		 
		 Thank you for reading and hope this helps!
		 */
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
		
		int min_or_max = 0;
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
			
			min_or_max = indexOf(years,cow_zodiac.get(from));
			
			if(when.equals("previous")) {
				age = cow_births.get(from) - 12 + indexOfp(years,year_name,min_or_max);
			}
			
			else if(when.equals("next")) {
				age = cow_births.get(from) + indexOf(years,year_name,min_or_max);
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