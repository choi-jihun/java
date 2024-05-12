import java.io.*;
import java.util.*;

public class baekjoon_2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[] heights = new int[1001];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            heights[L] = H;
        }

        int area = getArea(heights);

        bw.write(String.valueOf(area));
        bw.flush();
    }

    private static int getArea(int[] heights) {
        int maxHeight = 0;
        int maxIndex = 0;
        for (int i = 1; i <= 1000; i++) {
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
                maxIndex = i;
            }
        }

        int area = 0;
        int currentHeight = 0;
        for (int i = 1; i <= maxIndex; i++) {
            if (heights[i] > currentHeight) {
                currentHeight = heights[i];
            }
            area += currentHeight;
        }

        currentHeight = 0;
        for (int i = 1000; i >= maxIndex; i--) {
            if (heights[i] > currentHeight) {
                currentHeight = heights[i];
            }
            area += currentHeight;
        }

        area -= maxHeight;
        return area;
    }
}
