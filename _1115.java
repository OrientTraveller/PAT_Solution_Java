package PATFoo;

import java.util.LinkedList;
import java.util.Scanner;

public class _1115 {
	
	static class BST {
		LinkedList<Integer> level;
		class Node {
			int key;
			Node leftChild;
			Node rightChild;
			public Node(int key) {
				this.key = key;
				this.leftChild = null;
				this.rightChild = null;
			}
		}
		Node root;
		public BST() {
			this.root = null;
		}
		public void add(int key) {root = add(key, root);}
		private Node add(int key, Node r) {
			if(r == null)
				r = new Node(key);
			else
				if(r.key >= key)
					r.leftChild = add(key, r.leftChild);
				else
					r.rightChild = add(key, r.rightChild);
			return r;
		}
		public void levelOrder() {
			level = new LinkedList<Integer>();
			levelOrder(root, 0);
			if(level.size() >= 2)
				System.out.println(level.getLast() + " + " + level.get(level.size() - 2) + " = " + (level.getLast()+level.get(level.size() - 2)));
			else
				System.out.println(level.getLast() + " + 0 = " + level.getLast());
		}
		private void levelOrder(Node r, int levelNum) {
			if(level.size() < levelNum + 1) level.add(1);
			else level.set(levelNum, level.get(levelNum) + 1);
			if(r.leftChild != null) levelOrder(r.leftChild, levelNum + 1);
			if(r.rightChild != null) levelOrder(r.rightChild, levelNum + 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int round = scaner.nextInt();
		BST tree = new BST();
		for(int i = 0 ; i < round ; i++)
			tree.add(scaner.nextInt());
		scaner.close();
		tree.levelOrder();

	}

}
