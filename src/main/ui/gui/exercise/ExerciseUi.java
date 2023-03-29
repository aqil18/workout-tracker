package ui.gui.exercise;

import model.Workout;
import ui.gui.workout.WorkoutUi;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//Main GUI for exercises.
public class ExerciseUi extends JFrame {
    private JButton closeButton;
    private JButton addButton;
    private JButton deleteButton;
    private JButton viewButton;
    private JPanel homePanel;

    Workout workout;
    private ExerciseUi currentFrame;
    private WorkoutUi homeFrame;

    //EFFECTS - Sets up the main Exercise GUI
    public ExerciseUi(Workout workout, WorkoutUi homeFrame) {
        this.currentFrame = this;
        this.workout = workout;
        this.homeFrame = homeFrame;


        setContentPane(homePanel);
        setSize(900, 750);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addListener();
        deleteListener();
        viewListener();
        closeListener();
    }

    //EFFECTS - Creates a listener for the add button and creates a new AddExerciseUi upon click.
    public void addListener() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddExerciseUi addExerciseUi = new AddExerciseUi(workout, currentFrame);
                setVisible(false);
                addExerciseUi.setVisible(true);
            }
        });
    }

    //EFFECTS - Creates a listener for the delete button and creates a new DeleteExerciseUi upon click.
    public void deleteListener() {
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteExerciseUi deleteExerciseUi = new DeleteExerciseUi(workout, currentFrame);
                setVisible(false);
                deleteExerciseUi.setVisible(true);
            }
        });
    }


    //EFFECTS - Creates a listener for the view button and creates a new ViewExercisesUi upon click.
    public void viewListener() {
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewExercisesUi viewExercisesUi = new ViewExercisesUi(workout, currentFrame);
                setVisible(false);
                viewExercisesUi.setVisible(true);
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
