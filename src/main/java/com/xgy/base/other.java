package com.xgy.base;

public class other {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Checket c2 = new Checket();
		City c = new City();
		c.value();
	}

}

class Base {
	Base() {
		System.out.println("Base");
	}
}

class Checket extends Base {
	Checket() {
		// super();//���ø���Ĺ��췽����һ��Ҫ���ڷ������׸����
		System.out.println("Checket");
	}
	
}

	class Country {
		String name;

		void value() {
			name = "China";
		}
	}

	class City extends Country {
		String name;

		void value() 
		{
			name = "Hefei";
			super.value();// �����ô˷���ʱ��super.name���ص��Ǹ���ĳ�Ա������ֵnull
			System.out.println(name);
			System.out.println(super.name);
		}

	}


