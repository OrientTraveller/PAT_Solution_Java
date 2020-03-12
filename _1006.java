package PATFoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;

public class _1006 {
	
	static class Record{
		private String id;
		private String time;
		private boolean flag;//flase是入，true是出
		public Record(String id, String time, boolean flag) {
			this.id = id;
			this.time = time;
			this.flag = flag;
		}
		public boolean getFlag() {
			return flag;
		}
		public String getTime() {
			return time;
		}
		public String getID() {
			return id;
		}
	}

	public static void main(String[] args) throws IOException, ParseException {
		String[] str = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int personNum = Integer.parseInt(br.readLine());
		ArrayList<Record> al = new ArrayList<Record>();
		for(int i = 0 ; i < personNum ; i++) {
			str = br.readLine().split(" ");
			String id = str[0];
			String inTime = str[1];
			String outTime = str[2];
			if(inTime.compareTo(outTime) < 0) {
				boolean flag = true;
				for(int j = 0 ; j < al.size() ; j++) {
					if(al.get(j).getFlag() == true&&al.get(j).getTime().equals(outTime))
						flag = false;
					else if(al.get(j).getFlag() == false&&al.get(j).getTime().equals(inTime))
						flag = false;
					else;
				}
				if(flag == true) {
					al.add(new Record(id, inTime, false));
					al.add(new Record(id, outTime, true));
				}
			}
			else;
		}
		Record early = al.get(0);
		Record late = al.get(1);
		for(int i = 0 ; i < al.size() ; i++) {
			if(al.get(i).getFlag() == false && al.get(i).getTime().compareTo(early.getTime()) < 0)
				early = al.get(i);
			else if(al.get(i).getFlag() == true && al.get(i).getTime().compareTo(late.getTime()) > 0)
				late = al.get(i);
		}
		System.out.print(early.getID() + " " + late.getID());
	}

}
