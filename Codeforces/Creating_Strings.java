import java.util.*;
import java.io.*;

public class Creating_Strings {
	
	public static HashSet<String> permutations = new HashSet<>();
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word = br.readLine();
		
		permute(word, "");
		
		System.out.println(permutations.size());
		String[] permutes = new String[permutations.size()];
		int count = 0;
		for(String x:permutations) {
			permutes[count] = x;
			count ++;
		}
		Arrays.sort(permutes);
		
		for(String x:permutes) {
			System.out.println(x);
		}
	}
	
	public static void permute(String work, String prefix) {
		int length = work.length();
		
		if(length == 0) {
			permutations.add(prefix);
		}
		
		else {
			
			for(int x = 0; x < length; x++) {
				permute((work.substring(0,x)+work.substring(x + 1,length)),prefix + work.charAt(x));
			}
		}
	}
}
