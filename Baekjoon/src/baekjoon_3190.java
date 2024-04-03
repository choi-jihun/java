import java.io.*;
import java.util.*;

public class baekjoon_3190 {
    static int N;
    static int K;
    static int L;
    static int[][] arr;
    static Map<Integer, Character> map = new HashMap<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            arr[a][b] = 1;
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            map.put(X, C);
        }

        bw.write(String.valueOf(simulate()));
        bw.flush();
    }

    static int simulate() {
        int time = 0;
        int dir = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{0, 0});
        arr[0][0] = 2;

        while (true) {
            time++;
            int[] head = deque.getFirst();
            int nx = head[0] + dx[dir];
            int ny = head[1] + dy[dir];

            if (!isValid(nx, ny) || arr[nx][ny] == 2) {
                break;
            }

            if (arr[nx][ny] == 0) {
                int[] tail = deque.pollLast();
                arr[tail[0]][tail[1]] = 0;
            }
            deque.offerFirst(new int[]{nx, ny});
            arr[nx][ny] = 2;

            if (map.containsKey(time)) {
                dir = (dir + (map.get(time) == 'L' ? 3 : 1)) % 4;
            }
        }

        return time;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
