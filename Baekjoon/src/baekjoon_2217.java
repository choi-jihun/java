import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_2217 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int []rope = new int [N];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			rope[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(rope);
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			if(rope[i]*(N-i)>max)
				max = rope[i] * (N-i);
		}
		System.out.println(max);
	}

}