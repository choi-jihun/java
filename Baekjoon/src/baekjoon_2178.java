import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_2178 {
	static int [][]map;
	static int N,M;
	static boolean [][]visited;
	static int []dx = {-1,1,0,0};
	static int []dy = {0,0,-1,1};
	
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int [N][M];
		visited = new boolean [N][M];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++)
				map[i][j] = str.charAt(j) - '0';
		}
		bfs(0, 0);
		System.out.println(map[N-1][M-1]);
		
	}
	static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<Node>();
		visited[x][y] = true;
		q.add(new Node(x,y));
		while(!q.isEmpty()) {
			Node node = q.poll();
			for(int i = 0; i < 4; i++) {
				int cur_x = node.x + dx[i];
				int cur_y = node.y + dy[i];
				if(cur_x < 0 || cur_y < 0 || cur_x >= N || cur_y >=M || visited[cur_x][cur_y] || map[cur_x][cur_y] == 0)
					continue;
				q.add(new Node(cur_x, cur_y));
				map[cur_x][cur_y] = map[node.x][node.y] + 1;
				visited[cur_x][cur_y] = true;
			}
		}
	}

}
