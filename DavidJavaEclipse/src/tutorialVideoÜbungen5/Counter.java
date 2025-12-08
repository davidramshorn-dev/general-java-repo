package tutorialVideoÜbungen5;

public class Counter extends Thread{
@Override
public void run() {
	try {
		Thread.sleep(400);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	for (int i=0; i<6;i++) {
		System.out.println(i+ " generated from t3");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
}
}
