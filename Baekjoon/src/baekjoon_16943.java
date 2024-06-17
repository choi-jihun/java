import java.io.*;
import java.util.*;

public class baekjoon_16943 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        int result = findMaxPermutation(A, B);

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    public static int findMaxPermutation(String A, int B) {
        List<String> permutations = new ArrayList<>();
        permutation(A.toCharArray(), 0, permutations);

        int max = -1;
        for (String perm : permutations) {
            if (perm.charAt(0) != '0') {
                int num = Integer.parseInt(perm);
                if (num < B && num > max) {
                    max = num;
                }
            }
        }

        return max;
    }

    public static void permutation(char[] arr, int index, List<String> permutations) {
        if (index == arr.length - 1) {
            permutations.add(new String(arr));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            permutation(arr, index + 1, permutations);
            swap(arr, index, i);
        }
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
