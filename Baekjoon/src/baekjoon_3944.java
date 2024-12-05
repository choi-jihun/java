import java.io.*;
import java.util.StringTokenizer;


public class baekjoon_3944 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int B = Integer.parseInt(st.nextToken());
            String D = st.nextToken();

            int mod = B - 1;
            int sum = 0;

            for (int i = 0; i < D.length(); i++) {
                sum += (D.charAt(i) - '0');
                sum %= mod;
            }

            bw.write(sum + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
