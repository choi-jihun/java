import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_1551 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine(), ",");
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int[] arr2 = Arrays.copyOf(arr, arr.length);
        int arrLength = N - 1;

        while (K != 0) {
            int[] newArr = new int[arrLength];

            for (int i = 0; i < arr2.length - 1; i++)
                newArr[i] = arr2[i + 1] - arr2[i];

            arrLength--;
            K--;
            arr2 = Arrays.copyOf(newArr, newArr.length);
        }

        for (int i = 0; i < arr2.length; i++)
            if (i != arr2.length - 1)
                System.out.print(arr2[i] + ",");
            else
                System.out.println(arr2[i]);
    }
}
