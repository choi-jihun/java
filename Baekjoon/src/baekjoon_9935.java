import java.io.*;
import java.util.*;

public class baekjoon_9935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        String temp = br.readLine();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            if (stack.size() >= temp.length()) {
                boolean isBomb = true;
                for (int j = 0; j < temp.length(); j++) {
                    if (stack.get(stack.size() - temp.length() + j) != temp.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }

                if (isBomb) {
                    for (int j = 0; j < temp.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }

        bw.write((sb.length() > 0) ? sb.toString() : "FRULA");
        bw.flush();
        bw.close();
        br.close();
    }

}
