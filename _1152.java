package PATFoo;

import java.util.Scanner;

public class _1152 {
	
	static boolean isPrime(int key) {
		for(int i = 2; i*i < key; i++) 
			if(key % i == 0) return false;
		return true;
	}

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int num = scaner.nextInt();
		int len = scaner.nextInt();
		scaner.nextLine();
		String str = scaner.nextLine();
		scaner.close();
		boolean flag = false;
		for(int i = 0; i <= num - len; i++) {
			String temp = str.substring(i, i+len);
			if(isPrime(Integer.parseInt(temp))) {
				System.out.println(temp);
				flag = true;
				break;
			}		
		}
		if(!flag) System.out.println("404");
	}
}
