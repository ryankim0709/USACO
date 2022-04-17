import java.util.*;
import java.io.*;

public class family_tree {
    static HashMap<String, HashSet<String>> descendants = new HashMap<>();
    static HashMap<String, String> mothers = new HashMap<>();
    static String a = "";
    static String b = "";
    static boolean finished = false;
    static String finalAns = "";

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("family.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("family.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        a = st.nextToken();
        b = st.nextToken();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String mother = st.nextToken();
            String child = st.nextToken();

            descendants.putIfAbsent(mother, new HashSet<>());
            descendants.get(mother).add(child);
            mothers.put(child, mother);
        }

        solve();
        //System.out.println(finalAns);
        pw.print(finalAns);
        pw.close();
        br.close();
    }
    
    public static void solve() {
        if (areSiblings()) {
            finalAns = "SIBLINGS";
            return;
        }
        else if (isDescendant(a, 0, a, b) || isDescendant(b, 0, b, a) || finished) {
            return;
        }
        else if (isAunt(a, 0, mothers.get(b), a, b) || isAunt(b, 0, mothers.get(a), b, a) || finished) {
            return;
        }
        else if (areCousins() || finished) {
            return;
        }
        finalAns = "NOT RELATED";
    }

    public static boolean areSiblings() {
        mothers.putIfAbsent(a, "");
        mothers.putIfAbsent(b, "");
        return mothers.get(a).equals(mothers.get(b));
    }

    public static boolean isDescendant(String current, int step, String kid, String mom) {
        if (current.equals(mom)) {
            String ans = "";
            for (int i = 0; i < step - 2; i++) {
                ans += "great-";
            }
            finalAns = mom + " is the " + ans + "grand-mother of " + kid;
            if (step == 1) {
                finalAns = mom + " is the mother of " + kid;
            }
            finished = true;
            return true;
        }
        mothers.putIfAbsent(current, "");
        if (mothers.get(current) == "") {
            return false;
        }
        isDescendant(mothers.get(current), step + 1,kid, mom);
        return false;
    }

    public static boolean isAunt(String current, int step, String goal, String kid, String mom) {
        if (current.equals(goal)) {
            String ans = "";
            for (int i = 0; i < step - 2; i++) {
                ans += "great-";
            }
            finalAns = mom + " is the " + ans + "aunt of " + kid;
            finished = true;
            return true;
        }
        mothers.putIfAbsent(current, "");
        if (mothers.get(current) == "") {
            return false;
        }
        isAunt(mothers.get(current), step + 1, goal, kid, mom);
        return false;
    }

    public static boolean areCousins() {
        HashSet<String> aFam = new HashSet<>();
        HashSet<String> bFam = new HashSet<>();

        getFam(aFam, a);
        getFam(bFam, b);

        for (String i : aFam) {
            if (bFam.contains(i)) {
                finalAns = "COUSINS";
                return true;
            }
        }
        return false;
    }

    public static void getFam(HashSet<String> family, String curr) {
        family.add(curr);
        mothers.putIfAbsent(curr, "");
        if (mothers.get(curr).equals("")) {
            return;
        }
        getFam(family, mothers.get(curr));
    }
}
