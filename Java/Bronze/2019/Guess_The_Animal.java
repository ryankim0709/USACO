import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
public class Guess_The_Animal {

	public static void main(String[] args) throws IOException {
		Scanner sc1 = new Scanner(new File("./guess.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("./guess.out")));
		HashMap<String,HashSet<String>> animals = new HashMap<>();
		HashSet<String> descriptions = new HashSet<>();
		ArrayList<String> animals_names = new ArrayList<>();
		
		int length = sc1.nextInt();
		
		for(int x = 0; x < length;x++) {
			sc1.nextLine();
			descriptions.clear();
			String name = sc1.next();
			int descriptors = sc1.nextInt();
			animals_names.add(name);
			
			for(int y = 0; y < descriptors; y++) {
				descriptions.add(sc1.next());
			}
			animals.put(name, (HashSet<String>) descriptions.clone());
		}
		int max = 0;
		for(int x = 0; x < length;x++) {
			for(int y = x + 1; y < length;y++) {
				int overlap = find_overlap(x,y,animals,animals_names);
				
				if(overlap > max) {
					max = overlap;
				}
				
			}
		}

		pw.print(max+1);
		pw.close();
	}
	
	public static int find_overlap(int one, int two,HashMap<String,HashSet<String>> animals,ArrayList<String> animal_names) {
		HashSet<String> animal_one = animals.get(animal_names.get(one));
		HashSet<String> animal_two = animals.get(animal_names.get(two));
		int common = 0;
		
		for(String x:animal_one) {
			for(String y:animal_two) {
				if(x.equals(y)) {
					common++;
				}
			}
		}
		return common;
	}
}
