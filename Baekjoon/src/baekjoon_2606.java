import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2606 {
	static int [][] network; 
	static boolean []visited;
	static int cnt;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		network = new int [n+1][n+1];
		visited = new boolean [n+1];
		for(int i =0; i< m; i++) {
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 int v1 = Integer.parseInt(st.nextToken());
			 int v2 = Integer.parseInt(st.nextToken());
			 network[v1][v2] = 1;
			 network[v2][v1] = 1;
		}
		cnt = 0;
		DFS(1);
		System.out.println(cnt);
	}
	public static void DFS(int start) {
		visited[start] = true;
		for(int i = 1; i< network.length;i++) {
			if(network[start][i] == 1 && visited[i] != true) {
				visited[i] = true;
				cnt++;
				DFS(i);
			}
		}
	}
}
