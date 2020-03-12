package PATFoo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 注意在计算排序次数的时候要使用链表内节点个数而不是题目给的节点个数，因为有些节点不在链表内
 * @author SunFeiran
 *
 */
public class _1074 {

	static class Node {
		String index;
		int key;
		String next;
		public Node(String index, int key, String next) {
			this.index = index;
			this.key = key;
			this.next = next;
		}
	}
	
	public static void main(String[] args) {
		LinkedList<Node> ori = new LinkedList<Node>();
		LinkedList<Node> sort = new LinkedList<Node>();
		Scanner scaner = new Scanner(System.in);
		String start = scaner.next();
		int num = scaner.nextInt();
		int sortNum = scaner.nextInt();
		for(int i = 0 ; i < num ; i++) {
			String index = scaner.next();
			int key = scaner.nextInt();
			String next = scaner.next();
			ori.add(new Node(index, key, next));
		}
		scaner.close();
		for(int i = 0 ; i < num ; i++) {
			for(int j = 0 ; j < ori.size() ; j++) {
				if(ori.get(j).index.equals(start)) {
					sort.add(ori.get(j));
					start = ori.get(j).next;
					ori.remove(j);
					break;
				}
			}
		}
		ori.clear();
		int sortTime = sort.size()/sortNum;
		for(int i = 0 ; i < sortTime ; i++) {
			LinkedList<Node> temp = new LinkedList<Node>();
			for(int j = 0 ; j < sortNum ; j++) {
				temp.add(sort.pop());
			}
			Collections.reverse(temp);
			ori.addAll(temp);
		}
		ori.addAll(sort);
		for(int i = 0 ; i < ori.size() ; i++) {
			if(i < ori.size() - 1)
				System.out.println(ori.get(i).index + " " + ori.get(i).key + " " + ori.get(i + 1).index);
			else
				System.out.println(ori.get(i).index + " " + ori.get(i).key + " -1");
		}
	}

}
