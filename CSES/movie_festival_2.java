import java.util.*;
import java.io.*;

public class movie_festival_2 {
    static class movie implements Comparable<movie> {
        int start;
        int end;

        public movie(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(movie a) {

            return this.end - a.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numMovies = Integer.parseInt(st.nextToken());
        int friends = Integer.parseInt(st.nextToken());

        movie[] movies = new movie[numMovies];

        for (int x = 0; x < numMovies; x++) {
            st = new StringTokenizer(br.readLine());
            movies[x] = new movie(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(movies);
        // for (movie a : movies) {
        // System.out.println("Start: " + a.start + " End: " + a.end);
        // }

        ArrayList<Integer> friendMovies = new ArrayList<>();

        int moviesWatched = 0;

        int end;
        for (movie a : movies) {
            end = a.end;
            if (friendMovies.size() > 0 && friendMovies.get(0) < a.start) {
                friendMovies.remove(friendMovies.get(0));
                friendMovies.add(a.end);
                moviesWatched++;
            }

            else if (friendMovies.size() < friends) {
                friendMovies.add(end);
            }
            System.out.println(friendMovies);
        }
        System.out.println(moviesWatched + friendMovies.size());
    }
}