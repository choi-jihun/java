import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        double majorSum = 0;
        double gradeSum = 0;

        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            Double major = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            majorSum += major;

            if (grade.equals("A+"))
                gradeSum += major * 4.5;
            else if (grade.equals("A0")) {
                gradeSum += major * 4.0;
            } else if (grade.equals("B+")) {
                gradeSum += major * 3.5;
            } else if (grade.equals("B0")) {
                gradeSum += major * 3.0;
            } else if (grade.equals("C+")) {
                gradeSum += major * 2.5;
            } else if (grade.equals("C0")) {
                gradeSum += major * 2.0;
            } else if (grade.equals("D+")) {
                gradeSum += major * 1.5;
            } else if (grade.equals("D0")) {
                gradeSum += major * 1.0;
            } else if (grade.equals("F")) {
                gradeSum += major * 0.0;
            } else if (grade.equals("P"))
                majorSum -= major;
        }

        System.out.println(gradeSum / majorSum);
    }
}
