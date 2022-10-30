import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_19941 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String str = br.readLine();
		boolean []check = new boolean [N];
		int count = 0;
		for(int i = 0; i < N; i++) {
			if(str.charAt(i) == 'P') {
				int start = i - K;
				if(start < 0)
					start = 0;
				int end = i + K;
				if(end >= N)
					end = N-1;
				for(int j = start; j <= end; j++) {
					if(str.charAt(j) == 'H' && check[j] == false) {
						count++;
						check[j] = true;
						break;
					}
						
				}
			}
		}
		System.out.println(count);
	}
}