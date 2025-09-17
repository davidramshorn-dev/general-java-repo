package geschenkMama;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
		    e.printStackTrace(); // gibt dir dann die vollständige Herkunft im Stacktrace
		});
		View view=new View();
		Model model=new Model();
		Controller controller=new Controller(view, model);
	}
	}
