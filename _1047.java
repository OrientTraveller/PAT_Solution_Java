package PATFoo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _1047 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int stuNum = scaner.nextInt();
		int courseNum = scaner.nextInt();
		@SuppressWarnings("unchecked")
		ArrayList<String>[] courseList = new ArrayList[courseNum];
		for(int i = 0 ; i < courseNum ; i++) {
			courseList[i] = new ArrayList<String>();
		}
		scaner.nextLine();
		for(int i = 0 ; i < stuNum ; i++) {
			String name = scaner.next();
			int temp = scaner.nextInt();
			for(int j = 0 ; j < temp ; j++) {
				courseList[scaner.nextInt() - 1].add(name);
			}
		}
		scaner.close();
		for(int i = 0 ; i < courseNum ; i++) {
			System.out.println((i + 1) + " " + courseList[i].size());
			Collections.sort(courseList[i]);
			for(String s : courseList[i])
				System.out.println(s);
		}

	}
}
