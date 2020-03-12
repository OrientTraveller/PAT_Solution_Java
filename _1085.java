package PATFoo;

import java.util.Arrays;
import java.util.Scanner;

public class _1085 {
	
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int round = scaner.nextInt();
		int p = scaner.nextInt();
		int[] seq = new int[round];
		for(int i = 0 ; i < round ; i++) {
			seq[i] = scaner.nextInt();
		}
		scaner.close();
		Arrays.sort(seq);
		int left = 0;
		int right = 0;
		int len = 0;
		while(left < seq.length && right < seq.length) {
			while(right < seq.length && seq[right] <= (long)seq[left]*(long)p) {
				len = len > right - left + 1 ? len : right - left + 1;
				right++;
			}
			left++;	
		}
		System.out.println(len);
	}

}
