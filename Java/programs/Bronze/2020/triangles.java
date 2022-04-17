import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;

public class triangles {
	public static void main(String args[]) {
		Scanner sc1;
		
		try {
			sc1 = new Scanner(new File("/triangles_bronze_feb20/8.in"));
			//System.out.print("How many coordinates?");
			int coord_num = Integer.parseInt(sc1.nextLine());
			ArrayList<int[]> master_coord = new ArrayList<>();
			int[] given_coord = new int[2];
			int count = 0;
			int[] a = new int[2];
			int[] b = new int[2];
			int[] c = new int[2];
			
			for (int x = 0; x < coord_num;x++) {
				//System.out.print("Enter a corrdinate pair");
				String coordinates = sc1.nextLine();
				
				Scanner coords = new Scanner(coordinates);
				
				while (coords.hasNext()) {
					given_coord[count] = coords.nextInt();
					count ++;
				}
				
				master_coord.add(given_coord.clone());
				count = 0;
			}
			
			double max_area = 0;
			for (int x = 0; x < master_coord.size() ;x++) {
				for (int y = x + 1;y < master_coord.size() ;y++) {
					for (int z = x + 2; z < master_coord.size() ;z++) {
						a = master_coord.get(x);
						b = master_coord.get(y);
						c = master_coord.get(z);
						
						if (find_area(a,b,c) > max_area) {
							
							max_area = find_area(a,b,c);
						}
					}
				}
			}
			System.out.println(max_area*2);
		}
		catch (Exception e)
		{
	       e.getStackTrace();		
		}
		
	}
	public static double find_area(int[]a,int[] b,int[] c) {
		double[] sides = new double[3];
		
		if (a == b || a == c|| b == c) {
			//System.out.println("Here");
			return 0;
		}
		
		if (!parallel(a,b,c)) {
			return 0;
		}
		sides[0] = length(a,b);
		sides[1] = length(b,c);
		sides[2] = length(a,c);
		
		Arrays.sort(sides);
		/*for (double d:sides) {
			System.out.println(d);
		}
		double answer = (0.5) * 1;
		System.out.println(answer);
		*/
		return (0.5) * (sides[0]) * (sides[1]);
	}
	
	public static boolean parallel(int[] a,int[] b,int[]c) {
		
		
		if (a[0] == b[0] || b[0] == c[0] || a[0] == c[0]) {
			if (a[1] == b[1] || b[1] == c[1] || a[1] == c[1]) {
				return true;
			}
		}
		
		return false;
	}
	
	public static double length(int[] a, int[] b) {
		double len = (b[0] - a[0]);
		len = Math.pow(len, 2);
		double len2 = (b[1] - a[1]);
		len2 = (Math.pow(len2, 2));
		double length = len + len2;
		length = Math.sqrt(length);
		return length;
	}
}