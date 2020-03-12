package PATFoo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class _1076 {
	
	static class People {
		ArrayList<Integer> followers;
		public People() {
			followers = new ArrayList<Integer>();
		}
	}
	
	static void cal(People[] list , int index , int level) {
		Set<Integer> set = new HashSet<Integer>();
		int round = 0;
		LinkedList<Integer> num = new LinkedList<>();
		num.addAll(list[index - 1].followers);
		while(round < level) {
			round++;
			int size = num.size();
			for(int i = 0 ; i < size ; i++) {
				int temp = num.pop();
				num.addAll(list[temp - 1].followers);
				if(temp != index)
					set.add(temp);
			}
		}
		System.out.println(set.size());
	}
	
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int userNum = scaner.nextInt();
		People[] list = new People[userNum];
		for(int i = 0 ; i < userNum ; i++) {
			list[i] = new People();
		}
		int level = scaner.nextInt();
		for(int i = 0 ; i < userNum ; i++) {
			int followersNum = scaner.nextInt();
			for(int j = 0 ; j < followersNum ; j++) {
				list[scaner.nextInt() - 1].followers.add(i + 1);
			}
		}
		int temp = scaner.nextInt();
		for(int i = 0 ; i < temp ; i++) {
			int index = scaner.nextInt();
			cal(list,index,level);
		}
		scaner.close();
	}
}
