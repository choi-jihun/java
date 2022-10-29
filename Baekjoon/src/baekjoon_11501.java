import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//이거 왤캐 어렵지...실버 2 맞음?

public class baekjoon_11501 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {;
			int N = Integer.parseInt(br.readLine());
			long []arr = new long [N];
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[j] = Long.parseLong(st.nextToken());
			}
			long sum = 0;
			long max = -1;
			for(int k = N-1; k >= 0; k--) {
				if(arr[k] > max)
					max = arr[k];
				else {
					sum += max - arr[k];
				}
			}
			System.out.println(sum);
		}
	}

}
