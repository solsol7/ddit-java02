package game;

public class Charactor {

	public static void main(String[] args) {

		}
	
}



class Character{
		String name;			//ĳ������ �̸�
		int maxHp;				//ĳ���� �ִ� HP
		int maxMp;				//ĳ���� �ִ� MP
		int hp;					//ĳ���� ���� HP
		int mp;					//ĳ���� ���� MP
		int att;				//ĳ���� ���ݷ�
		int def;				//ĳ���� ����
		int lv;					//ĳ���� ���� ����
		int exp;				//ĳ���� ���� ����ġ
		int nextExp;			//�������� ���� ���� ����ġ
		int money;				//ĳ���Ͱ� ������ �ִ� �ں�
		
		int maxFishing;			//���� �ִ� ���õ�
		int fishing;			//���� ���õ� ����
		int pointFishing;		//���� ����Ʈ
		int maxFatigue;			//ĳ���� �ִ� �Ƿε�
		int fatigue;			//���� ĳ���� �Ƿε�
		Item[] inven;			//ĳ���� �κ��丮
		int input;				//�Է�
		
		public Character(String name) {
			this.name=name;			//�̸� ����
			this.maxHp = 100;		//�ִ� HP 100
			this.hp = this.maxHp;	//���� HP 100
			this.maxMp = 50;		//�ִ� MP 50
			this.mp = this.maxMp;	//���� MP 50
			this.att = 200;			//���ݷ� 200
			this.def = 10;			//���� 10
			this.lv=1;				//���� ���� 1
			this.exp=0;				//���� ����ġ 0
			this.money = 500;		//���� �ں� 500
			this.nextExp = (this.lv * 100);		//���� ���������� �޼��ؾ� �� ����ġ
			this.inven = new Item[0];			//�⺻���� �κ��丮 ����
			
			this.fishing = 1;					//���� ���� 1
			this.maxFishing = (this.fishing * 10);
			
			this.maxFatigue = 300;				//�ִ� �Ƿε� 300
			this.fatigue = this.maxFatigue;		//���� �ǵ��� 300
		}
		
		//ĳ���� ������ Ȯ��(ĳ���Ϳ� ���õ� ���� ������ Ȯ���� �� �ִ�.)
		public void showInfo() {
			System.out.println("---- ����----");
			System.out.printf("��  �� : %s\n", this.name);
			System.out.printf("��  �� : %d\n", this.lv);
			System.out.printf("�ൿ�� : %d / %d\n", this.fatigue, this.maxFatigue);
			System.out.printf("ü  �� : %d / %d\n", this.hp, this.maxHp);
			System.out.printf("��  �� : %d / %d\n", this.mp, this.maxMp);
			System.out.printf("��  �� : %d\n", this.att);
			System.out.printf("��  �� : %d\n", this.def);
			System.out.printf("����ġ : %d / %d\n", this.exp, this.nextExp);
			System.out.println("---���----");
			System.out.printf("��  �� : %d (point:%d)\n", this.fishing, this.pointFishing);
			System.out.println("----������----");
			System.out.printf("��  �� : %d\n", this.money);
			for(int i=0; i<inven.length; i++) {
				System.out.println(this.inven[i] + " ");
				if((i+1) % 5 == 0) {		//�κ��丮 ��� 5���� ����
					System.out.println();
				}
			}
			System.out.println();
			System.out.println("----------------------\n");
		}
		
		//���͸� �����Ѵ�.
		public void attack(Monster m) {
			int damage = this.att - m.def;	//ĳ���� ���ݷ� - ���� ����(������)
			
			//���Ϳ� �������� ���µ� 0�� ���� ���� ���� �������� ��� 1�� ����
			//�׷��� ���� ��쿣 ���� �������� ����
			damage = damage <= 0 ? 1 : damage;
			m.hp -=damage;		//���� HP - ������
			m.hp = m.hp < 0 ? 0: m.hp;
			
			//���� ��, ���� ���
			System.out.printf("%s(��)�� �������� %s���� %s��ŭ �������� �־����ϴ�.\n",
								this.name, m.name, damage);
			System.out.printf("%s�� ���� ü���� HP : %d\n", m.name, m.hp);
			System.out.println();
			
		}
		
		//ĳ���� ����ġ ���
		public void getExp(int exp) {
			System.out.println(exp + "�� ����ġ�� ȹ���Ͽ����ϴ�\n");
			
			this.exp += exp;
			while(this.exp >= this.nextExp) {
				//���� ����ġ - ���� �������� �ʿ��� ����ġ(������ �� ���� ����ġ)
				this.exp -= this.nextExp;
				levelUP();		//������
			}
			
		}
		
		public void levelUP() {
			this.lv++;
			this.maxHp += 20;
			this.hp = this.maxHp;
			this.maxMp += 10;
			this.mp = this.maxMp;
			this.att +=10;
			this.def +=10;
			this.nextExp = (this.lv * 100);
			this.maxFishing = (this.fishing * 100);
			System.out.println("LEVEL UP!!!");
		}
		
		public void getItem()
}