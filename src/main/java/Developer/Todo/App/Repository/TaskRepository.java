package Developer.Todo.App.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Developer.Todo.App.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    
}
