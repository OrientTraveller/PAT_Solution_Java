package PATFoo;

import java.util.ArrayList;
import java.util.Scanner;

public class _1059 {
	
	//埃拉托斯特尼筛法
	static ArrayList<Integer> prime(int j) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		boolean[] flag = new boolean[j + 1];
		flag[0] = flag[1] = true;
		for(int i = 2 ; i < j + 1 ; i++) {
			if(flag[i] == false) {
				al.add(i);
				for(int k = i + i ; k < j + 1 ; k+=i) {
					flag[k] = true;
				}
			}
		}
		return al;
	}

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int num = scaner.nextInt();
		scaner.close();
		if(num != 1) {
			System.out.print(num + "=");
			ArrayList<Integer> prime = prime(num);
			int size = prime.size();
			int[] e = new int[size];
			int index = 0;
			for(int i = 0 ; i < size ; i++) {
				int divisor = prime.get(i);
				while(true) {
					if(num >= divisor && (num%divisor == 0)) {
						e[i]++;
						num = num / divisor;
					}
					if(num >= divisor && (num%divisor != 0)){
						break;
					}
					if(num == 1) {
						index = i;
						break;	
					}	
				}
				if(num == 1)
					break;
			}
			for(int i = 0 ; i <= index ; i++) {
				if(e[i] > 0) {
					if(e[i] == 1&&i != index) {
						System.out.print(prime.get(i) + "*");
					}
					if(e[i] == 1&&i == index) {
						System.out.print(prime.get(i));
					}
					if(e[i] > 1&&i != index) {
						System.out.print(prime.get(i) + "^" + e[i] + "*");
					}
					if(e[i] > 1&&i == index) {
						System.out.print(prime.get(i) + "^" + e[i]);
					}
				}
			}
		}
		else
			System.out.println("1=1");
	}

}
