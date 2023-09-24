import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_5355 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String str = br.readLine();
            String[] arr = str.split(" ");
            float n = Float.parseFloat(arr[0]);
            for (int i = 1; i < arr.length; i++) {
                if (arr[i].equals("@"))
                    n *= 3;
                else if (arr[i].equals("%"))
                    n += 5;
                else
                    n -= 7;
            }
            sb.append(String.format("%.2f", n)).append("\n");
        }

        System.out.println(sb);
    }
}
