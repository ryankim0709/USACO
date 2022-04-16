import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.StringBuilder;
public class Censoring {

	public static void main(String[] args) throws IOException {
		Scanner sc1 = new Scanner(new File("./censor.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("./censor.out")));
		StringBuilder message = new StringBuilder();
		message.append(sc1.nextLine());
		
		String remove = sc1.nextLine();
		int remove_length = remove.length();
		int start = message.indexOf(remove);
		while(start != -1) {
			message.delete(start,start+remove_length);
			int end = start;
			start = message.indexOf(remove,(end-remove_length));
		}
		pw.print(message);
		pw.close();
	}

}
