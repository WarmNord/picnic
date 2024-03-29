package urfu.picnic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import urfu.picnic.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Task findByTaskId(Long id);

    Task save(Task task);

    void deleteByTaskId(Long id);

}
