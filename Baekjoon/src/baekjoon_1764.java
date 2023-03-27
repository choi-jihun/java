import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class baekjoon_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < N; i++)
            set.add(br.readLine());

        int cnt = 0;
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (set.contains(str)) {
                arr.add(str);
                cnt++;
            }
        }
        sb.append(cnt).append("\n");
        Collections.sort(arr);
        for (String s : arr)
            sb.append(s).append("\n");

        System.out.println(sb);
    }
}
