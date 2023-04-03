package ui.gui.workout;



import model.Event;
import model.EventLog;
import ui.GuiWorkoutTracker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


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

        EventLog.getInstance().clear();

        ImageIcon icon = new ImageIcon("data/The Workout Tracker.jpg");
        titleLabel.setIcon(icon);
        titleLabel.setText("");

        setContentPane(homePanel);
        setSize(900, 750);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addListener();
        deleteListener();
        editListener();
        viewListener();
        loadListener();
        saveListener();
        frameListener();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    //EFFECTS - Creates a listener for the add button and creates a new AddWorkoutUi upon click.
    public void addListener() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddWorkoutUi addWorkoutFrame = new AddWorkoutUi(gui.getCollection(), currentFrame);
                setVisible(false);
                addWorkoutFrame.setVisible(true);
            }
        });
    }

    //EFFECTS - Creates a listener for the delete button and creates a new DeleteWorkoutUi upon click.
    public void deleteListener() {
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteWorkoutUi deleteWorkoutUi = new DeleteWorkoutUi(gui.getCollection(), currentFrame);
                setVisible(false);
                deleteWorkoutUi.setVisible(true);
            }
        });
    }

    //EFFECTS - Creates a listener for the edit button and creates a new EditWorkoutUi upon click.
    public void editListener() {
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditWorkoutUi editWorkoutUi = new EditWorkoutUi(gui.getCollection(), currentFrame);
                setVisible(false);
                editWorkoutUi.setVisible(true);
            }
        });
    }

    //EFFECTS - Creates a listener for the view button and creates a new ViewWorkoutsUi upon click.
    public void viewListener() {
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewWorkoutsUI viewWorkoutsFrame = new ViewWorkoutsUI(gui.getCollection(), currentFrame);
                setVisible(false);
                viewWorkoutsFrame.setVisible(true);
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


    public void frameListener() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                EventLog el = EventLog.getInstance();
                for (Event next : el) {
                    System.out.println(next.toString() + "\n");
                }
            }
        });
    }


}
