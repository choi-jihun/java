import java.io.*;
import java.util.*;

public class baekjoon_16564 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        int[] levels = new int[N];
        for (int i = 0; i < N; i++) {
            levels[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(levels);

        long low = levels[0];
        long high = levels[0] + K;

        while (low < high) {
            long mid = (low + high + 1) / 2;

            if (levelUp(levels, K, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        bw.write(Long.toString(low));
        bw.flush();
        br.close();
        bw.close();
    }

    static boolean levelUp(int[] levels, long K, long target) {
        long require = 0;
        for (int level : levels) {
            if (level < target) {
                require += (target - level);
                if (require > K) {
                    return false;
                }
            }
        }
        return require <= K;
    }
}
