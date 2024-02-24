import java.io.*;
import java.util.StringTokenizer;

public class baekjoon_1062 {

    static int N, K;
    static String[] words;
    static boolean[] learned = new boolean[26];
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K < 5) {
            bw.write("0\n");
        } else if (K == 26) {
            bw.write(N + "\n");
        } else {
            words = new String[N];
            for (int i = 0; i < N; i++) {
                words[i] = br.readLine().replaceAll("[antic]", "");
            }

            K -= 5;
            learned[0] = true;
            learned['n' - 'a'] = true;
            learned['t' - 'a'] = true;
            learned['i' - 'a'] = true;
            learned['c' - 'a'] = true;

            dfs(0, 0);
            bw.write(max + "");

        }
        bw.flush();
    }

    static void dfs(int start, int cnt) {
        if (cnt == K) {
            int read = 0;
            for (String str : words) {
                boolean canRead = true;
                for (int i = 0; i < str.length(); i++) {
                    if (!learned[str.charAt(i) - 'a']) {
                        canRead = false;
                        break;
                    }
                }
                if (canRead)
                    read++;
            }
            max = Math.max(read, max);
            return;
        }

        for (int i = start; i < 26; i++) {
            if (!learned[i]) {
                learned[i] = true;
                dfs(i + 1, cnt + 1);
                learned[i] = false;
            }
        }
    }
}
