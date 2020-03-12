package PATFoo;

import java.math.BigInteger;
import java.util.Scanner;

public class _1024 {
	
	public static boolean check(BigInteger bi) {
		String str = bi.toString();
		StringBuffer strb=new StringBuffer(str);
		String newstr = strb.reverse().toString();
		if(str.equals(newstr))
			return true;
		else
			return false;
	}
	
	public static BigInteger getRev(BigInteger bi) {
		String str = bi.toString();
		StringBuffer strb=new StringBuffer(str);
		String newstr = strb.reverse().toString();
		return new BigInteger(newstr);
	}

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		String[] str = scaner.nextLine().split(" ");
		scaner.close();
		BigInteger ori = new BigInteger(str[0]);
		int rounds = Integer.parseInt(str[1]);
		int current = 0;
		for(int i = 0 ; i < rounds ; i++) {
			if(check(ori)) {
				System.out.println(ori);
				System.out.println(current);
				break;
			}
			else {
				current++;
				ori = ori.add(getRev(ori));
			}
		}
		if(!check(ori)) {
			System.out.println(ori);
			System.out.println(rounds);
		}
		if(check(ori)&&current == rounds) {
			System.out.println(ori);
			System.out.println(rounds);
		}
	}

}
