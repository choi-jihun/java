import java.io.*;
import java.util.StringTokenizer;

public class baekjoon_1024 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        for (int i = L; i <= 100; i++) {
            if ((N - i * (i - 1) / 2) % i == 0) {
                int a = (N - i * (i - 1) / 2) / i;
                if (a < 0)
                    continue;
                for (int j = 0; j < i; j++) {
                    bw.write((a + j) + " ");
                }
                bw.flush();
                return;
            }
        }
        System.out.println(-1);
    }
}
