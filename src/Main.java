import command.*;
import task.Task;
import user.NormalUser;
import user.SaveManager;
import user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<User> users = SaveManager.loadUsers();
        if (users == null) users = new ArrayList<>();

        for (User u : users) {
            User.userMap.put(u.getUsername(), u);
        }


        Scanner s = new Scanner(System.in);
        





        //Program start
        boolean wantToStay = true;
        while(wantToStay) {
            System.out.println("Sign Up or Sign In? (/in, /up): ");
            String command1 = s.nextLine().toLowerCase();

            if (command1.equals("/exit")) wantToStay =false;

            if (command1.equals("/up")) {
                users.add(CreateNewUser.execute(s, users));
                System.out.println("User created Successfully!");
                SaveManager.saveUsers(users);

            } else if (command1.equals("/in")) {
                System.out.println("Please enter Username");
                String inputUserName = s.nextLine();
                if (User.userMap.containsKey(inputUserName)) {
                    System.out.println("Please enter your password:");
                    String inputPassword = s.nextLine();

                    User foundUser = User.userMap.get(inputUserName);

                    if (foundUser.getPassword().equals(inputPassword)) {
                        System.out.println("✅ Logged in as: " + foundUser.getUsername());


                        while (wantToStay) {
                            System.out.println("Please type your Command: ");
                            String command2 = s.nextLine().trim().toLowerCase();

                            switch (command2) {

                                case "/show tasks":
                                    PrintAllTasks.execute(foundUser);
                                    break;
                                case "/create task":
                                    foundUser.getTaskList().add(CreateNewTask.execute(foundUser, s));
                                    break;
                                case "/delete task":
                                    DeleteTask.execute(foundUser, s);
                                    break;
                                case "/exit": wantToStay = false; break;
                                case "/set task": SetTask.execute(s, foundUser); break;
                                case "/assign task": AssignUserTask.execute(foundUser, s);

                                //case "/show users":
                            }
                        }


                    } else {
                        System.out.println("❌ Incorrect password.");
                    }
                } else {
                    System.out.println("❌ User does not exist.");
                }
            } else {
                System.out.println("Command does not exist, please try again. ");
            }
        }







        s.close();

        SaveManager.saveUsers(users);

    }
}