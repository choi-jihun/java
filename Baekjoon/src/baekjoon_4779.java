import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_4779 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringBuilder sb = new StringBuilder();

        while ((str = br.readLine()) != null && !str.isEmpty()) {
            int N = Integer.parseInt(str);
            StringBuilder temp = new StringBuilder();
            int count = (int) Math.pow(3, N);
            temp.append("-".repeat(Math.max(0, count)));
            recursive(temp, 0, count);
            sb.append(temp).append("\n");
        }
        System.out.println(sb);
    }

    static void recursive(StringBuilder temp, int start, int end) {
        if (end - start <= 1) {
            return;
        }

        int mid = (end - start) / 3;
        for (int i = start + mid; i < start + 2 * mid; i++) {
            temp.setCharAt(i, ' ');
        }

        recursive(temp, start, start + mid);
        recursive(temp, start + 2 * mid, end);
    }


}
