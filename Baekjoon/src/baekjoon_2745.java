import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        int N = Integer.parseInt(st.nextToken());

        int temp = 1;
        int ans = 0;

        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if ('0' <= ch && ch <= '9')
                ans += (ch - '0') * temp;
            else
                ans += (ch - 'A' + 10) * temp;
            temp *= N;
        }

        System.out.println(ans);
    }
}
