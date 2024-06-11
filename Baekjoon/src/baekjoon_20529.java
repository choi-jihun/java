import java.io.*;
import java.util.*;

public class baekjoon_20529 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] mbti = new String[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                mbti[i] = st.nextToken();
            }

            int min = Integer.MAX_VALUE;
            if (N > 32) {
                min = 0;
            } else {
                for (int i = 0; i < N; i++) {
                    for (int j = i + 1; j < N; j++) {
                        for (int k = j + 1; k < N; k++) {
                            int dis = getDistance(mbti[i], mbti[j]) +
                                    getDistance(mbti[j], mbti[k]) +
                                    getDistance(mbti[k], mbti[i]);
                            min = Math.min(min, dis);
                        }
                    }
                }
            }

            bw.write(min + "\n");
        }

        br.close();
        bw.close();
    }

    private static int getDistance(String a, String b) {
        int dis = 0;
        for (int i = 0; i < 4; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                dis++;
            }
        }
        return dis;
    }
}
