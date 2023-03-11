import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (str.equals("push"))
                stack.push(Integer.parseInt(st.nextToken()));

            if (str.equals("pop")) {
                if (stack.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(stack.pop()).append("\n");
            }

            if (str.equals("size"))
                sb.append(stack.size()).append("\n");

            if (str.equals("empty")) {
                if (stack.isEmpty())
                    sb.append(1).append("\n");
                else
                    sb.append(0).append("\n");
            }

            if (str.equals("top")) {
                if (stack.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(stack.peek()).append("\n");
            }
        }

        System.out.println(sb);
    }
}
