package main.java;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainController {

    @FXML
    private TextField courseNameField, taskNameField, priorityField;

    @FXML
    private DatePicker datePicker;

    @FXML
    private ListView<String> taskListView;

    @FXML
    private Button addButton, viewButton;

    private List<Task> tasks = new ArrayList<>();

    @FXML
    public void handleAddTask() {
        String courseName = courseNameField.getText();
        String taskName = taskNameField.getText();
        String priorityStr = priorityField.getText();
        String date = datePicker.getValue() != null ? datePicker.getValue().toString() : "";

        if (courseName.isEmpty() || taskName.isEmpty() || priorityStr.isEmpty() || date.isEmpty()) {
            System.out.println("Please fill all fields");
            return;
        }

        int priority;
        try {
            priority = Integer.parseInt(priorityStr);
        } catch (NumberFormatException e) {
            System.out.println("Invalid priority value. Please enter a valid integer.");
            return;
        }

        Task newTask = new Task(courseName, taskName, priority, date);

        tasks.add(newTask);

        saveTasks(tasks);

        courseNameField.clear();
        taskNameField.clear();
        priorityField.clear();
        datePicker.setValue(null);
    }

    private void saveTasks(List<Task> tasks) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("StudyPlanner/src/main/timetable.json"), tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Task> loadTasks() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Task> loadedTasks = new ArrayList<>();

        try {
            File file = new File("StudyPlanner/src/main/timetable.json");

            if (file.exists()) {
                if (file.length() == 0) {
                    System.out.println("The file is empty!");
                } else {
                    loadedTasks = objectMapper.readValue(file,
                            objectMapper.getTypeFactory().constructCollectionType(List.class, Task.class));
                }
            } else {
                System.out.println("File not found!");
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            e.printStackTrace();
        }

        return loadedTasks;
    }


    @FXML
    public void handleViewTimetable() {
        tasks = loadTasks();

        tasks.sort((task1, task2) -> Integer.compare(task1.getPriority(), task2.getPriority()));

        ObservableList<String> taskStrings = FXCollections.observableArrayList();
        for (Task task : tasks) {
            taskStrings.add(task.toString());
        }

        taskListView.setItems(taskStrings);
    }

    public static class Task {
        private String courseName;
        private String taskName;
        private int priority;
        private String date;
        public Task() {}
        public Task(String courseName, String taskName, int priority, String date) {
            this.courseName = courseName;
            this.taskName = taskName;
            this.priority = priority;
            this.date = date;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public String getTaskName() {
            return taskName;
        }

        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        @Override
        public String toString() {
            return "Course: " + courseName + ", Task: " + taskName + ", Priority: " + priority + ", Date: " + date;
        }
    }
}
