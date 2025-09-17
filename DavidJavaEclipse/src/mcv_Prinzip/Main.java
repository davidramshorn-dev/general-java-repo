package mcv_Prinzip;

public class Main {
	    public static void main(String[] args) {
	        CounterModel model = new CounterModel();
	        CounterView view = new CounterView();
	        CounterController controller = new CounterController(model, view);
	    }
}
