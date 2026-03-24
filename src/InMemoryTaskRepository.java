import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryTaskRepository implements TaskRepository {

    private  List<Task> tasks = new ArrayList<>();

    @Override
    public void save(Task task) {
        tasks.add(task);
    }

    @Override
    public Task findById(int id) {
       return tasks.stream()
               .filter(t -> t.getId() == id)
               .findFirst()
               .orElseThrow(() -> new TaskNotFoundException("Task não encontrada: " + id));
    }

    @Override
    public List<Task> findAll() {
        return tasks;
    }

    @Override
    public void delete(int id) {
        tasks.removeIf(t -> t.getId() == id);
    }

    @Override
    public List<Task> findByStatus(Status status) {
        return tasks.stream()
                .filter(t -> t.getStatus() == status)
                .collect(Collectors.toList());
    }
}
