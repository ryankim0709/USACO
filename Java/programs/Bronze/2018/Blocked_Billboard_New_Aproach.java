import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Blocked_Billboard_New_Aproach {
	 public static void main(String[] args) throws IOException   {
		//Scanner sc1 = new Scanner(new File("/Users/youjungkim/DropBox/ryankim/USACO_Bronze_2/billboard_bronze_dec17/1.in"));
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
		pw.println(a_area+g_area);
		pw.close();
		//System.out.println(a_area + g_area);
	}
	public static int find_area(int[] board) {
		int length = board[2] - board[0];
		int height = board[3] - board[1];
		return length * height;
	}
	public static int intersection(int[] a, int[] b) {
		int x_intersect = 0;
		int y_intersect = 0;
		
		if(b[0] > a[2] || b[2] < a[0]) {
			return 0;
		}
		if(a[0] < b[0] && a[2] > a[0] && a[2] < b[2]) {
			x_intersect = a[2] - b[0];
		}
		else if(b[0] < a[0] && b[2] > a[0] && b[2] < a[2]) {
			x_intersect = b[2] - a[0];
		}
		else if(a[0] > b[0] && a[2] < b[2]) {
			x_intersect = a[2] - a[0];
		}
		else if(b[0] > a[0] && b[2] < a[2]) {
			x_intersect = b[2] - b[0];
		}
		else if(b[0] > a[0] && b[2] > a[2]) {
			x_intersect = 0;
		}
		
		if(a[1] < b[1] && a[3] > a[1] && a[3] < b[3]) {
			y_intersect = a[3] - b[1];
		}
		else if(b[1] < a[1] && b[3] > a[1] && b[3] < a[3]) {
			y_intersect = b[3] - a[1];
		}
		else if(a[1] > b[0] && a[3] < b[3]) {
			y_intersect = a[3] - a[1];
		}
		else if(b[1] > a[1] && b[3] < a[3]) {
			y_intersect = b[3] - b[1];
		}
		else if(b[1] > a[1] && b[3] > a[3]) {
			y_intersect = 0;
		}

		return x_intersect * y_intersect;
	}
}