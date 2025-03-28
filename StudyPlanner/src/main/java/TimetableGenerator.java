package main.java;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TimetableGenerator {
    private List<Task> tasks = new ArrayList<>();
    private final String filePath = "StudyPlanner/src/main/timetable.json";  // File to save/load tasks

    public void addTask(Task task) {
        tasks.add(task);
        saveTasksToFile();  // Save after adding a task
    }

    public List<String> getSortedTasks() {
        return tasks.stream()
                .sorted((t1, t2) -> Integer.compare(t1.getPriority(), t2.getPriority()))  // Sort by priority
                .map(Task::toString)  // Convert task objects to string representations
                .collect(Collectors.toList());  // Collect sorted tasks into a list
    }

    public void saveTasksToFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        try {
            objectMapper.writeValue(new File(filePath), tasks);  // Write tasks to JSON file
        } catch (IOException e) {
            e.printStackTrace();  // Handle exceptions during file writing
        }
    }

    public void loadTasksFromFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File(filePath);
            if (file.exists()) {
                tasks = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Task.class));
            }
        } catch (IOException e) {
            e.printStackTrace();  // Handle exceptions during file reading
        }
    }

    public TimetableGenerator() {
        loadTasksFromFile();
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
