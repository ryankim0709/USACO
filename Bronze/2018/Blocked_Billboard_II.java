import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Blocked_Billboard_II{
	public static void main(String arrgs[]) throws IOException   {
		Scanner sc1 = new Scanner(new File("./billboard.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("./billboard.out"));
		int[] lawnmower = new int[4];
		int[] feed = new int[4];
		for(int x = 0;x < 4;x++) {
			lawnmower[x] = sc1.nextInt();
		}
		for(int x = 0; x < 4;x++) {
			feed[x] = sc1.nextInt();
		}
		int state = find_state(lawnmower,feed);
		if(state == 0 || state == 1) {
			pw.print(find_area(lawnmower));
		}
		else if(state == 2) {
			pw.print(find_area(lawnmower) - find_intersection(lawnmower,feed));
		}
		else {
			pw.print(0);
		}
		pw.close();
	}
	public static int find_intersection(int[] mower, int[] feed) {
		
		int x_intersect = Math.max(0, Math.min(mower[2],feed[2]) - Math.max(mower[0], feed[0]));
		int y_intersect = Math.max(0, Math.min(mower[3], feed[3]) - Math.max(mower[1], feed[1]));
		return x_intersect * y_intersect;
	}
	public static int find_area(int[] a) {
		int length = a[2] - a[0];
		int height = a[3]-a[1];
		return height * length;
	}
	public static int find_state(int[] mower,int[]feed) {
		int[] p1 = {mower[0],mower[1]};
		int[] p2 = {mower[0],mower[3]};
		int[] p3 = {mower[2],mower[3]};
		int[] p4 = {mower[2],mower[1]};
		
		int count = 0;
		
		if(contains(p1,feed)) {
			count ++;
		}
		if(contains(p2,feed)) {
			count ++;
		}
		if(contains(p3,feed)) {
			count ++;
		}
		if(contains(p4,feed)) {
			count ++;
		}
		return count;
	}
	public static boolean contains(int[] point, int[]feed) {
		if(point[0] >= feed[0] && point[0] <= feed[2] && point[1] <= feed[3]  && point[1] >= feed[1]) {
			return true;
		}
		return false;
	}
}