package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Longest_Path {
	static class Node{
		int idx;
		int cost;
		Node(int idx, int cost){
			this.idx = idx;
			this.cost = cost;
			}
		}
	static class Graph{
		int vertex;
		ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
		Graph(int vertex){
			this.vertex = vertex;
			for(int i = 0; i < vertex; i++)
				graph.add(new ArrayList<Node>());
		}
		void addEdge(int u, int v, int cost) {
			Node node = new Node(v,cost);
			graph.get(u).add(node);
		}
		void topologicalSort(int v, boolean visited[], Stack<Integer> stack) {
			visited[v] = true;
			for(int i = 0; i < graph.get(v).size();i++) {
				Node node = graph.get(v).get(i);
				if(!visited[node.idx])
					topologicalSort(node.idx,visited,stack);
			}
			stack.push(v);
		}
		void longestPath(int s) {
			Stack<Integer> stack = new Stack<Integer>();
			int[] dist = new int[vertex];
			boolean[] visited = new boolean[vertex];
			for(int i = 0; i < vertex;i++)
				visited[i] = false;
			for(int i = 0; i < vertex; i++)
				if(visited[i] == false)
					topologicalSort(i,visited,stack);
			for(int i = 0; i < vertex; i++)
				dist[i] = Integer.MIN_VALUE;
			dist[s] = 0;
			
			while(stack.isEmpty() == false) {
				int u = stack.peek();
				stack.pop();
				if(dist[u] != Integer.MIN_VALUE) {
					for(int i=0;i<graph.get(u).size();i++) {
						Node node = graph.get(u).get(i);
						if(dist[node.idx]<dist[u]+node.cost)
							dist[node.idx] = dist[u]+node.cost;
					}
				}
			}
			for(int i = 0; i <vertex;i++)
				if(dist[i] == Integer.MIN_VALUE)
					System.out.print("INF ");
				else
					System.out.print(dist[i] + " ");
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("정접의 개수 입력");
		int V = input.nextInt();
		System.out.print("간선의 개수 입력");
		int E = input.nextInt();
		Graph g = new Graph(V);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(bf.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			g.addEdge(v,w,cost);
		}
		System.out.print("시작점 입력");
		int start = input.nextInt();
		g.longestPath(start);
		input.close();
	}
}


