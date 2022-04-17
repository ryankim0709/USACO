import java.util.*;
import java.io.*;

public class Chessboard_and_Queens {
	
	public static ArrayList<Integer> reservedx = new ArrayList<>();
	public static ArrayList<Integer> reservedy = new ArrayList<>();
	
	public static int count = 0;
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String status = "";
		String line = "";
		
		for (int x = 0; x < 8; x++) {
			line = br.readLine();
			
			for(int y = 0; y < 8; y ++) {
				status = String.valueOf(line.charAt(y));
				
				if(status.equals("*")) {
					System.out.println("x: "+x+" y: "+y);
					reservedx.add(x);
					reservedy.add(y);
				}
			}
		}
		System.out.println("hello");
		System.out.println(reservedx);
		System.out.println(reservedy);
		
		sets(new ArrayList<Integer>(), new ArrayList<Integer>());
	}
	
	public static void sets(ArrayList<Integer> xs, ArrayList<Integer> ys) {
		
		ArrayList<Integer> clonex = new ArrayList<>();
		ArrayList<Integer> cloney = new ArrayList<>();
		
		if(xs.size() == 8) {
			//System.out.println(xs);
			//System.out.println(ys);
			//System.out.println(count);
			count ++;
		}
		
		else {
			for(int x = 0; x < 8; x ++) {
				for(int y = 0;y < 8;y ++) {
					if(xs.contains(x) || ys.contains(y) || (reservedx.contains(x) && reservedy.get(reservedx.indexOf(x)) == y)) {
						continue;
					}
					else {
						clonex = (ArrayList<Integer>) xs.clone();
						cloney = (ArrayList<Integer>) ys.clone();
						clonex.add(x);
						cloney.add(y);
						
						sets(clonex, cloney);
					}
				}
			}
		}
	}
}
