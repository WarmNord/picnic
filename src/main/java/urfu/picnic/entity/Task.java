package urfu.picnic.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "taskId", nullable = false, unique = true)
    private Long taskId;

    @Column(name = "userId", nullable = false)
    private Long userId;

    @Column(name = "teamId", nullable = false)
    private Long teamId;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

}
