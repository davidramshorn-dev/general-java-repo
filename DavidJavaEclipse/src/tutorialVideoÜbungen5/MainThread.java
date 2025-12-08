package tutorialVideoÜbungen5;

public class MainThread {

	public static void main(String[] args) {
		Thread thread1=new Thread(()->{   //Thread bekommt functionalInterface mit run Funktion; in Lambda Form
			for (int i=0; i<6;i++) {
			System.out.println(i+ " generated from t1");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
			});
		Thread thread2=new Thread(new Runnable(){   //Thread bekommt functionalInterface mit run Funktion;

			@Override
			public void run() {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for (int i=0; i<6;i++) {
					System.out.println(i+ " generated from t2");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					}
				
			}
			
		}
				);
		Thread thread3=new Counter();  //Klasse erbt von Thread
		
		ThreadMaker threadMaker=new ThreadMaker();
		
		thread1.start();
		thread2.start();
		thread3.start();
		threadMaker.lassLaufen(()->{
			try {
				Thread.sleep(600);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (int i=0; i<6;i++) {
				System.out.println(i+ " generated from t4");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				}
		});
	}

}
