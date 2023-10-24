import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class baekjoon_2729 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            String a1 = st.nextToken();
            String b1 = st.nextToken();

            BigInteger a2 = new BigInteger(a1, 2);
            BigInteger b2 = new BigInteger(b1, 2);

            BigInteger ans = a2.add(b2);
            sb.append(ans.toString(2)).append("\n");
        }

        System.out.println(sb);
    }
}
