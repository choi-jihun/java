import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1182 {

	static int N;
	static int S;
	static int []arr;
	static int count = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int [N];
		for(int i =0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		dfs(0, 0);
		if(S == 0)
			System.out.println(count-1);
		else
			System.out.println(count);
	}
	static void dfs(int depth, int sum) {
		if(depth == N) {
			if(sum == S)
				count++;
			return;
		}
		dfs(depth+1, sum);
		dfs(depth+1, sum+arr[depth]);
	}

}
