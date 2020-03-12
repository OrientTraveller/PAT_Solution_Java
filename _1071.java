package PATFoo;

/**
 * 特别注意！！！！！！！！！
 * 最重要的是～如果i已经到了最后一位，不管当前位是不是字母数字，都得将当前这个t放到map里面（只要t长度不为0）
 * @author SunFeiran
 *
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

/*
 * string s, t;
    getline(cin, s);
    map<string, int> m;
    for(int i = 0; i < s.length(); i++) {
        if(isalnum(s[i])) {
            s[i] = tolower(s[i]);
            t += s[i];
        }
        if(!isalnum(s[i]) || i == s.length() - 1){
            if(t.length() != 0) m[t]++;
            t = "";
        }
    }
    int maxn = 0;
    for(auto it = m.begin(); it != m.end(); it++) {
        if(it->second > maxn) {
            t = it->first;
            maxn = it->second;
        }
    }
    cout << t << " " << maxn;
 */

public class _1071 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		String str = scaner.nextLine();
		scaner.close();
		Map<String, Integer> map = new TreeMap<String, Integer>();
		String temp = "";
		for(int i = 0 ; i < str.length() ; i++) {
			char c = str.charAt(i);
			if(Character.isLetterOrDigit(c)) {
				temp = temp + Character.toLowerCase(c);
			}
			else {
				if(!temp.equals("")) {
					if(map.containsKey(temp)) {
						int value = map.get(temp) + 1;
						map.remove(temp);
						map.put(temp, value);
					}
					else
						map.put(temp, 1);
				}
				temp = "";
			}
			if(i == str.length() - 1) {
				if(!temp.equals("")) {
					if(map.containsKey(temp)) {
						int value = map.get(temp) + 1;
						map.remove(temp);
						map.put(temp, value);
					}
					else
						map.put(temp, 1);
				}
			}
		}
//		int max = 0;
//		String key = "";
//		for(String a : map.keySet()) {
//			if(map.get(a) > max) {
//				max = map.get(a);
//				key = a;
//			}
//			else if(map.get(a) == max) {
//				if(a.compareTo(key) < 0) {
//					key = a;
//				}
//			}
//		}
//		System.out.println(key + " " + max);
		//使用API进行比较
		ArrayList<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
	    Comparator<Map.Entry<String,Integer>> cmp = new Comparator<Map.Entry<String,Integer>>() {
			
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				int value1 = o1.getValue();
				int value2 = o2.getValue();
				if(value1 > value2)
					return -1;
				else if(value1 <value2)
					return 1;
				else{
					return o1.getKey().compareTo(o2.getKey());
				}
			}
		};
		Collections.sort(list, cmp);
		Map.Entry<String,Integer> result = list.get(0);
		System.out.println(result.getKey() + " " + result.getValue());
	}

}
