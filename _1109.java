package PATFoo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class _1109 {

	static class People {
		String name;
		int height;
		public People(String name, int height) {
			this.name = name;
			this.height = height;
		}
	}
	
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int n = scaner.nextInt(); int k = scaner.nextInt(); int lineNum = n/k;
		People[] list = new People[n];
		for(int i = 0 ; i < n ; i++) list[i] = new People(scaner.next(), scaner.nextInt());
		scaner.close();
		Comparator<People> cmp = new Comparator<People>() {
			@Override
			public int compare(People o1, People o2) {
				if(o1.height > o2.height)
					return 1;
				else if(o1.height < o2.height)
					return -1;
				else
					return -o1.name.compareTo(o2.name);
			}
		};
		Arrays.sort(list, cmp);
		for(int i = lineNum - 1 ; i >= 0  ; i--) {
			String rank = "";
			if(i != lineNum - 1) {
				rank += list[(i+1)*k - 1].name + " ";
				for(int j = 0 ; j < k - 1 ; j++) {
					if(j%2 == 0)
						rank = list[(i+1)*k - 2 - j].name + " " +  rank;
					else
						rank = rank + list[(i+1)*k - 2 - j].name + " ";
				}
			}
			else {
				rank += list[n - 1].name + " ";
				for(int j = 0 ; j < n%k + k - 1 ; j++) {
					if(j%2 == 0)
						rank = list[n - 2 - j].name + " " + rank;
					else
						rank = rank + list[n - 2 - j].name + " ";
				}
			}
			System.out.println(rank.trim());
		}
	}

}
