import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_20310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ch = br.readLine().toCharArray();
        int countZero = 0, countOne = 0;

        StringBuilder sb = new StringBuilder();
        for (char c : ch) {
            sb.append(c);
            if (c == '0') {
                countZero++;
            } else {
                countOne++;
            }
        }

        int removeZero = countZero / 2;
        int removeOne = countOne / 2;
        int len = sb.length();

        for (int i = 0; i < len; i++) {
            if (sb.charAt(i) == '1') {
                sb.deleteCharAt(i);
                removeOne--;
                i--;
            }
            if (removeOne == 0)
                break;
        }

        len = sb.length();
        for (int i = len - 1; i > -1; i--) {
            if (sb.charAt(i) == '0') {
                sb.deleteCharAt(i);
                removeZero--;
            }
            if (removeZero == 0)
                break;
        }

        System.out.println(sb);

    }
}
