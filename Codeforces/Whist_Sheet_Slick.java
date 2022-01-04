import java.util.Scanner;
public class Whist_Sheet_Slick {
	/* Time: 202ms
	 * Basic function: There are 3 cases where the rectangles DO cover the entire white sheet. The first case is one 
	 * black sheet covers the white sheet, the second case is the two black sheets cover two corners each and are vertical,
	 * and the last case is that the two black sheets each cover two corners, but they are horizontal. We create 3 rectangle
	 * objects, then check if the black sheets cover up the rectangle. Beware the orientation does matter. In this code
	 * the given rectangle is the top and right rectangle of the two functions respectively.
	 */
	static class Rect {
		int x1;
		int y1;
		int x2;
		int y2;
		
		public Rect(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
		
		public boolean covers_completely(Rect white) {
			
			if(x1 <= white.x1 && y1 <= white.y1 && x2 >= white.x2 && y2 >= white.y2) {
				return true;
			}
			return false;
		}
		
		public boolean covers_vertically(Rect black2, Rect white) {
			
			if(x1 <= white.x1 && y1 <= white.y1 && x2 >= white.x2 && y2 >= white.y1 && 
					black2.x1 <= white.x1 && black2.y1 <= white.y2 && black2.x2 >= white.x2 && black2.y2 >= white.y2 && black2.y1 <= y2) {
				return true;
			}
			return false;
		}
		
		public boolean covers_horizantally(Rect black2, Rect white) {
			
			if(x1 <= white.x1 && y1 <= white.y1 && x2 >= white.x1 && y2 >= white.y2 && 
					black2.x1 <= white.x2 && black2.y1 <= white.y1 && black2.x2 >= white.x2 && black2.y2 >= white.y2 && black2.x1 <= x2) {
				return true;
			}
			return false;
		}
	}
	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		
		Rect white = new Rect(sc1.nextInt(),sc1.nextInt(),sc1.nextInt(),sc1.nextInt());
		Rect black1 = new Rect(sc1.nextInt(),sc1.nextInt(),sc1.nextInt(),sc1.nextInt());
		Rect black2 = new Rect(sc1.nextInt(),sc1.nextInt(),sc1.nextInt(),sc1.nextInt());
		
		if(black1.covers_completely(white) || black2.covers_completely(white)) {
			System.out.println("NO");
		}
		
		else if(black1.y2 >= black2.y2 && black2.covers_vertically(black1, white)) {
			System.out.println("NO");
		}
		
		else if(black2.y2 >= black1.y2 && black1.covers_vertically(black2, white)) {
			System.out.println("NO");
		}
		else if(black2.x2 >= black1.x2 && black1.covers_horizantally(black2, white)) {
			System.out.println("NO");
		}
		
		else if(black1.x2 >= black2.x2 && black2.covers_horizantally(black1, white)) {
			System.out.println("NO");
		}
		
		else {
			System.out.println("YES");
		}
	}
}
