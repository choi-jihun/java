import java.io.*;
import java.util.*;

public class baekjoon_16236 {

    static class Shark {
        int x;
        int y;
        int size = 2;
        int eat = 0;
        int time = 0;

        public Shark(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    static int N;
    static int[][] arr;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static Shark shark;

    static List<List<Integer>> fishList = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    shark = new Shark(i, j);
                    arr[i][j] = 0;
                }
            }
        }

        while (findFish()) {
            fishList.sort((o1, o2) -> {
                if (o1.get(2).equals(o2.get(2))) { // 거리가 같다면
                    if (o1.get(0).equals(o2.get(0))) { // x 좌표가 같다면
                        return o1.get(1) - o2.get(1); // y 좌표가 작은 물고기부터
                    }
                    return o1.get(0) - o2.get(0); // x 좌표가 작은 물고기부터
                }
                return o1.get(2) - o2.get(2); // 거리가 작은 물고기부터
            });

            List<Integer> fish = fishList.get(0);
            shark.x = fish.get(0);
            shark.y = fish.get(1);
            shark.time += fish.get(2);
            shark.eat++;
            if (shark.eat == shark.size) {
                shark.size++;
                shark.eat = 0;
            }
            arr[shark.x][shark.y] = 0;
        }

        bw.write(String.valueOf(shark.time));
        bw.flush();
    }

    static boolean findFish() { //고기 찾기
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        queue.offer(new int[]{shark.x, shark.y, 0}); //x, y, 이동거리
        visited[shark.x][shark.y] = true;

        fishList.clear();
        boolean isFish = false;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if (isValid(nextX, nextY) && !visited[nextX][nextY] && arr[nextX][nextY] <= shark.size) {
                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY, dist + 1});
                    if (arr[nextX][nextY] != 0 && arr[nextX][nextY] < shark.size) {
                        fishList.add(Arrays.asList(nextX, nextY, dist + 1));
                        isFish = true;
                    }
                }
            }
        }

        return isFish;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
