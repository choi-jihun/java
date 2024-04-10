import java.io.*;
import java.util.Stack;

public class baekjoon_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        boolean isValid = true;
        int result = 0;
        int tmp = 1;

        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '(':
                    stack.push('(');
                    tmp *= 2;
                    break;
                case '[':
                    stack.push('[');
                    tmp *= 3;
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        isValid = false;
                        break;
                    }
                    if (str.charAt(i - 1) == '(')
                        result += tmp;
                    stack.pop();
                    tmp /= 2;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        isValid = false;
                        break;
                    }
                    if (str.charAt(i - 1) == '[')
                        result += tmp;
                    stack.pop();
                    tmp /= 3;
                    break;
            }
            if (!isValid) break;
        }

        if (!isValid || !stack.isEmpty()) {
            result = 0;
        }

        bw.write(result + "\n");
        bw.flush();
    }

}
