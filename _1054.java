package PATFoo;

import java.util.Scanner;
import java.util.TreeMap;

public class _1054 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int len = scaner.nextInt();
		int wid = scaner.nextInt();
		int edge = len * wid / 2;
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		boolean flag = false;
		for(int i = 0 ; i < wid ; i++) {
			for(int j = 0 ; j < len ; j++) {
				int key = scaner.nextInt();
				if(map.containsKey(key)) {
					int value = map.get(key) + 1;
					if(value > edge) {
						System.out.println(key);
						flag = true;
						break;
					}
					map.remove(key);
					map.put(key, value);
				}
				else {
					map.put(key, 1);
				}
			}
			if(flag)
				break;
		}
		scaner.close();
	}
}
