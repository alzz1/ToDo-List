import java.util.List;

public interface TaskRepository {
    void save(Task task);
    Task findById (int id);
    List<Task> findAll();
    void delete (int id);
    List<Task> findByStatus(Status status);
}
