package PATFoo;

import java.util.LinkedList;
import java.util.Scanner;

public class _1148 {
	
	static int[] arr;
	
	static boolean check(int w1, int w2) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		int[] isHuman = new int[arr.length];
		for(int i = 0; i < arr.length; i++)	isHuman[i] = 1;
		isHuman[w1] = isHuman[w2] = -1;
		for(int i = 0; i < arr.length; i++)
			if(arr[i]*isHuman[Math.abs(arr[i]) - 1] < 0) list.add(isHuman[i]);
		if(list.size() == 2 && list.get(0)+list.get(1) == 0) {
			System.out.println((w1+1) + " " + (w2+1));
			return true;
		}
		else return false;
	}

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int num = scaner.nextInt();
		arr = new int[num];
		for (int i = 0; i < num; i++) arr[i] = scaner.nextInt(); 
		scaner.close();
		boolean haveSolvation = false;
		loop:
		for (int i = 0; i < num; i++)
			for(int j = i + 1 ; j < num ; j++)
				if(check(i,j)) {
					haveSolvation = true;
					break loop;
				}
		if(!haveSolvation) System.out.println("No Solution");
	}
}
