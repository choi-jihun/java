import java.io.*;
import java.util.*;

public class baekjoon_2812 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String str = br.readLine();

        Stack<Integer> stack = new Stack<Integer>();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int temp = str.charAt(i) - '0';
            while (!stack.isEmpty() && stack.peek() < temp && cnt != K) {
                stack.pop();
                cnt++;
            }
            stack.push(temp);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        String result = sb.reverse().toString().substring(0, N - K);

        bw.write(result);
        bw.close();
        br.close();
    }

}
