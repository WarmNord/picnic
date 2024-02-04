package urfu.picnic.service;

import urfu.picnic.dto.TaskDto;
import urfu.picnic.entity.Task;

import java.util.List;

public interface TaskService {

    void addNewTask(TaskDto taskDto);


    List getAllTasks();

    Task getTaskById(Long taskId);

    Task createTask(Task task);

    Task updateTask(Long taskId, Task taskDetails);

    void deleteTask(Long taskId);
}
