package PATFoo;

import java.util.Arrays;
import java.util.Scanner;

public class _1138 {
	
	static String result = "";
	
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
	
	static Node init(int[] preOrder, int[] inOrder) {
		if(preOrder.length > 0 && inOrder.length > 0){
			Node root = new Node(preOrder[0]);
			int i;
			for(i = 0 ; i < inOrder.length ; i++) if(inOrder[i] == preOrder[0]) break;
			root.leftChild = init(Arrays.copyOfRange(preOrder, 1, 1+i), Arrays.copyOfRange(inOrder, 0, 0+i));
			root.rightChild = init(Arrays.copyOfRange(preOrder, 1+i, preOrder.length), Arrays.copyOfRange(inOrder, 1+i, inOrder.length));
			return root;
		}
		else
			return null;
	}
	
	static void postOrder(Node n) {
		if(n != null) {
			postOrder(n.leftChild);
			postOrder(n.rightChild);
			result += n.key + " ";
		}
	}

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int num = scaner.nextInt();
		int[] preOrder = new int[num];
		int[] inOrder = new int[num];
		for(int i = 0 ; i < num ; i++)  preOrder[i] = scaner.nextInt();
		for(int i = 0 ; i < num ; i++)  inOrder[i] = scaner.nextInt();
		scaner.close();
		Node root = init(preOrder, inOrder);
		postOrder(root);
		System.out.println(result.split(" ")[0]);
	}

}
