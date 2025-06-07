package taskManager;

import java.time.LocalDateTime;
import java.util.Scanner;

import taskManager.dao.TaskDAOImpl;
import taskManager.model.Task;
import taskManager.service.TaskService;
import taskManager.util.TaskChecker;

public class Main {
    public static void main(String[] args) {

        TaskService service = new TaskService(new TaskDAOImpl());
        TaskChecker checker = new TaskChecker(new TaskDAOImpl());
        checker.start();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(
                    "1. Add Task\n 2. View All Tasks\n 3.Mark Task with ID as completed.\n 4.Delet task with an ID\n 5.Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Title: ");
                    String title = scanner.nextLine();

                    System.out.println("Description: ");
                    String desc = scanner.nextLine();

                    System.out.println("Due date (yyyy-MM-dd): ");
                    String datePart = scanner.nextLine();

                    System.out.print("Enter due time (HH:mm): ");
                    String timePart = scanner.nextLine();

                    LocalDateTime dueDate = LocalDateTime.parse(datePart + "T" + timePart);

                    service.addNewTask(new Task(title, desc, dueDate, "PENDING"));
                    break;
                case 2:
                    service.listAllTasks();
                    break;
                case 3:
                    System.out.println("Enter task ID to mark as completed:");
                    int taskId = scanner.nextInt();
                    service.markTaskCompleted(taskId);
                    break;
                case 4:
                    System.out.println("Enter task ID to delete:");
                    int deleteId = scanner.nextInt();
                    service.deleteTask(deleteId);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    System.exit(0);
            }
        }

    }
}