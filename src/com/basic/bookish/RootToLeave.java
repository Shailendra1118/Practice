package com.basic.bookish;

import java.util.Iterator;
import java.util.Stack;

public class RootToLeave {

	public static void main(String[] args) {	
		
		Node c = new Node(4);
		Node d = new Node(5, new Node(8), new Node(11));
		Node a = new Node(2, c, d);
		Node e = new Node(6, null, new Node(7));
		Node b = new Node(3, null, e);
		Node root = new Node(1, a, b);
		
		//printTree(root);
		//postOrder(root);
		//pathToLeave(root);
		pathToLeaveRec(root, new int[20], 0);
	}

	private static void pathToLeaveRec(Node root, int arr[], int idx) {
		if(root == null)
			return;
		arr[idx++] = root.data;		
		if(root.left == null && root.right == null){
			printArray(arr, idx);
		}else{
			pathToLeaveRec(root.left, arr, idx);
			pathToLeaveRec(root.right, arr, idx);
		}
	}

	private static void printArray(int[] arr, int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	private static void pathToLeave(Node root) {
		if(root == null)
			return;
		Stack<Node> stk = new Stack<>();
		stk.push(root);
		Node temp = root.left;
		while( !stk.isEmpty()){
			while(temp != null){
				stk.push(temp);
				temp = temp.left;
			}
			Node top = stk.peek();
			if( !top.visited){
				top.visited = true;
				temp = top.right;
				if(temp == null){
					printPath(stk);
					stk.pop();
				}
			}else
				stk.pop();
		}
	}

	private static void printPath(Stack<Node> stk) {
		Iterator<Node> iter = stk.iterator();
		while(iter.hasNext())
			System.out.print(iter.next().data+" ");
		System.out.println();
	}

	private static void postOrder(Node root) {
		
	}

	private static void printTree(Node root) {
		
		if(root != null)
			System.out.print(root.data+" ");
		if(root.left != null)
			printTree(root.left);
		if(root.right != null)
			printTree(root.right);
				
	}

}

class Node{
	int data;
	Node left;
	Node right;
	boolean visited;
	
	Node(int data, Node left, Node right){
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}