import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        int min = 0;
        for (int i = 0; i < N - 1; i++) {
            int dis = arr[i + 1] - arr[i];
            min = findGCD(dis, min);
        }

        System.out.println((arr[N - 1] - arr[0]) / min + 1 - arr.length);
    }

    static int findGCD(int A, int B) {
        while (B != 0) {
            int R = A % B;
            A = B;
            B = R;
        }
        return A;
    }
}
