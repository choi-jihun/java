import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon_3986 {

    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        cnt = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            checkWord(str);
        }

        System.out.println(cnt);
    }

    static void checkWord(String str) {
        if (str.length() % 2 == 1)
            return;
        Stack<Character> stack = new Stack<>();
        stack.push(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if (stack.size() > 0 && stack.peek() == str.charAt(i))
                stack.pop();
            else
                stack.push(str.charAt(i));
        }
        if (stack.isEmpty())
            cnt++;
    }
}
