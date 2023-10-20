import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1356 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ch = br.readLine().toCharArray();
        int[] a = new int[ch.length];
        int[] b = new int[ch.length];

        for (int i = 0; i < ch.length - 1; i++) {
            int j = ch.length - 1 - i;

            if (i == 0) {
                a[i] = ch[i] - '0';
                b[j] = ch[j] - '0';
                continue;
            }

            a[i] = a[i - 1] * (ch[i] - '0');
            b[j] = b[j + 1] * (ch[j] - '0');
        }

        boolean yoo = false;
        for (int i = 0; i < ch.length - 1; i++) {
            if (a[i] == b[i + 1]) {
                yoo = true;
                break;
            }
        }
        String res = yoo ? "YES" : "NO";
        System.out.println(res);

    }
}
