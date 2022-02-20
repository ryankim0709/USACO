import java.util.*;
import java.io.*;

public class Mooyo_Mooyo {
    /*
    while(*check the board if it is valid*)
        - alternate: as you flood fill, once it reaches over k, then just flood fill then (better)
        - Go from bottom
            - if curr = 'd'
                - use recursion to check tile above until you hit a number of the top, x coordinate = 0
                
    
    flood(int x, int y)
        - !(in bounds or not nmber) => return
        - color as 'd' for destroyed
        - check up down left right => add one to count
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
    }
}
