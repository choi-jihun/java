import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon_2526 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        int temp = N;
        while (true) {
            if (list.contains(temp)) {
                System.out.println(list.size() - list.lastIndexOf(temp));
                break;
            }
            list.add(temp);
            temp = temp * N % P;
        }

    }
}
