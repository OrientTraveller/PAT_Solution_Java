package PATFoo;

import java.util.Scanner;

public class _1077 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int num = scaner.nextInt();
		scaner.nextLine();
		String[] str = new String[num];
		int minLen = Integer.MAX_VALUE;
		for(int i = 0 ; i < num ; i++) {
			str[i] = scaner.nextLine();
			if(str[i].length() < minLen)
				minLen = str[i].length();
		}
		scaner.close();
		int suffixLen = 0;
		while(suffixLen < minLen) {
			char c = str[0].charAt(str[0].length() - 1 - suffixLen);
			boolean flag = true;
			for(int i = 1 ; i < num ; i++)
				if(str[i].charAt(str[i].length() - 1 - suffixLen) != c)
					flag = false;
			if(flag)
				suffixLen++;
			else
				break;
		}
		if(suffixLen == 0)
			System.out.println("nai");
		else
			System.out.println(str[0].substring(str[0].length() - suffixLen));
	}
}
