package PATFoo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Scanner;

public class _1153 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		HashMap<Integer, Integer> site_num = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> site_score = new HashMap<Integer, Integer>();
		int size = scaner.nextInt();
		int round = scaner.nextInt();
		String[] arr = new String[size];
		for (int i = 0; i < size; i++) {
			String num = scaner.next();
			int score = scaner.nextInt();
			int tempSit =Integer.parseInt(num.substring(1, 4));
			if(!site_num.containsKey(tempSit)) 	{site_num.put(tempSit, 1); site_score.put(tempSit, score);}
			else								{site_num.replace(tempSit, site_num.get(tempSit)+1); site_score.replace(tempSit, site_score.get(tempSit)+score);}
			arr[i] = num + " " + score;
		}
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String[] arr1 = o1.split(" ");
				String[] arr2 = o2.split(" ");
				if(Integer.parseInt(arr1[1]) > Integer.parseInt(arr2[1]))
					return -1;
				else if(Integer.parseInt(arr1[1]) < Integer.parseInt(arr2[1]))
					return 1;
				else
					return arr1[0].compareTo(arr2[0]);
			}
		});;
		for (int i = 1; i <= round; i++) {
			String type = scaner.next();
			String p = scaner.next();
			System.out.println("Case "+i+": "+type+" "+p);
			if(type.equals("1")) {
				boolean flag = false;
				for(String s : arr)
					if(s.contains(p)) {
						flag = true;
						System.out.println(s);
					}
				if(!flag) System.out.println("NA");
			}
			else if(type.equals("2")) {
				if(site_num.get(Integer.parseInt(p)) == null)
					System.out.println("NA");
				else
					System.out.println(site_num.get(Integer.parseInt(p))+" "+site_score.get(Integer.parseInt(p)));
			}
			else {
				HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
				for(String s : arr) {
					String date = s.substring(4, 10);
					if(date.equals(p)) {
						int tempSit =Integer.parseInt(s.substring(1, 4));
						if(!map.containsKey(tempSit)) 	map.put(tempSit, 1);
						else							map.replace(tempSit, map.get(tempSit)+1);
					}
				}
				LinkedList<Entry<Integer, Integer>> list = new LinkedList<Entry<Integer, Integer>>(map.entrySet());
				if(list.size() == 0)
					System.out.println("NA");
				else {
					Collections.sort(list, new Comparator<Entry<Integer, Integer>>() {

						@Override
						public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
							if(o1.getValue() > o2.getValue())
								return -1;
							else if(o1.getValue() < o2.getValue())
								return 1;
							else if(o1.getKey() < o2.getKey())
								return -1;
							else return 1;
						}
					});
					for(Entry<Integer, Integer> e : list)
						System.out.println(e.getKey()+" "+e.getValue());
				}
			}
		}
		scaner.close();
	}
}
