import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class NumberWord implements Comparable<NumberWord> {
    int number;
    String word;

    public NumberWord(int number, String word) {
        this.number = number;
        this.word = word;
    }

    @Override
    public int compareTo(NumberWord other) {
        return this.word.compareTo(other.word);
    }
}

public class baekjoon_1755 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        NumberWord[] numbers = new NumberWord[M - N + 1];

        for (int i = N; i <= M; i++) {
            numbers[i - N] = new NumberWord(i, numberToWords(i));
        }

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length; i++) {
            bw.write(numbers[i].number + ((i % 10 == 9 || i == numbers.length - 1) ? "\n" : " "));
        }


        bw.flush();
    }

    public static String numberToWords(int number) {
        String[] units = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        if (number < 10) {
            return units[number];
        } else {
            int tens = number / 10;
            int ones = number % 10;
            return units[tens] + " " + units[ones];
        }
    }
}
