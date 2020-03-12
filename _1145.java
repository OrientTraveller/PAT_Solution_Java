package PATFoo;

import java.util.Scanner;

public class _1145 {

	static boolean isPrime(int num) {
		if(num < 2)	return false;
		for(int i = 2 ; i < Math.sqrt(num) + 1 ; i++)
			if(num % i == 0)
				return false;
		return true;
	}
	
	static int getPrime(int size) {
		while(!isPrime(size)) size++;
		return size;
	}
	
	static int hash(int key, int d, int size) {
		return (key + d*d) % size;
	}
	
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int size = getPrime(scaner.nextInt());
		int round = scaner.nextInt();
		int check = scaner.nextInt();
		int[] hashTable = new int[size];
		for (int i = 0; i < round; i++) {
			int temp = scaner.nextInt();
			for(int d = 0 ; d <= size ; d++) {
				if(hashTable[hash(temp, d, size)] == 0) {
					hashTable[hash(temp, d, size)] = temp;
					break;
				}
				if(d == size)	System.out.println(temp+" cannot be inserted.");
			}
		}
		int totalTime = 0;
		for (int i = 0; i < check; i++) {
			int temp = scaner.nextInt();
			for(int d = 0 ; d <= size ; d++) {
				totalTime++;
				if(hashTable[hash(temp, d, size)] == temp || hashTable[hash(temp, d, size)] == 0) {
					hashTable[hash(temp, d, size)] = temp;
					break;
				}
			}
		}
		scaner.close();
		System.out.println(String.format("%.1f", (float)totalTime/check));
	}

}
