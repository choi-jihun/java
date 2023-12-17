import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon_11536 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] names = new String[N];

        for (int i = 0; i < N; i++) {
            names[i] = br.readLine();
        }

        if (isSorted(names, true)) {
            System.out.println("INCREASING");
        } else if (isSorted(names, false)) {
            System.out.println("DECREASING");
        } else {
            System.out.println("NEITHER");
        }
    }

    public static boolean isSorted(String[] array, boolean ascending) {
        String[] sortedArray = array.clone();
        Arrays.sort(sortedArray);

        if (!ascending) {
            reverse(sortedArray);
        }

        return Arrays.equals(array, sortedArray);
    }

    public static void reverse(String[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            String temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }
}
