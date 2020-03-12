package PATFoo;

import java.util.Scanner;

public class _1140 {

	static String run(String str) {
		char pre = '@';
		int num = 1;
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) != pre) {
				if(pre != '@')
					result += String.valueOf(pre) + num;
				pre = str.charAt(i);
				num = 1;
			}
			else
				num++;
		}
		result += String.valueOf(pre) + num;
		return result;
	}
	
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		String init = scaner.next();
		int round = scaner.nextInt();
		for (int i = 0; i < round - 1; i++) {
			String str = run(init);
			init = str;
		}
		scaner.close();
		System.out.println(init);
	}

}
