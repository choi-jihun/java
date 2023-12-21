import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class baekjoon_2204 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String temp = br.readLine();
            if (temp.equals("0")) {
                break;
            }

            List<String> list = new ArrayList<>();
            for (int i = 0; i < Integer.parseInt(temp); i++) {
                list.add(br.readLine());
            }
            list.sort(String.CASE_INSENSITIVE_ORDER);
            sb.append(list.get(0)).append('\n');
        }
        System.out.println(sb);
    }
}
