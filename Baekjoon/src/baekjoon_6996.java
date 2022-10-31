import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.PrimitiveIterator.OfDouble;

public class baekjoon_6996 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st; 
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String str1 = st.nextToken();
			String str2 = st.nextToken();
			char []c1 = str1.toCharArray();
			char []c2 = str2.toCharArray();
			Arrays.sort(c1);
			Arrays.sort(c2);
			if(Arrays.toString(c1).equals(Arrays.toString(c2)))
				System.out.println(str1+" & "+ str2 + " are anagrams.");
			else 
				System.out.println(str1+" & "+ str2 +" are NOT anagrams.");
		}
	}
}
