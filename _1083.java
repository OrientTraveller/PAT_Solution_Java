package PATFoo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class _1083 {

	static class Student {
		String name;
		String id;
		int mark;
		public Student(String name , String id , int mark) {
			this.name = name;
			this.id = id;
			this.mark = mark;
		}
	}
	
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int round = scaner.nextInt();
		Student[] rank = new Student[round];
		for(int i = 0 ; i < round ; i++) {
			String name = scaner.next();
			String id = scaner.next();
			int mark = scaner.nextInt();
			rank[i] = new Student(name, id, mark);
		}
		int low = scaner.nextInt();
		int high = scaner.nextInt();
		scaner.close();
		Comparator<Student> cmp = new Comparator<Student>() {
			
			@Override
			public int compare(Student o1, Student o2) {
				if(o1.mark > o2.mark)
					return -1;
				else
					return 1;
			}
		}; 
		Arrays.sort(rank,cmp);
		boolean flag = true;
		for(Student s : rank) {
			if(s.mark < low)
				break;
			else {
				if(s.mark<=high) {
					flag = false;
					System.out.println(s.name+" "+s.id);
				}
			}
		}
		if(flag)
			System.out.println("NONE");
		
	}

}
