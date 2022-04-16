import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Fence_Painting {
	public static void main(String args[]) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("./paint.out")));
			Scanner sc1 = new Scanner(new File("./paint.in"));
			int[] FJ = {sc1.nextInt(),sc1.nextInt()};
			int[] Bessie = {sc1.nextInt(),sc1.nextInt()};
			//System.out.println("Farmer John "+FJ[0]+" "+FJ[1]);
			//System.out.println("Bessie "+Bessie[0]+" "+Bessie[1]);
			if(FJ[0] < Bessie[0] && FJ[1] > Bessie[0] && FJ[1] < Bessie[1]) {
				//System.out.println("Here");
				// -------FJ
				//     --------Bessie
				//System.out.println(Bessie[1] - FJ[0]);
				pw.println(Bessie[1] - FJ[0]);
				pw.close();
			}
			else if(FJ[0] > Bessie[0] && FJ[1] > Bessie[1] && FJ[0] < Bessie[1]) {
				//    ------FJ
				//------Bessie
				//System.out.println(FJ[1] - Bessie[0]);
				pw.println(FJ[1] - Bessie[0]);
				pw.close();
			}
			else if(FJ[0] >= Bessie[0] && FJ[1] <= Bessie[1]) {
				//System.out.println(Bessie[1] - Bessie[0]);
				pw.println(Bessie[1] - Bessie[0]);
				pw.close();
			}
			else if(FJ[0] <= Bessie[0] && FJ[1] >= Bessie[1]) {
				//System.out.println(FJ[1] - FJ[0]);
				pw.println(FJ[1] - FJ[0]);
				pw.close();
			}
			else if(FJ[0] == Bessie[0] && FJ[1] == Bessie[1]) {
				//System.out.println(Bessie[1] - Bessie[0]);
				pw.println(Bessie[1] - Bessie[0]);
				pw.close();
			}
			else {
				//System.out.println((Bessie[1] - Bessie[0]) + (FJ[1] - FJ[0]));
				pw.println((Bessie[1] - Bessie[0]) + (FJ[1] - FJ[0]));
				pw.close();
			}
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}
}