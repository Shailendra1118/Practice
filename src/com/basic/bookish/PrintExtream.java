package com.basic.bookish;

public class PrintExtream {

	static int lm = 0, rm = 0, lmax = 0, rmax = 0;
	static Node lnode = null;
	static Node rnode = null;
	public static void main(String[] args) {
		Node c = new Node(8);
		Node f = new Node(22, new Node(14), null);
		Node d = new Node(2, f, null);
		Node a = new Node(25, c, d);
		Node e = new Node(3, new Node(4), new Node(7));
		Node b = new Node(5, new Node(12), e);
		Node root = new Node(10, a, b);
		
		display(root);		
		findExt(root, 0, 0);
		System.out.println("lnode "+lnode.data+" rnode "+rnode.data);
		int h = findHeight(root, 1);
		System.out.println("height "+h);
		printK(root, h, 3);
	}

	private static void printK(Node node, int h, int k) {
		if(node == null)
			return;
		if(h-k == 0)
			System.out.println("post k node: "+node.data);
		if(node.left != null){
			printK(node.left, h-1, k);
		}
		if(node.right != null){
			printK(node.right, h-1, k);
		}
	}

	private static int findHeight(Node node, int h) {
		if(node == null)
			return 0 ;
		int left = findHeight(node.left, h);
		int right = findHeight(node.right, h);
		
		return Math.max(left+1, right+1);
	}

	private static void findExt(Node node, int lm, int rm) {
		if(node == null)
			return;
		if(node.left != null){
			lm++;
			findExt(node.left, lm, rm);
		}
		if(node.right != null){
			rm++;
			findExt(node.right, lm, rm);
		}
		
		if(lm > lmax){
			lmax = lm;
			lnode = node;					
		}
		if(rm > rmax){
			rmax = rm;
			rnode = node;					
		}
			
	}

	private static void display(Node root) {
		if(root == null)
			return;
		System.out.print(root.data+" ");
		display(root.left);
		display(root.right);
		
	}

}
