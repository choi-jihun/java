import java.io.*;
import java.util.*;

public class baekjoon_19598 {

    static class School implements Comparable<School> {
        int st;
        int et;

        public School(int st, int et) {
            this.st = st;
            this.et = et;
        }

        @Override
        public int compareTo(School o) {
            return this.st - o.st;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<School> meetings = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meetings.add(new School(start, end));
        }

        Collections.sort(meetings);


        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        for (School meeting : meetings) {

            if (!rooms.isEmpty() && rooms.peek() <= meeting.st) {
                rooms.poll();
            }
            rooms.add(meeting.et);
        }

        bw.write(String.valueOf(rooms.size()));
        bw.flush();
        bw.close();
        br.close();
    }

}
