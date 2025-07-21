package command;

import task.Task;
import user.User;

public class PrintAllTasks{

    public static void execute(User user) {
        for (Task task : user.getTaskList()) {
            task.print();
        }
    }
}
