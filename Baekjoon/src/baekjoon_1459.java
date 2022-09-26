import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://buzz-program.tistory.com/entry/BOJ1459%EA%B1%B7%EA%B8%B0 

public class baekjoon_1459 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(bf.readLine());
		long x = Integer.parseInt(st.nextToken());
		long y = Integer.parseInt(st.nextToken());
		long w = Integer.parseInt(st.nextToken());
		long s = Integer.parseInt(st.nextToken());
		long time = 0;
		long path1 = (x+y) * w;
		long path2;
		if((x+y)%2==0)
			path2 = Math.max(x,y)*s;
		else
			path2 = (Math.max(x,y)-1) * s + w;
		long path3 = (Math.min(x, y)*s)+(Math.abs(x-y)*w);
		time = (long)Math.min(path1,path2);
		time = (long)Math.min(time, path3);
		System.out.println(time);
	}

}
