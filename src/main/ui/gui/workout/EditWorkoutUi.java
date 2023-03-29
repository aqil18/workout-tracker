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

//GUI for editing a workout.
public class EditWorkoutUi extends JFrame {

    private JButton editButton;
    private JScrollPane scrollPane;
    private JPanel labelPanel;
    private JPanel viewPanel;
    private JButton closeButton;


    WorkoutCollection collection;
    WorkoutUi homeFrame;

    //EFFECTS - Sets up the AddWorkout GUI
    public EditWorkoutUi(WorkoutCollection collection, WorkoutUi homeFrame) {
        this.collection = collection;
        this.homeFrame = homeFrame;

        setContentPane(viewPanel);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        labelPanel.setLayout(new GridLayout(0, 1));
        scrollPane.setViewportView(labelPanel);

        addLabels();
        closeListener();
    }

    //EFFECTS - Adds all workouts as JLabels onto the GUI.
    public void addLabels() {
        try {
            for (Workout workout : collection.getWorkouts()) {
                JLabel label = new JLabel(workout.getWorkoutName() + " Rating: " + workout.getRating());
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        editButton.setText("Edit " + workout.getWorkoutName());
                        editListener(workout);
                    }
                });
                label.setPreferredSize(new Dimension(100, 50));
                labelPanel.add(label);
            }
            scrollPane.revalidate();
            scrollPane.repaint();


        } catch (EmptyWorkoutList e) {
            //
        }
    }

    //EFFECTS - Creates a listener for the delete button in the GUI.
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

