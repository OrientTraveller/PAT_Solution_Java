package PATFoo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _1101 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int num = scaner.nextInt();
		int[] ori = new int[num];
		int[] left = new int[num];
		int[] right = new int[num];
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i = 0 ; i < num ; i++) ori[i] = scaner.nextInt();
		scaner.close();
		for(int i = 0 ; i < num ; i++) {
			if(i == 0)
				left[i] = 0;
			else if(i == 1)
				left[i] = ori[0];
			else
				left[i] = Math.max(left[i - 1], ori[i - 1]);
			if(num - 1 - i == num - 1)
				right[num - 1 - i] = Integer.MAX_VALUE;
			else if(num - 1 - i == num - 2)
				right[num - 1 - i] = ori[num - 1];
			else
				right[num - 1 - i] = Math.min(right[num - i], ori[num - i]);
		}	
		for(int i = 0 ; i < num ; i++) {
			int temp = ori[i];
			if(temp > left[i] && temp < right[i])
				result.add(temp);
		}
		Collections.sort(result);
		int size = result.size();
		System.out.println(size);
		for(int i = 0 ; i < size ; i++)
			if(i == size - 1)
				System.out.print(result.get(i));
			else
				System.out.print(result.get(i) + " ");
	}

}
