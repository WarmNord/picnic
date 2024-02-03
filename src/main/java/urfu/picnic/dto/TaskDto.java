package urfu.picnic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    private int taskId;
    private int userId;
    private int teamId;
    private String description;
    private String status;
    private String comment;
}
