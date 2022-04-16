import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Blocked_Bilboard {
	public static void main(String args[]) throws IOException {
		
		Scanner sc1 = new Scanner(new File("./billboard.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("./billboard.out")));
		int[] alfalfa = new int[4];
		int[] grain = new int[4];
		int[] steak = new int[4];
		for(int x = 0; x < 4;x++) {
			alfalfa[x] = sc1.nextInt();
		}
		for(int x = 0; x < 4;x++) {
			grain[x] = sc1.nextInt();
		}
		for(int x = 0; x < 4;x++) {
			steak[x] = sc1.nextInt();
		}
		int a_area = find_area(alfalfa);
		int g_area = find_area(grain);
		a_area = a_area - intersection(alfalfa,steak);
		g_area = g_area - intersection(grain,steak);
		pw.print(a_area+g_area);
		pw.close();
		
	}
	public static int find_area(int[] board) {
		int length = board[2] - board[0];
		int height = board[3] - board[1];
		return length * height;
	}
	public static int intersection(int[] a, int[] b) {
		
		int y_intersection = Math.max(0, Math.min(b[3], a[3]) - Math.max(a[1], b[1]));
		int x_intersection = Math.max(0, Math.min(a[2], b[2]) - Math.max(a[0], b[0]));
		return y_intersection * x_intersection;
	}
}