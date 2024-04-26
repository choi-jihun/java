import java.io.*;
import java.util.*;

public class baekjoon_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> iter = list.listIterator();

            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (ch == '<') {
                    if (iter.hasPrevious()) {
                        iter.previous();
                    }
                } else if (ch == '>') {
                    if (iter.hasNext()) {
                        iter.next();
                    }
                } else if (ch == '-') {
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                } else {
                    iter.add(ch);
                }
            }

            StringBuilder sb = new StringBuilder();
            for (char ch : list) {
                sb.append(ch);
            }
            bw.write(sb.toString());
            bw.newLine();
        }
        bw.flush();
    }
}

