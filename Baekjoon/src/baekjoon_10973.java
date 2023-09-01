import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_10973 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        if (function(arr)) {
            for (int val : arr)
                System.out.print(val + " ");
        } else
            System.out.println(-1);
    }

    static boolean function(int[] arr) {
        int i = arr.length - 1;
        while (i > 0 && arr[i] > arr[i - 1])
            i--;

        if (i == 0)
            return false;

        int j = arr.length - 1;
        while (arr[i - 1] < arr[j])
            j--;
        swap(arr, i - 1, j);

        j = arr.length - 1;
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }

        return true;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
