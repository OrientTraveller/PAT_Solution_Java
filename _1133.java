package PATFoo;

import java.util.LinkedList;
import java.util.Scanner;

public class _1133 {
	
	static class Node {
		int current;
		int key;
		int next;
		public Node(int current, int key, int next) {
			this.current = current;
			this.key = key;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		Node[] list = new Node[100000];
		LinkedList<Node> neg = new LinkedList<Node>();
		LinkedList<Node> bk = new LinkedList<Node>();
		LinkedList<Node> ak = new LinkedList<Node>();
		Scanner scaner = new Scanner(System.in);
		int root = scaner.nextInt();
		int round = scaner.nextInt();
		int k = scaner.nextInt();
		for(int i = 0 ; i < round ; i++) {
			int current = scaner.nextInt();
			int key = scaner.nextInt();
			int next = scaner.nextInt();
			list[current] = new Node(current, key, next);
		}
		scaner.close();
		while(root != -1) {
			Node temp = list[root];
			if(temp.key < 0)
				neg.add(temp);
			else if(temp.key >= 0 && temp.key <= k)
				bk.add(temp);
			else
				ak.add(temp);
			root = temp.next;
		}
		neg.addAll(bk);
		neg.addAll(ak);
		for(int i = 0 ; i < neg.size() ; i++) {
			Node temp = neg.get(i);
			System.out.print(String.format("%05d", temp.current) + " " + temp.key + " ");
			if(i == neg.size() - 1)
				System.out.print("-1");
			else
				System.out.print(String.format("%05d", neg.get(i + 1).current));
		}
	}

}
