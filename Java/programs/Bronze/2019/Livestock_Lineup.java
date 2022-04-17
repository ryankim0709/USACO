import java.util.*;
import java.io.*;

public class Livestock_Lineup {
	public static ArrayList<String> answer = new ArrayList<>();
	public static ArrayList<String> an1 = new ArrayList<String>();
	public static ArrayList<String> an2 = new ArrayList<String>();
	public static void main(String[] args) throws IOException {
		
		/*Slowest time: 696 ms
		 * We put our animal that are next to each other in two array's instead of a HashMap
		 * because HashMap will eliminate duplicates. Since there will only be 8 cows, we can
		 * find all the permutations, check if the permutation is valid, then add to answer if it
		 * is lexicographically first. We use recursion to do this
		 */
		BufferedReader br = new BufferedReader(new FileReader("lineup.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));
		
		int condition = Integer.parseInt(br.readLine());
		
		ArrayList<String> animals = new ArrayList<>();
		animals.add("Bessie");
		animals.add("Buttercup");
		animals.add("Belinda");
		animals.add("Beatrice");
		animals.add("Bella");
		animals.add("Blue");
		animals.add("Betsy");
		animals.add("Sue");
		
		String first = "";
		String second = "";
		StringTokenizer st = null;
		
		for(int x = 0; x < condition; x++) {
			st = new StringTokenizer(br.readLine());
			first = st.nextToken();
			st.nextToken();
			st.nextToken();
			st.nextToken();
			st.nextToken();
			second = st.nextToken();
			an1.add(first);
			an2.add(second);
		}
		
		System.out.println(an1);
		System.out.println(an2);
		permute(new ArrayList<String>(), animals);
		
		for(String x:answer) {
			pw.println(x);
		}
		pw.close();
	}
	
	public static void permute(ArrayList<String> prefix, ArrayList<String> original) {
		
		ArrayList<String> cprefix = new ArrayList<>();
		ArrayList<String> coriginal = new ArrayList<>();
		
		if(original.size() == 0) {
			if(check(prefix)) {
				if(answer.size() == 0) {
					answer = prefix;
				}
				
				else {
					answer = alphabetical(prefix);
				}
			}
			return;
		}
		
		else {
			for(int x = 0; x < original.size(); x++) {
				cprefix = (ArrayList<String>) prefix.clone();
				coriginal = (ArrayList<String>) original.clone();
				cprefix.add(original.get(x));
				coriginal.remove(x);
				permute((ArrayList<String>) cprefix.clone(), (ArrayList<String>) coriginal.clone());
			}
		}
	}
	
	public static boolean check(ArrayList<String> permutation) {
		
		String next = "";
		int index = 0;
		for(int x = 0; x < an1.size(); x++) {
			next = an2.get(x);
			index = permutation.indexOf(an1.get(x));
			
			if( (index + 1 < 8 && permutation.get(index + 1).equals(next)) || 
					(index - 1 > -1 && permutation.get(index-1).equals(next))) {
				continue;
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	public static ArrayList<String> alphabetical(ArrayList<String> permutation) {
		
		int compare = 0;
		for(int x = 0; x < 8; x++) {
			compare = permutation.get(x).compareTo(answer.get(x));
			
			if(compare < 0) {
				return permutation;
			}
			
			else if(compare > 0) {
				return answer;
			}
		}
		return permutation;
	}
}
