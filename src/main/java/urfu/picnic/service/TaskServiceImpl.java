package urfu.picnic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urfu.picnic.dto.TaskDto;
import urfu.picnic.entity.Task;
import urfu.picnic.repository.TaskRepository;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public Task getTask(Long id) throws Throwable {
        return taskRepository.findByTaskId(id);
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

    @Override
    public List getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));

    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long taskId, Task taskDetails) {
        Task existingTask = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        existingTask.setUserId(taskDetails.getUserId());
        existingTask.setTeamId(taskDetails.getTeamId());
        existingTask.setDescription(taskDetails.getDescription());
        existingTask.setStatus(taskDetails.getStatus());
        existingTask.setComment(taskDetails.getComment());

        Task updatedTask = taskRepository.save(existingTask);

        return updatedTask;
    }
}
