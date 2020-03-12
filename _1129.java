package PATFoo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class _1129 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int round = scaner.nextInt();
		int num = scaner.nextInt();
		@SuppressWarnings("unchecked")
		LinkedList<Integer>[] record = new LinkedList[round + 1];
		for(int i = 0 ; i < round + 1 ; i++)
			record[i] = new LinkedList<Integer>();
		int[] rank = new int[round + 1];
		int temp = scaner.nextInt();
		rank[temp]++;
		record[1].add(temp);
		for(int i = 1 ; i < round ; i++) {
			temp = scaner.nextInt();
			String result = "";
			int current = 0;
			while(current < num) {
				int j;
				for(j = i + 1 ; j >= 1 ; j--) {
					Collections.sort(record[j]);
					for(int k : record[j]) {
						result += k + " ";
						current++;
						if(current == num)
							break;
					}
					if(current == num || j == 1)
						break;
				}
				if(current == num || j == 1)
					break;
			}
			System.out.println(temp + ": " + result.trim());
			rank[temp]++;
			if(rank[temp] > 1)
				record[rank[temp] - 1].remove((Object)temp);
			record[rank[temp]].add(temp);
		}
		scaner.close();
	}

}
