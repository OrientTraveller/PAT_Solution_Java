package PATFoo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class _1053 {
	
	static String[] weight;
	static ArrayList<Integer>[] tree;
	static int sum;
	static ArrayList<String> result = new ArrayList<>();
	
	static void dfs() {
		DFS(0,"",0);
	}
	
	static void DFS(int start ,String path,int total) {
		if(total >  sum);
		else {
			ArrayList<Integer> current = tree[start];
			path += String.valueOf(weight[start]) + " ";
			total += Integer.parseInt(weight[start]);
			if(current == null) {
				if(total == sum)
					result.add(path.trim());
			}
			else {
				for(int i = 0 ; i < current.size() ; i++) {
					DFS(current.get(i),path,total);
				}
			}
		}
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int totalNodeNum = scaner.nextInt();
		int nonLeafNodeNum = scaner.nextInt();
		sum = scaner.nextInt();
		scaner.nextLine();
		tree = new ArrayList[totalNodeNum];
		weight = scaner.nextLine().split(" ");
		for(int i = 0 ; i < nonLeafNodeNum ; i++) {
			int index = scaner.nextInt();
			int num = scaner.nextInt();
			ArrayList<Integer> temp = tree[index] = new ArrayList<>();
			for(int j = 0 ; j < num ; j++) {
				temp.add(scaner.nextInt());
			}
		}
		scaner.close();
		dfs();
		Comparator<String> cmp = new newcmp();
		Collections.sort(result,cmp);
		for(String s : result)
			System.out.println(s);		
	}
}

class newcmp implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		String[] temp1 = o1.split(" ");
		String[] temp2 = o2.split(" ");
		int edge = Math.min(temp1.length, temp2.length);
		for(int i = 1 ; i < edge ; i++) {
			if(temp1[i].equals(temp2[i]));
			else {
				int int1 = Integer.parseInt(temp1[i]);
				int int2 = Integer.parseInt(temp2[i]);
				if(int1 > int2) {
					return -1;
				}
				else
					return 1;
			}
		}
		return 0;
	}
}
