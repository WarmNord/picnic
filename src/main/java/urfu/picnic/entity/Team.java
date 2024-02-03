package urfu.picnic.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teamId", nullable = false, unique = true)
    private int teamId;

    @Column(name = "teamName", nullable = false)
    private String teamName;

    @Column(name = "memberId", nullable = false)
    private String memberId;

    @OneToOne
    @JoinColumn(name = "memberId", referencedColumnName = "memberId")
    private TeamMember teamMember;

    @ManyToOne
    @JoinColumn(name = "teamId", referencedColumnName = "teamId")
    private Task task;
}
