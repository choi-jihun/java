import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2023 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        findPrime("", N);
        System.out.println(sb);
    }

    static void findPrime(String str, int N) {
        if (str.length() == N) {
            sb.append(str).append("\n");
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (isPrime(Integer.parseInt(str + i))) {
                findPrime(str + i, N);
            }
        }
    }

    static boolean isPrime(int number) {
        if (number < 2)
            return false;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }
}
