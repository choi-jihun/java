import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon_11576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int sum = 0;
        for (int i = 0; i < m; i++)
            sum += (int) (arr[i] * Math.pow(A, m - (i + 1)));

        Stack<Integer> stack = new Stack<>();

        while (sum != 0) {
            stack.push(sum % B);
            sum /= B;
        }
        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.peek()).append(" ");
            stack.pop();
        }

        System.out.println(sb);
    }
}
