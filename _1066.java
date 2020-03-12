package PATFoo;

import java.util.ArrayList;
import java.util.Scanner;

public class _1066 {
	
	static ArrayList<String> al = new ArrayList<>();
	
	static class Node{
		private int key;
		private Node leftChild;
		private Node rightChild;
		public Node(int key) {
			this.key = key;
			this.leftChild = null;
			this.rightChild = null;
		}	
	}

	static class AVLTree{
		Node root;
		public AVLTree() {
			root = null;
		}
		
		//必备函数
		public void insert(int i) {
			this.root = _insert(this.root, i);
		}
		
		//必备函数
		public Node rebalance(Node root) {
			int factor = getBalanceFactor(root);
		    if(factor > 1 && getBalanceFactor(root.leftChild) > 0) // LL
		        root = R(root);
		    else if(factor > 1 && getBalanceFactor(root.leftChild) <= 0) { //LR
		    	root.leftChild = L(root.leftChild);
				root = R(root);
		    } 
		    else if(factor < -1 && getBalanceFactor(root.rightChild) <= 0) // RR
		    	root = L(root);
		    else if(factor < -1 && getBalanceFactor(root.rightChild) > 0) { // RL
		    	root.rightChild = R(root.rightChild);
				root = L(root);
		    } 
		    else;// 除以上情形外啥也不做
		    return root;
		}
		
		public void level(Node root ,int level) {
			Node temp = root;
			if(al.size() - 1 < level) {
				String temp1 = String.valueOf(temp.key);
				al.add(temp1);
			}
			else {
				String temp1 = al.get(level) + " " + String.valueOf(temp.key);
				al.set(level, temp1);
			}
			if(root.leftChild != null)
				level(root.leftChild,level+1);
			if(root.rightChild != null)
				level(root.rightChild,level+1);
		}

		//必备函数
		private Node R(Node root) {
			Node temp = root.leftChild;
			root.leftChild = temp.rightChild;
			temp.rightChild=root;
			root = temp;	
			return root;
		}
		
		//必备函数
		private Node L(Node root) {
			Node temp = root.rightChild;
			root.rightChild = temp.leftChild;
			temp.leftChild = root;
			root = temp;
			return root;
		}
		
		//必备函数
		private Node _insert(Node root , int i) {
			if(root == null)
				root = new Node(i);
			else {
				if(i > root.key) 
					root.rightChild = _insert(root.rightChild,i);
				else if(i < root.key)
					root.leftChild = _insert(root.leftChild,i);    
				else;
			}
			root = rebalance(root);
			return root;
		}
		
		//必备函数
		private int getBalanceFactor(Node n) {
			if(n.leftChild != null && n.rightChild != null)
				return getHeight(n.leftChild) - getHeight(n.rightChild);
			else if(n.leftChild != null && n.rightChild == null)
				return getHeight(n.leftChild);
			else if(n.leftChild == null && n.rightChild != null)
				return 0 - getHeight(n.rightChild);
			else
				return 0;
		}
		
		//必备函数
		private int getHeight(Node n) {
			return height(n,1);
		}
		
		//必备函数
		private int height(Node n, int level) {
			if (n.leftChild == null && n.rightChild == null)
				return level;
			else if (n.leftChild != null && n.rightChild != null)
				return Math.max(height(n.leftChild, level + 1), height(n.rightChild, level + 1));
			else if (n.leftChild != null)
				return height(n.leftChild, level + 1);
			else
				return height(n.rightChild, level + 1);

		}
		
	}
	
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int round = scaner.nextInt();
		AVLTree avlTree = new AVLTree();
		for(int i = 0 ; i< round ; i++) {
			avlTree.insert(scaner.nextInt());
		}
		scaner.close();
		avlTree.level(avlTree.root, 0);
		for(String s :al)
			System.out.println(s);
		System.out.println(avlTree.root.key);
	}

}
