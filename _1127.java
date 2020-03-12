package PATFoo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class _1127 {

	static LinkedList<String> list;
	
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
	
	static Node init(int[] inOrder, int[] postOrder) {
		if(inOrder.length == 0) return null;
		else {
			int key = postOrder[postOrder.length - 1];
			int index = 0;
			for(int i = 0 ; i < inOrder.length ; i++)
				if(inOrder[i] == key)
					index = i;
			Node n = new Node(key);
			n.leftChild = init(Arrays.copyOfRange(inOrder, 0, index), Arrays.copyOfRange(postOrder, 0, index));
			n.rightChild = init(Arrays.copyOfRange(inOrder, index + 1, inOrder.length), Arrays.copyOfRange(postOrder, index, postOrder.length - 1));
			return n;
		}
	}
	
	static void levelOrder(Node n, int level) {
		if(n != null) {
			if(list.size() < level + 1)
				list.add(n.key + " ");
			else if(list.size() >= level + 1 && level%2 == 0)
				list.set(level, n.key + " " + list.get(level));
			else if(list.size() >= level + 1 && level%2 != 0)
				list.set(level, list.get(level) + n.key + " ");
			levelOrder(n.leftChild, level + 1);
			levelOrder(n.rightChild, level + 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int num = scaner.nextInt();
		int[] inOrder = new int[num];
		int[] postOrder = new int[num];
		for(int i = 0 ; i < num ; i++)
			inOrder[i] = scaner.nextInt();
		for(int i = 0 ; i < num ; i++)
			postOrder[i] = scaner.nextInt();
		scaner.close();
		Node root = init(inOrder, postOrder);
		list = new LinkedList<String>();
		levelOrder(root, 0);
		String result = "";
		for(int i = 0 ; i < list.size() ; i++)
			result += list.get(i);
		System.out.println(result.trim());
	}

}
