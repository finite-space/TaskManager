package user;

import task.Task;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    String username;
    String role;
    String password;
    List<Task> taskList;
    public static Map<String, User> userMap = new HashMap<>();

    public User (String username, String password, String role, List<Task> taskList) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.taskList = taskList;
        userMap.put(username, this);
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public String getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    public void setRole(String role) {
        this.role = role;

    }

    public void addTasktoTasklist(Task task) {
        this.taskList.add(task);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
