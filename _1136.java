package PATFoo;

import java.math.BigInteger;
import java.util.Scanner;

public class _1136 {
	
	static boolean judge(BigInteger bi) {
		StringBuffer temp = new StringBuffer(bi.toString());
		StringBuffer rev = new StringBuffer(bi.toString());
		rev = rev.reverse();
		if(temp.toString().equals(rev.toString()))	return true;
		else										return false;
	}
	
	static String getRev(String ori) {
		return new StringBuffer(ori).reverse().toString();
	}

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		String ori = scaner.nextLine();
		scaner.close();
		int i;
		for(i = 0; i < 10 ; i++) {
			BigInteger bi1 = new BigInteger(ori);
			if(judge(bi1)) {
				System.out.println(bi1.toString()+" is a palindromic number.");
				break;
			}
			BigInteger bi2 = new BigInteger(getRev(ori)).add(bi1);
			System.out.println(ori+" + "+getRev(ori)+" = "+bi2.toString());
			if(judge(bi2)) {
				System.out.println(bi2.toString()+" is a palindromic number.");
				break;
			}
			else
				ori = bi2.toString();
		}
		if(i == 10)
			System.out.println("Not found in 10 iterations.");

	}

}
