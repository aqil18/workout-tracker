package ui.gui.workout;

import model.Workout;
import model.WorkoutCollection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//GUI for adding a workout.
public class AddWorkoutUi extends JFrame {
    private JTextField nameField;
    private JButton addButton;
    private JPanel addPanel;
    private JSpinner ratingSpinner;
    SpinnerNumberModel spinner = (SpinnerNumberModel) ratingSpinner.getModel();

    WorkoutCollection collection;
    WorkoutUi homeFrame;

    private static final int MAX_RATING = 5;
    private static final int MIN_RATING = 0;
    private static final int STEP_RATING = 1;

    //EFFECTS - Sets up the AddWorkout GUI
    public AddWorkoutUi(WorkoutCollection collection, WorkoutUi homeFrame) {
        this.collection = collection;
        this.homeFrame = homeFrame;

        setContentPane(addPanel);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        spinner.setMinimum(MIN_RATING);
        spinner.setMaximum(MAX_RATING);
        spinner.setStepSize(STEP_RATING);

        addListener();
    }

    //EFFECTS - Creates a listener for the add button in the GUI.
    public void addListener() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                int rating = (int) spinner.getNumber();
                Workout workout = new Workout(name, rating);
                collection.addWorkout(workout);
                dispose();
                homeFrame.setVisible(true);
            }
        });
    }

}
