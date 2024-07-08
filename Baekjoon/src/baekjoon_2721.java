import java.io.*;

public class baekjoon_2721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            long Wn = calculateW(n);
            bw.write(Wn + "\n");
        }

        br.close();
        bw.close();
    }

    private static long calculateW(int n) {
        long sum = 0;
        for (int k = 1; k <= n; k++) {
            long Tk1 = (k + 1L) * (k + 2L) / 2;
            sum += k * Tk1;
        }
        return sum;
    }
}
