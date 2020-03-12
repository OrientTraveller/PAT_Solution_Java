package PATFoo;

import java.util.Arrays;
import java.util.Scanner;

public class _1089 {
	
	static int[] mergeSort(int[] arr , int len) {
		if(len >= arr.length)
			Arrays.sort(arr);
		else {
			for(int i = 0 ; i < Math.ceil((float)arr.length / len) ; i++) {
				if (i * len + len <= arr.length)
					Arrays.sort(arr, i * len, i * len + len);
				else
					Arrays.sort(arr, i * len, arr.length);
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int num = scaner.nextInt();
		int[] ori = new int[num];
		int[] post = new int[num];
		String result = "";
		for (int i = 0; i < num; i++)
			ori[i] = scaner.nextInt();
		for (int i = 0; i < num; i++)
			post[i] = scaner.nextInt();
		scaner.close();
		int index = 0;
		for (int i = num - 1; i >= 0; i--) {
			if (ori[i] != post[i]) {
				index = i;
				break;
			}
		}
		if (index == 0) {
			System.out.println("Merge Sort");
			for (int i = 0; i < num / 2 + 1; i++) {
				if (i * 2 + 2 - 1 < num - 1)
					Arrays.sort(post, i * 2, i * 2 + 1);
				else
					Arrays.sort(post, i * 2, num);
			}
			String temp = "";
			for (int i : post)
				temp += i + " ";
			System.out.println(temp.trim());

		} else {
			int[] temp1 = Arrays.copyOfRange(post, 0, index + 1);
			int[] temp2 = Arrays.copyOfRange(ori, 0, index + 1);
			Arrays.sort(temp2);
			if (Arrays.equals(temp1, temp2))
				result = "Insertion Sort";
			else
				result = "Merge Sort";
			if (result.equals("Insertion Sort")) {
				Arrays.sort(post, 0, index + 2);
				String temp = "";
				for (int i : post)
					temp += i + " ";
				System.out.println(result);
				System.out.println(temp.trim());
			} else {
				int len = 2;
				while(true) {
					ori = mergeSort(ori, len);
					len = len * 2;
					if(Arrays.equals(ori, post))
						break;
				}
				ori = mergeSort(ori, len);
				String temp = "";
				for (int i : ori)
					temp += i + " ";
				System.out.println(result);
				System.out.println(temp.trim());
			}
		}
	}

}
