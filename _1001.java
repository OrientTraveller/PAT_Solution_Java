package PATFoo;

import java.io.*;

public class _1001 {
	/*
	 * 提交的时候将类名改为public class Main {
	 */
	
	public static void cal() throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = buffer.readLine().split(" ");
		int a = Integer.parseInt(strArr[0]);
		int b = Integer.parseInt(strArr[1]);
		char[] result = String.valueOf(a + b).toCharArray();
		if(result.length>3) {
			for(int i = 0;i<result.length;i++) {
				if((result.length-(i+1))%3==0&&i!=result.length-1&&result[i]!='-') {
					System.out.print(result[i]);
					System.out.print(",");
				}else {
					System.out.print(result[i]);
				}
			}
		}else {
			for(int i=0;i<result.length;i++)
				System.out.print(result[i]);
		}
	}

	public static void main(String[] args) throws IOException {
		cal();

	}

}
