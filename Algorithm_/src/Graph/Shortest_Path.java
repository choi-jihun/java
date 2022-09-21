package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Node{
	int idx;
	int cost;
	
	Node(int idx, int cost){
		this.idx = idx;
		this.cost = cost;
	}
}
public class Shortest_Path  {

	public static void shortest_path(int start,int n, ArrayList<ArrayList<Node>> graph) {
		boolean []chk = new boolean[n+1];
		int[] dist = new int[n+1];
		for(int i=0; i<dist.length;i++)
			dist[i] = Integer.MAX_VALUE;
		dist[start] = 0;
		
		for(int i = 0; i < n;i++) {
			int nodeCost = Integer.MAX_VALUE;
			int nodeIdx = 0;
			for(int j=1;j<n+1;j++) {
				if(!chk[i] && dist[j]<nodeCost) {
					nodeCost = dist[j];
					nodeIdx=j;
				}
				chk[nodeIdx] = true;
				for(int x = 0; x < graph.get(nodeIdx).size();x++) {
					Node adj = graph.get(nodeIdx).get(x);
					if(dist[adj.idx]>dist[nodeIdx]+adj.cost)
						dist[adj.idx] = dist[nodeIdx]+adj.cost;
				}
			}
		}
		
		for(int i = 1; i < n + 1; i++) {
			if(dist[i]==Integer.MAX_VALUE)
				System.out.print("MAX_VALUE"+"  ");
			else
				System.out.print(dist[i] + "  ");
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		System.out.print("꼭지점의 개수 입력 : ");
		int V = sc.nextInt();
		System.out.print("간선의 개수 입력 : ");
		int E = sc.nextInt();
		ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>(); 
		for (int i = 0; i <= V + 1; i++)
			graph.add(new ArrayList<>());
		StringTokenizer st;
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(bf.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph.get(v).add(new Node(w,cost));
		}
		System.out.print("시작 노드 입력 : ");
		int start = sc.nextInt();
		shortest_path(start,V,graph);
		sc.close();
	}

}
