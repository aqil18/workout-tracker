package ui.gui.workout;



import ui.GuiWorkoutTracker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//Main GUI for workouts.
public class WorkoutUi extends JFrame {
    private JPanel homePanel;
    private JButton addButton;
    private JButton viewButton;
    private JButton loadWorkoutsButton;
    private JButton saveButton;
    private JButton deleteButton;
    private JLabel titleLabel;
    private JButton editButton;

    private GuiWorkoutTracker gui;
    private WorkoutUi currentFrame;


    //EFFECTS - Sets up the main Workout GUI
    public WorkoutUi(GuiWorkoutTracker gui) {
        this.gui = gui;
        this.currentFrame = this;


        ImageIcon icon = new ImageIcon("data/The Workout Tracker.jpg");
        titleLabel.setIcon(icon);
        titleLabel.setText("");



        setContentPane(homePanel);
        setSize(1000, 1000);
        setVisible(true);

        addListener();
        deleteListener();
        editListener();
        viewListener();
        loadListener();
        saveListener();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }

    //EFFECTS - Creates a listener for the add button and creates a new AddWorkoutUi upon click.
    public void addListener() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddWorkoutUi addWorkoutFrame = new AddWorkoutUi(gui.getCollection(), currentFrame);
                setVisible(false); // Hide the current frame
                addWorkoutFrame.setVisible(true); // Show the new frame
            }
        });
    }

    //EFFECTS - Creates a listener for the delete button and creates a new DeleteWorkoutUi upon click.
    public void deleteListener() {
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteWorkoutUi deleteWorkoutUi = new DeleteWorkoutUi(gui.getCollection(), currentFrame);
                setVisible(false); // Hide the current frame
                deleteWorkoutUi.setVisible(true); // Show the new frame
            }
        });
    }

    //EFFECTS - Creates a listener for the edit button and creates a new EditWorkoutUi upon click.
    public void editListener() {
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditWorkoutUi editWorkoutUi = new EditWorkoutUi(gui.getCollection(), currentFrame);
                setVisible(false); // Hide the current frame
                editWorkoutUi.setVisible(true); // Show the new frame
            }
        });
    }

    //EFFECTS - Creates a listener for the view button and creates a new ViewWorkoutsUi upon click.
    public void viewListener() {
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewWorkoutsUI viewWorkoutsFrame = new ViewWorkoutsUI(gui.getCollection(), currentFrame);
                setVisible(false); // Hide the current frame
                viewWorkoutsFrame.setVisible(true); // Show the new frame
            }
        });
    }

    //EFFECTS - Creates a listener for the view button and loads saved workouts upon click.
    public void loadListener() {
        loadWorkoutsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.loadWorkoutCollection();
            }
        });
    }

    //EFFECTS - Creates a listener for the view button and saves workouts upon click.
    public void saveListener() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.saveWorkoutCollection();
            }
        });
    }


}
