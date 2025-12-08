package tutorialVideoÜbungen5;

public class ThreadMaker {
public void lassLaufen(Runnable run) {
	Thread thread=new Thread(run);
	thread.start();
}
}
