package PATFoo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class _1080 {

	static class Student {
		int id;
		int GE;
		int GI;
		float finalMark;
		ArrayList<Integer> perferredSchool;
		public Student(int id , int GE , int GI , float finalMark) {
			this.id = id;
			this.GE = GE;
			this.GI = GI;
			this.finalMark = finalMark;
			this.perferredSchool = new ArrayList<Integer>();
		}
	}
	
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int round = scaner.nextInt();
		Student[] rank = new Student[round];
		int schoolNum = scaner.nextInt();
		int PSNum = scaner.nextInt();
		int[] quota = new int[schoolNum];
		for(int i = 0 ; i < schoolNum ; i++)
			quota[i] = scaner.nextInt();
		for(int i = 0 ; i < round ; i++) {
			int ge = scaner.nextInt();
			int gi = scaner.nextInt();
			float finalMark = (float)(ge+gi)/2;
			rank[i] = new Student(i, ge, gi, finalMark);
			for(int j = 0 ; j < PSNum ; j++)
				rank[i].perferredSchool.add(scaner.nextInt());
		}
		scaner.close();
		Comparator<Student> cmp = new Comparator<Student>() {
			
			@Override
			public int compare(Student o1, Student o2) {
				if(o1.finalMark > o2.finalMark)
					return -1;
				else if(o1.finalMark < o2.finalMark)
					return 1;
				else {
					if(o1.GE > o2.GE)
						return -1;
					else if(o1.GE < o2.GE)
						return 1;
					else
						return 0;
				}
			}
		};
		Arrays.sort(rank, cmp);
		@SuppressWarnings("unchecked")
		ArrayList<Student>[] admit = new ArrayList[schoolNum];
		for(int i = 0 ; i < schoolNum ; i++)
			admit[i] = new ArrayList<Student>();
		for(Student s : rank) {
			for(int i : s.perferredSchool) {
				if(admit[i].size() < quota[i]) {
					admit[i].add(s);
					break;
				}
				else {
					if(s.finalMark == admit[i].get(admit[i].size() - 1).finalMark && s.GE == admit[i].get(admit[i].size() - 1).GE) {
						admit[i].add(s);
						break;
					}
				}
			}
		}
		Comparator<Student> newcmp = new Comparator<Student>() {
			
			@Override
			public int compare(Student o1, Student o2) {
				if(o1.id < o2.id)
					return -1;
				else
					return 1;
			}
		};
		for(ArrayList<Student> al : admit) {
			Collections.sort(al, newcmp);
			String result = "";
			for(Student s : al)
				result += s.id + " ";
			System.out.println(result.trim());
			
		}
	}

}
