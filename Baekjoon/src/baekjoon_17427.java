import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_17427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        int[] arr = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = i; j < N + 1; j += i) {
                arr[j] += i;
            }
        }

        long sum = 0;
        for (int i = 1; i < N + 1; i++)
            sum += arr[i];

        System.out.println(sum);
    }
}
