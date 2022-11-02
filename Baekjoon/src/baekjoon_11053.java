import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.imageio.metadata.IIOMetadataFormatImpl;

public class baekjoon_11053 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int []arr = new int [N];
		int []dp = new int [N];
		int count = 0;
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i] && dp[i] <= dp[j])
					dp[i] = dp[j]+1;
			}
		}
		int max =0;
		for(int i = 0; i <N; i++)
		max = Math.max(max, dp[i]);
		System.out.println(max);
		
	}

}
