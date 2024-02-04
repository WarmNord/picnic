package urfu.picnic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import urfu.picnic.entity.GroceryList;
import urfu.picnic.entity.Team;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Integer> {

    Optional findByTeamId(Long id);

    Team save(Team team);

    void deleteByTeamId(int id);
}
