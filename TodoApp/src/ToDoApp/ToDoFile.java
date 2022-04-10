package ToDoApp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ToDoFile {

    String path;

    public ToDoFile(String path) {
        this.path = path;
    }

    public void printHelp() {
        System.out.println("Command Line Todo application");
        System.out.println("=============================");
        System.out.println();
        System.out.println("\t -l  Lists all the tasks");
        System.out.println("\t -a  Adds a new task");
        System.out.println("\t -r  Removes an task");
        System.out.println("\t -c  Completes an task");
    }

    public void printToDoList() {
        Path filePath = Paths.get(this.path);
        try {
            List<String> fileLines = Files.readAllLines(filePath, UTF_8);
            if (fileLines.isEmpty()) {
                System.out.println("No todos for today! :)");
            } else {
                for (int i = 0; i < fileLines.size(); i++) {
                    System.out.println(i + 1 + " - " + fileLines.get(i));
                }
            }
        } catch (IOException e) {
            System.out.println("Unable to read file: ToDoList");
        }
    }

    public void addTask(String addItem) {
        Path filePath = Paths.get(this.path);
        try {
            Files.writeString(filePath, addItem + "\n", StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Unable to read file: ToDoList");
        }
    }

    public void removeTask(int index) {
        Path filePath = Paths.get(this.path);
        try {
            List<String> fileLines = Files.readAllLines(filePath, UTF_8);
            fileLines.remove(index);
            Files.write(filePath, fileLines);
        } catch (IOException e) {
            System.out.println("Unable to read file: ToDoList");
        }
    }
}








