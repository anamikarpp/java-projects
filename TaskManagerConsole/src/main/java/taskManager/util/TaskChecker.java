package taskManager.util;

import java.sql.Time;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import taskManager.dao.TaskDAO;

public class TaskChecker {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final TaskDAO taskDAO;

    public TaskChecker(TaskDAO dao) {
        this.taskDAO = dao;
    }

    public void start() {
        scheduler.scheduleAtFixedRate(() -> {

        }, 0, 1, TimeUnit.MINUTES);
    }

}
