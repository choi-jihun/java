import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_1520 {
	static int M,N;
	static int [][]dp;
	static int [][]arr;
	static int[] rangeX = {-1,0,1,0};
	static int[] rangeY = {0,-1,0,1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int [M+1][N+1];
		dp = new int [M+1][N+1];
		for(int i = 1; i < M+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < N+1; j++) {
				int value = Integer.parseInt(st.nextToken());
				arr[i][j] = value;
			}
		}
		for(int i = 1; i < M+1; i++) {
			for(int j = 1; j < N+1; j++) {
				dp[i][j] = -1;
			}
		}
		int ans = dfs(1,1);
		System.out.println(ans);
		
	}
	static int dfs(int x, int y) {
		if(x == M && y == N)
			return 1;
		if(dp[x][y] != -1)
			return dp[x][y];
		dp[x][y] = 0;
		for(int i = 0; i< 4; i++) {
			int dx = x + rangeX[i];
			int dy = y + rangeY[i];
			if(dx < 1 || dy < 1 || dx > M || dy > N)
				continue;
			if(arr[x][y]>arr[dx][dy])
				dp[x][y] += dfs(dx,dy);
		}
		return dp[x][y];
	}

}