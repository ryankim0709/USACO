import java.io.*;

public class String_Permutation {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String original = br.readLine();
		permute(original, "");
	}
	
	public static void permute(String original, String prefix) {
		
		int length = original.length();
		
		if(length == 0) {
			System.out.println(prefix);
		}
		else {
			for(int x = 0; x < length; x++) {
				permute((original.substring(0,x)+original.substring(x+1,length)),prefix+original.charAt(x));
			}
		}
	}
}