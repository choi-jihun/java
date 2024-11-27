import java.io.*;

public class baekjoon_2885 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int K = Integer.parseInt(br.readLine());
        int cnt = 0;
        int num = 1;
        while (num < K) {
            num *= 2;
        }

        bw.write(num + " ");
        while (K > 0) {
            if (K >= num) {
                K -= num;
            } else {
                num /= 2;
                cnt++;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        br.close();
        bw.close();
    }
}
