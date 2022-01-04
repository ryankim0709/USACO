import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Word_Processor {
	public static void main(String args[]) {
		Scanner sc1;
		String[][] words = null;
		int word_count = 0;
		int word_per_line = 0;
		try {
			sc1 = new Scanner(new File("./word.in"));
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("./word.out")));
			word_count = sc1.nextInt();
			word_per_line = sc1.nextInt();
			words = new String[word_count][1];
			
			for(int x = 0; x < word_count;x++) {
				words[x][0] = sc1.next();
			}
			
			int letters = words[0][0].length();
			pw.print(words[0][0]);
			for(int x = 1;x < word_count;x++) {
				if(letters + words[x][0].length() <= word_per_line) {
					pw.print(" "+words[x][0]);
					letters = letters + words[x][0].length();
				}
				else {
					pw.println();
					pw.print(words[x][0]);
					letters = words[x][0].length();
				}
			}
			pw.close();
			
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}
}