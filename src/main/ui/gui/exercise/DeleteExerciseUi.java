package ui.gui.exercise;

import exceptions.EmptyExerciseList;
import exceptions.EmptyWorkoutList;
import model.Exercise;
import model.Workout;
import model.WorkoutCollection;
import ui.gui.exercise.ExerciseUi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeleteExerciseUi extends JFrame {

    private JButton deleteButton;
    private JScrollPane scrollPane;
    private JPanel labelPanel;
    private JPanel viewPanel;
    private JButton closeButton;


    Workout workout;
    ExerciseUi homeFrame;

    public DeleteExerciseUi(Workout workout, ExerciseUi homeFrame) {

        this.workout = workout;
        this.homeFrame = homeFrame;



        setContentPane(viewPanel);
        setSize(500, 500);
        labelPanel.setLayout(new GridLayout(0, 1)); // Sets the layout to a vertical grid
        scrollPane.setViewportView(labelPanel); // Adds the panel as the viewport of the scroll pane

        addLabels();
        closeListener();


    }


    public void addLabels() {
        try {
            for (Exercise exercise : workout.getExercises()) {
                JLabel label = new JLabel(exercise.getExerciseName() + " Rating: " + workout.getRating());
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println(label.getText());
                        deleteButton.setText("Delete " + exercise.getExerciseName());

                        deleteListener(exercise);
                    }
                });
                label.setPreferredSize(new Dimension(100, 50)); // Sets the preferred size to 100x50 pixels
                labelPanel.add(label);


            }
            scrollPane.revalidate();
            scrollPane.repaint();


        } catch (EmptyExerciseList e) {
            //
        }
    }

    public void deleteListener(Exercise exercise) {
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                workout.deleteExercise(exercise);
                dispose();
                homeFrame.setVisible(true);

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
