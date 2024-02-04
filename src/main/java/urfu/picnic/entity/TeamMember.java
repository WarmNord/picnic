package urfu.picnic.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teamMembers")
public class TeamMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberId", nullable = false, unique = true)
    private Long memberId;

    @Column(name = "userId", nullable = false)
    private Long userId;

    @Column(name = "teamId", nullable = false)
    private Long teamId;

    @Column(name = "role")
    private Long role; //роль учатсника в команде переименовать таблицу на схеме

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "teamid")
    private List<Team> team = new ArrayList<>();
}
