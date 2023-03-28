import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str1 = st.nextToken();
        String str2 = st.nextToken();

        int ans = str1.length();

        for (int i = 0; i <= str2.length() - str1.length(); i++) {
            int cnt = 0;
            for (int j = 0; j < str1.length(); j++) {
                if (str1.charAt(j) != str2.charAt(j + i))
                    cnt++;
            }
            ans = Math.min(cnt, ans);
        }
        System.out.println(ans);
    }
}
