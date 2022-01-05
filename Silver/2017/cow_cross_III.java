import java.util.*;
import java.io.*;

public class cow_cross_III {
    static class cow {
        int x, y, id;
        public cow(int x, int y, int id) {
            this.x = x; this.y = y; this.id = id;
        }
    }

    static class road {
        int x1, y1, x2, y2;
        public road(int x1, int y1, int x2, int y2) {
            this.x1 = x1; this.y1 = y1;
            this.x2 = x2; this.y2 = y2;
        }
    }
    static HashSet<String> roads = new HashSet<>();
    static char[][] graph;
    static HashSet<cow> cows = new HashSet<>();

    static HashSet<Integer> visited = new HashSet<>();
    static ArrayList<Integer> perRegion = new ArrayList<>();

    static int N;
    
    static int numCows;
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("countcross.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("countcross.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        graph = new char[N][N];

        for(int x = 0; x < R; x++) {   
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken()) - 1; int second = Integer.parseInt(st.nextToken()) - 1;
            int third = Integer.parseInt(st.nextToken()) - 1; int fourth = Integer.parseInt(st.nextToken()) - 1;
            String fstring = String.valueOf(first) +" "+ String.valueOf(second)+" "+String.valueOf(third)+" "+String.valueOf(fourth);
            roads.add(fstring);
            fstring = String.valueOf(third) +" "+ String.valueOf(fourth)+" "+String.valueOf(first)+" "+String.valueOf(second);
            roads.add(fstring);
        }

        for(int x = 0; x < K; x++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken()) - 1;
            int second = Integer.parseInt(st.nextToken()) - 1;
            graph[first][second] = 'c';
            cows.add(new cow(first, second, x));
        }
        br.close();
        for(cow a:cows) {
            if(!visited.contains(a.id)) {
                numCows = 0;
                flood(a.x, a.y);
                perRegion.add(numCows);
            }
        }
        int ans = 0;

        int size = perRegion.size();
        for(int x = 0; x < size; x++) {
            for(int y = 0; y < size; y++) {
                if(x == y) {
                    continue;
                }
                ans += perRegion.get(x) * perRegion.get(y);
            }
        }
        //System.out.println(ans/2);
        pw.print(ans/2);
        pw.close();
    }
    public static void flood(int x , int y) {
        if(x == -1 || x == N || y == -1 || y == N || graph[x][y] == 'v') {
            return;
        }
        graph[x][y] = 'v';
        if(isCow(x, y)) {
            numCows ++;
        }

        if(!isRoad(x, y, x-1, y)) flood(x-1, y);
        if(!isRoad(x, y, x+1, y)) flood(x+1, y);
        if(!isRoad(x, y, x, y-1)) flood(x, y-1);
        if(!isRoad(x, y, x, y+1)) flood(x, y+1);
    }

    public static boolean isCow(int x, int y) {
        for(cow a:cows) {
            if(a.x == x && a.y == y) {
                visited.add(a.id);
                return true;
            }
        }
        return false;
    }

    public static boolean isRoad(int x, int y, int x1, int y1) {
        String fstring = String.valueOf(x)+" "+String.valueOf(y)+" "+String.valueOf(x1)+" "+String.valueOf(y1);
        if(roads.contains(fstring)) return true;
        fstring = String.valueOf(x1)+" "+String.valueOf(y1)+" "+String.valueOf(x)+" "+String.valueOf(y);
        if(roads.contains(fstring)) return true;
        return false;
    }
}
