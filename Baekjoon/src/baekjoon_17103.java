import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_17103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-->0) {
            int N = Integer.parseInt(br.readLine());

            boolean[] primes = isPrime(N);
            int cnt = 0;

            for (int i = 2; i <= N / 2; i++) {
                if (primes[i] && primes[N - i]) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    static boolean[] isPrime(int num) {
        boolean[] prime = new boolean[num + 1];
        for (int i = 2; i <= num; i++) {
            prime[i] = true;
        }

        for (int p = 2; p * p <= num; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= num; i += p) {
                    prime[i] = false;
                }
            }
        }
        return prime;
    }
}
