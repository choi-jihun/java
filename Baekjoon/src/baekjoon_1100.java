import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1100 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count =0;
		for(int i=0;i<8;i++) {
			String str = br.readLine();
			for(int j = 0;j<8;j++) {
				if((i+j)%2==0 && str.charAt(j)=='F')
					count++;
			}
		}
		System.out.println(count);
	}

}