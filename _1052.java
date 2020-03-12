package PATFoo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _1052 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int round = scaner.nextInt();
		Map<Integer, String> map = new TreeMap<Integer, String>();
		scaner.nextLine();
		String[] str;
		ArrayList<Integer> al = new ArrayList<>();
		for(int i = 0 ; i < round ; i++) {
			str = scaner.nextLine().split(" ");
			String value = str[0];
			int key = Integer.parseInt(str[1]);
			al.add(key);
			map.put(key, value);
		}
		scaner.close();
		Collections.sort(al);
		System.out.println(round + " " + map.get(al.get(0)));
		if(al.size() == 0)
			System.out.println("0 -1");
		else {
			for(int i = 0 ; i < al.size() ; i++) {
				int key = al.get(i);
				if(i < al.size() - 1)
					System.out.println(map.get(key) + " " + key + " " + map.get(al.get(i + 1)));
				else
					System.out.println(map.get(key) + " " + key + " " + (-1));
			}
		}
	}

}
