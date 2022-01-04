import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.Rectangle;

public class Blcoked_Billboard_Function {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(new File("./billboard.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("./billboard.out"));
        int x1, y1, x2, y2;

        x1 = sc.nextInt(); y1 = sc.nextInt(); x2 = sc.nextInt(); y2 = sc.nextInt();
        Rectangle firstRect = new Rectangle(x1, -y2, x2-x1, y2-y1);
        x1 = sc.nextInt(); y1 = sc.nextInt(); x2 = sc.nextInt(); y2 = sc.nextInt();
        Rectangle secondRect = new Rectangle(x1, -y2, x2-x1, y2-y1);
        x1 = sc.nextInt(); y1 = sc.nextInt(); x2 = sc.nextInt(); y2 = sc.nextInt();
        Rectangle truck = new Rectangle(x1, -y2, x2-x1, y2-y1);

        long firstIntersect = getArea(firstRect.intersection(truck));
        long secondIntersect = getArea(secondRect.intersection(truck));
        pw.println(getArea(firstRect)+getArea(secondRect)
                        - firstIntersect - secondIntersect);
        pw.close();
		
	}
	public static long getArea(Rectangle r) {
		if (r.isEmpty()) return 0;
        return (long)r.getHeight()*(long)r.getWidth();
	}
}