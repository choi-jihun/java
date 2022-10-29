import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class baekjoon_1946 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int [][]arr = new int [N][2];
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					if(o1[0] == o2[0])
						return o1[1] - o2[1];
					
					return o1[0] - o2[0];
				}
			});
			int max_score = arr[0][1];
			int count = 1;
			for(int k = 1; k < N; k++) {
				if(max_score > arr[k][1]) {
					max_score = arr[k][1];
					count++;
				}
			}
			System.out.println(count);
		}
	}

}
