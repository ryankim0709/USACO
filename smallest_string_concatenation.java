import java.util.*;
import java.io.*;

public class smallest_string_concatenation {
    static class Segment implements Comparable<Segment> {
        String word;

        public Segment(String word) {
            this.word = word;
        }

        public int compareTo(Segment a) {
            String first = this.word + a.word;
            String second = a.word + this.word;

            for (int x = 0; x < first.length(); x++) {
                if (first.charAt(x) > second.charAt(x))
                    return 1;
                else if (first.charAt(x) < second.charAt(x))
                    return -1;
            }
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int segments = Integer.parseInt(br.readLine());

        Segment[] words = new Segment[segments];
        for (int x = 0; x < segments; x++) {
            words[x] = new Segment(br.readLine());
        }

        Arrays.sort(words);
        for (Segment word : words) {
            System.out.print(word.word);
        }
    }
}
