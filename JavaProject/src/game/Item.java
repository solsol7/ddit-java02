package game;

import java.util.Random;

public class Item {
	String name;		//������ ��
	int maxHp;
	int maxMp;
	int att;
	int def;
	int fishing;
	int maxFatigue;
	int day;			//���� �� ������ ����
	
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
			info += " : ü�� +" + this.maxHp;
		if(this.maxMp > 0) 
			info+= " : ���� +" + this.maxMp;
		if(this.att > 0)
			info+= " : ���ݷ� +" + this.att;
		if(this.def > 0)
			info+= " : ���� +" + this.def;
		if(this.fishing > 0)
			info += " : ���ü��õ� +" +  this.fishing;
		if(this.maxFatigue > 0)
			info += " : �Ƿε� +" + this.maxFatigue;
		return info;
	}

	
}
