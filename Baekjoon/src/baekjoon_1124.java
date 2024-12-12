import java.io.*;
import java.util.*;

public class baekjoon_1124 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int MAX = 100000;

        boolean[] isPrime = new boolean[MAX + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int[] primeFactors = new int[MAX + 1];
        for (int i = 2; i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i; j <= MAX; j += i) {
                    int num = j;
                    while (num % i == 0) {
                        primeFactors[j]++;
                        num /= i;
                    }
                }
            }
        }

        int count = 0;
        for (int i = A; i <= B; i++) {
            if (isPrime[primeFactors[i]]) {
                count++;
            }
        }

        bw.write(count + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}
