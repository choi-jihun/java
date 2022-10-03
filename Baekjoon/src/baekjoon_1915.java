import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1915 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int ans = 0;
		int [][]dp = new int[n + 1][m + 1];
		for(int i = 1; i <= n; i++) {
			String [] ch = br.readLine().split("");
			for(int j = 1; j <= m; j++) {
				int temp = Integer.parseInt(ch[j - 1]);
				if(temp == 1) {
					dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1], dp[i-1][j]))+1;
					ans = Math.max(dp[i][j],ans);
				}
			}
		}
		System.out.println(ans * ans);
			
	}

}
