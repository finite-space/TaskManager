package command;

import task.Task;
import user.NormalUser;
import user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateNewUser {

    public static NormalUser execute(Scanner scanner, List<User> users) {
        System.out.println("Please type in desired Username");
        String userName;
        userName = scanner.nextLine();
        for (User user : users) {
            if (userName.equals(user.getUsername())) {
                System.out.println("Username already exists, try again.");
                return null;

            }
        }

        System.out.println("Please type in desired Password: ");
        String password = scanner.nextLine();

        System.out.println("Please type in desired Role: ");
        String role = scanner.nextLine();

        List<Task> taskList = new ArrayList<>();

        return new NormalUser(userName, password, role, taskList);
    }
}
