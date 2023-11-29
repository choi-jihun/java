import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_24060 {

    static int saveCount = 0;
    static int result = -1;

    static void merge(int[] arr, int start, int mid, int end, int K) {
        int s = start;
        int m = mid + 1;
        int k = 0;
        int[] temp = new int[end - start + 1];

        while (s <= mid && m <= end) {
            if (arr[s] <= arr[m]) {
                temp[k++] = arr[s++];
            } else {
                temp[k++] = arr[m++];
            }
            if (++saveCount == K) {
                result = temp[k - 1];
                return;
            }
        }

        while (s <= mid) {
            temp[k++] = arr[s++];
            if (++saveCount == K) {
                result = temp[k - 1];
                return;
            }
        }
        while (m <= end) {
            temp[k++] = arr[m++];
            if (++saveCount == K) {
                result = temp[k - 1];
                return;
            }
        }

        for (int i = start; i <= end; i++) {
            arr[i] = temp[i - start];
        }
    }

    static void merge_sort(int[] arr, int start, int end, int K) {
        if (start < end) {
            int mid = (start + end) / 2;
            merge_sort(arr, start, mid, K);
            merge_sort(arr, mid + 1, end, K);
            merge(arr, start, mid, end, K);
        }
    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(arr, 0, N - 1, K);
        System.out.println(result);
    }
}
