import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_3036 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int standard = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N - 1; i++) {
            int temp = Integer.parseInt(st.nextToken());
            int gcd = gcd(standard, temp);
            sb.append(standard / gcd).append('/').append(temp / gcd).append('\n');
        }

        System.out.println(sb);
    }

    static int gcd(int a, int b) {
        int r;

        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
