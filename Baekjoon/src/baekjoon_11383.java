import java.io.*;
import java.util.StringTokenizer;

public class baekjoon_11383 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] original = new String[N];
        String[] expanded = new String[N];

        for (int i = 0; i < N; i++) {
            original[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            expanded[i] = br.readLine();
        }

        boolean isEyfa = true;

        outerLoop:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (original[i].charAt(j) != expanded[i].charAt(2 * j) || original[i].charAt(j) != expanded[i].charAt(2 * j + 1)) {
                    isEyfa = false;
                    break outerLoop;
                }
            }
        }

        if (isEyfa) {
            bw.write("Eyfa\n");
        } else {
            bw.write("Not Eyfa\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
