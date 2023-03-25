package ui.gui;



import model.WorkoutCollection;
import ui.GuiWorkoutTracker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeUi extends JFrame {
    private JPanel homePanel;
    private JButton addButton;
    private JButton viewButton;
    private JButton loadWorkoutsButton;
    private JButton saveButton;
    private JButton deleteButton;
    private JLabel titleLabel;

    private WorkoutCollection collection;
    private GuiWorkoutTracker gui;
    private HomeUi currentFrame;






    public HomeUi(GuiWorkoutTracker gui) {
        collection = gui.getCollection();
        this.gui = gui;
        this.currentFrame = this;


        ImageIcon icon = new ImageIcon("data/The Workout Tracker.jpg");
        titleLabel.setIcon(icon);
        titleLabel.setText("");



        setContentPane(homePanel);
        setSize(500, 500);
        setVisible(true);

        addListener();
        deleteListener();
        viewListener();
        loadListener();
        saveListener();



    }

    public void addListener() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddWorkoutUi addWorkoutFrame = new AddWorkoutUi(collection, currentFrame);
                setVisible(false); // Hide the current frame
                addWorkoutFrame.setVisible(true); // Show the new frame
            }
        });
    }

    public void deleteListener() {
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteWorkoutUi deleteWorkoutUi = new DeleteWorkoutUi(collection, currentFrame);
                setVisible(false); // Hide the current frame
                deleteWorkoutUi.setVisible(true); // Show the new frame
            }
        });
    }

    public void viewListener() {
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewWorkoutsUI viewWorkoutsFrame = new ViewWorkoutsUI(collection, currentFrame);
                setVisible(false); // Hide the current frame
                viewWorkoutsFrame.setVisible(true); // Show the new frame
            }
        });
    }

    public void loadListener() {
        loadWorkoutsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.loadWorkoutCollection();
            }
        });
    }

    public void saveListener() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.saveWorkoutCollection();
            }
        });
    }


}
