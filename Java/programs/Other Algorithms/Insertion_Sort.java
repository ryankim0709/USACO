public class Insertion_Sort {
	public static void main(String[] args) {
		int[] original = new int[] {6,5,3,1,8,7,2,4};
		int length = original.length;
		
		int first = 0;
		int second = 0;
		
		for(int x = 0; x < length - 1;x++) {
			first = original[x];
			second = original[x+1];
			
			if(first > second) {
				original[x] = second;
				original[x+1] = first;
				
				for(int y = x; y > 0; y --) {
					first = original[y];
					second = original[y-1];
					
					if(second > first) {
						original[y] = second;
						original[y-1] = first;
					}
				}
			}
		}
		
		for(int x:original) {
			System.out.print(x+" ");
		}
	}
}
