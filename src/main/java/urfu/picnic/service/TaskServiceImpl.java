package urfu.picnic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urfu.picnic.dto.TaskDto;
import urfu.picnic.entity.GroceryList;
import urfu.picnic.entity.Task;
import urfu.picnic.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{

    private TaskRepository taskRepository;
    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public Task getTask(Long id) throws Throwable {
        return (Task) taskRepository.findByTaskId(id)
                .orElseThrow(() -> new RuntimeException("Task Not Found"));
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteByTaskId(id);
    }
    @Override
    public void addNewTask(TaskDto taskDto) {

    }
}
