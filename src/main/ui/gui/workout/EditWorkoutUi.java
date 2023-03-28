package ui.gui.workout;

import exceptions.EmptyWorkoutList;
import model.Workout;
import model.WorkoutCollection;
import ui.gui.exercise.ExerciseUi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditWorkoutUi extends JFrame {

    private JButton editButton;
    private JScrollPane scrollPane;
    private JPanel labelPanel;
    private JPanel viewPanel;
    private JButton closeButton;


    WorkoutCollection collection;
    WorkoutUi homeFrame;

    public EditWorkoutUi(WorkoutCollection collection, WorkoutUi homeFrame) {

        this.collection = collection;
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
            for (Workout workout : collection.getWorkouts()) {
                JLabel label = new JLabel(workout.getWorkoutName() + " Rating: " + workout.getRating());
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println(label.getText());
                        editButton.setText("Edit " + workout.getWorkoutName());

                        editListener(workout);
                    }
                });
                label.setPreferredSize(new Dimension(100, 50)); // Sets the preferred size to 100x50 pixels
                labelPanel.add(label);


            }
            scrollPane.revalidate();
            scrollPane.repaint();


        } catch (EmptyWorkoutList e) {
            //
        }
    }

    public void editListener(Workout workout) {
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExerciseUi exerciseUi = new ExerciseUi(workout, homeFrame);
                dispose();
                exerciseUi.setVisible(true);

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

