import java.io.*;
import java.util.*;

public class baekjoon_1359 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        double probability = 0.0;
        double totalCombinations = comb(N, M);

        for (int i = K; i <= M; i++) {
            double matchCombinations = comb(M, i) * comb(N - M, M - i);
            probability += matchCombinations / totalCombinations;
        }

        bw.write(String.format("%.9f", probability));

        bw.write(String.valueOf(1));
        bw.flush();
        br.close();
        bw.close();
    }

    public static long comb(int n, int r) {
        if (r == 0 || n == r) return 1;
        if (r > n) return 0;
        r = Math.min(r, n - r);
        long res = 1;
        for (int i = 0; i < r; i++) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }
}
