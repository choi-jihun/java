import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class baekjoon_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            String str = br.readLine();
            br.readLine();
            String arrayString = br.readLine();
            Deque<Integer> deque = parseArray(arrayString);

            boolean isError = false;
            boolean isReversed = false;
            for (char ch : str.toCharArray()) {
                if (ch == 'R') {
                    isReversed = !isReversed;
                } else if (ch == 'D') {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    } else {
                        if (isReversed) {
                            deque.removeLast();
                        } else {
                            deque.removeFirst();
                        }
                    }
                }
            }

            if (isError) {
                sb.append("error\n");
            } else {
                sb.append(dequeToString(deque, isReversed));
            }
        }
        System.out.println(sb);
    }

    private static Deque<Integer> parseArray(String arrayString) {
        Deque<Integer> deque = new ArrayDeque<>();
        String[] elements = arrayString.substring(1, arrayString.length() - 1).split(",");
        for (String element : elements) {
            if (!element.isEmpty()) {
                deque.add(Integer.parseInt(element));
            }
        }
        return deque;
    }

    private static String dequeToString(Deque<Integer> deque, boolean isReversed) {
        StringBuilder sb = new StringBuilder("[");
        while (!deque.isEmpty()) {
            sb.append(isReversed ? deque.removeLast() : deque.removeFirst());
            if (!deque.isEmpty()) {
                sb.append(",");
            }
        }
        sb.append("]\n");
        return sb.toString();
    }
}
