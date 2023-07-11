import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class baekjoon_15720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        Integer[] burger = new Integer[B];
        Integer[] side = new Integer[C];
        Integer[] bev = new Integer[D];

        int be_sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            burger[i] = Integer.parseInt(st.nextToken());
            be_sum += burger[i];
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            side[i] = Integer.parseInt(st.nextToken());
            be_sum += side[i];
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < D; i++) {
            bev[i] = Integer.parseInt(st.nextToken());
            be_sum += bev[i];
        }

        Arrays.sort(burger, Collections.reverseOrder());
        Arrays.sort(side, Collections.reverseOrder());
        Arrays.sort(bev, Collections.reverseOrder());

        int sum = 0;

        int temp = Math.min(B, Math.min(C, D));

        for (int i = 0; i < temp; i++) {
            int temp_sum = (int) ((burger[i] + side[i] + bev[i]) * 0.9);
            sum += temp_sum;
        }

        if (B > temp) {
            int b = temp;
            while (B > b && b < burger.length)
                sum += burger[b++];
        }

        if (C > temp) {
            int c = temp;
            while (C > c && c < side.length)
                sum += side[c++];
        }

        if (D > temp) {
            int d = temp;
            while (D > d && d < bev.length)
                sum += bev[d++];
        }

        System.out.println(be_sum);
        System.out.println(sum);
    }
}
