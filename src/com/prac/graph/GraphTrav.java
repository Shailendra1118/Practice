package com.prac.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class GraphTrav {
	
	int V;
	private LinkedList<GraphNode>[] adj = null;
	
	@SuppressWarnings("unchecked")
	public GraphTrav(int size){
		V = size+1;
		adj = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList<GraphNode>();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner s = new Scanner(new File("D:\\Keppler\\Practice\\src\\com\\prac\\graph\\input.txt"));
		int tc = Integer.parseInt(s.nextLine());
		int n = Integer.parseInt(s.nextLine());
		GraphTrav g = new GraphTrav(n);
		while(s.hasNextLine()){
			String ips = s.nextLine();
			System.out.println(ips);
			String[] ip = ips.split(" ");//s.nextLine().split(" ");
			int v1 = Integer.parseInt(ip[0]);
			int v2 = Integer.parseInt(ip[1]);
			int w = Integer.parseInt(ip[2]);
			g.addEdge(v1, v2, w);
		}
		boolean[] visited = new boolean[n+1];
		g.dfs(1, visited);
		Arrays.fill(visited, false);
		
		s.close();
	}

	private void dfs(int v, boolean visited[]) {
		LinkedList<GraphNode> node = adj[v];
		System.out.println("visiting "+v);
		visited[v] = true;
		Iterator<GraphNode> iter = node.listIterator();
		while(iter.hasNext()){
			GraphNode cur = iter.next();
			if(! visited[cur.data]){
				dfs(cur.data, visited);
			}
		}
		
	}

	private void addEdge(int u, int v, int w) {
		GraphNode node = new GraphNode(v, w);
		adj[u].add(node);
		GraphNode node1 = new GraphNode(u, w);
		adj[v].add(node1);
	}

}

class GraphNode{
	int data;
	int weight;
	//GraphNode next;
	
	public GraphNode(int data, int weight){//, GraphNode next){
		this.data = data;
		this.weight = weight;
		//this.next = next;
	}
}
