import java.util.*;
import java.io.*;

public class cross_country_skiing {
    public static int[][] course;
    public static boolean[][] arr;
    public static boolean[][] waypoints;
    public static int row;
    public static int column;

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("ccski.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("ccski.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());

        course = new int[row][column];
        waypoints = new boolean[row][column];

        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int x = 0; x < row; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < column; y++) {
                course[x][y] = Integer.parseInt(st.nextToken());
                min = Math.min(min, course[x][y]);
                max = Math.max(max, course[x][y]);
            }
        }

        int wayx = 0;
        int wayy = 0;
        for (int x = 0; x < row; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < column; y++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    waypoints[x][y] = true;
                }
            }
        }

        int low = 0;
        int high = max - min;
        int mid;

        while (low < high) {
            arr = new boolean[row][column];
            mid = low + (high - low) / 2;
            build(wayx, wayy, mid);
            if (canGetTo()) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        // System.out.println(high);
        pw.print(high);
        pw.close();
        br.close();
    }

    public static boolean canGetTo() {
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < column; y++) {
                if (waypoints[x][y] && !arr[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void build(int x, int y, int D) {
        arr[x][y] = true;
        checkUp(x, y, D);
        checkDown(x, y, D);
        checkLeft(x, y, D);
        checkRight(x, y, D);
    }

    public static void checkUp(int x, int y, int D) {
        int newx = x - 1;
        int newy = y;

        if (newx == -1) {
            return;
        } else {
            if (arr[newx][newy]) {
                return;
            }
            if (Math.abs(course[newx][newy] - course[x][y]) <= D) {
                build(newx, newy, D);
            }
        }
    }

    public static void checkDown(int x, int y, int D) {
        int newx = x + 1;
        int newy = y;

        if (newx == course.length) {
            return;
        } else {
            if (arr[newx][newy]) {
                return;
            }
            if (Math.abs(course[newx][newy] - course[x][y]) <= D) {
                build(newx, newy, D);
            }
        }
    }

    public static void checkRight(int x, int y, int D) {
        int newx = x;
        int newy = y + 1;

        if (newy == course[0].length) {
            return;
        } else {
            if (arr[newx][newy]) {
                return;
            }
            if (Math.abs(course[newx][newy] - course[x][y]) <= D) {
                build(newx, newy, D);
            }
        }
    }

    public static void checkLeft(int x, int y, int D) {
        int newx = x;
        int newy = y - 1;

        if (newy == -1) {
            return;
        } else {
            if (arr[newx][newy]) {
                return;
            }
            if (Math.abs(course[newx][newy] - course[x][y]) <= D) {
                build(newx, newy, D);
            }
        }
    }
}
