package PATFoo;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class _1137 {
	
	static class Student {
		String stuNum;
		int programMark;
		int midMark;
		int finalMark;
		int totalMark;
		public Student(String stuNum) {
			this.stuNum = stuNum;
			this.programMark = -1;
			this.midMark = -1;
			this.finalMark = -1;
			this.totalMark = -1;
		}
	}

	public static void main(String[] args) {
		HashMap<String, Integer> mapping = new HashMap<String, Integer>();
		LinkedList<Student> list = new LinkedList<Student>();
		Scanner scaner = new Scanner(System.in);
		int pNum = scaner.nextInt();
		int mNum = scaner.nextInt();
		int fNum = scaner.nextInt();
		for(int i = 0 ; i < pNum ; i++) {
			String stuNum = scaner.next();
			int pMark = scaner.nextInt();
			Student temp = new Student(stuNum);
			temp.programMark = pMark;
			list.add(temp);
			mapping.put(stuNum, i);
		}
		for(int i = 0 ; i < mNum ; i++) {
			String stuNum = scaner.next();
			int mMark = scaner.nextInt();
			if(mapping.containsKey(stuNum)) {
				int index = mapping.get(stuNum);
				Student temp = list.get(index);
				temp.midMark = mMark;
				list.set(index, temp);
			}
			else {
				mapping.put(stuNum, list.size());
				Student temp = new Student(stuNum);
				temp.midMark = mMark;
				list.add(temp);
			}
		}
		for(int i = 0 ; i < fNum ; i++) {
			String stuNum = scaner.next();
			int fMark = scaner.nextInt();
			if(mapping.containsKey(stuNum)) {
				int index = mapping.get(stuNum);
				Student temp = list.get(index);
				temp.finalMark = fMark;
				if(temp.midMark > temp.finalMark)
					temp.totalMark = (int) (Math.round(temp.midMark*0.4 + temp.finalMark*0.6));
				else 
					temp.totalMark = temp.finalMark;
				list.set(index, temp);
			}
			else {
				mapping.put(stuNum, list.size());
				Student temp = new Student(stuNum);
				temp.finalMark = fMark;
				temp.totalMark = fMark;
				list.add(temp);
			}
		}
		scaner.close();
		Collections.sort(list, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				if(o1.totalMark > o2.totalMark)
					return -1;
				else if(o1.totalMark < o2.totalMark)
					return 1;
				else
					return o1.stuNum.compareTo(o2.stuNum);
			}
		});
		for(Student s : list) {
			if(s.programMark >= 200 && s.totalMark >= 60 && s.totalMark <= 100)
				System.out.println(s.stuNum+" "+s.programMark+" "+s.midMark+" "+s.finalMark+" "+s.totalMark);
			if(s.totalMark < 60)
				break;
		}
	}

}
