import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
public class Hoof_Paper_Scissors {
	public static void main(String[] args) throws IOException {
		
		Scanner sc1 = new Scanner(new File("./hps.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("./hps.out")));
		//StreamTokenizer in = new StreamTokenizer(new BufferedReader(new FileReader("hps.in")));
		
		int plays = sc1.nextInt();
		int[] paper = new int[plays + 1];
		int[] hoof = new int[plays + 1];
		int[] scissors = new int[plays + 1];
		paper[0] = 0;
		hoof[0] = 0;
		scissors[0] = 0;
		for(int x = 1;x <= plays;x++) {
			char play = sc1.next().charAt(0);
			
			if(play == 'P') {
				paper[x] = paper[x-1] + 1;
				hoof[x] = hoof[x-1];
				scissors[x] = scissors[x-1];
			}
			else if(play == 'H') {
				hoof[x] = hoof[x-1] + 1;
				paper[x] = paper[x-1];
				scissors[x] = scissors[x-1];
			}
			else {
				scissors[x] = scissors[x-1] + 1;
				paper[x] = paper[x-1];
				hoof[x] = hoof[x-1];
			}
		}
		
		int wins = 0;
		int max = 0;
		char[] playable = new char[] {'H','P','S'};
		for(int x = 0;x < 3;x++) {
			for(int y = 2; y <= plays;y++) {
				for(int z = 0; z < 3;z++) {
					char first = playable[x];
					char second = playable[z];
					
					if(first == 'H') {
						wins = scissors[y-1];
					}
					else if(first ==  'P') {
						wins = hoof[y-1];
					}
					else {
						wins = paper[y-1];
					}
					
					if(second == 'H') {
						wins = wins + scissors[plays] - scissors[y - 1];
					}
					else if(second == 'P') {
						wins = wins + hoof[plays]-hoof[y-1];
					}
					else {
						wins = wins + paper[plays]-paper[y-1];
					}
					
					if(wins > max) {
						max = wins;
					}
				}
			}
		}
		//System.out.println(max);
		pw.print(max);
		pw.close();
	}
}
