package ui.gui.workout;

import exceptions.EmptyWorkoutList;
import model.Workout;
import model.WorkoutCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//GUI for viewing workouts.
public class ViewWorkoutsUI extends JFrame {
    private JPanel viewPanel;
    private JButton closeButton;
    private JScrollPane scrollPane;
    private JPanel labelPanel;

    WorkoutCollection collection;
    WorkoutUi homeFrame;

    //EFFECTS - Sets up the ViewWorkouts GUI
    public ViewWorkoutsUI(WorkoutCollection collection, WorkoutUi homeFrame) {
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
                label.setPreferredSize(new Dimension(100, 50));
                labelPanel.add(label);
            }
            scrollPane.revalidate();
            scrollPane.repaint();
        } catch (EmptyWorkoutList e) {
            //
        }
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
