import java.util.Scanner;
import java.util.ArrayList;

public class Even_More_Odd_Photos {
	public static void main(String args[]) {
		int numbers = 0;
		int odds = 0;
		int evens = 0;
		
		Scanner sc1 = new Scanner(System.in);
		numbers = sc1.nextInt();
		
		for(int x = 0; x < numbers;x++) {
			if(sc1.nextInt()%2 == 0) {
				evens ++;
			}
			else {
				odds++;
			}
		}
		numbers = 0;
		
		if(evens > odds) {
			System.out.println(odds * 2 + 1);
		}
		else {
			numbers = evens * 2;
			odds = odds - evens;
			
			if(odds % 3 == 0) {
				numbers = numbers + odds/3 * 2;
			}
			else if(odds % 3 == 1) {
				numbers = numbers + (odds - 4)/3 * 2 + 1;
			}
			else {
				numbers = numbers + odds/3 * 2 + 1;
			}
			System.out.println(numbers);
		}
	}
}