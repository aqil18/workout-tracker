package ui.gui;

import exceptions.EmptyWorkoutList;
import model.Workout;
import model.WorkoutCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeleteWorkoutUi extends JFrame {

    private JButton deleteButton;
    private JScrollPane scrollPane;
    private JPanel labelPanel;
    private JPanel viewPanel;


    WorkoutCollection collection;
    HomeUi homeFrame;

    public DeleteWorkoutUi(WorkoutCollection collection, HomeUi homeFrame) {

        this.collection = collection;
        this.homeFrame = homeFrame;

        deleteButton.setVisible(!deleteButton.isVisible());

        setContentPane(viewPanel);
        setSize(500, 500);
        labelPanel.setLayout(new GridLayout(0, 1)); // Sets the layout to a vertical grid
        scrollPane.setViewportView(labelPanel); // Adds the panel as the viewport of the scroll pane

        addLabels();


    }


    public void addLabels() {
        try {
            for (Workout workout : collection.getWorkouts()) {
                JLabel label = new JLabel(workout.getWorkoutName() + " Rating: " + workout.getRating());
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println(label.getText());
                        deleteButton.setText("Delete " + workout.getWorkoutName());
                        deleteButton.setVisible(!deleteButton.isVisible());
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
}

