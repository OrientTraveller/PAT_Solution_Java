package PATFoo;

import java.util.ArrayList;
import java.util.Scanner;

public class _1094 {

	static ArrayList<Integer> sum;
	
	static void run(ArrayList<Integer>[] family, int index, int level) {
		if(sum.size() < level)
			sum.add(1);
		else {
			int temp = sum.get(level - 1) + 1;
			sum.set(level - 1, temp);
		}
		for(int i : family[index])
			run(family, i, level + 1);
	}
	
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int num = scaner.nextInt();
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] family = new ArrayList[num];
		for(int i = 0 ; i < num ; i++)
			family[i] = new ArrayList<Integer>();
		int round = scaner.nextInt();
		for(int i = 0 ; i < round ; i++) {
			int index = scaner.nextInt() - 1;
			int childNum = scaner.nextInt();
			for(int j = 0 ; j < childNum ; j++)
				family[index].add(scaner.nextInt() - 1);
		}
		scaner.close();
		sum = new ArrayList<Integer>();
		run(family, 0, 1);
		int gen = 0;
		int max = 0;
		for(int i = 0 ; i < sum.size() ; i++)
			if(sum.get(i) > max) {
				max = sum.get(i);
				gen = i + 1;
			}
		System.out.println(max + " " + gen);
	}

}
