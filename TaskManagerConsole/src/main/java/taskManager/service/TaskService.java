package taskManager.service;

import java.util.List;

import taskManager.dao.TaskDAO;
import taskManager.model.Task;

public class TaskService {
    private TaskDAO taskDAO;

    public TaskService(TaskDAO dao) {
        this.taskDAO = dao;
    }

    public void addNewTask(Task task) {
        taskDAO.add(task);
        System.out.println("Task added successfully");
    }

    public void listAllTasks() {
        List<Task> tasks = taskDAO.getAllTasks();
        tasks.forEach(System.out::println);
    }

    public void markTaskCompleted(int id) {
        taskDAO.updateTaskStatus(id, "COMPLETED");
    }

    public void deleteTask(int id) {
        taskDAO.deleteTask(id);
    }
}
