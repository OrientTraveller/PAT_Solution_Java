package PATFoo;

import java.util.ArrayList;
import java.util.Scanner;

public class _1106 {
	
	static float minPrice = Float.MAX_VALUE;
	static int retailersNum = 0;
	static float price;
	static float per;
	
	static void cal(ArrayList<Integer>[] tree, int root, int level) {
		if(tree[root].size() == 0) {
			float tempPrice = (float) (price * Math.pow(1.0 + per/100, level));
			if(tempPrice < minPrice) {
				minPrice = tempPrice;
				retailersNum = 1;
			}
			else if(tempPrice == minPrice) retailersNum++;
		}
		else {
			for(int i : tree[root])
				cal(tree, i, level + 1);
		}
	}

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int num = scaner.nextInt();
		price = scaner.nextFloat();
		per = scaner.nextFloat();
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] tree = new ArrayList[num];
		for(int i = 0 ; i < num ; i++) {
			tree[i] = new ArrayList<Integer>();
			int temp = scaner.nextInt();
			for(int j = 0 ; j < temp ; j++)
				tree[i].add(scaner.nextInt());
		}
		scaner.close();
		cal(tree, 0, 0);
		System.out.println(String.format("%.4f", minPrice) + " " + retailersNum);

	}

}
