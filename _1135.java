package PATFoo;

import java.util.LinkedList;
import java.util.Scanner;

public class _1135 {
	static int blackNum = -1;
	
	static class Node {
		int color;// 0代表红，1代表黑
		int key;
		Node leftChild;
		Node rightChild;
		public Node(int color, int key) {
			this.color = color;
			this.key = key;
			this.leftChild = null;
			this.rightChild = null;
		}
	}
	
	static Node insert(Node root, int color, int key) {
		if (root == null) 			root = new Node(color, key);
		else if (key < root.key) 	root.leftChild = insert(root.leftChild, color, key);
		else if (key > root.key)	root.rightChild = insert(root.rightChild, color, key);
		return root;
	}
	
	static boolean dfs(Node root, int num) {
		boolean flag = true;
		if(root == null) {
			if(blackNum == -1)			blackNum = num;
			else if(blackNum != num) 	flag = false;
		}
		else {
			if(root.color == 1)              num++;
			if(!dfs(root.leftChild, num))    flag = false;
			if(!dfs(root.rightChild, num))   flag = false;
		}
		return flag;
	}
	
	static boolean bfs(Node root) {
		LinkedList<Node> list = new LinkedList<Node>();
		boolean flag = true;
		if(root.color == 0) flag = false;
		else {
			list.add(root);
			while(list.size() > 0) {
				Node n = list.remove();
				if(n.color == 0)
					if((n.leftChild != null && n.leftChild.color == 0)|| (n.rightChild != null && n.rightChild .color == 0)) {
						flag = false;
						break;
					}
				blackNum = -1;
				if(!dfs(n, 0)) { flag = false; break; }
				if(n.leftChild != null)  list.add(n.leftChild);
				if(n.rightChild != null) list.add(n.rightChild);
			}
		}
		return flag;
	}
	
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int round = scaner.nextInt();
		Node root = null;
		for (int i = 0; i < round; i++) {
			int num = scaner.nextInt();
			root = null;
			int j;
			for (j = 0; j < num; j++) {
				int temp = scaner.nextInt();
				if (temp < 0) 	root = insert(root, 0, Math.abs(temp));
				else			root = insert(root, 1, Math.abs(temp));
			}
			if(bfs(root)) System.out.println("Yes");
			else          System.out.println("No");
		}
		scaner.close();
	}
}
