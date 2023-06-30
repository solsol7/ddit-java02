package game;

import java.util.Random;

public class Item {
	String name;		//아이템 명
	int maxHp;
	int maxMp;
	int att;
	int def;
	int fishing;
	int maxFatigue;
	int day;			//잠을 잘 때마다 증가
	
	public Item(String name, int maxHp, int maxMp, int att,
			int def, int fishing, int maxFatigue) {
		this.name = name;
		this.maxHp = maxHp;
		this.maxMp = maxMp;
		this.att = att;
		this.def = def;
		this.fishing = fishing;
		this.maxFatigue = maxFatigue;
		this.day = new Random().nextInt(10) +1;
	}
	
	public Item(String name) {
		this.name = name;
		this.maxHp = 0;
		this.maxMp = 0;
		this.att = 0;
		this.def = 0;
		this.fishing = 0;
		this.maxFatigue = 0;
		this.day = new Random().nextInt(10) + 1;
	}
	
	public String toString() {
		String info = this.name + " ";
		
		if(this.maxHp > 0) 
			info += " : 체력 +" + this.maxHp;
		if(this.maxMp > 0) 
			info+= " : 마나 +" + this.maxMp;
		if(this.att > 0)
			info+= " : 공격력 +" + this.att;
		if(this.def > 0)
			info+= " : 방어력 +" + this.def;
		if(this.fishing > 0)
			info += " : 낚시숙련도 +" +  this.fishing;
		if(this.maxFatigue > 0)
			info += " : 피로도 +" + this.maxFatigue;
		return info;
	}

	
}
