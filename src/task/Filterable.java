package task;

import java.util.List;

public interface Filterable {

    List<Task> filter(List<Task> taskList);
}
