package tutorialVideoÜbungen3;

public class Thread2 implements Runnable{

	@Override
	public void run() {
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i=1;i<6;i++) {
			System.out.println((i)*2-1);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
