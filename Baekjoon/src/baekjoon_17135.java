import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_17135 {
    static int N, M, D;
    static int[][] arr;
    static int[][] tempArr;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        tempArr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                tempArr[i][j] = arr[i][j];
            }
        }

        ArrayList<Integer> positions = new ArrayList<>();
        placeArchers(positions, 0);
        bw.write(String.valueOf(max));
        bw.flush();
    }

    static void init() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = tempArr[i][j];
            }
        }
    }

    static void placeArchers(ArrayList<Integer> list, int start) {
        if (list.size() >= 3) {
            init();
            simulate(list);
            return;
        }

        for (int i = start; i < M; i++) {
            list.add(i);
            placeArchers(list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    static void simulate(ArrayList<Integer> list) {
        int kill = 0;

        for (int turn = 0; turn < N; turn++) {
            boolean[][] visited = new boolean[N][M];
            for (int position : list) {
                int minD = D + 1;
                int minR = -1;
                int minC = -1;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (arr[i][j] == 1) {
                            int distance = Math.abs(N - i) + Math.abs(position - j);
                            if (distance <= D && distance < minD) {
                                minD = distance;
                                minR = i;
                                minC = j;
                            } else if (distance == minD && j < minC) {
                                minR = i;
                                minC = j;
                            }
                        }
                    }
                }
                if (minR != -1 && minC != -1) {
                    visited[minR][minC] = true;
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visited[i][j]) {
                        arr[i][j] = 0;
                        kill++;
                    }
                }
            }

            for (int i = N - 1; i > 0; i--) {
                for (int j = 0; j < M; j++) {
                    arr[i][j] = arr[i - 1][j];
                }
            }
            Arrays.fill(arr[0], 0);

            max = Math.max(kill, max);
        }

    }
}
