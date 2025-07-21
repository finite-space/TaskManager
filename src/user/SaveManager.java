package user;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaveManager {

    public static void saveUsers(List<User> users) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("users.ser"))) {
            out.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<User> loadUsers() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("users.ser"))) {
            return (List<User>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>(); // Return empty if file doesn't exist
        }
    }
}
