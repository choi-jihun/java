import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://blog.naver.com/yu_jin456/222831783180 참조
// 세트로 사면 무조건 세트로 사야되고 낱개로 사면 무조건 낱개로 사야되는 줄 알고 계속헤맸다..

public class baekjoon_1049 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int min_set = Integer.MAX_VALUE, min_unit = Integer.MAX_VALUE;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			min_set = Math.min(min_set, Integer.parseInt(st.nextToken()));
			min_unit = Math.min(min_unit, Integer.parseInt(st.nextToken()));
		}
		int price = Integer.MAX_VALUE;
		price = Math.min(price, (N/6 + 1) * min_set);
		price = Math.min(price, min_unit * N);
		price = Math.min(price, ((N/6)*min_set) + (N%6) * min_unit);
		System.out.println(price);
	}

}
