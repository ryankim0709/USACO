import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
public class Field_Reduction {
	public static void main(String[] args) throws IOException {
		/*
		 Slowest time:1921
		 Basic function: find the minimum and maximum x's and y's, then find the coordinate using a big ArrayList.
		 Exclude that point and find that area. Put into final ArrayList and the first index is the smallest.
		 */
		Scanner sc1 = new Scanner(new File("./reduce.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("./reduce.out")));
		
		int cows = sc1.nextInt();
		
		ArrayList<Integer> coordinates = new ArrayList<>();
		ArrayList<Integer> x_coord = new ArrayList<>();
		ArrayList<Integer> y_coord = new ArrayList<>();
		
		int x_coordinate = 0;
		int y_coordinate = 0;
		for(int x = 0; x < cows;x++) {
			sc1.nextLine();
			
			x_coordinate = sc1.nextInt();
			y_coordinate = sc1.nextInt();
			
			coordinates.add(x_coordinate);
			coordinates.add(y_coordinate);
			x_coord.add(x_coordinate);
			y_coord.add(y_coordinate);
		}
		
		x_coord.sort(null);
		y_coord.sort(null);
		
		ArrayList<Integer> areas = new ArrayList<>();
		
		int corresponding = 0;
		int max_x = x_coord.get(cows-1);
		corresponding = coordinates.get(coordinates.indexOf(max_x) + 1);
		areas.add(without_point(x_coord,y_coord,max_x,corresponding));
		
		int min_x = x_coord.get(0);
		corresponding = coordinates.get(coordinates.indexOf(min_x) + 1);
		areas.add(without_point(x_coord,y_coord,min_x,corresponding));
		
		int max_y = y_coord.get(cows-1);
		corresponding = coordinates.get(coordinates.lastIndexOf(max_y) - 1);
		areas.add(without_point(x_coord,y_coord,corresponding,max_y));
		
		int min_y = y_coord.get(0);
		corresponding = coordinates.get(coordinates.lastIndexOf(min_y) - 1);
		areas.add(without_point(x_coord,y_coord,corresponding,min_y));
		
		areas.sort(null);
		
		pw.print(areas.get(0));
		pw.close();
	}
	
	public static int without_point(ArrayList<Integer> x_coords, ArrayList<Integer> y_coords, int x, int y) {
		
		ArrayList<Integer>x_coord = (ArrayList<Integer>) x_coords.clone();
		ArrayList<Integer>y_coord = (ArrayList<Integer>) y_coords.clone();
		x_coord.remove(x_coord.indexOf(x));
		y_coord.remove(y_coord.indexOf(y));
		
		int cows = x_coord.size();
		int max_x = x_coord.get(cows-1);
		int min_x = x_coord.get(0);
		int max_y = y_coord.get(cows-1);
		int min_y = y_coord.get(0);
		
		int height = max_y - min_y;
		int length = max_x - min_x;
		
		return height * length;
	}
}
