package PATFoo;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class _1114 {

	static HashMap<String, Integer> map;
	static LinkedList<String> result;
	
	static class People {
		String id;
		int set;
		int area;
		LinkedList<String> relationship;
		public People(String id) {
			this.id = id;
			this.set = 0;
			this.area = 0;
			this.relationship = new LinkedList<String>();
		}
	}
	
	static void BFS(LinkedList<People> g) {
		LinkedList<People> list = new LinkedList<People>();
		boolean[] flag = new boolean[g.size()];
		result = new LinkedList<String>();
		for(int i = 0 ; i < g.size() ; i++) {
			if(!flag[i]) {
				list.clear();
				int mNum = 0;
				int sNum = 0;
				int aNum = 0;
				LinkedList<String> family = new LinkedList<String>();
				list.add(g.get(i));
				while(list.size() > 0) {
					People temp = list.remove();
					flag[map.get(temp.id)] = true;
					mNum++;
					family.add(temp.id);
					sNum += temp.set;
					aNum += temp.area;
					for(String s : temp.relationship)
						if(!flag[map.get(s)] && !list.contains(g.get(map.get(s))))
							list.add(g.get(map.get(s)));	
				}
				Collections.sort(family);
				result.add(family.getFirst() + " " + mNum + " " + String.format("%.3f", (float)sNum/mNum) + " " + String.format("%.3f", (float)aNum/mNum));
			}
			
		}
	}
	
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int num = scaner.nextInt();
		map = new HashMap<String, Integer>();
		LinkedList<People> list = new LinkedList<People>();
		int index = 0;
		for(int i = 0 ; i < num ; i++) {
			String id = scaner.next();
			if(!map.containsKey(id)) {
				map.put(id, index++);
				list.add(new People(id));
			}
			for(int j = 0 ; j < 2 ; j++) {
				String temp = scaner.next();
				if(!temp.equals("-1")) {
					list.get(map.get(id)).relationship.add(temp);
					if(!map.containsKey(temp)) {
						map.put(temp, index++);
						People p = new People(temp);
						p.relationship.add(id);
						list.add(p);
					}
					else
						list.get(map.get(temp)).relationship.add(id);
				}
			}
			int child = scaner.nextInt();
			for(int j = 0 ; j < child ; j++) {
				String temp = scaner.next();
				list.get(map.get(id)).relationship.add(temp);
				if(!map.containsKey(temp)) {
					map.put(temp, index++);
					People p = new People(temp);
					p.relationship.add(id);
					list.add(p);
				}
				else
					list.get(map.get(temp)).relationship.add(id);
				
			}
			list.get(map.get(id)).set = scaner.nextInt();
			list.get(map.get(id)).area = scaner.nextInt();
		}
		scaner.close();
		BFS(list);
		Comparator<String> cmp = new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				String[] arr1 = o1.split(" ");
				String[] arr2 = o2.split(" ");
				if(Float.parseFloat(arr1[3]) > Float.parseFloat(arr2[3]))
					return -1;
				else if(Float.parseFloat(arr1[3]) < Float.parseFloat(arr2[3]))
					return 1;
				else {
					return arr1[0].compareTo(arr2[0]);
				}
			}
		};
		Collections.sort(result, cmp);
		System.out.println(result.size());
		for(String s : result)
			System.out.println(s);
	}

}
