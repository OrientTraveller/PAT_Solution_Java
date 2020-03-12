package PATFoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _1007 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		int[] nums = new int[num];
		for(int i = 0 ; i < nums.length ; i++) {
			nums[i] = Integer.parseInt(str[i]);
		}
		cal(nums);
	}
	public static void cal(int[] nums) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		ArrayList<Integer> al1 = new ArrayList<Integer>();
		int sum = nums[0];
		int sum1 = 0;
		al.add(nums[0]);
		int current = 0;
		int current1 = 0;
		for(int i = 1 ; i < nums.length ; i++) {
			
			if(nums[i] > sum) {
				al.clear();
				al.add(nums[i]);
				sum = nums[i];
				current = i;
			}
			else if(nums[i] + sum > sum&&i == current + 1) {
				al.add(nums[i]);
				sum = sum + nums[i];
				current = i;
			}
			else;
			
			if(i != current + 1 && nums[i] > sum1) {
				al1.clear();
				al1.add(nums[i]);
				sum1 = nums[i];
				current1 = i;
			}
			else if(nums[i] + sum1 > sum1&&i == current1 +1) {
				al1.add(nums[i]);
			}
		}
		if(sum < 0) {
			System.out.println("0" + " " + nums[0] + " " + nums[nums.length-1]);
		}
	}
}
