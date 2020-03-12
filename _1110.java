package PATFoo;

import java.util.ArrayList;
import java.util.Scanner;

public class _1110 {

	static int level;
	static ArrayList<Integer> lastLevel;
	static boolean flag = true;
	static int[][] tree;
	static int leafNodeNum(int n) { if(n%2 == 0) return n/2; else return (n + 1)/2;}
	static int levelNum(int n) {return (int)(Math.log(n)/Math.log(2));}
	static void run(int index, int levelIndex) {
		if(flag && levelIndex == level - 1) {
			if(flag && tree[index][0] != -1) lastLevel.add(tree[index][0]);
			else flag = false;
			
			if(flag && tree[index][1] != -1) lastLevel.add(tree[index][1]);
			else flag = false;
		}
		else {
			if(tree[index][0] > -1) run(tree[index][0], levelIndex + 1);
			if(tree[index][1] > -1) run(tree[index][1], levelIndex + 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int num = scaner.nextInt();
		int leafNodeNum = leafNodeNum(num);
		level = levelNum(num);
		int lastLevelNodeNum = (int) (num - (Math.pow(2, level) - 1));
		lastLevel = new ArrayList<Integer>();
		tree = new int[num][2];
		boolean[] flag = new boolean[num];
		for(int i = 0 ; i < num ; i++) {
			String temp1 = scaner.next();
			String temp2 = scaner.next();
			if(!temp1.equals("-")) {tree[i][0] = Integer.parseInt(temp1); flag[Integer.parseInt(temp1)] = true;}
			else tree[i][0] = -1;
			
			if(!temp2.equals("-")) {tree[i][1] = Integer.parseInt(temp2); flag[Integer.parseInt(temp2)] = true;}
			else tree[i][1] = -1;
			
			if(temp1.equals("-") && temp2.equals("-")) leafNodeNum--;	
		}
		scaner.close();
		if(num == 1)
			System.out.println("YES 0");
		else {
			int root = 0;
			for(int i = 0 ; i < flag.length ; i++) if(!flag[i]) { root = i; break;}
			if(leafNodeNum > 0) System.out.println("NO " + root);
			else {
				run(root, 0);
				if(lastLevelNodeNum == lastLevel.size()) System.out.println("YES " + lastLevel.get(lastLevel.size() - 1));
				else System.out.println("NO " + root);
			}
		}
	}

}
