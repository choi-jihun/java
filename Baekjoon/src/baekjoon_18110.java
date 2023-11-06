import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon_18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        float temp = (float) (n * 0.15);
        int solve = Math.round((temp));
        int sum = 0;

        for (int i = solve; i < n - solve; i++) {
            sum += arr[i];
        }

        float fAvg = (float) sum / (n - (solve * 2));
        System.out.println(Math.round(fAvg));
    }
}
