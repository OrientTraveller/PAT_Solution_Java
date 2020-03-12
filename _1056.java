package PATFoo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class _1056 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int num = scaner.nextInt();
		int[] weight = new int[num];
		Map<Integer, Integer> weight_index = new TreeMap<Integer, Integer>();
		int group = scaner.nextInt();
		for (int i = 0; i < num; i++) {
			int tempWeight = scaner.nextInt();
			weight[i] = tempWeight;
			weight_index.put(tempWeight, i);
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		ArrayList<Integer> sort = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			queue.add(scaner.nextInt());
		}
		scaner.close();
		while (!queue.isEmpty()) {
			int groupNum = (int) Math.ceil((double) num / group);
			int rank = groupNum + 1;
			if(queue.size() == 1) {
				weight[queue.remove()] = 1;
			}
			else {
				for (int i = 0; i < groupNum; i++) {
					sort.clear();
					int tempGroup = group;
					if (num % group != 0 && i == groupNum - 1) {
						tempGroup = num % group;
					}
					int[] temp = new int[tempGroup];
					for (int j = 0; j < tempGroup; j++) {
						int head = queue.remove();
						temp[j] = head;
						sort.add(weight[head]);
					}
					Collections.sort(sort);
					int index = weight_index.get(sort.get(tempGroup - 1));
					queue.add(index);
					for (int j = 0; j < tempGroup; j++) {
						if (temp[j] != index)
							weight[temp[j]] = rank;
					}
				}
				num = groupNum;
			}
		}
		String result = "";
		for (int i : weight)
			result += i + " ";
		System.out.println(result.trim());
	}
}
