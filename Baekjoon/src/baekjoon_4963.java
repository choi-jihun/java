import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormatSymbols;
import java.util.StringTokenizer;
import java.util.logging.Handler;

public class baekjoon_4963 {
	static int dx[]= {0,1,1,-1,-1, 1, 0,-1};
	static int dy[]= {1,0,1, 1, 0,-1,-1,-1};
	static boolean [][]visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			if(w == 0&& h ==0)
				break;
			int [][]map = new int[h][w];
			visited = new boolean [h][w];
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			int answer = 0;
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++)
					if(map[i][j] == 1 && !visited[i][j]) {
						dfs(map,i,j);
						answer++;
					}
			}
			System.out.println(answer);
		}
		
	}
	static void dfs(int [][]map, int x, int y) {
		visited[x][y] = true;
		for(int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && ny>=0 && nx < map.length && ny < map[0].length && map[nx][ny] == 1 && !visited[nx][ny])
				dfs(map, nx, ny);
		}
	}

}
