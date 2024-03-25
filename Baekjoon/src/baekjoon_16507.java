import java.io.*;
import java.util.StringTokenizer;

public class baekjoon_16507 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[][] arr = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] sumArr = new int[R][C];
        for (int i = 0; i < R; i++) {
            sumArr[i][0] = arr[i][0];
        }
        for (int i = 0; i < C; i++) {
            sumArr[0][i] = arr[0][i];
        }

        for (int i = 1; i < R; i++) {
            sumArr[i][0] = sumArr[i - 1][0] + arr[i][0];
        }
        for (int i = 1; i < C; i++) {
            sumArr[0][i] = sumArr[0][i - 1] + arr[0][i];
        }

        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                sumArr[i][j] = arr[i][j] + sumArr[i - 1][j] + sumArr[i][j - 1] - sumArr[i - 1][j - 1];
            }
        }


        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken()) - 1;
            int sy = Integer.parseInt(st.nextToken()) - 1;
            int ex = Integer.parseInt(st.nextToken()) - 1;
            int ey = Integer.parseInt(st.nextToken()) - 1;

            int total = sumArr[ex][ey];
            if (sx > 0) total -= sumArr[sx - 1][ey];
            if (sy > 0) total -= sumArr[ex][sy - 1];
            if (sx > 0 && sy > 0) total += sumArr[sx - 1][sy - 1];
            int area = (ex - sx + 1) * (ey - sy + 1);
            int avg = total / area;
            bw.write(String.format("%d\n", avg));
        }

        bw.flush();
    }

}