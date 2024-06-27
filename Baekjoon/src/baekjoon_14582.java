import java.io.*;
import java.util.*;

public class baekjoon_14582 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] geminis = new int[9];
        int[] gullivers = new int[9];

        for (int i = 0; i < 9; i++) {
            geminis[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 9; i++) {
            gullivers[i] = Integer.parseInt(st.nextToken());
        }

        int geminisTotal = 0;
        int gulliversTotal = 0;
        boolean isGeminisAhead = false;

        for (int i = 0; i < 9; i++) {
            geminisTotal += geminis[i];
            if (geminisTotal > gulliversTotal) {
                isGeminisAhead = true;
            }
            gulliversTotal += gullivers[i];
        }

        if (isGeminisAhead) {
            bw.write("Yes\n");
        } else {
            bw.write("No\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
