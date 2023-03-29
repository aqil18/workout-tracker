package ui.gui.workout;

import exceptions.EmptyWorkoutList;
import model.Workout;
import model.WorkoutCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//GUI for deleting a workout.
public class DeleteWorkoutUi extends JFrame {

    private JButton deleteButton;
    private JScrollPane scrollPane;
    private JPanel labelPanel;
    private JPanel viewPanel;
    private JButton closeButton;


    WorkoutCollection collection;
    WorkoutUi homeFrame;

    //EFFECTS - Sets up the DeleteWorkout GUI.
    public DeleteWorkoutUi(WorkoutCollection collection, WorkoutUi homeFrame) {

        this.collection = collection;
        this.homeFrame = homeFrame;



        setContentPane(viewPanel);
        setSize(500, 500);
        labelPanel.setLayout(new GridLayout(0, 1)); // Sets the layout to a vertical grid
        scrollPane.setViewportView(labelPanel); // Adds the panel as the viewport of the scroll pane

        addLabels();
        closeListener();


    }

    //EFFECTS - Adds all workouts as JLabels onto the GUI
    public void addLabels() {
        try {
            for (Workout workout : collection.getWorkouts()) {
                JLabel label = new JLabel(workout.getWorkoutName() + " Rating: " + workout.getRating());
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        deleteButton.setText("Delete " + workout.getWorkoutName());
                        deleteListener(workout);
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

    //EFFECTS - Creates a listener for the delete button in the GUI.
    public void deleteListener(Workout workout) {
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collection.deleteWorkout(workout);
                dispose();
                homeFrame.setVisible(true);

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

