import java.util.*;
import java.io.*;
public class RPS_Tournament {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int people;
		double games;
		int p1;
		char p1Result;
		int p2;
		char p2Result;
		char result;
		double[] wins;
		String[] PG = br.readLine().split(" ");
		int[] total;
		
		while(PG.length != 1) {
			people = Integer.parseInt(PG[0]);
			games = Integer.parseInt(PG[1]);
			wins = new double[people+1];
			total = new int[people + 1];
			
			for(int x = 0; x < games*people*(people-1)/2; x++) {
				st = new StringTokenizer(br.readLine());
				p1 = Integer.parseInt(st.nextToken());
				p1Result = st.nextToken().charAt(0);
				p2 = Integer.parseInt(st.nextToken());
				p2Result = st.nextToken().charAt(0);
				result = won(p1Result,p2Result);
				
				if(result == '1') {
					wins[p1] ++;
					total[p1] ++;
					total[p2] ++;
				}
				
				else if(result == '2'){
					wins[p2] ++;
					total[p1] ++;
					total[p2] ++;
				}
			}
			for(int x = 1; x <= people; x++) {
				if(total[x] == 0) {
					System.out.println("-");
				}
				else {
					System.out.printf("%.3f\n",wins[x]/total[x]);
				}
			}
			System.out.println();
			PG = br.readLine().split(" ");
		}
	}
	public static char won(char p1, char p2) {
		if((p1 == 'r' && p2 == 's') || (p1 == 'p' && p2 == 'r' || (p1 == 's' && p2 == 'p'))) {
			return '1';
		}
		
		if(p1 == p2) {
			return '0';
		}
		
		return '2';
	}
}