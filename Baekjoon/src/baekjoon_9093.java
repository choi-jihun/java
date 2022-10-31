import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_9093 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				String str = st.nextToken();
				for(int i = str.length()-1; i >=0; i--)
					sb.append(str.charAt(i));
				sb.append(" ");
			}
			sb.append("\n");
			T--;
		}
		System.out.println(sb);
		
	}

}
