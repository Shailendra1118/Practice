package com.prac.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BFS {

	public static void main(String[] args) {
		Graph g = new Graph();
		populateGraph(g);
		System.out.println("Size of the graph list: "+g.arr.size());
		g.display();
		//System.out.println(g.isEdge(new GNode(5), new GNode(8)));
		//bfsTrav(g);
		dfsTrav(g, g.arr.get(0));
		
	}

	private static void dfsTrav(Graph g, GNode node) {
		//GNode node = g.arr.get(0);
		System.out.println(node.data);
		node.visited = true;
		if(node.next == null)
			return;
		while(node.next != null){
			node = node.next;
			//System.out.println(node.data);
			GNode n1 = g.arr.get(node.data-1);
			System.out.println("n1: "+n1.data);
			if(n1.visited)
				break;
			dfsTrav(g, n1);
		}
	}

	private static void bfsTrav(Graph g) {
		List<GNode> arr = g.arr;
		LinkedList<GNode> que = new LinkedList<>();
		que.add(arr.get(0));
		int size = arr.size();
		while( !que.isEmpty() && size>0){
			GNode n = que.poll();
			GNode ni = arr.get(n.data-1);
			System.out.println("traverse: "+ni.data);
			while(ni.next != null){
				ni = ni.next;
				if( !isExist(que, ni)) // supposed to use visited flag here ??
					que.offer(ni);
			}
			size--;
		}
		
	}

	private static boolean isExist(List<GNode> list, GNode ni) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).equals(ni))
				return true;
		}
		return false;
	}

	private static void populateGraph(Graph g) {
		if(g.arr == null){
			g.arr = new ArrayList<GNode>();
		}else
			g.arr.clear();
		
		GNode n3 = new GNode(3);
		GNode n2 = new GNode(2, n3);
		GNode i1 = new GNode(1, n2);
		g.arr.add(i1);
		
		GNode n5 = new GNode(5);
		GNode n4 = new GNode(4, n5);
		GNode i2 = new GNode(2, n4);
		g.arr.add(i2);
		
		GNode i3 = new GNode(3, new GNode(5));
		g.arr.add(i3);
		
		g.arr.add(new GNode(4));
		
		GNode n6 = new GNode(6);
		GNode n7 = new GNode(7, n6);		
		GNode n8 = new GNode(8, n7);
		GNode i5 = new GNode(5, n8);
		g.arr.add(i5);
		
		g.arr.add(new GNode(6));
		g.arr.add(new GNode(7));
		
		GNode n9 = new GNode(9);
		GNode i8 = new GNode(8, n9);
		g.arr.add(i8);
		g.arr.add(n9);
		
	}

}



class GNode{
	public GNode(int i) {
		this.data = i;
		this.next = null;
		this.visited = false;
	}
	public GNode(int i, GNode n) {
		this.data = i;
		this.next = n;
		this.visited = false;
	}
	int data;
	GNode next;
	boolean visited;
	
	public boolean equals(GNode obj){
		if(obj == null || this == null)
			return false;
		else{
			if(obj.getClass().equals(this.getClass())){
				return obj.data == this.data;
			}
			else 
				return false;
		}
			
	}
	
	public String toString(){
		return String.valueOf(this.data);		
	}
	
}

class Graph{
	List<GNode> arr = null;	
	
	public void display(){
		for (int i = 0; i < arr.size(); i++) {
			GNode node = arr.get(i);
			System.out.print(node.data+":");
			while(node.next != null){
				node = node.next; // WTF missing
				System.out.print(node.data+"->");
				
			}
			System.out.println("null");
			//System.out.println();
		}
	}
	
	public boolean isEdge(GNode a, GNode b){
		//find vertex index
		GNode node = this.arr.get(a.data-1);
		System.out.println("first Node: "+node.data);
		while(node.next != null){
			node = node.next;
			if(node.data == b.data){
				return true;
			}
		}
		return false;
	}
	
}
