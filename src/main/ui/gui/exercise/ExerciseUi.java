package ui.gui.exercise;

import model.Workout;
import ui.gui.workout.WorkoutUi;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExerciseUi extends JFrame {
    private JButton closeButton;
    private JButton addButton;
    private JButton deleteButton;
    private JButton viewButton;

    Workout workout;
    private ExerciseUi currentFrame;
    private WorkoutUi homeFrame;

    public ExerciseUi(Workout workout, WorkoutUi homeFrame) {
        this.currentFrame = this;
        this.workout = workout;
        this.homeFrame = homeFrame;

        addListener();
        deleteListener();
        viewListener();
        closeListener();




    }

    public void deleteListener() {
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteExerciseUi deleteExerciseUi = new DeleteExerciseUi(workout, currentFrame);
                setVisible(false); // Hide the current frame
                deleteExerciseUi.setVisible(true); // Show the new frame
            }
        });
    }

    public void viewListener() {
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewExercisesUi viewExercisesUi = new ViewExercisesUi(workout, currentFrame);
                setVisible(false); // Hide the current frame
                viewExercisesUi.setVisible(true); // Show the new frame
            }
        });
    }


    public void addListener() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddExerciseUi addExerciseUi = new AddExerciseUi(workout, currentFrame);
                setVisible(false); // Hide the current frame
                addExerciseUi.setVisible(true); // Show the new frame
            }
        });
    }

    public void closeListener() {
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                homeFrame.setVisible(true);
            }
        });
    }
}
