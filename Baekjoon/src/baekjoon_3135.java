import java.io.*;
import java.util.StringTokenizer;

public class baekjoon_3135 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        int minPresses = Math.abs(A - B);
        for (int i = 0; i < N; i++) {
            int favorite = Integer.parseInt(br.readLine());
            minPresses = Math.min(minPresses, Math.abs(favorite - B) + 1);
        }

        bw.write(minPresses + "");
        bw.flush();
        br.close();
        bw.close();
    }
}
