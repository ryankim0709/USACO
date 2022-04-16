import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class Breed_Counting {
	public static void main(String[] args) throws IOException {
		Scanner sc1 = new Scanner(new File("./bcount.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("./bcount.out")));
		
		
		int cows = sc1.nextInt();
		int queries = sc1.nextInt();
		int[] Holsteins = new int[cows+1];
		int[] Guernseys = new int[cows+1];
		int[] Jerseys = new int[cows+1];
		Holsteins[0] = 0;
		Guernseys[0] = 0;
		Jerseys[0] = 0;
		
		for(int x = 1; x < cows+1; x++) {
			sc1.nextLine();
			int breed = sc1.nextInt();
			
			if(breed == 1) {
				Holsteins[x] = Holsteins[x-1]+ 1;
				Guernseys[x] = Guernseys[x-1];
				Jerseys[x] = Jerseys[x-1];
			}
			else if(breed == 2) {
				Holsteins[x] = Holsteins[x-1];
				Guernseys[x] = Guernseys[x-1]+ 1;
				Jerseys[x] = Jerseys[x-1];
			}
			
			else {
				Holsteins[x] = Holsteins[x-1];
				Guernseys[x] = Guernseys[x-1];
				Jerseys[x] = Jerseys[x-1] + 1;
			}
		}
		for(int x = 0; x < queries;x++) {
			int start = sc1.nextInt();
			int end = sc1.nextInt();
			pw.println((Holsteins[end]-Holsteins[start-1])+" "+(Guernseys[end]-Guernseys[start-1])+" "+(Jerseys[end]-Jerseys[start-1]));
		}
		pw.close();
	}
}
