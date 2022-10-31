import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1439 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		int count1 = 0, count2 = 0;
		char cmp = str[0];
		if(cmp == '0')
			count1++;
		else {
			count2++;
		}
		for(int i = 1; i < str.length; i++) {
			if(cmp!=str[i]) {
				if(str[i]=='0')
					count1++;
				else {
					count2++;
				}
				cmp = str[i];
			}
		}
		System.out.println(Math.min(count1, count2));
	}

}
