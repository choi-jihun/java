import java.io.*;
import java.util.*;

public class baekjoon_15723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        boolean[][] reachable = new boolean[26][26];

        for (int i = 0; i < n; i++) {
            String[] premise = br.readLine().split(" is ");
            int from = premise[0].charAt(0) - 'a';
            int to = premise[1].charAt(0) - 'a';
            reachable[from][to] = true;
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (reachable[i][k] && reachable[k][j]) {
                        reachable[i][j] = true;
                    }
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] conclusion = br.readLine().split(" is ");
            int from = conclusion[0].charAt(0) - 'a';
            int to = conclusion[1].charAt(0) - 'a';
            if (reachable[from][to]) {
                bw.write("T\n");
            } else {
                bw.write("F\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
