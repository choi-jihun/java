import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class baekjoon_2667 {
	
	static int N;
	static int [][]arr;
	static boolean [][]visited;
	static int dan; 
	static int []dx = {-1,1,0,0};
	static int []dy = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int [N][N];
		visited = new boolean [N][N];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++)
				arr[i][j] = str.charAt(j) - '0';
		}
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0;i < N; i++) {
			for(int j = 0; j < N; j++)
				if(!visited[i][j] && arr[i][j] == 1) {
					dan = 0;
					dfs(i,j);
					list.add(dan);
				}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int val : list)
			System.out.println(val);
	}
	static void dfs(int x, int y) {
		visited[x][y] = true;
		dan++;
		for(int i = 0; i < 4; i++) {
			int cur_x = x + dx[i];
			int cur_y = y + dy[i];
			if(cur_x >=0 && cur_y >=0 && cur_x < N && cur_y < N && arr[cur_x][cur_y] == 1 && !visited[cur_x][cur_y]) {
				visited[cur_x][cur_y]=true;
				dfs(cur_x, cur_y);
			}
		}
	}

}
