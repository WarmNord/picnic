package urfu.picnic.service;

import urfu.picnic.entity.Task;

import java.util.List;

public interface TaskService {

    List getAllTasks();

    Task getTaskById(Long taskId);

    Task createTask(Task task);

    Task updateTask(Long taskId, Task taskDetails);

    void deleteTask(Long taskId);
}
