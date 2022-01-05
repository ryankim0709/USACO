import java.util.*;
import java.io.*;

public class towers {
    public static void main(String[] args) throws IOException {
        /*
         * Is there to implement hashmap?? Since hashmap is O(1) it would be much faster
         * Let's say that you were given sizes [3,2], you use one box [3,2] -sort->
         * [2,3]
         * 
         * 3 2 [3] -> [2] <=> 1
         * 
         * 2 3 [2] -> [2,3] <=> 2 X
         * 
         * App 1: Process while scanning (Results: This actually does not time out, but
         * there are wrong answers. We can't use this method because duplicates can not
         * be handled by TreeSet) TreeSet Add int.MAX_VALUE [] -> 3 -> [3,8] -> [2,8] ->
         * [1,8] -> [1,5] Use cieling function, remove, then append again.
         * 
         * time complexity (3 * log(n)) * n = O(nlog(n)) -> too long
         * 
         * // TreeSet<Integer> powers = new TreeSet<>();
         * 
         * // powers.add(Integer.MAX_VALUE);
         * 
         * // st = new StringTokenizer(br.readLine());
         * 
         * // int len; // int num; // for(int x = 0; x < cubes; x++) { // len =
         * Integer.parseInt(st.nextToken()); // num = powers.higher(len); //
         * //System.out.println(len +" "+num); // if(num == (Integer.MAX_VALUE)) { //
         * powers.add(len); // } else { // powers.remove(num); // powers.add(len); // }
         * // } // System.out.println(powers.size() - 1);
         * 
         * App 2: Using array, but MAINTAIN sortedness
         * 
         * Create array and fill with 10^9 + 1
         * 
         * 5 3 8 2 1 5 1
         * 
         * [1, 5, 1, MAXVAL, MAXVAL]
         * 
         * Make my own higher function BUT RETURN THE INDEX. This we can insert in such
         * a way that the array is already sorted. This way, we cut down on nlog(n) for
         * every computation
         * 
         * Time complexity: Since we traverse our array each iteration, the time
         * complexity would be O(n^2).... Still worth a shot though
         * 
         * 
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cubes = Integer.parseInt(st.nextToken());

        TreeMap<Integer, Integer> towers = new TreeMap<>();
        towers.put(Integer.MAX_VALUE, 0);

        int num;
        int len;

        st = new StringTokenizer(br.readLine());
        int ans = 0;
        for (int x = 0; x < cubes; x++) {
            len = Integer.parseInt(st.nextToken());
            num = towers.higherKey(len);
            // System.out.println(towers + " " + len + " " + num + " " +
            // towers.containsKey(5));

            if (num == Integer.MAX_VALUE) {
                // System.out.println(len + " " + towers);
                if (towers.containsKey(len)) {
                    towers.put(len, towers.get(len) + 1);
                } else {
                    towers.put(len, 1);
                }
                ans++;
            } else {
                if (towers.get(num) == 1) {
                    towers.remove(num);
                } else {
                    towers.put(num, towers.get(num) - 1);
                }
                if (towers.containsKey(len)) {

                    towers.put(len, towers.get(len) + 1);
                } else {
                    towers.put(len, 1);
                }
            }
        }
        System.out.println(ans);
    }
}
