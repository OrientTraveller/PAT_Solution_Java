package PATFoo;

import java.util.ArrayList;
import java.util.Scanner;

public class _1044数组叠加版 {

	public static void main(String[] args) {
		long startTime=System.nanoTime();   //获取开始时间 
		Scanner scaner = new Scanner(System.in);
		int diamondsNum = scaner.nextInt();
		int totalMoney = scaner.nextInt();
		int[] diamondsString = new int[diamondsNum];
		boolean flag = false;
		ArrayList<Integer> start = new ArrayList<>();
		ArrayList<Integer> end = new ArrayList<>();
		int mincost = Integer.MAX_VALUE;
		int[] addValue = new int[diamondsNum];
		for(int i = 0 ; i < diamondsNum ; i++) {
			diamondsString[i] = scaner.nextInt();
			addValue[i] = 0;
			for(int j = i ; j >= 0 ; j--) {
				addValue[j] += diamondsString[i];
				if(addValue[j] > mincost) {
					break;
				}
				if(addValue[j] == totalMoney) {
					flag = true;
					if((i + 1) > (j + 1))
						System.out.println((j + 1) + "-" + (i + 1));
					else
						System.out.println((i + 1) + "-" + (j + 1));
				}
				else if(addValue[j] > totalMoney) {
					if(addValue[j] < mincost) {
						mincost = addValue[j];
						start.clear();
						end.clear();
						start.add((i + 1));
						end.add((j + 1));
					}
					else if(addValue[j] == mincost) {
						start.add((i + 1));
						end.add((j + 1));
					}
					
				}
			}
		}
		scaner.close();
		if(!flag) {
			for(int i = 0 ; i < start.size() ; i++) {
				if(start.get(i) < end.get(i))
					System.out.println(start.get(i) + "-" + end.get(i));
				else
					System.out.println(end.get(i) + "-" + start.get(i));
				
			}
		}
		long endTime=System.nanoTime(); //获取结束时间  
		System.out.println("程序运行时间： "+(endTime-startTime)+"ns"); 
	}

}
