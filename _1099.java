package PATFoo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class _1099 {
	
	static Node[] tree;
	static ArrayList<String> result;

	static class Node {
		int key;
		int leftChildNum;
		int rightChildNum;
		int leftChild;
		int rightChild;
		public Node (int leftChild, int rightChild) {
			this.key = 0;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
			this.leftChildNum = 0;
			this.rightChildNum = 0;
		}
	}
	
	static int check(int index) {
		int leftChildNum = 0;
		int rightChildNum = 0;
		if(tree[index].leftChild != -1) {
			leftChildNum++;
			leftChildNum += check(tree[index].leftChild);
		}
		if(tree[index].rightChild != -1) {
			rightChildNum++;
			rightChildNum += check(tree[index].rightChild);
		}
		tree[index].leftChildNum = leftChildNum;
		tree[index].rightChildNum = rightChildNum;
		return leftChildNum + rightChildNum;
	}
	
	static void insert(int[] numbers, int start, int end, int index) {
		int left = tree[index].leftChildNum;
		tree[index].key = numbers[start + left];
		if(tree[index].leftChild != -1)
			insert(numbers, start, start + left - 1, tree[index].leftChild);
		if(tree[index].rightChild != -1)
			insert(numbers, start + left + 1, end, tree[index].rightChild);
	}
	
	static void level(int root, int level) {
		if(result.size() == level)
			result.add(String.valueOf(tree[root].key) + " ");
		else {
			String temp = result.get(level);
			temp += tree[root].key + " ";
			result.set(level, temp);
		}
		if(tree[root].leftChild != -1)
			level(tree[root].leftChild, level + 1);
		if(tree[root].rightChild != -1)
			level(tree[root].rightChild, level + 1);
	}
	
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int num = scaner.nextInt();
		tree = new Node[num];
		int[] numbers = new int[num];
		for(int i = 0 ; i < num ; i++)
			tree[i] = new Node(scaner.nextInt(), scaner.nextInt());
		for(int i = 0 ; i < num ; i++)
			numbers[i] = scaner.nextInt();
		scaner.close();
		result = new ArrayList<String>();
		Arrays.sort(numbers);
		check(0);
		insert(numbers, 0, num - 1, 0);
		level(0, 0);
		for(int i = 0 ; i < result.size() ; i++) {
			System.out.print(result.get(i).trim());
			if(i != result.size() - 1)
				System.out.print(" ");
		}
	}

}
