import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1543 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String find = br.readLine();
		
		int count = 0;
		for(int i = 0; i < str.length() - find.length() + 1; i++) {
			if(str.substring(i, i + find.length()).equals(find)) {
				i += find.length() - 1;
				count++;
			}
		}
		System.out.println(count);
	}

}
