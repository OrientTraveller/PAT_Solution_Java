package PATFoo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 需要考虑
 * 3
 * eeeeee
 * 这种输入
 * 若相同一直持续到字符串末尾，所以需要在循环结束后对最后一组重复字符串进行判断
 * @author SunFeiran
 *
 */

public class _1112 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int k = scaner.nextInt();
		scaner.nextLine();
		String ori = scaner.nextLine();
		scaner.close();
		ArrayList<Character> list = new ArrayList<Character>();
		ArrayList<Character> deleted = new ArrayList<Character>();
		char c = ori.charAt(0);
		int sum = 1;
		for(int i = 1 ; i < ori.length() ; i++)
			if(c == ori.charAt(i))
				sum++;
			else {
				if(sum%k == 0 && !list.contains(c) && !deleted.contains(c)) list.add(c);
				else if(sum%k != 0 && list.contains(c)) {list.remove((Object)c); deleted.add(c);}
				c = ori.charAt(i);
				sum = 1;
			}
        if(sum%k==0 && !list.contains(c) && !deleted.contains(c))
			list.add(c);
        for(char cc : list) {
			System.out.print(cc);
			String temp = "";
			for(int i = 0 ; i < k ; i++)
				temp += cc;
			ori = ori.replace(temp, Character.toString(cc));
		}
		System.out.println();
		System.out.println(ori);
	}

}
