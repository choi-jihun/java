import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1254 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int cnt = str.length();
        for (int i = 0; i < str.length(); i++) {
            if (isPalindrome(str.substring(i)))
                break;
            cnt++;
        }
        System.out.println(cnt);
    }

    static boolean isPalindrome(String str) {
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length / 2; i++) {
            if (ch[i] != ch[ch.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
