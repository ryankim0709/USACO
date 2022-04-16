import java.util.Scanner;
public class Maximum_Distance {
	public static void main(String[] args) {
		
		Scanner sc1 = new Scanner(System.in);
		
		int coordinates = sc1.nextInt();
		
		int[] xs = new int[coordinates];
		int[] ys = new int[coordinates];
		
		for(int x = 0; x < 3; x ++) {
			xs[x] = sc1.nextInt();
		}
		
		for(int x = 0; x < 3; x ++) {
			ys[x] = sc1.nextInt();
		}
		
		int max = 0;
		int distance = 0;
		
		for(int x = 0; x < coordinates; x++) {
			for(int y = x + 1; y < coordinates;y++) {
				distance = (xs[x] - xs[y]) * (xs[x] - xs[y]) + (ys[x] - ys[y]) * (ys[x] - ys[y]);
				
				if(distance > max) {
					max = distance;
				}
			}
		}
		System.out.println(max);
	}
}
