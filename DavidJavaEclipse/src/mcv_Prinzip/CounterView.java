package mcv_Prinzip;

import javax.swing.*;
import java.awt.*;

public class CounterView {
    private JFrame frame;
    private JButton button;
    private JLabel label;

    public CounterView() {
        frame = new JFrame("MVC Counter");
        button = new JButton("Erhöhen");
        label = new JLabel("Zahl: 0", SwingConstants.CENTER);

        frame.setLayout(new BorderLayout());
        frame.add(label, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);

        frame.setSize(200, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void setLabelText(String text) {
        label.setText(text);
    }

    public JButton getButton() {
        return button;
    }
}

