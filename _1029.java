package PATFoo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 本题考查设计程序考虑运行时间
 * 用两个队列存储数列
 * 因为两队列都是按照顺序存储的，所以当两队列从队列推出一定数量的元素时
 *  两队列头部的最小元素便是所要查找的值
 */

public class _1029 {

	public static void main(String[] args) {
		Queue<Integer> num = new LinkedList<Integer>();
		Queue<Integer> num1 = new LinkedList<Integer>();
		Scanner scaner = new Scanner(System.in);
		int temp1 = scaner.nextInt();
		for(int i = 0 ; i < temp1 ; i++) {
			num.add(scaner.nextInt());
		}
		num.add(Integer.MAX_VALUE);
		scaner.nextLine();
		int temp2 = scaner.nextInt();
		int bound = (temp1 + temp2 - 1)/2;
		int current = 0;
		for(int i = 0 ; i < temp2 ; i++) {
			int temp = scaner.nextInt();
			num1.add(temp);
			current++;
			if(num.peek() >= num1.peek())
				num1.remove();
			else{
				num.remove();
			}
			if(current == bound) {
				System.out.println(Math.min(num.remove(), num1.remove()));
			}
		}
		num1.add(Integer.MAX_VALUE);
		scaner.close();
		if(current < bound) {
			for(int i = current ; i < bound ; i++) {
				if(num.peek() < num1.peek())    
		            num.remove();
		        else                         
		            num1.remove();
			}
			System.out.println(Math.min(num.remove(), num1.remove()));
		}
	}

}
