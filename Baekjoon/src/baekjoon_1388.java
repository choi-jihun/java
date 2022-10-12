import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1388 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cols = Integer.parseInt(st.nextToken());
		int rows = Integer.parseInt(st.nextToken());
		char [][] room = new char [cols][rows];
		int cnt = 0;
		for(int i = 0; i<cols;i++) {
			String tmp = br.readLine();
			for(int j = 0; j < rows; j++)
				room[i][j] = tmp.charAt(j);
		}
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(room[j][i] == '|') {
					cnt++;
					while(j<cols && room[j][i] == '|')
						j++;
				}
			}
		}
		for(int i = 0; i < cols; i++) {
			for(int j = 0; j < rows; j++) {
				if(room[i][j] == '-') {
					cnt++;
					while(j<rows && room[i][j] == '-')
						j++;
				}
			}
		}
		System.out.println(cnt);
	}

}
