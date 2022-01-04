import java.util.Scanner;
import java.io.File;

public class mad_scientist {
	public static void main(String args[]) {
		Scanner sc1;
		char[] list_a = null;
		char[] list_b = null;
		int count = 0;
		
		try {
			
			boolean order_a = true;
			
			sc1 = new Scanner(new File("/Users/youjungkim/DropBox/ryankim/usaco/breedflip_bronze_feb20/10.in"));
			int length = Integer.parseInt(sc1.nextLine());
			list_a = new char[length];
			list_b = new char[length];
			
			String order = sc1.nextLine();
			
			for (int x = 0; x < length;x ++) {
				list_a[x] = order.charAt(x);
			}
			order = sc1.nextLine();
			for (int x = 0; x < length;x ++) {
				list_b[x] = order.charAt(x);
			}
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		
		count = 0;
		for (int x = 0; x < list_a.length;x++) {
			if (list_a[x] != list_b[x]) {
				count ++;
				x ++;
				while (list_a[x] != list_b[x] && x < list_a.length-1) {
					x ++;
				}
			}
		}
		System.out.println(count);
	}

}