package com.basic.bookish;

public class ReverseIt {

	public static void main(String[] args) {

		LNode f = new LNode(6, null);
		LNode e = new LNode(5, f);
		LNode d = new LNode(4, e);
		LNode c = new LNode(3, d);
		LNode b = new LNode(2, c);
		LNode a = new LNode(1, b);

		LNode head = a;
		display(head);
		// head = reverse(a);
		// System.out.println("after reverse-");
		// display(head);
		// head = reverse(head);
		// head = reverseK(head, 3);
		// head = reverseNow(head, 3);
		// head = reverse(head);
		System.out.println("after K reverse-");
		display(head);
		head = tried(head);
	}

	/**
	 * @param head
	 * @return
	 */
	private static LNode tried(LNode head) {

		LNode cur = head;
		LNode prev = null;
		LNode next = null;

		while (cur.next != null) {

			next = cur.next;

			cur.next = next.next;
			prev = cur;
			cur = next;
		}

		return prev;
	}

	private static LNode reverseK(LNode node, int k) {
		int x = 1;
		LNode head = node;
		LNode current = head;
		while (current != null && current.next != null && x < k) {
			LNode temp = current.next;
			current.next = temp.next;
			temp.next = head;
			head = temp;
			x++;
		}

		return head;
	}

	private static LNode reverseNow(LNode head, int k) {
		LNode current = head;
		LNode prev = null;
		LNode next = null;
		int x = 0;
		while (current != null && x < k) {
			next = current.next; // usual
			current.next = prev;
			prev = current;
			current = next; // usual
			x++;
		}
		if (next != null)
			head.next = reverseNow(next, k);
		return prev;
	}

	private static LNode reverse(LNode node) {
		LNode nxt = null;
		LNode current = node;
		LNode prev = null;
		while (current != null) {// && current.next != null){
			nxt = current.next;

			current.next = prev;

			prev = current;
			current = nxt;
		}
		return prev;
	}

	private static void display(LNode a) {
		while (a != null) {
			System.out.print(a.data + "->");
			a = a.next;
		}
		System.out.println("null");
	}

}

class LNode {
	int data = 0;
	LNode next = null;

	public LNode(int data, LNode node) {
		this.data = data;
		if (node == null)
			this.next = null;
		else
			this.next = node;
	}
}
