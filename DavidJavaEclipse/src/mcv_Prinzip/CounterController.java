package mcv_Prinzip;

	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	public class CounterController {
	    private CounterModel model;
	    private CounterView view;

	    public CounterController(CounterModel model, CounterView view) {
	        this.model = model;
	        this.view = view;

	        view.getButton().addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                model.increase();
	                view.setLabelText("Zahl: " + model.getValue());
	            }
	        });
	    }
	}

