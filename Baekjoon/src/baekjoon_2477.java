import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] arr = new int[6];
        int maxR = 0, maxC = 0;
        int indexR = 0, indexC = 0;

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());

            if (dir == 3 || dir == 4) {
                maxR = Math.max(maxR, dis);
                if (maxR == dis)
                    indexR = i;
            } else {
                maxC = Math.max(maxC, dis);
                if (maxC == dis)
                    indexC = i;
            }
            arr[i] = dis;
        }

        int nextR1 = arr[5], nextC1 = arr[5];
        int nextR2 = arr[0], nextC2 = arr[0];
        if (indexC - 1 > -1)
            nextR1 = arr[indexC - 1];
        if (indexC + 1 < 6)
            nextR2 = arr[indexC + 1];
        if (indexR - 1 > -1)
            nextC1 = arr[indexR - 1];
        if (indexR + 1 < 6)
            nextC2 = arr[indexR + 1];

        int area = maxC * Math.min(nextR1, nextR2) + Math.min(nextC1, nextC2) * (maxR - (Math.min(nextR1, nextR2)));

        System.out.println(area * K);
    }
}
