import java.io.*;
import java.util.*;

public class baekjoon_1059 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int L = Integer.parseInt(br.readLine());
        int[] S = new int[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < L; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        int n = Integer.parseInt(br.readLine());

        Arrays.sort(S);

        int count = getCount(L, S, n);

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int getCount(int L, int[] S, int n) {
        int count = 0;
        int left = 0;
        int right = 1001;

        for (int i = 0; i < L; i++) {
            if (S[i] == n) {
                return 0;
            }
            if (S[i] < n) {
                left = S[i];
            } else if (S[i] > n) {
                right = S[i];
                break;
            }
        }

        for (int i = left + 1; i <= n; i++) {
            for (int j = n; j < right; j++) {
                if (i < j) {
                    count++;
                }
            }
        }
        return count;
    }
}
