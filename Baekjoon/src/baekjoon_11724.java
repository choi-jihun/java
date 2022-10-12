import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_11724 {

	static int[][] graph;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new int[N+1][N+1];
		visited = new boolean [N+1];
		for(int i = 0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			graph[v1][v2] = 1;
			graph[v2][v1] = 1;
		}
		int cnt = 0;
		for(int i = 1; i<visited.length;i++) {
			if(visited[i]!=true) {
				DFS(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	static void DFS(int start) {
		visited[start] = true;
		for(int i = 0; i < graph.length; i++) {
			if(graph[start][i] == 1 && visited[i] != true)
				DFS(i);
		}
	}

}