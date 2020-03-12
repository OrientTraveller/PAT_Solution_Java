package PATFoo;

import java.util.ArrayList;
import java.util.Scanner;

public class _1102 {
	
	static ArrayList<String> levelOrderResult;
	static String inOrder = "";
	
	static void levelOrder(int[][] tree, int index, int level) {
		if(levelOrderResult.size() < level + 1)
			levelOrderResult.add(String.valueOf(index));
		else {
			String temp = levelOrderResult.get(level);
			temp = index + " " + temp;
			levelOrderResult.set(level, temp);
		}
		for(int i : tree[index]) if(i != -1) levelOrder(tree, i, level + 1);
	}
	
	static int[][] invert(int[][] tree) {
		for(int[] arr : tree) {
			int temp = arr[0];
			arr[0] = arr[1];
			arr[1] = temp;
		}
		return tree;
	}
	
	static void inOrder(int [][] tree, int root) {
		if(tree[root][0] != -1)
			inOrder(tree, tree[root][0]);
		inOrder += root + " ";
		if(tree[root][1] != -1)
			inOrder(tree, tree[root][1]);
	}

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int nodeNum = scaner.nextInt();
		boolean[] flag = new boolean[nodeNum];
		int[][] tree = new int[nodeNum][2];
		for(int i = 0 ; i < nodeNum ; i++) {
			String temp1 = scaner.next();
			String temp2 = scaner.next();
			if(temp1.equals("-")) tree[i][0] = -1;
			else {
				tree[i][0] = Integer.parseInt(temp1);
				flag[Integer.parseInt(temp1)] = true;
			}
			if(temp2.equals("-")) tree[i][1] = -1;
			else {
				tree[i][1] = Integer.parseInt(temp2);
				flag[Integer.parseInt(temp2)] = true;
			}
		}
		scaner.close();
		int root = 0;
		for(int i = 0 ; i < nodeNum ; i++) if(!flag[i]) {root = i; break;}
		levelOrderResult = new ArrayList<String>();
		levelOrder(tree, root, 0);
		for(int i = 0 ; i < levelOrderResult.size() ; i++)
			if(i == levelOrderResult.size() - 1)
				System.out.println(levelOrderResult.get(i));
			else
				System.out.print(levelOrderResult.get(i) + " ");
		tree = invert(tree);
		inOrder(tree, root);
		System.out.println(inOrder.trim());

	}

}
