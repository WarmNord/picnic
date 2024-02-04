package urfu.picnic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import urfu.picnic.entity.TeamMember;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {

    TeamMember findByMemberId(Long id);

    TeamMember save(TeamMember teamMember);

    void deleteByMemberId(Long id);
}
