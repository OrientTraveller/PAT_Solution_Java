package PATFoo;

import java.util.Arrays;
import java.util.Scanner;

public class _1028 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int num = scaner.nextInt();
		int colNum = scaner.nextInt();
		scaner.nextLine();
		String[] str = new String[num];
		for(int i = 0 ; i < str.length ; i++) {
			str[i] = scaner.nextLine();
		}
		if(colNum == 1) {
			Arrays.sort(str);
		}
		else if(colNum == 2) {
			for(int i = 0 ; i < str.length ; i++) {
				String[] strs = str[i].split(" ");
				str[i] = strs[1] + " " + strs[0] + " " + strs[2];
			}
			Arrays.sort(str);
			for(int i = 0 ; i < str.length ; i++) {
				String[] strs = str[i].split(" ");
				str[i] = strs[1] + " " + strs[0] + " " + strs[2];
			}
		}
		else {
			for(int i = 0 ; i < str.length ; i++) {
				String[] strs = str[i].split(" ");
				if(strs[2].equals("100"))
					strs[2] = "999";
				str[i] = strs[2] + " " + strs[0] + " " + strs[1];
			}
			//分 学号 姓名
			Arrays.sort(str);
			for(int i = 0 ; i < str.length ; i++) {
				String[] strs = str[i].split(" ");
				if(strs[0].equals("999"))
					strs[0] = "100";
				str[i] = strs[1] + " " + strs[2] + " " + strs[0];
			}
		}
		for(int i = 0 ; i < str.length ; i++) {
			System.out.println(str[i]);
		}

	}

}
