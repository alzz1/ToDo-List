package Model;

import Model.Priority;
import Model.Status;

import java.time.LocalDate;

public class Task {
    private int id;
    private String title;
    private String description;
    private Status status;
    private LocalDate createdAt;
    private Priority priority;

    public Task(int id, String title, String description, Priority priority, Status status, LocalDate createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.createdAt = createdAt;
    }

    public boolean isOverdue() {
        return this.status != Status.DONE &&
                this.createdAt.isBefore(LocalDate.now().minusDays(7));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}