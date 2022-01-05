import java.util.*;
import java.io.*;

public class berry_picking {
    static int[] bpt;
    static int baskets;
    static int trees;

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new FileReader("berries.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("berries.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        trees = Integer.parseInt(st.nextToken());
        baskets = Integer.parseInt(st.nextToken());

        bpt = new int[trees];
        st = new StringTokenizer(br.readLine());

        int hi = -1;

        for (int x = 0; x < trees; x++) {
            bpt[x] = Integer.parseInt(st.nextToken());
            hi = Math.max(bpt[x], hi);
        }

        Arrays.sort(bpt);

        br.close();

        int ans = 0;

        for (int x = 1; x <= hi; x++) {
            // System.out.println(x + " " + berries(x));
            ans = Math.max(ans, berries(x));
        }
        // System.out.println(valid(6));
        // System.out.println(ans);
        pw.print(ans);
        pw.close();
    }

    public static int berries(int perBasket) {
        int canFill = 0;
        int[] leftOver = new int[trees];

        for (int x = 0; x < trees; x++) {
            canFill += bpt[x] / perBasket;
            leftOver[x] = bpt[x] % perBasket;
        }

        if (canFill >= baskets / 2) {
            Arrays.sort(leftOver);
            int amountMore = Math.max(baskets / 2 - (canFill - baskets / 2), 0);
            int curr = perBasket * (baskets / 2 - amountMore);
            for (int x = 0; x < amountMore; x++) {
                if (trees - x - 1 < 0) {
                    continue;
                }
                curr += leftOver[trees - x - 1];
            }
            // System.out.println("Per basket: " + perBasket + " " + "Curr sum: " + curr + "
            // " + "Amount more: "
            // + amountMore + " " + "Can fill: " + canFill);
            return curr;
        }
        return -1;
    }
}
