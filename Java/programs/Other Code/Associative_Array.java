import java.util.*;
import java.io.*;
public class Associative_Array {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int queries = Integer.parseInt(br.readLine());
		
		int command = 0;
		long index = 0;
		long value = 0;
		
		HashMap<Long, Long> infinite = new HashMap<>();
		
		StringTokenizer st = null;
		for(int x = 0; x < queries; x++) {
			st = new StringTokenizer(br.readLine());
			
			command = Integer.parseInt(st.nextToken());
			//System.out.println(infinite);
			if(command == 0) {
				index = Integer.parseInt(st.nextToken());
				value = Integer.parseInt(st.nextToken());
				
				infinite.put(index, value);
			}
			else {
				index = Integer.parseInt(st.nextToken());
				
				if(infinite.containsKey(index)) {
					System.out.println(infinite.get(index));
				}
				else {
					System.out.println(0);
				}
			}
		}

	}
}
