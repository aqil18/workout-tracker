package ui.gui;

import model.Workout;
import model.WorkoutCollection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddExerciseUi extends JFrame {
    private JPanel addExercisePanel;
    private JTextField nameField;
    private JSpinner repsSpinner;
    private JSpinner weightSpinner;
    private JSpinner timeSpinner;
    SpinnerNumberModel reps = (SpinnerNumberModel) repsSpinner.getModel();
    SpinnerNumberModel weight = (SpinnerNumberModel) weightSpinner.getModel();
    SpinnerNumberModel time = (SpinnerNumberModel) timeSpinner.getModel();
    private JComboBox typeComboBox;
    DefaultComboBoxModel<String> type = (DefaultComboBoxModel<String>) typeComboBox.getModel();
    private JButton addButton;




    Workout workout;
    HomeUi homeFrame;

    private static final int MIN_INPUT = 0;
    private static final String[] TYPES = {"Weighted", "Timed"};


    public AddExerciseUi(Workout workout, HomeUi homeFrame) {
        this.workout = workout;
        this.homeFrame = homeFrame;
        setContentPane(addExercisePanel);
        setSize(500, 500);


        reps.setMinimum(MIN_INPUT);
        weight.setMinimum(MIN_INPUT);
        time.setMinimum(MIN_INPUT);

        addListener();


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);





    }


    public void addListener() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();

                if ()

                Workout workout = new Workout(name, rating);
                collection.addWorkout(workout);
                dispose();
                homeFrame.setVisible(true);
            }
        });
    }

}
