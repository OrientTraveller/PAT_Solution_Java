package PATFoo;

import java.util.LinkedList;
import java.util.Scanner;

public class _1126 {

	static int[] parent;
	
	static void init(int length) {
		parent = new int[length];
		for(int i = 0 ; i < length ; i++)
			parent[i] = i + 1;
	}
	
	static int find(int key) {
		int copy = key;
		int temp;
		while(parent[key - 1] != key)
			key = parent[key - 1];
		while(copy != key) {
			temp = parent[copy - 1];
			parent[copy - 1] = key;
			copy = temp;
		}
		return key;
	}
	
	static void join(int x, int y) {
		int fx = find(x);
		int fy = find(y);
		if(fx != fy && fx < fy)
			parent[fy - 1] = fx;
		if(fx != fy && fy < fx)
			parent[fx - 1] = fy;
	}
	
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int nodeNum = scaner.nextInt();
		init(nodeNum);
		int edgeNum = scaner.nextInt();
		int[] degree = new int[nodeNum];
		for(int i = 0 ; i < edgeNum ; i++) {
			int temp1 = scaner.nextInt();
			int temp2 = scaner.nextInt();
			join(temp1, temp2);
			degree[temp1 - 1]++;
			degree[temp2 - 1]++;
		}
		scaner.close();
		String result = "";
		int oddNum = 0;
		for(int i : degree) {
			result += i + " ";
			if(i%2 == 1)
				oddNum++;
		}
		System.out.println(result.trim());
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i : parent)
			if(!list.contains(i))
				list.add(i);
		if(list.size() == 1 && oddNum == 0)
			System.out.println("Eulerian");
		else if(list.size() == 1 && oddNum == 2)
			System.out.println("Semi-Eulerian");
		else
			System.out.println("Non-Eulerian");
		

	}

}
