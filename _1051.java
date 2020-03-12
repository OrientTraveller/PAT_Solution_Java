package PATFoo;

import java.util.Scanner;
import java.util.Stack;

public class _1051 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int capacity = scaner.nextInt();
		int num = scaner.nextInt();
		int round = scaner.nextInt();
		scaner.nextLine();
		Stack<Integer> stack = new Stack<Integer>(); 
		for(int i = 0 ; i < round ; i++) {
			stack.clear();
			int currentPush = 2;
			String[] str = scaner.nextLine().split(" ");
			int point = 0;
			stack.push(1);
			while(true) {
				int temp = Integer.parseInt(str[point]);
				if(stack.isEmpty()) {
					stack.push(currentPush);
					currentPush++;
				}
				if(!stack.isEmpty()&&stack.peek() == temp) {
					stack.pop();
					point++;
					if(point == num)
						break;
					continue;
				}
				if(!stack.isEmpty()&&stack.peek() != temp&&stack.size() < capacity) {
					stack.push(currentPush);
					currentPush++;
				}
				if((!stack.isEmpty()&&stack.peek() != temp && currentPush > num )||(stack.size() == capacity&&stack.peek() != temp))
					break;
			}
			if(!stack.isEmpty())
				System.out.println("NO");
			else
				System.out.println("YES");
		}
		scaner.close();

	}

}
