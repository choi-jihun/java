import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class baekjoon_28279 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int mis = Integer.parseInt(st.nextToken());
            switch (mis) {
                case 1: {
                    deque.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                }
                case 2: {
                    deque.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                }
                case 3: {
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.pollFirst() + "\n");
                    }
                    break;
                }
                case 4: {
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.pollLast() + "\n");
                    }
                    break;
                }
                case 5: {
                    bw.write(deque.size() + "\n");
                    break;
                }
                case 6: {
                    if (deque.isEmpty()) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                }
                case 7: {
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        int temp = deque.pollFirst();
                        bw.write(temp + "\n");
                        deque.offerFirst(temp);
                    }
                    break;
                }
                case 8: {
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        int temp = deque.pollLast();
                        bw.write(temp + "\n");
                        deque.offerLast(temp);
                    }
                    break;
                }

            }

        }
        bw.flush();

    }

}