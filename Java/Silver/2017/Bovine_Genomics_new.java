import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
public class Bovine_Genomics_new {
	public static void main(String[] args) throws IOException {
		Scanner sc1 = new Scanner(new File("./cownomics.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("./cownomics.out")));
		
		int cows = sc1.nextInt();
		int genomic_code_length = sc1.nextInt();
		HashMap<Character, Integer> keys = new HashMap<>();
		keys.put('A', 1);
		keys.put('C', 2);
		keys.put('G', 3);
		keys.put('T',4);
		ArrayList<int[]> spotty = new ArrayList<>();
		ArrayList<int[]> plain = new ArrayList<>();
		int[] genomic_code = new int[genomic_code_length];
		
		for (int x = 0; x < cows;x++) {
			sc1.nextLine();
			String code = sc1.next();
			for(int y = 0; y < genomic_code_length;y++) {
				genomic_code[y] = keys.get(code.charAt(y));
			}
			spotty.add(genomic_code.clone());
		}
		
		for (int x = 0; x < cows;x++) {
			sc1.nextLine();
			String code = sc1.next();
			for(int y = 0; y < genomic_code_length;y++) {
				genomic_code[y] = keys.get(code.charAt(y));
			}
			plain.add(genomic_code.clone());
		}
		HashSet<Integer> spotted = new HashSet<>();
		HashSet<Integer> plained = new HashSet<>();
		int count = 0;
		for(int x = 0; x < genomic_code_length;x++) {
			for(int y = x+1; y < genomic_code_length;y++) {
				for(int z = y + 1; z < genomic_code_length;z++) {
					spotted.clear();
					plained.clear();
					for(int row = 0; row < cows;row++) {
						int[] spotty_genes = spotty.get(row);
						int[] plain_genes = plain.get(row);
						
						spotted.add(spotty_genes[x]*100+spotty_genes[y]*10+spotty_genes[z]);
						plained.add(plain_genes[x]*100+plain_genes[y]*10+plain_genes[z]);
					}
					if(explains_spottyness(spotted,plained)) {
						count ++;
					}
				}
			}
		}
		pw.print(count);
		pw.close();
	}
	
	public static boolean explains_spottyness(HashSet<Integer> spotted,HashSet<Integer> plained) {
		
		for(int x:spotted) {
			for(int y:plained) {
				if(x == y) {
					return false;
				}
			}
		}
		return true;
	}
}
