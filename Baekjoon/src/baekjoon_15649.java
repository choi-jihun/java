import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_15649 {

	static int N, M;
	static int []arr;
	static boolean []visitied;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int [M];
		visitied = new boolean [N];
		dfs(0);
	}
	
	static void dfs(int depth) {
		if(depth == M) {
			for(int i = 0; i < M; i++) 
				System.out.print(arr[i]+" ");
			System.out.println();
		}
		for(int i = 0; i < N; i++) {
			if(!visitied[i]) {
				visitied[i] = true;
				arr[depth] = i+1;
				dfs(depth+1);
				visitied[i] = false;
			}
		}
	}
}
