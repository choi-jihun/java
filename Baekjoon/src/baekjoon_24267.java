import java.io.*;

public class baekjoon_24267 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        bw.write((long) (N - 2) * (N - 1) * N / 6 + "\n" + 3);
        bw.flush();

    }
}
