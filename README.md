# Personalized Study Timetable Generator

## About
The **Personalized Study Timetable Generator** is a Java-based desktop application built with JavaFX. It allows students to input their courses, tasks, deadlines, and available study time to generate an efficient, dynamic study timetable. The application is highly customizable, offering task prioritization and deadline tracking, and it provides a user-friendly interface to help students manage their study time.

---

## Features
- **Task Management**: Add tasks with course names, deadlines, and priorities.
- **Dynamic Timetable Generation**: Automatically generate a study schedule based on tasks and availability.
- **Customizable Study Time**: Input available study hours and adjust tasks based on urgency.
- **Cross-Platform**: Works on both Windows and Linux systems.

---

## Installation

### Prerequisites
1. **Java JDK 17 or higher**: Install Java JDK 17 to compile and run the project.
   - Verify installation by running:
     ```bash
     java -version
     ```

2. **JavaFX SDK**: Download and set up JavaFX SDK.

### Download JavaFX SDK
- Download the latest JavaFX SDK from [here](https://gluonhq.com/products/javafx/).
- Extract the SDK to a folder of your choice. You'll need the path to the `lib` folder for configuring the project.

---

### Setup on **Windows**

1. **Download and Install JDK**:
   - Download the latest JDK from [Oracle's official site](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html).
   - Install and configure the environment variables:
     - Add the path to the JDK bin directory to your `PATH` variable.
   
2. **Install VS Code and Java Extensions**:
   - Install [Visual Studio Code](https://code.visualstudio.com/Download).
   - Install the **Java Extension Pack** from the VS Code marketplace.

3. **Configure JavaFX in VS Code**:
   - Set the path to your JavaFX SDK in your VS Code settings.
   - Open `File > Preferences > Settings`, search for `javafx.lib.path`, and set it to the JavaFX SDK `lib` folder:
     ```json
     "javafx.lib.path": "C:/path_to_javafx/lib"
     ```

4. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/StudyPlanner.git
   cd StudyPlanner
    ```

5. **Run the Project**:
In VS Code, open the project folder, press F5 or click the Run button to start the application.

## Setup on Linux (Ubuntu)

Install JDK:
```
sudo apt update
sudo apt install openjdk-17-jdk
```
Install VS Code and Java Extensions:
Install VS Code and the Java Extension Pack from the VS Code marketplace.
Configure JavaFX in VS Code:

Download and extract the JavaFX SDK as described above.
Set the path to your JavaFX SDK in VS Code:
Open File > Preferences > Settings, search for javafx.lib.path, and set it to the path where you extracted the JavaFX SDK:"javafx.lib.path": "/path_to_javafx/lib"

Clone the Repository:
```
git clone https://github.com/your-username/StudyPlanner.git
```
cd StudyPlanner

# Run the Project:

Open the project in VS Code, and press F5 or click the Run button to start the application.

# Running the Application
Upon launching, you'll be presented with a window where you can input:

Course Name: The course you are studying.

Task Name: The task to be completed (e.g., assignment, exam preparation).

Deadline: The deadline for the task (in yyyy-MM-ddThh:mm format).

Priority: The importance of the task on a scale from 1 to 3 (1 being the highest).

After adding tasks, click Generate Timetable to create a study plan based on the available time and task deadlines

# Project Structure
```
/StudyPlanner
    /src
        /main
            /java
                MainApp.java          # Main entry point for the JavaFX application
                Task.java             # Class to model individual tasks
                Availability.java     # Class to model user study availability
                Controller.java       # Handles UI interactions
            /resources
                study_planner.fxml    # Defines the layout for the JavaFX UI
            timetable.json
```
# Contribution
Feel free to fork this repository and contribute to the project by opening pull requests. Suggestions and feature requests are also welcome!

# License
This project is licensed under the MIT License.
