import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_14889 {
	
	static int N;
	static int [][]map;
	static boolean []visited;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		visited = new boolean [N];
		StringTokenizer st;
		for(int i = 0; i< N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
			
		helper(0,0);
		System.out.println(min);
	}
	
	static void helper(int start, int depth) {
		if(depth == N/2) {
			int t_st = 0;
			int t_li = 0;
			for(int i = 0; i < N - 1; i++) {
				for(int j = i + 1; j < N; j++) {
					if(visited[i] && visited[j]) {
						t_st += map[i][j];
						t_st += map[j][i];
					}
					else if(!visited[i] && !visited[j]) {
						t_li += map[i][j];
						t_li += map[j][i];
					}
				}
			}
			min = Math.min(min, Math.abs(t_st - t_li));
			return;
		}
		for(int i = start; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				helper(i + 1, depth + 1);
				visited[i] = false;
			}
		}
	}
}
