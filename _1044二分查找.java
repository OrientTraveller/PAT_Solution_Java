package PATFoo;

import java.util.ArrayList;
import java.util.Scanner;

public class _1044二分查找 {
	static int diamondsNum = -1;
	static int totalMoney = -1;
	static int[] diamondsString;
	
	static int[] binaryCheck(int start) {
		int[] result = new int[2];
		int left = start - 1;
		int leftValue;
		if(left == -1)
			leftValue = 0;
		else
			leftValue = diamondsString[left];
		int right = diamondsNum - 1;
		while(left < right) {
			int mid = (left + right)/2;
			if(diamondsString[mid] - leftValue >= totalMoney)
				right = mid;
			else
				left = mid + 1;			
		}
		result[0] = right;
		result[1] = diamondsString[right] - leftValue;
		return result;
	}

	public static void main(String[] args) {
		long startTime=System.nanoTime();   //获取开始时间   
		Scanner scaner = new Scanner(System.in);
		diamondsNum = scaner.nextInt();
		totalMoney = scaner.nextInt();
		diamondsString = new int[diamondsNum];
		ArrayList<Integer> start = new ArrayList<>();
		ArrayList<Integer> end = new ArrayList<>();
		int mincost = Integer.MAX_VALUE;
		for(int i = 0 ; i < diamondsNum ; i++) {
			diamondsString[i] = scaner.nextInt();
			if(i >= 1)
				diamondsString[i] += diamondsString[i - 1];
		}
		scaner.close();
		for(int i = 0 ; i < diamondsString.length ; i++) {
			int[] temp = binaryCheck(i);
			int left = i;
			int right = temp[0];
			int tempSum = temp[1];
			if(tempSum >= totalMoney) {
				if(tempSum < mincost) {
					start.clear();
					end.clear();
					mincost = tempSum;
					start.add(left + 1);
					end.add(right + 1);
				}
				else if(tempSum == mincost) {
					start.add(left + 1);
					end.add(right + 1);
				}
			}
		}
		long endTime=System.nanoTime(); //获取结束时间  
		System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
		for(int i = 0 ; i < start.size() ; i++) {
			System.out.println(start.get(i) + "-" + end.get(i));
		}
		  
	}

}
