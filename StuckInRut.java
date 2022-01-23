import java.util.*;
import java.io.*;

public class StuckInRut {
    static class Cow implements Comparable<Cow> {
        int x, y, index;
        char type;

        public Cow(int x, int y, int index, char type) {
            this.x = x;
            this.y = y;
            this.index = index;
            this.type = type;
        }

        public int compareTo(Cow a) {
            if (a.type == 'E') {
                if (this.y - a.y == 0) {
                    return this.x - a.x;
                }
                return this.y - a.y;
            }
            if (this.x - a.x == 0) {
                return this.y - a.y;
            }
            return this.x - a.x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Cow> northCows = new ArrayList<>();
        ArrayList<Cow> eastCows = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            if (st.nextToken().charAt(0) == 'E') {
                eastCows.add(new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i, 'E'));
            } else {
                northCows.add(new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i, 'N'));
            }
        }
        Collections.sort(northCows); // Sort by X value
        Collections.sort(eastCows); // Sort by Y value

        int[] blame = new int[2501];
        boolean[] stopped = new boolean[2501];

        for (Cow east : eastCows) {
            for (Cow north : northCows) {
                // Check if cows will meet and see if they have been stopped
                if (east.x <= north.x && east.y >= north.y && !stopped[east.index] && !stopped[north.index]) {
                    int eastDist = north.x - east.x;
                    int northDist = east.y - north.y;

                    if (northDist < eastDist) { // North stops east
                        stopped[east.index] = true;
                        blame[north.index] += blame[east.index] + 1;
                    } else if (eastDist < northDist) {
                        stopped[north.index] = true;
                        blame[east.index] += blame[north.index] + 1;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(blame[i]);
        }
    }
}