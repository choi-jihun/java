import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1145 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int []arr = new int [5];
		for(int i = 0; i < 5; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int value = 1;
		int count = 0;
		while(true) {
			for(int i = 0; i < 5; i++) {
				if(value % arr[i] == 0)
					count++;
			}
			if(count >= 3)
				break;
			value++;
			count=0;
		}
		System.out.println(value);
	}

}
