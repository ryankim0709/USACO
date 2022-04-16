import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;

public class Where_Am_I {
	public static void main(String args[]) {
		Scanner sc1;
		int length = 0;
		char[] mail_boxes = null;
		
		try {
			sc1 = new Scanner(new File("./whereami.in"));
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("./whereami.out")));
			length = sc1.nextInt();
			mail_boxes = new char[length];
			String colors = sc1.next();
			for(int x = 0; x < length;x++) {
				mail_boxes[x] = colors.charAt(x);
			}
			for(int x = 0; x < length;x++) {
				if(is_distinct(x,mail_boxes)) {
					pw.print(x);
					pw.close();
					break;
				}
			}
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}
	public static boolean is_distinct(int length,char[] mail_boxes) {
		HashMap<String,String> sets = new HashMap<>();
		for(int x = 0; x < mail_boxes.length-length + 1;x++) {
			String put = find_string(x,length,mail_boxes);
			if(sets.get(put) != null) {
				return false;
			}
			else {
				sets.put(put, put);
			}
		}
		return true;
	}
	public static String find_string(int start, int length, char[] mail_boxes) {
		String answer = "";
		for(int x = start;x < start + length;x++) {
			answer = answer + mail_boxes[x];
		}
		return answer;
	}
}