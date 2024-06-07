//program showing DeadLock condition.
/* Dead Lock can be avoided by, if a synchronized method of a class will not
   invoke another synchronized method of other class.
*/
package threads;

class FirstDemo {
	SecDemo s1;

	synchronized void m1() {
		System.out.println("I am m1");
		s1.m4();
	}

	synchronized void m2() {
		System.out.println("I am m2");
	}
}

class SecDemo {
	FirstDemo f1;

	synchronized void m3() {
		System.out.println("I am m3");
		f1.m2();
	}

	synchronized void m4() {
		System.out.println("I am m4");
	}
}

class Th9 extends Thread {
	FirstDemo f2;

	public void run() {
		while (true) {
			f2.m1();
		}
	}
}

class Th10 extends Thread {
	SecDemo s2;

	public void run() {
		while (true) {
			s2.m3();
		}
	}
}

public class DeadLockMain {
	public static void main(String[] args) {
		FirstDemo fst = new FirstDemo();   //object/instance creation
		SecDemo sec = new SecDemo();
		
		Th9 t1 = new Th9();
		Th10 t2 = new Th10();
		
		fst.s1 = sec;             //memory allocation
		sec.f1 = fst;
		
		t1.f2 = fst;
		t2.s2 = sec;
		
		t1.start();              //thread start
		t2.start();
	}
}
