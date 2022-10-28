import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_16953 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int count = 1;
		while(true) {
			if(A==B)
				break;
			else if(A>B) {
				count = -1;
				break;
			}
			if(B%2 == 0) {
				B /= 2;
				count++;
			}
			else {
				if(B%10==1) {
					B /= 10;
					count++;
				}
				else {
					count = -1;
					break;
				}
			}
		}
		System.out.println(count);
	}
}