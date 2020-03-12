package PATFoo;

import java.util.Arrays;
import java.util.Scanner;

public class _1119 {
	
	static boolean flag = true;
	static int[] pre;
	static int[] post;
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
	
	static Node insert(int preL, int preR, int postL, int postR) {
		int[] temp1 = Arrays.copyOfRange(pre, preL + 1, preR);
		int[] temp2 = Arrays.copyOfRange(post, postL, postR - 1);
		int key = pre[preL];
		Node n = new Node(key);
        if(temp1.length >= 1) {
			int index = 0;
			while(index < temp1.length) {
				int[] temp3 = Arrays.copyOfRange(temp1, 0, index + 1);
				int[] temp4 = Arrays.copyOfRange(temp2, 0, index + 1);
				Arrays.sort(temp3);
				Arrays.sort(temp4);
				if(Arrays.equals(temp3, temp4)) break;
				else 							index++;
			}
			n.leftChild = insert(preL + 1, preL + 2 + index, postL, postL + 1 + index);
			if(index + 1 == temp1.length) flag = false; 	
			else n.rightChild = insert(preL + 2 + index, preR, postL + 1 + index, postR - 1);
		}
		return n;
	}
	
	static void level(Node n) {
		if(n.leftChild != null)
			level(n.leftChild);
		result += n.key + " ";
		if(n.rightChild != null)
			level(n.rightChild);
	}

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int round = scaner.nextInt();
		pre = new int[round];
		post = new int[round];
		for(int i = 0 ; i < round ; i++)
			pre[i] = scaner.nextInt();
		for(int i = 0 ; i < round ; i++)
			post[i] = scaner.nextInt();
		scaner.close();
		Node root = insert(0, round, 0, round);
		if(flag)
			System.out.println("Yes");
		else
			System.out.println("No");
		level(root);
		System.out.println(result.trim());
		
	}

}
