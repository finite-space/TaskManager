package user;

import task.Task;

import java.util.List;

public class NormalUser extends User{



    public NormalUser(String name, String password, String role, List<Task> taskList) {
        super(name, password, role, taskList);

    }



}
