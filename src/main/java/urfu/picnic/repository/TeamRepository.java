package urfu.picnic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import urfu.picnic.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Integer> {
}
