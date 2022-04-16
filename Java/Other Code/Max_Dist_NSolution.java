import java.util.Scanner;

public class Max_Dist_NSolution {
	public static void main(String args[]) {
		
		Scanner sc1 = new Scanner(System.in);
		
		int[] top = new int[2];
		int[] bottom = new int[2];
		int[] left = new int[2];
		int[] right = new int[2];
		
		int coordinates = sc1.nextInt();
		
		int x = 0;
		int y = 0;
		
		int[] xs = new int[coordinates];
		int[] ys = new int[coordinates];
		
		sc1.nextLine();
		for(int a = 0; a < coordinates;a++) {
			x = sc1.nextInt();
			xs[a] = x;
		}
		
		sc1.nextLine();
		for(int a = 0; a < coordinates;a++) {
			y = sc1.nextInt();
			ys[a] = y;
		}
		
		top[0] = x;
		top[1] = y;
		bottom[0] = x;
		bottom[1] = y;
		left[0] = x;
		left[1] = y;
		right[0] = x;
		right[1] = y;
		
		for(int a = 0; a < coordinates; a++) {
			x = xs[a];
			y = ys[a];
			
			if(y > top[1]) {
				top[0] = x;
				top[1] = y;
			}
			
			else if(y < bottom[1]) {
				bottom[0] = x;
				bottom[1] = y;
			}
			
			if(x > right[0]) {
				right[0] = x;
				right[1] = y;
			}
			
			else if(x < left[0]) {
				left[0] = x;
				left[1] = y;
			}
		}
		
		//bottom right
		//bottom left
		//bottom top
		//top right
		//top left
		//right left
		
		int br = distance(bottom,right);
		int bl = distance(bottom,left);
		int bt = distance(bottom,top);
		int tr = distance(top, right);
		int tl = distance(top,left);
		int lr = distance(left, right);
		
		System.out.println(Math.max(Math.max(br, bl), Math.max(bt, Math.max(tr, Math.max(tl,lr)))));
		
	}
	public static int distance(int[] first, int[] second) {
		
		int x = second[0] - first[0];
		int y = second[1] - first[1];
		return x*x + y*y;
	}
}
