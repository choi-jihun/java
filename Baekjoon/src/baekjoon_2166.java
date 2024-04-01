import java.io.*;
import java.util.StringTokenizer;

public class baekjoon_2166 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] x = new int[N];
        int[] y = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        long area = 0;
        for (int i = 0; i < N; i++) {
            int next = (i + 1) % N;
            area += (long) x[i] * y[next] - (long) y[i] * x[next];
        }

        double result = Math.abs(area) / 2.0;
        bw.write(String.format("%.1f", result));
        bw.flush();
    }
}
