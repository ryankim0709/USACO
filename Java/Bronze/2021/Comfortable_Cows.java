import java.util.TreeSet;
import java.util.Scanner;
public class Comfortable_Cows {
	public static void main(String[] args) {
		TreeSet<String> cow_pos = new TreeSet<>();
		Scanner sc1 = new Scanner(System.in);
		int[] cows = new int[2];
		TreeSet<int[]> hi = new TreeSet<>();
		
		int length = sc1.nextInt();
		for(int x = 0; x < length;x++) {
			sc1.nextLine();
			int x_axis = sc1.nextInt();
			int y_axis = sc1.nextInt();
			String coordinates = String.valueOf(x_axis)+","+String.valueOf(y_axis);
			cows[0] = x_axis;
			cows[1] = y_axis;
			cow_pos.add(coordinates);
			int count = 0;
			if(comfortable(cow_pos,x_axis+1,y_axis)) {
				count ++;
			}
			if(comfortable(cow_pos,x_axis-1,y_axis)) {
				count ++;
			}
			if(comfortable(cow_pos,x_axis,y_axis+1)) {
				count ++;
			}
			if(comfortable(cow_pos,x_axis,y_axis-1)) {
				count ++;
			}
			System.out.println(count);
		}
	}
	public static boolean comfortable(TreeSet<String> cow_pos,int x_axis, int y_axis) {
		//System.out.println(x_axis);
		//System.out.println(y_axis);
		String right = String.valueOf(x_axis+1)+","+String.valueOf(y_axis);
		String left = String.valueOf(x_axis-1)+","+String.valueOf(y_axis);
		String up = String.valueOf(x_axis)+","+String.valueOf(y_axis+1);
		String down = String.valueOf(x_axis)+","+String.valueOf(y_axis-1);
		
		int Right = 0;
		int Left = 0;
		int Up = 0;
		int Down = 0;
		if(cow_pos.contains(right)) {
			Right ++;
		}
		if(cow_pos.contains(left)) {
			Left ++;
		}
		if(cow_pos.contains(up)) {
			Up++;
		}
		if(cow_pos.contains(down)) {
			Down ++;
		}
		//System.out.println(up+down+left+right);
		if(Up+Down+Left+Right == 3) {	
			return true;
		}
		return false;
	}

}
