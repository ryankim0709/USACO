import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;

public class Mowing_The_Field {
	public static void main(String args[]) {
		Scanner sc1;
		char[] dirrection = null;
		int[] length = null;
		int total_moves = 0;
		ArrayList<int[]> coordinates = new ArrayList<>();
		int[] coords = {0,0};
		coordinates.add(coords);
		
		try {
			sc1 = new Scanner(new File("/Users/youjungkim/DropBox/ryankim/usaco/mowing_bronze_jan16/10.in"));
			total_moves = sc1.nextInt();
			sc1.nextLine();
			dirrection = new char[total_moves];
			length = new int[total_moves];
			for (int x = 0; x < total_moves;x++) {
				String moves = sc1.nextLine();
				dirrection[x] = moves.charAt(0);
				length[x] = Integer.parseInt(moves.substring(2, moves.length()));
			}
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		
		for (int x = 0; x < total_moves;x++) {
			if(dirrection[x] == 'N') {
				move_north(coordinates,length[x]);
			}
			if(dirrection[x] == 'E') {
				move_east(coordinates,length[x]);
			}
			if(dirrection[x] == 'S') {
				move_south(coordinates,length[x]);
			}
			if(dirrection[x] == 'W') {
				move_west(coordinates,length[x]);
			}
		}

		int min = 2000000000;
		for(int x = 0; x < coordinates.size();x++) {
			for (int y = 0; y < coordinates.size();y++) {
				if(check(coordinates.get(x),coordinates.get(y)) && x != y && Math.abs(x-y) < min) {
					min = Math.abs(x-y);
				}
			}
		}
		if (min == 2000000000) {
			System.out.println(-1);
		}
		else {
			System.out.println(min);
		}
	}
	public static boolean check (int[] first, int[] second) {
		if(first[0] == second[0] && first[1] == second[1]) {
			return true;
		}
		return false;
	}
	public static void move_north(ArrayList<int[]> coordinates,int amount) {
		int[] coord = coordinates.get(coordinates.size()-1).clone();
		for (int x = 0; x < amount;x++) {
			coord[0] = coord[0];
			coord[1] = coord[1] + 1;
			coordinates.add(coord.clone());
		}
	}
	public static void move_east(ArrayList<int[]> coordinates,int amount) {
		int[] coord = coordinates.get(coordinates.size()-1).clone();
		for (int x = 0; x < amount;x++) {
			coord[0] = coord[0] + 1;
			coord[1] = coord[1];
			coordinates.add(coord.clone());
		}
	}
	public static void move_south(ArrayList<int[]> coordinates,int amount) {
		int[] coord = coordinates.get(coordinates.size()-1).clone();
		for (int x = 0; x < amount;x++) {
			coord[0] = coord[0];
			coord[1] = coord[1] - 1;
			coordinates.add(coord.clone());
		}
	}
	public static void move_west(ArrayList<int[]> coordinates,int amount) {
		int[] coord = coordinates.get(coordinates.size()-1).clone();
		for (int x = 0; x < amount;x++) {
			coord[0] = coord[0] - 1;
			coord[1] = coord[1];
			coordinates.add(coord.clone());
		}
	}
}