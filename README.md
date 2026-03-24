# 📝 Task Manager — Java

Sistema de gerenciamento de tarefas desenvolvido em Java, com foco em boas práticas de orientação a objetos como interfaces, injeção de dependência e separação de responsabilidades.

---

## 🏗️ Estrutura do projeto

```
src/
├── model/
│   ├── Task.java
│   ├── Priority.java        (enum)
│   └── Status.java          (enum)
├── repository/
│   ├── TaskRepository.java  (interface)
│   └── InMemoryTaskRepository.java
├── service/
│   └── TaskService.java
├── exception/
│   └── TaskNotFoundException.java
└── Main.java
```

---

## ✨ Funcionalidades

- Criar tarefas com título, descrição e prioridade
- Alterar o status de uma tarefa (PENDING → IN_PROGRESS → DONE)
- Listar todas as tarefas
- Filtrar tarefas por prioridade ou status
- Detectar tarefas em atraso (criadas há mais de 7 dias e ainda não concluídas)
- Tratamento de erro para tarefas não encontradas

---

## 🧱 Conceitos aplicados

- **Interface** — `TaskRepository` define o contrato de acesso a dados
- **Injeção de dependência** — `TaskService` recebe o repositório pelo construtor
- **Enum** — `Priority` (LOW, MEDIUM, HIGH) e `Status` (PENDING, IN_PROGRESS, DONE)
- **Streams** — usados para filtrar e buscar tarefas
- **Exceção customizada** — `TaskNotFoundException` para ids inexistentes

---

## 🚀 Como executar

**Pré-requisitos:** Java 11+

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/task-manager-java.git
cd task-manager-java

# Compile
javac -d out src/**/*.java

# Execute
java -cp out Main
```

---

## 📖 Exemplo de uso

```java
TaskRepository repo = new InMemoryTaskRepository();
TaskService service = new TaskService(repo);

service.createTask("Estudar Java", "Praticar interfaces e streams", Priority.HIGH);
service.createTask("Fazer compras", "Pão, leite e café", Priority.LOW);

service.completeTask(1);

List<Task> altas = service.listByPriority(Priority.HIGH);
```

---

## 📚 Aprendizados

Projeto desenvolvido como exercício de nível júnior para praticar:

- Modelagem orientada a objetos em Java
- Uso de interfaces e polimorfismo
- Streams e lambdas
- Tratamento de exceções customizadas
