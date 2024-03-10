import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//union-find 사용
//잘 모르겠어서 인터넷을 좀 찾아봄
//시간 복잡도는 O(N)
//77652KB 920ms
public class baekjoon_4195 {
    //사용자 부모를 저장하는 맵(자신의 루트를 찾음)
    static Map<String, String> parent = new HashMap<>();
    //루트의 크기를 저장하는 맵
    static Map<String, Integer> networkSize = new HashMap<>();
    //find 연산 x의 루트를 찾음
    static String find(String x) {
        //x의 부모 찾기
        if (!x.equals(parent.get(x))) { //x가 자기 자신을 부모로 가지지 않으면
            parent.put(x, find(parent.get(x))); //x의 현재 부모의 부모를 찾음
        }
        return parent.get(x);
    }
    static int union(String x, String y) {
        x = find(x); //x의 루트 찾기
        y = find(y); //y의 루트 찾기
        if (!x.equals(y)) { // x와 y의 루트가 다르면
            parent.put(y, x); //y루트를 x루트에 연결
            networkSize.put(x, networkSize.get(x) + networkSize.get(y)); //x네트워크 크기를 업데이트 해줌
        }
        return networkSize.get(x);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            int F = Integer.parseInt(br.readLine());
            parent.clear();
            networkSize.clear();

            for (int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                parent.putIfAbsent(a, a);
                parent.putIfAbsent(b, b);
                networkSize.putIfAbsent(a, 1);
                networkSize.putIfAbsent(b, 1);

                bw.write(union(a, b) + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
