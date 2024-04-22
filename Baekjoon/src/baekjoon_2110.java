import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int answer = getAnswer(arr, N, C);

        bw.write(answer + "\n");
        bw.flush();
    }

    private static int getAnswer(int[] arr, int N, int C) {
        int left = 1; // 최소 거리
        int right = arr[N - 1] - arr[0]; // 최대 거리
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2; // 중간값 거리
            int installed = 1;
            int lastInstall = arr[0]; // 마지막으로 공유기를 설치한 위치

            for (int i = 1; i < N; i++) {
                if (arr[i] - lastInstall >= mid) { // 공유기 설치가 가능하면
                    installed++;
                    lastInstall = arr[i]; // 마지막 공유기 설치 위치 갱신
                }
            }

            if (installed >= C) { // 공유기를 C개 이상 설치할 수 있으면 거리 늘리기
                left = mid + 1;
                answer = mid;
            } else { // 아니면 거리를 줄이기
                right = mid - 1;
            }
        }
        return answer;
    }
}
