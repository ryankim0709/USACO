import java.util.*;
import java.io.*;
public class Closing_the_Farm {
	static Set<Integer> visited = new HashSet<>();
	static Set<Integer> deleted = new HashSet<>();
	static int barns;
	public static void main(String[] args) throws IOException{
		
		// variables
		TreeSet<Integer> nonDeleted = new TreeSet<>();
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("closing.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("closing.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		barns = Integer.parseInt(st.nextToken());
		int path = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] paths = new ArrayList[barns + 1];
		//Set<ArrayList<Integer>>[] paths = new HashSet[barns + 1];
		
		//graph initialization
		for (int i = 0; i < barns + 1; i++) {
            paths[i] = new ArrayList<Integer>();
            nonDeleted.add(i + 1);
        }
		
		//building graph
		int first;
		int second;
		for(int x = 0; x < path; x++) {
			st = new StringTokenizer(br.readLine());
			first = Integer.parseInt(st.nextToken());
			second = Integer.parseInt(st.nextToken());
			paths[first].add(second);
			paths[second].add(first);
		}
		
		dfs(paths, 1, visited);
		//System.out.println((visited.size() == barns) == true ? "YES" : "NO");
		pw.println((visited.size() == barns) == true ? "YES" : "NO");
		
		int delete;
		
		for(int x = 0; x < barns - 1; x++) {
			visited = new HashSet<>();
			delete = Integer.parseInt(br.readLine());
			deleted.add(delete);
			nonDeleted.remove(delete);
			dfs(paths, nonDeleted.first(), visited);
			//System.out.println((visited.size() == barns - deleted.size()) == true ? "YES" : "NO");
			pw.println((visited.size() == barns - deleted.size()) == true ? "YES" : "NO");
		}
		pw.close();
	}
	public static void dfs(ArrayList<Integer>[] paths, int current, Set<Integer> visited) {
		if(visited.contains(current)) {
			return;
		}
		visited.add(current);
		for(int child:paths[current]) {
			if(!deleted.contains(child)) {
				dfs(paths, child, visited);
			}
		}
	}
}
