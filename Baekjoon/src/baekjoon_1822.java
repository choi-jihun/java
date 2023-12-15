import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class baekjoon_1822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        TreeSet<Integer> tree = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            tree.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < B; j++) {
            int temp = Integer.parseInt(st.nextToken());
            tree.remove(temp);
        }


        sb.append(tree.size()).append("\n");
        for (Integer num : tree) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}
