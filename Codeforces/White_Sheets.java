import java.util.Scanner;

public class White_Sheets {
	public static void main(String args[]){
		Scanner sc1 = new Scanner(System.in);
		int[] white = new int[4];
		int[] b1 = new int[4];
		int[] b2 = new int[4];
		
		for(int x = 0; x < 4;x++) {
			white[x] = sc1.nextInt();
		}
		for(int x = 0; x < 4;x++) {
			b1[x] = sc1.nextInt();
		}
		for(int x = 0; x < 4;x++) {
			b2[x] = sc1.nextInt();
		}
		int white_area = compute_area(white);
		white_area = white_area - intersection(white,b1) - intersection(white,b2) + intersection(b1,b2);
		if(white_area > 0) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
	public static int compute_area(int[]sheet) {
		int length = sheet[2]-sheet[0];
		int height = sheet[3]-sheet[1];
		return length * height;
	}
	public static int intersection(int[] first,int[] second) {
		int y_intersect = Math.max(0, Math.min(first[3], second[3]) - Math.max(first[1], second[1]));
		int x_intersect = Math.max(0, Math.min(first[2], second[2]) - Math.max(first[0], second[0]));
		
		return x_intersect * y_intersect;
	}
}