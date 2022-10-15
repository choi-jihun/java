import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1904 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long []arr = new long [N+2]; // 왜 n+1하면 오류??
		arr[1] = 1;
		arr[2] = 2;
		for(int i = 3; i < N+1; i++) {
			arr[i] = (arr[i-1]+arr[i-2]) % 15746;
		}
			
		System.out.println(arr[N]);
	}

}
