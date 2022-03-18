import java.util.ArrayList;

public class permutations {
    static int[] lst = { 1, 2, 2, 3 };
    static int k = 4;
    static ArrayList<Integer> perm = new ArrayList<>();
    static boolean[] include = new boolean[k];

    public static void main(String[] args) {
        generate();
    }
    
    public static void generate() {
        if (perm.size() == k) {
            System.out.println(perm);
        }
        for (int i = 0; i < k; i++) {
            if (!include[i]) {
                perm.add(lst[i]);
                include[i] = true;
                generate();
                perm.remove(perm.indexOf(lst[i]));
                include[i] = false;
            }
        }
    }
}
