import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1932 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [][]dp = new int [n+1][n+1];
		int ans = Integer.MIN_VALUE;
		for(int i = 1; i < n + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j =1; j<= i;j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
				if(i == 1)
					dp[i][j] = dp[i-1][j] + dp[i][j];
				else if(i == j)
					dp[i][j] = dp[i-1][j-1] + dp[i][j];
				else 
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + dp[i][j];
				ans = Math.max(ans,dp[i][j]);
			}
			
		}
		System.out.println(ans);
	}

}
