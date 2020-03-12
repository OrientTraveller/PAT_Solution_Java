package PATFoo;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 第26行一定要添加 i >= first条件，保证first前面的用户不会因为满足(i - first)%skip == 0而输出
 * 例如 6 5 6的条件，因为（1 - 6）%5==0，所以若不添加上述条件会输出first前面的用户
 * @author SunFeiran
 *
 */

public class _1124 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int num = scaner.nextInt();
		int skip = scaner.nextInt();
		int first = scaner.nextInt();
		LinkedList<String> selected = new LinkedList<String>();
		if(first > num)
			System.out.println("Keep going...");
		else
			for(int i = 1 ; i <= num ; i++) {
				String temp = scaner.next();
				if(i >= first && (i - first)%skip == 0)
					if(!selected.contains(temp))
						selected.add(temp);
					else
						first++;
			}
		scaner.close();
		for(String s : selected)
			System.out.println(s);

	}

}
