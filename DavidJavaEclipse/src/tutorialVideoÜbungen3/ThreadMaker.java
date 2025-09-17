package tutorialVideoÜbungen3;

public class ThreadMaker {
public static void lassImHintergrundLaufen(Runnable runnable) {
	Thread thread =new Thread(runnable);
	thread.start();
}
}
