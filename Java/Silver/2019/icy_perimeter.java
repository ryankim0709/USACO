import java.io.*;

public class icy_perimeter {
    public static int area;
    public static int perimeter;
    public static char[][] picture;

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("perimeter.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
        int size = Integer.parseInt(br.readLine());

        picture = new char[size][size];

        String line = "";
        for (int x = 0; x < size; x++) {
            line = br.readLine();
            for (int y = 0; y < size; y++) {
                picture[x][y] = line.charAt(y);
            }
        }
        int ansArea = 0;
        int ansPerimeter = 0;
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (picture[x][y] == '#') {
                    area = 0;
                    perimeter = 0;
                    findMeasures(x, y);

                    if (area > ansArea) {
                        ansArea = area;
                        ansPerimeter = perimeter;
                    } else if (area == ansArea) {
                        ansPerimeter = Math.min(ansPerimeter, perimeter);
                    }
                }
            }
        }
        // System.out.println(ansArea + " " + ansPerimeter);
        pw.print(ansArea + " " + ansPerimeter);
        pw.close();
        br.close();
    }

    public static void findMeasures(int x, int y) {
        area++;
        picture[x][y] = 'v';
        checkLeft(x, y);
        checkUp(x, y);
        checkDown(x, y);
        checkRight(x, y);
    }

    public static void checkLeft(int x, int y) {
        int newx = x;
        int newy = y - 1;

        if (newy == -1) {
            perimeter++;
            return;
        } else {
            if (picture[newx][newy] == '#') {
                findMeasures(newx, newy);
                return;
            } else if (picture[newx][newy] == '.') {
                perimeter++;
                return;
            }
        }
    }

    public static void checkUp(int x, int y) {
        int newx = x - 1;
        int newy = y;

        if (newx == -1) {
            perimeter++;
            return;
        } else {
            if (picture[newx][newy] == '#') {
                findMeasures(newx, newy);
                return;
            } else if (picture[newx][newy] == '.') {
                perimeter++;
                return;
            }
        }
    }

    public static void checkDown(int x, int y) {
        int newx = x + 1;
        int newy = y;

        if (newx == picture.length) {
            perimeter++;
            return;
        } else {
            if (picture[newx][newy] == '#') {
                findMeasures(newx, newy);
                return;
            } else if (picture[newx][newy] == '.') {
                perimeter++;
                return;
            }
        }
    }

    public static void checkRight(int x, int y) {
        int newx = x;
        int newy = y + 1;
        if (newy == picture.length) {
            perimeter++;
            return;
        } else {
            if (picture[newx][newy] == '#') {
                findMeasures(newx, newy);
                return;
            } else if (picture[newx][newy] == '.') {
                perimeter++;
                return;
            }
        }
    }
}