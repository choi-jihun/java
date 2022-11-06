import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class baekjoon_2798 {
	static int N;
	static int M;
	static int []arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr= new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		System.out.println(answer());
	}
	static int answer() {
		int result = 0;
		for(int i = 0; i < N-2; i++) {
			if(arr[i]>M)
				continue;
			for(int j = i+1; j < N-1; j++) {
				if(arr[i]+arr[j] > M)
					continue;
				for(int k = j+1; k < N; k++) {
					if(arr[i]+arr[j]+arr[k] > M)
						continue;
					int sum = arr[i]+arr[j]+arr[k];
					if(sum == M)
						return sum;
					if(result < sum && sum < M)
						result = sum;
				}
			}
		}
		return result;
	}

}
