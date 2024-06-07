//program showing not thread safe condition(not synchronized)
package threads;

class Bank{
	int bal = 0;
	
	void depo() {
		bal = bal+100;
	}
	
	void widl() {
		bal = bal-100;
	}
}

class Th5 extends Thread{
	Bank b1;
	
	public void run() {
		for(long i=0;i<=10000000;i++) {
			b1.depo();
		}
	}
}

class Th6 extends Thread{
	Bank b2;
	
	public void run() {
		for(long i=0;i<=10000000;i++) {
			b2.widl();
		}
	}
}

class ThreadDemo{
	public static void main(String str[]) {
		Bank bk = new Bank();
		Th5 t1 = new Th5();
		Th6 t2 = new Th6();
	
		t1.b1 = bk;
		t2.b2 = bk;
		
		t1.start();
		t2.start();
		
		try 
		{
			t1.join();
			t2.join();
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
		
		System.out.println("Balance = "+bk.bal);
	}
}