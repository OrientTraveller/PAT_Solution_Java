package PATFoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1008 {

	public static void main(String[] args) throws IOException {
		String[] str = null;
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine().split(" ");
		int[] des = new int[Integer.parseInt(str[0])];
		for(int i = 1 ; i < str.length ; i++) {
			des[i-1] = Integer.parseInt(str[i]);
		}
		int current = 0;
		int sum = 0 ;
		for(int i = 0 ; i < des.length ; i++) {
			if(des[i] > current)
				sum = sum + (des[i] - current) * 6 + 5;
			else if(des[i] < current)
				sum = sum + (current - des[i]) * 4 + 5;
			else
				sum = sum + 5; //假设两次相邻都是3层则停五秒
			current = des[i];
		}
		System.out.println(sum);
	}

}
