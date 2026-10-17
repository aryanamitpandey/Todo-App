package Developer.Todo.App.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;

import Developer.Todo.App.Service.TaskService;
import Developer.Todo.App.model.Task;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller 
//@RestController("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String getTasks(Model model){
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id ){
       taskService.deleteTask(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String toogleTask(@PathVariable Long id ){
       taskService.toggleTask(id);
        return "redirect:/";
    }

    @PostMapping
    public String createTasks(@RequestParam  String title){
         taskService.createTask(title);
                return "redirect:/";
    }
    
}
