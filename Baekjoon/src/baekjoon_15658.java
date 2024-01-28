import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_15658 {
    static int N;
    static int[] numbers;
    static int[] operators;
    static int maxValue = Integer.MIN_VALUE;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        operators = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        calculate(numbers[0], 1);
        System.out.println(maxValue);
        System.out.println(minValue);
    }


    public static void calculate(int currentValue, int index) {
        if (index == N) {
            maxValue = Math.max(maxValue, currentValue);
            minValue = Math.min(minValue, currentValue);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                switch (i) {
                    case 0:
                        calculate(currentValue + numbers[index], index + 1);
                        break;
                    case 1:
                        calculate(currentValue - numbers[index], index + 1);
                        break;
                    case 2:
                        calculate(currentValue * numbers[index], index + 1);
                        break;
                    case 3:
                        calculate(currentValue / numbers[index], index + 1);
                        break;
                }
                operators[i]++;
            }
        }
    }
}
