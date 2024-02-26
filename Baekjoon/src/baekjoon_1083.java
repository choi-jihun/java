import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon_1083 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int S = Integer.parseInt(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            int maxPos = i;
            for (int j = i + 1; j < N && j <= i + S; j++) {
                if (arr[j] > arr[maxPos]) {
                    maxPos = j;
                }
            }
            for (int k = maxPos; k > i; k--) {
                int temp = arr[k];
                arr[k] = arr[k - 1];
                arr[k - 1] = temp;
                S--;
            }
        }
        for (int i = 0; i < N; i++) {
            bw.write(arr[i] + " ");
        }
        bw.flush();
    }

}
