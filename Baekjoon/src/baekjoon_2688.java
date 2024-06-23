import java.io.*;

public class baekjoon_2688 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            long result = combination(n + 9, 9);
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static long combination(int n, int k) {
        if (k > n)
            return 0;
        if (k == 0 || k == n)
            return 1;
        k = Math.min(k, n - k);
        long c = 1;
        for (int i = 0; i < k; i++) {
            c = c * (n - i) / (i + 1);
        }
        return c;
    }
}
