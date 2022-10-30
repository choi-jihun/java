import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class baekjoon_11047 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Integer []arr = new Integer [N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int count = 0;
		Arrays.sort(arr,Collections.reverseOrder());
		int x = 0;
		while(K!=0) {
			if(arr[x]<=K) {
				K-=arr[x];
				count++;
			}
			else {
				x++;
			}
		}
		System.out.println(count);
	}

}
