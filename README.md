# My Personal Project

## The Workout Tracker


![The Workout Tracker Cover Photo](/data/The Workout Tracker.jpg)


### What will the application do?
*The Workout Tracker* will allow users to track the workouts they have completed and save new ones to their collection.
In the collection their able to see their most frequent workout they go on as well as the rating they give each one. 
Furthermore, if they are unsatisfied with a workout, they could edit the exercises on it or remove the workout entirely.



### Who is it for and why did I choose this as my project?
Despite being someone who enjoys working out , I had sometimes struggled to build the motivation to go to the gym. With
The Workout Tracker, it would help me see my progress in the gym and motivate me to keep working harder. Moreover, some
days I would not have the time for it and the application should help me pick out a shorter and more concise workout
for any day of the week. Therefore, The Workout Tracker is for those who need to see their potential and growth in the
gym to keep fueling them to invest in themselves. 



### User Stories
- As a user, I want to be able to create a workout and add it to a list of workouts.
- As a user, I want to be able to view a workout in the collection and see all the exercises in it.
- As a user, I want to be able to edit a workout in the collection and add or delete exercises.
- As a user, I want to be able to rate workouts in the collection.
- As a user, I want to be given the option to save all my workouts and respective exercises upon closing.
- As a user, I want to be given the option to load all my saved workouts and respective exercises upon opening.

### Instructions for Grader
- You can generate workouts and add it to the collection by clicking the add workout button and entering the details.
  and clicking the add button again.
- You can delete workouts by clicking on the delete button and selecting a workout by clicking on its label and clicking the delete button again. 
- You can locate my visual component in the home page of the Workout Tracker as a banner at the top.
- You can save the state of my application by clicking on the save workouts button in the home page.
- You can reload the state of my application by clicking on the load workouts button in the home page.
- ***Note:*** to switch between the GUI and Console UI, uncomment corresponding code in Main.java


### Phase 4: Task 2
Sample Event Log:

Mon Apr 10 02:17:16 PDT 2023
Event log cleared.

Mon Apr 10 02:17:27 PDT 2023
Added the Back workout to the collection.

Mon Apr 10 02:17:48 PDT 2023
Added the Extensions exercise to the Back workout.

Mon Apr 10 02:18:17 PDT 2023
Added the Press exercise to the Back workout.

Mon Apr 10 02:18:40 PDT 2023
Added the Pulldowns exercise to the Back workout.

Mon Apr 10 02:18:48 PDT 2023
Added the 33 exercise to the Back workout.

Mon Apr 10 02:18:52 PDT 2023
Deleted 33 exercise from the Back workout.

Mon Apr 10 02:19:01 PDT 2023
Added the Cardio workout to the collection.

Mon Apr 10 02:19:20 PDT 2023
Deleted the Cardio workout from the collection.


### Phase 4: Task 3
Looking at my UML diagram I can see that there are many areas of improvement to make it have higher cohesion and lower 
coupling.

Beginning in my model package, I identified a lot of code duplication between WorkoutCollection,
Workout and Exercise. This issue with this is if I had to change the implementation of a method I would end up having to do the same 
to duplicate methods in other classes, making the design prone to more bugs and less cohesive. One way to fix this potentially 
is by using a composite pattern and refactor to create an "Activity" interface that can be implemented by all 3 classes and make 
the WorkoutCollection the composite in this case. This would create a hierarchical structure that would only need one set of add, delete, 
view, toJson and other methods.

In my gui package, there is also an absurd amount of code duplication that stems from having multiple guis classes with same format.
All classes related to viewing, editing and deleting have the same format and very similar gui's however 5 of the same classes had to
be duplicated. To overcome this, I would look into refactoring out 1 single "ViewActivity" class that will display the corresponding button based
on use case and link it to the corresponding JFrame that it should lead to. 

### Attributions
- The UI in this application draws inspiration from how the TellerApp given to us built its UI.
- The data persistence feature is modeled based on the JsonSerialization project given to us.
- The YouTube videos I watched to learn how to use Intellij's swing UI designer:
    - [https://www.youtube.com/watch?v=-SmNpKskfJc&t=633s](https://www.youtube.com/watch?v=-SmNpKskfJc&t=633s)
    - [https://www.youtube.com/watch?v=nIQatIpL_GE&t=462s](https://www.youtube.com/watch?v=nIQatIpL_GE&t=462s) 
- The functionality for EventLog is adapted from the AlarmSystem project given to us.