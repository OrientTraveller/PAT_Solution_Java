package PATFoo;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class _1141 {
	
	static class School {
		String id;
		int studentNum;
		int BScore;
		int AScore;
		int TScore;
		int totalScore;
		public School(String id) {
			this.id = id;
			this.studentNum = 0;
			this.BScore = 0;
			this.AScore = 0;
			this.TScore = 0;
			this.totalScore = 0;
		}
	}
	
	public static void main(String[] args) {
		LinkedList<School> list = new LinkedList<School>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		Scanner scaner = new Scanner(System.in);
		int round = scaner.nextInt();
		for (int i = 0; i < round; i++) {
			String str = scaner.next();
			int score = scaner.nextInt();
			String sch = scaner.next().toLowerCase();
			if(!map.containsKey(sch)) {
				School temp = new School(sch);
				temp.studentNum++;
				if(str.charAt(0) == 'B')
					temp.BScore += score;
				else if(str.charAt(0) == 'A')
					temp.AScore += score;
				else
					temp.TScore += score;
				map.put(sch, map.size());
				list.add(temp);
			}else {
				School temp = list.get(map.get(sch));
				temp.studentNum++;
				if(str.charAt(0) == 'B')
					temp.BScore += score;
				else if(str.charAt(0) == 'A')
					temp.AScore += score;
				else
					temp.TScore += score;
				list.set(map.get(sch), temp);
			}
		}
		scaner.close();
		for (School s : list)
			s.totalScore = (int)(s.BScore/1.5 + s.AScore + s.TScore*1.5);
		Collections.sort(list, new Comparator<School>() {
			@Override
			public int compare(School o1, School o2) {
				if(o1.totalScore > o2.totalScore) 			return -1;
				else if(o1.totalScore < o2.totalScore)		return 1;
				else
					if(o1.studentNum < o2.studentNum)		return -1;
					else if(o1.studentNum > o2.studentNum)	return 1;
					else									return o1.id.compareTo(o2.id);
			}
		});
		System.out.println(list.size());
		int pre = list.get(0).totalScore;
		int rank = 1;
		int num = 0;
		for (School s : list) {
			num++;
			if(s.totalScore != pre){
				rank = num;
				pre = s.totalScore;
			}
			System.out.println(rank + " " + s.id + " " + s.totalScore + " " + s.studentNum);
		}
	}

}
