package PATFoo;

import java.util.ArrayList;
import java.util.Scanner;

public class _1090 {
	
	static ArrayList<String> levelAL = new ArrayList<String>();;
	
	static void run(ArrayList<Integer>[] tree , int index , int level) {
		if(levelAL.size()<level + 1)
			levelAL.add(String.valueOf(index) + " ");
		else {
			String temp = levelAL.get(level);
			temp += index + " ";
			levelAL.set(level, temp);
		}
		if(tree[index].size() > 0)
			for(int i : tree[index])
				run(tree, i, level + 1);
		
	}

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int num = scaner.nextInt();
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] tree = new ArrayList[num]; 
		for(int i = 0 ; i < num ; i++)
			tree[i] = new ArrayList<Integer>();
		float price = scaner.nextFloat();
		float per = scaner.nextFloat();
		int root = 0;
		for(int i = 0 ; i < num ; i++) {
			int temp = scaner.nextInt();
			if(temp == -1)
				root = i;
			else
				tree[temp].add(i);;
		}
		scaner.close();
		run(tree, root, 0);
		int e = levelAL.size() - 1;
		int retailNum = levelAL.get(levelAL.size() - 1).trim().split(" ").length;
		float highest = (float) (price * Math.pow((float)(1 + per/100), e));
		System.out.println(String.format("%.2f", highest)+" "+retailNum);
	}

}
