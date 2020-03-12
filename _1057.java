package PATFoo;

import java.util.Scanner;
import java.util.Stack;

/**
 * 树状数组，查询和修改复杂度都为log(n)
 * @author SunFeiran
 *
 */

public class _1057 {
	
	static int[] num;
	static Stack<Integer> stack;
	
	//lowBit函数实际上是计算2^k
	private static int lowBit(int k){
        return k&-k;
    }
	
	//查询函数
	static int getSum(int k) {
		int sum=0;
		for(int i=k;i>0;i-=lowBit(i)){
			sum+=num[i];
		}
		return sum;
	}
	
	//修改函数
	static void update(int k,int value) {
		for(int i=k;i<=100004;i+=lowBit(i)){
			num[i]+=value;
		}
	}
	
	static void mid(int index) {
		int l=1;
		int r=100004;
		int k=(stack.size()+1)/2;
		while(l<r)
		{
			int mid=(l+r)/2;
			if(getSum(mid)>=k)
				r=mid;
			else
				l=mid+1;
		}
		System.out.println(l);
	}

	public static void main(String[] args) {
		stack = new Stack<>();
		num = new int[100005];
		Scanner scaner = new Scanner(System.in);
		int round = scaner.nextInt();
		scaner.nextLine();
		for(int i = 0 ; i < round ; i++) {
			String command = scaner.nextLine();
			if(command.contains("Push")) {
				int temp = Integer.parseInt(command.split(" ")[1]);
				stack.push(temp);
				for(int j = temp ; j <= 100004 ; j+=lowBit(j)) {
					num[j]++;
				}
			}
			else if(command.equals("Pop")) {
				if(!stack.isEmpty()) {
					int temp = stack.pop();
					System.out.println(temp);
					for(int j = temp ; j <= 100004 ; j+=lowBit(j)) {
						num[j]--;
					}
				}
				else
					System.out.println("Invalid");
			}
			else {
				if(!stack.isEmpty()) {
					int index = (int) Math.ceil((double)stack.size() / 2);
					mid(index);
				}
				else
					System.out.println("Invalid");
			}
		}
		scaner.close();
	}
}
