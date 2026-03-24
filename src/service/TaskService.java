package service;

import Model.Priority;
import Model.Status;
import Model.Task;
import repository.TaskRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class TaskService {
    private TaskRepository repo;
    private int nextId = 1;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }
    public Task createTask(String title, String description, Priority priority){
        Task task = new Task(nextId++, title, description, priority, Status.PENDING, LocalDate.now());
        repo.save(task);
        return task;
    }

    public void completeTask(int id){
        Task task = repo.findById(id);
        task.setStatus(Status.DONE);
    }
    public List<Task> findByPriority(Priority priority){
        return repo.findAll()
                .stream()
                .filter(t -> t.getPriority() == priority)
                .collect(Collectors.toList());
    }
}
