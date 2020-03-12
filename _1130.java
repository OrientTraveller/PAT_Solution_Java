package PATFoo;

import java.util.Scanner;

public class _1130 {

	static Node[] tree;
	
	static class Node {
		String key;
		int leftChild;
		int rightChild;
		public Node(String key, int left, int right) {
			this.key = key;
			this.leftChild = left;
			this.rightChild = right;
		}
	}
	
	static String inOrder(Node n) {
		if(n.leftChild == -1 && n.rightChild == -1) 
			return n.key;
	    if(n.leftChild == -1 && n.rightChild != -1)  
	    	return "(" +  n.key + inOrder(tree[n.rightChild]) + ")";
	    if(n.leftChild != -1 && n.rightChild != -1) 
	    	return "(" +  inOrder(tree[n.leftChild]) + n.key + inOrder(tree[n.rightChild]) + ")";
	    else return null;
	}
	
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int num = scaner.nextInt();
		tree = new Node[num + 1];
		boolean[] flag = new boolean[num + 1];
		for(int i = 1 ; i <= num ; i++) {
			String key = scaner.next();
			int left = scaner.nextInt();
			int right = scaner.nextInt();
			if(left != -1) 	flag[left] = true;
			if(right != -1) flag[right] = true;
			tree[i] = new Node(key, left, right);
		}
		scaner.close();
		int root = -1;
		for(int i = 1 ; i <= num ; i++)
			if(flag[i] == false) {
				root = i;
				break;
			}
		String result = inOrder(tree[root]);
		if(result.charAt(0) == '(')
			result = result.substring(1, result.length() - 1);
		System.out.println(result);

	}

}
