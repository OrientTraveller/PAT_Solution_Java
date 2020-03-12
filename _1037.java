package PATFoo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class _1037 {

	public static void main(String[] args) {
		LinkedList<Integer> coupon = new LinkedList<>();
		LinkedList<Integer> product = new LinkedList<>();
		Scanner scaner = new Scanner(System.in);
		int couponNum = scaner.nextInt();
		scaner.nextLine();
		for (int i = 0; i < couponNum; i++) {
			coupon.add(scaner.nextInt());
		}
		scaner.nextLine();
		int productNum = scaner.nextInt();
		scaner.nextLine();
		for (int i = 0; i < productNum; i++) {
			product.add(scaner.nextInt());
		}
		scaner.close();
		Collections.sort(coupon);
		Collections.sort(product);
		int round = Math.min(coupon.size(), product.size());
		long total = 0;
		for (int i = 0; i < round; i++) {
			if (coupon.peek() < 0 && product.peek() < 0)
				total += coupon.remove() * product.remove();
			else
				break;
		}
		round = Math.min(coupon.size(), product.size());
		for (int i = 0; i < round; i++) {
			if (coupon.peekLast() > 0 && product.peekLast() > 0)
				total += coupon.removeLast() * product.removeLast();
			else
				break;
		}
		System.out.println(total);

	}

}
