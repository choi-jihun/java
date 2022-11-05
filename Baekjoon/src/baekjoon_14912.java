import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_14912 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int count = 0;
        for(int i = 1; i <= n; i++) {
        	int cmp = i;
        	while(cmp > 0) {
        		if(cmp % 10 == d)
        			count++;
        		cmp/=10;
        	}
        }
        System.out.println(count);
	}

}
