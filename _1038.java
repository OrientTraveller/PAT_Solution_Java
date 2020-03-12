package PATFoo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class _1038 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int totalNum = scaner.nextInt();
		ArrayList<String> num = new ArrayList<String>();
		for(int i = 0 ; i < totalNum ; i++) {
			String temp = scaner.next();
			if(Integer.parseInt(temp) != 0)
				num.add(temp);
		}
		scaner.close();
		Comparator<String> cmp = new cmp();
		Collections.sort(num,cmp);
		String result = "";
		for(String s : num) {
			result += s;
			System.out.println(s);
		}
		int result1 = Integer.parseInt(result);
		System.out.println(result1);
	}

}
class cmp implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		String[] temp1 = o1.split("");
		String[] temp2 = o2.split("");
		int i = 0;
		for(i = 0; i < temp1.length && i < temp2.length ; i++) {
			if(!temp1[i].equals(temp2[i]))
				return o1.compareTo(o2);
		}
		if(i < temp1.length) {
			return temp1[i].compareTo(temp1[0]);
		}
		else if(i < temp2.length) {
			int result = 0 - temp2[i].compareTo(temp2[0]);
			return result;
		}
		else
			return 0;
	}
	
}
