package command;

import task.Task;
import user.User;

import java.util.Scanner;

public class DeleteTask {
    public static void execute(User user, Scanner scanner) {
        System.out.println("Please enter Task Name: ");
        String task = scanner.nextLine();

        boolean hasDeleted = false;

        for (Task task1 : user.getTaskList()) {
            if (task1.title.equals(task)) {
                user.getTaskList().remove(task1);
                hasDeleted = true;
                System.out.println("Task successfully deleted! ");
            }
        }

        if (!hasDeleted) System.out.println("Didn't work, try again.. ");

    }
}
