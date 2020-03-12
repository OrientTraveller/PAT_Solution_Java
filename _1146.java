package PATFoo;

import java.util.LinkedList;
import java.util.Scanner;

public class _1146 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int nodeNum = scaner.nextInt();
		int edgeNum = scaner.nextInt();
		@SuppressWarnings("unchecked")
		LinkedList<Integer>[] pre = new LinkedList[nodeNum+1];
		for(int i = 1 ; i < nodeNum + 1 ; i++)
			pre[i] = new LinkedList<Integer>();
		for (int i = 0; i < edgeNum; i++) {
			int start = scaner.nextInt();
			int end = scaner.nextInt();
			pre[end].add(start);
		}
		int round = scaner.nextInt();
		System.out.println(round);
		String result = "";
		LinkedList<Integer> seq = new LinkedList<Integer>();
		for (int i = 0; i < round; i++) {
			seq.clear();
			boolean flag = true;
			for(int j = 0 ; j < nodeNum ; j++) {
				int current = scaner.nextInt();
				if(flag && !seq.containsAll(pre[current])) {
					result += i + " ";
					flag = false;
				}
				seq.add(current);
			}
		}
		scaner.close();
		System.out.println(result.trim());
	}
}
