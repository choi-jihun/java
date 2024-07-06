import java.io.*;
import java.util.*;

public class baekjoon_1392 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] times = new int[N];
        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(br.readLine());
        }

        int[] question = new int[Q];
        for (int i = 0; i < Q; i++) {
            question[i] = Integer.parseInt(br.readLine());
        }

        int[] endTimes = new int[N];
        endTimes[0] = times[0];
        for (int i = 1; i < N; i++) {
            endTimes[i] = endTimes[i - 1] + times[i];
        }

        for (int i = 0; i < Q; i++) {
            int time = question[i];
            int scoreIndex = findScoreIndex(endTimes, time);
            bw.write((scoreIndex + 1) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int findScoreIndex(int[] endTimes, int time) {
        int low = 0;
        int high = endTimes.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (endTimes[mid] > time) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
