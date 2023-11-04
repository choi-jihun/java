import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_10157 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[C][R];

        int K = Integer.parseInt(br.readLine());

        int temp = 1;
        if (K > C * R) {
            System.out.println(0);
            return;
        }
        int x = 0, y = 0;
        int dir = 0;
        while (true) {
            arr[x][y] = temp;
            if (temp == K) {
                System.out.println((x + 1) + " " + (y + 1));
                return;
            }
            if (x + dx[dir] < 0 || y + dy[dir] < 0 || x + dx[dir] >= C || y + dy[dir] >= R || arr[x + dx[dir]][y + dy[dir]] != 0)
                dir = (dir + 1) % 4;
            x += dx[dir];
            y += dy[dir];

            temp++;
        }
    }
}
