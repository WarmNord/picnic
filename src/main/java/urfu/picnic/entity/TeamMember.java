package urfu.picnic.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private int memberId;

    @Column(name = "userId", nullable = false)
    private int userId;

    @Column(name = "teamId", nullable = false)
    private int teamId;

    @Column(name = "role")
    private int role; //роль учатсника в команде переименовать таблицу на схеме

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "teamid")
    private List<Team> team = new ArrayList<>();
}
