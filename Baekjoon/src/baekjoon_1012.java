import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1012 {
	static int [][] ground;
	static boolean [][]visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			int ans = 0;
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			ground = new int[M][N];
			visited = new boolean[M][N];
			for(int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				ground[x][y] = 1;
			}
			for(int j = 0; j < M; j++) {
				for(int k =0; k < N; k++) {
					if(!visited[j][k] && ground[j][k] == 1) {
						dfs(j,k);
						ans++;
					}
				}
			}
			System.out.println(ans);
		}
	}
	
	static void dfs(int x, int y) {
		if(x<0||y<0||x>=ground.length||y>=ground[0].length||visited[x][y]||ground[x][y] == 0)
			return;
		visited[x][y] = true;
		dfs(x-1,y);
		dfs(x+1,y);
		dfs(x,y+1);
		dfs(x,y-1);
	}

}
