package PATFoo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class _1120 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		LinkedList<Integer> result = new LinkedList<Integer>();
		int round = scaner.nextInt();
		for(int i = 0 ; i < round ; i++) {
			int num = 0;
			String[] temp = scaner.next().split("");
			for(String s : temp) num += Integer.parseInt(s);
			if(!result.contains(num)) result.add(num);
		}
		scaner.close();
		Collections.sort(result);
		System.out.println(result.size());
		for(int i = 0 ; i < result.size() ; i++) {
			System.out.print(result.get(i));
			if(i != result.size() - 1)
				System.out.print(" ");
		}
	}
}
