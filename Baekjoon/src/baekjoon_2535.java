import java.io.*;
import java.util.*;

public class baekjoon_2535 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Student> students = new ArrayList<>();
        for (int i = 0; i <N;i++) {
            st = new StringTokenizer(br.readLine());
            int country = Integer.parseInt(st.nextToken());
            int studentNum = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            students.add(new Student(country, studentNum, score));
        }

        students.sort((a, b) -> b.score - a.score);
        List<Student> medalWinners = new ArrayList<>();
        Map<Integer, Integer> countryMedalCount = new HashMap<>();

        for (Student student : students) {
            int country = student.country;
            countryMedalCount.putIfAbsent(country, 0);

            if (countryMedalCount.get(country) < 2) {
                medalWinners.add(student);
                countryMedalCount.put(country, countryMedalCount.get(country) + 1);
            }

            if (medalWinners.size() == 3) break;
        }

        for (Student winner : medalWinners) {
            bw.write(winner.country + " " + winner.studentNum);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Student {
        int country;
        int studentNum;
        int score;

        Student(int country, int studentNum, int score) {
            this.country = country;
            this.studentNum = studentNum;
            this.score = score;
        }
    }
}
