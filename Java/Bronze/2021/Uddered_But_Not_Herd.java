import java.util.Scanner;

public class Uddered_But_Not_Herd {
	public static void main(String args[]) {
		/*Slowest time: 319ms
		 * Basic function: We loop over the alphabet until all the letters
		 * are found. This question should be very straight forward. Sorry
		 * for not using BufferedReader, this is my contest code and I didn't
		 * learn it yet.
		 */
		String word = "";
		String alphabet = "";
		try {
			Scanner sc1 = new Scanner(System.in);
			alphabet = sc1.next();
			word = sc1.next();
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		int hummed = 0;
		boolean found_word = false;
		int Char_At = 0;
		char letter = word.charAt(Char_At);
		
		while(!found_word) {
			hummed ++;
			for(int x = 0; x < 26;x++) {
				if(alphabet.charAt(x) == letter) {
					Char_At ++;
					if(Char_At == word.length()) {
						found_word = true;
						System.out.println(hummed);
						break;
					}
					letter = word.charAt(Char_At);
				}
			}
		}
		
	}
}