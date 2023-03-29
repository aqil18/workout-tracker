package ui.gui.exercise;

import exceptions.NonPositiveException;
import model.Exercise;
import model.TimedExercise;
import model.WeightedExercise;
import model.Workout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//GUI for adding an exercise.
public class AddExerciseUi extends JFrame {
    private JPanel addExercisePanel;
    private JTextField nameField;
    private JSpinner repsSpinner;
    private JSpinner weightSpinner;
    private JSpinner timeSpinner;
    SpinnerNumberModel reps = (SpinnerNumberModel) repsSpinner.getModel();
    SpinnerNumberModel weight = (SpinnerNumberModel) weightSpinner.getModel();
    SpinnerNumberModel time = (SpinnerNumberModel) timeSpinner.getModel();
    private JRadioButton weightedButton;
    private JRadioButton timedButton;
    private JButton addButton;
    ButtonGroup buttonGroup = new ButtonGroup();

    Workout workout;
    ExerciseUi homeFrame;

    private static final int MIN_INPUT = 0;

    //EFFECTS - Sets up the AddExercise GUI.
    public AddExerciseUi(Workout workout, ExerciseUi homeFrame) {
        this.workout = workout;
        this.homeFrame = homeFrame;

        setContentPane(addExercisePanel);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        reps.setMinimum(MIN_INPUT);
        weight.setMinimum(MIN_INPUT);
        time.setMinimum(MIN_INPUT);

        buttonGroup.add(weightedButton);
        buttonGroup.add(timedButton);
        weightSpinner.setVisible(false);
        repsSpinner.setVisible(false);
        timeSpinner.setVisible(false);

        addListener();
        weightedListener();
        timedListener();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //EFFECTS - Adds all exercises as JLabels onto the GUI
    public void addListener() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                try {
                    if (weightedButton.isSelected()) {
                        int newWeight = (int) weight.getNumber();
                        int newReps = (int) reps.getNumber();
                        Exercise newEx = new WeightedExercise(name, newWeight, newReps);
                        workout.addExercise(newEx);
                    } else {
                        int newTime = (int) time.getNumber();
                        Exercise newEx = new TimedExercise(name, newTime);
                        workout.addExercise(newEx);
                    }
                } catch (NonPositiveException s) {
                    //
                }
                dispose();
                homeFrame.setVisible(true);
            }
        });
    }

    //EFFECTS - Creates a listener for the weighted radio button in the GUI and makes the corresponding text fields
    //          visible.
    public void weightedListener() {
        weightedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weightSpinner.setVisible(true);
                repsSpinner.setVisible(true);
                timeSpinner.setVisible(false);
            }
        });
    }

    //EFFECTS - Creates a listener for the timed radio button in the GUI and makes the corresponding text fields
    //          visible.
    public void timedListener() {
        timedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weightSpinner.setVisible(false);
                repsSpinner.setVisible(false);
                timeSpinner.setVisible(true);
            }
        });
    }



}
