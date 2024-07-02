import java.io.*;
import java.util.*;

public class baekjoon_15792 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        sb.append(A / B).append(".");

        A = 10 * (A - B * (A / B));
        int T = 1000;
        while (T-- > 0) {
            sb.append(A / B);
            A = 10 * (A - B * (A / B));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
