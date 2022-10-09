import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon_1260 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 정점
		int M = sc.nextInt(); // 간선
		int V = sc.nextInt(); // 시작 정점 번호

		int[][] a = new int[N+1][N+1];
		boolean[] c = new boolean[N+1];

		// 인접행렬 만들기
		for (int i = 0; i < M; i++) {
			int a1 = sc.nextInt();
			int a2 = sc.nextInt();

			a[a1][a2] = 1;
			a[a2][a1] = 1;
		}
		DFS(a,c,V);
		System.out.println();
		Arrays.fill(c, false);
		BFS(a,c,V);
		
		
	}
	static void DFS(int [][]arr, boolean[] visited, int start) {
		int length = arr.length;
		visited[start] = true;
		System.out.print(start + " ");
		for(int i =1;i<length;i++) {
			if(arr[start][i] == 1 && visited[i] == false)
				DFS(arr,visited,i);
		}
	}
	
	static void BFS(int [][]arr, boolean[] visited, int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		int length = arr.length;
		q.add(start);
		visited[start] = true;
		while(!q.isEmpty()) {
			start = q.poll();
			System.out.print(start + " ");
			for(int i = 1; i<length;i++) {
				if(arr[start][i] == 1 && visited[i]==false) {
					q.add(i);
					visited[i]=true;
				}
			}
		}
	}

}
