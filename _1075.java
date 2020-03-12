package PATFoo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class _1075 {

	static class People {
		String id;
		int[] mark;
		int totalMark;
		int perfect;
		public People(String id) {
			this.id = id;
			mark = new int[5];
			for(int i = 0 ; i < 5 ; i++) {
				mark[i] = -2;
			}
			totalMark = 0;
			perfect = 0;
		}
	}
	
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int peopleNum = scaner.nextInt();
		People[] list = new People[peopleNum + 1];
		for(int i = 1 ; i < peopleNum + 1; i++)
			list[i] = new People(String.format("%05d", i));
		int problemNum = scaner.nextInt();
		int[] fullMarks = new int[problemNum];
		int round = scaner.nextInt();
		for(int i = 0 ; i < problemNum ; i++)
			fullMarks[i] = scaner.nextInt();
		for(int i = 0 ; i < round ; i++) {
			int id = scaner.nextInt();
			int problem = scaner.nextInt();
			int score = scaner.nextInt();
			if(score > list[id].mark[problem - 1])
				list[id].mark[problem - 1] = score;
			if(score == fullMarks[problem - 1])
				list[id].perfect++;
		}
		scaner.close();
		for(int i = 1 ; i < peopleNum + 1; i++) {
			People p = list[i];
			int sum = 0;
			boolean flag = false;
			for(int j = 0 ; j < problemNum ; j++) {
				if(p.mark[j] >= 0) {
					flag = true;
					sum += p.mark[j];
				}
			}
			if(flag)
				p.totalMark = sum;
			else
				p.totalMark = -1;
		}
		ArrayList<People> sort = new ArrayList<People>();
		for(int i = 1 ; i < peopleNum + 1; i++) {
			People p = list[i];
			if(p.totalMark > -1)
				sort.add(p);
		}
		Comparator<People> cmp = new Comparator<People>() {	
			@Override
			public int compare(People o1, People o2) {
				if(o1.totalMark > o2.totalMark)
					return -1;
				else if(o1.totalMark < o2.totalMark)
					return 1;
				else {
					if(o1.perfect > o2.perfect)
						return -1;
					else if(o1.perfect < o2.perfect)
						return 1;
					else
						return o1.id.compareTo(o2.id);
				}
			}
		};
		Collections.sort(sort,cmp);
		int preMark = -1;
		int rank = 1;
		int currentNum = 0;
		for(People p : sort) {
			currentNum++;
			if(preMark == -1) {
				System.out.print(rank+" "+p.id+" "+p.totalMark);
				for(int i = 0 ; i < problemNum ; i++) {
					if(p.mark[i] >= 0)
						System.out.print(" "+p.mark[i]);
					else if(p.mark[i] == -1)
						System.out.print(" 0");
					else
						System.out.print(" -");
				}
				System.out.println();
				preMark = p.totalMark;
			}
			else {
				if(preMark == p.totalMark) {
					System.out.print(rank+" "+p.id+" "+p.totalMark);
					for(int i = 0 ; i < problemNum ; i++) {
						if(p.mark[i] >= 0)
							System.out.print(" "+p.mark[i]);
						else if(p.mark[i] == -1)
							System.out.print(" 0");
						else
							System.out.print(" -");
					}
					System.out.println();
				}
				else {
					rank = currentNum;
					System.out.print(rank+" "+p.id+" "+p.totalMark);
					for(int i = 0 ; i < problemNum ; i++) {
						if(p.mark[i] >= 0)
							System.out.print(" "+p.mark[i]);
						else if(p.mark[i] == -1)
							System.out.print(" 0");
						else
							System.out.print(" -");
					}
					System.out.println();
					preMark = p.totalMark;
				}
			}
		}
	}

}
