import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

//https://airzinc.tistory.com/entry/%EB%B0%B1%EC%A4%80-16922-JAVA 코드 참고

public class baekjoon_16922 {
	
	static int []arr = {1,5,10,50};
	static int count = 0;
	static int N;
	static int []list;
	static boolean []visited = new boolean [10000];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new int [N];
		dfs(N, 0, 0);
		System.out.println(count);
	}
	static void dfs(int N, int start, int sum) {
		if(N==0) {
			if(!visited[sum]) {
				count++;
				visited[sum] = true;
			}
			return;
		}
		for(int i = start; i < arr.length; i++)
			dfs(N-1, i, sum + arr[i]);
	}
}