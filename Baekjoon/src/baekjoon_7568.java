import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_7568 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int [][]arr = new int [2][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[0][i] = Integer.parseInt(st.nextToken());
			arr[1][i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < N; i++) {
			int rank = 1;
			for(int j = 0; j < N; j++) {
				if(i==j)
					continue;
				if(arr[0][i] < arr[0][j] && arr[1][i] < arr[1][j])
					rank++;
			}
			System.out.print(rank + " ");
		}
	}

}
