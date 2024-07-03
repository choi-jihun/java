import java.util.*;

public class programmers_이중우선순위큐 {

    class Solution {
        public int[] solution(String[] operations) {
            PriorityQueue<Integer> min = new PriorityQueue<>();
            PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
            StringTokenizer st;

            for (String operation : operations) {
                st = new StringTokenizer(operation);
                char op = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                switch (op) {
                    case 'I':
                        min.add(num);
                        max.add(num);
                        break;
                    case 'D':
                        if (min.isEmpty()) {
                            break;
                        }
                        if (num == -1) {
                            int temp = min.poll();
                            max.remove(temp);
                        }
                        if (max.isEmpty()) {
                            break;
                        }
                        if (num == 1) {
                            int temp = max.poll();
                            min.remove(temp);
                        }
                }
            }
            if (max.isEmpty()) {
                return new int[]{0, 0};
            }
            return new int[] {max.peek(),min.peek()};
        }
    }
}
