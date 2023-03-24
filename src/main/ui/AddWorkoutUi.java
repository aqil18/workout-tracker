package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddWorkoutUi extends JFrame {
    private JTextField nameField;
    private JTextField ratingField;
    private JButton addButton;
    private JPanel addPanel;

    public AddWorkoutUi() {
        setContentPane(addPanel);
        setSize(500, 500);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String rating = ratingField.getText();

            }
        });
    }

}
