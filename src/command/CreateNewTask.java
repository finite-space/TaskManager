package command;

import task.Priority;
import task.Task;
import user.User;

import java.time.LocalDate;
import java.util.Scanner;

public class CreateNewTask {
    public static Task execute(User user, Scanner scanner) {
        System.out.println("Please Enter Task Name: ");
        String taskName = scanner.nextLine();

        System.out.println("Please Enter Task DueDate (YYYY-MM-DD): ");
        LocalDate date;
        try {
            date = LocalDate.parse(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("❌ Not a valid date.");
            return null;
        }

        System.out.println("Please Enter Task Priority (High, Medium, Low): ");
        String inputPriority = scanner.nextLine().toUpperCase();

        Priority priority = switch (inputPriority) {
            case "HIGH" -> Priority.HIGH;
            case "MEDIUM" -> Priority.MEDIUM;
            case "LOW" -> Priority.LOW;
            default -> null;
        };

        if (priority == null) {
            System.out.println("❌ Not a valid priority.");
            return null;
        }

        System.out.println("Please Enter Task description: ");
        String description = scanner.nextLine();

        return Task.create()
                .setTitle(taskName)
                .setDescription(description)
                .setPriority(priority)
                .setDueDate(date);
    }
}
