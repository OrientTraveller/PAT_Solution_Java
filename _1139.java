package PATFoo;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class _1139 {
	
	static LinkedList<People> list;
	static HashMap<Integer, Integer> map;
	
	static class People {
		int id;
		LinkedList<Integer> maleFriends;
		LinkedList<Integer> femaleFriends;
		public People(int id) {
			this.id = id;
			this.maleFriends = new LinkedList<Integer>();
			this.femaleFriends = new LinkedList<Integer>();
		}
	}
	
	static void find(int p1, int p2) {
		if(map.containsKey(p1) && map.containsKey(p2) && p1 != p2) {
			LinkedList<Integer> list1;
			boolean[] flag = new boolean[map.size()];
			LinkedList<String> result = new LinkedList<String>();
			if(p1 > 0) list1 = list.get(map.get(p1)).maleFriends;
			else	   list1 = list.get(map.get(p1)).femaleFriends;
			for (Integer i : list1)
				if(i != p1 && i != p2) {
					LinkedList<Integer> list2;
					if(p2 > 0) list2 = list.get(map.get(i)).maleFriends;
					else	   list2 = list.get(map.get(i)).femaleFriends;
					for (Integer j : list2)
						if(j != i && j != p1 && j != p2 && !flag[map.get(j)]) {
							LinkedList<Integer> list3;
							if(p2 > 0) list3 = list.get(map.get(j)).maleFriends;
							else	   list3 = list.get(map.get(j)).femaleFriends;
							if(list3.contains(p2))
								result.add(String.format("%04d", Math.abs(i))+" "+String.format("%4d", Math.abs(j)));
							else
								flag[map.get(j)] = true;
						}
				}
			Collections.sort(result, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					String[] arr1 = o1.split(" ");
					String[] arr2 = o2.split(" ");
					if(Integer.parseInt(arr1[0]) < Integer.parseInt(arr2[0]))
						return -1;
					else if(Integer.parseInt(arr1[0]) > Integer.parseInt(arr2[0]))
						return 1;
					else
						if(Integer.parseInt(arr1[1]) < Integer.parseInt(arr2[1]))
							return -1;
						else return 1;
				}
			});
			System.out.println(result.size());
			for (String s : result)
				System.out.println(s);
		}else
			System.out.println("0");
	}

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);scaner.nextInt();
		list = new LinkedList<People>();
		map = new HashMap<Integer, Integer>();
		int round = scaner.nextInt();
		for (int i = 0; i < round; i++) {
			int temp1 = scaner.nextInt();
			int temp2 = scaner.nextInt();
			if(!map.containsKey(temp1)) {
				People p1 = new People(temp1);
				if(temp2 > 0)	p1.maleFriends.add(temp2);
				else			p1.femaleFriends.add(temp2);
				list.add(p1);
				map.put(temp1, map.size());
			}else {
				People p1 = list.get(map.get(temp1));
				if(temp2 > 0)	{p1.maleFriends.add(temp2); list.set(map.get(temp1), p1);}
				else			{p1.femaleFriends.add(temp2); list.set(map.get(temp1), p1);}
			}
			if(!map.containsKey(temp2)) {
				People p2 = new People(temp2);
				if(temp1 > 0)	p2.maleFriends.add(temp1);
				else			p2.femaleFriends.add(temp1);
				list.add(p2);
				map.put(temp2, map.size());
			}else {
				People p2 = list.get(map.get(temp2));
				if(temp1 > 0)	{p2.maleFriends.add(temp1); list.set(map.get(temp2), p2);}
				else			{p2.femaleFriends.add(temp1); list.set(map.get(temp2), p2);}
			}
		}
		round = scaner.nextInt();
		for (int i = 0; i < round; i++)
			find(scaner.nextInt(), scaner.nextInt());
		scaner.close();
	}
}
