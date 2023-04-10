import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'A';
            arr[idx]++;
        }
        int cnt = 0;
        int mid = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                mid = i;
                cnt++;
            }

        }
        StringBuilder sb = new StringBuilder();
        if (cnt > 1 || (cnt == 1 && str.length() % 2 == 0)) {
            sb.append("I'm Sorry Hansoo");
            System.out.println(sb);
            return;
        } else {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i] / 2; j++)
                    sb.append((char) (i + 'A'));
            }
        }
        StringBuffer temp = new StringBuffer(sb.toString());
        if (cnt == 1)
            sb.append((char) (mid + 'A'));
        System.out.println(sb.toString() + temp.reverse());
    }
}
