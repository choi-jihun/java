import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[46];
        arr[0] = 0;
        arr[1] = 1;
        if (n < 2)
            System.out.println(n);
        else {
            for (int i = 2; i < n + 1; i++)
                arr[i] = arr[i - 2] + arr[i - 1];
            System.out.println(arr[n]);
        }
    }
}
