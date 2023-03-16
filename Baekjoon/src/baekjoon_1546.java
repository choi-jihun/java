import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        double[] arr = new double[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        double avg = 0;
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            avg += ((arr[i] / arr[N - 1]) * 100);
        }

        System.out.println(avg / N);
    }
}
