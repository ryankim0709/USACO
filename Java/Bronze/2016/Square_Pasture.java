import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*Slowest time: 312 ms
 Basic function: Find the min and max of the x and y coords. Then there are two possible lengths of the squares, the diff of the x's and y's.
 Take the greater one, then square.
 */
public class Square_Pasture {
	public static void main(String[] args) throws IOException{
		
		Scanner sc1 = new Scanner(new File("./square.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("./square.out")));
		
		int[] first = new int[4];
		int[] second = new int[4];
		
		int maxx = sc1.nextInt();
		int maxy = sc1.nextInt();
		int minx = maxx;
		int miny = maxy;
		
		first[0] = maxx;
		first[1] = maxy;
		
		int num = 0;
		for(int x = 2; x < 4;x++) {
			num =  sc1.nextInt();
			first[x] = num;
			
			if(x % 2 == 1 && num > maxy) {
				maxy = num;
			}
			
			else if(x % 2 == 1 && num < miny) {
				miny = num;
			}
			
			else if(x % 2 == 0 && num > maxx) {
				maxx = num;
			}
			
			else if(x % 2 == 0 && num < minx) {
				minx = num;
			}
		}
		sc1.nextLine();
		
		for(int x = 0; x < 4;x++) {
			num = sc1.nextInt();
			second[x] = num;
			
			if(x % 2 == 1 && num > maxy) {
				maxy = num;
			}
			
			else if(x % 2 == 1 && num < miny) {
				miny = num;
			}
			
			else if(x % 2 == 0 && num > maxx) {
				maxx = num;
			}
			
			else if(x % 2 == 0 && num < minx) {
				minx = num;
			}
		}
		
		int poss1 = maxx - minx;
		int poss2 = maxy - miny;
		
		pw.print(Math.max(poss1, poss2) * Math.max(poss1, poss2));
		pw.close();
		
	}
}
