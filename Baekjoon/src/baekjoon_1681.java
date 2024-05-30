import java.io.*;
import java.util.*;

public class baekjoon_1681 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        char L = st.nextToken().charAt(0);

        int num = 0;
        int cnt = 0;

        while (num < N) {
            cnt++;
            if (!String.valueOf(cnt).contains(String.valueOf(L))) {
                num++;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}
