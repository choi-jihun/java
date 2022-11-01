import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1789 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(br.readLine());
		int count = 0;
		long sum = 0;
		for(int i = 1; i<=S;i++) {
			sum+=i;
			if(sum>S) {
				System.out.println(i-1);
				break;
			}
			if(S==1) {
				System.out.println(1);
				break;
			}
		}
	}

}