import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_24426 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int [][]arr = new int [n+1][n+1];
		int [][]dp = new int [n+1][n+1];
		
		for(int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < n + 1; j++) {
				int k = Integer.parseInt(st.nextToken());
				arr[i][j] = k;
				dp[i][j] = k;
			}
		}
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		for(int i = 1; i <= x; i++) {
			for(int j = 1; j <= y; j++) {
				arr[i][j] += Math.max(arr[i-1][j], arr[i][j-1]);
			}
		}
		for(int i = x; i < n+1; i++) {
			for(int j = y; j < n+1; j++) {
				if(i == x && j == y)
					continue;
				arr[i][j] += Math.max(arr[i-1][j], arr[i][j-1]);
			}
		}
		dp[x][y] =  -1;
		if(x == 1)
			for(int i = y; i < n+1;i++)
				dp[x][i] = -1;
		if(y == 1)
			for(int i = x; i < n+1;i++)
				dp[i][y] = -1;
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j< n+1; j++) {
				if(dp[i][j] == -1) 
					continue;
				else
					dp[i][j] += Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		System.out.print(arr[n][n]+" " +dp[n][n]);
	}

}
