import java.util.*;

import java.io.*;

public class mv2 {

    public static char[] typeAtBarn;
    public static Map<Integer, ArrayList<Integer>> given = new HashMap<>();
    public static int current = 0;
    // public static Map<Integer, Integer> finale = new HashMap<>();
    public static int[] finale = new int[100005];

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("milkvisits.in"));
        BufferedReader br = new BufferedReader(new FileReader("/Users/ryan/Desktop/milkvisits_silver_dec19/2.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int farms = Integer.parseInt(st.nextToken());
        int friends = Integer.parseInt(st.nextToken());

        for (int x = 1; x <= farms; x++) { // init the needed arrayLists
            given.put(x, new ArrayList<Integer>());
        }
        for (int x = 0; x < 100005; x++) {
            finale[x] = -1;
        }
        typeAtBarn = br.readLine().toCharArray();

        int start;
        int end;
        for (int x = 0; x < farms - 1; x++) { // parsing
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            given.get(start).add(end);
            given.get(end).add(start);
        }

        for (int x = 1; x <= farms; x++) {
            if (finale[x] == -1) {
                current++;
                dfs(x);
            }
        }
        char pref;
        for (int x = 0; x < friends; x++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            pref = st.nextToken().charAt(0);

            if (x == 1683) {
                System.out.print(x);
                System.out.print(' ');
                System.out.print(start);
                System.out.print(' ');
                System.out.print(end);
                System.out.print(' ');
                System.out.print(pref);
                System.out.print(' ');
                System.out.print('\n');
                System.out.print(typeAtBarn[start - 1]);
                System.out.print(' ');
                System.out.print(finale[start]);
                System.out.print(' ');
                System.out.print(finale[end]);
                System.out.print(' ');
                System.out.print('\n');
            }

            if (typeAtBarn[start - 1] == pref || finale[start] != finale[end]) {
                // System.out.print(1);
                pw.print(1);
            } else {
                // System.out.print(0);
                pw.print(0);
            }
        }
        pw.close();
        br.close();
    }

    public static void dfs(int curr) {

        if (finale[curr] != -1) {
            return;
        }

        finale[curr] = current;

        for (int x : given.get(curr)) {
            if (typeAtBarn[x - 1] == typeAtBarn[curr - 1]) {
                dfs(x);
            }
        }
    }
}
