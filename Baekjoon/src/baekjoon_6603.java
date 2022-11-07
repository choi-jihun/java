import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_6603 {
	static int []arr;
	static int []answer; 
	static boolean []visited;
	static int k;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		while(true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k==0)
				break;
			arr = new int [k];
			visited = new boolean[k];
			answer = new int [6];
			for(int i = 0; i < k; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			dfs(0, 0);
			System.out.println();
		}
		
	}
	static void dfs(int depth, int start) {
		if(depth == 6) {
			for(int i = 0; i < 6; i++)
				System.out.print(answer[i] + " ");
			System.out.println();
			return;
		}
		for(int i = start; i < k; i++) {
			if(!visited[i]) {
				visited[i] = true;
				answer[depth] = arr[i];
 				dfs(depth+1, i);
				visited[i] = false;
			}
		}
	}

}
