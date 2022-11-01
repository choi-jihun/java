import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_14916 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		while(n > 0) {
			if(n%5 == 0) {
				count += n/5;
				break;
			}
			n-=2;
			count++;
		}
		if(n<0)
			System.out.println(-1);
		else 
			System.out.println(count);
	}

}
