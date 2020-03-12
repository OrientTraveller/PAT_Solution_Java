package PATFoo;

import java.util.LinkedList;
import java.util.Scanner;

public class _1123 {

	static int round;

	static class AVLTree {
		Node root;

		public AVLTree() {
			this.root = null;
		}

		public void insert(int key) {
			this.root = insert(key, this.root);
		}

		// 层序遍历顺便判断完全二叉树
		public void level() {
			LinkedList<Node> list = new LinkedList<Node>();
			list.add(root);
			String result = "";
			boolean isLeaf = false;
			boolean flag = true;
			while (list.size() > 0) {
				Node temp = list.remove();
				result = result + temp.key + " ";
				// 层序遍历
				if (temp.leftChild != null)
					list.add(temp.leftChild);
				if (temp.rightChild != null)
					list.add(temp.rightChild);
				// 判断完全二叉树
				if (isLeaf && (temp.leftChild != null || temp.rightChild != null))  //语句块A
					flag = false;													//语句块A
				if (temp.leftChild == null && temp.rightChild != null)
					flag = false;
				if (temp.rightChild == null)//一定要放在语句块A后面
					isLeaf = true;
			}
			System.out.println(result.trim());
			if (flag)
				System.out.println("YES");
			else
				System.out.println("NO");
		}

		private Node insert(int key, Node n) {
			if (n == null)
				n = new Node(key);
			else if (key > n.key)
				n.rightChild = insert(key, n.rightChild);
			else
				n.leftChild = insert(key, n.leftChild);
			n = adjust(n);
			return n;
		}

		private Node adjust(Node n) {
			if (n.leftChild != null && getBalanceFactor(n) > 1 && getBalanceFactor(n.leftChild) > 0) { // LL
				n = R(n);
			}
			if (n.leftChild != null && getBalanceFactor(n) > 1 && getBalanceFactor(n.leftChild) < 0) { // LR
				n.leftChild = L(n.leftChild);
				n = R(n);
			}
			if (n.rightChild != null && getBalanceFactor(n) < -1 && getBalanceFactor(n.rightChild) > 0) { // RL
				n.rightChild = R(n.rightChild);
				n = L(n);
			}
			if (n.rightChild != null && getBalanceFactor(n) < -1 && getBalanceFactor(n.rightChild) < 0) { // RR
				n = L(n);
			}
			return n;
		}

		private int getBalanceFactor(Node n) {
			int result = 0;
			if (n.leftChild != null && n.rightChild != null)
				result = getHeight(n.leftChild) - getHeight(n.rightChild);
			if (n.leftChild != null && n.rightChild == null)
				result = getHeight(n.leftChild);
			if (n.leftChild == null && n.rightChild != null)
				result = 0 - getHeight(n.rightChild);
			return result;
		}

		private Node L(Node n) {
			Node temp = n.rightChild;
			n.rightChild = temp.leftChild;
			temp.leftChild = n;
			return temp;
		}

		private Node R(Node n) {
			Node temp = n.leftChild;
			n.leftChild = temp.rightChild;
			temp.rightChild = n;
			return temp;
		}

		private int getHeight(Node n) {
			if (n == null)
				return 0;
			int leftChildHeight = getHeight(n.leftChild);
			int rightChildHeight = getHeight(n.rightChild);
			return Math.max(leftChildHeight, rightChildHeight) + 1;
		}

		static class Node {
			int key;
			Node leftChild;
			Node rightChild;

			public Node(int key) {
				this.key = key;
				this.leftChild = null;
				this.rightChild = null;
			}
		}
	}

	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		Scanner scaner = new Scanner(System.in);
		round = scaner.nextInt();
		for (int i = 0; i < round; i++)
			tree.insert(scaner.nextInt());
		scaner.close();
		tree.level();
	}

}
