package PATFoo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class _1062 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int round = scaner.nextInt();
		int low = scaner.nextInt();
		int high = scaner.nextInt();
		ArrayList<People> sages = new ArrayList<People>();
		ArrayList<People> noblemen = new ArrayList<People>();
		ArrayList<People> foolmen = new ArrayList<People>();
		ArrayList<People> smallmen = new ArrayList<People>();
		int sum = 0;
		for(int i = 0 ; i < round ; i++) {
			int id = scaner.nextInt();
			int virtue = scaner.nextInt();
			int talent = scaner.nextInt();
			if(talent>=low&&virtue>=low) {
				sum++;
				if(talent>=high&&virtue>=high) {
					sages.add(new People(id,talent,virtue));
				}
				else if(talent<high&&virtue>=high) {
					noblemen.add(new People(id,talent,virtue));
				}
				else if(talent<high&&virtue<high&&virtue>=talent) {
					foolmen.add(new People(id,talent,virtue));
				}
				else {
					smallmen.add(new People(id,talent,virtue));
				}
			}
		}
		scaner.close();
		Comparator<People> cmp = new Comparator<People>() {
			
			@Override
			public int compare(People o1, People o2) {
				int temp1 = (o1.getTalent() + o1.getVirtue())/2;
				int temp2 = (o2.getTalent() + o2.getVirtue())/2;
				if(temp1 > temp2)
					return -1;
				else if(temp1 < temp2)
					return 1;
				else {
					if(o1.getVirtue() > o2.getVirtue())
						return -1;
					else if(o1.getVirtue() < o2.getVirtue())
						return 1;
					else {
						if(o1.getId() < o2.getId())
							return -1;
						else
							return 1;
					}
				}
			}
		};
		Collections.sort(sages,cmp);
		Collections.sort(noblemen,cmp);
		Collections.sort(foolmen,cmp);
		Collections.sort(smallmen,cmp);
		System.out.println(sum);
		for(People p : sages)
			System.out.println(p.getId() + " " + p.getVirtue() + " " + p.getTalent());
		for(People p : noblemen)
			System.out.println(p.getId() + " " + p.getVirtue() + " " + p.getTalent());
		for(People p : foolmen)
			System.out.println(p.getId() + " " + p.getVirtue() + " " + p.getTalent());
		for(People p : smallmen)
			System.out.println(p.getId() + " " + p.getVirtue() + " " + p.getTalent());
	}

}

class People{
	private int id;
	private int talent;
	private int virtue;
	public People(int id , int talent , int virtue) {
		this.id = id;
		this.talent = talent;
		this.virtue = virtue;
	}
	public int getId() {
		return id;
	}
	public int getTalent() {
		return talent;
	}
	public int getVirtue() {
		return virtue;
	}
}


