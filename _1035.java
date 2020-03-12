package PATFoo;

import java.util.ArrayList;
import java.util.Scanner;

public class _1035 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int num = scaner.nextInt();
		scaner.nextLine();
		String[] str = new String[num];
		for(int i = 0 ; i < num ; i++) {
			str[i] = scaner.nextLine();
		}
		scaner.close();
		ArrayList<String> result = new ArrayList<>();
		for(String s : str) {
			String[] temp = s.split(" ");
			String pre = temp[1];
			temp[1] = temp[1].replace('1', '@').replace('0', '%').replace('l', 'L').replace('O', 'o');
			if(!pre.equals(temp[1])) {
				result.add(temp[0] + " " + temp[1]);
			}
		}
		if(result.size()>0) {
			System.out.println(result.size());
			for(String s : result) {
				System.out.println(s);
			}
		}
		else {
			if(str.length == 1)
				System.out.println("There is 1 account and no account is modified");
			else
				System.out.println("There are "+ str.length + " accounts and no account is modified");
		}
	}

}
