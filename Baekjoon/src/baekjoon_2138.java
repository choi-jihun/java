import java.io.*;

public class baekjoon_2138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[] firstClick = br.readLine().toCharArray();
        char[] firstNonClick = firstClick.clone();
        char[] target = br.readLine().toCharArray();

        int count1 = 0;
        for (int i = 1; i < N; i++) {
            if (firstClick[i - 1] != target[i - 1]) {
                count1++;
                toggle(firstClick, i);
            }
        }

        if (firstClick[N - 1] != target[N - 1]) {
            count1 = -1;
        }

        int count2 = 1;
        toggle(firstNonClick, 0);
        for (int i = 1; i < N; i++) {
            if (firstNonClick[i - 1] != target[i - 1]) {
                count2++;
                toggle(firstNonClick, i);
            }
        }

        if (firstNonClick[N - 1] != target[N - 1]) {
            count2 = -1;
        }

        if (count1 == -1 && count2 == -1) {
            bw.write("-1\n");
        } else if (count1 == -1) {
            bw.write(count2 + "\n");
        } else if (count2 == -1) {
            bw.write(count1 + "\n");
        } else {
            bw.write(Math.min(count1, count2) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static void toggle(char[] arr, int index) {
        for (int i = index - 1; i <= index + 1; i++) {
            if (i >= 0 && i < arr.length) {
                arr[i] = arr[i] == '0' ? '1' : '0';
            }
        }
    }
}
