import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_13241 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        long gcd = getGCD(Math.max(A, B), Math.min(A, B));

        System.out.println((A * B) / gcd);
    }

    public static long getGCD(long a, long b) {
        while (b > 0) {
            long tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }
}
