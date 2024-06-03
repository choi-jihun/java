import java.io.*;

public class baekjoon_17615 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        if (N == 1 || str.chars().distinct().count() == 1) {
            bw.write("0\n");
            bw.flush();
            return;
        }

        int min = Math.min(minMoves(str, 'R'), minMoves(str, 'B'));

        bw.write(min + "\n");
        bw.flush();
    }
    public static int minMoves(String balls, char color) {
        int leftMoves = 0;
        int rightMoves = 0;

        boolean segmentFound = false;
        for (int i = 0; i < balls.length(); i++) {
            if (balls.charAt(i) == color) {
                if (!segmentFound) {
                    segmentFound = true;
                }
            } else if (segmentFound) {
                leftMoves++;
            }
        }

        segmentFound = false;
        for (int i = balls.length() - 1; i >= 0; i--) {
            if (balls.charAt(i) == color) {
                if (!segmentFound) {
                    segmentFound = true;
                }
            } else if (segmentFound) {
                rightMoves++;
            }
        }

        return Math.min(leftMoves, rightMoves);
    }
}
