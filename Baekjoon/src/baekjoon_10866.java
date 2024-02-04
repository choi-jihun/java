import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class baekjoon_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();

        while (N-- > 0) {
            String[] strArr = br.readLine().split(" ");
            switch (strArr[0]) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(strArr[1]));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(strArr[1]));
                    break;
                case "pop_front":
                    if (!deque.isEmpty()) {
                        sb.append(deque.removeFirst()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;
                case "pop_back":
                    if (!deque.isEmpty()) {
                        sb.append(deque.removeLast()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    if (!deque.isEmpty()) {
                        sb.append(deque.peekFirst()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;
                case "back":
                    if (!deque.isEmpty()) {
                        sb.append(deque.peekLast()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
