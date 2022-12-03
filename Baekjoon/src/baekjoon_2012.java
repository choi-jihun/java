import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon_2012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int []arr = new int [n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        long sum = 0;
        for(int i = 0; i < n; i++)
            sum+=Math.abs((i + 1) - arr[i]);
        System.out.println(sum);
    }
}
