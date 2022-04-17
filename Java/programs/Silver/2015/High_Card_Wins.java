import java.util.*;
import java.io.*;
public class High_Card_Wins {
	public static void main(String[] args) throws IOException{
		/* Slowest time: 1497 ms
		 * Basic function: Once we find Bessie and Elsie's array, we have to match
		 * Bessie's highest card with Elsie's card. We can run one for loop to simulate
		 * this situation
		 */
		BufferedReader br = new BufferedReader(new FileReader("highcard.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("highcard.out")));
		int n = Integer.parseInt(br.readLine());
		Set<Integer> e = new TreeSet<>();
		Set<Integer> b = new TreeSet<>();
		
		for(int x = 0; x < n; x++) {
			e.add(Integer.parseInt(br.readLine()));
		}
		
		for(int x = 1; x <= 2*n; x++) {
			b.add(x);
		}
		
		b.removeAll(e);
		int[] elsie = new int[n];
		int[] bessie = new int[n];
		
		int index = 0;
		for(int x:e) {
			elsie[index] = x;
			index ++;
		}
		index = 0;
		
		for(int x:b) {
			bessie[index] = x;
			index ++;
		}
		
		index = n-1;
		int bessieCard;
		int ans = 0;
		
		for(int x = n-1; x >= 0; x--) {
			bessieCard = bessie[x];
			System.out.println("Bessie Card: "+bessieCard);
			if(index < 0) {
				break;
			}
			while(index >= 0 && bessieCard < elsie[index]) {
				index --;
			}
			index --;
			ans ++;
		}
		pw.print(ans);
		pw.close();
	}
}