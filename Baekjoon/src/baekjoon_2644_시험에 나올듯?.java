import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_2644 {
	static int[][] parents;
	static int [] relation;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		parents = new int [n+1][n+1];
		relation = new int[n+1];
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int lines = Integer.parseInt(st.nextToken());
		for(int i =0; i<lines;i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			parents[p][c] = 1;
			parents[c][p] = 1;
		}
		BFS(start,end);
		if(relation[end] == 0)
			System.out.println(-1);
		else
			System.out.println(relation[end]);
	}
	static void BFS(int start, int end) {
		Queue <Integer> q = new LinkedList<>();
		q.add(start);
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur == end)
				break;
			for(int  i = 1; i < parents.length;i++) {
				if(parents[cur][i] == 1 && relation[i] == 0) {
					relation[i] = relation[cur] +1;
					q.add(i);
				}
			}
		}
			
	}
}
