import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int num = 0;
        while(num < str.length()) {
            if (str.charAt(num) == '.') {
                sb.append('.');
                num++;
            } else {
                int cnt = 0;
                while (num < str.length() && str.charAt(num) == 'X') {
                    cnt++;
                    num++;
                }
                while (cnt >= 4) {
                    sb.append("AAAA");
                    cnt -= 4;
                }
                while (cnt == 2) {
                    sb.append("BB");
                    cnt -= 2;
                }
                if (cnt > 0) {
                    System.out.println("-1");
                    return;
                }
            }
        }
        System.out.println(sb);
    }
}
