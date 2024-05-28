import java.io.*;
import java.util.*;

public class baekjoon_2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Line> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            list.add(new Line(x, y));
        }

        list.sort((a, b) -> {
            if (a.start != b.start) return Long.compare(a.start, b.start);
            return Long.compare(a.end, b.end);
        });

        long totalLength = getTotalLength(list, N);
        bw.write(totalLength + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    private static long getTotalLength(List<Line> list, int N) {
        long totalLength = 0;
        long currentStart = list.get(0).start;
        long currentEnd = list.get(0).end;

        for (int i = 1; i < N; i++) {
            Line segment = list.get(i);
            if (segment.start > currentEnd) {
                totalLength += currentEnd - currentStart;
                currentStart = segment.start;
                currentEnd = segment.end;
            } else if (segment.end > currentEnd) {
                currentEnd = segment.end;
            }
        }

        totalLength += currentEnd - currentStart;
        return totalLength;
    }
    static class Line {
        long start;
        long end;

        Line(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }
}
