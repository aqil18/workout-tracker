package ui.gui;

import model.Workout;
import model.WorkoutCollection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddWorkoutUi extends JFrame {
    private JTextField nameField;
    private JTextField ratingField;
    private JButton addButton;
    private JPanel addPanel;

    WorkoutCollection collection;
    HomeUi homeFrame;

    public AddWorkoutUi(WorkoutCollection collection, HomeUi homeFrame) {
        this.collection = collection;
        this.homeFrame = homeFrame;
        setContentPane(addPanel);
        setSize(500, 500);

        addListener();



    }

    public void addListener() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                int rating = Integer.parseInt(ratingField.getText());
                Workout workout = new Workout(name, rating);
                collection.addWorkout(workout);
                dispose();
                homeFrame.setVisible(true);
            }
        });
    }

}
