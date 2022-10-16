package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BFS_DFS {
	
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

	 public static void bfs(int v){
	        Queue<Integer> q = new LinkedList<>();
	        q.offer(v);
	        visited[v] = true;

	        while(!q.isEmpty()){
	            int value = q.poll();
	            System.out.print(value + " ");

	            for(int e : graph.get(value)){
	                if(!visited[e]){
	                    visited[e] = true;
	                    q.offer(e);
	                }
	            }
	        }
	    }
	 public static void dfs(int v){
	        visited[v] = true;
	        System.out.print(v + " ");
	        for(int value : graph.get(v)){
	            if(!visited[value]){
	                dfs(value);
	            }
	        }
	    }
	 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
		System.out.print("꼭지점의 개수 입력 : ");
		int V = sc.nextInt();
		System.out.print("간선의 개수 입력 : ");
		int E = sc.nextInt();
		for(int i = 0; i <= V; i++)
			graph.add(new ArrayList<>());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(v).add(w);
		}
		System.out.print("시작 노드 입력 : ");
		int start = sc.nextInt();
		visited = new boolean[V+1];
		bfs(start);
		dfs(start);
		sc.close();
	}

}
