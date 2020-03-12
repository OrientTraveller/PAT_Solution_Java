package PATFoo;

import java.util.TreeMap;
import java.util.Map;
import java.util.Scanner;

public class _1121 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		Map<Integer, Integer> couple = new TreeMap<Integer, Integer>();
		int[] record = new int[100000];
		int round = scaner.nextInt();
		for(int i = 0 ; i < round ; i++) {
			int temp1 = Integer.parseInt(scaner.next());
			int temp2 = Integer.parseInt(scaner.next());
			couple.put(temp1, temp2);
			couple.put(temp2, temp1);
			record[temp1]++;
			record[temp2]++;
		}
		round = scaner.nextInt();
		for(int i = 0 ; i < round ; i++)
			record[Integer.parseInt(scaner.next())] += 2;
		scaner.close();
		String result = "";
		int sum = 0;
		for(int i = 0 ; i < 100000 ; i++)
			if(record[i] == 2 || (record[i] == 3 && record[couple.get(i)] != 3)) {
				sum++;
				result += String.format("%5d", i) + " ";
			}
		System.out.println(sum);
		System.out.println(result.trim());
		

	}

}
