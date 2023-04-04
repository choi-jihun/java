import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[10];
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            if (num == 6)
                arr[9]++;
            else
                arr[num]++;
        }
        int max = 0;
        for (int i = 0; i < 9; i++)
            max = Math.max(max, arr[i]);
        int temp = arr[9] / 2;
        if (arr[9] % 2 == 1)
            temp++;
        max = Math.max(max, temp);
        System.out.println(max);
    }
}
