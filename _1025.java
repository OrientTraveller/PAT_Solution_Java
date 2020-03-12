package PATFoo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _1025 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int placeNum = scaner.nextInt();
		scaner.nextLine();
		ArrayList<ArrayList<Integer>> mark = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> totalMark = new ArrayList<Integer>();
		for(int i = 0 ; i < placeNum ; i++) {
			mark.add(new ArrayList<Integer>());
		}
		ArrayList<String> people = new ArrayList<String>();
		int totalPre = 999;
		int totalIndex = 0;
		int totalRank = 0;
		int[] pre = new int[placeNum];
		int[] index = new int[placeNum];
		int[] rank = new int[placeNum];
		for(int i = 0 ; i < placeNum ; i++) {
			pre[i] = 999;
			index[i] = 0;
			rank[i] = 0;
		}
		int totalNum = 0;
		for(int i = 0 ; i < placeNum ; i++) {
			int thisNum = scaner.nextInt();
			totalNum = totalNum + thisNum;
			scaner.nextLine();
			for(int j = 0 ; j < thisNum ; j++) {
				String[] str = scaner.nextLine().split(" ");
				int tempmark = Integer.parseInt(str[1]);
				totalMark.add(tempmark);
				mark.get(i).add(tempmark);
				if(str[1].equals("100"))
					str[1] = "999";
				String temppeople = str[0] + " " + String.valueOf(i+1) + " " + str[1];
				people.add(temppeople);
			}
		}
		scaner.close();
		boolean[] flag = new boolean[people.size()];
		for(int i = 0 ; i < flag.length ; i++) {
			flag[i] = false;
		}
		Collections.sort(people);
		Collections.sort(totalMark);
		Collections.reverse(totalMark);
		for(int i = 0 ; i < mark.size() ; i++) {
			Collections.sort(mark.get(i));
			Collections.reverse(mark.get(i));
		}
		System.out.println(totalNum);
		for(int i = 0 ; i < totalMark.size() ; i++) {
			for(int j = 0 ; j < people.size() ; j++) {
				if(flag[j] == false) {
					String[] thispeople = people.get(j).split(" ");//0学号 1地点 2成绩
					if(thispeople[2].equals("999"))
						thispeople[2] = "100";
					if(totalMark.get(i) == Integer.valueOf(thispeople[2])) {
						totalIndex++;
						if(totalMark.get(i)<totalPre) {
							totalPre = totalMark.get(i);
							totalRank = totalIndex;
						}
						else if(totalMark.get(i) == totalPre) {
						}
						int placeindex = Integer.valueOf(thispeople[1]) - 1;
						index[placeindex]++;
						if(totalMark.get(i)<pre[placeindex]) {
							pre[placeindex] = totalMark.get(i);
							rank[placeindex] = index[placeindex];
						}
						else if(totalMark.get(i) == totalPre) {
						}
						flag[j] = true;
						System.out.println(thispeople[0] + " " + totalRank + " " + thispeople[1] + " " + rank[placeindex]);
					}
				}
				
				
//				if(mark.get(placeindex).get(j) == Integer.valueOf(thispeople[2])) {
//					index[placeindex]++;
//					if(totalMark.get(i)<totalPre) {
//						totalPre = totalMark.get(i);
//						totalRank = totalIndex;
//					}
//					else if(totalMark.get(i) == totalPre) {
//					}
//				}
			}
		}

	}

}
