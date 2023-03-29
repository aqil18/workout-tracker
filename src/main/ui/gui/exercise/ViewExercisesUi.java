package ui.gui.exercise;

import exceptions.EmptyExerciseList;
import model.Exercise;
import model.TimedExercise;
import model.WeightedExercise;
import model.Workout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//GUI for viewing all exercises in a workout.
public class ViewExercisesUi extends JFrame {
    private JPanel viewPanel;
    private JButton closeButton;
    private JScrollPane scrollPane;
    private JPanel labelPanel;

    Workout workout;
    ExerciseUi homeFrame;

    //EFFECTS - Sets up the ViewExercises GUI.
    public ViewExercisesUi(Workout workout, ExerciseUi homeFrame) {
        this.workout = workout;
        this.homeFrame = homeFrame;
        setContentPane(viewPanel);
        setSize(500, 500);
        labelPanel.setLayout(new GridLayout(0, 1)); // Sets the layout to a vertical grid
        scrollPane.setViewportView(labelPanel); // Adds the panel as the viewport of the scroll pane

        addLabels();
        closeListener();

    }

    //EFFECTS - Adds all exercises as JLabels onto the GUI
    public void addLabels() {
        try {
            for (Exercise exercise : workout.getExercises()) {
                JLabel label = getLabel(exercise);
                label.setPreferredSize(new Dimension(100, 50)); // Sets the preferred size to 100x50 pixels
                labelPanel.add(label);
            }
            scrollPane.revalidate();
            scrollPane.repaint();
        } catch (EmptyExerciseList e) {
            //
        }
    }

    //EFFECTS - Creates a JLabel for a given exercise.\
    public JLabel getLabel(Exercise exercise) {
        JLabel label;
        if (exercise instanceof WeightedExercise) {
            int reps = ((WeightedExercise) exercise).getReps();
            int weight = ((WeightedExercise) exercise).getWeight();
            label = new JLabel(exercise.getExerciseName() + "     Reps: " + reps + "   Weight: " + weight);
        } else {
            int time = ((TimedExercise) exercise).getTime();
            label = new JLabel(exercise.getExerciseName() + "     Time: " + time);
        }
        return label;
    }

    //EFFECTS - Creates a listener for the close button in the GUI.
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
