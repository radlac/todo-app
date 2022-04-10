package ToDoApp;

public class Main {
    public static void main(String[] args) {

        ToDoFile toDoFile = new ToDoFile("src/ToDoApp/ToDoList");


        if (args.length == 0) {
            toDoFile.printHelp();
        } else if (args[0].equals("-a")) {
            try {
                String item = args[1];
                toDoFile.addTask(item);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Unable to add: no task provided");
            }
        } else if (args[0].equals("-l")) {
            toDoFile.printToDoList();
        } else if (args[0].equals("-r")) {
            try {
                int index = Integer.parseInt(args[1]) - 1;
                toDoFile.removeTask(index);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Unable to remove: no index provided");
            }
        } else if (args[0] != "-l")
            if (args[0] != "-a")
                if (args[0] != "-r")
                    if (args[0] != "-c") {
                        System.out.println("Unsupported argument");
                        System.out.println();
                        toDoFile.printHelp();
                    }
    }
}

