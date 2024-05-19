import java.io.*;

public class baekjoon_4134 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int temp = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < temp; i++) {
            long n = Long.parseLong(br.readLine().trim());
            long prime = findNextPrime(n);
            bw.write(prime + "\n");
        }
        bw.flush();
    }

    private static long findNextPrime(long n) {
        if (n <= 2) return 2;
        if (n % 2 == 0) n++;
        while (!isPrime(n)) {
            n += 2;
        }
        return n;
    }

    private static boolean isPrime(long n) {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (long i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }
}
