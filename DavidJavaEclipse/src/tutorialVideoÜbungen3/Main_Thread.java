package tutorialVideoÜbungen3;

public class Main_Thread {

	public static void main(String[] args) {
		Runnable runnable1=new Thread1();
		Runnable runnable2=new Thread2();
		Thread thread=new Thread(runnable1);
		Thread thread2=new Thread(runnable2);
		thread.start();
		thread2.start();
		ThreadMaker.lassImHintergrundLaufen(() -> {try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} for (int i=0; i<100; i++) {System.out.println(i);}
	});

}}
