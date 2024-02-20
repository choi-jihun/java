import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_21610 {

    static int[][] arr;
    static boolean[][] cloud;
    static int N, M;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static ArrayList<ArrayList<Integer>> clouds = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        cloud = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clouds.add(new ArrayList<>(Arrays.asList(N - 1, 0)));
        clouds.add(new ArrayList<>(Arrays.asList(N - 1, 1)));
        clouds.add(new ArrayList<>(Arrays.asList(N - 2, 0)));
        clouds.add(new ArrayList<>(Arrays.asList(N - 2, 1)));

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken()) - 1;
            int dis = Integer.parseInt(st.nextToken());

            moveCloud(dir, dis);
            copyWater();
            makeNewClouds();
        }

        int totalWater = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                totalWater += arr[i][j];
            }
        }

        bw.write(totalWater + "");
        bw.flush();
    }

    static void moveCloud(int dir, int dis) {
        cloud = new boolean[N][N];
        ArrayList<ArrayList<Integer>> newClouds = new ArrayList<>();
        for (ArrayList<Integer> c : clouds) {
            int nx = Math.floorMod(c.get(0) + dx[dir] * dis, N); //나머지가 음수여도 양수 반환
            int ny = Math.floorMod(c.get(1) + dy[dir] * dis, N);
            newClouds.add(new ArrayList<>(Arrays.asList(nx, ny)));
            arr[nx][ny]++;
            cloud[nx][ny] = true;
        }
        clouds = newClouds;
    }

    static void copyWater() {
        for (ArrayList<Integer> cloud : clouds) {
            int x = cloud.get(0);
            int y = cloud.get(1);
            for (int i = 1; i < 8; i += 2) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && arr[nx][ny] > 0) {
                    arr[x][y]++;
                }
            }
        }
    }

    static void makeNewClouds() {
        clouds.clear();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] >= 2 && !cloud[i][j]) {
                    arr[i][j] -= 2;
                    clouds.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
    }
}
