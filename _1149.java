package PATFoo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class _1149 {

	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		LinkedList<LinkedList<Integer>> list = new LinkedList<LinkedList<Integer>>();
		Scanner scaner = new Scanner(System.in);
		int pairNum = scaner.nextInt();
		int round = scaner.nextInt();
		for (int i = 0; i < pairNum; i++) {
			int temp1 = scaner.nextInt();
			int temp2 = scaner.nextInt();
			if(!map.containsKey(temp1)) {
				map.put(temp1, map.size());
				LinkedList<Integer> list1 = new LinkedList<Integer>();
				list1.add(temp2);
				list.add(list1);
			}else {
				int index = map.get(temp1);
				LinkedList<Integer> list1 = list.get(index);
				list1.add(temp2);
				list.set(index, list1);
			}
			if(!map.containsKey(temp2)) {
				map.put(temp2, map.size());
				LinkedList<Integer> list2 = new LinkedList<Integer>();
				list2.add(temp1);
				list.add(list2);
			}else {
				int index = map.get(temp2);
				LinkedList<Integer> list2 = list.get(index);
				list2.add(temp1);
				list.set(index, list2);
			}
		}
		LinkedList<Integer> banned = new LinkedList<Integer>();
		boolean flag = true;
		for (int i = 0; i < round; i++) {
			int num = scaner.nextInt();
			banned.clear();
			flag = true;
			for (int j = 0; j < num; j++) {
				int temp = scaner.nextInt();
				if(flag)
					if(banned.contains((Object)temp))
						flag = false;
					else {
						Object index = map.get(temp);
						if(index != null)
							banned.addAll(list.get((int)index));
					}
			}
			if(flag)	System.out.println("Yes");
			else		System.out.println("No");
		}
		scaner.close();
	}
}
