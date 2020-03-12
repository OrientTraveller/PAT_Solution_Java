package PATFoo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _1039 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int studentNum = scaner.nextInt();
		int courseNum = scaner.nextInt();
		scaner.nextLine();
		ArrayList<String>[] courseList = new ArrayList[courseNum];
		ArrayList<Integer>[] stuList = new ArrayList[studentNum];
		for(int i = 0 ; i < courseNum ; i++) {
			int index = scaner.nextInt() - 1;
			int courseStuNum = scaner.nextInt();
			courseList[index] = new ArrayList<String>();
			scaner.nextLine();
			for(int j = 0 ; j < courseStuNum ; j++) {
				courseList[index].add(scaner.next());
			}
			scaner.nextLine();
		}
		String[] stuCheckList = scaner.nextLine().split(" ");
		scaner.close();
		for(int i = 0 ; i < stuCheckList.length ; i++) {
			stuList[i] = new ArrayList<Integer>();
			for(int j = 0 ; j < courseList.length ; j++) {
				if(courseList[j].contains(stuCheckList[i]))
					stuList[i].add(j + 1);
			}
		}
		for(int i = 0 ; i < stuCheckList.length ; i++) {
			System.out.print(stuCheckList[i] + " ");
			System.out.print(stuList[i].size());
			Collections.sort(stuList[i]);
			for(int index : stuList[i]) {
				System.out.print(" " + index);
			}
			System.out.println();
		}
	}

}
