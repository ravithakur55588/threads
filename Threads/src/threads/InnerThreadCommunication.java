//program showing concept of inner thread communication (use of wait(),
//notify() or notifyAll().
package threads;

class Bank2 {
	int bal = 0;

	synchronized void depo() {
		if (bal < 100) {
			bal = bal + 10;
		} else {
			try {
				notifyAll();
				wait();
			} catch (Exception ee) {
				System.out.println(ee);
			}
		}

	}

	synchronized void with() {
		if (bal > 10) {
			bal = bal - 10;
		} else {
			try {
				notifyAll();
				wait();
			} catch (Exception ee) {
				System.out.println(ee);
			}
		}

	}

}

class Th11 extends Thread {
	Bank2 b1;

	public void run() {
		while (true) {
			b1.depo();
			System.out.println(b1.bal);
		}
	}
}

class Th12 extends Thread {
	Bank2 b2;

	public void run() {
		while (true) {
			b2.with();
			System.out.println(b2.bal);
		}
	}
}

public class InnerThreadCommunication {
	public static void main(String[] args) {
		Bank2 bk = new Bank2();
		Th11 t1 = new Th11();
		Th12 t2 = new Th12();
		
		t1.b1 = bk;
		t2.b2 = bk;
		
		t1.start();
		t2.start();
	}
}
