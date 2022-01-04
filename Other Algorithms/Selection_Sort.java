public class Selection_Sort {
	public static void main(String[] args) {
		int[] original = new int[] {3,5,12,7,2,9};
		
		int length = original.length;
		int[] sorted = new int[original.length];
		
		int min = 1000000;
		int index = 0;
		int number = 0;
		
		for(int x = 0; x < length;x++) {
			min = 1000000;
			for(int y = 0; y < length;y++) {
				number = original[y];
				if(number == 1000000) {
					continue;
				}
				
				else if(number < min) {
					min = number;
					index = y;
				}
			}
			original[index] = 1000000;
			sorted[x] = min;
		}
		
		for(int x:sorted) {
			System.out.print(x+" ");
		}
	}
}
