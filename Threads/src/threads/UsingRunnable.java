// infinite thread using runnable interface

package threads;

class Th3 implements Runnable{
	public void run() {
		System.out.println("Hii");
	}
}

class Th4 implements Runnable{
	public void run() {
		System.out.println("Hello");
	}
}

public class UsingRunnable {

	public static void main(String[] args) {
	    Th3 t1 = new Th3();
	    Th4 t2 = new Th4();
	    
	    Thread p1 = new Thread(t1);            //using parametraized constructor 
	    Thread p2 = new Thread(t2);
	    
	    p1.start();
	    p2.start();
	}

}
