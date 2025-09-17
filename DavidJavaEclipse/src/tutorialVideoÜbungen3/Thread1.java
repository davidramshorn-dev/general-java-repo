package tutorialVideoÜbungen3;

public class Thread1 implements Runnable{

	@Override
	public void run() {
		for (int i=0;i<6;i++) {
			System.out.println((i)*2);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
