package PATFoo;

import java.util.Scanner;

public class _1078 {

	static boolean isPrime(int i) {
		if(i < 2)
			return false;
		else {
			boolean flag = true;
			for(int j = 2 ; j <= Math.sqrt(i) ; j++) {
				if(i % j == 0) {
					flag = false;
					break;
				}
			}
			return flag;
		}
	}
	
	static int getPrime(int i) {
		if(isPrime(i))
			return i;
		else {
			while(true) {
				i++;
				if(isPrime(i))
					break;
			}
			return i;
		}
	}
	
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int size = getPrime(scaner.nextInt());
		int num = scaner.nextInt();
		int[] hash = new int[size];
		String result = "";
		for(int i = 0 ; i < num ; i++) {
			int key = scaner.nextInt();
			int index = key % size;
			if(index < size) {
				if(hash[index] == 0) {
					hash[index] = key;
					result = result + index + " ";
				}
				else {
					int temp = 1;
					while(true) {
						int newKey = (int) (index + Math.pow(temp, 2));
						if(newKey < size) {
							if(hash[newKey] == 0) {
								hash[newKey] = key;
								result = result + newKey + " ";
								break;
							}
							else
								temp++;
						}
						else {
							result = result + "- ";
							break;
						}
						
					}
				}
			}
			else
				result = result + "- ";
			
		}
		scaner.close();
		System.out.println(result.trim());

	}

}
