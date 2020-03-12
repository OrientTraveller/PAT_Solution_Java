package PATFoo;

import java.util.LinkedList;
import java.util.TreeMap;
import java.util.Scanner;

public class _1014 {

	public static class Customer {
		int id;
		int serviceTime;
		int serviceTimeCopy;
		int finishTime;
		public Customer(int id, int serviceTime) {
			this.id = id;
			this.serviceTime = serviceTime;
			this.serviceTimeCopy = serviceTime;
			this.finishTime = -1;
		}

	}

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int windowNum = scaner.nextInt();
		int waitNum = scaner.nextInt();
		int totalCustomerNum = scaner.nextInt();
		int checkCustomerNum = scaner.nextInt();
		LinkedList<Customer> customers = new LinkedList<Customer>();
		int[] checkCustomers = new int[checkCustomerNum];
		for (int i = 0; i < totalCustomerNum; i++) customers.add(new Customer(i + 1, scaner.nextInt()));
		for (int i = 0; i < checkCustomerNum; i++) checkCustomers[i] = scaner.nextInt();
		scaner.close();
		LinkedList<LinkedList<Customer>> bank = new LinkedList<LinkedList<Customer>>();
		TreeMap<Integer, Integer> serviced1 = new TreeMap<Integer, Integer>();
		int time = 0;
		for (int i = 0; i < windowNum; i++) bank.add(new LinkedList<Customer>());

		// 初始化队列，将队列最大限度的填满顾客
		int index = 0;
		int flag = 0;
		while (customers.size() > 0) {
			if (index == 0) flag = 0;
			if (bank.get(index).size() < waitNum) {
				Customer temp = customers.remove();
				bank.get(index).add(temp);
			} else {
				flag++;
				if (flag == windowNum)
					break;
			}
			if (index == windowNum - 1) index = 0;
			else index++;
		}

		// 开始模拟顾客进出
		while (serviced1.size() < totalCustomerNum) {
			//寻找最小的剩余服务时间
			int minTime = Integer.MAX_VALUE;
			int minIndex = Integer.MAX_VALUE;
			for (int i = 0; i < windowNum; i++)
				if (bank.get(i).size() > 0 && bank.get(i).peek().serviceTime < minTime) {
					minTime = bank.get(i).peek().serviceTime;
					minIndex = i;
				}
			if (minIndex == Integer.MAX_VALUE) break;
			//根据选出的最小剩余服务时间修改总时间
			time += minTime;
			int id = bank.get(minIndex).remove().id;
			int finishTime = time;
			serviced1.put(id, finishTime);
			for (int i = 0; i < windowNum; i++)
				if (i != minIndex && bank.get(i).size() > 0) {
					Customer c = bank.get(i).remove();
					c.serviceTime -= minTime;
					bank.get(i).addFirst(c);
				}
			/*
			 * 当时间到下午五点及以后，对每个窗口进行清空处理
			 * 清空规则：
			 * 1.若队列第一个客户已经开始服务，则将其后面的顾客清除
			 * 2.若队列第一个顾客没有被服务，则队列清空
			 * 且清空工作只需要做一次
			 */
			boolean clearFlag = true; // 保证清空工作只做一次的守卫值
			if (time >= 540 && clearFlag) {
				for (int i = 0; i < windowNum; i++)
					if (bank.get(i).size() > 0 && bank.get(i).peek().serviceTime == bank.get(i).peek().serviceTimeCopy)
						bank.get(i).clear();
					else if (bank.get(i).size() > 1 && bank.get(i).peek().serviceTime < bank.get(i).peek().serviceTimeCopy)
						bank.get(i).removeLast();
				clearFlag = false;
			}
			//在五点之前才允许顾客进入队列
			if (time < 540 && customers.size() > 0)
				bank.get(minIndex).add(customers.remove());
		}

		// 输出结果
		for (int i : checkCustomers)
			if (serviced1.containsKey(i))
				System.out.println(String.format("%02d", 8 + serviced1.get(i) / 60) + ":" + String.format("%02d", serviced1.get(i) % 60));
			else
				System.out.println("Sorry");
	}
}
