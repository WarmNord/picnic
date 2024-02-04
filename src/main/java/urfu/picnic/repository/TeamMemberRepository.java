package urfu.picnic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import urfu.picnic.entity.Task;
import urfu.picnic.entity.TeamMember;

import java.util.Optional;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {

    Optional findByMemberId(Long id);

    TeamMember save(TeamMember teamMember);

    void deleteByMemberId(Long id);
}
