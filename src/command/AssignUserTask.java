package command;

import task.Task;
import user.User;

import java.util.Scanner;

public class AssignUserTask {
    public static void execute(User currentUser,  Scanner scanner) {

        System.out.println("Which User do you want to assign your task to? ");
        String username = scanner.nextLine().toLowerCase();
        User otherUser = null;
        for (User user : User.userMap.values()) {
            if (user.getUsername().toLowerCase().equals(username)) {
                otherUser = user;
            }
        }
        if (otherUser == null) System.out.println("Couldn't find user. ");

        Task taskToSend = null;

        if (otherUser != null) {
            System.out.println("Which Task do you want to assign to him? ");
            String taskTitle = scanner.nextLine().toLowerCase();

            for (Task task : currentUser.getTaskList()) {
                if (task.title.toLowerCase().equals(taskTitle)) {
                    taskToSend = task;
                }
            }
        }

        if (taskToSend != null) {
            otherUser.addTasktoTasklist(taskToSend);
            currentUser.getTaskList().remove(taskToSend);
            System.out.println("It worked!!! ");
        }



    }
}
