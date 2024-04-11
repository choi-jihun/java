import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon_18405 {

    static class Virus {
        int type, x, y, time;

        public Virus(int type, int x, int y, int time) {
            this.type = type;
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static int N, K;
    static int[][] arr;

    static PriorityQueue<Virus> queue = new PriorityQueue<>((v1, v2) -> {
        if (v1.time == v2.time) {
            return Integer.compare(v1.type, v2.type);
        }
        return Integer.compare(v1.time, v2.time);
    });
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int S, X, Y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] != 0) {
                    queue.add(new Virus(arr[i][j], i, j, 0));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1;
        Y = Integer.parseInt(st.nextToken()) - 1;

        bfs();
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//        }
        bw.write(String.valueOf(arr[X][Y]));
        bw.flush();
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Virus v = queue.poll();
            if (v.time == S) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = v.x + dx[i];
                int ny = v.y + dy[i];
                if (isValid(nx, ny) && arr[nx][ny] == 0) {
                    arr[nx][ny] = v.type;
                    queue.offer(new Virus(v.type, nx, ny, v.time + 1));
                }
            }

        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
