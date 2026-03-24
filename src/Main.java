import Model.Priority;
import Model.Task;
import exception.TaskNotFoundException;
import repository.InMemoryTaskRepository;
import repository.TaskRepository;
import service.TaskService;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TaskRepository repo = new InMemoryTaskRepository();
        TaskService service = new TaskService(repo);


        // 2. cria tarefas
        service.createTask("Estudar Java", "Praticar interfaces e streams", Priority.HIGH);
        service.createTask("Fazer compras", "Pão, leite e café", Priority.LOW);
        service.createTask("Revisar PR", "Revisar o pull request do colega", Priority.MEDIUM);

        // 3. completa uma tarefa
        service.completeTask(1);

        // 4. lista as tarefas
        System.out.println("=== Todas as tarefas ===");
        for (Task task : repo.findAll()) {
            System.out.println(task.getId() + " | " + task.getTitle() + " | " + task.getStatus());
        }

        // 5. lista por prioridade
        System.out.println("\n=== Prioridade HIGH ===");
        List<Task> altas = service.findByPriority(Priority.HIGH);
        for (Task task : altas) {
            System.out.println(task.getTitle() + " | " + task.getStatus());
        }

        // 6. testa a exceção
        System.out.println("\n=== Testando exceção ===");
        try {
            service.completeTask(99); // id que não existe
        } catch (TaskNotFoundException e) {
            System.out.println("Erro capturado: " + e.getMessage());
        }
    }
}