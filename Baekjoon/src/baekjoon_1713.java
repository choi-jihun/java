import java.io.*;
import java.util.*;

class Student implements Comparable<Student> {
    int id, count, time;

    Student(int id, int count, int time) {
        this.id = id;
        this.count = count;
        this.time = time;
    }

    public int compareTo(Student other) {
        if (this.count == other.count) {
            return this.time - other.time;
        }
        return this.count - other.count;
    }
}

public class baekjoon_1713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Student> frames = new ArrayList<>();
        Map<Integer, Student> map = new HashMap<>();

        int time = 0;

        for (int i = 0; i < M; i++) {
            int id = Integer.parseInt(st.nextToken());
            if (map.containsKey(id)) {
                map.get(id).count++;
            } else {
                if (frames.size() == N) {
                    Collections.sort(frames);
                    Student removed = frames.remove(0);
                    map.remove(removed.id);
                }
                Student newStudent = new Student(id, 1, time++);
                frames.add(newStudent);
                map.put(id, newStudent);
            }
        }

        frames.sort(Comparator.comparingInt(s -> s.id));
        for (Student s : frames) {
            bw.write(s.id + " ");
        }
        bw.flush();
    }
}
