import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class baekjoon_1337 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(numbers);

        int minAdditionalNumbers = Integer.MAX_VALUE;

        for (int i = 0; i < numbers.size(); i++) {
            int count = 1;
            for (int j = i + 1; j < numbers.size() && count < 5; j++) {
                if (numbers.get(j) - numbers.get(i) <= 4) {
                    count++;
                }
            }
            minAdditionalNumbers = Math.min(minAdditionalNumbers, 5 - count);
        }

        System.out.println(minAdditionalNumbers);
    }
}
