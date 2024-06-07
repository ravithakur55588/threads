//program showing thread safe condition(synchronized)
package threads;

class Bank1 {
	int bal = 0;

	synchronized void depo() {
		bal = bal + 100;
	}

	synchronized void widl() {
		bal = bal - 100;
	}
}

class Th7 extends Thread {
	Bank1 b1;

	public void run() {
		for (long i = 0; i <= 10000000; i++) {
			b1.depo();
		}
	}
}

class Th8 extends Thread {
	Bank1 b2;

	public void run() {
		for (long i = 0; i <= 10000000; i++) {
			b2.widl();
		}
	}
}

public class SyncronizedMain {
	public static void main(String str[]) {
		Bank1 bank = new Bank1();
		Th7 t1 = new Th7();
		Th8 t2 = new Th8();

		t1.b1 = bank;
		t2.b2 = bank;

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (Exception ee) {
			System.out.println(ee);
		}

		System.out.println("Balance = " + bank.bal);
	}
}