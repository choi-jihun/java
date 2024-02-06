import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class baekjoon_1092 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] cranes = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cranes[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        Integer[] weights = new Integer[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cranes, Collections.reverseOrder());
        Arrays.sort(weights, Collections.reverseOrder());

        int[] positions = new int[N];
        Arrays.fill(positions, -1);

        boolean[] isLoaded = new boolean[M];

        int count = 0;
        int time = 0;

        while (count < M) {
            boolean ableToMove = false;
            for (int i = 0; i < N; i++) {
                while (positions[i] < M - 1) {
                    positions[i]++;
                    if (!isLoaded[positions[i]] && cranes[i] >= weights[positions[i]]) {
                        isLoaded[positions[i]] = true;
                        count++;
                        ableToMove = true;
                        break;
                    }
                }
            }
            if (ableToMove) {
                time++;
            } else {
                break;
            }
        }

        if (count < M) {
            System.out.println(-1);
        } else {
            System.out.println(time);
        }
    }
}
