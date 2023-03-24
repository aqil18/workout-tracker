package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiWorkoutTracker extends JFrame {
    private JPanel homePanel;
    private JButton addButton;
    private JButton viewButton;
    private JButton loadWorkoutsButton;
    private JButton saveButton;



    public GuiWorkoutTracker() {
        setContentPane(homePanel);
        setSize(500, 500);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddWorkoutUi addWorkoutFrame = new AddWorkoutUi();
                setVisible(false); // Hide the current frame
                addWorkoutFrame.setVisible(true); // Show the new frame
            }
        });

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewWorkoutsUI viewWorkoutsFrame = new ViewWorkoutsUI();
                setVisible(false); // Hide the current frame
                viewWorkoutsFrame.setVisible(true); // Show the new frame
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
        GuiWorkoutTracker guiWorkoutTracker = new GuiWorkoutTracker();
        guiWorkoutTracker.setVisible(true);
    }
}
