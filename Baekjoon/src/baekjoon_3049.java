import java.io.*;

public class baekjoon_3049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int ans = (N * (N - 1) * (N - 2) * (N - 3)) / 24;
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
