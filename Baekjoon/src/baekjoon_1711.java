import java.io.*;
import java.util.StringTokenizer;

public class baekjoon_1711 {

    static class Point {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            points[i] = new Point(x, y);
        }

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    long x1 = points[i].x;
                    long y1 = points[i].y;
                    long x2 = points[j].x;
                    long y2 = points[j].y;
                    long x3 = points[k].x;
                    long y3 = points[k].y;

                    long dist1 = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
                    long dist2 = (x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3);
                    long dist3 = (x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3);

                    if (dist1 + dist2 == dist3 || dist1 + dist3 == dist2 || dist2 + dist3 == dist1) {
                        cnt++;
                    }
                }
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}