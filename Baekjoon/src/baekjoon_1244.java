import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1244 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int temp = Integer.parseInt(br.readLine());
        for (int i = 0; i < temp; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            if (gender == 1) {
                for (int j = 1; j < N + 1; j++) {
                    if (j % idx == 0) {
                        arr[j] = Math.abs(arr[j] - 1);
                    }
                }
            } else {
                int j = 1;
                arr[idx] = Math.abs(arr[idx] - 1);
                while (idx - j >= 1 && idx + j < N + 1) {
                    if (arr[idx - j] == arr[idx + j]) {
                        arr[idx - j] = Math.abs(arr[idx - j] - 1);
                        arr[idx + j] = Math.abs(arr[idx + j] - 1);
                    } else {
                        break;
                    }
                    j++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            sb.append(arr[i]).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

}
