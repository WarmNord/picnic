package urfu.picnic.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "userLists")
public class UserLists {

    @Id
    @Column(name = "userId", nullable = false)
    private int userId;

    @Column(name = "listId", nullable = false)
    private int listId;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "teamId", nullable = true)
    private Team team;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinTable(
            name = "users",
            joinColumns = {@JoinColumn(name = "userId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "userId", referencedColumnName = "id")})

    private User user;

}
