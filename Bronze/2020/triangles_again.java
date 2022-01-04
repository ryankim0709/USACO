import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class triangles_again {
	public static void main(String args[]) {
		Scanner sc1;
		ArrayList<int[]> coordinates = new ArrayList<>();
		int[] coordinate_pairs = new int[2];
		int number_of_coords = 0;
		
		try {
			sc1 = new Scanner(new File("/triangles_bronze_feb20/10.in"));
			number_of_coords = sc1.nextInt();
			
			for(int x = 0; x < number_of_coords; x++) {
				sc1.nextLine();
				coordinate_pairs[0] = sc1.nextInt();
				coordinate_pairs[1] = sc1.nextInt();
				coordinates.add(coordinate_pairs.clone());
			}
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		int[] coord_a = new int[2];
		int[] coord_b = new int[2];
		int[] coord_c = new int[2];
		double max_area = 0;
		for (int x = 0; x < number_of_coords;x++) {
			for (int y = x+1; y < number_of_coords;y++) {
				for(int z = y + 1; z < number_of_coords;z++) {
					coord_a = coordinates.get(x).clone();
					coord_b = coordinates.get(y).clone();
					coord_c = coordinates.get(z).clone();
					
					if (check_parallel(coord_a,coord_b,coord_c)) {
						if(find_area(coord_a,coord_b,coord_c) > max_area) {
							max_area = find_area(coord_a,coord_b,coord_c);
						}
						//System.out.println("X: "+x+" Y: "+y+" Z: "+z);
					}
				}
			}
		}
		System.out.println( max_area * 2);
	}
	
	public static boolean check_parallel(int[] a,int[] b, int[] c) {
		
		if((a[1] == b[1] || b[1] == c[1] || a[1] == c[1]) &&
				(a[0] == b[0] || b[0] == c[0] || a[0] == c[0])) {
			return true;
		}
		return false;
	}
	
	public static double find_area(int[] coord_a,int[] coord_b, int[] coord_c) {
		double[] lengths = new double[3];
		lengths[0] = find_length(coord_a,coord_b);
		lengths[1] = find_length(coord_a,coord_c);
		lengths[2] = find_length(coord_b,coord_c);
		Arrays.sort(lengths);
		double area = 0.5 * lengths[0] * lengths[1];
		return area;
	}
	
	public static double find_length(int[] coord_a,int[]coord_b) {
		double distance = Math.pow(coord_b[0]-coord_a[0], 2) + Math.pow(coord_b[1] - coord_a[1], 2);
		distance = Math.sqrt(distance);
		return distance;
	}
}