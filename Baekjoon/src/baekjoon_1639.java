import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1639 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int[] arr = new int[S.length()];

        for (int i = 0; i < S.length(); i++)
            arr[i] = Integer.parseInt(String.valueOf(S.charAt(i)));

        int start, mid, end;
        int left = 0, right = 0;
        int s, e;
        end = S.length() % 2 == 0 ? S.length() : S.length() - 1;
        end += 2;
        while (end > 2) {
            start = 0;
            end -= 2;
            e = end;
            s = start;

            while (e <= S.length()) {
                mid = (s + e) / 2;
                left = 0;
                right = 0;
                for (int i = s; i < mid; i++)
                    left += arr[i];
                for (int i = mid; i < e; i++)
                    right += arr[i];

                if (left == right) {
                    System.out.println(end);
                    return;
                }
                s++;
                e++;
            }
        }
        System.out.println(0);
    }
}
