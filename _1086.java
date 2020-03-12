package PATFoo;

import java.util.Scanner;
import java.util.Stack;

public class _1086 {

	static String result = "";
	
	static class Node {
		int key;
		Node leftChild;
		Node rightChild;
		public Node() {
			this.key = -1;
			this.leftChild = null;
			this.rightChild = null;
		}
	}
	
	static void postOrder(Node root) {
		if(root.leftChild != null)
			postOrder(root.leftChild);
		if(root.rightChild != null)
			postOrder(root.rightChild);
		result += root.key + " ";
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		Scanner scaner = new Scanner(System.in);
		int round = scaner.nextInt();
		Node[] tree = new Node[round+1];
		for (int i = 0; i < round+1; i++) {
			tree[i] = new Node();
		}
		int pre = -1;
		String preCal = "";
		int root = -1;
		for (int i = 0; i < 2 * round; i++) {
			String cal = scaner.next();
			if(cal.equals("Push")) {
				int temp = scaner.nextInt();
				stack.push(temp);
				tree[temp].key = temp;
				if(pre == -1) {
					root = temp;
				}
				else {
					if(preCal.equals("Push"))
						tree[pre].leftChild = tree[temp];
					else
						tree[pre].rightChild = tree[temp];
				}
				preCal = cal;
				pre = temp;
			}
			else {
				preCal = cal;
				pre = stack.pop();
			}
		}
		scaner.close();
		postOrder(tree[root]);
		System.out.println(result.trim());
	}

}
