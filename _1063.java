package PATFoo;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _1063 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int num = scaner.nextInt() + 1;
		@SuppressWarnings("unchecked")
		Set<Integer>[] setArr = new Set[num];
		for(int i = 1 ; i < num ; i++) {
			int tempNum = scaner.nextInt();
			setArr[i] = new HashSet<Integer>();
			for(int j = 0 ; j < tempNum ; j++) {
				setArr[i].add(scaner.nextInt());
			}
		}
		int round = scaner.nextInt();
		//超时
		long startTime=System.nanoTime();   //获取开始时间
		for(int i = 0 ; i < round ; i++) {
			int index1 = scaner.nextInt();
			int index2 = scaner.nextInt();
			Set<Integer> set1 = setArr[index1];
			Set<Integer> set2 = setArr[index2];
			float value = (float)intersect(set1, set2)/join(set1, set2)*100;
			String result = String.format("%.1f", value) + "%";
			System.out.println(result);
		}
		long endTime=System.nanoTime(); //获取结束时间  
		System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
		long startTime1=System.nanoTime();   //获取开始时间
		for(int i = 0 ; i < round ; i++) {
			int index1 = scaner.nextInt();
			int index2 = scaner.nextInt();
			Set<Integer> set1 = setArr[index1];
			Set<Integer> set2 = setArr[index2];
			int same = 0;
			int unsame = 0;
			for(Integer j : set1)
				if(set2.contains(j))
					same++;
				else
					unsame++;
			String result = String.format("%.1f", (float)same/(set2.size() + unsame) * 100) + "%";
			System.out.println(result);
		}
		long endTime1=System.nanoTime(); //获取结束时间  
		System.out.println("程序运行时间： "+(endTime1-startTime1)+"ns");
		scaner.close();
		

	}
	
	static int intersect(Set<Integer> set1 , Set<Integer> set2) {
		Set<Integer> result = new HashSet<>(set1);
		result.retainAll(set2);
		return result.size();
	}
	
	static int join(Set<Integer> set1 , Set<Integer> set2) {
		Set<Integer> result = new HashSet<>(set1);
		result.addAll(set2);
		return result.size();
	}

}
