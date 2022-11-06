import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_3040 {

	static int []arr;
	static int []sw;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		arr = new int [9];
		sw = new  int [7];
		for(int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		answer(0, 0);
		
	}
	static void answer(int start, int count) {
		if(count == 7) {
			int sum = 0;
			for(int i = 0; i < 7; i++)
				sum+=sw[i];
			if(sum == 100)
				for(int i = 0; i<7;i++)
					System.out.println(sw[i]);
			return;
		}
		for(int i = start; i < 9; i++) {
			sw[count] = arr[i];
			answer(i+1, count+1);
		}
	}

}
