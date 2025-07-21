package task;

import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Serializable {
    private static final long serialVersionUID = 1L;
    public String title;
    public String description;
    public Priority priority;
    public LocalDate dueDate;
    private boolean finished = false;

    public static Task create() {
        return new Task();
    }

    public boolean isOverdue() {
        return this.dueDate.isBefore(LocalDate.now());
    }

    public Task setDescription(String description) {
        this.description = description;
        return this;
    }

    public Task setTitle(String title) {
        this.title = title;
        return this;
    }

    public Task setPriority(Priority priority) {
        this.priority = priority;
        return this;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Task setDueDate(LocalDate dueDate) {
        if (dueDate.isBefore(LocalDate.now())) {
            System.out.println("Try again dumbass. ");
        } else {
            this.dueDate = dueDate;

        }
        return this;
    }

    public void print() {
        System.out.println("Task Name: " + title + "\nWas Finished: "+ isFinished() + "\nDue Date " + dueDate.toString() + "\nPriority " + priority.toString());
    }



}
