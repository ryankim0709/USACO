import java.util.*;
import java.io.*;
public class Factory_Machines {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int machines = Integer.parseInt(st.nextToken());
		int targetProducts = Integer.parseInt(st.nextToken());
		
		int[] productionTime = new int[machines];
		
		st = new StringTokenizer(br.readLine());
		for(int x = 0; x < machines; x++) {
			productionTime[x] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(productionTime);
		
		int low = productionTime[0];
		int high = low * targetProducts;
		int mid;
		
		while(low < high) {
			mid = low + (high - low)/2;
			
			if(canMeet(mid, productionTime, targetProducts)) {
				high = mid;
			}
			else {
				low = mid + 1;
			}
		}
		System.out.println(low);

	}
	public static boolean canMeet(int time, int productionTime[], int amount) {
		int products = 0;
		for(int x:productionTime) {
			products += time/x;
		}
		if(products >= amount) {
			return true;
		}
		return false;
	}
}
