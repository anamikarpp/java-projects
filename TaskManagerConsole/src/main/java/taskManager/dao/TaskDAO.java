package taskManager.dao;

import java.util.List;

import taskManager.model.Task;

public interface TaskDAO {

    void add(Task task);

    void deleteTask(int id);

    List<Task> getAllTasks();

    void updateTaskStatus(int id, String status);
}
