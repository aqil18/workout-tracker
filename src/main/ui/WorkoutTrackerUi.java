package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkoutTrackerUi extends JDialog {
    private JPanel homePanel;
    private JButton addButton;
    private JButton viewButton;
    private JButton loadWorkoutsButton;
    private JButton saveButton;



    public WorkoutTrackerUi() {
        setContentPane(homePanel);
        setSize(500, 500);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        loadWorkoutsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

    public static void main(String[] args) {
        WorkoutTrackerUi workoutTrackerUi = new WorkoutTrackerUi();
        workoutTrackerUi.setVisible(true);
    }
}
