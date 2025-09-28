package tiktaktoeExtended;

import javax.swing.SwingUtilities;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
		    e.printStackTrace(); // gibt dir dann die vollständige Herkunft im Stacktrace
		});
		TransparentButtonDemo2 view=new TransparentButtonDemo2();
		    SwingUtilities.invokeLater(() -> view.setVisible(true));
		Model model=new Model();
		Controller controller=new Controller(view, model);
	}
	}
