package task;

import java.util.ArrayList;
import java.util.List;

public class PriorityFilterMedium implements Filterable{
    @Override
    public List<Task> filter(List<Task> taskList) {

        List<Task> tasks = new ArrayList<>();

        for (Task task : taskList) {
            if (task.priority == Priority.MEDIUM) {
                tasks.add(task);
            }
        }

        return tasks;
    }
}
