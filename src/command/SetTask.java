package command;

import task.Task;
import user.User;

import java.util.Scanner;

public class SetTask {
    public static void execute(Scanner scanner, User user) {
        System.out.println("Type in the Task you want to change");
        String taskName = scanner.nextLine().toLowerCase();

        System.out.println("Set to completed or uncompleted? (false, true): ");
        String b = scanner.nextLine().toLowerCase();
        boolean b1 = false;

        try {
            b1 = switch (b) {
                case "false" -> false;
                case "true" -> true;
                default -> b1;
            };
        } catch (Exception e) {
            System.out.println("You stupid bro? ");
        }

        System.out.println();
        boolean wasFinished = false;
        for (Task task : user.getTaskList()) {
            if (task.title.toLowerCase().equals(taskName)) {
                task.setFinished(b1);
                System.out.println("Task " + taskName + " was marked as finished successfully! ");
                wasFinished = true;
                break;
            }
        }

        if (!wasFinished) System.out.println("Something went wrong, please try again. ");

    }
}
