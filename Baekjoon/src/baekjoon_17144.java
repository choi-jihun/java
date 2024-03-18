import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon_17144{

    static int R, C, T;
    static int[][] arr;
    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { 1, 0, -1, 0 };
    static int fx, fy, sx, sy;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == -1) {
                    if (fx == 0 && fy == 0) {
                        fx = i;
                        fy = j;
                    } else {
                        sx = i;
                        sy = j;
                    }
                }
            }
        }

        while (T-- > 0) {
            spread();
            clean(fx, true);
            clean(sx, false);
        }

        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] != -1 && arr[i][j] != 0) {
                    sum += arr[i][j];
                }
            }
        }

        bw.write(String.valueOf(sum));
        bw.flush();
    }

    static void spread() {
        int[][] temp = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] > 0) {
                    int spreadAmount = arr[i][j] / 5;
                    int spreadCount = 0;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx >= 0 && nx < R && ny >= 0 && ny < C && arr[nx][ny] != -1) {
                            temp[nx][ny] += spreadAmount;
                            spreadCount++;
                        }
                    }
                    arr[i][j] -= spreadAmount * spreadCount;
                }
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                arr[i][j] += temp[i][j];
            }
        }
    }

    static void clean(int x, boolean isUp) {
        if (isUp) {
            for (int i = x - 1; i > 0; i--)
                arr[i][0] = arr[i - 1][0];
            for (int i = 0; i < C - 1; i++)
                arr[0][i] = arr[0][i + 1];
            for (int i = 0; i < x; i++)
                arr[i][C - 1] = arr[i + 1][C - 1];
            for (int i = C - 1; i > 1; i--)
                arr[x][i] = arr[x][i - 1];
        } else {
            for (int i = x + 1; i < R - 1; i++)
                arr[i][0] = arr[i + 1][0];
            for (int i = 0; i < C - 1; i++)
                arr[R - 1][i] = arr[R - 1][i + 1];
            for (int i = R - 1; i > x; i--)
                arr[i][C - 1] = arr[i - 1][C - 1];
            for (int i = C - 1; i > 1; i--)
                arr[x][i] = arr[x][i - 1];
        }
        arr[x][1] = 0;
    }

}
