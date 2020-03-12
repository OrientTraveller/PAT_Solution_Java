package PATFoo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 二叉搜索树的中序满足：是一组序列的从小到大排列
 * @author SunFeiran
 *
 */

public class _1064 {

	static ArrayList<String> al;
	
	static int cal(int size) {
		int sum = 0;
		int e = 0;
		for(int i = 0 ; i < Math.pow(2, size) ; i++) {
			sum += Math.pow(2, i);
			if(sum > size) {
				sum -= Math.pow(2, i);
				e = i - 1;
				break;
			}
		}
		if(size - sum > Math.pow(2, e + 1)/2)
			return (int) (sum + Math.pow(2, e + 1)/2 - 1 - (sum - 1)/2);
		else
			return size - 1 - (sum - 1)/2;
	}
	
	static void buildTree(int[] node, int level) {
		int length = node.length;
		int rootIndex = cal(length);
		int root = node[rootIndex];
		if(al.size() - 1 < level) {
			String temp = String.valueOf(root);
			al.add(temp);
		}
		else {
			String temp = al.get(level) + " " + String.valueOf(root);
			al.set(level, temp);
		}
		if(length == 1);
		else {
			int[] left = Arrays.copyOfRange(node, 0, rootIndex);
			if(left.length > 0)
				buildTree(left, level+1);
			int[] right = Arrays.copyOfRange(node, rootIndex+1, length);
			if(right.length > 0)
				buildTree(right, level+1);
		}
	}
	
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int num = scaner.nextInt();
		int[] node = new int[num];
		for(int i = 0 ; i < num ; i++) {
			node[i] = scaner.nextInt();
		}
		Arrays.sort(node);
		al = new ArrayList<String>();
		buildTree(node, 0);
		String result = "";
		for(String s : al)
			result = result + s + " ";
		System.out.println(result.trim());
		scaner.close();
	}

}
