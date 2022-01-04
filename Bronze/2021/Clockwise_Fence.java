import java.util.Scanner;
public class Clockwise_Fence {
	public static void main(String[] args) {
		
		/*
		 Slowest time 354 ms.
		 
		 Basic function: We find the number of times we turn right or left. If we turn left more than we
		 turn right, then FJ went counterclockwise, otherwise, FJ went clockwise. There are a total of 8 cases 
		 because if previous and current char are same, we are going straight, and we can't go backwards.
		 Studying BufferedReader + StreamTokenizer. Sorry for using Scanner. Hope this helped.
		 */
		Scanner sc1 = new Scanner(System.in);
		
		int fences = sc1.nextInt();
		int left = 0;
		int right = 0;
		int length = 0;
		char previous = 'N';
		char current = ' ';
		String fence = "";
		for(int x = 0; x < fences;x++) {
			sc1.nextLine();
			fence = sc1.next();
			length = fence.length();
			right = 0;
			left = 0;
			for(int y = 0; y < length;y++) {
				current = fence.charAt(y);
				
				if(previous == 'N') {
					if(current == 'E') {
						right ++;
					}
					else if(current == 'W') {
						left ++;
					}
				}
				
				else if(previous == 'E') {
					if(current == 'S') {
						right ++;
					}
					else if(current == 'N') {
						left ++;
					}
				}
				
				else if(previous == 'S') {
					if(current == 'W') {
						right ++;
					}
					else if(current == 'E') {
						left ++;
					}
				}
				else {
					if(current == 'N' ) {
						right ++;
					}
					else if(current == 'S') {
						left ++;
					}
				}
				previous = current;
			}
			//System.out.println("Left: "+left);
			//System.out.println("Right: "+right);
			if(left > right) {
				System.out.println("CCW");
			}
			else {
				System.out.println("CW");
			}
		}

	}
}
