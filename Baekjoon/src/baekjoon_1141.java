import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class baekjoon_1141{

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }
        Arrays.sort(str, Comparator.comparingInt(String::length));

        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            boolean isPrefix = false;
            for (int j = i + 1; j < N; j++) {
                if (str[j].startsWith(str[i])) {
                    isPrefix = true;
                    break;
                }
            }
            if (!isPrefix) {
                list.add(str[i]);
            }
        }
        bw.write(String.valueOf(list.size()));
        bw.flush();
    }

}
