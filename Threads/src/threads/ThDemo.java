// infinite thread ( not syncronized (not thread safe))

package threads;
 
class Th1 extends Thread{
	public void run()
	{
		while(true)
		{
			System.out.println("Hello Indore");
		}
	}
}

class Th2 extends Thread{
	public void run()
	{
		while(true)
		{
			System.out.println("Hii India");
		}
	}
}

public class ThDemo {

	public static void main(String[] args) {
		Th1 t1 = new Th1();
		Th2 t2 = new Th2();
		
		t1.start();                 //t1 thread start
		t2.start();                 //t1 thread start
	}

}
