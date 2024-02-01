import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_25501 {
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            String str = br.readLine();
            cnt = 0;
            sb.append(isPalindrome(str)).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    static int recursive(String str, int start, int end) {
        if (start >= end) {
            cnt++;
            return 1;
        }
        if (str.charAt(start) != str.charAt(end)) {
            cnt++;
            return 0;
        } else {
            cnt++;
            return recursive(str, start + 1, end - 1);
        }
    }

    static int isPalindrome(String str) {
        return recursive(str, 0, str.length() - 1);
    }
}
